/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pecheasoft.odigen.sql.api.ast;

/**
 *
 * @author User
 */
public interface IDatastoreConstraint extends IASTObject {

    public enum ConstraintScope {
        ODI, DATABASE
    };

    public enum ConstraintType {
        KEY, REFERENCE, CHECK
    };

    public enum KeyConstraintType {
        UNIQUE, ALTERNATE, INDEX
    };

    ConstraintType getType();

    ConstraintScope getScope();

    Boolean isFlowControlEnabled();

    Boolean isStaticControlEnabled();

    Boolean isDefinedInDatabase();

    Boolean isActive();

    default String getConditionText() {
        return null;
    }

    default Boolean isCheckConstraint() {
        return false;
    }

    String getMessage();

}
