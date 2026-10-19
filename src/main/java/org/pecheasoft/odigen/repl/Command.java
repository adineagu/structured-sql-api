package org.pecheasoft.odigen.repl;

import java.util.List;

public record Command(String name, List<String> args) {}