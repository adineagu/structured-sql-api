package org.pecheasoft.odigen.sql.api.transform;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.lang3.StringUtils;
import org.pecheasoft.odigen.sql.api.ast.IASTObject;
import org.pecheasoft.odigen.sql.api.ast.IDatastoreAttribute;
import org.pecheasoft.odigen.sql.api.ast.IDatastoreCondition;
import org.pecheasoft.odigen.sql.api.ast.IDatastoreKey;
import org.pecheasoft.odigen.sql.api.ast.IExpression;
import org.pecheasoft.odigen.sql.api.ast.IJoinComponent;
import org.pecheasoft.odigen.sql.api.ast.IQuery;
import org.pecheasoft.odigen.sql.api.ast.IRelation;
import org.pecheasoft.odigen.sql.api.ast.ISelectItem;
import org.pecheasoft.odigen.sql.api.ast.ITargetAttribute;
import org.pecheasoft.odigen.sql.api.ast.impl.Datastore;
import org.pecheasoft.odigen.sql.api.ast.impl.DatastoreAttribute;
import org.pecheasoft.odigen.sql.api.ast.impl.DatastoreCondition;
import org.pecheasoft.odigen.sql.api.ast.impl.DatastoreKey;
import org.pecheasoft.odigen.sql.api.ast.impl.DatastoreReference;
import org.pecheasoft.odigen.sql.api.ast.impl.InsertStatement;
import org.pecheasoft.odigen.sql.api.ast.impl.MultiInsertTable;
import org.pecheasoft.odigen.sql.api.ast.impl.Query;
import org.pecheasoft.odigen.sql.api.ast.impl.SelectItem;
import org.pecheasoft.odigen.sql.api.ast.impl.TargetColumn;
import org.pecheasoft.odigen.sql.api.ast.impl.Expression;
import org.pecheasoft.odigen.sql.api.ast.impl.SubQuery;
import org.pecheasoft.odigen.sql.parse.algebra.Aggregation;
import org.pecheasoft.odigen.sql.parse.algebra.BaseAlgebraVisitor;
import org.pecheasoft.odigen.sql.parse.algebra.BinaryOperator;
import org.pecheasoft.odigen.sql.parse.algebra.ColumnDefinition;
import org.pecheasoft.odigen.sql.parse.algebra.CreateTable;
import org.pecheasoft.odigen.sql.parse.algebra.Expr;
import org.pecheasoft.odigen.sql.parse.algebra.Having;
import org.pecheasoft.odigen.sql.parse.algebra.ITableConstraint;
import org.pecheasoft.odigen.sql.parse.algebra.InPredicate;
import org.pecheasoft.odigen.sql.parse.algebra.Insert;
import org.pecheasoft.odigen.sql.parse.algebra.Join;
import org.pecheasoft.odigen.sql.parse.algebra.MultiInsert;
import org.pecheasoft.odigen.sql.parse.algebra.MultiInsertTarget;
import org.pecheasoft.odigen.sql.parse.algebra.NamedExpr;
import org.pecheasoft.odigen.sql.parse.algebra.NamedQuery;
import org.pecheasoft.odigen.sql.parse.algebra.NotExpr;
import org.pecheasoft.odigen.sql.parse.algebra.Projection;
import org.pecheasoft.odigen.sql.parse.algebra.QuantifiedComparisonPredicate;
import org.pecheasoft.odigen.sql.parse.algebra.Relation;
import org.pecheasoft.odigen.sql.parse.algebra.RelationList;
import org.pecheasoft.odigen.sql.parse.algebra.Selection;
import org.pecheasoft.odigen.sql.parse.algebra.SetOperation;
import org.pecheasoft.odigen.sql.parse.algebra.SimpleTableSubQuery;
import org.pecheasoft.odigen.sql.parse.algebra.TablePrimarySubQuery;
import org.pecheasoft.odigen.sql.parse.algebra.Unpivot;
import org.pecheasoft.odigen.sql.parse.algebra.BinaryOperator.Operator;
import org.pecheasoft.odigen.sql.parse.formatter.SQLExpressionFormatter;
import org.pecheasoft.odigen.sql.parse.formatter.SQLStatementFormatter;
import org.pecheasoft.odigen.sql.util.TUtil;


