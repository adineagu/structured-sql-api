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
package org.pecheasoft.odigen.sql.parse.formatter;

import java.util.Set;
import java.util.Stack;

import org.apache.commons.lang3.StringUtils;
import org.pecheasoft.odigen.sql.parse.algebra.BaseAlgebraVisitor;
import org.pecheasoft.odigen.sql.parse.algebra.BetweenPredicate;
import org.pecheasoft.odigen.sql.parse.algebra.BinaryOperator;
import org.pecheasoft.odigen.sql.parse.algebra.BinaryOperator.Operator;
import org.pecheasoft.odigen.sql.parse.algebra.CaseWhenPredicate;
import org.pecheasoft.odigen.sql.parse.algebra.CastExpr;
import org.pecheasoft.odigen.sql.parse.algebra.CoalesceExpr;
import org.pecheasoft.odigen.sql.parse.algebra.ColumnReferenceExpr;
import org.pecheasoft.odigen.sql.parse.algebra.CountRowsFunctionExpr;
import org.pecheasoft.odigen.sql.parse.algebra.DataTypeExpr;
import org.pecheasoft.odigen.sql.parse.algebra.DateLiteral;
import org.pecheasoft.odigen.sql.parse.algebra.ExistsPredicate;
import org.pecheasoft.odigen.sql.parse.algebra.Expr;
import org.pecheasoft.odigen.sql.parse.algebra.FunctionExpr;
import org.pecheasoft.odigen.sql.parse.algebra.GeneralSetFunctionExpr;
import org.pecheasoft.odigen.sql.parse.algebra.InPredicate;
import org.pecheasoft.odigen.sql.parse.algebra.IsNullPredicate;
import org.pecheasoft.odigen.sql.parse.algebra.LiteralValue;
import org.pecheasoft.odigen.sql.parse.algebra.NamedExpr;
import org.pecheasoft.odigen.sql.parse.algebra.NotExpr;
import org.pecheasoft.odigen.sql.parse.algebra.NullLiteral;
import org.pecheasoft.odigen.sql.parse.algebra.NullifExpr;
import org.pecheasoft.odigen.sql.parse.algebra.PatternMatchPredicate;
import org.pecheasoft.odigen.sql.parse.algebra.Projection;
import org.pecheasoft.odigen.sql.parse.algebra.QuantifiedComparisonPredicate;
import org.pecheasoft.odigen.sql.parse.algebra.Query;
import org.pecheasoft.odigen.sql.parse.algebra.Relation;
import org.pecheasoft.odigen.sql.parse.algebra.RelationList;
import org.pecheasoft.odigen.sql.parse.algebra.RowPredicandList;
import org.pecheasoft.odigen.sql.parse.algebra.ScalarSubQuery;
import org.pecheasoft.odigen.sql.parse.algebra.SignedExpr;
import org.pecheasoft.odigen.sql.parse.algebra.SimpleTableSubQuery;
import org.pecheasoft.odigen.sql.parse.algebra.Sort;
import org.pecheasoft.odigen.sql.parse.algebra.UnparseableString;
import org.pecheasoft.odigen.sql.parse.algebra.ValueListExpr;
import org.pecheasoft.odigen.sql.parse.algebra.WindowFunctionExpr;
import org.pecheasoft.odigen.sql.parse.algebra.WindowSpec;
import org.pecheasoft.odigen.sql.util.CatalogConstants;
import org.pecheasoft.odigen.sql.util.TUtil;

import com.google.common.base.Strings;
import com.google.common.collect.Sets;

/**
 *
 * @author Adi Neagu
 * @param <T>
 */
public class SQLExpressionFormatter extends BaseAlgebraVisitor<SQLExpressionFormatter.Context, String> {

    private static final String INDENT = "    ";
    private static final boolean SPLIT_AND_CONDITION = Boolean.TRUE;


    public static String format(Expr expression) {
        StringBuilder builder = new StringBuilder();
        SQLExpressionFormatter.Context ctx = new SQLExpressionFormatter.Context(builder, 0);
        SQLExpressionFormatter formatter = new SQLExpressionFormatter();
        return formatter.visit(ctx, new Stack<>(), expression);
    }

    public static String format(Expr expression, Integer indent) {
        StringBuilder builder = new StringBuilder();
        SQLExpressionFormatter.Context ctx = new SQLExpressionFormatter.Context(builder, indent);
        SQLExpressionFormatter formatter = new SQLExpressionFormatter();
        return formatter.visit(ctx, new Stack<>(), expression);
    }

