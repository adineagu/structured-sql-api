package org.pecheasoft.odigen.sql.api.ast.impl;

import java.util.Collection;

import org.pecheasoft.odigen.sql.api.ast.IDatastoreConstraint;
import org.pecheasoft.odigen.sql.util.annotation.Annotation;
import org.pecheasoft.odigen.sql.util.annotation.impl.AnnotatedObject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 *
 * @author Adi Neagu
 */

@JsonInclude(Include.NON_NULL)
public class DatastoreConstraint extends AnnotatedObject implements IDatastoreConstraint {

    private final String keyName;
    private final ConstraintType type;
    private final ConstraintScope scope;
    private final boolean flowControlEnabled;
    private final boolean staticControlEnabled;
    private final boolean definedInDatabase;
    private final String message;
    private final boolean active;

    public DatastoreConstraint(
            String keyName, ConstraintType keyType, 
            ConstraintScope scope, 
            Boolean controlFlowEnabled, Boolean controlStaticEnabled, 
            Boolean definedInDatabase, Boolean active, String message,
            Collection<Annotation> annotations
        ) {
        this.keyName = keyName;
        this.type = keyType;
        this.scope = scope;
        this.flowControlEnabled = controlFlowEnabled;
        this.staticControlEnabled = controlStaticEnabled;
        this.definedInDatabase = definedInDatabase;
        this.active = active;
        this.message = message;
        setAnnotations(annotations);
    }

    @Override
    public String getName() {
        return keyName;
    }

    @Override
    public Boolean isFlowControlEnabled() {
        return flowControlEnabled;
    }

    @Override
    public Boolean isStaticControlEnabled() {
        return staticControlEnabled;
    }

    @Override
    public Boolean isDefinedInDatabase() {
        return definedInDatabase;
    }

    @Override
    public Boolean isActive() {
        return active;
    }

    @Override
    public ConstraintType getType() {
        return type;
    }

    @Override
    public ConstraintScope getScope() {
        return scope;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
