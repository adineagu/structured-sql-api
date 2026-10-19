package org.pecheasoft.odigen;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.pecheasoft.odigen.metadata.MetadataManager;
import org.pecheasoft.odigen.project.Project;
import org.pecheasoft.odigen.render.CodeGeneratorService;
import org.pecheasoft.odigen.sql.api.ast.impl.Datastore;
import org.pecheasoft.odigen.sql.api.ast.impl.DatastoreCondition;
import org.pecheasoft.odigen.sql.api.ast.impl.InsertNode;
import org.pecheasoft.odigen.sql.parse.algebra.ITableConstraint;
import org.pecheasoft.odigen.sql.parse.algebra.TableCheckConstraint;
import org.pecheasoft.odigen.sql.parse.algebra.TableConstraint;

import static org.junit.Assert.*;

public class CheckConstraintTest {
    @Rule public TemporaryFolder temporary = new TemporaryFolder();

    private CodeGeneratorService generator(Path root) throws Exception {
        for (String folder : List.of("datastores", "mappings", "templates")) {
            Files.createDirectories(root.resolve(folder));
        }
        var project = new Project(root);
        return new CodeGeneratorService(project, new MetadataManager(project));
    }

    @Test public void parsesUnannotatedCheckThroughPublicApi() throws Exception {
        var datastore = (Datastore) generator(temporary.newFolder().toPath()).parse(
                "CREATE TABLE employees (salary DECIMAL(12,2), CONSTRAINT emp_salary_min CHECK (salary > 0))");
        assertEquals(1, datastore.getConditions().size());
        var condition = datastore.getConditions().get(0);
        assertEquals("EMP_SALARY_MIN", condition.getName());
        assertEquals("salary>0", condition.getCondition().replaceAll("\\s+", ""));
        assertNotNull(condition.annotations());
        assertTrue(condition.annotations().isEmpty());
    }

    @Test public void preservesCheckPolicyAndSqlPropertiesThroughRenderingAndResolution() throws Exception {
        Path root = temporary.newFolder().toPath();
        generator(root); // create required application directories before writing fixtures
        Files.writeString(root.resolve("datastores/employees.sql"), """
                CREATE TABLE employees (
                    salary DECIMAL(12,2),
                    @VALIDATION(SEVERITY="WARN") @ROUTING(QUEUE="salary_errors")
                    CONSTRAINT emp_salary_min CHECK (salary > 0)
                    DEFINED IN DATABASE ACTIVE CONTROL STATIC MESSAGE 'Salary must be positive',
                    CONSTRAINT emp_salary_max CHECK (salary < 1000000)
                )
                """);
        Files.writeString(root.resolve("mappings/load.sql"),
                "INSERT INTO employees (salary) SELECT 100 AS salary");
        Files.writeString(root.resolve("templates/report.vtl"), """
                #foreach($rule in $datastore.conditions)
                $rule.name|$rule.condition|$rule.annotations().isEmpty()
                #if($rule.annotations().has("VALIDATION"))
                $rule.annotations().get("VALIDATION").attribute("SEVERITY")
                #end
                #end
                """);
        Files.writeString(root.resolve("config.yml"), "templateEngine: velocity");
        var codegen = generator(root);
        var datastore = (Datastore) codegen.parse(Files.readString(root.resolve("datastores/employees.sql")));
        var condition = datastore.getConditions().get(0);
        assertEquals("WARN", condition.annotations().get("VALIDATION").attribute("SEVERITY"));
        assertEquals("salary_errors", condition.annotations().get("ROUTING").attribute("QUEUE"));
        assertTrue(condition.isDefinedInDatabase());
        assertTrue(condition.isActive());
        assertTrue(condition.isStaticControlEnabled());
        assertFalse(condition.isFlowControlEnabled());
        assertEquals("Salary must be positive", condition.getMessage());
        assertTrue(datastore.getConditions().get(1).annotations().isEmpty());
        assertFalse(datastore.annotations().has("VALIDATION"));

        String report = codegen.transform("employees").using("report").render();
        assertTrue(report, report.contains("EMP_SALARY_MIN|"));
        assertTrue(report, report.contains("WARN"));
        assertTrue(report, report.contains("EMP_SALARY_MAX|"));
        var insert = (InsertNode) codegen.parse("INSERT INTO employees (salary) SELECT 100 AS salary");
        assertEquals("WARN", insert.getTarget().getDatastore().getConditions().get(0)
                .annotations().get("VALIDATION").attribute("SEVERITY"));
    }

    @Test public void semanticConditionAcceptsAbsentAnnotationsFromCallerPreparedAlgebra() {
        var constraint = new TableConstraint("salary_min", ITableConstraint.ConstraintScope.DATABASE,
                true, true, false, false, null);
        var check = new TableCheckConstraint(constraint, null);
        check.setQualText("salary > 0");
        assertNull(check.getAnnotations());
        var condition = new DatastoreCondition(check);
        assertEquals("salary > 0", condition.getCondition());
        assertTrue(condition.annotations().isEmpty());
    }
}
