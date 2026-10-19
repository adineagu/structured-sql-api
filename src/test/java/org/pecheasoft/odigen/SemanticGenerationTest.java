package org.pecheasoft.odigen;

import org.junit.Test;
import org.pecheasoft.odigen.sql.api.ast.*;
import org.pecheasoft.odigen.sql.api.ast.impl.*;
import org.pecheasoft.odigen.sql.api.transform.SemanticModelBuilder;
import org.pecheasoft.odigen.sql.parse.SQLStatementParser;
import org.pecheasoft.odigen.sql.api.transform.BaseSemanticModelVisitor;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.junit.Assert.*;

public class SemanticGenerationTest {
    private SemanticModel parse(String sql) {
        return SemanticModelBuilder.getStructuredObject(new SQLStatementParser().parseSingleStatementScript(sql));
    }

    @Test
    public void preservesBusinessClausesThroughParsingAndCopying() {
        SemanticSimpleQueryBlock query = (SemanticSimpleQueryBlock) parse(
                "SELECT department_id, COUNT(*) AS total FROM employees GROUP BY department_id "
                + "HAVING COUNT(*) > 1 ORDER BY department_id DESC NULLS FIRST LIMIT 5");
        assertTrue(query.getHavingText(), query.getHavingText().contains("> 1"));
        assertEquals(query.getHavingText(), query.getHavingList().get(0).getText());
        assertEquals("DEPARTMENT_ID DESC NULLS FIRST", query.getOrderByText());
        assertEquals("5", query.getLimit().getText());
        assertEquals("5", query.shallowCopy().getLimit().getText());
    }

    @Test
    public void nestedClausesStayWithTheirOwnQuery() {
        SemanticSimpleQueryBlock outer = (SemanticSimpleQueryBlock) parse(
                "SELECT q.department_id FROM (SELECT department_id FROM employees "
                + "ORDER BY department_id DESC LIMIT 3) q ORDER BY q.department_id ASC LIMIT 2");
        JoinNode from = (JoinNode) outer.getFromList().get(0);
        SemanticNestedQueryBlock nested = (SemanticNestedQueryBlock) from.getLeftQuery();
        SemanticSimpleQueryBlock inner = (SemanticSimpleQueryBlock) nested.getQuery();
        assertEquals("Q.DEPARTMENT_ID ASC NULLS LAST", outer.getOrderByText());
        assertEquals("2", outer.getLimit().getText());
        assertEquals("DEPARTMENT_ID DESC NULLS LAST", inner.getOrderByText());
        assertEquals("3", inner.getLimit().getText());
    }

