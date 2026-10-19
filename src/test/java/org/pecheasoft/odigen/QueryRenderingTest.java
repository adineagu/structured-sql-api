package org.pecheasoft.odigen;

import java.nio.file.Path;
import java.util.List;
import org.junit.Test;
import org.pecheasoft.odigen.metadata.MetadataManager;
import org.pecheasoft.odigen.project.Project;
import org.pecheasoft.odigen.render.*;
import org.pecheasoft.odigen.repl.Command;
import org.pecheasoft.odigen.repl.CommandExecutor;
import org.pecheasoft.odigen.sql.api.ast.*;
import org.pecheasoft.odigen.sql.api.ast.impl.*;
import org.pecheasoft.odigen.sql.api.transform.SemanticModelBuilder;
import org.pecheasoft.odigen.sql.parse.SQLStatementParser;
import org.pecheasoft.odigen.template.*;
import static org.junit.Assert.*;

public class QueryRenderingTest {
    private SemanticModel parse(String sql) {
        return SemanticModelBuilder.getStructuredObject(new SQLStatementParser().parseSingleStatementScript(sql));
    }
    private String normalize(String text) { return text.replaceAll("\\s+", " ").trim(); }
    private String render(SemanticModel model, TransformationContext context) {
        var engine = TemplateEngineFacadeFactory.create(TemplateEngineType.VELOCITY);
        return normalize(engine.resolve(TemplateIntegrationTest.template("render", "#parse('library.Query')#Render($model $ctx)"),
                List.of(TemplateParameter.of("model", model), TemplateParameter.of("ctx", context))));
    }
    private void expected(String sql, String expected) {
        assertEquals(normalize(expected), render(parse(sql), new TransformationContext()));
    }

    @Test public void simpleProjectionAndFromlessQueryHaveCompleteExpectedOutput() {
        expected("SELECT DISTINCT e.id AS employee_id FROM base.employees e WHERE e.id > 0",
                "SELECT DISTINCT E.ID AS EMPLOYEE_ID FROM BASE.EMPLOYEES E WHERE (E.ID > 0)");
        expected("SELECT 1 AS value", "SELECT 1 AS VALUE");
    }

    @Test public void joinsNestedQueriesAndCommaSourcesRetainTheirStructure() {
        expected("SELECT e.id AS id FROM base.employees e LEFT JOIN "
                + "(SELECT d.id AS id FROM base.departments d) q ON e.id=q.id",
                "SELECT E.ID AS ID FROM ( BASE.EMPLOYEES E LEFT JOIN ( SELECT D.ID AS ID FROM BASE.DEPARTMENTS D ) Q ON E.ID = Q.ID)");
        var query = (SemanticSimpleQueryBlock) parse("SELECT 1 AS value");
        query.setFromList(List.of(new DatastoreReferenceNode("A", "A1"), new DatastoreReferenceNode("B", "B1")));
        assertEquals("SELECT 1 AS VALUE FROM A A1 , B B1", render(query, new TransformationContext()));
    }

    @Test public void groupingHavingOrderingAndExplicitLimitDialectAreRendered() {
        var model = parse("SELECT e.department_id AS department_id, COUNT(*) AS total FROM base.employees e "
                + "GROUP BY e.department_id HAVING COUNT(*) > 1 ORDER BY e.department_id DESC NULLS FIRST LIMIT 5");
        String prefix = "SELECT E.DEPARTMENT_ID AS DEPARTMENT_ID , COUNT(*) AS TOTAL FROM BASE.EMPLOYEES E "
                + "GROUP BY E.DEPARTMENT_ID HAVING COUNT(*) > 1 ORDER BY E.DEPARTMENT_ID DESC NULLS FIRST ";
        assertEquals(prefix + "LIMIT 5", render(model, new TransformationContext().withLimitStyle(TransformationContext.LimitStyle.LIMIT)));
        assertEquals(prefix + "FETCH FIRST 5 ROWS ONLY", render(model, new TransformationContext().withLimitStyle(TransformationContext.LimitStyle.FETCH_FIRST)));
        assertThrows(RuntimeException.class, () -> render(model, new TransformationContext()));
    }

    @Test public void insertAndSetBranchesDoNotAddTechnicalFieldsOrIntegrationPolicies() {
        expected("INSERT INTO dest(id) SELECT a.id AS id FROM a UNION ALL SELECT b.id AS id FROM b",
                "INSERT INTO DEST ( ID) SELECT A.ID AS ID FROM A A UNION ALL SELECT B.ID AS ID FROM B B");
        expected("INSERT ALL INTO a(id) VALUES(id) INTO b(id) VALUES(id) SELECT s.id AS id FROM s",
                "INSERT ALL INTO A ( ID) VALUES (id) INTO B ( ID) VALUES (id) SELECT S.ID AS ID FROM S S");
    }

