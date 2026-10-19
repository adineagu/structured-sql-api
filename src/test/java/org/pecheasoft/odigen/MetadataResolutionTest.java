package org.pecheasoft.odigen;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.pecheasoft.odigen.metadata.MetadataManager;
import org.pecheasoft.odigen.metadata.MetadataResolver;
import org.pecheasoft.odigen.project.Project;
import org.pecheasoft.odigen.render.CodeGeneratorService;
import org.pecheasoft.odigen.repl.Command;
import org.pecheasoft.odigen.repl.CommandExecutor;
import org.pecheasoft.odigen.sql.api.ast.SemanticModel;
import org.pecheasoft.odigen.sql.api.ast.impl.DatastoreReferenceNode;
import org.pecheasoft.odigen.sql.api.ast.impl.InsertNode;
import org.pecheasoft.odigen.sql.api.transform.BaseSemanticModelVisitor;
import org.pecheasoft.odigen.sql.api.transform.SemanticModelBuilder;
import org.pecheasoft.odigen.sql.parse.SQLStatementParser;
import org.pecheasoft.odigen.template.TemplateEngineFacadeFactory;

import static org.junit.Assert.*;

public class MetadataResolutionTest {
    @Rule public TemporaryFolder temporary = new TemporaryFolder();

    private Path projectRoot() throws Exception {
        Path root = temporary.newFolder().toPath();
        for (String folder : List.of("datastores", "mappings", "templates")) Files.createDirectories(root.resolve(folder));
        return root;
    }

    private void write(Path root, String path, String content) throws Exception {
        Path file = root.resolve(path);
        Files.createDirectories(file.getParent());
        Files.writeString(file, content);
    }

    private CodeGeneratorService generator(Path root) {
        Project project = new Project(root);
        return new CodeGeneratorService(project, new MetadataManager(project));
    }

    private List<DatastoreReferenceNode> references(SemanticModel model) {
        List<DatastoreReferenceNode> result = new ArrayList<>();
        new BaseSemanticModelVisitor<Void, Void>() {
            @Override public Void visitDatastoreReference(Void ctx, Stack<SemanticModel> stack, DatastoreReferenceNode node) {
                result.add(node);
                return null;
            }
        }.visit(null, new Stack<>(), model);
        return result;
    }

    @Test
    public void injectsStructuredDefinitionsWithoutMergingBusinessAndDefinitionAnnotations() throws Exception {
        Path root = projectRoot();
        write(root, "datastores/warehouse/customer.sql", "@SCD(SCD_TYPE=\"SCD2\") CREATE TABLE physical_customer "
                + "(@properties(role=\"key\") id NUMBER NOT NULL NATURAL_KEY, CONSTRAINT customer_pk PRIMARY KEY(id))");
        write(root, "datastores/crm/customer.sql", "@source(system=\"CRM\") CREATE TABLE physical_source (id NUMBER)");
        String sql = "@properties(strategy=\"history\") INSERT INTO warehouse.customer "
                + "(@properties(role=\"business\") id) SELECT c.id FROM crm.customer c JOIN crm.customer d ON c.id=d.id";
        var insert = (InsertNode) generator(root).parse(sql);
        var refs = references(insert);
        assertEquals(3, refs.size());
        assertEquals("PHYSICAL_CUSTOMER", insert.getTarget().getDatastore().getName());
        assertEquals("WAREHOUSE.CUSTOMER", insert.getTarget().getName());
        assertEquals("C", refs.get(1).getAlias());
        assertSame(refs.get(1).getDatastore(), refs.get(2).getDatastore());
        assertEquals("CRM", refs.get(1).getDatastore().annotations().get("SOURCE").attribute("SYSTEM"));
        assertEquals("SCD2", insert.getTarget().getDatastore().annotations().get("SCD").attribute("SCD_TYPE"));
        assertEquals(1, insert.getTarget().getDatastore().getKeys().size());
        var assignment = insert.getColumns().get(0);
        assertSame(insert.getTarget().getDatastore().getAttribute("ID"), assignment.getMetadata());
        assertEquals("NUMBER", assignment.getDataType());
        assertEquals("NATURAL_KEY", assignment.getScdBehavior());
        assertEquals("business", assignment.annotations().get("PROPERTIES").attribute("ROLE"));
        assertEquals("key", assignment.getMetadata().annotations().get("PROPERTIES").attribute("ROLE"));
        assertSame(assignment, assignment.getExpression().getTargetColumn());
    }

