/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pecheasoft.odigen.sql.api.transform;

import java.util.Stack;

import org.pecheasoft.odigen.sql.api.ast.SemanticModel;
import org.pecheasoft.odigen.sql.api.ast.SemanticAssignment;
import org.pecheasoft.odigen.sql.api.ast.SemanticModelVisitor;
import org.pecheasoft.odigen.sql.api.ast.SemanticNestedQueryBlock;
import org.pecheasoft.odigen.sql.api.ast.SemanticNestedQueryFilter;
import org.pecheasoft.odigen.sql.api.ast.SemanticExpression;
import org.pecheasoft.odigen.sql.api.ast.SemanticSimpleQueryBlock;
import org.pecheasoft.odigen.sql.api.ast.SemanticRelation;
import org.pecheasoft.odigen.sql.api.ast.impl.DatastoreReferenceNode;
import org.pecheasoft.odigen.sql.api.ast.impl.InsertNode;
import org.pecheasoft.odigen.sql.api.ast.impl.JoinNode;
import org.pecheasoft.odigen.sql.api.ast.impl.SelectItem;
import org.pecheasoft.odigen.sql.util.TUtil;


/**
 *
 * @author Adi Neagu
 */
public class BaseSemanticModelVisitor<CONTEXT, RESULT> implements SemanticModelVisitor<CONTEXT, RESULT> {

    public RESULT visit(CONTEXT ctx, Stack<SemanticModel> stack, SemanticModel expr) {
        RESULT current;
        
        switch (expr.getClass().getSimpleName()) {
            case "InsertStatement" -> current = visitInsertStatement(ctx, stack, (InsertNode) expr);
            case "Query" -> current = visitQuery(ctx, stack, (SemanticSimpleQueryBlock) expr);
            case "JoinTable" -> current = visitJoinTable(ctx, stack, (JoinNode) expr);
            case "DatastoreReference" -> current = visitDatastoreReference(ctx, stack, (DatastoreReferenceNode) expr);
            case "SubQuery" -> current = visitSubQuery(ctx, stack, (SemanticNestedQueryBlock) expr);
            case "FilterSubQuery" -> current = visitFilterSubQuery(ctx, stack, (SemanticNestedQueryFilter) expr);
            default -> throw new RuntimeException(String.format("Object of type \"%s\" not handled yet!", expr.getClass().getSimpleName()));
        }
        
        return current;
    }
    
    @Override
    public RESULT visitInsertStatement(CONTEXT ctx, Stack<SemanticModel> stack, InsertNode expr) {
        stack.push(expr);
        RESULT result = visit(ctx, stack, expr.getQuery());
        stack.pop();
        
        return result;
    }

    @Override
    public RESULT visitTargetAttribute(CONTEXT ctx, Stack<SemanticModel> stack, SemanticAssignment expr) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public RESULT visitSelectItem(CONTEXT ctx, Stack<SemanticModel> stack, SelectItem expr) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public RESULT visitQuery(CONTEXT ctx, Stack<SemanticModel> stack, SemanticSimpleQueryBlock expr) {
        RESULT result = null;
        
        stack.push(expr);

        if (!TUtil.isNullOrEmpty(expr.getFromList())) {
            for (SemanticModel relation : expr.getFromList()) {
                result = visit(ctx, stack, relation);
            }
        }
        stack.pop();
        
        return result;
    }

    @Override
    public RESULT visitRelation(CONTEXT ctx, Stack<SemanticModel> stack, SemanticRelation expr) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public RESULT visitJoinTable(CONTEXT ctx, Stack<SemanticModel> stack, JoinNode expr) {
        RESULT result = null;
        
        stack.push(expr);
        
        if (expr.getLeftJoin() != null) {
            result = visit(ctx, stack, expr.getLeftJoin());
        }
        if (expr.getLeftQuery() != null) {
            result = visit(ctx, stack, expr.getLeftQuery());
        }
        if (expr.getLeftTable()!= null) {
            result = visit(ctx, stack, expr.getLeftTable());
        }
        
        if (expr.getRightJoin() != null) {
            result = visit(ctx, stack, expr.getRightJoin());
        }
        if (expr.getRightQuery() != null) {
            result = visit(ctx, stack, expr.getRightQuery());
        }
        if (expr.getRightTable()!= null) {
            result = visit(ctx, stack, expr.getRightTable());
        }
        
        stack.pop();
        
        return result;
    }

    @Override
    public RESULT visitSubQuery(CONTEXT ctx, Stack<SemanticModel> stack, SemanticNestedQueryBlock expr) {
        RESULT result;
        
        stack.push(expr);
        result = visit(ctx, stack, expr.getQuery());
        stack.pop();
        
        return result;
    }

    @Override
    public RESULT visitFilterSubQuery(CONTEXT ctx, Stack<SemanticModel> stack, SemanticNestedQueryFilter expr) {
        RESULT result;
        
        stack.push(expr);
        result = visit(ctx, stack, expr.getSubQuery());
        stack.pop();
        
        return result;
    }

    @Override
    public RESULT visitDatastoreReference(CONTEXT ctx, Stack<SemanticModel> stack, DatastoreReferenceNode expr) {
        return null;
    }

    @Override
    public RESULT visitExpression(CONTEXT ctx, Stack<SemanticModel> stack, SemanticExpression expr) {
        return null;
    }

}
