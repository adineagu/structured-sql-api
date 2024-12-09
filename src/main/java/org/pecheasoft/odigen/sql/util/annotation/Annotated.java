/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pecheasoft.odigen.sql.util.annotation;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import org.pecheasoft.odigen.sql.util.TUtil;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 *
 * @author Adi Neagu
 */
@JsonInclude(Include.NON_NULL)
public interface Annotated {   
    
    Collection<Annotation> getAnnotations(); 

    void setAnnotations(Collection<Annotation> annotations);

    default boolean isAnnotatedWith(String annotationName) {
        if (TUtil.isNullOrEmpty(getAnnotations())) {
            return false;
        }
        return getAnnotations().stream().anyMatch((annotation) -> (annotation.getName().equalsIgnoreCase(annotationName)));
    }

    default Annotation getAnnotation(String annotationName) {
        if (TUtil.isNullOrEmpty(getAnnotations())) {
            return null;
        }
        return getAnnotations().stream().filter((annotation) -> (annotation.getName().equalsIgnoreCase(annotationName))).findAny().orElse(null);
    }

    default String getAnnotationsAsString() {
        return getAnnotationsString();     
    } 

    default String getAnnotationsString() {
        return TUtil.isNullOrEmpty(getAnnotations()) ? null :
                getAnnotations()
                    .stream()
                    .map(anno -> anno.toString())
                    .collect(Collectors.joining(" "));
    }
    
    default String getAnnotationParameterValue(String annotationName, String parameterName) {
        String paramValue = null;
        
        if (TUtil.isNullOrEmpty(getAnnotations())) {
            return null;
        }
        
        Optional<Annotation> annotation = getAnnotations().stream()
                .filter(anno -> annotationName.equalsIgnoreCase(anno.getName()))
                .findAny();
        
        if (annotation.isPresent()) {
            paramValue = annotation.get().getParameters().get(parameterName);
        }
        
        return paramValue;
    }
    
    @JsonIgnore
    default String getNameAnnotation() {
        String name = getAnnotationParameterValue("PROPERTIES", "NAME");
        if (!TUtil.isNullOrEmpty(name)) {
            return String.format("@properties(name=\"%s\")", name);
        } else {
            return "";
        }
    }
    
    @JsonIgnore
    default String getNameAnnotation(char delimiter) {
        return getNameAnnotation() + delimiter;
    }

    public Object clone() throws CloneNotSupportedException;
}
