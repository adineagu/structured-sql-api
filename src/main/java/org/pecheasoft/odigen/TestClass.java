package org.pecheasoft.odigen;

import java.nio.file.Path;

import org.pecheasoft.odigen.metadata.MetadataManager;
import org.pecheasoft.odigen.project.Project;
import org.pecheasoft.odigen.render.CodeGeneratorService;

public class TestClass {
    public static void main(String[] args) {
        if (args.length != 2 || args[0].isBlank() || args[1].isBlank()) {
            throw new IllegalArgumentException("Usage: TestClass <project-directory> <mapping-id>");
        }
        Path root = Path.of(args[0]);

        // 2. Build project snapshot
        Project project = new Project(root);

        // 3. Build metadata manager (with caching)
        MetadataManager metadata = new MetadataManager(project);

        CodeGeneratorService codegen = new CodeGeneratorService(project, metadata);
        var mapping = metadata.findMapping(args[1]).orElseThrow(
                () -> new IllegalArgumentException("Mapping not found: " + args[1]));
        var ast = codegen.parse(mapping);

        System.out.println(ast.toJson());

    }
}
