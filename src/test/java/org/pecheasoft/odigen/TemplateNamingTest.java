package org.pecheasoft.odigen;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.pecheasoft.odigen.metadata.MetadataManager;
import org.pecheasoft.odigen.project.Project;
import org.pecheasoft.odigen.render.*;
import org.pecheasoft.odigen.sql.api.ast.impl.DatastoreReferenceNode;
import org.pecheasoft.odigen.template.*;
import static org.junit.Assert.*;

public class TemplateNamingTest {
    private CodeGeneratorService generator() {
        var project = new Project(Path.of("examples/airflow-bigquery-draft"));
        return new CodeGeneratorService(project, new MetadataManager(project));
    }

    @Test public void projectTemplateConfiguresNamingWithoutPhysicalMetadata() {
        var generator = generator();
        var defaults = new TransformationContext();
        generator.withContext(defaults);
        String output = generator.transform("employees_to_prep").using("airflow_bigquery/render_business.vtl").render();
        assertEquals("SELECT E.EMPLOYEE_ID AS EMPLOYEE_ID , E.DEPARTMENT_ID AS DEPARTMENT_ID , E.SALARY AS SALARY FROM `example-project.stage.employees` E",
                output.replaceAll("\\s+", " ").trim());
        // Template configuration must not leak into later renders.
        assertEquals("PREP.EMPLOYEES", defaults.targetName(new DatastoreReferenceNode("PREP.EMPLOYEES")));
        var model = (org.pecheasoft.odigen.sql.api.ast.impl.InsertNode) generator.parse(
                "INSERT INTO prep.employees (EMPLOYEE_ID) SELECT e.EMPLOYEE_ID AS EMPLOYEE_ID FROM stage.employees e");
        assertEquals("prep.employees", model.getTarget().getDatastore().getName().toLowerCase());
    }

    @Test public void templateCallbackReachesTargetsAndCorrelatedExpressionTables() {
        var model = generator().parse("INSERT INTO prep.employees (EMPLOYEE_ID) SELECT "
                + "(SELECT x.EMPLOYEE_ID FROM stage.employees x WHERE x.EMPLOYEE_ID=e.EMPLOYEE_ID) AS EMPLOYEE_ID FROM stage.employees e");
        var project = new Project(Path.of("examples/airflow-bigquery-draft"));
        var engine = TemplateEngineFacadeFactory.createPackage(new TemplatePackage(
                new MetadataManager(project).findTemplate("airflow_bigquery").orElseThrow()));
        var context = new TransformationContext();
        String output = engine.resolve(TemplateIntegrationTest.template("check", "#parse('library.Query')#parse('airflow_bigquery/naming.vtl')#Render($mapping $ctx)"),
                List.of(TemplateParameter.of("mapping", model), TemplateParameter.of("ctx", context)));
        assertTrue(output, output.contains("INSERT INTO `example-project.prep.employees`"));
        assertTrue(output, output.contains("FROM `example-project.stage.employees` x"));
        assertTrue(output, output.contains("FROM") && output.contains("`example-project.stage.employees` E"));
    }

    @Test public void rulesAreCaseInsensitiveSnapshotAndRejectUnknownQualifiers() {
        var ctx = new TransformationContext();
        var namespaces = new HashMap<>(Map.of("stage", "project.dataset"));
        var names = ctx.tableNames("`{namespace}.{basename}`", namespaces, true);
        namespaces.put("stage", "changed");
        assertEquals("`project.dataset.employees`", names.apply(new DatastoreReferenceNode("STAGE.EMPLOYEES")));
        assertThrows(IllegalArgumentException.class, () -> names.apply(new DatastoreReferenceNode("unknown.employees")));
        assertThrows(IllegalArgumentException.class, () -> ctx.tableNames("{unknown}", namespaces, true));
        assertThrows(IllegalArgumentException.class, () -> ctx.tableNames("{namespace}.{basename}", Map.of("stage", "a", "STAGE", "b"), false));
        assertEquals("project.dataset.EMPLOYEES", ctx.tableNames("{namespace}.{basename}", Map.of("stage", "project.dataset"), false)
                .apply(new DatastoreReferenceNode("STAGE.EMPLOYEES")));
    }
}

