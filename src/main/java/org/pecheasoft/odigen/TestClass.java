package org.pecheasoft.odigen;

import java.nio.file.Path;

import org.pecheasoft.odigen.metadata.MetadataManager;
import org.pecheasoft.odigen.project.Project;
import org.pecheasoft.odigen.render.CodeGeneratorService;
import org.pecheasoft.odigen.sql.api.ast.impl.InsertNode;

public class TestClass {
    public static void main(String[] args) {
        Path root = args.length > 0
                ? Path.of(args[0])
                : Path.of("project"); // default: current directory

        // 2. Build project snapshot
        Project project = new Project(root);

        // 3. Build metadata manager (with caching)
        MetadataManager metadata = new MetadataManager(project);

        CodeGeneratorService codegen = new CodeGeneratorService(project, metadata);
        InsertNode ast = (InsertNode) codegen.parse(metadata.findMapping("otp.analytic.mapping1").get());

        System.out.println(ast.toJson());

    }
}