package org.pecheasoft.odigen;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.pecheasoft.odigen.metadata.MetadataManager;
import org.pecheasoft.odigen.project.Project;
import org.pecheasoft.odigen.render.CodeGeneratorService;
import org.pecheasoft.odigen.sql.api.ast.SemanticExpression;
import org.pecheasoft.odigen.sql.api.ast.SemanticSimpleQueryBlock;
import org.pecheasoft.odigen.sql.api.ast.impl.DatastoreReferenceNode;
import org.pecheasoft.odigen.sql.api.ast.impl.Expression;
import org.pecheasoft.odigen.template.TemplateParameter;
import org.pecheasoft.odigen.template.TemplateEngineFacadeFactory;
import org.pecheasoft.odigen.template.TemplateEngineType;
import static org.junit.Assert.*;

public class EmbeddedExpressionTest {
    @Rule public TemporaryFolder temporary = new TemporaryFolder();
    private final Function<DatastoreReferenceNode, String> physicalName = r -> r.getDatastore().getName();

    private CodeGeneratorService generator() throws Exception {
        Path root = temporary.newFolder().toPath();
        Files.createDirectories(root.resolve("datastores/base"));
        Files.createDirectories(root.resolve("mappings"));
        Files.createDirectories(root.resolve("templates"));
        Files.writeString(root.resolve("datastores/base/employees.sql"),
                "CREATE TABLE hr.employees (employee_id NUMBER, name VARCHAR2(30))");
        Files.writeString(root.resolve("datastores/base/departments.sql"),
                "CREATE TABLE hr.departments (manager_id NUMBER)");
        Project project = new Project(root);
        return new CodeGeneratorService(project, new MetadataManager(project));
    }

    @Test public void scalarSubqueryGetsMetadataAndRetainsCorrelation() throws Exception {
        var query = (SemanticSimpleQueryBlock) generator().parse("SELECT (SELECT name FROM base.employees "
                + "WHERE employee_id = dept.manager_id) AS employee_name FROM base.departments dept");
        SemanticExpression expression = query.getSelectList().get(0).getExpression();
        assertEquals(1, expression.getTableReferences().size());
        assertEquals("BASE.EMPLOYEES", expression.getTableReferences().get(0).getName());
        String rendered = expression.render(physicalName);
        assertTrue(rendered, rendered.contains("HR.EMPLOYEES"));
        assertTrue(rendered, rendered.contains("dept.manager_id"));
        assertTrue(rendered, rendered.contains("WHERE"));
        assertTrue(expression.getText(), expression.getText().contains("base.employees"));
    }

    @Test public void existsAndInQueriesExposeAllEmbeddedTables() throws Exception {
        var query = (SemanticSimpleQueryBlock) generator().parse("SELECT dept.manager_id FROM base.departments dept "
                + "WHERE EXISTS (SELECT e.employee_id FROM base.employees e WHERE e.employee_id IN "
                + "(SELECT x.employee_id FROM base.employees x WHERE x.employee_id=dept.manager_id))");
        SemanticExpression filter = (SemanticExpression) query.getWhereList().get(0);
        assertEquals(2, filter.getTableReferences().size());
        assertSame(filter.getTableReferences().get(0).getDatastore(), filter.getTableReferences().get(1).getDatastore());
        String rendered = filter.render(physicalName);
        assertFalse(rendered, rendered.contains("BASE.EMPLOYEES"));
        assertTrue(rendered, rendered.contains("e.employee_id"));
        assertTrue(rendered, rendered.contains("x.employee_id"));
    }

    @Test public void replacementsPreserveLiteralsWhitespaceAndUnicode() {
        String sql = "COALESCE('😀 base.employees', (SELECT e.name /* keep */ FROM base.employees e WHERE e.name='base.employees'))";
        var expression = new Expression(sql);
        assertEquals(sql.replace("FROM base.employees e", "FROM HR.PEOPLE e"), expression.render(r -> "HR.PEOPLE"));
        assertEquals(sql, expression.getText());
        assertTrue(new Expression("'SELECT name FROM base.employees'").getTableReferences().isEmpty());
    }

    @Test public void cteScopesExcludeQueryNamesButRetainDefinitionSources() {
        var expression = new Expression("(WITH q AS (SELECT e.name FROM base.employees e) SELECT name FROM q)");
        assertEquals(1, expression.getTableReferences().size());
        String rendered = expression.render(r -> "HR.PEOPLE");
        assertTrue(rendered, rendered.contains("FROM q"));
        assertTrue(rendered, rendered.contains("FROM HR.PEOPLE e"));
        assertTrue(new Expression("(SELECT name FROM q)", Set.of("Q")).getTableReferences().isEmpty());
    }

    @Test public void qualifiedColumnsRequireAnAliasBeforeTheirTableIsRenamed() {
        var expression = new Expression("(SELECT employees.name FROM base.employees)");
        assertEquals(expression.getText(), expression.render(r -> "base.employees"));
        var error = assertThrows(IllegalArgumentException.class, () -> expression.render(r -> "HR.PEOPLE"));
        assertTrue(error.getMessage(), error.getMessage().contains("explicit alias"));
        assertEquals("(SELECT e.name FROM HR.PEOPLE e)",
                new Expression("(SELECT e.name FROM base.employees e)").render(r -> "HR.PEOPLE"));
    }

    @Test public void unknownEmbeddedDefinitionsAreDiagnosed() throws Exception {
        var generator = generator();
        var error = assertThrows(IllegalArgumentException.class, () -> generator.parse(
                "SELECT (SELECT name FROM missing.people e) AS manager FROM base.departments dept"));
        assertTrue(error.getMessage(), error.getMessage().contains("MISSING.PEOPLE"));
    }

    @Test public void templatesCanSupplyTheirOwnNamingFunction() throws Exception {
        var query = (SemanticSimpleQueryBlock) generator().parse("SELECT (SELECT e.name FROM base.employees e) "
                + "AS employee_name FROM base.departments dept");
        var expression = query.getSelectList().get(0).getExpression();
        for (var type : TemplateEngineType.values()) {
            String body = switch (type) {
                case PEBBLE, JINJAVA -> "{{ expression.render(names) }}";
                case FREEMARKER -> "${expression.render(names)}";
                case VELOCITY -> "$expression.render($names)";
            };
            String output = TemplateEngineFacadeFactory.create(type).resolve(TemplateIntegrationTest.template("embedded", body),
                    List.of(TemplateParameter.of("expression", expression), TemplateParameter.of("names", physicalName)));
            assertEquals(type.name(), expression.render(physicalName), output);
        }
    }

    @Test public void scalarClausesAndCommentsSurviveWithoutBeingReconstructed() throws Exception {
        var query = (SemanticSimpleQueryBlock) generator().parse("SELECT (SELECT e.name /* keep */ FROM base.employees e "
                + "WHERE e.employee_id < dept.manager_id ORDER BY e.employee_id DESC LIMIT 1) AS employee_name "
                + "FROM base.departments dept");
        var expression = query.getSelectList().get(0).getExpression();
        assertEquals(expression.getText().replace("base.employees", "HR.EMPLOYEES"), expression.render(physicalName));
        assertTrue(expression.getText(), expression.getText().contains("/* keep */"));
        assertTrue(expression.getText(), expression.getText().contains("LIMIT 1"));
    }

    @Test public void sortExpressionsCanContainScalarSubqueries() {
        var expression = new Expression("(SELECT e.name FROM base.employees e) DESC NULLS LAST");
        assertEquals("(SELECT e.name FROM HR.PEOPLE e) DESC NULLS LAST", expression.render(r -> "HR.PEOPLE"));
    }
}
