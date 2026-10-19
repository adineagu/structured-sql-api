package gg.jte.generated.ondemand;
import org.pecheasoft.odigen.sql.api.ast.IDatastore;
@SuppressWarnings("unchecked")
public final class Jtecreate_datastoreGenerated {
	public static final String JTE_NAME = "create_datastore";
	public static final int[] JTE_LINE_INFO = {1,1,2,2,2,2,7,7,7,8,8,9,9,13,13,19,19,20,20,21,21,22,22,23,23,24,24,25,25,25,25,26,26,27,27,27,2,2,2,2};
	public static void render(gg.jte.TemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, IDatastore datastore) {
		jteOutput.writeContent("@{\n    var xtDatastoreName = \"XT_\" + datastore.getName() + \"_V\";\n    var stageDatastoreName = \"ST_\" + datastore.getName();\n}\nCREATE OR REPLACE DATASTORE DWH_STAGE_ARCHIVE.");
		jteOutput.writeUserContent(stageDatastoreName);
		jteOutput.writeContent("\nALIAS ");
		jteOutput.writeUserContent(stageDatastoreName);
		jteOutput.writeContent("\nRESOURCE '");
		jteOutput.writeUserContent(stageDatastoreName);
		jteOutput.writeContent("'\n(\n     LOAD_ID NUMBER(22,0) NOT NULL\n    ,EFFECTIVE_DATE DATE NOT NULL\n");
		for (var col : datastore.getAttributes()) {
			jteOutput.writeContent("\n    @{\n        var props = col.getAnnotation(\"PROPERTIES\");\n        var params = props != null ? props.getParameters() : null;\n        var semantic = params != null ? params.get(\"CHAR_LENGTH_SEMANTIC\") : null;\n    }\n    ,");
			jteOutput.writeUserContent(col.getName().toLowerCase());
			jteOutput.writeContent(" \n    ");
			if (semantic != null && semantic.equals("CHAR")) {
				jteOutput.writeContent("\n        VARCHAR2_CHAR(");
				jteOutput.writeUserContent(col.getLength());
				jteOutput.writeContent(")\n    ");
			} else {
				jteOutput.writeContent("\n        ");
				jteOutput.writeUserContent(col.getDDLDataType());
				jteOutput.writeContent("\n    ");
			}
			jteOutput.writeContent("\n    ");
			if (col.isMandatory()) {
				jteOutput.writeContent(" NOT NULL");
			}
			jteOutput.writeContent("\n");
		}
		jteOutput.writeContent("\n);");
	}
	public static void renderMap(gg.jte.TemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		IDatastore datastore = (IDatastore)params.get("datastore");
		render(jteOutput, jteHtmlInterceptor, datastore);
	}
}
