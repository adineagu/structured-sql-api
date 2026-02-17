<xtDatastoreName>XT_<datastore.Name>_V</xtDatastoreName>

<stageDatastoreName>ST_<datastore.Name></stageDatastoreName>

-- create stage archive datastore

CREATE OR REPLACE DATASTORE DWH_STAGE_ARCHIVE.<stageDatastoreName>
ALIAS <stageDatastoreName>
RESOURCE '<stageDatastoreName>'
(
     LOAD_ID	NUMBER(22,0) NOT NULL
    ,EFFECTIVE_DATE	DATE NOT NULL  
<datastore.Attributes:{col |    ,<col.Name> <getDataType(col)> <if(col.IsMandatory)>NOT NULL<endif>
}>
);

<! Helper template for data types !>
<getDataType(col)>
<if(col.isAnnotatedWith("PROPERTIES"))><if(col.getAnnotation("PROPERTIES").getParameters().CHAR_LENGTH_SEMANTIC)><if(col.getAnnotation("PROPERTIES").getParameters().CHAR_LENGTH_SEMANTIC == "CHAR")>VARCHAR2_CHAR(<col.Length>)<else><col.DDLDataType><endif><else><col.DDLDataType><endif><else><col.DDLDataType><endif>