    public static String indentString(Integer indent) {
        return StringUtils.repeat(INDENT, indent);
    }

    public static class Context {

        protected final StringBuilder builder;
        protected Integer indent;


        public Context(StringBuilder builder) {
            this.builder = builder;
            this.indent = 0;
        }

        public Context(StringBuilder builder, Integer indent) {
            this.builder = builder;
            this.indent = indent;
        }

        public Integer nextIndent() {
            return ++indent;
        }
    }

    @Override
    public String postHook(SQLExpressionFormatter.Context ctx, Stack<Expr> stack, Expr expr, String current) {
        super.postHook(ctx, stack, expr, current);
        if (org.pecheasoft.odigen.sql.util.TUtil.isNullOrEmpty(current)) {
            current = expr.getText();
        }
        return current;
    }

    @Override
    public String visit(SQLExpressionFormatter.Context ctx, Stack<Expr> stack, Expr expr) {
        String componentName = expr.getNameAnnotation();
        String current = super.visit(ctx, stack, expr);

        if (!TUtil.isNullOrEmpty(componentName)) {
            current = componentName
                    .concat("\n")
                    .concat(indentString(ctx.indent + 1))
                    .concat(current);
        }
        
        return current;
    }

    @Override
    public String visitTargetExpr(SQLExpressionFormatter.Context ctx, Stack<Expr> stack, NamedExpr expr) {
        return visit(ctx, stack, expr.getChild());
    }

    @Override
    public String visitEquals(SQLExpressionFormatter.Context ctx, Stack<Expr> stack, BinaryOperator expr) {
        String left = visit(ctx, stack, expr.getLeft());
        String right = visit(ctx, stack, expr.getRight());
        return left + " = " + right;
    }

    @Override
    public String visitColumnReference(SQLExpressionFormatter.Context ctx, Stack<Expr> stack, ColumnReferenceExpr expr) {
        String name = expr.getCanonicalName();
        name = TUtil.formatQualifiedName(name);
        return name;
    }

    @Override
    public String visitLiteral(SQLExpressionFormatter.Context ctx, Stack<Expr> stack, LiteralValue expr) {
        if (expr.getValueType() == LiteralValue.LiteralType.String) {
            return CatalogConstants.IDENTIFIER_SINGLEQUOTE_STRING + expr.getValue() + CatalogConstants.IDENTIFIER_SINGLEQUOTE_STRING;
        } else {
            return expr.getValue();
        }
    }

    @Override
    public String visitUnparseableString(SQLExpressionFormatter.Context ctx, Stack<Expr> stack, UnparseableString expr) {
        return expr.getValue();
    }

    @Override
    public String visitFunction(SQLExpressionFormatter.Context ctx, Stack<Expr> stack, FunctionExpr expr) {
        if (expr.getParams() != null) {
            String[] params = new String[expr.getParams().length];
            for (int i = 0; i < expr.getParams().length; i++) {
                params[i] = visit(ctx, stack, (expr.getParams())[i]);
            }
            return expr.getSignature() + "(" + StringUtils.join(params, ",") + ")";
        } else {
            return expr.getSignature() + "(" + ")";
        }
    }

    @Override
    public String visitSign(SQLExpressionFormatter.Context ctx, Stack<Expr> stack, SignedExpr expr) {
        if ((expr.getChild() instanceof BinaryOperator)) {
            return (expr.isNegative() ? "-" : "") + "(" + super.visitSign(ctx, stack, expr) + ")";
        }
        return (expr.isNegative() ? "-" : "") + super.visitSign(ctx, stack, expr);
    }

    @Override
    public String visitDivide(SQLExpressionFormatter.Context ctx, Stack<Expr> stack, BinaryOperator expr) {
        String left = visit(ctx, stack, expr.getLeft());
        String right = visit(ctx, stack, expr.getRight());

        if (expr.getLeft() instanceof BinaryOperator ) {
            BinaryOperator leftExpr = (BinaryOperator) expr.getLeft();
            if (leftExpr.getOperator().equals(Operator.Minus) || leftExpr.getOperator().equals(Operator.Plus)) {
                left = "(" + left + ")";
            }
        }

        if (expr.getRight() instanceof BinaryOperator ) {
            BinaryOperator rightExpr = (BinaryOperator) expr.getRight();
            if (rightExpr.getOperator().equals(Operator.Minus) || rightExpr.getOperator().equals(Operator.Plus)) {
                right = "(" + right + ")";
            }
        }

        return left + " / " + right;
    }

