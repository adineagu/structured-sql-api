package org.pecheasoft.odigen.repl;

import org.jline.reader.Candidate;
import org.jline.reader.Completer;
import org.jline.reader.LineReader;
import org.jline.reader.ParsedLine;
import org.pecheasoft.odigen.metadata.MetadataManager;

import java.util.List;
import java.util.function.Supplier;

public final class CommandCompleter implements Completer {

    private final Supplier<MetadataManager> metadata;

    public CommandCompleter(Supplier<MetadataManager> metadata) {
        this.metadata = metadata;
    }

    @Override
    public void complete(LineReader reader, ParsedLine line, List<Candidate> candidates) {

        List<String> words = line.words();
        String buffer = line.word().toLowerCase();

        MetadataManager m = metadata.get();

        // No words typed → suggest commands
        if (words.isEmpty()) {
            suggest(candidates, buffer, List.of("help", "list", "show", "apply", "java", "clear", "exit", "quit"));
            return;
        }

        String cmd = words.get(0);

        switch (cmd) {

            case "help" -> {
                // help has no arguments
            }

            case "clear" -> {
                // clear has no arguments
            }

            case "list" -> {
                if (line.wordIndex() == 1) {
                    suggest(candidates, buffer, List.of("datastores", "mappings", "templates"));
                }
            }

            case "show" -> {
                if (line.wordIndex() == 1) {
                    suggest(candidates, buffer, List.of("datastore", "mapping", "template"));
                } else if (line.wordIndex() == 2) {
                    switch (words.get(1)) {
                        case "datastore" -> m.findAllDatastores("").forEach(o ->
                            candidates.add(new Candidate(o.id().qualifiedName())));
                        case "mapping" -> m.findAllMappings("").forEach(o ->
                            candidates.add(new Candidate(o.id().qualifiedName())));
                        case "template" -> m.findAllTemplates("").forEach(o ->
                            candidates.add(new Candidate(o.id().qualifiedName())));
                    }
                }
            }

            case "apply" -> {
                if (line.wordIndex() == 1) {
                    // apply → suggest template IDs
                    m.findAllTemplates("").forEach(o ->
                        candidates.add(new Candidate(o.id().qualifiedName())));
                } else if (line.wordIndex() == 2) {
                    // apply <template> → suggest "to"
                    suggest(candidates, buffer, List.of("to"));
                } else if (line.wordIndex() == 3 && words.get(2).equals("to")) {
                    // apply <template> to → suggest object types
                    suggest(candidates, buffer, List.of("datastore", "mapping"));
                } else if (line.wordIndex() == 5) {
                    suggest(candidates, buffer, List.of("into"));
                } else if (line.wordIndex() == 4) {
                    switch (words.get(3)) {
                        case "datastore" -> m.findAllDatastores("").forEach(o ->
                            candidates.add(new Candidate(o.id().qualifiedName())));
                        case "mapping" -> m.findAllMappings("").forEach(o ->
                            candidates.add(new Candidate(o.id().qualifiedName())));
                    }
                }
            }

            case "java" -> {
                // No suggestions for java command
            }
                        
            default -> {
                // Unknown command → suggest commands
                suggest(candidates, buffer, List.of("help", "list", "show", "apply", "java", "clear", "exit", "quit"));
            }
        }
    }

    private void suggest(List<Candidate> candidates, String buffer, List<String> options) {
        options.stream()
            .filter(o -> o.startsWith(buffer))
            .forEach(o -> candidates.add(new Candidate(o)));
    }

}
