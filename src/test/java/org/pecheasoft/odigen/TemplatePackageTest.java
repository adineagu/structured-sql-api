package org.pecheasoft.odigen;

import java.nio.file.*;
import java.util.*;
import org.junit.*;
import org.junit.rules.TemporaryFolder;
import org.pecheasoft.odigen.project.*;
import org.pecheasoft.odigen.metadata.MetadataManager;
import org.pecheasoft.odigen.render.CodeGeneratorService;
import org.pecheasoft.odigen.repl.*;
import org.pecheasoft.odigen.template.*;
import static org.junit.Assert.*;

public class TemplatePackageTest {
    @Rule public TemporaryFolder temporary = new TemporaryFolder();

    private Path project(String engine) throws Exception {
        Path root = temporary.newFolder().toPath();
        for (String folder : List.of("datastores", "mappings", "templates")) Files.createDirectories(root.resolve(folder));
        Files.writeString(root.resolve("config.yml"), "templateEngine: " + engine);
        Files.writeString(root.resolve("mappings/example.sql"), "SELECT 1 AS VALUE");
        return root;
    }
    private void write(Path root, String file, String content) throws Exception {
        Path path = root.resolve("templates").resolve(file);
        Files.createDirectories(path.getParent());
        Files.writeString(path, content);
    }
    private CodeGeneratorService generator(Path root) {
        var project = new Project(root);
        return new CodeGeneratorService(project, new MetadataManager(project));
    }
    private String descriptor(String entry, String output) {
        return descriptor("velocity", entry, output);
    }
    private String descriptor(String engine, String entry, String output) {
        return "engine: " + engine + "\nartifacts:\n  - template: " + entry + "\n    output: '" + output + "'\n";
    }

    @Test public void packagesHavePrivateLocalIncludesAcrossAllEnginesAndLegacyFilesStillWork() throws Exception {
        for (String engine : List.of("velocity", "freemarker", "pebble", "jinjava")) {
            Path root = project(engine);
            String extension = switch (engine) { case "velocity" -> "vtl"; case "freemarker" -> "ftl"; case "pebble" -> "peb"; default -> "jinja"; };
            String body = switch (engine) {
                case "velocity" -> "#parse('helper.vtl'):$artifactName";
                case "freemarker" -> "<#include 'helper.ftl'>:${artifactName}";
                default -> "{% include 'helper." + extension + "' %}:{{ artifactName }}";
            };
            for (String name : List.of("one", "two")) {
                write(root, name + "/template.yml", descriptor(engine, "main." + extension, "{name}.txt"));
                write(root, name + "/main." + extension, body);
                write(root, name + "/helper." + extension, name);
            }
            write(root, "legacy." + extension, "legacy");
            var generator = generator(root);
            assertEquals(engine, Map.of("example.txt", "one:example"), generator.renderPackage("example", "one"));
            assertEquals(engine, Map.of("example.txt", "two:example"), generator.renderPackage("example", "two"));
            assertEquals("legacy", generator.transform("example").using("legacy").render());
            var metadata = new MetadataManager(new Project(root));
            assertEquals(Set.of("one", "two", "legacy"), new HashSet<>(metadata.findAllTemplates("").stream().map(t -> t.id().qualifiedName()).toList()));
            assertTrue(metadata.findTemplate("one.helper").isEmpty());
        }
    }

    @Test public void replListsAndAppliesPackageAndSqlReferenceUsesArtifactBasename() throws Exception {
        Path root = temporary.newFolder().toPath();
        Path example = Path.of("examples/airflow-bigquery-draft");
        try (var paths = Files.walk(example)) {
            for (Path path : paths.toList()) {
                Path destination = root.resolve(example.relativize(path));
                if (Files.isDirectory(path)) Files.createDirectories(destination); else Files.copy(path, destination);
            }
        }
        Path mapping = root.resolve("mappings/employees_to_prep.sql");
        Files.writeString(mapping, Files.readString(mapping).replace("DAG_ID=\"employees_to_prep\"", "DAG_ID=\"different_dag\""));
        var project = new Project(root);
        var metadata = new MetadataManager(project);
        var executor = new CommandExecutor(() -> metadata, TemplateEngineFacadeFactory.create(project));
        assertEquals("airflow_bigquery", executor.execute(new Command("list", List.of("templates"))));
        String result = executor.execute(new Command("apply", List.of("airflow_bigquery", "to", "mapping", "employees_to_prep", "into", "out")));
        assertTrue(result, result.contains("Generated template package"));
        assertTrue(Files.exists(root.resolve("out/sql/employees_to_prep.sql")));
        String dag = Files.readString(root.resolve("out/employees_to_prep.py"));
        assertTrue(dag.contains("dag_id=\"different_dag\""));
        assertTrue(dag.contains("include 'employees_to_prep.sql'"));
        executor.execute(new Command("apply", List.of("airflow_bigquery", "to", "mapping", "employees_to_prep")));
        assertTrue(Files.exists(root.resolve("generated/airflow_bigquery/employees_to_prep/employees_to_prep.py")));
        assertTrue(executor.execute(new Command("show", List.of("template", "airflow_bigquery"))).contains("artifacts:"));
        assertThrows(IllegalArgumentException.class, () -> generator(root).transform("employees_to_prep").using("airflow_bigquery"));
    }

