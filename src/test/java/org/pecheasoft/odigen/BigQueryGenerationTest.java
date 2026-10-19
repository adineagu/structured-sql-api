package org.pecheasoft.odigen;

import java.nio.file.*;
import java.util.*;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import org.pecheasoft.odigen.metadata.MetadataManager;
import org.pecheasoft.odigen.project.Project;
import org.pecheasoft.odigen.render.CodeGeneratorService;
import static org.junit.Assert.*;

public class BigQueryGenerationTest {
    @Rule public TemporaryFolder temporary = new TemporaryFolder();
    private final Path root = Path.of("examples/airflow-bigquery-draft");
    private CodeGeneratorService generator() {
        var project = new Project(root);
        return new CodeGeneratorService(project, new MetadataManager(project));
    }
    private String sql(String value) {
        return value.replaceAll("(?m)^--.*$", "").replaceAll("\\s+", "").toUpperCase(Locale.ROOT);
    }
    private String python(String value) {
        return value.replaceAll("(?m)^\\s*\"\"\".*\"\"\"\\s*$", "")
                .replace("merge_employees =", "task =").replaceAll("(?m)^\\s*$\\R", "").strip();
    }
    @Test public void generatesSqlAndDagTogether() throws Exception {
        Path output = temporary.newFolder().toPath();
        generator().generatePackage("employees_to_prep", "airflow_bigquery", output);
        assertEquals(sql(Files.readString(root.resolve("expected/sql/employees_to_prep.sql"))), sql(Files.readString(output.resolve("sql/employees_to_prep.sql"))));
        assertEquals(python(Files.readString(root.resolve("expected/employees_to_prep.py"))), python(Files.readString(output.resolve("employees_to_prep.py"))));
    }
    @Test public void changedAnnotationsDriveOutput() throws Exception {
        var generator = generator();
        String input = Files.readString(root.resolve("mappings/employees_to_prep.sql"));
        var model = generator.parse(input.replace("DAG_ID=\"employees_to_prep\"", "DAG_ID=\"other_load\""));
        String dag = generator.transform("employees_to_prep").using("airflow_bigquery/dag.vtl").withModel(model).render();
        assertTrue(dag, dag.contains("dag_id=\"other_load\""));
        assertTrue(dag, dag.contains("include 'other_load.sql'"));
    }

    private String renderWithDefinition(String definition) throws Exception {
        var generator = generator();
        var model = (org.pecheasoft.odigen.sql.api.ast.impl.InsertNode) generator.parse(
                Files.readString(root.resolve("mappings/employees_to_prep.sql")));
        model.getTarget().setMetadata((org.pecheasoft.odigen.sql.api.ast.impl.Datastore) generator.parse(definition));
        var project = new Project(root);
        return org.pecheasoft.odigen.template.TemplateEngineFacadeFactory.create(project).resolve(
                new MetadataManager(project).findTemplateResource("airflow_bigquery/merge.vtl").orElseThrow(), List.of(
                        org.pecheasoft.odigen.template.TemplateParameter.of("mapping", model),
                        org.pecheasoft.odigen.template.TemplateParameter.of("ctx", new org.pecheasoft.odigen.render.TransformationContext())));
    }

    @Test public void targetPrimaryKeyDrivesCompositeMatchRegardlessOfConstraintName() throws Exception {
        String definition = Files.readString(root.resolve("datastores/prep/employees.sql"))
                .replace("PR_EMPLOYEES_PK", "ARBITRARY_PK_NAME")
                .replace("DEPARTMENT_ID BIGINT", "DEPARTMENT_ID BIGINT NOT NULL")
                .replace("PRIMARY KEY (EMPLOYEE_ID)", "PRIMARY KEY (EMPLOYEE_ID, DEPARTMENT_ID)");
        String output = sql(renderWithDefinition(definition));
        assertTrue(output, output.contains("ONT.EMPLOYEE_ID=S.EMPLOYEE_IDANDT.DEPARTMENT_ID=S.DEPARTMENT_ID"));
        String updates = output.substring(output.indexOf("UPDATESET"), output.indexOf("WHENNOTMATCHED"));
        assertFalse(updates, updates.contains("DEPARTMENT_ID="));
        assertFalse(updates, updates.contains("EMPLOYEE_ID="));
    }

