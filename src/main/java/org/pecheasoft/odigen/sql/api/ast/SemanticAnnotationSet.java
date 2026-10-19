package org.pecheasoft.odigen.sql.api.ast;

import java.util.List;

public final class SemanticAnnotationSet {

    private List<SemanticAnnotation> annotations;

    public SemanticAnnotationSet(List<SemanticAnnotation> annotations) {
        this.annotations = List.copyOf(annotations);
    }

    public List<SemanticAnnotation> all() {
        return annotations;
    }

    public boolean has(String name) {
        return annotations.stream().anyMatch(a -> a.name().equals(name));
    }

    public SemanticAnnotation get(String name) {
        return annotations.stream()
                .filter(a -> a.name().equals(name))
                .findFirst()
                .orElse(null);
    }

    public boolean isEmpty() {
        return annotations.isEmpty();
    }

    public void setAnnotations(List<SemanticAnnotation> annotations) {
        this.annotations = List.copyOf(annotations);
    }
}