    @Override
    public String visitMultiply(SQLExpressionFormatter.Context ctx, Stack<Expr> stack, BinaryOperator expr) {
        String left = visit(ctx, stack, expr.getLeft());
        String right = visit(ctx, stack, expr.getRight());

        if (expr.getLeft() instanceof BinaryOperator ) {
            BinaryOperator leftExpr = (BinaryOperator) expr.getLeft();
            if (leftExpr.getOperator().equals(Operator.Minus) || leftExpr.getOperator().equals(Operator.Plus)) {
                left = "(" + left + ")";
            }
        }

        if (expr.getRight() instanceof BinaryOperator ) {
            BinaryOperator rightExpr = (BinaryOperator) expr.getRight();
            if (rightExpr.getOperator().equals(Operator.Minus) || rightExpr.getOperator().equals(Operator.Plus)) {
                right = "(" + right + ")";
            }
        }

        return left + " * " + right;
    }

    @Override
    public String visitMinus(SQLExpressionFormatter.Context ctx, Stack<Expr> stack, BinaryOperator expr) {
        String left = visit(ctx, stack, expr.getLeft());
        String right = visit(ctx, stack, expr.getRight());

        if (expr.getLeft() instanceof BinaryOperator ) {
            BinaryOperator leftExpr = (BinaryOperator) expr.getLeft();
            if (leftExpr.getOperator().equals(Operator.Minus) || leftExpr.getOperator().equals(Operator.Plus)) {
                left = "(" + left + ")";
            }
        }

        if (expr.getRight() instanceof BinaryOperator ) {
            BinaryOperator rightExpr = (BinaryOperator) expr.getRight();
            if (rightExpr.getOperator().equals(Operator.Minus) || rightExpr.getOperator().equals(Operator.Plus)) {
                right = "(" + right + ")";
            }
        }

        return left + " - " + right;
    }

    @Override
    public String visitPlus(SQLExpressionFormatter.Context ctx, Stack<Expr> stack, BinaryOperator expr) {
        String left = visit(ctx, stack, expr.getLeft());
        String right = visit(ctx, stack, expr.getRight());
        return left + " + " + right;
    }

    @Override
    public String visitConcatenate(SQLExpressionFormatter.Context ctx, Stack<Expr> stack, BinaryOperator expr) {
        String left = visit(ctx, stack, expr.getLeft());
        String right = visit(ctx, stack, expr.getRight());
        return left + " || " + right;
    }

    @Override
    public String visitCaseWhen(SQLExpressionFormatter.Context ctx, Stack<Expr> stack, CaseWhenPredicate expr) {
        StringBuilder builder = new StringBuilder("CASE");
        for (CaseWhenPredicate.WhenExpr when : expr.getWhens()) {
            builder.append("\n").append(indentString(ctx.indent + 2)).append("WHEN ").append(visit(ctx, stack, when.getCondition())).append(" THEN ").append(visit(ctx, stack, when.getResult()));
        }
        if (expr.getElseResult() != null) {
            builder.append("\n").append(indentString(ctx.indent + 2)).append("ELSE ").append(visit(ctx, stack, expr.getElseResult()));
        }
        builder.append("\n").append(indentString(ctx.indent + 1)).append(" END");
        return builder.toString();
    }

    @Override
    public String visitCoalesce(SQLExpressionFormatter.Context ctx, Stack<Expr> stack, CoalesceExpr expr) {
        String[] params = new String[expr.getOperands().size()];
        for (int i = 0; i < expr.getOperands().size(); i++) {
            params[i] = visit(ctx, stack, (expr.getOperands()).get(i));
        }
        return "COALESCE(" + StringUtils.join(params, ",") + ")";
    }

    @Override
    public String visitCountRowsFunction(SQLExpressionFormatter.Context ctx, Stack<Expr> stack, CountRowsFunctionExpr expr) {
        return "COUNT(*)";
    }

    @Override
    public String visitNullif(SQLExpressionFormatter.Context ctx, Stack<Expr> stack, NullifExpr expr) {
        String[] params = new String[expr.getOperands().size()];
        for (int i = 0; i < expr.getOperands().size(); i++) {
            params[i] = visit(ctx, stack, (expr.getOperands()).get(i));
        }
        return "NULLIF(" + StringUtils.join(params, ",") + ")";
    }

