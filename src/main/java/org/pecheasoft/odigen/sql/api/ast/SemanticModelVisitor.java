/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pecheasoft.odigen.sql.api.ast;

import java.util.Stack;

import org.pecheasoft.odigen.sql.api.ast.impl.DatastoreReferenceNode;
import org.pecheasoft.odigen.sql.api.ast.impl.InsertNode;
import org.pecheasoft.odigen.sql.api.ast.impl.JoinNode;
import org.pecheasoft.odigen.sql.api.ast.impl.SelectItem;

/**
 *
 * @author Adi Neagu
 */
public interface SemanticModelVisitor<CONTEXT, RESULT> {
    RESULT visitInsertStatement(CONTEXT ctx, Stack<SemanticModel> stack, InsertNode expr);
    RESULT visitTargetAttribute(CONTEXT ctx, Stack<SemanticModel> stack, SemanticAssignment expr);
    RESULT visitSelectItem(CONTEXT ctx, Stack<SemanticModel> stack, SelectItem expr);
    RESULT visitQuery(CONTEXT ctx, Stack<SemanticModel> stack, SemanticSimpleQueryBlock expr);
    RESULT visitRelation(CONTEXT ctx, Stack<SemanticModel> stack, SemanticRelation expr);
    RESULT visitJoinTable(CONTEXT ctx, Stack<SemanticModel> stack, JoinNode expr);
    RESULT visitSubQuery(CONTEXT ctx, Stack<SemanticModel> stack, SemanticNestedQueryBlock expr);
    RESULT visitFilterSubQuery(CONTEXT ctx, Stack<SemanticModel> stack, SemanticNestedQueryFilter expr);
    RESULT visitDatastoreReference(CONTEXT ctx, Stack<SemanticModel> stack, DatastoreReferenceNode expr);
    RESULT visitExpression(CONTEXT ctx, Stack<SemanticModel> stack, SemanticExpression expr);
}
