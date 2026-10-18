@import org.pecheasoft.odigen.sql.api.ast.IDatastore
@param IDatastore datastore
@{
    var xtDatastoreName = "XT_" + datastore.getName() + "_V";
    var stageDatastoreName = "ST_" + datastore.getName();
}

CREATE OR REPLACE DATASTORE DWH_STAGE_ARCHIVE.${stageDatastoreName}
ALIAS ${stageDatastoreName}
RESOURCE '${stageDatastoreName}'
(
     LOAD_ID NUMBER(22,0) NOT NULL
    ,EFFECTIVE_DATE DATE NOT NULL
@for (var col : datastore.getAttributes())
    @{
        var props = col.getAnnotation("PROPERTIES");
        var params = props != null ? props.getParameters() : null;
        var semantic = params != null ? params.get("CHAR_LENGTH_SEMANTIC") : null;
    }
    ,${col.getName().toLowerCase()} 
    @if (semantic != null && semantic.equals("CHAR"))
        VARCHAR2_CHAR(${col.getLength()})
    @else
        ${col.getDDLDataType()}
    @endif
    @if (col.isMandatory()) NOT NULL@endif
@endfor
);
