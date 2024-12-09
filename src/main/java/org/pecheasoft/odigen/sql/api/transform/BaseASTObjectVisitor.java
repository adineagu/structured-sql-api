/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pecheasoft.odigen.sql.api.transform;

import java.util.Stack;

import org.pecheasoft.odigen.sql.api.ast.IASTObject;
import org.pecheasoft.odigen.sql.api.ast.IASTObjectVisitor;
import org.pecheasoft.odigen.sql.api.ast.IDatastoreReference;
import org.pecheasoft.odigen.sql.api.ast.IExpression;
import org.pecheasoft.odigen.sql.api.ast.IFilterSubQuery;
import org.pecheasoft.odigen.sql.api.ast.IInsertStatement;
import org.pecheasoft.odigen.sql.api.ast.IQuery;
import org.pecheasoft.odigen.sql.api.ast.IRelation;
import org.pecheasoft.odigen.sql.api.ast.ISelectItem;
import org.pecheasoft.odigen.sql.api.ast.ISubQuery;
import org.pecheasoft.odigen.sql.api.ast.ITargetAttribute;
import org.pecheasoft.odigen.sql.api.ast.impl.DatastoreReference;
import org.pecheasoft.odigen.sql.api.ast.impl.FilterSubQuery;
import org.pecheasoft.odigen.sql.api.ast.impl.InsertStatement;
import org.pecheasoft.odigen.sql.api.ast.impl.Join;
import org.pecheasoft.odigen.sql.api.ast.impl.Query;
import org.pecheasoft.odigen.sql.api.ast.impl.SubQuery;
import org.pecheasoft.odigen.sql.util.TUtil;
import org.pecheasoft.odigen.sql.api.ast.IJoin;


/**
 *
 * @author Adi Neagu
 */
public class BaseASTObjectVisitor<CONTEXT, RESULT> implements IASTObjectVisitor<CONTEXT, RESULT> {

    public RESULT visit(CONTEXT ctx, Stack<IASTObject> stack, IASTObject expr) {
        RESULT current;
        
        switch (expr.getClass().getSimpleName()) {
            case "InsertStatement" -> current = visitInsertStatement(ctx, stack, (InsertStatement) expr);
            case "Query" -> current = visitQuery(ctx, stack, (Query) expr);
            case "JoinTable" -> current = visitJoinTable(ctx, stack, (Join) expr);
            case "DatastoreReference" -> current = visitDatastoreReference(ctx, stack, (DatastoreReference) expr);
            case "SubQuery" -> current = visitSubQuery(ctx, stack, (SubQuery) expr);
            case "FilterSubQuery" -> current = visitFilterSubQuery(ctx, stack, (FilterSubQuery) expr);
            default -> throw new RuntimeException(String.format("Object of type \"%s\" not handled yet!", expr.getClass().getSimpleName()));
        }
        
        return current;
    }
    
    @Override
    public RESULT visitInsertStatement(CONTEXT ctx, Stack<IASTObject> stack, IInsertStatement expr) {
        stack.push(expr);
        RESULT result = visit(ctx, stack, expr.getQuery());
        stack.pop();
        
        return result;
    }

    @Override
    public RESULT visitTargetAttribute(CONTEXT ctx, Stack<IASTObject> stack, ITargetAttribute expr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RESULT visitSelectItem(CONTEXT ctx, Stack<IASTObject> stack, ISelectItem expr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RESULT visitQuery(CONTEXT ctx, Stack<IASTObject> stack, IQuery expr) {
        RESULT result = null;
        
        stack.push(expr);

        if (!TUtil.isNullOrEmpty(expr.getFromList())) {
            for (IASTObject relation : expr.getFromList()) {
                result = visit(ctx, stack, relation);
            }
        }
        stack.pop();
        
        return result;
    }

    @Override
    public RESULT visitRelation(CONTEXT ctx, Stack<IASTObject> stack, IRelation expr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RESULT visitJoinTable(CONTEXT ctx, Stack<IASTObject> stack, IJoin expr) {
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
    public RESULT visitSubQuery(CONTEXT ctx, Stack<IASTObject> stack, ISubQuery expr) {
        RESULT result;
        
        stack.push(expr);
        result = visit(ctx, stack, expr.getQuery());
        stack.pop();
        
        return result;
    }

    @Override
    public RESULT visitFilterSubQuery(CONTEXT ctx, Stack<IASTObject> stack, IFilterSubQuery expr) {
        RESULT result;
        
        stack.push(expr);
        result = visit(ctx, stack, expr.getSubQuery());
        stack.pop();
        
        return result;
    }

    @Override
    public RESULT visitDatastoreReference(CONTEXT ctx, Stack<IASTObject> stack, IDatastoreReference expr) {
        return null;
    }

    @Override
    public RESULT visitExpression(CONTEXT ctx, Stack<IASTObject> stack, IExpression expr) {
        return null;
    }

}
