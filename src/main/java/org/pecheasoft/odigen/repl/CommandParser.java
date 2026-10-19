package org.pecheasoft.odigen.repl;

import java.util.List;
import java.util.Optional;

public final class CommandParser {

    public Optional<Command> parse(String line) {
        if (line == null || line.isBlank()) {
            return Optional.empty();
        }

        String[] parts = line.trim().split("\\s+");
        String name = parts[0];
        List<String> args = List.of(parts).subList(1, parts.length);

        return Optional.of(new Command(name, args));
    }
}