    @Override
    public String visitNullLiteral(SQLExpressionFormatter.Context ctx, Stack<Expr> stack, NullLiteral expr) {
        return "NULL";
    }

    @Override
    public String visitCastExpr(SQLExpressionFormatter.Context ctx, Stack<Expr> stack, CastExpr expr) {
        String operand = visit(ctx, stack, expr.getOperand());
        String dataType = visit(ctx, stack, expr.getTarget());
        return String.format("CAST(%s AS %s)", operand, dataType);
    }

    @Override
    public String visitDataType(SQLExpressionFormatter.Context ctx, Stack<Expr> stack, DataTypeExpr expr) {
        StringBuilder builder = new StringBuilder(expr.getTypeName());
        if (expr.hasLengthOrPrecision()) {
            builder.append("(");
            builder.append(expr.getLengthOrPrecision());
            if (expr.hasScale()) {
                builder.append(",").append(expr.getScale());
            }
            builder.append(")");
        }
        return builder.toString();
    }

    @Override
    public String visitBetween(SQLExpressionFormatter.Context ctx, Stack<Expr> stack, BetweenPredicate expr) {
        String predicate = visit(ctx, stack, expr.model().predicand());
        String begin = visit(ctx, stack, expr.model().begin());
        String end = visit(ctx, stack, expr.model().end());
        return String.format("%s BETWEEN %s AND %s", predicate, begin, end);
    }

    @Override
    public String visitGreaterThanOrEquals(SQLExpressionFormatter.Context ctx, Stack<Expr> stack, BinaryOperator expr) {
        String left = visit(ctx, stack, expr.getLeft());
        String right = visit(ctx, stack, expr.getRight());
        return String.format("%s >= %s", left, right);
    }

    @Override
    public String visitGreaterThan(SQLExpressionFormatter.Context ctx, Stack<Expr> stack, BinaryOperator expr) {
        String left = visit(ctx, stack, expr.getLeft());
        String right = visit(ctx, stack, expr.getRight());
        return String.format("%s > %s", left, right);
    }

    @Override
    public String visitLessThanOrEquals(SQLExpressionFormatter.Context ctx, Stack<Expr> stack, BinaryOperator expr) {
        String left = visit(ctx, stack, expr.getLeft());
        String right = visit(ctx, stack, expr.getRight());
        return String.format("%s <= %s", left, right);
    }

    @Override
    public String visitLessThan(SQLExpressionFormatter.Context ctx, Stack<Expr> stack, BinaryOperator expr) {
        String left = visit(ctx, stack, expr.getLeft());
        String right = visit(ctx, stack, expr.getRight());
        return String.format("%s < %s", left, right);
    }

    @Override
    public String visitNotEquals(SQLExpressionFormatter.Context ctx, Stack<Expr> stack, BinaryOperator expr) {
        String left = visit(ctx, stack, expr.getLeft());
        String right = visit(ctx, stack, expr.getRight());
        return String.format("%s != %s", left, right);
    }

    @Override
    public String visitGeneralSetFunction(SQLExpressionFormatter.Context ctx, Stack<Expr> stack, GeneralSetFunctionExpr expr) {
        String signature = expr.getSignature().toUpperCase();
        String[] params = new String[expr.getParams().length];
        for (int i = 0; i < params.length; i++) {
            params[i] = visit(ctx, stack, expr.getParams()[i]);
        }
        StringUtils.join(params, ",");

        if (expr.isDistinct()) {
            return String.format("%s(DISTINCT %s)", signature.toUpperCase(), StringUtils.join(params, ","));
        } else {
            return String.format("%s(%s)", signature.toUpperCase(), StringUtils.join(params, ","));
        }
    }

    @Override
    public String visitIsNullPredicate(SQLExpressionFormatter.Context ctx, Stack<Expr> stack, IsNullPredicate expr) {
        String predicand = visit(ctx, stack, expr.getPredicand());
        if (expr.isNot()) {
            return String.format("%s IS NOT NULL", predicand);
        } else {
            return String.format("%s IS NULL", predicand);
        }
    }

    @Override
    public String visitNot(SQLExpressionFormatter.Context ctx, Stack<Expr> stack, NotExpr expr) {
        return "NOT (" + visit(ctx, stack, expr.getChild()) + ")";
    }

