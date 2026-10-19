import java.nio.file.Files;
import java.nio.file.Path;
import org.pecheasoft.odigen.project.Project;
import org.pecheasoft.odigen.metadata.MetadataManager;
import org.pecheasoft.odigen.render.CodeGeneratorService;

/** Application entry point: public generation API, no framework internals. */
public class GenerateOracle {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) throw new IllegalArgumentException("Usage: GenerateOracle.java <project> <output>");
        Path root = Path.of(args[0]);
        // Project discovery expects this directory even for datastore-only generation.
        Files.createDirectories(root.resolve("mappings"));
        var project = new Project(root);
        var metadata = new MetadataManager(project);
        var codegen = new CodeGeneratorService(project, metadata);
        for (var definition : metadata.findAllDatastores("")) codegen.parse(definition);
        var preview = codegen.renderPackage("source.employees", "oracle_validate");
        for (var artifact : preview.entrySet()) {
            String expected = Files.readString(root.resolve("expected").resolve(artifact.getKey()));
            // Preserve word boundaries and literals; only formatting whitespace differs here.
            String actualTokens = artifact.getValue().replaceAll("\\s+", " ").strip()
                    .replaceAll("\\s*,\\s*", ",");
            String expectedTokens = expected.replaceAll("\\s+", " ").strip()
                    .replaceAll("\\s*,\\s*", ",");
            if (!expectedTokens.equals(actualTokens)) {
                throw new AssertionError("Fixture mismatch for " + artifact.getKey() + ":\n" + artifact.getValue());
            }
            System.out.println(artifact.getKey() + "\n" + artifact.getValue());
        }
        codegen.generatePackage("source.employees", "oracle_validate", Path.of(args[1]));
        for (var artifact : preview.entrySet()) {
            if (!Files.readString(Path.of(args[1]).resolve(artifact.getKey())).equals(artifact.getValue())) {
                throw new AssertionError("Written output differs from preview: " + artifact.getKey());
            }
        }
        System.out.println("Oracle fixture generation and writes verified.");
    }
}
