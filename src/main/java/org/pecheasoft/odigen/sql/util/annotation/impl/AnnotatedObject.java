package org.pecheasoft.odigen.sql.util.annotation.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.pecheasoft.odigen.sql.util.annotation.Annotated;
import org.pecheasoft.odigen.sql.util.annotation.Annotation;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AnnotatedObject implements Annotated {

    //@JsonProperty("Annotations")
    @JsonIgnore
    private Collection<Annotation> annotations; 
    
    public AnnotatedObject(Collection<Annotation> annotations) {
        this.annotations = annotations;
    }

    public AnnotatedObject() {
    }

    @Override
    @JsonIgnore
    public Collection<Annotation> getAnnotations() {
        return annotations;
    }

    @Override
    public void setAnnotations(Collection<Annotation> annotations) {
        this.annotations = annotations;
    }

    @Override
    public String toString() {
        return "AnnotationsHolder{" + "annotations=" + annotations + '}';
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        AnnotatedObject anno = (AnnotatedObject) super.clone();
        anno.setAnnotations(new ArrayList<>(annotations));
        return anno;
    }

}