    @Override
    public String visitOr(SQLExpressionFormatter.Context ctx, Stack<Expr> stack, BinaryOperator expr) {
        String leftOp = visit(ctx, stack, expr.getLeft());
        String rightOp = visit(ctx, stack, expr.getRight());
        return String.format("(%s OR %s)", leftOp, rightOp);
    }

    @Override
    public String visitAnd(SQLExpressionFormatter.Context ctx, Stack<Expr> stack, BinaryOperator expr) {
        String leftOp = visit(ctx, stack, expr.getLeft());
        String rightOp = visit(ctx, stack, expr.getRight());

        String ret;

        if (SPLIT_AND_CONDITION) {
            ret= String.format("""
                                 %s 
                                 """ + indentString(ctx.indent + 1) + "AND %s", leftOp, rightOp);
        } else {
            ret = String.format("%s AND %s", leftOp, rightOp);
        }

        String componentName = expr.getNameAnnotation();

        if (!TUtil.isNullOrEmpty(componentName)) {
            ret = "(" + ret + ")";
        }        
        return ret;
    }

    @Override
    public String visitExistsPredicate(SQLExpressionFormatter.Context ctx, Stack<Expr> stack, ExistsPredicate expr) {
        StringBuilder builder = new StringBuilder();

        builder
            .append((expr.isNot() ? """
                                    NOT EXISTS
                                    """ + indentString(ctx.indent + 1) + "(" : "EXISTS ("))
            .append(SQLStatementFormatter.format(expr.getSubQuery(), ctx.indent + 2))
            .append("\n")
            .append(indentString(ctx.indent + 1))
            .append(")");

        return builder.toString();
    }

    @Override
    public String visitInPredicate(SQLExpressionFormatter.Context ctx, Stack<Expr> stack, InPredicate expr) {
        StringBuilder builder = new StringBuilder();

        builder.append(visit(ctx, stack, expr.getLeft()));
        builder.append(expr.isNot() ? " NOT IN" : " IN");
        if (expr.getRight() instanceof SimpleTableSubQuery) {
            builder.append("\n").append(indentString(ctx.indent + 1)).append("(").append(SQLStatementFormatter.format(expr.getRight(), ctx.indent + 2)).append("\n").append(indentString(ctx.indent + 1)).append(")");
        } else {
            builder.append(" ").append(visit(ctx, stack, expr.getRight()));
        }
        return builder.toString();
    }

    @Override
    public String visitQuantifiedComparisonPredicate(SQLExpressionFormatter.Context ctx, Stack<Expr> stack, QuantifiedComparisonPredicate expr) {
        StringBuilder builder = new StringBuilder();

        builder.append(visit(ctx, stack, expr.getLeft()));
        builder.append(" ").append(expr.getSqlOperator());
        if (!TUtil.isNullOrEmpty(expr.getQuantifier())) {
            builder.append(" ").append(expr.getQuantifier().toUpperCase());
        }
        if (expr.getRight() instanceof SimpleTableSubQuery || expr.getRight() instanceof Query) {
            builder.append("\n").append(indentString(ctx.indent + 1)).append(" (").append(SQLStatementFormatter.format(expr.getRight(), ctx.indent + 2)).append("\n").append(indentString(ctx.indent + 1)).append(")");
        } else {
            builder.append(" ").append(visit(ctx, stack, expr.getRight()));
        }
        return builder.toString();
    }

    @Override
    public String visitRowPredicandList(SQLExpressionFormatter.Context ctx, Stack<Expr> stack, RowPredicandList expr) {
        StringBuilder builder = new StringBuilder();
        builder.append("(");
        boolean isFirst = true;
        for (Expr predicand : expr.getPredicands()) {
            builder.append(isFirst ? "" : ", ").append(visit(ctx, stack, predicand));
            isFirst = false;
        }
        builder.append(")");
        return builder.toString();
    }

    @Override
    public String visitValueListExpr(SQLExpressionFormatter.Context ctx, Stack<Expr> stack, ValueListExpr expr) {
        StringBuilder builder = new StringBuilder();
        builder.append("(");
        boolean isFirst = Boolean.TRUE;
        for (Expr crt : expr.getValues()) {
            String value = visit(ctx, stack, crt);
            builder.append(isFirst ? "" : ",").append(value);
            isFirst = Boolean.FALSE;
        }
        builder.append(")");
        return builder.toString();
    }

    protected static String indentString(int indent) {
        return Strings.repeat(INDENT, indent);
    }