/**
 *
 * @author Adi Neagu
 *
 * Transforms a object of type Expr in the equivalent structured expression CreateTable -> Datastore Insert -> InsertStatement
 */
public class StructuredObjectBuilder extends BaseAlgebraVisitor<StructuredObjectBuilder.Context, IASTObject> {

    Map<String, Query> withQueries = TUtil.newHashMap();

    private IASTObject rootObject = null;

    public static class Context {
        final Map<Integer, ITargetAttribute> targetColsPosMap = TUtil.newHashMap();
        final Map<String, Query> withQueries = TUtil.newHashMap();
        Query query;
        boolean inWhereCondition;
    }

    public static IASTObject getStructuredObject(final Expr source) {
        Context ctx = new StructuredObjectBuilder.Context();
        StructuredObjectBuilder visitor = new StructuredObjectBuilder();

        return visitor.visit(ctx, new Stack<>(), source);
    }

    @Override
    public IASTObject visitCreateTable(final Context ctx, final Stack<Expr> stack, final CreateTable expr) {
        Datastore datastore = new Datastore();

        if (expr.getAnnotations() != null) {
            datastore.setAnnotations(expr.getAnnotations());
        }

        if (!TUtil.isNullOrEmpty(expr.getTableKeys())) {
            final Collection<IDatastoreKey> keys = expr.getTableKeys().stream()
                    .filter(c -> c.isPrimaryKey() || c.isAlternateKey() || c.isNonUniqueIndex())
                    .map(DatastoreKey::new)
                    .collect(Collectors.toList());

            datastore.setKeys(keys);

            final Collection<IDatastoreCondition> conditions = expr.getTableKeys().stream()
                    .filter(ITableConstraint::isCheckConstraint)
                    .map(DatastoreCondition::new)
                    .collect(Collectors.toList());

            datastore.setConditions(conditions);
        }

        datastore.setName(expr.getTableName());
        datastore.setAttributes(getDatastoreAttributes(expr));

        if (!TUtil.isNullOrEmpty(expr.getDescription())) {
            datastore.setDescription(expr.getDescription());
        }

        rootObject = datastore;

        return datastore;
    }

    @Override
    public IASTObject visitMultiInsert(Context ctx, Stack<Expr> stack, MultiInsert expr) {
        final InsertStatement insertStmt = new InsertStatement();
        Query query = new Query();
        ctx.query = query;

        query = (Query) visit(ctx, stack, expr.getSubQuery());

        insertStmt.setQuery(query);

        rootObject = insertStmt;

        if (expr.getAnnotations() != null) {
            insertStmt.setAnnotations(expr.getAnnotations());
        }

        Collection<MultiInsertTable> targets = TUtil.newList();

        insertStmt.setMultiInsertTargets(targets);

        for (MultiInsertTarget insTarg : expr.getTargets()) {
            MultiInsertTable targ = new MultiInsertTable();
            String name = insTarg.getTableName();
            String alias = insTarg.getTableAlias();
            String condition = insTarg.getCondition().getText();

            targ.setTarget(new DatastoreReference(name, alias));
            targ.setCondition(condition);

            if (expr.getAnnotations() != null) {
                targ.setAnnotations(expr.getAnnotations());
            }

            Expr[] expressions = insTarg.getExpressions();

            Map<String, Expr> exprMap = IntStream.rangeClosed(0, expressions.length - 1)
                    .mapToObj(i -> new NamedExpr(expressions[i], Integer.toString(i)))
                    .collect(Collectors.toMap(NamedExpr::getAlias, NamedExpr::getExpr));

            List<ISelectItem> targetCols = IntStream
                    .rangeClosed(0, insTarg.getTargetColumns().size() - 1)
                    .mapToObj(pos -> new SelectItem(new Expression((exprMap.get(Integer.toString(pos))).getText()), insTarg.getTargetColumns().get(pos).getName()))
                    .collect(Collectors.toList());

            targ.setSelectList(targetCols);

            targets.add(targ);
        }

        return insertStmt;
    }

