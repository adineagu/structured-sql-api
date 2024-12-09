/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pecheasoft.odigen.sql.api.ast;

import java.util.Stack;

/**
 *
 * @author Adi Neagu
 */
public interface IASTObjectVisitor<CONTEXT, RESULT> {
    RESULT visitInsertStatement(CONTEXT ctx, Stack<IASTObject> stack, IInsertStatement expr);
    RESULT visitTargetAttribute(CONTEXT ctx, Stack<IASTObject> stack, ITargetAttribute expr);
    RESULT visitSelectItem(CONTEXT ctx, Stack<IASTObject> stack, ISelectItem expr);
    RESULT visitQuery(CONTEXT ctx, Stack<IASTObject> stack, IQuery expr);
    RESULT visitRelation(CONTEXT ctx, Stack<IASTObject> stack, IRelation expr);
    RESULT visitJoinTable(CONTEXT ctx, Stack<IASTObject> stack, IJoin expr);
    RESULT visitSubQuery(CONTEXT ctx, Stack<IASTObject> stack, ISubQuery expr);
    RESULT visitFilterSubQuery(CONTEXT ctx, Stack<IASTObject> stack, IFilterSubQuery expr);
    RESULT visitDatastoreReference(CONTEXT ctx, Stack<IASTObject> stack, IDatastoreReference expr);
    RESULT visitExpression(CONTEXT ctx, Stack<IASTObject> stack, IExpression expr);
}
