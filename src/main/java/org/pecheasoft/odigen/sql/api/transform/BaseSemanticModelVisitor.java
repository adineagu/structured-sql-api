/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pecheasoft.odigen.sql.api.transform;

import java.util.Stack;
import java.util.List;
import org.pecheasoft.odigen.sql.api.ast.SemanticSetQueryBlock;
import org.pecheasoft.odigen.sql.api.ast.impl.MultiInsertTableNode;

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


/**
 *
 * @author Adi Neagu
 */
public class BaseSemanticModelVisitor<CONTEXT, RESULT> implements SemanticModelVisitor<CONTEXT, RESULT> {

    public RESULT visit(CONTEXT ctx, Stack<SemanticModel> stack, SemanticModel expr) {
        RESULT current;
        
        switch (expr) {
            case InsertNode node -> current = visitInsertStatement(ctx, stack, node);
            case SemanticNestedQueryBlock node -> current = visitSubQuery(ctx, stack, node);
            case SemanticSimpleQueryBlock node -> current = visitQuery(ctx, stack, node);
            case SemanticSetQueryBlock node -> current = visitSetQuery(ctx, stack, node);
            case JoinNode node -> current = visitJoinTable(ctx, stack, node);
            case DatastoreReferenceNode node -> current = visitDatastoreReference(ctx, stack, node);
            case SemanticNestedQueryFilter node -> current = visitFilterSubQuery(ctx, stack, node);
            case SemanticAssignment node -> current = visitTargetAttribute(ctx, stack, node);
            case SelectItem node -> current = visitSelectItem(ctx, stack, node);
            case MultiInsertTableNode node -> current = visitMultiInsertTarget(ctx, stack, node);
            case SemanticExpression node -> current = visitExpression(ctx, stack, node);
            case SemanticRelation node -> current = visitRelation(ctx, stack, node);
            default -> throw new RuntimeException(String.format("Object of type \"%s\" not handled yet!", expr.getClass().getSimpleName()));
        }
        
        return current;
    }
    
    @Override
    public RESULT visitInsertStatement(CONTEXT ctx, Stack<SemanticModel> stack, InsertNode expr) {
        stack.push(expr);
        try {
            if (expr.getTarget() != null) visit(ctx, stack, expr.getTarget());
            visitAll(ctx, stack, expr.getColumns());
            visitAll(ctx, stack, expr.getMultiInsertTargets());
            return expr.getQuery() == null ? null : visit(ctx, stack, expr.getQuery());
        } finally {
            stack.pop();
        }
    }

    @Override
    public RESULT visitTargetAttribute(CONTEXT ctx, Stack<SemanticModel> stack, SemanticAssignment expr) {
        // The linked SelectItem belongs to the query. Do not traverse the back-reference.
        return null;
    }

    @Override
    public RESULT visitSelectItem(CONTEXT ctx, Stack<SemanticModel> stack, SelectItem expr) {
        stack.push(expr);
        try {
            return expr.getExpression() == null ? null : visit(ctx, stack, expr.getExpression());
        } finally {
            stack.pop();
        }
    }

    @Override
    public RESULT visitQuery(CONTEXT ctx, Stack<SemanticModel> stack, SemanticSimpleQueryBlock expr) {
        stack.push(expr);
        try {
            visitAll(ctx, stack, expr.getWithList());
            visitAll(ctx, stack, expr.getSelectList());
            RESULT result = visitAll(ctx, stack, expr.getFromList());
            visitAll(ctx, stack, expr.getWhereList());
            visitAll(ctx, stack, expr.getGroupByList());
            visitAll(ctx, stack, expr.getHavingList());
            visitAll(ctx, stack, expr.getOrderByList());
            if (expr.getLimit() != null) visit(ctx, stack, expr.getLimit());
            return result;
        } finally {
            stack.pop();
        }
    }

    public RESULT visitSetQuery(CONTEXT ctx, Stack<SemanticModel> stack, SemanticSetQueryBlock expr) {
        stack.push(expr);
        try {
            RESULT result = null;
            for (SemanticSetQueryBlock.Dataset dataset : expr.getDatasets()) {
                result = visit(ctx, stack, dataset.getDataset());
            }
            return result;
        } finally {
            stack.pop();
        }
    }

    public RESULT visitMultiInsertTarget(CONTEXT ctx, Stack<SemanticModel> stack, MultiInsertTableNode expr) {
        stack.push(expr);
        try {
            if (expr.getTarget() != null) visit(ctx, stack, expr.getTarget());
            return visitAll(ctx, stack, expr.getSelectList());
        } finally {
            stack.pop();
        }
    }

    private RESULT visitAll(CONTEXT ctx, Stack<SemanticModel> stack, List<? extends SemanticModel> nodes) {
        RESULT result = null;
        if (nodes != null) {
            for (SemanticModel node : nodes) result = visit(ctx, stack, node);
        }
        return result;
    }

    @Override
    public RESULT visitRelation(CONTEXT ctx, Stack<SemanticModel> stack, SemanticRelation expr) {
        return null;
    }

    @Override
    public RESULT visitJoinTable(CONTEXT ctx, Stack<SemanticModel> stack, JoinNode expr) {
        RESULT result = null;
        stack.push(expr);
        try {
            if (expr.getLeftJoin() != null) result = visit(ctx, stack, expr.getLeftJoin());
            if (expr.getLeftQuery() != null) result = visit(ctx, stack, expr.getLeftQuery());
            if (expr.getLeftTable() != null) result = visit(ctx, stack, expr.getLeftTable());
            if (expr.getRightJoin() != null) result = visit(ctx, stack, expr.getRightJoin());
            if (expr.getRightQuery() != null) result = visit(ctx, stack, expr.getRightQuery());
            if (expr.getRightTable() != null) result = visit(ctx, stack, expr.getRightTable());
            if (expr.getJoinExpression() != null) visit(ctx, stack, expr.getJoinExpression());
            return result;
        } finally {
            stack.pop();
        }
    }

    @Override
    public RESULT visitSubQuery(CONTEXT ctx, Stack<SemanticModel> stack, SemanticNestedQueryBlock expr) {
        stack.push(expr);
        try {
            return visit(ctx, stack, expr.getQuery());
        } finally {
            stack.pop();
        }
    }

    @Override
    public RESULT visitFilterSubQuery(CONTEXT ctx, Stack<SemanticModel> stack, SemanticNestedQueryFilter expr) {
        stack.push(expr);
        try {
            return expr.getSubQuery() == null ? null : visit(ctx, stack, expr.getSubQuery());
        } finally {
            stack.pop();
        }
    }

    @Override
    public RESULT visitDatastoreReference(CONTEXT ctx, Stack<SemanticModel> stack, DatastoreReferenceNode expr) {
        return null;
    }

    @Override
    public RESULT visitExpression(CONTEXT ctx, Stack<SemanticModel> stack, SemanticExpression expr) {
        stack.push(expr);
        try {
            return visitAll(ctx, stack, expr.getTableReferences());
        } finally {
            stack.pop();
        }
    }

}
