package org.pecheasoft.odigen;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.List;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.junit.Test;
import org.pecheasoft.odigen.metadata.MetadataManager;
import org.pecheasoft.odigen.project.Project;
import org.pecheasoft.odigen.render.CodeGeneratorService;
import org.pecheasoft.odigen.repl.Command;
import org.pecheasoft.odigen.repl.CommandExecutor;
import org.pecheasoft.odigen.sql.api.ast.impl.InsertNode;
import org.pecheasoft.odigen.sql.api.ast.SemanticSimpleQueryBlock;
import org.pecheasoft.odigen.sql.api.transform.AstTransformations;
import org.pecheasoft.odigen.sql.parser.SQLLexer;
import org.pecheasoft.odigen.template.TemplateEngineFacadeFactory;
import static org.junit.Assert.*;

public class OdiMappingStrategyTest {
    private final Path root = Path.of("examples/odi-mapping-draft");
    private Project project() { return new Project(root); }
    private CodeGeneratorService generator() {
        var project = project();
        return new CodeGeneratorService(project, new MetadataManager(project));
    }
    private String businessSql() throws Exception { return Files.readString(root.resolve("mappings/employees_to_prep.sql")); }
    private List<String> tokens(String sql) {
        var stream = new CommonTokenStream(new SQLLexer(CharStreams.fromString(sql)));
        stream.fill();
        return stream.getTokens().stream().filter(t -> t.getType() != Token.EOF && t.getChannel() == Token.DEFAULT_CHANNEL)
                .map(Token::getText).toList();
    }
    private String render(CodeGeneratorService generator, InsertNode model) {
        return generator.transform("employees_to_prep").using("CreateComplexMapping").withModel(model).render();
    }
    private void rejected(String sql, String message) {
        var generator = generator();
        var model = (InsertNode) generator.parse(sql);
        var error = assertThrows(RuntimeException.class, () -> render(generator, model));
        Throwable cause = error;
        StringBuilder details = new StringBuilder();
        while (cause != null) { details.append(cause.getMessage()).append('\n'); cause = cause.getCause(); }
        assertTrue(details.toString(), details.toString().contains(message));
    }

    @Test public void generatesAcceptedArtifactThroughProgrammaticAndReplPaths() throws Exception {
        List<String> expected = tokens(Files.readString(root.resolve("expected/PR_EMPLOYEES_TI_MAP.sql")));
        String output = generator().transform("employees_to_prep").using("CreateComplexMapping").render();
        assertEquals(expected, tokens(output));
        var project = project();
        var metadata = new MetadataManager(project);
        var repl = new CommandExecutor(() -> metadata, TemplateEngineFacadeFactory.create(project));
        assertEquals(expected, tokens(repl.execute(new Command("apply", List.of("CreateComplexMapping", "to", "mapping", "employees_to_prep")))));
    }

    @Test public void strategyPreparationDoesNotMutateTheBusinessAstOrAccumulateColumns() throws Exception {
        var generator = generator();
        var model = (InsertNode) generator.parse(businessSql());
        var firstAssignment = model.getColumns().get(0);
        var firstProjection = ((SemanticSimpleQueryBlock)model.getQuery()).getSelectList().get(0);
        String output = render(generator, model);
        assertEquals(tokens(output), tokens(render(generator, model)));
        assertEquals(3, model.getColumns().size());
        assertEquals(Integer.valueOf(0), firstAssignment.getPosition());
        assertSame(firstAssignment, firstProjection.getTargetColumn());
        assertTrue(model.annotations().has("PROPERTIES"));
        assertTrue(generator.transform("employees_to_prep").using("CreateComplexMapping").render().contains("DWH_PREP.PR_EMPLOYEES"));
    }