    @Override
    public IASTObject visitInsert(final Context ctx, final Stack<Expr> stack, final Insert expr) {
        final InsertStatement insertStmt = new InsertStatement();

        final DatastoreReference targetTable = getTargetTable(expr);
        targetTable.setIsTarget(true);

        insertStmt.setTargetTable(targetTable);
        insertStmt.setColumns(getTargetColumns(ctx, expr, targetTable));

        Query query = new Query();
        ctx.query = query;

        query = (Query) visit(ctx, stack, expr.getSubQuery());

        insertStmt.setQuery(query);

        rootObject = insertStmt;

        if (expr.getAnnotations() != null) {
            insertStmt.setAnnotations(expr.getAnnotations());
        }

        return insertStmt;
    }

    private DatastoreReference getTargetTable(final Insert insert) {
        final String targetTableName = insert.getTableName();
        final DatastoreReference table = new DatastoreReference(targetTableName);
        return table;
    }

    private List<ITargetAttribute> getTargetColumns(final Context ctx, final Insert insert,
            final DatastoreReference table) {
        final List<ITargetAttribute> targetColumns = TUtil.newList();

        int i = 0;
        for (final org.pecheasoft.odigen.sql.parse.algebra.TargetColumn col : insert.getTargetColumns()) {
            final String name = col.getName();
            TargetColumn tc;

            if (table.getDatastore() != null) {
                final IDatastoreAttribute attr = table.getDatastore().getAttribute(name);
                tc = new TargetColumn(SQLExpressionFormatter.encloseIfReservedWord(name), i++, attr, table);
            } else {
                tc = new TargetColumn(SQLExpressionFormatter.encloseIfReservedWord(name), i++, null, table);
            }

            if (col.getAnnotations() != null) {
                tc.setAnnotations(col.getAnnotations());
            }
    
            targetColumns.add(tc);
            ctx.targetColsPosMap.put(tc.getPosition(), tc);
        }

        return targetColumns;
    }

    @Override
    public IASTObject visitTableSubQuery(final Context ctx, final Stack<Expr> stack, final TablePrimarySubQuery expr) {
        final Context newCtx = new Context();

        Query query = new Query();
        newCtx.query = query;

        query = (Query) visit(newCtx, stack, expr.getSubQuery());

        return new SubQuery(query, expr.getAlias());
    }

    @Override
    public IASTObject visitSimpleTableSubQuery(Context ctx, Stack<Expr> stack, SimpleTableSubQuery expr) {
        final Context newCtx = new Context();

        Query query = new Query();
        newCtx.query = query;

        query = (Query) visit(newCtx, stack, expr.getSubQuery());

        return new SubQuery(query, "");
    }

    @Override
    public IASTObject visitIntersect(Context ctx, Stack<Expr> stack, SetOperation expr) {
        return visitUnion(ctx, stack, expr);
    }

    @Override
    public IASTObject visitExcept(Context ctx, Stack<Expr> stack, SetOperation expr) {
        return visitUnion(ctx, stack, expr);
    }

    @Override
    public IASTObject visitUnion(final Context ctx, final Stack<Expr> stack, final SetOperation expr) {
        Query finalQuery = null;
        List<IQuery> datasets = TUtil.newList();

        for (int i = 0; i < expr.getOperands().length; i++) {
            final Projection proj = (Projection) expr.getOperands()[i];

            final SetOperation.Type setOpType = expr.getOperationTypes()[i];
            String setOperation = null;
            if (setOpType != null) {
                setOperation = expr.getOperationTypes()[i].toString().toUpperCase();
                final Boolean isDistinct = expr.getDistinctIndicators()[i];
                if (isDistinct == null || !isDistinct) {
                    setOperation = setOperation.concat(" ALL");
                }
            }

            final Query qry = (Query) visitProjection(ctx, stack, proj);

            if (!TUtil.isNullOrEmpty(setOperation)) {
                qry.setSetOperator(setOperation);
            }

            if (!TUtil.isNullOrEmpty(proj.getAnnotations())) {  
                qry.setAnnotations(proj.getAnnotations());
            }

            qry.setDatasetList(Collections.singletonList(qry));

            datasets.add(qry);
            if (finalQuery == null) {
                finalQuery = qry;
            } else {
                finalQuery.setDatasetList(datasets);
            }

        }

        return finalQuery;
    }

