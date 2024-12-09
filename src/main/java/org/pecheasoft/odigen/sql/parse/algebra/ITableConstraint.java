/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pecheasoft.odigen.sql.parse.algebra;

import java.util.Collection;

import org.pecheasoft.odigen.sql.util.annotation.Annotated;


public interface ITableConstraint extends Annotated {

    public enum ConstraintScope {
        ODI, DATABASE
    };

    public enum ConstraintType {
        PRIMARY_KEY, ALTERNATE_KEY, FOREIGN_KEY, UNIQUE_INDEX, INDEX, CHECK_CONSTRAINT
    };

    String getConstraintName();

    ConstraintType getConstraintType();

    ConstraintScope getScope();

    Boolean isControlFlowEnabled();

    Boolean isControlStaticEnabled();

    Boolean isDefinedInDatabase();

    Boolean isActive();

    default Expr getCondition() {
        return null;
    }

    default String getConditionText() {
        return null;
    }

    default boolean isPrimaryKey() {
        return false;
    }

    default boolean isAlternateKey() {
        return false;
    }

    default boolean isReferenceKey() {
        return false;
    }

    default boolean isCheckConstraint() {
        return false;
    }

    default boolean isUniqueIndex() {
        return false;
    }

    default boolean isNonUniqueIndex() {
        return false;
    }

    default Collection<String> getKeyColumns() {
        return null;
    }

    String getMessage();
}
