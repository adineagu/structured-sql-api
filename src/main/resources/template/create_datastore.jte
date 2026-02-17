@import org.pecheasoft.odigen.sql.api.ast.IASTObject

@param IASTObject datastore

@{var xtDatastoreName = "XT_" + datastore.getName() + "_V";}
@{var stageDatastoreName = "ST_" + datastore.getName();}

-- create stage archive datastore

CREATE OR REPLACE DATASTORE DWH_STAGE_ARCHIVE.${stageDatastoreName}
ALIAS ${stageDatastoreName}
RESOURCE '${stageDatastoreName}'
(
     LOAD_ID	NUMBER(22,0) NOT NULL
    ,EFFECTIVE_DATE	DATE NOT NULL  
@for(var col : datastore.getAttributes())
    ,${col.getName().toLowerCase()} @if(col.isAnnotatedWith("PROPERTIES") && col.getAnnotation("PROPERTIES").getParameters().get("CHAR_LENGTH_SEMANTIC") != null && col.getAnnotation("PROPERTIES").getParameters().get("CHAR_LENGTH_SEMANTIC").equals("CHAR"))VARCHAR2_CHAR(${col.getLength()})@else${col.getDDLDataType()}@endif@if(col.isMandatory()) NOT NULL@endif
@endfor
);