    @Test public void uniqueKeyIsNotUsedAsFallbackForMissingPrimaryKey() throws Exception {
        String definition = Files.readString(root.resolve("datastores/prep/employees.sql"));
        var error = assertThrows(RuntimeException.class, () -> renderWithDefinition(definition.replace("PRIMARY KEY", "UNIQUE KEY")));
        assertTrue(error.toString(), error.toString().contains("primary key in the target datastore"));
        assertThrows(RuntimeException.class, () -> renderWithDefinition(definition.replace(
                "CONSTRAINT PR_EMPLOYEES_PK PRIMARY KEY (EMPLOYEE_ID)",
                "CONSTRAINT PK1 PRIMARY KEY (EMPLOYEE_ID), CONSTRAINT PK2 PRIMARY KEY (EMPLOYEE_ID)")));
    }
    @Test public void batchRendersBeforeWritingAndRejectsEscapingPaths() throws Exception {
        Path output = temporary.newFolder().toPath();
        var artifacts = new LinkedHashMap<String, String>();
        artifacts.put("valid.sql", "airflow_bigquery/merge.vtl");
        artifacts.put("invalid.py", "missing_template");
        assertThrows(IllegalArgumentException.class, () -> generator().generate("employees_to_prep", artifacts, output));
        assertFalse(Files.exists(output.resolve("valid.sql")));
        assertThrows(IllegalArgumentException.class, () -> generator().generate("employees_to_prep", Map.of("../escape.sql", "airflow_bigquery/merge.vtl"), output));
    }

    @Test public void layerPolicyDrivesBothTemplatesWithoutMutatingBusinessAst() throws Exception {
        Path projectRoot = temporary.newFolder().toPath();
        try (var paths = Files.walk(root)) {
            for (Path path : paths.toList()) {
                Path destination = projectRoot.resolve(root.relativize(path));
                if (Files.isDirectory(path)) Files.createDirectories(destination);
                else Files.copy(path, destination);
            }
        }
        Path policy = projectRoot.resolve("templates/airflow_bigquery/prep_policy.vtl");
        Files.writeString(policy, Files.readString(policy).replace("effective_date", "business_date"));
        var project = new Project(projectRoot);
        var generator = new CodeGeneratorService(project, new MetadataManager(project));
        var model = (org.pecheasoft.odigen.sql.api.ast.impl.InsertNode) generator.parse(
                Files.readString(projectRoot.resolve("mappings/employees_to_prep.sql")));
        for (String template : List.of("merge", "dag")) {
            String output = generator.transform("employees_to_prep").using("airflow_bigquery/" + template + ".vtl").withModel(model).render();
            assertTrue(output, output.contains("business_date"));
            assertFalse(output, output.contains("effective_date"));
            assertEquals(output, generator.transform("employees_to_prep").using("airflow_bigquery/" + template + ".vtl").withModel(model).render());
        }
        assertEquals(3, model.getColumns().size());
        assertTrue(model.annotations().has("AIRFLOW"));
    }

    @Test public void prepPolicyRequiresCompatibleDeclaredColumns() throws Exception {
        String definition = Files.readString(root.resolve("datastores/prep/employees.sql"));
        assertFalse(definition.contains("@TECHNICAL"));
        var missing = assertThrows(RuntimeException.class, () -> renderWithDefinition(
                definition.replace("LOAD_DATE TIMESTAMP,", "")));
        assertTrue(missing.toString(), missing.toString().contains("missing prep technical column: LOAD_DATE"));
        var type = assertThrows(RuntimeException.class, () -> renderWithDefinition(
                definition.replace("LOAD_DATE TIMESTAMP", "LOAD_DATE DATE")));
        assertTrue(type.toString(), type.toString().contains("Unexpected datatype for prep technical column: LOAD_DATE"));
    }
}

