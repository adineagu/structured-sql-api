package org.pecheasoft.odigen;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.Test;
import org.pecheasoft.odigen.project.*;
import org.pecheasoft.odigen.sql.api.ast.impl.Datastore;
import org.pecheasoft.odigen.sql.api.transform.SemanticModelBuilder;
import org.pecheasoft.odigen.sql.parse.SQLStatementParser;
import org.pecheasoft.odigen.template.*;
import org.pecheasoft.odigen.template.pebble.PebbleTemplateService;
import org.pecheasoft.odigen.template.velocity.ApacheVelocityTemplateService;
import org.pecheasoft.odigen.template.freemarker.FreeMarkerTemplateService;
import org.pecheasoft.odigen.template.jinjava.JinjavaTemplateService;
import org.pecheasoft.odigen.metadata.MetadataManager;
import org.pecheasoft.odigen.render.CodeGeneratorService;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import static org.junit.Assert.*;

public class TemplateIntegrationTest {
    @Rule public TemporaryFolder temporary = new TemporaryFolder();
    static ProjectObject template(String name, String body) {
        return new ProjectObject(new ProjectObjectId(ObjectType.TEMPLATE, name, Path.of(name)), body);
    }

    @Test
    public void velocityLoadsBodiesIncludesAndKeepsInstancesIndependent() {
        var first = new ApacheVelocityTemplateService();
        var helper = template("helper", "hello $name");
        first.loadTemplates(List.of(helper));
        var second = new ApacheVelocityTemplateService();
        assertEquals("second", second.resolve(template("main", "second"), List.of()));
        assertEquals("hello world", first.resolve(template("main", "#parse('helper')"),
                List.of(TemplateParameter.of("name", "world"))));
    }

    @Test
    public void projectDatastoreTemplatePreservesCharacterSemanticsAndMandatoryColumns() throws Exception {
        Datastore datastore = (Datastore) SemanticModelBuilder.getStructuredObject(
                new SQLStatementParser().parseSingleStatementScript(
                        "CREATE TABLE demo (@properties(char_length_semantic=\"CHAR\") name VARCHAR2(20) NOT NULL)"));
        String body = Files.readString(Path.of("project/templates/datastore/create_datastore.peb"));
        String output = new PebbleTemplateService().resolve(template("create", body),
                List.of(TemplateParameter.of("datastore", datastore)));
        assertTrue(output, output.contains("VARCHAR2_CHAR(20)"));
        assertTrue(output, output.matches("(?s).*VARCHAR2_CHAR\\(20\\)\\s+NOT NULL.*"));
        assertTrue(output, output.contains("-- Columns: 1"));
    }

    @Test
    public void facadesResolveCompanionTemplates() {
        var cases = List.of(
                new Object[] {new PebbleTemplateService(), "{% include 'helper' %}"},
                new Object[] {new FreeMarkerTemplateService(), "<#include 'helper'>"},
                new Object[] {new JinjavaTemplateService(), "{% include 'helper' %}"});
        for (Object[] example : cases) {
            TemplateEngineFacade engine = (TemplateEngineFacade) example[0];
            engine.loadTemplates(List.of(template("helper", "shared")));
            assertEquals(engine.getClass().getName(), "shared",
                    engine.resolve(template("main", (String) example[1]), List.of()));
        }
    }

    @Test
    public void fluentRenderingUsesPreparedModelsParametersAndProjectDependencies() throws Exception {
        Path root = temporary.newFolder().toPath();
        Files.createDirectories(root.resolve("datastores"));
        Files.createDirectories(root.resolve("mappings"));
        Files.createDirectories(root.resolve("templates"));
        Files.writeString(root.resolve("datastores/demo.sql"), "CREATE TABLE original (id NUMBER)");
        Files.writeString(root.resolve("templates/helper.peb"), "{{ datastore.name }}-{{ strategy }}");
        Files.writeString(root.resolve("templates/main.peb"), "{% include 'helper' %}");
        var project = new Project(root);
        var generator = new CodeGeneratorService(project, new MetadataManager(project));
        var model = (Datastore) generator.parse("CREATE TABLE prepared (id NUMBER)");
        model.setName("changed");
        assertEquals("changed-history", generator.transform("demo").using("main")
                .withModel(model).withParameter("strategy", "history").render());
        assertThrows(RuntimeException.class, () -> generator.parse("SELECT id FROM a; SELECT id FROM b"));
    }

    @Test
    public void supportedResourceDatastoreTemplatesRenderAgainstCurrentModel() throws Exception {
        var datastore = (Datastore) SemanticModelBuilder.getStructuredObject(
                new SQLStatementParser().parseSingleStatementScript(
                        "CREATE TABLE demo (@properties(char_length_semantic=\"CHAR\") name VARCHAR2(20) NOT NULL)"));
        for (String extension : List.of("peb", "ftl", "vtl", "jinja")) {
            TemplateEngineFacade engine = TemplateEngineFacadeFactory.create(TemplateExtensions.detect("test." + extension));
            String body = Files.readString(Path.of("src/main/resources/template/create_datastore." + extension));
            String output = engine.resolve(template("create", body), List.of(TemplateParameter.of("datastore", datastore)));
            assertTrue(extension + ": " + output, output.contains("NOT NULL"));
            if (!extension.equals("jinja")) assertTrue(extension + ": " + output, output.contains("VARCHAR2_CHAR(20)"));
            assertTrue(extension + ": " + output, output.toLowerCase().contains("name"));
        }
    }
}