    @Override
    public IASTObject visitQuery(final Context ctx, final Stack<Expr> stack, final org.pecheasoft.odigen.sql.parse.algebra.Query expr) {
        /*
            Make sure all queries from the clause WITH are registered
         */
        for (int i = 0; i < 10; i++) {
            if (expr.getWithQueries() != null) {
                Context specialCtx = new Context();
                Stack<Expr> specialStack = new Stack<>();
                expr.getWithQueries().forEach(q -> {
                    Query ret = (Query) visit(specialCtx, specialStack, ((NamedQuery) q).getChild());

                    if (TUtil.isNullOrEmpty(ret.getDatasetList())) {
                        ret.setDatasetList(Collections.singletonList(ret));
                    }

                    ret.setName(((NamedQuery) q).getName());
                    specialCtx.withQueries.put(((NamedQuery) q).getName(), ret);
                });

                if (specialCtx.withQueries != null && !specialCtx.withQueries.isEmpty()) {
                    withQueries = specialCtx.withQueries;
                }
            }
        }

        if (expr.getWithQueries() != null) {
            expr.getWithQueries().forEach(q -> {
                Query ret = (Query) visit(ctx, stack, ((NamedQuery) q).getChild());

                if (TUtil.isNullOrEmpty(ret.getDatasetList())) {
                    ret.setDatasetList(Collections.singletonList(ret));
                }

                ret.setName(((NamedQuery) q).getName());
            });
        }

        final Query query = (Query) super.visitQuery(ctx, stack, expr);

        if (TUtil.isNullOrEmpty(query.getDatasetList())) {
            query.setDatasetList(Collections.singletonList(query));
        }

        return query;
    }

    @Override
    public IASTObject visitProjection(final Context ctx, final Stack<Expr> stack, final Projection expr) {

        final String queryName = "Default";

        final Query query = new Query(queryName);
        query.setIsDistinct(expr.isDistinct());

        final List<ISelectItem> selItems = getSelectItems(ctx, expr);
        query.setSelectList(selItems);

        ctx.query = query;
        super.visitProjection(ctx, stack, expr);

        rootObject = query;

        if (TUtil.isNullOrEmpty(query.getDatasetList())) {
            ((Query) rootObject).setDatasetList(Collections.singletonList(query));
        }

        return query;
    }

    private List<ISelectItem> getSelectItems(final Context ctx, final Projection proj) {
        final List<ISelectItem> selectItems = new ArrayList<>();

        int i = 0;

        for (final NamedExpr si : proj.getNamedExprs()) {
            String alias;

            if (!Objects.isNull(si.getAlias())) {
                alias = SQLExpressionFormatter.encloseIfReservedWord(si.getAlias());
            } else {
                alias = "col_" + Integer.toString(i);
            }

            final Expression expr = new Expression(SQLExpressionFormatter.format(si));
            final SelectItem selItem = new SelectItem(expr, alias);
            selectItems.add(selItem);
            if (ctx.targetColsPosMap.get(i) != null) {
                selItem.setTargetColumn(ctx.targetColsPosMap.get(i));
                ((TargetColumn) ctx.targetColsPosMap.get(i)).setExpression(selItem);
            }
            i++;
        }

        return selectItems;
    }

    @Override
    public IASTObject visitFilter(final Context ctx, final Stack<Expr> stack, final Selection expr) {
        super.visitFilter(ctx, stack, expr);

        ctx.query.setWhereList(TUtil.newList());

        SplitFilterExprVisitor filterVisitor = new SplitFilterExprVisitor();

        Collection<Expr> filterItems = filterVisitor.getFilterConditions(expr);

        for (Expr ic : filterItems) {
            String expressionText = SQLExpressionFormatter.format(ic);
            Expression expression = new Expression(expressionText);
            ctx.query.getWhereList().add((IExpression) expression);
        }

        return null;
    }

