package org.pecheasoft.odigen.repl;

import org.pecheasoft.odigen.project.Project;
import org.pecheasoft.odigen.render.CodeGeneratorService;
import org.pecheasoft.odigen.template.TemplateEngineFacade;
import org.pecheasoft.odigen.template.TemplateEngineFacadeFactory;

import org.pecheasoft.odigen.metadata.MetadataManager;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;

import jdk.jshell.JShell;
import jdk.jshell.SnippetEvent;
import jdk.jshell.SourceCodeAnalysis;
import jdk.jshell.SourceCodeAnalysis.CompletionInfo;

public final class Repl {

    private final Project project;
    private final MetadataManager metadata;
    private final LineReader reader;
    private final CommandParser parser;
    private final CommandExecutor executor;    

    private JShell jshell;
    ByteArrayOutputStream outBuffer = new ByteArrayOutputStream();
    ByteArrayOutputStream errBuffer = new ByteArrayOutputStream();

    private final PrintStream jshellOut = new PrintStream(outBuffer, true, StandardCharsets.UTF_8);
    private final PrintStream jshellErr = new PrintStream(errBuffer, true, StandardCharsets.UTF_8);   

    public Repl(Project project, MetadataManager metadata) {
        this.project = project;
        this.metadata = metadata;

        Host.metadata = this.metadata;
        Host.codegen = new CodeGeneratorService(project, metadata);

        this.reader = LineReaderBuilder.builder()
            .completer(new CommandCompleter(() -> metadata))
            .build();

        this.parser = new CommandParser();
        TemplateEngineFacade templateEngine = TemplateEngineFacadeFactory.create(project);            
        this.executor = new CommandExecutor(() -> metadata, templateEngine);

        initJShell();
    }

    
    public void start() {

        while (true) {
            String line = reader.readLine("sqlm> ").trim();

            final String outputFile;
            final boolean append;

            // detect >> (append)
            if (line.contains(">>")) {
                String[] parts = line.split(">>", 2);
                line = parts[0].trim();
                outputFile = normalizePath(parts[1].trim());
                append = true;
            }
            // detect > (overwrite)
            else if (line.contains(">")) {
                String[] parts = line.split(">", 2);
                line = parts[0].trim();
                outputFile = normalizePath(parts[1].trim());
                append = false;
            } else {
                outputFile = null;
                append = false;
            }

            if (line.equals("exit") || line.equals("quit")) {
                System.out.println("Bye.");
                break;
            }

            parser.parse(line).ifPresent(cmd -> {
                if (cmd.name().equals("java")) {
                    handleJava();
                    return;
                }

                String result = executor.execute(cmd);

                if (result == null || result.isBlank()) {
                    return;
                }

                if (outputFile == null) {
                    System.out.println(result);
                } else {
                    try (FileWriter fw = new FileWriter(outputFile, append)) {
                        fw.write(result);
                        fw.write(System.lineSeparator());
                    } catch (IOException e) {
                        System.out.println("Error writing to file: " + e.getMessage());
                    }
                }
            });
        }
    }

    private String normalizePath(String raw) {

        if (raw == null || raw.isBlank()) {
            return raw;
        }

        String path = raw.trim();

        // 1. Strip quotes: "C:\My Folder\out.sql"
        if ((path.startsWith("\"") && path.endsWith("\"")) ||
            (path.startsWith("'") && path.endsWith("'"))) {
            path = path.substring(1, path.length() - 1);
        }

        // 2. Expand tilde: ~/out.sql
        if (path.startsWith("~" + File.separator) || path.equals("~")) {
            String home = System.getProperty("user.home");
            if (path.equals("~")) {
                path = home;
            } else {
                path = home + path.substring(1);
            }
        }

        // 3. Windows backslashes: C:\temp\out.sql → C:\\temp\\out.sql
        // Only if user did NOT already escape them
        if (path.contains("\\") && !path.contains("\\\\")) {
            path = path.replace("\\", "\\\\");
        }

        // 4. Resolve relative paths against project root
        File f = new File(path);
        if (!f.isAbsolute()) {
            // projectRoot is whatever you use in your REPL
            path = new File(project.root().toString(), path).getAbsolutePath();
        }

        return path;
    }

    private void initJShell() {
 
        jshell = JShell.builder()
            .executionEngine("local")
            .out(jshellOut)
            .err(jshellErr)
            .build();

        String cp = System.getProperty("java.class.path");
        jshell.addToClasspath(cp);

        // imports
        jshell.eval("import java.util.*;");
        jshell.eval("import java.nio.file.*;");
        jshell.eval("import org.pecheasoft.odigen.*;");
        jshell.eval("import org.pecheasoft.odigen.repl.Host;");

        // inject metadata + codegen
        jshell.eval("var metadata = Host.metadata;");
        jshell.eval("var codegen = Host.codegen;");
    }

    private void handleJava() {
        System.out.println("Entering JShell mode. Type /exit to return.");

        StringBuilder buffer = new StringBuilder();
        int braceDepth = 0;

        while (true) {
            String prompt = buffer.isEmpty() ? "jshell> " : "   ...> ";
            String line = reader.readLine(prompt);

            if (line == null) return;

            if (line.equals("/exit")) {
                System.out.println("Leaving JShell mode.");
                break;
            }

            if (line.trim().isEmpty() && buffer.length() == 0) {
                continue; // do nothing, keep top-level prompt
            }

            buffer.append(line).append("\n");

            // Count braces
            braceDepth += count('{', line);
            braceDepth -= count('}', line);            
            boolean endsWithSemicolon = line.trim().endsWith(";");

            CompletionInfo analysis = jshell.sourceCodeAnalysis().analyzeCompletion(buffer.toString());
            SourceCodeAnalysis.Completeness completeness = analysis.completeness();

            boolean isComplete =
                braceDepth == 0 &&
                endsWithSemicolon &&
                completeness == SourceCodeAnalysis.Completeness.COMPLETE;

            if (isComplete) {
                evalSnippet(buffer.toString());
                buffer.setLength(0);
                braceDepth = 0;
            }

        }
    }

    private void evalSnippet(String code) {
        // Save originals
        PrintStream originalOut = System.out;
        PrintStream originalErr = System.err;

        try {
            // Redirect global System.out/err so evaluated code prints into our buffers
            System.setOut(jshellOut);
            System.setErr(jshellErr);

            // Evaluate
            List<SnippetEvent> events = jshell.eval(code);

            // Print snippet results and exceptions (JShell-level)
            for (SnippetEvent e : events) {
                if (e.exception() != null) {
                    // print stacktrace to host console
                    e.exception().printStackTrace(originalOut);
                } else if (e.value() != null) {
                    // snippet returned a value (e.g., expression)
                    originalOut.println(e.value());
                }
            }
        } finally {
            // Flush and restore System.out/err immediately
            System.out.flush();
            System.err.flush();
            System.setOut(originalOut);
            System.setErr(originalErr);
        }

        // Now print what the evaluated code wrote to stdout/stderr
        if (outBuffer.size() > 0) {
            System.out.print(outBuffer.toString(StandardCharsets.UTF_8));
            outBuffer.reset();
        }
        if (errBuffer.size() > 0) {
            System.err.print(errBuffer.toString(StandardCharsets.UTF_8));
            errBuffer.reset();
        }
    }

    private int count(char c, String s) {
        int n = 0;
        for (char x : s.toCharArray()) if (x == c) n++;
        return n;
    }

}
