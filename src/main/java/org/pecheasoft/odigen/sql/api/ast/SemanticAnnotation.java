package org.pecheasoft.odigen.sql.api.ast;

import java.util.Map;

public final class SemanticAnnotation {

    private final String name;
    private final Map<String, String> attributes;

    public SemanticAnnotation(String name, Map<String, String> attributes) {
        this.name = name;
        this.attributes = Map.copyOf(attributes);
    }

    public String name() {
        return name;
    }

    public Map<String, String> attributes() {
        return attributes;
    }

    public String attribute(String key) {
        return attributes.get(key);
    }
}
