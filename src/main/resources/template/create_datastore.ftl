<#-- FreeMarker Template for Datastore Creation -->
<#assign xtDatastoreName = "XT_" + datastore.Name + "_V">
<#assign stageDatastoreName = "ST_" + datastore.Name>

-- create stage archive datastore

CREATE OR REPLACE DATASTORE DWH_STAGE_ARCHIVE.${stageDatastoreName}
ALIAS ${stageDatastoreName}
RESOURCE '${stageDatastoreName}'
(
     LOAD_ID	NUMBER(22,0) NOT NULL
    ,EFFECTIVE_DATE	DATE NOT NULL  
<#list datastore.Attributes as col>
    ,${col.Name?lower_case} <#if col.isAnnotatedWith("PROPERTIES") && col.getAnnotation("PROPERTIES").getParameters().CHAR_LENGTH_SEMANTIC?? && col.getAnnotation("PROPERTIES").getParameters().CHAR_LENGTH_SEMANTIC == "CHAR">VARCHAR2_CHAR(${col.Length})<#else>${col.DDLDataType}</#if><#if col.IsMandatory> NOT NULL</#if>
</#list>
);