    @Test public void annotationsAndExplicitIntegrationSettingsAreNotInterpreted() {
        expected("@properties(strategy=\"custom\") INSERT INTO dest (@properties(flag=\"x\") id) SELECT id AS id FROM src",
                "@PROPERTIES(STRATEGY=\"custom\") INSERT INTO DEST (@PROPERTIES(FLAG=\"x\") ID) SELECT ID AS ID FROM SRC SRC");
        var model = parse("INSERT INTO dest(id) INTEGRATION TYPE 'Example' SELECT id AS id FROM src");
        assertThrows(RuntimeException.class, () -> render(model, new TransformationContext()));
        assertEquals("INSERT INTO DEST ( ID) INTEGRATION TYPE 'Example' SELECT ID AS ID FROM SRC SRC",
                render(model, new TransformationContext().withIntegrationRenderer(n -> "INTEGRATION TYPE '" + ((InsertNode)n).getIntegrationType() + "'")));
    }

    @Test public void sourceAndTargetRulesAlsoReachEmbeddedQueries() {
        var model = parse("INSERT INTO dest(id) SELECT (SELECT x.id FROM src x WHERE x.id=e.id) AS id FROM src e");
        var context = new TransformationContext().withSourceNames(r -> "INPUT." + r.getBasename())
                .withTargetNames(r -> "OUTPUT." + r.getBasename());
        assertEquals("INSERT INTO OUTPUT.DEST ( ID) SELECT (SELECT x.id FROM INPUT.SRC x WHERE x.id=e.id) AS ID FROM INPUT.SRC E",
                render(model, context));
    }

    @Test public void unsupportedAndIncompleteModelsFailExplicitly() {
        var model = (SemanticSimpleQueryBlock) parse("SELECT e.id AS id FROM src e");
        model.setPivotText("UNPIVOT ...");
        assertThrows(RuntimeException.class, () -> render(model, new TransformationContext()));
        model.setPivotText(null);
        model.setFromList(List.of(new JoinNode(new DatastoreReferenceNode("A"), new DatastoreReferenceNode("B"), null, null)));
        assertThrows(RuntimeException.class, () -> render(model, new TransformationContext()));
        var externalCte = parse("INSERT INTO dest(id) WITH q AS (SELECT id FROM src) SELECT (SELECT id FROM q) AS id FROM q");
        assertThrows(RuntimeException.class, () -> render(externalCte, new TransformationContext()));
    }

    @Test public void expandedCtesRenderAsNestedQueries() {
        expected("INSERT INTO dest(id) WITH q AS (SELECT s.id AS id FROM src s) SELECT q.id AS id FROM q",
                "INSERT INTO DEST ( ID) SELECT Q.ID AS ID FROM ( SELECT S.ID AS ID FROM SRC S ) Q");
    }

    @Test public void exampleWorksThroughReplAndProgrammaticGenerationWithIndependentContexts() {
        var project = new Project(Path.of("examples/ast-rendering"));
        var metadata = new MetadataManager(project);
        var executor = new CommandExecutor(() -> metadata, TemplateEngineFacadeFactory.create(project));
        String logical = normalize(executor.execute(new Command("apply", List.of("render", "to", "mapping", "department_totals"))));
        assertEquals("INSERT INTO TARGET.TOTALS ( DEPARTMENT_ID, TOTAL_SALARY) SELECT E.DEPARTMENT_ID AS DEPARTMENT_ID , SUM(E.SALARY) AS TOTAL_SALARY "
                + "FROM SOURCE.EMPLOYEES E GROUP BY E.DEPARTMENT_ID HAVING SUM(E.SALARY) > 0 ORDER BY E.DEPARTMENT_ID ASC NULLS LAST", logical);
        var context = new TransformationContext().withSourceNames(r -> r.getDatastore().getName()).withTargetNames(r -> r.getDatastore().getName());
        String physical = normalize(new CodeGeneratorService(project, metadata).withContext(context).transform("department_totals").using("render").render());
        assertEquals(logical.replace("TARGET.TOTALS", "REPORTING.DEPARTMENT_TOTALS").replace("SOURCE.EMPLOYEES", "HR.EMPLOYEES"), physical);
        assertEquals(logical, normalize(executor.execute(new Command("apply", List.of("render", "to", "mapping", "department_totals")))));
    }

    @Test public void distinctAndIntersectAllOperatorsRetainTheirMeaning() {
        expected("INSERT INTO dest(id) SELECT a.id AS id FROM a UNION SELECT b.id AS id FROM b",
                "INSERT INTO DEST ( ID) SELECT A.ID AS ID FROM A A UNION SELECT B.ID AS ID FROM B B");
        expected("INSERT INTO dest(id) SELECT a.id AS id FROM a INTERSECT ALL SELECT b.id AS id FROM b INTERSECT DISTINCT SELECT c.id AS id FROM c",
                "INSERT INTO DEST ( ID) SELECT A.ID AS ID FROM A A INTERSECT ALL SELECT B.ID AS ID FROM B B INTERSECT SELECT C.ID AS ID FROM C C");
    }

    @Test public void renderContextConfigurationDoesNotLeakAcrossGenerations() {
        var context = new TransformationContext();
        context.copy().withSourceNames(r -> "CHANGED");
        assertEquals("ORIGINAL", context.sourceName(new DatastoreReferenceNode("ORIGINAL", "O")));
        var project = new Project(Path.of("examples/ast-rendering"));
        var generator = new CodeGeneratorService(project, new MetadataManager(project));
        assertThrows(IllegalArgumentException.class, () -> generator.transform("department_totals").using("render").withParameter("ctx", context).render());
        assertTrue(generator.transform("department_totals").using("render").render().contains("SOURCE.EMPLOYEES"));
    }
}
