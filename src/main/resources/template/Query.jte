@import org.pecheasoft.odigen.sql.api.ast.*
@import java.util.List

<%--
Query template for JTE - Handles complex SELECT statements
Type-safe template with Java objects
--%>

@param IASTObject query
@param String layer
@param boolean isMain

<%-- Main Query template --%>
@for(var qry : query.getDatasetList())
${qry.getSetOperator() != null ? qry.getSetOperator() : ""}
${qry.getAnnotationsString() != null ? qry.getAnnotationsString() : ""}
SELECT @if(qry.isDistinct()) DISTINCT @endif
@if(isMain)
$unsafe{getTechColsExpr(layer)}
@endif
@for(var selItem : qry.getSelectList())
@if(!isMain && selItem.isFirst())    @else    ,@endif${selItem.getExpression()} as ${selItem.getAlias()}
@endfor
FROM
@for(var from : qry.getFromList())
$unsafe{joinLeftItem(from)}
    @if(from.getName() != null && !from.getName().isEmpty())@properties(name="${from.getName()}")@else${from.getName() != null ? from.getName() : ""}@endif
    @if(from.getJoinType() != null) ${from.getJoinType()}@endif $unsafe{joinRightItem(from)}
@if(from.getJoinExpression() != null) ON ${from.getJoinExpression()} @endif
@endfor
@if(qry.getWhereText() != null && !qry.getWhereText().isEmpty())
WHERE
@for(var selItem : qry.getWhereList())
@if(!selItem.isFirst())AND @endif${selItem}
@endfor
@endif
@if(qry.getPivotText() != null && !qry.getPivotText().isEmpty())
    ${qry.getPivotText()}
@endif
@if(qry.getGroupByText() != null)
GROUP BY
    ${qry.getGroupByText()}
@endif
@if(qry.getHavingText() != null)
HAVING
    ${qry.getHavingText()}
@endif
@if(qry.getOrderByText() != null)
ORDER BY
    ${qry.getOrderByText()}
@endif
@endfor

<%-- Helper templates as Java methods would be defined separately --%>
<%--
These would typically be implemented as Java helper methods in a companion class:

public static String joinLeftItem(IASTObject from) {
    StringBuilder sb = new StringBuilder();
    if (from.getLeftTable() != null) {
        sb.append("    ").append(from.getLeftTable().getPhysName(ctx))
          .append(" ").append(from.getLeftTable().getAlias()).append(" ");
    }
    if (from.getLeftQuery() != null) {
        sb.append("    (").append(Query(from.getLeftQuery(), "", false))
          .append(") ").append(from.getLeftQuery().getName()).append(" ");
    }
    if (from.getLeftJoin() != null) {
        sb.append("    ").append(fromLeftItem(from.getLeftJoin())).append(" ");
    }
    return sb.toString();
}

public static String joinRightItem(IASTObject from) {
    StringBuilder sb = new StringBuilder();
    if (from.getRightTable() != null) {
        sb.append("    ").append(from.getRightTable().getPhysName(ctx))
          .append(" ").append(from.getRightTable().getAlias()).append(" ");
    }
    if (from.getRightQuery() != null) {
        sb.append("    (").append(Query(from.getRightQuery(), "", false))
          .append(") ").append(from.getRightQuery().getName()).append(" ");
    }
    if (from.getRightJoin() != null) {
        sb.append("    ").append(fromRightItem(from.getRightJoin())).append(" ");
    }
    return sb.toString();
}

public static String insertQuery(IASTObject insert, String targetLayer) {
    // INSERT logic implementation
}
--%>
