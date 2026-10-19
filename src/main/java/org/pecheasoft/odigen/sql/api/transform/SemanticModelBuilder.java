package org.pecheasoft.odigen.sql.api.transform;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.lang3.StringUtils;
import org.pecheasoft.odigen.sql.api.ast.SemanticModel;
import org.pecheasoft.odigen.sql.api.ast.SemanticNestedQueryBlock;
import org.pecheasoft.odigen.sql.api.ast.SemanticQueryBlock;
import org.pecheasoft.odigen.sql.api.ast.SemanticAnnotationSet;
import org.pecheasoft.odigen.sql.api.ast.SemanticAssignment;
import org.pecheasoft.odigen.sql.api.ast.SemanticExpression;
import org.pecheasoft.odigen.sql.api.ast.SemanticJoinSource;
import org.pecheasoft.odigen.sql.api.ast.SemanticSimpleQueryBlock;
import org.pecheasoft.odigen.sql.api.ast.SemanticSetQueryBlock;
import org.pecheasoft.odigen.sql.api.ast.SemanticRelation;
import org.pecheasoft.odigen.sql.api.ast.impl.Datastore;
import org.pecheasoft.odigen.sql.api.ast.impl.DatastoreAttribute;
import org.pecheasoft.odigen.sql.api.ast.impl.DatastoreCondition;
import org.pecheasoft.odigen.sql.api.ast.impl.DatastoreKey;
import org.pecheasoft.odigen.sql.api.ast.impl.DatastoreReferenceNode;
import org.pecheasoft.odigen.sql.api.ast.impl.InsertNode;
import org.pecheasoft.odigen.sql.api.ast.impl.JoinNode;
import org.pecheasoft.odigen.sql.api.ast.impl.MultiInsertTableNode;
import org.pecheasoft.odigen.sql.api.ast.impl.SelectItem;
import org.pecheasoft.odigen.sql.api.ast.impl.Expression;
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
import org.pecheasoft.odigen.sql.parse.algebra.Limit;
import org.pecheasoft.odigen.sql.parse.algebra.Sort;
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
import org.pecheasoft.odigen.sql.util.annotation.AnnotationTransformer;


/**
 *
 * @author Adi Neagu
 *
 * Transforms a object of type Expr in the equivalent structured expression CreateTable -> Datastore Insert -> InsertStatement
 */
public class SemanticModelBuilder extends BaseAlgebraVisitor<SemanticModelBuilder.Context, SemanticModel> {

    Map<String, SemanticQueryBlock> withQueries = TUtil.newHashMap();
    private Map<String, NamedQuery> withDefinitions = new LinkedHashMap<>();
    private final Set<NamedQuery> resolvingWithQueries = Collections.newSetFromMap(new IdentityHashMap<>());

    private SemanticModel rootObject = null;

    private Expression expression(String text) {
        return new Expression(text, withDefinitions.keySet());
    }

    public static class Context {
        final Map<Integer, SemanticAssignment> targetColsPosMap = TUtil.newHashMap();
        final Map<String, SemanticQueryBlock> withQueries = TUtil.newHashMap();
        SemanticQueryBlock queryBlock;
        boolean inWhereCondition;
    }

    public static SemanticModel getStructuredObject(final Expr source) {
        Context ctx = new SemanticModelBuilder.Context();
        SemanticModelBuilder visitor = new SemanticModelBuilder();

        return visitor.visit(ctx, new Stack<>(), source);
    }

