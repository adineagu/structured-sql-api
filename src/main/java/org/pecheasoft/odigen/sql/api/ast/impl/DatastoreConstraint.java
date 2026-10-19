package org.pecheasoft.odigen.sql.api.ast.impl;

import org.pecheasoft.odigen.sql.api.ast.SemanticAnnotationSet;
import org.pecheasoft.odigen.sql.api.ast.SemanticModel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 *
 * @author Adi Neagu
 */

@JsonInclude(Include.NON_NULL)
public class DatastoreConstraint implements SemanticModel {

    public enum ConstraintScope {
        ODI, DATABASE
    };

    public enum ConstraintType {
        KEY, REFERENCE, CHECK
    };

    public enum KeyConstraintType {
        UNIQUE, ALTERNATE, INDEX
    };

    private final String keyName;
    private final ConstraintType type;
    private final ConstraintScope scope;
    private final boolean flowControlEnabled;
    private final boolean staticControlEnabled;
    private final boolean definedInDatabase;
    private final String message;
    private final boolean active;
    private SemanticAnnotationSet annotations;

    public DatastoreConstraint(
            String keyName, ConstraintType keyType, 
            ConstraintScope scope, 
            Boolean controlFlowEnabled, Boolean controlStaticEnabled, 
            Boolean definedInDatabase, Boolean active, String message,
            SemanticAnnotationSet annotations
        ) {
        this.keyName = keyName;
        this.type = keyType;
        this.scope = scope;
        this.flowControlEnabled = controlFlowEnabled;
        this.staticControlEnabled = controlStaticEnabled;
        this.definedInDatabase = definedInDatabase;
        this.active = active;
        this.message = message;
        this.annotations = annotations;
    }

    public String getName() {
        return keyName;
    }

    public Boolean isFlowControlEnabled() {
        return flowControlEnabled;
    }

    public Boolean isStaticControlEnabled() {
        return staticControlEnabled;
    }

    public Boolean isDefinedInDatabase() {
        return definedInDatabase;
    }

    public Boolean isActive() {
        return active;
    }

    public ConstraintType getType() {
        return type;
    }

    public ConstraintScope getScope() {
        return scope;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public SemanticAnnotationSet annotations() {
        return annotations;
    }

    public void setAnnotations(SemanticAnnotationSet annotations) {
        this.annotations = annotations;
    }

}
