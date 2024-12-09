package org.pecheasoft.odigen.sql.api.ast.impl;

import org.pecheasoft.odigen.sql.api.ast.IDatastoreCondition;
import org.pecheasoft.odigen.sql.parse.algebra.ITableConstraint;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 *
 * @author Adi Neagu
 */

@JsonInclude(Include.NON_NULL)
public class DatastoreCondition extends DatastoreConstraint implements IDatastoreCondition {

    private final String conditionExpression;

    public DatastoreCondition(ITableConstraint key) {
        super(
                key.getConstraintName(),
                ConstraintType.CHECK,
                key.isDefinedInDatabase() ? ConstraintScope.DATABASE : ConstraintScope.ODI,
                key.isControlFlowEnabled(),
                key.isControlStaticEnabled(),
                key.isDefinedInDatabase(),
                key.isActive(),
                key.getMessage(),
                key.getAnnotations()
        );   
        this.conditionExpression = key.getConditionText();
    }

    @Override
    public String getCondition() {
        return conditionExpression;
    }

}