    @Override
    public String visitWindowFunction(SQLExpressionFormatter.Context ctx, Stack<Expr> stack, WindowFunctionExpr expr) {
        StringBuilder builder = new StringBuilder();
        builder.append(expr.getSignature().toUpperCase()).append("(");
        boolean isFirst = Boolean.TRUE;
        for (Expr param : expr.getParams()) {
            builder.append(isFirst ? "" : ",").append(visit(ctx, stack, param));
            isFirst = Boolean.FALSE;
        }

        if (!TUtil.isNullOrEmpty(expr.getNullOption())) {
            builder.append(" ").append(expr.getNullOption());
        }

        builder.append(")");

        if ("LISTAGG".equals(expr.getSignature().toUpperCase())) {
            // LISTAGG has the syntax LISTAGG(...) WITHIN GROUP (ORDER BY...) OVER(PARTITION BY...)

            builder.append(" WITHIN GROUP (");
            if (expr.getWindowSpec().getSortSpecs() != null && expr.getWindowSpec().getSortSpecs().length > 0) {
                isFirst = Boolean.TRUE;
                builder.append("ORDER BY ");
                for (Sort.SortSpec sortSpec : expr.getWindowSpec().getSortSpecs()) {
                    builder.append(isFirst ? "" : ",").append(SQLExpressionFormatter.format(sortSpec.getKey(), ctx.indent)).append(sortSpec.isAscending() ? " ASC" : " DESC").append(sortSpec.isNullFirst() ? " NULLS FIRST" : " NULLS LAST");
                    isFirst = Boolean.FALSE;
                }
            }
            builder.append(") ");

            if (expr.getWindowSpec().getPartitionKeys() != null && expr.getWindowSpec().getPartitionKeys().length > 0) {
                isFirst = Boolean.TRUE;
                builder.append("PARTITION BY ");
                for (Expr param : expr.getWindowSpec().getPartitionKeys()) {
                    builder.append(isFirst ? "" : ",").append(visit(ctx, stack, param));
                    isFirst = Boolean.FALSE;
                }
                builder.append(") ");
            }
        } else {
            builder.append("\n").append(" OVER (");

            if (expr.getWindowSpec().getPartitionKeys() != null && expr.getWindowSpec().getPartitionKeys().length > 0) {
                isFirst = Boolean.TRUE;
                builder.append("PARTITION BY ");
                for (Expr param : expr.getWindowSpec().getPartitionKeys()) {
                    builder.append(isFirst ? "" : ",").append(visit(ctx, stack, param));
                    isFirst = Boolean.FALSE;
                }
                builder.append(" ");
            }

            if (expr.getWindowSpec().getSortSpecs() != null && expr.getWindowSpec().getSortSpecs().length > 0) {
                isFirst = Boolean.TRUE;
                builder.append("\n").append("ORDER BY ");
                for (Sort.SortSpec sortSpec : expr.getWindowSpec().getSortSpecs()) {
                    builder.append(isFirst ? "" : ",").append(SQLExpressionFormatter.format(sortSpec.getKey(), ctx.indent)).append(sortSpec.isAscending() ? " ASC" : " DESC").append(sortSpec.isNullFirst() ? " NULLS FIRST" : " NULLS LAST");
                    isFirst = Boolean.FALSE;
                }
            }

            if (expr.getWindowSpec().hasWindowFrame()) {
                WindowSpec.WindowFrame frame = expr.getWindowSpec().getWindowFrame();
                builder.append("\n").append("ROWS BETWEEN ");

                WindowSpec.WindowStartBound startBond = frame.getStartBound();
                switch (startBond.getBoundType()) {
                    case UNBOUNDED_PRECEDING -> builder.append("UNBOUNDED PRECEDING");
                    case CURRENT_ROW -> builder.append("CURRENT ROW");
                    case PRECEDING -> builder.append(String.format("PRECEDING %s ROWS", startBond.getNumber()));
                }

                if (frame.hasEndBound()) {
                    builder.append(" AND ");
                    WindowSpec.WindowEndBound endBound = frame.getEndBound();
                    switch (endBound.getBoundType()) {
                        case CURRENT_ROW -> builder.append("CURRENT ROW");
                        case UNBOUNDED_FOLLOWING -> builder.append("UNBOUNDED FOLLOWING");
                        case FOLLOWING -> builder.append(String.format("FOLLOWING %s ROWS", startBond.getNumber()));
                    }
                }
            }
            builder.append(")");
        }

        return builder.toString();
    }

