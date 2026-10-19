import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import org.pecheasoft.odigen.metadata.MetadataManager;
import org.pecheasoft.odigen.project.Project;
import org.pecheasoft.odigen.render.CodeGeneratorService;

/** Standalone application-fixture verification; requires SQLMorph and dependencies. */
public class VerifyTraining {
    private static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }

    private static String normalized(String path, String text) {
        if (path.endsWith(".sql")) return text.replaceAll("\\s+", "");
        return text.lines().map(String::strip).filter(line -> !line.isEmpty())
                .collect(java.util.stream.Collectors.joining("\n"));
    }

    private static void rejects(Runnable action, String messageFragment) {
        try {
            action.run();
        } catch (RuntimeException error) {
            StringBuilder messages = new StringBuilder();
            for (Throwable cause = error; cause != null; cause = cause.getCause()) {
                messages.append(cause.getMessage()).append('\n');
            }
            check(messages.toString().contains(messageFragment), "Unexpected failure: " + messages);
            return;
        }
        throw new AssertionError("Expected rejection: " + messageFragment);
    }

    public static void main(String[] args) throws Exception {
        Path root = Path.of(args.length == 0 ? "docs/agents/training-project" : args[0]);
        var project = new Project(root);
        var codegen = new CodeGeneratorService(project, new MetadataManager(project));
        var actual = codegen.renderPackage("copy_employees", "append");
        check(actual.size() == 2, "Expected two artifacts");
        for (var artifact : actual.entrySet()) {
            String expected = Files.readString(root.resolve("expected").resolve(artifact.getKey()));
            check(normalized(artifact.getKey(), expected).equals(normalized(artifact.getKey(), artifact.getValue())),
                    "Output mismatch for " + artifact.getKey() + ":\n" + artifact.getValue());
            check(!artifact.getValue().contains("$"), "Unresolved Velocity reference");
        }
        check(actual.equals(codegen.renderPackage("copy_employees", "append")), "Non-deterministic rendering");

        String mapping = Files.readString(root.resolve("mappings/copy_employees.sql"));
        rejects(() -> codegen.transform("copy_employees").using("append/main.vtl")
                .withModel(codegen.parse(mapping.replace("APPEND", "MERGE"))).render(), "LOAD requires MODE=APPEND");
        rejects(() -> codegen.transform("copy_employees").using("append/main.vtl")
                .withModel(codegen.parse(mapping.replace("MODE=\"APPEND\"", "MODE=\"APPEND\", EXTRA=\"x\""))).render(),
                "LOAD requires MODE=APPEND");
        rejects(() -> codegen.parse(mapping.replace("prep.employees", "prep.missing")), "PREP.MISSING");
        rejects(() -> codegen.parse(mapping.replace("(EMPLOYEE_ID, SALARY)", "(EMPLOYEE_ID, MISSING_COLUMN)")),
                "MISSING_COLUMN");

        Path output = Files.createTempDirectory("sqlmorph-training-");
        codegen.generatePackage("copy_employees", "append", output);
        for (var artifact : actual.entrySet()) {
            check(Files.readString(output.resolve(artifact.getKey())).equals(artifact.getValue()), "Write mismatch");
        }
        Path failedOutput = output.resolve("failed-batch");
        var invalidBatch = new LinkedHashMap<String, String>();
        invalidBatch.put("first.sql", "append/main.vtl");
        invalidBatch.put("second.sql", "no_such_template");
        try {
            codegen.generate("copy_employees", invalidBatch, failedOutput);
            throw new AssertionError("Invalid batch should fail");
        } catch (IllegalArgumentException expected) {
            check(!Files.exists(failedOutput), "Rendering failure wrote output");
        }
        System.out.println("Training example verified: expected artifacts, repeatability, policy and metadata failures, writes, and batch failure.");
        System.out.println("Generated verification artifacts: " + output);
    }
}
