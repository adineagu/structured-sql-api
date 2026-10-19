package org.pecheasoft.odigen.repl;

import org.pecheasoft.odigen.project.Project;
import org.pecheasoft.odigen.metadata.MetadataManager;

import java.nio.file.Path;

public final class Main {

    public static void main(String[] args) {

        // 1. Determine project root
        Path root = args.length > 0
                ? Path.of(args[0])
                : Path.of("project"); // default: current directory

        // 2. Build project snapshot
        Project project = new Project(root);

        // 3. Build metadata manager (with caching)
        MetadataManager metadata = new MetadataManager(project);

        // 4. Start REPL
        new Repl(project, metadata).start();
    }
}