    @Override
    public String visitLikePredicate(SQLExpressionFormatter.Context ctx, Stack<Expr> stack, PatternMatchPredicate expr) {
        String leftOp = visit(ctx, stack, expr.getLeft());
        String rightOp = visit(ctx, stack, expr.getRight());

        if (expr.isNot()) {
            return String.format("%s NOT LIKE %s", leftOp, rightOp);
        } else {
            return String.format("%s LIKE %s", leftOp, rightOp);
        }
    }

    @Override
    public String visitScalarSubQuery(SQLExpressionFormatter.Context ctx, Stack<Expr> stack, ScalarSubQuery expr) {
        String therest = visit(ctx, stack, expr.getChild());
        return "(SELECT ".concat(therest).concat(")");
    }

    @Override
    public String visitProjection(SQLExpressionFormatter.Context ctx, Stack<Expr> stack, Projection expr) {
        String result = "";
        stack.push(expr);

        for (NamedExpr target : expr.getNamedExprs()) {
            result = result.concat(visit(ctx, stack, target));
        }
        if (expr.hasChild()) {
            String childText = visit(ctx, stack, expr.getChild());
            result = result.concat(childText != null ? childText : "");
        }

        stack.pop();

        return result;
    }

    @Override
    public String visitRelationList(SQLExpressionFormatter.Context ctx, Stack<Expr> stack, RelationList expr) {
        StringBuilder builder = new StringBuilder();
        builder.append(" FROM ");
        for (Expr e : expr.getRelations()) {
            builder.append(visit(ctx, stack, e));
        }
        return builder.toString();
    }

    @Override
    public String visitRelation(SQLExpressionFormatter.Context ctx, Stack<Expr> stack, Relation expr) {
        StringBuilder builder = new StringBuilder();
        builder.append(encloseNameTokens(expr.getName()));

        if (expr.hasAlias()) {
            builder.append(" ").append(expr.getAlias());
        }

        return builder.toString();
    }

    @Override
    public String visitDateLiteral(SQLExpressionFormatter.Context ctx, Stack<Expr> stack, DateLiteral expr) {
        return String.format("DATE'%s'", expr.getText());
    }

    private static String encloseWithinDoubleQuotes(String text) {
        return '"' + text + '"';
    }

    public static String encloseNameTokens(final String name) {
        String[] tokens = StringUtils.split(name, CatalogConstants.IDENTIFIER_DELIMITER);

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (token.contains(" ") || RESERVED_WORDS.contains(token)) {
                token = encloseWithinDoubleQuotes(token);
            }
            tokens[i] = token;
        }

        return StringUtils.join(tokens, CatalogConstants.IDENTIFIER_DELIMITER);
    }

    public static String encloseIfReservedWord(String in) {
        if (RESERVED_WORDS.contains(in) || !in.equals(in.toUpperCase())) {
            return encloseWithinDoubleQuotes(in);
        } else {
            return in;
        }
    }

    private final static Set<String> RESERVED_WORDS = Sets.newHashSet(
            "ALL",
            "AND",
            "ANY",
            "AS",
            "ASC",
            "CASCADE",
            "CASE",
            "CAST",
            "CAST_EXPRESSION",
            "CLOB",
            "CREATE",
            "DEFINED",
            "DELIMITED",
            "DESC",
            "DISTINCT",
            "ELSE",
            "END",
            "FALSE",
            "FOR",
            "FROM",
            "HAVING",
            "HOUR",
            "IF",
            "IN",
            "INTERSECT",
            "INTO",
            "IS",
            "JOIN",
            "LEAD",
            "LEADING",
            "LEFT",
            "LIKE",
            "MINUS",
            "MODIFY",
            "NOT",
            "NULL",
            "NULLS",
            "ON",
            "OR",
            "OUTER",
            "OVER",
            "RIGHT",
            "SELECT",
            "SOME",
            "TABLE",
            "THEN",
            "TRUE",
            "TRUNCATE",
            "UNION",
            "UNIQUE",
            "USING",
            "WHEN",
            "WHERE",
            "WITH",
            "INTEGRATION",
            "CONSTRAINT",
            "CURSOR",
            "ERROR",
            "GOTO",
            "DECLARE",
            "REFRESH",
            "RETRY",
            "WAIT",
            "BEGIN",
            "EXIT"
    );
}