    @Test
    public void enrichmentKeepsAssignmentIdentityAndExpressionLinks() throws Exception {
        Path root = projectRoot();
        write(root, "datastores/dest.sql", "CREATE TABLE actual_dest (id NUMBER)");
        write(root, "datastores/src.sql", "CREATE TABLE actual_src (id NUMBER)");
        var model = (InsertNode) SemanticModelBuilder.getStructuredObject(new SQLStatementParser()
                .parseSingleStatementScript("INSERT INTO dest(id) SELECT id FROM src"));
        var assignment = model.getColumns().get(0);
        assertNull(assignment.getMetadata());
        var project = new Project(root);
        new MetadataResolver(new MetadataManager(project)).resolve(model, "mapping", MetadataResolver.Mode.STRICT);
        assertSame(assignment, model.getColumns().get(0));
        assertSame(assignment, assignment.getExpression().getTargetColumn());
        assertNotNull(assignment.getMetadata());
        assertTrue(model.toJson(), model.toJson().contains("\"Metadata\""));
    }

    @Test
    public void traversesCtesNestedQueriesAndSetBranchesWithoutLookingUpAliasesAsFiles() throws Exception {
        Path root = projectRoot();
        for (String id : List.of("dest", "a", "b")) {
            write(root, "datastores/schema/" + id + ".sql", "CREATE TABLE " + id + " (id NUMBER)");
        }
        var model = generator(root).parse("INSERT INTO schema.dest(id) WITH q AS "
                + "(SELECT id FROM schema.a UNION ALL SELECT id FROM schema.b) "
                + "SELECT n.id FROM (SELECT id FROM q) n");
        var refs = references(model);
        assertEquals(List.of("SCHEMA.DEST", "SCHEMA.A", "SCHEMA.B"), refs.stream().map(DatastoreReferenceNode::getName).toList());
        assertTrue(refs.stream().allMatch(r -> r.getDatastore() != null));
    }

    @Test
    public void multiInsertTargetsReceiveDefinitionsAndColumnBindings() throws Exception {
        Path root = projectRoot();
        for (String id : List.of("a", "b", "src")) write(root, "datastores/" + id + ".sql", "CREATE TABLE " + id + " (id NUMBER)");
        var insert = (InsertNode) generator(root).parse("INSERT ALL INTO a(id) VALUES(id) INTO b(id) VALUES(id) SELECT id FROM src");
        for (var target : insert.getMultiInsertTargets()) {
            assertTrue(target.getTarget().isTarget());
            var item = target.getSelectList().get(0);
            assertSame(target.getTarget().getDatastore().getAttribute("ID"), item.getTargetColumn().getMetadata());
            assertSame(item, item.getTargetColumn().getExpression());
        }
        var binding = insert.getMultiInsertTargets().get(0).getSelectList().get(0).getTargetColumn();
        new MetadataResolver(new MetadataManager(new Project(root))).resolve(insert, "prepared", MetadataResolver.Mode.STRICT);
        assertSame(binding, insert.getMultiInsertTargets().get(0).getSelectList().get(0).getTargetColumn());
    }

    @Test
    public void strictMissingDefinitionReportsMappingReferenceAndExpectedLocation() throws Exception {
        Path root = projectRoot();
        write(root, "datastores/known.sql", "CREATE TABLE known (id NUMBER)");
        write(root, "mappings/load.sql", "INSERT INTO known(id) SELECT id FROM crm.missing");
        var gen = generator(root);
        var project = new Project(root);
        var metadata = new MetadataManager(project);
        var error = assertThrows(IllegalArgumentException.class, () -> gen.parse(metadata.findMapping("load").orElseThrow()));
        assertTrue(error.getMessage(), error.getMessage().contains("'load'"));
        assertTrue(error.getMessage(), error.getMessage().contains("CRM.MISSING"));
        assertTrue(error.getMessage(), error.getMessage().contains("datastores/CRM/MISSING.sql"));
    }

