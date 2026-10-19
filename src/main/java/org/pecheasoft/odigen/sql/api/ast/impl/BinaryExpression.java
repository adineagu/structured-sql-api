package org.pecheasoft.odigen.sql.api.ast.impl;

import org.pecheasoft.odigen.sql.api.ast.SemanticAnnotationSet;
import org.pecheasoft.odigen.sql.api.ast.SemanticExpression;
import org.pecheasoft.odigen.sql.parse.algebra.OpType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 *
 * @author Adi Neagu
 */
@JsonInclude(Include.NON_NULL)
public class BinaryExpression implements SemanticExpression {
    private Expression left;
    private Expression right;
    private OpType operator;
    private SemanticAnnotationSet annotations;

    @Override
    public String getText() {
        return left.getText() + operator + right.toString();
    } 

    @Override
    public SemanticAnnotationSet annotations() {
        return annotations;
    }
}
