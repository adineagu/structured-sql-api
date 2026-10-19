package org.pecheasoft.odigen.render;

import java.util.List;
import java.util.Objects;
import java.util.Stack;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.pecheasoft.odigen.sql.api.ast.*;
import org.pecheasoft.odigen.sql.api.ast.impl.*;
import org.pecheasoft.odigen.sql.api.transform.BaseSemanticModelVisitor;

/** Per-generation rendering choices. No business or integration strategy is implemented here. */
public class TransformationContext {
    public enum LimitStyle { UNSUPPORTED, LIMIT, FETCH_FIRST }
    private Function<DatastoreReferenceNode, String> sourceNames = DatastoreReferenceNode::getName;
    private Function<DatastoreReferenceNode, String> targetNames = DatastoreReferenceNode::getName;
    private Function<SemanticModel, String> integrationRenderer;
    private LimitStyle limitStyle = LimitStyle.UNSUPPORTED;

    /** Template-friendly access to general AST preparation, without a Java constructor in the template. */
    public InsertNode prependAssignments(InsertNode insert, java.util.Map<String, String> additions) {
        return org.pecheasoft.odigen.sql.api.transform.AstTransformations.prependAssignments(insert, additions);
    }
    public String require(boolean condition, String message) {
        if (!condition) throw new IllegalArgumentException(message);
        return "";
    }
    public String removeAnnotation(SemanticModel model, String name) {
        if (model.annotations() != null) {
            model.annotations().setAnnotations(model.annotations().all().stream().filter(a -> !a.name().equals(name)).toList());
        }
        return "";
    }
    public String quotedIdentifier(String name) {
        return "\"" + nonblank(name, "Identifier").replace("\"", "\"\"") + "\"";
    }
    /** Use definition-declared table names; no schema or prefix conventions are inferred. */
    public TransformationContext useDeclaredDatastoreNames() {
        Function<DatastoreReferenceNode, String> declared = table -> {
            if (table.getDatastore() == null) throw new IllegalArgumentException("Unresolved table: " + table.getName());
            return table.getDatastore().getName();
        };
        return withSourceNames(declared).withTargetNames(declared);
    }

    /** Copy configuration for one render; callbacks themselves should be side-effect free. */
    public TransformationContext copy() {
        TransformationContext copy = new TransformationContext();
        copy.sourceNames = sourceNames;
        copy.targetNames = targetNames;
        copy.integrationRenderer = integrationRenderer;
        copy.limitStyle = limitStyle;
        return copy;
    }

    public TransformationContext withSourceNames(Function<DatastoreReferenceNode, String> names) {
        sourceNames = Objects.requireNonNull(names); return this;
    }
    public TransformationContext withTargetNames(Function<DatastoreReferenceNode, String> names) {
        targetNames = Objects.requireNonNull(names); return this;
    }