    @Override
    public SemanticModel visitCreateTable(final Context ctx, final Stack<Expr> stack, final CreateTable expr) {
        Datastore datastore = new Datastore();

        SemanticAnnotationSet semanticAnnotationSet = new SemanticAnnotationSet(
            AnnotationTransformer.toSemanticList(List.copyOf(expr.getAnnotations()))
        );

        if (expr.getAnnotations() != null) {
            datastore.setAnnotations(semanticAnnotationSet);
        }

        if (!TUtil.isNullOrEmpty(expr.getTableKeys())) {
            final List<DatastoreKey> keys = expr.getTableKeys().stream()
                    .filter(c -> c.isPrimaryKey() || c.isAlternateKey() || c.isNonUniqueIndex())
                    .map(DatastoreKey::new)
                    .collect(Collectors.toList());

            datastore.setKeys(keys);

            final List<DatastoreCondition> conditions = expr.getTableKeys().stream()
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
    public SemanticModel visitMultiInsert(Context ctx, Stack<Expr> stack, MultiInsert expr) {
        final InsertNode insertStmt = new InsertNode();
        SemanticQueryBlock query = (SemanticQueryBlock) visit(ctx, stack, expr.getSubQuery());

        insertStmt.setQuery(query);

        rootObject = insertStmt;

        if (expr.getAnnotations() != null) {
            SemanticAnnotationSet semanticAnnotationSet = new SemanticAnnotationSet(
                AnnotationTransformer.toSemanticList(List.copyOf(expr.getAnnotations()))
            );
            insertStmt.setAnnotations(semanticAnnotationSet);
        }

        List<MultiInsertTableNode> targets = TUtil.newList();

        insertStmt.setMultiInsertTargets(targets);

        for (MultiInsertTarget insTarg : expr.getTargets()) {
            MultiInsertTableNode targ = new MultiInsertTableNode();
            String name = insTarg.getTableName();
            String alias = insTarg.getTableAlias();
            String condition = insTarg.getCondition() == null ? null : SQLExpressionFormatter.format(insTarg.getCondition());

            targ.setTarget(new DatastoreReferenceNode(name, alias));
            targ.setCondition(condition);
            targ.setIntegrationType(insTarg.getIntegrationType());
            targ.setUpdateKey(insTarg.getUpdateKey());
            targ.setRejectLimit(insTarg.getRejectLimit());
            targ.setRejectLimitUnit(insTarg.getRejectLimitUnit());

            if (insTarg.getAnnotations() != null) {
                SemanticAnnotationSet semanticAnnotationSet = new SemanticAnnotationSet(
                    AnnotationTransformer.toSemanticList(List.copyOf(insTarg.getAnnotations()))
                );
                targ.setAnnotations(semanticAnnotationSet);
            }

            Expr[] expressions = insTarg.getExpressions();

            Map<String, Expr> exprMap = IntStream.rangeClosed(0, expressions.length - 1)
                    .mapToObj(i -> new NamedExpr(expressions[i], Integer.toString(i)))
                    .collect(Collectors.toMap(NamedExpr::getAlias, NamedExpr::getExpr));

            List<SelectItem> targetCols = IntStream
                    .rangeClosed(0, insTarg.getTargetColumns().size() - 1)
                    .mapToObj(pos -> new SelectItem(expression((exprMap.get(Integer.toString(pos))).getText()), insTarg.getTargetColumns().get(pos).getName()))
                    .collect(Collectors.toList());

            targ.setSelectList(targetCols);

            targets.add(targ);
        }

        return insertStmt;
    }

    @Override
    public InsertNode visitInsert(final Context ctx, final Stack<Expr> stack, final Insert expr) {
        final InsertNode insertStmt = new InsertNode();
        insertStmt.setIntegrationType(expr.getIntegrationType());
        insertStmt.setUpdateKey(expr.getUpdateKey());
        insertStmt.setRejectLimit(expr.getRejectLimit());
        insertStmt.setRejectLimitUnit(expr.getRejectLimitUnit());

        final DatastoreReferenceNode targetTable = getTargetTable(expr);
        targetTable.setIsTarget(true);

        insertStmt.setTargetTable(targetTable);
        insertStmt.setColumns(getTargetColumns(ctx, expr, targetTable));

        //SemanticQueryBlock query = new SemanticSetQueryBlock();
        //ctx.queryBlock = query;

        SemanticQueryBlock query = (SemanticQueryBlock) visit(ctx, stack, expr.getSubQuery());

        insertStmt.setQuery(query);

        rootObject = insertStmt;

        if (expr.getAnnotations() != null) {
            SemanticAnnotationSet semanticAnnotationSet = new SemanticAnnotationSet(
                AnnotationTransformer.toSemanticList(List.copyOf(expr.getAnnotations()))
            );
            insertStmt.setAnnotations(semanticAnnotationSet);
        }

        return insertStmt;
    }

    private DatastoreReferenceNode getTargetTable(final Insert insert) {
        final String targetTableName = insert.getTableName();
        final DatastoreReferenceNode table = new DatastoreReferenceNode(targetTableName, insert.getTableAlias());
        return table;
    }

    private List<SemanticAssignment> getTargetColumns(final Context ctx, final Insert insert,
            final DatastoreReferenceNode table) {
        final List<SemanticAssignment> targetColumns = TUtil.newList();

        if (insert.getTargetColumns() == null) return targetColumns;

        int i = 0;
        for (final org.pecheasoft.odigen.sql.parse.algebra.TargetColumn col : insert.getTargetColumns()) {
            final String name = col.getName();
            SemanticAssignment tc;

            if (table.getDatastore() != null) {
                final DatastoreAttribute attr = table.getDatastore().getAttribute(name);
                tc = new SemanticAssignment(SQLExpressionFormatter.encloseIfReservedWord(name), i++, attr, table);
            } else {
                tc = new SemanticAssignment(SQLExpressionFormatter.encloseIfReservedWord(name), i++, null, table);
            }

            if (col.getAnnotations() != null) {
                SemanticAnnotationSet semanticAnnotationSet = new SemanticAnnotationSet(
                    AnnotationTransformer.toSemanticList(List.copyOf(col.getAnnotations()))
                );
                tc.setAnnotations(semanticAnnotationSet);
            }
    
            targetColumns.add(tc);
            ctx.targetColsPosMap.put(tc.getPosition(), tc);
        }

        return targetColumns;
    }

    @Override
    public SemanticNestedQueryBlock visitTableSubQuery(final Context ctx, final Stack<Expr> stack, final TablePrimarySubQuery expr) {
        final Context newCtx = new Context();

        //SemanticQueryBlock query = new SemanticSimpleQueryBlock();
        //newCtx.queryBlock = query;

        SemanticQueryBlock query = (SemanticQueryBlock) visit(newCtx, stack, expr.getSubQuery());

        return new SemanticNestedQueryBlock(query, expr.getAlias());
    }

    @Override
    public SemanticQueryBlock visitSimpleTableSubQuery(Context ctx, Stack<Expr> stack, SimpleTableSubQuery expr) {
        final Context newCtx = new Context();

        //SemanticSimpleQueryBlock query = new SemanticSimpleQueryBlock();
        //newCtx.queryBlock = query;

        SemanticQueryBlock query = (SemanticQueryBlock) visit(newCtx, stack, expr.getSubQuery());

        return query;
    }

    @Override
    public SemanticModel visitIntersect(Context ctx, Stack<Expr> stack, SetOperation expr) {
        return visitUnion(ctx, stack, expr);
    }

    @Override
    public SemanticModel visitExcept(Context ctx, Stack<Expr> stack, SetOperation expr) {
        return visitUnion(ctx, stack, expr);
    }

    @Override
    public SemanticSetQueryBlock visitUnion(final Context ctx, final Stack<Expr> stack, final SetOperation expr) {
        SemanticSetQueryBlock queryBlockSet = new SemanticSetQueryBlock();

        for (int i = 0; i < expr.getOperands().length; i++) {
            final Expr operand = expr.getOperands()[i];

            final SetOperation.Type setOpType = expr.getOperationTypes()[i];
            String setOperation = null;
            if (setOpType != null) {
                setOperation = expr.getOperationTypes()[i].toString().toUpperCase();
                final Boolean isDistinct = expr.getDistinctIndicators()[i];
                if (isDistinct == null || !isDistinct) {
                    setOperation = setOperation.concat(" ALL");
                }
            }

            final SemanticQueryBlock qry = (SemanticQueryBlock) visit(ctx, stack, operand);

            
            queryBlockSet.addDataset(new SemanticSetQueryBlock.Dataset(qry, setOperation));

        }

        return queryBlockSet;
    }

    @Override
    public SemanticQueryBlock visitQuery(final Context ctx, final Stack<Expr> stack, final org.pecheasoft.odigen.sql.parse.algebra.Query expr) {
        Map<String, SemanticQueryBlock> enclosingQueries = withQueries;
        Map<String, NamedQuery> enclosingDefinitions = withDefinitions;
        withQueries = new HashMap<>(enclosingQueries);
        withDefinitions = new LinkedHashMap<>(enclosingDefinitions);
        if (expr.getWithQueries() != null) {
            for (Expr definition : expr.getWithQueries()) {
                NamedQuery named = (NamedQuery) definition;
                withDefinitions.put(named.getName(), named);
                withQueries.remove(named.getName());
            }
        }
        try {
            // Resolve each definition once in its declaring scope. Dependencies are
            // resolved recursively, so forward references do not need repeated passes.
            if (expr.getWithQueries() != null) {
                for (Expr definition : expr.getWithQueries()) {
                    visitRelation(new Context(), new Stack<>(), new Relation(((NamedQuery) definition).getName()));
                }
            }
            return (SemanticQueryBlock) super.visitQuery(ctx, stack, expr);
        } finally {
            withQueries = enclosingQueries;
            withDefinitions = enclosingDefinitions;
        }
    }

    @Override
    public SemanticModel visitProjection(final Context ctx, final Stack<Expr> stack, final Projection expr) {

        final String queryName = "Default";

        final SemanticSimpleQueryBlock query = new SemanticSimpleQueryBlock(queryName);
        query.setIsDistinct(expr.isDistinct());
        if (expr.getAnnotations() != null) {
            query.setAnnotations(new SemanticAnnotationSet(
                    AnnotationTransformer.toSemanticList(List.copyOf(expr.getAnnotations()))));
        }

        final List<SelectItem> selItems = getSelectItems(ctx, expr);
        query.setSelectList(selItems);

        ctx.queryBlock = query;
        // Projection expressions already live in semantic Expression objects. Traversing
        // their algebra subqueries here would replace the enclosing query's context.
        if (expr.hasChild()) visit(ctx, stack, expr.getChild());
        ctx.queryBlock = query;

        rootObject = query;

        return query;
    }

    private List<SelectItem> getSelectItems(final Context ctx, final Projection proj) {
        final List<SelectItem> selectItems = new ArrayList<>();

        int i = 0;

        for (final NamedExpr si : proj.getNamedExprs()) {
            String alias;

            if (!Objects.isNull(si.getAlias())) {
                alias = SQLExpressionFormatter.encloseIfReservedWord(si.getAlias());
            } else {
                alias = "col_" + Integer.toString(i);
            }

            final Expression expr = expression(SQLExpressionFormatter.format(si));
            final SelectItem selItem = new SelectItem(expr, alias);
            selectItems.add(selItem);
            if (ctx.targetColsPosMap.get(i) != null) {
                selItem.setTargetColumn(ctx.targetColsPosMap.get(i));
                ((SemanticAssignment) ctx.targetColsPosMap.get(i)).setExpression(selItem);
            }
            i++;
        }

        return selectItems;
    }

    @Override
    public SemanticModel visitFilter(final Context ctx, final Stack<Expr> stack, final Selection expr) {
        super.visitFilter(ctx, stack, expr);

        // a filter can exists only in a SemanticSimpleQueryBlock
        if (ctx.queryBlock instanceof SemanticSimpleQueryBlock queryBlock) {
            queryBlock.setWhereList(TUtil.newList());
        }

        SplitFilterExprVisitor filterVisitor = new SplitFilterExprVisitor();

        List<Expr> filterItems = filterVisitor.getFilterConditions(expr);

        for (Expr ic : filterItems) {
            String expressionText = SQLExpressionFormatter.format(ic);
            Expression expression = expression(expressionText);
            if (ctx.queryBlock instanceof SemanticSimpleQueryBlock queryBlock) {
                queryBlock.getWhereList().add((SemanticExpression) expression);
            }
        }

        return null;
    }

    @Override
    public SemanticModel visitQuantifiedComparisonPredicate(final Context ctx, final Stack<Expr> stack, final QuantifiedComparisonPredicate expr) {
        String expressionText = SQLExpressionFormatter.format(expr);
        Expression expression = expression(expressionText);
        if (ctx.inWhereCondition) {
            if (ctx.queryBlock instanceof SemanticSimpleQueryBlock queryBlock) {
                queryBlock.getWhereList().add(expression);
            }
        }

        return expression;
    }

    @Override
    public SemanticModel visitNot(final Context ctx, final Stack<Expr> stack, final NotExpr expr) {
        return super.visitNot(ctx, stack, expr);
    }

    @Override
    public SemanticModel visitOr(final Context ctx, final Stack<Expr> stack, final BinaryOperator expr) {
        return super.visitOr(ctx, stack, expr);
    }

    @Override
    public SemanticModel visitAnd(final Context ctx, final Stack<Expr> stack, final BinaryOperator expr) {
        return super.visitAnd(ctx, stack, expr);
    }

    @Override
    public SemanticModel visitInPredicate(Context ctx, Stack<Expr> stack, InPredicate expr) {
        String expressionText = SQLExpressionFormatter.format(expr);
        Expression expression = expression(expressionText);
        if (ctx.inWhereCondition) {
            if (ctx.queryBlock instanceof SemanticSimpleQueryBlock queryBlock) {
                queryBlock.getWhereList().add(expression);
            }
        }
        return expression;
    }

    @Override
    public SemanticModel visitGroupBy(final Context ctx, final Stack<Expr> stack, final Aggregation expr) {

        if (ctx.queryBlock instanceof SemanticSimpleQueryBlock queryBlock) {
            queryBlock.setGroupByList(TUtil.newList());
        }

        for (Aggregation.GroupElement groupElement : expr.getGroupSet()) {
            for (Expr groupingSet : groupElement.getGroupingSets()) {
                String expressionText = SQLExpressionFormatter.format(groupingSet);
                Expression expression = expression(expressionText);
                if (ctx.queryBlock instanceof SemanticSimpleQueryBlock queryBlock) {
                    queryBlock.getGroupByList().add(expression);
                }
            }
        }

        String groupByExprText = StringUtils.substringAfter(SQLStatementFormatter.format(expr), "GROUP BY\n").trim();
        if (ctx.queryBlock instanceof SemanticSimpleQueryBlock queryBlock) {
            queryBlock.setGroupByText(groupByExprText);
        }

        return super.visitGroupBy(ctx, stack, expr);
    }

    @Override
    public SemanticModel visitUnpivot(Context ctx, Stack<Expr> stack, Unpivot expr) {
        String unpivotText = "UNPIVOT ".concat(StringUtils.substringAfter(SQLStatementFormatter.format(expr), "UNPIVOT ").trim());
        if (ctx.queryBlock instanceof SemanticSimpleQueryBlock queryBlock) {
            queryBlock.setPivotText(unpivotText);
        }
        
        return super.visitUnpivot(ctx, stack, expr);
    }
    
    @Override
    public SemanticModel visitHaving(final Context ctx, final Stack<Expr> stack, final Having expr) {
        SemanticSimpleQueryBlock query = requireSimpleQuery(ctx, "HAVING");
        SemanticModel result = visit(ctx, stack, expr.getChild());
        String text = SQLExpressionFormatter.format(expr.getQual());
        query.setHavingList(new ArrayList<>(List.of(expression(text))));
        query.setHavingText(text);
        return result;
    }

    @Override
    public SemanticModel visitSort(Context ctx, Stack<Expr> stack, Sort expr) {
        SemanticSimpleQueryBlock query = requireSimpleQuery(ctx, "ORDER BY");
        SemanticModel result = visit(ctx, stack, expr.getChild());
        List<SemanticExpression> items = Arrays.stream(expr.getSortSpecs())
                .map(spec -> (SemanticExpression) expression(
                        SQLExpressionFormatter.format(spec.getKey())
                        + (spec.isAscending() ? " ASC" : " DESC")
                        + (spec.isNullFirst() ? " NULLS FIRST" : " NULLS LAST")))
                .collect(Collectors.toCollection(ArrayList::new));
        query.setOrderByList(items);
        query.setOrderByText(items.stream().map(SemanticExpression::getText)
                .collect(Collectors.joining(", ")));
        return result;
    }

    @Override
    public SemanticModel visitLimit(Context ctx, Stack<Expr> stack, Limit expr) {
        SemanticSimpleQueryBlock query = requireSimpleQuery(ctx, "LIMIT");
        SemanticModel result = visit(ctx, stack, expr.getChild());
        query.setLimit(expression(SQLExpressionFormatter.format(expr.getFetchFirstNum())));
        return result;
    }

    private SemanticSimpleQueryBlock requireSimpleQuery(Context ctx, String clause) {
        if (ctx.queryBlock instanceof SemanticSimpleQueryBlock query) {
            return query;
        }
        throw new IllegalArgumentException("Cannot represent " + clause + " outside a simple query block");
    }

    @Override
    public SemanticModel visitRelationList(final Context ctx, final Stack<Expr> stack, final RelationList expr) {
        if (ctx.queryBlock instanceof SemanticSimpleQueryBlock queryBlock) {
            queryBlock.setFromList(TUtil.newList());
        }

        for (final Expr rel : expr.getRelations()) {
            final SemanticModel relation = visit(ctx, stack, rel);
            if (relation instanceof SemanticRelation iRelation) {
                final JoinNode join = new JoinNode(iRelation, null, null, null);
                if (ctx.queryBlock instanceof SemanticSimpleQueryBlock queryBlock) {
                    queryBlock.getFromList().add(join);
                }
            }
        }
        return ctx.queryBlock;
    }

    @Override
    public SemanticModel visitJoin(final Context ctx, final Stack<Expr> stack, final Join expr) {

        String joinExprText;
        joinExprText = SQLExpressionFormatter.format(expr.getQual());

        final SemanticJoinSource left = (SemanticJoinSource) visit(ctx, stack, expr.getLeft());
        final SemanticJoinSource right = (SemanticJoinSource) visit(ctx, stack, expr.getRight());

        final org.pecheasoft.odigen.sql.api.ast.impl.JoinNode join = new org.pecheasoft.odigen.sql.api.ast.impl.JoinNode(expr.getAnnotationParameterValue("PROPERTIES", "NAME"), left, right, expr.getJoinTypeAsSQL(), expression(joinExprText));

        if (ctx.queryBlock instanceof SemanticSimpleQueryBlock queryBlock) {
            queryBlock.getFromList().clear();
            queryBlock.getFromList().add(join);
        }

        return join;
    }

    @Override
    public SemanticModel visitRelation(final Context ctx, final Stack<Expr> stack, final Relation expr) {

        String relationName = expr.getName();        

        if (withDefinitions.containsKey(relationName)) {
            SemanticQueryBlock query = withQueries.get(relationName);
            if (query == null) {
                NamedQuery definition = withDefinitions.get(relationName);
                if (!resolvingWithQueries.add(definition)) {
                    throw new IllegalArgumentException("Recursive WITH query cannot be expanded: " + relationName);
                }
                try {
                    query = (SemanticQueryBlock) visit(new Context(), new Stack<>(), definition.getChild());
                    withQueries.put(relationName, query);
                } finally {
                    resolvingWithQueries.remove(definition);
                }
            }
            String alias = expr.getAlias() == null ? relationName : expr.getAlias();
            return new SemanticNestedQueryBlock(query.shallowCopy(), alias);
        }

        final DatastoreReferenceNode table = new DatastoreReferenceNode(expr.getName());
        final String alias = SQLExpressionFormatter.encloseIfReservedWord(expr.getAlias());
        table.setAlias(alias);

        return table;
    }

    private List<DatastoreAttribute> getDatastoreAttributes(final CreateTable expr) {
        final List<DatastoreAttribute> attributes = TUtil.newList();

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
                SemanticAnnotationSet semanticAnnotationSet = new SemanticAnnotationSet(
                    AnnotationTransformer.toSemanticList(List.copyOf(col.getAnnotations()))
                );
                dsa.setAnnotations(semanticAnnotationSet);
            }

        }

        return attributes;
    }

    class SplitFilterExprVisitor extends BaseAlgebraVisitor<SplitFilterExprVisitor.Context, Expr> {

        class Context {

            final List<Expr> itemsList = TUtil.newList();
        }

        final Context ctx = new Context();
        final Stack<Expr> stack = new Stack<>();

        public List<Expr> getFilterConditions(Expr expr) {
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
