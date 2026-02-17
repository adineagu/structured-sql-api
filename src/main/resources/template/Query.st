
<! Query template for StringTemplate 4 - Handles complex SELECT statements !>

<! Main Query template with recursion support !>
Query(query, layer, isMain) ::= <<
<query.DatasetList:{qry |
<qry.SetOperator>
<qry.AnnotationsString>
SELECT <if(qry.IsDistinct)>DISTINCT <endif>
<if(isMain)>
<get_Tech_Cols_Expr(layer)>
<endif>
<qry.SelectList:{selItem |<if(!isMain && i0)>    <else>    ,<endif><selItem.Expression> as <selItem.Alias>
}>
FROM
<qry.FromList:{from |
<joinLeftItem(from)>
    <if(from.Name)>@properties(name="<from.Name>")<else><from.Name><endif>
    <if(from.JoinType)><from.JoinType><endif> <joinRightItem(from)>
<if(from.JoinExpression)>ON <from.JoinExpression> <endif>
}>
<if(qry.WhereText)>
WHERE
<qry.WhereList:{selItem |<if(!i0)>AND <endif><selItem>
}>
<endif>
<if(qry.PivotText)>
    <qry.PivotText>
<endif>
<if(qry.GroupByText)>
GROUP BY
    <qry.GroupByText>
<endif>
<if(qry.HavingText)>
HAVING
    <qry.HavingText>
<endif>
<if(qry.OrderByText)>
ORDER BY
    <qry.OrderByText>
<endif>
}>
>>

<! From left item template !>
fromLeftItem(from) ::= <<
<joinLeftItem(from)>
    <if(from.Name)>@properties(name="<from.Name>")<else><from.Name><endif>
    <from.JoinType> <joinRightItem(from)>
<if(from.JoinExpression)>ON <from.JoinExpression> <endif>
>>

<! From right item template !>
fromRightItem(from) ::= <<
<joinLeftItem(from)>
    <if(from.Name)>@properties(name="<from.Name>")<else><from.Name><endif>
    <from.JoinType> <joinRightItem(from)>
<if(from.JoinExpression)>ON <from.JoinExpression> <endif>
>>

<! Join left item template !>
joinLeftItem(from) ::= <<
<if(from.LeftTable)>    <from.LeftTable.PhysName> <from.LeftTable.Alias> <endif>
<if(from.LeftQuery)>    (<Query(from.LeftQuery, "", false)>) <from.LeftQuery.Name> <endif>
<if(from.LeftJoin)>    <fromLeftItem(from.LeftJoin)> <endif>
>>

<! Join right item template !>
joinRightItem(from) ::= <<
<if(from.RightTable)>    <from.RightTable.PhysName> <from.RightTable.Alias> <endif>
<if(from.RightQuery)>    (<Query(from.RightQuery, "", false)>) <from.RightQuery.Name> <endif>
<if(from.RightJoin)>    <fromRightItem(from.RightJoin)> <endif>
>>

<! Insert template !>
Insert(insert, targetLayer) ::= <<
<if(!insert.MultiInsertTargets || insert.MultiInsertTargets.empty)>
INSERT INTO <insert.Target.PhysName> (
<get_Tech_Cols(targetLayer)>
<insert.Columns:{column |    ,<column.AnnotationsString> <column.Name>
}>
)
<get_Integration_Params(insert)>
<else>
INSERT ALL
<insert.MultiInsertTargets:{targ |
WHEN (<targ.Condition>) THEN INTO <targ.Target.PhysName> <targ.Target.Alias> (
<get_Tech_Cols(targ.Layer)>
<targ.SelectList:{selItem |    ,<selItem.Alias>
}>
)
VALUES (
<get_Tech_Cols_Expr(targ.Layer, "noAlias")>
<targ.SelectList:{selItem |    ,<selItem.Expression.Text>
}>
)
<get_Integration_Params_MultiInsert(targ, insert)>
}>
<endif>
>>