    @Override
    public IASTObject visitQuantifiedComparisonPredicate(final Context ctx, final Stack<Expr> stack, final QuantifiedComparisonPredicate expr) {
        String expressionText = SQLExpressionFormatter.format(expr);
        Expression expression = new Expression(expressionText);
        if (ctx.inWhereCondition) {
            ctx.query.getWhereList().add(expression);
        }

        return expression;
    }

    @Override
    public IASTObject visitNot(final Context ctx, final Stack<Expr> stack, final NotExpr expr) {
        return super.visitNot(ctx, stack, expr);
    }

    @Override
    public IASTObject visitOr(final Context ctx, final Stack<Expr> stack, final BinaryOperator expr) {
        return super.visitOr(ctx, stack, expr);
    }

    @Override
    public IASTObject visitAnd(final Context ctx, final Stack<Expr> stack, final BinaryOperator expr) {
        return super.visitAnd(ctx, stack, expr);
    }

    @Override
    public IASTObject visitInPredicate(Context ctx, Stack<Expr> stack, InPredicate expr) {
        String expressionText = SQLExpressionFormatter.format(expr);
        Expression expression = new Expression(expressionText);
        if (ctx.inWhereCondition) {
            ctx.query.getWhereList().add(expression);
        }
        return expression;
    }

    @Override
    public IASTObject visitGroupBy(final Context ctx, final Stack<Expr> stack, final Aggregation expr) {

        ctx.query.setGroupByList(TUtil.newList());

        for (Aggregation.GroupElement groupElement : expr.getGroupSet()) {
            for (Expr groupingSet : groupElement.getGroupingSets()) {
                String expressionText = SQLExpressionFormatter.format(groupingSet);
                Expression expression = new Expression(expressionText);
                ctx.query.getGroupByList().add(expression);
            }
        }

        String groupByExprText = StringUtils.substringAfter(SQLStatementFormatter.format(expr), "GROUP BY\n").trim();
        ctx.query.setGroupByText(groupByExprText);

        return super.visitGroupBy(ctx, stack, expr);
    }

    @Override
    public IASTObject visitUnpivot(Context ctx, Stack<Expr> stack, Unpivot expr) {
        String unpivotText = "UNPIVOT ".concat(StringUtils.substringAfter(SQLStatementFormatter.format(expr), "UNPIVOT ").trim());
        ctx.query.setPivotText(unpivotText);
        
        return super.visitUnpivot(ctx, stack, expr);
    }
    
    @Override
    public IASTObject visitHaving(final Context ctx, final Stack<Expr> stack, final Having expr) {
        return super.visitHaving(ctx, stack, expr);
    }

    @Override
    public IASTObject visitRelationList(final Context ctx, final Stack<Expr> stack, final RelationList expr) {
        ctx.query.setFromList(TUtil.newList());

        for (final Expr rel : expr.getRelations()) {
            final IASTObject relation = visit(ctx, stack, rel);
            if (relation instanceof IRelation iRelation) {
                final org.pecheasoft.odigen.sql.api.ast.impl.Join join = new org.pecheasoft.odigen.sql.api.ast.impl.Join(iRelation, null, null, null);
                ctx.query.getFromList().add(join);
            }
        }
        return ctx.query;
    }

    @Override
    public IASTObject visitJoin(final Context ctx, final Stack<Expr> stack, final Join expr) {

        String joinExprText;
        joinExprText = SQLExpressionFormatter.format(expr.getQual());

        final IJoinComponent left = (IJoinComponent) visit(ctx, stack, expr.getLeft());
        final IJoinComponent right = (IJoinComponent) visit(ctx, stack, expr.getRight());

        final org.pecheasoft.odigen.sql.api.ast.impl.Join join = new org.pecheasoft.odigen.sql.api.ast.impl.Join(expr.getAnnotationParameterValue("PROPERTIES", "NAME"), left, right, expr.getJoinTypeAsSQL(), new Expression(joinExprText));

        ctx.query.getFromList().clear();
        ctx.query.getFromList().add(join);

        return join;
    }