    @Test
    public void unresolvedModeStillInjectsKnownDefinitionsAndDoesNotGuessBasenames() throws Exception {
        Path root = projectRoot();
        write(root, "datastores/warehouse/dest.sql", "CREATE TABLE physical (id NUMBER)");
        write(root, "datastores/crm/customer.sql", "CREATE TABLE customer (id NUMBER)");
        var gen = generator(root).withMetadataResolution(MetadataResolver.Mode.ALLOW_UNRESOLVED);
        var insert = (InsertNode) gen.parse("INSERT INTO warehouse.dest(id) SELECT id FROM customer");
        assertNotNull(insert.getColumns().get(0).getMetadata());
        assertNull(references(insert).get(1).getDatastore());
        assertThrows(IllegalArgumentException.class, () -> generator(root).parse("SELECT id FROM customer"));
    }

    @Test
    public void missingTargetColumnsFailStrictlyAndRemainAbsentInUnresolvedMode() throws Exception {
        Path root = projectRoot();
        write(root, "datastores/dest.sql", "CREATE TABLE dest (id NUMBER)");
        String sql = "INSERT INTO dest(missing_column) SELECT id FROM dest";
        var error = assertThrows(IllegalArgumentException.class, () -> generator(root).parse(sql));
        assertTrue(error.getMessage(), error.getMessage().contains("MISSING_COLUMN"));
        assertTrue(error.getMessage(), error.getMessage().contains("DEST"));
        var model = (InsertNode) generator(root).withMetadataResolution(MetadataResolver.Mode.ALLOW_UNRESOLVED).parse(sql);
        assertNull(model.getColumns().get(0).getMetadata());
    }

    @Test
    public void ambiguousProjectIdentifiersAreRejectedEvenInUnresolvedMode() throws Exception {
        Path root = projectRoot();
        write(root, "datastores/crm.customer.sql", "CREATE TABLE a (id NUMBER)");
        write(root, "datastores/crm/customer.sql", "CREATE TABLE b (id NUMBER)");
        var error = assertThrows(IllegalArgumentException.class, () -> generator(root)
                .withMetadataResolution(MetadataResolver.Mode.ALLOW_UNRESOLVED).parse("SELECT id FROM crm.customer"));
        assertTrue(error.getMessage(), error.getMessage().contains("Ambiguous datastore reference"));
    }

    @Test
    public void malformedMatchedDefinitionsAreNotSilentlyIgnored() throws Exception {
        Path root = projectRoot();
        write(root, "datastores/src.sql", "SELECT id FROM something");
        var error = assertThrows(IllegalArgumentException.class, () -> generator(root)
                .withMetadataResolution(MetadataResolver.Mode.ALLOW_UNRESOLVED).parse("SELECT id FROM src"));
        assertTrue(error.getMessage(), error.getMessage().contains("must declare a TABLE or DATASTORE"));
    }

    @Test
    public void fluentRenderingAndReplReceiveTheSameEnrichedAstAndNewOperationsReloadDefinitions() throws Exception {
        Path root = projectRoot();
        write(root, "datastores/dest.sql", "CREATE TABLE physical (id NUMBER(12))");
        write(root, "datastores/src.sql", "CREATE TABLE physical_src (id NUMBER)");
        write(root, "mappings/load.sql", "INSERT INTO dest(id) SELECT id FROM src");
        write(root, "templates/show.peb", "{{ mapping.target.datastore.name }}:{{ mapping.columns[0].DDLDataType }}");
        Project project = new Project(root);
        var metadata = new MetadataManager(project);
        var gen = new CodeGeneratorService(project, metadata);
        assertEquals("PHYSICAL:NUMBER(12)", gen.transform("load").using("show").render());
        var executor = new CommandExecutor(() -> metadata, TemplateEngineFacadeFactory.create(project));
        assertEquals("PHYSICAL:NUMBER(12)", executor.execute(new Command("apply", List.of("show", "to", "mapping", "load"))));
        var model = (InsertNode) gen.parse(metadata.findMapping("load").orElseThrow());
        assertEquals("PHYSICAL:NUMBER(12)", gen.transform("load").using("show").withModel(model).render());
        write(root, "datastores/dest.sql", "CREATE TABLE updated (id NUMBER(20))");
        assertEquals("UPDATED:NUMBER(20)", gen.transform("load").using("show").render());
    }
}
