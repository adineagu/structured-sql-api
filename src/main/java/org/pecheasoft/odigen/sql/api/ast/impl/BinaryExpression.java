package org.pecheasoft.odigen.sql.api.ast.impl;

import org.pecheasoft.odigen.sql.api.ast.IExpression;
import org.pecheasoft.odigen.sql.parse.algebra.OpType;
import org.pecheasoft.odigen.sql.util.annotation.impl.AnnotatedObject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 *
 * @author Adi Neagu
 */
@JsonInclude(Include.NON_NULL)
public class BinaryExpression extends AnnotatedObject implements IExpression {
    private Expression left;
    private Expression right;
    private OpType operator;

    @Override
    public String getText() {
        return left.getText() + operator + right.toString();
    }  

    @Override
    public String getName() {
        return null;
    }

}