    /** Build a naming callback from template-owned rules; no platform conventions are assumed. */
    public Function<DatastoreReferenceNode, String> tableNames(String pattern,
            java.util.Map<String, String> namespaces, boolean lowercaseBasename) {
        nonblank(pattern, "Table name pattern");
        String remaining = pattern.replace("{namespace}", "").replace("{basename}", "");
        if (!pattern.contains("{namespace}") || !pattern.contains("{basename}")
                || remaining.contains("{") || remaining.contains("}")) {
            throw new IllegalArgumentException("Table name pattern requires {namespace} and {basename} only");
        }
        var rules = new java.util.HashMap<String, String>();
        Objects.requireNonNull(namespaces, "namespaces").forEach((key, value) -> {
            String normalized = nonblank(key, "Logical qualifier").toUpperCase(java.util.Locale.ROOT);
            if (rules.putIfAbsent(normalized, nonblank(value, "Physical namespace")) != null) {
                throw new IllegalArgumentException("Duplicate logical qualifier: " + key);
            }
        });
        var frozen = java.util.Map.copyOf(rules);
        return table -> {
            String namespace = frozen.get(table.getQualifier().toUpperCase(java.util.Locale.ROOT));
            if (namespace == null) throw new IllegalArgumentException("No naming rule for table: " + table.getName());
            String basename = lowercaseBasename ? table.getBasename().toLowerCase(java.util.Locale.ROOT) : table.getBasename();
            // One substitution pass prevents replacement values being interpreted as pattern tokens.
            var matcher = java.util.regex.Pattern.compile("\\{namespace\\}|\\{basename\\}").matcher(pattern);
            return matcher.replaceAll(match -> java.util.regex.Matcher.quoteReplacement(
                    match.group().equals("{namespace}") ? namespace : basename));
        };
    }
    public TransformationContext withLimitStyle(LimitStyle style) {
        limitStyle = Objects.requireNonNull(style); return this;
    }
    /** Optional serialization of existing integration settings, not interpretation of annotations. */
    public TransformationContext withIntegrationRenderer(Function<SemanticModel, String> renderer) {
        integrationRenderer = Objects.requireNonNull(renderer); return this;
    }
    private String nonblank(String value, String what) {
        if (value == null || value.isBlank()) throw new IllegalArgumentException(what + " must not be blank");
        return value;
    }
    public String sourceName(DatastoreReferenceNode table) {
        String name = nonblank(sourceNames.apply(table), "Source name");
        if (table.getAlias() == null && !name.equals(table.getName())) {
            throw new IllegalArgumentException("Add an explicit alias before renaming source '" + table.getName() + "'");
        }
        return name;
    }
    public String targetName(DatastoreReferenceNode table) {
        return nonblank(targetNames.apply(table), "Target name");
    }
    public String expression(SemanticExpression expression) {
        if (expression instanceof Expression text && !text.getEnclosingCteReferences().isEmpty()) {
            throw new IllegalArgumentException("Query renderer cannot emit enclosing CTE dependencies inside an expression: "
                    + text.getEnclosingCteReferences());
        }
        return nonblank(expression.render(sourceNames), "Expression");
    }
    public boolean has(List<?> list) { return list != null && !list.isEmpty(); }
    public String unsupported(SemanticModel node) {
        throw new IllegalArgumentException("Unsupported renderer position for " + node.getClass().getSimpleName());
    }
    public boolean setParentheses(SemanticQueryBlock node) {
        return node instanceof SemanticSetQueryBlock || node instanceof SemanticSimpleQueryBlock simple
                && (simple.getLimit() != null || has(simple.getOrderByList()));
    }
    public String kind(SemanticModel node) {
        return switch (node) {
            case InsertNode ignored -> "insert";
            case SemanticNestedQueryBlock ignored -> "nested";
            case SemanticSimpleQueryBlock ignored -> "simple";
            case SemanticSetQueryBlock ignored -> "set";
            case JoinNode ignored -> "join";
            case DatastoreReferenceNode ignored -> "table";
            default -> throw new IllegalArgumentException("Query renderer does not support " + node.getClass().getSimpleName());
        };
    }
    public SemanticModel left(JoinNode join) {
        if (join.getLeftJoin() != null) return join.getLeftJoin();
        if (join.getLeftQuery() != null) return join.getLeftQuery();
        return join.getLeftTable();
    }
    public SemanticModel right(JoinNode join) {
        if (join.getRightJoin() != null) return join.getRightJoin();
        if (join.getRightQuery() != null) return join.getRightQuery();
        return join.getRightTable();
    }
    public String limitClause(SemanticSimpleQueryBlock query) {
        if (query.getLimit() == null) return "";
        return switch (limitStyle) {
            case LIMIT -> "LIMIT " + expression(query.getLimit());
            case FETCH_FIRST -> "FETCH FIRST " + expression(query.getLimit()) + " ROWS ONLY";
            case UNSUPPORTED -> throw new IllegalArgumentException("Select a LimitStyle before rendering a row limit");
        };
    }
    public String annotations(SemanticModel node) {
        if (node.annotations() == null) return "";
        return node.annotations().all().stream().map(a -> "@" + a.name()
                + (a.attributes().isEmpty() ? "" : a.attributes().entrySet().stream()
                    .sorted(java.util.Map.Entry.comparingByKey())
                    .map(e -> e.getKey() + "=\"" + e.getValue().replace("\\", "\\\\").replace("\"", "\\\"") + "\"")
                    .collect(Collectors.joining(", ", "(", ")"))))
                .collect(Collectors.joining("\n"));
    }
    public boolean hasIntegrationSettings(SemanticModel node) {
        return node instanceof InsertNode insert
                ? insert.getIntegrationType() != null || insert.getUpdateKey() != null || insert.getRejectLimit() != null || insert.getRejectLimitUnit() != null
                : node instanceof MultiInsertTableNode target
                    && (target.getIntegrationType() != null || target.getUpdateKey() != null || target.getRejectLimit() != null || target.getRejectLimitUnit() != null);
    }
    public String integration(SemanticModel node) {
        if (!hasIntegrationSettings(node)) return "";
        if (integrationRenderer == null) throw new IllegalArgumentException("Supply an integration renderer for explicit integration settings");
        return nonblank(integrationRenderer.apply(node), "Integration clause");
    }
    /** Validate supported forms before the template emits output. */
    public String validate(SemanticModel model) {
        kind(model);
        new BaseSemanticModelVisitor<Void, Void>() {
            @Override public Void visit(Void unused, Stack<SemanticModel> stack, SemanticModel node) {
                if (stack.contains(node)) throw new IllegalArgumentException("Cyclic AST cannot be rendered");
                if (node instanceof SemanticSimpleQueryBlock q && !(q instanceof SemanticNestedQueryBlock)) {
                    if (!has(q.getSelectList())) throw new IllegalArgumentException("Query has no projections");
                    if (has(q.getWithList()) || q.getWithText() != null && !q.getWithText().isBlank())
                        throw new IllegalArgumentException("Render expanded CTEs; raw WITH clauses are unsupported");
                    if (q.getPivotText() != null && !q.getPivotText().isBlank())
                        throw new IllegalArgumentException("Pivot/unpivot rendering is not supported by library.Query");
                    if (q.getFromText() != null && !q.getFromText().isBlank())
                        throw new IllegalArgumentException("Render structured FROM sources instead of raw fromText");
                    requireStructured(q.getGroupByList(), q.getGroupByText(), "GROUP BY");
                    requireStructured(q.getHavingList(), q.getHavingText(), "HAVING");
                    requireStructured(q.getOrderByList(), q.getOrderByText(), "ORDER BY");
                    limitClause(q);
                }
                if (node instanceof SemanticSetQueryBlock set) {
                    if (!has(set.getDatasets())) throw new IllegalArgumentException("Set query has no datasets");
                    for (int i = 0; i < set.getDatasets().size(); i++) {
                        String op = set.getDatasets().get(i).getSetOperator();
                        if (i == 0 ? op != null : op == null || !List.of("UNION", "UNION ALL", "INTERSECT", "INTERSECT ALL", "EXCEPT", "EXCEPT ALL").contains(op))
                            throw new IllegalArgumentException("Invalid set operator position: " + op);
                    }
                }
                if (node instanceof JoinNode join) {
                    if (left(join) == null) throw new IllegalArgumentException("Join has no left source");
                    if (right(join) != null && (join.getJoinType() == null || !List.of("INNER JOIN", "LEFT JOIN", "RIGHT JOIN", "FULL OUTER JOIN", "CROSS JOIN").contains(join.getJoinType())))
                        throw new IllegalArgumentException("Unsupported join type: " + join.getJoinType());
                    if (right(join) == null && (join.getJoinType() != null || join.getJoinExpression() != null))
                        throw new IllegalArgumentException("Incomplete join");
                    if (right(join) != null && !"CROSS JOIN".equals(join.getJoinType()) && join.getJoinExpression() == null)
                        throw new IllegalArgumentException("Join condition is required");
                }
                if (node instanceof SemanticNestedQueryBlock nested) nonblank(nested.getAlias(), "Subquery alias");
                if (node instanceof SelectItem item) nonblank(item.getAlias(), "Select alias");
                if (node instanceof InsertNode insert) {
                    if (insert.getQuery() == null || insert.getTarget() == null && !has(insert.getMultiInsertTargets()))
                        throw new IllegalArgumentException("Insert needs a target and source query");
                    integration(insert);
                }
                if (node instanceof MultiInsertTableNode target) {
                    if (target.getTarget() == null || !has(target.getSelectList())) throw new IllegalArgumentException("Incomplete multi-insert target");
                    if (target.getCondition() != null && !new Expression(target.getCondition()).getTableReferences().isEmpty())
                        throw new IllegalArgumentException("Subqueries in multi-insert conditions are unsupported");
                    integration(target);
                }
                return super.visit(unused, stack, node);
            }
            @Override public Void visitDatastoreReference(Void unused, Stack<SemanticModel> stack, DatastoreReferenceNode node) {
                boolean target = node.isTarget() || !stack.empty() && (stack.peek() instanceof InsertNode || stack.peek() instanceof MultiInsertTableNode);
                if (target) targetName(node); // Embedded-expression naming is checked by expression.render itself.
                return null;
            }
            @Override public Void visitExpression(Void unused, Stack<SemanticModel> stack, SemanticExpression node) {
                expression(node); return null;
            }
        }.visit(null, new Stack<>(), model);
        return "";
    }
    private void requireStructured(List<?> list, String text, String clause) {
        if (!has(list) && text != null && !text.isBlank()) throw new IllegalArgumentException("Missing structured " + clause + " expressions");
    }
}