    @Override
    public IASTObject visitRelation(final Context ctx, final Stack<Expr> stack, final Relation expr) {

        String relationName = expr.getName();

        if (withQueries.containsKey(relationName)) {
            Query qry = withQueries.get(relationName).shallowCopy();
            
            if (!TUtil.isNullOrEmpty(expr.getAlias())) {
                qry.setName(expr.getAlias());
            }
            return qry;
        }

        final DatastoreReference table = new DatastoreReference(expr.getName());
        final String alias = SQLExpressionFormatter.encloseIfReservedWord(expr.getAlias());
        table.setAlias(alias);

        return table;
    }

    private List<IDatastoreAttribute> getDatastoreAttributes(final CreateTable expr) {
        final List<IDatastoreAttribute> attributes = TUtil.newList();

        int i = 1;
        for (final ColumnDefinition col : expr.getTableElements()) {
            final DatastoreAttribute dsa = new DatastoreAttribute();
            dsa.setName(SQLExpressionFormatter.encloseIfReservedWord(col.getColumnName()));
            attributes.add(dsa);

            if (!TUtil.isNullOrEmpty(col.getTypeName())) {
                dsa.setDataType(col.getTypeName());
            }

            dsa.setPosition(i++);

            dsa.setIsMandatory(!col.isOptional());

            if (col.getLengthOrPrecision() != null) {
                dsa.setPrecision(col.getLengthOrPrecision());
                dsa.setLength(col.getLengthOrPrecision());
            }

            if (col.getScale() != null) {
                dsa.setScale(col.getScale());
            }

            if (!TUtil.isNullOrEmpty(col.getFormat())) {
                dsa.setFormat(col.getFormat());
            }

            if (!TUtil.isNullOrEmpty(col.getScdBehavior())) {
                dsa.setScdBehavior(col.getScdBehavior());
            }

            if (!TUtil.isNullOrEmpty(col.getDescription())) {
                dsa.setDescription(col.getDescription());
            }

            if (!TUtil.isNullOrEmpty(col.getAnnotations())) {  
                dsa.setAnnotations(col.getAnnotations());
            }

        }

        return attributes;
    }

    class SplitFilterExprVisitor extends BaseAlgebraVisitor<SplitFilterExprVisitor.Context, Expr> {

        class Context {

            final Collection<Expr> itemsList = TUtil.newList();
        }

        final Context ctx = new Context();
        final Stack<Expr> stack = new Stack<>();

        public Collection<Expr> getFilterConditions(Expr expr) {
            visitFilter(ctx, stack, (Selection) expr);
            return ctx.itemsList;
        }

        @Override
        public Expr visitFilter(Context ctx, Stack<Expr> stack, Selection expr) {
            Expr condition = expr.getQual();

            if (!(condition instanceof BinaryOperator && ((BinaryOperator) condition).getOperator() == Operator.And)) {
                ctx.itemsList.add(condition);
            }
            if (expr.getQual() instanceof QuantifiedComparisonPredicate) {
                return super.visit(new Context(), stack, expr.getQual());
            } else {
                return super.visit(ctx, stack, expr.getQual());
            }
        }
        
        @Override
        public Expr visitAnd(Context ctx, Stack<Expr> stack, BinaryOperator expr) {
            String rightAnnotationName = expr.getRight().getNameAnnotation();
            
            if (TUtil.isNullOrEmpty(rightAnnotationName)) {
                expr.getLeft().setAnnotations(null);
                ctx.itemsList.add(expr);
            } else {
                ctx.itemsList.add(expr.getLeft());

                if (expr.getRight() instanceof BinaryOperator) {
                    BinaryOperator op = expr.getRight();
                    if (op.getOperator() == Operator.And) {
                        visit(ctx, stack, expr.getRight());
                    } else {
                        ctx.itemsList.add(expr.getRight());
                    }
                } else {
                    Expr e = expr.getRight();
                    ctx.itemsList.add(e);
                }
            }

            return expr;
        }
    }
}
