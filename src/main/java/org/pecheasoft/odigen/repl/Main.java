package org.pecheasoft.odigen.repl;

import org.pecheasoft.odigen.project.Project;
import org.pecheasoft.odigen.metadata.MetadataManager;

import java.nio.file.Path;

public final class Main {

    public static void main(String[] args) {

        if (args.length == 1 && (args[0].equals("--help") || args[0].equals("-h"))) {
            usage(System.out);
            return;
        }
        if (args.length != 1 || args[0].isBlank()) {
            usage(System.err);
            System.exit(2);
            return;
        }
        Path root = Path.of(args[0]);

        // 2. Build project snapshot
        Project project = new Project(root);

        // 3. Build metadata manager (with caching)
        MetadataManager metadata = new MetadataManager(project);

        // 4. Start REPL
        new Repl(project, metadata).start();
    }

    private static void usage(java.io.PrintStream output) {
        output.println("Usage: java -jar sqlmorph.jar <project-directory>");
        output.println("Example: java -jar sqlmorph.jar examples/airflow-bigquery-draft");
        output.println("Maven: mvn compile exec:java \"-Dexec.args=examples/airflow-bigquery-draft\"");
    }
}
