<#--
Query template for FreeMarker - Handles complex SELECT statements
-->

<#-- Main Query macro with recursion support -->
<#macro Query query layer isMain>
<#list query.DatasetList as qry>
${qry.SetOperator!}
${qry.AnnotationsString!}
SELECT <#if qry.IsDistinct> DISTINCT </#if>
<#if isMain>
<@get_Tech_Cols_Expr layer=layer/>
</#if>
<#list qry.SelectList as selItem>
<#if selItem?is_first && !isMain>    <#else>    ,</#if>${selItem.Expression} as ${selItem.Alias}
</#list>
FROM
<#list qry.FromList as from>
<@joinLeftItem from=from/>
    <#if from.Name?has_content>@properties(name="${from.Name}")<#else>${from.Name!}</#if>
    <#if from.JoinType??> ${from.JoinType}</#if> <@joinRightItem from=from/>
<#if from.JoinExpression??> ON ${from.JoinExpression} </#if>
</#list>
<#if qry.WhereText?has_content>
WHERE
<#list qry.WhereList as selItem>
<#if !selItem?is_first>AND </#if>${selItem}
</#list>
</#if>
<#if qry.PivotText?has_content>
    ${qry.PivotText}
</#if>
<#if qry.GroupByText??>
GROUP BY
    ${qry.GroupByText}
</#if>
<#if qry.HavingText??>
HAVING
    ${qry.HavingText}
</#if>
<#if qry.OrderByText??>
ORDER BY
    ${qry.OrderByText}
</#if>
</#list>
</#macro>

<#-- From left item macro -->
<#macro fromLeftItem from>
<@joinLeftItem from=from/>
    <#if from.Name?has_content>@properties(name="${from.Name}")<#else>${from.Name!}</#if>
    ${from.JoinType} <@joinRightItem from=from/>
<#if from.JoinExpression??> ON ${from.JoinExpression} </#if>
</#macro>

<#-- From right item macro -->
<#macro fromRightItem from>
<@joinLeftItem from=from/>
    <#if from.Name?has_content>@properties(name="${from.Name}")<#else>${from.Name!}</#if>
    ${from.JoinType} <@joinRightItem from=from/>
<#if from.JoinExpression??> ON ${from.JoinExpression} </#if>
</#macro>

<#-- Join left item macro -->
<#macro joinLeftItem from>
<#if from.LeftTable??>    ${from.LeftTable.getPhysName(ctx)} ${from.LeftTable.Alias} </#if>
<#if from.LeftQuery??>    (<@Query query=from.LeftQuery layer="" isMain=false/>) ${from.LeftQuery.Name} </#if>
<#if from.LeftJoin??>    <@fromLeftItem from=from.LeftJoin/> </#if>
</#macro>

<#-- Join right item macro -->
<#macro joinRightItem from>
<#if from.RightTable??>    ${from.RightTable.getPhysName(ctx)} ${from.RightTable.Alias} </#if>
<#if from.RightQuery??>    (<@Query query=from.RightQuery layer="" isMain=false/>) ${from.RightQuery.Name} </#if>
<#if from.RightJoin??>    <@fromRightItem from=from.RightJoin/> </#if>
</#macro>

<#-- Insert macro -->
<#macro Insert insert>
<#if !insert.MultiInsertTargets?? || insert.MultiInsertTargets?size == 0>
INSERT INTO ${insert.Target.getPhysName(ctx)} (
<@get_Tech_Cols layer=targetLayer/>
<#list insert.Columns as column>   
    ,${column.AnnotationsString} ${column.Name}
</#list>
)
<@get_Integration_Params insert=insert/>
<#else>
INSERT ALL
<#list insert.MultiInsertTargets as targ>
<#assign targetTableName = targ.Target.Name>
<#assign targLayer = targetTableName?substring(0, targetTableName?index_of('_'))>
WHEN (${targ.Condition}) THEN INTO ${targ.Target.getPhysName(ctx)} ${targ.Target.Alias} (
<@get_Tech_Cols layer=targLayer/>
<#list targ.SelectList as selItem>
    ,${selItem.Alias}
</#list>
)
VALUES (
<@get_Tech_Cols_Expr layer=targLayer mode="noAlias"/>
<#list targ.SelectList as selItem>
    ,${selItem.Expression.Text}
</#list>
)
<@get_Integration_Params_MultiInsert targ=targ insert=insert/>
</#list>
</#if>
</#macro>
