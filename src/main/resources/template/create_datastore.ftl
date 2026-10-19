<#-- FreeMarker Template for Datastore Creation -->
<#assign xtDatastoreName = "XT_" + datastore.name + "_V">
<#assign stageDatastoreName = "ST_" + datastore.name>

-- create stage archive datastore

CREATE OR REPLACE DATASTORE DWH_STAGE_ARCHIVE.${stageDatastoreName}
ALIAS ${stageDatastoreName}
RESOURCE '${stageDatastoreName}'
(
     LOAD_ID	NUMBER(22,0) NOT NULL
    ,EFFECTIVE_DATE	DATE NOT NULL  
<#list datastore.attributes as col>
    ,${col.name?lower_case} <#if col.annotations()?? && col.annotations().has("PROPERTIES") && (col.annotations().get("PROPERTIES").attribute("CHAR_LENGTH_SEMANTIC")!"") == "CHAR">VARCHAR2_CHAR(${col.length})<#else>${col.getDDLDataType()}</#if><#if col.isMandatory> NOT NULL</#if>
</#list>
);
