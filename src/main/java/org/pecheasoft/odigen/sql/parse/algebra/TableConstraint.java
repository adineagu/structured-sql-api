/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pecheasoft.odigen.sql.parse.algebra;

/**
 *
 * @author Adi Neagu
 */
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)

public class TableConstraint extends Expr implements ITableConstraint {    
    private final String keyName;
    private final ConstraintScope scope;
    private final Boolean controlFlow;
    private final Boolean controlStatic;
    private final Boolean definedInDatabase;
    private final Boolean active;
    private final String description;

    public TableConstraint(String keyName, ConstraintScope scope, Boolean controlFlow, Boolean controlStatic, Boolean definedInDatabase, Boolean active, String description) {
        this.keyName = keyName;
        this.scope = scope;
        this.controlFlow = controlFlow;
        this.controlStatic = controlStatic;
        this.definedInDatabase = definedInDatabase;
        this.active = active;
        this.description = description;
    }

    @Override
    public String getConstraintName() {
        return keyName;
    }

    @Override
    public ConstraintType getConstraintType() {
        return ConstraintType.CHECK_CONSTRAINT;
    }

    @Override
    public ConstraintScope getScope() {
        return scope;
    }

    @Override
    public Boolean isControlFlowEnabled() {
        return controlFlow;
    }

    @Override
    public Boolean isControlStaticEnabled() {
        return controlStatic;
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
    public String getMessage() {
        return description;
    }
    
}
