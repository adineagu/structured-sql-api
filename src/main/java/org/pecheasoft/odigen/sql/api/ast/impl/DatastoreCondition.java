package org.pecheasoft.odigen.sql.api.ast.impl;

import java.util.List;

import org.pecheasoft.odigen.sql.api.ast.SemanticAnnotationSet;
import org.pecheasoft.odigen.sql.parse.algebra.ITableConstraint;
import org.pecheasoft.odigen.sql.util.annotation.AnnotationTransformer;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 *
 * @author Adi Neagu
 */

@JsonInclude(Include.NON_NULL)
public class DatastoreCondition extends DatastoreConstraint {

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
                new SemanticAnnotationSet(
                    AnnotationTransformer.toSemanticList(key.getAnnotations() == null
                            ? List.of() : List.copyOf(key.getAnnotations()))
                )
        );   
        this.conditionExpression = key.getConditionText();
    }

    public String getCondition() {
        return conditionExpression;
    }

}