    @Test public void invalidOutputsAndMissingLocalIncludesFailWithoutWriting() throws Exception {
        for (String output : List.of("../escape.txt", "{unknown}.txt", "/absolute.txt", "C:relative.txt", "C:/absolute.txt")) {
            Path root = project("velocity");
            write(root, "pkg/template.yml", descriptor("main.vtl", output));
            write(root, "pkg/main.vtl", "body");
            assertThrows(RuntimeException.class, () -> generator(root).generatePackage("example", "pkg", root.resolve("out")));
            assertFalse(Files.exists(root.resolve("out")));
        }
        Path root = project("velocity");
        write(root, "pkg/template.yml", descriptor("main.vtl", "{name}.txt"));
        write(root, "pkg/main.vtl", "#parse('missing')");
        write(root, "missing.vtl", "must not fall back to this global helper");
        assertThrows(IllegalArgumentException.class, () -> generator(root).renderPackage("example", "pkg"));
    }

    @Test public void descriptorAndOutputCollisionsAreRejected() throws Exception {
        Path root = project("velocity");
        write(root, "pkg/main.vtl", "ok");
        write(root, "pkg/template.yml", "engine: velocity\nartifacts:\n  - template: main.vtl\n    output: a.txt\n  - template: main.vtl\n    output: './a.txt'\n");
        assertThrows(IllegalArgumentException.class, () -> generator(root).renderPackage("example", "pkg"));
        write(root, "pkg/template.yml", "artifacts: []\n");
        assertThrows(IllegalArgumentException.class, () -> generator(root).renderPackage("example", "pkg"));
        write(root, "pkg/template.yml", descriptor("main.vtl", "out.txt"));
        write(root, "pkg.vtl", "ambiguous public template name");
        assertThrows(IllegalArgumentException.class, () -> new Project(root));
    }

    @Test public void mixedEnginePackagesRunWithoutProjectConfiguration() throws Exception {
        Path root = project("pebble");
        Files.delete(root.resolve("config.yml"));
        write(root, "velocity/template.yml", descriptor("velocity", "main.vtl", "{name}.txt"));
        write(root, "velocity/main.vtl", "#parse('helper'):$artifactName");
        write(root, "velocity/helper.vtl", "velocity");
        write(root, "freemarker/template.yml", descriptor("freemarker", "main.ftl", "{name}.txt"));
        write(root, "freemarker/main.ftl", "<#include 'helper.ftl'>:${artifactName}");
        write(root, "freemarker/helper.ftl", "freemarker");
        write(root, "jinjava/template.yml", descriptor("jinjava", "main.jinja", "{name}.txt"));
        write(root, "jinjava/main.jinja", "jinjava:{{ artifactName }}");
        write(root, "pebble/template.yml", descriptor("pebble", "main.peb", "{name}.txt"));
        write(root, "pebble/main.peb", "pebble:{{ artifactName }}");
        var generator = generator(root);
        for (String name : List.of("velocity", "freemarker", "pebble", "jinjava", "velocity"))
            assertEquals(Map.of("example.txt", name + ":example"), generator.renderPackage("example", name));
        assertEquals("velocity:example", generator.transform("example").using("velocity/main.vtl").withParameter("artifactName", "example").render());
        var project = new Project(root);
        var metadata = new MetadataManager(project);
        var repl = new CommandExecutor(() -> metadata, TemplateEngineFacadeFactory.create(project));
        repl.execute(new Command("apply", List.of("freemarker", "to", "mapping", "example", "into", "out")));
        assertEquals("freemarker:example", Files.readString(root.resolve("out/example.txt")));
    }

    @Test public void packageEngineOverridesProjectDefaultAndInvalidEnginesFailOnUse() throws Exception {
        Path root = project("pebble");
        write(root, "pkg/template.yml", descriptor("velocity", "main.vtl", "{name}.txt"));
        write(root, "pkg/main.vtl", "$artifactName");
        write(root, "legacy.peb", "legacy:{{ value }}");
        var generator = generator(root);
        assertEquals(Map.of("example.txt", "example"), generator.renderPackage("example", "pkg"));
        assertEquals("legacy:ok", generator.transform("example").using("legacy").withParameter("value", "ok").render());
        for (String descriptor : List.of(descriptor("unknown", "main.vtl", "a.txt"), descriptor("main.vtl", "a.txt").replace("engine: velocity\n", ""))) {
            write(root, "pkg/template.yml", descriptor);
            assertThrows(IllegalArgumentException.class, () -> generator(root).renderPackage("example", "pkg"));
            // An invalid unused package does not prevent rendering legacy templates.
            assertEquals("legacy:ok", generator(root).transform("example").using("legacy").withParameter("value", "ok").render());
        }
    }
}
