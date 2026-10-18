package org.pecheasoft.odigen.sql.util.annotation;

import java.util.List;

import org.pecheasoft.odigen.sql.api.ast.SemanticAnnotation;

public final class AnnotationTransformer {

    private AnnotationTransformer() {}

    public static SemanticAnnotation toSemantic(Annotation a) {
        return new SemanticAnnotation(a.getName(), a.getParameters());
    }

    public static List<SemanticAnnotation> toSemanticList(List<? extends Annotation> list) {
        return list.stream()
                .map(AnnotationTransformer::toSemantic)
                .toList();
    }
}
