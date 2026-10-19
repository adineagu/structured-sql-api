package org.pecheasoft.odigen.sql.api.transform;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.pecheasoft.odigen.sql.api.ast.*;
import org.pecheasoft.odigen.sql.api.ast.impl.*;

/** General structural preparation operations; column policies belong to the caller. */
public final class AstTransformations {
    private AstTransformations() {}

    /**
     * Return an insert with prepended assignments/projections in map iteration order.
     * The input is not modified. FROM/filter children and immutable expressions are shared.
     */
    public static InsertNode prependAssignments(InsertNode source, Map<String, String> additions) {
        if (!(source.getQuery() instanceof SemanticSimpleQueryBlock query)
                || query instanceof SemanticNestedQueryBlock
                || source.getMultiInsertTargets() != null && !source.getMultiInsertTargets().isEmpty()) {
            throw new IllegalArgumentException("prependAssignments requires a single-target insert with a simple outer query");
        }
        if (source.getTarget() == null || source.getTarget().getDatastore() == null) {
            throw new IllegalArgumentException("Resolve target metadata before preparing assignments");
        }
        List<SemanticAssignment> original = source.getColumns();
        if (original == null || query.getSelectList() == null || original.size() != query.getSelectList().size()) {
            throw new IllegalArgumentException("Explicit target assignments must match the source projections");
        }
        var names = new HashSet<String>();
        for (SemanticAssignment column : original) names.add(column.getName().toUpperCase(Locale.ROOT));
        for (var entry : additions.entrySet()) {
            if (entry.getKey() == null || entry.getKey().isBlank() || entry.getValue() == null || entry.getValue().isBlank()) {
                throw new IllegalArgumentException("Assignment names and expressions must not be blank");
            }
            if (!names.add(entry.getKey().toUpperCase(Locale.ROOT))) {
                throw new IllegalArgumentException("Assignment already exists: " + entry.getKey());
            }
            if (source.getTarget().getDatastore().getAttribute(entry.getKey()) == null) {
                throw new IllegalArgumentException("Target definition has no column: " + entry.getKey());
            }
        }
        var columns = new ArrayList<SemanticAssignment>();
        var projections = new ArrayList<SelectItem>();
        for (var entry : additions.entrySet()) {
            append(columns, projections, source.getTarget(), entry.getKey(), null, new Expression(entry.getValue()), entry.getKey(), null, null);
        }
        for (int i = 0; i < original.size(); i++) {
            SelectItem item = query.getSelectList().get(i);
            append(columns, projections, source.getTarget(), original.get(i).getName(), original.get(i).getMetadata(), (Expression)item.getExpression(),
                    item.getAlias(), original.get(i).annotations(), item.annotations());
        }
        InsertNode prepared = new InsertNode(source.getTarget(), columns);
        SemanticSimpleQueryBlock preparedQuery = query.shallowCopy();
        preparedQuery.setSelectList(projections);
        preparedQuery.setWithList(query.getWithList());
        preparedQuery.setWithText(query.getWithText());
        prepared.setQuery(preparedQuery);
        prepared.setAnnotations(copy(source.annotations()));
        prepared.setIntegrationType(source.getIntegrationType());
        prepared.setUpdateKey(source.getUpdateKey());
        prepared.setRejectLimit(source.getRejectLimit());
        prepared.setRejectLimitUnit(source.getRejectLimitUnit());
        return prepared;
    }

    private static SemanticAnnotationSet copy(SemanticAnnotationSet annotations) {
        return annotations == null ? null : new SemanticAnnotationSet(annotations.all());
    }

    private static void append(List<SemanticAssignment> columns, List<SelectItem> projections,
            DatastoreReferenceNode target, String name, DatastoreAttribute metadata, Expression expression, String alias,
            SemanticAnnotationSet columnAnnotations, SemanticAnnotationSet itemAnnotations) {
        SemanticAssignment assignment = new SemanticAssignment(name, columns.size(), metadata, target);
        assignment.setAnnotations(copy(columnAnnotations));
        SelectItem item = new SelectItem(expression, alias);
        item.setAnnotations(copy(itemAnnotations));
        item.setTargetColumn(assignment);
        assignment.setExpression(item);
        columns.add(assignment);
        projections.add(item);
    }
}