    @Test public void genericPreparationPreservesMetadataPositionsAndBidirectionalLinks() throws Exception {
        var model = (InsertNode) generator().parse(businessSql());
        assertEquals("PR_EMPLOYEES_UK", model.getTarget().getDatastore().getKeys().get(0).getName());
        assertTrue(model.getTarget().getDatastore().getKeys().get(0).isAlternateKey());
        var additions = new LinkedHashMap<String, String>();
        additions.put("LOAD_ID", "GET_LOAD_ID()");
        additions.put("UPDATE_ID", "GET_LOAD_ID()");
        var prepared = AstTransformations.prependAssignments(model, additions);
        assertEquals(5, prepared.getColumns().size());
        var projections = ((SemanticSimpleQueryBlock)prepared.getQuery()).getSelectList();
        for (int i = 0; i < prepared.getColumns().size(); i++) {
            var assignment = prepared.getColumns().get(i);
            assertEquals(Integer.valueOf(i), assignment.getPosition());
            assertSame(assignment, projections.get(i).getTargetColumn());
            assertSame(projections.get(i), assignment.getExpression());
            assertNotNull(assignment.getMetadata());
        }
        assertEquals(List.of("LOAD_ID", "UPDATE_ID", "EMPLOYEE_ID", "DEPARTMENT_ID", "SALARY"),
                prepared.getColumns().stream().map(c -> c.getName()).toList());
        assertNotSame(model.getColumns().get(0), prepared.getColumns().get(2));
        assertSame(model.getColumns().get(0).getMetadata(), prepared.getColumns().get(2).getMetadata());
    }

    @Test public void annotationContractAndIntegrationPolicyAreExplicit() throws Exception {
        rejected(businessSql().replace("MAPPING_NAME=\"PR_EMPLOYEES_TI_MAP\",", ""), "Missing mapping property: MAPPING_NAME");
        rejected(businessSql().replace("Incremental Update", "Control Append"), "Incremental Update only");
        rejected(businessSql().replace("UPDATE_KEY=\"PR_EMPLOYEES_UK\"", "UPDATE_KEY=\"NO_SUCH_KEY\""), "not a primary or unique key");
        rejected(businessSql().replace("UPDATE_KEY=\"PR_EMPLOYEES_UK\"", "UPDATE_KEY=\"PR_EMPLOYEES_UK\", IKM_NAME=\"custom\""), "Unsupported mapping property: IKM_NAME");
    }

    @Test public void missingTechnicalColumnsAndConflictingAssignmentsAreRejected() throws Exception {
        var generator = generator();
        var model = (InsertNode) generator.parse(businessSql());
        var target = model.getTarget().getDatastore();
        target.setAttributes(target.getAttributes().stream().filter(a -> !a.getName().equals("LOAD_DATE")).toList());
        var error = assertThrows(RuntimeException.class, () -> render(generator, model));
        assertNotNull(error.getCause());
        var original = (InsertNode) generator.parse(businessSql());
        var duplicate = new LinkedHashMap<String, String>();
        duplicate.put("EMPLOYEE_ID", "1");
        assertThrows(IllegalArgumentException.class, () -> AstTransformations.prependAssignments(original, duplicate));
        assertEquals(3, original.getColumns().size());
    }

    @Test public void groupedQueriesAreNotSilentlyTreatedAsSimpleLoads() throws Exception {
        rejected(businessSql().replace("SELECT", "SELECT DISTINCT"), "DISTINCT and grouped queries");
    }

    @Test public void constraintKindsRemainDistinctInMetadata() throws Exception {
        String definition = Files.readString(root.resolve("datastores/prep/employees.sql"));
        for (String kind : List.of("PRIMARY KEY", "UNIQUE KEY", "UNIQUE INDEX", "INDEX")) {
            var datastore = (org.pecheasoft.odigen.sql.api.ast.impl.Datastore)
                    generator().parse(definition.replace("UNIQUE KEY", kind));
            var key = datastore.getKeys().get(0);
            assertEquals(kind, kind.equals("PRIMARY KEY"), key.isPrimaryKey());
            assertEquals(kind, kind.startsWith("UNIQUE"), key.isAlternateKey());
            assertEquals(kind, kind.equals("INDEX"), key.isNonUniqueIndex());
        }
    }
}
