package org.pecheasoft.odigen;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReplStartupTest {
    private record Result(int exitCode, String output) {}

    private Result launch(String... arguments) throws Exception {
        String executable = System.getProperty("os.name").startsWith("Windows") ? "java.exe" : "java";
        var command = new ArrayList<>(List.of(
                Path.of(System.getProperty("java.home"), "bin", executable).toString(),
                "-cp", System.getProperty("surefire.test.class.path", System.getProperty("java.class.path")),
                "org.pecheasoft.odigen.repl.Main"));
        command.addAll(Arrays.asList(arguments));
        Process process = new ProcessBuilder(command).redirectErrorStream(true).start();
        try {
            process.getOutputStream().close();
            assertTrue("Startup did not exit", process.waitFor(15, TimeUnit.SECONDS));
            return new Result(process.exitValue(), new String(process.getInputStream().readAllBytes(), StandardCharsets.UTF_8));
        } finally {
            if (process.isAlive()) process.destroyForcibly();
        }
    }

    @Test public void missingProjectPrintsUsageAndExitsWithError() throws Exception {
        var result = launch();
        assertEquals(result.output(), 2, result.exitCode());
        assertTrue(result.output(), result.output().contains("<project-directory>"));
        assertTrue(result.output(), result.output().contains("examples/airflow-bigquery-draft"));
        assertFalse(result.output(), result.output().contains("Exception"));
    }

    @Test public void blankAndExtraArgumentsAreRejectedBeforeStartingRepl() throws Exception {
        for (String[] arguments : List.of(new String[] {" "}, new String[] {"examples/ast-rendering", "extra"})) {
            var result = launch(arguments);
            assertEquals(result.output(), 2, result.exitCode());
            assertTrue(result.output(), result.output().contains("Usage:"));
        }
    }

    @Test public void helpDoesNotRequireAProjectOrStartRepl() throws Exception {
        for (String argument : List.of("--help", "-h")) {
            var result = launch(argument);
            assertEquals(result.output(), 0, result.exitCode());
            assertTrue(result.output(), result.output().contains("Usage:"));
            assertFalse(result.output(), result.output().contains("sqlm>"));
        }
    }
}
