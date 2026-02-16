/* 
 * Copyright 2017 DWH Tools.
 *
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://odieasy.com/11-licenses/eula
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.pecheasoft.odigen.sql.parse.algebra;

import java.util.Stack;

public class BaseAlgebraVisitor<CONTEXT, RESULT> implements AlgebraVisitor<CONTEXT, RESULT> {

    /**
     * The prehook is called before each expression is visited.
     * @throws org.apache.tajo.plan.PlanningException
     */
    public void preHook(CONTEXT ctx, Stack<Expr> stack, Expr expr) {
    }

    /**
     * The posthook is called before each expression is visited.
     */
    public RESULT postHook(CONTEXT ctx, Stack<Expr> stack, Expr expr, RESULT current) {
        return current;
    }

    /**
     * visit visits each relational operator expression recursively.
     *
     * @param stack The stack contains the upper operators' type.
     * @param expr The visiting relational operator
     */
    public RESULT visit(CONTEXT ctx, Stack<Expr> stack, Expr expr) {
        preHook(ctx, stack, expr);
        
        RESULT current = switch (expr) {
            case null -> throw new RuntimeException("Object cannot be null!");
            case Aggregation e -> visitGroupBy(ctx, stack, e);
            case SetSession e -> visitSetSession(ctx, stack, e);
            case Query e -> visitQuery(ctx, stack, e);
            case Projection e -> visitProjection(ctx, stack, e);
            case Limit e -> visitLimit(ctx, stack, e);
            case Sort e -> visitSort(ctx, stack, e);
            case Having e -> visitHaving(ctx, stack, e);
            case Unpivot e -> visitUnpivot(ctx, stack, e);
            case Join e -> visitJoin(ctx, stack, e);
            case Selection e -> visitFilter(ctx, stack, e);
            case SetOperation e -> visitSetOperation(ctx, stack, e);
            case TableFunction e -> visitTableFunction(ctx, stack, e);
            case SimpleTableSubQuery e -> visitSimpleTableSubQuery(ctx, stack, e);
            case TablePrimarySubQuery e -> visitTableSubQuery(ctx, stack, e);
            case RelationList e -> visitRelationList(ctx, stack, e);
            case Relation e -> visitRelation(ctx, stack, e);
            case ScalarSubQuery e -> visitScalarSubQuery(ctx, stack, e);
            case Explain e -> visitExplain(ctx, stack, e);
            case CreateDatabase e -> visitCreateDatabase(ctx, stack, e);
            case DropDatabase e -> visitDropDatabase(ctx, stack, e);
            case CreateTable e -> visitCreateTable(ctx, stack, e);
            case DropTable e -> visitDropTable(ctx, stack, e);
            case AlterTablespace e -> visitAlterTablespace(ctx, stack, e);
            case AlterTable e -> visitAlterTable(ctx, stack, e);
            case TruncateTable e -> visitTruncateTable(ctx, stack, e);
            case Insert e -> visitInsert(ctx, stack, e);
            case PatternMatchPredicate e -> visitPatternMatchPredicate(ctx, stack, e);
            case InPredicate e -> visitInPredicate(ctx, stack, e);
            case QuantifiedComparisonPredicate e -> visitQuantifiedComparisonPredicate(ctx, stack, e);
            case BinaryOperator e -> visitBinaryOperator(ctx, stack, e);
            case NotExpr e -> visitNot(ctx, stack, e);
            case BetweenPredicate e -> visitBetween(ctx, stack, e);
            case CaseWhenPredicate e -> visitCaseWhen(ctx, stack, e);
            case NullifExpr e -> visitNullif(ctx, stack, (NullifExpr) expr);
            case CoalesceExpr e -> visitCoalesce(ctx, stack, e);
            case IsNullPredicate e -> visitIsNullPredicate(ctx, stack, e);
            case ValueListExpr e -> visitValueListExpr(ctx, stack, e);
            case ExistsPredicate e -> visitExistsPredicate(ctx, stack, e);
            case SignedExpr e -> visitSign(ctx, stack, e);
            case ColumnReferenceExpr e -> visitColumnReference(ctx, stack, e);
            case NamedExpr e -> visitTargetExpr(ctx, stack, e);
            case QualifiedAsteriskExpr e -> visitQualifiedAsterisk(ctx, stack, e);
            case CountRowsFunctionExpr e -> visitCountRowsFunction(ctx, stack, e);
            case GeneralSetFunctionExpr e -> visitGeneralSetFunction(ctx, stack, e);
            case FunctionExpr e -> visitFunction(ctx, stack, e);
            case DataTypeExpr e -> visitDataType(ctx, stack, e);
            case CastExpr e -> visitCastExpr(ctx, stack, e);
            case LiteralValue e -> visitLiteral(ctx, stack, e);
            case NullLiteral e -> visitNullLiteral(ctx, stack, e);
            case DateLiteral e -> visitDateLiteral(ctx, stack, e);
            case TimeLiteral e -> visitTimeLiteral(ctx, stack, e);
            case TimestampLiteral e -> visitTimestampLiteral(ctx, stack, e);
            case IntervalLiteral e -> visitIntervalLiteral(ctx, stack, e);
            case UnparseableString e -> visitUnparseableString(ctx, stack, e);
            case MultiInsert e -> visitMultiInsert(ctx, stack, e);
            case RowPredicandList e -> visitRowPredicandList(ctx, stack, e);
            default -> throw new RuntimeException("Cannot support this type algebra \"" + expr.getClassName() + "\"" + " for class \"" + expr.getClassName() + "\"");
        };

        // skip postHook against only one relation
        if (expr instanceof RelationList) {
            RelationList relationList = (RelationList) expr;
            if (relationList.size() == 1 && relationList.getRelations()[0] instanceof Relation) {
                return current;
            }
        }

        postHook(ctx, stack, expr, current);
        return current;
    }

    private RESULT visitDefaultUnaryExpr(CONTEXT ctx, Stack<Expr> stack, UnaryOperator expr) {
        stack.push(expr);
        RESULT child = visit(ctx, stack, expr.getChild());
        stack.pop();
        return child;
    }

    private RESULT visitDefaultBinaryExpr(CONTEXT ctx, Stack<Expr> stack, BinaryOperator expr)
            {
        stack.push(expr);
        RESULT child = visit(ctx, stack, expr.getLeft());
        visit(ctx, stack, expr.getRight());
        stack.pop();
        return child;
    }

    private RESULT visitDefaultMultiaryExpr(CONTEXT ctx, Stack<Expr> stack, MultiaryOperator expr)
            {

        RESULT child = null;
        stack.push(expr);
        for (Expr operand : expr.getOperands()) {
            child = visit(ctx, stack, operand);
        }
        stack.pop();
        return child;
    }

    @Override
    public RESULT visitSetSession(CONTEXT ctx, Stack<Expr> stack, SetSession expr) {
        return null;
    }

    @Override
    public RESULT visitQuery(CONTEXT ctx, Stack<Expr> stack, Query expr) {
        return visitDefaultUnaryExpr(ctx, stack, expr);
    }

    @Override
    public RESULT visitProjection(CONTEXT ctx, Stack<Expr> stack, Projection expr)  {
        stack.push(expr);

        for (NamedExpr target : expr.getNamedExprs()) {
            if (target == null) {
                throw new RuntimeException("Projection cannot have a null named expression: " + expr);
            }
            visit(ctx, stack, target);
        }
        if (expr.hasChild()) {
            return visit(ctx, stack, expr.getChild());
        }

        stack.pop();

        return null;
    }

    @Override
    public RESULT visitLimit(CONTEXT ctx, Stack<Expr> stack, Limit expr) {
        stack.push(expr);
        visit(ctx, stack, expr.getFetchFirstNum());
        RESULT result = visit(ctx, stack, expr.getChild());
        stack.pop();
        return result;
    }

    @Override
    public RESULT visitSort(CONTEXT ctx, Stack<Expr> stack, Sort expr) {
        RESULT result = null;
        
        stack.push(expr);
        for (Sort.SortSpec sortSpec : expr.getSortSpecs()) {
            result = visit(ctx, stack, sortSpec.getKey());
        }
        if (expr.getChild() != null) {
            result = visit(ctx, stack, expr.getChild());
        }
        return result;
    }

    @Override
    public RESULT visitHaving(CONTEXT ctx, Stack<Expr> stack, Having expr) {
        stack.push(expr);
        visit(ctx, stack, expr.getQual());
        RESULT result = visit(ctx, stack, expr.getChild());
        stack.pop();
        return result;
    }

    @Override
    public RESULT visitGroupBy(CONTEXT ctx, Stack<Expr> stack, Aggregation expr) {
        stack.push(expr);

        for (Aggregation.GroupElement groupElement : expr.getGroupSet()) {
            for (Expr groupingSet : groupElement.getGroupingSets()) {
                visit(ctx, stack, groupingSet);
            }
        }

        RESULT result = visit(ctx, stack, expr.getChild());
        stack.pop();
        return result;
    }
    
    @Override
    public RESULT visitUnpivot(CONTEXT ctx, Stack<Expr> stack, Unpivot expr) {
        stack.push(expr);
        RESULT result = visit(ctx, stack, expr.getChild());
        stack.pop();
        return result;
    }
    
    @Override
    public RESULT visitJoin(CONTEXT ctx, Stack<Expr> stack, Join expr) {
        stack.push(expr);
        if (expr.getQual() != null) {
            visit(ctx, stack, expr.getQual());
        }
        RESULT result;
        result = visit(ctx, stack, expr.getLeft());
        if (expr.getRight() != null) {
            result = visit(ctx, stack, expr.getRight());
        }        
        stack.pop();
        return result;
    }
    
    @Override
    public RESULT visitFilter(CONTEXT ctx, Stack<Expr> stack, Selection expr) {
        stack.push(expr);
        visit(ctx, stack, expr.getQual());
        RESULT result = visit(ctx, stack, expr.getChild());
        stack.pop();
        return result;
    }

    @Override
    public RESULT visitSelection(CONTEXT ctx, Stack<Expr> stack, Selection expr) {
        return visitFilter(ctx, stack, expr);
    }

    @Override
    public RESULT visitSetOperation(CONTEXT ctx, Stack<Expr> stack, SetOperation expr) {
        return switch (expr.getOperationType()) {
            case SetOperation.Type.UNION -> visitUnion(ctx, stack, expr);
            case SetOperation.Type.INTERSECT -> visitIntersect(ctx, stack, expr);
            case SetOperation.Type.EXCEPT -> visitExcept(ctx, stack, expr);
        };
    }

    @Override
    public RESULT visitUnion(CONTEXT ctx, Stack<Expr> stack, SetOperation expr) {
        return visitDefaultMultiaryExpr(ctx, stack, expr);
    }

    @Override
    public RESULT visitExcept(CONTEXT ctx, Stack<Expr> stack, SetOperation expr) {
        return visitDefaultMultiaryExpr(ctx, stack, expr);
    }

    @Override
    public RESULT visitIntersect(CONTEXT ctx, Stack<Expr> stack, SetOperation expr) {
        return visitDefaultMultiaryExpr(ctx, stack, expr);
    }

    @Override
    public RESULT visitTableFunction(CONTEXT ctx, Stack<Expr> stack, TableFunction expr) {
        stack.push(expr);
        RESULT child = visit(ctx, stack, expr.getFunction());
        stack.pop();
        return child;
    }
    
    @Override
    public RESULT visitSimpleTableSubQuery(CONTEXT ctx, Stack<Expr> stack, SimpleTableSubQuery expr)
            {
        return visitDefaultUnaryExpr(ctx, stack, expr);
    }

    @Override
    public RESULT visitTableSubQuery(CONTEXT ctx, Stack<Expr> stack, TablePrimarySubQuery expr)
            {
        stack.push(expr);
        RESULT child = visit(ctx, stack, expr.getSubQuery());
        stack.pop();
        return child;
    }

    @Override
    public RESULT visitRelationList(CONTEXT ctx, Stack<Expr> stack, RelationList expr) {
        stack.push(expr);
        RESULT child = null;
        for (Expr e : expr.getRelations()) {
            child = visit(ctx, stack, e);
        }
        stack.pop();
        return child;
    }

    @Override
    public RESULT visitRelation(CONTEXT ctx, Stack<Expr> stack, Relation expr) {
        return null;
    }

    @Override
    public RESULT visitScalarSubQuery(CONTEXT ctx, Stack<Expr> stack, ScalarSubQuery expr) {
        return visitDefaultUnaryExpr(ctx, stack, expr);
    }

    @Override
    public RESULT visitExplain(CONTEXT ctx, Stack<Expr> stack, Explain expr) {
        stack.push(expr);
        RESULT child = visit(ctx, stack, expr.getChild());
        stack.pop();
        return child;
    }

    @Override
    public RESULT visitCreateDatabase(CONTEXT ctx, Stack<Expr> stack, CreateDatabase expr) {
        return null;
    }

    @Override
    public RESULT visitDropDatabase(CONTEXT ctx, Stack<Expr> stack, DropDatabase expr) {
        return null;
    }

    @Override
    public RESULT visitCreateTable(CONTEXT ctx, Stack<Expr> stack, CreateTable expr) {
        stack.push(expr);
        RESULT child = null;
        if (expr.hasSubQuery()) {
            child = visit(ctx, stack, expr.getSubQuery());
        }
        stack.pop();
        return child;
    }

    @Override
    public RESULT visitDropTable(CONTEXT ctx, Stack<Expr> stack, DropTable expr) {
        return null;
    }

    @Override
    public RESULT visitAlterTablespace(CONTEXT ctx, Stack<Expr> stack, AlterTablespace expr) {
        return null;
    }

    @Override
    public RESULT visitAlterTable(CONTEXT ctx, Stack<Expr> stack, AlterTable expr) {
        return null;
    }

    @Override
    public RESULT visitTruncateTable(CONTEXT ctx, Stack<Expr> stack, TruncateTable expr) {
        return null;
    }

    @Override
    public RESULT visitInsert(CONTEXT ctx, Stack<Expr> stack, Insert expr) {
        stack.push(expr);
        RESULT child = visit(ctx, stack, expr.getSubQuery());
        stack.pop();
        return child;
    }

    @Override
    public RESULT visitBinaryOperator(CONTEXT ctx, Stack<Expr> stack, BinaryOperator expr) {
        return switch (expr.getOperator()) {
            case BinaryOperator.Operator.And -> visitAnd(ctx, stack, expr);
            case BinaryOperator.Operator.Or -> visitOr(ctx, stack, expr);
                
            case BinaryOperator.Operator.Plus -> visitPlus(ctx, stack, expr);
            case BinaryOperator.Operator.Minus -> visitMinus(ctx, stack, expr);
            case BinaryOperator.Operator.Multiply -> visitMultiply(ctx, stack, expr);
            case BinaryOperator.Operator.Divide -> visitDivide(ctx, stack, expr);
                
            case BinaryOperator.Operator.GreaterThan -> visitGreaterThan(ctx, stack, expr);
            case BinaryOperator.Operator.GreaterThanOrEquals -> visitGreaterThanOrEquals(ctx, stack, expr);
            case BinaryOperator.Operator.LessThan -> visitLessThan(ctx, stack, expr);
            case BinaryOperator.Operator.LessThanOrEquals -> visitLessThanOrEquals(ctx, stack, expr);
                
            case BinaryOperator.Operator.Equals -> visitEquals(ctx, stack, expr);
            case BinaryOperator.Operator.NotEquals -> visitNotEquals(ctx, stack, expr);
                
            case BinaryOperator.Operator.Concatenate -> visitConcatenate(ctx, stack, expr);
            case BinaryOperator.Operator.Modular -> visitModular(ctx, stack, expr);
                
            default -> throw new RuntimeException("SQL operator type \"" + expr.getOperator() + "\" shoould be handled on dedicated routine!");
        };
    }

    @Override
    public RESULT visitAnd(CONTEXT ctx, Stack<Expr> stack, BinaryOperator expr) {
        return visitDefaultBinaryExpr(ctx, stack, expr);
    }

    @Override
    public RESULT visitOr(CONTEXT ctx, Stack<Expr> stack, BinaryOperator expr) {
        return visitDefaultBinaryExpr(ctx, stack, expr);
    }

    @Override
    public RESULT visitNot(CONTEXT ctx, Stack<Expr> stack, NotExpr expr) {
        return visitDefaultUnaryExpr(ctx, stack, expr);
    }

    @Override
    public RESULT visitEquals(CONTEXT ctx, Stack<Expr> stack, BinaryOperator expr) {
        return visitDefaultBinaryExpr(ctx, stack, expr);
    }

    @Override
    public RESULT visitNotEquals(CONTEXT ctx, Stack<Expr> stack, BinaryOperator expr) {
        return visitDefaultBinaryExpr(ctx, stack, expr);
    }

    @Override
    public RESULT visitLessThan(CONTEXT ctx, Stack<Expr> stack, BinaryOperator expr) {
        return visitDefaultBinaryExpr(ctx, stack, expr);
    }

    @Override
    public RESULT visitLessThanOrEquals(CONTEXT ctx, Stack<Expr> stack, BinaryOperator expr) {
        return visitDefaultBinaryExpr(ctx, stack, expr);
    }

    @Override
    public RESULT visitGreaterThan(CONTEXT ctx, Stack<Expr> stack, BinaryOperator expr) {
        return visitDefaultBinaryExpr(ctx, stack, expr);
    }

    @Override
    public RESULT visitGreaterThanOrEquals(CONTEXT ctx, Stack<Expr> stack, BinaryOperator expr)
            {
        return visitDefaultBinaryExpr(ctx, stack, expr);
    }

    @Override
    public RESULT visitBetween(CONTEXT ctx, Stack<Expr> stack, BetweenPredicate expr) {
        stack.push(expr);
        RESULT result = visit(ctx, stack, expr.model().predicand());
        visit(ctx, stack, expr.model().begin());
        visit(ctx, stack, expr.model().end());
        stack.pop();
        return result;
    }

    @Override
    public RESULT visitCaseWhen(CONTEXT ctx, Stack<Expr> stack, CaseWhenPredicate expr) {
        stack.push(expr);
        RESULT result = null;
        for (CaseWhenPredicate.WhenExpr when : expr.getWhens()) {
            result = visit(ctx, stack, when.getCondition());
            visit(ctx, stack, when.getResult());
        }
        if (expr.hasElseResult()) {
            visit(ctx, stack, expr.getElseResult());
        }
        stack.pop();
        return result;
    }

    @Override
    public RESULT visitIsNullPredicate(CONTEXT ctx, Stack<Expr> stack, IsNullPredicate expr) {
        return visitDefaultUnaryExpr(ctx, stack, expr);
    }

    @Override
    public RESULT visitInPredicate(CONTEXT ctx, Stack<Expr> stack, InPredicate expr) {
        return visitDefaultBinaryExpr(ctx, stack, expr);
    }

    @Override
    public RESULT visitQuantifiedComparisonPredicate(CONTEXT ctx, Stack<Expr> stack, QuantifiedComparisonPredicate expr) {
        return visitDefaultBinaryExpr(ctx, stack, expr);
    }

    @Override
    public RESULT visitValueListExpr(CONTEXT ctx, Stack<Expr> stack, ValueListExpr expr) {
        stack.push(expr);
        RESULT result = null;
        for (Expr value : expr.getValues()) {
            result = visit(ctx, stack, value);
        }
        stack.pop();
        return result;
    }

    @Override
    public RESULT visitExistsPredicate(CONTEXT ctx, Stack<Expr> stack, ExistsPredicate expr) {
        return visitDefaultUnaryExpr(ctx, stack, expr);
    }

    @Override
    public RESULT visitPatternMatchPredicate(CONTEXT ctx, Stack<Expr> stack, PatternMatchPredicate expr) {
        return switch (expr.getMatchType()) {
            case PatternMatchPredicate.MatchType.LikePredicate -> visitLikePredicate(ctx, stack, expr);
            case PatternMatchPredicate.MatchType.SimilarToPredicate -> visitSimilarToPredicate(ctx, stack, expr);
            case PatternMatchPredicate.MatchType.Regexp -> visitRegexpPredicate(ctx, stack, expr);
        };
    }

    @Override
    public RESULT visitLikePredicate(CONTEXT ctx, Stack<Expr> stack, PatternMatchPredicate expr)
            {
        return visitDefaultBinaryExpr(ctx, stack, expr);
    }

    @Override
    public RESULT visitSimilarToPredicate(CONTEXT ctx, Stack<Expr> stack, PatternMatchPredicate expr)
            {
        return visitDefaultBinaryExpr(ctx, stack, expr);
    }

    @Override
    public RESULT visitRegexpPredicate(CONTEXT ctx, Stack<Expr> stack, PatternMatchPredicate expr)
            {
        return visitDefaultBinaryExpr(ctx, stack, expr);
    }

    @Override
    public RESULT visitConcatenate(CONTEXT ctx, Stack<Expr> stack, BinaryOperator expr) {
        return visitDefaultBinaryExpr(ctx, stack, expr);
    }

    @Override
    public RESULT visitPlus(CONTEXT ctx, Stack<Expr> stack, BinaryOperator expr) {
        return visitDefaultBinaryExpr(ctx, stack, expr);
    }

    @Override
    public RESULT visitMinus(CONTEXT ctx, Stack<Expr> stack, BinaryOperator expr) {
        return visitDefaultBinaryExpr(ctx, stack, expr);
    }

    @Override
    public RESULT visitMultiply(CONTEXT ctx, Stack<Expr> stack, BinaryOperator expr) {
        return visitDefaultBinaryExpr(ctx, stack, expr);
    }

    @Override
    public RESULT visitDivide(CONTEXT ctx, Stack<Expr> stack, BinaryOperator expr) {
        return visitDefaultBinaryExpr(ctx, stack, expr);
    }

    @Override
    public RESULT visitModular(CONTEXT ctx, Stack<Expr> stack, BinaryOperator expr) {
        return visitDefaultBinaryExpr(ctx, stack, expr);
    }

    @Override
    public RESULT visitSign(CONTEXT ctx, Stack<Expr> stack, SignedExpr expr) {
        return visitDefaultUnaryExpr(ctx, stack, expr);
    }

    @Override
    public RESULT visitColumnReference(CONTEXT ctx, Stack<Expr> stack, ColumnReferenceExpr expr)
            {
        return null;
    }

    @Override
    public RESULT visitTargetExpr(CONTEXT ctx, Stack<Expr> stack, NamedExpr expr) {
        return visitDefaultUnaryExpr(ctx, stack, expr);
    }

    @Override
    public RESULT visitFunction(CONTEXT ctx, Stack<Expr> stack, FunctionExpr expr) {
        stack.push(expr);
        RESULT result = null;
        if (expr.hasParams()) {
            for (Expr param : expr.getParams()) {
                result = visit(ctx, stack, param);
            }
        }
        stack.pop();
        return result;
    }

    @Override
    public RESULT visitQualifiedAsterisk(CONTEXT ctx, Stack<Expr> stack, QualifiedAsteriskExpr expr) {
        return null;
    }

    @Override
    public RESULT visitCountRowsFunction(CONTEXT ctx, Stack<Expr> stack, CountRowsFunctionExpr expr)
            {
        return null;
    }

    @Override
    public RESULT visitGeneralSetFunction(CONTEXT ctx, Stack<Expr> stack, GeneralSetFunctionExpr expr)
            {
        stack.push(expr);
        RESULT result = null;
        for (Expr param : expr.getParams()) {
            result = visit(ctx, stack, param);
        }
        stack.pop();
        return result;
    }

    @Override
    public RESULT visitWindowFunction(CONTEXT ctx, Stack<Expr> stack, WindowFunctionExpr expr) {
        stack.push(expr);
        RESULT result = null;
        for (Expr param : expr.getParams()) {
            result = visit(ctx, stack, param);
        }

        WindowSpec windowSpec = expr.getWindowSpec();

        if (windowSpec.hasPartitionBy()) {
            for (Expr partitionKey : windowSpec.getPartitionKeys()) {
                visit(ctx, stack, partitionKey);
            }
        }
        if (windowSpec.hasOrderBy()) {
            for (Sort.SortSpec sortKey : windowSpec.getSortSpecs()) {
                visit(ctx, stack, sortKey.getKey());
            }
        }
        if (windowSpec.hasWindowFrame()) {
            if (windowSpec.getWindowFrame().getStartBound().hasNumber()) {
                visit(ctx, stack, windowSpec.getWindowFrame().getStartBound().getNumber());
            }
            if (windowSpec.getWindowFrame().getEndBound().hasNumber()) {
                visit(ctx, stack, windowSpec.getWindowFrame().getEndBound().getNumber());
            }
        }

        stack.pop();
        return result;
    }

    @Override
    public RESULT visitDataType(CONTEXT ctx, Stack<Expr> stack, DataTypeExpr expr) {
        return null;
    }

    @Override
    public RESULT visitCastExpr(CONTEXT ctx, Stack<Expr> stack, CastExpr expr) {
        stack.push(expr);
        RESULT result = visit(ctx, stack, expr.getOperand());
        stack.pop();
        return result;
    }

    @Override
    public RESULT visitLiteral(CONTEXT ctx, Stack<Expr> stack, LiteralValue expr) {
        return null;
    }

    @Override
    public RESULT visitNullLiteral(CONTEXT ctx, Stack<Expr> stack, NullLiteral expr) {
        return null;
    }

    @Override
    public RESULT visitTimestampLiteral(CONTEXT ctx, Stack<Expr> stack, TimestampLiteral expr) {
        return null;
    }

    @Override
    public RESULT visitIntervalLiteral(CONTEXT ctx, Stack<Expr> stack, IntervalLiteral expr) {
        return null;
    }

    @Override
    public RESULT visitTimeLiteral(CONTEXT ctx, Stack<Expr> stack, TimeLiteral expr) {
        return null;
    }

    @Override
    public RESULT visitDateLiteral(CONTEXT ctx, Stack<Expr> stack, DateLiteral expr) {
        return null;
    }
    
    @Override
    public RESULT visitUnparseableString(CONTEXT ctx, Stack<Expr> stack, UnparseableString expr) {
        return null;
    }
    
    @Override
    public RESULT visitMultiInsert(CONTEXT ctx, Stack<Expr> stack, MultiInsert expr) {
        stack.push(expr);
        RESULT child = visit(ctx, stack, expr.getSubQuery());
        stack.pop();
        return child;
    }

    @Override
    public RESULT visitRowPredicandList(CONTEXT ctx, Stack<Expr> stack, RowPredicandList expr) {
        stack.push(expr);
        for (Expr pred : expr.getPredicands()) {
            visit(ctx, stack, pred);
        }
        stack.pop();
        return null;
    }

    @Override
    public RESULT visitCoalesce(CONTEXT ctx, Stack<Expr> stack, CoalesceExpr expr) {
        stack.push(expr);
        for (Expr pred : expr.getOperands()) {
            visit(ctx, stack, pred);
        }
        stack.pop();
        return null;
    }

    @Override
    public RESULT visitNullif(CONTEXT ctx, Stack<Expr> stack, NullifExpr expr) {
        stack.push(expr);
        for (Expr pred : expr.getOperands()) {
            visit(ctx, stack, pred);
        }
        stack.pop();
        return null;
    }

}