    @Test
    public void visitorTraversesCurrentInsertSetAndExpressionTypesWithoutFollowingBackReferences() {
        SemanticModel model = parse("INSERT INTO target (id) SELECT id FROM source_a UNION ALL SELECT id FROM source_b");
        List<String> relations = new ArrayList<>();
        List<String> expressions = new ArrayList<>();
        var visitor = new BaseSemanticModelVisitor<Void, Void>() {
            @Override
            public Void visitDatastoreReference(Void ctx, Stack<SemanticModel> stack, DatastoreReferenceNode node) {
                relations.add(node.getName());
                return null;
            }
            @Override
            public Void visitExpression(Void ctx, Stack<SemanticModel> stack, SemanticExpression node) {
                expressions.add(node.getText());
                return null;
            }
        };
        Stack<SemanticModel> stack = new Stack<>();
        visitor.visit(null, stack, model);
        assertEquals(3, relations.size());
        assertEquals(2, expressions.size());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void unresolvedMetadataFailsWithAnActionableDiagnostic() {
        InsertNode model = (InsertNode) parse("INSERT INTO target (id) SELECT id FROM source");
        IllegalStateException error = assertThrows(IllegalStateException.class,
                () -> model.getColumns().get(0).getDataType());
        assertTrue(error.getMessage(), error.getMessage().contains("metadata is unresolved"));
        var metadata = new DatastoreAttribute();
        assertNull(new SemanticAssignment("id", 0, metadata, model.getTarget()).getDefaultValue());
    }

    @Test
    public void derivedTablesCanContainSetQueries() {
        var query = (SemanticSimpleQueryBlock) parse("SELECT q.id FROM "
                + "(SELECT id FROM a UNION ALL SELECT id FROM b) q");
        var nested = (SemanticNestedQueryBlock) ((JoinNode) query.getFromList().get(0)).getLeftQuery();
        assertEquals(2, ((SemanticSetQueryBlock) nested.getQuery()).getDatasets().size());
    }

    @Test
    public void multiInsertAcceptsASimpleSourceAndUnconditionalTargets() {
        var insert = (InsertNode) parse("INSERT ALL INTO target (id) VALUES (id) SELECT id FROM source");
        assertTrue(insert.getQuery() instanceof SemanticSimpleQueryBlock);
        assertEquals(1, insert.getMultiInsertTargets().size());
        assertNull(insert.getMultiInsertTargets().get(0).getCondition());
    }

    @Test
    public void integrationSettingsSurviveConversionWithoutChoosingAnImplementation() {
        var insert = (InsertNode) parse("INSERT INTO target (id) INTEGRATION TYPE 'Incremental Update' "
                + "UPDATE KEY target_uk REJECT LIMIT 10 ROWS SELECT id FROM source");
        assertEquals("Incremental Update", insert.getIntegrationType());
        assertEquals("TARGET_UK", insert.getUpdateKey());
        assertEquals(Integer.valueOf(10), insert.getRejectLimit());
        assertEquals("ROWS", insert.getRejectLimitUnit());
    }

    @Test
    public void cteDependenciesAreResolvedWithoutAFixedPassLimitAndKeepReferenceAliases() {
        StringBuilder sql = new StringBuilder("WITH ");
        for (int i = 0; i < 12; i++) {
            sql.append("q").append(i).append(" AS (SELECT id FROM q").append(i + 1).append("), ");
        }
        sql.append("q12 AS (SELECT id FROM original) SELECT x.id FROM q0 x");
        var query = (SemanticSimpleQueryBlock) ((InsertNode) parse("INSERT INTO sink (id) " + sql)).getQuery();
        var reference = (SemanticNestedQueryBlock) ((JoinNode) query.getFromList().get(0)).getLeftQuery();
        assertEquals("X", reference.getAlias());
        List<String> relations = new ArrayList<>();
        new BaseSemanticModelVisitor<Void, Void>() {
            @Override
            public Void visitDatastoreReference(Void ctx, Stack<SemanticModel> stack, DatastoreReferenceNode node) {
                relations.add(node.getName());
                return null;
            }
        }.visit(null, new Stack<>(), query);
        assertEquals(List.of("ORIGINAL"), relations);
    }

    @Test
    public void recursiveCtesFailExplicitlyRatherThanLeavingUnresolvedRelations() {
        var error = assertThrows(IllegalArgumentException.class,
                () -> parse("INSERT INTO sink (id) WITH q AS (SELECT id FROM q) SELECT id FROM q"));
        assertTrue(error.getMessage(), error.getMessage().contains("Recursive WITH query"));
    }

    @Test
    public void repositoryAddressMappingStillParsesWithItsAnnotationsAndAssignments() throws Exception {
        var insert = (InsertNode) parse(java.nio.file.Files.readString(
                java.nio.file.Path.of("project/mappings/otp.analytic/ad_address_ti_map.sql")));
        assertEquals("AD_ADDRESS", insert.getTarget().getName());
        assertEquals(10, insert.getColumns().size());
        assertEquals("Incremental Update", insert.annotations().get("PROPERTIES").attribute("INTEGRATION_TYPE"));
        assertNotNull(insert.getColumns().get(0).getExpression());
    }

    @Test
    public void nestedWithDefinitionsDoNotLeakIntoTheirEnclosingScope() {
        var model = parse("INSERT INTO sink (id) WITH q AS (SELECT id FROM outer_source) SELECT n.id FROM "
                + "(WITH q AS (SELECT id FROM inner_source) SELECT id FROM q) n "
                + "JOIN q p ON n.id = p.id");
        List<String> relations = new ArrayList<>();
        new BaseSemanticModelVisitor<Void, Void>() {
            @Override
            public Void visitDatastoreReference(Void ctx, Stack<SemanticModel> stack, DatastoreReferenceNode node) {
                relations.add(node.getName());
                return null;
            }
        }.visit(null, new Stack<>(), model);
        assertEquals(List.of("SINK", "INNER_SOURCE", "OUTER_SOURCE"), relations);
    }
}
