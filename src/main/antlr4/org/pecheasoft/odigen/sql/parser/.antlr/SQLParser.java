// Generated from c:/Sources/odi-generator/OdiGenLibraries/odigen-odi-parse/src/main/antlr4/org/apache/tajo/engine/parser/SQLParser.g4 by ANTLR 4.13.1


import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class SQLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		AS=1, ALL=2, AND=3, ANY=4, ASYMMETRIC=5, ASC=6, BOTH=7, CASE=8, CAST=9, 
		CREATE=10, CROSS=11, CURRENT_DATE=12, CURRENT_TIME=13, CURRENT_TIMESTAMP=14, 
		DESC=15, DISTINCT=16, DATASET=17, END=18, ELSE=19, EXCEPT=20, FALSE=21, 
		FULL=22, FROM=23, GROUP=24, HAVING=25, ILIKE=26, IN=27, INNER=28, INTERSECT=29, 
		INTO=30, IS=31, JOIN=32, LEADING=33, LEFT=34, LIKE=35, LIMIT=36, MAPPING=37, 
		NATURAL=38, NOT=39, NULL=40, ON=41, OR=42, ORDER=43, OUTER=44, OVER=45, 
		PACKAGE=46, PROCEDURE=47, PROJECT=48, RIGHT=49, REUSABLE=50, SELECT=51, 
		SOME=52, SYMMETRIC=53, SCENARIO=54, TABLE=55, THEN=56, TRAILING=57, TRUE=58, 
		UNION=59, UNIQUE=60, USING=61, WHEN=62, WHERE=63, WITH=64, WINDOW=65, 
		VARIABLE=66, POSITION=67, OFFSET=68, IKM=69, LKM=70, CKM=71, TECHNOLOGY=72, 
		PHYSICAL_DESIGN=73, DESCRIPTION=74, OPTIMIZATION_CONTEXT=75, REMOVE_TEMPORARY_OBJECTS_ON_ERROR=76, 
		UNIQUE_TEMPORARY_OBJECT_NAMES=77, AVG=78, ADD=79, ALTER=80, BETWEEN=81, 
		BY=82, CASCADE=83, CATALOG=84, CENTURY=85, CHARACTER=86, COLLECT=87, COALESCE=88, 
		COLUMN=89, COUNT=90, CUBE=91, CUME_DIST=92, CURRENT=93, STRING=94, FEBCDIC=95, 
		SIGNED_PACKED_DECIMAL=96, EBCDIC_SIGNED_ZONED_DECIMAL=97, DAY=98, DEFAULT=99, 
		DATABASE=100, DEC=101, DECADE=102, DENSE_RANK=103, DOW=104, DOY=105, DROP=106, 
		EPOCH=107, EVERY=108, EXCLUDE=109, EXISTS=110, EXPLAIN=111, EXTERNAL=112, 
		EXTRACT=113, FILTER=114, FIRST=115, FIRST_VALUE=116, FOLLOWING=117, FOR=118, 
		FORMAT=119, FUSION=120, GROUPING=121, HASH=122, HOUR=123, IF=124, INDEX=125, 
		INSERT=126, INTERSECTION=127, ISODOW=128, ISOYEAR=129, LAG=130, LAST=131, 
		LAST_VALUE=132, LEAD=133, LESS=134, LIST=135, LOCATION=136, MAX=137, MAXVALUE=138, 
		MICROSECONDS=139, MILLENNIUM=140, MILLISECONDS=141, MIN=142, MINUTE=143, 
		MONTH=144, NATIONAL=145, NULLIF=146, NO=147, OVERWRITE=148, OTHERS=149, 
		PARTITION=150, PARTITIONS=151, PERCENT_RANK=152, PRECEDING=153, PRECISION=154, 
		PURGE=155, QUARTER=156, RANGE=157, RANK=158, REGEXP=159, RENAME=160, RESET=161, 
		RLIKE=162, ROLLUP=163, ROW=164, ROWS=165, ROW_NUMBER=166, SECOND=167, 
		SESSION=168, SET=169, SIMILAR=170, STDDEV_POP=171, STDDEV_SAMP=172, SUBPARTITION=173, 
		SUM=174, TABLESPACE=175, THAN=176, TIES=177, TIMEZONE=178, TIMEZONE_HOUR=179, 
		TIMEZONE_MINUTE=180, TRIM=181, TO=182, TRUNCATE=183, UNBOUNDED=184, UNKNOWN=185, 
		VALUES=186, VAR_SAMP=187, VAR_POP=188, VARYING=189, WEEK=190, YEAR=191, 
		ZONE=192, BOOLEAN=193, BOOL=194, BIT=195, VARBIT=196, INT1=197, INT2=198, 
		INT4=199, INT8=200, TINYINT=201, SMALLINT=202, INT=203, INTEGER=204, BIGINT=205, 
		FLOAT4=206, FLOAT8=207, REAL=208, FLOAT=209, DOUBLE=210, NUMERIC=211, 
		ORANUMBER=212, DECIMAL=213, CHAR=214, VARCHAR2=215, VARCHAR=216, NCHAR=217, 
		NVARCHAR=218, CLOB=219, DATE=220, INTERVAL=221, TIME=222, TIMETZ=223, 
		TIMESTAMP=224, TIMESTAMPTZ=225, TEXT=226, BINARY=227, VARBINARY=228, BLOB=229, 
		BYTEA=230, INET4=231, Similar_To=232, Not_Similar_To=233, Similar_To_Case_Insensitive=234, 
		Not_Similar_To_Case_Insensitive=235, CAST_EXPRESSION=236, ASSIGN=237, 
		EQUAL=238, COLON=239, SEMI_COLON=240, COMMA=241, CONCATENATION_OPERATOR=242, 
		NOT_EQUAL=243, LTH=244, LEQ=245, GTH=246, GEQ=247, LEFT_PAREN=248, RIGHT_PAREN=249, 
		PLUS=250, MINUS=251, MULTIPLY=252, DIVIDE=253, MODULAR=254, DOT=255, UNDERLINE=256, 
		VERTICAL_BAR=257, QUOTE=258, DOUBLE_QUOTE=259, HASH_SIGN=260, AT_SIGN=261, 
		NUMBER=262, REAL_NUMBER=263, NULLS=264, MINUS_SET=265, DATASTORE=266, 
		ALIAS=267, RESOURCE=268, FILE=269, HEADING=270, RECORD_SEP=271, FIELD_SEP=272, 
		TEXT_DELIM=273, DECIMAL_SEP=274, FIXED=275, DELIMITED=276, PHYS_LENGTH=277, 
		SCD=278, SCD_BEHAVIOR=279, MODEL=280, WITH_NAME=281, LOGICAL_SCHEMA=282, 
		FOLDER=283, SUBMODEL=284, MODIFY=285, REPLACE=286, CONTEXT=287, XKM=288, 
		SEQUENCEFILE=289, FIELDS=290, TERMINATED=291, ESCAPED=292, DEFINED=293, 
		SERDE=294, SERDEPROPERTIES=295, TEXTFILE=296, RCFILE=297, ORC=298, PARQUET=299, 
		AVRO=300, INPUTFORMAT=301, OUTPUTFORMAT=302, TEMPORARY=303, STORED_AS=304, 
		TBLPROPERTIES=305, ROW_FORMAT=306, INTEGRATION_TYPE=307, UPDATE_KEY=308, 
		REJECT=309, PERCENT=310, PRIMARY_KEY=311, ALTERNATE_KEY=312, OLAP_TYPE=313, 
		CONSTRAINT=314, ODI_Tag_Start=315, ODI_Tag_End=316, ODIREF=317, CURSOR=318, 
		SUCCESS=319, ERROR=320, GOTO=321, DECLARE=322, REFRESH=323, RETRY=324, 
		WAIT=325, BEGIN=326, EXIT=327, CMNT=328, LISTAGG=329, WITHIN_GROUP=330, 
		EXPORT=331, IMPORT=332, REGENERATE=333, OR_REPLACE=334, TYPE=335, STAGING=336, 
		CONNECT=337, ODI=338, IGNORE_NULLS=339, RESPECT_NULLS=340, CONVERT=341, 
		DATETIME=342, VARCHAR_MAX=343, VARCHAR2_MAX=344, CONTINUE=345, CHECK=346, 
		CONTROL=347, FLOW=348, STATIC=349, ACTIVE=350, MESSAGE=351, KEEP=352, 
		PIVOT=353, UNPIVOT=354, INCLUDE=355, Odi_Sequence=356, Odi_Variable=357, 
		Odi_Variable_Literal=358, Hint_Start=359, Hint_End=360, BlockComment=361, 
		LineComment=362, Regular_Identifier=363, Quoted_Identifier=364, Character_String_Literal=365, 
		FreeCode=366, Space=367, White_Space=368, BAD=369;
	public static final int
		RULE_script = 0, RULE_singleSqlScript = 1, RULE_sql = 2, RULE_explain_clause = 3, 
		RULE_statement = 4, RULE_session_statement = 5, RULE_data_statement = 6, 
		RULE_data_change_statement = 7, RULE_schema_statement = 8, RULE_index_statement = 9, 
		RULE_database_definition = 10, RULE_if_not_exists = 11, RULE_drop_database_statement = 12, 
		RULE_if_exists = 13, RULE_or_replace = 14, RULE_hive_row_format = 15, 
		RULE_hive_file_format = 16, RULE_file_alias = 17, RULE_file_resource_name = 18, 
		RULE_file_description = 19, RULE_file_format = 20, RULE_file_heading = 21, 
		RULE_record_separator = 22, RULE_field_separator = 23, RULE_text_delimiter = 24, 
		RULE_decimal_separator = 25, RULE_olap_type = 26, RULE_file_descriptor = 27, 
		RULE_create_table_statement = 28, RULE_create_project_statement = 29, 
		RULE_drop_project_statement = 30, RULE_create_folder_statement = 31, RULE_drop_folder_statement = 32, 
		RULE_create_model_statement = 33, RULE_drop_model_statement = 34, RULE_create_submodel_statement = 35, 
		RULE_drop_submodel_statement = 36, RULE_mapping_statements_block = 37, 
		RULE_create_simple_mapping = 38, RULE_create_complex_mapping = 39, RULE_create_mapping_statement = 40, 
		RULE_create_package_statement = 41, RULE_create_procedure_statement = 42, 
		RULE_scenario_name = 43, RULE_scenario_version = 44, RULE_odi_object_type = 45, 
		RULE_odi_parent_object_type = 46, RULE_scenario_source_type = 47, RULE_scenario_variable = 48, 
		RULE_scenario_variables = 49, RULE_create_scenario_statement = 50, RULE_regenerate_scenario_statement = 51, 
		RULE_drop_scenario_statement = 52, RULE_export_scenario_statement = 53, 
		RULE_export_mapping_statement = 54, RULE_odi_object_name = 55, RULE_import_object = 56, 
		RULE_import_parent_object = 57, RULE_import_mode = 58, RULE_import_scenario_statement = 59, 
		RULE_table_elements = 60, RULE_field_element = 61, RULE_index_inline = 62, 
		RULE_modify_field_element = 63, RULE_field_type = 64, RULE_null_constraint = 65, 
		RULE_position = 66, RULE_offset = 67, RULE_field_phys_length = 68, RULE_field_format = 69, 
		RULE_field_scd_behavior = 70, RULE_field_comment = 71, RULE_param_clause = 72, 
		RULE_param = 73, RULE_km_param = 74, RULE_km_name = 75, RULE_km_technology = 76, 
		RULE_km_target_item = 77, RULE_km_target_list = 78, RULE_ikm_target = 79, 
		RULE_km_target = 80, RULE_km_params = 81, RULE_lkm_clause = 82, RULE_xkm_clause = 83, 
		RULE_ikm_clause = 84, RULE_ckm_clause = 85, RULE_km_list = 86, RULE_phys_design_name = 87, 
		RULE_phys_design_desc = 88, RULE_optimization_context = 89, RULE_staging_location = 90, 
		RULE_mapping_command = 91, RULE_on_begin_mapping_cmd = 92, RULE_on_end_mapping_cmd = 93, 
		RULE_phys_design = 94, RULE_phys_design_clause = 95, RULE_declare_odivar_statement = 96, 
		RULE_refresh_odivar_statement = 97, RULE_set_odivar_statement = 98, RULE_procedure_options = 99, 
		RULE_procedure_statement = 100, RULE_increment_odivar_statement = 101, 
		RULE_mapping_statement = 102, RULE_package_statement = 103, RULE_success_clause = 104, 
		RULE_error_clause = 105, RULE_label = 106, RULE_generic_package_statement = 107, 
		RULE_statement_block = 108, RULE_method_specifier = 109, RULE_table_space_specifier = 110, 
		RULE_table_space_name = 111, RULE_table_partitioning_clauses = 112, RULE_range_partitions = 113, 
		RULE_range_value_clause_list = 114, RULE_range_value_clause = 115, RULE_hash_partitions = 116, 
		RULE_individual_hash_partitions = 117, RULE_individual_hash_partition = 118, 
		RULE_hash_partitions_by_quantity = 119, RULE_list_partitions = 120, RULE_list_value_clause_list = 121, 
		RULE_list_value_partition = 122, RULE_column_partitions = 123, RULE_partition_name = 124, 
		RULE_truncate_table_statement = 125, RULE_annotation_element = 126, RULE_annotation = 127, 
		RULE_truncate_mapping_statement = 128, RULE_truncate_reusable_mapping_statement = 129, 
		RULE_drop_table_statement = 130, RULE_drop_mapping_statement = 131, RULE_drop_reusable_mapping_statement = 132, 
		RULE_drop_package_statement = 133, RULE_nonreserved_keywords = 134, RULE_identifier = 135, 
		RULE_unsigned_literal = 136, RULE_general_literal = 137, RULE_datetime_literal = 138, 
		RULE_time_literal = 139, RULE_timestamp_literal = 140, RULE_date_literal = 141, 
		RULE_interval_literal = 142, RULE_boolean_literal = 143, RULE_data_type = 144, 
		RULE_predefined_type = 145, RULE_generic_type = 146, RULE_network_type = 147, 
		RULE_character_string_type = 148, RULE_type_length = 149, RULE_national_character_string_type = 150, 
		RULE_binary_large_object_string_type = 151, RULE_numeric_type = 152, RULE_exact_numeric_type = 153, 
		RULE_approximate_numeric_type = 154, RULE_precision_param = 155, RULE_boolean_type = 156, 
		RULE_datetime_type = 157, RULE_bit_type = 158, RULE_binary_type = 159, 
		RULE_value_expression_primary = 160, RULE_parenthesized_value_expression = 161, 
		RULE_nonparenthesized_value_expression_primary = 162, RULE_unsigned_value_specification = 163, 
		RULE_unsigned_numeric_literal = 164, RULE_signed_numerical_literal = 165, 
		RULE_set_function_specification = 166, RULE_aggregate_function = 167, 
		RULE_general_set_function = 168, RULE_set_function_type = 169, RULE_filter_clause = 170, 
		RULE_grouping_operation = 171, RULE_listagg_function = 172, RULE_window_function = 173, 
		RULE_window_function_nulls_clause = 174, RULE_window_function_type = 175, 
		RULE_rank_function_type = 176, RULE_window_name_or_specification = 177, 
		RULE_case_expression = 178, RULE_case_abbreviation = 179, RULE_case_specification = 180, 
		RULE_simple_case = 181, RULE_searched_case = 182, RULE_simple_when_clause = 183, 
		RULE_searched_when_clause = 184, RULE_else_clause = 185, RULE_result = 186, 
		RULE_cast_specification = 187, RULE_cast_operand = 188, RULE_cast_target = 189, 
		RULE_convert_specification = 190, RULE_value_expression = 191, RULE_common_value_expression = 192, 
		RULE_numeric_value_expression = 193, RULE_term = 194, RULE_factor = 195, 
		RULE_array = 196, RULE_numeric_primary = 197, RULE_sign = 198, RULE_numeric_value_function = 199, 
		RULE_extract_expression = 200, RULE_extract_field = 201, RULE_time_zone_field = 202, 
		RULE_extract_source = 203, RULE_string_value_expression = 204, RULE_character_value_expression = 205, 
		RULE_character_factor = 206, RULE_character_primary = 207, RULE_string_value_function = 208, 
		RULE_trim_function = 209, RULE_trim_operands = 210, RULE_trim_specification = 211, 
		RULE_datetime_value_expression = 212, RULE_datetime_term = 213, RULE_datetime_factor = 214, 
		RULE_datetime_primary = 215, RULE_datetime_value_function = 216, RULE_current_date_value_function = 217, 
		RULE_current_time_value_function = 218, RULE_current_timestamp_value_function = 219, 
		RULE_boolean_value_expression = 220, RULE_or_predicate = 221, RULE_and_predicate = 222, 
		RULE_boolean_factor = 223, RULE_boolean_test = 224, RULE_is_clause = 225, 
		RULE_truth_value = 226, RULE_boolean_primary = 227, RULE_boolean_predicand = 228, 
		RULE_parenthesized_boolean_value_expression = 229, RULE_odi_variable = 230, 
		RULE_odi_variable_literal = 231, RULE_odi_sequence = 232, RULE_row_value_expression = 233, 
		RULE_row_value_special_case = 234, RULE_explicit_row_value_constructor = 235, 
		RULE_row_value_predicand = 236, RULE_row_value_constructor_predicand = 237, 
		RULE_table_expression = 238, RULE_from_clause = 239, RULE_table_reference_list = 240, 
		RULE_unpivot_fields_list = 241, RULE_unpivot_source_fields_list = 242, 
		RULE_unpivot_rule = 243, RULE_unpivot_rules = 244, RULE_unpivot_clause = 245, 
		RULE_pivot_fields_list = 246, RULE_pivot_source_fields_list = 247, RULE_pivot_rule = 248, 
		RULE_pivot_rules = 249, RULE_pivot_clause = 250, RULE_table_reference = 251, 
		RULE_annotated_joined_table_primary = 252, RULE_joined_table = 253, RULE_joined_table_primary = 254, 
		RULE_cross_join = 255, RULE_qualified_join = 256, RULE_natural_join = 257, 
		RULE_union_join = 258, RULE_join_type = 259, RULE_outer_join_type = 260, 
		RULE_outer_join_type_part2 = 261, RULE_first_row = 262, RULE_last_row = 263, 
		RULE_all_rows = 264, RULE_lookup_specification = 265, RULE_join_specification = 266, 
		RULE_join_condition = 267, RULE_named_columns_join = 268, RULE_table_primary = 269, 
		RULE_target_column = 270, RULE_column_name_list = 271, RULE_derived_table = 272, 
		RULE_where_clause = 273, RULE_search_condition = 274, RULE_groupby_clause = 275, 
		RULE_grouping_element_list = 276, RULE_grouping_element = 277, RULE_ordinary_grouping_set = 278, 
		RULE_ordinary_grouping_set_list = 279, RULE_rollup_list = 280, RULE_cube_list = 281, 
		RULE_empty_grouping_set = 282, RULE_having_clause = 283, RULE_row_value_predicand_list = 284, 
		RULE_window_clause = 285, RULE_window_definition_list = 286, RULE_window_definition = 287, 
		RULE_window_name = 288, RULE_window_specification = 289, RULE_window_specification_details = 290, 
		RULE_existing_window_name = 291, RULE_window_partition_clause = 292, RULE_window_order_clause = 293, 
		RULE_window_frame_clause = 294, RULE_window_frame_units = 295, RULE_window_frame_extent = 296, 
		RULE_window_frame_start_bound = 297, RULE_window_frame_between = 298, 
		RULE_window_frame_end_bound = 299, RULE_window_frame_exclusion = 300, 
		RULE_named_query = 301, RULE_with_clause = 302, RULE_query_expression = 303, 
		RULE_query_expression_body = 304, RULE_non_join_query_expression = 305, 
		RULE_query_term = 306, RULE_non_join_query_term = 307, RULE_query_primary = 308, 
		RULE_non_join_query_primary = 309, RULE_simple_table = 310, RULE_explicit_table = 311, 
		RULE_table_or_query_name = 312, RULE_table_name = 313, RULE_column_name = 314, 
		RULE_folder_name = 315, RULE_mapping_name = 316, RULE_dataset_hint = 317, 
		RULE_query_specification = 318, RULE_select_list = 319, RULE_select_sublist = 320, 
		RULE_derived_column = 321, RULE_qualified_asterisk = 322, RULE_set_qualifier = 323, 
		RULE_column_reference = 324, RULE_as_clause = 325, RULE_column_reference_list = 326, 
		RULE_cursor_function = 327, RULE_scalar_subquery = 328, RULE_row_subquery = 329, 
		RULE_table_subquery = 330, RULE_subquery = 331, RULE_predicate = 332, 
		RULE_quantified_comparison_predicate = 333, RULE_quantifier = 334, RULE_all = 335, 
		RULE_some = 336, RULE_comparison_predicate = 337, RULE_comp_op = 338, 
		RULE_between_predicate = 339, RULE_between_predicate_part_2 = 340, RULE_in_predicate = 341, 
		RULE_in_predicate_value = 342, RULE_in_value_list = 343, RULE_pattern_matching_predicate = 344, 
		RULE_pattern_matcher = 345, RULE_negativable_matcher = 346, RULE_regex_matcher = 347, 
		RULE_null_predicate = 348, RULE_exists_predicate = 349, RULE_unique_predicate = 350, 
		RULE_primary_datetime_field = 351, RULE_non_second_primary_datetime_field = 352, 
		RULE_extended_datetime_field = 353, RULE_routine_invocation = 354, RULE_function_names_for_reserved_words = 355, 
		RULE_schema_name = 356, RULE_function_name = 357, RULE_sql_argument_list = 358, 
		RULE_table_function = 359, RULE_orderby_clause = 360, RULE_sort_specifier_list = 361, 
		RULE_sort_specifier = 362, RULE_order_specification = 363, RULE_limit_clause = 364, 
		RULE_null_ordering = 365, RULE_integration_params = 366, RULE_insert_statement = 367, 
		RULE_multi_insert_select_list = 368, RULE_multi_insert_target = 369, RULE_multi_insert_def_target = 370, 
		RULE_multi_insert_statement = 371, RULE_alter_tablespace_statement = 372, 
		RULE_datastore_key = 373, RULE_datastore_check = 374, RULE_constraint_control = 375, 
		RULE_in_database = 376, RULE_constraint_type = 377, RULE_datastore_condition_message = 378, 
		RULE_datastore_constraint = 379, RULE_alter_table_statement = 380, RULE_alter_mapping_statement = 381, 
		RULE_open_project_statement = 382, RULE_connect_statement = 383;
	private static String[] makeRuleNames() {
		return new String[] {
			"script", "singleSqlScript", "sql", "explain_clause", "statement", "session_statement", 
			"data_statement", "data_change_statement", "schema_statement", "index_statement", 
			"database_definition", "if_not_exists", "drop_database_statement", "if_exists", 
			"or_replace", "hive_row_format", "hive_file_format", "file_alias", "file_resource_name", 
			"file_description", "file_format", "file_heading", "record_separator", 
			"field_separator", "text_delimiter", "decimal_separator", "olap_type", 
			"file_descriptor", "create_table_statement", "create_project_statement", 
			"drop_project_statement", "create_folder_statement", "drop_folder_statement", 
			"create_model_statement", "drop_model_statement", "create_submodel_statement", 
			"drop_submodel_statement", "mapping_statements_block", "create_simple_mapping", 
			"create_complex_mapping", "create_mapping_statement", "create_package_statement", 
			"create_procedure_statement", "scenario_name", "scenario_version", "odi_object_type", 
			"odi_parent_object_type", "scenario_source_type", "scenario_variable", 
			"scenario_variables", "create_scenario_statement", "regenerate_scenario_statement", 
			"drop_scenario_statement", "export_scenario_statement", "export_mapping_statement", 
			"odi_object_name", "import_object", "import_parent_object", "import_mode", 
			"import_scenario_statement", "table_elements", "field_element", "index_inline", 
			"modify_field_element", "field_type", "null_constraint", "position", 
			"offset", "field_phys_length", "field_format", "field_scd_behavior", 
			"field_comment", "param_clause", "param", "km_param", "km_name", "km_technology", 
			"km_target_item", "km_target_list", "ikm_target", "km_target", "km_params", 
			"lkm_clause", "xkm_clause", "ikm_clause", "ckm_clause", "km_list", "phys_design_name", 
			"phys_design_desc", "optimization_context", "staging_location", "mapping_command", 
			"on_begin_mapping_cmd", "on_end_mapping_cmd", "phys_design", "phys_design_clause", 
			"declare_odivar_statement", "refresh_odivar_statement", "set_odivar_statement", 
			"procedure_options", "procedure_statement", "increment_odivar_statement", 
			"mapping_statement", "package_statement", "success_clause", "error_clause", 
			"label", "generic_package_statement", "statement_block", "method_specifier", 
			"table_space_specifier", "table_space_name", "table_partitioning_clauses", 
			"range_partitions", "range_value_clause_list", "range_value_clause", 
			"hash_partitions", "individual_hash_partitions", "individual_hash_partition", 
			"hash_partitions_by_quantity", "list_partitions", "list_value_clause_list", 
			"list_value_partition", "column_partitions", "partition_name", "truncate_table_statement", 
			"annotation_element", "annotation", "truncate_mapping_statement", "truncate_reusable_mapping_statement", 
			"drop_table_statement", "drop_mapping_statement", "drop_reusable_mapping_statement", 
			"drop_package_statement", "nonreserved_keywords", "identifier", "unsigned_literal", 
			"general_literal", "datetime_literal", "time_literal", "timestamp_literal", 
			"date_literal", "interval_literal", "boolean_literal", "data_type", "predefined_type", 
			"generic_type", "network_type", "character_string_type", "type_length", 
			"national_character_string_type", "binary_large_object_string_type", 
			"numeric_type", "exact_numeric_type", "approximate_numeric_type", "precision_param", 
			"boolean_type", "datetime_type", "bit_type", "binary_type", "value_expression_primary", 
			"parenthesized_value_expression", "nonparenthesized_value_expression_primary", 
			"unsigned_value_specification", "unsigned_numeric_literal", "signed_numerical_literal", 
			"set_function_specification", "aggregate_function", "general_set_function", 
			"set_function_type", "filter_clause", "grouping_operation", "listagg_function", 
			"window_function", "window_function_nulls_clause", "window_function_type", 
			"rank_function_type", "window_name_or_specification", "case_expression", 
			"case_abbreviation", "case_specification", "simple_case", "searched_case", 
			"simple_when_clause", "searched_when_clause", "else_clause", "result", 
			"cast_specification", "cast_operand", "cast_target", "convert_specification", 
			"value_expression", "common_value_expression", "numeric_value_expression", 
			"term", "factor", "array", "numeric_primary", "sign", "numeric_value_function", 
			"extract_expression", "extract_field", "time_zone_field", "extract_source", 
			"string_value_expression", "character_value_expression", "character_factor", 
			"character_primary", "string_value_function", "trim_function", "trim_operands", 
			"trim_specification", "datetime_value_expression", "datetime_term", "datetime_factor", 
			"datetime_primary", "datetime_value_function", "current_date_value_function", 
			"current_time_value_function", "current_timestamp_value_function", "boolean_value_expression", 
			"or_predicate", "and_predicate", "boolean_factor", "boolean_test", "is_clause", 
			"truth_value", "boolean_primary", "boolean_predicand", "parenthesized_boolean_value_expression", 
			"odi_variable", "odi_variable_literal", "odi_sequence", "row_value_expression", 
			"row_value_special_case", "explicit_row_value_constructor", "row_value_predicand", 
			"row_value_constructor_predicand", "table_expression", "from_clause", 
			"table_reference_list", "unpivot_fields_list", "unpivot_source_fields_list", 
			"unpivot_rule", "unpivot_rules", "unpivot_clause", "pivot_fields_list", 
			"pivot_source_fields_list", "pivot_rule", "pivot_rules", "pivot_clause", 
			"table_reference", "annotated_joined_table_primary", "joined_table", 
			"joined_table_primary", "cross_join", "qualified_join", "natural_join", 
			"union_join", "join_type", "outer_join_type", "outer_join_type_part2", 
			"first_row", "last_row", "all_rows", "lookup_specification", "join_specification", 
			"join_condition", "named_columns_join", "table_primary", "target_column", 
			"column_name_list", "derived_table", "where_clause", "search_condition", 
			"groupby_clause", "grouping_element_list", "grouping_element", "ordinary_grouping_set", 
			"ordinary_grouping_set_list", "rollup_list", "cube_list", "empty_grouping_set", 
			"having_clause", "row_value_predicand_list", "window_clause", "window_definition_list", 
			"window_definition", "window_name", "window_specification", "window_specification_details", 
			"existing_window_name", "window_partition_clause", "window_order_clause", 
			"window_frame_clause", "window_frame_units", "window_frame_extent", "window_frame_start_bound", 
			"window_frame_between", "window_frame_end_bound", "window_frame_exclusion", 
			"named_query", "with_clause", "query_expression", "query_expression_body", 
			"non_join_query_expression", "query_term", "non_join_query_term", "query_primary", 
			"non_join_query_primary", "simple_table", "explicit_table", "table_or_query_name", 
			"table_name", "column_name", "folder_name", "mapping_name", "dataset_hint", 
			"query_specification", "select_list", "select_sublist", "derived_column", 
			"qualified_asterisk", "set_qualifier", "column_reference", "as_clause", 
			"column_reference_list", "cursor_function", "scalar_subquery", "row_subquery", 
			"table_subquery", "subquery", "predicate", "quantified_comparison_predicate", 
			"quantifier", "all", "some", "comparison_predicate", "comp_op", "between_predicate", 
			"between_predicate_part_2", "in_predicate", "in_predicate_value", "in_value_list", 
			"pattern_matching_predicate", "pattern_matcher", "negativable_matcher", 
			"regex_matcher", "null_predicate", "exists_predicate", "unique_predicate", 
			"primary_datetime_field", "non_second_primary_datetime_field", "extended_datetime_field", 
			"routine_invocation", "function_names_for_reserved_words", "schema_name", 
			"function_name", "sql_argument_list", "table_function", "orderby_clause", 
			"sort_specifier_list", "sort_specifier", "order_specification", "limit_clause", 
			"null_ordering", "integration_params", "insert_statement", "multi_insert_select_list", 
			"multi_insert_target", "multi_insert_def_target", "multi_insert_statement", 
			"alter_tablespace_statement", "datastore_key", "datastore_check", "constraint_control", 
			"in_database", "constraint_type", "datastore_condition_message", "datastore_constraint", 
			"alter_table_statement", "alter_mapping_statement", "open_project_statement", 
			"connect_statement"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "'~'", "'!~'", "'~*'", "'!~*'", null, "':='", 
			"'='", "':'", "';'", "','", null, null, "'<'", "'<='", "'>'", "'>='", 
			"'('", "')'", "'+'", "'-'", "'*'", "'/'", "'%'", "'.'", "'_'", "'|'", 
			"'''", "'\"'", "'#'", "'@'", null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "'/*+'", "'*/'", null, null, null, 
			null, null, null, "' '"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "AS", "ALL", "AND", "ANY", "ASYMMETRIC", "ASC", "BOTH", "CASE", 
			"CAST", "CREATE", "CROSS", "CURRENT_DATE", "CURRENT_TIME", "CURRENT_TIMESTAMP", 
			"DESC", "DISTINCT", "DATASET", "END", "ELSE", "EXCEPT", "FALSE", "FULL", 
			"FROM", "GROUP", "HAVING", "ILIKE", "IN", "INNER", "INTERSECT", "INTO", 
			"IS", "JOIN", "LEADING", "LEFT", "LIKE", "LIMIT", "MAPPING", "NATURAL", 
			"NOT", "NULL", "ON", "OR", "ORDER", "OUTER", "OVER", "PACKAGE", "PROCEDURE", 
			"PROJECT", "RIGHT", "REUSABLE", "SELECT", "SOME", "SYMMETRIC", "SCENARIO", 
			"TABLE", "THEN", "TRAILING", "TRUE", "UNION", "UNIQUE", "USING", "WHEN", 
			"WHERE", "WITH", "WINDOW", "VARIABLE", "POSITION", "OFFSET", "IKM", "LKM", 
			"CKM", "TECHNOLOGY", "PHYSICAL_DESIGN", "DESCRIPTION", "OPTIMIZATION_CONTEXT", 
			"REMOVE_TEMPORARY_OBJECTS_ON_ERROR", "UNIQUE_TEMPORARY_OBJECT_NAMES", 
			"AVG", "ADD", "ALTER", "BETWEEN", "BY", "CASCADE", "CATALOG", "CENTURY", 
			"CHARACTER", "COLLECT", "COALESCE", "COLUMN", "COUNT", "CUBE", "CUME_DIST", 
			"CURRENT", "STRING", "FEBCDIC", "SIGNED_PACKED_DECIMAL", "EBCDIC_SIGNED_ZONED_DECIMAL", 
			"DAY", "DEFAULT", "DATABASE", "DEC", "DECADE", "DENSE_RANK", "DOW", "DOY", 
			"DROP", "EPOCH", "EVERY", "EXCLUDE", "EXISTS", "EXPLAIN", "EXTERNAL", 
			"EXTRACT", "FILTER", "FIRST", "FIRST_VALUE", "FOLLOWING", "FOR", "FORMAT", 
			"FUSION", "GROUPING", "HASH", "HOUR", "IF", "INDEX", "INSERT", "INTERSECTION", 
			"ISODOW", "ISOYEAR", "LAG", "LAST", "LAST_VALUE", "LEAD", "LESS", "LIST", 
			"LOCATION", "MAX", "MAXVALUE", "MICROSECONDS", "MILLENNIUM", "MILLISECONDS", 
			"MIN", "MINUTE", "MONTH", "NATIONAL", "NULLIF", "NO", "OVERWRITE", "OTHERS", 
			"PARTITION", "PARTITIONS", "PERCENT_RANK", "PRECEDING", "PRECISION", 
			"PURGE", "QUARTER", "RANGE", "RANK", "REGEXP", "RENAME", "RESET", "RLIKE", 
			"ROLLUP", "ROW", "ROWS", "ROW_NUMBER", "SECOND", "SESSION", "SET", "SIMILAR", 
			"STDDEV_POP", "STDDEV_SAMP", "SUBPARTITION", "SUM", "TABLESPACE", "THAN", 
			"TIES", "TIMEZONE", "TIMEZONE_HOUR", "TIMEZONE_MINUTE", "TRIM", "TO", 
			"TRUNCATE", "UNBOUNDED", "UNKNOWN", "VALUES", "VAR_SAMP", "VAR_POP", 
			"VARYING", "WEEK", "YEAR", "ZONE", "BOOLEAN", "BOOL", "BIT", "VARBIT", 
			"INT1", "INT2", "INT4", "INT8", "TINYINT", "SMALLINT", "INT", "INTEGER", 
			"BIGINT", "FLOAT4", "FLOAT8", "REAL", "FLOAT", "DOUBLE", "NUMERIC", "ORANUMBER", 
			"DECIMAL", "CHAR", "VARCHAR2", "VARCHAR", "NCHAR", "NVARCHAR", "CLOB", 
			"DATE", "INTERVAL", "TIME", "TIMETZ", "TIMESTAMP", "TIMESTAMPTZ", "TEXT", 
			"BINARY", "VARBINARY", "BLOB", "BYTEA", "INET4", "Similar_To", "Not_Similar_To", 
			"Similar_To_Case_Insensitive", "Not_Similar_To_Case_Insensitive", "CAST_EXPRESSION", 
			"ASSIGN", "EQUAL", "COLON", "SEMI_COLON", "COMMA", "CONCATENATION_OPERATOR", 
			"NOT_EQUAL", "LTH", "LEQ", "GTH", "GEQ", "LEFT_PAREN", "RIGHT_PAREN", 
			"PLUS", "MINUS", "MULTIPLY", "DIVIDE", "MODULAR", "DOT", "UNDERLINE", 
			"VERTICAL_BAR", "QUOTE", "DOUBLE_QUOTE", "HASH_SIGN", "AT_SIGN", "NUMBER", 
			"REAL_NUMBER", "NULLS", "MINUS_SET", "DATASTORE", "ALIAS", "RESOURCE", 
			"FILE", "HEADING", "RECORD_SEP", "FIELD_SEP", "TEXT_DELIM", "DECIMAL_SEP", 
			"FIXED", "DELIMITED", "PHYS_LENGTH", "SCD", "SCD_BEHAVIOR", "MODEL", 
			"WITH_NAME", "LOGICAL_SCHEMA", "FOLDER", "SUBMODEL", "MODIFY", "REPLACE", 
			"CONTEXT", "XKM", "SEQUENCEFILE", "FIELDS", "TERMINATED", "ESCAPED", 
			"DEFINED", "SERDE", "SERDEPROPERTIES", "TEXTFILE", "RCFILE", "ORC", "PARQUET", 
			"AVRO", "INPUTFORMAT", "OUTPUTFORMAT", "TEMPORARY", "STORED_AS", "TBLPROPERTIES", 
			"ROW_FORMAT", "INTEGRATION_TYPE", "UPDATE_KEY", "REJECT", "PERCENT", 
			"PRIMARY_KEY", "ALTERNATE_KEY", "OLAP_TYPE", "CONSTRAINT", "ODI_Tag_Start", 
			"ODI_Tag_End", "ODIREF", "CURSOR", "SUCCESS", "ERROR", "GOTO", "DECLARE", 
			"REFRESH", "RETRY", "WAIT", "BEGIN", "EXIT", "CMNT", "LISTAGG", "WITHIN_GROUP", 
			"EXPORT", "IMPORT", "REGENERATE", "OR_REPLACE", "TYPE", "STAGING", "CONNECT", 
			"ODI", "IGNORE_NULLS", "RESPECT_NULLS", "CONVERT", "DATETIME", "VARCHAR_MAX", 
			"VARCHAR2_MAX", "CONTINUE", "CHECK", "CONTROL", "FLOW", "STATIC", "ACTIVE", 
			"MESSAGE", "KEEP", "PIVOT", "UNPIVOT", "INCLUDE", "Odi_Sequence", "Odi_Variable", 
			"Odi_Variable_Literal", "Hint_Start", "Hint_End", "BlockComment", "LineComment", 
			"Regular_Identifier", "Quoted_Identifier", "Character_String_Literal", 
			"FreeCode", "Space", "White_Space", "BAD"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SQLParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }



	public SQLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ScriptContext extends ParserRuleContext {
		public List<SqlContext> sql() {
			return getRuleContexts(SqlContext.class);
		}
		public SqlContext sql(int i) {
			return getRuleContext(SqlContext.class,i);
		}
		public TerminalNode EOF() { return getToken(SQLParser.EOF, 0); }
		public ScriptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_script; }
	}

	public final ScriptContext script() throws RecognitionException {
		ScriptContext _localctx = new ScriptContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_script);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(768);
			sql();
			setState(772);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2533274790396928L) != 0) || ((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & 70370958770177L) != 0) || ((((_la - 161)) & ~0x3f) == 0 && ((1L << (_la - 161)) & 4194561L) != 0) || _la==AT_SIGN || ((((_la - 331)) & ~0x3f) == 0 && ((1L << (_la - 331)) & 71L) != 0)) {
				{
				{
				setState(769);
				sql();
				}
				}
				setState(774);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(775);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SingleSqlScriptContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SQLParser.EOF, 0); }
		public Explain_clauseContext explain_clause() {
			return getRuleContext(Explain_clauseContext.class,0);
		}
		public TerminalNode SEMI_COLON() { return getToken(SQLParser.SEMI_COLON, 0); }
		public SingleSqlScriptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleSqlScript; }
	}

	public final SingleSqlScriptContext singleSqlScript() throws RecognitionException {
		SingleSqlScriptContext _localctx = new SingleSqlScriptContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_singleSqlScript);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(778);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXPLAIN) {
				{
				setState(777);
				explain_clause();
				}
			}

			setState(780);
			statement();
			setState(782);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI_COLON) {
				{
				setState(781);
				match(SEMI_COLON);
				}
			}

			setState(784);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SqlContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public Explain_clauseContext explain_clause() {
			return getRuleContext(Explain_clauseContext.class,0);
		}
		public TerminalNode SEMI_COLON() { return getToken(SQLParser.SEMI_COLON, 0); }
		public SqlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sql; }
	}

	public final SqlContext sql() throws RecognitionException {
		SqlContext _localctx = new SqlContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_sql);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(787);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXPLAIN) {
				{
				setState(786);
				explain_clause();
				}
			}

			setState(789);
			statement();
			setState(791);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI_COLON) {
				{
				setState(790);
				match(SEMI_COLON);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Explain_clauseContext extends ParserRuleContext {
		public TerminalNode EXPLAIN() { return getToken(SQLParser.EXPLAIN, 0); }
		public Explain_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explain_clause; }
	}

	public final Explain_clauseContext explain_clause() throws RecognitionException {
		Explain_clauseContext _localctx = new Explain_clauseContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_explain_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(793);
			match(EXPLAIN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public Session_statementContext session_statement() {
			return getRuleContext(Session_statementContext.class,0);
		}
		public Data_statementContext data_statement() {
			return getRuleContext(Data_statementContext.class,0);
		}
		public Data_change_statementContext data_change_statement() {
			return getRuleContext(Data_change_statementContext.class,0);
		}
		public Schema_statementContext schema_statement() {
			return getRuleContext(Schema_statementContext.class,0);
		}
		public Index_statementContext index_statement() {
			return getRuleContext(Index_statementContext.class,0);
		}
		public Open_project_statementContext open_project_statement() {
			return getRuleContext(Open_project_statementContext.class,0);
		}
		public Connect_statementContext connect_statement() {
			return getRuleContext(Connect_statementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_statement);
		try {
			setState(802);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(795);
				session_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(796);
				data_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(797);
				data_change_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(798);
				schema_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(799);
				index_statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(800);
				open_project_statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(801);
				connect_statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Session_statementContext extends ParserRuleContext {
		public IdentifierContext dbname;
		public IdentifierContext name;
		public TerminalNode SET() { return getToken(SQLParser.SET, 0); }
		public TerminalNode CATALOG() { return getToken(SQLParser.CATALOG, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode TIME() { return getToken(SQLParser.TIME, 0); }
		public TerminalNode ZONE() { return getToken(SQLParser.ZONE, 0); }
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public Signed_numerical_literalContext signed_numerical_literal() {
			return getRuleContext(Signed_numerical_literalContext.class,0);
		}
		public TerminalNode DEFAULT() { return getToken(SQLParser.DEFAULT, 0); }
		public TerminalNode TO() { return getToken(SQLParser.TO, 0); }
		public TerminalNode EQUAL() { return getToken(SQLParser.EQUAL, 0); }
		public Boolean_literalContext boolean_literal() {
			return getRuleContext(Boolean_literalContext.class,0);
		}
		public TerminalNode SESSION() { return getToken(SQLParser.SESSION, 0); }
		public TerminalNode RESET() { return getToken(SQLParser.RESET, 0); }
		public Session_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_session_statement; }
	}

	public final Session_statementContext session_statement() throws RecognitionException {
		Session_statementContext _localctx = new Session_statementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_session_statement);
		int _la;
		try {
			setState(834);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(804);
				match(SET);
				setState(805);
				match(CATALOG);
				setState(806);
				((Session_statementContext)_localctx).dbname = identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(807);
				match(SET);
				setState(808);
				match(TIME);
				setState(809);
				match(ZONE);
				setState(811);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TO || _la==EQUAL) {
					{
					setState(810);
					_la = _input.LA(1);
					if ( !(_la==TO || _la==EQUAL) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(816);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Character_String_Literal:
					{
					setState(813);
					match(Character_String_Literal);
					}
					break;
				case PLUS:
				case MINUS:
				case NUMBER:
				case REAL_NUMBER:
					{
					setState(814);
					signed_numerical_literal();
					}
					break;
				case DEFAULT:
					{
					setState(815);
					match(DEFAULT);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(818);
				match(SET);
				setState(820);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(819);
					match(SESSION);
					}
					break;
				}
				setState(822);
				((Session_statementContext)_localctx).name = identifier();
				setState(824);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TO || _la==EQUAL) {
					{
					setState(823);
					_la = _input.LA(1);
					if ( !(_la==TO || _la==EQUAL) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(830);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Character_String_Literal:
					{
					setState(826);
					match(Character_String_Literal);
					}
					break;
				case PLUS:
				case MINUS:
				case NUMBER:
				case REAL_NUMBER:
					{
					setState(827);
					signed_numerical_literal();
					}
					break;
				case FALSE:
				case TRUE:
				case UNKNOWN:
					{
					setState(828);
					boolean_literal();
					}
					break;
				case DEFAULT:
					{
					setState(829);
					match(DEFAULT);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(832);
				match(RESET);
				setState(833);
				((Session_statementContext)_localctx).name = identifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Data_statementContext extends ParserRuleContext {
		public Query_specificationContext query_specification() {
			return getRuleContext(Query_specificationContext.class,0);
		}
		public Data_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data_statement; }
	}

	public final Data_statementContext data_statement() throws RecognitionException {
		Data_statementContext _localctx = new Data_statementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_data_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(836);
			query_specification();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Data_change_statementContext extends ParserRuleContext {
		public Insert_statementContext insert_statement() {
			return getRuleContext(Insert_statementContext.class,0);
		}
		public Multi_insert_statementContext multi_insert_statement() {
			return getRuleContext(Multi_insert_statementContext.class,0);
		}
		public Data_change_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data_change_statement; }
	}

	public final Data_change_statementContext data_change_statement() throws RecognitionException {
		Data_change_statementContext _localctx = new Data_change_statementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_data_change_statement);
		try {
			setState(840);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(838);
				insert_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(839);
				multi_insert_statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Schema_statementContext extends ParserRuleContext {
		public Database_definitionContext database_definition() {
			return getRuleContext(Database_definitionContext.class,0);
		}
		public Drop_database_statementContext drop_database_statement() {
			return getRuleContext(Drop_database_statementContext.class,0);
		}
		public Create_table_statementContext create_table_statement() {
			return getRuleContext(Create_table_statementContext.class,0);
		}
		public Drop_table_statementContext drop_table_statement() {
			return getRuleContext(Drop_table_statementContext.class,0);
		}
		public Alter_tablespace_statementContext alter_tablespace_statement() {
			return getRuleContext(Alter_tablespace_statementContext.class,0);
		}
		public Alter_table_statementContext alter_table_statement() {
			return getRuleContext(Alter_table_statementContext.class,0);
		}
		public Truncate_table_statementContext truncate_table_statement() {
			return getRuleContext(Truncate_table_statementContext.class,0);
		}
		public Alter_mapping_statementContext alter_mapping_statement() {
			return getRuleContext(Alter_mapping_statementContext.class,0);
		}
		public Create_mapping_statementContext create_mapping_statement() {
			return getRuleContext(Create_mapping_statementContext.class,0);
		}
		public Create_package_statementContext create_package_statement() {
			return getRuleContext(Create_package_statementContext.class,0);
		}
		public Create_scenario_statementContext create_scenario_statement() {
			return getRuleContext(Create_scenario_statementContext.class,0);
		}
		public Regenerate_scenario_statementContext regenerate_scenario_statement() {
			return getRuleContext(Regenerate_scenario_statementContext.class,0);
		}
		public Drop_mapping_statementContext drop_mapping_statement() {
			return getRuleContext(Drop_mapping_statementContext.class,0);
		}
		public Truncate_mapping_statementContext truncate_mapping_statement() {
			return getRuleContext(Truncate_mapping_statementContext.class,0);
		}
		public Drop_reusable_mapping_statementContext drop_reusable_mapping_statement() {
			return getRuleContext(Drop_reusable_mapping_statementContext.class,0);
		}
		public Truncate_reusable_mapping_statementContext truncate_reusable_mapping_statement() {
			return getRuleContext(Truncate_reusable_mapping_statementContext.class,0);
		}
		public Drop_package_statementContext drop_package_statement() {
			return getRuleContext(Drop_package_statementContext.class,0);
		}
		public Create_model_statementContext create_model_statement() {
			return getRuleContext(Create_model_statementContext.class,0);
		}
		public Create_submodel_statementContext create_submodel_statement() {
			return getRuleContext(Create_submodel_statementContext.class,0);
		}
		public Create_project_statementContext create_project_statement() {
			return getRuleContext(Create_project_statementContext.class,0);
		}
		public Create_folder_statementContext create_folder_statement() {
			return getRuleContext(Create_folder_statementContext.class,0);
		}
		public Drop_project_statementContext drop_project_statement() {
			return getRuleContext(Drop_project_statementContext.class,0);
		}
		public Drop_model_statementContext drop_model_statement() {
			return getRuleContext(Drop_model_statementContext.class,0);
		}
		public Drop_folder_statementContext drop_folder_statement() {
			return getRuleContext(Drop_folder_statementContext.class,0);
		}
		public Drop_submodel_statementContext drop_submodel_statement() {
			return getRuleContext(Drop_submodel_statementContext.class,0);
		}
		public Drop_scenario_statementContext drop_scenario_statement() {
			return getRuleContext(Drop_scenario_statementContext.class,0);
		}
		public Export_scenario_statementContext export_scenario_statement() {
			return getRuleContext(Export_scenario_statementContext.class,0);
		}
		public Import_scenario_statementContext import_scenario_statement() {
			return getRuleContext(Import_scenario_statementContext.class,0);
		}
		public Export_mapping_statementContext export_mapping_statement() {
			return getRuleContext(Export_mapping_statementContext.class,0);
		}
		public Schema_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_schema_statement; }
	}

	public final Schema_statementContext schema_statement() throws RecognitionException {
		Schema_statementContext _localctx = new Schema_statementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_schema_statement);
		try {
			setState(871);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(842);
				database_definition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(843);
				drop_database_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(844);
				create_table_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(845);
				drop_table_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(846);
				alter_tablespace_statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(847);
				alter_table_statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(848);
				truncate_table_statement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(849);
				alter_mapping_statement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(850);
				create_mapping_statement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(851);
				create_package_statement();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(852);
				create_scenario_statement();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(853);
				regenerate_scenario_statement();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(854);
				drop_mapping_statement();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(855);
				truncate_mapping_statement();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(856);
				drop_reusable_mapping_statement();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(857);
				truncate_reusable_mapping_statement();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(858);
				drop_package_statement();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(859);
				create_model_statement();
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(860);
				create_submodel_statement();
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(861);
				create_project_statement();
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(862);
				create_folder_statement();
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(863);
				drop_project_statement();
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(864);
				drop_model_statement();
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 24);
				{
				setState(865);
				drop_folder_statement();
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 25);
				{
				setState(866);
				drop_submodel_statement();
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 26);
				{
				setState(867);
				drop_scenario_statement();
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 27);
				{
				setState(868);
				export_scenario_statement();
				}
				break;
			case 28:
				enterOuterAlt(_localctx, 28);
				{
				setState(869);
				import_scenario_statement();
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 29);
				{
				setState(870);
				export_mapping_statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Index_statementContext extends ParserRuleContext {
		public Token u;
		public IdentifierContext n;
		public Table_nameContext t;
		public Method_specifierContext m;
		public Sort_specifier_listContext s;
		public Param_clauseContext p;
		public TerminalNode CREATE() { return getToken(SQLParser.CREATE, 0); }
		public TerminalNode INDEX() { return getToken(SQLParser.INDEX, 0); }
		public TerminalNode ON() { return getToken(SQLParser.ON, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public Sort_specifier_listContext sort_specifier_list() {
			return getRuleContext(Sort_specifier_listContext.class,0);
		}
		public TerminalNode UNIQUE() { return getToken(SQLParser.UNIQUE, 0); }
		public Method_specifierContext method_specifier() {
			return getRuleContext(Method_specifierContext.class,0);
		}
		public Param_clauseContext param_clause() {
			return getRuleContext(Param_clauseContext.class,0);
		}
		public Index_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_index_statement; }
	}

	public final Index_statementContext index_statement() throws RecognitionException {
		Index_statementContext _localctx = new Index_statementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_index_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(873);
			match(CREATE);
			setState(875);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==UNIQUE) {
				{
				setState(874);
				((Index_statementContext)_localctx).u = match(UNIQUE);
				}
			}

			setState(877);
			match(INDEX);
			setState(878);
			((Index_statementContext)_localctx).n = identifier();
			setState(879);
			match(ON);
			setState(880);
			((Index_statementContext)_localctx).t = table_name();
			setState(882);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==USING) {
				{
				setState(881);
				((Index_statementContext)_localctx).m = method_specifier();
				}
			}

			setState(884);
			match(LEFT_PAREN);
			setState(885);
			((Index_statementContext)_localctx).s = sort_specifier_list();
			setState(886);
			match(RIGHT_PAREN);
			setState(888);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LEFT_PAREN) {
				{
				setState(887);
				((Index_statementContext)_localctx).p = param_clause();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Database_definitionContext extends ParserRuleContext {
		public IdentifierContext dbname;
		public TerminalNode CREATE() { return getToken(SQLParser.CREATE, 0); }
		public TerminalNode DATABASE() { return getToken(SQLParser.DATABASE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public If_not_existsContext if_not_exists() {
			return getRuleContext(If_not_existsContext.class,0);
		}
		public Database_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_database_definition; }
	}

	public final Database_definitionContext database_definition() throws RecognitionException {
		Database_definitionContext _localctx = new Database_definitionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_database_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(890);
			match(CREATE);
			setState(891);
			match(DATABASE);
			setState(893);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(892);
				if_not_exists();
				}
			}

			setState(895);
			((Database_definitionContext)_localctx).dbname = identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class If_not_existsContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(SQLParser.IF, 0); }
		public TerminalNode NOT() { return getToken(SQLParser.NOT, 0); }
		public TerminalNode EXISTS() { return getToken(SQLParser.EXISTS, 0); }
		public If_not_existsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_not_exists; }
	}

	public final If_not_existsContext if_not_exists() throws RecognitionException {
		If_not_existsContext _localctx = new If_not_existsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_if_not_exists);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(897);
			match(IF);
			setState(898);
			match(NOT);
			setState(899);
			match(EXISTS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Drop_database_statementContext extends ParserRuleContext {
		public IdentifierContext dbname;
		public TerminalNode DROP() { return getToken(SQLParser.DROP, 0); }
		public TerminalNode DATABASE() { return getToken(SQLParser.DATABASE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public If_existsContext if_exists() {
			return getRuleContext(If_existsContext.class,0);
		}
		public Drop_database_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop_database_statement; }
	}

	public final Drop_database_statementContext drop_database_statement() throws RecognitionException {
		Drop_database_statementContext _localctx = new Drop_database_statementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_drop_database_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(901);
			match(DROP);
			setState(902);
			match(DATABASE);
			setState(904);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(903);
				if_exists();
				}
			}

			setState(906);
			((Drop_database_statementContext)_localctx).dbname = identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class If_existsContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(SQLParser.IF, 0); }
		public TerminalNode EXISTS() { return getToken(SQLParser.EXISTS, 0); }
		public If_existsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_exists; }
	}

	public final If_existsContext if_exists() throws RecognitionException {
		If_existsContext _localctx = new If_existsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_if_exists);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(908);
			match(IF);
			setState(909);
			match(EXISTS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Or_replaceContext extends ParserRuleContext {
		public TerminalNode OR_REPLACE() { return getToken(SQLParser.OR_REPLACE, 0); }
		public Or_replaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or_replace; }
	}

	public final Or_replaceContext or_replace() throws RecognitionException {
		Or_replaceContext _localctx = new Or_replaceContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_or_replace);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(911);
			match(OR_REPLACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Hive_row_formatContext extends ParserRuleContext {
		public TerminalNode DELIMITED() { return getToken(SQLParser.DELIMITED, 0); }
		public TerminalNode FIELDS() { return getToken(SQLParser.FIELDS, 0); }
		public TerminalNode TERMINATED() { return getToken(SQLParser.TERMINATED, 0); }
		public List<TerminalNode> BY() { return getTokens(SQLParser.BY); }
		public TerminalNode BY(int i) {
			return getToken(SQLParser.BY, i);
		}
		public List<TerminalNode> Character_String_Literal() { return getTokens(SQLParser.Character_String_Literal); }
		public TerminalNode Character_String_Literal(int i) {
			return getToken(SQLParser.Character_String_Literal, i);
		}
		public TerminalNode ESCAPED() { return getToken(SQLParser.ESCAPED, 0); }
		public TerminalNode SERDE() { return getToken(SQLParser.SERDE, 0); }
		public TerminalNode WITH() { return getToken(SQLParser.WITH, 0); }
		public TerminalNode SERDEPROPERTIES() { return getToken(SQLParser.SERDEPROPERTIES, 0); }
		public Param_clauseContext param_clause() {
			return getRuleContext(Param_clauseContext.class,0);
		}
		public Hive_row_formatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hive_row_format; }
	}

	public final Hive_row_formatContext hive_row_format() throws RecognitionException {
		Hive_row_formatContext _localctx = new Hive_row_formatContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_hive_row_format);
		int _la;
		try {
			setState(932);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DELIMITED:
				enterOuterAlt(_localctx, 1);
				{
				setState(913);
				match(DELIMITED);
				setState(923);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FIELDS) {
					{
					setState(914);
					match(FIELDS);
					setState(915);
					match(TERMINATED);
					setState(916);
					match(BY);
					setState(917);
					match(Character_String_Literal);
					setState(921);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ESCAPED) {
						{
						setState(918);
						match(ESCAPED);
						setState(919);
						match(BY);
						setState(920);
						match(Character_String_Literal);
						}
					}

					}
				}

				}
				break;
			case SERDE:
				enterOuterAlt(_localctx, 2);
				{
				setState(925);
				match(SERDE);
				setState(926);
				match(Character_String_Literal);
				setState(930);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WITH) {
					{
					setState(927);
					match(WITH);
					setState(928);
					match(SERDEPROPERTIES);
					setState(929);
					param_clause();
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Hive_file_formatContext extends ParserRuleContext {
		public Token input_format_classname;
		public Token output_format_classname;
		public TerminalNode SEQUENCEFILE() { return getToken(SQLParser.SEQUENCEFILE, 0); }
		public TerminalNode TEXTFILE() { return getToken(SQLParser.TEXTFILE, 0); }
		public TerminalNode RCFILE() { return getToken(SQLParser.RCFILE, 0); }
		public TerminalNode ORC() { return getToken(SQLParser.ORC, 0); }
		public TerminalNode PARQUET() { return getToken(SQLParser.PARQUET, 0); }
		public TerminalNode AVRO() { return getToken(SQLParser.AVRO, 0); }
		public TerminalNode INPUTFORMAT() { return getToken(SQLParser.INPUTFORMAT, 0); }
		public TerminalNode OUTPUTFORMAT() { return getToken(SQLParser.OUTPUTFORMAT, 0); }
		public List<TerminalNode> Character_String_Literal() { return getTokens(SQLParser.Character_String_Literal); }
		public TerminalNode Character_String_Literal(int i) {
			return getToken(SQLParser.Character_String_Literal, i);
		}
		public Hive_file_formatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hive_file_format; }
	}

	public final Hive_file_formatContext hive_file_format() throws RecognitionException {
		Hive_file_formatContext _localctx = new Hive_file_formatContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_hive_file_format);
		try {
			setState(944);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEQUENCEFILE:
				enterOuterAlt(_localctx, 1);
				{
				setState(934);
				match(SEQUENCEFILE);
				}
				break;
			case TEXTFILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(935);
				match(TEXTFILE);
				}
				break;
			case RCFILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(936);
				match(RCFILE);
				}
				break;
			case ORC:
				enterOuterAlt(_localctx, 4);
				{
				setState(937);
				match(ORC);
				}
				break;
			case PARQUET:
				enterOuterAlt(_localctx, 5);
				{
				setState(938);
				match(PARQUET);
				}
				break;
			case AVRO:
				enterOuterAlt(_localctx, 6);
				{
				setState(939);
				match(AVRO);
				}
				break;
			case INPUTFORMAT:
				enterOuterAlt(_localctx, 7);
				{
				setState(940);
				match(INPUTFORMAT);
				setState(941);
				((Hive_file_formatContext)_localctx).input_format_classname = match(Character_String_Literal);
				setState(942);
				match(OUTPUTFORMAT);
				setState(943);
				((Hive_file_formatContext)_localctx).output_format_classname = match(Character_String_Literal);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class File_aliasContext extends ParserRuleContext {
		public TerminalNode ALIAS() { return getToken(SQLParser.ALIAS, 0); }
		public TerminalNode Regular_Identifier() { return getToken(SQLParser.Regular_Identifier, 0); }
		public File_aliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file_alias; }
	}

	public final File_aliasContext file_alias() throws RecognitionException {
		File_aliasContext _localctx = new File_aliasContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_file_alias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(946);
			match(ALIAS);
			setState(947);
			match(Regular_Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class File_resource_nameContext extends ParserRuleContext {
		public TerminalNode RESOURCE() { return getToken(SQLParser.RESOURCE, 0); }
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public Odi_variable_literalContext odi_variable_literal() {
			return getRuleContext(Odi_variable_literalContext.class,0);
		}
		public File_resource_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file_resource_name; }
	}

	public final File_resource_nameContext file_resource_name() throws RecognitionException {
		File_resource_nameContext _localctx = new File_resource_nameContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_file_resource_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(949);
			match(RESOURCE);
			setState(952);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Character_String_Literal:
				{
				setState(950);
				match(Character_String_Literal);
				}
				break;
			case Odi_Variable_Literal:
				{
				setState(951);
				odi_variable_literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class File_descriptionContext extends ParserRuleContext {
		public TerminalNode DESCRIPTION() { return getToken(SQLParser.DESCRIPTION, 0); }
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public File_descriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file_description; }
	}

	public final File_descriptionContext file_description() throws RecognitionException {
		File_descriptionContext _localctx = new File_descriptionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_file_description);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(954);
			match(DESCRIPTION);
			setState(955);
			match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class File_formatContext extends ParserRuleContext {
		public TerminalNode FORMAT() { return getToken(SQLParser.FORMAT, 0); }
		public TerminalNode FIXED() { return getToken(SQLParser.FIXED, 0); }
		public TerminalNode DELIMITED() { return getToken(SQLParser.DELIMITED, 0); }
		public File_formatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file_format; }
	}

	public final File_formatContext file_format() throws RecognitionException {
		File_formatContext _localctx = new File_formatContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_file_format);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(957);
			match(FORMAT);
			setState(958);
			_la = _input.LA(1);
			if ( !(_la==FIXED || _la==DELIMITED) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class File_headingContext extends ParserRuleContext {
		public TerminalNode HEADING() { return getToken(SQLParser.HEADING, 0); }
		public TerminalNode NUMBER() { return getToken(SQLParser.NUMBER, 0); }
		public File_headingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file_heading; }
	}

	public final File_headingContext file_heading() throws RecognitionException {
		File_headingContext _localctx = new File_headingContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_file_heading);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(960);
			match(HEADING);
			setState(961);
			match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Record_separatorContext extends ParserRuleContext {
		public TerminalNode RECORD_SEP() { return getToken(SQLParser.RECORD_SEP, 0); }
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public Record_separatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_record_separator; }
	}

	public final Record_separatorContext record_separator() throws RecognitionException {
		Record_separatorContext _localctx = new Record_separatorContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_record_separator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(963);
			match(RECORD_SEP);
			setState(964);
			match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Field_separatorContext extends ParserRuleContext {
		public TerminalNode FIELD_SEP() { return getToken(SQLParser.FIELD_SEP, 0); }
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public Field_separatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_separator; }
	}

	public final Field_separatorContext field_separator() throws RecognitionException {
		Field_separatorContext _localctx = new Field_separatorContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_field_separator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(966);
			match(FIELD_SEP);
			setState(967);
			match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Text_delimiterContext extends ParserRuleContext {
		public TerminalNode TEXT_DELIM() { return getToken(SQLParser.TEXT_DELIM, 0); }
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public Text_delimiterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text_delimiter; }
	}

	public final Text_delimiterContext text_delimiter() throws RecognitionException {
		Text_delimiterContext _localctx = new Text_delimiterContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_text_delimiter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(969);
			match(TEXT_DELIM);
			setState(970);
			match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Decimal_separatorContext extends ParserRuleContext {
		public TerminalNode DECIMAL_SEP() { return getToken(SQLParser.DECIMAL_SEP, 0); }
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public Decimal_separatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decimal_separator; }
	}

	public final Decimal_separatorContext decimal_separator() throws RecognitionException {
		Decimal_separatorContext _localctx = new Decimal_separatorContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_decimal_separator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(972);
			match(DECIMAL_SEP);
			setState(973);
			match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Olap_typeContext extends ParserRuleContext {
		public Token otype;
		public TerminalNode OLAP_TYPE() { return getToken(SQLParser.OLAP_TYPE, 0); }
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public Olap_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_olap_type; }
	}

	public final Olap_typeContext olap_type() throws RecognitionException {
		Olap_typeContext _localctx = new Olap_typeContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_olap_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(975);
			match(OLAP_TYPE);
			setState(976);
			((Olap_typeContext)_localctx).otype = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class File_descriptorContext extends ParserRuleContext {
		public TerminalNode FILE() { return getToken(SQLParser.FILE, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public File_formatContext file_format() {
			return getRuleContext(File_formatContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public File_headingContext file_heading() {
			return getRuleContext(File_headingContext.class,0);
		}
		public Record_separatorContext record_separator() {
			return getRuleContext(Record_separatorContext.class,0);
		}
		public Field_separatorContext field_separator() {
			return getRuleContext(Field_separatorContext.class,0);
		}
		public Text_delimiterContext text_delimiter() {
			return getRuleContext(Text_delimiterContext.class,0);
		}
		public Decimal_separatorContext decimal_separator() {
			return getRuleContext(Decimal_separatorContext.class,0);
		}
		public File_descriptorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file_descriptor; }
	}

	public final File_descriptorContext file_descriptor() throws RecognitionException {
		File_descriptorContext _localctx = new File_descriptorContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_file_descriptor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(978);
			match(FILE);
			setState(998);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(979);
				match(LEFT_PAREN);
				setState(980);
				file_format();
				setState(982);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==HEADING) {
					{
					setState(981);
					file_heading();
					}
				}

				setState(985);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RECORD_SEP) {
					{
					setState(984);
					record_separator();
					}
				}

				setState(988);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FIELD_SEP) {
					{
					setState(987);
					field_separator();
					}
				}

				setState(991);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TEXT_DELIM) {
					{
					setState(990);
					text_delimiter();
					}
				}

				setState(994);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DECIMAL_SEP) {
					{
					setState(993);
					decimal_separator();
					}
				}

				setState(996);
				match(RIGHT_PAREN);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Create_table_statementContext extends ParserRuleContext {
		public Token path;
		public Param_clauseContext params;
		public IdentifierContext storage_type;
		public Table_nameContext like_table_name;
		public TerminalNode CREATE() { return getToken(SQLParser.CREATE, 0); }
		public List<Table_nameContext> table_name() {
			return getRuleContexts(Table_nameContext.class);
		}
		public Table_nameContext table_name(int i) {
			return getRuleContext(Table_nameContext.class,i);
		}
		public Table_elementsContext table_elements() {
			return getRuleContext(Table_elementsContext.class,0);
		}
		public TerminalNode TABLE() { return getToken(SQLParser.TABLE, 0); }
		public TerminalNode DATASTORE() { return getToken(SQLParser.DATASTORE, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public Or_replaceContext or_replace() {
			return getRuleContext(Or_replaceContext.class,0);
		}
		public TerminalNode TEMPORARY() { return getToken(SQLParser.TEMPORARY, 0); }
		public TerminalNode EXTERNAL() { return getToken(SQLParser.EXTERNAL, 0); }
		public If_not_existsContext if_not_exists() {
			return getRuleContext(If_not_existsContext.class,0);
		}
		public File_aliasContext file_alias() {
			return getRuleContext(File_aliasContext.class,0);
		}
		public File_resource_nameContext file_resource_name() {
			return getRuleContext(File_resource_nameContext.class,0);
		}
		public Olap_typeContext olap_type() {
			return getRuleContext(Olap_typeContext.class,0);
		}
		public File_descriptionContext file_description() {
			return getRuleContext(File_descriptionContext.class,0);
		}
		public TerminalNode ROW_FORMAT() { return getToken(SQLParser.ROW_FORMAT, 0); }
		public Hive_row_formatContext hive_row_format() {
			return getRuleContext(Hive_row_formatContext.class,0);
		}
		public TerminalNode STORED_AS() { return getToken(SQLParser.STORED_AS, 0); }
		public Hive_file_formatContext hive_file_format() {
			return getRuleContext(Hive_file_formatContext.class,0);
		}
		public TerminalNode LOCATION() { return getToken(SQLParser.LOCATION, 0); }
		public TerminalNode TBLPROPERTIES() { return getToken(SQLParser.TBLPROPERTIES, 0); }
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public Param_clauseContext param_clause() {
			return getRuleContext(Param_clauseContext.class,0);
		}
		public File_descriptorContext file_descriptor() {
			return getRuleContext(File_descriptorContext.class,0);
		}
		public Table_partitioning_clausesContext table_partitioning_clauses() {
			return getRuleContext(Table_partitioning_clausesContext.class,0);
		}
		public TerminalNode AS() { return getToken(SQLParser.AS, 0); }
		public Query_expressionContext query_expression() {
			return getRuleContext(Query_expressionContext.class,0);
		}
		public TerminalNode USING() { return getToken(SQLParser.USING, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LIKE() { return getToken(SQLParser.LIKE, 0); }
		public Insert_statementContext insert_statement() {
			return getRuleContext(Insert_statementContext.class,0);
		}
		public Create_table_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_table_statement; }
	}

	public final Create_table_statementContext create_table_statement() throws RecognitionException {
		Create_table_statementContext _localctx = new Create_table_statementContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_create_table_statement);
		int _la;
		try {
			setState(1122);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1003);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT_SIGN) {
					{
					{
					setState(1000);
					annotation();
					}
					}
					setState(1005);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1006);
				match(CREATE);
				setState(1008);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OR_REPLACE) {
					{
					setState(1007);
					or_replace();
					}
				}

				setState(1011);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TEMPORARY) {
					{
					setState(1010);
					match(TEMPORARY);
					}
				}

				setState(1014);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EXTERNAL) {
					{
					setState(1013);
					match(EXTERNAL);
					}
				}

				setState(1016);
				_la = _input.LA(1);
				if ( !(_la==TABLE || _la==DATASTORE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1018);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(1017);
					if_not_exists();
					}
				}

				setState(1020);
				table_name();
				setState(1022);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ALIAS) {
					{
					setState(1021);
					file_alias();
					}
				}

				setState(1025);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RESOURCE) {
					{
					setState(1024);
					file_resource_name();
					}
				}

				setState(1028);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OLAP_TYPE) {
					{
					setState(1027);
					olap_type();
					}
				}

				setState(1031);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DESCRIPTION) {
					{
					setState(1030);
					file_description();
					}
				}

				setState(1033);
				table_elements();
				setState(1036);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ROW_FORMAT) {
					{
					setState(1034);
					match(ROW_FORMAT);
					setState(1035);
					hive_row_format();
					}
				}

				setState(1040);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STORED_AS) {
					{
					setState(1038);
					match(STORED_AS);
					setState(1039);
					hive_file_format();
					}
				}

				setState(1044);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LOCATION) {
					{
					setState(1042);
					match(LOCATION);
					setState(1043);
					((Create_table_statementContext)_localctx).path = match(Character_String_Literal);
					}
				}

				setState(1048);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TBLPROPERTIES) {
					{
					setState(1046);
					match(TBLPROPERTIES);
					setState(1047);
					((Create_table_statementContext)_localctx).params = param_clause();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1053);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT_SIGN) {
					{
					{
					setState(1050);
					annotation();
					}
					}
					setState(1055);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1056);
				match(CREATE);
				setState(1058);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OR_REPLACE) {
					{
					setState(1057);
					or_replace();
					}
				}

				setState(1060);
				_la = _input.LA(1);
				if ( !(_la==TABLE || _la==DATASTORE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1062);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(1061);
					if_not_exists();
					}
				}

				setState(1064);
				table_name();
				setState(1066);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ALIAS) {
					{
					setState(1065);
					file_alias();
					}
				}

				setState(1069);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RESOURCE) {
					{
					setState(1068);
					file_resource_name();
					}
				}

				setState(1071);
				table_elements();
				setState(1073);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FILE) {
					{
					setState(1072);
					file_descriptor();
					}
				}

				setState(1076);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(1075);
					param_clause();
					}
				}

				setState(1079);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(1078);
					table_partitioning_clauses();
					}
				}

				setState(1083);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(1081);
					match(AS);
					setState(1082);
					query_expression();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1085);
				match(CREATE);
				setState(1086);
				match(TABLE);
				setState(1088);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(1087);
					if_not_exists();
					}
				}

				setState(1090);
				table_name();
				setState(1093);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(1091);
					match(USING);
					setState(1092);
					((Create_table_statementContext)_localctx).storage_type = identifier();
					}
				}

				setState(1096);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(1095);
					param_clause();
					}
				}

				setState(1099);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(1098);
					table_partitioning_clauses();
					}
				}

				setState(1101);
				match(AS);
				setState(1102);
				query_expression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1104);
				match(CREATE);
				setState(1105);
				match(TABLE);
				setState(1107);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(1106);
					if_not_exists();
					}
				}

				setState(1109);
				table_name();
				setState(1110);
				match(LIKE);
				setState(1111);
				((Create_table_statementContext)_localctx).like_table_name = table_name();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1113);
				match(CREATE);
				setState(1114);
				match(TABLE);
				setState(1116);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(1115);
					if_not_exists();
					}
				}

				setState(1118);
				table_name();
				setState(1119);
				match(AS);
				setState(1120);
				insert_statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Create_project_statementContext extends ParserRuleContext {
		public Token code;
		public Token name;
		public TerminalNode CREATE() { return getToken(SQLParser.CREATE, 0); }
		public TerminalNode PROJECT() { return getToken(SQLParser.PROJECT, 0); }
		public TerminalNode Regular_Identifier() { return getToken(SQLParser.Regular_Identifier, 0); }
		public If_not_existsContext if_not_exists() {
			return getRuleContext(If_not_existsContext.class,0);
		}
		public TerminalNode WITH_NAME() { return getToken(SQLParser.WITH_NAME, 0); }
		public TerminalNode Quoted_Identifier() { return getToken(SQLParser.Quoted_Identifier, 0); }
		public Create_project_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_project_statement; }
	}

	public final Create_project_statementContext create_project_statement() throws RecognitionException {
		Create_project_statementContext _localctx = new Create_project_statementContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_create_project_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1124);
			match(CREATE);
			setState(1125);
			match(PROJECT);
			setState(1127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(1126);
				if_not_exists();
				}
			}

			setState(1129);
			((Create_project_statementContext)_localctx).code = match(Regular_Identifier);
			setState(1132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WITH_NAME) {
				{
				setState(1130);
				match(WITH_NAME);
				setState(1131);
				((Create_project_statementContext)_localctx).name = match(Quoted_Identifier);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Drop_project_statementContext extends ParserRuleContext {
		public Token code;
		public TerminalNode DROP() { return getToken(SQLParser.DROP, 0); }
		public TerminalNode PROJECT() { return getToken(SQLParser.PROJECT, 0); }
		public TerminalNode Regular_Identifier() { return getToken(SQLParser.Regular_Identifier, 0); }
		public If_existsContext if_exists() {
			return getRuleContext(If_existsContext.class,0);
		}
		public TerminalNode CASCADE() { return getToken(SQLParser.CASCADE, 0); }
		public Drop_project_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop_project_statement; }
	}

	public final Drop_project_statementContext drop_project_statement() throws RecognitionException {
		Drop_project_statementContext _localctx = new Drop_project_statementContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_drop_project_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1134);
			match(DROP);
			setState(1135);
			match(PROJECT);
			setState(1137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(1136);
				if_exists();
				}
			}

			setState(1139);
			((Drop_project_statementContext)_localctx).code = match(Regular_Identifier);
			setState(1141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CASCADE) {
				{
				setState(1140);
				match(CASCADE);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Create_folder_statementContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(SQLParser.CREATE, 0); }
		public TerminalNode FOLDER() { return getToken(SQLParser.FOLDER, 0); }
		public Folder_nameContext folder_name() {
			return getRuleContext(Folder_nameContext.class,0);
		}
		public If_not_existsContext if_not_exists() {
			return getRuleContext(If_not_existsContext.class,0);
		}
		public Create_folder_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_folder_statement; }
	}

	public final Create_folder_statementContext create_folder_statement() throws RecognitionException {
		Create_folder_statementContext _localctx = new Create_folder_statementContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_create_folder_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1143);
			match(CREATE);
			setState(1144);
			match(FOLDER);
			setState(1146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(1145);
				if_not_exists();
				}
			}

			setState(1148);
			folder_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Drop_folder_statementContext extends ParserRuleContext {
		public TerminalNode DROP() { return getToken(SQLParser.DROP, 0); }
		public TerminalNode FOLDER() { return getToken(SQLParser.FOLDER, 0); }
		public Folder_nameContext folder_name() {
			return getRuleContext(Folder_nameContext.class,0);
		}
		public If_existsContext if_exists() {
			return getRuleContext(If_existsContext.class,0);
		}
		public TerminalNode CASCADE() { return getToken(SQLParser.CASCADE, 0); }
		public Drop_folder_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop_folder_statement; }
	}

	public final Drop_folder_statementContext drop_folder_statement() throws RecognitionException {
		Drop_folder_statementContext _localctx = new Drop_folder_statementContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_drop_folder_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1150);
			match(DROP);
			setState(1151);
			match(FOLDER);
			setState(1153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(1152);
				if_exists();
				}
			}

			setState(1155);
			folder_name();
			setState(1157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CASCADE) {
				{
				setState(1156);
				match(CASCADE);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Create_model_statementContext extends ParserRuleContext {
		public Token code;
		public Token name;
		public Token schema;
		public IdentifierContext context;
		public TerminalNode CREATE() { return getToken(SQLParser.CREATE, 0); }
		public TerminalNode MODEL() { return getToken(SQLParser.MODEL, 0); }
		public TerminalNode LOGICAL_SCHEMA() { return getToken(SQLParser.LOGICAL_SCHEMA, 0); }
		public TerminalNode CONTEXT() { return getToken(SQLParser.CONTEXT, 0); }
		public TerminalNode Regular_Identifier() { return getToken(SQLParser.Regular_Identifier, 0); }
		public List<TerminalNode> Quoted_Identifier() { return getTokens(SQLParser.Quoted_Identifier); }
		public TerminalNode Quoted_Identifier(int i) {
			return getToken(SQLParser.Quoted_Identifier, i);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public If_not_existsContext if_not_exists() {
			return getRuleContext(If_not_existsContext.class,0);
		}
		public TerminalNode WITH_NAME() { return getToken(SQLParser.WITH_NAME, 0); }
		public Create_model_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_model_statement; }
	}

	public final Create_model_statementContext create_model_statement() throws RecognitionException {
		Create_model_statementContext _localctx = new Create_model_statementContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_create_model_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1159);
			match(CREATE);
			setState(1160);
			match(MODEL);
			setState(1162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(1161);
				if_not_exists();
				}
			}

			setState(1164);
			((Create_model_statementContext)_localctx).code = match(Regular_Identifier);
			setState(1167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WITH_NAME) {
				{
				setState(1165);
				match(WITH_NAME);
				setState(1166);
				((Create_model_statementContext)_localctx).name = match(Quoted_Identifier);
				}
			}

			setState(1169);
			match(LOGICAL_SCHEMA);
			setState(1170);
			((Create_model_statementContext)_localctx).schema = match(Quoted_Identifier);
			setState(1171);
			match(CONTEXT);
			setState(1172);
			((Create_model_statementContext)_localctx).context = identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Drop_model_statementContext extends ParserRuleContext {
		public Token code;
		public TerminalNode DROP() { return getToken(SQLParser.DROP, 0); }
		public TerminalNode MODEL() { return getToken(SQLParser.MODEL, 0); }
		public TerminalNode Regular_Identifier() { return getToken(SQLParser.Regular_Identifier, 0); }
		public If_existsContext if_exists() {
			return getRuleContext(If_existsContext.class,0);
		}
		public TerminalNode CASCADE() { return getToken(SQLParser.CASCADE, 0); }
		public Drop_model_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop_model_statement; }
	}

	public final Drop_model_statementContext drop_model_statement() throws RecognitionException {
		Drop_model_statementContext _localctx = new Drop_model_statementContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_drop_model_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1174);
			match(DROP);
			setState(1175);
			match(MODEL);
			setState(1177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(1176);
				if_exists();
				}
			}

			setState(1179);
			((Drop_model_statementContext)_localctx).code = match(Regular_Identifier);
			setState(1181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CASCADE) {
				{
				setState(1180);
				match(CASCADE);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Create_submodel_statementContext extends ParserRuleContext {
		public Token name;
		public TerminalNode CREATE() { return getToken(SQLParser.CREATE, 0); }
		public TerminalNode SUBMODEL() { return getToken(SQLParser.SUBMODEL, 0); }
		public If_not_existsContext if_not_exists() {
			return getRuleContext(If_not_existsContext.class,0);
		}
		public Folder_nameContext folder_name() {
			return getRuleContext(Folder_nameContext.class,0);
		}
		public TerminalNode WITH_NAME() { return getToken(SQLParser.WITH_NAME, 0); }
		public TerminalNode Quoted_Identifier() { return getToken(SQLParser.Quoted_Identifier, 0); }
		public Create_submodel_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_submodel_statement; }
	}

	public final Create_submodel_statementContext create_submodel_statement() throws RecognitionException {
		Create_submodel_statementContext _localctx = new Create_submodel_statementContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_create_submodel_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1183);
			match(CREATE);
			setState(1184);
			match(SUBMODEL);
			setState(1186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(1185);
				if_not_exists();
				}
			}

			setState(1189);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
			case 1:
				{
				setState(1188);
				folder_name();
				}
				break;
			}
			setState(1193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WITH_NAME) {
				{
				setState(1191);
				match(WITH_NAME);
				setState(1192);
				((Create_submodel_statementContext)_localctx).name = match(Quoted_Identifier);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Drop_submodel_statementContext extends ParserRuleContext {
		public TerminalNode DROP() { return getToken(SQLParser.DROP, 0); }
		public TerminalNode SUBMODEL() { return getToken(SQLParser.SUBMODEL, 0); }
		public Folder_nameContext folder_name() {
			return getRuleContext(Folder_nameContext.class,0);
		}
		public If_existsContext if_exists() {
			return getRuleContext(If_existsContext.class,0);
		}
		public TerminalNode CASCADE() { return getToken(SQLParser.CASCADE, 0); }
		public Drop_submodel_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop_submodel_statement; }
	}

	public final Drop_submodel_statementContext drop_submodel_statement() throws RecognitionException {
		Drop_submodel_statementContext _localctx = new Drop_submodel_statementContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_drop_submodel_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1195);
			match(DROP);
			setState(1196);
			match(SUBMODEL);
			setState(1198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(1197);
				if_exists();
				}
			}

			setState(1200);
			folder_name();
			setState(1202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CASCADE) {
				{
				setState(1201);
				match(CASCADE);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Mapping_statements_blockContext extends ParserRuleContext {
		public TerminalNode BEGIN() { return getToken(SQLParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(SQLParser.END, 0); }
		public List<Insert_statementContext> insert_statement() {
			return getRuleContexts(Insert_statementContext.class);
		}
		public Insert_statementContext insert_statement(int i) {
			return getRuleContext(Insert_statementContext.class,i);
		}
		public List<Multi_insert_statementContext> multi_insert_statement() {
			return getRuleContexts(Multi_insert_statementContext.class);
		}
		public Multi_insert_statementContext multi_insert_statement(int i) {
			return getRuleContext(Multi_insert_statementContext.class,i);
		}
		public Mapping_statements_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapping_statements_block; }
	}

	public final Mapping_statements_blockContext mapping_statements_block() throws RecognitionException {
		Mapping_statements_blockContext _localctx = new Mapping_statements_blockContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_mapping_statements_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1204);
			match(BEGIN);
			setState(1207); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(1207);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,76,_ctx) ) {
				case 1:
					{
					setState(1205);
					insert_statement();
					}
					break;
				case 2:
					{
					setState(1206);
					multi_insert_statement();
					}
					break;
				}
				}
				setState(1209); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==INSERT || _la==AT_SIGN );
			setState(1211);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Create_simple_mappingContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(SQLParser.CREATE, 0); }
		public TerminalNode MAPPING() { return getToken(SQLParser.MAPPING, 0); }
		public Mapping_nameContext mapping_name() {
			return getRuleContext(Mapping_nameContext.class,0);
		}
		public TerminalNode AS() { return getToken(SQLParser.AS, 0); }
		public Insert_statementContext insert_statement() {
			return getRuleContext(Insert_statementContext.class,0);
		}
		public Multi_insert_statementContext multi_insert_statement() {
			return getRuleContext(Multi_insert_statementContext.class,0);
		}
		public Or_replaceContext or_replace() {
			return getRuleContext(Or_replaceContext.class,0);
		}
		public TerminalNode REUSABLE() { return getToken(SQLParser.REUSABLE, 0); }
		public If_not_existsContext if_not_exists() {
			return getRuleContext(If_not_existsContext.class,0);
		}
		public Param_clauseContext param_clause() {
			return getRuleContext(Param_clauseContext.class,0);
		}
		public Staging_locationContext staging_location() {
			return getRuleContext(Staging_locationContext.class,0);
		}
		public Phys_design_clauseContext phys_design_clause() {
			return getRuleContext(Phys_design_clauseContext.class,0);
		}
		public Create_simple_mappingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_simple_mapping; }
	}

	public final Create_simple_mappingContext create_simple_mapping() throws RecognitionException {
		Create_simple_mappingContext _localctx = new Create_simple_mappingContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_create_simple_mapping);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1213);
			match(CREATE);
			setState(1215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OR_REPLACE) {
				{
				setState(1214);
				or_replace();
				}
			}

			setState(1218);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==REUSABLE) {
				{
				setState(1217);
				match(REUSABLE);
				}
			}

			setState(1220);
			match(MAPPING);
			setState(1222);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(1221);
				if_not_exists();
				}
			}

			setState(1224);
			mapping_name();
			setState(1226);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LEFT_PAREN) {
				{
				setState(1225);
				param_clause();
				}
			}

			setState(1229);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STAGING) {
				{
				setState(1228);
				staging_location();
				}
			}

			setState(1232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PHYSICAL_DESIGN) {
				{
				setState(1231);
				phys_design_clause();
				}
			}

			setState(1234);
			match(AS);
			setState(1237);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,84,_ctx) ) {
			case 1:
				{
				setState(1235);
				insert_statement();
				}
				break;
			case 2:
				{
				setState(1236);
				multi_insert_statement();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Create_complex_mappingContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(SQLParser.CREATE, 0); }
		public TerminalNode MAPPING() { return getToken(SQLParser.MAPPING, 0); }
		public Mapping_nameContext mapping_name() {
			return getRuleContext(Mapping_nameContext.class,0);
		}
		public TerminalNode AS() { return getToken(SQLParser.AS, 0); }
		public Mapping_statements_blockContext mapping_statements_block() {
			return getRuleContext(Mapping_statements_blockContext.class,0);
		}
		public Or_replaceContext or_replace() {
			return getRuleContext(Or_replaceContext.class,0);
		}
		public If_not_existsContext if_not_exists() {
			return getRuleContext(If_not_existsContext.class,0);
		}
		public Param_clauseContext param_clause() {
			return getRuleContext(Param_clauseContext.class,0);
		}
		public Staging_locationContext staging_location() {
			return getRuleContext(Staging_locationContext.class,0);
		}
		public Phys_design_clauseContext phys_design_clause() {
			return getRuleContext(Phys_design_clauseContext.class,0);
		}
		public Create_complex_mappingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_complex_mapping; }
	}

	public final Create_complex_mappingContext create_complex_mapping() throws RecognitionException {
		Create_complex_mappingContext _localctx = new Create_complex_mappingContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_create_complex_mapping);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1239);
			match(CREATE);
			setState(1241);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OR_REPLACE) {
				{
				setState(1240);
				or_replace();
				}
			}

			setState(1243);
			match(MAPPING);
			setState(1245);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(1244);
				if_not_exists();
				}
			}

			setState(1247);
			mapping_name();
			setState(1249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LEFT_PAREN) {
				{
				setState(1248);
				param_clause();
				}
			}

			setState(1252);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STAGING) {
				{
				setState(1251);
				staging_location();
				}
			}

			setState(1255);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PHYSICAL_DESIGN) {
				{
				setState(1254);
				phys_design_clause();
				}
			}

			setState(1257);
			match(AS);
			setState(1258);
			mapping_statements_block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Create_mapping_statementContext extends ParserRuleContext {
		public Create_simple_mappingContext create_simple_mapping() {
			return getRuleContext(Create_simple_mappingContext.class,0);
		}
		public Create_complex_mappingContext create_complex_mapping() {
			return getRuleContext(Create_complex_mappingContext.class,0);
		}
		public Create_mapping_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_mapping_statement; }
	}

	public final Create_mapping_statementContext create_mapping_statement() throws RecognitionException {
		Create_mapping_statementContext _localctx = new Create_mapping_statementContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_create_mapping_statement);
		try {
			setState(1262);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,90,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1260);
				create_simple_mapping();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1261);
				create_complex_mapping();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Create_package_statementContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(SQLParser.CREATE, 0); }
		public TerminalNode PACKAGE() { return getToken(SQLParser.PACKAGE, 0); }
		public Mapping_nameContext mapping_name() {
			return getRuleContext(Mapping_nameContext.class,0);
		}
		public TerminalNode AS() { return getToken(SQLParser.AS, 0); }
		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class,0);
		}
		public Or_replaceContext or_replace() {
			return getRuleContext(Or_replaceContext.class,0);
		}
		public If_not_existsContext if_not_exists() {
			return getRuleContext(If_not_existsContext.class,0);
		}
		public Create_package_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_package_statement; }
	}

	public final Create_package_statementContext create_package_statement() throws RecognitionException {
		Create_package_statementContext _localctx = new Create_package_statementContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_create_package_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1264);
			match(CREATE);
			setState(1266);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OR_REPLACE) {
				{
				setState(1265);
				or_replace();
				}
			}

			setState(1268);
			match(PACKAGE);
			setState(1270);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(1269);
				if_not_exists();
				}
			}

			setState(1272);
			mapping_name();
			setState(1273);
			match(AS);
			setState(1274);
			statement_block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Create_procedure_statementContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(SQLParser.CREATE, 0); }
		public TerminalNode PROCEDURE() { return getToken(SQLParser.PROCEDURE, 0); }
		public TerminalNode AS() { return getToken(SQLParser.AS, 0); }
		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class,0);
		}
		public Or_replaceContext or_replace() {
			return getRuleContext(Or_replaceContext.class,0);
		}
		public If_not_existsContext if_not_exists() {
			return getRuleContext(If_not_existsContext.class,0);
		}
		public Create_procedure_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_procedure_statement; }
	}

	public final Create_procedure_statementContext create_procedure_statement() throws RecognitionException {
		Create_procedure_statementContext _localctx = new Create_procedure_statementContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_create_procedure_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1276);
			match(CREATE);
			setState(1278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OR_REPLACE) {
				{
				setState(1277);
				or_replace();
				}
			}

			setState(1280);
			match(PROCEDURE);
			setState(1282);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(1281);
				if_not_exists();
				}
			}

			setState(1284);
			match(AS);
			setState(1285);
			statement_block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Scenario_nameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Scenario_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scenario_name; }
	}

	public final Scenario_nameContext scenario_name() throws RecognitionException {
		Scenario_nameContext _localctx = new Scenario_nameContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_scenario_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1287);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Scenario_versionContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Scenario_versionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scenario_version; }
	}

	public final Scenario_versionContext scenario_version() throws RecognitionException {
		Scenario_versionContext _localctx = new Scenario_versionContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_scenario_version);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1289);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Odi_object_typeContext extends ParserRuleContext {
		public TerminalNode PROJECT() { return getToken(SQLParser.PROJECT, 0); }
		public TerminalNode FOLDER() { return getToken(SQLParser.FOLDER, 0); }
		public TerminalNode MAPPING() { return getToken(SQLParser.MAPPING, 0); }
		public TerminalNode REUSABLE() { return getToken(SQLParser.REUSABLE, 0); }
		public TerminalNode PROCEDURE() { return getToken(SQLParser.PROCEDURE, 0); }
		public TerminalNode VARIABLE() { return getToken(SQLParser.VARIABLE, 0); }
		public TerminalNode SCENARIO() { return getToken(SQLParser.SCENARIO, 0); }
		public TerminalNode MODEL() { return getToken(SQLParser.MODEL, 0); }
		public TerminalNode DATASTORE() { return getToken(SQLParser.DATASTORE, 0); }
		public Odi_object_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_odi_object_type; }
	}

	public final Odi_object_typeContext odi_object_type() throws RecognitionException {
		Odi_object_typeContext _localctx = new Odi_object_typeContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_odi_object_type);
		try {
			setState(1301);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PROJECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1291);
				match(PROJECT);
				}
				break;
			case FOLDER:
				enterOuterAlt(_localctx, 2);
				{
				setState(1292);
				match(FOLDER);
				}
				break;
			case MAPPING:
				enterOuterAlt(_localctx, 3);
				{
				setState(1293);
				match(MAPPING);
				}
				break;
			case REUSABLE:
				enterOuterAlt(_localctx, 4);
				{
				setState(1294);
				match(REUSABLE);
				setState(1295);
				match(MAPPING);
				}
				break;
			case PROCEDURE:
				enterOuterAlt(_localctx, 5);
				{
				setState(1296);
				match(PROCEDURE);
				}
				break;
			case VARIABLE:
				enterOuterAlt(_localctx, 6);
				{
				setState(1297);
				match(VARIABLE);
				}
				break;
			case SCENARIO:
				enterOuterAlt(_localctx, 7);
				{
				setState(1298);
				match(SCENARIO);
				}
				break;
			case MODEL:
				enterOuterAlt(_localctx, 8);
				{
				setState(1299);
				match(MODEL);
				}
				break;
			case DATASTORE:
				enterOuterAlt(_localctx, 9);
				{
				setState(1300);
				match(DATASTORE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Odi_parent_object_typeContext extends ParserRuleContext {
		public TerminalNode PROJECT() { return getToken(SQLParser.PROJECT, 0); }
		public TerminalNode FOLDER() { return getToken(SQLParser.FOLDER, 0); }
		public TerminalNode MODEL() { return getToken(SQLParser.MODEL, 0); }
		public Odi_parent_object_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_odi_parent_object_type; }
	}

	public final Odi_parent_object_typeContext odi_parent_object_type() throws RecognitionException {
		Odi_parent_object_typeContext _localctx = new Odi_parent_object_typeContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_odi_parent_object_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1303);
			_la = _input.LA(1);
			if ( !(_la==PROJECT || _la==MODEL || _la==FOLDER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Scenario_source_typeContext extends ParserRuleContext {
		public TerminalNode MAPPING() { return getToken(SQLParser.MAPPING, 0); }
		public TerminalNode PACKAGE() { return getToken(SQLParser.PACKAGE, 0); }
		public TerminalNode PROCEDURE() { return getToken(SQLParser.PROCEDURE, 0); }
		public TerminalNode VARIABLE() { return getToken(SQLParser.VARIABLE, 0); }
		public Scenario_source_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scenario_source_type; }
	}

	public final Scenario_source_typeContext scenario_source_type() throws RecognitionException {
		Scenario_source_typeContext _localctx = new Scenario_source_typeContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_scenario_source_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1305);
			_la = _input.LA(1);
			if ( !(((((_la - 37)) & ~0x3f) == 0 && ((1L << (_la - 37)) & 536872449L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Scenario_variableContext extends ParserRuleContext {
		public Token value;
		public TerminalNode Odi_Variable() { return getToken(SQLParser.Odi_Variable, 0); }
		public TerminalNode DEFAULT() { return getToken(SQLParser.DEFAULT, 0); }
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public Scenario_variableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scenario_variable; }
	}

	public final Scenario_variableContext scenario_variable() throws RecognitionException {
		Scenario_variableContext _localctx = new Scenario_variableContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_scenario_variable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1307);
			match(Odi_Variable);
			setState(1310);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(1308);
				match(DEFAULT);
				setState(1309);
				((Scenario_variableContext)_localctx).value = match(Character_String_Literal);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Scenario_variablesContext extends ParserRuleContext {
		public TerminalNode WITH() { return getToken(SQLParser.WITH, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public List<Scenario_variableContext> scenario_variable() {
			return getRuleContexts(Scenario_variableContext.class);
		}
		public Scenario_variableContext scenario_variable(int i) {
			return getRuleContext(Scenario_variableContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Scenario_variablesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scenario_variables; }
	}

	public final Scenario_variablesContext scenario_variables() throws RecognitionException {
		Scenario_variablesContext _localctx = new Scenario_variablesContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_scenario_variables);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1312);
			match(WITH);
			setState(1313);
			match(LEFT_PAREN);
			setState(1314);
			scenario_variable();
			setState(1319);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1315);
				match(COMMA);
				setState(1316);
				scenario_variable();
				}
				}
				setState(1321);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1322);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Create_scenario_statementContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(SQLParser.CREATE, 0); }
		public TerminalNode SCENARIO() { return getToken(SQLParser.SCENARIO, 0); }
		public Scenario_nameContext scenario_name() {
			return getRuleContext(Scenario_nameContext.class,0);
		}
		public TerminalNode FOR() { return getToken(SQLParser.FOR, 0); }
		public Scenario_source_typeContext scenario_source_type() {
			return getRuleContext(Scenario_source_typeContext.class,0);
		}
		public Mapping_nameContext mapping_name() {
			return getRuleContext(Mapping_nameContext.class,0);
		}
		public Or_replaceContext or_replace() {
			return getRuleContext(Or_replaceContext.class,0);
		}
		public Scenario_versionContext scenario_version() {
			return getRuleContext(Scenario_versionContext.class,0);
		}
		public TerminalNode PHYSICAL_DESIGN() { return getToken(SQLParser.PHYSICAL_DESIGN, 0); }
		public Phys_design_nameContext phys_design_name() {
			return getRuleContext(Phys_design_nameContext.class,0);
		}
		public Scenario_variablesContext scenario_variables() {
			return getRuleContext(Scenario_variablesContext.class,0);
		}
		public Create_scenario_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_scenario_statement; }
	}

	public final Create_scenario_statementContext create_scenario_statement() throws RecognitionException {
		Create_scenario_statementContext _localctx = new Create_scenario_statementContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_create_scenario_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1324);
			match(CREATE);
			setState(1326);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OR_REPLACE) {
				{
				setState(1325);
				or_replace();
				}
			}

			setState(1328);
			match(SCENARIO);
			setState(1329);
			scenario_name();
			setState(1331);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 172764544106657952L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & -873698335226338561L) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & -18014398509482001L) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & 549688705023L) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & 72275295724540153L) != 0) || ((((_la - 335)) & ~0x3f) == 0 && ((1L << (_la - 335)) & 806350857L) != 0)) {
				{
				setState(1330);
				scenario_version();
				}
			}

			setState(1333);
			match(FOR);
			setState(1334);
			scenario_source_type();
			setState(1335);
			mapping_name();
			setState(1338);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PHYSICAL_DESIGN) {
				{
				setState(1336);
				match(PHYSICAL_DESIGN);
				setState(1337);
				phys_design_name();
				}
			}

			setState(1341);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(1340);
				scenario_variables();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Regenerate_scenario_statementContext extends ParserRuleContext {
		public TerminalNode REGENERATE() { return getToken(SQLParser.REGENERATE, 0); }
		public TerminalNode SCENARIO() { return getToken(SQLParser.SCENARIO, 0); }
		public Scenario_nameContext scenario_name() {
			return getRuleContext(Scenario_nameContext.class,0);
		}
		public Scenario_versionContext scenario_version() {
			return getRuleContext(Scenario_versionContext.class,0);
		}
		public If_existsContext if_exists() {
			return getRuleContext(If_existsContext.class,0);
		}
		public Regenerate_scenario_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regenerate_scenario_statement; }
	}

	public final Regenerate_scenario_statementContext regenerate_scenario_statement() throws RecognitionException {
		Regenerate_scenario_statementContext _localctx = new Regenerate_scenario_statementContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_regenerate_scenario_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1343);
			match(REGENERATE);
			setState(1345);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(1344);
				if_exists();
				}
			}

			setState(1347);
			match(SCENARIO);
			setState(1348);
			scenario_name();
			setState(1349);
			scenario_version();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Drop_scenario_statementContext extends ParserRuleContext {
		public TerminalNode DROP() { return getToken(SQLParser.DROP, 0); }
		public TerminalNode SCENARIO() { return getToken(SQLParser.SCENARIO, 0); }
		public Scenario_nameContext scenario_name() {
			return getRuleContext(Scenario_nameContext.class,0);
		}
		public Scenario_versionContext scenario_version() {
			return getRuleContext(Scenario_versionContext.class,0);
		}
		public If_existsContext if_exists() {
			return getRuleContext(If_existsContext.class,0);
		}
		public Drop_scenario_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop_scenario_statement; }
	}

	public final Drop_scenario_statementContext drop_scenario_statement() throws RecognitionException {
		Drop_scenario_statementContext _localctx = new Drop_scenario_statementContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_drop_scenario_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1351);
			match(DROP);
			setState(1352);
			match(SCENARIO);
			setState(1354);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(1353);
				if_exists();
				}
			}

			setState(1356);
			scenario_name();
			setState(1357);
			scenario_version();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Export_scenario_statementContext extends ParserRuleContext {
		public Token path;
		public TerminalNode EXPORT() { return getToken(SQLParser.EXPORT, 0); }
		public TerminalNode SCENARIO() { return getToken(SQLParser.SCENARIO, 0); }
		public Scenario_nameContext scenario_name() {
			return getRuleContext(Scenario_nameContext.class,0);
		}
		public Scenario_versionContext scenario_version() {
			return getRuleContext(Scenario_versionContext.class,0);
		}
		public TerminalNode TO() { return getToken(SQLParser.TO, 0); }
		public TerminalNode Quoted_Identifier() { return getToken(SQLParser.Quoted_Identifier, 0); }
		public If_existsContext if_exists() {
			return getRuleContext(If_existsContext.class,0);
		}
		public Export_scenario_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_export_scenario_statement; }
	}

	public final Export_scenario_statementContext export_scenario_statement() throws RecognitionException {
		Export_scenario_statementContext _localctx = new Export_scenario_statementContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_export_scenario_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1359);
			match(EXPORT);
			setState(1360);
			match(SCENARIO);
			setState(1362);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(1361);
				if_exists();
				}
			}

			setState(1364);
			scenario_name();
			setState(1365);
			scenario_version();
			setState(1366);
			match(TO);
			setState(1367);
			((Export_scenario_statementContext)_localctx).path = match(Quoted_Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Export_mapping_statementContext extends ParserRuleContext {
		public Token path;
		public TerminalNode EXPORT() { return getToken(SQLParser.EXPORT, 0); }
		public TerminalNode MAPPING() { return getToken(SQLParser.MAPPING, 0); }
		public Mapping_nameContext mapping_name() {
			return getRuleContext(Mapping_nameContext.class,0);
		}
		public TerminalNode TO() { return getToken(SQLParser.TO, 0); }
		public TerminalNode Quoted_Identifier() { return getToken(SQLParser.Quoted_Identifier, 0); }
		public If_existsContext if_exists() {
			return getRuleContext(If_existsContext.class,0);
		}
		public TerminalNode AS() { return getToken(SQLParser.AS, 0); }
		public TerminalNode TEXT() { return getToken(SQLParser.TEXT, 0); }
		public Export_mapping_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_export_mapping_statement; }
	}

	public final Export_mapping_statementContext export_mapping_statement() throws RecognitionException {
		Export_mapping_statementContext _localctx = new Export_mapping_statementContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_export_mapping_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1369);
			match(EXPORT);
			setState(1370);
			match(MAPPING);
			setState(1372);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(1371);
				if_exists();
				}
			}

			setState(1374);
			mapping_name();
			setState(1375);
			match(TO);
			setState(1376);
			((Export_mapping_statementContext)_localctx).path = match(Quoted_Identifier);
			setState(1379);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(1377);
				match(AS);
				setState(1378);
				match(TEXT);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Odi_object_nameContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(SQLParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(SQLParser.DOT, i);
		}
		public Odi_object_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_odi_object_name; }
	}

	public final Odi_object_nameContext odi_object_name() throws RecognitionException {
		Odi_object_nameContext _localctx = new Odi_object_nameContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_odi_object_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1381);
			identifier();
			setState(1386);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(1382);
				match(DOT);
				setState(1383);
				identifier();
				}
				}
				setState(1388);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Import_objectContext extends ParserRuleContext {
		public Odi_object_nameContext odi_object_name() {
			return getRuleContext(Odi_object_nameContext.class,0);
		}
		public Scenario_versionContext scenario_version() {
			return getRuleContext(Scenario_versionContext.class,0);
		}
		public Import_objectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_object; }
	}

	public final Import_objectContext import_object() throws RecognitionException {
		Import_objectContext _localctx = new Import_objectContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_import_object);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1389);
			odi_object_name();
			setState(1391);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 172764544106657952L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & -873698335226338561L) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & -18014398509482001L) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & 549688705023L) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & 72275295724540153L) != 0) || ((((_la - 335)) & ~0x3f) == 0 && ((1L << (_la - 335)) & 806350857L) != 0)) {
				{
				setState(1390);
				scenario_version();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Import_parent_objectContext extends ParserRuleContext {
		public Odi_parent_object_typeContext odi_parent_object_type() {
			return getRuleContext(Odi_parent_object_typeContext.class,0);
		}
		public Odi_object_nameContext odi_object_name() {
			return getRuleContext(Odi_object_nameContext.class,0);
		}
		public Import_parent_objectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_parent_object; }
	}

	public final Import_parent_objectContext import_parent_object() throws RecognitionException {
		Import_parent_objectContext _localctx = new Import_parent_objectContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_import_parent_object);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1393);
			odi_parent_object_type();
			setState(1394);
			odi_object_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Import_modeContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(SQLParser.TYPE, 0); }
		public TerminalNode Quoted_Identifier() { return getToken(SQLParser.Quoted_Identifier, 0); }
		public Import_modeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_mode; }
	}

	public final Import_modeContext import_mode() throws RecognitionException {
		Import_modeContext _localctx = new Import_modeContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_import_mode);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1396);
			match(TYPE);
			setState(1397);
			match(Quoted_Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Import_scenario_statementContext extends ParserRuleContext {
		public Token path;
		public TerminalNode IMPORT() { return getToken(SQLParser.IMPORT, 0); }
		public TerminalNode FROM() { return getToken(SQLParser.FROM, 0); }
		public Import_modeContext import_mode() {
			return getRuleContext(Import_modeContext.class,0);
		}
		public TerminalNode Quoted_Identifier() { return getToken(SQLParser.Quoted_Identifier, 0); }
		public Odi_object_typeContext odi_object_type() {
			return getRuleContext(Odi_object_typeContext.class,0);
		}
		public Import_objectContext import_object() {
			return getRuleContext(Import_objectContext.class,0);
		}
		public TerminalNode INTO() { return getToken(SQLParser.INTO, 0); }
		public Import_parent_objectContext import_parent_object() {
			return getRuleContext(Import_parent_objectContext.class,0);
		}
		public If_not_existsContext if_not_exists() {
			return getRuleContext(If_not_existsContext.class,0);
		}
		public Import_scenario_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_scenario_statement; }
	}

	public final Import_scenario_statementContext import_scenario_statement() throws RecognitionException {
		Import_scenario_statementContext _localctx = new Import_scenario_statementContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_import_scenario_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1399);
			match(IMPORT);
			setState(1406);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 37)) & ~0x3f) == 0 && ((1L << (_la - 37)) & 537013249L) != 0) || ((((_la - 266)) & ~0x3f) == 0 && ((1L << (_la - 266)) & 147457L) != 0)) {
				{
				setState(1400);
				odi_object_type();
				setState(1402);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(1401);
					if_not_exists();
					}
				}

				setState(1404);
				import_object();
				}
			}

			setState(1408);
			match(FROM);
			setState(1409);
			((Import_scenario_statementContext)_localctx).path = match(Quoted_Identifier);
			setState(1412);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INTO) {
				{
				setState(1410);
				match(INTO);
				setState(1411);
				import_parent_object();
				}
			}

			setState(1414);
			import_mode();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Table_elementsContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public List<Field_elementContext> field_element() {
			return getRuleContexts(Field_elementContext.class);
		}
		public Field_elementContext field_element(int i) {
			return getRuleContext(Field_elementContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Table_elementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_elements; }
	}

	public final Table_elementsContext table_elements() throws RecognitionException {
		Table_elementsContext _localctx = new Table_elementsContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_table_elements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1416);
			match(LEFT_PAREN);
			setState(1417);
			field_element();
			setState(1422);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1418);
				match(COMMA);
				setState(1419);
				field_element();
				}
				}
				setState(1424);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1425);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Field_elementContext extends ParserRuleContext {
		public IdentifierContext name;
		public Field_typeContext field_type() {
			return getRuleContext(Field_typeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public Null_constraintContext null_constraint() {
			return getRuleContext(Null_constraintContext.class,0);
		}
		public PositionContext position() {
			return getRuleContext(PositionContext.class,0);
		}
		public OffsetContext offset() {
			return getRuleContext(OffsetContext.class,0);
		}
		public Field_phys_lengthContext field_phys_length() {
			return getRuleContext(Field_phys_lengthContext.class,0);
		}
		public Decimal_separatorContext decimal_separator() {
			return getRuleContext(Decimal_separatorContext.class,0);
		}
		public Field_formatContext field_format() {
			return getRuleContext(Field_formatContext.class,0);
		}
		public Field_scd_behaviorContext field_scd_behavior() {
			return getRuleContext(Field_scd_behaviorContext.class,0);
		}
		public Field_commentContext field_comment() {
			return getRuleContext(Field_commentContext.class,0);
		}
		public Datastore_constraintContext datastore_constraint() {
			return getRuleContext(Datastore_constraintContext.class,0);
		}
		public Index_inlineContext index_inline() {
			return getRuleContext(Index_inlineContext.class,0);
		}
		public Field_elementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_element; }
	}

	public final Field_elementContext field_element() throws RecognitionException {
		Field_elementContext _localctx = new Field_elementContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_field_element);
		int _la;
		try {
			setState(1461);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,122,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1430);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT_SIGN) {
					{
					{
					setState(1427);
					annotation();
					}
					}
					setState(1432);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1433);
				((Field_elementContext)_localctx).name = identifier();
				setState(1434);
				field_type();
				setState(1436);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT || _la==NULL) {
					{
					setState(1435);
					null_constraint();
					}
				}

				setState(1439);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==POSITION) {
					{
					setState(1438);
					position();
					}
				}

				setState(1442);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OFFSET) {
					{
					setState(1441);
					offset();
					}
				}

				setState(1445);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PHYS_LENGTH) {
					{
					setState(1444);
					field_phys_length();
					}
				}

				setState(1448);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DECIMAL_SEP) {
					{
					setState(1447);
					decimal_separator();
					}
				}

				setState(1451);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FORMAT) {
					{
					setState(1450);
					field_format();
					}
				}

				setState(1454);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SCD_BEHAVIOR) {
					{
					setState(1453);
					field_scd_behavior();
					}
				}

				setState(1457);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CMNT) {
					{
					setState(1456);
					field_comment();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1459);
				datastore_constraint();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1460);
				index_inline();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Index_inlineContext extends ParserRuleContext {
		public Token index_type;
		public IdentifierContext name;
		public TerminalNode INDEX() { return getToken(SQLParser.INDEX, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Column_name_listContext column_name_list() {
			return getRuleContext(Column_name_listContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public TerminalNode UNIQUE() { return getToken(SQLParser.UNIQUE, 0); }
		public Index_inlineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_index_inline; }
	}

	public final Index_inlineContext index_inline() throws RecognitionException {
		Index_inlineContext _localctx = new Index_inlineContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_index_inline);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1466);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT_SIGN) {
				{
				{
				setState(1463);
				annotation();
				}
				}
				setState(1468);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1469);
			match(INDEX);
			setState(1471);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==UNIQUE) {
				{
				setState(1470);
				((Index_inlineContext)_localctx).index_type = match(UNIQUE);
				}
			}

			setState(1473);
			((Index_inlineContext)_localctx).name = identifier();
			setState(1474);
			match(LEFT_PAREN);
			setState(1475);
			column_name_list();
			setState(1476);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Modify_field_elementContext extends ParserRuleContext {
		public IdentifierContext name;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Field_typeContext field_type() {
			return getRuleContext(Field_typeContext.class,0);
		}
		public Null_constraintContext null_constraint() {
			return getRuleContext(Null_constraintContext.class,0);
		}
		public PositionContext position() {
			return getRuleContext(PositionContext.class,0);
		}
		public OffsetContext offset() {
			return getRuleContext(OffsetContext.class,0);
		}
		public Field_phys_lengthContext field_phys_length() {
			return getRuleContext(Field_phys_lengthContext.class,0);
		}
		public Decimal_separatorContext decimal_separator() {
			return getRuleContext(Decimal_separatorContext.class,0);
		}
		public Field_formatContext field_format() {
			return getRuleContext(Field_formatContext.class,0);
		}
		public Field_scd_behaviorContext field_scd_behavior() {
			return getRuleContext(Field_scd_behaviorContext.class,0);
		}
		public Field_commentContext field_comment() {
			return getRuleContext(Field_commentContext.class,0);
		}
		public Modify_field_elementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modify_field_element; }
	}

	public final Modify_field_elementContext modify_field_element() throws RecognitionException {
		Modify_field_elementContext _localctx = new Modify_field_elementContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_modify_field_element);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1478);
			((Modify_field_elementContext)_localctx).name = identifier();
			setState(1480);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & 576460752303460097L) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & 549755813887L) != 0) || ((((_la - 342)) & ~0x3f) == 0 && ((1L << (_la - 342)) & 6291463L) != 0)) {
				{
				setState(1479);
				field_type();
				}
			}

			setState(1483);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT || _la==NULL) {
				{
				setState(1482);
				null_constraint();
				}
			}

			setState(1486);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==POSITION) {
				{
				setState(1485);
				position();
				}
			}

			setState(1489);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OFFSET) {
				{
				setState(1488);
				offset();
				}
			}

			setState(1492);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PHYS_LENGTH) {
				{
				setState(1491);
				field_phys_length();
				}
			}

			setState(1495);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DECIMAL_SEP) {
				{
				setState(1494);
				decimal_separator();
				}
			}

			setState(1498);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FORMAT) {
				{
				setState(1497);
				field_format();
				}
			}

			setState(1501);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SCD_BEHAVIOR) {
				{
				setState(1500);
				field_scd_behavior();
				}
			}

			setState(1504);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CMNT) {
				{
				setState(1503);
				field_comment();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Field_typeContext extends ParserRuleContext {
		public Data_typeContext data_type() {
			return getRuleContext(Data_typeContext.class,0);
		}
		public Field_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_type; }
	}

	public final Field_typeContext field_type() throws RecognitionException {
		Field_typeContext _localctx = new Field_typeContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_field_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1506);
			data_type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Null_constraintContext extends ParserRuleContext {
		public TerminalNode NULL() { return getToken(SQLParser.NULL, 0); }
		public TerminalNode NOT() { return getToken(SQLParser.NOT, 0); }
		public Null_constraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_null_constraint; }
	}

	public final Null_constraintContext null_constraint() throws RecognitionException {
		Null_constraintContext _localctx = new Null_constraintContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_null_constraint);
		try {
			setState(1511);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NULL:
				enterOuterAlt(_localctx, 1);
				{
				setState(1508);
				match(NULL);
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1509);
				match(NOT);
				setState(1510);
				match(NULL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PositionContext extends ParserRuleContext {
		public TerminalNode POSITION() { return getToken(SQLParser.POSITION, 0); }
		public TerminalNode NUMBER() { return getToken(SQLParser.NUMBER, 0); }
		public PositionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_position; }
	}

	public final PositionContext position() throws RecognitionException {
		PositionContext _localctx = new PositionContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_position);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1513);
			match(POSITION);
			setState(1514);
			match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OffsetContext extends ParserRuleContext {
		public TerminalNode OFFSET() { return getToken(SQLParser.OFFSET, 0); }
		public TerminalNode NUMBER() { return getToken(SQLParser.NUMBER, 0); }
		public OffsetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_offset; }
	}

	public final OffsetContext offset() throws RecognitionException {
		OffsetContext _localctx = new OffsetContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_offset);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1516);
			match(OFFSET);
			setState(1517);
			match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Field_phys_lengthContext extends ParserRuleContext {
		public TerminalNode PHYS_LENGTH() { return getToken(SQLParser.PHYS_LENGTH, 0); }
		public TerminalNode NUMBER() { return getToken(SQLParser.NUMBER, 0); }
		public Field_phys_lengthContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_phys_length; }
	}

	public final Field_phys_lengthContext field_phys_length() throws RecognitionException {
		Field_phys_lengthContext _localctx = new Field_phys_lengthContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_field_phys_length);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1519);
			match(PHYS_LENGTH);
			setState(1520);
			match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Field_formatContext extends ParserRuleContext {
		public TerminalNode FORMAT() { return getToken(SQLParser.FORMAT, 0); }
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public Field_formatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_format; }
	}

	public final Field_formatContext field_format() throws RecognitionException {
		Field_formatContext _localctx = new Field_formatContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_field_format);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1522);
			match(FORMAT);
			setState(1523);
			match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Field_scd_behaviorContext extends ParserRuleContext {
		public TerminalNode SCD_BEHAVIOR() { return getToken(SQLParser.SCD_BEHAVIOR, 0); }
		public Field_scd_behaviorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_scd_behavior; }
	}

	public final Field_scd_behaviorContext field_scd_behavior() throws RecognitionException {
		Field_scd_behaviorContext _localctx = new Field_scd_behaviorContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_field_scd_behavior);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1525);
			match(SCD_BEHAVIOR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Field_commentContext extends ParserRuleContext {
		public Token comm;
		public TerminalNode CMNT() { return getToken(SQLParser.CMNT, 0); }
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public Field_commentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_comment; }
	}

	public final Field_commentContext field_comment() throws RecognitionException {
		Field_commentContext _localctx = new Field_commentContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_field_comment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1527);
			match(CMNT);
			setState(1528);
			((Field_commentContext)_localctx).comm = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Param_clauseContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Param_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_clause; }
	}

	public final Param_clauseContext param_clause() throws RecognitionException {
		Param_clauseContext _localctx = new Param_clauseContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_param_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1530);
			match(LEFT_PAREN);
			setState(1531);
			param();
			setState(1536);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1532);
				match(COMMA);
				setState(1533);
				param();
				}
				}
				setState(1538);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1539);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamContext extends ParserRuleContext {
		public Token key;
		public Numeric_value_expressionContext value;
		public TerminalNode EQUAL() { return getToken(SQLParser.EQUAL, 0); }
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public Numeric_value_expressionContext numeric_value_expression() {
			return getRuleContext(Numeric_value_expressionContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1541);
			((ParamContext)_localctx).key = match(Character_String_Literal);
			setState(1542);
			match(EQUAL);
			setState(1543);
			((ParamContext)_localctx).value = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Km_paramContext extends ParserRuleContext {
		public Token key;
		public General_literalContext value;
		public TerminalNode EQUAL() { return getToken(SQLParser.EQUAL, 0); }
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public General_literalContext general_literal() {
			return getRuleContext(General_literalContext.class,0);
		}
		public Km_paramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_km_param; }
	}

	public final Km_paramContext km_param() throws RecognitionException {
		Km_paramContext _localctx = new Km_paramContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_km_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1545);
			((Km_paramContext)_localctx).key = match(Character_String_Literal);
			setState(1546);
			match(EQUAL);
			setState(1547);
			((Km_paramContext)_localctx).value = general_literal();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Km_nameContext extends ParserRuleContext {
		public TerminalNode Quoted_Identifier() { return getToken(SQLParser.Quoted_Identifier, 0); }
		public Km_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_km_name; }
	}

	public final Km_nameContext km_name() throws RecognitionException {
		Km_nameContext _localctx = new Km_nameContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_km_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1549);
			match(Quoted_Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Km_technologyContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(SQLParser.FOR, 0); }
		public TerminalNode TECHNOLOGY() { return getToken(SQLParser.TECHNOLOGY, 0); }
		public TerminalNode Quoted_Identifier() { return getToken(SQLParser.Quoted_Identifier, 0); }
		public Km_technologyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_km_technology; }
	}

	public final Km_technologyContext km_technology() throws RecognitionException {
		Km_technologyContext _localctx = new Km_technologyContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_km_technology);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1551);
			match(FOR);
			setState(1552);
			match(TECHNOLOGY);
			setState(1553);
			match(Quoted_Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Km_target_itemContext extends ParserRuleContext {
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode Regular_Identifier() { return getToken(SQLParser.Regular_Identifier, 0); }
		public Km_target_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_km_target_item; }
	}

	public final Km_target_itemContext km_target_item() throws RecognitionException {
		Km_target_itemContext _localctx = new Km_target_itemContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_km_target_item);
		try {
			setState(1557);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,136,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1555);
				table_name();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1556);
				match(Regular_Identifier);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Km_target_listContext extends ParserRuleContext {
		public List<Km_target_itemContext> km_target_item() {
			return getRuleContexts(Km_target_itemContext.class);
		}
		public Km_target_itemContext km_target_item(int i) {
			return getRuleContext(Km_target_itemContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Km_target_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_km_target_list; }
	}

	public final Km_target_listContext km_target_list() throws RecognitionException {
		Km_target_listContext _localctx = new Km_target_listContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_km_target_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1559);
			km_target_item();
			setState(1564);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1560);
				match(COMMA);
				setState(1561);
				km_target_item();
				}
				}
				setState(1566);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Ikm_targetContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(SQLParser.FOR, 0); }
		public TerminalNode TABLE() { return getToken(SQLParser.TABLE, 0); }
		public List<Table_nameContext> table_name() {
			return getRuleContexts(Table_nameContext.class);
		}
		public Table_nameContext table_name(int i) {
			return getRuleContext(Table_nameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Ikm_targetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ikm_target; }
	}

	public final Ikm_targetContext ikm_target() throws RecognitionException {
		Ikm_targetContext _localctx = new Ikm_targetContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_ikm_target);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1567);
			match(FOR);
			setState(1568);
			match(TABLE);
			setState(1569);
			table_name();
			setState(1574);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1570);
				match(COMMA);
				setState(1571);
				table_name();
				}
				}
				setState(1576);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Km_targetContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(SQLParser.FOR, 0); }
		public TerminalNode TABLE() { return getToken(SQLParser.TABLE, 0); }
		public Km_target_listContext km_target_list() {
			return getRuleContext(Km_target_listContext.class,0);
		}
		public Km_targetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_km_target; }
	}

	public final Km_targetContext km_target() throws RecognitionException {
		Km_targetContext _localctx = new Km_targetContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_km_target);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1577);
			match(FOR);
			setState(1578);
			match(TABLE);
			setState(1579);
			km_target_list();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Km_paramsContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public List<Km_paramContext> km_param() {
			return getRuleContexts(Km_paramContext.class);
		}
		public Km_paramContext km_param(int i) {
			return getRuleContext(Km_paramContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Km_paramsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_km_params; }
	}

	public final Km_paramsContext km_params() throws RecognitionException {
		Km_paramsContext _localctx = new Km_paramsContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_km_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1581);
			match(LEFT_PAREN);
			setState(1582);
			km_param();
			setState(1587);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1583);
				match(COMMA);
				setState(1584);
				km_param();
				}
				}
				setState(1589);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1590);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Lkm_clauseContext extends ParserRuleContext {
		public TerminalNode LKM() { return getToken(SQLParser.LKM, 0); }
		public Km_nameContext km_name() {
			return getRuleContext(Km_nameContext.class,0);
		}
		public Km_technologyContext km_technology() {
			return getRuleContext(Km_technologyContext.class,0);
		}
		public Km_paramsContext km_params() {
			return getRuleContext(Km_paramsContext.class,0);
		}
		public Lkm_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lkm_clause; }
	}

	public final Lkm_clauseContext lkm_clause() throws RecognitionException {
		Lkm_clauseContext _localctx = new Lkm_clauseContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_lkm_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1592);
			match(LKM);
			setState(1593);
			km_name();
			setState(1595);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FOR) {
				{
				setState(1594);
				km_technology();
				}
			}

			setState(1598);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LEFT_PAREN) {
				{
				setState(1597);
				km_params();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Xkm_clauseContext extends ParserRuleContext {
		public TerminalNode XKM() { return getToken(SQLParser.XKM, 0); }
		public Km_nameContext km_name() {
			return getRuleContext(Km_nameContext.class,0);
		}
		public Km_technologyContext km_technology() {
			return getRuleContext(Km_technologyContext.class,0);
		}
		public Km_targetContext km_target() {
			return getRuleContext(Km_targetContext.class,0);
		}
		public Km_paramsContext km_params() {
			return getRuleContext(Km_paramsContext.class,0);
		}
		public Xkm_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xkm_clause; }
	}

	public final Xkm_clauseContext xkm_clause() throws RecognitionException {
		Xkm_clauseContext _localctx = new Xkm_clauseContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_xkm_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1600);
			match(XKM);
			setState(1601);
			km_name();
			setState(1604);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,142,_ctx) ) {
			case 1:
				{
				setState(1602);
				km_technology();
				}
				break;
			case 2:
				{
				setState(1603);
				km_target();
				}
				break;
			}
			setState(1607);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LEFT_PAREN) {
				{
				setState(1606);
				km_params();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Ikm_clauseContext extends ParserRuleContext {
		public TerminalNode IKM() { return getToken(SQLParser.IKM, 0); }
		public Km_nameContext km_name() {
			return getRuleContext(Km_nameContext.class,0);
		}
		public Km_technologyContext km_technology() {
			return getRuleContext(Km_technologyContext.class,0);
		}
		public Km_targetContext km_target() {
			return getRuleContext(Km_targetContext.class,0);
		}
		public Km_paramsContext km_params() {
			return getRuleContext(Km_paramsContext.class,0);
		}
		public Ikm_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ikm_clause; }
	}

	public final Ikm_clauseContext ikm_clause() throws RecognitionException {
		Ikm_clauseContext _localctx = new Ikm_clauseContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_ikm_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1609);
			match(IKM);
			setState(1610);
			km_name();
			setState(1613);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,144,_ctx) ) {
			case 1:
				{
				setState(1611);
				km_technology();
				}
				break;
			case 2:
				{
				setState(1612);
				km_target();
				}
				break;
			}
			setState(1616);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LEFT_PAREN) {
				{
				setState(1615);
				km_params();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Ckm_clauseContext extends ParserRuleContext {
		public TerminalNode CKM() { return getToken(SQLParser.CKM, 0); }
		public Km_nameContext km_name() {
			return getRuleContext(Km_nameContext.class,0);
		}
		public Km_technologyContext km_technology() {
			return getRuleContext(Km_technologyContext.class,0);
		}
		public Km_paramsContext km_params() {
			return getRuleContext(Km_paramsContext.class,0);
		}
		public Ckm_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ckm_clause; }
	}

	public final Ckm_clauseContext ckm_clause() throws RecognitionException {
		Ckm_clauseContext _localctx = new Ckm_clauseContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_ckm_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1618);
			match(CKM);
			setState(1619);
			km_name();
			setState(1621);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FOR) {
				{
				setState(1620);
				km_technology();
				}
			}

			setState(1624);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LEFT_PAREN) {
				{
				setState(1623);
				km_params();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Km_listContext extends ParserRuleContext {
		public List<Lkm_clauseContext> lkm_clause() {
			return getRuleContexts(Lkm_clauseContext.class);
		}
		public Lkm_clauseContext lkm_clause(int i) {
			return getRuleContext(Lkm_clauseContext.class,i);
		}
		public List<Ikm_clauseContext> ikm_clause() {
			return getRuleContexts(Ikm_clauseContext.class);
		}
		public Ikm_clauseContext ikm_clause(int i) {
			return getRuleContext(Ikm_clauseContext.class,i);
		}
		public List<Ckm_clauseContext> ckm_clause() {
			return getRuleContexts(Ckm_clauseContext.class);
		}
		public Ckm_clauseContext ckm_clause(int i) {
			return getRuleContext(Ckm_clauseContext.class,i);
		}
		public List<Xkm_clauseContext> xkm_clause() {
			return getRuleContexts(Xkm_clauseContext.class);
		}
		public Xkm_clauseContext xkm_clause(int i) {
			return getRuleContext(Xkm_clauseContext.class,i);
		}
		public Km_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_km_list; }
	}

	public final Km_listContext km_list() throws RecognitionException {
		Km_listContext _localctx = new Km_listContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_km_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1630); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(1630);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LKM:
					{
					setState(1626);
					lkm_clause();
					}
					break;
				case IKM:
					{
					setState(1627);
					ikm_clause();
					}
					break;
				case CKM:
					{
					setState(1628);
					ckm_clause();
					}
					break;
				case XKM:
					{
					setState(1629);
					xkm_clause();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(1632); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 7L) != 0) || _la==XKM );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Phys_design_nameContext extends ParserRuleContext {
		public TerminalNode Quoted_Identifier() { return getToken(SQLParser.Quoted_Identifier, 0); }
		public Phys_design_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_phys_design_name; }
	}

	public final Phys_design_nameContext phys_design_name() throws RecognitionException {
		Phys_design_nameContext _localctx = new Phys_design_nameContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_phys_design_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1634);
			match(Quoted_Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Phys_design_descContext extends ParserRuleContext {
		public TerminalNode DESCRIPTION() { return getToken(SQLParser.DESCRIPTION, 0); }
		public TerminalNode Quoted_Identifier() { return getToken(SQLParser.Quoted_Identifier, 0); }
		public Phys_design_descContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_phys_design_desc; }
	}

	public final Phys_design_descContext phys_design_desc() throws RecognitionException {
		Phys_design_descContext _localctx = new Phys_design_descContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_phys_design_desc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1636);
			match(DESCRIPTION);
			setState(1637);
			match(Quoted_Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Optimization_contextContext extends ParserRuleContext {
		public TerminalNode OPTIMIZATION_CONTEXT() { return getToken(SQLParser.OPTIMIZATION_CONTEXT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Optimization_contextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optimization_context; }
	}

	public final Optimization_contextContext optimization_context() throws RecognitionException {
		Optimization_contextContext _localctx = new Optimization_contextContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_optimization_context);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1639);
			match(OPTIMIZATION_CONTEXT);
			setState(1640);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Staging_locationContext extends ParserRuleContext {
		public IdentifierContext name;
		public TerminalNode STAGING() { return getToken(SQLParser.STAGING, 0); }
		public TerminalNode LOCATION() { return getToken(SQLParser.LOCATION, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Staging_locationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_staging_location; }
	}

	public final Staging_locationContext staging_location() throws RecognitionException {
		Staging_locationContext _localctx = new Staging_locationContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_staging_location);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1642);
			match(STAGING);
			setState(1643);
			match(LOCATION);
			setState(1644);
			((Staging_locationContext)_localctx).name = identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Mapping_commandContext extends ParserRuleContext {
		public Token command;
		public Token technology;
		public Token location;
		public TerminalNode FreeCode() { return getToken(SQLParser.FreeCode, 0); }
		public TerminalNode TECHNOLOGY() { return getToken(SQLParser.TECHNOLOGY, 0); }
		public TerminalNode LOCATION() { return getToken(SQLParser.LOCATION, 0); }
		public List<TerminalNode> Quoted_Identifier() { return getTokens(SQLParser.Quoted_Identifier); }
		public TerminalNode Quoted_Identifier(int i) {
			return getToken(SQLParser.Quoted_Identifier, i);
		}
		public Mapping_commandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapping_command; }
	}

	public final Mapping_commandContext mapping_command() throws RecognitionException {
		Mapping_commandContext _localctx = new Mapping_commandContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_mapping_command);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1646);
			((Mapping_commandContext)_localctx).command = match(FreeCode);
			setState(1649);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TECHNOLOGY) {
				{
				setState(1647);
				match(TECHNOLOGY);
				setState(1648);
				((Mapping_commandContext)_localctx).technology = match(Quoted_Identifier);
				}
			}

			setState(1653);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LOCATION) {
				{
				setState(1651);
				match(LOCATION);
				setState(1652);
				((Mapping_commandContext)_localctx).location = match(Quoted_Identifier);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class On_begin_mapping_cmdContext extends ParserRuleContext {
		public TerminalNode ON() { return getToken(SQLParser.ON, 0); }
		public TerminalNode BEGIN() { return getToken(SQLParser.BEGIN, 0); }
		public TerminalNode MAPPING() { return getToken(SQLParser.MAPPING, 0); }
		public Mapping_commandContext mapping_command() {
			return getRuleContext(Mapping_commandContext.class,0);
		}
		public On_begin_mapping_cmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_on_begin_mapping_cmd; }
	}

	public final On_begin_mapping_cmdContext on_begin_mapping_cmd() throws RecognitionException {
		On_begin_mapping_cmdContext _localctx = new On_begin_mapping_cmdContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_on_begin_mapping_cmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1655);
			match(ON);
			setState(1656);
			match(BEGIN);
			setState(1657);
			match(MAPPING);
			setState(1658);
			mapping_command();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class On_end_mapping_cmdContext extends ParserRuleContext {
		public TerminalNode ON() { return getToken(SQLParser.ON, 0); }
		public TerminalNode END() { return getToken(SQLParser.END, 0); }
		public TerminalNode MAPPING() { return getToken(SQLParser.MAPPING, 0); }
		public Mapping_commandContext mapping_command() {
			return getRuleContext(Mapping_commandContext.class,0);
		}
		public On_end_mapping_cmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_on_end_mapping_cmd; }
	}

	public final On_end_mapping_cmdContext on_end_mapping_cmd() throws RecognitionException {
		On_end_mapping_cmdContext _localctx = new On_end_mapping_cmdContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_on_end_mapping_cmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1660);
			match(ON);
			setState(1661);
			match(END);
			setState(1662);
			match(MAPPING);
			setState(1663);
			mapping_command();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Phys_designContext extends ParserRuleContext {
		public TerminalNode PHYSICAL_DESIGN() { return getToken(SQLParser.PHYSICAL_DESIGN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public Phys_design_nameContext phys_design_name() {
			return getRuleContext(Phys_design_nameContext.class,0);
		}
		public Phys_design_descContext phys_design_desc() {
			return getRuleContext(Phys_design_descContext.class,0);
		}
		public Staging_locationContext staging_location() {
			return getRuleContext(Staging_locationContext.class,0);
		}
		public Optimization_contextContext optimization_context() {
			return getRuleContext(Optimization_contextContext.class,0);
		}
		public On_begin_mapping_cmdContext on_begin_mapping_cmd() {
			return getRuleContext(On_begin_mapping_cmdContext.class,0);
		}
		public On_end_mapping_cmdContext on_end_mapping_cmd() {
			return getRuleContext(On_end_mapping_cmdContext.class,0);
		}
		public TerminalNode REMOVE_TEMPORARY_OBJECTS_ON_ERROR() { return getToken(SQLParser.REMOVE_TEMPORARY_OBJECTS_ON_ERROR, 0); }
		public TerminalNode UNIQUE_TEMPORARY_OBJECT_NAMES() { return getToken(SQLParser.UNIQUE_TEMPORARY_OBJECT_NAMES, 0); }
		public Km_listContext km_list() {
			return getRuleContext(Km_listContext.class,0);
		}
		public Phys_designContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_phys_design; }
	}

	public final Phys_designContext phys_design() throws RecognitionException {
		Phys_designContext _localctx = new Phys_designContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_phys_design);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1665);
			match(PHYSICAL_DESIGN);
			setState(1667);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Quoted_Identifier) {
				{
				setState(1666);
				phys_design_name();
				}
			}

			setState(1669);
			match(LEFT_PAREN);
			setState(1671);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DESCRIPTION) {
				{
				setState(1670);
				phys_design_desc();
				}
			}

			setState(1674);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STAGING) {
				{
				setState(1673);
				staging_location();
				}
			}

			setState(1677);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPTIMIZATION_CONTEXT) {
				{
				setState(1676);
				optimization_context();
				}
			}

			setState(1680);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,156,_ctx) ) {
			case 1:
				{
				setState(1679);
				on_begin_mapping_cmd();
				}
				break;
			}
			setState(1683);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ON) {
				{
				setState(1682);
				on_end_mapping_cmd();
				}
			}

			setState(1686);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==REMOVE_TEMPORARY_OBJECTS_ON_ERROR) {
				{
				setState(1685);
				match(REMOVE_TEMPORARY_OBJECTS_ON_ERROR);
				}
			}

			setState(1689);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==UNIQUE_TEMPORARY_OBJECT_NAMES) {
				{
				setState(1688);
				match(UNIQUE_TEMPORARY_OBJECT_NAMES);
				}
			}

			setState(1692);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 7L) != 0) || _la==XKM) {
				{
				setState(1691);
				km_list();
				}
			}

			setState(1694);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Phys_design_clauseContext extends ParserRuleContext {
		public List<Phys_designContext> phys_design() {
			return getRuleContexts(Phys_designContext.class);
		}
		public Phys_designContext phys_design(int i) {
			return getRuleContext(Phys_designContext.class,i);
		}
		public Phys_design_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_phys_design_clause; }
	}

	public final Phys_design_clauseContext phys_design_clause() throws RecognitionException {
		Phys_design_clauseContext _localctx = new Phys_design_clauseContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_phys_design_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1697); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1696);
				phys_design();
				}
				}
				setState(1699); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==PHYSICAL_DESIGN );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Declare_odivar_statementContext extends ParserRuleContext {
		public TerminalNode DECLARE() { return getToken(SQLParser.DECLARE, 0); }
		public Odi_variableContext odi_variable() {
			return getRuleContext(Odi_variableContext.class,0);
		}
		public Declare_odivar_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declare_odivar_statement; }
	}

	public final Declare_odivar_statementContext declare_odivar_statement() throws RecognitionException {
		Declare_odivar_statementContext _localctx = new Declare_odivar_statementContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_declare_odivar_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1701);
			match(DECLARE);
			setState(1702);
			odi_variable();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Refresh_odivar_statementContext extends ParserRuleContext {
		public TerminalNode REFRESH() { return getToken(SQLParser.REFRESH, 0); }
		public Odi_variableContext odi_variable() {
			return getRuleContext(Odi_variableContext.class,0);
		}
		public Refresh_odivar_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_refresh_odivar_statement; }
	}

	public final Refresh_odivar_statementContext refresh_odivar_statement() throws RecognitionException {
		Refresh_odivar_statementContext _localctx = new Refresh_odivar_statementContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_refresh_odivar_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1704);
			match(REFRESH);
			setState(1705);
			odi_variable();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Set_odivar_statementContext extends ParserRuleContext {
		public TerminalNode SET() { return getToken(SQLParser.SET, 0); }
		public Odi_variableContext odi_variable() {
			return getRuleContext(Odi_variableContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(SQLParser.EQUAL, 0); }
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public Signed_numerical_literalContext signed_numerical_literal() {
			return getRuleContext(Signed_numerical_literalContext.class,0);
		}
		public Set_odivar_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set_odivar_statement; }
	}

	public final Set_odivar_statementContext set_odivar_statement() throws RecognitionException {
		Set_odivar_statementContext _localctx = new Set_odivar_statementContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_set_odivar_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1707);
			match(SET);
			setState(1708);
			odi_variable();
			setState(1709);
			match(EQUAL);
			setState(1712);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Character_String_Literal:
				{
				setState(1710);
				match(Character_String_Literal);
				}
				break;
			case PLUS:
			case MINUS:
			case NUMBER:
			case REAL_NUMBER:
				{
				setState(1711);
				signed_numerical_literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Procedure_optionsContext extends ParserRuleContext {
		public TerminalNode WITH() { return getToken(SQLParser.WITH, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public List<Km_paramContext> km_param() {
			return getRuleContexts(Km_paramContext.class);
		}
		public Km_paramContext km_param(int i) {
			return getRuleContext(Km_paramContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Procedure_optionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedure_options; }
	}

	public final Procedure_optionsContext procedure_options() throws RecognitionException {
		Procedure_optionsContext _localctx = new Procedure_optionsContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_procedure_options);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1714);
			match(WITH);
			setState(1715);
			match(LEFT_PAREN);
			setState(1716);
			km_param();
			setState(1721);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1717);
				match(COMMA);
				setState(1718);
				km_param();
				}
				}
				setState(1723);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1724);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Procedure_statementContext extends ParserRuleContext {
		public TerminalNode PROCEDURE() { return getToken(SQLParser.PROCEDURE, 0); }
		public Mapping_nameContext mapping_name() {
			return getRuleContext(Mapping_nameContext.class,0);
		}
		public Procedure_optionsContext procedure_options() {
			return getRuleContext(Procedure_optionsContext.class,0);
		}
		public Procedure_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedure_statement; }
	}

	public final Procedure_statementContext procedure_statement() throws RecognitionException {
		Procedure_statementContext _localctx = new Procedure_statementContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_procedure_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1726);
			match(PROCEDURE);
			setState(1727);
			mapping_name();
			setState(1729);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(1728);
				procedure_options();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Increment_odivar_statementContext extends ParserRuleContext {
		public List<Odi_variableContext> odi_variable() {
			return getRuleContexts(Odi_variableContext.class);
		}
		public Odi_variableContext odi_variable(int i) {
			return getRuleContext(Odi_variableContext.class,i);
		}
		public TerminalNode EQUAL() { return getToken(SQLParser.EQUAL, 0); }
		public Signed_numerical_literalContext signed_numerical_literal() {
			return getRuleContext(Signed_numerical_literalContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(SQLParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(SQLParser.MINUS, 0); }
		public Increment_odivar_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_increment_odivar_statement; }
	}

	public final Increment_odivar_statementContext increment_odivar_statement() throws RecognitionException {
		Increment_odivar_statementContext _localctx = new Increment_odivar_statementContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_increment_odivar_statement);
		int _la;
		try {
			setState(1742);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,165,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1731);
				odi_variable();
				setState(1732);
				match(EQUAL);
				setState(1733);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1734);
				signed_numerical_literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1736);
				odi_variable();
				setState(1737);
				match(EQUAL);
				setState(1738);
				odi_variable();
				setState(1739);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1740);
				signed_numerical_literal();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Mapping_statementContext extends ParserRuleContext {
		public TerminalNode MAPPING() { return getToken(SQLParser.MAPPING, 0); }
		public Mapping_nameContext mapping_name() {
			return getRuleContext(Mapping_nameContext.class,0);
		}
		public TerminalNode PHYSICAL_DESIGN() { return getToken(SQLParser.PHYSICAL_DESIGN, 0); }
		public Phys_design_nameContext phys_design_name() {
			return getRuleContext(Phys_design_nameContext.class,0);
		}
		public Mapping_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapping_statement; }
	}

	public final Mapping_statementContext mapping_statement() throws RecognitionException {
		Mapping_statementContext _localctx = new Mapping_statementContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_mapping_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1744);
			match(MAPPING);
			setState(1745);
			mapping_name();
			setState(1748);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PHYSICAL_DESIGN) {
				{
				setState(1746);
				match(PHYSICAL_DESIGN);
				setState(1747);
				phys_design_name();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Package_statementContext extends ParserRuleContext {
		public Declare_odivar_statementContext declare_odivar_statement() {
			return getRuleContext(Declare_odivar_statementContext.class,0);
		}
		public Refresh_odivar_statementContext refresh_odivar_statement() {
			return getRuleContext(Refresh_odivar_statementContext.class,0);
		}
		public Set_odivar_statementContext set_odivar_statement() {
			return getRuleContext(Set_odivar_statementContext.class,0);
		}
		public Increment_odivar_statementContext increment_odivar_statement() {
			return getRuleContext(Increment_odivar_statementContext.class,0);
		}
		public Mapping_statementContext mapping_statement() {
			return getRuleContext(Mapping_statementContext.class,0);
		}
		public Procedure_statementContext procedure_statement() {
			return getRuleContext(Procedure_statementContext.class,0);
		}
		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class,0);
		}
		public Package_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_package_statement; }
	}

	public final Package_statementContext package_statement() throws RecognitionException {
		Package_statementContext _localctx = new Package_statementContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_package_statement);
		try {
			setState(1757);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DECLARE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1750);
				declare_odivar_statement();
				}
				break;
			case REFRESH:
				enterOuterAlt(_localctx, 2);
				{
				setState(1751);
				refresh_odivar_statement();
				}
				break;
			case SET:
				enterOuterAlt(_localctx, 3);
				{
				setState(1752);
				set_odivar_statement();
				}
				break;
			case Odi_Variable:
				enterOuterAlt(_localctx, 4);
				{
				setState(1753);
				increment_odivar_statement();
				}
				break;
			case MAPPING:
				enterOuterAlt(_localctx, 5);
				{
				setState(1754);
				mapping_statement();
				}
				break;
			case PROCEDURE:
				enterOuterAlt(_localctx, 6);
				{
				setState(1755);
				procedure_statement();
				}
				break;
			case BEGIN:
				enterOuterAlt(_localctx, 7);
				{
				setState(1756);
				statement_block();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Success_clauseContext extends ParserRuleContext {
		public TerminalNode ON() { return getToken(SQLParser.ON, 0); }
		public TerminalNode SUCCESS() { return getToken(SQLParser.SUCCESS, 0); }
		public TerminalNode GOTO() { return getToken(SQLParser.GOTO, 0); }
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public TerminalNode EXIT() { return getToken(SQLParser.EXIT, 0); }
		public Success_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_success_clause; }
	}

	public final Success_clauseContext success_clause() throws RecognitionException {
		Success_clauseContext _localctx = new Success_clauseContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_success_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1759);
			match(ON);
			setState(1760);
			match(SUCCESS);
			setState(1764);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GOTO:
				{
				setState(1761);
				match(GOTO);
				setState(1762);
				label();
				}
				break;
			case EXIT:
				{
				setState(1763);
				match(EXIT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Error_clauseContext extends ParserRuleContext {
		public Token times;
		public Token wait_time;
		public TerminalNode ON() { return getToken(SQLParser.ON, 0); }
		public TerminalNode ERROR() { return getToken(SQLParser.ERROR, 0); }
		public TerminalNode RETRY() { return getToken(SQLParser.RETRY, 0); }
		public TerminalNode GOTO() { return getToken(SQLParser.GOTO, 0); }
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public TerminalNode CONTINUE() { return getToken(SQLParser.CONTINUE, 0); }
		public TerminalNode EXIT() { return getToken(SQLParser.EXIT, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(SQLParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(SQLParser.NUMBER, i);
		}
		public TerminalNode WAIT() { return getToken(SQLParser.WAIT, 0); }
		public Error_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_error_clause; }
	}

	public final Error_clauseContext error_clause() throws RecognitionException {
		Error_clauseContext _localctx = new Error_clauseContext(_ctx, getState());
		enterRule(_localctx, 210, RULE_error_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1766);
			match(ON);
			setState(1767);
			match(ERROR);
			setState(1774);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RETRY) {
				{
				setState(1768);
				match(RETRY);
				setState(1769);
				((Error_clauseContext)_localctx).times = match(NUMBER);
				setState(1772);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WAIT) {
					{
					setState(1770);
					match(WAIT);
					setState(1771);
					((Error_clauseContext)_localctx).wait_time = match(NUMBER);
					}
				}

				}
			}

			setState(1780);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GOTO:
				{
				setState(1776);
				match(GOTO);
				setState(1777);
				label();
				}
				break;
			case CONTINUE:
				{
				setState(1778);
				match(CONTINUE);
				}
				break;
			case EXIT:
				{
				setState(1779);
				match(EXIT);
				}
				break;
			case ASYMMETRIC:
			case BOTH:
			case CROSS:
			case CURRENT_DATE:
			case CURRENT_TIME:
			case CURRENT_TIMESTAMP:
			case DATASET:
			case END:
			case FULL:
			case GROUP:
			case LIMIT:
			case MAPPING:
			case NATURAL:
			case ON:
			case ORDER:
			case PACKAGE:
			case PROCEDURE:
			case PROJECT:
			case REUSABLE:
			case SYMMETRIC:
			case SCENARIO:
			case TRAILING:
			case WINDOW:
			case VARIABLE:
			case POSITION:
			case OFFSET:
			case IKM:
			case LKM:
			case CKM:
			case TECHNOLOGY:
			case DESCRIPTION:
			case AVG:
			case ADD:
			case ALTER:
			case BETWEEN:
			case BY:
			case CATALOG:
			case CENTURY:
			case CHARACTER:
			case COLLECT:
			case COALESCE:
			case COLUMN:
			case COUNT:
			case CUBE:
			case CUME_DIST:
			case CURRENT:
			case STRING:
			case DAY:
			case DEFAULT:
			case DATABASE:
			case DEC:
			case DECADE:
			case DENSE_RANK:
			case DOW:
			case DOY:
			case DROP:
			case EPOCH:
			case EVERY:
			case EXCLUDE:
			case EXISTS:
			case EXPLAIN:
			case EXTERNAL:
			case EXTRACT:
			case FILTER:
			case FIRST:
			case FIRST_VALUE:
			case FOLLOWING:
			case FORMAT:
			case FUSION:
			case GROUPING:
			case HASH:
			case INDEX:
			case INSERT:
			case INTERSECTION:
			case ISODOW:
			case ISOYEAR:
			case LAG:
			case LAST:
			case LAST_VALUE:
			case LESS:
			case LIST:
			case LOCATION:
			case MAX:
			case MAXVALUE:
			case MICROSECONDS:
			case MILLENNIUM:
			case MILLISECONDS:
			case MIN:
			case MINUTE:
			case MONTH:
			case NATIONAL:
			case NULLIF:
			case NO:
			case OVERWRITE:
			case OTHERS:
			case PARTITION:
			case PARTITIONS:
			case PERCENT_RANK:
			case PRECEDING:
			case PRECISION:
			case PURGE:
			case QUARTER:
			case RANGE:
			case RANK:
			case REGEXP:
			case RENAME:
			case RESET:
			case RLIKE:
			case ROLLUP:
			case ROW:
			case ROWS:
			case ROW_NUMBER:
			case SECOND:
			case SESSION:
			case SET:
			case SIMILAR:
			case STDDEV_POP:
			case STDDEV_SAMP:
			case SUBPARTITION:
			case SUM:
			case TABLESPACE:
			case THAN:
			case TIES:
			case TIMEZONE:
			case TIMEZONE_HOUR:
			case TIMEZONE_MINUTE:
			case TRIM:
			case TO:
			case UNBOUNDED:
			case UNKNOWN:
			case VALUES:
			case VAR_SAMP:
			case VAR_POP:
			case VARYING:
			case WEEK:
			case YEAR:
			case ZONE:
			case BOOLEAN:
			case BOOL:
			case BIT:
			case VARBIT:
			case INT1:
			case INT2:
			case INT4:
			case INT8:
			case TINYINT:
			case SMALLINT:
			case INT:
			case INTEGER:
			case BIGINT:
			case FLOAT4:
			case FLOAT8:
			case REAL:
			case FLOAT:
			case DOUBLE:
			case NUMERIC:
			case ORANUMBER:
			case DECIMAL:
			case CHAR:
			case VARCHAR2:
			case VARCHAR:
			case NCHAR:
			case NVARCHAR:
			case DATE:
			case INTERVAL:
			case TIME:
			case TIMETZ:
			case TIMESTAMP:
			case TIMESTAMPTZ:
			case TEXT:
			case BINARY:
			case VARBINARY:
			case BLOB:
			case BYTEA:
			case INET4:
			case REAL_NUMBER:
			case DATASTORE:
			case ALIAS:
			case RESOURCE:
			case FILE:
			case HEADING:
			case FIXED:
			case SCD:
			case MODEL:
			case FOLDER:
			case SUBMODEL:
			case REPLACE:
			case CONTEXT:
			case XKM:
			case SEQUENCEFILE:
			case FIELDS:
			case TERMINATED:
			case SERDE:
			case SERDEPROPERTIES:
			case TEXTFILE:
			case RCFILE:
			case ORC:
			case PARQUET:
			case AVRO:
			case INPUTFORMAT:
			case OUTPUTFORMAT:
			case TEMPORARY:
			case TBLPROPERTIES:
			case REJECT:
			case PERCENT:
			case SUCCESS:
			case DECLARE:
			case REFRESH:
			case BEGIN:
			case TYPE:
			case ODI:
			case CONTROL:
			case FLOW:
			case STATIC:
			case ACTIVE:
			case MESSAGE:
			case KEEP:
			case PIVOT:
			case UNPIVOT:
			case Odi_Variable:
			case Regular_Identifier:
			case Quoted_Identifier:
				break;
			default:
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LabelContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode COLON() { return getToken(SQLParser.COLON, 0); }
		public LabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label; }
	}

	public final LabelContext label() throws RecognitionException {
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 212, RULE_label);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1782);
			identifier();
			setState(1783);
			match(COLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Generic_package_statementContext extends ParserRuleContext {
		public Package_statementContext package_statement() {
			return getRuleContext(Package_statementContext.class,0);
		}
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public Success_clauseContext success_clause() {
			return getRuleContext(Success_clauseContext.class,0);
		}
		public Error_clauseContext error_clause() {
			return getRuleContext(Error_clauseContext.class,0);
		}
		public Generic_package_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generic_package_statement; }
	}

	public final Generic_package_statementContext generic_package_statement() throws RecognitionException {
		Generic_package_statementContext _localctx = new Generic_package_statementContext(_ctx, getState());
		enterRule(_localctx, 214, RULE_generic_package_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1786);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,172,_ctx) ) {
			case 1:
				{
				setState(1785);
				label();
				}
				break;
			}
			setState(1788);
			package_statement();
			setState(1790);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,173,_ctx) ) {
			case 1:
				{
				setState(1789);
				success_clause();
				}
				break;
			}
			setState(1793);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,174,_ctx) ) {
			case 1:
				{
				setState(1792);
				error_clause();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Statement_blockContext extends ParserRuleContext {
		public TerminalNode BEGIN() { return getToken(SQLParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(SQLParser.END, 0); }
		public List<Generic_package_statementContext> generic_package_statement() {
			return getRuleContexts(Generic_package_statementContext.class);
		}
		public Generic_package_statementContext generic_package_statement(int i) {
			return getRuleContext(Generic_package_statementContext.class,i);
		}
		public TerminalNode ON() { return getToken(SQLParser.ON, 0); }
		public TerminalNode ERROR() { return getToken(SQLParser.ERROR, 0); }
		public Statement_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement_block; }
	}

	public final Statement_blockContext statement_block() throws RecognitionException {
		Statement_blockContext _localctx = new Statement_blockContext(_ctx, getState());
		enterRule(_localctx, 216, RULE_statement_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1795);
			match(BEGIN);
			setState(1797); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1796);
				generic_package_statement();
				}
				}
				setState(1799); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 172764544106657952L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & -873698335226338561L) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & -18014398509482001L) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & 549688705023L) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & -7421714484219965191L) != 0) || ((((_la - 335)) & ~0x3f) == 0 && ((1L << (_la - 335)) & 810545161L) != 0) );
			setState(1808);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ON) {
				{
				setState(1801);
				match(ON);
				setState(1802);
				match(ERROR);
				setState(1804); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1803);
					generic_package_statement();
					}
					}
					setState(1806); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 172764544106657952L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & -873698335226338561L) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & -18014398509482001L) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & 549688705023L) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & -7421714484219965191L) != 0) || ((((_la - 335)) & ~0x3f) == 0 && ((1L << (_la - 335)) & 810545161L) != 0) );
				}
			}

			setState(1810);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Method_specifierContext extends ParserRuleContext {
		public IdentifierContext m;
		public TerminalNode USING() { return getToken(SQLParser.USING, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Method_specifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_specifier; }
	}

	public final Method_specifierContext method_specifier() throws RecognitionException {
		Method_specifierContext _localctx = new Method_specifierContext(_ctx, getState());
		enterRule(_localctx, 218, RULE_method_specifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1812);
			match(USING);
			setState(1813);
			((Method_specifierContext)_localctx).m = identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Table_space_specifierContext extends ParserRuleContext {
		public TerminalNode TABLESPACE() { return getToken(SQLParser.TABLESPACE, 0); }
		public Table_space_nameContext table_space_name() {
			return getRuleContext(Table_space_nameContext.class,0);
		}
		public Table_space_specifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_space_specifier; }
	}

	public final Table_space_specifierContext table_space_specifier() throws RecognitionException {
		Table_space_specifierContext _localctx = new Table_space_specifierContext(_ctx, getState());
		enterRule(_localctx, 220, RULE_table_space_specifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1815);
			match(TABLESPACE);
			setState(1816);
			table_space_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Table_space_nameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Table_space_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_space_name; }
	}

	public final Table_space_nameContext table_space_name() throws RecognitionException {
		Table_space_nameContext _localctx = new Table_space_nameContext(_ctx, getState());
		enterRule(_localctx, 222, RULE_table_space_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1818);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Table_partitioning_clausesContext extends ParserRuleContext {
		public Range_partitionsContext range_partitions() {
			return getRuleContext(Range_partitionsContext.class,0);
		}
		public Hash_partitionsContext hash_partitions() {
			return getRuleContext(Hash_partitionsContext.class,0);
		}
		public List_partitionsContext list_partitions() {
			return getRuleContext(List_partitionsContext.class,0);
		}
		public Column_partitionsContext column_partitions() {
			return getRuleContext(Column_partitionsContext.class,0);
		}
		public Table_partitioning_clausesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_partitioning_clauses; }
	}

	public final Table_partitioning_clausesContext table_partitioning_clauses() throws RecognitionException {
		Table_partitioning_clausesContext _localctx = new Table_partitioning_clausesContext(_ctx, getState());
		enterRule(_localctx, 224, RULE_table_partitioning_clauses);
		try {
			setState(1824);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,178,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1820);
				range_partitions();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1821);
				hash_partitions();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1822);
				list_partitions();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1823);
				column_partitions();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Range_partitionsContext extends ParserRuleContext {
		public TerminalNode PARTITION() { return getToken(SQLParser.PARTITION, 0); }
		public TerminalNode BY() { return getToken(SQLParser.BY, 0); }
		public TerminalNode RANGE() { return getToken(SQLParser.RANGE, 0); }
		public List<TerminalNode> LEFT_PAREN() { return getTokens(SQLParser.LEFT_PAREN); }
		public TerminalNode LEFT_PAREN(int i) {
			return getToken(SQLParser.LEFT_PAREN, i);
		}
		public Column_reference_listContext column_reference_list() {
			return getRuleContext(Column_reference_listContext.class,0);
		}
		public List<TerminalNode> RIGHT_PAREN() { return getTokens(SQLParser.RIGHT_PAREN); }
		public TerminalNode RIGHT_PAREN(int i) {
			return getToken(SQLParser.RIGHT_PAREN, i);
		}
		public Range_value_clause_listContext range_value_clause_list() {
			return getRuleContext(Range_value_clause_listContext.class,0);
		}
		public Range_partitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range_partitions; }
	}

	public final Range_partitionsContext range_partitions() throws RecognitionException {
		Range_partitionsContext _localctx = new Range_partitionsContext(_ctx, getState());
		enterRule(_localctx, 226, RULE_range_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1826);
			match(PARTITION);
			setState(1827);
			match(BY);
			setState(1828);
			match(RANGE);
			setState(1829);
			match(LEFT_PAREN);
			setState(1830);
			column_reference_list();
			setState(1831);
			match(RIGHT_PAREN);
			setState(1832);
			match(LEFT_PAREN);
			setState(1833);
			range_value_clause_list();
			setState(1834);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Range_value_clause_listContext extends ParserRuleContext {
		public List<Range_value_clauseContext> range_value_clause() {
			return getRuleContexts(Range_value_clauseContext.class);
		}
		public Range_value_clauseContext range_value_clause(int i) {
			return getRuleContext(Range_value_clauseContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Range_value_clause_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range_value_clause_list; }
	}

	public final Range_value_clause_listContext range_value_clause_list() throws RecognitionException {
		Range_value_clause_listContext _localctx = new Range_value_clause_listContext(_ctx, getState());
		enterRule(_localctx, 228, RULE_range_value_clause_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1836);
			range_value_clause();
			setState(1841);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1837);
				match(COMMA);
				setState(1838);
				range_value_clause();
				}
				}
				setState(1843);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Range_value_clauseContext extends ParserRuleContext {
		public TerminalNode PARTITION() { return getToken(SQLParser.PARTITION, 0); }
		public Partition_nameContext partition_name() {
			return getRuleContext(Partition_nameContext.class,0);
		}
		public TerminalNode VALUES() { return getToken(SQLParser.VALUES, 0); }
		public TerminalNode LESS() { return getToken(SQLParser.LESS, 0); }
		public TerminalNode THAN() { return getToken(SQLParser.THAN, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Value_expressionContext value_expression() {
			return getRuleContext(Value_expressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode MAXVALUE() { return getToken(SQLParser.MAXVALUE, 0); }
		public Range_value_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range_value_clause; }
	}

	public final Range_value_clauseContext range_value_clause() throws RecognitionException {
		Range_value_clauseContext _localctx = new Range_value_clauseContext(_ctx, getState());
		enterRule(_localctx, 230, RULE_range_value_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1844);
			match(PARTITION);
			setState(1845);
			partition_name();
			setState(1846);
			match(VALUES);
			setState(1847);
			match(LESS);
			setState(1848);
			match(THAN);
			setState(1860);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,182,_ctx) ) {
			case 1:
				{
				setState(1849);
				match(LEFT_PAREN);
				setState(1850);
				value_expression();
				setState(1851);
				match(RIGHT_PAREN);
				}
				break;
			case 2:
				{
				setState(1854);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(1853);
					match(LEFT_PAREN);
					}
				}

				setState(1856);
				match(MAXVALUE);
				setState(1858);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,181,_ctx) ) {
				case 1:
					{
					setState(1857);
					match(RIGHT_PAREN);
					}
					break;
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Hash_partitionsContext extends ParserRuleContext {
		public TerminalNode PARTITION() { return getToken(SQLParser.PARTITION, 0); }
		public TerminalNode BY() { return getToken(SQLParser.BY, 0); }
		public TerminalNode HASH() { return getToken(SQLParser.HASH, 0); }
		public List<TerminalNode> LEFT_PAREN() { return getTokens(SQLParser.LEFT_PAREN); }
		public TerminalNode LEFT_PAREN(int i) {
			return getToken(SQLParser.LEFT_PAREN, i);
		}
		public Column_reference_listContext column_reference_list() {
			return getRuleContext(Column_reference_listContext.class,0);
		}
		public List<TerminalNode> RIGHT_PAREN() { return getTokens(SQLParser.RIGHT_PAREN); }
		public TerminalNode RIGHT_PAREN(int i) {
			return getToken(SQLParser.RIGHT_PAREN, i);
		}
		public Individual_hash_partitionsContext individual_hash_partitions() {
			return getRuleContext(Individual_hash_partitionsContext.class,0);
		}
		public Hash_partitions_by_quantityContext hash_partitions_by_quantity() {
			return getRuleContext(Hash_partitions_by_quantityContext.class,0);
		}
		public Hash_partitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hash_partitions; }
	}

	public final Hash_partitionsContext hash_partitions() throws RecognitionException {
		Hash_partitionsContext _localctx = new Hash_partitionsContext(_ctx, getState());
		enterRule(_localctx, 232, RULE_hash_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1862);
			match(PARTITION);
			setState(1863);
			match(BY);
			setState(1864);
			match(HASH);
			setState(1865);
			match(LEFT_PAREN);
			setState(1866);
			column_reference_list();
			setState(1867);
			match(RIGHT_PAREN);
			setState(1873);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEFT_PAREN:
				{
				setState(1868);
				match(LEFT_PAREN);
				setState(1869);
				individual_hash_partitions();
				setState(1870);
				match(RIGHT_PAREN);
				}
				break;
			case PARTITIONS:
				{
				setState(1872);
				hash_partitions_by_quantity();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Individual_hash_partitionsContext extends ParserRuleContext {
		public List<Individual_hash_partitionContext> individual_hash_partition() {
			return getRuleContexts(Individual_hash_partitionContext.class);
		}
		public Individual_hash_partitionContext individual_hash_partition(int i) {
			return getRuleContext(Individual_hash_partitionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Individual_hash_partitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_individual_hash_partitions; }
	}

	public final Individual_hash_partitionsContext individual_hash_partitions() throws RecognitionException {
		Individual_hash_partitionsContext _localctx = new Individual_hash_partitionsContext(_ctx, getState());
		enterRule(_localctx, 234, RULE_individual_hash_partitions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1875);
			individual_hash_partition();
			setState(1880);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1876);
				match(COMMA);
				setState(1877);
				individual_hash_partition();
				}
				}
				setState(1882);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Individual_hash_partitionContext extends ParserRuleContext {
		public TerminalNode PARTITION() { return getToken(SQLParser.PARTITION, 0); }
		public Partition_nameContext partition_name() {
			return getRuleContext(Partition_nameContext.class,0);
		}
		public Individual_hash_partitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_individual_hash_partition; }
	}

	public final Individual_hash_partitionContext individual_hash_partition() throws RecognitionException {
		Individual_hash_partitionContext _localctx = new Individual_hash_partitionContext(_ctx, getState());
		enterRule(_localctx, 236, RULE_individual_hash_partition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1883);
			match(PARTITION);
			setState(1884);
			partition_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Hash_partitions_by_quantityContext extends ParserRuleContext {
		public Numeric_value_expressionContext quantity;
		public TerminalNode PARTITIONS() { return getToken(SQLParser.PARTITIONS, 0); }
		public Numeric_value_expressionContext numeric_value_expression() {
			return getRuleContext(Numeric_value_expressionContext.class,0);
		}
		public Hash_partitions_by_quantityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hash_partitions_by_quantity; }
	}

	public final Hash_partitions_by_quantityContext hash_partitions_by_quantity() throws RecognitionException {
		Hash_partitions_by_quantityContext _localctx = new Hash_partitions_by_quantityContext(_ctx, getState());
		enterRule(_localctx, 238, RULE_hash_partitions_by_quantity);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1886);
			match(PARTITIONS);
			setState(1887);
			((Hash_partitions_by_quantityContext)_localctx).quantity = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class List_partitionsContext extends ParserRuleContext {
		public TerminalNode PARTITION() { return getToken(SQLParser.PARTITION, 0); }
		public TerminalNode BY() { return getToken(SQLParser.BY, 0); }
		public TerminalNode LIST() { return getToken(SQLParser.LIST, 0); }
		public List<TerminalNode> LEFT_PAREN() { return getTokens(SQLParser.LEFT_PAREN); }
		public TerminalNode LEFT_PAREN(int i) {
			return getToken(SQLParser.LEFT_PAREN, i);
		}
		public Column_reference_listContext column_reference_list() {
			return getRuleContext(Column_reference_listContext.class,0);
		}
		public List<TerminalNode> RIGHT_PAREN() { return getTokens(SQLParser.RIGHT_PAREN); }
		public TerminalNode RIGHT_PAREN(int i) {
			return getToken(SQLParser.RIGHT_PAREN, i);
		}
		public List_value_clause_listContext list_value_clause_list() {
			return getRuleContext(List_value_clause_listContext.class,0);
		}
		public List_partitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_partitions; }
	}

	public final List_partitionsContext list_partitions() throws RecognitionException {
		List_partitionsContext _localctx = new List_partitionsContext(_ctx, getState());
		enterRule(_localctx, 240, RULE_list_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1889);
			match(PARTITION);
			setState(1890);
			match(BY);
			setState(1891);
			match(LIST);
			setState(1892);
			match(LEFT_PAREN);
			setState(1893);
			column_reference_list();
			setState(1894);
			match(RIGHT_PAREN);
			setState(1895);
			match(LEFT_PAREN);
			setState(1896);
			list_value_clause_list();
			setState(1897);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class List_value_clause_listContext extends ParserRuleContext {
		public List<List_value_partitionContext> list_value_partition() {
			return getRuleContexts(List_value_partitionContext.class);
		}
		public List_value_partitionContext list_value_partition(int i) {
			return getRuleContext(List_value_partitionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public List_value_clause_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_value_clause_list; }
	}

	public final List_value_clause_listContext list_value_clause_list() throws RecognitionException {
		List_value_clause_listContext _localctx = new List_value_clause_listContext(_ctx, getState());
		enterRule(_localctx, 242, RULE_list_value_clause_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1899);
			list_value_partition();
			setState(1904);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1900);
				match(COMMA);
				setState(1901);
				list_value_partition();
				}
				}
				setState(1906);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class List_value_partitionContext extends ParserRuleContext {
		public TerminalNode PARTITION() { return getToken(SQLParser.PARTITION, 0); }
		public Partition_nameContext partition_name() {
			return getRuleContext(Partition_nameContext.class,0);
		}
		public TerminalNode VALUES() { return getToken(SQLParser.VALUES, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public In_value_listContext in_value_list() {
			return getRuleContext(In_value_listContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode IN() { return getToken(SQLParser.IN, 0); }
		public List_value_partitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_value_partition; }
	}

	public final List_value_partitionContext list_value_partition() throws RecognitionException {
		List_value_partitionContext _localctx = new List_value_partitionContext(_ctx, getState());
		enterRule(_localctx, 244, RULE_list_value_partition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1907);
			match(PARTITION);
			setState(1908);
			partition_name();
			setState(1909);
			match(VALUES);
			setState(1911);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IN) {
				{
				setState(1910);
				match(IN);
				}
			}

			setState(1913);
			match(LEFT_PAREN);
			setState(1914);
			in_value_list();
			setState(1915);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Column_partitionsContext extends ParserRuleContext {
		public TerminalNode PARTITION() { return getToken(SQLParser.PARTITION, 0); }
		public TerminalNode BY() { return getToken(SQLParser.BY, 0); }
		public TerminalNode COLUMN() { return getToken(SQLParser.COLUMN, 0); }
		public Table_elementsContext table_elements() {
			return getRuleContext(Table_elementsContext.class,0);
		}
		public Column_partitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_partitions; }
	}

	public final Column_partitionsContext column_partitions() throws RecognitionException {
		Column_partitionsContext _localctx = new Column_partitionsContext(_ctx, getState());
		enterRule(_localctx, 246, RULE_column_partitions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1917);
			match(PARTITION);
			setState(1918);
			match(BY);
			setState(1919);
			match(COLUMN);
			setState(1920);
			table_elements();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Partition_nameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Partition_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partition_name; }
	}

	public final Partition_nameContext partition_name() throws RecognitionException {
		Partition_nameContext _localctx = new Partition_nameContext(_ctx, getState());
		enterRule(_localctx, 248, RULE_partition_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1922);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Truncate_table_statementContext extends ParserRuleContext {
		public TerminalNode TRUNCATE() { return getToken(SQLParser.TRUNCATE, 0); }
		public List<Table_nameContext> table_name() {
			return getRuleContexts(Table_nameContext.class);
		}
		public Table_nameContext table_name(int i) {
			return getRuleContext(Table_nameContext.class,i);
		}
		public TerminalNode TABLE() { return getToken(SQLParser.TABLE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Truncate_table_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_truncate_table_statement; }
	}

	public final Truncate_table_statementContext truncate_table_statement() throws RecognitionException {
		Truncate_table_statementContext _localctx = new Truncate_table_statementContext(_ctx, getState());
		enterRule(_localctx, 250, RULE_truncate_table_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1924);
			match(TRUNCATE);
			setState(1926);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TABLE) {
				{
				setState(1925);
				match(TABLE);
				}
			}

			setState(1928);
			table_name();
			setState(1933);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1929);
				match(COMMA);
				setState(1930);
				table_name();
				}
				}
				setState(1935);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Annotation_elementContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(SQLParser.EQUAL, 0); }
		public TerminalNode Quoted_Identifier() { return getToken(SQLParser.Quoted_Identifier, 0); }
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public Annotation_elementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotation_element; }
	}

	public final Annotation_elementContext annotation_element() throws RecognitionException {
		Annotation_elementContext _localctx = new Annotation_elementContext(_ctx, getState());
		enterRule(_localctx, 252, RULE_annotation_element);
		try {
			setState(1944);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,189,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1936);
				identifier();
				setState(1937);
				match(EQUAL);
				setState(1938);
				match(Quoted_Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1940);
				identifier();
				setState(1941);
				match(EQUAL);
				setState(1942);
				match(Character_String_Literal);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AnnotationContext extends ParserRuleContext {
		public TerminalNode AT_SIGN() { return getToken(SQLParser.AT_SIGN, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public List<Annotation_elementContext> annotation_element() {
			return getRuleContexts(Annotation_elementContext.class);
		}
		public Annotation_elementContext annotation_element(int i) {
			return getRuleContext(Annotation_elementContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public AnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotation; }
	}

	public final AnnotationContext annotation() throws RecognitionException {
		AnnotationContext _localctx = new AnnotationContext(_ctx, getState());
		enterRule(_localctx, 254, RULE_annotation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1946);
			match(AT_SIGN);
			setState(1947);
			identifier();
			setState(1959);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,191,_ctx) ) {
			case 1:
				{
				setState(1948);
				match(LEFT_PAREN);
				setState(1949);
				annotation_element();
				setState(1954);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1950);
					match(COMMA);
					setState(1951);
					annotation_element();
					}
					}
					setState(1956);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1957);
				match(RIGHT_PAREN);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Truncate_mapping_statementContext extends ParserRuleContext {
		public TerminalNode TRUNCATE() { return getToken(SQLParser.TRUNCATE, 0); }
		public TerminalNode MAPPING() { return getToken(SQLParser.MAPPING, 0); }
		public Mapping_nameContext mapping_name() {
			return getRuleContext(Mapping_nameContext.class,0);
		}
		public If_existsContext if_exists() {
			return getRuleContext(If_existsContext.class,0);
		}
		public Truncate_mapping_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_truncate_mapping_statement; }
	}

	public final Truncate_mapping_statementContext truncate_mapping_statement() throws RecognitionException {
		Truncate_mapping_statementContext _localctx = new Truncate_mapping_statementContext(_ctx, getState());
		enterRule(_localctx, 256, RULE_truncate_mapping_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1961);
			match(TRUNCATE);
			setState(1962);
			match(MAPPING);
			setState(1964);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(1963);
				if_exists();
				}
			}

			setState(1966);
			mapping_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Truncate_reusable_mapping_statementContext extends ParserRuleContext {
		public TerminalNode TRUNCATE() { return getToken(SQLParser.TRUNCATE, 0); }
		public TerminalNode REUSABLE() { return getToken(SQLParser.REUSABLE, 0); }
		public TerminalNode MAPPING() { return getToken(SQLParser.MAPPING, 0); }
		public Mapping_nameContext mapping_name() {
			return getRuleContext(Mapping_nameContext.class,0);
		}
		public If_existsContext if_exists() {
			return getRuleContext(If_existsContext.class,0);
		}
		public Truncate_reusable_mapping_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_truncate_reusable_mapping_statement; }
	}

	public final Truncate_reusable_mapping_statementContext truncate_reusable_mapping_statement() throws RecognitionException {
		Truncate_reusable_mapping_statementContext _localctx = new Truncate_reusable_mapping_statementContext(_ctx, getState());
		enterRule(_localctx, 258, RULE_truncate_reusable_mapping_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1968);
			match(TRUNCATE);
			setState(1969);
			match(REUSABLE);
			setState(1970);
			match(MAPPING);
			setState(1972);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(1971);
				if_exists();
				}
			}

			setState(1974);
			mapping_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Drop_table_statementContext extends ParserRuleContext {
		public TerminalNode DROP() { return getToken(SQLParser.DROP, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode TABLE() { return getToken(SQLParser.TABLE, 0); }
		public TerminalNode DATASTORE() { return getToken(SQLParser.DATASTORE, 0); }
		public If_existsContext if_exists() {
			return getRuleContext(If_existsContext.class,0);
		}
		public TerminalNode PURGE() { return getToken(SQLParser.PURGE, 0); }
		public Drop_table_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop_table_statement; }
	}

	public final Drop_table_statementContext drop_table_statement() throws RecognitionException {
		Drop_table_statementContext _localctx = new Drop_table_statementContext(_ctx, getState());
		enterRule(_localctx, 260, RULE_drop_table_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1976);
			match(DROP);
			setState(1977);
			_la = _input.LA(1);
			if ( !(_la==TABLE || _la==DATASTORE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(1979);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(1978);
				if_exists();
				}
			}

			setState(1981);
			table_name();
			setState(1983);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PURGE) {
				{
				setState(1982);
				match(PURGE);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Drop_mapping_statementContext extends ParserRuleContext {
		public TerminalNode DROP() { return getToken(SQLParser.DROP, 0); }
		public TerminalNode MAPPING() { return getToken(SQLParser.MAPPING, 0); }
		public Mapping_nameContext mapping_name() {
			return getRuleContext(Mapping_nameContext.class,0);
		}
		public If_existsContext if_exists() {
			return getRuleContext(If_existsContext.class,0);
		}
		public TerminalNode CASCADE() { return getToken(SQLParser.CASCADE, 0); }
		public Drop_mapping_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop_mapping_statement; }
	}

	public final Drop_mapping_statementContext drop_mapping_statement() throws RecognitionException {
		Drop_mapping_statementContext _localctx = new Drop_mapping_statementContext(_ctx, getState());
		enterRule(_localctx, 262, RULE_drop_mapping_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1985);
			match(DROP);
			setState(1986);
			match(MAPPING);
			setState(1988);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(1987);
				if_exists();
				}
			}

			setState(1990);
			mapping_name();
			setState(1992);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CASCADE) {
				{
				setState(1991);
				match(CASCADE);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Drop_reusable_mapping_statementContext extends ParserRuleContext {
		public TerminalNode DROP() { return getToken(SQLParser.DROP, 0); }
		public TerminalNode REUSABLE() { return getToken(SQLParser.REUSABLE, 0); }
		public TerminalNode MAPPING() { return getToken(SQLParser.MAPPING, 0); }
		public Mapping_nameContext mapping_name() {
			return getRuleContext(Mapping_nameContext.class,0);
		}
		public If_existsContext if_exists() {
			return getRuleContext(If_existsContext.class,0);
		}
		public TerminalNode CASCADE() { return getToken(SQLParser.CASCADE, 0); }
		public Drop_reusable_mapping_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop_reusable_mapping_statement; }
	}

	public final Drop_reusable_mapping_statementContext drop_reusable_mapping_statement() throws RecognitionException {
		Drop_reusable_mapping_statementContext _localctx = new Drop_reusable_mapping_statementContext(_ctx, getState());
		enterRule(_localctx, 264, RULE_drop_reusable_mapping_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1994);
			match(DROP);
			setState(1995);
			match(REUSABLE);
			setState(1996);
			match(MAPPING);
			setState(1998);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(1997);
				if_exists();
				}
			}

			setState(2000);
			mapping_name();
			setState(2002);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CASCADE) {
				{
				setState(2001);
				match(CASCADE);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Drop_package_statementContext extends ParserRuleContext {
		public TerminalNode DROP() { return getToken(SQLParser.DROP, 0); }
		public TerminalNode PACKAGE() { return getToken(SQLParser.PACKAGE, 0); }
		public Mapping_nameContext mapping_name() {
			return getRuleContext(Mapping_nameContext.class,0);
		}
		public If_existsContext if_exists() {
			return getRuleContext(If_existsContext.class,0);
		}
		public Drop_package_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop_package_statement; }
	}

	public final Drop_package_statementContext drop_package_statement() throws RecognitionException {
		Drop_package_statementContext _localctx = new Drop_package_statementContext(_ctx, getState());
		enterRule(_localctx, 266, RULE_drop_package_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2004);
			match(DROP);
			setState(2005);
			match(PACKAGE);
			setState(2007);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(2006);
				if_exists();
				}
			}

			setState(2009);
			mapping_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Nonreserved_keywordsContext extends ParserRuleContext {
		public TerminalNode ADD() { return getToken(SQLParser.ADD, 0); }
		public TerminalNode ACTIVE() { return getToken(SQLParser.ACTIVE, 0); }
		public TerminalNode ALIAS() { return getToken(SQLParser.ALIAS, 0); }
		public TerminalNode ALTER() { return getToken(SQLParser.ALTER, 0); }
		public TerminalNode ASYMMETRIC() { return getToken(SQLParser.ASYMMETRIC, 0); }
		public TerminalNode AVG() { return getToken(SQLParser.AVG, 0); }
		public TerminalNode AVRO() { return getToken(SQLParser.AVRO, 0); }
		public TerminalNode BETWEEN() { return getToken(SQLParser.BETWEEN, 0); }
		public TerminalNode BIGINT() { return getToken(SQLParser.BIGINT, 0); }
		public TerminalNode BINARY() { return getToken(SQLParser.BINARY, 0); }
		public TerminalNode BIT() { return getToken(SQLParser.BIT, 0); }
		public TerminalNode BLOB() { return getToken(SQLParser.BLOB, 0); }
		public TerminalNode BOOL() { return getToken(SQLParser.BOOL, 0); }
		public TerminalNode BOOLEAN() { return getToken(SQLParser.BOOLEAN, 0); }
		public TerminalNode BOTH() { return getToken(SQLParser.BOTH, 0); }
		public TerminalNode BY() { return getToken(SQLParser.BY, 0); }
		public TerminalNode BYTEA() { return getToken(SQLParser.BYTEA, 0); }
		public TerminalNode CATALOG() { return getToken(SQLParser.CATALOG, 0); }
		public TerminalNode CENTURY() { return getToken(SQLParser.CENTURY, 0); }
		public TerminalNode CHAR() { return getToken(SQLParser.CHAR, 0); }
		public TerminalNode CHARACTER() { return getToken(SQLParser.CHARACTER, 0); }
		public TerminalNode CKM() { return getToken(SQLParser.CKM, 0); }
		public TerminalNode COALESCE() { return getToken(SQLParser.COALESCE, 0); }
		public TerminalNode COLLECT() { return getToken(SQLParser.COLLECT, 0); }
		public TerminalNode COLUMN() { return getToken(SQLParser.COLUMN, 0); }
		public TerminalNode CONTEXT() { return getToken(SQLParser.CONTEXT, 0); }
		public TerminalNode CONTROL() { return getToken(SQLParser.CONTROL, 0); }
		public TerminalNode COUNT() { return getToken(SQLParser.COUNT, 0); }
		public TerminalNode CROSS() { return getToken(SQLParser.CROSS, 0); }
		public TerminalNode CUBE() { return getToken(SQLParser.CUBE, 0); }
		public TerminalNode CUME_DIST() { return getToken(SQLParser.CUME_DIST, 0); }
		public TerminalNode CURRENT() { return getToken(SQLParser.CURRENT, 0); }
		public TerminalNode CURRENT_DATE() { return getToken(SQLParser.CURRENT_DATE, 0); }
		public TerminalNode CURRENT_TIME() { return getToken(SQLParser.CURRENT_TIME, 0); }
		public TerminalNode CURRENT_TIMESTAMP() { return getToken(SQLParser.CURRENT_TIMESTAMP, 0); }
		public TerminalNode DATABASE() { return getToken(SQLParser.DATABASE, 0); }
		public TerminalNode DATASET() { return getToken(SQLParser.DATASET, 0); }
		public TerminalNode DATASTORE() { return getToken(SQLParser.DATASTORE, 0); }
		public TerminalNode DATE() { return getToken(SQLParser.DATE, 0); }
		public TerminalNode DAY() { return getToken(SQLParser.DAY, 0); }
		public TerminalNode DEC() { return getToken(SQLParser.DEC, 0); }
		public TerminalNode DECADE() { return getToken(SQLParser.DECADE, 0); }
		public TerminalNode DECIMAL() { return getToken(SQLParser.DECIMAL, 0); }
		public TerminalNode DEFAULT() { return getToken(SQLParser.DEFAULT, 0); }
		public TerminalNode DENSE_RANK() { return getToken(SQLParser.DENSE_RANK, 0); }
		public TerminalNode DESCRIPTION() { return getToken(SQLParser.DESCRIPTION, 0); }
		public TerminalNode DOUBLE() { return getToken(SQLParser.DOUBLE, 0); }
		public TerminalNode DOW() { return getToken(SQLParser.DOW, 0); }
		public TerminalNode DOY() { return getToken(SQLParser.DOY, 0); }
		public TerminalNode DROP() { return getToken(SQLParser.DROP, 0); }
		public TerminalNode EPOCH() { return getToken(SQLParser.EPOCH, 0); }
		public TerminalNode EVERY() { return getToken(SQLParser.EVERY, 0); }
		public TerminalNode EXCLUDE() { return getToken(SQLParser.EXCLUDE, 0); }
		public TerminalNode EXISTS() { return getToken(SQLParser.EXISTS, 0); }
		public TerminalNode EXPLAIN() { return getToken(SQLParser.EXPLAIN, 0); }
		public TerminalNode EXTERNAL() { return getToken(SQLParser.EXTERNAL, 0); }
		public TerminalNode EXTRACT() { return getToken(SQLParser.EXTRACT, 0); }
		public TerminalNode FIELDS() { return getToken(SQLParser.FIELDS, 0); }
		public TerminalNode FILE() { return getToken(SQLParser.FILE, 0); }
		public TerminalNode FILTER() { return getToken(SQLParser.FILTER, 0); }
		public TerminalNode FIRST() { return getToken(SQLParser.FIRST, 0); }
		public TerminalNode FIRST_VALUE() { return getToken(SQLParser.FIRST_VALUE, 0); }
		public TerminalNode FIXED() { return getToken(SQLParser.FIXED, 0); }
		public TerminalNode FLOAT() { return getToken(SQLParser.FLOAT, 0); }
		public TerminalNode FLOAT4() { return getToken(SQLParser.FLOAT4, 0); }
		public TerminalNode FLOAT8() { return getToken(SQLParser.FLOAT8, 0); }
		public TerminalNode FLOW() { return getToken(SQLParser.FLOW, 0); }
		public TerminalNode FOLDER() { return getToken(SQLParser.FOLDER, 0); }
		public TerminalNode FOLLOWING() { return getToken(SQLParser.FOLLOWING, 0); }
		public TerminalNode FORMAT() { return getToken(SQLParser.FORMAT, 0); }
		public TerminalNode FULL() { return getToken(SQLParser.FULL, 0); }
		public TerminalNode FUSION() { return getToken(SQLParser.FUSION, 0); }
		public TerminalNode GROUP() { return getToken(SQLParser.GROUP, 0); }
		public TerminalNode GROUPING() { return getToken(SQLParser.GROUPING, 0); }
		public TerminalNode HASH() { return getToken(SQLParser.HASH, 0); }
		public TerminalNode HEADING() { return getToken(SQLParser.HEADING, 0); }
		public TerminalNode IKM() { return getToken(SQLParser.IKM, 0); }
		public TerminalNode INDEX() { return getToken(SQLParser.INDEX, 0); }
		public TerminalNode INET4() { return getToken(SQLParser.INET4, 0); }
		public TerminalNode INPUTFORMAT() { return getToken(SQLParser.INPUTFORMAT, 0); }
		public TerminalNode INSERT() { return getToken(SQLParser.INSERT, 0); }
		public TerminalNode INT() { return getToken(SQLParser.INT, 0); }
		public TerminalNode INT1() { return getToken(SQLParser.INT1, 0); }
		public TerminalNode INT2() { return getToken(SQLParser.INT2, 0); }
		public TerminalNode INT4() { return getToken(SQLParser.INT4, 0); }
		public TerminalNode INT8() { return getToken(SQLParser.INT8, 0); }
		public TerminalNode INTEGER() { return getToken(SQLParser.INTEGER, 0); }
		public TerminalNode INTERSECTION() { return getToken(SQLParser.INTERSECTION, 0); }
		public TerminalNode INTERVAL() { return getToken(SQLParser.INTERVAL, 0); }
		public TerminalNode ISODOW() { return getToken(SQLParser.ISODOW, 0); }
		public TerminalNode ISOYEAR() { return getToken(SQLParser.ISOYEAR, 0); }
		public TerminalNode KEEP() { return getToken(SQLParser.KEEP, 0); }
		public TerminalNode LAG() { return getToken(SQLParser.LAG, 0); }
		public TerminalNode LAST() { return getToken(SQLParser.LAST, 0); }
		public TerminalNode LAST_VALUE() { return getToken(SQLParser.LAST_VALUE, 0); }
		public TerminalNode LESS() { return getToken(SQLParser.LESS, 0); }
		public TerminalNode LIMIT() { return getToken(SQLParser.LIMIT, 0); }
		public TerminalNode LIST() { return getToken(SQLParser.LIST, 0); }
		public TerminalNode LKM() { return getToken(SQLParser.LKM, 0); }
		public TerminalNode LOCATION() { return getToken(SQLParser.LOCATION, 0); }
		public TerminalNode MAPPING() { return getToken(SQLParser.MAPPING, 0); }
		public TerminalNode MAX() { return getToken(SQLParser.MAX, 0); }
		public TerminalNode MAXVALUE() { return getToken(SQLParser.MAXVALUE, 0); }
		public TerminalNode MESSAGE() { return getToken(SQLParser.MESSAGE, 0); }
		public TerminalNode MICROSECONDS() { return getToken(SQLParser.MICROSECONDS, 0); }
		public TerminalNode MILLENNIUM() { return getToken(SQLParser.MILLENNIUM, 0); }
		public TerminalNode MILLISECONDS() { return getToken(SQLParser.MILLISECONDS, 0); }
		public TerminalNode MIN() { return getToken(SQLParser.MIN, 0); }
		public TerminalNode MINUTE() { return getToken(SQLParser.MINUTE, 0); }
		public TerminalNode MODEL() { return getToken(SQLParser.MODEL, 0); }
		public TerminalNode MONTH() { return getToken(SQLParser.MONTH, 0); }
		public TerminalNode NATIONAL() { return getToken(SQLParser.NATIONAL, 0); }
		public TerminalNode NATURAL() { return getToken(SQLParser.NATURAL, 0); }
		public TerminalNode NCHAR() { return getToken(SQLParser.NCHAR, 0); }
		public TerminalNode NO() { return getToken(SQLParser.NO, 0); }
		public TerminalNode NULLIF() { return getToken(SQLParser.NULLIF, 0); }
		public TerminalNode NUMERIC() { return getToken(SQLParser.NUMERIC, 0); }
		public TerminalNode NVARCHAR() { return getToken(SQLParser.NVARCHAR, 0); }
		public TerminalNode ODI() { return getToken(SQLParser.ODI, 0); }
		public TerminalNode OFFSET() { return getToken(SQLParser.OFFSET, 0); }
		public TerminalNode ORANUMBER() { return getToken(SQLParser.ORANUMBER, 0); }
		public TerminalNode ORC() { return getToken(SQLParser.ORC, 0); }
		public TerminalNode ORDER() { return getToken(SQLParser.ORDER, 0); }
		public TerminalNode OTHERS() { return getToken(SQLParser.OTHERS, 0); }
		public TerminalNode OUTPUTFORMAT() { return getToken(SQLParser.OUTPUTFORMAT, 0); }
		public TerminalNode OVERWRITE() { return getToken(SQLParser.OVERWRITE, 0); }
		public TerminalNode PACKAGE() { return getToken(SQLParser.PACKAGE, 0); }
		public TerminalNode PARQUET() { return getToken(SQLParser.PARQUET, 0); }
		public TerminalNode PARTITION() { return getToken(SQLParser.PARTITION, 0); }
		public TerminalNode PARTITIONS() { return getToken(SQLParser.PARTITIONS, 0); }
		public TerminalNode PERCENT() { return getToken(SQLParser.PERCENT, 0); }
		public TerminalNode PERCENT_RANK() { return getToken(SQLParser.PERCENT_RANK, 0); }
		public TerminalNode PIVOT() { return getToken(SQLParser.PIVOT, 0); }
		public TerminalNode POSITION() { return getToken(SQLParser.POSITION, 0); }
		public TerminalNode PRECEDING() { return getToken(SQLParser.PRECEDING, 0); }
		public TerminalNode PRECISION() { return getToken(SQLParser.PRECISION, 0); }
		public TerminalNode PROCEDURE() { return getToken(SQLParser.PROCEDURE, 0); }
		public TerminalNode PROJECT() { return getToken(SQLParser.PROJECT, 0); }
		public TerminalNode PURGE() { return getToken(SQLParser.PURGE, 0); }
		public TerminalNode QUARTER() { return getToken(SQLParser.QUARTER, 0); }
		public TerminalNode RANGE() { return getToken(SQLParser.RANGE, 0); }
		public TerminalNode RANK() { return getToken(SQLParser.RANK, 0); }
		public TerminalNode RCFILE() { return getToken(SQLParser.RCFILE, 0); }
		public TerminalNode REAL() { return getToken(SQLParser.REAL, 0); }
		public TerminalNode REAL_NUMBER() { return getToken(SQLParser.REAL_NUMBER, 0); }
		public TerminalNode REGEXP() { return getToken(SQLParser.REGEXP, 0); }
		public TerminalNode REJECT() { return getToken(SQLParser.REJECT, 0); }
		public TerminalNode RENAME() { return getToken(SQLParser.RENAME, 0); }
		public TerminalNode REPLACE() { return getToken(SQLParser.REPLACE, 0); }
		public TerminalNode RESET() { return getToken(SQLParser.RESET, 0); }
		public TerminalNode RESOURCE() { return getToken(SQLParser.RESOURCE, 0); }
		public TerminalNode REUSABLE() { return getToken(SQLParser.REUSABLE, 0); }
		public TerminalNode RLIKE() { return getToken(SQLParser.RLIKE, 0); }
		public TerminalNode ROLLUP() { return getToken(SQLParser.ROLLUP, 0); }
		public TerminalNode ROW() { return getToken(SQLParser.ROW, 0); }
		public TerminalNode ROWS() { return getToken(SQLParser.ROWS, 0); }
		public TerminalNode ROW_NUMBER() { return getToken(SQLParser.ROW_NUMBER, 0); }
		public TerminalNode SCD() { return getToken(SQLParser.SCD, 0); }
		public TerminalNode SCENARIO() { return getToken(SQLParser.SCENARIO, 0); }
		public TerminalNode SECOND() { return getToken(SQLParser.SECOND, 0); }
		public TerminalNode SEQUENCEFILE() { return getToken(SQLParser.SEQUENCEFILE, 0); }
		public TerminalNode SERDE() { return getToken(SQLParser.SERDE, 0); }
		public TerminalNode SERDEPROPERTIES() { return getToken(SQLParser.SERDEPROPERTIES, 0); }
		public TerminalNode SESSION() { return getToken(SQLParser.SESSION, 0); }
		public TerminalNode SET() { return getToken(SQLParser.SET, 0); }
		public TerminalNode SIMILAR() { return getToken(SQLParser.SIMILAR, 0); }
		public TerminalNode SMALLINT() { return getToken(SQLParser.SMALLINT, 0); }
		public TerminalNode STATIC() { return getToken(SQLParser.STATIC, 0); }
		public TerminalNode STDDEV_POP() { return getToken(SQLParser.STDDEV_POP, 0); }
		public TerminalNode STDDEV_SAMP() { return getToken(SQLParser.STDDEV_SAMP, 0); }
		public TerminalNode STRING() { return getToken(SQLParser.STRING, 0); }
		public TerminalNode SUBMODEL() { return getToken(SQLParser.SUBMODEL, 0); }
		public TerminalNode SUBPARTITION() { return getToken(SQLParser.SUBPARTITION, 0); }
		public TerminalNode SUCCESS() { return getToken(SQLParser.SUCCESS, 0); }
		public TerminalNode SUM() { return getToken(SQLParser.SUM, 0); }
		public TerminalNode SYMMETRIC() { return getToken(SQLParser.SYMMETRIC, 0); }
		public TerminalNode TABLESPACE() { return getToken(SQLParser.TABLESPACE, 0); }
		public TerminalNode TBLPROPERTIES() { return getToken(SQLParser.TBLPROPERTIES, 0); }
		public TerminalNode TECHNOLOGY() { return getToken(SQLParser.TECHNOLOGY, 0); }
		public TerminalNode TEMPORARY() { return getToken(SQLParser.TEMPORARY, 0); }
		public TerminalNode TERMINATED() { return getToken(SQLParser.TERMINATED, 0); }
		public TerminalNode TEXT() { return getToken(SQLParser.TEXT, 0); }
		public TerminalNode TEXTFILE() { return getToken(SQLParser.TEXTFILE, 0); }
		public TerminalNode THAN() { return getToken(SQLParser.THAN, 0); }
		public TerminalNode TIES() { return getToken(SQLParser.TIES, 0); }
		public TerminalNode TIME() { return getToken(SQLParser.TIME, 0); }
		public TerminalNode TIMESTAMP() { return getToken(SQLParser.TIMESTAMP, 0); }
		public TerminalNode TIMESTAMPTZ() { return getToken(SQLParser.TIMESTAMPTZ, 0); }
		public TerminalNode TIMETZ() { return getToken(SQLParser.TIMETZ, 0); }
		public TerminalNode TIMEZONE() { return getToken(SQLParser.TIMEZONE, 0); }
		public TerminalNode TIMEZONE_HOUR() { return getToken(SQLParser.TIMEZONE_HOUR, 0); }
		public TerminalNode TIMEZONE_MINUTE() { return getToken(SQLParser.TIMEZONE_MINUTE, 0); }
		public TerminalNode TINYINT() { return getToken(SQLParser.TINYINT, 0); }
		public TerminalNode TO() { return getToken(SQLParser.TO, 0); }
		public TerminalNode TRAILING() { return getToken(SQLParser.TRAILING, 0); }
		public TerminalNode TRIM() { return getToken(SQLParser.TRIM, 0); }
		public TerminalNode TYPE() { return getToken(SQLParser.TYPE, 0); }
		public TerminalNode UNBOUNDED() { return getToken(SQLParser.UNBOUNDED, 0); }
		public TerminalNode UNKNOWN() { return getToken(SQLParser.UNKNOWN, 0); }
		public TerminalNode UNPIVOT() { return getToken(SQLParser.UNPIVOT, 0); }
		public TerminalNode VALUES() { return getToken(SQLParser.VALUES, 0); }
		public TerminalNode VARBINARY() { return getToken(SQLParser.VARBINARY, 0); }
		public TerminalNode VARBIT() { return getToken(SQLParser.VARBIT, 0); }
		public TerminalNode VARCHAR() { return getToken(SQLParser.VARCHAR, 0); }
		public TerminalNode VARCHAR2() { return getToken(SQLParser.VARCHAR2, 0); }
		public TerminalNode VARIABLE() { return getToken(SQLParser.VARIABLE, 0); }
		public TerminalNode VARYING() { return getToken(SQLParser.VARYING, 0); }
		public TerminalNode VAR_POP() { return getToken(SQLParser.VAR_POP, 0); }
		public TerminalNode VAR_SAMP() { return getToken(SQLParser.VAR_SAMP, 0); }
		public TerminalNode WEEK() { return getToken(SQLParser.WEEK, 0); }
		public TerminalNode WINDOW() { return getToken(SQLParser.WINDOW, 0); }
		public TerminalNode XKM() { return getToken(SQLParser.XKM, 0); }
		public TerminalNode YEAR() { return getToken(SQLParser.YEAR, 0); }
		public TerminalNode ZONE() { return getToken(SQLParser.ZONE, 0); }
		public Nonreserved_keywordsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonreserved_keywords; }
	}

	public final Nonreserved_keywordsContext nonreserved_keywords() throws RecognitionException {
		Nonreserved_keywordsContext _localctx = new Nonreserved_keywordsContext(_ctx, getState());
		enterRule(_localctx, 268, RULE_nonreserved_keywords);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2011);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 172764544106657952L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & -873698335226338561L) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & -18014398509482001L) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & 549688705023L) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & 72275295724540153L) != 0) || ((((_la - 335)) & ~0x3f) == 0 && ((1L << (_la - 335)) & 1044489L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode Regular_Identifier() { return getToken(SQLParser.Regular_Identifier, 0); }
		public TerminalNode Quoted_Identifier() { return getToken(SQLParser.Quoted_Identifier, 0); }
		public Nonreserved_keywordsContext nonreserved_keywords() {
			return getRuleContext(Nonreserved_keywordsContext.class,0);
		}
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 270, RULE_identifier);
		try {
			setState(2016);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Regular_Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(2013);
				match(Regular_Identifier);
				}
				break;
			case Quoted_Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(2014);
				match(Quoted_Identifier);
				}
				break;
			case ASYMMETRIC:
			case BOTH:
			case CROSS:
			case CURRENT_DATE:
			case CURRENT_TIME:
			case CURRENT_TIMESTAMP:
			case DATASET:
			case FULL:
			case GROUP:
			case LIMIT:
			case MAPPING:
			case NATURAL:
			case ORDER:
			case PACKAGE:
			case PROCEDURE:
			case PROJECT:
			case REUSABLE:
			case SYMMETRIC:
			case SCENARIO:
			case TRAILING:
			case WINDOW:
			case VARIABLE:
			case POSITION:
			case OFFSET:
			case IKM:
			case LKM:
			case CKM:
			case TECHNOLOGY:
			case DESCRIPTION:
			case AVG:
			case ADD:
			case ALTER:
			case BETWEEN:
			case BY:
			case CATALOG:
			case CENTURY:
			case CHARACTER:
			case COLLECT:
			case COALESCE:
			case COLUMN:
			case COUNT:
			case CUBE:
			case CUME_DIST:
			case CURRENT:
			case STRING:
			case DAY:
			case DEFAULT:
			case DATABASE:
			case DEC:
			case DECADE:
			case DENSE_RANK:
			case DOW:
			case DOY:
			case DROP:
			case EPOCH:
			case EVERY:
			case EXCLUDE:
			case EXISTS:
			case EXPLAIN:
			case EXTERNAL:
			case EXTRACT:
			case FILTER:
			case FIRST:
			case FIRST_VALUE:
			case FOLLOWING:
			case FORMAT:
			case FUSION:
			case GROUPING:
			case HASH:
			case INDEX:
			case INSERT:
			case INTERSECTION:
			case ISODOW:
			case ISOYEAR:
			case LAG:
			case LAST:
			case LAST_VALUE:
			case LESS:
			case LIST:
			case LOCATION:
			case MAX:
			case MAXVALUE:
			case MICROSECONDS:
			case MILLENNIUM:
			case MILLISECONDS:
			case MIN:
			case MINUTE:
			case MONTH:
			case NATIONAL:
			case NULLIF:
			case NO:
			case OVERWRITE:
			case OTHERS:
			case PARTITION:
			case PARTITIONS:
			case PERCENT_RANK:
			case PRECEDING:
			case PRECISION:
			case PURGE:
			case QUARTER:
			case RANGE:
			case RANK:
			case REGEXP:
			case RENAME:
			case RESET:
			case RLIKE:
			case ROLLUP:
			case ROW:
			case ROWS:
			case ROW_NUMBER:
			case SECOND:
			case SESSION:
			case SET:
			case SIMILAR:
			case STDDEV_POP:
			case STDDEV_SAMP:
			case SUBPARTITION:
			case SUM:
			case TABLESPACE:
			case THAN:
			case TIES:
			case TIMEZONE:
			case TIMEZONE_HOUR:
			case TIMEZONE_MINUTE:
			case TRIM:
			case TO:
			case UNBOUNDED:
			case UNKNOWN:
			case VALUES:
			case VAR_SAMP:
			case VAR_POP:
			case VARYING:
			case WEEK:
			case YEAR:
			case ZONE:
			case BOOLEAN:
			case BOOL:
			case BIT:
			case VARBIT:
			case INT1:
			case INT2:
			case INT4:
			case INT8:
			case TINYINT:
			case SMALLINT:
			case INT:
			case INTEGER:
			case BIGINT:
			case FLOAT4:
			case FLOAT8:
			case REAL:
			case FLOAT:
			case DOUBLE:
			case NUMERIC:
			case ORANUMBER:
			case DECIMAL:
			case CHAR:
			case VARCHAR2:
			case VARCHAR:
			case NCHAR:
			case NVARCHAR:
			case DATE:
			case INTERVAL:
			case TIME:
			case TIMETZ:
			case TIMESTAMP:
			case TIMESTAMPTZ:
			case TEXT:
			case BINARY:
			case VARBINARY:
			case BLOB:
			case BYTEA:
			case INET4:
			case REAL_NUMBER:
			case DATASTORE:
			case ALIAS:
			case RESOURCE:
			case FILE:
			case HEADING:
			case FIXED:
			case SCD:
			case MODEL:
			case FOLDER:
			case SUBMODEL:
			case REPLACE:
			case CONTEXT:
			case XKM:
			case SEQUENCEFILE:
			case FIELDS:
			case TERMINATED:
			case SERDE:
			case SERDEPROPERTIES:
			case TEXTFILE:
			case RCFILE:
			case ORC:
			case PARQUET:
			case AVRO:
			case INPUTFORMAT:
			case OUTPUTFORMAT:
			case TEMPORARY:
			case TBLPROPERTIES:
			case REJECT:
			case PERCENT:
			case SUCCESS:
			case TYPE:
			case ODI:
			case CONTROL:
			case FLOW:
			case STATIC:
			case ACTIVE:
			case MESSAGE:
			case KEEP:
			case PIVOT:
			case UNPIVOT:
				enterOuterAlt(_localctx, 3);
				{
				setState(2015);
				nonreserved_keywords();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Unsigned_literalContext extends ParserRuleContext {
		public Unsigned_numeric_literalContext unsigned_numeric_literal() {
			return getRuleContext(Unsigned_numeric_literalContext.class,0);
		}
		public General_literalContext general_literal() {
			return getRuleContext(General_literalContext.class,0);
		}
		public Unsigned_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsigned_literal; }
	}

	public final Unsigned_literalContext unsigned_literal() throws RecognitionException {
		Unsigned_literalContext _localctx = new Unsigned_literalContext(_ctx, getState());
		enterRule(_localctx, 272, RULE_unsigned_literal);
		try {
			setState(2020);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
			case REAL_NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(2018);
				unsigned_numeric_literal();
				}
				break;
			case FALSE:
			case TRUE:
			case UNKNOWN:
			case DATE:
			case INTERVAL:
			case TIME:
			case TIMESTAMP:
			case Odi_Variable_Literal:
			case Character_String_Literal:
				enterOuterAlt(_localctx, 2);
				{
				setState(2019);
				general_literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class General_literalContext extends ParserRuleContext {
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public Datetime_literalContext datetime_literal() {
			return getRuleContext(Datetime_literalContext.class,0);
		}
		public Boolean_literalContext boolean_literal() {
			return getRuleContext(Boolean_literalContext.class,0);
		}
		public Odi_variable_literalContext odi_variable_literal() {
			return getRuleContext(Odi_variable_literalContext.class,0);
		}
		public General_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_general_literal; }
	}

	public final General_literalContext general_literal() throws RecognitionException {
		General_literalContext _localctx = new General_literalContext(_ctx, getState());
		enterRule(_localctx, 274, RULE_general_literal);
		try {
			setState(2026);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Character_String_Literal:
				enterOuterAlt(_localctx, 1);
				{
				setState(2022);
				match(Character_String_Literal);
				}
				break;
			case DATE:
			case INTERVAL:
			case TIME:
			case TIMESTAMP:
				enterOuterAlt(_localctx, 2);
				{
				setState(2023);
				datetime_literal();
				}
				break;
			case FALSE:
			case TRUE:
			case UNKNOWN:
				enterOuterAlt(_localctx, 3);
				{
				setState(2024);
				boolean_literal();
				}
				break;
			case Odi_Variable_Literal:
				enterOuterAlt(_localctx, 4);
				{
				setState(2025);
				odi_variable_literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Datetime_literalContext extends ParserRuleContext {
		public Timestamp_literalContext timestamp_literal() {
			return getRuleContext(Timestamp_literalContext.class,0);
		}
		public Time_literalContext time_literal() {
			return getRuleContext(Time_literalContext.class,0);
		}
		public Date_literalContext date_literal() {
			return getRuleContext(Date_literalContext.class,0);
		}
		public Interval_literalContext interval_literal() {
			return getRuleContext(Interval_literalContext.class,0);
		}
		public Datetime_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datetime_literal; }
	}

	public final Datetime_literalContext datetime_literal() throws RecognitionException {
		Datetime_literalContext _localctx = new Datetime_literalContext(_ctx, getState());
		enterRule(_localctx, 276, RULE_datetime_literal);
		try {
			setState(2032);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TIMESTAMP:
				enterOuterAlt(_localctx, 1);
				{
				setState(2028);
				timestamp_literal();
				}
				break;
			case TIME:
				enterOuterAlt(_localctx, 2);
				{
				setState(2029);
				time_literal();
				}
				break;
			case DATE:
				enterOuterAlt(_localctx, 3);
				{
				setState(2030);
				date_literal();
				}
				break;
			case INTERVAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(2031);
				interval_literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Time_literalContext extends ParserRuleContext {
		public Token time_string;
		public TerminalNode TIME() { return getToken(SQLParser.TIME, 0); }
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public Time_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_time_literal; }
	}

	public final Time_literalContext time_literal() throws RecognitionException {
		Time_literalContext _localctx = new Time_literalContext(_ctx, getState());
		enterRule(_localctx, 278, RULE_time_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2034);
			match(TIME);
			setState(2035);
			((Time_literalContext)_localctx).time_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Timestamp_literalContext extends ParserRuleContext {
		public Token timestamp_string;
		public TerminalNode TIMESTAMP() { return getToken(SQLParser.TIMESTAMP, 0); }
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public Timestamp_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timestamp_literal; }
	}

	public final Timestamp_literalContext timestamp_literal() throws RecognitionException {
		Timestamp_literalContext _localctx = new Timestamp_literalContext(_ctx, getState());
		enterRule(_localctx, 280, RULE_timestamp_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2037);
			match(TIMESTAMP);
			setState(2038);
			((Timestamp_literalContext)_localctx).timestamp_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Date_literalContext extends ParserRuleContext {
		public Token date_string;
		public TerminalNode DATE() { return getToken(SQLParser.DATE, 0); }
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public Date_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_date_literal; }
	}

	public final Date_literalContext date_literal() throws RecognitionException {
		Date_literalContext _localctx = new Date_literalContext(_ctx, getState());
		enterRule(_localctx, 282, RULE_date_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2040);
			match(DATE);
			setState(2041);
			((Date_literalContext)_localctx).date_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Interval_literalContext extends ParserRuleContext {
		public Token interval_string;
		public TerminalNode INTERVAL() { return getToken(SQLParser.INTERVAL, 0); }
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public Interval_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interval_literal; }
	}

	public final Interval_literalContext interval_literal() throws RecognitionException {
		Interval_literalContext _localctx = new Interval_literalContext(_ctx, getState());
		enterRule(_localctx, 284, RULE_interval_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2043);
			match(INTERVAL);
			setState(2044);
			((Interval_literalContext)_localctx).interval_string = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Boolean_literalContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(SQLParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(SQLParser.FALSE, 0); }
		public TerminalNode UNKNOWN() { return getToken(SQLParser.UNKNOWN, 0); }
		public Boolean_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_literal; }
	}

	public final Boolean_literalContext boolean_literal() throws RecognitionException {
		Boolean_literalContext _localctx = new Boolean_literalContext(_ctx, getState());
		enterRule(_localctx, 286, RULE_boolean_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2046);
			_la = _input.LA(1);
			if ( !(_la==FALSE || _la==TRUE || _la==UNKNOWN) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Data_typeContext extends ParserRuleContext {
		public Predefined_typeContext predefined_type() {
			return getRuleContext(Predefined_typeContext.class,0);
		}
		public Generic_typeContext generic_type() {
			return getRuleContext(Generic_typeContext.class,0);
		}
		public Data_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data_type; }
	}

	public final Data_typeContext data_type() throws RecognitionException {
		Data_typeContext _localctx = new Data_typeContext(_ctx, getState());
		enterRule(_localctx, 288, RULE_data_type);
		try {
			setState(2050);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CHARACTER:
			case STRING:
			case FEBCDIC:
			case SIGNED_PACKED_DECIMAL:
			case EBCDIC_SIGNED_ZONED_DECIMAL:
			case DEC:
			case NATIONAL:
			case BOOLEAN:
			case BOOL:
			case BIT:
			case VARBIT:
			case INT1:
			case INT2:
			case INT4:
			case INT8:
			case TINYINT:
			case SMALLINT:
			case INT:
			case INTEGER:
			case BIGINT:
			case FLOAT4:
			case FLOAT8:
			case REAL:
			case FLOAT:
			case DOUBLE:
			case NUMERIC:
			case ORANUMBER:
			case DECIMAL:
			case CHAR:
			case VARCHAR2:
			case VARCHAR:
			case NCHAR:
			case NVARCHAR:
			case CLOB:
			case DATE:
			case INTERVAL:
			case TIME:
			case TIMETZ:
			case TIMESTAMP:
			case TIMESTAMPTZ:
			case TEXT:
			case BINARY:
			case VARBINARY:
			case BLOB:
			case BYTEA:
			case INET4:
			case DATETIME:
			case VARCHAR_MAX:
			case VARCHAR2_MAX:
				enterOuterAlt(_localctx, 1);
				{
				setState(2048);
				predefined_type();
				}
				break;
			case Regular_Identifier:
			case Quoted_Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(2049);
				generic_type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Predefined_typeContext extends ParserRuleContext {
		public Character_string_typeContext character_string_type() {
			return getRuleContext(Character_string_typeContext.class,0);
		}
		public National_character_string_typeContext national_character_string_type() {
			return getRuleContext(National_character_string_typeContext.class,0);
		}
		public Binary_large_object_string_typeContext binary_large_object_string_type() {
			return getRuleContext(Binary_large_object_string_typeContext.class,0);
		}
		public Numeric_typeContext numeric_type() {
			return getRuleContext(Numeric_typeContext.class,0);
		}
		public Boolean_typeContext boolean_type() {
			return getRuleContext(Boolean_typeContext.class,0);
		}
		public Datetime_typeContext datetime_type() {
			return getRuleContext(Datetime_typeContext.class,0);
		}
		public Bit_typeContext bit_type() {
			return getRuleContext(Bit_typeContext.class,0);
		}
		public Binary_typeContext binary_type() {
			return getRuleContext(Binary_typeContext.class,0);
		}
		public Network_typeContext network_type() {
			return getRuleContext(Network_typeContext.class,0);
		}
		public Predefined_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predefined_type; }
	}

	public final Predefined_typeContext predefined_type() throws RecognitionException {
		Predefined_typeContext _localctx = new Predefined_typeContext(_ctx, getState());
		enterRule(_localctx, 290, RULE_predefined_type);
		try {
			setState(2061);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CHARACTER:
			case STRING:
			case FEBCDIC:
			case CHAR:
			case VARCHAR2:
			case VARCHAR:
			case CLOB:
			case TEXT:
			case VARCHAR_MAX:
			case VARCHAR2_MAX:
				enterOuterAlt(_localctx, 1);
				{
				setState(2052);
				character_string_type();
				}
				break;
			case NATIONAL:
			case NCHAR:
			case NVARCHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(2053);
				national_character_string_type();
				}
				break;
			case BLOB:
			case BYTEA:
				enterOuterAlt(_localctx, 3);
				{
				setState(2054);
				binary_large_object_string_type();
				}
				break;
			case SIGNED_PACKED_DECIMAL:
			case EBCDIC_SIGNED_ZONED_DECIMAL:
			case DEC:
			case INT1:
			case INT2:
			case INT4:
			case INT8:
			case TINYINT:
			case SMALLINT:
			case INT:
			case INTEGER:
			case BIGINT:
			case FLOAT4:
			case FLOAT8:
			case REAL:
			case FLOAT:
			case DOUBLE:
			case NUMERIC:
			case ORANUMBER:
			case DECIMAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(2055);
				numeric_type();
				}
				break;
			case BOOLEAN:
			case BOOL:
				enterOuterAlt(_localctx, 5);
				{
				setState(2056);
				boolean_type();
				}
				break;
			case DATE:
			case INTERVAL:
			case TIME:
			case TIMETZ:
			case TIMESTAMP:
			case TIMESTAMPTZ:
			case DATETIME:
				enterOuterAlt(_localctx, 6);
				{
				setState(2057);
				datetime_type();
				}
				break;
			case BIT:
			case VARBIT:
				enterOuterAlt(_localctx, 7);
				{
				setState(2058);
				bit_type();
				}
				break;
			case BINARY:
			case VARBINARY:
				enterOuterAlt(_localctx, 8);
				{
				setState(2059);
				binary_type();
				}
				break;
			case INET4:
				enterOuterAlt(_localctx, 9);
				{
				setState(2060);
				network_type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Generic_typeContext extends ParserRuleContext {
		public TerminalNode Regular_Identifier() { return getToken(SQLParser.Regular_Identifier, 0); }
		public TerminalNode Quoted_Identifier() { return getToken(SQLParser.Quoted_Identifier, 0); }
		public Precision_paramContext precision_param() {
			return getRuleContext(Precision_paramContext.class,0);
		}
		public Generic_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generic_type; }
	}

	public final Generic_typeContext generic_type() throws RecognitionException {
		Generic_typeContext _localctx = new Generic_typeContext(_ctx, getState());
		enterRule(_localctx, 292, RULE_generic_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2063);
			_la = _input.LA(1);
			if ( !(_la==Regular_Identifier || _la==Quoted_Identifier) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(2065);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LEFT_PAREN) {
				{
				setState(2064);
				precision_param();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Network_typeContext extends ParserRuleContext {
		public TerminalNode INET4() { return getToken(SQLParser.INET4, 0); }
		public Network_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_network_type; }
	}

	public final Network_typeContext network_type() throws RecognitionException {
		Network_typeContext _localctx = new Network_typeContext(_ctx, getState());
		enterRule(_localctx, 294, RULE_network_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2067);
			match(INET4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Character_string_typeContext extends ParserRuleContext {
		public TerminalNode CHARACTER() { return getToken(SQLParser.CHARACTER, 0); }
		public Type_lengthContext type_length() {
			return getRuleContext(Type_lengthContext.class,0);
		}
		public TerminalNode CHAR() { return getToken(SQLParser.CHAR, 0); }
		public TerminalNode VARYING() { return getToken(SQLParser.VARYING, 0); }
		public TerminalNode VARCHAR() { return getToken(SQLParser.VARCHAR, 0); }
		public TerminalNode VARCHAR_MAX() { return getToken(SQLParser.VARCHAR_MAX, 0); }
		public TerminalNode VARCHAR2() { return getToken(SQLParser.VARCHAR2, 0); }
		public TerminalNode VARCHAR2_MAX() { return getToken(SQLParser.VARCHAR2_MAX, 0); }
		public TerminalNode FEBCDIC() { return getToken(SQLParser.FEBCDIC, 0); }
		public TerminalNode STRING() { return getToken(SQLParser.STRING, 0); }
		public TerminalNode TEXT() { return getToken(SQLParser.TEXT, 0); }
		public TerminalNode CLOB() { return getToken(SQLParser.CLOB, 0); }
		public Character_string_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_character_string_type; }
	}

	public final Character_string_typeContext character_string_type() throws RecognitionException {
		Character_string_typeContext _localctx = new Character_string_typeContext(_ctx, getState());
		enterRule(_localctx, 296, RULE_character_string_type);
		int _la;
		try {
			setState(2110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,217,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2069);
				match(CHARACTER);
				setState(2071);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2070);
					type_length();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2073);
				match(CHAR);
				setState(2075);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2074);
					type_length();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2077);
				match(CHARACTER);
				setState(2078);
				match(VARYING);
				setState(2080);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2079);
					type_length();
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2082);
				match(CHAR);
				setState(2083);
				match(VARYING);
				setState(2085);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2084);
					type_length();
					}
				}

				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2087);
				match(VARCHAR);
				setState(2089);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2088);
					type_length();
					}
				}

				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2091);
				match(VARCHAR_MAX);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2092);
				match(VARCHAR2);
				setState(2094);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2093);
					type_length();
					}
				}

				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(2096);
				match(VARCHAR2_MAX);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(2097);
				match(FEBCDIC);
				setState(2099);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2098);
					type_length();
					}
				}

				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(2101);
				match(STRING);
				setState(2103);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2102);
					type_length();
					}
				}

				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(2105);
				match(TEXT);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(2106);
				match(CLOB);
				setState(2108);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2107);
					type_length();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Type_lengthContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public TerminalNode NUMBER() { return getToken(SQLParser.NUMBER, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public Type_lengthContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_length; }
	}

	public final Type_lengthContext type_length() throws RecognitionException {
		Type_lengthContext _localctx = new Type_lengthContext(_ctx, getState());
		enterRule(_localctx, 298, RULE_type_length);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2112);
			match(LEFT_PAREN);
			setState(2113);
			match(NUMBER);
			setState(2114);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class National_character_string_typeContext extends ParserRuleContext {
		public TerminalNode NATIONAL() { return getToken(SQLParser.NATIONAL, 0); }
		public TerminalNode CHARACTER() { return getToken(SQLParser.CHARACTER, 0); }
		public Type_lengthContext type_length() {
			return getRuleContext(Type_lengthContext.class,0);
		}
		public TerminalNode CHAR() { return getToken(SQLParser.CHAR, 0); }
		public TerminalNode NCHAR() { return getToken(SQLParser.NCHAR, 0); }
		public TerminalNode VARYING() { return getToken(SQLParser.VARYING, 0); }
		public TerminalNode NVARCHAR() { return getToken(SQLParser.NVARCHAR, 0); }
		public National_character_string_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_national_character_string_type; }
	}

	public final National_character_string_typeContext national_character_string_type() throws RecognitionException {
		National_character_string_typeContext _localctx = new National_character_string_typeContext(_ctx, getState());
		enterRule(_localctx, 300, RULE_national_character_string_type);
		int _la;
		try {
			setState(2151);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,225,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2116);
				match(NATIONAL);
				setState(2117);
				match(CHARACTER);
				setState(2119);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2118);
					type_length();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2121);
				match(NATIONAL);
				setState(2122);
				match(CHAR);
				setState(2124);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2123);
					type_length();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2126);
				match(NCHAR);
				setState(2128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2127);
					type_length();
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2130);
				match(NATIONAL);
				setState(2131);
				match(CHARACTER);
				setState(2132);
				match(VARYING);
				setState(2134);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2133);
					type_length();
					}
				}

				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2136);
				match(NATIONAL);
				setState(2137);
				match(CHAR);
				setState(2138);
				match(VARYING);
				setState(2140);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2139);
					type_length();
					}
				}

				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2142);
				match(NCHAR);
				setState(2143);
				match(VARYING);
				setState(2145);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2144);
					type_length();
					}
				}

				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2147);
				match(NVARCHAR);
				setState(2149);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2148);
					type_length();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Binary_large_object_string_typeContext extends ParserRuleContext {
		public TerminalNode BLOB() { return getToken(SQLParser.BLOB, 0); }
		public Type_lengthContext type_length() {
			return getRuleContext(Type_lengthContext.class,0);
		}
		public TerminalNode BYTEA() { return getToken(SQLParser.BYTEA, 0); }
		public Binary_large_object_string_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_large_object_string_type; }
	}

	public final Binary_large_object_string_typeContext binary_large_object_string_type() throws RecognitionException {
		Binary_large_object_string_typeContext _localctx = new Binary_large_object_string_typeContext(_ctx, getState());
		enterRule(_localctx, 302, RULE_binary_large_object_string_type);
		int _la;
		try {
			setState(2161);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BLOB:
				enterOuterAlt(_localctx, 1);
				{
				setState(2153);
				match(BLOB);
				setState(2155);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2154);
					type_length();
					}
				}

				}
				break;
			case BYTEA:
				enterOuterAlt(_localctx, 2);
				{
				setState(2157);
				match(BYTEA);
				setState(2159);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2158);
					type_length();
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Numeric_typeContext extends ParserRuleContext {
		public Exact_numeric_typeContext exact_numeric_type() {
			return getRuleContext(Exact_numeric_typeContext.class,0);
		}
		public Approximate_numeric_typeContext approximate_numeric_type() {
			return getRuleContext(Approximate_numeric_typeContext.class,0);
		}
		public Numeric_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numeric_type; }
	}

	public final Numeric_typeContext numeric_type() throws RecognitionException {
		Numeric_typeContext _localctx = new Numeric_typeContext(_ctx, getState());
		enterRule(_localctx, 304, RULE_numeric_type);
		try {
			setState(2165);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SIGNED_PACKED_DECIMAL:
			case EBCDIC_SIGNED_ZONED_DECIMAL:
			case DEC:
			case INT1:
			case INT2:
			case INT4:
			case INT8:
			case TINYINT:
			case SMALLINT:
			case INT:
			case INTEGER:
			case BIGINT:
			case NUMERIC:
			case ORANUMBER:
			case DECIMAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(2163);
				exact_numeric_type();
				}
				break;
			case FLOAT4:
			case FLOAT8:
			case REAL:
			case FLOAT:
			case DOUBLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(2164);
				approximate_numeric_type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Exact_numeric_typeContext extends ParserRuleContext {
		public TerminalNode NUMERIC() { return getToken(SQLParser.NUMERIC, 0); }
		public Precision_paramContext precision_param() {
			return getRuleContext(Precision_paramContext.class,0);
		}
		public TerminalNode ORANUMBER() { return getToken(SQLParser.ORANUMBER, 0); }
		public TerminalNode DECIMAL() { return getToken(SQLParser.DECIMAL, 0); }
		public TerminalNode DEC() { return getToken(SQLParser.DEC, 0); }
		public TerminalNode INT1() { return getToken(SQLParser.INT1, 0); }
		public TerminalNode TINYINT() { return getToken(SQLParser.TINYINT, 0); }
		public TerminalNode INT2() { return getToken(SQLParser.INT2, 0); }
		public TerminalNode SMALLINT() { return getToken(SQLParser.SMALLINT, 0); }
		public TerminalNode INT4() { return getToken(SQLParser.INT4, 0); }
		public TerminalNode INT() { return getToken(SQLParser.INT, 0); }
		public TerminalNode INTEGER() { return getToken(SQLParser.INTEGER, 0); }
		public TerminalNode INT8() { return getToken(SQLParser.INT8, 0); }
		public TerminalNode BIGINT() { return getToken(SQLParser.BIGINT, 0); }
		public TerminalNode SIGNED_PACKED_DECIMAL() { return getToken(SQLParser.SIGNED_PACKED_DECIMAL, 0); }
		public TerminalNode EBCDIC_SIGNED_ZONED_DECIMAL() { return getToken(SQLParser.EBCDIC_SIGNED_ZONED_DECIMAL, 0); }
		public Exact_numeric_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exact_numeric_type; }
	}

	public final Exact_numeric_typeContext exact_numeric_type() throws RecognitionException {
		Exact_numeric_typeContext _localctx = new Exact_numeric_typeContext(_ctx, getState());
		enterRule(_localctx, 306, RULE_exact_numeric_type);
		int _la;
		try {
			setState(2196);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMERIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(2167);
				match(NUMERIC);
				setState(2169);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2168);
					precision_param();
					}
				}

				}
				break;
			case ORANUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(2171);
				match(ORANUMBER);
				setState(2173);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2172);
					precision_param();
					}
				}

				}
				break;
			case DECIMAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(2175);
				match(DECIMAL);
				setState(2177);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2176);
					precision_param();
					}
				}

				}
				break;
			case DEC:
				enterOuterAlt(_localctx, 4);
				{
				setState(2179);
				match(DEC);
				setState(2181);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2180);
					precision_param();
					}
				}

				}
				break;
			case INT1:
				enterOuterAlt(_localctx, 5);
				{
				setState(2183);
				match(INT1);
				}
				break;
			case TINYINT:
				enterOuterAlt(_localctx, 6);
				{
				setState(2184);
				match(TINYINT);
				}
				break;
			case INT2:
				enterOuterAlt(_localctx, 7);
				{
				setState(2185);
				match(INT2);
				}
				break;
			case SMALLINT:
				enterOuterAlt(_localctx, 8);
				{
				setState(2186);
				match(SMALLINT);
				}
				break;
			case INT4:
				enterOuterAlt(_localctx, 9);
				{
				setState(2187);
				match(INT4);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 10);
				{
				setState(2188);
				match(INT);
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 11);
				{
				setState(2189);
				match(INTEGER);
				}
				break;
			case INT8:
				enterOuterAlt(_localctx, 12);
				{
				setState(2190);
				match(INT8);
				}
				break;
			case BIGINT:
				enterOuterAlt(_localctx, 13);
				{
				setState(2191);
				match(BIGINT);
				}
				break;
			case SIGNED_PACKED_DECIMAL:
				enterOuterAlt(_localctx, 14);
				{
				setState(2192);
				match(SIGNED_PACKED_DECIMAL);
				{
				setState(2193);
				precision_param();
				}
				}
				break;
			case EBCDIC_SIGNED_ZONED_DECIMAL:
				enterOuterAlt(_localctx, 15);
				{
				setState(2194);
				match(EBCDIC_SIGNED_ZONED_DECIMAL);
				{
				setState(2195);
				precision_param();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Approximate_numeric_typeContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(SQLParser.FLOAT, 0); }
		public Precision_paramContext precision_param() {
			return getRuleContext(Precision_paramContext.class,0);
		}
		public TerminalNode FLOAT4() { return getToken(SQLParser.FLOAT4, 0); }
		public TerminalNode REAL() { return getToken(SQLParser.REAL, 0); }
		public TerminalNode FLOAT8() { return getToken(SQLParser.FLOAT8, 0); }
		public TerminalNode DOUBLE() { return getToken(SQLParser.DOUBLE, 0); }
		public TerminalNode PRECISION() { return getToken(SQLParser.PRECISION, 0); }
		public Approximate_numeric_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_approximate_numeric_type; }
	}

	public final Approximate_numeric_typeContext approximate_numeric_type() throws RecognitionException {
		Approximate_numeric_typeContext _localctx = new Approximate_numeric_typeContext(_ctx, getState());
		enterRule(_localctx, 308, RULE_approximate_numeric_type);
		int _la;
		try {
			setState(2208);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,236,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2198);
				match(FLOAT);
				setState(2200);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2199);
					precision_param();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2202);
				match(FLOAT4);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2203);
				match(REAL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2204);
				match(FLOAT8);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2205);
				match(DOUBLE);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2206);
				match(DOUBLE);
				setState(2207);
				match(PRECISION);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Precision_paramContext extends ParserRuleContext {
		public Token precision;
		public Token scale;
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(SQLParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(SQLParser.NUMBER, i);
		}
		public TerminalNode COMMA() { return getToken(SQLParser.COMMA, 0); }
		public Precision_paramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_precision_param; }
	}

	public final Precision_paramContext precision_param() throws RecognitionException {
		Precision_paramContext _localctx = new Precision_paramContext(_ctx, getState());
		enterRule(_localctx, 310, RULE_precision_param);
		try {
			setState(2218);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,237,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2210);
				match(LEFT_PAREN);
				setState(2211);
				((Precision_paramContext)_localctx).precision = match(NUMBER);
				setState(2212);
				match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2213);
				match(LEFT_PAREN);
				setState(2214);
				((Precision_paramContext)_localctx).precision = match(NUMBER);
				setState(2215);
				match(COMMA);
				setState(2216);
				((Precision_paramContext)_localctx).scale = match(NUMBER);
				setState(2217);
				match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Boolean_typeContext extends ParserRuleContext {
		public TerminalNode BOOLEAN() { return getToken(SQLParser.BOOLEAN, 0); }
		public TerminalNode BOOL() { return getToken(SQLParser.BOOL, 0); }
		public Boolean_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_type; }
	}

	public final Boolean_typeContext boolean_type() throws RecognitionException {
		Boolean_typeContext _localctx = new Boolean_typeContext(_ctx, getState());
		enterRule(_localctx, 312, RULE_boolean_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2220);
			_la = _input.LA(1);
			if ( !(_la==BOOLEAN || _la==BOOL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Datetime_typeContext extends ParserRuleContext {
		public TerminalNode DATE() { return getToken(SQLParser.DATE, 0); }
		public Type_lengthContext type_length() {
			return getRuleContext(Type_lengthContext.class,0);
		}
		public TerminalNode DATETIME() { return getToken(SQLParser.DATETIME, 0); }
		public TerminalNode INTERVAL() { return getToken(SQLParser.INTERVAL, 0); }
		public List<TerminalNode> TIME() { return getTokens(SQLParser.TIME); }
		public TerminalNode TIME(int i) {
			return getToken(SQLParser.TIME, i);
		}
		public TerminalNode WITH() { return getToken(SQLParser.WITH, 0); }
		public TerminalNode ZONE() { return getToken(SQLParser.ZONE, 0); }
		public TerminalNode TIMETZ() { return getToken(SQLParser.TIMETZ, 0); }
		public TerminalNode TIMESTAMP() { return getToken(SQLParser.TIMESTAMP, 0); }
		public TerminalNode TIMESTAMPTZ() { return getToken(SQLParser.TIMESTAMPTZ, 0); }
		public Datetime_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datetime_type; }
	}

	public final Datetime_typeContext datetime_type() throws RecognitionException {
		Datetime_typeContext _localctx = new Datetime_typeContext(_ctx, getState());
		enterRule(_localctx, 314, RULE_datetime_type);
		int _la;
		try {
			setState(2243);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,240,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2222);
				match(DATE);
				setState(2224);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2223);
					type_length();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2226);
				match(DATETIME);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2227);
				match(INTERVAL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2228);
				match(TIME);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2229);
				match(TIME);
				setState(2230);
				match(WITH);
				setState(2231);
				match(TIME);
				setState(2232);
				match(ZONE);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2233);
				match(TIMETZ);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2234);
				match(TIMESTAMP);
				setState(2236);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2235);
					type_length();
					}
				}

				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(2238);
				match(TIMESTAMP);
				setState(2239);
				match(WITH);
				setState(2240);
				match(TIME);
				setState(2241);
				match(ZONE);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(2242);
				match(TIMESTAMPTZ);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Bit_typeContext extends ParserRuleContext {
		public TerminalNode BIT() { return getToken(SQLParser.BIT, 0); }
		public Type_lengthContext type_length() {
			return getRuleContext(Type_lengthContext.class,0);
		}
		public TerminalNode VARBIT() { return getToken(SQLParser.VARBIT, 0); }
		public TerminalNode VARYING() { return getToken(SQLParser.VARYING, 0); }
		public Bit_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bit_type; }
	}

	public final Bit_typeContext bit_type() throws RecognitionException {
		Bit_typeContext _localctx = new Bit_typeContext(_ctx, getState());
		enterRule(_localctx, 316, RULE_bit_type);
		int _la;
		try {
			setState(2258);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,244,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2245);
				match(BIT);
				setState(2247);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2246);
					type_length();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2249);
				match(VARBIT);
				setState(2251);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2250);
					type_length();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2253);
				match(BIT);
				setState(2254);
				match(VARYING);
				setState(2256);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2255);
					type_length();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Binary_typeContext extends ParserRuleContext {
		public TerminalNode BINARY() { return getToken(SQLParser.BINARY, 0); }
		public Type_lengthContext type_length() {
			return getRuleContext(Type_lengthContext.class,0);
		}
		public TerminalNode VARYING() { return getToken(SQLParser.VARYING, 0); }
		public TerminalNode VARBINARY() { return getToken(SQLParser.VARBINARY, 0); }
		public Binary_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_type; }
	}

	public final Binary_typeContext binary_type() throws RecognitionException {
		Binary_typeContext _localctx = new Binary_typeContext(_ctx, getState());
		enterRule(_localctx, 318, RULE_binary_type);
		int _la;
		try {
			setState(2273);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,248,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2260);
				match(BINARY);
				setState(2262);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2261);
					type_length();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2264);
				match(BINARY);
				setState(2265);
				match(VARYING);
				setState(2267);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2266);
					type_length();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2269);
				match(VARBINARY);
				setState(2271);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(2270);
					type_length();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Value_expression_primaryContext extends ParserRuleContext {
		public Parenthesized_value_expressionContext parenthesized_value_expression() {
			return getRuleContext(Parenthesized_value_expressionContext.class,0);
		}
		public Nonparenthesized_value_expression_primaryContext nonparenthesized_value_expression_primary() {
			return getRuleContext(Nonparenthesized_value_expression_primaryContext.class,0);
		}
		public Value_expression_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_expression_primary; }
	}

	public final Value_expression_primaryContext value_expression_primary() throws RecognitionException {
		Value_expression_primaryContext _localctx = new Value_expression_primaryContext(_ctx, getState());
		enterRule(_localctx, 320, RULE_value_expression_primary);
		try {
			setState(2277);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,249,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2275);
				parenthesized_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2276);
				nonparenthesized_value_expression_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Parenthesized_value_expressionContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Value_expressionContext value_expression() {
			return getRuleContext(Value_expressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public Parenthesized_value_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parenthesized_value_expression; }
	}

	public final Parenthesized_value_expressionContext parenthesized_value_expression() throws RecognitionException {
		Parenthesized_value_expressionContext _localctx = new Parenthesized_value_expressionContext(_ctx, getState());
		enterRule(_localctx, 322, RULE_parenthesized_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2279);
			match(LEFT_PAREN);
			setState(2280);
			value_expression();
			setState(2281);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Nonparenthesized_value_expression_primaryContext extends ParserRuleContext {
		public Unsigned_value_specificationContext unsigned_value_specification() {
			return getRuleContext(Unsigned_value_specificationContext.class,0);
		}
		public Column_referenceContext column_reference() {
			return getRuleContext(Column_referenceContext.class,0);
		}
		public Set_function_specificationContext set_function_specification() {
			return getRuleContext(Set_function_specificationContext.class,0);
		}
		public Window_functionContext window_function() {
			return getRuleContext(Window_functionContext.class,0);
		}
		public Listagg_functionContext listagg_function() {
			return getRuleContext(Listagg_functionContext.class,0);
		}
		public Case_expressionContext case_expression() {
			return getRuleContext(Case_expressionContext.class,0);
		}
		public Case_abbreviationContext case_abbreviation() {
			return getRuleContext(Case_abbreviationContext.class,0);
		}
		public Cast_specificationContext cast_specification() {
			return getRuleContext(Cast_specificationContext.class,0);
		}
		public Convert_specificationContext convert_specification() {
			return getRuleContext(Convert_specificationContext.class,0);
		}
		public Routine_invocationContext routine_invocation() {
			return getRuleContext(Routine_invocationContext.class,0);
		}
		public Scalar_subqueryContext scalar_subquery() {
			return getRuleContext(Scalar_subqueryContext.class,0);
		}
		public Cursor_functionContext cursor_function() {
			return getRuleContext(Cursor_functionContext.class,0);
		}
		public Nonparenthesized_value_expression_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonparenthesized_value_expression_primary; }
	}

	public final Nonparenthesized_value_expression_primaryContext nonparenthesized_value_expression_primary() throws RecognitionException {
		Nonparenthesized_value_expression_primaryContext _localctx = new Nonparenthesized_value_expression_primaryContext(_ctx, getState());
		enterRule(_localctx, 324, RULE_nonparenthesized_value_expression_primary);
		try {
			setState(2295);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,250,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2283);
				unsigned_value_specification();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2284);
				column_reference();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2285);
				set_function_specification();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2286);
				window_function();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2287);
				listagg_function();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2288);
				case_expression();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2289);
				case_abbreviation();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(2290);
				cast_specification();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(2291);
				convert_specification();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(2292);
				routine_invocation();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(2293);
				scalar_subquery();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(2294);
				cursor_function();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Unsigned_value_specificationContext extends ParserRuleContext {
		public Unsigned_literalContext unsigned_literal() {
			return getRuleContext(Unsigned_literalContext.class,0);
		}
		public Unsigned_value_specificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsigned_value_specification; }
	}

	public final Unsigned_value_specificationContext unsigned_value_specification() throws RecognitionException {
		Unsigned_value_specificationContext _localctx = new Unsigned_value_specificationContext(_ctx, getState());
		enterRule(_localctx, 326, RULE_unsigned_value_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2297);
			unsigned_literal();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Unsigned_numeric_literalContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(SQLParser.NUMBER, 0); }
		public TerminalNode REAL_NUMBER() { return getToken(SQLParser.REAL_NUMBER, 0); }
		public Unsigned_numeric_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsigned_numeric_literal; }
	}

	public final Unsigned_numeric_literalContext unsigned_numeric_literal() throws RecognitionException {
		Unsigned_numeric_literalContext _localctx = new Unsigned_numeric_literalContext(_ctx, getState());
		enterRule(_localctx, 328, RULE_unsigned_numeric_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2299);
			_la = _input.LA(1);
			if ( !(_la==NUMBER || _la==REAL_NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Signed_numerical_literalContext extends ParserRuleContext {
		public Unsigned_numeric_literalContext unsigned_numeric_literal() {
			return getRuleContext(Unsigned_numeric_literalContext.class,0);
		}
		public SignContext sign() {
			return getRuleContext(SignContext.class,0);
		}
		public Signed_numerical_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signed_numerical_literal; }
	}

	public final Signed_numerical_literalContext signed_numerical_literal() throws RecognitionException {
		Signed_numerical_literalContext _localctx = new Signed_numerical_literalContext(_ctx, getState());
		enterRule(_localctx, 330, RULE_signed_numerical_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2302);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(2301);
				sign();
				}
			}

			setState(2304);
			unsigned_numeric_literal();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Set_function_specificationContext extends ParserRuleContext {
		public Aggregate_functionContext aggregate_function() {
			return getRuleContext(Aggregate_functionContext.class,0);
		}
		public Set_function_specificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set_function_specification; }
	}

	public final Set_function_specificationContext set_function_specification() throws RecognitionException {
		Set_function_specificationContext _localctx = new Set_function_specificationContext(_ctx, getState());
		enterRule(_localctx, 332, RULE_set_function_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2306);
			aggregate_function();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Aggregate_functionContext extends ParserRuleContext {
		public TerminalNode COUNT() { return getToken(SQLParser.COUNT, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public TerminalNode MULTIPLY() { return getToken(SQLParser.MULTIPLY, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public General_set_functionContext general_set_function() {
			return getRuleContext(General_set_functionContext.class,0);
		}
		public Filter_clauseContext filter_clause() {
			return getRuleContext(Filter_clauseContext.class,0);
		}
		public Aggregate_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregate_function; }
	}

	public final Aggregate_functionContext aggregate_function() throws RecognitionException {
		Aggregate_functionContext _localctx = new Aggregate_functionContext(_ctx, getState());
		enterRule(_localctx, 334, RULE_aggregate_function);
		try {
			setState(2316);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,253,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2308);
				match(COUNT);
				setState(2309);
				match(LEFT_PAREN);
				setState(2310);
				match(MULTIPLY);
				setState(2311);
				match(RIGHT_PAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2312);
				general_set_function();
				setState(2314);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,252,_ctx) ) {
				case 1:
					{
					setState(2313);
					filter_clause();
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class General_set_functionContext extends ParserRuleContext {
		public Set_function_typeContext set_function_type() {
			return getRuleContext(Set_function_typeContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Value_expressionContext value_expression() {
			return getRuleContext(Value_expressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public Set_qualifierContext set_qualifier() {
			return getRuleContext(Set_qualifierContext.class,0);
		}
		public General_set_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_general_set_function; }
	}

	public final General_set_functionContext general_set_function() throws RecognitionException {
		General_set_functionContext _localctx = new General_set_functionContext(_ctx, getState());
		enterRule(_localctx, 336, RULE_general_set_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2318);
			set_function_type();
			setState(2319);
			match(LEFT_PAREN);
			setState(2321);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ALL || _la==DISTINCT) {
				{
				setState(2320);
				set_qualifier();
				}
			}

			setState(2323);
			value_expression();
			setState(2324);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Set_function_typeContext extends ParserRuleContext {
		public TerminalNode AVG() { return getToken(SQLParser.AVG, 0); }
		public TerminalNode MAX() { return getToken(SQLParser.MAX, 0); }
		public TerminalNode MIN() { return getToken(SQLParser.MIN, 0); }
		public TerminalNode SUM() { return getToken(SQLParser.SUM, 0); }
		public TerminalNode EVERY() { return getToken(SQLParser.EVERY, 0); }
		public TerminalNode ANY() { return getToken(SQLParser.ANY, 0); }
		public TerminalNode SOME() { return getToken(SQLParser.SOME, 0); }
		public TerminalNode COUNT() { return getToken(SQLParser.COUNT, 0); }
		public TerminalNode STDDEV_POP() { return getToken(SQLParser.STDDEV_POP, 0); }
		public TerminalNode STDDEV_SAMP() { return getToken(SQLParser.STDDEV_SAMP, 0); }
		public TerminalNode VAR_SAMP() { return getToken(SQLParser.VAR_SAMP, 0); }
		public TerminalNode VAR_POP() { return getToken(SQLParser.VAR_POP, 0); }
		public TerminalNode COLLECT() { return getToken(SQLParser.COLLECT, 0); }
		public TerminalNode FUSION() { return getToken(SQLParser.FUSION, 0); }
		public TerminalNode INTERSECTION() { return getToken(SQLParser.INTERSECTION, 0); }
		public Set_function_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set_function_type; }
	}

	public final Set_function_typeContext set_function_type() throws RecognitionException {
		Set_function_typeContext _localctx = new Set_function_typeContext(_ctx, getState());
		enterRule(_localctx, 338, RULE_set_function_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2326);
			_la = _input.LA(1);
			if ( !(_la==ANY || _la==SOME || ((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & 577028101377102337L) != 0) || ((((_la - 142)) & ~0x3f) == 0 && ((1L << (_la - 142)) & 105559021846529L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Filter_clauseContext extends ParserRuleContext {
		public TerminalNode KEEP() { return getToken(SQLParser.KEEP, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public TerminalNode DENSE_RANK() { return getToken(SQLParser.DENSE_RANK, 0); }
		public Orderby_clauseContext orderby_clause() {
			return getRuleContext(Orderby_clauseContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode FIRST() { return getToken(SQLParser.FIRST, 0); }
		public TerminalNode LAST() { return getToken(SQLParser.LAST, 0); }
		public Filter_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filter_clause; }
	}

	public final Filter_clauseContext filter_clause() throws RecognitionException {
		Filter_clauseContext _localctx = new Filter_clauseContext(_ctx, getState());
		enterRule(_localctx, 340, RULE_filter_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2328);
			match(KEEP);
			setState(2329);
			match(LEFT_PAREN);
			setState(2330);
			match(DENSE_RANK);
			setState(2331);
			_la = _input.LA(1);
			if ( !(_la==FIRST || _la==LAST) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(2332);
			orderby_clause();
			setState(2333);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Grouping_operationContext extends ParserRuleContext {
		public TerminalNode GROUPING() { return getToken(SQLParser.GROUPING, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Column_reference_listContext column_reference_list() {
			return getRuleContext(Column_reference_listContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public Grouping_operationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grouping_operation; }
	}

	public final Grouping_operationContext grouping_operation() throws RecognitionException {
		Grouping_operationContext _localctx = new Grouping_operationContext(_ctx, getState());
		enterRule(_localctx, 342, RULE_grouping_operation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2335);
			match(GROUPING);
			setState(2336);
			match(LEFT_PAREN);
			setState(2337);
			column_reference_list();
			setState(2338);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Listagg_functionContext extends ParserRuleContext {
		public TerminalNode LISTAGG() { return getToken(SQLParser.LISTAGG, 0); }
		public List<TerminalNode> LEFT_PAREN() { return getTokens(SQLParser.LEFT_PAREN); }
		public TerminalNode LEFT_PAREN(int i) {
			return getToken(SQLParser.LEFT_PAREN, i);
		}
		public List<Value_expressionContext> value_expression() {
			return getRuleContexts(Value_expressionContext.class);
		}
		public Value_expressionContext value_expression(int i) {
			return getRuleContext(Value_expressionContext.class,i);
		}
		public List<TerminalNode> RIGHT_PAREN() { return getTokens(SQLParser.RIGHT_PAREN); }
		public TerminalNode RIGHT_PAREN(int i) {
			return getToken(SQLParser.RIGHT_PAREN, i);
		}
		public TerminalNode WITHIN_GROUP() { return getToken(SQLParser.WITHIN_GROUP, 0); }
		public Orderby_clauseContext orderby_clause() {
			return getRuleContext(Orderby_clauseContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(SQLParser.COMMA, 0); }
		public TerminalNode OVER() { return getToken(SQLParser.OVER, 0); }
		public Window_name_or_specificationContext window_name_or_specification() {
			return getRuleContext(Window_name_or_specificationContext.class,0);
		}
		public Listagg_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listagg_function; }
	}

	public final Listagg_functionContext listagg_function() throws RecognitionException {
		Listagg_functionContext _localctx = new Listagg_functionContext(_ctx, getState());
		enterRule(_localctx, 344, RULE_listagg_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2340);
			match(LISTAGG);
			setState(2341);
			match(LEFT_PAREN);
			setState(2342);
			value_expression();
			setState(2345);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(2343);
				match(COMMA);
				setState(2344);
				value_expression();
				}
			}

			setState(2347);
			match(RIGHT_PAREN);
			setState(2348);
			match(WITHIN_GROUP);
			setState(2349);
			match(LEFT_PAREN);
			setState(2350);
			orderby_clause();
			setState(2351);
			match(RIGHT_PAREN);
			setState(2354);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OVER) {
				{
				setState(2352);
				match(OVER);
				setState(2353);
				window_name_or_specification();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Window_functionContext extends ParserRuleContext {
		public Window_function_typeContext window_function_type() {
			return getRuleContext(Window_function_typeContext.class,0);
		}
		public TerminalNode OVER() { return getToken(SQLParser.OVER, 0); }
		public Window_name_or_specificationContext window_name_or_specification() {
			return getRuleContext(Window_name_or_specificationContext.class,0);
		}
		public Window_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_window_function; }
	}

	public final Window_functionContext window_function() throws RecognitionException {
		Window_functionContext _localctx = new Window_functionContext(_ctx, getState());
		enterRule(_localctx, 346, RULE_window_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2356);
			window_function_type();
			setState(2357);
			match(OVER);
			setState(2358);
			window_name_or_specification();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Window_function_nulls_clauseContext extends ParserRuleContext {
		public TerminalNode IGNORE_NULLS() { return getToken(SQLParser.IGNORE_NULLS, 0); }
		public TerminalNode RESPECT_NULLS() { return getToken(SQLParser.RESPECT_NULLS, 0); }
		public Window_function_nulls_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_window_function_nulls_clause; }
	}

	public final Window_function_nulls_clauseContext window_function_nulls_clause() throws RecognitionException {
		Window_function_nulls_clauseContext _localctx = new Window_function_nulls_clauseContext(_ctx, getState());
		enterRule(_localctx, 348, RULE_window_function_nulls_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2360);
			_la = _input.LA(1);
			if ( !(_la==IGNORE_NULLS || _la==RESPECT_NULLS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Window_function_typeContext extends ParserRuleContext {
		public Rank_function_typeContext rank_function_type() {
			return getRuleContext(Rank_function_typeContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode ROW_NUMBER() { return getToken(SQLParser.ROW_NUMBER, 0); }
		public Aggregate_functionContext aggregate_function() {
			return getRuleContext(Aggregate_functionContext.class,0);
		}
		public TerminalNode FIRST_VALUE() { return getToken(SQLParser.FIRST_VALUE, 0); }
		public Value_expressionContext value_expression() {
			return getRuleContext(Value_expressionContext.class,0);
		}
		public Window_function_nulls_clauseContext window_function_nulls_clause() {
			return getRuleContext(Window_function_nulls_clauseContext.class,0);
		}
		public TerminalNode LAST_VALUE() { return getToken(SQLParser.LAST_VALUE, 0); }
		public TerminalNode LAG() { return getToken(SQLParser.LAG, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Numeric_value_expressionContext numeric_value_expression() {
			return getRuleContext(Numeric_value_expressionContext.class,0);
		}
		public Common_value_expressionContext common_value_expression() {
			return getRuleContext(Common_value_expressionContext.class,0);
		}
		public TerminalNode LEAD() { return getToken(SQLParser.LEAD, 0); }
		public Window_function_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_window_function_type; }
	}

	public final Window_function_typeContext window_function_type() throws RecognitionException {
		Window_function_typeContext _localctx = new Window_function_typeContext(_ctx, getState());
		enterRule(_localctx, 350, RULE_window_function_type);
		int _la;
		try {
			setState(2412);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CUME_DIST:
			case DENSE_RANK:
			case PERCENT_RANK:
			case RANK:
				enterOuterAlt(_localctx, 1);
				{
				setState(2362);
				rank_function_type();
				setState(2363);
				match(LEFT_PAREN);
				setState(2364);
				match(RIGHT_PAREN);
				}
				break;
			case ROW_NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(2366);
				match(ROW_NUMBER);
				setState(2367);
				match(LEFT_PAREN);
				setState(2368);
				match(RIGHT_PAREN);
				}
				break;
			case ANY:
			case SOME:
			case AVG:
			case COLLECT:
			case COUNT:
			case EVERY:
			case FUSION:
			case INTERSECTION:
			case MAX:
			case MIN:
			case STDDEV_POP:
			case STDDEV_SAMP:
			case SUM:
			case VAR_SAMP:
			case VAR_POP:
				enterOuterAlt(_localctx, 3);
				{
				setState(2369);
				aggregate_function();
				}
				break;
			case FIRST_VALUE:
				enterOuterAlt(_localctx, 4);
				{
				setState(2370);
				match(FIRST_VALUE);
				setState(2371);
				match(LEFT_PAREN);
				setState(2372);
				value_expression();
				setState(2374);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IGNORE_NULLS || _la==RESPECT_NULLS) {
					{
					setState(2373);
					window_function_nulls_clause();
					}
				}

				setState(2376);
				match(RIGHT_PAREN);
				}
				break;
			case LAST_VALUE:
				enterOuterAlt(_localctx, 5);
				{
				setState(2378);
				match(LAST_VALUE);
				setState(2379);
				match(LEFT_PAREN);
				setState(2380);
				value_expression();
				setState(2382);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IGNORE_NULLS || _la==RESPECT_NULLS) {
					{
					setState(2381);
					window_function_nulls_clause();
					}
				}

				setState(2384);
				match(RIGHT_PAREN);
				}
				break;
			case LAG:
				enterOuterAlt(_localctx, 6);
				{
				setState(2386);
				match(LAG);
				setState(2387);
				match(LEFT_PAREN);
				setState(2388);
				value_expression();
				setState(2395);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(2389);
					match(COMMA);
					setState(2390);
					numeric_value_expression();
					setState(2393);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(2391);
						match(COMMA);
						setState(2392);
						common_value_expression();
						}
					}

					}
				}

				setState(2397);
				match(RIGHT_PAREN);
				}
				break;
			case LEAD:
				enterOuterAlt(_localctx, 7);
				{
				setState(2399);
				match(LEAD);
				setState(2400);
				match(LEFT_PAREN);
				setState(2401);
				value_expression();
				setState(2408);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(2402);
					match(COMMA);
					setState(2403);
					numeric_value_expression();
					setState(2406);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(2404);
						match(COMMA);
						setState(2405);
						common_value_expression();
						}
					}

					}
				}

				setState(2410);
				match(RIGHT_PAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Rank_function_typeContext extends ParserRuleContext {
		public TerminalNode RANK() { return getToken(SQLParser.RANK, 0); }
		public TerminalNode DENSE_RANK() { return getToken(SQLParser.DENSE_RANK, 0); }
		public TerminalNode PERCENT_RANK() { return getToken(SQLParser.PERCENT_RANK, 0); }
		public TerminalNode CUME_DIST() { return getToken(SQLParser.CUME_DIST, 0); }
		public Rank_function_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rank_function_type; }
	}

	public final Rank_function_typeContext rank_function_type() throws RecognitionException {
		Rank_function_typeContext _localctx = new Rank_function_typeContext(_ctx, getState());
		enterRule(_localctx, 352, RULE_rank_function_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2414);
			_la = _input.LA(1);
			if ( !(((((_la - 92)) & ~0x3f) == 0 && ((1L << (_la - 92)) & 1152921504606849025L) != 0) || _la==RANK) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Window_name_or_specificationContext extends ParserRuleContext {
		public Window_nameContext window_name() {
			return getRuleContext(Window_nameContext.class,0);
		}
		public Window_specificationContext window_specification() {
			return getRuleContext(Window_specificationContext.class,0);
		}
		public Window_name_or_specificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_window_name_or_specification; }
	}

	public final Window_name_or_specificationContext window_name_or_specification() throws RecognitionException {
		Window_name_or_specificationContext _localctx = new Window_name_or_specificationContext(_ctx, getState());
		enterRule(_localctx, 354, RULE_window_name_or_specification);
		try {
			setState(2418);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ASYMMETRIC:
			case BOTH:
			case CROSS:
			case CURRENT_DATE:
			case CURRENT_TIME:
			case CURRENT_TIMESTAMP:
			case DATASET:
			case FULL:
			case GROUP:
			case LIMIT:
			case MAPPING:
			case NATURAL:
			case ORDER:
			case PACKAGE:
			case PROCEDURE:
			case PROJECT:
			case REUSABLE:
			case SYMMETRIC:
			case SCENARIO:
			case TRAILING:
			case WINDOW:
			case VARIABLE:
			case POSITION:
			case OFFSET:
			case IKM:
			case LKM:
			case CKM:
			case TECHNOLOGY:
			case DESCRIPTION:
			case AVG:
			case ADD:
			case ALTER:
			case BETWEEN:
			case BY:
			case CATALOG:
			case CENTURY:
			case CHARACTER:
			case COLLECT:
			case COALESCE:
			case COLUMN:
			case COUNT:
			case CUBE:
			case CUME_DIST:
			case CURRENT:
			case STRING:
			case DAY:
			case DEFAULT:
			case DATABASE:
			case DEC:
			case DECADE:
			case DENSE_RANK:
			case DOW:
			case DOY:
			case DROP:
			case EPOCH:
			case EVERY:
			case EXCLUDE:
			case EXISTS:
			case EXPLAIN:
			case EXTERNAL:
			case EXTRACT:
			case FILTER:
			case FIRST:
			case FIRST_VALUE:
			case FOLLOWING:
			case FORMAT:
			case FUSION:
			case GROUPING:
			case HASH:
			case INDEX:
			case INSERT:
			case INTERSECTION:
			case ISODOW:
			case ISOYEAR:
			case LAG:
			case LAST:
			case LAST_VALUE:
			case LESS:
			case LIST:
			case LOCATION:
			case MAX:
			case MAXVALUE:
			case MICROSECONDS:
			case MILLENNIUM:
			case MILLISECONDS:
			case MIN:
			case MINUTE:
			case MONTH:
			case NATIONAL:
			case NULLIF:
			case NO:
			case OVERWRITE:
			case OTHERS:
			case PARTITION:
			case PARTITIONS:
			case PERCENT_RANK:
			case PRECEDING:
			case PRECISION:
			case PURGE:
			case QUARTER:
			case RANGE:
			case RANK:
			case REGEXP:
			case RENAME:
			case RESET:
			case RLIKE:
			case ROLLUP:
			case ROW:
			case ROWS:
			case ROW_NUMBER:
			case SECOND:
			case SESSION:
			case SET:
			case SIMILAR:
			case STDDEV_POP:
			case STDDEV_SAMP:
			case SUBPARTITION:
			case SUM:
			case TABLESPACE:
			case THAN:
			case TIES:
			case TIMEZONE:
			case TIMEZONE_HOUR:
			case TIMEZONE_MINUTE:
			case TRIM:
			case TO:
			case UNBOUNDED:
			case UNKNOWN:
			case VALUES:
			case VAR_SAMP:
			case VAR_POP:
			case VARYING:
			case WEEK:
			case YEAR:
			case ZONE:
			case BOOLEAN:
			case BOOL:
			case BIT:
			case VARBIT:
			case INT1:
			case INT2:
			case INT4:
			case INT8:
			case TINYINT:
			case SMALLINT:
			case INT:
			case INTEGER:
			case BIGINT:
			case FLOAT4:
			case FLOAT8:
			case REAL:
			case FLOAT:
			case DOUBLE:
			case NUMERIC:
			case ORANUMBER:
			case DECIMAL:
			case CHAR:
			case VARCHAR2:
			case VARCHAR:
			case NCHAR:
			case NVARCHAR:
			case DATE:
			case INTERVAL:
			case TIME:
			case TIMETZ:
			case TIMESTAMP:
			case TIMESTAMPTZ:
			case TEXT:
			case BINARY:
			case VARBINARY:
			case BLOB:
			case BYTEA:
			case INET4:
			case REAL_NUMBER:
			case DATASTORE:
			case ALIAS:
			case RESOURCE:
			case FILE:
			case HEADING:
			case FIXED:
			case SCD:
			case MODEL:
			case FOLDER:
			case SUBMODEL:
			case REPLACE:
			case CONTEXT:
			case XKM:
			case SEQUENCEFILE:
			case FIELDS:
			case TERMINATED:
			case SERDE:
			case SERDEPROPERTIES:
			case TEXTFILE:
			case RCFILE:
			case ORC:
			case PARQUET:
			case AVRO:
			case INPUTFORMAT:
			case OUTPUTFORMAT:
			case TEMPORARY:
			case TBLPROPERTIES:
			case REJECT:
			case PERCENT:
			case SUCCESS:
			case TYPE:
			case ODI:
			case CONTROL:
			case FLOW:
			case STATIC:
			case ACTIVE:
			case MESSAGE:
			case KEEP:
			case PIVOT:
			case UNPIVOT:
			case Regular_Identifier:
			case Quoted_Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(2416);
				window_name();
				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(2417);
				window_specification();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Case_expressionContext extends ParserRuleContext {
		public Case_specificationContext case_specification() {
			return getRuleContext(Case_specificationContext.class,0);
		}
		public Case_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_expression; }
	}

	public final Case_expressionContext case_expression() throws RecognitionException {
		Case_expressionContext _localctx = new Case_expressionContext(_ctx, getState());
		enterRule(_localctx, 356, RULE_case_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2420);
			case_specification();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Case_abbreviationContext extends ParserRuleContext {
		public TerminalNode NULLIF() { return getToken(SQLParser.NULLIF, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public List<Value_expressionContext> value_expression() {
			return getRuleContexts(Value_expressionContext.class);
		}
		public Value_expressionContext value_expression(int i) {
			return getRuleContext(Value_expressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode COALESCE() { return getToken(SQLParser.COALESCE, 0); }
		public Case_abbreviationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_abbreviation; }
	}

	public final Case_abbreviationContext case_abbreviation() throws RecognitionException {
		Case_abbreviationContext _localctx = new Case_abbreviationContext(_ctx, getState());
		enterRule(_localctx, 358, RULE_case_abbreviation);
		int _la;
		try {
			setState(2440);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NULLIF:
				enterOuterAlt(_localctx, 1);
				{
				setState(2422);
				match(NULLIF);
				setState(2423);
				match(LEFT_PAREN);
				setState(2424);
				value_expression();
				setState(2425);
				match(COMMA);
				setState(2426);
				value_expression();
				setState(2427);
				match(RIGHT_PAREN);
				}
				break;
			case COALESCE:
				enterOuterAlt(_localctx, 2);
				{
				setState(2429);
				match(COALESCE);
				setState(2430);
				match(LEFT_PAREN);
				setState(2431);
				value_expression();
				setState(2434); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2432);
					match(COMMA);
					setState(2433);
					value_expression();
					}
					}
					setState(2436); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				setState(2438);
				match(RIGHT_PAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Case_specificationContext extends ParserRuleContext {
		public Simple_caseContext simple_case() {
			return getRuleContext(Simple_caseContext.class,0);
		}
		public Searched_caseContext searched_case() {
			return getRuleContext(Searched_caseContext.class,0);
		}
		public Case_specificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_specification; }
	}

	public final Case_specificationContext case_specification() throws RecognitionException {
		Case_specificationContext _localctx = new Case_specificationContext(_ctx, getState());
		enterRule(_localctx, 360, RULE_case_specification);
		try {
			setState(2444);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,267,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2442);
				simple_case();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2443);
				searched_case();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Simple_caseContext extends ParserRuleContext {
		public TerminalNode CASE() { return getToken(SQLParser.CASE, 0); }
		public Boolean_value_expressionContext boolean_value_expression() {
			return getRuleContext(Boolean_value_expressionContext.class,0);
		}
		public TerminalNode END() { return getToken(SQLParser.END, 0); }
		public List<Simple_when_clauseContext> simple_when_clause() {
			return getRuleContexts(Simple_when_clauseContext.class);
		}
		public Simple_when_clauseContext simple_when_clause(int i) {
			return getRuleContext(Simple_when_clauseContext.class,i);
		}
		public Else_clauseContext else_clause() {
			return getRuleContext(Else_clauseContext.class,0);
		}
		public Simple_caseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_case; }
	}

	public final Simple_caseContext simple_case() throws RecognitionException {
		Simple_caseContext _localctx = new Simple_caseContext(_ctx, getState());
		enterRule(_localctx, 362, RULE_simple_case);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2446);
			match(CASE);
			setState(2447);
			boolean_value_expression();
			setState(2449); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(2448);
				simple_when_clause();
				}
				}
				setState(2451); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(2454);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(2453);
				else_clause();
				}
			}

			setState(2456);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Searched_caseContext extends ParserRuleContext {
		public TerminalNode CASE() { return getToken(SQLParser.CASE, 0); }
		public TerminalNode END() { return getToken(SQLParser.END, 0); }
		public List<Searched_when_clauseContext> searched_when_clause() {
			return getRuleContexts(Searched_when_clauseContext.class);
		}
		public Searched_when_clauseContext searched_when_clause(int i) {
			return getRuleContext(Searched_when_clauseContext.class,i);
		}
		public Else_clauseContext else_clause() {
			return getRuleContext(Else_clauseContext.class,0);
		}
		public Searched_caseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_searched_case; }
	}

	public final Searched_caseContext searched_case() throws RecognitionException {
		Searched_caseContext _localctx = new Searched_caseContext(_ctx, getState());
		enterRule(_localctx, 364, RULE_searched_case);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2458);
			match(CASE);
			setState(2460); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(2459);
				searched_when_clause();
				}
				}
				setState(2462); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WHEN );
			setState(2465);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(2464);
				else_clause();
				}
			}

			setState(2467);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Simple_when_clauseContext extends ParserRuleContext {
		public TerminalNode WHEN() { return getToken(SQLParser.WHEN, 0); }
		public Search_conditionContext search_condition() {
			return getRuleContext(Search_conditionContext.class,0);
		}
		public TerminalNode THEN() { return getToken(SQLParser.THEN, 0); }
		public ResultContext result() {
			return getRuleContext(ResultContext.class,0);
		}
		public Simple_when_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_when_clause; }
	}

	public final Simple_when_clauseContext simple_when_clause() throws RecognitionException {
		Simple_when_clauseContext _localctx = new Simple_when_clauseContext(_ctx, getState());
		enterRule(_localctx, 366, RULE_simple_when_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2469);
			match(WHEN);
			setState(2470);
			search_condition();
			setState(2471);
			match(THEN);
			setState(2472);
			result();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Searched_when_clauseContext extends ParserRuleContext {
		public Search_conditionContext c;
		public ResultContext r;
		public TerminalNode WHEN() { return getToken(SQLParser.WHEN, 0); }
		public TerminalNode THEN() { return getToken(SQLParser.THEN, 0); }
		public Search_conditionContext search_condition() {
			return getRuleContext(Search_conditionContext.class,0);
		}
		public ResultContext result() {
			return getRuleContext(ResultContext.class,0);
		}
		public Searched_when_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_searched_when_clause; }
	}

	public final Searched_when_clauseContext searched_when_clause() throws RecognitionException {
		Searched_when_clauseContext _localctx = new Searched_when_clauseContext(_ctx, getState());
		enterRule(_localctx, 368, RULE_searched_when_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2474);
			match(WHEN);
			setState(2475);
			((Searched_when_clauseContext)_localctx).c = search_condition();
			setState(2476);
			match(THEN);
			setState(2477);
			((Searched_when_clauseContext)_localctx).r = result();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Else_clauseContext extends ParserRuleContext {
		public ResultContext r;
		public TerminalNode ELSE() { return getToken(SQLParser.ELSE, 0); }
		public ResultContext result() {
			return getRuleContext(ResultContext.class,0);
		}
		public Else_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_clause; }
	}

	public final Else_clauseContext else_clause() throws RecognitionException {
		Else_clauseContext _localctx = new Else_clauseContext(_ctx, getState());
		enterRule(_localctx, 370, RULE_else_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2479);
			match(ELSE);
			setState(2480);
			((Else_clauseContext)_localctx).r = result();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ResultContext extends ParserRuleContext {
		public Value_expressionContext value_expression() {
			return getRuleContext(Value_expressionContext.class,0);
		}
		public TerminalNode NULL() { return getToken(SQLParser.NULL, 0); }
		public ResultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_result; }
	}

	public final ResultContext result() throws RecognitionException {
		ResultContext _localctx = new ResultContext(_ctx, getState());
		enterRule(_localctx, 372, RULE_result);
		try {
			setState(2484);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,272,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2482);
				value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2483);
				match(NULL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Cast_specificationContext extends ParserRuleContext {
		public TerminalNode CAST() { return getToken(SQLParser.CAST, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Cast_operandContext cast_operand() {
			return getRuleContext(Cast_operandContext.class,0);
		}
		public TerminalNode AS() { return getToken(SQLParser.AS, 0); }
		public Cast_targetContext cast_target() {
			return getRuleContext(Cast_targetContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public Cast_specificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cast_specification; }
	}

	public final Cast_specificationContext cast_specification() throws RecognitionException {
		Cast_specificationContext _localctx = new Cast_specificationContext(_ctx, getState());
		enterRule(_localctx, 374, RULE_cast_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2486);
			match(CAST);
			setState(2487);
			match(LEFT_PAREN);
			setState(2488);
			cast_operand();
			setState(2489);
			match(AS);
			setState(2490);
			cast_target();
			setState(2491);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Cast_operandContext extends ParserRuleContext {
		public Value_expressionContext value_expression() {
			return getRuleContext(Value_expressionContext.class,0);
		}
		public Cast_operandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cast_operand; }
	}

	public final Cast_operandContext cast_operand() throws RecognitionException {
		Cast_operandContext _localctx = new Cast_operandContext(_ctx, getState());
		enterRule(_localctx, 376, RULE_cast_operand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2493);
			value_expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Cast_targetContext extends ParserRuleContext {
		public Data_typeContext data_type() {
			return getRuleContext(Data_typeContext.class,0);
		}
		public Cast_targetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cast_target; }
	}

	public final Cast_targetContext cast_target() throws RecognitionException {
		Cast_targetContext _localctx = new Cast_targetContext(_ctx, getState());
		enterRule(_localctx, 378, RULE_cast_target);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2495);
			data_type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Convert_specificationContext extends ParserRuleContext {
		public Token style;
		public TerminalNode CONVERT() { return getToken(SQLParser.CONVERT, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Cast_targetContext cast_target() {
			return getRuleContext(Cast_targetContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Cast_operandContext cast_operand() {
			return getRuleContext(Cast_operandContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode NUMBER() { return getToken(SQLParser.NUMBER, 0); }
		public Convert_specificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_convert_specification; }
	}

	public final Convert_specificationContext convert_specification() throws RecognitionException {
		Convert_specificationContext _localctx = new Convert_specificationContext(_ctx, getState());
		enterRule(_localctx, 380, RULE_convert_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2497);
			match(CONVERT);
			setState(2498);
			match(LEFT_PAREN);
			setState(2499);
			cast_target();
			setState(2500);
			match(COMMA);
			setState(2501);
			cast_operand();
			setState(2504);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(2502);
				match(COMMA);
				setState(2503);
				((Convert_specificationContext)_localctx).style = match(NUMBER);
				}
			}

			setState(2506);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Value_expressionContext extends ParserRuleContext {
		public Common_value_expressionContext common_value_expression() {
			return getRuleContext(Common_value_expressionContext.class,0);
		}
		public Row_value_expressionContext row_value_expression() {
			return getRuleContext(Row_value_expressionContext.class,0);
		}
		public Boolean_value_expressionContext boolean_value_expression() {
			return getRuleContext(Boolean_value_expressionContext.class,0);
		}
		public Value_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_expression; }
	}

	public final Value_expressionContext value_expression() throws RecognitionException {
		Value_expressionContext _localctx = new Value_expressionContext(_ctx, getState());
		enterRule(_localctx, 382, RULE_value_expression);
		try {
			setState(2511);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,274,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2508);
				common_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2509);
				row_value_expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2510);
				boolean_value_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Common_value_expressionContext extends ParserRuleContext {
		public Numeric_value_expressionContext numeric_value_expression() {
			return getRuleContext(Numeric_value_expressionContext.class,0);
		}
		public Odi_variableContext odi_variable() {
			return getRuleContext(Odi_variableContext.class,0);
		}
		public Odi_variable_literalContext odi_variable_literal() {
			return getRuleContext(Odi_variable_literalContext.class,0);
		}
		public Odi_sequenceContext odi_sequence() {
			return getRuleContext(Odi_sequenceContext.class,0);
		}
		public String_value_expressionContext string_value_expression() {
			return getRuleContext(String_value_expressionContext.class,0);
		}
		public Datetime_value_expressionContext datetime_value_expression() {
			return getRuleContext(Datetime_value_expressionContext.class,0);
		}
		public TerminalNode ODIREF() { return getToken(SQLParser.ODIREF, 0); }
		public TerminalNode NULL() { return getToken(SQLParser.NULL, 0); }
		public Common_value_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_common_value_expression; }
	}

	public final Common_value_expressionContext common_value_expression() throws RecognitionException {
		Common_value_expressionContext _localctx = new Common_value_expressionContext(_ctx, getState());
		enterRule(_localctx, 384, RULE_common_value_expression);
		try {
			setState(2521);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,275,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2513);
				numeric_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2514);
				odi_variable();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2515);
				odi_variable_literal();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2516);
				odi_sequence();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2517);
				string_value_expression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2518);
				datetime_value_expression();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2519);
				match(ODIREF);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(2520);
				match(NULL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Numeric_value_expressionContext extends ParserRuleContext {
		public TermContext left;
		public TermContext right;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(SQLParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(SQLParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(SQLParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(SQLParser.MINUS, i);
		}
		public Numeric_value_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numeric_value_expression; }
	}

	public final Numeric_value_expressionContext numeric_value_expression() throws RecognitionException {
		Numeric_value_expressionContext _localctx = new Numeric_value_expressionContext(_ctx, getState());
		enterRule(_localctx, 386, RULE_numeric_value_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2523);
			((Numeric_value_expressionContext)_localctx).left = term();
			setState(2528);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(2524);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(2525);
				((Numeric_value_expressionContext)_localctx).right = term();
				}
				}
				setState(2530);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public FactorContext left;
		public FactorContext right;
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<TerminalNode> MULTIPLY() { return getTokens(SQLParser.MULTIPLY); }
		public TerminalNode MULTIPLY(int i) {
			return getToken(SQLParser.MULTIPLY, i);
		}
		public List<TerminalNode> DIVIDE() { return getTokens(SQLParser.DIVIDE); }
		public TerminalNode DIVIDE(int i) {
			return getToken(SQLParser.DIVIDE, i);
		}
		public List<TerminalNode> MODULAR() { return getTokens(SQLParser.MODULAR); }
		public TerminalNode MODULAR(int i) {
			return getToken(SQLParser.MODULAR, i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 388, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2531);
			((TermContext)_localctx).left = factor();
			setState(2536);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 252)) & ~0x3f) == 0 && ((1L << (_la - 252)) & 7L) != 0)) {
				{
				{
				setState(2532);
				_la = _input.LA(1);
				if ( !(((((_la - 252)) & ~0x3f) == 0 && ((1L << (_la - 252)) & 7L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(2533);
				((TermContext)_localctx).right = factor();
				}
				}
				setState(2538);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FactorContext extends ParserRuleContext {
		public Numeric_primaryContext numeric_primary() {
			return getRuleContext(Numeric_primaryContext.class,0);
		}
		public SignContext sign() {
			return getRuleContext(SignContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 390, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2540);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(2539);
				sign();
				}
			}

			setState(2542);
			numeric_primary();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public List<Numeric_value_expressionContext> numeric_value_expression() {
			return getRuleContexts(Numeric_value_expressionContext.class);
		}
		public Numeric_value_expressionContext numeric_value_expression(int i) {
			return getRuleContext(Numeric_value_expressionContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 392, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2544);
			match(LEFT_PAREN);
			setState(2545);
			numeric_value_expression();
			setState(2550);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2546);
				match(COMMA);
				setState(2547);
				numeric_value_expression();
				}
				}
				setState(2552);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2553);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Numeric_primaryContext extends ParserRuleContext {
		public Value_expression_primaryContext value_expression_primary() {
			return getRuleContext(Value_expression_primaryContext.class,0);
		}
		public List<TerminalNode> CAST_EXPRESSION() { return getTokens(SQLParser.CAST_EXPRESSION); }
		public TerminalNode CAST_EXPRESSION(int i) {
			return getToken(SQLParser.CAST_EXPRESSION, i);
		}
		public List<Cast_targetContext> cast_target() {
			return getRuleContexts(Cast_targetContext.class);
		}
		public Cast_targetContext cast_target(int i) {
			return getRuleContext(Cast_targetContext.class,i);
		}
		public Numeric_value_functionContext numeric_value_function() {
			return getRuleContext(Numeric_value_functionContext.class,0);
		}
		public Numeric_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numeric_primary; }
	}

	public final Numeric_primaryContext numeric_primary() throws RecognitionException {
		Numeric_primaryContext _localctx = new Numeric_primaryContext(_ctx, getState());
		enterRule(_localctx, 394, RULE_numeric_primary);
		int _la;
		try {
			setState(2564);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,281,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2555);
				value_expression_primary();
				setState(2560);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CAST_EXPRESSION) {
					{
					{
					setState(2556);
					match(CAST_EXPRESSION);
					setState(2557);
					cast_target();
					}
					}
					setState(2562);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2563);
				numeric_value_function();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SignContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(SQLParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(SQLParser.MINUS, 0); }
		public SignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sign; }
	}

	public final SignContext sign() throws RecognitionException {
		SignContext _localctx = new SignContext(_ctx, getState());
		enterRule(_localctx, 396, RULE_sign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2566);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Numeric_value_functionContext extends ParserRuleContext {
		public Extract_expressionContext extract_expression() {
			return getRuleContext(Extract_expressionContext.class,0);
		}
		public Numeric_value_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numeric_value_function; }
	}

	public final Numeric_value_functionContext numeric_value_function() throws RecognitionException {
		Numeric_value_functionContext _localctx = new Numeric_value_functionContext(_ctx, getState());
		enterRule(_localctx, 398, RULE_numeric_value_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2568);
			extract_expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Extract_expressionContext extends ParserRuleContext {
		public Extract_fieldContext extract_field_string;
		public TerminalNode EXTRACT() { return getToken(SQLParser.EXTRACT, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public TerminalNode FROM() { return getToken(SQLParser.FROM, 0); }
		public Extract_sourceContext extract_source() {
			return getRuleContext(Extract_sourceContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public Extract_fieldContext extract_field() {
			return getRuleContext(Extract_fieldContext.class,0);
		}
		public Extract_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extract_expression; }
	}

	public final Extract_expressionContext extract_expression() throws RecognitionException {
		Extract_expressionContext _localctx = new Extract_expressionContext(_ctx, getState());
		enterRule(_localctx, 400, RULE_extract_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2570);
			match(EXTRACT);
			setState(2571);
			match(LEFT_PAREN);
			setState(2572);
			((Extract_expressionContext)_localctx).extract_field_string = extract_field();
			setState(2573);
			match(FROM);
			setState(2574);
			extract_source();
			setState(2575);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Extract_fieldContext extends ParserRuleContext {
		public Primary_datetime_fieldContext primary_datetime_field() {
			return getRuleContext(Primary_datetime_fieldContext.class,0);
		}
		public Time_zone_fieldContext time_zone_field() {
			return getRuleContext(Time_zone_fieldContext.class,0);
		}
		public Extended_datetime_fieldContext extended_datetime_field() {
			return getRuleContext(Extended_datetime_fieldContext.class,0);
		}
		public Extract_fieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extract_field; }
	}

	public final Extract_fieldContext extract_field() throws RecognitionException {
		Extract_fieldContext _localctx = new Extract_fieldContext(_ctx, getState());
		enterRule(_localctx, 402, RULE_extract_field);
		try {
			setState(2580);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DAY:
			case HOUR:
			case MINUTE:
			case MONTH:
			case SECOND:
			case YEAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(2577);
				primary_datetime_field();
				}
				break;
			case TIMEZONE:
			case TIMEZONE_HOUR:
			case TIMEZONE_MINUTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(2578);
				time_zone_field();
				}
				break;
			case CENTURY:
			case DECADE:
			case DOW:
			case DOY:
			case EPOCH:
			case ISODOW:
			case ISOYEAR:
			case MICROSECONDS:
			case MILLENNIUM:
			case MILLISECONDS:
			case QUARTER:
			case WEEK:
				enterOuterAlt(_localctx, 3);
				{
				setState(2579);
				extended_datetime_field();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Time_zone_fieldContext extends ParserRuleContext {
		public TerminalNode TIMEZONE() { return getToken(SQLParser.TIMEZONE, 0); }
		public TerminalNode TIMEZONE_HOUR() { return getToken(SQLParser.TIMEZONE_HOUR, 0); }
		public TerminalNode TIMEZONE_MINUTE() { return getToken(SQLParser.TIMEZONE_MINUTE, 0); }
		public Time_zone_fieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_time_zone_field; }
	}

	public final Time_zone_fieldContext time_zone_field() throws RecognitionException {
		Time_zone_fieldContext _localctx = new Time_zone_fieldContext(_ctx, getState());
		enterRule(_localctx, 404, RULE_time_zone_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2582);
			_la = _input.LA(1);
			if ( !(((((_la - 178)) & ~0x3f) == 0 && ((1L << (_la - 178)) & 7L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Extract_sourceContext extends ParserRuleContext {
		public Datetime_value_expressionContext datetime_value_expression() {
			return getRuleContext(Datetime_value_expressionContext.class,0);
		}
		public Extract_sourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extract_source; }
	}

	public final Extract_sourceContext extract_source() throws RecognitionException {
		Extract_sourceContext _localctx = new Extract_sourceContext(_ctx, getState());
		enterRule(_localctx, 406, RULE_extract_source);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2584);
			datetime_value_expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class String_value_expressionContext extends ParserRuleContext {
		public Character_value_expressionContext character_value_expression() {
			return getRuleContext(Character_value_expressionContext.class,0);
		}
		public String_value_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_value_expression; }
	}

	public final String_value_expressionContext string_value_expression() throws RecognitionException {
		String_value_expressionContext _localctx = new String_value_expressionContext(_ctx, getState());
		enterRule(_localctx, 408, RULE_string_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2586);
			character_value_expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Character_value_expressionContext extends ParserRuleContext {
		public List<Character_factorContext> character_factor() {
			return getRuleContexts(Character_factorContext.class);
		}
		public Character_factorContext character_factor(int i) {
			return getRuleContext(Character_factorContext.class,i);
		}
		public List<TerminalNode> CONCATENATION_OPERATOR() { return getTokens(SQLParser.CONCATENATION_OPERATOR); }
		public TerminalNode CONCATENATION_OPERATOR(int i) {
			return getToken(SQLParser.CONCATENATION_OPERATOR, i);
		}
		public Character_value_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_character_value_expression; }
	}

	public final Character_value_expressionContext character_value_expression() throws RecognitionException {
		Character_value_expressionContext _localctx = new Character_value_expressionContext(_ctx, getState());
		enterRule(_localctx, 410, RULE_character_value_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2588);
			character_factor();
			setState(2593);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CONCATENATION_OPERATOR) {
				{
				{
				setState(2589);
				match(CONCATENATION_OPERATOR);
				setState(2590);
				character_factor();
				}
				}
				setState(2595);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Character_factorContext extends ParserRuleContext {
		public Character_primaryContext character_primary() {
			return getRuleContext(Character_primaryContext.class,0);
		}
		public Character_factorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_character_factor; }
	}

	public final Character_factorContext character_factor() throws RecognitionException {
		Character_factorContext _localctx = new Character_factorContext(_ctx, getState());
		enterRule(_localctx, 412, RULE_character_factor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2596);
			character_primary();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Character_primaryContext extends ParserRuleContext {
		public Value_expression_primaryContext value_expression_primary() {
			return getRuleContext(Value_expression_primaryContext.class,0);
		}
		public String_value_functionContext string_value_function() {
			return getRuleContext(String_value_functionContext.class,0);
		}
		public Character_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_character_primary; }
	}

	public final Character_primaryContext character_primary() throws RecognitionException {
		Character_primaryContext _localctx = new Character_primaryContext(_ctx, getState());
		enterRule(_localctx, 414, RULE_character_primary);
		try {
			setState(2600);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,284,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2598);
				value_expression_primary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2599);
				string_value_function();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class String_value_functionContext extends ParserRuleContext {
		public Trim_functionContext trim_function() {
			return getRuleContext(Trim_functionContext.class,0);
		}
		public String_value_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_value_function; }
	}

	public final String_value_functionContext string_value_function() throws RecognitionException {
		String_value_functionContext _localctx = new String_value_functionContext(_ctx, getState());
		enterRule(_localctx, 416, RULE_string_value_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2602);
			trim_function();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Trim_functionContext extends ParserRuleContext {
		public TerminalNode TRIM() { return getToken(SQLParser.TRIM, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Trim_operandsContext trim_operands() {
			return getRuleContext(Trim_operandsContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public Trim_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trim_function; }
	}

	public final Trim_functionContext trim_function() throws RecognitionException {
		Trim_functionContext _localctx = new Trim_functionContext(_ctx, getState());
		enterRule(_localctx, 418, RULE_trim_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2604);
			match(TRIM);
			setState(2605);
			match(LEFT_PAREN);
			setState(2606);
			trim_operands();
			setState(2607);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Trim_operandsContext extends ParserRuleContext {
		public Character_value_expressionContext trim_character;
		public Character_value_expressionContext trim_source;
		public List<Character_value_expressionContext> character_value_expression() {
			return getRuleContexts(Character_value_expressionContext.class);
		}
		public Character_value_expressionContext character_value_expression(int i) {
			return getRuleContext(Character_value_expressionContext.class,i);
		}
		public TerminalNode FROM() { return getToken(SQLParser.FROM, 0); }
		public Trim_specificationContext trim_specification() {
			return getRuleContext(Trim_specificationContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(SQLParser.COMMA, 0); }
		public Trim_operandsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trim_operands; }
	}

	public final Trim_operandsContext trim_operands() throws RecognitionException {
		Trim_operandsContext _localctx = new Trim_operandsContext(_ctx, getState());
		enterRule(_localctx, 420, RULE_trim_operands);
		int _la;
		try {
			setState(2623);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,288,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2616);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,287,_ctx) ) {
				case 1:
					{
					setState(2610);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,285,_ctx) ) {
					case 1:
						{
						setState(2609);
						trim_specification();
						}
						break;
					}
					setState(2613);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 466061487021128624L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & -873698335226338561L) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & -18014398509481985L) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & 36029346707668991L) != 0) || ((((_la - 262)) & ~0x3f) == 0 && ((1L << (_la - 262)) & 252636982505972211L) != 0) || ((((_la - 329)) & ~0x3f) == 0 && ((1L << (_la - 329)) & 120862806593L) != 0)) {
						{
						setState(2612);
						((Trim_operandsContext)_localctx).trim_character = character_value_expression();
						}
					}

					setState(2615);
					match(FROM);
					}
					break;
				}
				setState(2618);
				((Trim_operandsContext)_localctx).trim_source = character_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2619);
				((Trim_operandsContext)_localctx).trim_source = character_value_expression();
				setState(2620);
				match(COMMA);
				setState(2621);
				((Trim_operandsContext)_localctx).trim_character = character_value_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Trim_specificationContext extends ParserRuleContext {
		public TerminalNode LEADING() { return getToken(SQLParser.LEADING, 0); }
		public TerminalNode TRAILING() { return getToken(SQLParser.TRAILING, 0); }
		public TerminalNode BOTH() { return getToken(SQLParser.BOTH, 0); }
		public Trim_specificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trim_specification; }
	}

	public final Trim_specificationContext trim_specification() throws RecognitionException {
		Trim_specificationContext _localctx = new Trim_specificationContext(_ctx, getState());
		enterRule(_localctx, 422, RULE_trim_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2625);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 144115196665790592L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Datetime_value_expressionContext extends ParserRuleContext {
		public Datetime_termContext datetime_term() {
			return getRuleContext(Datetime_termContext.class,0);
		}
		public Datetime_value_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datetime_value_expression; }
	}

	public final Datetime_value_expressionContext datetime_value_expression() throws RecognitionException {
		Datetime_value_expressionContext _localctx = new Datetime_value_expressionContext(_ctx, getState());
		enterRule(_localctx, 424, RULE_datetime_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2627);
			datetime_term();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Datetime_termContext extends ParserRuleContext {
		public Datetime_factorContext datetime_factor() {
			return getRuleContext(Datetime_factorContext.class,0);
		}
		public Datetime_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datetime_term; }
	}

	public final Datetime_termContext datetime_term() throws RecognitionException {
		Datetime_termContext _localctx = new Datetime_termContext(_ctx, getState());
		enterRule(_localctx, 426, RULE_datetime_term);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2629);
			datetime_factor();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Datetime_factorContext extends ParserRuleContext {
		public Datetime_primaryContext datetime_primary() {
			return getRuleContext(Datetime_primaryContext.class,0);
		}
		public Datetime_factorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datetime_factor; }
	}

	public final Datetime_factorContext datetime_factor() throws RecognitionException {
		Datetime_factorContext _localctx = new Datetime_factorContext(_ctx, getState());
		enterRule(_localctx, 428, RULE_datetime_factor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2631);
			datetime_primary();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Datetime_primaryContext extends ParserRuleContext {
		public Value_expression_primaryContext value_expression_primary() {
			return getRuleContext(Value_expression_primaryContext.class,0);
		}
		public Datetime_value_functionContext datetime_value_function() {
			return getRuleContext(Datetime_value_functionContext.class,0);
		}
		public Datetime_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datetime_primary; }
	}

	public final Datetime_primaryContext datetime_primary() throws RecognitionException {
		Datetime_primaryContext _localctx = new Datetime_primaryContext(_ctx, getState());
		enterRule(_localctx, 430, RULE_datetime_primary);
		try {
			setState(2635);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,289,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2633);
				value_expression_primary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2634);
				datetime_value_function();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Datetime_value_functionContext extends ParserRuleContext {
		public Current_date_value_functionContext current_date_value_function() {
			return getRuleContext(Current_date_value_functionContext.class,0);
		}
		public Current_time_value_functionContext current_time_value_function() {
			return getRuleContext(Current_time_value_functionContext.class,0);
		}
		public Current_timestamp_value_functionContext current_timestamp_value_function() {
			return getRuleContext(Current_timestamp_value_functionContext.class,0);
		}
		public Datetime_value_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datetime_value_function; }
	}

	public final Datetime_value_functionContext datetime_value_function() throws RecognitionException {
		Datetime_value_functionContext _localctx = new Datetime_value_functionContext(_ctx, getState());
		enterRule(_localctx, 432, RULE_datetime_value_function);
		try {
			setState(2640);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CURRENT_DATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(2637);
				current_date_value_function();
				}
				break;
			case CURRENT_TIME:
				enterOuterAlt(_localctx, 2);
				{
				setState(2638);
				current_time_value_function();
				}
				break;
			case CURRENT_TIMESTAMP:
				enterOuterAlt(_localctx, 3);
				{
				setState(2639);
				current_timestamp_value_function();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Current_date_value_functionContext extends ParserRuleContext {
		public TerminalNode CURRENT_DATE() { return getToken(SQLParser.CURRENT_DATE, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public Current_date_value_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_current_date_value_function; }
	}

	public final Current_date_value_functionContext current_date_value_function() throws RecognitionException {
		Current_date_value_functionContext _localctx = new Current_date_value_functionContext(_ctx, getState());
		enterRule(_localctx, 434, RULE_current_date_value_function);
		try {
			setState(2646);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,291,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2642);
				match(CURRENT_DATE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2643);
				match(CURRENT_DATE);
				setState(2644);
				match(LEFT_PAREN);
				setState(2645);
				match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Current_time_value_functionContext extends ParserRuleContext {
		public TerminalNode CURRENT_TIME() { return getToken(SQLParser.CURRENT_TIME, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public Current_time_value_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_current_time_value_function; }
	}

	public final Current_time_value_functionContext current_time_value_function() throws RecognitionException {
		Current_time_value_functionContext _localctx = new Current_time_value_functionContext(_ctx, getState());
		enterRule(_localctx, 436, RULE_current_time_value_function);
		try {
			setState(2652);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,292,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2648);
				match(CURRENT_TIME);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2649);
				match(CURRENT_TIME);
				setState(2650);
				match(LEFT_PAREN);
				setState(2651);
				match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Current_timestamp_value_functionContext extends ParserRuleContext {
		public TerminalNode CURRENT_TIMESTAMP() { return getToken(SQLParser.CURRENT_TIMESTAMP, 0); }
		public Current_timestamp_value_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_current_timestamp_value_function; }
	}

	public final Current_timestamp_value_functionContext current_timestamp_value_function() throws RecognitionException {
		Current_timestamp_value_functionContext _localctx = new Current_timestamp_value_functionContext(_ctx, getState());
		enterRule(_localctx, 438, RULE_current_timestamp_value_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2654);
			match(CURRENT_TIMESTAMP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Boolean_value_expressionContext extends ParserRuleContext {
		public Or_predicateContext or_predicate() {
			return getRuleContext(Or_predicateContext.class,0);
		}
		public Boolean_value_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_value_expression; }
	}

	public final Boolean_value_expressionContext boolean_value_expression() throws RecognitionException {
		Boolean_value_expressionContext _localctx = new Boolean_value_expressionContext(_ctx, getState());
		enterRule(_localctx, 440, RULE_boolean_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2656);
			or_predicate();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Or_predicateContext extends ParserRuleContext {
		public And_predicateContext and_predicate() {
			return getRuleContext(And_predicateContext.class,0);
		}
		public List<TerminalNode> OR() { return getTokens(SQLParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(SQLParser.OR, i);
		}
		public List<Or_predicateContext> or_predicate() {
			return getRuleContexts(Or_predicateContext.class);
		}
		public Or_predicateContext or_predicate(int i) {
			return getRuleContext(Or_predicateContext.class,i);
		}
		public Or_predicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or_predicate; }
	}

	public final Or_predicateContext or_predicate() throws RecognitionException {
		Or_predicateContext _localctx = new Or_predicateContext(_ctx, getState());
		enterRule(_localctx, 442, RULE_or_predicate);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2658);
			and_predicate();
			setState(2663);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,293,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2659);
					match(OR);
					setState(2660);
					or_predicate();
					}
					} 
				}
				setState(2665);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,293,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class And_predicateContext extends ParserRuleContext {
		public Boolean_factorContext boolean_factor() {
			return getRuleContext(Boolean_factorContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(SQLParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(SQLParser.AND, i);
		}
		public List<And_predicateContext> and_predicate() {
			return getRuleContexts(And_predicateContext.class);
		}
		public And_predicateContext and_predicate(int i) {
			return getRuleContext(And_predicateContext.class,i);
		}
		public And_predicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and_predicate; }
	}

	public final And_predicateContext and_predicate() throws RecognitionException {
		And_predicateContext _localctx = new And_predicateContext(_ctx, getState());
		enterRule(_localctx, 444, RULE_and_predicate);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2669);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT_SIGN) {
				{
				{
				setState(2666);
				annotation();
				}
				}
				setState(2671);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2672);
			boolean_factor();
			setState(2677);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,295,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2673);
					match(AND);
					setState(2674);
					and_predicate();
					}
					} 
				}
				setState(2679);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,295,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Boolean_factorContext extends ParserRuleContext {
		public Boolean_testContext boolean_test() {
			return getRuleContext(Boolean_testContext.class,0);
		}
		public TerminalNode NOT() { return getToken(SQLParser.NOT, 0); }
		public Boolean_factorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_factor; }
	}

	public final Boolean_factorContext boolean_factor() throws RecognitionException {
		Boolean_factorContext _localctx = new Boolean_factorContext(_ctx, getState());
		enterRule(_localctx, 446, RULE_boolean_factor);
		try {
			setState(2683);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,296,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2680);
				boolean_test();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2681);
				match(NOT);
				setState(2682);
				boolean_test();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Boolean_testContext extends ParserRuleContext {
		public Boolean_primaryContext boolean_primary() {
			return getRuleContext(Boolean_primaryContext.class,0);
		}
		public Is_clauseContext is_clause() {
			return getRuleContext(Is_clauseContext.class,0);
		}
		public Boolean_testContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_test; }
	}

	public final Boolean_testContext boolean_test() throws RecognitionException {
		Boolean_testContext _localctx = new Boolean_testContext(_ctx, getState());
		enterRule(_localctx, 448, RULE_boolean_test);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2685);
			boolean_primary();
			setState(2687);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IS) {
				{
				setState(2686);
				is_clause();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Is_clauseContext extends ParserRuleContext {
		public Truth_valueContext t;
		public TerminalNode IS() { return getToken(SQLParser.IS, 0); }
		public Truth_valueContext truth_value() {
			return getRuleContext(Truth_valueContext.class,0);
		}
		public TerminalNode NOT() { return getToken(SQLParser.NOT, 0); }
		public Is_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_is_clause; }
	}

	public final Is_clauseContext is_clause() throws RecognitionException {
		Is_clauseContext _localctx = new Is_clauseContext(_ctx, getState());
		enterRule(_localctx, 450, RULE_is_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2689);
			match(IS);
			setState(2691);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(2690);
				match(NOT);
				}
			}

			setState(2693);
			((Is_clauseContext)_localctx).t = truth_value();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Truth_valueContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(SQLParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(SQLParser.FALSE, 0); }
		public TerminalNode UNKNOWN() { return getToken(SQLParser.UNKNOWN, 0); }
		public Truth_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_truth_value; }
	}

	public final Truth_valueContext truth_value() throws RecognitionException {
		Truth_valueContext _localctx = new Truth_valueContext(_ctx, getState());
		enterRule(_localctx, 452, RULE_truth_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2695);
			_la = _input.LA(1);
			if ( !(_la==FALSE || _la==TRUE || _la==UNKNOWN) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Boolean_primaryContext extends ParserRuleContext {
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public Boolean_predicandContext boolean_predicand() {
			return getRuleContext(Boolean_predicandContext.class,0);
		}
		public Boolean_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_primary; }
	}

	public final Boolean_primaryContext boolean_primary() throws RecognitionException {
		Boolean_primaryContext _localctx = new Boolean_primaryContext(_ctx, getState());
		enterRule(_localctx, 454, RULE_boolean_primary);
		try {
			setState(2699);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,299,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2697);
				predicate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2698);
				boolean_predicand();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Boolean_predicandContext extends ParserRuleContext {
		public Parenthesized_boolean_value_expressionContext parenthesized_boolean_value_expression() {
			return getRuleContext(Parenthesized_boolean_value_expressionContext.class,0);
		}
		public Nonparenthesized_value_expression_primaryContext nonparenthesized_value_expression_primary() {
			return getRuleContext(Nonparenthesized_value_expression_primaryContext.class,0);
		}
		public Boolean_predicandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_predicand; }
	}

	public final Boolean_predicandContext boolean_predicand() throws RecognitionException {
		Boolean_predicandContext _localctx = new Boolean_predicandContext(_ctx, getState());
		enterRule(_localctx, 456, RULE_boolean_predicand);
		try {
			setState(2703);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,300,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2701);
				parenthesized_boolean_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2702);
				nonparenthesized_value_expression_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Parenthesized_boolean_value_expressionContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Boolean_value_expressionContext boolean_value_expression() {
			return getRuleContext(Boolean_value_expressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public Parenthesized_boolean_value_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parenthesized_boolean_value_expression; }
	}

	public final Parenthesized_boolean_value_expressionContext parenthesized_boolean_value_expression() throws RecognitionException {
		Parenthesized_boolean_value_expressionContext _localctx = new Parenthesized_boolean_value_expressionContext(_ctx, getState());
		enterRule(_localctx, 458, RULE_parenthesized_boolean_value_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2705);
			match(LEFT_PAREN);
			setState(2706);
			boolean_value_expression();
			setState(2707);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Odi_variableContext extends ParserRuleContext {
		public TerminalNode Odi_Variable() { return getToken(SQLParser.Odi_Variable, 0); }
		public Odi_variableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_odi_variable; }
	}

	public final Odi_variableContext odi_variable() throws RecognitionException {
		Odi_variableContext _localctx = new Odi_variableContext(_ctx, getState());
		enterRule(_localctx, 460, RULE_odi_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2709);
			match(Odi_Variable);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Odi_variable_literalContext extends ParserRuleContext {
		public TerminalNode Odi_Variable_Literal() { return getToken(SQLParser.Odi_Variable_Literal, 0); }
		public Odi_variable_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_odi_variable_literal; }
	}

	public final Odi_variable_literalContext odi_variable_literal() throws RecognitionException {
		Odi_variable_literalContext _localctx = new Odi_variable_literalContext(_ctx, getState());
		enterRule(_localctx, 462, RULE_odi_variable_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2711);
			match(Odi_Variable_Literal);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Odi_sequenceContext extends ParserRuleContext {
		public TerminalNode Odi_Sequence() { return getToken(SQLParser.Odi_Sequence, 0); }
		public Odi_sequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_odi_sequence; }
	}

	public final Odi_sequenceContext odi_sequence() throws RecognitionException {
		Odi_sequenceContext _localctx = new Odi_sequenceContext(_ctx, getState());
		enterRule(_localctx, 464, RULE_odi_sequence);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2713);
			match(Odi_Sequence);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Row_value_expressionContext extends ParserRuleContext {
		public Row_value_special_caseContext row_value_special_case() {
			return getRuleContext(Row_value_special_caseContext.class,0);
		}
		public Explicit_row_value_constructorContext explicit_row_value_constructor() {
			return getRuleContext(Explicit_row_value_constructorContext.class,0);
		}
		public Row_value_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_row_value_expression; }
	}

	public final Row_value_expressionContext row_value_expression() throws RecognitionException {
		Row_value_expressionContext _localctx = new Row_value_expressionContext(_ctx, getState());
		enterRule(_localctx, 466, RULE_row_value_expression);
		try {
			setState(2717);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ANY:
			case ASYMMETRIC:
			case BOTH:
			case CASE:
			case CAST:
			case CROSS:
			case CURRENT_DATE:
			case CURRENT_TIME:
			case CURRENT_TIMESTAMP:
			case DATASET:
			case FALSE:
			case FULL:
			case GROUP:
			case LEFT:
			case LIMIT:
			case MAPPING:
			case NATURAL:
			case ORDER:
			case PACKAGE:
			case PROCEDURE:
			case PROJECT:
			case RIGHT:
			case REUSABLE:
			case SOME:
			case SYMMETRIC:
			case SCENARIO:
			case TRAILING:
			case TRUE:
			case WINDOW:
			case VARIABLE:
			case POSITION:
			case OFFSET:
			case IKM:
			case LKM:
			case CKM:
			case TECHNOLOGY:
			case DESCRIPTION:
			case AVG:
			case ADD:
			case ALTER:
			case BETWEEN:
			case BY:
			case CATALOG:
			case CENTURY:
			case CHARACTER:
			case COLLECT:
			case COALESCE:
			case COLUMN:
			case COUNT:
			case CUBE:
			case CUME_DIST:
			case CURRENT:
			case STRING:
			case DAY:
			case DEFAULT:
			case DATABASE:
			case DEC:
			case DECADE:
			case DENSE_RANK:
			case DOW:
			case DOY:
			case DROP:
			case EPOCH:
			case EVERY:
			case EXCLUDE:
			case EXISTS:
			case EXPLAIN:
			case EXTERNAL:
			case EXTRACT:
			case FILTER:
			case FIRST:
			case FIRST_VALUE:
			case FOLLOWING:
			case FORMAT:
			case FUSION:
			case GROUPING:
			case HASH:
			case INDEX:
			case INSERT:
			case INTERSECTION:
			case ISODOW:
			case ISOYEAR:
			case LAG:
			case LAST:
			case LAST_VALUE:
			case LEAD:
			case LESS:
			case LIST:
			case LOCATION:
			case MAX:
			case MAXVALUE:
			case MICROSECONDS:
			case MILLENNIUM:
			case MILLISECONDS:
			case MIN:
			case MINUTE:
			case MONTH:
			case NATIONAL:
			case NULLIF:
			case NO:
			case OVERWRITE:
			case OTHERS:
			case PARTITION:
			case PARTITIONS:
			case PERCENT_RANK:
			case PRECEDING:
			case PRECISION:
			case PURGE:
			case QUARTER:
			case RANGE:
			case RANK:
			case REGEXP:
			case RENAME:
			case RESET:
			case RLIKE:
			case ROLLUP:
			case ROW:
			case ROWS:
			case ROW_NUMBER:
			case SECOND:
			case SESSION:
			case SET:
			case SIMILAR:
			case STDDEV_POP:
			case STDDEV_SAMP:
			case SUBPARTITION:
			case SUM:
			case TABLESPACE:
			case THAN:
			case TIES:
			case TIMEZONE:
			case TIMEZONE_HOUR:
			case TIMEZONE_MINUTE:
			case TRIM:
			case TO:
			case UNBOUNDED:
			case UNKNOWN:
			case VALUES:
			case VAR_SAMP:
			case VAR_POP:
			case VARYING:
			case WEEK:
			case YEAR:
			case ZONE:
			case BOOLEAN:
			case BOOL:
			case BIT:
			case VARBIT:
			case INT1:
			case INT2:
			case INT4:
			case INT8:
			case TINYINT:
			case SMALLINT:
			case INT:
			case INTEGER:
			case BIGINT:
			case FLOAT4:
			case FLOAT8:
			case REAL:
			case FLOAT:
			case DOUBLE:
			case NUMERIC:
			case ORANUMBER:
			case DECIMAL:
			case CHAR:
			case VARCHAR2:
			case VARCHAR:
			case NCHAR:
			case NVARCHAR:
			case DATE:
			case INTERVAL:
			case TIME:
			case TIMETZ:
			case TIMESTAMP:
			case TIMESTAMPTZ:
			case TEXT:
			case BINARY:
			case VARBINARY:
			case BLOB:
			case BYTEA:
			case INET4:
			case LEFT_PAREN:
			case NUMBER:
			case REAL_NUMBER:
			case DATASTORE:
			case ALIAS:
			case RESOURCE:
			case FILE:
			case HEADING:
			case FIXED:
			case SCD:
			case MODEL:
			case FOLDER:
			case SUBMODEL:
			case REPLACE:
			case CONTEXT:
			case XKM:
			case SEQUENCEFILE:
			case FIELDS:
			case TERMINATED:
			case SERDE:
			case SERDEPROPERTIES:
			case TEXTFILE:
			case RCFILE:
			case ORC:
			case PARQUET:
			case AVRO:
			case INPUTFORMAT:
			case OUTPUTFORMAT:
			case TEMPORARY:
			case TBLPROPERTIES:
			case REJECT:
			case PERCENT:
			case ODIREF:
			case CURSOR:
			case SUCCESS:
			case LISTAGG:
			case TYPE:
			case ODI:
			case CONVERT:
			case CONTROL:
			case FLOW:
			case STATIC:
			case ACTIVE:
			case MESSAGE:
			case KEEP:
			case PIVOT:
			case UNPIVOT:
			case Odi_Variable_Literal:
			case Regular_Identifier:
			case Quoted_Identifier:
			case Character_String_Literal:
				enterOuterAlt(_localctx, 1);
				{
				setState(2715);
				row_value_special_case();
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 2);
				{
				setState(2716);
				explicit_row_value_constructor();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Row_value_special_caseContext extends ParserRuleContext {
		public Nonparenthesized_value_expression_primaryContext nonparenthesized_value_expression_primary() {
			return getRuleContext(Nonparenthesized_value_expression_primaryContext.class,0);
		}
		public Row_value_special_caseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_row_value_special_case; }
	}

	public final Row_value_special_caseContext row_value_special_case() throws RecognitionException {
		Row_value_special_caseContext _localctx = new Row_value_special_caseContext(_ctx, getState());
		enterRule(_localctx, 468, RULE_row_value_special_case);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2719);
			nonparenthesized_value_expression_primary();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Explicit_row_value_constructorContext extends ParserRuleContext {
		public TerminalNode NULL() { return getToken(SQLParser.NULL, 0); }
		public Explicit_row_value_constructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explicit_row_value_constructor; }
	}

	public final Explicit_row_value_constructorContext explicit_row_value_constructor() throws RecognitionException {
		Explicit_row_value_constructorContext _localctx = new Explicit_row_value_constructorContext(_ctx, getState());
		enterRule(_localctx, 470, RULE_explicit_row_value_constructor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2721);
			match(NULL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Row_value_predicandContext extends ParserRuleContext {
		public Row_value_special_caseContext row_value_special_case() {
			return getRuleContext(Row_value_special_caseContext.class,0);
		}
		public Row_value_constructor_predicandContext row_value_constructor_predicand() {
			return getRuleContext(Row_value_constructor_predicandContext.class,0);
		}
		public Row_value_predicandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_row_value_predicand; }
	}

	public final Row_value_predicandContext row_value_predicand() throws RecognitionException {
		Row_value_predicandContext _localctx = new Row_value_predicandContext(_ctx, getState());
		enterRule(_localctx, 472, RULE_row_value_predicand);
		try {
			setState(2725);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,302,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2723);
				row_value_special_case();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2724);
				row_value_constructor_predicand();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Row_value_constructor_predicandContext extends ParserRuleContext {
		public Common_value_expressionContext common_value_expression() {
			return getRuleContext(Common_value_expressionContext.class,0);
		}
		public Boolean_predicandContext boolean_predicand() {
			return getRuleContext(Boolean_predicandContext.class,0);
		}
		public Row_value_constructor_predicandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_row_value_constructor_predicand; }
	}

	public final Row_value_constructor_predicandContext row_value_constructor_predicand() throws RecognitionException {
		Row_value_constructor_predicandContext _localctx = new Row_value_constructor_predicandContext(_ctx, getState());
		enterRule(_localctx, 474, RULE_row_value_constructor_predicand);
		try {
			setState(2729);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,303,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2727);
				common_value_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2728);
				boolean_predicand();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Table_expressionContext extends ParserRuleContext {
		public From_clauseContext from_clause() {
			return getRuleContext(From_clauseContext.class,0);
		}
		public Pivot_clauseContext pivot_clause() {
			return getRuleContext(Pivot_clauseContext.class,0);
		}
		public Where_clauseContext where_clause() {
			return getRuleContext(Where_clauseContext.class,0);
		}
		public Unpivot_clauseContext unpivot_clause() {
			return getRuleContext(Unpivot_clauseContext.class,0);
		}
		public Groupby_clauseContext groupby_clause() {
			return getRuleContext(Groupby_clauseContext.class,0);
		}
		public Having_clauseContext having_clause() {
			return getRuleContext(Having_clauseContext.class,0);
		}
		public Orderby_clauseContext orderby_clause() {
			return getRuleContext(Orderby_clauseContext.class,0);
		}
		public Window_clauseContext window_clause() {
			return getRuleContext(Window_clauseContext.class,0);
		}
		public Limit_clauseContext limit_clause() {
			return getRuleContext(Limit_clauseContext.class,0);
		}
		public Table_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_expression; }
	}

	public final Table_expressionContext table_expression() throws RecognitionException {
		Table_expressionContext _localctx = new Table_expressionContext(_ctx, getState());
		enterRule(_localctx, 476, RULE_table_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2731);
			from_clause();
			setState(2733);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PIVOT) {
				{
				setState(2732);
				pivot_clause();
				}
			}

			setState(2736);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,305,_ctx) ) {
			case 1:
				{
				setState(2735);
				where_clause();
				}
				break;
			}
			setState(2739);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==UNPIVOT) {
				{
				setState(2738);
				unpivot_clause();
				}
			}

			setState(2742);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,307,_ctx) ) {
			case 1:
				{
				setState(2741);
				groupby_clause();
				}
				break;
			}
			setState(2745);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HAVING) {
				{
				setState(2744);
				having_clause();
				}
			}

			setState(2748);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,309,_ctx) ) {
			case 1:
				{
				setState(2747);
				orderby_clause();
				}
				break;
			}
			setState(2751);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WINDOW) {
				{
				setState(2750);
				window_clause();
				}
			}

			setState(2754);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LIMIT) {
				{
				setState(2753);
				limit_clause();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class From_clauseContext extends ParserRuleContext {
		public TerminalNode FROM() { return getToken(SQLParser.FROM, 0); }
		public Table_reference_listContext table_reference_list() {
			return getRuleContext(Table_reference_listContext.class,0);
		}
		public From_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_from_clause; }
	}

	public final From_clauseContext from_clause() throws RecognitionException {
		From_clauseContext _localctx = new From_clauseContext(_ctx, getState());
		enterRule(_localctx, 478, RULE_from_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2756);
			match(FROM);
			setState(2757);
			table_reference_list();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Table_reference_listContext extends ParserRuleContext {
		public List<Table_referenceContext> table_reference() {
			return getRuleContexts(Table_referenceContext.class);
		}
		public Table_referenceContext table_reference(int i) {
			return getRuleContext(Table_referenceContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Table_reference_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_reference_list; }
	}

	public final Table_reference_listContext table_reference_list() throws RecognitionException {
		Table_reference_listContext _localctx = new Table_reference_listContext(_ctx, getState());
		enterRule(_localctx, 480, RULE_table_reference_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2759);
			table_reference();
			setState(2764);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2760);
				match(COMMA);
				setState(2761);
				table_reference();
				}
				}
				setState(2766);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Unpivot_fields_listContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public Unpivot_fields_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unpivot_fields_list; }
	}

	public final Unpivot_fields_listContext unpivot_fields_list() throws RecognitionException {
		Unpivot_fields_listContext _localctx = new Unpivot_fields_listContext(_ctx, getState());
		enterRule(_localctx, 482, RULE_unpivot_fields_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2768);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LEFT_PAREN) {
				{
				setState(2767);
				match(LEFT_PAREN);
				}
			}

			setState(2770);
			identifier();
			setState(2775);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2771);
				match(COMMA);
				setState(2772);
				identifier();
				}
				}
				setState(2777);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2779);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RIGHT_PAREN) {
				{
				setState(2778);
				match(RIGHT_PAREN);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Unpivot_source_fields_listContext extends ParserRuleContext {
		public List<Common_value_expressionContext> common_value_expression() {
			return getRuleContexts(Common_value_expressionContext.class);
		}
		public Common_value_expressionContext common_value_expression(int i) {
			return getRuleContext(Common_value_expressionContext.class,i);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public Unpivot_source_fields_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unpivot_source_fields_list; }
	}

	public final Unpivot_source_fields_listContext unpivot_source_fields_list() throws RecognitionException {
		Unpivot_source_fields_listContext _localctx = new Unpivot_source_fields_listContext(_ctx, getState());
		enterRule(_localctx, 484, RULE_unpivot_source_fields_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2782);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,316,_ctx) ) {
			case 1:
				{
				setState(2781);
				match(LEFT_PAREN);
				}
				break;
			}
			setState(2784);
			common_value_expression();
			setState(2789);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2785);
				match(COMMA);
				setState(2786);
				common_value_expression();
				}
				}
				setState(2791);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2793);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RIGHT_PAREN) {
				{
				setState(2792);
				match(RIGHT_PAREN);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Unpivot_ruleContext extends ParserRuleContext {
		public Unpivot_source_fields_listContext unpivot_source_fields_list() {
			return getRuleContext(Unpivot_source_fields_listContext.class,0);
		}
		public TerminalNode AS() { return getToken(SQLParser.AS, 0); }
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public Signed_numerical_literalContext signed_numerical_literal() {
			return getRuleContext(Signed_numerical_literalContext.class,0);
		}
		public Unpivot_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unpivot_rule; }
	}

	public final Unpivot_ruleContext unpivot_rule() throws RecognitionException {
		Unpivot_ruleContext _localctx = new Unpivot_ruleContext(_ctx, getState());
		enterRule(_localctx, 486, RULE_unpivot_rule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2795);
			unpivot_source_fields_list();
			setState(2796);
			match(AS);
			setState(2799);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Character_String_Literal:
				{
				setState(2797);
				match(Character_String_Literal);
				}
				break;
			case PLUS:
			case MINUS:
			case NUMBER:
			case REAL_NUMBER:
				{
				setState(2798);
				signed_numerical_literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Unpivot_rulesContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public List<Unpivot_ruleContext> unpivot_rule() {
			return getRuleContexts(Unpivot_ruleContext.class);
		}
		public Unpivot_ruleContext unpivot_rule(int i) {
			return getRuleContext(Unpivot_ruleContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Unpivot_rulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unpivot_rules; }
	}

	public final Unpivot_rulesContext unpivot_rules() throws RecognitionException {
		Unpivot_rulesContext _localctx = new Unpivot_rulesContext(_ctx, getState());
		enterRule(_localctx, 488, RULE_unpivot_rules);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2801);
			match(LEFT_PAREN);
			setState(2802);
			unpivot_rule();
			setState(2807);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2803);
				match(COMMA);
				setState(2804);
				unpivot_rule();
				}
				}
				setState(2809);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2810);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Unpivot_clauseContext extends ParserRuleContext {
		public IdentifierContext locator;
		public IdentifierContext alias;
		public TerminalNode UNPIVOT() { return getToken(SQLParser.UNPIVOT, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Unpivot_fields_listContext unpivot_fields_list() {
			return getRuleContext(Unpivot_fields_listContext.class,0);
		}
		public TerminalNode FOR() { return getToken(SQLParser.FOR, 0); }
		public TerminalNode IN() { return getToken(SQLParser.IN, 0); }
		public Unpivot_rulesContext unpivot_rules() {
			return getRuleContext(Unpivot_rulesContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode INCLUDE() { return getToken(SQLParser.INCLUDE, 0); }
		public TerminalNode NULLS() { return getToken(SQLParser.NULLS, 0); }
		public TerminalNode AS() { return getToken(SQLParser.AS, 0); }
		public Unpivot_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unpivot_clause; }
	}

	public final Unpivot_clauseContext unpivot_clause() throws RecognitionException {
		Unpivot_clauseContext _localctx = new Unpivot_clauseContext(_ctx, getState());
		enterRule(_localctx, 490, RULE_unpivot_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2812);
			match(UNPIVOT);
			setState(2815);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INCLUDE) {
				{
				setState(2813);
				match(INCLUDE);
				setState(2814);
				match(NULLS);
				}
			}

			setState(2817);
			match(LEFT_PAREN);
			setState(2818);
			unpivot_fields_list();
			setState(2819);
			match(FOR);
			setState(2820);
			((Unpivot_clauseContext)_localctx).locator = identifier();
			setState(2821);
			match(IN);
			setState(2822);
			unpivot_rules();
			setState(2823);
			match(RIGHT_PAREN);
			setState(2825);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(2824);
				match(AS);
				}
			}

			setState(2827);
			((Unpivot_clauseContext)_localctx).alias = identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Pivot_fields_listContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public Pivot_fields_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pivot_fields_list; }
	}

	public final Pivot_fields_listContext pivot_fields_list() throws RecognitionException {
		Pivot_fields_listContext _localctx = new Pivot_fields_listContext(_ctx, getState());
		enterRule(_localctx, 492, RULE_pivot_fields_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2830);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LEFT_PAREN) {
				{
				setState(2829);
				match(LEFT_PAREN);
				}
			}

			setState(2832);
			identifier();
			setState(2837);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2833);
				match(COMMA);
				setState(2834);
				identifier();
				}
				}
				setState(2839);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2841);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RIGHT_PAREN) {
				{
				setState(2840);
				match(RIGHT_PAREN);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Pivot_source_fields_listContext extends ParserRuleContext {
		public List<Common_value_expressionContext> common_value_expression() {
			return getRuleContexts(Common_value_expressionContext.class);
		}
		public Common_value_expressionContext common_value_expression(int i) {
			return getRuleContext(Common_value_expressionContext.class,i);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public Pivot_source_fields_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pivot_source_fields_list; }
	}

	public final Pivot_source_fields_listContext pivot_source_fields_list() throws RecognitionException {
		Pivot_source_fields_listContext _localctx = new Pivot_source_fields_listContext(_ctx, getState());
		enterRule(_localctx, 494, RULE_pivot_source_fields_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2844);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,326,_ctx) ) {
			case 1:
				{
				setState(2843);
				match(LEFT_PAREN);
				}
				break;
			}
			setState(2846);
			common_value_expression();
			setState(2851);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2847);
				match(COMMA);
				setState(2848);
				common_value_expression();
				}
				}
				setState(2853);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2855);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RIGHT_PAREN) {
				{
				setState(2854);
				match(RIGHT_PAREN);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Pivot_ruleContext extends ParserRuleContext {
		public Unpivot_source_fields_listContext unpivot_source_fields_list() {
			return getRuleContext(Unpivot_source_fields_listContext.class,0);
		}
		public TerminalNode AS() { return getToken(SQLParser.AS, 0); }
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public Signed_numerical_literalContext signed_numerical_literal() {
			return getRuleContext(Signed_numerical_literalContext.class,0);
		}
		public Pivot_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pivot_rule; }
	}

	public final Pivot_ruleContext pivot_rule() throws RecognitionException {
		Pivot_ruleContext _localctx = new Pivot_ruleContext(_ctx, getState());
		enterRule(_localctx, 496, RULE_pivot_rule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2857);
			unpivot_source_fields_list();
			setState(2858);
			match(AS);
			setState(2861);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Character_String_Literal:
				{
				setState(2859);
				match(Character_String_Literal);
				}
				break;
			case PLUS:
			case MINUS:
			case NUMBER:
			case REAL_NUMBER:
				{
				setState(2860);
				signed_numerical_literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Pivot_rulesContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public List<Unpivot_ruleContext> unpivot_rule() {
			return getRuleContexts(Unpivot_ruleContext.class);
		}
		public Unpivot_ruleContext unpivot_rule(int i) {
			return getRuleContext(Unpivot_ruleContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Pivot_rulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pivot_rules; }
	}

	public final Pivot_rulesContext pivot_rules() throws RecognitionException {
		Pivot_rulesContext _localctx = new Pivot_rulesContext(_ctx, getState());
		enterRule(_localctx, 498, RULE_pivot_rules);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2863);
			match(LEFT_PAREN);
			setState(2864);
			unpivot_rule();
			setState(2869);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2865);
				match(COMMA);
				setState(2866);
				unpivot_rule();
				}
				}
				setState(2871);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2872);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Pivot_clauseContext extends ParserRuleContext {
		public IdentifierContext locator;
		public IdentifierContext alias;
		public TerminalNode PIVOT() { return getToken(SQLParser.PIVOT, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Pivot_fields_listContext pivot_fields_list() {
			return getRuleContext(Pivot_fields_listContext.class,0);
		}
		public TerminalNode FOR() { return getToken(SQLParser.FOR, 0); }
		public TerminalNode IN() { return getToken(SQLParser.IN, 0); }
		public Unpivot_rulesContext unpivot_rules() {
			return getRuleContext(Unpivot_rulesContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode AS() { return getToken(SQLParser.AS, 0); }
		public Pivot_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pivot_clause; }
	}

	public final Pivot_clauseContext pivot_clause() throws RecognitionException {
		Pivot_clauseContext _localctx = new Pivot_clauseContext(_ctx, getState());
		enterRule(_localctx, 500, RULE_pivot_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2874);
			match(PIVOT);
			setState(2875);
			match(LEFT_PAREN);
			setState(2876);
			pivot_fields_list();
			setState(2877);
			match(FOR);
			setState(2878);
			((Pivot_clauseContext)_localctx).locator = identifier();
			setState(2879);
			match(IN);
			setState(2880);
			unpivot_rules();
			setState(2881);
			match(RIGHT_PAREN);
			setState(2883);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(2882);
				match(AS);
				}
			}

			setState(2885);
			((Pivot_clauseContext)_localctx).alias = identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Table_referenceContext extends ParserRuleContext {
		public Joined_tableContext joined_table() {
			return getRuleContext(Joined_tableContext.class,0);
		}
		public Table_primaryContext table_primary() {
			return getRuleContext(Table_primaryContext.class,0);
		}
		public Table_referenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_reference; }
	}

	public final Table_referenceContext table_reference() throws RecognitionException {
		Table_referenceContext _localctx = new Table_referenceContext(_ctx, getState());
		enterRule(_localctx, 502, RULE_table_reference);
		try {
			setState(2889);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,332,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2887);
				joined_table();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2888);
				table_primary();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Annotated_joined_table_primaryContext extends ParserRuleContext {
		public Joined_table_primaryContext joined_table_primary() {
			return getRuleContext(Joined_table_primaryContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public Annotated_joined_table_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotated_joined_table_primary; }
	}

	public final Annotated_joined_table_primaryContext annotated_joined_table_primary() throws RecognitionException {
		Annotated_joined_table_primaryContext _localctx = new Annotated_joined_table_primaryContext(_ctx, getState());
		enterRule(_localctx, 504, RULE_annotated_joined_table_primary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2894);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT_SIGN) {
				{
				{
				setState(2891);
				annotation();
				}
				}
				setState(2896);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2897);
			joined_table_primary();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Joined_tableContext extends ParserRuleContext {
		public Table_primaryContext table_primary() {
			return getRuleContext(Table_primaryContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public List<Annotated_joined_table_primaryContext> annotated_joined_table_primary() {
			return getRuleContexts(Annotated_joined_table_primaryContext.class);
		}
		public Annotated_joined_table_primaryContext annotated_joined_table_primary(int i) {
			return getRuleContext(Annotated_joined_table_primaryContext.class,i);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public Joined_tableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joined_table; }
	}

	public final Joined_tableContext joined_table() throws RecognitionException {
		Joined_tableContext _localctx = new Joined_tableContext(_ctx, getState());
		enterRule(_localctx, 506, RULE_joined_table);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2900);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,334,_ctx) ) {
			case 1:
				{
				setState(2899);
				match(LEFT_PAREN);
				}
				break;
			}
			setState(2902);
			table_primary();
			setState(2906);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,335,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2903);
					annotated_joined_table_primary();
					}
					} 
				}
				setState(2908);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,335,_ctx);
			}
			setState(2910);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,336,_ctx) ) {
			case 1:
				{
				setState(2909);
				match(RIGHT_PAREN);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Joined_table_primaryContext extends ParserRuleContext {
		public Joined_tableContext right;
		public Join_typeContext t;
		public Join_specificationContext s;
		public TerminalNode CROSS() { return getToken(SQLParser.CROSS, 0); }
		public TerminalNode JOIN() { return getToken(SQLParser.JOIN, 0); }
		public Joined_tableContext joined_table() {
			return getRuleContext(Joined_tableContext.class,0);
		}
		public Join_specificationContext join_specification() {
			return getRuleContext(Join_specificationContext.class,0);
		}
		public Join_typeContext join_type() {
			return getRuleContext(Join_typeContext.class,0);
		}
		public TerminalNode NATURAL() { return getToken(SQLParser.NATURAL, 0); }
		public TerminalNode UNION() { return getToken(SQLParser.UNION, 0); }
		public Joined_table_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joined_table_primary; }
	}

	public final Joined_table_primaryContext joined_table_primary() throws RecognitionException {
		Joined_table_primaryContext _localctx = new Joined_table_primaryContext(_ctx, getState());
		enterRule(_localctx, 508, RULE_joined_table_primary);
		int _la;
		try {
			setState(2933);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CROSS:
				enterOuterAlt(_localctx, 1);
				{
				setState(2912);
				match(CROSS);
				setState(2913);
				match(JOIN);
				setState(2914);
				((Joined_table_primaryContext)_localctx).right = joined_table();
				}
				break;
			case FULL:
			case INNER:
			case JOIN:
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(2916);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 562967405920256L) != 0)) {
					{
					setState(2915);
					((Joined_table_primaryContext)_localctx).t = join_type();
					}
				}

				setState(2918);
				match(JOIN);
				setState(2919);
				((Joined_table_primaryContext)_localctx).right = joined_table();
				setState(2920);
				((Joined_table_primaryContext)_localctx).s = join_specification();
				}
				break;
			case NATURAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(2922);
				match(NATURAL);
				setState(2924);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 562967405920256L) != 0)) {
					{
					setState(2923);
					((Joined_table_primaryContext)_localctx).t = join_type();
					}
				}

				setState(2926);
				match(JOIN);
				setState(2927);
				((Joined_table_primaryContext)_localctx).right = joined_table();
				setState(2928);
				((Joined_table_primaryContext)_localctx).s = join_specification();
				}
				break;
			case UNION:
				enterOuterAlt(_localctx, 4);
				{
				setState(2930);
				match(UNION);
				setState(2931);
				match(JOIN);
				setState(2932);
				((Joined_table_primaryContext)_localctx).right = joined_table();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Cross_joinContext extends ParserRuleContext {
		public Table_referenceContext r;
		public TerminalNode CROSS() { return getToken(SQLParser.CROSS, 0); }
		public TerminalNode JOIN() { return getToken(SQLParser.JOIN, 0); }
		public Table_referenceContext table_reference() {
			return getRuleContext(Table_referenceContext.class,0);
		}
		public Cross_joinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cross_join; }
	}

	public final Cross_joinContext cross_join() throws RecognitionException {
		Cross_joinContext _localctx = new Cross_joinContext(_ctx, getState());
		enterRule(_localctx, 510, RULE_cross_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2935);
			match(CROSS);
			setState(2936);
			match(JOIN);
			setState(2937);
			((Cross_joinContext)_localctx).r = table_reference();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Qualified_joinContext extends ParserRuleContext {
		public Join_typeContext t;
		public Table_primaryContext r;
		public Join_specificationContext s;
		public TerminalNode JOIN() { return getToken(SQLParser.JOIN, 0); }
		public Table_primaryContext table_primary() {
			return getRuleContext(Table_primaryContext.class,0);
		}
		public Join_specificationContext join_specification() {
			return getRuleContext(Join_specificationContext.class,0);
		}
		public Join_typeContext join_type() {
			return getRuleContext(Join_typeContext.class,0);
		}
		public Qualified_joinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualified_join; }
	}

	public final Qualified_joinContext qualified_join() throws RecognitionException {
		Qualified_joinContext _localctx = new Qualified_joinContext(_ctx, getState());
		enterRule(_localctx, 512, RULE_qualified_join);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2940);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 562967405920256L) != 0)) {
				{
				setState(2939);
				((Qualified_joinContext)_localctx).t = join_type();
				}
			}

			setState(2942);
			match(JOIN);
			setState(2943);
			((Qualified_joinContext)_localctx).r = table_primary();
			setState(2944);
			((Qualified_joinContext)_localctx).s = join_specification();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Natural_joinContext extends ParserRuleContext {
		public Join_typeContext t;
		public Table_primaryContext r;
		public TerminalNode NATURAL() { return getToken(SQLParser.NATURAL, 0); }
		public TerminalNode JOIN() { return getToken(SQLParser.JOIN, 0); }
		public Table_primaryContext table_primary() {
			return getRuleContext(Table_primaryContext.class,0);
		}
		public Join_typeContext join_type() {
			return getRuleContext(Join_typeContext.class,0);
		}
		public Natural_joinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_natural_join; }
	}

	public final Natural_joinContext natural_join() throws RecognitionException {
		Natural_joinContext _localctx = new Natural_joinContext(_ctx, getState());
		enterRule(_localctx, 514, RULE_natural_join);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2946);
			match(NATURAL);
			setState(2948);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 562967405920256L) != 0)) {
				{
				setState(2947);
				((Natural_joinContext)_localctx).t = join_type();
				}
			}

			setState(2950);
			match(JOIN);
			setState(2951);
			((Natural_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Union_joinContext extends ParserRuleContext {
		public Table_primaryContext r;
		public TerminalNode UNION() { return getToken(SQLParser.UNION, 0); }
		public TerminalNode JOIN() { return getToken(SQLParser.JOIN, 0); }
		public Table_primaryContext table_primary() {
			return getRuleContext(Table_primaryContext.class,0);
		}
		public Union_joinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_union_join; }
	}

	public final Union_joinContext union_join() throws RecognitionException {
		Union_joinContext _localctx = new Union_joinContext(_ctx, getState());
		enterRule(_localctx, 516, RULE_union_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2953);
			match(UNION);
			setState(2954);
			match(JOIN);
			setState(2955);
			((Union_joinContext)_localctx).r = table_primary();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Join_typeContext extends ParserRuleContext {
		public Outer_join_typeContext t;
		public TerminalNode INNER() { return getToken(SQLParser.INNER, 0); }
		public Outer_join_typeContext outer_join_type() {
			return getRuleContext(Outer_join_typeContext.class,0);
		}
		public Join_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_join_type; }
	}

	public final Join_typeContext join_type() throws RecognitionException {
		Join_typeContext _localctx = new Join_typeContext(_ctx, getState());
		enterRule(_localctx, 518, RULE_join_type);
		try {
			setState(2959);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INNER:
				enterOuterAlt(_localctx, 1);
				{
				setState(2957);
				match(INNER);
				}
				break;
			case FULL:
			case LEFT:
			case RIGHT:
				enterOuterAlt(_localctx, 2);
				{
				setState(2958);
				((Join_typeContext)_localctx).t = outer_join_type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Outer_join_typeContext extends ParserRuleContext {
		public Outer_join_type_part2Context outer_join_type_part2() {
			return getRuleContext(Outer_join_type_part2Context.class,0);
		}
		public TerminalNode OUTER() { return getToken(SQLParser.OUTER, 0); }
		public Outer_join_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outer_join_type; }
	}

	public final Outer_join_typeContext outer_join_type() throws RecognitionException {
		Outer_join_typeContext _localctx = new Outer_join_typeContext(_ctx, getState());
		enterRule(_localctx, 520, RULE_outer_join_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2961);
			outer_join_type_part2();
			setState(2963);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OUTER) {
				{
				setState(2962);
				match(OUTER);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Outer_join_type_part2Context extends ParserRuleContext {
		public TerminalNode LEFT() { return getToken(SQLParser.LEFT, 0); }
		public TerminalNode RIGHT() { return getToken(SQLParser.RIGHT, 0); }
		public TerminalNode FULL() { return getToken(SQLParser.FULL, 0); }
		public Outer_join_type_part2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outer_join_type_part2; }
	}

	public final Outer_join_type_part2Context outer_join_type_part2() throws RecognitionException {
		Outer_join_type_part2Context _localctx = new Outer_join_type_part2Context(_ctx, getState());
		enterRule(_localctx, 522, RULE_outer_join_type_part2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2965);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 562967137484800L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class First_rowContext extends ParserRuleContext {
		public TerminalNode FIRST() { return getToken(SQLParser.FIRST, 0); }
		public TerminalNode ROW() { return getToken(SQLParser.ROW, 0); }
		public First_rowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_first_row; }
	}

	public final First_rowContext first_row() throws RecognitionException {
		First_rowContext _localctx = new First_rowContext(_ctx, getState());
		enterRule(_localctx, 524, RULE_first_row);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2967);
			match(FIRST);
			setState(2968);
			match(ROW);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Last_rowContext extends ParserRuleContext {
		public TerminalNode LAST() { return getToken(SQLParser.LAST, 0); }
		public TerminalNode ROW() { return getToken(SQLParser.ROW, 0); }
		public Last_rowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_last_row; }
	}

	public final Last_rowContext last_row() throws RecognitionException {
		Last_rowContext _localctx = new Last_rowContext(_ctx, getState());
		enterRule(_localctx, 526, RULE_last_row);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2970);
			match(LAST);
			setState(2971);
			match(ROW);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class All_rowsContext extends ParserRuleContext {
		public TerminalNode ALL() { return getToken(SQLParser.ALL, 0); }
		public TerminalNode ROWS() { return getToken(SQLParser.ROWS, 0); }
		public All_rowsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_all_rows; }
	}

	public final All_rowsContext all_rows() throws RecognitionException {
		All_rowsContext _localctx = new All_rowsContext(_ctx, getState());
		enterRule(_localctx, 528, RULE_all_rows);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2973);
			match(ALL);
			setState(2974);
			match(ROWS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Lookup_specificationContext extends ParserRuleContext {
		public First_rowContext first_row() {
			return getRuleContext(First_rowContext.class,0);
		}
		public Orderby_clauseContext orderby_clause() {
			return getRuleContext(Orderby_clauseContext.class,0);
		}
		public Last_rowContext last_row() {
			return getRuleContext(Last_rowContext.class,0);
		}
		public All_rowsContext all_rows() {
			return getRuleContext(All_rowsContext.class,0);
		}
		public Lookup_specificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lookup_specification; }
	}

	public final Lookup_specificationContext lookup_specification() throws RecognitionException {
		Lookup_specificationContext _localctx = new Lookup_specificationContext(_ctx, getState());
		enterRule(_localctx, 530, RULE_lookup_specification);
		try {
			setState(2983);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FIRST:
				enterOuterAlt(_localctx, 1);
				{
				setState(2976);
				first_row();
				setState(2977);
				orderby_clause();
				}
				break;
			case LAST:
				enterOuterAlt(_localctx, 2);
				{
				setState(2979);
				last_row();
				setState(2980);
				orderby_clause();
				}
				break;
			case ALL:
				enterOuterAlt(_localctx, 3);
				{
				setState(2982);
				all_rows();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Join_specificationContext extends ParserRuleContext {
		public Join_conditionContext join_condition() {
			return getRuleContext(Join_conditionContext.class,0);
		}
		public Named_columns_joinContext named_columns_join() {
			return getRuleContext(Named_columns_joinContext.class,0);
		}
		public Lookup_specificationContext lookup_specification() {
			return getRuleContext(Lookup_specificationContext.class,0);
		}
		public Join_specificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_join_specification; }
	}

	public final Join_specificationContext join_specification() throws RecognitionException {
		Join_specificationContext _localctx = new Join_specificationContext(_ctx, getState());
		enterRule(_localctx, 532, RULE_join_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2987);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ON:
				{
				setState(2985);
				join_condition();
				}
				break;
			case USING:
				{
				setState(2986);
				named_columns_join();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(2990);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ALL || _la==FIRST || _la==LAST) {
				{
				setState(2989);
				lookup_specification();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Join_conditionContext extends ParserRuleContext {
		public TerminalNode ON() { return getToken(SQLParser.ON, 0); }
		public Search_conditionContext search_condition() {
			return getRuleContext(Search_conditionContext.class,0);
		}
		public Join_conditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_join_condition; }
	}

	public final Join_conditionContext join_condition() throws RecognitionException {
		Join_conditionContext _localctx = new Join_conditionContext(_ctx, getState());
		enterRule(_localctx, 534, RULE_join_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2992);
			match(ON);
			setState(2993);
			search_condition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Named_columns_joinContext extends ParserRuleContext {
		public Column_reference_listContext f;
		public TerminalNode USING() { return getToken(SQLParser.USING, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public Column_reference_listContext column_reference_list() {
			return getRuleContext(Column_reference_listContext.class,0);
		}
		public Named_columns_joinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_named_columns_join; }
	}

	public final Named_columns_joinContext named_columns_join() throws RecognitionException {
		Named_columns_joinContext _localctx = new Named_columns_joinContext(_ctx, getState());
		enterRule(_localctx, 536, RULE_named_columns_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2995);
			match(USING);
			setState(2996);
			match(LEFT_PAREN);
			setState(2997);
			((Named_columns_joinContext)_localctx).f = column_reference_list();
			setState(2998);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Table_primaryContext extends ParserRuleContext {
		public IdentifierContext alias;
		public IdentifierContext name;
		public Table_or_query_nameContext table_or_query_name() {
			return getRuleContext(Table_or_query_nameContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Column_name_listContext column_name_list() {
			return getRuleContext(Column_name_listContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode AS() { return getToken(SQLParser.AS, 0); }
		public Derived_tableContext derived_table() {
			return getRuleContext(Derived_tableContext.class,0);
		}
		public Table_functionContext table_function() {
			return getRuleContext(Table_functionContext.class,0);
		}
		public Table_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_primary; }
	}

	public final Table_primaryContext table_primary() throws RecognitionException {
		Table_primaryContext _localctx = new Table_primaryContext(_ctx, getState());
		enterRule(_localctx, 538, RULE_table_primary);
		int _la;
		try {
			setState(3034);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ASYMMETRIC:
			case BOTH:
			case CROSS:
			case CURRENT_DATE:
			case CURRENT_TIME:
			case CURRENT_TIMESTAMP:
			case DATASET:
			case FULL:
			case GROUP:
			case LIMIT:
			case MAPPING:
			case NATURAL:
			case ORDER:
			case PACKAGE:
			case PROCEDURE:
			case PROJECT:
			case REUSABLE:
			case SYMMETRIC:
			case SCENARIO:
			case TRAILING:
			case WINDOW:
			case VARIABLE:
			case POSITION:
			case OFFSET:
			case IKM:
			case LKM:
			case CKM:
			case TECHNOLOGY:
			case DESCRIPTION:
			case AVG:
			case ADD:
			case ALTER:
			case BETWEEN:
			case BY:
			case CATALOG:
			case CENTURY:
			case CHARACTER:
			case COLLECT:
			case COALESCE:
			case COLUMN:
			case COUNT:
			case CUBE:
			case CUME_DIST:
			case CURRENT:
			case STRING:
			case DAY:
			case DEFAULT:
			case DATABASE:
			case DEC:
			case DECADE:
			case DENSE_RANK:
			case DOW:
			case DOY:
			case DROP:
			case EPOCH:
			case EVERY:
			case EXCLUDE:
			case EXISTS:
			case EXPLAIN:
			case EXTERNAL:
			case EXTRACT:
			case FILTER:
			case FIRST:
			case FIRST_VALUE:
			case FOLLOWING:
			case FORMAT:
			case FUSION:
			case GROUPING:
			case HASH:
			case INDEX:
			case INSERT:
			case INTERSECTION:
			case ISODOW:
			case ISOYEAR:
			case LAG:
			case LAST:
			case LAST_VALUE:
			case LESS:
			case LIST:
			case LOCATION:
			case MAX:
			case MAXVALUE:
			case MICROSECONDS:
			case MILLENNIUM:
			case MILLISECONDS:
			case MIN:
			case MINUTE:
			case MONTH:
			case NATIONAL:
			case NULLIF:
			case NO:
			case OVERWRITE:
			case OTHERS:
			case PARTITION:
			case PARTITIONS:
			case PERCENT_RANK:
			case PRECEDING:
			case PRECISION:
			case PURGE:
			case QUARTER:
			case RANGE:
			case RANK:
			case REGEXP:
			case RENAME:
			case RESET:
			case RLIKE:
			case ROLLUP:
			case ROW:
			case ROWS:
			case ROW_NUMBER:
			case SECOND:
			case SESSION:
			case SET:
			case SIMILAR:
			case STDDEV_POP:
			case STDDEV_SAMP:
			case SUBPARTITION:
			case SUM:
			case TABLESPACE:
			case THAN:
			case TIES:
			case TIMEZONE:
			case TIMEZONE_HOUR:
			case TIMEZONE_MINUTE:
			case TRIM:
			case TO:
			case UNBOUNDED:
			case UNKNOWN:
			case VALUES:
			case VAR_SAMP:
			case VAR_POP:
			case VARYING:
			case WEEK:
			case YEAR:
			case ZONE:
			case BOOLEAN:
			case BOOL:
			case BIT:
			case VARBIT:
			case INT1:
			case INT2:
			case INT4:
			case INT8:
			case TINYINT:
			case SMALLINT:
			case INT:
			case INTEGER:
			case BIGINT:
			case FLOAT4:
			case FLOAT8:
			case REAL:
			case FLOAT:
			case DOUBLE:
			case NUMERIC:
			case ORANUMBER:
			case DECIMAL:
			case CHAR:
			case VARCHAR2:
			case VARCHAR:
			case NCHAR:
			case NVARCHAR:
			case DATE:
			case INTERVAL:
			case TIME:
			case TIMETZ:
			case TIMESTAMP:
			case TIMESTAMPTZ:
			case TEXT:
			case BINARY:
			case VARBINARY:
			case BLOB:
			case BYTEA:
			case INET4:
			case REAL_NUMBER:
			case DATASTORE:
			case ALIAS:
			case RESOURCE:
			case FILE:
			case HEADING:
			case FIXED:
			case SCD:
			case MODEL:
			case FOLDER:
			case SUBMODEL:
			case REPLACE:
			case CONTEXT:
			case XKM:
			case SEQUENCEFILE:
			case FIELDS:
			case TERMINATED:
			case SERDE:
			case SERDEPROPERTIES:
			case TEXTFILE:
			case RCFILE:
			case ORC:
			case PARQUET:
			case AVRO:
			case INPUTFORMAT:
			case OUTPUTFORMAT:
			case TEMPORARY:
			case TBLPROPERTIES:
			case REJECT:
			case PERCENT:
			case SUCCESS:
			case TYPE:
			case ODI:
			case CONTROL:
			case FLOW:
			case STATIC:
			case ACTIVE:
			case MESSAGE:
			case KEEP:
			case PIVOT:
			case UNPIVOT:
			case Regular_Identifier:
			case Quoted_Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(3000);
				table_or_query_name();
				setState(3005);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,348,_ctx) ) {
				case 1:
					{
					setState(3002);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==AS) {
						{
						setState(3001);
						match(AS);
						}
					}

					setState(3004);
					((Table_primaryContext)_localctx).alias = identifier();
					}
					break;
				}
				setState(3011);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(3007);
					match(LEFT_PAREN);
					setState(3008);
					column_name_list();
					setState(3009);
					match(RIGHT_PAREN);
					}
				}

				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(3013);
				derived_table();
				setState(3015);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(3014);
					match(AS);
					}
				}

				setState(3017);
				((Table_primaryContext)_localctx).name = identifier();
				setState(3022);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(3018);
					match(LEFT_PAREN);
					setState(3019);
					column_name_list();
					setState(3020);
					match(RIGHT_PAREN);
					}
				}

				}
				break;
			case TABLE:
				enterOuterAlt(_localctx, 3);
				{
				setState(3024);
				table_function();
				{
				setState(3025);
				match(LEFT_PAREN);
				setState(3026);
				column_name_list();
				setState(3027);
				match(RIGHT_PAREN);
				}
				setState(3030);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(3029);
					match(AS);
					}
				}

				setState(3032);
				((Table_primaryContext)_localctx).alias = identifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Target_columnContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(SQLParser.COMMA, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public Target_columnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_target_column; }
	}

	public final Target_columnContext target_column() throws RecognitionException {
		Target_columnContext _localctx = new Target_columnContext(_ctx, getState());
		enterRule(_localctx, 540, RULE_target_column);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3037);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(3036);
				match(COMMA);
				}
			}

			setState(3042);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT_SIGN) {
				{
				{
				setState(3039);
				annotation();
				}
				}
				setState(3044);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(3045);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Column_name_listContext extends ParserRuleContext {
		public List<Target_columnContext> target_column() {
			return getRuleContexts(Target_columnContext.class);
		}
		public Target_columnContext target_column(int i) {
			return getRuleContext(Target_columnContext.class,i);
		}
		public Column_name_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_name_list; }
	}

	public final Column_name_listContext column_name_list() throws RecognitionException {
		Column_name_listContext _localctx = new Column_name_listContext(_ctx, getState());
		enterRule(_localctx, 542, RULE_column_name_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3050);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 172764544106657952L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & -873698335226338561L) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & -18014398509482001L) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & 282024665415679L) != 0) || ((((_la - 261)) & ~0x3f) == 0 && ((1L << (_la - 261)) & 289101182898160613L) != 0) || ((((_la - 335)) & ~0x3f) == 0 && ((1L << (_la - 335)) & 806350857L) != 0)) {
				{
				{
				setState(3047);
				target_column();
				}
				}
				setState(3052);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Derived_tableContext extends ParserRuleContext {
		public Table_subqueryContext table_subquery() {
			return getRuleContext(Table_subqueryContext.class,0);
		}
		public Derived_tableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_derived_table; }
	}

	public final Derived_tableContext derived_table() throws RecognitionException {
		Derived_tableContext _localctx = new Derived_tableContext(_ctx, getState());
		enterRule(_localctx, 544, RULE_derived_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3053);
			table_subquery();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Where_clauseContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(SQLParser.WHERE, 0); }
		public Search_conditionContext search_condition() {
			return getRuleContext(Search_conditionContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public Where_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_where_clause; }
	}

	public final Where_clauseContext where_clause() throws RecognitionException {
		Where_clauseContext _localctx = new Where_clauseContext(_ctx, getState());
		enterRule(_localctx, 546, RULE_where_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3058);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT_SIGN) {
				{
				{
				setState(3055);
				annotation();
				}
				}
				setState(3060);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(3061);
			match(WHERE);
			setState(3062);
			search_condition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Search_conditionContext extends ParserRuleContext {
		public Value_expressionContext value_expression() {
			return getRuleContext(Value_expressionContext.class,0);
		}
		public Search_conditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_search_condition; }
	}

	public final Search_conditionContext search_condition() throws RecognitionException {
		Search_conditionContext _localctx = new Search_conditionContext(_ctx, getState());
		enterRule(_localctx, 548, RULE_search_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3064);
			value_expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Groupby_clauseContext extends ParserRuleContext {
		public Grouping_element_listContext g;
		public TerminalNode GROUP() { return getToken(SQLParser.GROUP, 0); }
		public TerminalNode BY() { return getToken(SQLParser.BY, 0); }
		public Grouping_element_listContext grouping_element_list() {
			return getRuleContext(Grouping_element_listContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public Groupby_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupby_clause; }
	}

	public final Groupby_clauseContext groupby_clause() throws RecognitionException {
		Groupby_clauseContext _localctx = new Groupby_clauseContext(_ctx, getState());
		enterRule(_localctx, 550, RULE_groupby_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3069);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT_SIGN) {
				{
				{
				setState(3066);
				annotation();
				}
				}
				setState(3071);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(3072);
			match(GROUP);
			setState(3073);
			match(BY);
			setState(3074);
			((Groupby_clauseContext)_localctx).g = grouping_element_list();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Grouping_element_listContext extends ParserRuleContext {
		public List<Grouping_elementContext> grouping_element() {
			return getRuleContexts(Grouping_elementContext.class);
		}
		public Grouping_elementContext grouping_element(int i) {
			return getRuleContext(Grouping_elementContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Grouping_element_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grouping_element_list; }
	}

	public final Grouping_element_listContext grouping_element_list() throws RecognitionException {
		Grouping_element_listContext _localctx = new Grouping_element_listContext(_ctx, getState());
		enterRule(_localctx, 552, RULE_grouping_element_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3076);
			grouping_element();
			setState(3081);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3077);
				match(COMMA);
				setState(3078);
				grouping_element();
				}
				}
				setState(3083);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Grouping_elementContext extends ParserRuleContext {
		public Rollup_listContext rollup_list() {
			return getRuleContext(Rollup_listContext.class,0);
		}
		public Cube_listContext cube_list() {
			return getRuleContext(Cube_listContext.class,0);
		}
		public Empty_grouping_setContext empty_grouping_set() {
			return getRuleContext(Empty_grouping_setContext.class,0);
		}
		public Ordinary_grouping_setContext ordinary_grouping_set() {
			return getRuleContext(Ordinary_grouping_setContext.class,0);
		}
		public Grouping_elementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grouping_element; }
	}

	public final Grouping_elementContext grouping_element() throws RecognitionException {
		Grouping_elementContext _localctx = new Grouping_elementContext(_ctx, getState());
		enterRule(_localctx, 554, RULE_grouping_element);
		try {
			setState(3088);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,360,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3084);
				rollup_list();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3085);
				cube_list();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3086);
				empty_grouping_set();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(3087);
				ordinary_grouping_set();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Ordinary_grouping_setContext extends ParserRuleContext {
		public Row_value_predicandContext row_value_predicand() {
			return getRuleContext(Row_value_predicandContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Row_value_predicand_listContext row_value_predicand_list() {
			return getRuleContext(Row_value_predicand_listContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public Ordinary_grouping_setContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ordinary_grouping_set; }
	}

	public final Ordinary_grouping_setContext ordinary_grouping_set() throws RecognitionException {
		Ordinary_grouping_setContext _localctx = new Ordinary_grouping_setContext(_ctx, getState());
		enterRule(_localctx, 556, RULE_ordinary_grouping_set);
		try {
			setState(3095);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,361,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3090);
				row_value_predicand();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3091);
				match(LEFT_PAREN);
				setState(3092);
				row_value_predicand_list();
				setState(3093);
				match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Ordinary_grouping_set_listContext extends ParserRuleContext {
		public List<Ordinary_grouping_setContext> ordinary_grouping_set() {
			return getRuleContexts(Ordinary_grouping_setContext.class);
		}
		public Ordinary_grouping_setContext ordinary_grouping_set(int i) {
			return getRuleContext(Ordinary_grouping_setContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Ordinary_grouping_set_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ordinary_grouping_set_list; }
	}

	public final Ordinary_grouping_set_listContext ordinary_grouping_set_list() throws RecognitionException {
		Ordinary_grouping_set_listContext _localctx = new Ordinary_grouping_set_listContext(_ctx, getState());
		enterRule(_localctx, 558, RULE_ordinary_grouping_set_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3097);
			ordinary_grouping_set();
			setState(3102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3098);
				match(COMMA);
				setState(3099);
				ordinary_grouping_set();
				}
				}
				setState(3104);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Rollup_listContext extends ParserRuleContext {
		public Ordinary_grouping_set_listContext c;
		public TerminalNode ROLLUP() { return getToken(SQLParser.ROLLUP, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public Ordinary_grouping_set_listContext ordinary_grouping_set_list() {
			return getRuleContext(Ordinary_grouping_set_listContext.class,0);
		}
		public Rollup_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rollup_list; }
	}

	public final Rollup_listContext rollup_list() throws RecognitionException {
		Rollup_listContext _localctx = new Rollup_listContext(_ctx, getState());
		enterRule(_localctx, 560, RULE_rollup_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3105);
			match(ROLLUP);
			setState(3106);
			match(LEFT_PAREN);
			setState(3107);
			((Rollup_listContext)_localctx).c = ordinary_grouping_set_list();
			setState(3108);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Cube_listContext extends ParserRuleContext {
		public Ordinary_grouping_set_listContext c;
		public TerminalNode CUBE() { return getToken(SQLParser.CUBE, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public Ordinary_grouping_set_listContext ordinary_grouping_set_list() {
			return getRuleContext(Ordinary_grouping_set_listContext.class,0);
		}
		public Cube_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cube_list; }
	}

	public final Cube_listContext cube_list() throws RecognitionException {
		Cube_listContext _localctx = new Cube_listContext(_ctx, getState());
		enterRule(_localctx, 562, RULE_cube_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3110);
			match(CUBE);
			setState(3111);
			match(LEFT_PAREN);
			setState(3112);
			((Cube_listContext)_localctx).c = ordinary_grouping_set_list();
			setState(3113);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Empty_grouping_setContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public Empty_grouping_setContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_empty_grouping_set; }
	}

	public final Empty_grouping_setContext empty_grouping_set() throws RecognitionException {
		Empty_grouping_setContext _localctx = new Empty_grouping_setContext(_ctx, getState());
		enterRule(_localctx, 564, RULE_empty_grouping_set);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3115);
			match(LEFT_PAREN);
			setState(3116);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Having_clauseContext extends ParserRuleContext {
		public TerminalNode HAVING() { return getToken(SQLParser.HAVING, 0); }
		public Boolean_value_expressionContext boolean_value_expression() {
			return getRuleContext(Boolean_value_expressionContext.class,0);
		}
		public Having_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_having_clause; }
	}

	public final Having_clauseContext having_clause() throws RecognitionException {
		Having_clauseContext _localctx = new Having_clauseContext(_ctx, getState());
		enterRule(_localctx, 566, RULE_having_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3118);
			match(HAVING);
			setState(3119);
			boolean_value_expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Row_value_predicand_listContext extends ParserRuleContext {
		public List<Row_value_predicandContext> row_value_predicand() {
			return getRuleContexts(Row_value_predicandContext.class);
		}
		public Row_value_predicandContext row_value_predicand(int i) {
			return getRuleContext(Row_value_predicandContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Row_value_predicand_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_row_value_predicand_list; }
	}

	public final Row_value_predicand_listContext row_value_predicand_list() throws RecognitionException {
		Row_value_predicand_listContext _localctx = new Row_value_predicand_listContext(_ctx, getState());
		enterRule(_localctx, 568, RULE_row_value_predicand_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3121);
			row_value_predicand();
			setState(3126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3122);
				match(COMMA);
				setState(3123);
				row_value_predicand();
				}
				}
				setState(3128);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Window_clauseContext extends ParserRuleContext {
		public TerminalNode WINDOW() { return getToken(SQLParser.WINDOW, 0); }
		public Window_definition_listContext window_definition_list() {
			return getRuleContext(Window_definition_listContext.class,0);
		}
		public Window_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_window_clause; }
	}

	public final Window_clauseContext window_clause() throws RecognitionException {
		Window_clauseContext _localctx = new Window_clauseContext(_ctx, getState());
		enterRule(_localctx, 570, RULE_window_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3129);
			match(WINDOW);
			setState(3130);
			window_definition_list();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Window_definition_listContext extends ParserRuleContext {
		public List<Window_definitionContext> window_definition() {
			return getRuleContexts(Window_definitionContext.class);
		}
		public Window_definitionContext window_definition(int i) {
			return getRuleContext(Window_definitionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Window_definition_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_window_definition_list; }
	}

	public final Window_definition_listContext window_definition_list() throws RecognitionException {
		Window_definition_listContext _localctx = new Window_definition_listContext(_ctx, getState());
		enterRule(_localctx, 572, RULE_window_definition_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3132);
			window_definition();
			setState(3137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3133);
				match(COMMA);
				setState(3134);
				window_definition();
				}
				}
				setState(3139);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Window_definitionContext extends ParserRuleContext {
		public Window_nameContext window_name() {
			return getRuleContext(Window_nameContext.class,0);
		}
		public TerminalNode AS() { return getToken(SQLParser.AS, 0); }
		public Window_specificationContext window_specification() {
			return getRuleContext(Window_specificationContext.class,0);
		}
		public Window_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_window_definition; }
	}

	public final Window_definitionContext window_definition() throws RecognitionException {
		Window_definitionContext _localctx = new Window_definitionContext(_ctx, getState());
		enterRule(_localctx, 574, RULE_window_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3140);
			window_name();
			setState(3141);
			match(AS);
			setState(3142);
			window_specification();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Window_nameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Window_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_window_name; }
	}

	public final Window_nameContext window_name() throws RecognitionException {
		Window_nameContext _localctx = new Window_nameContext(_ctx, getState());
		enterRule(_localctx, 576, RULE_window_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3144);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Window_specificationContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Window_specification_detailsContext window_specification_details() {
			return getRuleContext(Window_specification_detailsContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public Window_specificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_window_specification; }
	}

	public final Window_specificationContext window_specification() throws RecognitionException {
		Window_specificationContext _localctx = new Window_specificationContext(_ctx, getState());
		enterRule(_localctx, 578, RULE_window_specification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3146);
			match(LEFT_PAREN);
			setState(3147);
			window_specification_details();
			setState(3148);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Window_specification_detailsContext extends ParserRuleContext {
		public Existing_window_nameContext existing_window_name() {
			return getRuleContext(Existing_window_nameContext.class,0);
		}
		public Window_partition_clauseContext window_partition_clause() {
			return getRuleContext(Window_partition_clauseContext.class,0);
		}
		public Window_order_clauseContext window_order_clause() {
			return getRuleContext(Window_order_clauseContext.class,0);
		}
		public Window_frame_clauseContext window_frame_clause() {
			return getRuleContext(Window_frame_clauseContext.class,0);
		}
		public Window_specification_detailsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_window_specification_details; }
	}

	public final Window_specification_detailsContext window_specification_details() throws RecognitionException {
		Window_specification_detailsContext _localctx = new Window_specification_detailsContext(_ctx, getState());
		enterRule(_localctx, 580, RULE_window_specification_details);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3151);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,365,_ctx) ) {
			case 1:
				{
				setState(3150);
				existing_window_name();
				}
				break;
			}
			setState(3154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PARTITION) {
				{
				setState(3153);
				window_partition_clause();
				}
			}

			setState(3157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ORDER || _la==AT_SIGN) {
				{
				setState(3156);
				window_order_clause();
				}
			}

			setState(3160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RANGE || _la==ROWS) {
				{
				setState(3159);
				window_frame_clause();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Existing_window_nameContext extends ParserRuleContext {
		public Window_nameContext window_name() {
			return getRuleContext(Window_nameContext.class,0);
		}
		public Existing_window_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_existing_window_name; }
	}

	public final Existing_window_nameContext existing_window_name() throws RecognitionException {
		Existing_window_nameContext _localctx = new Existing_window_nameContext(_ctx, getState());
		enterRule(_localctx, 582, RULE_existing_window_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3162);
			window_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Window_partition_clauseContext extends ParserRuleContext {
		public TerminalNode PARTITION() { return getToken(SQLParser.PARTITION, 0); }
		public TerminalNode BY() { return getToken(SQLParser.BY, 0); }
		public Row_value_predicand_listContext row_value_predicand_list() {
			return getRuleContext(Row_value_predicand_listContext.class,0);
		}
		public Window_partition_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_window_partition_clause; }
	}

	public final Window_partition_clauseContext window_partition_clause() throws RecognitionException {
		Window_partition_clauseContext _localctx = new Window_partition_clauseContext(_ctx, getState());
		enterRule(_localctx, 584, RULE_window_partition_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3164);
			match(PARTITION);
			setState(3165);
			match(BY);
			setState(3166);
			row_value_predicand_list();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Window_order_clauseContext extends ParserRuleContext {
		public Orderby_clauseContext orderby_clause() {
			return getRuleContext(Orderby_clauseContext.class,0);
		}
		public Window_order_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_window_order_clause; }
	}

	public final Window_order_clauseContext window_order_clause() throws RecognitionException {
		Window_order_clauseContext _localctx = new Window_order_clauseContext(_ctx, getState());
		enterRule(_localctx, 586, RULE_window_order_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3168);
			orderby_clause();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Window_frame_clauseContext extends ParserRuleContext {
		public Window_frame_unitsContext window_frame_units() {
			return getRuleContext(Window_frame_unitsContext.class,0);
		}
		public Window_frame_extentContext window_frame_extent() {
			return getRuleContext(Window_frame_extentContext.class,0);
		}
		public Window_frame_exclusionContext window_frame_exclusion() {
			return getRuleContext(Window_frame_exclusionContext.class,0);
		}
		public Window_frame_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_window_frame_clause; }
	}

	public final Window_frame_clauseContext window_frame_clause() throws RecognitionException {
		Window_frame_clauseContext _localctx = new Window_frame_clauseContext(_ctx, getState());
		enterRule(_localctx, 588, RULE_window_frame_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3170);
			window_frame_units();
			setState(3171);
			window_frame_extent();
			setState(3173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXCLUDE) {
				{
				setState(3172);
				window_frame_exclusion();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Window_frame_unitsContext extends ParserRuleContext {
		public TerminalNode ROWS() { return getToken(SQLParser.ROWS, 0); }
		public TerminalNode RANGE() { return getToken(SQLParser.RANGE, 0); }
		public Window_frame_unitsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_window_frame_units; }
	}

	public final Window_frame_unitsContext window_frame_units() throws RecognitionException {
		Window_frame_unitsContext _localctx = new Window_frame_unitsContext(_ctx, getState());
		enterRule(_localctx, 590, RULE_window_frame_units);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3175);
			_la = _input.LA(1);
			if ( !(_la==RANGE || _la==ROWS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Window_frame_extentContext extends ParserRuleContext {
		public Window_frame_start_boundContext window_frame_start_bound() {
			return getRuleContext(Window_frame_start_boundContext.class,0);
		}
		public Window_frame_betweenContext window_frame_between() {
			return getRuleContext(Window_frame_betweenContext.class,0);
		}
		public Window_frame_extentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_window_frame_extent; }
	}

	public final Window_frame_extentContext window_frame_extent() throws RecognitionException {
		Window_frame_extentContext _localctx = new Window_frame_extentContext(_ctx, getState());
		enterRule(_localctx, 592, RULE_window_frame_extent);
		try {
			setState(3179);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FALSE:
			case TRUE:
			case CURRENT:
			case UNBOUNDED:
			case UNKNOWN:
			case DATE:
			case INTERVAL:
			case TIME:
			case TIMESTAMP:
			case NUMBER:
			case REAL_NUMBER:
			case Odi_Variable_Literal:
			case Character_String_Literal:
				enterOuterAlt(_localctx, 1);
				{
				setState(3177);
				window_frame_start_bound();
				}
				break;
			case BETWEEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(3178);
				window_frame_between();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Window_frame_start_boundContext extends ParserRuleContext {
		public TerminalNode UNBOUNDED() { return getToken(SQLParser.UNBOUNDED, 0); }
		public TerminalNode PRECEDING() { return getToken(SQLParser.PRECEDING, 0); }
		public Unsigned_value_specificationContext unsigned_value_specification() {
			return getRuleContext(Unsigned_value_specificationContext.class,0);
		}
		public TerminalNode CURRENT() { return getToken(SQLParser.CURRENT, 0); }
		public TerminalNode ROW() { return getToken(SQLParser.ROW, 0); }
		public Window_frame_start_boundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_window_frame_start_bound; }
	}

	public final Window_frame_start_boundContext window_frame_start_bound() throws RecognitionException {
		Window_frame_start_boundContext _localctx = new Window_frame_start_boundContext(_ctx, getState());
		enterRule(_localctx, 594, RULE_window_frame_start_bound);
		try {
			setState(3188);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case UNBOUNDED:
				enterOuterAlt(_localctx, 1);
				{
				setState(3181);
				match(UNBOUNDED);
				setState(3182);
				match(PRECEDING);
				}
				break;
			case FALSE:
			case TRUE:
			case UNKNOWN:
			case DATE:
			case INTERVAL:
			case TIME:
			case TIMESTAMP:
			case NUMBER:
			case REAL_NUMBER:
			case Odi_Variable_Literal:
			case Character_String_Literal:
				enterOuterAlt(_localctx, 2);
				{
				setState(3183);
				unsigned_value_specification();
				setState(3184);
				match(PRECEDING);
				}
				break;
			case CURRENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(3186);
				match(CURRENT);
				setState(3187);
				match(ROW);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Window_frame_betweenContext extends ParserRuleContext {
		public Window_frame_start_boundContext bound1;
		public Window_frame_end_boundContext bound2;
		public TerminalNode BETWEEN() { return getToken(SQLParser.BETWEEN, 0); }
		public TerminalNode AND() { return getToken(SQLParser.AND, 0); }
		public Window_frame_start_boundContext window_frame_start_bound() {
			return getRuleContext(Window_frame_start_boundContext.class,0);
		}
		public Window_frame_end_boundContext window_frame_end_bound() {
			return getRuleContext(Window_frame_end_boundContext.class,0);
		}
		public Window_frame_betweenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_window_frame_between; }
	}

	public final Window_frame_betweenContext window_frame_between() throws RecognitionException {
		Window_frame_betweenContext _localctx = new Window_frame_betweenContext(_ctx, getState());
		enterRule(_localctx, 596, RULE_window_frame_between);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3190);
			match(BETWEEN);
			setState(3191);
			((Window_frame_betweenContext)_localctx).bound1 = window_frame_start_bound();
			setState(3192);
			match(AND);
			setState(3193);
			((Window_frame_betweenContext)_localctx).bound2 = window_frame_end_bound();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Window_frame_end_boundContext extends ParserRuleContext {
		public TerminalNode UNBOUNDED() { return getToken(SQLParser.UNBOUNDED, 0); }
		public TerminalNode FOLLOWING() { return getToken(SQLParser.FOLLOWING, 0); }
		public Unsigned_value_specificationContext unsigned_value_specification() {
			return getRuleContext(Unsigned_value_specificationContext.class,0);
		}
		public TerminalNode CURRENT() { return getToken(SQLParser.CURRENT, 0); }
		public TerminalNode ROW() { return getToken(SQLParser.ROW, 0); }
		public Window_frame_end_boundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_window_frame_end_bound; }
	}

	public final Window_frame_end_boundContext window_frame_end_bound() throws RecognitionException {
		Window_frame_end_boundContext _localctx = new Window_frame_end_boundContext(_ctx, getState());
		enterRule(_localctx, 598, RULE_window_frame_end_bound);
		try {
			setState(3202);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case UNBOUNDED:
				enterOuterAlt(_localctx, 1);
				{
				setState(3195);
				match(UNBOUNDED);
				setState(3196);
				match(FOLLOWING);
				}
				break;
			case FALSE:
			case TRUE:
			case UNKNOWN:
			case DATE:
			case INTERVAL:
			case TIME:
			case TIMESTAMP:
			case NUMBER:
			case REAL_NUMBER:
			case Odi_Variable_Literal:
			case Character_String_Literal:
				enterOuterAlt(_localctx, 2);
				{
				setState(3197);
				unsigned_value_specification();
				setState(3198);
				match(FOLLOWING);
				}
				break;
			case CURRENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(3200);
				match(CURRENT);
				setState(3201);
				match(ROW);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Window_frame_exclusionContext extends ParserRuleContext {
		public TerminalNode EXCLUDE() { return getToken(SQLParser.EXCLUDE, 0); }
		public TerminalNode CURRENT() { return getToken(SQLParser.CURRENT, 0); }
		public TerminalNode ROW() { return getToken(SQLParser.ROW, 0); }
		public TerminalNode GROUP() { return getToken(SQLParser.GROUP, 0); }
		public TerminalNode TIES() { return getToken(SQLParser.TIES, 0); }
		public TerminalNode NO() { return getToken(SQLParser.NO, 0); }
		public TerminalNode OTHERS() { return getToken(SQLParser.OTHERS, 0); }
		public Window_frame_exclusionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_window_frame_exclusion; }
	}

	public final Window_frame_exclusionContext window_frame_exclusion() throws RecognitionException {
		Window_frame_exclusionContext _localctx = new Window_frame_exclusionContext(_ctx, getState());
		enterRule(_localctx, 600, RULE_window_frame_exclusion);
		try {
			setState(3214);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,373,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3204);
				match(EXCLUDE);
				setState(3205);
				match(CURRENT);
				setState(3206);
				match(ROW);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3207);
				match(EXCLUDE);
				setState(3208);
				match(GROUP);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3209);
				match(EXCLUDE);
				setState(3210);
				match(TIES);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(3211);
				match(EXCLUDE);
				setState(3212);
				match(NO);
				setState(3213);
				match(OTHERS);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Named_queryContext extends ParserRuleContext {
		public Token name;
		public TerminalNode AS() { return getToken(SQLParser.AS, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Query_expression_bodyContext query_expression_body() {
			return getRuleContext(Query_expression_bodyContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode Regular_Identifier() { return getToken(SQLParser.Regular_Identifier, 0); }
		public Named_queryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_named_query; }
	}

	public final Named_queryContext named_query() throws RecognitionException {
		Named_queryContext _localctx = new Named_queryContext(_ctx, getState());
		enterRule(_localctx, 602, RULE_named_query);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3216);
			((Named_queryContext)_localctx).name = match(Regular_Identifier);
			setState(3217);
			match(AS);
			setState(3218);
			match(LEFT_PAREN);
			setState(3219);
			query_expression_body();
			setState(3220);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class With_clauseContext extends ParserRuleContext {
		public TerminalNode WITH() { return getToken(SQLParser.WITH, 0); }
		public List<Named_queryContext> named_query() {
			return getRuleContexts(Named_queryContext.class);
		}
		public Named_queryContext named_query(int i) {
			return getRuleContext(Named_queryContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public With_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_with_clause; }
	}

	public final With_clauseContext with_clause() throws RecognitionException {
		With_clauseContext _localctx = new With_clauseContext(_ctx, getState());
		enterRule(_localctx, 604, RULE_with_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3222);
			match(WITH);
			setState(3223);
			named_query();
			setState(3228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3224);
				match(COMMA);
				setState(3225);
				named_query();
				}
				}
				setState(3230);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Query_expressionContext extends ParserRuleContext {
		public Query_expression_bodyContext query_expression_body() {
			return getRuleContext(Query_expression_bodyContext.class,0);
		}
		public With_clauseContext with_clause() {
			return getRuleContext(With_clauseContext.class,0);
		}
		public Query_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query_expression; }
	}

	public final Query_expressionContext query_expression() throws RecognitionException {
		Query_expressionContext _localctx = new Query_expressionContext(_ctx, getState());
		enterRule(_localctx, 606, RULE_query_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(3231);
				with_clause();
				}
			}

			setState(3234);
			query_expression_body();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Query_expression_bodyContext extends ParserRuleContext {
		public Non_join_query_expressionContext non_join_query_expression() {
			return getRuleContext(Non_join_query_expressionContext.class,0);
		}
		public Joined_tableContext joined_table() {
			return getRuleContext(Joined_tableContext.class,0);
		}
		public Query_expression_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query_expression_body; }
	}

	public final Query_expression_bodyContext query_expression_body() throws RecognitionException {
		Query_expression_bodyContext _localctx = new Query_expression_bodyContext(_ctx, getState());
		enterRule(_localctx, 608, RULE_query_expression_body);
		try {
			setState(3238);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,376,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3236);
				non_join_query_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3237);
				joined_table();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Non_join_query_expressionContext extends ParserRuleContext {
		public Non_join_query_termContext non_join_query_term() {
			return getRuleContext(Non_join_query_termContext.class,0);
		}
		public Joined_tableContext joined_table() {
			return getRuleContext(Joined_tableContext.class,0);
		}
		public List<Query_termContext> query_term() {
			return getRuleContexts(Query_termContext.class);
		}
		public Query_termContext query_term(int i) {
			return getRuleContext(Query_termContext.class,i);
		}
		public List<TerminalNode> UNION() { return getTokens(SQLParser.UNION); }
		public TerminalNode UNION(int i) {
			return getToken(SQLParser.UNION, i);
		}
		public List<TerminalNode> EXCEPT() { return getTokens(SQLParser.EXCEPT); }
		public TerminalNode EXCEPT(int i) {
			return getToken(SQLParser.EXCEPT, i);
		}
		public List<TerminalNode> MINUS_SET() { return getTokens(SQLParser.MINUS_SET); }
		public TerminalNode MINUS_SET(int i) {
			return getToken(SQLParser.MINUS_SET, i);
		}
		public List<TerminalNode> ALL() { return getTokens(SQLParser.ALL); }
		public TerminalNode ALL(int i) {
			return getToken(SQLParser.ALL, i);
		}
		public List<TerminalNode> DISTINCT() { return getTokens(SQLParser.DISTINCT); }
		public TerminalNode DISTINCT(int i) {
			return getToken(SQLParser.DISTINCT, i);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public Non_join_query_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_non_join_query_expression; }
	}

	public final Non_join_query_expressionContext non_join_query_expression() throws RecognitionException {
		Non_join_query_expressionContext _localctx = new Non_join_query_expressionContext(_ctx, getState());
		enterRule(_localctx, 610, RULE_non_join_query_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(3248);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,378,_ctx) ) {
			case 1:
				{
				setState(3240);
				non_join_query_term();
				}
				break;
			case 2:
				{
				setState(3241);
				joined_table();
				setState(3242);
				_la = _input.LA(1);
				if ( !(_la==EXCEPT || _la==UNION || _la==MINUS_SET) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(3244);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(3243);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(3246);
				query_term();
				}
				break;
			}
			setState(3263);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,381,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(3253);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==AT_SIGN) {
						{
						{
						setState(3250);
						annotation();
						}
						}
						setState(3255);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(3256);
					_la = _input.LA(1);
					if ( !(_la==EXCEPT || _la==UNION || _la==MINUS_SET) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(3258);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ALL || _la==DISTINCT) {
						{
						setState(3257);
						_la = _input.LA(1);
						if ( !(_la==ALL || _la==DISTINCT) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
					}

					setState(3260);
					query_term();
					}
					} 
				}
				setState(3265);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,381,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Query_termContext extends ParserRuleContext {
		public Non_join_query_termContext non_join_query_term() {
			return getRuleContext(Non_join_query_termContext.class,0);
		}
		public Joined_tableContext joined_table() {
			return getRuleContext(Joined_tableContext.class,0);
		}
		public Query_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query_term; }
	}

	public final Query_termContext query_term() throws RecognitionException {
		Query_termContext _localctx = new Query_termContext(_ctx, getState());
		enterRule(_localctx, 612, RULE_query_term);
		try {
			setState(3268);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,382,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3266);
				non_join_query_term();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3267);
				joined_table();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Non_join_query_termContext extends ParserRuleContext {
		public Non_join_query_primaryContext non_join_query_primary() {
			return getRuleContext(Non_join_query_primaryContext.class,0);
		}
		public Joined_tableContext joined_table() {
			return getRuleContext(Joined_tableContext.class,0);
		}
		public List<TerminalNode> INTERSECT() { return getTokens(SQLParser.INTERSECT); }
		public TerminalNode INTERSECT(int i) {
			return getToken(SQLParser.INTERSECT, i);
		}
		public List<Query_primaryContext> query_primary() {
			return getRuleContexts(Query_primaryContext.class);
		}
		public Query_primaryContext query_primary(int i) {
			return getRuleContext(Query_primaryContext.class,i);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public List<TerminalNode> ALL() { return getTokens(SQLParser.ALL); }
		public TerminalNode ALL(int i) {
			return getToken(SQLParser.ALL, i);
		}
		public List<TerminalNode> DISTINCT() { return getTokens(SQLParser.DISTINCT); }
		public TerminalNode DISTINCT(int i) {
			return getToken(SQLParser.DISTINCT, i);
		}
		public Non_join_query_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_non_join_query_term; }
	}

	public final Non_join_query_termContext non_join_query_term() throws RecognitionException {
		Non_join_query_termContext _localctx = new Non_join_query_termContext(_ctx, getState());
		enterRule(_localctx, 614, RULE_non_join_query_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3284);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,385,_ctx) ) {
			case 1:
				{
				setState(3270);
				non_join_query_primary();
				}
				break;
			case 2:
				{
				setState(3271);
				joined_table();
				setState(3275);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT_SIGN) {
					{
					{
					setState(3272);
					annotation();
					}
					}
					setState(3277);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(3278);
				match(INTERSECT);
				setState(3280);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(3279);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(3282);
				query_primary();
				}
				break;
			}
			setState(3293);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INTERSECT) {
				{
				{
				setState(3286);
				match(INTERSECT);
				setState(3288);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ALL || _la==DISTINCT) {
					{
					setState(3287);
					_la = _input.LA(1);
					if ( !(_la==ALL || _la==DISTINCT) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(3290);
				query_primary();
				}
				}
				setState(3295);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Query_primaryContext extends ParserRuleContext {
		public Non_join_query_primaryContext non_join_query_primary() {
			return getRuleContext(Non_join_query_primaryContext.class,0);
		}
		public Joined_tableContext joined_table() {
			return getRuleContext(Joined_tableContext.class,0);
		}
		public Query_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query_primary; }
	}

	public final Query_primaryContext query_primary() throws RecognitionException {
		Query_primaryContext _localctx = new Query_primaryContext(_ctx, getState());
		enterRule(_localctx, 616, RULE_query_primary);
		try {
			setState(3298);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,388,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3296);
				non_join_query_primary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3297);
				joined_table();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Non_join_query_primaryContext extends ParserRuleContext {
		public Simple_tableContext simple_table() {
			return getRuleContext(Simple_tableContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Non_join_query_expressionContext non_join_query_expression() {
			return getRuleContext(Non_join_query_expressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public Non_join_query_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_non_join_query_primary; }
	}

	public final Non_join_query_primaryContext non_join_query_primary() throws RecognitionException {
		Non_join_query_primaryContext _localctx = new Non_join_query_primaryContext(_ctx, getState());
		enterRule(_localctx, 618, RULE_non_join_query_primary);
		try {
			setState(3305);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SELECT:
			case TABLE:
			case AT_SIGN:
				enterOuterAlt(_localctx, 1);
				{
				setState(3300);
				simple_table();
				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(3301);
				match(LEFT_PAREN);
				setState(3302);
				non_join_query_expression();
				setState(3303);
				match(RIGHT_PAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Simple_tableContext extends ParserRuleContext {
		public Query_specificationContext query_specification() {
			return getRuleContext(Query_specificationContext.class,0);
		}
		public Explicit_tableContext explicit_table() {
			return getRuleContext(Explicit_tableContext.class,0);
		}
		public Simple_tableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_table; }
	}

	public final Simple_tableContext simple_table() throws RecognitionException {
		Simple_tableContext _localctx = new Simple_tableContext(_ctx, getState());
		enterRule(_localctx, 620, RULE_simple_table);
		try {
			setState(3309);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SELECT:
			case AT_SIGN:
				enterOuterAlt(_localctx, 1);
				{
				setState(3307);
				query_specification();
				}
				break;
			case TABLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(3308);
				explicit_table();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Explicit_tableContext extends ParserRuleContext {
		public TerminalNode TABLE() { return getToken(SQLParser.TABLE, 0); }
		public Table_or_query_nameContext table_or_query_name() {
			return getRuleContext(Table_or_query_nameContext.class,0);
		}
		public Explicit_tableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explicit_table; }
	}

	public final Explicit_tableContext explicit_table() throws RecognitionException {
		Explicit_tableContext _localctx = new Explicit_tableContext(_ctx, getState());
		enterRule(_localctx, 622, RULE_explicit_table);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3311);
			match(TABLE);
			setState(3312);
			table_or_query_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Table_or_query_nameContext extends ParserRuleContext {
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Table_or_query_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_or_query_name; }
	}

	public final Table_or_query_nameContext table_or_query_name() throws RecognitionException {
		Table_or_query_nameContext _localctx = new Table_or_query_nameContext(_ctx, getState());
		enterRule(_localctx, 624, RULE_table_or_query_name);
		try {
			setState(3316);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,391,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3314);
				table_name();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3315);
				identifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Table_nameContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(SQLParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(SQLParser.DOT, i);
		}
		public Mapping_nameContext mapping_name() {
			return getRuleContext(Mapping_nameContext.class,0);
		}
		public Table_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_name; }
	}

	public final Table_nameContext table_name() throws RecognitionException {
		Table_nameContext _localctx = new Table_nameContext(_ctx, getState());
		enterRule(_localctx, 626, RULE_table_name);
		int _la;
		try {
			setState(3328);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,394,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3318);
				identifier();
				setState(3325);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOT) {
					{
					setState(3319);
					match(DOT);
					setState(3320);
					identifier();
					setState(3323);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==DOT) {
						{
						setState(3321);
						match(DOT);
						setState(3322);
						identifier();
						}
					}

					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3327);
				mapping_name();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Column_nameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Column_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_name; }
	}

	public final Column_nameContext column_name() throws RecognitionException {
		Column_nameContext _localctx = new Column_nameContext(_ctx, getState());
		enterRule(_localctx, 628, RULE_column_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3330);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Folder_nameContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(SQLParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(SQLParser.DOT, i);
		}
		public Folder_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_folder_name; }
	}

	public final Folder_nameContext folder_name() throws RecognitionException {
		Folder_nameContext _localctx = new Folder_nameContext(_ctx, getState());
		enterRule(_localctx, 630, RULE_folder_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3332);
			identifier();
			setState(3335); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(3333);
				match(DOT);
				setState(3334);
				identifier();
				}
				}
				setState(3337); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DOT );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Mapping_nameContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(SQLParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(SQLParser.DOT, i);
		}
		public Mapping_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapping_name; }
	}

	public final Mapping_nameContext mapping_name() throws RecognitionException {
		Mapping_nameContext _localctx = new Mapping_nameContext(_ctx, getState());
		enterRule(_localctx, 632, RULE_mapping_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3339);
			identifier();
			setState(3340);
			match(DOT);
			setState(3341);
			identifier();
			setState(3342);
			match(DOT);
			setState(3343);
			identifier();
			setState(3348);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(3344);
				match(DOT);
				setState(3345);
				identifier();
				}
				}
				setState(3350);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Dataset_hintContext extends ParserRuleContext {
		public TerminalNode Hint_Start() { return getToken(SQLParser.Hint_Start, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode Hint_End() { return getToken(SQLParser.Hint_End, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public Dataset_hintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataset_hint; }
	}

	public final Dataset_hintContext dataset_hint() throws RecognitionException {
		Dataset_hintContext _localctx = new Dataset_hintContext(_ctx, getState());
		enterRule(_localctx, 634, RULE_dataset_hint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3351);
			match(Hint_Start);
			setState(3352);
			identifier();
			setState(3357);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LEFT_PAREN) {
				{
				setState(3353);
				match(LEFT_PAREN);
				setState(3354);
				identifier();
				setState(3355);
				match(RIGHT_PAREN);
				}
			}

			setState(3359);
			match(Hint_End);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Query_specificationContext extends ParserRuleContext {
		public TerminalNode SELECT() { return getToken(SQLParser.SELECT, 0); }
		public Select_listContext select_list() {
			return getRuleContext(Select_listContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public Dataset_hintContext dataset_hint() {
			return getRuleContext(Dataset_hintContext.class,0);
		}
		public Set_qualifierContext set_qualifier() {
			return getRuleContext(Set_qualifierContext.class,0);
		}
		public Table_expressionContext table_expression() {
			return getRuleContext(Table_expressionContext.class,0);
		}
		public Query_specificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query_specification; }
	}

	public final Query_specificationContext query_specification() throws RecognitionException {
		Query_specificationContext _localctx = new Query_specificationContext(_ctx, getState());
		enterRule(_localctx, 636, RULE_query_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3364);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT_SIGN) {
				{
				{
				setState(3361);
				annotation();
				}
				}
				setState(3366);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(3367);
			match(SELECT);
			setState(3369);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Hint_Start) {
				{
				setState(3368);
				dataset_hint();
				}
			}

			setState(3372);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ALL || _la==DISTINCT) {
				{
				setState(3371);
				set_qualifier();
				}
			}

			setState(3374);
			select_list();
			setState(3376);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(3375);
				table_expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Select_listContext extends ParserRuleContext {
		public List<Select_sublistContext> select_sublist() {
			return getRuleContexts(Select_sublistContext.class);
		}
		public Select_sublistContext select_sublist(int i) {
			return getRuleContext(Select_sublistContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Select_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_list; }
	}

	public final Select_listContext select_list() throws RecognitionException {
		Select_listContext _localctx = new Select_listContext(_ctx, getState());
		enterRule(_localctx, 638, RULE_select_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3378);
			select_sublist();
			setState(3383);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3379);
				match(COMMA);
				setState(3380);
				select_sublist();
				}
				}
				setState(3385);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Select_sublistContext extends ParserRuleContext {
		public Derived_columnContext derived_column() {
			return getRuleContext(Derived_columnContext.class,0);
		}
		public Qualified_asteriskContext qualified_asterisk() {
			return getRuleContext(Qualified_asteriskContext.class,0);
		}
		public Select_sublistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_sublist; }
	}

	public final Select_sublistContext select_sublist() throws RecognitionException {
		Select_sublistContext _localctx = new Select_sublistContext(_ctx, getState());
		enterRule(_localctx, 640, RULE_select_sublist);
		try {
			setState(3388);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,403,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3386);
				derived_column();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3387);
				qualified_asterisk();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Derived_columnContext extends ParserRuleContext {
		public Value_expressionContext value_expression() {
			return getRuleContext(Value_expressionContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public As_clauseContext as_clause() {
			return getRuleContext(As_clauseContext.class,0);
		}
		public Derived_columnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_derived_column; }
	}

	public final Derived_columnContext derived_column() throws RecognitionException {
		Derived_columnContext _localctx = new Derived_columnContext(_ctx, getState());
		enterRule(_localctx, 642, RULE_derived_column);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(3393);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,404,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(3390);
					annotation();
					}
					} 
				}
				setState(3395);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,404,_ctx);
			}
			setState(3396);
			value_expression();
			setState(3398);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,405,_ctx) ) {
			case 1:
				{
				setState(3397);
				as_clause();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Qualified_asteriskContext extends ParserRuleContext {
		public IdentifierContext tb_name;
		public TerminalNode MULTIPLY() { return getToken(SQLParser.MULTIPLY, 0); }
		public TerminalNode DOT() { return getToken(SQLParser.DOT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Qualified_asteriskContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualified_asterisk; }
	}

	public final Qualified_asteriskContext qualified_asterisk() throws RecognitionException {
		Qualified_asteriskContext _localctx = new Qualified_asteriskContext(_ctx, getState());
		enterRule(_localctx, 644, RULE_qualified_asterisk);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3403);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 172764544106657952L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & -873698335226338561L) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & -18014398509482001L) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & 549688705023L) != 0) || ((((_la - 263)) & ~0x3f) == 0 && ((1L << (_la - 263)) & 72275295724540153L) != 0) || ((((_la - 335)) & ~0x3f) == 0 && ((1L << (_la - 335)) & 806350857L) != 0)) {
				{
				setState(3400);
				((Qualified_asteriskContext)_localctx).tb_name = identifier();
				setState(3401);
				match(DOT);
				}
			}

			setState(3405);
			match(MULTIPLY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Set_qualifierContext extends ParserRuleContext {
		public TerminalNode DISTINCT() { return getToken(SQLParser.DISTINCT, 0); }
		public TerminalNode ALL() { return getToken(SQLParser.ALL, 0); }
		public Set_qualifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set_qualifier; }
	}

	public final Set_qualifierContext set_qualifier() throws RecognitionException {
		Set_qualifierContext _localctx = new Set_qualifierContext(_ctx, getState());
		enterRule(_localctx, 646, RULE_set_qualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3407);
			_la = _input.LA(1);
			if ( !(_la==ALL || _la==DISTINCT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Column_referenceContext extends ParserRuleContext {
		public IdentifierContext db_name;
		public IdentifierContext tb_name;
		public IdentifierContext name;
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(SQLParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(SQLParser.DOT, i);
		}
		public Column_referenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_reference; }
	}

	public final Column_referenceContext column_reference() throws RecognitionException {
		Column_referenceContext _localctx = new Column_referenceContext(_ctx, getState());
		enterRule(_localctx, 648, RULE_column_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3417);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,408,_ctx) ) {
			case 1:
				{
				setState(3412);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,407,_ctx) ) {
				case 1:
					{
					setState(3409);
					((Column_referenceContext)_localctx).db_name = identifier();
					setState(3410);
					match(DOT);
					}
					break;
				}
				{
				setState(3414);
				((Column_referenceContext)_localctx).tb_name = identifier();
				setState(3415);
				match(DOT);
				}
				}
				break;
			}
			setState(3419);
			((Column_referenceContext)_localctx).name = identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class As_clauseContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode AS() { return getToken(SQLParser.AS, 0); }
		public As_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_as_clause; }
	}

	public final As_clauseContext as_clause() throws RecognitionException {
		As_clauseContext _localctx = new As_clauseContext(_ctx, getState());
		enterRule(_localctx, 650, RULE_as_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3422);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(3421);
				match(AS);
				}
			}

			setState(3424);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Column_reference_listContext extends ParserRuleContext {
		public List<Column_referenceContext> column_reference() {
			return getRuleContexts(Column_referenceContext.class);
		}
		public Column_referenceContext column_reference(int i) {
			return getRuleContext(Column_referenceContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Column_reference_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_reference_list; }
	}

	public final Column_reference_listContext column_reference_list() throws RecognitionException {
		Column_reference_listContext _localctx = new Column_reference_listContext(_ctx, getState());
		enterRule(_localctx, 652, RULE_column_reference_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3426);
			column_reference();
			setState(3431);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3427);
				match(COMMA);
				setState(3428);
				column_reference();
				}
				}
				setState(3433);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Cursor_functionContext extends ParserRuleContext {
		public TerminalNode CURSOR() { return getToken(SQLParser.CURSOR, 0); }
		public Table_subqueryContext table_subquery() {
			return getRuleContext(Table_subqueryContext.class,0);
		}
		public Cursor_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cursor_function; }
	}

	public final Cursor_functionContext cursor_function() throws RecognitionException {
		Cursor_functionContext _localctx = new Cursor_functionContext(_ctx, getState());
		enterRule(_localctx, 654, RULE_cursor_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3434);
			match(CURSOR);
			setState(3435);
			table_subquery();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Scalar_subqueryContext extends ParserRuleContext {
		public SubqueryContext subquery() {
			return getRuleContext(SubqueryContext.class,0);
		}
		public Scalar_subqueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scalar_subquery; }
	}

	public final Scalar_subqueryContext scalar_subquery() throws RecognitionException {
		Scalar_subqueryContext _localctx = new Scalar_subqueryContext(_ctx, getState());
		enterRule(_localctx, 656, RULE_scalar_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3437);
			subquery();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Row_subqueryContext extends ParserRuleContext {
		public SubqueryContext subquery() {
			return getRuleContext(SubqueryContext.class,0);
		}
		public Row_subqueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_row_subquery; }
	}

	public final Row_subqueryContext row_subquery() throws RecognitionException {
		Row_subqueryContext _localctx = new Row_subqueryContext(_ctx, getState());
		enterRule(_localctx, 658, RULE_row_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3439);
			subquery();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Table_subqueryContext extends ParserRuleContext {
		public SubqueryContext subquery() {
			return getRuleContext(SubqueryContext.class,0);
		}
		public Table_subqueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_subquery; }
	}

	public final Table_subqueryContext table_subquery() throws RecognitionException {
		Table_subqueryContext _localctx = new Table_subqueryContext(_ctx, getState());
		enterRule(_localctx, 660, RULE_table_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3441);
			subquery();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SubqueryContext extends ParserRuleContext {
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Query_expressionContext query_expression() {
			return getRuleContext(Query_expressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public SubqueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subquery; }
	}

	public final SubqueryContext subquery() throws RecognitionException {
		SubqueryContext _localctx = new SubqueryContext(_ctx, getState());
		enterRule(_localctx, 662, RULE_subquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3443);
			match(LEFT_PAREN);
			setState(3444);
			query_expression();
			setState(3445);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PredicateContext extends ParserRuleContext {
		public Quantified_comparison_predicateContext quantified_comparison_predicate() {
			return getRuleContext(Quantified_comparison_predicateContext.class,0);
		}
		public Comparison_predicateContext comparison_predicate() {
			return getRuleContext(Comparison_predicateContext.class,0);
		}
		public Between_predicateContext between_predicate() {
			return getRuleContext(Between_predicateContext.class,0);
		}
		public In_predicateContext in_predicate() {
			return getRuleContext(In_predicateContext.class,0);
		}
		public Pattern_matching_predicateContext pattern_matching_predicate() {
			return getRuleContext(Pattern_matching_predicateContext.class,0);
		}
		public Null_predicateContext null_predicate() {
			return getRuleContext(Null_predicateContext.class,0);
		}
		public Exists_predicateContext exists_predicate() {
			return getRuleContext(Exists_predicateContext.class,0);
		}
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 664, RULE_predicate);
		try {
			setState(3454);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,411,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3447);
				quantified_comparison_predicate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3448);
				comparison_predicate();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3449);
				between_predicate();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(3450);
				in_predicate();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(3451);
				pattern_matching_predicate();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(3452);
				null_predicate();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(3453);
				exists_predicate();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Quantified_comparison_predicateContext extends ParserRuleContext {
		public Common_value_expressionContext l;
		public Comp_opContext c;
		public QuantifierContext q;
		public Table_subqueryContext s;
		public Common_value_expressionContext common_value_expression() {
			return getRuleContext(Common_value_expressionContext.class,0);
		}
		public Comp_opContext comp_op() {
			return getRuleContext(Comp_opContext.class,0);
		}
		public Table_subqueryContext table_subquery() {
			return getRuleContext(Table_subqueryContext.class,0);
		}
		public QuantifierContext quantifier() {
			return getRuleContext(QuantifierContext.class,0);
		}
		public Quantified_comparison_predicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantified_comparison_predicate; }
	}

	public final Quantified_comparison_predicateContext quantified_comparison_predicate() throws RecognitionException {
		Quantified_comparison_predicateContext _localctx = new Quantified_comparison_predicateContext(_ctx, getState());
		enterRule(_localctx, 666, RULE_quantified_comparison_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3456);
			((Quantified_comparison_predicateContext)_localctx).l = common_value_expression();
			setState(3457);
			((Quantified_comparison_predicateContext)_localctx).c = comp_op();
			setState(3459);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4503599627370516L) != 0)) {
				{
				setState(3458);
				((Quantified_comparison_predicateContext)_localctx).q = quantifier();
				}
			}

			setState(3461);
			((Quantified_comparison_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QuantifierContext extends ParserRuleContext {
		public AllContext all() {
			return getRuleContext(AllContext.class,0);
		}
		public SomeContext some() {
			return getRuleContext(SomeContext.class,0);
		}
		public QuantifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantifier; }
	}

	public final QuantifierContext quantifier() throws RecognitionException {
		QuantifierContext _localctx = new QuantifierContext(_ctx, getState());
		enterRule(_localctx, 668, RULE_quantifier);
		try {
			setState(3465);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ALL:
				enterOuterAlt(_localctx, 1);
				{
				setState(3463);
				all();
				}
				break;
			case ANY:
			case SOME:
				enterOuterAlt(_localctx, 2);
				{
				setState(3464);
				some();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AllContext extends ParserRuleContext {
		public TerminalNode ALL() { return getToken(SQLParser.ALL, 0); }
		public AllContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_all; }
	}

	public final AllContext all() throws RecognitionException {
		AllContext _localctx = new AllContext(_ctx, getState());
		enterRule(_localctx, 670, RULE_all);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3467);
			match(ALL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SomeContext extends ParserRuleContext {
		public TerminalNode SOME() { return getToken(SQLParser.SOME, 0); }
		public TerminalNode ANY() { return getToken(SQLParser.ANY, 0); }
		public SomeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_some; }
	}

	public final SomeContext some() throws RecognitionException {
		SomeContext _localctx = new SomeContext(_ctx, getState());
		enterRule(_localctx, 672, RULE_some);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3469);
			_la = _input.LA(1);
			if ( !(_la==ANY || _la==SOME) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Comparison_predicateContext extends ParserRuleContext {
		public Row_value_predicandContext left;
		public Comp_opContext c;
		public Row_value_predicandContext right;
		public List<Row_value_predicandContext> row_value_predicand() {
			return getRuleContexts(Row_value_predicandContext.class);
		}
		public Row_value_predicandContext row_value_predicand(int i) {
			return getRuleContext(Row_value_predicandContext.class,i);
		}
		public Comp_opContext comp_op() {
			return getRuleContext(Comp_opContext.class,0);
		}
		public Comparison_predicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison_predicate; }
	}

	public final Comparison_predicateContext comparison_predicate() throws RecognitionException {
		Comparison_predicateContext _localctx = new Comparison_predicateContext(_ctx, getState());
		enterRule(_localctx, 674, RULE_comparison_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3471);
			((Comparison_predicateContext)_localctx).left = row_value_predicand();
			setState(3472);
			((Comparison_predicateContext)_localctx).c = comp_op();
			setState(3473);
			((Comparison_predicateContext)_localctx).right = row_value_predicand();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Comp_opContext extends ParserRuleContext {
		public TerminalNode EQUAL() { return getToken(SQLParser.EQUAL, 0); }
		public TerminalNode NOT_EQUAL() { return getToken(SQLParser.NOT_EQUAL, 0); }
		public TerminalNode LTH() { return getToken(SQLParser.LTH, 0); }
		public TerminalNode LEQ() { return getToken(SQLParser.LEQ, 0); }
		public TerminalNode GTH() { return getToken(SQLParser.GTH, 0); }
		public TerminalNode GEQ() { return getToken(SQLParser.GEQ, 0); }
		public Comp_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comp_op; }
	}

	public final Comp_opContext comp_op() throws RecognitionException {
		Comp_opContext _localctx = new Comp_opContext(_ctx, getState());
		enterRule(_localctx, 676, RULE_comp_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3475);
			_la = _input.LA(1);
			if ( !(((((_la - 238)) & ~0x3f) == 0 && ((1L << (_la - 238)) & 993L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Between_predicateContext extends ParserRuleContext {
		public Row_value_predicandContext predicand;
		public Between_predicate_part_2Context between_predicate_part_2() {
			return getRuleContext(Between_predicate_part_2Context.class,0);
		}
		public Row_value_predicandContext row_value_predicand() {
			return getRuleContext(Row_value_predicandContext.class,0);
		}
		public Between_predicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_between_predicate; }
	}

	public final Between_predicateContext between_predicate() throws RecognitionException {
		Between_predicateContext _localctx = new Between_predicateContext(_ctx, getState());
		enterRule(_localctx, 678, RULE_between_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3477);
			((Between_predicateContext)_localctx).predicand = row_value_predicand();
			setState(3478);
			between_predicate_part_2();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Between_predicate_part_2Context extends ParserRuleContext {
		public Row_value_predicandContext begin;
		public Row_value_predicandContext end;
		public TerminalNode BETWEEN() { return getToken(SQLParser.BETWEEN, 0); }
		public TerminalNode AND() { return getToken(SQLParser.AND, 0); }
		public List<Row_value_predicandContext> row_value_predicand() {
			return getRuleContexts(Row_value_predicandContext.class);
		}
		public Row_value_predicandContext row_value_predicand(int i) {
			return getRuleContext(Row_value_predicandContext.class,i);
		}
		public TerminalNode NOT() { return getToken(SQLParser.NOT, 0); }
		public TerminalNode ASYMMETRIC() { return getToken(SQLParser.ASYMMETRIC, 0); }
		public TerminalNode SYMMETRIC() { return getToken(SQLParser.SYMMETRIC, 0); }
		public Between_predicate_part_2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_between_predicate_part_2; }
	}

	public final Between_predicate_part_2Context between_predicate_part_2() throws RecognitionException {
		Between_predicate_part_2Context _localctx = new Between_predicate_part_2Context(_ctx, getState());
		enterRule(_localctx, 680, RULE_between_predicate_part_2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3481);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(3480);
				match(NOT);
				}
			}

			setState(3483);
			match(BETWEEN);
			setState(3485);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,415,_ctx) ) {
			case 1:
				{
				setState(3484);
				_la = _input.LA(1);
				if ( !(_la==ASYMMETRIC || _la==SYMMETRIC) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
			setState(3487);
			((Between_predicate_part_2Context)_localctx).begin = row_value_predicand();
			setState(3488);
			match(AND);
			setState(3489);
			((Between_predicate_part_2Context)_localctx).end = row_value_predicand();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class In_predicateContext extends ParserRuleContext {
		public Common_value_expressionContext common_value_expression() {
			return getRuleContext(Common_value_expressionContext.class,0);
		}
		public TerminalNode IN() { return getToken(SQLParser.IN, 0); }
		public In_predicate_valueContext in_predicate_value() {
			return getRuleContext(In_predicate_valueContext.class,0);
		}
		public TerminalNode NOT() { return getToken(SQLParser.NOT, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Row_value_predicand_listContext row_value_predicand_list() {
			return getRuleContext(Row_value_predicand_listContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public In_predicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_in_predicate; }
	}

	public final In_predicateContext in_predicate() throws RecognitionException {
		In_predicateContext _localctx = new In_predicateContext(_ctx, getState());
		enterRule(_localctx, 682, RULE_in_predicate);
		int _la;
		try {
			setState(3507);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,418,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3491);
				common_value_expression();
				setState(3493);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(3492);
					match(NOT);
					}
				}

				setState(3495);
				match(IN);
				setState(3496);
				in_predicate_value();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3498);
				match(LEFT_PAREN);
				setState(3499);
				row_value_predicand_list();
				setState(3500);
				match(RIGHT_PAREN);
				setState(3502);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(3501);
					match(NOT);
					}
				}

				setState(3504);
				match(IN);
				setState(3505);
				in_predicate_value();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class In_predicate_valueContext extends ParserRuleContext {
		public Table_subqueryContext table_subquery() {
			return getRuleContext(Table_subqueryContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public In_value_listContext in_value_list() {
			return getRuleContext(In_value_listContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public In_predicate_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_in_predicate_value; }
	}

	public final In_predicate_valueContext in_predicate_value() throws RecognitionException {
		In_predicate_valueContext _localctx = new In_predicate_valueContext(_ctx, getState());
		enterRule(_localctx, 684, RULE_in_predicate_value);
		try {
			setState(3514);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,419,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3509);
				table_subquery();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3510);
				match(LEFT_PAREN);
				setState(3511);
				in_value_list();
				setState(3512);
				match(RIGHT_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class In_value_listContext extends ParserRuleContext {
		public List<Row_value_predicandContext> row_value_predicand() {
			return getRuleContexts(Row_value_predicandContext.class);
		}
		public Row_value_predicandContext row_value_predicand(int i) {
			return getRuleContext(Row_value_predicandContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public In_value_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_in_value_list; }
	}

	public final In_value_listContext in_value_list() throws RecognitionException {
		In_value_listContext _localctx = new In_value_listContext(_ctx, getState());
		enterRule(_localctx, 686, RULE_in_value_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3516);
			row_value_predicand();
			setState(3521);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3517);
				match(COMMA);
				setState(3518);
				row_value_predicand();
				}
				}
				setState(3523);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Pattern_matching_predicateContext extends ParserRuleContext {
		public Row_value_predicandContext f;
		public Row_value_predicandContext s;
		public Pattern_matcherContext pattern_matcher() {
			return getRuleContext(Pattern_matcherContext.class,0);
		}
		public List<Row_value_predicandContext> row_value_predicand() {
			return getRuleContexts(Row_value_predicandContext.class);
		}
		public Row_value_predicandContext row_value_predicand(int i) {
			return getRuleContext(Row_value_predicandContext.class,i);
		}
		public Pattern_matching_predicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern_matching_predicate; }
	}

	public final Pattern_matching_predicateContext pattern_matching_predicate() throws RecognitionException {
		Pattern_matching_predicateContext _localctx = new Pattern_matching_predicateContext(_ctx, getState());
		enterRule(_localctx, 688, RULE_pattern_matching_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3524);
			((Pattern_matching_predicateContext)_localctx).f = row_value_predicand();
			setState(3525);
			pattern_matcher();
			setState(3526);
			((Pattern_matching_predicateContext)_localctx).s = row_value_predicand();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Pattern_matcherContext extends ParserRuleContext {
		public Negativable_matcherContext negativable_matcher() {
			return getRuleContext(Negativable_matcherContext.class,0);
		}
		public TerminalNode NOT() { return getToken(SQLParser.NOT, 0); }
		public Regex_matcherContext regex_matcher() {
			return getRuleContext(Regex_matcherContext.class,0);
		}
		public Pattern_matcherContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern_matcher; }
	}

	public final Pattern_matcherContext pattern_matcher() throws RecognitionException {
		Pattern_matcherContext _localctx = new Pattern_matcherContext(_ctx, getState());
		enterRule(_localctx, 690, RULE_pattern_matcher);
		int _la;
		try {
			setState(3533);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ILIKE:
			case LIKE:
			case NOT:
			case REGEXP:
			case RLIKE:
			case SIMILAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(3529);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(3528);
					match(NOT);
					}
				}

				setState(3531);
				negativable_matcher();
				}
				break;
			case Similar_To:
			case Not_Similar_To:
			case Similar_To_Case_Insensitive:
			case Not_Similar_To_Case_Insensitive:
				enterOuterAlt(_localctx, 2);
				{
				setState(3532);
				regex_matcher();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Negativable_matcherContext extends ParserRuleContext {
		public TerminalNode LIKE() { return getToken(SQLParser.LIKE, 0); }
		public TerminalNode ILIKE() { return getToken(SQLParser.ILIKE, 0); }
		public TerminalNode SIMILAR() { return getToken(SQLParser.SIMILAR, 0); }
		public TerminalNode TO() { return getToken(SQLParser.TO, 0); }
		public TerminalNode REGEXP() { return getToken(SQLParser.REGEXP, 0); }
		public TerminalNode RLIKE() { return getToken(SQLParser.RLIKE, 0); }
		public Negativable_matcherContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_negativable_matcher; }
	}

	public final Negativable_matcherContext negativable_matcher() throws RecognitionException {
		Negativable_matcherContext _localctx = new Negativable_matcherContext(_ctx, getState());
		enterRule(_localctx, 692, RULE_negativable_matcher);
		try {
			setState(3541);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LIKE:
				enterOuterAlt(_localctx, 1);
				{
				setState(3535);
				match(LIKE);
				}
				break;
			case ILIKE:
				enterOuterAlt(_localctx, 2);
				{
				setState(3536);
				match(ILIKE);
				}
				break;
			case SIMILAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(3537);
				match(SIMILAR);
				setState(3538);
				match(TO);
				}
				break;
			case REGEXP:
				enterOuterAlt(_localctx, 4);
				{
				setState(3539);
				match(REGEXP);
				}
				break;
			case RLIKE:
				enterOuterAlt(_localctx, 5);
				{
				setState(3540);
				match(RLIKE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Regex_matcherContext extends ParserRuleContext {
		public TerminalNode Similar_To() { return getToken(SQLParser.Similar_To, 0); }
		public TerminalNode Not_Similar_To() { return getToken(SQLParser.Not_Similar_To, 0); }
		public TerminalNode Similar_To_Case_Insensitive() { return getToken(SQLParser.Similar_To_Case_Insensitive, 0); }
		public TerminalNode Not_Similar_To_Case_Insensitive() { return getToken(SQLParser.Not_Similar_To_Case_Insensitive, 0); }
		public Regex_matcherContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regex_matcher; }
	}

	public final Regex_matcherContext regex_matcher() throws RecognitionException {
		Regex_matcherContext _localctx = new Regex_matcherContext(_ctx, getState());
		enterRule(_localctx, 694, RULE_regex_matcher);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3543);
			_la = _input.LA(1);
			if ( !(((((_la - 232)) & ~0x3f) == 0 && ((1L << (_la - 232)) & 15L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Null_predicateContext extends ParserRuleContext {
		public Row_value_predicandContext predicand;
		public Token n;
		public TerminalNode IS() { return getToken(SQLParser.IS, 0); }
		public TerminalNode NULL() { return getToken(SQLParser.NULL, 0); }
		public Row_value_predicandContext row_value_predicand() {
			return getRuleContext(Row_value_predicandContext.class,0);
		}
		public TerminalNode NOT() { return getToken(SQLParser.NOT, 0); }
		public Null_predicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_null_predicate; }
	}

	public final Null_predicateContext null_predicate() throws RecognitionException {
		Null_predicateContext _localctx = new Null_predicateContext(_ctx, getState());
		enterRule(_localctx, 696, RULE_null_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3545);
			((Null_predicateContext)_localctx).predicand = row_value_predicand();
			setState(3546);
			match(IS);
			setState(3548);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(3547);
				((Null_predicateContext)_localctx).n = match(NOT);
				}
			}

			setState(3550);
			match(NULL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Exists_predicateContext extends ParserRuleContext {
		public Table_subqueryContext s;
		public TerminalNode EXISTS() { return getToken(SQLParser.EXISTS, 0); }
		public Table_subqueryContext table_subquery() {
			return getRuleContext(Table_subqueryContext.class,0);
		}
		public TerminalNode NOT() { return getToken(SQLParser.NOT, 0); }
		public Exists_predicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exists_predicate; }
	}

	public final Exists_predicateContext exists_predicate() throws RecognitionException {
		Exists_predicateContext _localctx = new Exists_predicateContext(_ctx, getState());
		enterRule(_localctx, 698, RULE_exists_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3553);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(3552);
				match(NOT);
				}
			}

			setState(3555);
			match(EXISTS);
			setState(3556);
			((Exists_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Unique_predicateContext extends ParserRuleContext {
		public Table_subqueryContext s;
		public TerminalNode UNIQUE() { return getToken(SQLParser.UNIQUE, 0); }
		public Table_subqueryContext table_subquery() {
			return getRuleContext(Table_subqueryContext.class,0);
		}
		public Unique_predicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unique_predicate; }
	}

	public final Unique_predicateContext unique_predicate() throws RecognitionException {
		Unique_predicateContext _localctx = new Unique_predicateContext(_ctx, getState());
		enterRule(_localctx, 700, RULE_unique_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3558);
			match(UNIQUE);
			setState(3559);
			((Unique_predicateContext)_localctx).s = table_subquery();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Primary_datetime_fieldContext extends ParserRuleContext {
		public Non_second_primary_datetime_fieldContext non_second_primary_datetime_field() {
			return getRuleContext(Non_second_primary_datetime_fieldContext.class,0);
		}
		public TerminalNode SECOND() { return getToken(SQLParser.SECOND, 0); }
		public Primary_datetime_fieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary_datetime_field; }
	}

	public final Primary_datetime_fieldContext primary_datetime_field() throws RecognitionException {
		Primary_datetime_fieldContext _localctx = new Primary_datetime_fieldContext(_ctx, getState());
		enterRule(_localctx, 702, RULE_primary_datetime_field);
		try {
			setState(3563);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DAY:
			case HOUR:
			case MINUTE:
			case MONTH:
			case YEAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(3561);
				non_second_primary_datetime_field();
				}
				break;
			case SECOND:
				enterOuterAlt(_localctx, 2);
				{
				setState(3562);
				match(SECOND);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Non_second_primary_datetime_fieldContext extends ParserRuleContext {
		public TerminalNode YEAR() { return getToken(SQLParser.YEAR, 0); }
		public TerminalNode MONTH() { return getToken(SQLParser.MONTH, 0); }
		public TerminalNode DAY() { return getToken(SQLParser.DAY, 0); }
		public TerminalNode HOUR() { return getToken(SQLParser.HOUR, 0); }
		public TerminalNode MINUTE() { return getToken(SQLParser.MINUTE, 0); }
		public Non_second_primary_datetime_fieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_non_second_primary_datetime_field; }
	}

	public final Non_second_primary_datetime_fieldContext non_second_primary_datetime_field() throws RecognitionException {
		Non_second_primary_datetime_fieldContext _localctx = new Non_second_primary_datetime_fieldContext(_ctx, getState());
		enterRule(_localctx, 704, RULE_non_second_primary_datetime_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3565);
			_la = _input.LA(1);
			if ( !(((((_la - 98)) & ~0x3f) == 0 && ((1L << (_la - 98)) & 105553149820929L) != 0) || _la==YEAR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Extended_datetime_fieldContext extends ParserRuleContext {
		public TerminalNode CENTURY() { return getToken(SQLParser.CENTURY, 0); }
		public TerminalNode DECADE() { return getToken(SQLParser.DECADE, 0); }
		public TerminalNode DOW() { return getToken(SQLParser.DOW, 0); }
		public TerminalNode DOY() { return getToken(SQLParser.DOY, 0); }
		public TerminalNode EPOCH() { return getToken(SQLParser.EPOCH, 0); }
		public TerminalNode ISODOW() { return getToken(SQLParser.ISODOW, 0); }
		public TerminalNode ISOYEAR() { return getToken(SQLParser.ISOYEAR, 0); }
		public TerminalNode MICROSECONDS() { return getToken(SQLParser.MICROSECONDS, 0); }
		public TerminalNode MILLENNIUM() { return getToken(SQLParser.MILLENNIUM, 0); }
		public TerminalNode MILLISECONDS() { return getToken(SQLParser.MILLISECONDS, 0); }
		public TerminalNode QUARTER() { return getToken(SQLParser.QUARTER, 0); }
		public TerminalNode WEEK() { return getToken(SQLParser.WEEK, 0); }
		public Extended_datetime_fieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extended_datetime_field; }
	}

	public final Extended_datetime_fieldContext extended_datetime_field() throws RecognitionException {
		Extended_datetime_fieldContext _localctx = new Extended_datetime_fieldContext(_ctx, getState());
		enterRule(_localctx, 706, RULE_extended_datetime_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3567);
			_la = _input.LA(1);
			if ( !(((((_la - 85)) & ~0x3f) == 0 && ((1L << (_la - 85)) & 126127177851338753L) != 0) || _la==QUARTER || _la==WEEK) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Routine_invocationContext extends ParserRuleContext {
		public Function_nameContext function_name() {
			return getRuleContext(Function_nameContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public Sql_argument_listContext sql_argument_list() {
			return getRuleContext(Sql_argument_listContext.class,0);
		}
		public Routine_invocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_routine_invocation; }
	}

	public final Routine_invocationContext routine_invocation() throws RecognitionException {
		Routine_invocationContext _localctx = new Routine_invocationContext(_ctx, getState());
		enterRule(_localctx, 708, RULE_routine_invocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3569);
			function_name();
			setState(3570);
			match(LEFT_PAREN);
			setState(3572);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 466063136288570288L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & -873698335226338561L) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & -18014398509481985L) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & 468374910935236607L) != 0) || ((((_la - 261)) & ~0x3f) == 0 && ((1L << (_la - 261)) & 505273965011944423L) != 0) || ((((_la - 329)) & ~0x3f) == 0 && ((1L << (_la - 329)) & 121265459777L) != 0)) {
				{
				setState(3571);
				sql_argument_list();
				}
			}

			setState(3574);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Function_names_for_reserved_wordsContext extends ParserRuleContext {
		public TerminalNode LEFT() { return getToken(SQLParser.LEFT, 0); }
		public TerminalNode RIGHT() { return getToken(SQLParser.RIGHT, 0); }
		public TerminalNode REPLACE() { return getToken(SQLParser.REPLACE, 0); }
		public Function_names_for_reserved_wordsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_names_for_reserved_words; }
	}

	public final Function_names_for_reserved_wordsContext function_names_for_reserved_words() throws RecognitionException {
		Function_names_for_reserved_wordsContext _localctx = new Function_names_for_reserved_wordsContext(_ctx, getState());
		enterRule(_localctx, 710, RULE_function_names_for_reserved_words);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3576);
			_la = _input.LA(1);
			if ( !(_la==LEFT || _la==RIGHT || _la==REPLACE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Schema_nameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ODIREF() { return getToken(SQLParser.ODIREF, 0); }
		public Schema_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_schema_name; }
	}

	public final Schema_nameContext schema_name() throws RecognitionException {
		Schema_nameContext _localctx = new Schema_nameContext(_ctx, getState());
		enterRule(_localctx, 712, RULE_schema_name);
		try {
			setState(3580);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ASYMMETRIC:
			case BOTH:
			case CROSS:
			case CURRENT_DATE:
			case CURRENT_TIME:
			case CURRENT_TIMESTAMP:
			case DATASET:
			case FULL:
			case GROUP:
			case LIMIT:
			case MAPPING:
			case NATURAL:
			case ORDER:
			case PACKAGE:
			case PROCEDURE:
			case PROJECT:
			case REUSABLE:
			case SYMMETRIC:
			case SCENARIO:
			case TRAILING:
			case WINDOW:
			case VARIABLE:
			case POSITION:
			case OFFSET:
			case IKM:
			case LKM:
			case CKM:
			case TECHNOLOGY:
			case DESCRIPTION:
			case AVG:
			case ADD:
			case ALTER:
			case BETWEEN:
			case BY:
			case CATALOG:
			case CENTURY:
			case CHARACTER:
			case COLLECT:
			case COALESCE:
			case COLUMN:
			case COUNT:
			case CUBE:
			case CUME_DIST:
			case CURRENT:
			case STRING:
			case DAY:
			case DEFAULT:
			case DATABASE:
			case DEC:
			case DECADE:
			case DENSE_RANK:
			case DOW:
			case DOY:
			case DROP:
			case EPOCH:
			case EVERY:
			case EXCLUDE:
			case EXISTS:
			case EXPLAIN:
			case EXTERNAL:
			case EXTRACT:
			case FILTER:
			case FIRST:
			case FIRST_VALUE:
			case FOLLOWING:
			case FORMAT:
			case FUSION:
			case GROUPING:
			case HASH:
			case INDEX:
			case INSERT:
			case INTERSECTION:
			case ISODOW:
			case ISOYEAR:
			case LAG:
			case LAST:
			case LAST_VALUE:
			case LESS:
			case LIST:
			case LOCATION:
			case MAX:
			case MAXVALUE:
			case MICROSECONDS:
			case MILLENNIUM:
			case MILLISECONDS:
			case MIN:
			case MINUTE:
			case MONTH:
			case NATIONAL:
			case NULLIF:
			case NO:
			case OVERWRITE:
			case OTHERS:
			case PARTITION:
			case PARTITIONS:
			case PERCENT_RANK:
			case PRECEDING:
			case PRECISION:
			case PURGE:
			case QUARTER:
			case RANGE:
			case RANK:
			case REGEXP:
			case RENAME:
			case RESET:
			case RLIKE:
			case ROLLUP:
			case ROW:
			case ROWS:
			case ROW_NUMBER:
			case SECOND:
			case SESSION:
			case SET:
			case SIMILAR:
			case STDDEV_POP:
			case STDDEV_SAMP:
			case SUBPARTITION:
			case SUM:
			case TABLESPACE:
			case THAN:
			case TIES:
			case TIMEZONE:
			case TIMEZONE_HOUR:
			case TIMEZONE_MINUTE:
			case TRIM:
			case TO:
			case UNBOUNDED:
			case UNKNOWN:
			case VALUES:
			case VAR_SAMP:
			case VAR_POP:
			case VARYING:
			case WEEK:
			case YEAR:
			case ZONE:
			case BOOLEAN:
			case BOOL:
			case BIT:
			case VARBIT:
			case INT1:
			case INT2:
			case INT4:
			case INT8:
			case TINYINT:
			case SMALLINT:
			case INT:
			case INTEGER:
			case BIGINT:
			case FLOAT4:
			case FLOAT8:
			case REAL:
			case FLOAT:
			case DOUBLE:
			case NUMERIC:
			case ORANUMBER:
			case DECIMAL:
			case CHAR:
			case VARCHAR2:
			case VARCHAR:
			case NCHAR:
			case NVARCHAR:
			case DATE:
			case INTERVAL:
			case TIME:
			case TIMETZ:
			case TIMESTAMP:
			case TIMESTAMPTZ:
			case TEXT:
			case BINARY:
			case VARBINARY:
			case BLOB:
			case BYTEA:
			case INET4:
			case REAL_NUMBER:
			case DATASTORE:
			case ALIAS:
			case RESOURCE:
			case FILE:
			case HEADING:
			case FIXED:
			case SCD:
			case MODEL:
			case FOLDER:
			case SUBMODEL:
			case REPLACE:
			case CONTEXT:
			case XKM:
			case SEQUENCEFILE:
			case FIELDS:
			case TERMINATED:
			case SERDE:
			case SERDEPROPERTIES:
			case TEXTFILE:
			case RCFILE:
			case ORC:
			case PARQUET:
			case AVRO:
			case INPUTFORMAT:
			case OUTPUTFORMAT:
			case TEMPORARY:
			case TBLPROPERTIES:
			case REJECT:
			case PERCENT:
			case SUCCESS:
			case TYPE:
			case ODI:
			case CONTROL:
			case FLOW:
			case STATIC:
			case ACTIVE:
			case MESSAGE:
			case KEEP:
			case PIVOT:
			case UNPIVOT:
			case Regular_Identifier:
			case Quoted_Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(3578);
				identifier();
				}
				break;
			case ODIREF:
				enterOuterAlt(_localctx, 2);
				{
				setState(3579);
				match(ODIREF);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Function_nameContext extends ParserRuleContext {
		public IdentifierContext package_name;
		public IdentifierContext name;
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public Schema_nameContext schema_name() {
			return getRuleContext(Schema_nameContext.class,0);
		}
		public List<TerminalNode> DOT() { return getTokens(SQLParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(SQLParser.DOT, i);
		}
		public Function_names_for_reserved_wordsContext function_names_for_reserved_words() {
			return getRuleContext(Function_names_for_reserved_wordsContext.class,0);
		}
		public Function_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_name; }
	}

	public final Function_nameContext function_name() throws RecognitionException {
		Function_nameContext _localctx = new Function_nameContext(_ctx, getState());
		enterRule(_localctx, 714, RULE_function_name);
		try {
			setState(3594);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,431,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3585);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,429,_ctx) ) {
				case 1:
					{
					setState(3582);
					schema_name();
					setState(3583);
					match(DOT);
					}
					break;
				}
				setState(3590);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,430,_ctx) ) {
				case 1:
					{
					setState(3587);
					((Function_nameContext)_localctx).package_name = identifier();
					setState(3588);
					match(DOT);
					}
					break;
				}
				setState(3592);
				((Function_nameContext)_localctx).name = identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3593);
				function_names_for_reserved_words();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Sql_argument_listContext extends ParserRuleContext {
		public List<Value_expressionContext> value_expression() {
			return getRuleContexts(Value_expressionContext.class);
		}
		public Value_expressionContext value_expression(int i) {
			return getRuleContext(Value_expressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Sql_argument_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sql_argument_list; }
	}

	public final Sql_argument_listContext sql_argument_list() throws RecognitionException {
		Sql_argument_listContext _localctx = new Sql_argument_listContext(_ctx, getState());
		enterRule(_localctx, 716, RULE_sql_argument_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3596);
			value_expression();
			setState(3601);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3597);
				match(COMMA);
				setState(3598);
				value_expression();
				}
				}
				setState(3603);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Table_functionContext extends ParserRuleContext {
		public TerminalNode TABLE() { return getToken(SQLParser.TABLE, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Routine_invocationContext routine_invocation() {
			return getRuleContext(Routine_invocationContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public Table_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_function; }
	}

	public final Table_functionContext table_function() throws RecognitionException {
		Table_functionContext _localctx = new Table_functionContext(_ctx, getState());
		enterRule(_localctx, 718, RULE_table_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3604);
			match(TABLE);
			setState(3605);
			match(LEFT_PAREN);
			setState(3606);
			routine_invocation();
			setState(3607);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Orderby_clauseContext extends ParserRuleContext {
		public TerminalNode ORDER() { return getToken(SQLParser.ORDER, 0); }
		public TerminalNode BY() { return getToken(SQLParser.BY, 0); }
		public Sort_specifier_listContext sort_specifier_list() {
			return getRuleContext(Sort_specifier_listContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public Orderby_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderby_clause; }
	}

	public final Orderby_clauseContext orderby_clause() throws RecognitionException {
		Orderby_clauseContext _localctx = new Orderby_clauseContext(_ctx, getState());
		enterRule(_localctx, 720, RULE_orderby_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3612);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT_SIGN) {
				{
				{
				setState(3609);
				annotation();
				}
				}
				setState(3614);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(3615);
			match(ORDER);
			setState(3616);
			match(BY);
			setState(3617);
			sort_specifier_list();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Sort_specifier_listContext extends ParserRuleContext {
		public List<Sort_specifierContext> sort_specifier() {
			return getRuleContexts(Sort_specifierContext.class);
		}
		public Sort_specifierContext sort_specifier(int i) {
			return getRuleContext(Sort_specifierContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Sort_specifier_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sort_specifier_list; }
	}

	public final Sort_specifier_listContext sort_specifier_list() throws RecognitionException {
		Sort_specifier_listContext _localctx = new Sort_specifier_listContext(_ctx, getState());
		enterRule(_localctx, 722, RULE_sort_specifier_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(3619);
			sort_specifier();
			setState(3624);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,434,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(3620);
					match(COMMA);
					setState(3621);
					sort_specifier();
					}
					} 
				}
				setState(3626);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,434,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Sort_specifierContext extends ParserRuleContext {
		public Row_value_predicandContext key;
		public Order_specificationContext order;
		public Null_orderingContext null_order;
		public Row_value_predicandContext row_value_predicand() {
			return getRuleContext(Row_value_predicandContext.class,0);
		}
		public Order_specificationContext order_specification() {
			return getRuleContext(Order_specificationContext.class,0);
		}
		public Null_orderingContext null_ordering() {
			return getRuleContext(Null_orderingContext.class,0);
		}
		public Sort_specifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sort_specifier; }
	}

	public final Sort_specifierContext sort_specifier() throws RecognitionException {
		Sort_specifierContext _localctx = new Sort_specifierContext(_ctx, getState());
		enterRule(_localctx, 724, RULE_sort_specifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3627);
			((Sort_specifierContext)_localctx).key = row_value_predicand();
			setState(3629);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASC || _la==DESC) {
				{
				setState(3628);
				((Sort_specifierContext)_localctx).order = order_specification();
				}
			}

			setState(3632);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NULLS) {
				{
				setState(3631);
				((Sort_specifierContext)_localctx).null_order = null_ordering();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Order_specificationContext extends ParserRuleContext {
		public TerminalNode ASC() { return getToken(SQLParser.ASC, 0); }
		public TerminalNode DESC() { return getToken(SQLParser.DESC, 0); }
		public Order_specificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_order_specification; }
	}

	public final Order_specificationContext order_specification() throws RecognitionException {
		Order_specificationContext _localctx = new Order_specificationContext(_ctx, getState());
		enterRule(_localctx, 726, RULE_order_specification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3634);
			_la = _input.LA(1);
			if ( !(_la==ASC || _la==DESC) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Limit_clauseContext extends ParserRuleContext {
		public Numeric_value_expressionContext e;
		public TerminalNode LIMIT() { return getToken(SQLParser.LIMIT, 0); }
		public Numeric_value_expressionContext numeric_value_expression() {
			return getRuleContext(Numeric_value_expressionContext.class,0);
		}
		public Limit_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_limit_clause; }
	}

	public final Limit_clauseContext limit_clause() throws RecognitionException {
		Limit_clauseContext _localctx = new Limit_clauseContext(_ctx, getState());
		enterRule(_localctx, 728, RULE_limit_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3636);
			match(LIMIT);
			setState(3637);
			((Limit_clauseContext)_localctx).e = numeric_value_expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Null_orderingContext extends ParserRuleContext {
		public TerminalNode NULLS() { return getToken(SQLParser.NULLS, 0); }
		public TerminalNode FIRST() { return getToken(SQLParser.FIRST, 0); }
		public TerminalNode LAST() { return getToken(SQLParser.LAST, 0); }
		public Null_orderingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_null_ordering; }
	}

	public final Null_orderingContext null_ordering() throws RecognitionException {
		Null_orderingContext _localctx = new Null_orderingContext(_ctx, getState());
		enterRule(_localctx, 730, RULE_null_ordering);
		try {
			setState(3643);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,437,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3639);
				match(NULLS);
				setState(3640);
				match(FIRST);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3641);
				match(NULLS);
				setState(3642);
				match(LAST);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Integration_paramsContext extends ParserRuleContext {
		public Token integration_type;
		public Token key;
		public Unsigned_numeric_literalContext max_rejected;
		public Token rejected_unit;
		public TerminalNode INTEGRATION_TYPE() { return getToken(SQLParser.INTEGRATION_TYPE, 0); }
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public TerminalNode UPDATE_KEY() { return getToken(SQLParser.UPDATE_KEY, 0); }
		public TerminalNode REJECT() { return getToken(SQLParser.REJECT, 0); }
		public TerminalNode LIMIT() { return getToken(SQLParser.LIMIT, 0); }
		public TerminalNode Regular_Identifier() { return getToken(SQLParser.Regular_Identifier, 0); }
		public Unsigned_numeric_literalContext unsigned_numeric_literal() {
			return getRuleContext(Unsigned_numeric_literalContext.class,0);
		}
		public TerminalNode ROWS() { return getToken(SQLParser.ROWS, 0); }
		public TerminalNode PERCENT() { return getToken(SQLParser.PERCENT, 0); }
		public Integration_paramsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integration_params; }
	}

	public final Integration_paramsContext integration_params() throws RecognitionException {
		Integration_paramsContext _localctx = new Integration_paramsContext(_ctx, getState());
		enterRule(_localctx, 732, RULE_integration_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(3645);
			match(INTEGRATION_TYPE);
			setState(3646);
			((Integration_paramsContext)_localctx).integration_type = match(Character_String_Literal);
			}
			setState(3650);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==UPDATE_KEY) {
				{
				setState(3648);
				match(UPDATE_KEY);
				setState(3649);
				((Integration_paramsContext)_localctx).key = match(Regular_Identifier);
				}
			}

			setState(3657);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,439,_ctx) ) {
			case 1:
				{
				setState(3652);
				match(REJECT);
				setState(3653);
				match(LIMIT);
				setState(3654);
				((Integration_paramsContext)_localctx).max_rejected = unsigned_numeric_literal();
				setState(3655);
				((Integration_paramsContext)_localctx).rejected_unit = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ROWS || _la==PERCENT) ) {
					((Integration_paramsContext)_localctx).rejected_unit = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Insert_statementContext extends ParserRuleContext {
		public IdentifierContext alias;
		public Token path;
		public IdentifierContext storage_type;
		public TerminalNode INSERT() { return getToken(SQLParser.INSERT, 0); }
		public TerminalNode INTO() { return getToken(SQLParser.INTO, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public Query_expressionContext query_expression() {
			return getRuleContext(Query_expressionContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public TerminalNode OVERWRITE() { return getToken(SQLParser.OVERWRITE, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Column_name_listContext column_name_list() {
			return getRuleContext(Column_name_listContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public Integration_paramsContext integration_params() {
			return getRuleContext(Integration_paramsContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LOCATION() { return getToken(SQLParser.LOCATION, 0); }
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public TerminalNode USING() { return getToken(SQLParser.USING, 0); }
		public Param_clauseContext param_clause() {
			return getRuleContext(Param_clauseContext.class,0);
		}
		public Insert_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insert_statement; }
	}

	public final Insert_statementContext insert_statement() throws RecognitionException {
		Insert_statementContext _localctx = new Insert_statementContext(_ctx, getState());
		enterRule(_localctx, 734, RULE_insert_statement);
		int _la;
		try {
			setState(3700);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,448,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3662);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT_SIGN) {
					{
					{
					setState(3659);
					annotation();
					}
					}
					setState(3664);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(3665);
				match(INSERT);
				setState(3667);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OVERWRITE) {
					{
					setState(3666);
					match(OVERWRITE);
					}
				}

				setState(3669);
				match(INTO);
				setState(3670);
				table_name();
				setState(3672);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,442,_ctx) ) {
				case 1:
					{
					setState(3671);
					((Insert_statementContext)_localctx).alias = identifier();
					}
					break;
				}
				setState(3678);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,443,_ctx) ) {
				case 1:
					{
					setState(3674);
					match(LEFT_PAREN);
					setState(3675);
					column_name_list();
					setState(3676);
					match(RIGHT_PAREN);
					}
					break;
				}
				setState(3681);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INTEGRATION_TYPE) {
					{
					setState(3680);
					integration_params();
					}
				}

				setState(3683);
				query_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3685);
				match(INSERT);
				setState(3687);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OVERWRITE) {
					{
					setState(3686);
					match(OVERWRITE);
					}
				}

				setState(3689);
				match(INTO);
				setState(3690);
				match(LOCATION);
				setState(3691);
				((Insert_statementContext)_localctx).path = match(Character_String_Literal);
				setState(3697);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==USING) {
					{
					setState(3692);
					match(USING);
					setState(3693);
					((Insert_statementContext)_localctx).storage_type = identifier();
					setState(3695);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,446,_ctx) ) {
					case 1:
						{
						setState(3694);
						param_clause();
						}
						break;
					}
					}
				}

				setState(3699);
				query_expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Multi_insert_select_listContext extends ParserRuleContext {
		public List<Value_expressionContext> value_expression() {
			return getRuleContexts(Value_expressionContext.class);
		}
		public Value_expressionContext value_expression(int i) {
			return getRuleContext(Value_expressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SQLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SQLParser.COMMA, i);
		}
		public Multi_insert_select_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multi_insert_select_list; }
	}

	public final Multi_insert_select_listContext multi_insert_select_list() throws RecognitionException {
		Multi_insert_select_listContext _localctx = new Multi_insert_select_listContext(_ctx, getState());
		enterRule(_localctx, 736, RULE_multi_insert_select_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3702);
			value_expression();
			setState(3707);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(3703);
				match(COMMA);
				setState(3704);
				value_expression();
				}
				}
				setState(3709);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Multi_insert_targetContext extends ParserRuleContext {
		public IdentifierContext alias;
		public TerminalNode INTO() { return getToken(SQLParser.INTO, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode VALUES() { return getToken(SQLParser.VALUES, 0); }
		public List<TerminalNode> LEFT_PAREN() { return getTokens(SQLParser.LEFT_PAREN); }
		public TerminalNode LEFT_PAREN(int i) {
			return getToken(SQLParser.LEFT_PAREN, i);
		}
		public Multi_insert_select_listContext multi_insert_select_list() {
			return getRuleContext(Multi_insert_select_listContext.class,0);
		}
		public List<TerminalNode> RIGHT_PAREN() { return getTokens(SQLParser.RIGHT_PAREN); }
		public TerminalNode RIGHT_PAREN(int i) {
			return getToken(SQLParser.RIGHT_PAREN, i);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public TerminalNode WHEN() { return getToken(SQLParser.WHEN, 0); }
		public Search_conditionContext search_condition() {
			return getRuleContext(Search_conditionContext.class,0);
		}
		public TerminalNode THEN() { return getToken(SQLParser.THEN, 0); }
		public Column_name_listContext column_name_list() {
			return getRuleContext(Column_name_listContext.class,0);
		}
		public Integration_paramsContext integration_params() {
			return getRuleContext(Integration_paramsContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Multi_insert_targetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multi_insert_target; }
	}

	public final Multi_insert_targetContext multi_insert_target() throws RecognitionException {
		Multi_insert_targetContext _localctx = new Multi_insert_targetContext(_ctx, getState());
		enterRule(_localctx, 738, RULE_multi_insert_target);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3713);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT_SIGN) {
				{
				{
				setState(3710);
				annotation();
				}
				}
				setState(3715);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(3720);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHEN) {
				{
				setState(3716);
				match(WHEN);
				setState(3717);
				search_condition();
				setState(3718);
				match(THEN);
				}
			}

			setState(3722);
			match(INTO);
			setState(3723);
			table_name();
			setState(3725);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,452,_ctx) ) {
			case 1:
				{
				setState(3724);
				((Multi_insert_targetContext)_localctx).alias = identifier();
				}
				break;
			}
			setState(3731);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LEFT_PAREN) {
				{
				setState(3727);
				match(LEFT_PAREN);
				setState(3728);
				column_name_list();
				setState(3729);
				match(RIGHT_PAREN);
				}
			}

			setState(3733);
			match(VALUES);
			{
			setState(3734);
			match(LEFT_PAREN);
			setState(3735);
			multi_insert_select_list();
			setState(3736);
			match(RIGHT_PAREN);
			}
			setState(3739);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INTEGRATION_TYPE) {
				{
				setState(3738);
				integration_params();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Multi_insert_def_targetContext extends ParserRuleContext {
		public IdentifierContext alias;
		public TerminalNode ELSE() { return getToken(SQLParser.ELSE, 0); }
		public TerminalNode INTO() { return getToken(SQLParser.INTO, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode VALUES() { return getToken(SQLParser.VALUES, 0); }
		public List<TerminalNode> LEFT_PAREN() { return getTokens(SQLParser.LEFT_PAREN); }
		public TerminalNode LEFT_PAREN(int i) {
			return getToken(SQLParser.LEFT_PAREN, i);
		}
		public Multi_insert_select_listContext multi_insert_select_list() {
			return getRuleContext(Multi_insert_select_listContext.class,0);
		}
		public List<TerminalNode> RIGHT_PAREN() { return getTokens(SQLParser.RIGHT_PAREN); }
		public TerminalNode RIGHT_PAREN(int i) {
			return getToken(SQLParser.RIGHT_PAREN, i);
		}
		public Column_name_listContext column_name_list() {
			return getRuleContext(Column_name_listContext.class,0);
		}
		public Integration_paramsContext integration_params() {
			return getRuleContext(Integration_paramsContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Multi_insert_def_targetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multi_insert_def_target; }
	}

	public final Multi_insert_def_targetContext multi_insert_def_target() throws RecognitionException {
		Multi_insert_def_targetContext _localctx = new Multi_insert_def_targetContext(_ctx, getState());
		enterRule(_localctx, 740, RULE_multi_insert_def_target);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3741);
			match(ELSE);
			setState(3742);
			match(INTO);
			setState(3743);
			table_name();
			setState(3745);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,455,_ctx) ) {
			case 1:
				{
				setState(3744);
				((Multi_insert_def_targetContext)_localctx).alias = identifier();
				}
				break;
			}
			setState(3751);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LEFT_PAREN) {
				{
				setState(3747);
				match(LEFT_PAREN);
				setState(3748);
				column_name_list();
				setState(3749);
				match(RIGHT_PAREN);
				}
			}

			setState(3753);
			match(VALUES);
			{
			setState(3754);
			match(LEFT_PAREN);
			setState(3755);
			multi_insert_select_list();
			setState(3756);
			match(RIGHT_PAREN);
			}
			setState(3759);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INTEGRATION_TYPE) {
				{
				setState(3758);
				integration_params();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Multi_insert_statementContext extends ParserRuleContext {
		public TerminalNode INSERT() { return getToken(SQLParser.INSERT, 0); }
		public TerminalNode ALL() { return getToken(SQLParser.ALL, 0); }
		public Query_expressionContext query_expression() {
			return getRuleContext(Query_expressionContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public List<Multi_insert_targetContext> multi_insert_target() {
			return getRuleContexts(Multi_insert_targetContext.class);
		}
		public Multi_insert_targetContext multi_insert_target(int i) {
			return getRuleContext(Multi_insert_targetContext.class,i);
		}
		public Multi_insert_def_targetContext multi_insert_def_target() {
			return getRuleContext(Multi_insert_def_targetContext.class,0);
		}
		public Multi_insert_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multi_insert_statement; }
	}

	public final Multi_insert_statementContext multi_insert_statement() throws RecognitionException {
		Multi_insert_statementContext _localctx = new Multi_insert_statementContext(_ctx, getState());
		enterRule(_localctx, 742, RULE_multi_insert_statement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(3764);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT_SIGN) {
				{
				{
				setState(3761);
				annotation();
				}
				}
				setState(3766);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(3767);
			match(INSERT);
			setState(3768);
			match(ALL);
			setState(3770); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(3769);
					multi_insert_target();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(3772); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,459,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(3775);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(3774);
				multi_insert_def_target();
				}
			}

			setState(3777);
			query_expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Alter_tablespace_statementContext extends ParserRuleContext {
		public IdentifierContext space_name;
		public Token uri;
		public TerminalNode ALTER() { return getToken(SQLParser.ALTER, 0); }
		public TerminalNode TABLESPACE() { return getToken(SQLParser.TABLESPACE, 0); }
		public TerminalNode LOCATION() { return getToken(SQLParser.LOCATION, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public Alter_tablespace_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alter_tablespace_statement; }
	}

	public final Alter_tablespace_statementContext alter_tablespace_statement() throws RecognitionException {
		Alter_tablespace_statementContext _localctx = new Alter_tablespace_statementContext(_ctx, getState());
		enterRule(_localctx, 744, RULE_alter_tablespace_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3779);
			match(ALTER);
			setState(3780);
			match(TABLESPACE);
			setState(3781);
			((Alter_tablespace_statementContext)_localctx).space_name = identifier();
			setState(3782);
			match(LOCATION);
			setState(3783);
			((Alter_tablespace_statementContext)_localctx).uri = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Datastore_keyContext extends ParserRuleContext {
		public Token key_type;
		public IdentifierContext key_name;
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Column_name_listContext column_name_list() {
			return getRuleContext(Column_name_listContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode CONSTRAINT() { return getToken(SQLParser.CONSTRAINT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode PRIMARY_KEY() { return getToken(SQLParser.PRIMARY_KEY, 0); }
		public TerminalNode ALTERNATE_KEY() { return getToken(SQLParser.ALTERNATE_KEY, 0); }
		public TerminalNode INDEX() { return getToken(SQLParser.INDEX, 0); }
		public TerminalNode UNIQUE() { return getToken(SQLParser.UNIQUE, 0); }
		public Datastore_keyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datastore_key; }
	}

	public final Datastore_keyContext datastore_key() throws RecognitionException {
		Datastore_keyContext _localctx = new Datastore_keyContext(_ctx, getState());
		enterRule(_localctx, 746, RULE_datastore_key);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3785);
			((Datastore_keyContext)_localctx).key_type = match(CONSTRAINT);
			setState(3786);
			((Datastore_keyContext)_localctx).key_name = identifier();
			setState(3792);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRIMARY_KEY:
				{
				setState(3787);
				match(PRIMARY_KEY);
				}
				break;
			case ALTERNATE_KEY:
				{
				setState(3788);
				match(ALTERNATE_KEY);
				}
				break;
			case INDEX:
				{
				setState(3789);
				match(INDEX);
				}
				break;
			case UNIQUE:
				{
				setState(3790);
				match(UNIQUE);
				setState(3791);
				match(INDEX);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(3794);
			match(LEFT_PAREN);
			setState(3795);
			column_name_list();
			setState(3796);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Datastore_checkContext extends ParserRuleContext {
		public Token key_type;
		public IdentifierContext key_name;
		public TerminalNode CHECK() { return getToken(SQLParser.CHECK, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(SQLParser.LEFT_PAREN, 0); }
		public Search_conditionContext search_condition() {
			return getRuleContext(Search_conditionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(SQLParser.RIGHT_PAREN, 0); }
		public TerminalNode CONSTRAINT() { return getToken(SQLParser.CONSTRAINT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Datastore_checkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datastore_check; }
	}

	public final Datastore_checkContext datastore_check() throws RecognitionException {
		Datastore_checkContext _localctx = new Datastore_checkContext(_ctx, getState());
		enterRule(_localctx, 748, RULE_datastore_check);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3798);
			((Datastore_checkContext)_localctx).key_type = match(CONSTRAINT);
			setState(3799);
			((Datastore_checkContext)_localctx).key_name = identifier();
			setState(3800);
			match(CHECK);
			setState(3801);
			match(LEFT_PAREN);
			setState(3802);
			search_condition();
			setState(3803);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Constraint_controlContext extends ParserRuleContext {
		public TerminalNode CONTROL() { return getToken(SQLParser.CONTROL, 0); }
		public TerminalNode FLOW() { return getToken(SQLParser.FLOW, 0); }
		public TerminalNode STATIC() { return getToken(SQLParser.STATIC, 0); }
		public Constraint_controlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint_control; }
	}

	public final Constraint_controlContext constraint_control() throws RecognitionException {
		Constraint_controlContext _localctx = new Constraint_controlContext(_ctx, getState());
		enterRule(_localctx, 750, RULE_constraint_control);
		try {
			setState(3815);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,462,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3805);
				match(CONTROL);
				setState(3806);
				match(FLOW);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3807);
				match(CONTROL);
				setState(3808);
				match(STATIC);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3809);
				match(CONTROL);
				setState(3810);
				match(FLOW);
				setState(3811);
				match(STATIC);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(3812);
				match(CONTROL);
				setState(3813);
				match(STATIC);
				setState(3814);
				match(FLOW);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class In_databaseContext extends ParserRuleContext {
		public TerminalNode DEFINED() { return getToken(SQLParser.DEFINED, 0); }
		public TerminalNode IN() { return getToken(SQLParser.IN, 0); }
		public TerminalNode DATABASE() { return getToken(SQLParser.DATABASE, 0); }
		public TerminalNode ACTIVE() { return getToken(SQLParser.ACTIVE, 0); }
		public In_databaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_in_database; }
	}

	public final In_databaseContext in_database() throws RecognitionException {
		In_databaseContext _localctx = new In_databaseContext(_ctx, getState());
		enterRule(_localctx, 752, RULE_in_database);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3817);
			match(DEFINED);
			setState(3818);
			match(IN);
			setState(3819);
			match(DATABASE);
			setState(3821);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ACTIVE) {
				{
				setState(3820);
				match(ACTIVE);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Constraint_typeContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(SQLParser.TYPE, 0); }
		public TerminalNode ODI() { return getToken(SQLParser.ODI, 0); }
		public TerminalNode DATABASE() { return getToken(SQLParser.DATABASE, 0); }
		public Constraint_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint_type; }
	}

	public final Constraint_typeContext constraint_type() throws RecognitionException {
		Constraint_typeContext _localctx = new Constraint_typeContext(_ctx, getState());
		enterRule(_localctx, 754, RULE_constraint_type);
		try {
			setState(3827);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,464,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3823);
				match(TYPE);
				setState(3824);
				match(ODI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3825);
				match(TYPE);
				setState(3826);
				match(DATABASE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Datastore_condition_messageContext extends ParserRuleContext {
		public Token comm;
		public TerminalNode MESSAGE() { return getToken(SQLParser.MESSAGE, 0); }
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public Datastore_condition_messageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datastore_condition_message; }
	}

	public final Datastore_condition_messageContext datastore_condition_message() throws RecognitionException {
		Datastore_condition_messageContext _localctx = new Datastore_condition_messageContext(_ctx, getState());
		enterRule(_localctx, 756, RULE_datastore_condition_message);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3829);
			match(MESSAGE);
			setState(3830);
			((Datastore_condition_messageContext)_localctx).comm = match(Character_String_Literal);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Datastore_constraintContext extends ParserRuleContext {
		public Datastore_keyContext datastore_key() {
			return getRuleContext(Datastore_keyContext.class,0);
		}
		public Datastore_checkContext datastore_check() {
			return getRuleContext(Datastore_checkContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public Constraint_typeContext constraint_type() {
			return getRuleContext(Constraint_typeContext.class,0);
		}
		public In_databaseContext in_database() {
			return getRuleContext(In_databaseContext.class,0);
		}
		public Constraint_controlContext constraint_control() {
			return getRuleContext(Constraint_controlContext.class,0);
		}
		public Datastore_condition_messageContext datastore_condition_message() {
			return getRuleContext(Datastore_condition_messageContext.class,0);
		}
		public Datastore_constraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datastore_constraint; }
	}

	public final Datastore_constraintContext datastore_constraint() throws RecognitionException {
		Datastore_constraintContext _localctx = new Datastore_constraintContext(_ctx, getState());
		enterRule(_localctx, 758, RULE_datastore_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3835);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT_SIGN) {
				{
				{
				setState(3832);
				annotation();
				}
				}
				setState(3837);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(3840);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,466,_ctx) ) {
			case 1:
				{
				setState(3838);
				datastore_key();
				}
				break;
			case 2:
				{
				setState(3839);
				datastore_check();
				}
				break;
			}
			setState(3843);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE) {
				{
				setState(3842);
				constraint_type();
				}
			}

			setState(3846);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFINED) {
				{
				setState(3845);
				in_database();
				}
			}

			setState(3849);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONTROL) {
				{
				setState(3848);
				constraint_control();
				}
			}

			setState(3852);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MESSAGE) {
				{
				setState(3851);
				datastore_condition_message();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Alter_table_statementContext extends ParserRuleContext {
		public Token comm;
		public TerminalNode ALTER() { return getToken(SQLParser.ALTER, 0); }
		public List<Table_nameContext> table_name() {
			return getRuleContexts(Table_nameContext.class);
		}
		public Table_nameContext table_name(int i) {
			return getRuleContext(Table_nameContext.class,i);
		}
		public TerminalNode RENAME() { return getToken(SQLParser.RENAME, 0); }
		public TerminalNode TO() { return getToken(SQLParser.TO, 0); }
		public TerminalNode TABLE() { return getToken(SQLParser.TABLE, 0); }
		public TerminalNode DATASTORE() { return getToken(SQLParser.DATASTORE, 0); }
		public TerminalNode COLUMN() { return getToken(SQLParser.COLUMN, 0); }
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public TerminalNode MODIFY() { return getToken(SQLParser.MODIFY, 0); }
		public Modify_field_elementContext modify_field_element() {
			return getRuleContext(Modify_field_elementContext.class,0);
		}
		public TerminalNode ADD() { return getToken(SQLParser.ADD, 0); }
		public Field_elementContext field_element() {
			return getRuleContext(Field_elementContext.class,0);
		}
		public Datastore_constraintContext datastore_constraint() {
			return getRuleContext(Datastore_constraintContext.class,0);
		}
		public TerminalNode CMNT() { return getToken(SQLParser.CMNT, 0); }
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public Alter_table_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alter_table_statement; }
	}

	public final Alter_table_statementContext alter_table_statement() throws RecognitionException {
		Alter_table_statementContext _localctx = new Alter_table_statementContext(_ctx, getState());
		enterRule(_localctx, 760, RULE_alter_table_statement);
		int _la;
		try {
			setState(3896);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,471,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3854);
				match(ALTER);
				setState(3855);
				_la = _input.LA(1);
				if ( !(_la==TABLE || _la==DATASTORE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(3856);
				table_name();
				setState(3857);
				match(RENAME);
				setState(3858);
				match(TO);
				setState(3859);
				table_name();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3861);
				match(ALTER);
				setState(3862);
				_la = _input.LA(1);
				if ( !(_la==TABLE || _la==DATASTORE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(3863);
				table_name();
				setState(3864);
				match(RENAME);
				setState(3865);
				match(COLUMN);
				setState(3866);
				column_name();
				setState(3867);
				match(TO);
				setState(3868);
				column_name();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(3870);
				match(ALTER);
				setState(3871);
				_la = _input.LA(1);
				if ( !(_la==TABLE || _la==DATASTORE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(3872);
				table_name();
				setState(3873);
				match(MODIFY);
				setState(3874);
				match(COLUMN);
				setState(3875);
				modify_field_element();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(3877);
				match(ALTER);
				setState(3878);
				_la = _input.LA(1);
				if ( !(_la==TABLE || _la==DATASTORE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(3879);
				table_name();
				setState(3880);
				match(ADD);
				setState(3881);
				match(COLUMN);
				setState(3882);
				field_element();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(3884);
				match(ALTER);
				setState(3885);
				_la = _input.LA(1);
				if ( !(_la==TABLE || _la==DATASTORE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(3886);
				table_name();
				setState(3887);
				match(ADD);
				setState(3888);
				datastore_constraint();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(3890);
				match(ALTER);
				setState(3891);
				_la = _input.LA(1);
				if ( !(_la==TABLE || _la==DATASTORE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(3892);
				table_name();
				setState(3893);
				match(CMNT);
				setState(3894);
				((Alter_table_statementContext)_localctx).comm = match(Character_String_Literal);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Alter_mapping_statementContext extends ParserRuleContext {
		public Token comm;
		public TerminalNode ALTER() { return getToken(SQLParser.ALTER, 0); }
		public TerminalNode MAPPING() { return getToken(SQLParser.MAPPING, 0); }
		public Mapping_nameContext mapping_name() {
			return getRuleContext(Mapping_nameContext.class,0);
		}
		public TerminalNode MODIFY() { return getToken(SQLParser.MODIFY, 0); }
		public Phys_design_clauseContext phys_design_clause() {
			return getRuleContext(Phys_design_clauseContext.class,0);
		}
		public If_existsContext if_exists() {
			return getRuleContext(If_existsContext.class,0);
		}
		public TerminalNode CMNT() { return getToken(SQLParser.CMNT, 0); }
		public TerminalNode Character_String_Literal() { return getToken(SQLParser.Character_String_Literal, 0); }
		public TerminalNode REUSABLE() { return getToken(SQLParser.REUSABLE, 0); }
		public Alter_mapping_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alter_mapping_statement; }
	}

	public final Alter_mapping_statementContext alter_mapping_statement() throws RecognitionException {
		Alter_mapping_statementContext _localctx = new Alter_mapping_statementContext(_ctx, getState());
		enterRule(_localctx, 762, RULE_alter_mapping_statement);
		int _la;
		try {
			setState(3919);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,475,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(3898);
				match(ALTER);
				setState(3899);
				match(MAPPING);
				setState(3901);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(3900);
					if_exists();
					}
				}

				setState(3903);
				mapping_name();
				setState(3904);
				match(MODIFY);
				setState(3905);
				phys_design_clause();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(3907);
				match(ALTER);
				setState(3909);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==REUSABLE) {
					{
					setState(3908);
					match(REUSABLE);
					}
				}

				setState(3911);
				match(MAPPING);
				setState(3913);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(3912);
					if_exists();
					}
				}

				setState(3915);
				mapping_name();
				setState(3916);
				match(CMNT);
				setState(3917);
				((Alter_mapping_statementContext)_localctx).comm = match(Character_String_Literal);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Open_project_statementContext extends ParserRuleContext {
		public IdentifierContext path;
		public TerminalNode PROJECT() { return getToken(SQLParser.PROJECT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Open_project_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_open_project_statement; }
	}

	public final Open_project_statementContext open_project_statement() throws RecognitionException {
		Open_project_statementContext _localctx = new Open_project_statementContext(_ctx, getState());
		enterRule(_localctx, 764, RULE_open_project_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3921);
			match(PROJECT);
			setState(3922);
			((Open_project_statementContext)_localctx).path = identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Connect_statementContext extends ParserRuleContext {
		public IdentifierContext name;
		public TerminalNode CONNECT() { return getToken(SQLParser.CONNECT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ODI() { return getToken(SQLParser.ODI, 0); }
		public Connect_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_connect_statement; }
	}

	public final Connect_statementContext connect_statement() throws RecognitionException {
		Connect_statementContext _localctx = new Connect_statementContext(_ctx, getState());
		enterRule(_localctx, 766, RULE_connect_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3924);
			match(CONNECT);
			setState(3926);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,476,_ctx) ) {
			case 1:
				{
				setState(3925);
				match(ODI);
				}
				break;
			}
			setState(3928);
			((Connect_statementContext)_localctx).name = identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	private static final String _serializedATNSegment0 =
		"\u0004\u0001\u0171\u0f5b\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007"+
		"\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007"+
		"\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007"+
		"\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007"+
		"\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007"+
		",\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u0007"+
		"1\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u0007"+
		"6\u00027\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007"+
		";\u0002<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007"+
		"@\u0002A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0002E\u0007"+
		"E\u0002F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007I\u0002J\u0007"+
		"J\u0002K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002N\u0007N\u0002O\u0007"+
		"O\u0002P\u0007P\u0002Q\u0007Q\u0002R\u0007R\u0002S\u0007S\u0002T\u0007"+
		"T\u0002U\u0007U\u0002V\u0007V\u0002W\u0007W\u0002X\u0007X\u0002Y\u0007"+
		"Y\u0002Z\u0007Z\u0002[\u0007[\u0002\\\u0007\\\u0002]\u0007]\u0002^\u0007"+
		"^\u0002_\u0007_\u0002`\u0007`\u0002a\u0007a\u0002b\u0007b\u0002c\u0007"+
		"c\u0002d\u0007d\u0002e\u0007e\u0002f\u0007f\u0002g\u0007g\u0002h\u0007"+
		"h\u0002i\u0007i\u0002j\u0007j\u0002k\u0007k\u0002l\u0007l\u0002m\u0007"+
		"m\u0002n\u0007n\u0002o\u0007o\u0002p\u0007p\u0002q\u0007q\u0002r\u0007"+
		"r\u0002s\u0007s\u0002t\u0007t\u0002u\u0007u\u0002v\u0007v\u0002w\u0007"+
		"w\u0002x\u0007x\u0002y\u0007y\u0002z\u0007z\u0002{\u0007{\u0002|\u0007"+
		"|\u0002}\u0007}\u0002~\u0007~\u0002\u007f\u0007\u007f\u0002\u0080\u0007"+
		"\u0080\u0002\u0081\u0007\u0081\u0002\u0082\u0007\u0082\u0002\u0083\u0007"+
		"\u0083\u0002\u0084\u0007\u0084\u0002\u0085\u0007\u0085\u0002\u0086\u0007"+
		"\u0086\u0002\u0087\u0007\u0087\u0002\u0088\u0007\u0088\u0002\u0089\u0007"+
		"\u0089\u0002\u008a\u0007\u008a\u0002\u008b\u0007\u008b\u0002\u008c\u0007"+
		"\u008c\u0002\u008d\u0007\u008d\u0002\u008e\u0007\u008e\u0002\u008f\u0007"+
		"\u008f\u0002\u0090\u0007\u0090\u0002\u0091\u0007\u0091\u0002\u0092\u0007"+
		"\u0092\u0002\u0093\u0007\u0093\u0002\u0094\u0007\u0094\u0002\u0095\u0007"+
		"\u0095\u0002\u0096\u0007\u0096\u0002\u0097\u0007\u0097\u0002\u0098\u0007"+
		"\u0098\u0002\u0099\u0007\u0099\u0002\u009a\u0007\u009a\u0002\u009b\u0007"+
		"\u009b\u0002\u009c\u0007\u009c\u0002\u009d\u0007\u009d\u0002\u009e\u0007"+
		"\u009e\u0002\u009f\u0007\u009f\u0002\u00a0\u0007\u00a0\u0002\u00a1\u0007"+
		"\u00a1\u0002\u00a2\u0007\u00a2\u0002\u00a3\u0007\u00a3\u0002\u00a4\u0007"+
		"\u00a4\u0002\u00a5\u0007\u00a5\u0002\u00a6\u0007\u00a6\u0002\u00a7\u0007"+
		"\u00a7\u0002\u00a8\u0007\u00a8\u0002\u00a9\u0007\u00a9\u0002\u00aa\u0007"+
		"\u00aa\u0002\u00ab\u0007\u00ab\u0002\u00ac\u0007\u00ac\u0002\u00ad\u0007"+
		"\u00ad\u0002\u00ae\u0007\u00ae\u0002\u00af\u0007\u00af\u0002\u00b0\u0007"+
		"\u00b0\u0002\u00b1\u0007\u00b1\u0002\u00b2\u0007\u00b2\u0002\u00b3\u0007"+
		"\u00b3\u0002\u00b4\u0007\u00b4\u0002\u00b5\u0007\u00b5\u0002\u00b6\u0007"+
		"\u00b6\u0002\u00b7\u0007\u00b7\u0002\u00b8\u0007\u00b8\u0002\u00b9\u0007"+
		"\u00b9\u0002\u00ba\u0007\u00ba\u0002\u00bb\u0007\u00bb\u0002\u00bc\u0007"+
		"\u00bc\u0002\u00bd\u0007\u00bd\u0002\u00be\u0007\u00be\u0002\u00bf\u0007"+
		"\u00bf\u0002\u00c0\u0007\u00c0\u0002\u00c1\u0007\u00c1\u0002\u00c2\u0007"+
		"\u00c2\u0002\u00c3\u0007\u00c3\u0002\u00c4\u0007\u00c4\u0002\u00c5\u0007"+
		"\u00c5\u0002\u00c6\u0007\u00c6\u0002\u00c7\u0007\u00c7\u0002\u00c8\u0007"+
		"\u00c8\u0002\u00c9\u0007\u00c9\u0002\u00ca\u0007\u00ca\u0002\u00cb\u0007"+
		"\u00cb\u0002\u00cc\u0007\u00cc\u0002\u00cd\u0007\u00cd\u0002\u00ce\u0007"+
		"\u00ce\u0002\u00cf\u0007\u00cf\u0002\u00d0\u0007\u00d0\u0002\u00d1\u0007"+
		"\u00d1\u0002\u00d2\u0007\u00d2\u0002\u00d3\u0007\u00d3\u0002\u00d4\u0007"+
		"\u00d4\u0002\u00d5\u0007\u00d5\u0002\u00d6\u0007\u00d6\u0002\u00d7\u0007"+
		"\u00d7\u0002\u00d8\u0007\u00d8\u0002\u00d9\u0007\u00d9\u0002\u00da\u0007"+
		"\u00da\u0002\u00db\u0007\u00db\u0002\u00dc\u0007\u00dc\u0002\u00dd\u0007"+
		"\u00dd\u0002\u00de\u0007\u00de\u0002\u00df\u0007\u00df\u0002\u00e0\u0007"+
		"\u00e0\u0002\u00e1\u0007\u00e1\u0002\u00e2\u0007\u00e2\u0002\u00e3\u0007"+
		"\u00e3\u0002\u00e4\u0007\u00e4\u0002\u00e5\u0007\u00e5\u0002\u00e6\u0007"+
		"\u00e6\u0002\u00e7\u0007\u00e7\u0002\u00e8\u0007\u00e8\u0002\u00e9\u0007"+
		"\u00e9\u0002\u00ea\u0007\u00ea\u0002\u00eb\u0007\u00eb\u0002\u00ec\u0007"+
		"\u00ec\u0002\u00ed\u0007\u00ed\u0002\u00ee\u0007\u00ee\u0002\u00ef\u0007"+
		"\u00ef\u0002\u00f0\u0007\u00f0\u0002\u00f1\u0007\u00f1\u0002\u00f2\u0007"+
		"\u00f2\u0002\u00f3\u0007\u00f3\u0002\u00f4\u0007\u00f4\u0002\u00f5\u0007"+
		"\u00f5\u0002\u00f6\u0007\u00f6\u0002\u00f7\u0007\u00f7\u0002\u00f8\u0007"+
		"\u00f8\u0002\u00f9\u0007\u00f9\u0002\u00fa\u0007\u00fa\u0002\u00fb\u0007"+
		"\u00fb\u0002\u00fc\u0007\u00fc\u0002\u00fd\u0007\u00fd\u0002\u00fe\u0007"+
		"\u00fe\u0002\u00ff\u0007\u00ff\u0002\u0100\u0007\u0100\u0002\u0101\u0007"+
		"\u0101\u0002\u0102\u0007\u0102\u0002\u0103\u0007\u0103\u0002\u0104\u0007"+
		"\u0104\u0002\u0105\u0007\u0105\u0002\u0106\u0007\u0106\u0002\u0107\u0007"+
		"\u0107\u0002\u0108\u0007\u0108\u0002\u0109\u0007\u0109\u0002\u010a\u0007"+
		"\u010a\u0002\u010b\u0007\u010b\u0002\u010c\u0007\u010c\u0002\u010d\u0007"+
		"\u010d\u0002\u010e\u0007\u010e\u0002\u010f\u0007\u010f\u0002\u0110\u0007"+
		"\u0110\u0002\u0111\u0007\u0111\u0002\u0112\u0007\u0112\u0002\u0113\u0007"+
		"\u0113\u0002\u0114\u0007\u0114\u0002\u0115\u0007\u0115\u0002\u0116\u0007"+
		"\u0116\u0002\u0117\u0007\u0117\u0002\u0118\u0007\u0118\u0002\u0119\u0007"+
		"\u0119\u0002\u011a\u0007\u011a\u0002\u011b\u0007\u011b\u0002\u011c\u0007"+
		"\u011c\u0002\u011d\u0007\u011d\u0002\u011e\u0007\u011e\u0002\u011f\u0007"+
		"\u011f\u0002\u0120\u0007\u0120\u0002\u0121\u0007\u0121\u0002\u0122\u0007"+
		"\u0122\u0002\u0123\u0007\u0123\u0002\u0124\u0007\u0124\u0002\u0125\u0007"+
		"\u0125\u0002\u0126\u0007\u0126\u0002\u0127\u0007\u0127\u0002\u0128\u0007"+
		"\u0128\u0002\u0129\u0007\u0129\u0002\u012a\u0007\u012a\u0002\u012b\u0007"+
		"\u012b\u0002\u012c\u0007\u012c\u0002\u012d\u0007\u012d\u0002\u012e\u0007"+
		"\u012e\u0002\u012f\u0007\u012f\u0002\u0130\u0007\u0130\u0002\u0131\u0007"+
		"\u0131\u0002\u0132\u0007\u0132\u0002\u0133\u0007\u0133\u0002\u0134\u0007"+
		"\u0134\u0002\u0135\u0007\u0135\u0002\u0136\u0007\u0136\u0002\u0137\u0007"+
		"\u0137\u0002\u0138\u0007\u0138\u0002\u0139\u0007\u0139\u0002\u013a\u0007"+
		"\u013a\u0002\u013b\u0007\u013b\u0002\u013c\u0007\u013c\u0002\u013d\u0007"+
		"\u013d\u0002\u013e\u0007\u013e\u0002\u013f\u0007\u013f\u0002\u0140\u0007"+
		"\u0140\u0002\u0141\u0007\u0141\u0002\u0142\u0007\u0142\u0002\u0143\u0007"+
		"\u0143\u0002\u0144\u0007\u0144\u0002\u0145\u0007\u0145\u0002\u0146\u0007"+
		"\u0146\u0002\u0147\u0007\u0147\u0002\u0148\u0007\u0148\u0002\u0149\u0007"+
		"\u0149\u0002\u014a\u0007\u014a\u0002\u014b\u0007\u014b\u0002\u014c\u0007"+
		"\u014c\u0002\u014d\u0007\u014d\u0002\u014e\u0007\u014e\u0002\u014f\u0007"+
		"\u014f\u0002\u0150\u0007\u0150\u0002\u0151\u0007\u0151\u0002\u0152\u0007"+
		"\u0152\u0002\u0153\u0007\u0153\u0002\u0154\u0007\u0154\u0002\u0155\u0007"+
		"\u0155\u0002\u0156\u0007\u0156\u0002\u0157\u0007\u0157\u0002\u0158\u0007"+
		"\u0158\u0002\u0159\u0007\u0159\u0002\u015a\u0007\u015a\u0002\u015b\u0007"+
		"\u015b\u0002\u015c\u0007\u015c\u0002\u015d\u0007\u015d\u0002\u015e\u0007"+
		"\u015e\u0002\u015f\u0007\u015f\u0002\u0160\u0007\u0160\u0002\u0161\u0007"+
		"\u0161\u0002\u0162\u0007\u0162\u0002\u0163\u0007\u0163\u0002\u0164\u0007"+
		"\u0164\u0002\u0165\u0007\u0165\u0002\u0166\u0007\u0166\u0002\u0167\u0007"+
		"\u0167\u0002\u0168\u0007\u0168\u0002\u0169\u0007\u0169\u0002\u016a\u0007"+
		"\u016a\u0002\u016b\u0007\u016b\u0002\u016c\u0007\u016c\u0002\u016d\u0007"+
		"\u016d\u0002\u016e\u0007\u016e\u0002\u016f\u0007\u016f\u0002\u0170\u0007"+
		"\u0170\u0002\u0171\u0007\u0171\u0002\u0172\u0007\u0172\u0002\u0173\u0007"+
		"\u0173\u0002\u0174\u0007\u0174\u0002\u0175\u0007\u0175\u0002\u0176\u0007"+
		"\u0176\u0002\u0177\u0007\u0177\u0002\u0178\u0007\u0178\u0002\u0179\u0007"+
		"\u0179\u0002\u017a\u0007\u017a\u0002\u017b\u0007\u017b\u0002\u017c\u0007"+
		"\u017c\u0002\u017d\u0007\u017d\u0002\u017e\u0007\u017e\u0002\u017f\u0007"+
		"\u017f\u0001\u0000\u0001\u0000\u0005\u0000\u0303\b\u0000\n\u0000\f\u0000"+
		"\u0306\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0003\u0001\u030b\b"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u030f\b\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0003\u0002\u0314\b\u0002\u0001\u0002\u0001\u0002\u0003"+
		"\u0002\u0318\b\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u0323"+
		"\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0003\u0005\u032c\b\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0003\u0005\u0331\b\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u0335"+
		"\b\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u0339\b\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u033f\b\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005\u0343\b\u0005\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0003\u0007\u0349\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u0368"+
		"\b\b\u0001\t\u0001\t\u0003\t\u036c\b\t\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0003\t\u0373\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u0379"+
		"\b\t\u0001\n\u0001\n\u0001\n\u0003\n\u037e\b\n\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0003\f\u0389"+
		"\b\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0003\u000f\u039a\b\u000f\u0003\u000f\u039c\b\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f"+
		"\u03a3\b\u000f\u0003\u000f\u03a5\b\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0003\u0010\u03b1\b\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u03b9\b\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u03d7\b\u001b\u0001"+
		"\u001b\u0003\u001b\u03da\b\u001b\u0001\u001b\u0003\u001b\u03dd\b\u001b"+
		"\u0001\u001b\u0003\u001b\u03e0\b\u001b\u0001\u001b\u0003\u001b\u03e3\b"+
		"\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u03e7\b\u001b\u0001\u001c\u0005"+
		"\u001c\u03ea\b\u001c\n\u001c\f\u001c\u03ed\t\u001c\u0001\u001c\u0001\u001c"+
		"\u0003\u001c\u03f1\b\u001c\u0001\u001c\u0003\u001c\u03f4\b\u001c\u0001"+
		"\u001c\u0003\u001c\u03f7\b\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u03fb"+
		"\b\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u03ff\b\u001c\u0001\u001c"+
		"\u0003\u001c\u0402\b\u001c\u0001\u001c\u0003\u001c\u0405\b\u001c\u0001"+
		"\u001c\u0003\u001c\u0408\b\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0003"+
		"\u001c\u040d\b\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u0411\b\u001c"+
		"\u0001\u001c\u0001\u001c\u0003\u001c\u0415\b\u001c\u0001\u001c\u0001\u001c"+
		"\u0003\u001c\u0419\b\u001c\u0001\u001c\u0005\u001c\u041c\b\u001c\n\u001c"+
		"\f\u001c\u041f\t\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u0423\b\u001c"+
		"\u0001\u001c\u0001\u001c\u0003\u001c\u0427\b\u001c\u0001\u001c\u0001\u001c"+
		"\u0003\u001c\u042b\b\u001c\u0001\u001c\u0003\u001c\u042e\b\u001c\u0001"+
		"\u001c\u0001\u001c\u0003\u001c\u0432\b\u001c\u0001\u001c\u0003\u001c\u0435"+
		"\b\u001c\u0001\u001c\u0003\u001c\u0438\b\u001c\u0001\u001c\u0001\u001c"+
		"\u0003\u001c\u043c\b\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0003\u001c"+
		"\u0441\b\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u0446\b"+
		"\u001c\u0001\u001c\u0003\u001c\u0449\b\u001c\u0001\u001c\u0003\u001c\u044c"+
		"\b\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0003\u001c\u0454\b\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u045d\b\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u0463\b\u001c\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0003\u001d\u0468\b\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0003\u001d\u046d\b\u001d\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0003\u001e\u0472\b\u001e\u0001\u001e\u0001\u001e\u0003\u001e\u0476"+
		"\b\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0003\u001f\u047b\b\u001f"+
		"\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0003 \u0482\b \u0001 \u0001"+
		" \u0003 \u0486\b \u0001!\u0001!\u0001!\u0003!\u048b\b!\u0001!\u0001!\u0001"+
		"!\u0003!\u0490\b!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001\"\u0001\"\u0001"+
		"\"\u0003\"\u049a\b\"\u0001\"\u0001\"\u0003\"\u049e\b\"\u0001#\u0001#\u0001"+
		"#\u0003#\u04a3\b#\u0001#\u0003#\u04a6\b#\u0001#\u0001#\u0003#\u04aa\b"+
		"#\u0001$\u0001$\u0001$\u0003$\u04af\b$\u0001$\u0001$\u0003$\u04b3\b$\u0001"+
		"%\u0001%\u0001%\u0004%\u04b8\b%\u000b%\f%\u04b9\u0001%\u0001%\u0001&\u0001"+
		"&\u0003&\u04c0\b&\u0001&\u0003&\u04c3\b&\u0001&\u0001&\u0003&\u04c7\b"+
		"&\u0001&\u0001&\u0003&\u04cb\b&\u0001&\u0003&\u04ce\b&\u0001&\u0003&\u04d1"+
		"\b&\u0001&\u0001&\u0001&\u0003&\u04d6\b&\u0001\'\u0001\'\u0003\'\u04da"+
		"\b\'\u0001\'\u0001\'\u0003\'\u04de\b\'\u0001\'\u0001\'\u0003\'\u04e2\b"+
		"\'\u0001\'\u0003\'\u04e5\b\'\u0001\'\u0003\'\u04e8\b\'\u0001\'\u0001\'"+
		"\u0001\'\u0001(\u0001(\u0003(\u04ef\b(\u0001)\u0001)\u0003)\u04f3\b)\u0001"+
		")\u0001)\u0003)\u04f7\b)\u0001)\u0001)\u0001)\u0001)\u0001*\u0001*\u0003"+
		"*\u04ff\b*\u0001*\u0001*\u0003*\u0503\b*\u0001*\u0001*\u0001*\u0001+\u0001"+
		"+\u0001,\u0001,\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001"+
		"-\u0001-\u0001-\u0003-\u0516\b-\u0001.\u0001.\u0001/\u0001/\u00010\u0001"+
		"0\u00010\u00030\u051f\b0\u00011\u00011\u00011\u00011\u00011\u00051\u0526"+
		"\b1\n1\f1\u0529\t1\u00011\u00011\u00012\u00012\u00032\u052f\b2\u00012"+
		"\u00012\u00012\u00032\u0534\b2\u00012\u00012\u00012\u00012\u00012\u0003"+
		"2\u053b\b2\u00012\u00032\u053e\b2\u00013\u00013\u00033\u0542\b3\u0001"+
		"3\u00013\u00013\u00013\u00014\u00014\u00014\u00034\u054b\b4\u00014\u0001"+
		"4\u00014\u00015\u00015\u00015\u00035\u0553\b5\u00015\u00015\u00015\u0001"+
		"5\u00015\u00016\u00016\u00016\u00036\u055d\b6\u00016\u00016\u00016\u0001"+
		"6\u00016\u00036\u0564\b6\u00017\u00017\u00017\u00057\u0569\b7\n7\f7\u056c"+
		"\t7\u00018\u00018\u00038\u0570\b8\u00019\u00019\u00019\u0001:\u0001:\u0001"+
		":\u0001;\u0001;\u0001;\u0003;\u057b\b;\u0001;\u0001;\u0003;\u057f\b;\u0001"+
		";\u0001;\u0001;\u0001;\u0003;\u0585\b;\u0001;\u0001;\u0001<\u0001<\u0001"+
		"<\u0001<\u0005<\u058d\b<\n<\f<\u0590\t<\u0001<\u0001<\u0001=\u0005=\u0595"+
		"\b=\n=\f=\u0598\t=\u0001=\u0001=\u0001=\u0003=\u059d\b=\u0001=\u0003="+
		"\u05a0\b=\u0001=\u0003=\u05a3\b=\u0001=\u0003=\u05a6\b=\u0001=\u0003="+
		"\u05a9\b=\u0001=\u0003=\u05ac\b=\u0001=\u0003=\u05af\b=\u0001=\u0003="+
		"\u05b2\b=\u0001=\u0001=\u0003=\u05b6\b=\u0001>\u0005>\u05b9\b>\n>\f>\u05bc"+
		"\t>\u0001>\u0001>\u0003>\u05c0\b>\u0001>\u0001>\u0001>\u0001>\u0001>\u0001"+
		"?\u0001?\u0003?\u05c9\b?\u0001?\u0003?\u05cc\b?\u0001?\u0003?\u05cf\b"+
		"?\u0001?\u0003?\u05d2\b?\u0001?\u0003?\u05d5\b?\u0001?\u0003?\u05d8\b"+
		"?\u0001?\u0003?\u05db\b?\u0001?\u0003?\u05de\b?\u0001?\u0003?\u05e1\b"+
		"?\u0001@\u0001@\u0001A\u0001A\u0001A\u0003A\u05e8\bA\u0001B\u0001B\u0001"+
		"B\u0001C\u0001C\u0001C\u0001D\u0001D\u0001D\u0001E\u0001E\u0001E\u0001"+
		"F\u0001F\u0001G\u0001G\u0001G\u0001H\u0001H\u0001H\u0001H\u0005H\u05ff"+
		"\bH\nH\fH\u0602\tH\u0001H\u0001H\u0001I\u0001I\u0001I\u0001I\u0001J\u0001"+
		"J\u0001J\u0001J\u0001K\u0001K\u0001L\u0001L\u0001L\u0001L\u0001M\u0001"+
		"M\u0003M\u0616\bM\u0001N\u0001N\u0001N\u0005N\u061b\bN\nN\fN\u061e\tN"+
		"\u0001O\u0001O\u0001O\u0001O\u0001O\u0005O\u0625\bO\nO\fO\u0628\tO\u0001"+
		"P\u0001P\u0001P\u0001P\u0001Q\u0001Q\u0001Q\u0001Q\u0005Q\u0632\bQ\nQ"+
		"\fQ\u0635\tQ\u0001Q\u0001Q\u0001R\u0001R\u0001R\u0003R\u063c\bR\u0001"+
		"R\u0003R\u063f\bR\u0001S\u0001S\u0001S\u0001S\u0003S\u0645\bS\u0001S\u0003"+
		"S\u0648\bS\u0001T\u0001T\u0001T\u0001T\u0003T\u064e\bT\u0001T\u0003T\u0651"+
		"\bT\u0001U\u0001U\u0001U\u0003U\u0656\bU\u0001U\u0003U\u0659\bU\u0001"+
		"V\u0001V\u0001V\u0001V\u0004V\u065f\bV\u000bV\fV\u0660\u0001W\u0001W\u0001"+
		"X\u0001X\u0001X\u0001Y\u0001Y\u0001Y\u0001Z\u0001Z\u0001Z\u0001Z\u0001"+
		"[\u0001[\u0001[\u0003[\u0672\b[\u0001[\u0001[\u0003[\u0676\b[\u0001\\"+
		"\u0001\\\u0001\\\u0001\\\u0001\\\u0001]\u0001]\u0001]\u0001]\u0001]\u0001"+
		"^\u0001^\u0003^\u0684\b^\u0001^\u0001^\u0003^\u0688\b^\u0001^\u0003^\u068b"+
		"\b^\u0001^\u0003^\u068e\b^\u0001^\u0003^\u0691\b^\u0001^\u0003^\u0694"+
		"\b^\u0001^\u0003^\u0697\b^\u0001^\u0003^\u069a\b^\u0001^\u0003^\u069d"+
		"\b^\u0001^\u0001^\u0001_\u0004_\u06a2\b_\u000b_\f_\u06a3\u0001`\u0001"+
		"`\u0001`\u0001a\u0001a\u0001a\u0001b\u0001b\u0001b\u0001b\u0001b\u0003"+
		"b\u06b1\bb\u0001c\u0001c\u0001c\u0001c\u0001c\u0005c\u06b8\bc\nc\fc\u06bb"+
		"\tc\u0001c\u0001c\u0001d\u0001d\u0001d\u0003d\u06c2\bd\u0001e\u0001e\u0001"+
		"e\u0001e\u0001e\u0001e\u0001e\u0001e\u0001e\u0001e\u0001e\u0003e\u06cf"+
		"\be\u0001f\u0001f\u0001f\u0001f\u0003f\u06d5\bf\u0001g\u0001g\u0001g\u0001"+
		"g\u0001g\u0001g\u0001g\u0003g\u06de\bg\u0001h\u0001h\u0001h\u0001h\u0001"+
		"h\u0003h\u06e5\bh\u0001i\u0001i\u0001i\u0001i\u0001i\u0001i\u0003i\u06ed"+
		"\bi\u0003i\u06ef\bi\u0001i\u0001i\u0001i\u0001i\u0003i\u06f5\bi\u0001"+
		"j\u0001j\u0001j\u0001k\u0003k\u06fb\bk\u0001k\u0001k\u0003k\u06ff\bk\u0001"+
		"k\u0003k\u0702\bk\u0001l\u0001l\u0004l\u0706\bl\u000bl\fl\u0707\u0001"+
		"l\u0001l\u0001l\u0004l\u070d\bl\u000bl\fl\u070e\u0003l\u0711\bl\u0001"+
		"l\u0001l\u0001m\u0001m\u0001m\u0001n\u0001n\u0001n\u0001o\u0001o\u0001"+
		"p\u0001p\u0001p\u0001p\u0003p\u0721\bp\u0001q\u0001q\u0001q\u0001q\u0001"+
		"q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001r\u0001r\u0001r\u0005r\u0730"+
		"\br\nr\fr\u0733\tr\u0001s\u0001s\u0001s\u0001s\u0001s\u0001s\u0001s\u0001"+
		"s\u0001s\u0001s\u0003s\u073f\bs\u0001s\u0001s\u0003s\u0743\bs\u0003s\u0745"+
		"\bs\u0001t\u0001t\u0001t\u0001t\u0001t\u0001t\u0001t\u0001t\u0001t\u0001"+
		"t\u0001t\u0003t\u0752\bt\u0001u\u0001u\u0001u\u0005u\u0757\bu\nu\fu\u075a"+
		"\tu\u0001v\u0001v\u0001v\u0001w\u0001w\u0001w\u0001x\u0001x\u0001x\u0001"+
		"x\u0001x\u0001x\u0001x\u0001x\u0001x\u0001x\u0001y\u0001y\u0001y\u0005"+
		"y\u076f\by\ny\fy\u0772\ty\u0001z\u0001z\u0001z\u0001z\u0003z\u0778\bz"+
		"\u0001z\u0001z\u0001z\u0001z\u0001{\u0001{\u0001{\u0001{\u0001{\u0001"+
		"|\u0001|\u0001}\u0001}\u0003}\u0787\b}\u0001}\u0001}\u0001}\u0005}\u078c"+
		"\b}\n}\f}\u078f\t}\u0001~\u0001~\u0001~\u0001~\u0001~\u0001~\u0001~\u0001"+
		"~\u0003~\u0799\b~\u0001\u007f\u0001\u007f\u0001\u007f\u0001\u007f\u0001"+
		"\u007f\u0001\u007f\u0005\u007f\u07a1\b\u007f\n\u007f\f\u007f\u07a4\t\u007f"+
		"\u0001\u007f\u0001\u007f\u0003\u007f\u07a8\b\u007f\u0001\u0080\u0001\u0080"+
		"\u0001\u0080\u0003\u0080\u07ad\b\u0080\u0001\u0080\u0001\u0080\u0001\u0081"+
		"\u0001\u0081\u0001\u0081\u0001\u0081\u0003\u0081\u07b5\b\u0081\u0001\u0081"+
		"\u0001\u0081\u0001\u0082\u0001\u0082\u0001\u0082\u0003\u0082\u07bc\b\u0082"+
		"\u0001\u0082\u0001\u0082\u0003\u0082\u07c0\b\u0082\u0001\u0083\u0001\u0083"+
		"\u0001\u0083\u0003\u0083\u07c5\b\u0083\u0001\u0083\u0001\u0083\u0003\u0083"+
		"\u07c9\b\u0083\u0001\u0084\u0001\u0084\u0001\u0084\u0001\u0084\u0003\u0084"+
		"\u07cf\b\u0084\u0001\u0084\u0001\u0084\u0003\u0084\u07d3\b\u0084\u0001"+
		"\u0085\u0001\u0085\u0001\u0085\u0003\u0085\u07d8\b\u0085\u0001\u0085\u0001"+
		"\u0085\u0001\u0086\u0001\u0086\u0001\u0087\u0001\u0087\u0001\u0087\u0003"+
		"\u0087\u07e1\b\u0087\u0001\u0088\u0001\u0088\u0003\u0088\u07e5\b\u0088"+
		"\u0001\u0089\u0001\u0089\u0001\u0089\u0001\u0089\u0003\u0089\u07eb\b\u0089"+
		"\u0001\u008a\u0001\u008a\u0001\u008a\u0001\u008a\u0003\u008a\u07f1\b\u008a"+
		"\u0001\u008b\u0001\u008b\u0001\u008b\u0001\u008c\u0001\u008c\u0001\u008c"+
		"\u0001\u008d\u0001\u008d\u0001\u008d\u0001\u008e\u0001\u008e\u0001\u008e"+
		"\u0001\u008f\u0001\u008f\u0001\u0090\u0001\u0090\u0003\u0090\u0803\b\u0090"+
		"\u0001\u0091\u0001\u0091\u0001\u0091\u0001\u0091\u0001\u0091\u0001\u0091"+
		"\u0001\u0091\u0001\u0091\u0001\u0091\u0003\u0091\u080e\b\u0091\u0001\u0092"+
		"\u0001\u0092\u0003\u0092\u0812\b\u0092\u0001\u0093\u0001\u0093\u0001\u0094"+
		"\u0001\u0094\u0003\u0094\u0818\b\u0094\u0001\u0094\u0001\u0094\u0003\u0094"+
		"\u081c\b\u0094\u0001\u0094\u0001\u0094\u0001\u0094\u0003\u0094\u0821\b"+
		"\u0094\u0001\u0094\u0001\u0094\u0001\u0094\u0003\u0094\u0826\b\u0094\u0001"+
		"\u0094\u0001\u0094\u0003\u0094\u082a\b\u0094\u0001\u0094\u0001\u0094\u0001"+
		"\u0094\u0003\u0094\u082f\b\u0094\u0001\u0094\u0001\u0094\u0001\u0094\u0003"+
		"\u0094\u0834\b\u0094\u0001\u0094\u0001\u0094\u0003\u0094\u0838\b\u0094"+
		"\u0001\u0094\u0001\u0094\u0001\u0094\u0003\u0094\u083d\b\u0094\u0003\u0094"+
		"\u083f\b\u0094\u0001\u0095\u0001\u0095\u0001\u0095\u0001\u0095\u0001\u0096"+
		"\u0001\u0096\u0001\u0096\u0003\u0096\u0848\b\u0096\u0001\u0096\u0001\u0096"+
		"\u0001\u0096\u0003\u0096\u084d\b\u0096\u0001\u0096\u0001\u0096\u0003\u0096"+
		"\u0851\b\u0096\u0001\u0096\u0001\u0096\u0001\u0096\u0001\u0096\u0003\u0096"+
		"\u0857\b\u0096\u0001\u0096\u0001\u0096\u0001\u0096\u0001\u0096\u0003\u0096"+
		"\u085d\b\u0096\u0001\u0096\u0001\u0096\u0001\u0096\u0003\u0096\u0862\b"+
		"\u0096\u0001\u0096\u0001\u0096\u0003\u0096\u0866\b\u0096\u0003\u0096\u0868"+
		"\b\u0096\u0001\u0097\u0001\u0097\u0003\u0097\u086c\b\u0097\u0001\u0097"+
		"\u0001\u0097\u0003\u0097\u0870\b\u0097\u0003\u0097\u0872\b\u0097\u0001"+
		"\u0098\u0001\u0098\u0003\u0098\u0876\b\u0098\u0001\u0099\u0001\u0099\u0003"+
		"\u0099\u087a\b\u0099\u0001\u0099\u0001\u0099\u0003\u0099\u087e\b\u0099"+
		"\u0001\u0099\u0001\u0099\u0003\u0099\u0882\b\u0099\u0001\u0099\u0001\u0099"+
		"\u0003\u0099\u0886\b\u0099\u0001\u0099\u0001\u0099\u0001\u0099\u0001\u0099"+
		"\u0001\u0099\u0001\u0099\u0001\u0099\u0001\u0099\u0001\u0099\u0001\u0099"+
		"\u0001\u0099\u0001\u0099\u0001\u0099\u0003\u0099\u0895\b\u0099\u0001\u009a"+
		"\u0001\u009a\u0003\u009a\u0899\b\u009a\u0001\u009a\u0001\u009a\u0001\u009a"+
		"\u0001\u009a\u0001\u009a\u0001\u009a\u0003\u009a\u08a1\b\u009a\u0001\u009b"+
		"\u0001\u009b\u0001\u009b\u0001\u009b\u0001\u009b\u0001\u009b\u0001\u009b"+
		"\u0001\u009b\u0003\u009b\u08ab\b\u009b\u0001\u009c\u0001\u009c\u0001\u009d"+
		"\u0001\u009d\u0003\u009d\u08b1\b\u009d\u0001\u009d\u0001\u009d\u0001\u009d"+
		"\u0001\u009d\u0001\u009d\u0001\u009d\u0001\u009d\u0001\u009d\u0001\u009d"+
		"\u0001\u009d\u0003\u009d\u08bd\b\u009d\u0001\u009d\u0001\u009d\u0001\u009d"+
		"\u0001\u009d\u0001\u009d\u0003\u009d\u08c4\b\u009d\u0001\u009e\u0001\u009e"+
		"\u0003\u009e\u08c8\b\u009e\u0001\u009e\u0001\u009e\u0003\u009e\u08cc\b"+
		"\u009e\u0001\u009e\u0001\u009e\u0001\u009e\u0003\u009e\u08d1\b\u009e\u0003"+
		"\u009e\u08d3\b\u009e\u0001\u009f\u0001\u009f\u0003\u009f\u08d7\b\u009f"+
		"\u0001\u009f\u0001\u009f\u0001\u009f\u0003\u009f\u08dc\b\u009f\u0001\u009f"+
		"\u0001\u009f\u0003\u009f\u08e0\b\u009f\u0003\u009f\u08e2\b\u009f\u0001"+
		"\u00a0\u0001\u00a0\u0003\u00a0\u08e6\b\u00a0\u0001\u00a1\u0001\u00a1\u0001"+
		"\u00a1\u0001\u00a1\u0001\u00a2\u0001\u00a2\u0001\u00a2\u0001\u00a2\u0001"+
		"\u00a2\u0001\u00a2\u0001\u00a2\u0001\u00a2\u0001\u00a2\u0001\u00a2\u0001"+
		"\u00a2\u0001\u00a2\u0003\u00a2\u08f8\b\u00a2\u0001\u00a3\u0001\u00a3\u0001"+
		"\u00a4\u0001\u00a4\u0001\u00a5\u0003\u00a5\u08ff\b\u00a5\u0001\u00a5\u0001"+
		"\u00a5\u0001\u00a6\u0001\u00a6\u0001\u00a7\u0001\u00a7\u0001\u00a7\u0001"+
		"\u00a7\u0001\u00a7\u0001\u00a7\u0003\u00a7\u090b\b\u00a7\u0003\u00a7\u090d"+
		"\b\u00a7\u0001\u00a8\u0001\u00a8\u0001\u00a8\u0003\u00a8\u0912\b\u00a8"+
		"\u0001\u00a8\u0001\u00a8\u0001\u00a8\u0001\u00a9\u0001\u00a9\u0001\u00aa"+
		"\u0001\u00aa\u0001\u00aa\u0001\u00aa\u0001\u00aa\u0001\u00aa\u0001\u00aa"+
		"\u0001\u00ab\u0001\u00ab\u0001\u00ab\u0001\u00ab\u0001\u00ab\u0001\u00ac"+
		"\u0001\u00ac\u0001\u00ac\u0001\u00ac\u0001\u00ac\u0003\u00ac\u092a\b\u00ac"+
		"\u0001\u00ac\u0001\u00ac\u0001\u00ac\u0001\u00ac\u0001\u00ac\u0001\u00ac"+
		"\u0001\u00ac\u0003\u00ac\u0933\b\u00ac\u0001\u00ad\u0001\u00ad\u0001\u00ad"+
		"\u0001\u00ad\u0001\u00ae\u0001\u00ae\u0001\u00af\u0001\u00af\u0001\u00af"+
		"\u0001\u00af\u0001\u00af\u0001\u00af\u0001\u00af\u0001\u00af\u0001\u00af"+
		"\u0001\u00af\u0001\u00af\u0001\u00af\u0003\u00af\u0947\b\u00af\u0001\u00af"+
		"\u0001\u00af\u0001\u00af\u0001\u00af\u0001\u00af\u0001\u00af\u0003\u00af"+
		"\u094f\b\u00af\u0001\u00af\u0001\u00af\u0001\u00af\u0001\u00af\u0001\u00af"+
		"\u0001\u00af\u0001\u00af\u0001\u00af\u0001\u00af\u0003\u00af\u095a\b\u00af"+
		"\u0003\u00af\u095c\b\u00af\u0001\u00af\u0001\u00af\u0001\u00af\u0001\u00af"+
		"\u0001\u00af\u0001\u00af\u0001\u00af\u0001\u00af\u0001\u00af\u0003\u00af"+
		"\u0967\b\u00af\u0003\u00af\u0969\b\u00af\u0001\u00af\u0001\u00af\u0003"+
		"\u00af\u096d\b\u00af\u0001\u00b0\u0001\u00b0\u0001\u00b1\u0001\u00b1\u0003"+
		"\u00b1\u0973\b\u00b1\u0001\u00b2\u0001\u00b2\u0001\u00b3\u0001\u00b3\u0001"+
		"\u00b3\u0001\u00b3\u0001\u00b3\u0001\u00b3\u0001\u00b3\u0001\u00b3\u0001"+
		"\u00b3\u0001\u00b3\u0001\u00b3\u0001\u00b3\u0004\u00b3\u0983\b\u00b3\u000b"+
		"\u00b3\f\u00b3\u0984\u0001\u00b3\u0001\u00b3\u0003\u00b3\u0989\b\u00b3"+
		"\u0001\u00b4\u0001\u00b4\u0003\u00b4\u098d\b\u00b4\u0001\u00b5\u0001\u00b5"+
		"\u0001\u00b5\u0004\u00b5\u0992\b\u00b5\u000b\u00b5\f\u00b5\u0993\u0001"+
		"\u00b5\u0003\u00b5\u0997\b\u00b5\u0001\u00b5\u0001\u00b5\u0001\u00b6\u0001"+
		"\u00b6\u0004\u00b6\u099d\b\u00b6\u000b\u00b6\f\u00b6\u099e\u0001\u00b6"+
		"\u0003\u00b6\u09a2\b\u00b6\u0001\u00b6\u0001\u00b6\u0001\u00b7\u0001\u00b7"+
		"\u0001\u00b7\u0001\u00b7\u0001\u00b7\u0001\u00b8\u0001\u00b8\u0001\u00b8"+
		"\u0001\u00b8\u0001\u00b8\u0001\u00b9\u0001\u00b9\u0001\u00b9\u0001\u00ba"+
		"\u0001\u00ba\u0003\u00ba\u09b5\b\u00ba\u0001\u00bb\u0001\u00bb\u0001\u00bb"+
		"\u0001\u00bb\u0001\u00bb\u0001\u00bb\u0001\u00bb\u0001\u00bc\u0001\u00bc"+
		"\u0001\u00bd\u0001\u00bd\u0001\u00be\u0001\u00be\u0001\u00be\u0001\u00be"+
		"\u0001\u00be\u0001\u00be\u0001\u00be\u0003\u00be\u09c9\b\u00be\u0001\u00be"+
		"\u0001\u00be\u0001\u00bf\u0001\u00bf\u0001\u00bf\u0003\u00bf\u09d0\b\u00bf"+
		"\u0001\u00c0\u0001\u00c0\u0001\u00c0\u0001\u00c0\u0001\u00c0\u0001\u00c0"+
		"\u0001\u00c0\u0001\u00c0\u0003\u00c0\u09da\b\u00c0\u0001\u00c1\u0001\u00c1"+
		"\u0001\u00c1\u0005\u00c1\u09df\b\u00c1\n\u00c1\f\u00c1\u09e2\t\u00c1\u0001"+
		"\u00c2\u0001\u00c2\u0001\u00c2\u0005\u00c2\u09e7\b\u00c2\n\u00c2\f\u00c2"+
		"\u09ea\t\u00c2\u0001\u00c3\u0003\u00c3\u09ed\b\u00c3\u0001\u00c3\u0001"+
		"\u00c3\u0001\u00c4\u0001\u00c4\u0001\u00c4\u0001\u00c4\u0005\u00c4\u09f5"+
		"\b\u00c4\n\u00c4\f\u00c4\u09f8\t\u00c4\u0001\u00c4\u0001\u00c4\u0001\u00c5"+
		"\u0001\u00c5\u0001\u00c5\u0005\u00c5\u09ff\b\u00c5\n\u00c5\f\u00c5\u0a02"+
		"\t\u00c5\u0001\u00c5\u0003\u00c5\u0a05\b\u00c5\u0001\u00c6\u0001\u00c6"+
		"\u0001\u00c7\u0001\u00c7\u0001\u00c8\u0001\u00c8\u0001\u00c8\u0001\u00c8"+
		"\u0001\u00c8\u0001\u00c8\u0001\u00c8\u0001\u00c9\u0001\u00c9\u0001\u00c9"+
		"\u0003\u00c9\u0a15\b\u00c9\u0001\u00ca\u0001\u00ca\u0001\u00cb\u0001\u00cb"+
		"\u0001\u00cc\u0001\u00cc\u0001\u00cd\u0001\u00cd\u0001\u00cd\u0005\u00cd"+
		"\u0a20\b\u00cd\n\u00cd\f\u00cd\u0a23\t\u00cd\u0001\u00ce\u0001\u00ce\u0001"+
		"\u00cf\u0001\u00cf\u0003\u00cf\u0a29\b\u00cf\u0001\u00d0\u0001\u00d0\u0001"+
		"\u00d1\u0001\u00d1\u0001\u00d1\u0001\u00d1\u0001\u00d1\u0001\u00d2\u0003"+
		"\u00d2\u0a33\b\u00d2\u0001\u00d2\u0003\u00d2\u0a36\b\u00d2\u0001\u00d2"+
		"\u0003\u00d2\u0a39\b\u00d2\u0001\u00d2\u0001\u00d2\u0001\u00d2\u0001\u00d2"+
		"\u0001\u00d2\u0003\u00d2\u0a40\b\u00d2\u0001\u00d3\u0001\u00d3\u0001\u00d4"+
		"\u0001\u00d4\u0001\u00d5\u0001\u00d5\u0001\u00d6\u0001\u00d6\u0001\u00d7"+
		"\u0001\u00d7\u0003\u00d7\u0a4c\b\u00d7\u0001\u00d8\u0001\u00d8\u0001\u00d8"+
		"\u0003\u00d8\u0a51\b\u00d8\u0001\u00d9\u0001\u00d9\u0001\u00d9\u0001\u00d9"+
		"\u0003\u00d9\u0a57\b\u00d9\u0001\u00da\u0001\u00da\u0001\u00da\u0001\u00da"+
		"\u0003\u00da\u0a5d\b\u00da\u0001\u00db\u0001\u00db\u0001\u00dc\u0001\u00dc"+
		"\u0001\u00dd\u0001\u00dd\u0001\u00dd\u0005\u00dd\u0a66\b\u00dd\n\u00dd"+
		"\f\u00dd\u0a69\t\u00dd\u0001\u00de\u0005\u00de\u0a6c\b\u00de\n\u00de\f"+
		"\u00de\u0a6f\t\u00de\u0001\u00de\u0001\u00de\u0001\u00de\u0005\u00de\u0a74"+
		"\b\u00de\n\u00de\f\u00de\u0a77\t\u00de\u0001\u00df\u0001\u00df\u0001\u00df"+
		"\u0003\u00df\u0a7c\b\u00df\u0001\u00e0\u0001\u00e0\u0003\u00e0\u0a80\b"+
		"\u00e0\u0001\u00e1\u0001\u00e1\u0003\u00e1\u0a84\b\u00e1\u0001\u00e1\u0001"+
		"\u00e1\u0001\u00e2\u0001\u00e2\u0001\u00e3\u0001\u00e3\u0003\u00e3\u0a8c"+
		"\b\u00e3\u0001\u00e4\u0001\u00e4\u0003\u00e4\u0a90\b\u00e4\u0001\u00e5"+
		"\u0001\u00e5\u0001\u00e5\u0001\u00e5\u0001\u00e6\u0001\u00e6\u0001\u00e7"+
		"\u0001\u00e7\u0001\u00e8\u0001\u00e8\u0001\u00e9\u0001\u00e9\u0003\u00e9"+
		"\u0a9e\b\u00e9\u0001\u00ea\u0001\u00ea\u0001\u00eb\u0001\u00eb\u0001\u00ec"+
		"\u0001\u00ec\u0003\u00ec\u0aa6\b\u00ec\u0001\u00ed\u0001\u00ed\u0003\u00ed"+
		"\u0aaa\b\u00ed\u0001\u00ee\u0001\u00ee\u0003\u00ee\u0aae\b\u00ee\u0001"+
		"\u00ee\u0003\u00ee\u0ab1\b\u00ee\u0001\u00ee\u0003\u00ee\u0ab4\b\u00ee"+
		"\u0001\u00ee\u0003\u00ee\u0ab7\b\u00ee\u0001\u00ee\u0003\u00ee\u0aba\b"+
		"\u00ee\u0001\u00ee\u0003\u00ee\u0abd\b\u00ee\u0001\u00ee\u0003\u00ee\u0ac0"+
		"\b\u00ee\u0001\u00ee\u0003\u00ee\u0ac3\b\u00ee\u0001\u00ef\u0001\u00ef"+
		"\u0001\u00ef\u0001\u00f0\u0001\u00f0\u0001\u00f0\u0005\u00f0\u0acb\b\u00f0"+
		"\n\u00f0\f\u00f0\u0ace\t\u00f0\u0001\u00f1\u0003\u00f1\u0ad1\b\u00f1\u0001"+
		"\u00f1\u0001\u00f1\u0001\u00f1\u0005\u00f1\u0ad6\b\u00f1\n\u00f1\f\u00f1"+
		"\u0ad9\t\u00f1\u0001\u00f1\u0003\u00f1\u0adc\b\u00f1\u0001\u00f2\u0003"+
		"\u00f2\u0adf\b\u00f2\u0001\u00f2\u0001\u00f2\u0001\u00f2\u0005\u00f2\u0ae4"+
		"\b\u00f2\n\u00f2\f\u00f2\u0ae7\t\u00f2\u0001\u00f2\u0003\u00f2\u0aea\b"+
		"\u00f2\u0001\u00f3\u0001\u00f3\u0001\u00f3\u0001\u00f3\u0003\u00f3\u0af0"+
		"\b\u00f3\u0001\u00f4\u0001\u00f4\u0001\u00f4\u0001\u00f4\u0005\u00f4\u0af6"+
		"\b\u00f4\n\u00f4\f\u00f4\u0af9\t\u00f4\u0001\u00f4\u0001\u00f4\u0001\u00f5"+
		"\u0001\u00f5\u0001\u00f5\u0003\u00f5\u0b00\b\u00f5\u0001\u00f5\u0001\u00f5"+
		"\u0001\u00f5\u0001\u00f5\u0001\u00f5\u0001\u00f5\u0001\u00f5\u0001\u00f5"+
		"\u0003\u00f5\u0b0a\b\u00f5\u0001\u00f5\u0001\u00f5\u0001\u00f6\u0003\u00f6"+
		"\u0b0f\b\u00f6\u0001\u00f6\u0001\u00f6\u0001\u00f6\u0005\u00f6\u0b14\b"+
		"\u00f6\n\u00f6\f\u00f6\u0b17\t\u00f6\u0001\u00f6\u0003\u00f6\u0b1a\b\u00f6"+
		"\u0001\u00f7\u0003\u00f7\u0b1d\b\u00f7\u0001\u00f7\u0001\u00f7\u0001\u00f7"+
		"\u0005\u00f7\u0b22\b\u00f7\n\u00f7\f\u00f7\u0b25\t\u00f7\u0001\u00f7\u0003"+
		"\u00f7\u0b28\b\u00f7\u0001\u00f8\u0001\u00f8\u0001\u00f8\u0001\u00f8\u0003"+
		"\u00f8\u0b2e\b\u00f8\u0001\u00f9\u0001\u00f9\u0001\u00f9\u0001\u00f9\u0005"+
		"\u00f9\u0b34\b\u00f9\n\u00f9\f\u00f9\u0b37\t\u00f9\u0001\u00f9\u0001\u00f9"+
		"\u0001\u00fa\u0001\u00fa\u0001\u00fa\u0001\u00fa\u0001\u00fa\u0001\u00fa"+
		"\u0001\u00fa\u0001\u00fa\u0001\u00fa\u0003\u00fa\u0b44\b\u00fa\u0001\u00fa"+
		"\u0001\u00fa\u0001\u00fb\u0001\u00fb\u0003\u00fb\u0b4a\b\u00fb\u0001\u00fc"+
		"\u0005\u00fc\u0b4d\b\u00fc\n\u00fc\f\u00fc\u0b50\t\u00fc\u0001\u00fc\u0001"+
		"\u00fc\u0001\u00fd\u0003\u00fd\u0b55\b\u00fd\u0001\u00fd\u0001\u00fd\u0005"+
		"\u00fd\u0b59\b\u00fd\n\u00fd\f\u00fd\u0b5c\t\u00fd\u0001\u00fd\u0003\u00fd"+
		"\u0b5f\b\u00fd\u0001\u00fe\u0001\u00fe\u0001\u00fe\u0001\u00fe\u0003\u00fe"+
		"\u0b65\b\u00fe\u0001\u00fe\u0001\u00fe\u0001\u00fe\u0001\u00fe\u0001\u00fe"+
		"\u0001\u00fe\u0003\u00fe\u0b6d\b\u00fe\u0001\u00fe\u0001\u00fe\u0001\u00fe"+
		"\u0001\u00fe\u0001\u00fe\u0001\u00fe\u0001\u00fe\u0003\u00fe\u0b76\b\u00fe"+
		"\u0001\u00ff\u0001\u00ff\u0001\u00ff\u0001\u00ff\u0001\u0100\u0003\u0100"+
		"\u0b7d\b\u0100\u0001\u0100\u0001\u0100\u0001\u0100\u0001\u0100\u0001\u0101"+
		"\u0001\u0101\u0003\u0101\u0b85\b\u0101\u0001\u0101\u0001\u0101\u0001\u0101"+
		"\u0001\u0102\u0001\u0102\u0001\u0102\u0001\u0102\u0001\u0103\u0001\u0103"+
		"\u0003\u0103\u0b90\b\u0103\u0001\u0104\u0001\u0104\u0003\u0104\u0b94\b"+
		"\u0104\u0001\u0105\u0001\u0105\u0001\u0106\u0001\u0106\u0001\u0106\u0001"+
		"\u0107\u0001\u0107\u0001\u0107\u0001\u0108\u0001\u0108\u0001\u0108\u0001"+
		"\u0109\u0001\u0109\u0001\u0109\u0001\u0109\u0001\u0109\u0001\u0109\u0001"+
		"\u0109\u0003\u0109\u0ba8\b\u0109\u0001\u010a\u0001\u010a\u0003\u010a\u0bac"+
		"\b\u010a\u0001\u010a\u0003\u010a\u0baf\b\u010a\u0001\u010b\u0001\u010b"+
		"\u0001\u010b\u0001\u010c\u0001\u010c\u0001\u010c\u0001\u010c\u0001\u010c"+
		"\u0001\u010d\u0001\u010d\u0003\u010d\u0bbb\b\u010d\u0001\u010d\u0003\u010d"+
		"\u0bbe\b\u010d\u0001\u010d\u0001\u010d\u0001\u010d\u0001\u010d\u0003\u010d"+
		"\u0bc4\b\u010d\u0001\u010d\u0001\u010d\u0003\u010d\u0bc8\b\u010d\u0001"+
		"\u010d\u0001\u010d\u0001\u010d\u0001\u010d\u0001\u010d\u0003\u010d\u0bcf"+
		"\b\u010d\u0001\u010d\u0001\u010d\u0001\u010d\u0001\u010d\u0001\u010d\u0001"+
		"\u010d\u0003\u010d\u0bd7\b\u010d\u0001\u010d\u0001\u010d\u0003\u010d\u0bdb"+
		"\b\u010d\u0001\u010e\u0003\u010e\u0bde\b\u010e\u0001\u010e\u0005\u010e"+
		"\u0be1\b\u010e\n\u010e\f\u010e\u0be4\t\u010e\u0001\u010e\u0001\u010e\u0001"+
		"\u010f\u0005\u010f\u0be9\b\u010f\n\u010f\f\u010f\u0bec\t\u010f\u0001\u0110"+
		"\u0001\u0110\u0001\u0111\u0005\u0111\u0bf1\b\u0111\n\u0111\f\u0111\u0bf4"+
		"\t\u0111\u0001\u0111\u0001\u0111\u0001\u0111\u0001\u0112\u0001\u0112\u0001"+
		"\u0113\u0005\u0113\u0bfc\b\u0113\n\u0113\f\u0113\u0bff\t\u0113\u0001\u0113"+
		"\u0001\u0113\u0001\u0113\u0001\u0113\u0001\u0114\u0001\u0114\u0001\u0114"+
		"\u0005\u0114\u0c08\b\u0114\n\u0114\f\u0114\u0c0b\t\u0114\u0001\u0115\u0001"+
		"\u0115\u0001\u0115\u0001\u0115\u0003\u0115\u0c11\b\u0115\u0001\u0116\u0001"+
		"\u0116\u0001\u0116\u0001\u0116\u0001\u0116\u0003\u0116\u0c18\b\u0116\u0001"+
		"\u0117\u0001\u0117\u0001\u0117\u0005\u0117\u0c1d\b\u0117\n\u0117\f\u0117"+
		"\u0c20\t\u0117\u0001\u0118\u0001\u0118\u0001\u0118\u0001\u0118\u0001\u0118"+
		"\u0001\u0119\u0001\u0119\u0001\u0119\u0001\u0119\u0001\u0119\u0001\u011a"+
		"\u0001\u011a\u0001\u011a\u0001\u011b\u0001\u011b\u0001\u011b\u0001\u011c"+
		"\u0001\u011c\u0001\u011c\u0005\u011c\u0c35\b\u011c\n\u011c\f\u011c\u0c38"+
		"\t\u011c\u0001\u011d\u0001\u011d\u0001\u011d\u0001\u011e\u0001\u011e\u0001"+
		"\u011e\u0005\u011e\u0c40\b\u011e\n\u011e\f\u011e\u0c43\t\u011e\u0001\u011f"+
		"\u0001\u011f\u0001\u011f\u0001\u011f\u0001\u0120\u0001\u0120\u0001\u0121"+
		"\u0001\u0121\u0001\u0121\u0001\u0121\u0001\u0122\u0003\u0122\u0c50\b\u0122"+
		"\u0001\u0122\u0003\u0122\u0c53\b\u0122\u0001\u0122\u0003\u0122\u0c56\b"+
		"\u0122\u0001\u0122\u0003\u0122\u0c59\b\u0122\u0001\u0123\u0001\u0123\u0001"+
		"\u0124\u0001\u0124\u0001\u0124\u0001\u0124\u0001\u0125\u0001\u0125\u0001"+
		"\u0126\u0001\u0126\u0001\u0126\u0003\u0126\u0c66\b\u0126\u0001\u0127\u0001"+
		"\u0127\u0001\u0128\u0001\u0128\u0003\u0128\u0c6c\b\u0128\u0001\u0129\u0001"+
		"\u0129\u0001\u0129\u0001\u0129\u0001\u0129\u0001\u0129\u0001\u0129\u0003"+
		"\u0129\u0c75\b\u0129\u0001\u012a\u0001\u012a\u0001\u012a\u0001\u012a\u0001"+
		"\u012a\u0001\u012b\u0001\u012b\u0001\u012b\u0001\u012b\u0001\u012b\u0001"+
		"\u012b\u0001\u012b\u0003\u012b\u0c83\b\u012b\u0001\u012c\u0001\u012c\u0001"+
		"\u012c\u0001\u012c\u0001\u012c\u0001\u012c\u0001\u012c\u0001\u012c\u0001"+
		"\u012c\u0001\u012c\u0003\u012c\u0c8f\b\u012c\u0001\u012d\u0001\u012d\u0001"+
		"\u012d\u0001\u012d\u0001\u012d\u0001\u012d\u0001\u012e\u0001\u012e\u0001"+
		"\u012e\u0001\u012e\u0005\u012e\u0c9b\b\u012e\n\u012e\f\u012e\u0c9e\t\u012e"+
		"\u0001\u012f\u0003\u012f\u0ca1\b\u012f\u0001\u012f\u0001\u012f\u0001\u0130"+
		"\u0001\u0130\u0003\u0130\u0ca7\b\u0130\u0001\u0131\u0001\u0131\u0001\u0131"+
		"\u0001\u0131\u0003\u0131\u0cad\b\u0131\u0001\u0131\u0001\u0131\u0003\u0131"+
		"\u0cb1\b\u0131\u0001\u0131\u0005\u0131\u0cb4\b\u0131\n\u0131\f\u0131\u0cb7"+
		"\t\u0131\u0001\u0131\u0001\u0131\u0003\u0131\u0cbb\b\u0131\u0001\u0131"+
		"\u0005\u0131\u0cbe\b\u0131\n\u0131\f\u0131\u0cc1\t\u0131\u0001\u0132\u0001"+
		"\u0132\u0003\u0132\u0cc5\b\u0132\u0001\u0133\u0001\u0133\u0001\u0133\u0005"+
		"\u0133\u0cca\b\u0133\n\u0133\f\u0133\u0ccd\t\u0133\u0001\u0133\u0001\u0133"+
		"\u0003\u0133\u0cd1\b\u0133\u0001\u0133\u0001\u0133\u0003\u0133\u0cd5\b"+
		"\u0133\u0001\u0133\u0001\u0133\u0003\u0133\u0cd9\b\u0133\u0001\u0133\u0005"+
		"\u0133\u0cdc\b\u0133\n\u0133\f\u0133\u0cdf\t\u0133\u0001\u0134\u0001\u0134"+
		"\u0003\u0134\u0ce3\b\u0134\u0001\u0135\u0001\u0135\u0001\u0135\u0001\u0135"+
		"\u0001\u0135\u0003\u0135\u0cea\b\u0135\u0001\u0136\u0001\u0136\u0003\u0136"+
		"\u0cee\b\u0136\u0001\u0137\u0001\u0137\u0001\u0137\u0001\u0138\u0001\u0138"+
		"\u0003\u0138\u0cf5\b\u0138\u0001\u0139\u0001\u0139\u0001\u0139\u0001\u0139"+
		"\u0001\u0139\u0003\u0139\u0cfc\b\u0139\u0003\u0139\u0cfe\b\u0139\u0001"+
		"\u0139\u0003\u0139\u0d01\b\u0139\u0001\u013a\u0001\u013a\u0001\u013b\u0001"+
		"\u013b\u0001\u013b\u0004\u013b\u0d08\b\u013b\u000b\u013b\f\u013b\u0d09"+
		"\u0001\u013c\u0001\u013c\u0001\u013c\u0001\u013c\u0001\u013c\u0001\u013c"+
		"\u0001\u013c\u0005\u013c\u0d13\b\u013c\n\u013c\f\u013c\u0d16\t\u013c\u0001"+
		"\u013d\u0001\u013d\u0001\u013d\u0001\u013d\u0001\u013d\u0001\u013d\u0003"+
		"\u013d\u0d1e\b\u013d\u0001\u013d\u0001\u013d\u0001\u013e\u0005\u013e\u0d23"+
		"\b\u013e\n\u013e\f\u013e\u0d26\t\u013e\u0001\u013e\u0001\u013e\u0003\u013e"+
		"\u0d2a\b\u013e\u0001\u013e\u0003\u013e\u0d2d\b\u013e\u0001\u013e\u0001"+
		"\u013e\u0003\u013e\u0d31\b\u013e\u0001\u013f\u0001\u013f\u0001\u013f\u0005"+
		"\u013f\u0d36\b\u013f\n\u013f\f\u013f\u0d39\t\u013f\u0001\u0140\u0001\u0140"+
		"\u0003\u0140\u0d3d\b\u0140\u0001\u0141\u0005\u0141\u0d40\b\u0141\n\u0141"+
		"\f\u0141\u0d43\t\u0141\u0001\u0141\u0001\u0141\u0003\u0141\u0d47\b\u0141"+
		"\u0001\u0142\u0001\u0142\u0001\u0142\u0003\u0142\u0d4c\b\u0142\u0001\u0142"+
		"\u0001\u0142\u0001\u0143\u0001\u0143\u0001\u0144\u0001\u0144\u0001\u0144"+
		"\u0003\u0144\u0d55\b\u0144\u0001\u0144\u0001\u0144\u0001\u0144\u0003\u0144"+
		"\u0d5a\b\u0144\u0001\u0144\u0001\u0144\u0001\u0145\u0003\u0145\u0d5f\b"+
		"\u0145\u0001\u0145\u0001\u0145\u0001\u0146\u0001\u0146\u0001\u0146\u0005"+
		"\u0146\u0d66\b\u0146\n\u0146\f\u0146\u0d69\t\u0146\u0001\u0147\u0001\u0147"+
		"\u0001\u0147\u0001\u0148\u0001\u0148\u0001\u0149\u0001\u0149\u0001\u014a"+
		"\u0001\u014a\u0001\u014b\u0001\u014b\u0001\u014b\u0001\u014b\u0001\u014c"+
		"\u0001\u014c\u0001\u014c\u0001\u014c\u0001\u014c\u0001\u014c\u0001\u014c"+
		"\u0003\u014c\u0d7f\b\u014c\u0001\u014d\u0001\u014d\u0001\u014d\u0003\u014d"+
		"\u0d84\b\u014d\u0001\u014d\u0001\u014d\u0001\u014e\u0001\u014e\u0003\u014e"+
		"\u0d8a\b\u014e\u0001\u014f\u0001\u014f\u0001\u0150\u0001\u0150\u0001\u0151"+
		"\u0001\u0151\u0001\u0151\u0001\u0151\u0001\u0152\u0001\u0152\u0001\u0153"+
		"\u0001\u0153\u0001\u0153\u0001\u0154\u0003\u0154\u0d9a\b\u0154\u0001\u0154"+
		"\u0001\u0154\u0003\u0154\u0d9e\b\u0154\u0001\u0154\u0001\u0154\u0001\u0154"+
		"\u0001\u0154\u0001\u0155\u0001\u0155\u0003\u0155\u0da6\b\u0155\u0001\u0155"+
		"\u0001\u0155\u0001\u0155\u0001\u0155\u0001\u0155\u0001\u0155\u0001\u0155"+
		"\u0003\u0155\u0daf\b\u0155\u0001\u0155\u0001\u0155\u0001\u0155\u0003\u0155"+
		"\u0db4\b\u0155\u0001\u0156\u0001\u0156\u0001\u0156\u0001\u0156\u0001\u0156"+
		"\u0003\u0156\u0dbb\b\u0156\u0001\u0157\u0001\u0157\u0001\u0157\u0005\u0157"+
		"\u0dc0\b\u0157\n\u0157\f\u0157\u0dc3\t\u0157\u0001\u0158\u0001\u0158\u0001"+
		"\u0158\u0001\u0158\u0001\u0159\u0003\u0159\u0dca\b\u0159\u0001\u0159\u0001"+
		"\u0159\u0003\u0159\u0dce\b\u0159\u0001\u015a\u0001\u015a\u0001\u015a\u0001"+
		"\u015a\u0001\u015a\u0001\u015a\u0003\u015a\u0dd6\b\u015a\u0001\u015b\u0001"+
		"\u015b\u0001\u015c\u0001\u015c\u0001\u015c\u0003\u015c\u0ddd\b\u015c\u0001"+
		"\u015c\u0001\u015c\u0001\u015d\u0003\u015d\u0de2\b\u015d\u0001\u015d\u0001"+
		"\u015d\u0001\u015d\u0001\u015e\u0001\u015e\u0001\u015e\u0001\u015f\u0001"+
		"\u015f\u0003\u015f\u0dec\b\u015f\u0001\u0160\u0001\u0160\u0001\u0161\u0001"+
		"\u0161\u0001\u0162\u0001\u0162\u0001\u0162\u0003\u0162\u0df5\b\u0162\u0001"+
		"\u0162\u0001\u0162\u0001\u0163\u0001\u0163\u0001\u0164\u0001\u0164\u0003"+
		"\u0164\u0dfd\b\u0164\u0001\u0165\u0001\u0165\u0001\u0165\u0003\u0165\u0e02"+
		"\b\u0165\u0001\u0165\u0001\u0165\u0001\u0165\u0003\u0165\u0e07\b\u0165"+
		"\u0001\u0165\u0001\u0165\u0003\u0165\u0e0b\b\u0165\u0001\u0166\u0001\u0166"+
		"\u0001\u0166\u0005\u0166\u0e10\b\u0166\n\u0166\f\u0166\u0e13\t\u0166\u0001"+
		"\u0167\u0001\u0167\u0001\u0167\u0001\u0167\u0001\u0167\u0001\u0168\u0005"+
		"\u0168\u0e1b\b\u0168\n\u0168\f\u0168\u0e1e\t\u0168\u0001\u0168\u0001\u0168"+
		"\u0001\u0168\u0001\u0168\u0001\u0169\u0001\u0169\u0001\u0169\u0005\u0169"+
		"\u0e27\b\u0169\n\u0169\f\u0169\u0e2a\t\u0169\u0001\u016a\u0001\u016a\u0003"+
		"\u016a\u0e2e\b\u016a\u0001\u016a\u0003\u016a\u0e31\b\u016a\u0001\u016b"+
		"\u0001\u016b\u0001\u016c\u0001\u016c\u0001\u016c\u0001\u016d\u0001\u016d"+
		"\u0001\u016d\u0001\u016d\u0003\u016d\u0e3c\b\u016d\u0001\u016e\u0001\u016e"+
		"\u0001\u016e\u0001\u016e\u0001\u016e\u0003\u016e\u0e43\b\u016e\u0001\u016e"+
		"\u0001\u016e\u0001\u016e\u0001\u016e\u0001\u016e\u0003\u016e\u0e4a\b\u016e"+
		"\u0001\u016f\u0005\u016f\u0e4d\b\u016f\n\u016f\f\u016f\u0e50\t\u016f\u0001"+
		"\u016f\u0001\u016f\u0003\u016f\u0e54\b\u016f\u0001\u016f\u0001\u016f\u0001"+
		"\u016f\u0003\u016f\u0e59\b\u016f\u0001\u016f\u0001\u016f\u0001\u016f\u0001"+
		"\u016f\u0003\u016f\u0e5f\b\u016f\u0001\u016f\u0003\u016f\u0e62\b\u016f"+
		"\u0001\u016f\u0001\u016f\u0001\u016f\u0001\u016f\u0003\u016f\u0e68\b\u016f"+
		"\u0001\u016f\u0001\u016f\u0001\u016f\u0001\u016f\u0001\u016f\u0001\u016f"+
		"\u0003\u016f\u0e70\b\u016f\u0003\u016f\u0e72\b\u016f\u0001\u016f\u0003"+
		"\u016f\u0e75\b\u016f\u0001\u0170\u0001\u0170\u0001\u0170\u0005\u0170\u0e7a"+
		"\b\u0170\n\u0170\f\u0170\u0e7d\t\u0170\u0001\u0171\u0005\u0171\u0e80\b"+
		"\u0171\n\u0171\f\u0171\u0e83\t\u0171\u0001\u0171\u0001\u0171\u0001\u0171"+
		"\u0001\u0171\u0003\u0171\u0e89\b\u0171\u0001\u0171\u0001\u0171\u0001\u0171"+
		"\u0003\u0171\u0e8e\b\u0171\u0001\u0171\u0001\u0171\u0001\u0171\u0001\u0171"+
		"\u0003\u0171\u0e94\b\u0171\u0001\u0171\u0001\u0171\u0001\u0171\u0001\u0171"+
		"\u0001\u0171\u0001\u0171\u0003\u0171\u0e9c\b\u0171\u0001\u0172\u0001\u0172"+
		"\u0001\u0172\u0001\u0172\u0003\u0172\u0ea2\b\u0172\u0001\u0172\u0001\u0172"+
		"\u0001\u0172\u0001\u0172\u0003\u0172\u0ea8\b\u0172\u0001\u0172\u0001\u0172"+
		"\u0001\u0172\u0001\u0172\u0001\u0172\u0001\u0172\u0003\u0172\u0eb0\b\u0172"+
		"\u0001\u0173\u0005\u0173\u0eb3\b\u0173\n\u0173\f\u0173\u0eb6\t\u0173\u0001"+
		"\u0173\u0001\u0173\u0001\u0173\u0004\u0173\u0ebb\b\u0173\u000b\u0173\f"+
		"\u0173\u0ebc\u0001\u0173\u0003\u0173\u0ec0\b\u0173\u0001\u0173\u0001\u0173"+
		"\u0001\u0174\u0001\u0174\u0001\u0174\u0001\u0174\u0001\u0174\u0001\u0174"+
		"\u0001\u0175\u0001\u0175\u0001\u0175\u0001\u0175\u0001\u0175\u0001\u0175"+
		"\u0001\u0175\u0003\u0175\u0ed1\b\u0175\u0001\u0175\u0001\u0175\u0001\u0175"+
		"\u0001\u0175\u0001\u0176\u0001\u0176\u0001\u0176\u0001\u0176\u0001\u0176"+
		"\u0001\u0176\u0001\u0176\u0001\u0177\u0001\u0177\u0001\u0177\u0001\u0177"+
		"\u0001\u0177\u0001\u0177\u0001\u0177\u0001\u0177\u0001\u0177\u0001\u0177"+
		"\u0003\u0177\u0ee8\b\u0177\u0001\u0178\u0001\u0178\u0001\u0178\u0001\u0178"+
		"\u0003\u0178\u0eee\b\u0178\u0001\u0179\u0001\u0179\u0001\u0179\u0001\u0179"+
		"\u0003\u0179\u0ef4\b\u0179\u0001\u017a\u0001\u017a\u0001\u017a\u0001\u017b"+
		"\u0005\u017b\u0efa\b\u017b\n\u017b\f\u017b\u0efd\t\u017b\u0001\u017b\u0001"+
		"\u017b\u0003\u017b\u0f01\b\u017b\u0001\u017b\u0003\u017b\u0f04\b\u017b"+
		"\u0001\u017b\u0003\u017b\u0f07\b\u017b\u0001\u017b\u0003\u017b\u0f0a\b"+
		"\u017b\u0001\u017b\u0003\u017b\u0f0d\b\u017b\u0001\u017c\u0001\u017c\u0001"+
		"\u017c\u0001\u017c\u0001\u017c\u0001\u017c\u0001\u017c\u0001\u017c\u0001"+
		"\u017c\u0001\u017c\u0001\u017c\u0001\u017c\u0001\u017c\u0001\u017c\u0001"+
		"\u017c\u0001\u017c\u0001\u017c\u0001\u017c\u0001\u017c\u0001\u017c\u0001"+
		"\u017c\u0001\u017c\u0001\u017c\u0001\u017c\u0001\u017c\u0001\u017c\u0001"+
		"\u017c\u0001\u017c\u0001\u017c\u0001\u017c\u0001\u017c\u0001\u017c\u0001"+
		"\u017c\u0001\u017c\u0001\u017c\u0001\u017c\u0001\u017c\u0001\u017c\u0001"+
		"\u017c\u0001\u017c\u0001\u017c\u0001\u017c\u0003\u017c\u0f39\b\u017c\u0001"+
		"\u017d\u0001\u017d\u0001\u017d\u0003\u017d\u0f3e\b\u017d\u0001\u017d\u0001"+
		"\u017d\u0001\u017d\u0001\u017d\u0001\u017d\u0001\u017d\u0003\u017d\u0f46"+
		"\b\u017d\u0001\u017d\u0001\u017d\u0003\u017d\u0f4a\b\u017d\u0001\u017d"+
		"\u0001\u017d\u0001\u017d\u0001\u017d\u0003\u017d\u0f50\b\u017d\u0001\u017e"+
		"\u0001\u017e\u0001\u017e\u0001\u017f\u0001\u017f\u0003\u017f\u0f57\b\u017f"+
		"\u0001\u017f\u0001\u017f\u0001\u017f\u0000\u0000\u0180\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \""+
		"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086"+
		"\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e"+
		"\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6"+
		"\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\u00c8\u00ca\u00cc\u00ce"+
		"\u00d0\u00d2\u00d4\u00d6\u00d8\u00da\u00dc\u00de\u00e0\u00e2\u00e4\u00e6"+
		"\u00e8\u00ea\u00ec\u00ee\u00f0\u00f2\u00f4\u00f6\u00f8\u00fa\u00fc\u00fe"+
		"\u0100\u0102\u0104\u0106\u0108\u010a\u010c\u010e\u0110\u0112\u0114\u0116"+
		"\u0118\u011a\u011c\u011e\u0120\u0122\u0124\u0126\u0128\u012a\u012c\u012e"+
		"\u0130\u0132\u0134\u0136\u0138\u013a\u013c\u013e\u0140\u0142\u0144\u0146"+
		"\u0148\u014a\u014c\u014e\u0150\u0152\u0154\u0156\u0158\u015a\u015c\u015e"+
		"\u0160\u0162\u0164\u0166\u0168\u016a\u016c\u016e\u0170\u0172\u0174\u0176"+
		"\u0178\u017a\u017c\u017e\u0180\u0182\u0184\u0186\u0188\u018a\u018c\u018e"+
		"\u0190\u0192\u0194\u0196\u0198\u019a\u019c\u019e\u01a0\u01a2\u01a4\u01a6"+
		"\u01a8\u01aa\u01ac\u01ae\u01b0\u01b2\u01b4\u01b6\u01b8\u01ba\u01bc\u01be"+
		"\u01c0\u01c2\u01c4\u01c6\u01c8\u01ca\u01cc\u01ce\u01d0\u01d2\u01d4\u01d6"+
		"\u01d8\u01da\u01dc\u01de\u01e0\u01e2\u01e4\u01e6\u01e8\u01ea\u01ec\u01ee"+
		"\u01f0\u01f2\u01f4\u01f6\u01f8\u01fa\u01fc\u01fe\u0200\u0202\u0204\u0206"+
		"\u0208\u020a\u020c\u020e\u0210\u0212\u0214\u0216\u0218\u021a\u021c\u021e"+
		"\u0220\u0222\u0224\u0226\u0228\u022a\u022c\u022e\u0230\u0232\u0234\u0236"+
		"\u0238\u023a\u023c\u023e\u0240\u0242\u0244\u0246\u0248\u024a\u024c\u024e"+
		"\u0250\u0252\u0254\u0256\u0258\u025a\u025c\u025e\u0260\u0262\u0264\u0266"+
		"\u0268\u026a\u026c\u026e\u0270\u0272\u0274\u0276\u0278\u027a\u027c\u027e"+
		"\u0280\u0282\u0284\u0286\u0288\u028a\u028c\u028e\u0290\u0292\u0294\u0296"+
		"\u0298\u029a\u029c\u029e\u02a0\u02a2\u02a4\u02a6\u02a8\u02aa\u02ac\u02ae"+
		"\u02b0\u02b2\u02b4\u02b6\u02b8\u02ba\u02bc\u02be\u02c0\u02c2\u02c4\u02c6"+
		"\u02c8\u02ca\u02cc\u02ce\u02d0\u02d2\u02d4\u02d6\u02d8\u02da\u02dc\u02de"+
		"\u02e0\u02e2\u02e4\u02e6\u02e8\u02ea\u02ec\u02ee\u02f0\u02f2\u02f4\u02f6"+
		"\u02f8\u02fa\u02fc\u02fe\u0000\u001f\u0002\u0000\u00b6\u00b6\u00ee\u00ee"+
		"\u0001\u0000\u0113\u0114\u0002\u000077\u010a\u010a\u0003\u000000\u0118"+
		"\u0118\u011b\u011b\u0003\u0000%%./BB\u0001\u0000\u00fa\u00fb$\u0000\u0005"+
		"\u0005\u0007\u0007\u000b\u000e\u0011\u0011\u0016\u0016\u0018\u0018$&+"+
		"+.0225699AHJJNRT^buwz}\u0084\u0086\u00b6\u00b8\u00da\u00dc\u00e7\u0107"+
		"\u0107\u010a\u010e\u0113\u0113\u0116\u0116\u0118\u0118\u011b\u011c\u011e"+
		"\u0123\u0126\u012f\u0131\u0131\u0135\u0136\u013f\u013f\u014f\u014f\u0152"+
		"\u0152\u015b\u0162\u0003\u0000\u0015\u0015::\u00b9\u00b9\u0001\u0000\u016b"+
		"\u016c\u0001\u0000\u00c1\u00c2\u0001\u0000\u0106\u0107\r\u0000\u0004\u0004"+
		"44NNWWZZllxx\u007f\u007f\u0089\u0089\u008e\u008e\u00ab\u00ac\u00ae\u00ae"+
		"\u00bb\u00bc\u0002\u0000ss\u0083\u0083\u0001\u0000\u0153\u0154\u0004\u0000"+
		"\\\\gg\u0098\u0098\u009e\u009e\u0001\u0000\u00fc\u00fe\u0001\u0000\u00b2"+
		"\u00b4\u0003\u0000\u0007\u0007!!99\u0003\u0000\u0016\u0016\"\"11\u0002"+
		"\u0000\u009d\u009d\u00a5\u00a5\u0003\u0000\u0014\u0014;;\u0109\u0109\u0002"+
		"\u0000\u0002\u0002\u0010\u0010\u0002\u0000\u0004\u000444\u0002\u0000\u00ee"+
		"\u00ee\u00f3\u00f7\u0002\u0000\u0005\u000555\u0001\u0000\u00e8\u00eb\u0004"+
		"\u0000bb{{\u008f\u0090\u00bf\u00bf\b\u0000UUffhikk\u0080\u0081\u008b\u008d"+
		"\u009c\u009c\u00be\u00be\u0003\u0000\"\"11\u011e\u011e\u0002\u0000\u0006"+
		"\u0006\u000f\u000f\u0002\u0000\u00a5\u00a5\u0136\u0136\u105f\u0000\u0300"+
		"\u0001\u0000\u0000\u0000\u0002\u030a\u0001\u0000\u0000\u0000\u0004\u0313"+
		"\u0001\u0000\u0000\u0000\u0006\u0319\u0001\u0000\u0000\u0000\b\u0322\u0001"+
		"\u0000\u0000\u0000\n\u0342\u0001\u0000\u0000\u0000\f\u0344\u0001\u0000"+
		"\u0000\u0000\u000e\u0348\u0001\u0000\u0000\u0000\u0010\u0367\u0001\u0000"+
		"\u0000\u0000\u0012\u0369\u0001\u0000\u0000\u0000\u0014\u037a\u0001\u0000"+
		"\u0000\u0000\u0016\u0381\u0001\u0000\u0000\u0000\u0018\u0385\u0001\u0000"+
		"\u0000\u0000\u001a\u038c\u0001\u0000\u0000\u0000\u001c\u038f\u0001\u0000"+
		"\u0000\u0000\u001e\u03a4\u0001\u0000\u0000\u0000 \u03b0\u0001\u0000\u0000"+
		"\u0000\"\u03b2\u0001\u0000\u0000\u0000$\u03b5\u0001\u0000\u0000\u0000"+
		"&\u03ba\u0001\u0000\u0000\u0000(\u03bd\u0001\u0000\u0000\u0000*\u03c0"+
		"\u0001\u0000\u0000\u0000,\u03c3\u0001\u0000\u0000\u0000.\u03c6\u0001\u0000"+
		"\u0000\u00000\u03c9\u0001\u0000\u0000\u00002\u03cc\u0001\u0000\u0000\u0000"+
		"4\u03cf\u0001\u0000\u0000\u00006\u03d2\u0001\u0000\u0000\u00008\u0462"+
		"\u0001\u0000\u0000\u0000:\u0464\u0001\u0000\u0000\u0000<\u046e\u0001\u0000"+
		"\u0000\u0000>\u0477\u0001\u0000\u0000\u0000@\u047e\u0001\u0000\u0000\u0000"+
		"B\u0487\u0001\u0000\u0000\u0000D\u0496\u0001\u0000\u0000\u0000F\u049f"+
		"\u0001\u0000\u0000\u0000H\u04ab\u0001\u0000\u0000\u0000J\u04b4\u0001\u0000"+
		"\u0000\u0000L\u04bd\u0001\u0000\u0000\u0000N\u04d7\u0001\u0000\u0000\u0000"+
		"P\u04ee\u0001\u0000\u0000\u0000R\u04f0\u0001\u0000\u0000\u0000T\u04fc"+
		"\u0001\u0000\u0000\u0000V\u0507\u0001\u0000\u0000\u0000X\u0509\u0001\u0000"+
		"\u0000\u0000Z\u0515\u0001\u0000\u0000\u0000\\\u0517\u0001\u0000\u0000"+
		"\u0000^\u0519\u0001\u0000\u0000\u0000`\u051b\u0001\u0000\u0000\u0000b"+
		"\u0520\u0001\u0000\u0000\u0000d\u052c\u0001\u0000\u0000\u0000f\u053f\u0001"+
		"\u0000\u0000\u0000h\u0547\u0001\u0000\u0000\u0000j\u054f\u0001\u0000\u0000"+
		"\u0000l\u0559\u0001\u0000\u0000\u0000n\u0565\u0001\u0000\u0000\u0000p"+
		"\u056d\u0001\u0000\u0000\u0000r\u0571\u0001\u0000\u0000\u0000t\u0574\u0001"+
		"\u0000\u0000\u0000v\u0577\u0001\u0000\u0000\u0000x\u0588\u0001\u0000\u0000"+
		"\u0000z\u05b5\u0001\u0000\u0000\u0000|\u05ba\u0001\u0000\u0000\u0000~"+
		"\u05c6\u0001\u0000\u0000\u0000\u0080\u05e2\u0001\u0000\u0000\u0000\u0082"+
		"\u05e7\u0001\u0000\u0000\u0000\u0084\u05e9\u0001\u0000\u0000\u0000\u0086"+
		"\u05ec\u0001\u0000\u0000\u0000\u0088\u05ef\u0001\u0000\u0000\u0000\u008a"+
		"\u05f2\u0001\u0000\u0000\u0000\u008c\u05f5\u0001\u0000\u0000\u0000\u008e"+
		"\u05f7\u0001\u0000\u0000\u0000\u0090\u05fa\u0001\u0000\u0000\u0000\u0092"+
		"\u0605\u0001\u0000\u0000\u0000\u0094\u0609\u0001\u0000\u0000\u0000\u0096"+
		"\u060d\u0001\u0000\u0000\u0000\u0098\u060f\u0001\u0000\u0000\u0000\u009a"+
		"\u0615\u0001\u0000\u0000\u0000\u009c\u0617\u0001\u0000\u0000\u0000\u009e"+
		"\u061f\u0001\u0000\u0000\u0000\u00a0\u0629\u0001\u0000\u0000\u0000\u00a2"+
		"\u062d\u0001\u0000\u0000\u0000\u00a4\u0638\u0001\u0000\u0000\u0000\u00a6"+
		"\u0640\u0001\u0000\u0000\u0000\u00a8\u0649\u0001\u0000\u0000\u0000\u00aa"+
		"\u0652\u0001\u0000\u0000\u0000\u00ac\u065e\u0001\u0000\u0000\u0000\u00ae"+
		"\u0662\u0001\u0000\u0000\u0000\u00b0\u0664\u0001\u0000\u0000\u0000\u00b2"+
		"\u0667\u0001\u0000\u0000\u0000\u00b4\u066a\u0001\u0000\u0000\u0000\u00b6"+
		"\u066e\u0001\u0000\u0000\u0000\u00b8\u0677\u0001\u0000\u0000\u0000\u00ba"+
		"\u067c\u0001\u0000\u0000\u0000\u00bc\u0681\u0001\u0000\u0000\u0000\u00be"+
		"\u06a1\u0001\u0000\u0000\u0000\u00c0\u06a5\u0001\u0000\u0000\u0000\u00c2"+
		"\u06a8\u0001\u0000\u0000\u0000\u00c4\u06ab\u0001\u0000\u0000\u0000\u00c6"+
		"\u06b2\u0001\u0000\u0000\u0000\u00c8\u06be\u0001\u0000\u0000\u0000\u00ca"+
		"\u06ce\u0001\u0000\u0000\u0000\u00cc\u06d0\u0001\u0000\u0000\u0000\u00ce"+
		"\u06dd\u0001\u0000\u0000\u0000\u00d0\u06df\u0001\u0000\u0000\u0000\u00d2"+
		"\u06e6\u0001\u0000\u0000\u0000\u00d4\u06f6\u0001\u0000\u0000\u0000\u00d6"+
		"\u06fa\u0001\u0000\u0000\u0000\u00d8\u0703\u0001\u0000\u0000\u0000\u00da"+
		"\u0714\u0001\u0000\u0000\u0000\u00dc\u0717\u0001\u0000\u0000\u0000\u00de"+
		"\u071a\u0001\u0000\u0000\u0000\u00e0\u0720\u0001\u0000\u0000\u0000\u00e2"+
		"\u0722\u0001\u0000\u0000\u0000\u00e4\u072c\u0001\u0000\u0000\u0000\u00e6"+
		"\u0734\u0001\u0000\u0000\u0000\u00e8\u0746\u0001\u0000\u0000\u0000\u00ea"+
		"\u0753\u0001\u0000\u0000\u0000\u00ec\u075b\u0001\u0000\u0000\u0000\u00ee"+
		"\u075e\u0001\u0000\u0000\u0000\u00f0\u0761\u0001\u0000\u0000\u0000\u00f2"+
		"\u076b\u0001\u0000\u0000\u0000\u00f4\u0773\u0001\u0000\u0000\u0000\u00f6"+
		"\u077d\u0001\u0000\u0000\u0000\u00f8\u0782\u0001\u0000\u0000\u0000\u00fa"+
		"\u0784\u0001\u0000\u0000\u0000\u00fc\u0798\u0001\u0000\u0000\u0000\u00fe"+
		"\u079a\u0001\u0000\u0000\u0000\u0100\u07a9\u0001\u0000\u0000\u0000\u0102"+
		"\u07b0\u0001\u0000\u0000\u0000\u0104\u07b8\u0001\u0000\u0000\u0000\u0106"+
		"\u07c1\u0001\u0000\u0000\u0000\u0108\u07ca\u0001\u0000\u0000\u0000\u010a"+
		"\u07d4\u0001\u0000\u0000\u0000\u010c\u07db\u0001\u0000\u0000\u0000\u010e"+
		"\u07e0\u0001\u0000\u0000\u0000\u0110\u07e4\u0001\u0000\u0000\u0000\u0112"+
		"\u07ea\u0001\u0000\u0000\u0000\u0114\u07f0\u0001\u0000\u0000\u0000\u0116"+
		"\u07f2\u0001\u0000\u0000\u0000\u0118\u07f5\u0001\u0000\u0000\u0000\u011a"+
		"\u07f8\u0001\u0000\u0000\u0000\u011c\u07fb\u0001\u0000\u0000\u0000\u011e"+
		"\u07fe\u0001\u0000\u0000\u0000\u0120\u0802\u0001\u0000\u0000\u0000\u0122"+
		"\u080d\u0001\u0000\u0000\u0000\u0124\u080f\u0001\u0000\u0000\u0000\u0126"+
		"\u0813\u0001\u0000\u0000\u0000\u0128\u083e\u0001\u0000\u0000\u0000\u012a"+
		"\u0840\u0001\u0000\u0000\u0000\u012c\u0867\u0001\u0000\u0000\u0000\u012e"+
		"\u0871\u0001\u0000\u0000\u0000\u0130\u0875\u0001\u0000\u0000\u0000\u0132"+
		"\u0894\u0001\u0000\u0000\u0000\u0134\u08a0\u0001\u0000\u0000\u0000\u0136"+
		"\u08aa\u0001\u0000\u0000\u0000\u0138\u08ac\u0001\u0000\u0000\u0000\u013a"+
		"\u08c3\u0001\u0000\u0000\u0000\u013c\u08d2\u0001\u0000\u0000\u0000\u013e"+
		"\u08e1\u0001\u0000\u0000\u0000\u0140\u08e5\u0001\u0000\u0000\u0000\u0142"+
		"\u08e7\u0001\u0000\u0000\u0000\u0144\u08f7\u0001\u0000\u0000\u0000\u0146"+
		"\u08f9\u0001\u0000\u0000\u0000\u0148\u08fb\u0001\u0000\u0000\u0000\u014a"+
		"\u08fe\u0001\u0000\u0000\u0000\u014c\u0902\u0001\u0000\u0000\u0000\u014e"+
		"\u090c\u0001\u0000\u0000\u0000\u0150\u090e\u0001\u0000\u0000\u0000\u0152"+
		"\u0916\u0001\u0000\u0000\u0000\u0154\u0918\u0001\u0000\u0000\u0000\u0156"+
		"\u091f\u0001\u0000\u0000\u0000\u0158\u0924\u0001\u0000\u0000\u0000\u015a"+
		"\u0934\u0001\u0000\u0000\u0000\u015c\u0938\u0001\u0000\u0000\u0000\u015e"+
		"\u096c\u0001\u0000\u0000\u0000\u0160\u096e\u0001\u0000\u0000\u0000\u0162"+
		"\u0972\u0001\u0000\u0000\u0000\u0164\u0974\u0001\u0000\u0000\u0000\u0166"+
		"\u0988\u0001\u0000\u0000\u0000\u0168\u098c\u0001\u0000\u0000\u0000\u016a"+
		"\u098e\u0001\u0000\u0000\u0000\u016c\u099a\u0001\u0000\u0000\u0000\u016e"+
		"\u09a5\u0001\u0000\u0000\u0000\u0170\u09aa\u0001\u0000\u0000\u0000\u0172"+
		"\u09af\u0001\u0000\u0000\u0000\u0174\u09b4\u0001\u0000\u0000\u0000\u0176"+
		"\u09b6\u0001\u0000\u0000\u0000\u0178\u09bd\u0001\u0000\u0000\u0000\u017a"+
		"\u09bf\u0001\u0000\u0000\u0000\u017c\u09c1\u0001\u0000\u0000\u0000\u017e"+
		"\u09cf\u0001\u0000\u0000\u0000\u0180\u09d9\u0001\u0000\u0000\u0000\u0182"+
		"\u09db\u0001\u0000\u0000\u0000\u0184\u09e3\u0001\u0000\u0000\u0000\u0186"+
		"\u09ec\u0001\u0000\u0000\u0000\u0188\u09f0\u0001\u0000\u0000\u0000\u018a"+
		"\u0a04\u0001\u0000\u0000\u0000\u018c\u0a06\u0001\u0000\u0000\u0000\u018e"+
		"\u0a08\u0001\u0000\u0000\u0000\u0190\u0a0a\u0001\u0000\u0000\u0000\u0192"+
		"\u0a14\u0001\u0000\u0000\u0000\u0194\u0a16\u0001\u0000\u0000\u0000\u0196"+
		"\u0a18\u0001\u0000\u0000\u0000\u0198\u0a1a\u0001\u0000\u0000\u0000\u019a"+
		"\u0a1c\u0001\u0000\u0000\u0000\u019c\u0a24\u0001\u0000\u0000\u0000\u019e"+
		"\u0a28\u0001\u0000\u0000\u0000\u01a0\u0a2a\u0001\u0000\u0000\u0000\u01a2"+
		"\u0a2c\u0001\u0000\u0000\u0000\u01a4\u0a3f\u0001\u0000\u0000\u0000\u01a6"+
		"\u0a41\u0001\u0000\u0000\u0000\u01a8\u0a43\u0001\u0000\u0000\u0000\u01aa"+
		"\u0a45\u0001\u0000\u0000\u0000\u01ac\u0a47\u0001\u0000\u0000\u0000\u01ae"+
		"\u0a4b\u0001\u0000\u0000\u0000\u01b0\u0a50\u0001\u0000\u0000\u0000\u01b2"+
		"\u0a56\u0001\u0000\u0000\u0000\u01b4\u0a5c\u0001\u0000\u0000\u0000\u01b6"+
		"\u0a5e\u0001\u0000\u0000\u0000\u01b8\u0a60\u0001\u0000\u0000\u0000\u01ba"+
		"\u0a62\u0001\u0000\u0000\u0000\u01bc\u0a6d\u0001\u0000\u0000\u0000\u01be"+
		"\u0a7b\u0001\u0000\u0000\u0000\u01c0\u0a7d\u0001\u0000\u0000\u0000\u01c2"+
		"\u0a81\u0001\u0000\u0000\u0000\u01c4\u0a87\u0001\u0000\u0000\u0000\u01c6"+
		"\u0a8b\u0001\u0000\u0000\u0000\u01c8\u0a8f\u0001\u0000\u0000\u0000\u01ca"+
		"\u0a91\u0001\u0000\u0000\u0000\u01cc\u0a95\u0001\u0000\u0000\u0000\u01ce"+
		"\u0a97\u0001\u0000\u0000\u0000\u01d0\u0a99\u0001\u0000\u0000\u0000\u01d2"+
		"\u0a9d\u0001\u0000\u0000\u0000\u01d4\u0a9f\u0001\u0000\u0000\u0000\u01d6"+
		"\u0aa1\u0001\u0000\u0000\u0000\u01d8\u0aa5\u0001\u0000\u0000\u0000\u01da"+
		"\u0aa9\u0001\u0000\u0000\u0000\u01dc\u0aab\u0001\u0000\u0000\u0000\u01de"+
		"\u0ac4\u0001\u0000\u0000\u0000\u01e0\u0ac7\u0001\u0000\u0000\u0000\u01e2"+
		"\u0ad0\u0001\u0000\u0000\u0000\u01e4\u0ade\u0001\u0000\u0000\u0000\u01e6"+
		"\u0aeb\u0001\u0000\u0000\u0000\u01e8\u0af1\u0001\u0000\u0000\u0000\u01ea"+
		"\u0afc\u0001\u0000\u0000\u0000\u01ec\u0b0e\u0001\u0000\u0000\u0000\u01ee"+
		"\u0b1c\u0001\u0000\u0000\u0000\u01f0\u0b29\u0001\u0000\u0000\u0000\u01f2"+
		"\u0b2f\u0001\u0000\u0000\u0000\u01f4\u0b3a\u0001\u0000\u0000\u0000\u01f6"+
		"\u0b49\u0001\u0000\u0000\u0000\u01f8\u0b4e\u0001\u0000\u0000\u0000\u01fa"+
		"\u0b54\u0001\u0000\u0000\u0000\u01fc\u0b75\u0001\u0000\u0000\u0000\u01fe"+
		"\u0b77\u0001\u0000\u0000\u0000\u0200\u0b7c\u0001\u0000\u0000\u0000\u0202"+
		"\u0b82\u0001\u0000\u0000\u0000\u0204\u0b89\u0001\u0000\u0000\u0000\u0206"+
		"\u0b8f\u0001\u0000\u0000\u0000\u0208\u0b91\u0001\u0000\u0000\u0000\u020a"+
		"\u0b95\u0001\u0000\u0000\u0000\u020c\u0b97\u0001\u0000\u0000\u0000\u020e"+
		"\u0b9a\u0001\u0000\u0000\u0000\u0210\u0b9d\u0001\u0000\u0000\u0000\u0212"+
		"\u0ba7\u0001\u0000\u0000\u0000\u0214\u0bab\u0001\u0000\u0000\u0000\u0216"+
		"\u0bb0\u0001\u0000\u0000\u0000\u0218\u0bb3\u0001\u0000\u0000\u0000\u021a"+
		"\u0bda\u0001\u0000\u0000\u0000\u021c\u0bdd\u0001\u0000\u0000\u0000\u021e"+
		"\u0bea\u0001\u0000\u0000\u0000\u0220\u0bed\u0001\u0000\u0000\u0000\u0222"+
		"\u0bf2\u0001\u0000\u0000\u0000\u0224\u0bf8\u0001\u0000\u0000\u0000\u0226"+
		"\u0bfd\u0001\u0000\u0000\u0000\u0228\u0c04\u0001\u0000\u0000\u0000\u022a"+
		"\u0c10\u0001\u0000\u0000\u0000\u022c\u0c17\u0001\u0000\u0000\u0000\u022e"+
		"\u0c19\u0001\u0000\u0000\u0000\u0230\u0c21\u0001\u0000\u0000\u0000\u0232"+
		"\u0c26\u0001\u0000\u0000\u0000\u0234\u0c2b\u0001\u0000\u0000\u0000\u0236"+
		"\u0c2e\u0001\u0000\u0000\u0000\u0238\u0c31\u0001\u0000\u0000\u0000\u023a"+
		"\u0c39\u0001\u0000\u0000\u0000\u023c\u0c3c\u0001\u0000\u0000\u0000\u023e"+
		"\u0c44\u0001\u0000\u0000\u0000\u0240\u0c48\u0001\u0000\u0000\u0000\u0242"+
		"\u0c4a\u0001\u0000\u0000\u0000\u0244\u0c4f\u0001\u0000\u0000\u0000\u0246"+
		"\u0c5a\u0001\u0000\u0000\u0000\u0248\u0c5c\u0001\u0000\u0000\u0000\u024a"+
		"\u0c60\u0001\u0000\u0000\u0000\u024c\u0c62\u0001\u0000\u0000\u0000\u024e"+
		"\u0c67\u0001\u0000\u0000\u0000\u0250\u0c6b\u0001\u0000\u0000\u0000\u0252"+
		"\u0c74\u0001\u0000\u0000\u0000\u0254\u0c76\u0001\u0000\u0000\u0000\u0256"+
		"\u0c82\u0001\u0000\u0000\u0000\u0258\u0c8e\u0001\u0000\u0000\u0000\u025a"+
		"\u0c90\u0001\u0000\u0000\u0000\u025c\u0c96\u0001\u0000\u0000\u0000\u025e"+
		"\u0ca0\u0001\u0000\u0000\u0000\u0260\u0ca6\u0001\u0000\u0000\u0000\u0262"+
		"\u0cb0\u0001\u0000\u0000\u0000\u0264\u0cc4\u0001\u0000\u0000\u0000\u0266"+
		"\u0cd4\u0001\u0000\u0000\u0000\u0268\u0ce2\u0001\u0000\u0000\u0000\u026a"+
		"\u0ce9\u0001\u0000\u0000\u0000\u026c\u0ced\u0001\u0000\u0000\u0000\u026e"+
		"\u0cef\u0001\u0000\u0000\u0000\u0270\u0cf4\u0001\u0000\u0000\u0000\u0272"+
		"\u0d00\u0001\u0000\u0000\u0000\u0274\u0d02\u0001\u0000\u0000\u0000\u0276"+
		"\u0d04\u0001\u0000\u0000\u0000\u0278\u0d0b\u0001\u0000\u0000\u0000\u027a"+
		"\u0d17\u0001\u0000\u0000\u0000\u027c\u0d24\u0001\u0000\u0000\u0000\u027e"+
		"\u0d32\u0001\u0000\u0000\u0000\u0280\u0d3c\u0001\u0000\u0000\u0000\u0282"+
		"\u0d41\u0001\u0000\u0000\u0000\u0284\u0d4b\u0001\u0000\u0000\u0000\u0286"+
		"\u0d4f\u0001\u0000\u0000\u0000\u0288\u0d59\u0001\u0000\u0000\u0000\u028a"+
		"\u0d5e\u0001\u0000\u0000\u0000\u028c\u0d62\u0001\u0000\u0000\u0000\u028e"+
		"\u0d6a\u0001\u0000\u0000\u0000\u0290\u0d6d\u0001\u0000\u0000\u0000\u0292"+
		"\u0d6f\u0001\u0000\u0000\u0000\u0294\u0d71\u0001\u0000\u0000\u0000\u0296"+
		"\u0d73\u0001\u0000\u0000\u0000\u0298\u0d7e\u0001\u0000\u0000\u0000\u029a"+
		"\u0d80\u0001\u0000\u0000\u0000\u029c\u0d89\u0001\u0000\u0000\u0000\u029e"+
		"\u0d8b\u0001\u0000\u0000\u0000\u02a0\u0d8d\u0001\u0000\u0000\u0000\u02a2"+
		"\u0d8f\u0001\u0000\u0000\u0000\u02a4\u0d93\u0001\u0000\u0000\u0000\u02a6"+
		"\u0d95\u0001\u0000\u0000\u0000\u02a8\u0d99\u0001\u0000\u0000\u0000\u02aa"+
		"\u0db3\u0001\u0000\u0000\u0000\u02ac\u0dba\u0001\u0000\u0000\u0000\u02ae"+
		"\u0dbc\u0001\u0000\u0000\u0000\u02b0\u0dc4\u0001\u0000\u0000\u0000\u02b2"+
		"\u0dcd\u0001\u0000\u0000\u0000\u02b4\u0dd5\u0001\u0000\u0000\u0000\u02b6"+
		"\u0dd7\u0001\u0000\u0000\u0000\u02b8\u0dd9\u0001\u0000\u0000\u0000\u02ba"+
		"\u0de1\u0001\u0000\u0000\u0000\u02bc\u0de6\u0001\u0000\u0000\u0000\u02be"+
		"\u0deb\u0001\u0000\u0000\u0000\u02c0\u0ded\u0001\u0000\u0000\u0000\u02c2"+
		"\u0def\u0001\u0000\u0000\u0000\u02c4\u0df1\u0001\u0000\u0000\u0000\u02c6"+
		"\u0df8\u0001\u0000\u0000\u0000\u02c8\u0dfc\u0001\u0000\u0000\u0000\u02ca"+
		"\u0e0a\u0001\u0000\u0000\u0000\u02cc\u0e0c\u0001\u0000\u0000\u0000\u02ce"+
		"\u0e14\u0001\u0000\u0000\u0000\u02d0\u0e1c\u0001\u0000\u0000\u0000\u02d2"+
		"\u0e23\u0001\u0000\u0000\u0000\u02d4\u0e2b\u0001\u0000\u0000\u0000\u02d6"+
		"\u0e32\u0001\u0000\u0000\u0000\u02d8\u0e34\u0001\u0000\u0000\u0000\u02da"+
		"\u0e3b\u0001\u0000\u0000\u0000\u02dc\u0e3d\u0001\u0000\u0000\u0000\u02de"+
		"\u0e74\u0001\u0000\u0000\u0000\u02e0\u0e76\u0001\u0000\u0000\u0000\u02e2"+
		"\u0e81\u0001\u0000\u0000\u0000\u02e4\u0e9d\u0001\u0000\u0000\u0000\u02e6"+
		"\u0eb4\u0001\u0000\u0000\u0000\u02e8\u0ec3\u0001\u0000\u0000\u0000\u02ea"+
		"\u0ec9\u0001\u0000\u0000\u0000\u02ec\u0ed6\u0001\u0000\u0000\u0000\u02ee"+
		"\u0ee7\u0001\u0000\u0000\u0000\u02f0\u0ee9\u0001\u0000\u0000\u0000\u02f2"+
		"\u0ef3\u0001\u0000\u0000\u0000\u02f4\u0ef5\u0001\u0000\u0000\u0000\u02f6"+
		"\u0efb\u0001\u0000\u0000\u0000\u02f8\u0f38\u0001\u0000\u0000\u0000\u02fa"+
		"\u0f4f\u0001\u0000\u0000\u0000\u02fc\u0f51\u0001\u0000\u0000\u0000\u02fe"+
		"\u0f54\u0001\u0000\u0000\u0000\u0300\u0304\u0003\u0004\u0002\u0000\u0301"+
		"\u0303\u0003\u0004\u0002\u0000\u0302\u0301\u0001\u0000\u0000\u0000\u0303"+
		"\u0306\u0001\u0000\u0000\u0000\u0304\u0302\u0001\u0000\u0000\u0000\u0304"+
		"\u0305\u0001\u0000\u0000\u0000\u0305\u0307\u0001\u0000\u0000\u0000\u0306"+
		"\u0304\u0001\u0000\u0000\u0000\u0307\u0308\u0005\u0000\u0000\u0001\u0308"+
		"\u0001\u0001\u0000\u0000\u0000\u0309\u030b\u0003\u0006\u0003\u0000\u030a"+
		"\u0309\u0001\u0000\u0000\u0000\u030a\u030b\u0001\u0000\u0000\u0000\u030b"+
		"\u030c\u0001\u0000\u0000\u0000\u030c\u030e\u0003\b\u0004\u0000\u030d\u030f"+
		"\u0005\u00f0\u0000\u0000\u030e\u030d\u0001\u0000\u0000\u0000\u030e\u030f"+
		"\u0001\u0000\u0000\u0000\u030f\u0310\u0001\u0000\u0000\u0000\u0310\u0311"+
		"\u0005\u0000\u0000\u0001\u0311\u0003\u0001\u0000\u0000\u0000\u0312\u0314"+
		"\u0003\u0006\u0003\u0000\u0313\u0312\u0001\u0000\u0000\u0000\u0313\u0314"+
		"\u0001\u0000\u0000\u0000\u0314\u0315\u0001\u0000\u0000\u0000\u0315\u0317"+
		"\u0003\b\u0004\u0000\u0316\u0318\u0005\u00f0\u0000\u0000\u0317\u0316\u0001"+
		"\u0000\u0000\u0000\u0317\u0318\u0001\u0000\u0000\u0000\u0318\u0005\u0001"+
		"\u0000\u0000\u0000\u0319\u031a\u0005o\u0000\u0000\u031a\u0007\u0001\u0000"+
		"\u0000\u0000\u031b\u0323\u0003\n\u0005\u0000\u031c\u0323\u0003\f\u0006"+
		"\u0000\u031d\u0323\u0003\u000e\u0007\u0000\u031e\u0323\u0003\u0010\b\u0000"+
		"\u031f\u0323\u0003\u0012\t\u0000\u0320\u0323\u0003\u02fc\u017e\u0000\u0321"+
		"\u0323\u0003\u02fe\u017f\u0000\u0322\u031b\u0001\u0000\u0000\u0000\u0322"+
		"\u031c\u0001\u0000\u0000\u0000\u0322\u031d\u0001\u0000\u0000\u0000\u0322"+
		"\u031e\u0001\u0000\u0000\u0000\u0322\u031f\u0001\u0000\u0000\u0000\u0322"+
		"\u0320\u0001\u0000\u0000\u0000\u0322\u0321\u0001\u0000\u0000\u0000\u0323"+
		"\t\u0001\u0000\u0000\u0000\u0324\u0325\u0005\u00a9\u0000\u0000\u0325\u0326"+
		"\u0005T\u0000\u0000\u0326\u0343\u0003\u010e\u0087\u0000\u0327\u0328\u0005"+
		"\u00a9\u0000\u0000\u0328\u0329\u0005\u00de\u0000\u0000\u0329\u032b\u0005"+
		"\u00c0\u0000\u0000\u032a\u032c\u0007\u0000\u0000\u0000\u032b\u032a\u0001"+
		"\u0000\u0000\u0000\u032b\u032c\u0001\u0000\u0000\u0000\u032c\u0330\u0001"+
		"\u0000\u0000\u0000\u032d\u0331\u0005\u016d\u0000\u0000\u032e\u0331\u0003"+
		"\u014a\u00a5\u0000\u032f\u0331\u0005c\u0000\u0000\u0330\u032d\u0001\u0000"+
		"\u0000\u0000\u0330\u032e\u0001\u0000\u0000\u0000\u0330\u032f\u0001\u0000"+
		"\u0000\u0000\u0331\u0343\u0001\u0000\u0000\u0000\u0332\u0334\u0005\u00a9"+
		"\u0000\u0000\u0333\u0335\u0005\u00a8\u0000\u0000\u0334\u0333\u0001\u0000"+
		"\u0000\u0000\u0334\u0335\u0001\u0000\u0000\u0000\u0335\u0336\u0001\u0000"+
		"\u0000\u0000\u0336\u0338\u0003\u010e\u0087\u0000\u0337\u0339\u0007\u0000"+
		"\u0000\u0000\u0338\u0337\u0001\u0000\u0000\u0000\u0338\u0339\u0001\u0000"+
		"\u0000\u0000\u0339\u033e\u0001\u0000\u0000\u0000\u033a\u033f\u0005\u016d"+
		"\u0000\u0000\u033b\u033f\u0003\u014a\u00a5\u0000\u033c\u033f\u0003\u011e"+
		"\u008f\u0000\u033d\u033f\u0005c\u0000\u0000\u033e\u033a\u0001\u0000\u0000"+
		"\u0000\u033e\u033b\u0001\u0000\u0000\u0000\u033e\u033c\u0001\u0000\u0000"+
		"\u0000\u033e\u033d\u0001\u0000\u0000\u0000\u033f\u0343\u0001\u0000\u0000"+
		"\u0000\u0340\u0341\u0005\u00a1\u0000\u0000\u0341\u0343\u0003\u010e\u0087"+
		"\u0000\u0342\u0324\u0001\u0000\u0000\u0000\u0342\u0327\u0001\u0000\u0000"+
		"\u0000\u0342\u0332\u0001\u0000\u0000\u0000\u0342\u0340\u0001\u0000\u0000"+
		"\u0000\u0343\u000b\u0001\u0000\u0000\u0000\u0344\u0345\u0003\u027c\u013e"+
		"\u0000\u0345\r\u0001\u0000\u0000\u0000\u0346\u0349\u0003\u02de\u016f\u0000"+
		"\u0347\u0349\u0003\u02e6\u0173\u0000\u0348\u0346\u0001\u0000\u0000\u0000"+
		"\u0348\u0347\u0001\u0000\u0000\u0000\u0349\u000f\u0001\u0000\u0000\u0000"+
		"\u034a\u0368\u0003\u0014\n\u0000\u034b\u0368\u0003\u0018\f\u0000\u034c"+
		"\u0368\u00038\u001c\u0000\u034d\u0368\u0003\u0104\u0082\u0000\u034e\u0368"+
		"\u0003\u02e8\u0174\u0000\u034f\u0368\u0003\u02f8\u017c\u0000\u0350\u0368"+
		"\u0003\u00fa}\u0000\u0351\u0368\u0003\u02fa\u017d\u0000\u0352\u0368\u0003"+
		"P(\u0000\u0353\u0368\u0003R)\u0000\u0354\u0368\u0003d2\u0000\u0355\u0368"+
		"\u0003f3\u0000\u0356\u0368\u0003\u0106\u0083\u0000\u0357\u0368\u0003\u0100"+
		"\u0080\u0000\u0358\u0368\u0003\u0108\u0084\u0000\u0359\u0368\u0003\u0102"+
		"\u0081\u0000\u035a\u0368\u0003\u010a\u0085\u0000\u035b\u0368\u0003B!\u0000"+
		"\u035c\u0368\u0003F#\u0000\u035d\u0368\u0003:\u001d\u0000\u035e\u0368"+
		"\u0003>\u001f\u0000\u035f\u0368\u0003<\u001e\u0000\u0360\u0368\u0003D"+
		"\"\u0000\u0361\u0368\u0003@ \u0000\u0362\u0368\u0003H$\u0000\u0363\u0368"+
		"\u0003h4\u0000\u0364\u0368\u0003j5\u0000\u0365\u0368\u0003v;\u0000\u0366"+
		"\u0368\u0003l6\u0000\u0367\u034a\u0001\u0000\u0000\u0000\u0367\u034b\u0001"+
		"\u0000\u0000\u0000\u0367\u034c\u0001\u0000\u0000\u0000\u0367\u034d\u0001"+
		"\u0000\u0000\u0000\u0367\u034e\u0001\u0000\u0000\u0000\u0367\u034f\u0001"+
		"\u0000\u0000\u0000\u0367\u0350\u0001\u0000\u0000\u0000\u0367\u0351\u0001"+
		"\u0000\u0000\u0000\u0367\u0352\u0001\u0000\u0000\u0000\u0367\u0353\u0001"+
		"\u0000\u0000\u0000\u0367\u0354\u0001\u0000\u0000\u0000\u0367\u0355\u0001"+
		"\u0000\u0000\u0000\u0367\u0356\u0001\u0000\u0000\u0000\u0367\u0357\u0001"+
		"\u0000\u0000\u0000\u0367\u0358\u0001\u0000\u0000\u0000\u0367\u0359\u0001"+
		"\u0000\u0000\u0000\u0367\u035a\u0001\u0000\u0000\u0000\u0367\u035b\u0001"+
		"\u0000\u0000\u0000\u0367\u035c\u0001\u0000\u0000\u0000\u0367\u035d\u0001"+
		"\u0000\u0000\u0000\u0367\u035e\u0001\u0000\u0000\u0000\u0367\u035f\u0001"+
		"\u0000\u0000\u0000\u0367\u0360\u0001\u0000\u0000\u0000\u0367\u0361\u0001"+
		"\u0000\u0000\u0000\u0367\u0362\u0001\u0000\u0000\u0000\u0367\u0363\u0001"+
		"\u0000\u0000\u0000\u0367\u0364\u0001\u0000\u0000\u0000\u0367\u0365\u0001"+
		"\u0000\u0000\u0000\u0367\u0366\u0001\u0000\u0000\u0000\u0368\u0011\u0001"+
		"\u0000\u0000\u0000\u0369\u036b\u0005\n\u0000\u0000\u036a\u036c\u0005<"+
		"\u0000\u0000\u036b\u036a\u0001\u0000\u0000\u0000\u036b\u036c\u0001\u0000"+
		"\u0000\u0000\u036c\u036d\u0001\u0000\u0000\u0000\u036d\u036e\u0005}\u0000"+
		"\u0000\u036e\u036f\u0003\u010e\u0087\u0000\u036f\u0370\u0005)\u0000\u0000"+
		"\u0370\u0372\u0003\u0272\u0139\u0000\u0371\u0373\u0003\u00dam\u0000\u0372"+
		"\u0371\u0001\u0000\u0000\u0000\u0372\u0373\u0001\u0000\u0000\u0000\u0373"+
		"\u0374\u0001\u0000\u0000\u0000\u0374\u0375\u0005\u00f8\u0000\u0000\u0375"+
		"\u0376\u0003\u02d2\u0169\u0000\u0376\u0378\u0005\u00f9\u0000\u0000\u0377"+
		"\u0379\u0003\u0090H\u0000\u0378\u0377\u0001\u0000\u0000\u0000\u0378\u0379"+
		"\u0001\u0000\u0000\u0000\u0379\u0013\u0001\u0000\u0000\u0000\u037a\u037b"+
		"\u0005\n\u0000\u0000\u037b\u037d\u0005d\u0000\u0000\u037c\u037e\u0003"+
		"\u0016\u000b\u0000\u037d\u037c\u0001\u0000\u0000\u0000\u037d\u037e\u0001"+
		"\u0000\u0000\u0000\u037e\u037f\u0001\u0000\u0000\u0000\u037f\u0380\u0003"+
		"\u010e\u0087\u0000\u0380\u0015\u0001\u0000\u0000\u0000\u0381\u0382\u0005"+
		"|\u0000\u0000\u0382\u0383\u0005\'\u0000\u0000\u0383\u0384\u0005n\u0000"+
		"\u0000\u0384\u0017\u0001\u0000\u0000\u0000\u0385\u0386\u0005j\u0000\u0000"+
		"\u0386\u0388\u0005d\u0000\u0000\u0387\u0389\u0003\u001a\r\u0000\u0388"+
		"\u0387\u0001\u0000\u0000\u0000\u0388\u0389\u0001\u0000\u0000\u0000\u0389"+
		"\u038a\u0001\u0000\u0000\u0000\u038a\u038b\u0003\u010e\u0087\u0000\u038b"+
		"\u0019\u0001\u0000\u0000\u0000\u038c\u038d\u0005|\u0000\u0000\u038d\u038e"+
		"\u0005n\u0000\u0000\u038e\u001b\u0001\u0000\u0000\u0000\u038f\u0390\u0005"+
		"\u014e\u0000\u0000\u0390\u001d\u0001\u0000\u0000\u0000\u0391\u039b\u0005"+
		"\u0114\u0000\u0000\u0392\u0393\u0005\u0122\u0000\u0000\u0393\u0394\u0005"+
		"\u0123\u0000\u0000\u0394\u0395\u0005R\u0000\u0000\u0395\u0399\u0005\u016d"+
		"\u0000\u0000\u0396\u0397\u0005\u0124\u0000\u0000\u0397\u0398\u0005R\u0000"+
		"\u0000\u0398\u039a\u0005\u016d\u0000\u0000\u0399\u0396\u0001\u0000\u0000"+
		"\u0000\u0399\u039a\u0001\u0000\u0000\u0000\u039a\u039c\u0001\u0000\u0000"+
		"\u0000\u039b\u0392\u0001\u0000\u0000\u0000\u039b\u039c\u0001\u0000\u0000"+
		"\u0000\u039c\u03a5\u0001\u0000\u0000\u0000\u039d\u039e\u0005\u0126\u0000"+
		"\u0000\u039e\u03a2\u0005\u016d\u0000\u0000\u039f\u03a0\u0005@\u0000\u0000"+
		"\u03a0\u03a1\u0005\u0127\u0000\u0000\u03a1\u03a3\u0003\u0090H\u0000\u03a2"+
		"\u039f\u0001\u0000\u0000\u0000\u03a2\u03a3\u0001\u0000\u0000\u0000\u03a3"+
		"\u03a5\u0001\u0000\u0000\u0000\u03a4\u0391\u0001\u0000\u0000\u0000\u03a4"+
		"\u039d\u0001\u0000\u0000\u0000\u03a5\u001f\u0001\u0000\u0000\u0000\u03a6"+
		"\u03b1\u0005\u0121\u0000\u0000\u03a7\u03b1\u0005\u0128\u0000\u0000\u03a8"+
		"\u03b1\u0005\u0129\u0000\u0000\u03a9\u03b1\u0005\u012a\u0000\u0000\u03aa"+
		"\u03b1\u0005\u012b\u0000\u0000\u03ab\u03b1\u0005\u012c\u0000\u0000\u03ac"+
		"\u03ad\u0005\u012d\u0000\u0000\u03ad\u03ae\u0005\u016d\u0000\u0000\u03ae"+
		"\u03af\u0005\u012e\u0000\u0000\u03af\u03b1\u0005\u016d\u0000\u0000\u03b0"+
		"\u03a6\u0001\u0000\u0000\u0000\u03b0\u03a7\u0001\u0000\u0000\u0000\u03b0"+
		"\u03a8\u0001\u0000\u0000\u0000\u03b0\u03a9\u0001\u0000\u0000\u0000\u03b0"+
		"\u03aa\u0001\u0000\u0000\u0000\u03b0\u03ab\u0001\u0000\u0000\u0000\u03b0"+
		"\u03ac\u0001\u0000\u0000\u0000\u03b1!\u0001\u0000\u0000\u0000\u03b2\u03b3"+
		"\u0005\u010b\u0000\u0000\u03b3\u03b4\u0005\u016b\u0000\u0000\u03b4#\u0001"+
		"\u0000\u0000\u0000\u03b5\u03b8\u0005\u010c\u0000\u0000\u03b6\u03b9\u0005"+
		"\u016d\u0000\u0000\u03b7\u03b9\u0003\u01ce\u00e7\u0000\u03b8\u03b6\u0001"+
		"\u0000\u0000\u0000\u03b8\u03b7\u0001\u0000\u0000\u0000\u03b9%\u0001\u0000"+
		"\u0000\u0000\u03ba\u03bb\u0005J\u0000\u0000\u03bb\u03bc\u0005\u016d\u0000"+
		"\u0000\u03bc\'\u0001\u0000\u0000\u0000\u03bd\u03be\u0005w\u0000\u0000"+
		"\u03be\u03bf\u0007\u0001\u0000\u0000\u03bf)\u0001\u0000\u0000\u0000\u03c0"+
		"\u03c1\u0005\u010e\u0000\u0000\u03c1\u03c2\u0005\u0106\u0000\u0000\u03c2"+
		"+\u0001\u0000\u0000\u0000\u03c3\u03c4\u0005\u010f\u0000\u0000\u03c4\u03c5"+
		"\u0005\u016d\u0000\u0000\u03c5-\u0001\u0000\u0000\u0000\u03c6\u03c7\u0005"+
		"\u0110\u0000\u0000\u03c7\u03c8\u0005\u016d\u0000\u0000\u03c8/\u0001\u0000"+
		"\u0000\u0000\u03c9\u03ca\u0005\u0111\u0000\u0000\u03ca\u03cb\u0005\u016d"+
		"\u0000\u0000\u03cb1\u0001\u0000\u0000\u0000\u03cc\u03cd\u0005\u0112\u0000"+
		"\u0000\u03cd\u03ce\u0005\u016d\u0000\u0000\u03ce3\u0001\u0000\u0000\u0000"+
		"\u03cf\u03d0\u0005\u0139\u0000\u0000\u03d0\u03d1\u0005\u016d\u0000\u0000"+
		"\u03d15\u0001\u0000\u0000\u0000\u03d2\u03e6\u0005\u010d\u0000\u0000\u03d3"+
		"\u03d4\u0005\u00f8\u0000\u0000\u03d4\u03d6\u0003(\u0014\u0000\u03d5\u03d7"+
		"\u0003*\u0015\u0000\u03d6\u03d5\u0001\u0000\u0000\u0000\u03d6\u03d7\u0001"+
		"\u0000\u0000\u0000\u03d7\u03d9\u0001\u0000\u0000\u0000\u03d8\u03da\u0003"+
		",\u0016\u0000\u03d9\u03d8\u0001\u0000\u0000\u0000\u03d9\u03da\u0001\u0000"+
		"\u0000\u0000\u03da\u03dc\u0001\u0000\u0000\u0000\u03db\u03dd\u0003.\u0017"+
		"\u0000\u03dc\u03db\u0001\u0000\u0000\u0000\u03dc\u03dd\u0001\u0000\u0000"+
		"\u0000\u03dd\u03df\u0001\u0000\u0000\u0000\u03de\u03e0\u00030\u0018\u0000"+
		"\u03df\u03de\u0001\u0000\u0000\u0000\u03df\u03e0\u0001\u0000\u0000\u0000"+
		"\u03e0\u03e2\u0001\u0000\u0000\u0000\u03e1\u03e3\u00032\u0019\u0000\u03e2"+
		"\u03e1\u0001\u0000\u0000\u0000\u03e2\u03e3\u0001\u0000\u0000\u0000\u03e3"+
		"\u03e4\u0001\u0000\u0000\u0000\u03e4\u03e5\u0005\u00f9\u0000\u0000\u03e5"+
		"\u03e7\u0001\u0000\u0000\u0000\u03e6\u03d3\u0001\u0000\u0000\u0000\u03e6"+
		"\u03e7\u0001\u0000\u0000\u0000\u03e77\u0001\u0000\u0000\u0000\u03e8\u03ea"+
		"\u0003\u00fe\u007f\u0000\u03e9\u03e8\u0001\u0000\u0000\u0000\u03ea\u03ed"+
		"\u0001\u0000\u0000\u0000\u03eb\u03e9\u0001\u0000\u0000\u0000\u03eb\u03ec"+
		"\u0001\u0000\u0000\u0000\u03ec\u03ee\u0001\u0000\u0000\u0000\u03ed\u03eb"+
		"\u0001\u0000\u0000\u0000\u03ee\u03f0\u0005\n\u0000\u0000\u03ef\u03f1\u0003"+
		"\u001c\u000e\u0000\u03f0\u03ef\u0001\u0000\u0000\u0000\u03f0\u03f1\u0001"+
		"\u0000\u0000\u0000\u03f1\u03f3\u0001\u0000\u0000\u0000\u03f2\u03f4\u0005"+
		"\u012f\u0000\u0000\u03f3\u03f2\u0001\u0000\u0000\u0000\u03f3\u03f4\u0001"+
		"\u0000\u0000\u0000\u03f4\u03f6\u0001\u0000\u0000\u0000\u03f5\u03f7\u0005"+
		"p\u0000\u0000\u03f6\u03f5\u0001\u0000\u0000\u0000\u03f6\u03f7\u0001\u0000"+
		"\u0000\u0000\u03f7\u03f8\u0001\u0000\u0000\u0000\u03f8\u03fa\u0007\u0002"+
		"\u0000\u0000\u03f9\u03fb\u0003\u0016\u000b\u0000\u03fa\u03f9\u0001\u0000"+
		"\u0000\u0000\u03fa\u03fb\u0001\u0000\u0000\u0000\u03fb\u03fc\u0001\u0000"+
		"\u0000\u0000\u03fc\u03fe\u0003\u0272\u0139\u0000\u03fd\u03ff\u0003\"\u0011"+
		"\u0000\u03fe\u03fd\u0001\u0000\u0000\u0000\u03fe\u03ff\u0001\u0000\u0000"+
		"\u0000\u03ff\u0401\u0001\u0000\u0000\u0000\u0400\u0402\u0003$\u0012\u0000"+
		"\u0401\u0400\u0001\u0000\u0000\u0000\u0401\u0402\u0001\u0000\u0000\u0000"+
		"\u0402\u0404\u0001\u0000\u0000\u0000\u0403\u0405\u00034\u001a\u0000\u0404"+
		"\u0403\u0001\u0000\u0000\u0000\u0404\u0405\u0001\u0000\u0000\u0000\u0405"+
		"\u0407\u0001\u0000\u0000\u0000\u0406\u0408\u0003&\u0013\u0000\u0407\u0406"+
		"\u0001\u0000\u0000\u0000\u0407\u0408\u0001\u0000\u0000\u0000\u0408\u0409"+
		"\u0001\u0000\u0000\u0000\u0409\u040c\u0003x<\u0000\u040a\u040b\u0005\u0132"+
		"\u0000\u0000\u040b\u040d\u0003\u001e\u000f\u0000\u040c\u040a\u0001\u0000"+
		"\u0000\u0000\u040c\u040d\u0001\u0000\u0000\u0000\u040d\u0410\u0001\u0000"+
		"\u0000\u0000\u040e\u040f\u0005\u0130\u0000\u0000\u040f\u0411\u0003 \u0010"+
		"\u0000\u0410\u040e\u0001\u0000\u0000\u0000\u0410\u0411\u0001\u0000\u0000"+
		"\u0000\u0411\u0414\u0001\u0000\u0000\u0000\u0412\u0413\u0005\u0088\u0000"+
		"\u0000\u0413\u0415\u0005\u016d\u0000\u0000\u0414\u0412\u0001\u0000\u0000"+
		"\u0000\u0414\u0415\u0001\u0000\u0000\u0000\u0415\u0418\u0001\u0000\u0000"+
		"\u0000\u0416\u0417\u0005\u0131\u0000\u0000\u0417\u0419\u0003\u0090H\u0000"+
		"\u0418\u0416\u0001\u0000\u0000\u0000\u0418\u0419\u0001\u0000\u0000\u0000"+
		"\u0419\u0463\u0001\u0000\u0000\u0000\u041a\u041c\u0003\u00fe\u007f\u0000"+
		"\u041b\u041a\u0001\u0000\u0000\u0000\u041c\u041f\u0001\u0000\u0000\u0000"+
		"\u041d\u041b\u0001\u0000\u0000\u0000\u041d\u041e\u0001\u0000\u0000\u0000"+
		"\u041e\u0420\u0001\u0000\u0000\u0000\u041f\u041d\u0001\u0000\u0000\u0000"+
		"\u0420\u0422\u0005\n\u0000\u0000\u0421\u0423\u0003\u001c\u000e\u0000\u0422"+
		"\u0421\u0001\u0000\u0000\u0000\u0422\u0423\u0001\u0000\u0000\u0000\u0423"+
		"\u0424\u0001\u0000\u0000\u0000\u0424\u0426\u0007\u0002\u0000\u0000\u0425"+
		"\u0427\u0003\u0016\u000b\u0000\u0426\u0425\u0001\u0000\u0000\u0000\u0426"+
		"\u0427\u0001\u0000\u0000\u0000\u0427\u0428\u0001\u0000\u0000\u0000\u0428"+
		"\u042a\u0003\u0272\u0139\u0000\u0429\u042b\u0003\"\u0011\u0000\u042a\u0429"+
		"\u0001\u0000\u0000\u0000\u042a\u042b\u0001\u0000\u0000\u0000\u042b\u042d"+
		"\u0001\u0000\u0000\u0000\u042c\u042e\u0003$\u0012\u0000\u042d\u042c\u0001"+
		"\u0000\u0000\u0000\u042d\u042e\u0001\u0000\u0000\u0000\u042e\u042f\u0001"+
		"\u0000\u0000\u0000\u042f\u0431\u0003x<\u0000\u0430\u0432\u00036\u001b"+
		"\u0000\u0431\u0430\u0001\u0000\u0000\u0000\u0431\u0432\u0001\u0000\u0000"+
		"\u0000\u0432\u0434\u0001\u0000\u0000\u0000\u0433\u0435\u0003\u0090H\u0000"+
		"\u0434\u0433\u0001\u0000\u0000\u0000\u0434\u0435\u0001\u0000\u0000\u0000"+
		"\u0435\u0437\u0001\u0000\u0000\u0000\u0436\u0438\u0003\u00e0p\u0000\u0437"+
		"\u0436\u0001\u0000\u0000\u0000\u0437\u0438\u0001\u0000\u0000\u0000\u0438"+
		"\u043b\u0001\u0000\u0000\u0000\u0439\u043a\u0005\u0001\u0000\u0000\u043a"+
		"\u043c\u0003\u025e\u012f\u0000\u043b\u0439\u0001\u0000\u0000\u0000\u043b"+
		"\u043c\u0001\u0000\u0000\u0000\u043c\u0463\u0001\u0000\u0000\u0000\u043d"+
		"\u043e\u0005\n\u0000\u0000\u043e\u0440\u00057\u0000\u0000\u043f\u0441"+
		"\u0003\u0016\u000b\u0000\u0440\u043f\u0001\u0000\u0000\u0000\u0440\u0441"+
		"\u0001\u0000\u0000\u0000\u0441\u0442\u0001\u0000\u0000\u0000\u0442\u0445"+
		"\u0003\u0272\u0139\u0000\u0443\u0444\u0005=\u0000\u0000\u0444\u0446\u0003"+
		"\u010e\u0087\u0000\u0445\u0443\u0001\u0000\u0000\u0000\u0445\u0446\u0001"+
		"\u0000\u0000\u0000\u0446\u0448\u0001\u0000\u0000\u0000\u0447\u0449\u0003"+
		"\u0090H\u0000\u0448\u0447\u0001\u0000\u0000\u0000\u0448\u0449\u0001\u0000"+
		"\u0000\u0000\u0449\u044b\u0001\u0000\u0000\u0000\u044a\u044c\u0003\u00e0"+
		"p\u0000\u044b\u044a\u0001\u0000\u0000\u0000\u044b\u044c\u0001\u0000\u0000"+
		"\u0000\u044c\u044d\u0001\u0000\u0000\u0000\u044d\u044e\u0005\u0001\u0000"+
		"\u0000\u044e\u044f\u0003\u025e\u012f\u0000\u044f\u0463\u0001\u0000\u0000"+
		"\u0000\u0450\u0451\u0005\n\u0000\u0000\u0451\u0453\u00057\u0000\u0000"+
		"\u0452\u0454\u0003\u0016\u000b\u0000\u0453\u0452\u0001\u0000\u0000\u0000"+
		"\u0453\u0454\u0001\u0000\u0000\u0000\u0454\u0455\u0001\u0000\u0000\u0000"+
		"\u0455\u0456\u0003\u0272\u0139\u0000\u0456\u0457\u0005#\u0000\u0000\u0457"+
		"\u0458\u0003\u0272\u0139\u0000\u0458\u0463\u0001\u0000\u0000\u0000\u0459"+
		"\u045a\u0005\n\u0000\u0000\u045a\u045c\u00057\u0000\u0000\u045b\u045d"+
		"\u0003\u0016\u000b\u0000\u045c\u045b\u0001\u0000\u0000\u0000\u045c\u045d"+
		"\u0001\u0000\u0000\u0000\u045d\u045e\u0001\u0000\u0000\u0000\u045e\u045f"+
		"\u0003\u0272\u0139\u0000\u045f\u0460\u0005\u0001\u0000\u0000\u0460\u0461"+
		"\u0003\u02de\u016f\u0000\u0461\u0463\u0001\u0000\u0000\u0000\u0462\u03eb"+
		"\u0001\u0000\u0000\u0000\u0462\u041d\u0001\u0000\u0000\u0000\u0462\u043d"+
		"\u0001\u0000\u0000\u0000\u0462\u0450\u0001\u0000\u0000\u0000\u0462\u0459"+
		"\u0001\u0000\u0000\u0000\u04639\u0001\u0000\u0000\u0000\u0464\u0465\u0005"+
		"\n\u0000\u0000\u0465\u0467\u00050\u0000\u0000\u0466\u0468\u0003\u0016"+
		"\u000b\u0000\u0467\u0466\u0001\u0000\u0000\u0000\u0467\u0468\u0001\u0000"+
		"\u0000\u0000\u0468\u0469\u0001\u0000\u0000\u0000\u0469\u046c\u0005\u016b"+
		"\u0000\u0000\u046a\u046b\u0005\u0119\u0000\u0000\u046b\u046d\u0005\u016c"+
		"\u0000\u0000\u046c\u046a\u0001\u0000\u0000\u0000\u046c\u046d\u0001\u0000"+
		"\u0000\u0000\u046d;\u0001\u0000\u0000\u0000\u046e\u046f\u0005j\u0000\u0000"+
		"\u046f\u0471\u00050\u0000\u0000\u0470\u0472\u0003\u001a\r\u0000\u0471"+
		"\u0470\u0001\u0000\u0000\u0000\u0471\u0472\u0001\u0000\u0000\u0000\u0472"+
		"\u0473\u0001\u0000\u0000\u0000\u0473\u0475\u0005\u016b\u0000\u0000\u0474"+
		"\u0476\u0005S\u0000\u0000\u0475\u0474\u0001\u0000\u0000\u0000\u0475\u0476"+
		"\u0001\u0000\u0000\u0000\u0476=\u0001\u0000\u0000\u0000\u0477\u0478\u0005"+
		"\n\u0000\u0000\u0478\u047a\u0005\u011b\u0000\u0000\u0479\u047b\u0003\u0016"+
		"\u000b\u0000\u047a\u0479\u0001\u0000\u0000\u0000\u047a\u047b\u0001\u0000"+
		"\u0000\u0000\u047b\u047c\u0001\u0000\u0000\u0000\u047c\u047d\u0003\u0276"+
		"\u013b\u0000\u047d?\u0001\u0000\u0000\u0000\u047e\u047f\u0005j\u0000\u0000"+
		"\u047f\u0481\u0005\u011b\u0000\u0000\u0480\u0482\u0003\u001a\r\u0000\u0481"+
		"\u0480\u0001\u0000\u0000\u0000\u0481\u0482\u0001\u0000\u0000\u0000\u0482"+
		"\u0483\u0001\u0000\u0000\u0000\u0483\u0485\u0003\u0276\u013b\u0000\u0484"+
		"\u0486\u0005S\u0000\u0000\u0485\u0484\u0001\u0000\u0000\u0000\u0485\u0486"+
		"\u0001\u0000\u0000\u0000\u0486A\u0001\u0000\u0000\u0000\u0487\u0488\u0005"+
		"\n\u0000\u0000\u0488\u048a\u0005\u0118\u0000\u0000\u0489\u048b\u0003\u0016"+
		"\u000b\u0000\u048a\u0489\u0001\u0000\u0000\u0000\u048a\u048b\u0001\u0000"+
		"\u0000\u0000\u048b\u048c\u0001\u0000\u0000\u0000\u048c\u048f\u0005\u016b"+
		"\u0000\u0000\u048d\u048e\u0005\u0119\u0000\u0000\u048e\u0490\u0005\u016c"+
		"\u0000\u0000\u048f\u048d\u0001\u0000\u0000\u0000\u048f\u0490\u0001\u0000"+
		"\u0000\u0000\u0490\u0491\u0001\u0000\u0000\u0000\u0491\u0492\u0005\u011a"+
		"\u0000\u0000\u0492\u0493\u0005\u016c\u0000\u0000\u0493\u0494\u0005\u011f"+
		"\u0000\u0000\u0494\u0495\u0003\u010e\u0087\u0000\u0495C\u0001\u0000\u0000"+
		"\u0000\u0496\u0497\u0005j\u0000\u0000\u0497\u0499\u0005\u0118\u0000\u0000"+
		"\u0498\u049a\u0003\u001a\r\u0000\u0499\u0498\u0001\u0000\u0000\u0000\u0499"+
		"\u049a\u0001\u0000\u0000\u0000\u049a\u049b\u0001\u0000\u0000\u0000\u049b"+
		"\u049d\u0005\u016b\u0000\u0000\u049c\u049e\u0005S\u0000\u0000\u049d\u049c"+
		"\u0001\u0000\u0000\u0000\u049d\u049e\u0001\u0000\u0000\u0000\u049eE\u0001"+
		"\u0000\u0000\u0000\u049f\u04a0\u0005\n\u0000\u0000\u04a0\u04a2\u0005\u011c"+
		"\u0000\u0000\u04a1\u04a3\u0003\u0016\u000b\u0000\u04a2\u04a1\u0001\u0000"+
		"\u0000\u0000\u04a2\u04a3\u0001\u0000\u0000\u0000\u04a3\u04a5\u0001\u0000"+
		"\u0000\u0000\u04a4\u04a6\u0003\u0276\u013b\u0000\u04a5\u04a4\u0001\u0000"+
		"\u0000\u0000\u04a5\u04a6\u0001\u0000\u0000\u0000\u04a6\u04a9\u0001\u0000"+
		"\u0000\u0000\u04a7\u04a8\u0005\u0119\u0000\u0000\u04a8\u04aa\u0005\u016c"+
		"\u0000\u0000\u04a9\u04a7\u0001\u0000\u0000\u0000\u04a9\u04aa\u0001\u0000"+
		"\u0000\u0000\u04aaG\u0001\u0000\u0000\u0000\u04ab\u04ac\u0005j\u0000\u0000"+
		"\u04ac\u04ae\u0005\u011c\u0000\u0000\u04ad\u04af\u0003\u001a\r\u0000\u04ae"+
		"\u04ad\u0001\u0000\u0000\u0000\u04ae\u04af\u0001\u0000\u0000\u0000\u04af"+
		"\u04b0\u0001\u0000\u0000\u0000\u04b0\u04b2\u0003\u0276\u013b\u0000\u04b1"+
		"\u04b3\u0005S\u0000\u0000\u04b2\u04b1\u0001\u0000\u0000\u0000\u04b2\u04b3"+
		"\u0001\u0000\u0000\u0000\u04b3I\u0001\u0000\u0000\u0000\u04b4\u04b7\u0005"+
		"\u0146\u0000\u0000\u04b5\u04b8\u0003\u02de\u016f\u0000\u04b6\u04b8\u0003"+
		"\u02e6\u0173\u0000\u04b7\u04b5\u0001\u0000\u0000\u0000\u04b7\u04b6\u0001"+
		"\u0000\u0000\u0000\u04b8\u04b9\u0001\u0000\u0000\u0000\u04b9\u04b7\u0001"+
		"\u0000\u0000\u0000\u04b9\u04ba\u0001\u0000\u0000\u0000\u04ba\u04bb\u0001"+
		"\u0000\u0000\u0000\u04bb\u04bc\u0005\u0012\u0000\u0000\u04bcK\u0001\u0000"+
		"\u0000\u0000\u04bd\u04bf\u0005\n\u0000\u0000\u04be\u04c0\u0003\u001c\u000e"+
		"\u0000\u04bf\u04be\u0001\u0000\u0000\u0000\u04bf\u04c0\u0001\u0000\u0000"+
		"\u0000\u04c0\u04c2\u0001\u0000\u0000\u0000\u04c1\u04c3\u00052\u0000\u0000"+
		"\u04c2\u04c1\u0001\u0000\u0000\u0000\u04c2\u04c3\u0001\u0000\u0000\u0000"+
		"\u04c3\u04c4\u0001\u0000\u0000\u0000\u04c4\u04c6\u0005%\u0000\u0000\u04c5"+
		"\u04c7\u0003\u0016\u000b\u0000\u04c6\u04c5\u0001\u0000\u0000\u0000\u04c6"+
		"\u04c7\u0001\u0000\u0000\u0000\u04c7\u04c8\u0001\u0000\u0000\u0000\u04c8"+
		"\u04ca\u0003\u0278\u013c\u0000\u04c9\u04cb\u0003\u0090H\u0000\u04ca\u04c9"+
		"\u0001\u0000\u0000\u0000\u04ca\u04cb\u0001\u0000\u0000\u0000\u04cb\u04cd"+
		"\u0001\u0000\u0000\u0000\u04cc\u04ce\u0003\u00b4Z\u0000\u04cd\u04cc\u0001"+
		"\u0000\u0000\u0000\u04cd\u04ce\u0001\u0000\u0000\u0000\u04ce\u04d0\u0001"+
		"\u0000\u0000\u0000\u04cf\u04d1\u0003\u00be_\u0000\u04d0\u04cf\u0001\u0000"+
		"\u0000\u0000\u04d0\u04d1\u0001\u0000\u0000\u0000\u04d1\u04d2\u0001\u0000"+
		"\u0000\u0000\u04d2\u04d5\u0005\u0001\u0000\u0000\u04d3\u04d6\u0003\u02de"+
		"\u016f\u0000\u04d4\u04d6\u0003\u02e6\u0173\u0000\u04d5\u04d3\u0001\u0000"+
		"\u0000\u0000\u04d5\u04d4\u0001\u0000\u0000\u0000\u04d6M\u0001\u0000\u0000"+
		"\u0000\u04d7\u04d9\u0005\n\u0000\u0000\u04d8\u04da\u0003\u001c\u000e\u0000"+
		"\u04d9\u04d8\u0001\u0000\u0000\u0000\u04d9\u04da\u0001\u0000\u0000\u0000"+
		"\u04da\u04db\u0001\u0000\u0000\u0000\u04db\u04dd\u0005%\u0000\u0000\u04dc"+
		"\u04de\u0003\u0016\u000b\u0000\u04dd\u04dc\u0001\u0000\u0000\u0000\u04dd"+
		"\u04de\u0001\u0000\u0000\u0000\u04de\u04df\u0001\u0000\u0000\u0000\u04df"+
		"\u04e1\u0003\u0278\u013c\u0000\u04e0\u04e2\u0003\u0090H\u0000\u04e1\u04e0"+
		"\u0001\u0000\u0000\u0000\u04e1\u04e2\u0001\u0000\u0000\u0000\u04e2\u04e4"+
		"\u0001\u0000\u0000\u0000\u04e3\u04e5\u0003\u00b4Z\u0000\u04e4\u04e3\u0001"+
		"\u0000\u0000\u0000\u04e4\u04e5\u0001\u0000\u0000\u0000\u04e5\u04e7\u0001"+
		"\u0000\u0000\u0000\u04e6\u04e8\u0003\u00be_\u0000\u04e7\u04e6\u0001\u0000"+
		"\u0000\u0000\u04e7\u04e8\u0001\u0000\u0000\u0000\u04e8\u04e9\u0001\u0000"+
		"\u0000\u0000\u04e9\u04ea\u0005\u0001\u0000\u0000\u04ea\u04eb\u0003J%\u0000"+
		"\u04ebO\u0001\u0000\u0000\u0000\u04ec\u04ef\u0003L&\u0000\u04ed\u04ef"+
		"\u0003N\'\u0000\u04ee\u04ec\u0001\u0000\u0000\u0000\u04ee\u04ed\u0001"+
		"\u0000\u0000\u0000\u04efQ\u0001\u0000\u0000\u0000\u04f0\u04f2\u0005\n"+
		"\u0000\u0000\u04f1\u04f3\u0003\u001c\u000e\u0000\u04f2\u04f1\u0001\u0000"+
		"\u0000\u0000\u04f2\u04f3\u0001\u0000\u0000\u0000\u04f3\u04f4\u0001\u0000"+
		"\u0000\u0000\u04f4\u04f6\u0005.\u0000\u0000\u04f5\u04f7\u0003\u0016\u000b"+
		"\u0000\u04f6\u04f5\u0001\u0000\u0000\u0000\u04f6\u04f7\u0001\u0000\u0000"+
		"\u0000\u04f7\u04f8\u0001\u0000\u0000\u0000\u04f8\u04f9\u0003\u0278\u013c"+
		"\u0000\u04f9\u04fa\u0005\u0001\u0000\u0000\u04fa\u04fb\u0003\u00d8l\u0000"+
		"\u04fbS\u0001\u0000\u0000\u0000\u04fc\u04fe\u0005\n\u0000\u0000\u04fd"+
		"\u04ff\u0003\u001c\u000e\u0000\u04fe\u04fd\u0001\u0000\u0000\u0000\u04fe"+
		"\u04ff\u0001\u0000\u0000\u0000\u04ff\u0500\u0001\u0000\u0000\u0000\u0500"+
		"\u0502\u0005/\u0000\u0000\u0501\u0503\u0003\u0016\u000b\u0000\u0502\u0501"+
		"\u0001\u0000\u0000\u0000\u0502\u0503\u0001\u0000\u0000\u0000\u0503\u0504"+
		"\u0001\u0000\u0000\u0000\u0504\u0505\u0005\u0001\u0000\u0000\u0505\u0506"+
		"\u0003\u00d8l\u0000\u0506U\u0001\u0000\u0000\u0000\u0507\u0508\u0003\u010e"+
		"\u0087\u0000\u0508W\u0001\u0000\u0000\u0000\u0509\u050a\u0003\u010e\u0087"+
		"\u0000\u050aY\u0001\u0000\u0000\u0000\u050b\u0516\u00050\u0000\u0000\u050c"+
		"\u0516\u0005\u011b\u0000\u0000\u050d\u0516\u0005%\u0000\u0000\u050e\u050f"+
		"\u00052\u0000\u0000\u050f\u0516\u0005%\u0000\u0000\u0510\u0516\u0005/"+
		"\u0000\u0000\u0511\u0516\u0005B\u0000\u0000\u0512\u0516\u00056\u0000\u0000"+
		"\u0513\u0516\u0005\u0118\u0000\u0000\u0514\u0516\u0005\u010a\u0000\u0000"+
		"\u0515\u050b\u0001\u0000\u0000\u0000\u0515\u050c\u0001\u0000\u0000\u0000"+
		"\u0515\u050d\u0001\u0000\u0000\u0000\u0515\u050e\u0001\u0000\u0000\u0000"+
		"\u0515\u0510\u0001\u0000\u0000\u0000\u0515\u0511\u0001\u0000\u0000\u0000"+
		"\u0515\u0512\u0001\u0000\u0000\u0000\u0515\u0513\u0001\u0000\u0000\u0000"+
		"\u0515\u0514\u0001\u0000\u0000\u0000\u0516[\u0001\u0000\u0000\u0000\u0517"+
		"\u0518\u0007\u0003\u0000\u0000\u0518]\u0001\u0000\u0000\u0000\u0519\u051a"+
		"\u0007\u0004\u0000\u0000\u051a_\u0001\u0000\u0000\u0000\u051b\u051e\u0005"+
		"\u0165\u0000\u0000\u051c\u051d\u0005c\u0000\u0000\u051d\u051f\u0005\u016d"+
		"\u0000\u0000\u051e\u051c\u0001\u0000\u0000\u0000\u051e\u051f\u0001\u0000"+
		"\u0000\u0000\u051fa\u0001\u0000\u0000\u0000\u0520\u0521\u0005@\u0000\u0000"+
		"\u0521\u0522\u0005\u00f8\u0000\u0000\u0522\u0527\u0003`0\u0000\u0523\u0524"+
		"\u0005\u00f1\u0000\u0000\u0524\u0526\u0003`0\u0000\u0525\u0523\u0001\u0000"+
		"\u0000\u0000\u0526\u0529\u0001\u0000\u0000\u0000\u0527\u0525\u0001\u0000"+
		"\u0000\u0000\u0527\u0528\u0001\u0000\u0000\u0000\u0528\u052a\u0001\u0000"+
		"\u0000\u0000\u0529\u0527\u0001\u0000\u0000\u0000\u052a\u052b\u0005\u00f9"+
		"\u0000\u0000\u052bc\u0001\u0000\u0000\u0000\u052c\u052e\u0005\n\u0000"+
		"\u0000\u052d\u052f\u0003\u001c\u000e\u0000\u052e\u052d\u0001\u0000\u0000"+
		"\u0000\u052e\u052f\u0001\u0000\u0000\u0000\u052f\u0530\u0001\u0000\u0000"+
		"\u0000\u0530\u0531\u00056\u0000\u0000\u0531\u0533\u0003V+\u0000\u0532"+
		"\u0534\u0003X,\u0000\u0533\u0532\u0001\u0000\u0000\u0000\u0533\u0534\u0001"+
		"\u0000\u0000\u0000\u0534\u0535\u0001\u0000\u0000\u0000\u0535\u0536\u0005"+
		"v\u0000\u0000\u0536\u0537\u0003^/\u0000\u0537\u053a\u0003\u0278\u013c"+
		"\u0000\u0538\u0539\u0005I\u0000\u0000\u0539\u053b\u0003\u00aeW\u0000\u053a"+
		"\u0538\u0001\u0000\u0000\u0000\u053a\u053b\u0001\u0000\u0000\u0000\u053b"+
		"\u053d\u0001\u0000\u0000\u0000\u053c\u053e\u0003b1\u0000\u053d\u053c\u0001"+
		"\u0000\u0000\u0000\u053d\u053e\u0001\u0000\u0000\u0000\u053ee\u0001\u0000"+
		"\u0000\u0000\u053f\u0541\u0005\u014d\u0000\u0000\u0540\u0542\u0003\u001a"+
		"\r\u0000\u0541\u0540\u0001\u0000\u0000\u0000\u0541\u0542\u0001\u0000\u0000"+
		"\u0000\u0542\u0543\u0001\u0000\u0000\u0000\u0543\u0544\u00056\u0000\u0000"+
		"\u0544\u0545\u0003V+\u0000\u0545\u0546\u0003X,\u0000\u0546g\u0001\u0000"+
		"\u0000\u0000\u0547\u0548\u0005j\u0000\u0000\u0548\u054a\u00056\u0000\u0000"+
		"\u0549\u054b\u0003\u001a\r\u0000\u054a\u0549\u0001\u0000\u0000\u0000\u054a"+
		"\u054b\u0001\u0000\u0000\u0000\u054b\u054c\u0001\u0000\u0000\u0000\u054c"+
		"\u054d\u0003V+\u0000\u054d\u054e\u0003X,\u0000\u054ei\u0001\u0000\u0000"+
		"\u0000\u054f\u0550\u0005\u014b\u0000\u0000\u0550\u0552\u00056\u0000\u0000"+
		"\u0551\u0553\u0003\u001a\r\u0000\u0552\u0551\u0001\u0000\u0000\u0000\u0552"+
		"\u0553\u0001\u0000\u0000\u0000\u0553\u0554\u0001\u0000\u0000\u0000\u0554"+
		"\u0555\u0003V+\u0000\u0555\u0556\u0003X,\u0000\u0556\u0557\u0005\u00b6"+
		"\u0000\u0000\u0557\u0558\u0005\u016c\u0000\u0000\u0558k\u0001\u0000\u0000"+
		"\u0000\u0559\u055a\u0005\u014b\u0000\u0000\u055a\u055c\u0005%\u0000\u0000"+
		"\u055b\u055d\u0003\u001a\r\u0000\u055c\u055b\u0001\u0000\u0000\u0000\u055c"+
		"\u055d\u0001\u0000\u0000\u0000\u055d\u055e\u0001\u0000\u0000\u0000\u055e"+
		"\u055f\u0003\u0278\u013c\u0000\u055f\u0560\u0005\u00b6\u0000\u0000\u0560"+
		"\u0563\u0005\u016c\u0000\u0000\u0561\u0562\u0005\u0001\u0000\u0000\u0562"+
		"\u0564\u0005\u00e2\u0000\u0000\u0563\u0561\u0001\u0000\u0000\u0000\u0563"+
		"\u0564\u0001\u0000\u0000\u0000\u0564m\u0001\u0000\u0000\u0000\u0565\u056a"+
		"\u0003\u010e\u0087\u0000\u0566\u0567\u0005\u00ff\u0000\u0000\u0567\u0569"+
		"\u0003\u010e\u0087\u0000\u0568\u0566\u0001\u0000\u0000\u0000\u0569\u056c"+
		"\u0001\u0000\u0000\u0000\u056a\u0568\u0001\u0000\u0000\u0000\u056a\u056b"+
		"\u0001\u0000\u0000\u0000\u056bo\u0001\u0000\u0000\u0000\u056c\u056a\u0001"+
		"\u0000\u0000\u0000\u056d\u056f\u0003n7\u0000\u056e\u0570\u0003X,\u0000"+
		"\u056f\u056e\u0001\u0000\u0000\u0000\u056f\u0570\u0001\u0000\u0000\u0000"+
		"\u0570q\u0001\u0000\u0000\u0000\u0571\u0572\u0003\\.\u0000\u0572\u0573"+
		"\u0003n7\u0000\u0573s\u0001\u0000\u0000\u0000\u0574\u0575\u0005\u014f"+
		"\u0000\u0000\u0575\u0576\u0005\u016c\u0000\u0000\u0576u\u0001\u0000\u0000"+
		"\u0000\u0577\u057e\u0005\u014c\u0000\u0000\u0578\u057a\u0003Z-\u0000\u0579"+
		"\u057b\u0003\u0016\u000b\u0000\u057a\u0579\u0001\u0000\u0000\u0000\u057a"+
		"\u057b\u0001\u0000\u0000\u0000\u057b\u057c\u0001\u0000\u0000\u0000\u057c"+
		"\u057d\u0003p8\u0000\u057d\u057f\u0001\u0000\u0000\u0000\u057e\u0578\u0001"+
		"\u0000\u0000\u0000\u057e\u057f\u0001\u0000\u0000\u0000\u057f\u0580\u0001"+
		"\u0000\u0000\u0000\u0580\u0581\u0005\u0017\u0000\u0000\u0581\u0584\u0005"+
		"\u016c\u0000\u0000\u0582\u0583\u0005\u001e\u0000\u0000\u0583\u0585\u0003"+
		"r9\u0000\u0584\u0582\u0001\u0000\u0000\u0000\u0584\u0585\u0001\u0000\u0000"+
		"\u0000\u0585\u0586\u0001\u0000\u0000\u0000\u0586\u0587\u0003t:\u0000\u0587"+
		"w\u0001\u0000\u0000\u0000\u0588\u0589\u0005\u00f8\u0000\u0000\u0589\u058e"+
		"\u0003z=\u0000\u058a\u058b\u0005\u00f1\u0000\u0000\u058b\u058d\u0003z"+
		"=\u0000\u058c\u058a\u0001\u0000\u0000\u0000\u058d\u0590\u0001\u0000\u0000"+
		"\u0000\u058e\u058c\u0001\u0000\u0000\u0000\u058e\u058f\u0001\u0000\u0000"+
		"\u0000\u058f\u0591\u0001\u0000\u0000\u0000\u0590\u058e\u0001\u0000\u0000"+
		"\u0000\u0591\u0592\u0005\u00f9\u0000\u0000\u0592y\u0001\u0000\u0000\u0000"+
		"\u0593\u0595\u0003\u00fe\u007f\u0000\u0594\u0593\u0001\u0000\u0000\u0000"+
		"\u0595\u0598\u0001\u0000\u0000\u0000\u0596\u0594\u0001\u0000\u0000\u0000"+
		"\u0596\u0597\u0001\u0000\u0000\u0000\u0597\u0599\u0001\u0000\u0000\u0000"+
		"\u0598\u0596\u0001\u0000\u0000\u0000\u0599\u059a\u0003\u010e\u0087\u0000"+
		"\u059a\u059c\u0003\u0080@\u0000\u059b\u059d\u0003\u0082A\u0000\u059c\u059b"+
		"\u0001\u0000\u0000\u0000\u059c\u059d\u0001\u0000\u0000\u0000\u059d\u059f"+
		"\u0001\u0000\u0000\u0000\u059e\u05a0\u0003\u0084B\u0000\u059f\u059e\u0001"+
		"\u0000\u0000\u0000\u059f\u05a0\u0001\u0000\u0000\u0000\u05a0\u05a2\u0001"+
		"\u0000\u0000\u0000\u05a1\u05a3\u0003\u0086C\u0000\u05a2\u05a1\u0001\u0000"+
		"\u0000\u0000\u05a2\u05a3\u0001\u0000\u0000\u0000\u05a3\u05a5\u0001\u0000"+
		"\u0000\u0000\u05a4\u05a6\u0003\u0088D\u0000\u05a5\u05a4\u0001\u0000\u0000"+
		"\u0000\u05a5\u05a6\u0001\u0000\u0000\u0000\u05a6\u05a8\u0001\u0000\u0000"+
		"\u0000\u05a7\u05a9\u00032\u0019\u0000\u05a8\u05a7\u0001\u0000\u0000\u0000"+
		"\u05a8\u05a9\u0001\u0000\u0000\u0000\u05a9\u05ab\u0001\u0000\u0000\u0000"+
		"\u05aa\u05ac\u0003\u008aE\u0000\u05ab\u05aa\u0001\u0000\u0000\u0000\u05ab"+
		"\u05ac\u0001\u0000\u0000\u0000\u05ac\u05ae\u0001\u0000\u0000\u0000\u05ad"+
		"\u05af\u0003\u008cF\u0000\u05ae\u05ad\u0001\u0000\u0000\u0000\u05ae\u05af"+
		"\u0001\u0000\u0000\u0000\u05af\u05b1\u0001\u0000\u0000\u0000\u05b0\u05b2"+
		"\u0003\u008eG\u0000\u05b1\u05b0\u0001\u0000\u0000\u0000\u05b1\u05b2\u0001"+
		"\u0000\u0000\u0000\u05b2\u05b6\u0001\u0000\u0000\u0000\u05b3\u05b6\u0003"+
		"\u02f6\u017b\u0000\u05b4\u05b6\u0003|>\u0000\u05b5\u0596\u0001\u0000\u0000"+
		"\u0000\u05b5\u05b3\u0001\u0000\u0000\u0000\u05b5\u05b4\u0001\u0000\u0000"+
		"\u0000\u05b6{\u0001\u0000\u0000\u0000\u05b7\u05b9\u0003\u00fe\u007f\u0000"+
		"\u05b8\u05b7\u0001\u0000\u0000\u0000\u05b9\u05bc\u0001\u0000\u0000\u0000"+
		"\u05ba\u05b8\u0001\u0000\u0000\u0000\u05ba\u05bb\u0001\u0000\u0000\u0000"+
		"\u05bb\u05bd\u0001\u0000\u0000\u0000\u05bc\u05ba\u0001\u0000\u0000\u0000"+
		"\u05bd\u05bf\u0005}\u0000\u0000\u05be\u05c0\u0005<\u0000\u0000\u05bf\u05be"+
		"\u0001\u0000\u0000\u0000\u05bf\u05c0\u0001\u0000\u0000\u0000\u05c0\u05c1"+
		"\u0001\u0000\u0000\u0000\u05c1\u05c2\u0003\u010e\u0087\u0000\u05c2\u05c3"+
		"\u0005\u00f8\u0000\u0000\u05c3\u05c4\u0003\u021e\u010f\u0000\u05c4\u05c5"+
		"\u0005\u00f9\u0000\u0000\u05c5}\u0001\u0000\u0000\u0000\u05c6\u05c8\u0003"+
		"\u010e\u0087\u0000\u05c7\u05c9\u0003\u0080@\u0000\u05c8\u05c7\u0001\u0000"+
		"\u0000\u0000\u05c8\u05c9\u0001\u0000\u0000\u0000\u05c9\u05cb\u0001\u0000"+
		"\u0000\u0000\u05ca\u05cc\u0003\u0082A\u0000\u05cb\u05ca\u0001\u0000\u0000"+
		"\u0000\u05cb\u05cc\u0001\u0000\u0000\u0000\u05cc\u05ce\u0001\u0000\u0000"+
		"\u0000\u05cd\u05cf\u0003\u0084B\u0000\u05ce\u05cd\u0001\u0000\u0000\u0000"+
		"\u05ce\u05cf\u0001\u0000\u0000\u0000\u05cf\u05d1\u0001\u0000\u0000\u0000"+
		"\u05d0\u05d2\u0003\u0086C\u0000\u05d1\u05d0\u0001\u0000\u0000\u0000\u05d1"+
		"\u05d2\u0001\u0000\u0000\u0000\u05d2\u05d4\u0001\u0000\u0000\u0000\u05d3"+
		"\u05d5\u0003\u0088D\u0000\u05d4\u05d3\u0001\u0000\u0000\u0000\u05d4\u05d5"+
		"\u0001\u0000\u0000\u0000\u05d5\u05d7\u0001\u0000\u0000\u0000\u05d6\u05d8"+
		"\u00032\u0019\u0000\u05d7\u05d6\u0001\u0000\u0000\u0000\u05d7\u05d8\u0001"+
		"\u0000\u0000\u0000\u05d8\u05da\u0001\u0000\u0000\u0000\u05d9\u05db\u0003"+
		"\u008aE\u0000\u05da\u05d9\u0001\u0000\u0000\u0000\u05da\u05db\u0001\u0000"+
		"\u0000\u0000\u05db\u05dd\u0001\u0000\u0000\u0000\u05dc\u05de\u0003\u008c"+
		"F\u0000\u05dd\u05dc\u0001\u0000\u0000\u0000\u05dd\u05de\u0001\u0000\u0000"+
		"\u0000\u05de\u05e0\u0001\u0000\u0000\u0000\u05df\u05e1\u0003\u008eG\u0000"+
		"\u05e0\u05df\u0001\u0000\u0000\u0000\u05e0\u05e1\u0001\u0000\u0000\u0000"+
		"\u05e1\u007f\u0001\u0000\u0000\u0000\u05e2\u05e3\u0003\u0120\u0090\u0000"+
		"\u05e3\u0081\u0001\u0000\u0000\u0000\u05e4\u05e8\u0005(\u0000\u0000\u05e5"+
		"\u05e6\u0005\'\u0000\u0000\u05e6\u05e8\u0005(\u0000\u0000\u05e7\u05e4"+
		"\u0001\u0000\u0000\u0000\u05e7\u05e5\u0001\u0000\u0000\u0000\u05e8\u0083"+
		"\u0001\u0000\u0000\u0000\u05e9\u05ea\u0005C\u0000\u0000\u05ea\u05eb\u0005"+
		"\u0106\u0000\u0000\u05eb\u0085\u0001\u0000\u0000\u0000\u05ec\u05ed\u0005"+
		"D\u0000\u0000\u05ed\u05ee\u0005\u0106\u0000\u0000\u05ee\u0087\u0001\u0000"+
		"\u0000\u0000\u05ef\u05f0\u0005\u0115\u0000\u0000\u05f0\u05f1\u0005\u0106"+
		"\u0000\u0000\u05f1\u0089\u0001\u0000\u0000\u0000\u05f2\u05f3\u0005w\u0000"+
		"\u0000\u05f3\u05f4\u0005\u016d\u0000\u0000\u05f4\u008b\u0001\u0000\u0000"+
		"\u0000\u05f5\u05f6\u0005\u0117\u0000\u0000\u05f6\u008d\u0001\u0000\u0000"+
		"\u0000\u05f7\u05f8\u0005\u0148\u0000\u0000\u05f8\u05f9\u0005\u016d\u0000"+
		"\u0000\u05f9\u008f\u0001\u0000\u0000\u0000\u05fa\u05fb\u0005\u00f8\u0000"+
		"\u0000\u05fb\u0600\u0003\u0092I\u0000\u05fc\u05fd\u0005\u00f1\u0000\u0000"+
		"\u05fd\u05ff\u0003\u0092I\u0000\u05fe\u05fc\u0001\u0000\u0000\u0000\u05ff"+
		"\u0602\u0001\u0000\u0000\u0000\u0600\u05fe\u0001\u0000\u0000\u0000\u0600"+
		"\u0601\u0001\u0000\u0000\u0000\u0601\u0603\u0001\u0000\u0000\u0000\u0602"+
		"\u0600\u0001\u0000\u0000\u0000\u0603\u0604\u0005\u00f9\u0000\u0000\u0604"+
		"\u0091\u0001\u0000\u0000\u0000\u0605\u0606\u0005\u016d\u0000\u0000\u0606"+
		"\u0607\u0005\u00ee\u0000\u0000\u0607\u0608\u0003\u0182\u00c1\u0000\u0608"+
		"\u0093\u0001\u0000\u0000\u0000\u0609\u060a\u0005\u016d\u0000\u0000\u060a"+
		"\u060b\u0005\u00ee\u0000\u0000\u060b\u060c\u0003\u0112\u0089\u0000\u060c"+
		"\u0095\u0001\u0000\u0000\u0000\u060d\u060e\u0005\u016c\u0000\u0000\u060e"+
		"\u0097\u0001\u0000\u0000\u0000\u060f\u0610\u0005v\u0000\u0000\u0610\u0611"+
		"\u0005H\u0000\u0000\u0611\u0612\u0005\u016c\u0000\u0000\u0612\u0099\u0001"+
		"\u0000\u0000\u0000\u0613\u0616\u0003\u0272\u0139\u0000\u0614\u0616\u0005"+
		"\u016b\u0000\u0000\u0615\u0613\u0001\u0000\u0000\u0000\u0615\u0614\u0001"+
		"\u0000\u0000\u0000\u0616\u009b\u0001\u0000\u0000\u0000\u0617\u061c\u0003"+
		"\u009aM\u0000\u0618\u0619\u0005\u00f1\u0000\u0000\u0619\u061b\u0003\u009a"+
		"M\u0000\u061a\u0618\u0001\u0000\u0000\u0000\u061b\u061e\u0001\u0000\u0000"+
		"\u0000\u061c\u061a\u0001\u0000\u0000\u0000\u061c\u061d\u0001\u0000\u0000"+
		"\u0000\u061d\u009d\u0001\u0000\u0000\u0000\u061e\u061c\u0001\u0000\u0000"+
		"\u0000\u061f\u0620\u0005v\u0000\u0000\u0620\u0621\u00057\u0000\u0000\u0621"+
		"\u0626\u0003\u0272\u0139\u0000\u0622\u0623\u0005\u00f1\u0000\u0000\u0623"+
		"\u0625\u0003\u0272\u0139\u0000\u0624\u0622\u0001\u0000\u0000\u0000\u0625"+
		"\u0628\u0001\u0000\u0000\u0000\u0626\u0624\u0001\u0000\u0000\u0000\u0626"+
		"\u0627\u0001\u0000\u0000\u0000\u0627\u009f\u0001\u0000\u0000\u0000\u0628"+
		"\u0626\u0001\u0000\u0000\u0000\u0629\u062a\u0005v\u0000\u0000\u062a\u062b"+
		"\u00057\u0000\u0000\u062b\u062c\u0003\u009cN\u0000\u062c\u00a1\u0001\u0000"+
		"\u0000\u0000\u062d\u062e\u0005\u00f8\u0000\u0000\u062e\u0633\u0003\u0094"+
		"J\u0000\u062f\u0630\u0005\u00f1\u0000\u0000\u0630\u0632\u0003\u0094J\u0000"+
		"\u0631\u062f\u0001\u0000\u0000\u0000\u0632\u0635\u0001\u0000\u0000\u0000"+
		"\u0633\u0631\u0001\u0000\u0000\u0000\u0633\u0634\u0001\u0000\u0000\u0000"+
		"\u0634\u0636\u0001\u0000\u0000\u0000\u0635\u0633\u0001\u0000\u0000\u0000"+
		"\u0636\u0637\u0005\u00f9\u0000\u0000\u0637\u00a3\u0001\u0000\u0000\u0000"+
		"\u0638\u0639\u0005F\u0000\u0000\u0639\u063b\u0003\u0096K\u0000\u063a\u063c"+
		"\u0003\u0098L\u0000\u063b\u063a\u0001\u0000\u0000\u0000\u063b\u063c\u0001"+
		"\u0000\u0000\u0000\u063c\u063e\u0001\u0000\u0000\u0000\u063d\u063f\u0003"+
		"\u00a2Q\u0000\u063e\u063d\u0001\u0000\u0000\u0000\u063e\u063f\u0001\u0000"+
		"\u0000\u0000\u063f\u00a5\u0001\u0000\u0000\u0000\u0640\u0641\u0005\u0120"+
		"\u0000\u0000\u0641\u0644\u0003\u0096K\u0000\u0642\u0645\u0003\u0098L\u0000"+
		"\u0643\u0645\u0003\u00a0P\u0000\u0644\u0642\u0001\u0000\u0000\u0000\u0644"+
		"\u0643\u0001\u0000\u0000\u0000\u0645\u0647\u0001\u0000\u0000\u0000\u0646"+
		"\u0648\u0003\u00a2Q\u0000\u0647\u0646\u0001\u0000\u0000\u0000\u0647\u0648"+
		"\u0001\u0000\u0000\u0000\u0648\u00a7\u0001\u0000\u0000\u0000\u0649\u064a"+
		"\u0005E\u0000\u0000\u064a\u064d\u0003\u0096K\u0000\u064b\u064e\u0003\u0098"+
		"L\u0000\u064c\u064e\u0003\u00a0P\u0000\u064d\u064b\u0001\u0000\u0000\u0000"+
		"\u064d\u064c\u0001\u0000\u0000\u0000\u064d\u064e\u0001\u0000\u0000\u0000"+
		"\u064e\u0650\u0001\u0000\u0000\u0000\u064f\u0651\u0003\u00a2Q\u0000\u0650"+
		"\u064f\u0001\u0000\u0000\u0000\u0650\u0651\u0001\u0000\u0000\u0000\u0651"+
		"\u00a9\u0001\u0000\u0000\u0000\u0652\u0653\u0005G\u0000\u0000\u0653\u0655"+
		"\u0003\u0096K\u0000\u0654\u0656\u0003\u0098L\u0000\u0655\u0654\u0001\u0000"+
		"\u0000\u0000\u0655\u0656\u0001\u0000\u0000\u0000\u0656\u0658\u0001\u0000"+
		"\u0000\u0000\u0657\u0659\u0003\u00a2Q\u0000\u0658\u0657\u0001\u0000\u0000"+
		"\u0000\u0658\u0659\u0001\u0000\u0000\u0000\u0659\u00ab\u0001\u0000\u0000"+
		"\u0000\u065a\u065f\u0003\u00a4R\u0000\u065b\u065f\u0003\u00a8T\u0000\u065c"+
		"\u065f\u0003\u00aaU\u0000\u065d\u065f\u0003\u00a6S\u0000\u065e\u065a\u0001"+
		"\u0000\u0000\u0000\u065e\u065b\u0001\u0000\u0000\u0000\u065e\u065c\u0001"+
		"\u0000\u0000\u0000\u065e\u065d\u0001\u0000\u0000\u0000\u065f\u0660\u0001"+
		"\u0000\u0000\u0000\u0660\u065e\u0001\u0000\u0000\u0000\u0660\u0661\u0001"+
		"\u0000\u0000\u0000\u0661\u00ad\u0001\u0000\u0000\u0000\u0662\u0663\u0005"+
		"\u016c\u0000\u0000\u0663\u00af\u0001\u0000\u0000\u0000\u0664\u0665\u0005"+
		"J\u0000\u0000\u0665\u0666\u0005\u016c\u0000\u0000\u0666\u00b1\u0001\u0000"+
		"\u0000\u0000\u0667\u0668\u0005K\u0000\u0000\u0668\u0669\u0003\u010e\u0087"+
		"\u0000\u0669\u00b3\u0001\u0000\u0000\u0000\u066a\u066b\u0005\u0150\u0000"+
		"\u0000\u066b\u066c\u0005\u0088\u0000\u0000\u066c\u066d\u0003\u010e\u0087"+
		"\u0000\u066d\u00b5\u0001\u0000\u0000\u0000\u066e\u0671\u0005\u016e\u0000"+
		"\u0000\u066f\u0670\u0005H\u0000\u0000\u0670\u0672\u0005\u016c\u0000\u0000"+
		"\u0671\u066f\u0001\u0000\u0000\u0000\u0671\u0672\u0001\u0000\u0000\u0000"+
		"\u0672\u0675\u0001\u0000\u0000\u0000\u0673\u0674\u0005\u0088\u0000\u0000"+
		"\u0674\u0676\u0005\u016c\u0000\u0000\u0675\u0673\u0001\u0000\u0000\u0000"+
		"\u0675\u0676\u0001\u0000\u0000\u0000\u0676\u00b7\u0001\u0000\u0000\u0000"+
		"\u0677\u0678\u0005)\u0000\u0000\u0678\u0679\u0005\u0146\u0000\u0000\u0679"+
		"\u067a\u0005%\u0000\u0000\u067a\u067b\u0003\u00b6[\u0000\u067b\u00b9\u0001"+
		"\u0000\u0000\u0000\u067c\u067d\u0005)\u0000\u0000\u067d\u067e\u0005\u0012"+
		"\u0000\u0000\u067e\u067f\u0005%\u0000\u0000\u067f\u0680\u0003\u00b6[\u0000"+
		"\u0680\u00bb\u0001\u0000\u0000\u0000\u0681\u0683\u0005I\u0000\u0000\u0682"+
		"\u0684\u0003\u00aeW\u0000\u0683\u0682\u0001\u0000\u0000\u0000\u0683\u0684"+
		"\u0001\u0000\u0000\u0000\u0684\u0685\u0001\u0000\u0000\u0000\u0685\u0687"+
		"\u0005\u00f8\u0000\u0000\u0686\u0688\u0003\u00b0X\u0000\u0687\u0686\u0001"+
		"\u0000\u0000\u0000\u0687\u0688\u0001\u0000\u0000\u0000\u0688\u068a\u0001"+
		"\u0000\u0000\u0000\u0689\u068b\u0003\u00b4Z\u0000\u068a\u0689\u0001\u0000"+
		"\u0000\u0000\u068a\u068b\u0001\u0000\u0000\u0000\u068b\u068d\u0001\u0000"+
		"\u0000\u0000\u068c\u068e\u0003\u00b2Y\u0000\u068d\u068c\u0001\u0000\u0000"+
		"\u0000\u068d\u068e\u0001\u0000\u0000\u0000\u068e\u0690\u0001\u0000\u0000"+
		"\u0000\u068f\u0691\u0003\u00b8\\\u0000\u0690\u068f\u0001\u0000\u0000\u0000"+
		"\u0690\u0691\u0001\u0000\u0000\u0000\u0691\u0693\u0001\u0000\u0000\u0000"+
		"\u0692\u0694\u0003\u00ba]\u0000\u0693\u0692\u0001\u0000\u0000\u0000\u0693"+
		"\u0694\u0001\u0000\u0000\u0000\u0694\u0696\u0001\u0000\u0000\u0000\u0695"+
		"\u0697\u0005L\u0000\u0000\u0696\u0695\u0001\u0000\u0000\u0000\u0696\u0697"+
		"\u0001\u0000\u0000\u0000\u0697\u0699\u0001\u0000\u0000\u0000\u0698\u069a"+
		"\u0005M\u0000\u0000\u0699\u0698\u0001\u0000\u0000\u0000\u0699\u069a\u0001"+
		"\u0000\u0000\u0000\u069a\u069c\u0001\u0000\u0000\u0000\u069b\u069d\u0003"+
		"\u00acV\u0000\u069c\u069b\u0001\u0000\u0000\u0000\u069c\u069d\u0001\u0000"+
		"\u0000\u0000\u069d\u069e\u0001\u0000\u0000\u0000\u069e\u069f\u0005\u00f9"+
		"\u0000\u0000\u069f\u00bd\u0001\u0000\u0000\u0000\u06a0\u06a2\u0003\u00bc"+
		"^\u0000\u06a1\u06a0\u0001\u0000\u0000\u0000\u06a2\u06a3\u0001\u0000\u0000"+
		"\u0000\u06a3\u06a1\u0001\u0000\u0000\u0000\u06a3\u06a4\u0001\u0000\u0000"+
		"\u0000\u06a4\u00bf\u0001\u0000\u0000\u0000\u06a5\u06a6\u0005\u0142\u0000"+
		"\u0000\u06a6\u06a7\u0003\u01cc\u00e6\u0000\u06a7\u00c1\u0001\u0000\u0000"+
		"\u0000\u06a8\u06a9\u0005\u0143\u0000\u0000\u06a9\u06aa\u0003\u01cc\u00e6"+
		"\u0000\u06aa\u00c3\u0001\u0000\u0000\u0000\u06ab\u06ac\u0005\u00a9\u0000"+
		"\u0000\u06ac\u06ad\u0003\u01cc\u00e6\u0000\u06ad\u06b0\u0005\u00ee\u0000"+
		"\u0000\u06ae\u06b1\u0005\u016d\u0000\u0000\u06af\u06b1\u0003\u014a\u00a5"+
		"\u0000\u06b0\u06ae\u0001\u0000\u0000\u0000\u06b0\u06af\u0001\u0000\u0000"+
		"\u0000\u06b1\u00c5\u0001\u0000\u0000\u0000\u06b2\u06b3\u0005@\u0000\u0000"+
		"\u06b3\u06b4\u0005\u00f8\u0000\u0000\u06b4\u06b9\u0003\u0094J\u0000\u06b5"+
		"\u06b6\u0005\u00f1\u0000\u0000\u06b6\u06b8\u0003\u0094J\u0000\u06b7\u06b5"+
		"\u0001\u0000\u0000\u0000\u06b8\u06bb\u0001\u0000\u0000\u0000\u06b9\u06b7"+
		"\u0001\u0000\u0000\u0000\u06b9\u06ba\u0001\u0000\u0000\u0000\u06ba\u06bc"+
		"\u0001\u0000\u0000\u0000\u06bb\u06b9\u0001\u0000\u0000\u0000\u06bc\u06bd"+
		"\u0005\u00f9\u0000\u0000\u06bd\u00c7\u0001\u0000\u0000\u0000\u06be\u06bf"+
		"\u0005/\u0000\u0000\u06bf\u06c1\u0003\u0278\u013c\u0000\u06c0\u06c2\u0003"+
		"\u00c6c\u0000\u06c1\u06c0\u0001\u0000\u0000\u0000\u06c1\u06c2\u0001\u0000"+
		"\u0000\u0000\u06c2\u00c9\u0001\u0000\u0000\u0000\u06c3\u06c4\u0003\u01cc"+
		"\u00e6\u0000\u06c4\u06c5\u0005\u00ee\u0000\u0000\u06c5\u06c6\u0007\u0005"+
		"\u0000\u0000\u06c6\u06c7\u0003\u014a\u00a5\u0000\u06c7\u06cf\u0001\u0000"+
		"\u0000\u0000\u06c8\u06c9\u0003\u01cc\u00e6\u0000\u06c9\u06ca\u0005\u00ee"+
		"\u0000\u0000\u06ca\u06cb\u0003\u01cc\u00e6\u0000\u06cb\u06cc\u0007\u0005"+
		"\u0000\u0000\u06cc\u06cd\u0003\u014a\u00a5\u0000\u06cd\u06cf\u0001\u0000"+
		"\u0000\u0000\u06ce\u06c3\u0001\u0000\u0000\u0000\u06ce\u06c8\u0001\u0000"+
		"\u0000\u0000\u06cf\u00cb\u0001\u0000\u0000\u0000\u06d0\u06d1\u0005%\u0000"+
		"\u0000\u06d1\u06d4\u0003\u0278\u013c\u0000\u06d2\u06d3\u0005I\u0000\u0000"+
		"\u06d3\u06d5\u0003\u00aeW\u0000\u06d4\u06d2\u0001\u0000\u0000\u0000\u06d4"+
		"\u06d5\u0001\u0000\u0000\u0000\u06d5\u00cd\u0001\u0000\u0000\u0000\u06d6"+
		"\u06de\u0003\u00c0`\u0000\u06d7\u06de\u0003\u00c2a\u0000\u06d8\u06de\u0003"+
		"\u00c4b\u0000\u06d9\u06de\u0003\u00cae\u0000\u06da\u06de\u0003\u00ccf"+
		"\u0000\u06db\u06de\u0003\u00c8d\u0000\u06dc\u06de\u0003\u00d8l\u0000\u06dd"+
		"\u06d6\u0001\u0000\u0000\u0000\u06dd\u06d7\u0001\u0000\u0000\u0000\u06dd"+
		"\u06d8\u0001\u0000\u0000\u0000\u06dd\u06d9\u0001\u0000\u0000\u0000\u06dd"+
		"\u06da\u0001\u0000\u0000\u0000\u06dd\u06db\u0001\u0000\u0000\u0000\u06dd"+
		"\u06dc\u0001\u0000\u0000\u0000\u06de\u00cf\u0001\u0000\u0000\u0000\u06df"+
		"\u06e0\u0005)\u0000\u0000\u06e0\u06e4\u0005\u013f\u0000\u0000\u06e1\u06e2"+
		"\u0005\u0141\u0000\u0000\u06e2\u06e5\u0003\u00d4j\u0000\u06e3\u06e5\u0005"+
		"\u0147\u0000\u0000\u06e4\u06e1\u0001\u0000\u0000\u0000\u06e4\u06e3\u0001"+
		"\u0000\u0000\u0000\u06e5\u00d1\u0001\u0000\u0000\u0000\u06e6\u06e7\u0005"+
		")\u0000\u0000\u06e7\u06ee\u0005\u0140\u0000\u0000\u06e8\u06e9\u0005\u0144"+
		"\u0000\u0000\u06e9\u06ec\u0005\u0106\u0000\u0000\u06ea\u06eb\u0005\u0145"+
		"\u0000\u0000\u06eb\u06ed\u0005\u0106\u0000\u0000\u06ec\u06ea\u0001\u0000"+
		"\u0000\u0000\u06ec\u06ed\u0001\u0000\u0000\u0000\u06ed\u06ef\u0001\u0000"+
		"\u0000\u0000\u06ee\u06e8\u0001\u0000\u0000\u0000\u06ee\u06ef\u0001\u0000"+
		"\u0000\u0000\u06ef\u06f4\u0001\u0000\u0000\u0000\u06f0\u06f1\u0005\u0141"+
		"\u0000\u0000\u06f1\u06f5\u0003\u00d4j\u0000\u06f2\u06f5\u0005\u0159\u0000"+
		"\u0000\u06f3\u06f5\u0005\u0147\u0000\u0000\u06f4\u06f0\u0001\u0000\u0000"+
		"\u0000\u06f4\u06f2\u0001\u0000\u0000\u0000\u06f4\u06f3\u0001\u0000\u0000"+
		"\u0000\u06f4\u06f5\u0001\u0000\u0000\u0000\u06f5\u00d3\u0001\u0000\u0000"+
		"\u0000\u06f6\u06f7\u0003\u010e\u0087\u0000\u06f7\u06f8\u0005\u00ef\u0000"+
		"\u0000\u06f8\u00d5\u0001\u0000\u0000\u0000\u06f9\u06fb\u0003\u00d4j\u0000"+
		"\u06fa\u06f9\u0001\u0000\u0000\u0000\u06fa\u06fb\u0001\u0000\u0000\u0000"+
		"\u06fb\u06fc\u0001\u0000\u0000\u0000\u06fc\u06fe\u0003\u00ceg\u0000\u06fd"+
		"\u06ff\u0003\u00d0h\u0000\u06fe\u06fd\u0001\u0000\u0000\u0000\u06fe\u06ff"+
		"\u0001\u0000\u0000\u0000\u06ff\u0701\u0001\u0000\u0000\u0000\u0700\u0702"+
		"\u0003\u00d2i\u0000\u0701\u0700\u0001\u0000\u0000\u0000\u0701\u0702\u0001"+
		"\u0000\u0000\u0000\u0702\u00d7\u0001\u0000\u0000\u0000\u0703\u0705\u0005"+
		"\u0146\u0000\u0000\u0704\u0706\u0003\u00d6k\u0000\u0705\u0704\u0001\u0000"+
		"\u0000\u0000\u0706\u0707\u0001\u0000\u0000\u0000\u0707\u0705\u0001\u0000"+
		"\u0000\u0000\u0707\u0708\u0001\u0000\u0000\u0000\u0708\u0710\u0001\u0000"+
		"\u0000\u0000\u0709\u070a\u0005)\u0000\u0000\u070a\u070c\u0005\u0140\u0000"+
		"\u0000\u070b\u070d\u0003\u00d6k\u0000\u070c\u070b\u0001\u0000\u0000\u0000"+
		"\u070d\u070e\u0001\u0000\u0000\u0000\u070e\u070c\u0001\u0000\u0000\u0000"+
		"\u070e\u070f\u0001\u0000\u0000\u0000\u070f\u0711\u0001\u0000\u0000\u0000"+
		"\u0710\u0709\u0001\u0000\u0000\u0000\u0710\u0711\u0001\u0000\u0000\u0000"+
		"\u0711\u0712\u0001\u0000\u0000\u0000\u0712\u0713\u0005\u0012\u0000\u0000"+
		"\u0713\u00d9\u0001\u0000\u0000\u0000\u0714\u0715\u0005=\u0000\u0000\u0715"+
		"\u0716\u0003\u010e\u0087\u0000\u0716\u00db\u0001\u0000\u0000\u0000\u0717"+
		"\u0718\u0005\u00af\u0000\u0000\u0718\u0719\u0003\u00deo\u0000\u0719\u00dd"+
		"\u0001\u0000\u0000\u0000\u071a\u071b\u0003\u010e\u0087\u0000\u071b\u00df"+
		"\u0001\u0000\u0000\u0000\u071c\u0721\u0003\u00e2q\u0000\u071d\u0721\u0003"+
		"\u00e8t\u0000\u071e\u0721\u0003\u00f0x\u0000\u071f\u0721\u0003\u00f6{"+
		"\u0000\u0720\u071c\u0001\u0000\u0000\u0000\u0720\u071d\u0001\u0000\u0000"+
		"\u0000\u0720\u071e\u0001\u0000\u0000\u0000\u0720\u071f\u0001\u0000\u0000"+
		"\u0000\u0721\u00e1\u0001\u0000\u0000\u0000\u0722\u0723\u0005\u0096\u0000"+
		"\u0000\u0723\u0724\u0005R\u0000\u0000\u0724\u0725\u0005\u009d\u0000\u0000"+
		"\u0725\u0726\u0005\u00f8\u0000\u0000\u0726\u0727\u0003\u028c\u0146\u0000"+
		"\u0727\u0728\u0005\u00f9\u0000\u0000\u0728\u0729\u0005\u00f8\u0000\u0000"+
		"\u0729\u072a\u0003\u00e4r\u0000\u072a\u072b\u0005\u00f9\u0000\u0000\u072b"+
		"\u00e3\u0001\u0000\u0000\u0000\u072c\u0731\u0003\u00e6s\u0000\u072d\u072e"+
		"\u0005\u00f1\u0000\u0000\u072e\u0730\u0003\u00e6s\u0000\u072f\u072d\u0001"+
		"\u0000\u0000\u0000\u0730\u0733\u0001\u0000\u0000\u0000\u0731\u072f\u0001"+
		"\u0000\u0000\u0000\u0731\u0732\u0001\u0000\u0000\u0000\u0732\u00e5\u0001"+
		"\u0000\u0000\u0000\u0733\u0731\u0001\u0000\u0000\u0000\u0734\u0735\u0005"+
		"\u0096\u0000\u0000\u0735\u0736\u0003\u00f8|\u0000\u0736\u0737\u0005\u00ba"+
		"\u0000\u0000\u0737\u0738\u0005\u0086\u0000\u0000\u0738\u0744\u0005\u00b0"+
		"\u0000\u0000\u0739\u073a\u0005\u00f8\u0000\u0000\u073a\u073b\u0003\u017e"+
		"\u00bf\u0000\u073b\u073c\u0005\u00f9\u0000\u0000\u073c\u0745\u0001\u0000"+
		"\u0000\u0000\u073d\u073f\u0005\u00f8\u0000\u0000\u073e\u073d\u0001\u0000"+
		"\u0000\u0000\u073e\u073f\u0001\u0000\u0000\u0000\u073f\u0740\u0001\u0000"+
		"\u0000\u0000\u0740\u0742\u0005\u008a\u0000\u0000\u0741\u0743\u0005\u00f9"+
		"\u0000\u0000\u0742\u0741\u0001\u0000\u0000\u0000\u0742\u0743\u0001\u0000"+
		"\u0000\u0000\u0743\u0745\u0001\u0000\u0000\u0000\u0744\u0739\u0001\u0000"+
		"\u0000\u0000\u0744\u073e\u0001\u0000\u0000\u0000\u0745\u00e7\u0001\u0000"+
		"\u0000\u0000\u0746\u0747\u0005\u0096\u0000\u0000\u0747\u0748\u0005R\u0000"+
		"\u0000\u0748\u0749\u0005z\u0000\u0000\u0749\u074a\u0005\u00f8\u0000\u0000"+
		"\u074a\u074b\u0003\u028c\u0146\u0000\u074b\u0751\u0005\u00f9\u0000\u0000"+
		"\u074c\u074d\u0005\u00f8\u0000\u0000\u074d\u074e\u0003\u00eau\u0000\u074e"+
		"\u074f\u0005\u00f9\u0000\u0000\u074f\u0752\u0001\u0000\u0000\u0000\u0750"+
		"\u0752\u0003\u00eew\u0000\u0751\u074c\u0001\u0000\u0000\u0000\u0751\u0750"+
		"\u0001\u0000\u0000\u0000\u0752\u00e9\u0001\u0000\u0000\u0000\u0753\u0758"+
		"\u0003\u00ecv\u0000\u0754\u0755\u0005\u00f1\u0000\u0000\u0755\u0757\u0003"+
		"\u00ecv\u0000\u0756\u0754\u0001\u0000\u0000\u0000\u0757\u075a\u0001\u0000"+
		"\u0000\u0000\u0758\u0756\u0001\u0000\u0000\u0000\u0758\u0759\u0001\u0000"+
		"\u0000\u0000\u0759\u00eb\u0001\u0000\u0000\u0000\u075a\u0758\u0001\u0000"+
		"\u0000\u0000\u075b\u075c\u0005\u0096\u0000\u0000\u075c\u075d\u0003\u00f8"+
		"|\u0000\u075d\u00ed\u0001\u0000\u0000\u0000\u075e\u075f\u0005\u0097\u0000"+
		"\u0000\u075f\u0760\u0003\u0182\u00c1\u0000\u0760\u00ef\u0001\u0000\u0000"+
		"\u0000\u0761\u0762\u0005\u0096\u0000\u0000\u0762\u0763\u0005R\u0000\u0000"+
		"\u0763\u0764\u0005\u0087\u0000\u0000\u0764\u0765\u0005\u00f8\u0000\u0000"+
		"\u0765\u0766\u0003\u028c\u0146\u0000\u0766\u0767\u0005\u00f9\u0000\u0000"+
		"\u0767\u0768\u0005\u00f8\u0000\u0000\u0768\u0769\u0003\u00f2y\u0000\u0769"+
		"\u076a\u0005\u00f9\u0000\u0000\u076a\u00f1\u0001\u0000\u0000\u0000\u076b"+
		"\u0770\u0003\u00f4z\u0000\u076c\u076d\u0005\u00f1\u0000\u0000\u076d\u076f"+
		"\u0003\u00f4z\u0000\u076e\u076c\u0001\u0000\u0000\u0000\u076f\u0772\u0001"+
		"\u0000\u0000\u0000\u0770\u076e\u0001\u0000\u0000\u0000\u0770\u0771\u0001"+
		"\u0000\u0000\u0000\u0771\u00f3\u0001\u0000\u0000\u0000\u0772\u0770\u0001"+
		"\u0000\u0000\u0000\u0773\u0774\u0005\u0096\u0000\u0000\u0774\u0775\u0003"+
		"\u00f8|\u0000\u0775\u0777\u0005\u00ba\u0000\u0000\u0776\u0778\u0005\u001b"+
		"\u0000\u0000\u0777\u0776\u0001\u0000\u0000\u0000\u0777\u0778\u0001\u0000"+
		"\u0000\u0000\u0778\u0779\u0001\u0000\u0000\u0000\u0779\u077a\u0005\u00f8"+
		"\u0000\u0000\u077a\u077b\u0003\u02ae\u0157\u0000\u077b\u077c\u0005\u00f9"+
		"\u0000\u0000\u077c\u00f5\u0001\u0000\u0000\u0000\u077d\u077e\u0005\u0096"+
		"\u0000\u0000\u077e\u077f\u0005R\u0000\u0000\u077f\u0780\u0005Y\u0000\u0000"+
		"\u0780\u0781\u0003x<\u0000\u0781\u00f7\u0001\u0000\u0000\u0000\u0782\u0783"+
		"\u0003\u010e\u0087\u0000\u0783\u00f9\u0001\u0000\u0000\u0000\u0784\u0786"+
		"\u0005\u00b7\u0000\u0000\u0785\u0787\u00057\u0000\u0000\u0786\u0785\u0001"+
		"\u0000\u0000\u0000\u0786\u0787\u0001\u0000\u0000\u0000\u0787\u0788\u0001"+
		"\u0000\u0000\u0000\u0788\u078d\u0003\u0272\u0139\u0000\u0789\u078a\u0005"+
		"\u00f1\u0000\u0000\u078a\u078c\u0003\u0272\u0139\u0000\u078b\u0789\u0001"+
		"\u0000\u0000\u0000\u078c\u078f\u0001\u0000\u0000\u0000\u078d\u078b\u0001"+
		"\u0000\u0000\u0000\u078d\u078e\u0001\u0000\u0000\u0000\u078e\u00fb\u0001"+
		"\u0000\u0000\u0000\u078f\u078d\u0001\u0000\u0000\u0000\u0790\u0791\u0003"+
		"\u010e\u0087\u0000\u0791\u0792\u0005\u00ee\u0000\u0000\u0792\u0793\u0005"+
		"\u016c\u0000\u0000\u0793\u0799\u0001\u0000\u0000\u0000\u0794\u0795\u0003"+
		"\u010e\u0087\u0000\u0795\u0796\u0005\u00ee\u0000\u0000\u0796\u0797\u0005"+
		"\u016d\u0000\u0000\u0797\u0799\u0001\u0000\u0000\u0000\u0798\u0790\u0001"+
		"\u0000\u0000\u0000\u0798\u0794\u0001\u0000\u0000\u0000\u0799\u00fd\u0001"+
		"\u0000\u0000\u0000\u079a\u079b\u0005\u0105\u0000\u0000\u079b\u07a7\u0003"+
		"\u010e\u0087\u0000\u079c\u079d\u0005\u00f8\u0000\u0000\u079d\u07a2\u0003"+
		"\u00fc~\u0000\u079e\u079f\u0005\u00f1\u0000\u0000\u079f\u07a1\u0003\u00fc"+
		"~\u0000\u07a0\u079e\u0001\u0000\u0000\u0000\u07a1\u07a4\u0001\u0000\u0000"+
		"\u0000\u07a2\u07a0\u0001\u0000\u0000\u0000\u07a2\u07a3\u0001\u0000\u0000"+
		"\u0000\u07a3\u07a5\u0001\u0000\u0000\u0000\u07a4\u07a2\u0001\u0000\u0000"+
		"\u0000\u07a5\u07a6\u0005\u00f9\u0000\u0000\u07a6\u07a8\u0001\u0000\u0000"+
		"\u0000\u07a7\u079c\u0001\u0000\u0000\u0000\u07a7\u07a8\u0001\u0000\u0000"+
		"\u0000\u07a8\u00ff\u0001\u0000\u0000\u0000\u07a9\u07aa\u0005\u00b7\u0000"+
		"\u0000\u07aa\u07ac\u0005%\u0000\u0000\u07ab\u07ad\u0003\u001a\r\u0000"+
		"\u07ac\u07ab\u0001\u0000\u0000\u0000\u07ac\u07ad\u0001\u0000\u0000\u0000"+
		"\u07ad\u07ae\u0001\u0000\u0000\u0000\u07ae\u07af\u0003\u0278\u013c\u0000"+
		"\u07af\u0101\u0001\u0000\u0000\u0000\u07b0\u07b1\u0005\u00b7\u0000\u0000"+
		"\u07b1\u07b2\u00052\u0000\u0000\u07b2\u07b4\u0005%\u0000\u0000\u07b3\u07b5"+
		"\u0003\u001a\r\u0000\u07b4\u07b3\u0001\u0000\u0000\u0000\u07b4\u07b5\u0001"+
		"\u0000\u0000\u0000\u07b5\u07b6\u0001\u0000\u0000\u0000\u07b6\u07b7\u0003"+
		"\u0278\u013c\u0000\u07b7\u0103\u0001\u0000\u0000\u0000\u07b8\u07b9\u0005"+
		"j\u0000\u0000\u07b9\u07bb\u0007\u0002\u0000\u0000\u07ba\u07bc\u0003\u001a"+
		"\r\u0000\u07bb\u07ba\u0001\u0000\u0000\u0000\u07bb\u07bc\u0001\u0000\u0000"+
		"\u0000\u07bc\u07bd\u0001\u0000\u0000\u0000\u07bd\u07bf\u0003\u0272\u0139"+
		"\u0000\u07be\u07c0\u0005\u009b\u0000\u0000\u07bf\u07be\u0001\u0000\u0000"+
		"\u0000\u07bf\u07c0\u0001\u0000\u0000\u0000\u07c0\u0105\u0001\u0000\u0000"+
		"\u0000\u07c1\u07c2\u0005j\u0000\u0000\u07c2\u07c4\u0005%\u0000\u0000\u07c3"+
		"\u07c5\u0003\u001a\r\u0000\u07c4\u07c3\u0001\u0000\u0000\u0000\u07c4\u07c5"+
		"\u0001\u0000\u0000\u0000\u07c5\u07c6\u0001\u0000\u0000\u0000\u07c6\u07c8"+
		"\u0003\u0278\u013c\u0000\u07c7\u07c9\u0005S\u0000\u0000\u07c8\u07c7\u0001"+
		"\u0000\u0000\u0000\u07c8\u07c9\u0001\u0000\u0000\u0000\u07c9\u0107\u0001"+
		"\u0000\u0000\u0000\u07ca\u07cb\u0005j\u0000\u0000\u07cb\u07cc\u00052\u0000"+
		"\u0000\u07cc\u07ce\u0005%\u0000\u0000\u07cd\u07cf\u0003\u001a\r\u0000"+
		"\u07ce\u07cd\u0001\u0000\u0000\u0000\u07ce\u07cf\u0001\u0000\u0000\u0000"+
		"\u07cf\u07d0\u0001\u0000\u0000\u0000\u07d0\u07d2\u0003\u0278\u013c\u0000"+
		"\u07d1\u07d3\u0005S\u0000\u0000\u07d2\u07d1\u0001\u0000\u0000\u0000\u07d2"+
		"\u07d3\u0001\u0000\u0000\u0000\u07d3\u0109\u0001\u0000\u0000\u0000\u07d4"+
		"\u07d5\u0005j\u0000\u0000\u07d5\u07d7\u0005.\u0000\u0000\u07d6\u07d8\u0003"+
		"\u001a\r\u0000\u07d7\u07d6\u0001\u0000\u0000\u0000\u07d7\u07d8\u0001\u0000"+
		"\u0000\u0000\u07d8\u07d9\u0001\u0000\u0000\u0000\u07d9\u07da\u0003\u0278"+
		"\u013c\u0000\u07da\u010b\u0001\u0000\u0000\u0000\u07db\u07dc\u0007\u0006"+
		"\u0000\u0000\u07dc\u010d\u0001\u0000\u0000\u0000\u07dd\u07e1\u0005\u016b"+
		"\u0000\u0000\u07de\u07e1\u0005\u016c\u0000\u0000\u07df\u07e1\u0003\u010c"+
		"\u0086\u0000\u07e0\u07dd\u0001\u0000\u0000\u0000\u07e0\u07de\u0001\u0000"+
		"\u0000\u0000\u07e0\u07df\u0001\u0000\u0000\u0000\u07e1\u010f\u0001\u0000"+
		"\u0000\u0000\u07e2\u07e5\u0003\u0148\u00a4\u0000\u07e3\u07e5\u0003\u0112"+
		"\u0089\u0000\u07e4\u07e2\u0001\u0000\u0000\u0000\u07e4\u07e3\u0001\u0000"+
		"\u0000\u0000\u07e5\u0111\u0001\u0000\u0000\u0000\u07e6\u07eb\u0005\u016d"+
		"\u0000\u0000\u07e7\u07eb\u0003\u0114\u008a\u0000\u07e8\u07eb\u0003\u011e"+
		"\u008f\u0000\u07e9\u07eb\u0003\u01ce\u00e7\u0000\u07ea\u07e6\u0001\u0000"+
		"\u0000\u0000\u07ea\u07e7\u0001\u0000\u0000\u0000\u07ea\u07e8\u0001\u0000"+
		"\u0000\u0000\u07ea\u07e9\u0001\u0000\u0000\u0000\u07eb\u0113\u0001\u0000"+
		"\u0000\u0000\u07ec\u07f1\u0003\u0118\u008c\u0000\u07ed\u07f1\u0003\u0116"+
		"\u008b\u0000\u07ee\u07f1\u0003\u011a\u008d\u0000\u07ef\u07f1\u0003\u011c"+
		"\u008e\u0000\u07f0\u07ec\u0001\u0000\u0000\u0000\u07f0\u07ed\u0001\u0000"+
		"\u0000\u0000\u07f0\u07ee\u0001\u0000\u0000\u0000\u07f0\u07ef\u0001\u0000"+
		"\u0000\u0000\u07f1\u0115\u0001\u0000\u0000\u0000\u07f2\u07f3\u0005\u00de"+
		"\u0000\u0000\u07f3\u07f4\u0005\u016d\u0000\u0000\u07f4\u0117\u0001\u0000"+
		"\u0000\u0000\u07f5\u07f6\u0005\u00e0\u0000\u0000\u07f6\u07f7\u0005\u016d"+
		"\u0000\u0000\u07f7\u0119\u0001\u0000\u0000\u0000\u07f8\u07f9\u0005\u00dc"+
		"\u0000\u0000\u07f9\u07fa\u0005\u016d\u0000\u0000\u07fa\u011b\u0001\u0000"+
		"\u0000\u0000\u07fb\u07fc\u0005\u00dd\u0000\u0000\u07fc\u07fd\u0005\u016d"+
		"\u0000\u0000\u07fd\u011d\u0001\u0000\u0000\u0000\u07fe\u07ff\u0007\u0007"+
		"\u0000\u0000\u07ff\u011f\u0001\u0000\u0000\u0000\u0800\u0803\u0003\u0122"+
		"\u0091\u0000\u0801\u0803\u0003\u0124\u0092\u0000\u0802\u0800\u0001\u0000"+
		"\u0000\u0000\u0802\u0801\u0001\u0000\u0000\u0000\u0803\u0121\u0001\u0000"+
		"\u0000\u0000\u0804\u080e\u0003\u0128\u0094\u0000\u0805\u080e\u0003\u012c"+
		"\u0096\u0000\u0806\u080e\u0003\u012e\u0097\u0000\u0807\u080e\u0003\u0130"+
		"\u0098\u0000\u0808\u080e\u0003\u0138\u009c\u0000\u0809\u080e\u0003\u013a"+
		"\u009d\u0000\u080a\u080e\u0003\u013c\u009e\u0000\u080b\u080e\u0003\u013e"+
		"\u009f\u0000\u080c\u080e\u0003\u0126\u0093\u0000\u080d\u0804\u0001\u0000"+
		"\u0000\u0000\u080d\u0805\u0001\u0000\u0000\u0000\u080d\u0806\u0001\u0000"+
		"\u0000\u0000\u080d\u0807\u0001\u0000\u0000\u0000\u080d\u0808\u0001\u0000"+
		"\u0000\u0000\u080d\u0809\u0001\u0000\u0000\u0000\u080d\u080a\u0001\u0000"+
		"\u0000\u0000\u080d\u080b\u0001\u0000\u0000\u0000\u080d\u080c\u0001\u0000"+
		"\u0000\u0000\u080e\u0123\u0001\u0000\u0000\u0000\u080f\u0811\u0007\b\u0000"+
		"\u0000\u0810\u0812\u0003\u0136\u009b\u0000\u0811\u0810\u0001\u0000\u0000"+
		"\u0000\u0811\u0812\u0001\u0000\u0000\u0000\u0812\u0125\u0001\u0000\u0000"+
		"\u0000\u0813\u0814\u0005\u00e7\u0000\u0000\u0814\u0127\u0001\u0000\u0000"+
		"\u0000\u0815\u0817\u0005V\u0000\u0000\u0816\u0818\u0003\u012a\u0095\u0000"+
		"\u0817\u0816\u0001\u0000\u0000\u0000\u0817\u0818\u0001\u0000\u0000\u0000"+
		"\u0818\u083f\u0001\u0000\u0000\u0000\u0819\u081b\u0005\u00d6\u0000\u0000"+
		"\u081a\u081c\u0003\u012a\u0095\u0000\u081b\u081a\u0001\u0000\u0000\u0000"+
		"\u081b\u081c\u0001\u0000\u0000\u0000\u081c\u083f\u0001\u0000\u0000\u0000"+
		"\u081d\u081e\u0005V\u0000\u0000\u081e\u0820\u0005\u00bd\u0000\u0000\u081f"+
		"\u0821\u0003\u012a\u0095\u0000\u0820\u081f\u0001\u0000\u0000\u0000\u0820"+
		"\u0821\u0001\u0000\u0000\u0000\u0821\u083f\u0001\u0000\u0000\u0000\u0822"+
		"\u0823\u0005\u00d6\u0000\u0000\u0823\u0825\u0005\u00bd\u0000\u0000\u0824"+
		"\u0826\u0003\u012a\u0095\u0000\u0825\u0824\u0001\u0000\u0000\u0000\u0825"+
		"\u0826\u0001\u0000\u0000\u0000\u0826\u083f\u0001\u0000\u0000\u0000\u0827"+
		"\u0829\u0005\u00d8\u0000\u0000\u0828\u082a\u0003\u012a\u0095\u0000\u0829"+
		"\u0828\u0001\u0000\u0000\u0000\u0829\u082a\u0001\u0000\u0000\u0000\u082a"+
		"\u083f\u0001\u0000\u0000\u0000\u082b\u083f\u0005\u0157\u0000\u0000\u082c"+
		"\u082e\u0005\u00d7\u0000\u0000\u082d\u082f\u0003\u012a\u0095\u0000\u082e"+
		"\u082d\u0001\u0000\u0000\u0000\u082e\u082f\u0001\u0000\u0000\u0000\u082f"+
		"\u083f\u0001\u0000\u0000\u0000\u0830\u083f\u0005\u0158\u0000\u0000\u0831"+
		"\u0833\u0005_\u0000\u0000\u0832\u0834\u0003\u012a\u0095\u0000\u0833\u0832"+
		"\u0001\u0000\u0000\u0000\u0833\u0834\u0001\u0000\u0000\u0000\u0834\u083f"+
		"\u0001\u0000\u0000\u0000\u0835\u0837\u0005^\u0000\u0000\u0836\u0838\u0003"+
		"\u012a\u0095\u0000\u0837\u0836\u0001\u0000\u0000\u0000\u0837\u0838\u0001"+
		"\u0000\u0000\u0000\u0838\u083f\u0001\u0000\u0000\u0000\u0839\u083f\u0005"+
		"\u00e2\u0000\u0000\u083a\u083c\u0005\u00db\u0000\u0000\u083b\u083d\u0003"+
		"\u012a\u0095\u0000\u083c\u083b\u0001\u0000\u0000\u0000\u083c\u083d\u0001"+
		"\u0000\u0000\u0000\u083d\u083f\u0001\u0000\u0000\u0000\u083e\u0815\u0001"+
		"\u0000\u0000\u0000\u083e\u0819\u0001\u0000\u0000\u0000\u083e\u081d\u0001"+
		"\u0000\u0000\u0000\u083e\u0822\u0001\u0000\u0000\u0000\u083e\u0827\u0001"+
		"\u0000\u0000\u0000\u083e\u082b\u0001\u0000\u0000\u0000\u083e\u082c\u0001"+
		"\u0000\u0000\u0000\u083e\u0830\u0001\u0000\u0000\u0000\u083e\u0831\u0001"+
		"\u0000\u0000\u0000\u083e\u0835\u0001\u0000\u0000\u0000\u083e\u0839\u0001"+
		"\u0000\u0000\u0000\u083e\u083a\u0001\u0000\u0000\u0000\u083f\u0129\u0001"+
		"\u0000\u0000\u0000\u0840\u0841\u0005\u00f8\u0000\u0000\u0841\u0842\u0005"+
		"\u0106\u0000\u0000\u0842\u0843\u0005\u00f9\u0000\u0000\u0843\u012b\u0001"+
		"\u0000\u0000\u0000\u0844\u0845\u0005\u0091\u0000\u0000\u0845\u0847\u0005"+
		"V\u0000\u0000\u0846\u0848\u0003\u012a\u0095\u0000\u0847\u0846\u0001\u0000"+
		"\u0000\u0000\u0847\u0848\u0001\u0000\u0000\u0000\u0848\u0868\u0001\u0000"+
		"\u0000\u0000\u0849\u084a\u0005\u0091\u0000\u0000\u084a\u084c\u0005\u00d6"+
		"\u0000\u0000\u084b\u084d\u0003\u012a\u0095\u0000\u084c\u084b\u0001\u0000"+
		"\u0000\u0000\u084c\u084d\u0001\u0000\u0000\u0000\u084d\u0868\u0001\u0000"+
		"\u0000\u0000\u084e\u0850\u0005\u00d9\u0000\u0000\u084f\u0851\u0003\u012a"+
		"\u0095\u0000\u0850\u084f\u0001\u0000\u0000\u0000\u0850\u0851\u0001\u0000"+
		"\u0000\u0000\u0851\u0868\u0001\u0000\u0000\u0000\u0852\u0853\u0005\u0091"+
		"\u0000\u0000\u0853\u0854\u0005V\u0000\u0000\u0854\u0856\u0005\u00bd\u0000"+
		"\u0000\u0855\u0857\u0003\u012a\u0095\u0000\u0856\u0855\u0001\u0000\u0000"+
		"\u0000\u0856\u0857\u0001\u0000\u0000\u0000\u0857\u0868\u0001\u0000\u0000"+
		"\u0000\u0858\u0859\u0005\u0091\u0000\u0000\u0859\u085a\u0005\u00d6\u0000"+
		"\u0000\u085a\u085c\u0005\u00bd\u0000\u0000\u085b\u085d\u0003\u012a\u0095"+
		"\u0000\u085c\u085b\u0001\u0000\u0000\u0000\u085c\u085d\u0001\u0000\u0000"+
		"\u0000\u085d\u0868\u0001\u0000\u0000\u0000\u085e\u085f\u0005\u00d9\u0000"+
		"\u0000\u085f\u0861\u0005\u00bd\u0000\u0000\u0860\u0862\u0003\u012a\u0095"+
		"\u0000\u0861\u0860\u0001\u0000\u0000\u0000\u0861\u0862\u0001\u0000\u0000"+
		"\u0000\u0862\u0868\u0001\u0000\u0000\u0000\u0863\u0865\u0005\u00da\u0000"+
		"\u0000\u0864\u0866\u0003\u012a\u0095\u0000\u0865\u0864\u0001\u0000\u0000"+
		"\u0000\u0865\u0866\u0001\u0000\u0000\u0000\u0866\u0868\u0001\u0000\u0000"+
		"\u0000\u0867\u0844\u0001\u0000\u0000\u0000\u0867\u0849\u0001\u0000\u0000"+
		"\u0000\u0867\u084e\u0001\u0000\u0000\u0000\u0867\u0852\u0001\u0000\u0000"+
		"\u0000\u0867\u0858\u0001\u0000\u0000\u0000\u0867\u085e\u0001\u0000\u0000"+
		"\u0000\u0867\u0863\u0001\u0000\u0000\u0000\u0868\u012d\u0001\u0000\u0000"+
		"\u0000\u0869\u086b\u0005\u00e5\u0000\u0000\u086a\u086c\u0003\u012a\u0095"+
		"\u0000\u086b\u086a\u0001\u0000\u0000\u0000\u086b\u086c\u0001\u0000\u0000"+
		"\u0000\u086c\u0872\u0001\u0000\u0000\u0000\u086d\u086f\u0005\u00e6\u0000"+
		"\u0000\u086e\u0870\u0003\u012a\u0095\u0000\u086f\u086e\u0001\u0000\u0000"+
		"\u0000\u086f\u0870\u0001\u0000\u0000\u0000\u0870\u0872\u0001\u0000\u0000"+
		"\u0000\u0871\u0869\u0001\u0000\u0000\u0000\u0871\u086d\u0001\u0000\u0000"+
		"\u0000\u0872\u012f\u0001\u0000\u0000\u0000\u0873\u0876\u0003\u0132\u0099"+
		"\u0000\u0874\u0876\u0003\u0134\u009a\u0000\u0875\u0873\u0001\u0000\u0000"+
		"\u0000\u0875\u0874\u0001\u0000\u0000\u0000\u0876\u0131\u0001\u0000\u0000"+
		"\u0000\u0877\u0879\u0005\u00d3\u0000\u0000\u0878\u087a\u0003\u0136\u009b"+
		"\u0000\u0879\u0878\u0001\u0000\u0000\u0000\u0879\u087a\u0001\u0000\u0000"+
		"\u0000\u087a\u0895\u0001\u0000\u0000\u0000\u087b\u087d\u0005\u00d4\u0000"+
		"\u0000\u087c\u087e\u0003\u0136\u009b\u0000\u087d\u087c\u0001\u0000\u0000"+
		"\u0000\u087d\u087e\u0001\u0000\u0000\u0000\u087e\u0895\u0001\u0000\u0000"+
		"\u0000\u087f\u0881\u0005\u00d5\u0000\u0000\u0880\u0882\u0003\u0136\u009b"+
		"\u0000\u0881\u0880\u0001\u0000\u0000\u0000\u0881\u0882\u0001\u0000\u0000"+
		"\u0000\u0882\u0895\u0001\u0000\u0000\u0000\u0883\u0885\u0005e\u0000\u0000"+
		"\u0884\u0886\u0003\u0136\u009b\u0000\u0885\u0884\u0001\u0000\u0000\u0000"+
		"\u0885\u0886\u0001\u0000\u0000\u0000\u0886\u0895\u0001\u0000\u0000\u0000";
	private static final String _serializedATNSegment1 =
		"\u0887\u0895\u0005\u00c5\u0000\u0000\u0888\u0895\u0005\u00c9\u0000\u0000"+
		"\u0889\u0895\u0005\u00c6\u0000\u0000\u088a\u0895\u0005\u00ca\u0000\u0000"+
		"\u088b\u0895\u0005\u00c7\u0000\u0000\u088c\u0895\u0005\u00cb\u0000\u0000"+
		"\u088d\u0895\u0005\u00cc\u0000\u0000\u088e\u0895\u0005\u00c8\u0000\u0000"+
		"\u088f\u0895\u0005\u00cd\u0000\u0000\u0890\u0891\u0005`\u0000\u0000\u0891"+
		"\u0895\u0003\u0136\u009b\u0000\u0892\u0893\u0005a\u0000\u0000\u0893\u0895"+
		"\u0003\u0136\u009b\u0000\u0894\u0877\u0001\u0000\u0000\u0000\u0894\u087b"+
		"\u0001\u0000\u0000\u0000\u0894\u087f\u0001\u0000\u0000\u0000\u0894\u0883"+
		"\u0001\u0000\u0000\u0000\u0894\u0887\u0001\u0000\u0000\u0000\u0894\u0888"+
		"\u0001\u0000\u0000\u0000\u0894\u0889\u0001\u0000\u0000\u0000\u0894\u088a"+
		"\u0001\u0000\u0000\u0000\u0894\u088b\u0001\u0000\u0000\u0000\u0894\u088c"+
		"\u0001\u0000\u0000\u0000\u0894\u088d\u0001\u0000\u0000\u0000\u0894\u088e"+
		"\u0001\u0000\u0000\u0000\u0894\u088f\u0001\u0000\u0000\u0000\u0894\u0890"+
		"\u0001\u0000\u0000\u0000\u0894\u0892\u0001\u0000\u0000\u0000\u0895\u0133"+
		"\u0001\u0000\u0000\u0000\u0896\u0898\u0005\u00d1\u0000\u0000\u0897\u0899"+
		"\u0003\u0136\u009b\u0000\u0898\u0897\u0001\u0000\u0000\u0000\u0898\u0899"+
		"\u0001\u0000\u0000\u0000\u0899\u08a1\u0001\u0000\u0000\u0000\u089a\u08a1"+
		"\u0005\u00ce\u0000\u0000\u089b\u08a1\u0005\u00d0\u0000\u0000\u089c\u08a1"+
		"\u0005\u00cf\u0000\u0000\u089d\u08a1\u0005\u00d2\u0000\u0000\u089e\u089f"+
		"\u0005\u00d2\u0000\u0000\u089f\u08a1\u0005\u009a\u0000\u0000\u08a0\u0896"+
		"\u0001\u0000\u0000\u0000\u08a0\u089a\u0001\u0000\u0000\u0000\u08a0\u089b"+
		"\u0001\u0000\u0000\u0000\u08a0\u089c\u0001\u0000\u0000\u0000\u08a0\u089d"+
		"\u0001\u0000\u0000\u0000\u08a0\u089e\u0001\u0000\u0000\u0000\u08a1\u0135"+
		"\u0001\u0000\u0000\u0000\u08a2\u08a3\u0005\u00f8\u0000\u0000\u08a3\u08a4"+
		"\u0005\u0106\u0000\u0000\u08a4\u08ab\u0005\u00f9\u0000\u0000\u08a5\u08a6"+
		"\u0005\u00f8\u0000\u0000\u08a6\u08a7\u0005\u0106\u0000\u0000\u08a7\u08a8"+
		"\u0005\u00f1\u0000\u0000\u08a8\u08a9\u0005\u0106\u0000\u0000\u08a9\u08ab"+
		"\u0005\u00f9\u0000\u0000\u08aa\u08a2\u0001\u0000\u0000\u0000\u08aa\u08a5"+
		"\u0001\u0000\u0000\u0000\u08ab\u0137\u0001\u0000\u0000\u0000\u08ac\u08ad"+
		"\u0007\t\u0000\u0000\u08ad\u0139\u0001\u0000\u0000\u0000\u08ae\u08b0\u0005"+
		"\u00dc\u0000\u0000\u08af\u08b1\u0003\u012a\u0095\u0000\u08b0\u08af\u0001"+
		"\u0000\u0000\u0000\u08b0\u08b1\u0001\u0000\u0000\u0000\u08b1\u08c4\u0001"+
		"\u0000\u0000\u0000\u08b2\u08c4\u0005\u0156\u0000\u0000\u08b3\u08c4\u0005"+
		"\u00dd\u0000\u0000\u08b4\u08c4\u0005\u00de\u0000\u0000\u08b5\u08b6\u0005"+
		"\u00de\u0000\u0000\u08b6\u08b7\u0005@\u0000\u0000\u08b7\u08b8\u0005\u00de"+
		"\u0000\u0000\u08b8\u08c4\u0005\u00c0\u0000\u0000\u08b9\u08c4\u0005\u00df"+
		"\u0000\u0000\u08ba\u08bc\u0005\u00e0\u0000\u0000\u08bb\u08bd\u0003\u012a"+
		"\u0095\u0000\u08bc\u08bb\u0001\u0000\u0000\u0000\u08bc\u08bd\u0001\u0000"+
		"\u0000\u0000\u08bd\u08c4\u0001\u0000\u0000\u0000\u08be\u08bf\u0005\u00e0"+
		"\u0000\u0000\u08bf\u08c0\u0005@\u0000\u0000\u08c0\u08c1\u0005\u00de\u0000"+
		"\u0000\u08c1\u08c4\u0005\u00c0\u0000\u0000\u08c2\u08c4\u0005\u00e1\u0000"+
		"\u0000\u08c3\u08ae\u0001\u0000\u0000\u0000\u08c3\u08b2\u0001\u0000\u0000"+
		"\u0000\u08c3\u08b3\u0001\u0000\u0000\u0000\u08c3\u08b4\u0001\u0000\u0000"+
		"\u0000\u08c3\u08b5\u0001\u0000\u0000\u0000\u08c3\u08b9\u0001\u0000\u0000"+
		"\u0000\u08c3\u08ba\u0001\u0000\u0000\u0000\u08c3\u08be\u0001\u0000\u0000"+
		"\u0000\u08c3\u08c2\u0001\u0000\u0000\u0000\u08c4\u013b\u0001\u0000\u0000"+
		"\u0000\u08c5\u08c7\u0005\u00c3\u0000\u0000\u08c6\u08c8\u0003\u012a\u0095"+
		"\u0000\u08c7\u08c6\u0001\u0000\u0000\u0000\u08c7\u08c8\u0001\u0000\u0000"+
		"\u0000\u08c8\u08d3\u0001\u0000\u0000\u0000\u08c9\u08cb\u0005\u00c4\u0000"+
		"\u0000\u08ca\u08cc\u0003\u012a\u0095\u0000\u08cb\u08ca\u0001\u0000\u0000"+
		"\u0000\u08cb\u08cc\u0001\u0000\u0000\u0000\u08cc\u08d3\u0001\u0000\u0000"+
		"\u0000\u08cd\u08ce\u0005\u00c3\u0000\u0000\u08ce\u08d0\u0005\u00bd\u0000"+
		"\u0000\u08cf\u08d1\u0003\u012a\u0095\u0000\u08d0\u08cf\u0001\u0000\u0000"+
		"\u0000\u08d0\u08d1\u0001\u0000\u0000\u0000\u08d1\u08d3\u0001\u0000\u0000"+
		"\u0000\u08d2\u08c5\u0001\u0000\u0000\u0000\u08d2\u08c9\u0001\u0000\u0000"+
		"\u0000\u08d2\u08cd\u0001\u0000\u0000\u0000\u08d3\u013d\u0001\u0000\u0000"+
		"\u0000\u08d4\u08d6\u0005\u00e3\u0000\u0000\u08d5\u08d7\u0003\u012a\u0095"+
		"\u0000\u08d6\u08d5\u0001\u0000\u0000\u0000\u08d6\u08d7\u0001\u0000\u0000"+
		"\u0000\u08d7\u08e2\u0001\u0000\u0000\u0000\u08d8\u08d9\u0005\u00e3\u0000"+
		"\u0000\u08d9\u08db\u0005\u00bd\u0000\u0000\u08da\u08dc\u0003\u012a\u0095"+
		"\u0000\u08db\u08da\u0001\u0000\u0000\u0000\u08db\u08dc\u0001\u0000\u0000"+
		"\u0000\u08dc\u08e2\u0001\u0000\u0000\u0000\u08dd\u08df\u0005\u00e4\u0000"+
		"\u0000\u08de\u08e0\u0003\u012a\u0095\u0000\u08df\u08de\u0001\u0000\u0000"+
		"\u0000\u08df\u08e0\u0001\u0000\u0000\u0000\u08e0\u08e2\u0001\u0000\u0000"+
		"\u0000\u08e1\u08d4\u0001\u0000\u0000\u0000\u08e1\u08d8\u0001\u0000\u0000"+
		"\u0000\u08e1\u08dd\u0001\u0000\u0000\u0000\u08e2\u013f\u0001\u0000\u0000"+
		"\u0000\u08e3\u08e6\u0003\u0142\u00a1\u0000\u08e4\u08e6\u0003\u0144\u00a2"+
		"\u0000\u08e5\u08e3\u0001\u0000\u0000\u0000\u08e5\u08e4\u0001\u0000\u0000"+
		"\u0000\u08e6\u0141\u0001\u0000\u0000\u0000\u08e7\u08e8\u0005\u00f8\u0000"+
		"\u0000\u08e8\u08e9\u0003\u017e\u00bf\u0000\u08e9\u08ea\u0005\u00f9\u0000"+
		"\u0000\u08ea\u0143\u0001\u0000\u0000\u0000\u08eb\u08f8\u0003\u0146\u00a3"+
		"\u0000\u08ec\u08f8\u0003\u0288\u0144\u0000\u08ed\u08f8\u0003\u014c\u00a6"+
		"\u0000\u08ee\u08f8\u0003\u015a\u00ad\u0000\u08ef\u08f8\u0003\u0158\u00ac"+
		"\u0000\u08f0\u08f8\u0003\u0164\u00b2\u0000\u08f1\u08f8\u0003\u0166\u00b3"+
		"\u0000\u08f2\u08f8\u0003\u0176\u00bb\u0000\u08f3\u08f8\u0003\u017c\u00be"+
		"\u0000\u08f4\u08f8\u0003\u02c4\u0162\u0000\u08f5\u08f8\u0003\u0290\u0148"+
		"\u0000\u08f6\u08f8\u0003\u028e\u0147\u0000\u08f7\u08eb\u0001\u0000\u0000"+
		"\u0000\u08f7\u08ec\u0001\u0000\u0000\u0000\u08f7\u08ed\u0001\u0000\u0000"+
		"\u0000\u08f7\u08ee\u0001\u0000\u0000\u0000\u08f7\u08ef\u0001\u0000\u0000"+
		"\u0000\u08f7\u08f0\u0001\u0000\u0000\u0000\u08f7\u08f1\u0001\u0000\u0000"+
		"\u0000\u08f7\u08f2\u0001\u0000\u0000\u0000\u08f7\u08f3\u0001\u0000\u0000"+
		"\u0000\u08f7\u08f4\u0001\u0000\u0000\u0000\u08f7\u08f5\u0001\u0000\u0000"+
		"\u0000\u08f7\u08f6\u0001\u0000\u0000\u0000\u08f8\u0145\u0001\u0000\u0000"+
		"\u0000\u08f9\u08fa\u0003\u0110\u0088\u0000\u08fa\u0147\u0001\u0000\u0000"+
		"\u0000\u08fb\u08fc\u0007\n\u0000\u0000\u08fc\u0149\u0001\u0000\u0000\u0000"+
		"\u08fd\u08ff\u0003\u018c\u00c6\u0000\u08fe\u08fd\u0001\u0000\u0000\u0000"+
		"\u08fe\u08ff\u0001\u0000\u0000\u0000\u08ff\u0900\u0001\u0000\u0000\u0000"+
		"\u0900\u0901\u0003\u0148\u00a4\u0000\u0901\u014b\u0001\u0000\u0000\u0000"+
		"\u0902\u0903\u0003\u014e\u00a7\u0000\u0903\u014d\u0001\u0000\u0000\u0000"+
		"\u0904\u0905\u0005Z\u0000\u0000\u0905\u0906\u0005\u00f8\u0000\u0000\u0906"+
		"\u0907\u0005\u00fc\u0000\u0000\u0907\u090d\u0005\u00f9\u0000\u0000\u0908"+
		"\u090a\u0003\u0150\u00a8\u0000\u0909\u090b\u0003\u0154\u00aa\u0000\u090a"+
		"\u0909\u0001\u0000\u0000\u0000\u090a\u090b\u0001\u0000\u0000\u0000\u090b"+
		"\u090d\u0001\u0000\u0000\u0000\u090c\u0904\u0001\u0000\u0000\u0000\u090c"+
		"\u0908\u0001\u0000\u0000\u0000\u090d\u014f\u0001\u0000\u0000\u0000\u090e"+
		"\u090f\u0003\u0152\u00a9\u0000\u090f\u0911\u0005\u00f8\u0000\u0000\u0910"+
		"\u0912\u0003\u0286\u0143\u0000\u0911\u0910\u0001\u0000\u0000\u0000\u0911"+
		"\u0912\u0001\u0000\u0000\u0000\u0912\u0913\u0001\u0000\u0000\u0000\u0913"+
		"\u0914\u0003\u017e\u00bf\u0000\u0914\u0915\u0005\u00f9\u0000\u0000\u0915"+
		"\u0151\u0001\u0000\u0000\u0000\u0916\u0917\u0007\u000b\u0000\u0000\u0917"+
		"\u0153\u0001\u0000\u0000\u0000\u0918\u0919\u0005\u0160\u0000\u0000\u0919"+
		"\u091a\u0005\u00f8\u0000\u0000\u091a\u091b\u0005g\u0000\u0000\u091b\u091c"+
		"\u0007\f\u0000\u0000\u091c\u091d\u0003\u02d0\u0168\u0000\u091d\u091e\u0005"+
		"\u00f9\u0000\u0000\u091e\u0155\u0001\u0000\u0000\u0000\u091f\u0920\u0005"+
		"y\u0000\u0000\u0920\u0921\u0005\u00f8\u0000\u0000\u0921\u0922\u0003\u028c"+
		"\u0146\u0000\u0922\u0923\u0005\u00f9\u0000\u0000\u0923\u0157\u0001\u0000"+
		"\u0000\u0000\u0924\u0925\u0005\u0149\u0000\u0000\u0925\u0926\u0005\u00f8"+
		"\u0000\u0000\u0926\u0929\u0003\u017e\u00bf\u0000\u0927\u0928\u0005\u00f1"+
		"\u0000\u0000\u0928\u092a\u0003\u017e\u00bf\u0000\u0929\u0927\u0001\u0000"+
		"\u0000\u0000\u0929\u092a\u0001\u0000\u0000\u0000\u092a\u092b\u0001\u0000"+
		"\u0000\u0000\u092b\u092c\u0005\u00f9\u0000\u0000\u092c\u092d\u0005\u014a"+
		"\u0000\u0000\u092d\u092e\u0005\u00f8\u0000\u0000\u092e\u092f\u0003\u02d0"+
		"\u0168\u0000\u092f\u0932\u0005\u00f9\u0000\u0000\u0930\u0931\u0005-\u0000"+
		"\u0000\u0931\u0933\u0003\u0162\u00b1\u0000\u0932\u0930\u0001\u0000\u0000"+
		"\u0000\u0932\u0933\u0001\u0000\u0000\u0000\u0933\u0159\u0001\u0000\u0000"+
		"\u0000\u0934\u0935\u0003\u015e\u00af\u0000\u0935\u0936\u0005-\u0000\u0000"+
		"\u0936\u0937\u0003\u0162\u00b1\u0000\u0937\u015b\u0001\u0000\u0000\u0000"+
		"\u0938\u0939\u0007\r\u0000\u0000\u0939\u015d\u0001\u0000\u0000\u0000\u093a"+
		"\u093b\u0003\u0160\u00b0\u0000\u093b\u093c\u0005\u00f8\u0000\u0000\u093c"+
		"\u093d\u0005\u00f9\u0000\u0000\u093d\u096d\u0001\u0000\u0000\u0000\u093e"+
		"\u093f\u0005\u00a6\u0000\u0000\u093f\u0940\u0005\u00f8\u0000\u0000\u0940"+
		"\u096d\u0005\u00f9\u0000\u0000\u0941\u096d\u0003\u014e\u00a7\u0000\u0942"+
		"\u0943\u0005t\u0000\u0000\u0943\u0944\u0005\u00f8\u0000\u0000\u0944\u0946"+
		"\u0003\u017e\u00bf\u0000\u0945\u0947\u0003\u015c\u00ae\u0000\u0946\u0945"+
		"\u0001\u0000\u0000\u0000\u0946\u0947\u0001\u0000\u0000\u0000\u0947\u0948"+
		"\u0001\u0000\u0000\u0000\u0948\u0949\u0005\u00f9\u0000\u0000\u0949\u096d"+
		"\u0001\u0000\u0000\u0000\u094a\u094b\u0005\u0084\u0000\u0000\u094b\u094c"+
		"\u0005\u00f8\u0000\u0000\u094c\u094e\u0003\u017e\u00bf\u0000\u094d\u094f"+
		"\u0003\u015c\u00ae\u0000\u094e\u094d\u0001\u0000\u0000\u0000\u094e\u094f"+
		"\u0001\u0000\u0000\u0000\u094f\u0950\u0001\u0000\u0000\u0000\u0950\u0951"+
		"\u0005\u00f9\u0000\u0000\u0951\u096d\u0001\u0000\u0000\u0000\u0952\u0953"+
		"\u0005\u0082\u0000\u0000\u0953\u0954\u0005\u00f8\u0000\u0000\u0954\u095b"+
		"\u0003\u017e\u00bf\u0000\u0955\u0956\u0005\u00f1\u0000\u0000\u0956\u0959"+
		"\u0003\u0182\u00c1\u0000\u0957\u0958\u0005\u00f1\u0000\u0000\u0958\u095a"+
		"\u0003\u0180\u00c0\u0000\u0959\u0957\u0001\u0000\u0000\u0000\u0959\u095a"+
		"\u0001\u0000\u0000\u0000\u095a\u095c\u0001\u0000\u0000\u0000\u095b\u0955"+
		"\u0001\u0000\u0000\u0000\u095b\u095c\u0001\u0000\u0000\u0000\u095c\u095d"+
		"\u0001\u0000\u0000\u0000\u095d\u095e\u0005\u00f9\u0000\u0000\u095e\u096d"+
		"\u0001\u0000\u0000\u0000\u095f\u0960\u0005\u0085\u0000\u0000\u0960\u0961"+
		"\u0005\u00f8\u0000\u0000\u0961\u0968\u0003\u017e\u00bf\u0000\u0962\u0963"+
		"\u0005\u00f1\u0000\u0000\u0963\u0966\u0003\u0182\u00c1\u0000\u0964\u0965"+
		"\u0005\u00f1\u0000\u0000\u0965\u0967\u0003\u0180\u00c0\u0000\u0966\u0964"+
		"\u0001\u0000\u0000\u0000\u0966\u0967\u0001\u0000\u0000\u0000\u0967\u0969"+
		"\u0001\u0000\u0000\u0000\u0968\u0962\u0001\u0000\u0000\u0000\u0968\u0969"+
		"\u0001\u0000\u0000\u0000\u0969\u096a\u0001\u0000\u0000\u0000\u096a\u096b"+
		"\u0005\u00f9\u0000\u0000\u096b\u096d\u0001\u0000\u0000\u0000\u096c\u093a"+
		"\u0001\u0000\u0000\u0000\u096c\u093e\u0001\u0000\u0000\u0000\u096c\u0941"+
		"\u0001\u0000\u0000\u0000\u096c\u0942\u0001\u0000\u0000\u0000\u096c\u094a"+
		"\u0001\u0000\u0000\u0000\u096c\u0952\u0001\u0000\u0000\u0000\u096c\u095f"+
		"\u0001\u0000\u0000\u0000\u096d\u015f\u0001\u0000\u0000\u0000\u096e\u096f"+
		"\u0007\u000e\u0000\u0000\u096f\u0161\u0001\u0000\u0000\u0000\u0970\u0973"+
		"\u0003\u0240\u0120\u0000\u0971\u0973\u0003\u0242\u0121\u0000\u0972\u0970"+
		"\u0001\u0000\u0000\u0000\u0972\u0971\u0001\u0000\u0000\u0000\u0973\u0163"+
		"\u0001\u0000\u0000\u0000\u0974\u0975\u0003\u0168\u00b4\u0000\u0975\u0165"+
		"\u0001\u0000\u0000\u0000\u0976\u0977\u0005\u0092\u0000\u0000\u0977\u0978"+
		"\u0005\u00f8\u0000\u0000\u0978\u0979\u0003\u017e\u00bf\u0000\u0979\u097a"+
		"\u0005\u00f1\u0000\u0000\u097a\u097b\u0003\u017e\u00bf\u0000\u097b\u097c"+
		"\u0005\u00f9\u0000\u0000\u097c\u0989\u0001\u0000\u0000\u0000\u097d\u097e"+
		"\u0005X\u0000\u0000\u097e\u097f\u0005\u00f8\u0000\u0000\u097f\u0982\u0003"+
		"\u017e\u00bf\u0000\u0980\u0981\u0005\u00f1\u0000\u0000\u0981\u0983\u0003"+
		"\u017e\u00bf\u0000\u0982\u0980\u0001\u0000\u0000\u0000\u0983\u0984\u0001"+
		"\u0000\u0000\u0000\u0984\u0982\u0001\u0000\u0000\u0000\u0984\u0985\u0001"+
		"\u0000\u0000\u0000\u0985\u0986\u0001\u0000\u0000\u0000\u0986\u0987\u0005"+
		"\u00f9\u0000\u0000\u0987\u0989\u0001\u0000\u0000\u0000\u0988\u0976\u0001"+
		"\u0000\u0000\u0000\u0988\u097d\u0001\u0000\u0000\u0000\u0989\u0167\u0001"+
		"\u0000\u0000\u0000\u098a\u098d\u0003\u016a\u00b5\u0000\u098b\u098d\u0003"+
		"\u016c\u00b6\u0000\u098c\u098a\u0001\u0000\u0000\u0000\u098c\u098b\u0001"+
		"\u0000\u0000\u0000\u098d\u0169\u0001\u0000\u0000\u0000\u098e\u098f\u0005"+
		"\b\u0000\u0000\u098f\u0991\u0003\u01b8\u00dc\u0000\u0990\u0992\u0003\u016e"+
		"\u00b7\u0000\u0991\u0990\u0001\u0000\u0000\u0000\u0992\u0993\u0001\u0000"+
		"\u0000\u0000\u0993\u0991\u0001\u0000\u0000\u0000\u0993\u0994\u0001\u0000"+
		"\u0000\u0000\u0994\u0996\u0001\u0000\u0000\u0000\u0995\u0997\u0003\u0172"+
		"\u00b9\u0000\u0996\u0995\u0001\u0000\u0000\u0000\u0996\u0997\u0001\u0000"+
		"\u0000\u0000\u0997\u0998\u0001\u0000\u0000\u0000\u0998\u0999\u0005\u0012"+
		"\u0000\u0000\u0999\u016b\u0001\u0000\u0000\u0000\u099a\u099c\u0005\b\u0000"+
		"\u0000\u099b\u099d\u0003\u0170\u00b8\u0000\u099c\u099b\u0001\u0000\u0000"+
		"\u0000\u099d\u099e\u0001\u0000\u0000\u0000\u099e\u099c\u0001\u0000\u0000"+
		"\u0000\u099e\u099f\u0001\u0000\u0000\u0000\u099f\u09a1\u0001\u0000\u0000"+
		"\u0000\u09a0\u09a2\u0003\u0172\u00b9\u0000\u09a1\u09a0\u0001\u0000\u0000"+
		"\u0000\u09a1\u09a2\u0001\u0000\u0000\u0000\u09a2\u09a3\u0001\u0000\u0000"+
		"\u0000\u09a3\u09a4\u0005\u0012\u0000\u0000\u09a4\u016d\u0001\u0000\u0000"+
		"\u0000\u09a5\u09a6\u0005>\u0000\u0000\u09a6\u09a7\u0003\u0224\u0112\u0000"+
		"\u09a7\u09a8\u00058\u0000\u0000\u09a8\u09a9\u0003\u0174\u00ba\u0000\u09a9"+
		"\u016f\u0001\u0000\u0000\u0000\u09aa\u09ab\u0005>\u0000\u0000\u09ab\u09ac"+
		"\u0003\u0224\u0112\u0000\u09ac\u09ad\u00058\u0000\u0000\u09ad\u09ae\u0003"+
		"\u0174\u00ba\u0000\u09ae\u0171\u0001\u0000\u0000\u0000\u09af\u09b0\u0005"+
		"\u0013\u0000\u0000\u09b0\u09b1\u0003\u0174\u00ba\u0000\u09b1\u0173\u0001"+
		"\u0000\u0000\u0000\u09b2\u09b5\u0003\u017e\u00bf\u0000\u09b3\u09b5\u0005"+
		"(\u0000\u0000\u09b4\u09b2\u0001\u0000\u0000\u0000\u09b4\u09b3\u0001\u0000"+
		"\u0000\u0000\u09b5\u0175\u0001\u0000\u0000\u0000\u09b6\u09b7\u0005\t\u0000"+
		"\u0000\u09b7\u09b8\u0005\u00f8\u0000\u0000\u09b8\u09b9\u0003\u0178\u00bc"+
		"\u0000\u09b9\u09ba\u0005\u0001\u0000\u0000\u09ba\u09bb\u0003\u017a\u00bd"+
		"\u0000\u09bb\u09bc\u0005\u00f9\u0000\u0000\u09bc\u0177\u0001\u0000\u0000"+
		"\u0000\u09bd\u09be\u0003\u017e\u00bf\u0000\u09be\u0179\u0001\u0000\u0000"+
		"\u0000\u09bf\u09c0\u0003\u0120\u0090\u0000\u09c0\u017b\u0001\u0000\u0000"+
		"\u0000\u09c1\u09c2\u0005\u0155\u0000\u0000\u09c2\u09c3\u0005\u00f8\u0000"+
		"\u0000\u09c3\u09c4\u0003\u017a\u00bd\u0000\u09c4\u09c5\u0005\u00f1\u0000"+
		"\u0000\u09c5\u09c8\u0003\u0178\u00bc\u0000\u09c6\u09c7\u0005\u00f1\u0000"+
		"\u0000\u09c7\u09c9\u0005\u0106\u0000\u0000\u09c8\u09c6\u0001\u0000\u0000"+
		"\u0000\u09c8\u09c9\u0001\u0000\u0000\u0000\u09c9\u09ca\u0001\u0000\u0000"+
		"\u0000\u09ca\u09cb\u0005\u00f9\u0000\u0000\u09cb\u017d\u0001\u0000\u0000"+
		"\u0000\u09cc\u09d0\u0003\u0180\u00c0\u0000\u09cd\u09d0\u0003\u01d2\u00e9"+
		"\u0000\u09ce\u09d0\u0003\u01b8\u00dc\u0000\u09cf\u09cc\u0001\u0000\u0000"+
		"\u0000\u09cf\u09cd\u0001\u0000\u0000\u0000\u09cf\u09ce\u0001\u0000\u0000"+
		"\u0000\u09d0\u017f\u0001\u0000\u0000\u0000\u09d1\u09da\u0003\u0182\u00c1"+
		"\u0000\u09d2\u09da\u0003\u01cc\u00e6\u0000\u09d3\u09da\u0003\u01ce\u00e7"+
		"\u0000\u09d4\u09da\u0003\u01d0\u00e8\u0000\u09d5\u09da\u0003\u0198\u00cc"+
		"\u0000\u09d6\u09da\u0003\u01a8\u00d4\u0000\u09d7\u09da\u0005\u013d\u0000"+
		"\u0000\u09d8\u09da\u0005(\u0000\u0000\u09d9\u09d1\u0001\u0000\u0000\u0000"+
		"\u09d9\u09d2\u0001\u0000\u0000\u0000\u09d9\u09d3\u0001\u0000\u0000\u0000"+
		"\u09d9\u09d4\u0001\u0000\u0000\u0000\u09d9\u09d5\u0001\u0000\u0000\u0000"+
		"\u09d9\u09d6\u0001\u0000\u0000\u0000\u09d9\u09d7\u0001\u0000\u0000\u0000"+
		"\u09d9\u09d8\u0001\u0000\u0000\u0000\u09da\u0181\u0001\u0000\u0000\u0000"+
		"\u09db\u09e0\u0003\u0184\u00c2\u0000\u09dc\u09dd\u0007\u0005\u0000\u0000"+
		"\u09dd\u09df\u0003\u0184\u00c2\u0000\u09de\u09dc\u0001\u0000\u0000\u0000"+
		"\u09df\u09e2\u0001\u0000\u0000\u0000\u09e0\u09de\u0001\u0000\u0000\u0000"+
		"\u09e0\u09e1\u0001\u0000\u0000\u0000\u09e1\u0183\u0001\u0000\u0000\u0000"+
		"\u09e2\u09e0\u0001\u0000\u0000\u0000\u09e3\u09e8\u0003\u0186\u00c3\u0000"+
		"\u09e4\u09e5\u0007\u000f\u0000\u0000\u09e5\u09e7\u0003\u0186\u00c3\u0000"+
		"\u09e6\u09e4\u0001\u0000\u0000\u0000\u09e7\u09ea\u0001\u0000\u0000\u0000"+
		"\u09e8\u09e6\u0001\u0000\u0000\u0000\u09e8\u09e9\u0001\u0000\u0000\u0000"+
		"\u09e9\u0185\u0001\u0000\u0000\u0000\u09ea\u09e8\u0001\u0000\u0000\u0000"+
		"\u09eb\u09ed\u0003\u018c\u00c6\u0000\u09ec\u09eb\u0001\u0000\u0000\u0000"+
		"\u09ec\u09ed\u0001\u0000\u0000\u0000\u09ed\u09ee\u0001\u0000\u0000\u0000"+
		"\u09ee\u09ef\u0003\u018a\u00c5\u0000\u09ef\u0187\u0001\u0000\u0000\u0000"+
		"\u09f0\u09f1\u0005\u00f8\u0000\u0000\u09f1\u09f6\u0003\u0182\u00c1\u0000"+
		"\u09f2\u09f3\u0005\u00f1\u0000\u0000\u09f3\u09f5\u0003\u0182\u00c1\u0000"+
		"\u09f4\u09f2\u0001\u0000\u0000\u0000\u09f5\u09f8\u0001\u0000\u0000\u0000"+
		"\u09f6\u09f4\u0001\u0000\u0000\u0000\u09f6\u09f7\u0001\u0000\u0000\u0000"+
		"\u09f7\u09f9\u0001\u0000\u0000\u0000\u09f8\u09f6\u0001\u0000\u0000\u0000"+
		"\u09f9\u09fa\u0005\u00f9\u0000\u0000\u09fa\u0189\u0001\u0000\u0000\u0000"+
		"\u09fb\u0a00\u0003\u0140\u00a0\u0000\u09fc\u09fd\u0005\u00ec\u0000\u0000"+
		"\u09fd\u09ff\u0003\u017a\u00bd\u0000\u09fe\u09fc\u0001\u0000\u0000\u0000"+
		"\u09ff\u0a02\u0001\u0000\u0000\u0000\u0a00\u09fe\u0001\u0000\u0000\u0000"+
		"\u0a00\u0a01\u0001\u0000\u0000\u0000\u0a01\u0a05\u0001\u0000\u0000\u0000"+
		"\u0a02\u0a00\u0001\u0000\u0000\u0000\u0a03\u0a05\u0003\u018e\u00c7\u0000"+
		"\u0a04\u09fb\u0001\u0000\u0000\u0000\u0a04\u0a03\u0001\u0000\u0000\u0000"+
		"\u0a05\u018b\u0001\u0000\u0000\u0000\u0a06\u0a07\u0007\u0005\u0000\u0000"+
		"\u0a07\u018d\u0001\u0000\u0000\u0000\u0a08\u0a09\u0003\u0190\u00c8\u0000"+
		"\u0a09\u018f\u0001\u0000\u0000\u0000\u0a0a\u0a0b\u0005q\u0000\u0000\u0a0b"+
		"\u0a0c\u0005\u00f8\u0000\u0000\u0a0c\u0a0d\u0003\u0192\u00c9\u0000\u0a0d"+
		"\u0a0e\u0005\u0017\u0000\u0000\u0a0e\u0a0f\u0003\u0196\u00cb\u0000\u0a0f"+
		"\u0a10\u0005\u00f9\u0000\u0000\u0a10\u0191\u0001\u0000\u0000\u0000\u0a11"+
		"\u0a15\u0003\u02be\u015f\u0000\u0a12\u0a15\u0003\u0194\u00ca\u0000\u0a13"+
		"\u0a15\u0003\u02c2\u0161\u0000\u0a14\u0a11\u0001\u0000\u0000\u0000\u0a14"+
		"\u0a12\u0001\u0000\u0000\u0000\u0a14\u0a13\u0001\u0000\u0000\u0000\u0a15"+
		"\u0193\u0001\u0000\u0000\u0000\u0a16\u0a17\u0007\u0010\u0000\u0000\u0a17"+
		"\u0195\u0001\u0000\u0000\u0000\u0a18\u0a19\u0003\u01a8\u00d4\u0000\u0a19"+
		"\u0197\u0001\u0000\u0000\u0000\u0a1a\u0a1b\u0003\u019a\u00cd\u0000\u0a1b"+
		"\u0199\u0001\u0000\u0000\u0000\u0a1c\u0a21\u0003\u019c\u00ce\u0000\u0a1d"+
		"\u0a1e\u0005\u00f2\u0000\u0000\u0a1e\u0a20\u0003\u019c\u00ce\u0000\u0a1f"+
		"\u0a1d\u0001\u0000\u0000\u0000\u0a20\u0a23\u0001\u0000\u0000\u0000\u0a21"+
		"\u0a1f\u0001\u0000\u0000\u0000\u0a21\u0a22\u0001\u0000\u0000\u0000\u0a22"+
		"\u019b\u0001\u0000\u0000\u0000\u0a23\u0a21\u0001\u0000\u0000\u0000\u0a24"+
		"\u0a25\u0003\u019e\u00cf\u0000\u0a25\u019d\u0001\u0000\u0000\u0000\u0a26"+
		"\u0a29\u0003\u0140\u00a0\u0000\u0a27\u0a29\u0003\u01a0\u00d0\u0000\u0a28"+
		"\u0a26\u0001\u0000\u0000\u0000\u0a28\u0a27\u0001\u0000\u0000\u0000\u0a29"+
		"\u019f\u0001\u0000\u0000\u0000\u0a2a\u0a2b\u0003\u01a2\u00d1\u0000\u0a2b"+
		"\u01a1\u0001\u0000\u0000\u0000\u0a2c\u0a2d\u0005\u00b5\u0000\u0000\u0a2d"+
		"\u0a2e\u0005\u00f8\u0000\u0000\u0a2e\u0a2f\u0003\u01a4\u00d2\u0000\u0a2f"+
		"\u0a30\u0005\u00f9\u0000\u0000\u0a30\u01a3\u0001\u0000\u0000\u0000\u0a31"+
		"\u0a33\u0003\u01a6\u00d3\u0000\u0a32\u0a31\u0001\u0000\u0000\u0000\u0a32"+
		"\u0a33\u0001\u0000\u0000\u0000\u0a33\u0a35\u0001\u0000\u0000\u0000\u0a34"+
		"\u0a36\u0003\u019a\u00cd\u0000\u0a35\u0a34\u0001\u0000\u0000\u0000\u0a35"+
		"\u0a36\u0001\u0000\u0000\u0000\u0a36\u0a37\u0001\u0000\u0000\u0000\u0a37"+
		"\u0a39\u0005\u0017\u0000\u0000\u0a38\u0a32\u0001\u0000\u0000\u0000\u0a38"+
		"\u0a39\u0001\u0000\u0000\u0000\u0a39\u0a3a\u0001\u0000\u0000\u0000\u0a3a"+
		"\u0a40\u0003\u019a\u00cd\u0000\u0a3b\u0a3c\u0003\u019a\u00cd\u0000\u0a3c"+
		"\u0a3d\u0005\u00f1\u0000\u0000\u0a3d\u0a3e\u0003\u019a\u00cd\u0000\u0a3e"+
		"\u0a40\u0001\u0000\u0000\u0000\u0a3f\u0a38\u0001\u0000\u0000\u0000\u0a3f"+
		"\u0a3b\u0001\u0000\u0000\u0000\u0a40\u01a5\u0001\u0000\u0000\u0000\u0a41"+
		"\u0a42\u0007\u0011\u0000\u0000\u0a42\u01a7\u0001\u0000\u0000\u0000\u0a43"+
		"\u0a44\u0003\u01aa\u00d5\u0000\u0a44\u01a9\u0001\u0000\u0000\u0000\u0a45"+
		"\u0a46\u0003\u01ac\u00d6\u0000\u0a46\u01ab\u0001\u0000\u0000\u0000\u0a47"+
		"\u0a48\u0003\u01ae\u00d7\u0000\u0a48\u01ad\u0001\u0000\u0000\u0000\u0a49"+
		"\u0a4c\u0003\u0140\u00a0\u0000\u0a4a\u0a4c\u0003\u01b0\u00d8\u0000\u0a4b"+
		"\u0a49\u0001\u0000\u0000\u0000\u0a4b\u0a4a\u0001\u0000\u0000\u0000\u0a4c"+
		"\u01af\u0001\u0000\u0000\u0000\u0a4d\u0a51\u0003\u01b2\u00d9\u0000\u0a4e"+
		"\u0a51\u0003\u01b4\u00da\u0000\u0a4f\u0a51\u0003\u01b6\u00db\u0000\u0a50"+
		"\u0a4d\u0001\u0000\u0000\u0000\u0a50\u0a4e\u0001\u0000\u0000\u0000\u0a50"+
		"\u0a4f\u0001\u0000\u0000\u0000\u0a51\u01b1\u0001\u0000\u0000\u0000\u0a52"+
		"\u0a57\u0005\f\u0000\u0000\u0a53\u0a54\u0005\f\u0000\u0000\u0a54\u0a55"+
		"\u0005\u00f8\u0000\u0000\u0a55\u0a57\u0005\u00f9\u0000\u0000\u0a56\u0a52"+
		"\u0001\u0000\u0000\u0000\u0a56\u0a53\u0001\u0000\u0000\u0000\u0a57\u01b3"+
		"\u0001\u0000\u0000\u0000\u0a58\u0a5d\u0005\r\u0000\u0000\u0a59\u0a5a\u0005"+
		"\r\u0000\u0000\u0a5a\u0a5b\u0005\u00f8\u0000\u0000\u0a5b\u0a5d\u0005\u00f9"+
		"\u0000\u0000\u0a5c\u0a58\u0001\u0000\u0000\u0000\u0a5c\u0a59\u0001\u0000"+
		"\u0000\u0000\u0a5d\u01b5\u0001\u0000\u0000\u0000\u0a5e\u0a5f\u0005\u000e"+
		"\u0000\u0000\u0a5f\u01b7\u0001\u0000\u0000\u0000\u0a60\u0a61\u0003\u01ba"+
		"\u00dd\u0000\u0a61\u01b9\u0001\u0000\u0000\u0000\u0a62\u0a67\u0003\u01bc"+
		"\u00de\u0000\u0a63\u0a64\u0005*\u0000\u0000\u0a64\u0a66\u0003\u01ba\u00dd"+
		"\u0000\u0a65\u0a63\u0001\u0000\u0000\u0000\u0a66\u0a69\u0001\u0000\u0000"+
		"\u0000\u0a67\u0a65\u0001\u0000\u0000\u0000\u0a67\u0a68\u0001\u0000\u0000"+
		"\u0000\u0a68\u01bb\u0001\u0000\u0000\u0000\u0a69\u0a67\u0001\u0000\u0000"+
		"\u0000\u0a6a\u0a6c\u0003\u00fe\u007f\u0000\u0a6b\u0a6a\u0001\u0000\u0000"+
		"\u0000\u0a6c\u0a6f\u0001\u0000\u0000\u0000\u0a6d\u0a6b\u0001\u0000\u0000"+
		"\u0000\u0a6d\u0a6e\u0001\u0000\u0000\u0000\u0a6e\u0a70\u0001\u0000\u0000"+
		"\u0000\u0a6f\u0a6d\u0001\u0000\u0000\u0000\u0a70\u0a75\u0003\u01be\u00df"+
		"\u0000\u0a71\u0a72\u0005\u0003\u0000\u0000\u0a72\u0a74\u0003\u01bc\u00de"+
		"\u0000\u0a73\u0a71\u0001\u0000\u0000\u0000\u0a74\u0a77\u0001\u0000\u0000"+
		"\u0000\u0a75\u0a73\u0001\u0000\u0000\u0000\u0a75\u0a76\u0001\u0000\u0000"+
		"\u0000\u0a76\u01bd\u0001\u0000\u0000\u0000\u0a77\u0a75\u0001\u0000\u0000"+
		"\u0000\u0a78\u0a7c\u0003\u01c0\u00e0\u0000\u0a79\u0a7a\u0005\'\u0000\u0000"+
		"\u0a7a\u0a7c\u0003\u01c0\u00e0\u0000\u0a7b\u0a78\u0001\u0000\u0000\u0000"+
		"\u0a7b\u0a79\u0001\u0000\u0000\u0000\u0a7c\u01bf\u0001\u0000\u0000\u0000"+
		"\u0a7d\u0a7f\u0003\u01c6\u00e3\u0000\u0a7e\u0a80\u0003\u01c2\u00e1\u0000"+
		"\u0a7f\u0a7e\u0001\u0000\u0000\u0000\u0a7f\u0a80\u0001\u0000\u0000\u0000"+
		"\u0a80\u01c1\u0001\u0000\u0000\u0000\u0a81\u0a83\u0005\u001f\u0000\u0000"+
		"\u0a82\u0a84\u0005\'\u0000\u0000\u0a83\u0a82\u0001\u0000\u0000\u0000\u0a83"+
		"\u0a84\u0001\u0000\u0000\u0000\u0a84\u0a85\u0001\u0000\u0000\u0000\u0a85"+
		"\u0a86\u0003\u01c4\u00e2\u0000\u0a86\u01c3\u0001\u0000\u0000\u0000\u0a87"+
		"\u0a88\u0007\u0007\u0000\u0000\u0a88\u01c5\u0001\u0000\u0000\u0000\u0a89"+
		"\u0a8c\u0003\u0298\u014c\u0000\u0a8a\u0a8c\u0003\u01c8\u00e4\u0000\u0a8b"+
		"\u0a89\u0001\u0000\u0000\u0000\u0a8b\u0a8a\u0001\u0000\u0000\u0000\u0a8c"+
		"\u01c7\u0001\u0000\u0000\u0000\u0a8d\u0a90\u0003\u01ca\u00e5\u0000\u0a8e"+
		"\u0a90\u0003\u0144\u00a2\u0000\u0a8f\u0a8d\u0001\u0000\u0000\u0000\u0a8f"+
		"\u0a8e\u0001\u0000\u0000\u0000\u0a90\u01c9\u0001\u0000\u0000\u0000\u0a91"+
		"\u0a92\u0005\u00f8\u0000\u0000\u0a92\u0a93\u0003\u01b8\u00dc\u0000\u0a93"+
		"\u0a94\u0005\u00f9\u0000\u0000\u0a94\u01cb\u0001\u0000\u0000\u0000\u0a95"+
		"\u0a96\u0005\u0165\u0000\u0000\u0a96\u01cd\u0001\u0000\u0000\u0000\u0a97"+
		"\u0a98\u0005\u0166\u0000\u0000\u0a98\u01cf\u0001\u0000\u0000\u0000\u0a99"+
		"\u0a9a\u0005\u0164\u0000\u0000\u0a9a\u01d1\u0001\u0000\u0000\u0000\u0a9b"+
		"\u0a9e\u0003\u01d4\u00ea\u0000\u0a9c\u0a9e\u0003\u01d6\u00eb\u0000\u0a9d"+
		"\u0a9b\u0001\u0000\u0000\u0000\u0a9d\u0a9c\u0001\u0000\u0000\u0000\u0a9e"+
		"\u01d3\u0001\u0000\u0000\u0000\u0a9f\u0aa0\u0003\u0144\u00a2\u0000\u0aa0"+
		"\u01d5\u0001\u0000\u0000\u0000\u0aa1\u0aa2\u0005(\u0000\u0000\u0aa2\u01d7"+
		"\u0001\u0000\u0000\u0000\u0aa3\u0aa6\u0003\u01d4\u00ea\u0000\u0aa4\u0aa6"+
		"\u0003\u01da\u00ed\u0000\u0aa5\u0aa3\u0001\u0000\u0000\u0000\u0aa5\u0aa4"+
		"\u0001\u0000\u0000\u0000\u0aa6\u01d9\u0001\u0000\u0000\u0000\u0aa7\u0aaa"+
		"\u0003\u0180\u00c0\u0000\u0aa8\u0aaa\u0003\u01c8\u00e4\u0000\u0aa9\u0aa7"+
		"\u0001\u0000\u0000\u0000\u0aa9\u0aa8\u0001\u0000\u0000\u0000\u0aaa\u01db"+
		"\u0001\u0000\u0000\u0000\u0aab\u0aad\u0003\u01de\u00ef\u0000\u0aac\u0aae"+
		"\u0003\u01f4\u00fa\u0000\u0aad\u0aac\u0001\u0000\u0000\u0000\u0aad\u0aae"+
		"\u0001\u0000\u0000\u0000\u0aae\u0ab0\u0001\u0000\u0000\u0000\u0aaf\u0ab1"+
		"\u0003\u0222\u0111\u0000\u0ab0\u0aaf\u0001\u0000\u0000\u0000\u0ab0\u0ab1"+
		"\u0001\u0000\u0000\u0000\u0ab1\u0ab3\u0001\u0000\u0000\u0000\u0ab2\u0ab4"+
		"\u0003\u01ea\u00f5\u0000\u0ab3\u0ab2\u0001\u0000\u0000\u0000\u0ab3\u0ab4"+
		"\u0001\u0000\u0000\u0000\u0ab4\u0ab6\u0001\u0000\u0000\u0000\u0ab5\u0ab7"+
		"\u0003\u0226\u0113\u0000\u0ab6\u0ab5\u0001\u0000\u0000\u0000\u0ab6\u0ab7"+
		"\u0001\u0000\u0000\u0000\u0ab7\u0ab9\u0001\u0000\u0000\u0000\u0ab8\u0aba"+
		"\u0003\u0236\u011b\u0000\u0ab9\u0ab8\u0001\u0000\u0000\u0000\u0ab9\u0aba"+
		"\u0001\u0000\u0000\u0000\u0aba\u0abc\u0001\u0000\u0000\u0000\u0abb\u0abd"+
		"\u0003\u02d0\u0168\u0000\u0abc\u0abb\u0001\u0000\u0000\u0000\u0abc\u0abd"+
		"\u0001\u0000\u0000\u0000\u0abd\u0abf\u0001\u0000\u0000\u0000\u0abe\u0ac0"+
		"\u0003\u023a\u011d\u0000\u0abf\u0abe\u0001\u0000\u0000\u0000\u0abf\u0ac0"+
		"\u0001\u0000\u0000\u0000\u0ac0\u0ac2\u0001\u0000\u0000\u0000\u0ac1\u0ac3"+
		"\u0003\u02d8\u016c\u0000\u0ac2\u0ac1\u0001\u0000\u0000\u0000\u0ac2\u0ac3"+
		"\u0001\u0000\u0000\u0000\u0ac3\u01dd\u0001\u0000\u0000\u0000\u0ac4\u0ac5"+
		"\u0005\u0017\u0000\u0000\u0ac5\u0ac6\u0003\u01e0\u00f0\u0000\u0ac6\u01df"+
		"\u0001\u0000\u0000\u0000\u0ac7\u0acc\u0003\u01f6\u00fb\u0000\u0ac8\u0ac9"+
		"\u0005\u00f1\u0000\u0000\u0ac9\u0acb\u0003\u01f6\u00fb\u0000\u0aca\u0ac8"+
		"\u0001\u0000\u0000\u0000\u0acb\u0ace\u0001\u0000\u0000\u0000\u0acc\u0aca"+
		"\u0001\u0000\u0000\u0000\u0acc\u0acd\u0001\u0000\u0000\u0000\u0acd\u01e1"+
		"\u0001\u0000\u0000\u0000\u0ace\u0acc\u0001\u0000\u0000\u0000\u0acf\u0ad1"+
		"\u0005\u00f8\u0000\u0000\u0ad0\u0acf\u0001\u0000\u0000\u0000\u0ad0\u0ad1"+
		"\u0001\u0000\u0000\u0000\u0ad1\u0ad2\u0001\u0000\u0000\u0000\u0ad2\u0ad7"+
		"\u0003\u010e\u0087\u0000\u0ad3\u0ad4\u0005\u00f1\u0000\u0000\u0ad4\u0ad6"+
		"\u0003\u010e\u0087\u0000\u0ad5\u0ad3\u0001\u0000\u0000\u0000\u0ad6\u0ad9"+
		"\u0001\u0000\u0000\u0000\u0ad7\u0ad5\u0001\u0000\u0000\u0000\u0ad7\u0ad8"+
		"\u0001\u0000\u0000\u0000\u0ad8\u0adb\u0001\u0000\u0000\u0000\u0ad9\u0ad7"+
		"\u0001\u0000\u0000\u0000\u0ada\u0adc\u0005\u00f9\u0000\u0000\u0adb\u0ada"+
		"\u0001\u0000\u0000\u0000\u0adb\u0adc\u0001\u0000\u0000\u0000\u0adc\u01e3"+
		"\u0001\u0000\u0000\u0000\u0add\u0adf\u0005\u00f8\u0000\u0000\u0ade\u0add"+
		"\u0001\u0000\u0000\u0000\u0ade\u0adf\u0001\u0000\u0000\u0000\u0adf\u0ae0"+
		"\u0001\u0000\u0000\u0000\u0ae0\u0ae5\u0003\u0180\u00c0\u0000\u0ae1\u0ae2"+
		"\u0005\u00f1\u0000\u0000\u0ae2\u0ae4\u0003\u0180\u00c0\u0000\u0ae3\u0ae1"+
		"\u0001\u0000\u0000\u0000\u0ae4\u0ae7\u0001\u0000\u0000\u0000\u0ae5\u0ae3"+
		"\u0001\u0000\u0000\u0000\u0ae5\u0ae6\u0001\u0000\u0000\u0000\u0ae6\u0ae9"+
		"\u0001\u0000\u0000\u0000\u0ae7\u0ae5\u0001\u0000\u0000\u0000\u0ae8\u0aea"+
		"\u0005\u00f9\u0000\u0000\u0ae9\u0ae8\u0001\u0000\u0000\u0000\u0ae9\u0aea"+
		"\u0001\u0000\u0000\u0000\u0aea\u01e5\u0001\u0000\u0000\u0000\u0aeb\u0aec"+
		"\u0003\u01e4\u00f2\u0000\u0aec\u0aef\u0005\u0001\u0000\u0000\u0aed\u0af0"+
		"\u0005\u016d\u0000\u0000\u0aee\u0af0\u0003\u014a\u00a5\u0000\u0aef\u0aed"+
		"\u0001\u0000\u0000\u0000\u0aef\u0aee\u0001\u0000\u0000\u0000\u0af0\u01e7"+
		"\u0001\u0000\u0000\u0000\u0af1\u0af2\u0005\u00f8\u0000\u0000\u0af2\u0af7"+
		"\u0003\u01e6\u00f3\u0000\u0af3\u0af4\u0005\u00f1\u0000\u0000\u0af4\u0af6"+
		"\u0003\u01e6\u00f3\u0000\u0af5\u0af3\u0001\u0000\u0000\u0000\u0af6\u0af9"+
		"\u0001\u0000\u0000\u0000\u0af7\u0af5\u0001\u0000\u0000\u0000\u0af7\u0af8"+
		"\u0001\u0000\u0000\u0000\u0af8\u0afa\u0001\u0000\u0000\u0000\u0af9\u0af7"+
		"\u0001\u0000\u0000\u0000\u0afa\u0afb\u0005\u00f9\u0000\u0000\u0afb\u01e9"+
		"\u0001\u0000\u0000\u0000\u0afc\u0aff\u0005\u0162\u0000\u0000\u0afd\u0afe"+
		"\u0005\u0163\u0000\u0000\u0afe\u0b00\u0005\u0108\u0000\u0000\u0aff\u0afd"+
		"\u0001\u0000\u0000\u0000\u0aff\u0b00\u0001\u0000\u0000\u0000\u0b00\u0b01"+
		"\u0001\u0000\u0000\u0000\u0b01\u0b02\u0005\u00f8\u0000\u0000\u0b02\u0b03"+
		"\u0003\u01e2\u00f1\u0000\u0b03\u0b04\u0005v\u0000\u0000\u0b04\u0b05\u0003"+
		"\u010e\u0087\u0000\u0b05\u0b06\u0005\u001b\u0000\u0000\u0b06\u0b07\u0003"+
		"\u01e8\u00f4\u0000\u0b07\u0b09\u0005\u00f9\u0000\u0000\u0b08\u0b0a\u0005"+
		"\u0001\u0000\u0000\u0b09\u0b08\u0001\u0000\u0000\u0000\u0b09\u0b0a\u0001"+
		"\u0000\u0000\u0000\u0b0a\u0b0b\u0001\u0000\u0000\u0000\u0b0b\u0b0c\u0003"+
		"\u010e\u0087\u0000\u0b0c\u01eb\u0001\u0000\u0000\u0000\u0b0d\u0b0f\u0005"+
		"\u00f8\u0000\u0000\u0b0e\u0b0d\u0001\u0000\u0000\u0000\u0b0e\u0b0f\u0001"+
		"\u0000\u0000\u0000\u0b0f\u0b10\u0001\u0000\u0000\u0000\u0b10\u0b15\u0003"+
		"\u010e\u0087\u0000\u0b11\u0b12\u0005\u00f1\u0000\u0000\u0b12\u0b14\u0003"+
		"\u010e\u0087\u0000\u0b13\u0b11\u0001\u0000\u0000\u0000\u0b14\u0b17\u0001"+
		"\u0000\u0000\u0000\u0b15\u0b13\u0001\u0000\u0000\u0000\u0b15\u0b16\u0001"+
		"\u0000\u0000\u0000\u0b16\u0b19\u0001\u0000\u0000\u0000\u0b17\u0b15\u0001"+
		"\u0000\u0000\u0000\u0b18\u0b1a\u0005\u00f9\u0000\u0000\u0b19\u0b18\u0001"+
		"\u0000\u0000\u0000\u0b19\u0b1a\u0001\u0000\u0000\u0000\u0b1a\u01ed\u0001"+
		"\u0000\u0000\u0000\u0b1b\u0b1d\u0005\u00f8\u0000\u0000\u0b1c\u0b1b\u0001"+
		"\u0000\u0000\u0000\u0b1c\u0b1d\u0001\u0000\u0000\u0000\u0b1d\u0b1e\u0001"+
		"\u0000\u0000\u0000\u0b1e\u0b23\u0003\u0180\u00c0\u0000\u0b1f\u0b20\u0005"+
		"\u00f1\u0000\u0000\u0b20\u0b22\u0003\u0180\u00c0\u0000\u0b21\u0b1f\u0001"+
		"\u0000\u0000\u0000\u0b22\u0b25\u0001\u0000\u0000\u0000\u0b23\u0b21\u0001"+
		"\u0000\u0000\u0000\u0b23\u0b24\u0001\u0000\u0000\u0000\u0b24\u0b27\u0001"+
		"\u0000\u0000\u0000\u0b25\u0b23\u0001\u0000\u0000\u0000\u0b26\u0b28\u0005"+
		"\u00f9\u0000\u0000\u0b27\u0b26\u0001\u0000\u0000\u0000\u0b27\u0b28\u0001"+
		"\u0000\u0000\u0000\u0b28\u01ef\u0001\u0000\u0000\u0000\u0b29\u0b2a\u0003"+
		"\u01e4\u00f2\u0000\u0b2a\u0b2d\u0005\u0001\u0000\u0000\u0b2b\u0b2e\u0005"+
		"\u016d\u0000\u0000\u0b2c\u0b2e\u0003\u014a\u00a5\u0000\u0b2d\u0b2b\u0001"+
		"\u0000\u0000\u0000\u0b2d\u0b2c\u0001\u0000\u0000\u0000\u0b2e\u01f1\u0001"+
		"\u0000\u0000\u0000\u0b2f\u0b30\u0005\u00f8\u0000\u0000\u0b30\u0b35\u0003"+
		"\u01e6\u00f3\u0000\u0b31\u0b32\u0005\u00f1\u0000\u0000\u0b32\u0b34\u0003"+
		"\u01e6\u00f3\u0000\u0b33\u0b31\u0001\u0000\u0000\u0000\u0b34\u0b37\u0001"+
		"\u0000\u0000\u0000\u0b35\u0b33\u0001\u0000\u0000\u0000\u0b35\u0b36\u0001"+
		"\u0000\u0000\u0000\u0b36\u0b38\u0001\u0000\u0000\u0000\u0b37\u0b35\u0001"+
		"\u0000\u0000\u0000\u0b38\u0b39\u0005\u00f9\u0000\u0000\u0b39\u01f3\u0001"+
		"\u0000\u0000\u0000\u0b3a\u0b3b\u0005\u0161\u0000\u0000\u0b3b\u0b3c\u0005"+
		"\u00f8\u0000\u0000\u0b3c\u0b3d\u0003\u01ec\u00f6\u0000\u0b3d\u0b3e\u0005"+
		"v\u0000\u0000\u0b3e\u0b3f\u0003\u010e\u0087\u0000\u0b3f\u0b40\u0005\u001b"+
		"\u0000\u0000\u0b40\u0b41\u0003\u01e8\u00f4\u0000\u0b41\u0b43\u0005\u00f9"+
		"\u0000\u0000\u0b42\u0b44\u0005\u0001\u0000\u0000\u0b43\u0b42\u0001\u0000"+
		"\u0000\u0000\u0b43\u0b44\u0001\u0000\u0000\u0000\u0b44\u0b45\u0001\u0000"+
		"\u0000\u0000\u0b45\u0b46\u0003\u010e\u0087\u0000\u0b46\u01f5\u0001\u0000"+
		"\u0000\u0000\u0b47\u0b4a\u0003\u01fa\u00fd\u0000\u0b48\u0b4a\u0003\u021a"+
		"\u010d\u0000\u0b49\u0b47\u0001\u0000\u0000\u0000\u0b49\u0b48\u0001\u0000"+
		"\u0000\u0000\u0b4a\u01f7\u0001\u0000\u0000\u0000\u0b4b\u0b4d\u0003\u00fe"+
		"\u007f\u0000\u0b4c\u0b4b\u0001\u0000\u0000\u0000\u0b4d\u0b50\u0001\u0000"+
		"\u0000\u0000\u0b4e\u0b4c\u0001\u0000\u0000\u0000\u0b4e\u0b4f\u0001\u0000"+
		"\u0000\u0000\u0b4f\u0b51\u0001\u0000\u0000\u0000\u0b50\u0b4e\u0001\u0000"+
		"\u0000\u0000\u0b51\u0b52\u0003\u01fc\u00fe\u0000\u0b52\u01f9\u0001\u0000"+
		"\u0000\u0000\u0b53\u0b55\u0005\u00f8\u0000\u0000\u0b54\u0b53\u0001\u0000"+
		"\u0000\u0000\u0b54\u0b55\u0001\u0000\u0000\u0000\u0b55\u0b56\u0001\u0000"+
		"\u0000\u0000\u0b56\u0b5a\u0003\u021a\u010d\u0000\u0b57\u0b59\u0003\u01f8"+
		"\u00fc\u0000\u0b58\u0b57\u0001\u0000\u0000\u0000\u0b59\u0b5c\u0001\u0000"+
		"\u0000\u0000\u0b5a\u0b58\u0001\u0000\u0000\u0000\u0b5a\u0b5b\u0001\u0000"+
		"\u0000\u0000\u0b5b\u0b5e\u0001\u0000\u0000\u0000\u0b5c\u0b5a\u0001\u0000"+
		"\u0000\u0000\u0b5d\u0b5f\u0005\u00f9\u0000\u0000\u0b5e\u0b5d\u0001\u0000"+
		"\u0000\u0000\u0b5e\u0b5f\u0001\u0000\u0000\u0000\u0b5f\u01fb\u0001\u0000"+
		"\u0000\u0000\u0b60\u0b61\u0005\u000b\u0000\u0000\u0b61\u0b62\u0005 \u0000"+
		"\u0000\u0b62\u0b76\u0003\u01fa\u00fd\u0000\u0b63\u0b65\u0003\u0206\u0103"+
		"\u0000\u0b64\u0b63\u0001\u0000\u0000\u0000\u0b64\u0b65\u0001\u0000\u0000"+
		"\u0000\u0b65\u0b66\u0001\u0000\u0000\u0000\u0b66\u0b67\u0005 \u0000\u0000"+
		"\u0b67\u0b68\u0003\u01fa\u00fd\u0000\u0b68\u0b69\u0003\u0214\u010a\u0000"+
		"\u0b69\u0b76\u0001\u0000\u0000\u0000\u0b6a\u0b6c\u0005&\u0000\u0000\u0b6b"+
		"\u0b6d\u0003\u0206\u0103\u0000\u0b6c\u0b6b\u0001\u0000\u0000\u0000\u0b6c"+
		"\u0b6d\u0001\u0000\u0000\u0000\u0b6d\u0b6e\u0001\u0000\u0000\u0000\u0b6e"+
		"\u0b6f\u0005 \u0000\u0000\u0b6f\u0b70\u0003\u01fa\u00fd\u0000\u0b70\u0b71"+
		"\u0003\u0214\u010a\u0000\u0b71\u0b76\u0001\u0000\u0000\u0000\u0b72\u0b73"+
		"\u0005;\u0000\u0000\u0b73\u0b74\u0005 \u0000\u0000\u0b74\u0b76\u0003\u01fa"+
		"\u00fd\u0000\u0b75\u0b60\u0001\u0000\u0000\u0000\u0b75\u0b64\u0001\u0000"+
		"\u0000\u0000\u0b75\u0b6a\u0001\u0000\u0000\u0000\u0b75\u0b72\u0001\u0000"+
		"\u0000\u0000\u0b76\u01fd\u0001\u0000\u0000\u0000\u0b77\u0b78\u0005\u000b"+
		"\u0000\u0000\u0b78\u0b79\u0005 \u0000\u0000\u0b79\u0b7a\u0003\u01f6\u00fb"+
		"\u0000\u0b7a\u01ff\u0001\u0000\u0000\u0000\u0b7b\u0b7d\u0003\u0206\u0103"+
		"\u0000\u0b7c\u0b7b\u0001\u0000\u0000\u0000\u0b7c\u0b7d\u0001\u0000\u0000"+
		"\u0000\u0b7d\u0b7e\u0001\u0000\u0000\u0000\u0b7e\u0b7f\u0005 \u0000\u0000"+
		"\u0b7f\u0b80\u0003\u021a\u010d\u0000\u0b80\u0b81\u0003\u0214\u010a\u0000"+
		"\u0b81\u0201\u0001\u0000\u0000\u0000\u0b82\u0b84\u0005&\u0000\u0000\u0b83"+
		"\u0b85\u0003\u0206\u0103\u0000\u0b84\u0b83\u0001\u0000\u0000\u0000\u0b84"+
		"\u0b85\u0001\u0000\u0000\u0000\u0b85\u0b86\u0001\u0000\u0000\u0000\u0b86"+
		"\u0b87\u0005 \u0000\u0000\u0b87\u0b88\u0003\u021a\u010d\u0000\u0b88\u0203"+
		"\u0001\u0000\u0000\u0000\u0b89\u0b8a\u0005;\u0000\u0000\u0b8a\u0b8b\u0005"+
		" \u0000\u0000\u0b8b\u0b8c\u0003\u021a\u010d\u0000\u0b8c\u0205\u0001\u0000"+
		"\u0000\u0000\u0b8d\u0b90\u0005\u001c\u0000\u0000\u0b8e\u0b90\u0003\u0208"+
		"\u0104\u0000\u0b8f\u0b8d\u0001\u0000\u0000\u0000\u0b8f\u0b8e\u0001\u0000"+
		"\u0000\u0000\u0b90\u0207\u0001\u0000\u0000\u0000\u0b91\u0b93\u0003\u020a"+
		"\u0105\u0000\u0b92\u0b94\u0005,\u0000\u0000\u0b93\u0b92\u0001\u0000\u0000"+
		"\u0000\u0b93\u0b94\u0001\u0000\u0000\u0000\u0b94\u0209\u0001\u0000\u0000"+
		"\u0000\u0b95\u0b96\u0007\u0012\u0000\u0000\u0b96\u020b\u0001\u0000\u0000"+
		"\u0000\u0b97\u0b98\u0005s\u0000\u0000\u0b98\u0b99\u0005\u00a4\u0000\u0000"+
		"\u0b99\u020d\u0001\u0000\u0000\u0000\u0b9a\u0b9b\u0005\u0083\u0000\u0000"+
		"\u0b9b\u0b9c\u0005\u00a4\u0000\u0000\u0b9c\u020f\u0001\u0000\u0000\u0000"+
		"\u0b9d\u0b9e\u0005\u0002\u0000\u0000\u0b9e\u0b9f\u0005\u00a5\u0000\u0000"+
		"\u0b9f\u0211\u0001\u0000\u0000\u0000\u0ba0\u0ba1\u0003\u020c\u0106\u0000"+
		"\u0ba1\u0ba2\u0003\u02d0\u0168\u0000\u0ba2\u0ba8\u0001\u0000\u0000\u0000"+
		"\u0ba3\u0ba4\u0003\u020e\u0107\u0000\u0ba4\u0ba5\u0003\u02d0\u0168\u0000"+
		"\u0ba5\u0ba8\u0001\u0000\u0000\u0000\u0ba6\u0ba8\u0003\u0210\u0108\u0000"+
		"\u0ba7\u0ba0\u0001\u0000\u0000\u0000\u0ba7\u0ba3\u0001\u0000\u0000\u0000"+
		"\u0ba7\u0ba6\u0001\u0000\u0000\u0000\u0ba8\u0213\u0001\u0000\u0000\u0000"+
		"\u0ba9\u0bac\u0003\u0216\u010b\u0000\u0baa\u0bac\u0003\u0218\u010c\u0000"+
		"\u0bab\u0ba9\u0001\u0000\u0000\u0000\u0bab\u0baa\u0001\u0000\u0000\u0000"+
		"\u0bac\u0bae\u0001\u0000\u0000\u0000\u0bad\u0baf\u0003\u0212\u0109\u0000"+
		"\u0bae\u0bad\u0001\u0000\u0000\u0000\u0bae\u0baf\u0001\u0000\u0000\u0000"+
		"\u0baf\u0215\u0001\u0000\u0000\u0000\u0bb0\u0bb1\u0005)\u0000\u0000\u0bb1"+
		"\u0bb2\u0003\u0224\u0112\u0000\u0bb2\u0217\u0001\u0000\u0000\u0000\u0bb3"+
		"\u0bb4\u0005=\u0000\u0000\u0bb4\u0bb5\u0005\u00f8\u0000\u0000\u0bb5\u0bb6"+
		"\u0003\u028c\u0146\u0000\u0bb6\u0bb7\u0005\u00f9\u0000\u0000\u0bb7\u0219"+
		"\u0001\u0000\u0000\u0000\u0bb8\u0bbd\u0003\u0270\u0138\u0000\u0bb9\u0bbb"+
		"\u0005\u0001\u0000\u0000\u0bba\u0bb9\u0001\u0000\u0000\u0000\u0bba\u0bbb"+
		"\u0001\u0000\u0000\u0000\u0bbb\u0bbc\u0001\u0000\u0000\u0000\u0bbc\u0bbe"+
		"\u0003\u010e\u0087\u0000\u0bbd\u0bba\u0001\u0000\u0000\u0000\u0bbd\u0bbe"+
		"\u0001\u0000\u0000\u0000\u0bbe\u0bc3\u0001\u0000\u0000\u0000\u0bbf\u0bc0"+
		"\u0005\u00f8\u0000\u0000\u0bc0\u0bc1\u0003\u021e\u010f\u0000\u0bc1\u0bc2"+
		"\u0005\u00f9\u0000\u0000\u0bc2\u0bc4\u0001\u0000\u0000\u0000\u0bc3\u0bbf"+
		"\u0001\u0000\u0000\u0000\u0bc3\u0bc4\u0001\u0000\u0000\u0000\u0bc4\u0bdb"+
		"\u0001\u0000\u0000\u0000\u0bc5\u0bc7\u0003\u0220\u0110\u0000\u0bc6\u0bc8"+
		"\u0005\u0001\u0000\u0000\u0bc7\u0bc6\u0001\u0000\u0000\u0000\u0bc7\u0bc8"+
		"\u0001\u0000\u0000\u0000\u0bc8\u0bc9\u0001\u0000\u0000\u0000\u0bc9\u0bce"+
		"\u0003\u010e\u0087\u0000\u0bca\u0bcb\u0005\u00f8\u0000\u0000\u0bcb\u0bcc"+
		"\u0003\u021e\u010f\u0000\u0bcc\u0bcd\u0005\u00f9\u0000\u0000\u0bcd\u0bcf"+
		"\u0001\u0000\u0000\u0000\u0bce\u0bca\u0001\u0000\u0000\u0000\u0bce\u0bcf"+
		"\u0001\u0000\u0000\u0000\u0bcf\u0bdb\u0001\u0000\u0000\u0000\u0bd0\u0bd1"+
		"\u0003\u02ce\u0167\u0000\u0bd1\u0bd2\u0005\u00f8\u0000\u0000\u0bd2\u0bd3"+
		"\u0003\u021e\u010f\u0000\u0bd3\u0bd4\u0005\u00f9\u0000\u0000\u0bd4\u0bd6"+
		"\u0001\u0000\u0000\u0000\u0bd5\u0bd7\u0005\u0001\u0000\u0000\u0bd6\u0bd5"+
		"\u0001\u0000\u0000\u0000\u0bd6\u0bd7\u0001\u0000\u0000\u0000\u0bd7\u0bd8"+
		"\u0001\u0000\u0000\u0000\u0bd8\u0bd9\u0003\u010e\u0087\u0000\u0bd9\u0bdb"+
		"\u0001\u0000\u0000\u0000\u0bda\u0bb8\u0001\u0000\u0000\u0000\u0bda\u0bc5"+
		"\u0001\u0000\u0000\u0000\u0bda\u0bd0\u0001\u0000\u0000\u0000\u0bdb\u021b"+
		"\u0001\u0000\u0000\u0000\u0bdc\u0bde\u0005\u00f1\u0000\u0000\u0bdd\u0bdc"+
		"\u0001\u0000\u0000\u0000\u0bdd\u0bde\u0001\u0000\u0000\u0000\u0bde\u0be2"+
		"\u0001\u0000\u0000\u0000\u0bdf\u0be1\u0003\u00fe\u007f\u0000\u0be0\u0bdf"+
		"\u0001\u0000\u0000\u0000\u0be1\u0be4\u0001\u0000\u0000\u0000\u0be2\u0be0"+
		"\u0001\u0000\u0000\u0000\u0be2\u0be3\u0001\u0000\u0000\u0000\u0be3\u0be5"+
		"\u0001\u0000\u0000\u0000\u0be4\u0be2\u0001\u0000\u0000\u0000\u0be5\u0be6"+
		"\u0003\u010e\u0087\u0000\u0be6\u021d\u0001\u0000\u0000\u0000\u0be7\u0be9"+
		"\u0003\u021c\u010e\u0000\u0be8\u0be7\u0001\u0000\u0000\u0000\u0be9\u0bec"+
		"\u0001\u0000\u0000\u0000\u0bea\u0be8\u0001\u0000\u0000\u0000\u0bea\u0beb"+
		"\u0001\u0000\u0000\u0000\u0beb\u021f\u0001\u0000\u0000\u0000\u0bec\u0bea"+
		"\u0001\u0000\u0000\u0000\u0bed\u0bee\u0003\u0294\u014a\u0000\u0bee\u0221"+
		"\u0001\u0000\u0000\u0000\u0bef\u0bf1\u0003\u00fe\u007f\u0000\u0bf0\u0bef"+
		"\u0001\u0000\u0000\u0000\u0bf1\u0bf4\u0001\u0000\u0000\u0000\u0bf2\u0bf0"+
		"\u0001\u0000\u0000\u0000\u0bf2\u0bf3\u0001\u0000\u0000\u0000\u0bf3\u0bf5"+
		"\u0001\u0000\u0000\u0000\u0bf4\u0bf2\u0001\u0000\u0000\u0000\u0bf5\u0bf6"+
		"\u0005?\u0000\u0000\u0bf6\u0bf7\u0003\u0224\u0112\u0000\u0bf7\u0223\u0001"+
		"\u0000\u0000\u0000\u0bf8\u0bf9\u0003\u017e\u00bf\u0000\u0bf9\u0225\u0001"+
		"\u0000\u0000\u0000\u0bfa\u0bfc\u0003\u00fe\u007f\u0000\u0bfb\u0bfa\u0001"+
		"\u0000\u0000\u0000\u0bfc\u0bff\u0001\u0000\u0000\u0000\u0bfd\u0bfb\u0001"+
		"\u0000\u0000\u0000\u0bfd\u0bfe\u0001\u0000\u0000\u0000\u0bfe\u0c00\u0001"+
		"\u0000\u0000\u0000\u0bff\u0bfd\u0001\u0000\u0000\u0000\u0c00\u0c01\u0005"+
		"\u0018\u0000\u0000\u0c01\u0c02\u0005R\u0000\u0000\u0c02\u0c03\u0003\u0228"+
		"\u0114\u0000\u0c03\u0227\u0001\u0000\u0000\u0000\u0c04\u0c09\u0003\u022a"+
		"\u0115\u0000\u0c05\u0c06\u0005\u00f1\u0000\u0000\u0c06\u0c08\u0003\u022a"+
		"\u0115\u0000\u0c07\u0c05\u0001\u0000\u0000\u0000\u0c08\u0c0b\u0001\u0000"+
		"\u0000\u0000\u0c09\u0c07\u0001\u0000\u0000\u0000\u0c09\u0c0a\u0001\u0000"+
		"\u0000\u0000\u0c0a\u0229\u0001\u0000\u0000\u0000\u0c0b\u0c09\u0001\u0000"+
		"\u0000\u0000\u0c0c\u0c11\u0003\u0230\u0118\u0000\u0c0d\u0c11\u0003\u0232"+
		"\u0119\u0000\u0c0e\u0c11\u0003\u0234\u011a\u0000\u0c0f\u0c11\u0003\u022c"+
		"\u0116\u0000\u0c10\u0c0c\u0001\u0000\u0000\u0000\u0c10\u0c0d\u0001\u0000"+
		"\u0000\u0000\u0c10\u0c0e\u0001\u0000\u0000\u0000\u0c10\u0c0f\u0001\u0000"+
		"\u0000\u0000\u0c11\u022b\u0001\u0000\u0000\u0000\u0c12\u0c18\u0003\u01d8"+
		"\u00ec\u0000\u0c13\u0c14\u0005\u00f8\u0000\u0000\u0c14\u0c15\u0003\u0238"+
		"\u011c\u0000\u0c15\u0c16\u0005\u00f9\u0000\u0000\u0c16\u0c18\u0001\u0000"+
		"\u0000\u0000\u0c17\u0c12\u0001\u0000\u0000\u0000\u0c17\u0c13\u0001\u0000"+
		"\u0000\u0000\u0c18\u022d\u0001\u0000\u0000\u0000\u0c19\u0c1e\u0003\u022c"+
		"\u0116\u0000\u0c1a\u0c1b\u0005\u00f1\u0000\u0000\u0c1b\u0c1d\u0003\u022c"+
		"\u0116\u0000\u0c1c\u0c1a\u0001\u0000\u0000\u0000\u0c1d\u0c20\u0001\u0000"+
		"\u0000\u0000\u0c1e\u0c1c\u0001\u0000\u0000\u0000\u0c1e\u0c1f\u0001\u0000"+
		"\u0000\u0000\u0c1f\u022f\u0001\u0000\u0000\u0000\u0c20\u0c1e\u0001\u0000"+
		"\u0000\u0000\u0c21\u0c22\u0005\u00a3\u0000\u0000\u0c22\u0c23\u0005\u00f8"+
		"\u0000\u0000\u0c23\u0c24\u0003\u022e\u0117\u0000\u0c24\u0c25\u0005\u00f9"+
		"\u0000\u0000\u0c25\u0231\u0001\u0000\u0000\u0000\u0c26\u0c27\u0005[\u0000"+
		"\u0000\u0c27\u0c28\u0005\u00f8\u0000\u0000\u0c28\u0c29\u0003\u022e\u0117"+
		"\u0000\u0c29\u0c2a\u0005\u00f9\u0000\u0000\u0c2a\u0233\u0001\u0000\u0000"+
		"\u0000\u0c2b\u0c2c\u0005\u00f8\u0000\u0000\u0c2c\u0c2d\u0005\u00f9\u0000"+
		"\u0000\u0c2d\u0235\u0001\u0000\u0000\u0000\u0c2e\u0c2f\u0005\u0019\u0000"+
		"\u0000\u0c2f\u0c30\u0003\u01b8\u00dc\u0000\u0c30\u0237\u0001\u0000\u0000"+
		"\u0000\u0c31\u0c36\u0003\u01d8\u00ec\u0000\u0c32\u0c33\u0005\u00f1\u0000"+
		"\u0000\u0c33\u0c35\u0003\u01d8\u00ec\u0000\u0c34\u0c32\u0001\u0000\u0000"+
		"\u0000\u0c35\u0c38\u0001\u0000\u0000\u0000\u0c36\u0c34\u0001\u0000\u0000"+
		"\u0000\u0c36\u0c37\u0001\u0000\u0000\u0000\u0c37\u0239\u0001\u0000\u0000"+
		"\u0000\u0c38\u0c36\u0001\u0000\u0000\u0000\u0c39\u0c3a\u0005A\u0000\u0000"+
		"\u0c3a\u0c3b\u0003\u023c\u011e\u0000\u0c3b\u023b\u0001\u0000\u0000\u0000"+
		"\u0c3c\u0c41\u0003\u023e\u011f\u0000\u0c3d\u0c3e\u0005\u00f1\u0000\u0000"+
		"\u0c3e\u0c40\u0003\u023e\u011f\u0000\u0c3f\u0c3d\u0001\u0000\u0000\u0000"+
		"\u0c40\u0c43\u0001\u0000\u0000\u0000\u0c41\u0c3f\u0001\u0000\u0000\u0000"+
		"\u0c41\u0c42\u0001\u0000\u0000\u0000\u0c42\u023d\u0001\u0000\u0000\u0000"+
		"\u0c43\u0c41\u0001\u0000\u0000\u0000\u0c44\u0c45\u0003\u0240\u0120\u0000"+
		"\u0c45\u0c46\u0005\u0001\u0000\u0000\u0c46\u0c47\u0003\u0242\u0121\u0000"+
		"\u0c47\u023f\u0001\u0000\u0000\u0000\u0c48\u0c49\u0003\u010e\u0087\u0000"+
		"\u0c49\u0241\u0001\u0000\u0000\u0000\u0c4a\u0c4b\u0005\u00f8\u0000\u0000"+
		"\u0c4b\u0c4c\u0003\u0244\u0122\u0000\u0c4c\u0c4d\u0005\u00f9\u0000\u0000"+
		"\u0c4d\u0243\u0001\u0000\u0000\u0000\u0c4e\u0c50\u0003\u0246\u0123\u0000"+
		"\u0c4f\u0c4e\u0001\u0000\u0000\u0000\u0c4f\u0c50\u0001\u0000\u0000\u0000"+
		"\u0c50\u0c52\u0001\u0000\u0000\u0000\u0c51\u0c53\u0003\u0248\u0124\u0000"+
		"\u0c52\u0c51\u0001\u0000\u0000\u0000\u0c52\u0c53\u0001\u0000\u0000\u0000"+
		"\u0c53\u0c55\u0001\u0000\u0000\u0000\u0c54\u0c56\u0003\u024a\u0125\u0000"+
		"\u0c55\u0c54\u0001\u0000\u0000\u0000\u0c55\u0c56\u0001\u0000\u0000\u0000"+
		"\u0c56\u0c58\u0001\u0000\u0000\u0000\u0c57\u0c59\u0003\u024c\u0126\u0000"+
		"\u0c58\u0c57\u0001\u0000\u0000\u0000\u0c58\u0c59\u0001\u0000\u0000\u0000"+
		"\u0c59\u0245\u0001\u0000\u0000\u0000\u0c5a\u0c5b\u0003\u0240\u0120\u0000"+
		"\u0c5b\u0247\u0001\u0000\u0000\u0000\u0c5c\u0c5d\u0005\u0096\u0000\u0000"+
		"\u0c5d\u0c5e\u0005R\u0000\u0000\u0c5e\u0c5f\u0003\u0238\u011c\u0000\u0c5f"+
		"\u0249\u0001\u0000\u0000\u0000\u0c60\u0c61\u0003\u02d0\u0168\u0000\u0c61"+
		"\u024b\u0001\u0000\u0000\u0000\u0c62\u0c63\u0003\u024e\u0127\u0000\u0c63"+
		"\u0c65\u0003\u0250\u0128\u0000\u0c64\u0c66\u0003\u0258\u012c\u0000\u0c65"+
		"\u0c64\u0001\u0000\u0000\u0000\u0c65\u0c66\u0001\u0000\u0000\u0000\u0c66"+
		"\u024d\u0001\u0000\u0000\u0000\u0c67\u0c68\u0007\u0013\u0000\u0000\u0c68"+
		"\u024f\u0001\u0000\u0000\u0000\u0c69\u0c6c\u0003\u0252\u0129\u0000\u0c6a"+
		"\u0c6c\u0003\u0254\u012a\u0000\u0c6b\u0c69\u0001\u0000\u0000\u0000\u0c6b"+
		"\u0c6a\u0001\u0000\u0000\u0000\u0c6c\u0251\u0001\u0000\u0000\u0000\u0c6d"+
		"\u0c6e\u0005\u00b8\u0000\u0000\u0c6e\u0c75\u0005\u0099\u0000\u0000\u0c6f"+
		"\u0c70\u0003\u0146\u00a3\u0000\u0c70\u0c71\u0005\u0099\u0000\u0000\u0c71"+
		"\u0c75\u0001\u0000\u0000\u0000\u0c72\u0c73\u0005]\u0000\u0000\u0c73\u0c75"+
		"\u0005\u00a4\u0000\u0000\u0c74\u0c6d\u0001\u0000\u0000\u0000\u0c74\u0c6f"+
		"\u0001\u0000\u0000\u0000\u0c74\u0c72\u0001\u0000\u0000\u0000\u0c75\u0253"+
		"\u0001\u0000\u0000\u0000\u0c76\u0c77\u0005Q\u0000\u0000\u0c77\u0c78\u0003"+
		"\u0252\u0129\u0000\u0c78\u0c79\u0005\u0003\u0000\u0000\u0c79\u0c7a\u0003"+
		"\u0256\u012b\u0000\u0c7a\u0255\u0001\u0000\u0000\u0000\u0c7b\u0c7c\u0005"+
		"\u00b8\u0000\u0000\u0c7c\u0c83\u0005u\u0000\u0000\u0c7d\u0c7e\u0003\u0146"+
		"\u00a3\u0000\u0c7e\u0c7f\u0005u\u0000\u0000\u0c7f\u0c83\u0001\u0000\u0000"+
		"\u0000\u0c80\u0c81\u0005]\u0000\u0000\u0c81\u0c83\u0005\u00a4\u0000\u0000"+
		"\u0c82\u0c7b\u0001\u0000\u0000\u0000\u0c82\u0c7d\u0001\u0000\u0000\u0000"+
		"\u0c82\u0c80\u0001\u0000\u0000\u0000\u0c83\u0257\u0001\u0000\u0000\u0000"+
		"\u0c84\u0c85\u0005m\u0000\u0000\u0c85\u0c86\u0005]\u0000\u0000\u0c86\u0c8f"+
		"\u0005\u00a4\u0000\u0000\u0c87\u0c88\u0005m\u0000\u0000\u0c88\u0c8f\u0005"+
		"\u0018\u0000\u0000\u0c89\u0c8a\u0005m\u0000\u0000\u0c8a\u0c8f\u0005\u00b1"+
		"\u0000\u0000\u0c8b\u0c8c\u0005m\u0000\u0000\u0c8c\u0c8d\u0005\u0093\u0000"+
		"\u0000\u0c8d\u0c8f\u0005\u0095\u0000\u0000\u0c8e\u0c84\u0001\u0000\u0000"+
		"\u0000\u0c8e\u0c87\u0001\u0000\u0000\u0000\u0c8e\u0c89\u0001\u0000\u0000"+
		"\u0000\u0c8e\u0c8b\u0001\u0000\u0000\u0000\u0c8f\u0259\u0001\u0000\u0000"+
		"\u0000\u0c90\u0c91\u0005\u016b\u0000\u0000\u0c91\u0c92\u0005\u0001\u0000"+
		"\u0000\u0c92\u0c93\u0005\u00f8\u0000\u0000\u0c93\u0c94\u0003\u0260\u0130"+
		"\u0000\u0c94\u0c95\u0005\u00f9\u0000\u0000\u0c95\u025b\u0001\u0000\u0000"+
		"\u0000\u0c96\u0c97\u0005@\u0000\u0000\u0c97\u0c9c\u0003\u025a\u012d\u0000"+
		"\u0c98\u0c99\u0005\u00f1\u0000\u0000\u0c99\u0c9b\u0003\u025a\u012d\u0000"+
		"\u0c9a\u0c98\u0001\u0000\u0000\u0000\u0c9b\u0c9e\u0001\u0000\u0000\u0000"+
		"\u0c9c\u0c9a\u0001\u0000\u0000\u0000\u0c9c\u0c9d\u0001\u0000\u0000\u0000"+
		"\u0c9d\u025d\u0001\u0000\u0000\u0000\u0c9e\u0c9c\u0001\u0000\u0000\u0000"+
		"\u0c9f\u0ca1\u0003\u025c\u012e\u0000\u0ca0\u0c9f\u0001\u0000\u0000\u0000"+
		"\u0ca0\u0ca1\u0001\u0000\u0000\u0000\u0ca1\u0ca2\u0001\u0000\u0000\u0000"+
		"\u0ca2\u0ca3\u0003\u0260\u0130\u0000\u0ca3\u025f\u0001\u0000\u0000\u0000"+
		"\u0ca4\u0ca7\u0003\u0262\u0131\u0000\u0ca5\u0ca7\u0003\u01fa\u00fd\u0000"+
		"\u0ca6\u0ca4\u0001\u0000\u0000\u0000\u0ca6\u0ca5\u0001\u0000\u0000\u0000"+
		"\u0ca7\u0261\u0001\u0000\u0000\u0000\u0ca8\u0cb1\u0003\u0266\u0133\u0000"+
		"\u0ca9\u0caa\u0003\u01fa\u00fd\u0000\u0caa\u0cac\u0007\u0014\u0000\u0000"+
		"\u0cab\u0cad\u0007\u0015\u0000\u0000\u0cac\u0cab\u0001\u0000\u0000\u0000"+
		"\u0cac\u0cad\u0001\u0000\u0000\u0000\u0cad\u0cae\u0001\u0000\u0000\u0000"+
		"\u0cae\u0caf\u0003\u0264\u0132\u0000\u0caf\u0cb1\u0001\u0000\u0000\u0000"+
		"\u0cb0\u0ca8\u0001\u0000\u0000\u0000\u0cb0\u0ca9\u0001\u0000\u0000\u0000"+
		"\u0cb1\u0cbf\u0001\u0000\u0000\u0000\u0cb2\u0cb4\u0003\u00fe\u007f\u0000"+
		"\u0cb3\u0cb2\u0001\u0000\u0000\u0000\u0cb4\u0cb7\u0001\u0000\u0000\u0000"+
		"\u0cb5\u0cb3\u0001\u0000\u0000\u0000\u0cb5\u0cb6\u0001\u0000\u0000\u0000"+
		"\u0cb6\u0cb8\u0001\u0000\u0000\u0000\u0cb7\u0cb5\u0001\u0000\u0000\u0000"+
		"\u0cb8\u0cba\u0007\u0014\u0000\u0000\u0cb9\u0cbb\u0007\u0015\u0000\u0000"+
		"\u0cba\u0cb9\u0001\u0000\u0000\u0000\u0cba\u0cbb\u0001\u0000\u0000\u0000"+
		"\u0cbb\u0cbc\u0001\u0000\u0000\u0000\u0cbc\u0cbe\u0003\u0264\u0132\u0000"+
		"\u0cbd\u0cb5\u0001\u0000\u0000\u0000\u0cbe\u0cc1\u0001\u0000\u0000\u0000"+
		"\u0cbf\u0cbd\u0001\u0000\u0000\u0000\u0cbf\u0cc0\u0001\u0000\u0000\u0000"+
		"\u0cc0\u0263\u0001\u0000\u0000\u0000\u0cc1\u0cbf\u0001\u0000\u0000\u0000"+
		"\u0cc2\u0cc5\u0003\u0266\u0133\u0000\u0cc3\u0cc5\u0003\u01fa\u00fd\u0000"+
		"\u0cc4\u0cc2\u0001\u0000\u0000\u0000\u0cc4\u0cc3\u0001\u0000\u0000\u0000"+
		"\u0cc5\u0265\u0001\u0000\u0000\u0000\u0cc6\u0cd5\u0003\u026a\u0135\u0000"+
		"\u0cc7\u0ccb\u0003\u01fa\u00fd\u0000\u0cc8\u0cca\u0003\u00fe\u007f\u0000"+
		"\u0cc9\u0cc8\u0001\u0000\u0000\u0000\u0cca\u0ccd\u0001\u0000\u0000\u0000"+
		"\u0ccb\u0cc9\u0001\u0000\u0000\u0000\u0ccb\u0ccc\u0001\u0000\u0000\u0000"+
		"\u0ccc\u0cce\u0001\u0000\u0000\u0000\u0ccd\u0ccb\u0001\u0000\u0000\u0000"+
		"\u0cce\u0cd0\u0005\u001d\u0000\u0000\u0ccf\u0cd1\u0007\u0015\u0000\u0000"+
		"\u0cd0\u0ccf\u0001\u0000\u0000\u0000\u0cd0\u0cd1\u0001\u0000\u0000\u0000"+
		"\u0cd1\u0cd2\u0001\u0000\u0000\u0000\u0cd2\u0cd3\u0003\u0268\u0134\u0000"+
		"\u0cd3\u0cd5\u0001\u0000\u0000\u0000\u0cd4\u0cc6\u0001\u0000\u0000\u0000"+
		"\u0cd4\u0cc7\u0001\u0000\u0000\u0000\u0cd5\u0cdd\u0001\u0000\u0000\u0000"+
		"\u0cd6\u0cd8\u0005\u001d\u0000\u0000\u0cd7\u0cd9\u0007\u0015\u0000\u0000"+
		"\u0cd8\u0cd7\u0001\u0000\u0000\u0000\u0cd8\u0cd9\u0001\u0000\u0000\u0000"+
		"\u0cd9\u0cda\u0001\u0000\u0000\u0000\u0cda\u0cdc\u0003\u0268\u0134\u0000"+
		"\u0cdb\u0cd6\u0001\u0000\u0000\u0000\u0cdc\u0cdf\u0001\u0000\u0000\u0000"+
		"\u0cdd\u0cdb\u0001\u0000\u0000\u0000\u0cdd\u0cde\u0001\u0000\u0000\u0000"+
		"\u0cde\u0267\u0001\u0000\u0000\u0000\u0cdf\u0cdd\u0001\u0000\u0000\u0000"+
		"\u0ce0\u0ce3\u0003\u026a\u0135\u0000\u0ce1\u0ce3\u0003\u01fa\u00fd\u0000"+
		"\u0ce2\u0ce0\u0001\u0000\u0000\u0000\u0ce2\u0ce1\u0001\u0000\u0000\u0000"+
		"\u0ce3\u0269\u0001\u0000\u0000\u0000\u0ce4\u0cea\u0003\u026c\u0136\u0000"+
		"\u0ce5\u0ce6\u0005\u00f8\u0000\u0000\u0ce6\u0ce7\u0003\u0262\u0131\u0000"+
		"\u0ce7\u0ce8\u0005\u00f9\u0000\u0000\u0ce8\u0cea\u0001\u0000\u0000\u0000"+
		"\u0ce9\u0ce4\u0001\u0000\u0000\u0000\u0ce9\u0ce5\u0001\u0000\u0000\u0000"+
		"\u0cea\u026b\u0001\u0000\u0000\u0000\u0ceb\u0cee\u0003\u027c\u013e\u0000"+
		"\u0cec\u0cee\u0003\u026e\u0137\u0000\u0ced\u0ceb\u0001\u0000\u0000\u0000"+
		"\u0ced\u0cec\u0001\u0000\u0000\u0000\u0cee\u026d\u0001\u0000\u0000\u0000"+
		"\u0cef\u0cf0\u00057\u0000\u0000\u0cf0\u0cf1\u0003\u0270\u0138\u0000\u0cf1"+
		"\u026f\u0001\u0000\u0000\u0000\u0cf2\u0cf5\u0003\u0272\u0139\u0000\u0cf3"+
		"\u0cf5\u0003\u010e\u0087\u0000\u0cf4\u0cf2\u0001\u0000\u0000\u0000\u0cf4"+
		"\u0cf3\u0001\u0000\u0000\u0000\u0cf5\u0271\u0001\u0000\u0000\u0000\u0cf6"+
		"\u0cfd\u0003\u010e\u0087\u0000\u0cf7\u0cf8\u0005\u00ff\u0000\u0000\u0cf8"+
		"\u0cfb\u0003\u010e\u0087\u0000\u0cf9\u0cfa\u0005\u00ff\u0000\u0000\u0cfa"+
		"\u0cfc\u0003\u010e\u0087\u0000\u0cfb\u0cf9\u0001\u0000\u0000\u0000\u0cfb"+
		"\u0cfc\u0001\u0000\u0000\u0000\u0cfc\u0cfe\u0001\u0000\u0000\u0000\u0cfd"+
		"\u0cf7\u0001\u0000\u0000\u0000\u0cfd\u0cfe\u0001\u0000\u0000\u0000\u0cfe"+
		"\u0d01\u0001\u0000\u0000\u0000\u0cff\u0d01\u0003\u0278\u013c\u0000\u0d00"+
		"\u0cf6\u0001\u0000\u0000\u0000\u0d00\u0cff\u0001\u0000\u0000\u0000\u0d01"+
		"\u0273\u0001\u0000\u0000\u0000\u0d02\u0d03\u0003\u010e\u0087\u0000\u0d03"+
		"\u0275\u0001\u0000\u0000\u0000\u0d04\u0d07\u0003\u010e\u0087\u0000\u0d05"+
		"\u0d06\u0005\u00ff\u0000\u0000\u0d06\u0d08\u0003\u010e\u0087\u0000\u0d07"+
		"\u0d05\u0001\u0000\u0000\u0000\u0d08\u0d09\u0001\u0000\u0000\u0000\u0d09"+
		"\u0d07\u0001\u0000\u0000\u0000\u0d09\u0d0a\u0001\u0000\u0000\u0000\u0d0a"+
		"\u0277\u0001\u0000\u0000\u0000\u0d0b\u0d0c\u0003\u010e\u0087\u0000\u0d0c"+
		"\u0d0d\u0005\u00ff\u0000\u0000\u0d0d\u0d0e\u0003\u010e\u0087\u0000\u0d0e"+
		"\u0d0f\u0005\u00ff\u0000\u0000\u0d0f\u0d14\u0003\u010e\u0087\u0000\u0d10"+
		"\u0d11\u0005\u00ff\u0000\u0000\u0d11\u0d13\u0003\u010e\u0087\u0000\u0d12"+
		"\u0d10\u0001\u0000\u0000\u0000\u0d13\u0d16\u0001\u0000\u0000\u0000\u0d14"+
		"\u0d12\u0001\u0000\u0000\u0000\u0d14\u0d15\u0001\u0000\u0000\u0000\u0d15"+
		"\u0279\u0001\u0000\u0000\u0000\u0d16\u0d14\u0001\u0000\u0000\u0000\u0d17"+
		"\u0d18\u0005\u0167\u0000\u0000\u0d18\u0d1d\u0003\u010e\u0087\u0000\u0d19"+
		"\u0d1a\u0005\u00f8\u0000\u0000\u0d1a\u0d1b\u0003\u010e\u0087\u0000\u0d1b"+
		"\u0d1c\u0005\u00f9\u0000\u0000\u0d1c\u0d1e\u0001\u0000\u0000\u0000\u0d1d"+
		"\u0d19\u0001\u0000\u0000\u0000\u0d1d\u0d1e\u0001\u0000\u0000\u0000\u0d1e"+
		"\u0d1f\u0001\u0000\u0000\u0000\u0d1f\u0d20\u0005\u0168\u0000\u0000\u0d20"+
		"\u027b\u0001\u0000\u0000\u0000\u0d21\u0d23\u0003\u00fe\u007f\u0000\u0d22"+
		"\u0d21\u0001\u0000\u0000\u0000\u0d23\u0d26\u0001\u0000\u0000\u0000\u0d24"+
		"\u0d22\u0001\u0000\u0000\u0000\u0d24\u0d25\u0001\u0000\u0000\u0000\u0d25"+
		"\u0d27\u0001\u0000\u0000\u0000\u0d26\u0d24\u0001\u0000\u0000\u0000\u0d27"+
		"\u0d29\u00053\u0000\u0000\u0d28\u0d2a\u0003\u027a\u013d\u0000\u0d29\u0d28"+
		"\u0001\u0000\u0000\u0000\u0d29\u0d2a\u0001\u0000\u0000\u0000\u0d2a\u0d2c"+
		"\u0001\u0000\u0000\u0000\u0d2b\u0d2d\u0003\u0286\u0143\u0000\u0d2c\u0d2b"+
		"\u0001\u0000\u0000\u0000\u0d2c\u0d2d\u0001\u0000\u0000\u0000\u0d2d\u0d2e"+
		"\u0001\u0000\u0000\u0000\u0d2e\u0d30\u0003\u027e\u013f\u0000\u0d2f\u0d31"+
		"\u0003\u01dc\u00ee\u0000\u0d30\u0d2f\u0001\u0000\u0000\u0000\u0d30\u0d31"+
		"\u0001\u0000\u0000\u0000\u0d31\u027d\u0001\u0000\u0000\u0000\u0d32\u0d37"+
		"\u0003\u0280\u0140\u0000\u0d33\u0d34\u0005\u00f1\u0000\u0000\u0d34\u0d36"+
		"\u0003\u0280\u0140\u0000\u0d35\u0d33\u0001\u0000\u0000\u0000\u0d36\u0d39"+
		"\u0001\u0000\u0000\u0000\u0d37\u0d35\u0001\u0000\u0000\u0000\u0d37\u0d38"+
		"\u0001\u0000\u0000\u0000\u0d38\u027f\u0001\u0000\u0000\u0000\u0d39\u0d37"+
		"\u0001\u0000\u0000\u0000\u0d3a\u0d3d\u0003\u0282\u0141\u0000\u0d3b\u0d3d"+
		"\u0003\u0284\u0142\u0000\u0d3c\u0d3a\u0001\u0000\u0000\u0000\u0d3c\u0d3b"+
		"\u0001\u0000\u0000\u0000\u0d3d\u0281\u0001\u0000\u0000\u0000\u0d3e\u0d40"+
		"\u0003\u00fe\u007f\u0000\u0d3f\u0d3e\u0001\u0000\u0000\u0000\u0d40\u0d43"+
		"\u0001\u0000\u0000\u0000\u0d41\u0d3f\u0001\u0000\u0000\u0000\u0d41\u0d42"+
		"\u0001\u0000\u0000\u0000\u0d42\u0d44\u0001\u0000\u0000\u0000\u0d43\u0d41"+
		"\u0001\u0000\u0000\u0000\u0d44\u0d46\u0003\u017e\u00bf\u0000\u0d45\u0d47"+
		"\u0003\u028a\u0145\u0000\u0d46\u0d45\u0001\u0000\u0000\u0000\u0d46\u0d47"+
		"\u0001\u0000\u0000\u0000\u0d47\u0283\u0001\u0000\u0000\u0000\u0d48\u0d49"+
		"\u0003\u010e\u0087\u0000\u0d49\u0d4a\u0005\u00ff\u0000\u0000\u0d4a\u0d4c"+
		"\u0001\u0000\u0000\u0000\u0d4b\u0d48\u0001\u0000\u0000\u0000\u0d4b\u0d4c"+
		"\u0001\u0000\u0000\u0000\u0d4c\u0d4d\u0001\u0000\u0000\u0000\u0d4d\u0d4e"+
		"\u0005\u00fc\u0000\u0000\u0d4e\u0285\u0001\u0000\u0000\u0000\u0d4f\u0d50"+
		"\u0007\u0015\u0000\u0000\u0d50\u0287\u0001\u0000\u0000\u0000\u0d51\u0d52"+
		"\u0003\u010e\u0087\u0000\u0d52\u0d53\u0005\u00ff\u0000\u0000\u0d53\u0d55"+
		"\u0001\u0000\u0000\u0000\u0d54\u0d51\u0001\u0000\u0000\u0000\u0d54\u0d55"+
		"\u0001\u0000\u0000\u0000\u0d55\u0d56\u0001\u0000\u0000\u0000\u0d56\u0d57"+
		"\u0003\u010e\u0087\u0000\u0d57\u0d58\u0005\u00ff\u0000\u0000\u0d58\u0d5a"+
		"\u0001\u0000\u0000\u0000\u0d59\u0d54\u0001\u0000\u0000\u0000\u0d59\u0d5a"+
		"\u0001\u0000\u0000\u0000\u0d5a\u0d5b\u0001\u0000\u0000\u0000\u0d5b\u0d5c"+
		"\u0003\u010e\u0087\u0000\u0d5c\u0289\u0001\u0000\u0000\u0000\u0d5d\u0d5f"+
		"\u0005\u0001\u0000\u0000\u0d5e\u0d5d\u0001\u0000\u0000\u0000\u0d5e\u0d5f"+
		"\u0001\u0000\u0000\u0000\u0d5f\u0d60\u0001\u0000\u0000\u0000\u0d60\u0d61"+
		"\u0003\u010e\u0087\u0000\u0d61\u028b\u0001\u0000\u0000\u0000\u0d62\u0d67"+
		"\u0003\u0288\u0144\u0000\u0d63\u0d64\u0005\u00f1\u0000\u0000\u0d64\u0d66"+
		"\u0003\u0288\u0144\u0000\u0d65\u0d63\u0001\u0000\u0000\u0000\u0d66\u0d69"+
		"\u0001\u0000\u0000\u0000\u0d67\u0d65\u0001\u0000\u0000\u0000\u0d67\u0d68"+
		"\u0001\u0000\u0000\u0000\u0d68\u028d\u0001\u0000\u0000\u0000\u0d69\u0d67"+
		"\u0001\u0000\u0000\u0000\u0d6a\u0d6b\u0005\u013e\u0000\u0000\u0d6b\u0d6c"+
		"\u0003\u0294\u014a\u0000\u0d6c\u028f\u0001\u0000\u0000\u0000\u0d6d\u0d6e"+
		"\u0003\u0296\u014b\u0000\u0d6e\u0291\u0001\u0000\u0000\u0000\u0d6f\u0d70"+
		"\u0003\u0296\u014b\u0000\u0d70\u0293\u0001\u0000\u0000\u0000\u0d71\u0d72"+
		"\u0003\u0296\u014b\u0000\u0d72\u0295\u0001\u0000\u0000\u0000\u0d73\u0d74"+
		"\u0005\u00f8\u0000\u0000\u0d74\u0d75\u0003\u025e\u012f\u0000\u0d75\u0d76"+
		"\u0005\u00f9\u0000\u0000\u0d76\u0297\u0001\u0000\u0000\u0000\u0d77\u0d7f"+
		"\u0003\u029a\u014d\u0000\u0d78\u0d7f\u0003\u02a2\u0151\u0000\u0d79\u0d7f"+
		"\u0003\u02a6\u0153\u0000\u0d7a\u0d7f\u0003\u02aa\u0155\u0000\u0d7b\u0d7f"+
		"\u0003\u02b0\u0158\u0000\u0d7c\u0d7f\u0003\u02b8\u015c\u0000\u0d7d\u0d7f"+
		"\u0003\u02ba\u015d\u0000\u0d7e\u0d77\u0001\u0000\u0000\u0000\u0d7e\u0d78"+
		"\u0001\u0000\u0000\u0000\u0d7e\u0d79\u0001\u0000\u0000\u0000\u0d7e\u0d7a"+
		"\u0001\u0000\u0000\u0000\u0d7e\u0d7b\u0001\u0000\u0000\u0000\u0d7e\u0d7c"+
		"\u0001\u0000\u0000\u0000\u0d7e\u0d7d\u0001\u0000\u0000\u0000\u0d7f\u0299"+
		"\u0001\u0000\u0000\u0000\u0d80\u0d81\u0003\u0180\u00c0\u0000\u0d81\u0d83"+
		"\u0003\u02a4\u0152\u0000\u0d82\u0d84\u0003\u029c\u014e\u0000\u0d83\u0d82"+
		"\u0001\u0000\u0000\u0000\u0d83\u0d84\u0001\u0000\u0000\u0000\u0d84\u0d85"+
		"\u0001\u0000\u0000\u0000\u0d85\u0d86\u0003\u0294\u014a\u0000\u0d86\u029b"+
		"\u0001\u0000\u0000\u0000\u0d87\u0d8a\u0003\u029e\u014f\u0000\u0d88\u0d8a"+
		"\u0003\u02a0\u0150\u0000\u0d89\u0d87\u0001\u0000\u0000\u0000\u0d89\u0d88"+
		"\u0001\u0000\u0000\u0000\u0d8a\u029d\u0001\u0000\u0000\u0000\u0d8b\u0d8c"+
		"\u0005\u0002\u0000\u0000\u0d8c\u029f\u0001\u0000\u0000\u0000\u0d8d\u0d8e"+
		"\u0007\u0016\u0000\u0000\u0d8e\u02a1\u0001\u0000\u0000\u0000\u0d8f\u0d90"+
		"\u0003\u01d8\u00ec\u0000\u0d90\u0d91\u0003\u02a4\u0152\u0000\u0d91\u0d92"+
		"\u0003\u01d8\u00ec\u0000\u0d92\u02a3\u0001\u0000\u0000\u0000\u0d93\u0d94"+
		"\u0007\u0017\u0000\u0000\u0d94\u02a5\u0001\u0000\u0000\u0000\u0d95\u0d96"+
		"\u0003\u01d8\u00ec\u0000\u0d96\u0d97\u0003\u02a8\u0154\u0000\u0d97\u02a7"+
		"\u0001\u0000\u0000\u0000\u0d98\u0d9a\u0005\'\u0000\u0000\u0d99\u0d98\u0001"+
		"\u0000\u0000\u0000\u0d99\u0d9a\u0001\u0000\u0000\u0000\u0d9a\u0d9b\u0001"+
		"\u0000\u0000\u0000\u0d9b\u0d9d\u0005Q\u0000\u0000\u0d9c\u0d9e\u0007\u0018"+
		"\u0000\u0000\u0d9d\u0d9c\u0001\u0000\u0000\u0000\u0d9d\u0d9e\u0001\u0000"+
		"\u0000\u0000\u0d9e\u0d9f\u0001\u0000\u0000\u0000\u0d9f\u0da0\u0003\u01d8"+
		"\u00ec\u0000\u0da0\u0da1\u0005\u0003\u0000\u0000\u0da1\u0da2\u0003\u01d8"+
		"\u00ec\u0000\u0da2\u02a9\u0001\u0000\u0000\u0000\u0da3\u0da5\u0003\u0180"+
		"\u00c0\u0000\u0da4\u0da6\u0005\'\u0000\u0000\u0da5\u0da4\u0001\u0000\u0000"+
		"\u0000\u0da5\u0da6\u0001\u0000\u0000\u0000\u0da6\u0da7\u0001\u0000\u0000"+
		"\u0000\u0da7\u0da8\u0005\u001b\u0000\u0000\u0da8\u0da9\u0003\u02ac\u0156"+
		"\u0000\u0da9\u0db4\u0001\u0000\u0000\u0000\u0daa\u0dab\u0005\u00f8\u0000"+
		"\u0000\u0dab\u0dac\u0003\u0238\u011c\u0000\u0dac\u0dae\u0005\u00f9\u0000"+
		"\u0000\u0dad\u0daf\u0005\'\u0000\u0000\u0dae\u0dad\u0001\u0000\u0000\u0000"+
		"\u0dae\u0daf\u0001\u0000\u0000\u0000\u0daf\u0db0\u0001\u0000\u0000\u0000"+
		"\u0db0\u0db1\u0005\u001b\u0000\u0000\u0db1\u0db2\u0003\u02ac\u0156\u0000"+
		"\u0db2\u0db4\u0001\u0000\u0000\u0000\u0db3\u0da3\u0001\u0000\u0000\u0000"+
		"\u0db3\u0daa\u0001\u0000\u0000\u0000\u0db4\u02ab\u0001\u0000\u0000\u0000"+
		"\u0db5\u0dbb\u0003\u0294\u014a\u0000\u0db6\u0db7\u0005\u00f8\u0000\u0000"+
		"\u0db7\u0db8\u0003\u02ae\u0157\u0000\u0db8\u0db9\u0005\u00f9\u0000\u0000"+
		"\u0db9\u0dbb\u0001\u0000\u0000\u0000\u0dba\u0db5\u0001\u0000\u0000\u0000"+
		"\u0dba\u0db6\u0001\u0000\u0000\u0000\u0dbb\u02ad\u0001\u0000\u0000\u0000"+
		"\u0dbc\u0dc1\u0003\u01d8\u00ec\u0000\u0dbd\u0dbe\u0005\u00f1\u0000\u0000"+
		"\u0dbe\u0dc0\u0003\u01d8\u00ec\u0000\u0dbf\u0dbd\u0001\u0000\u0000\u0000"+
		"\u0dc0\u0dc3\u0001\u0000\u0000\u0000\u0dc1\u0dbf\u0001\u0000\u0000\u0000"+
		"\u0dc1\u0dc2\u0001\u0000\u0000\u0000\u0dc2\u02af\u0001\u0000\u0000\u0000"+
		"\u0dc3\u0dc1\u0001\u0000\u0000\u0000\u0dc4\u0dc5\u0003\u01d8\u00ec\u0000"+
		"\u0dc5\u0dc6\u0003\u02b2\u0159\u0000\u0dc6\u0dc7\u0003\u01d8\u00ec\u0000"+
		"\u0dc7\u02b1\u0001\u0000\u0000\u0000\u0dc8\u0dca\u0005\'\u0000\u0000\u0dc9"+
		"\u0dc8\u0001\u0000\u0000\u0000\u0dc9\u0dca\u0001\u0000\u0000\u0000\u0dca"+
		"\u0dcb\u0001\u0000\u0000\u0000\u0dcb\u0dce\u0003\u02b4\u015a\u0000\u0dcc"+
		"\u0dce\u0003\u02b6\u015b\u0000\u0dcd\u0dc9\u0001\u0000\u0000\u0000\u0dcd"+
		"\u0dcc\u0001\u0000\u0000\u0000\u0dce\u02b3\u0001\u0000\u0000\u0000\u0dcf"+
		"\u0dd6\u0005#\u0000\u0000\u0dd0\u0dd6\u0005\u001a\u0000\u0000\u0dd1\u0dd2"+
		"\u0005\u00aa\u0000\u0000\u0dd2\u0dd6\u0005\u00b6\u0000\u0000\u0dd3\u0dd6"+
		"\u0005\u009f\u0000\u0000\u0dd4\u0dd6\u0005\u00a2\u0000\u0000\u0dd5\u0dcf"+
		"\u0001\u0000\u0000\u0000\u0dd5\u0dd0\u0001\u0000\u0000\u0000\u0dd5\u0dd1"+
		"\u0001\u0000\u0000\u0000\u0dd5\u0dd3\u0001\u0000\u0000\u0000\u0dd5\u0dd4"+
		"\u0001\u0000\u0000\u0000\u0dd6\u02b5\u0001\u0000\u0000\u0000\u0dd7\u0dd8"+
		"\u0007\u0019\u0000\u0000\u0dd8\u02b7\u0001\u0000\u0000\u0000\u0dd9\u0dda"+
		"\u0003\u01d8\u00ec\u0000\u0dda\u0ddc\u0005\u001f\u0000\u0000\u0ddb\u0ddd"+
		"\u0005\'\u0000\u0000\u0ddc\u0ddb\u0001\u0000\u0000\u0000\u0ddc\u0ddd\u0001"+
		"\u0000\u0000\u0000\u0ddd\u0dde\u0001\u0000\u0000\u0000\u0dde\u0ddf\u0005"+
		"(\u0000\u0000\u0ddf\u02b9\u0001\u0000\u0000\u0000\u0de0\u0de2\u0005\'"+
		"\u0000\u0000\u0de1\u0de0\u0001\u0000\u0000\u0000\u0de1\u0de2\u0001\u0000"+
		"\u0000\u0000\u0de2\u0de3\u0001\u0000\u0000\u0000\u0de3\u0de4\u0005n\u0000"+
		"\u0000\u0de4\u0de5\u0003\u0294\u014a\u0000\u0de5\u02bb\u0001\u0000\u0000"+
		"\u0000\u0de6\u0de7\u0005<\u0000\u0000\u0de7\u0de8\u0003\u0294\u014a\u0000"+
		"\u0de8\u02bd\u0001\u0000\u0000\u0000\u0de9\u0dec\u0003\u02c0\u0160\u0000"+
		"\u0dea\u0dec\u0005\u00a7\u0000\u0000\u0deb\u0de9\u0001\u0000\u0000\u0000"+
		"\u0deb\u0dea\u0001\u0000\u0000\u0000\u0dec\u02bf\u0001\u0000\u0000\u0000"+
		"\u0ded\u0dee\u0007\u001a\u0000\u0000\u0dee\u02c1\u0001\u0000\u0000\u0000"+
		"\u0def\u0df0\u0007\u001b\u0000\u0000\u0df0\u02c3\u0001\u0000\u0000\u0000"+
		"\u0df1\u0df2\u0003\u02ca\u0165\u0000\u0df2\u0df4\u0005\u00f8\u0000\u0000"+
		"\u0df3\u0df5\u0003\u02cc\u0166\u0000\u0df4\u0df3\u0001\u0000\u0000\u0000"+
		"\u0df4\u0df5\u0001\u0000\u0000\u0000\u0df5\u0df6\u0001\u0000\u0000\u0000"+
		"\u0df6\u0df7\u0005\u00f9\u0000\u0000\u0df7\u02c5\u0001\u0000\u0000\u0000"+
		"\u0df8\u0df9\u0007\u001c\u0000\u0000\u0df9\u02c7\u0001\u0000\u0000\u0000"+
		"\u0dfa\u0dfd\u0003\u010e\u0087\u0000\u0dfb\u0dfd\u0005\u013d\u0000\u0000"+
		"\u0dfc\u0dfa\u0001\u0000\u0000\u0000\u0dfc\u0dfb\u0001\u0000\u0000\u0000"+
		"\u0dfd\u02c9\u0001\u0000\u0000\u0000\u0dfe\u0dff\u0003\u02c8\u0164\u0000"+
		"\u0dff\u0e00\u0005\u00ff\u0000\u0000\u0e00\u0e02\u0001\u0000\u0000\u0000"+
		"\u0e01\u0dfe\u0001\u0000\u0000\u0000\u0e01\u0e02\u0001\u0000\u0000\u0000"+
		"\u0e02\u0e06\u0001\u0000\u0000\u0000\u0e03\u0e04\u0003\u010e\u0087\u0000"+
		"\u0e04\u0e05\u0005\u00ff\u0000\u0000\u0e05\u0e07\u0001\u0000\u0000\u0000"+
		"\u0e06\u0e03\u0001\u0000\u0000\u0000\u0e06\u0e07\u0001\u0000\u0000\u0000"+
		"\u0e07\u0e08\u0001\u0000\u0000\u0000\u0e08\u0e0b\u0003\u010e\u0087\u0000"+
		"\u0e09\u0e0b\u0003\u02c6\u0163\u0000\u0e0a\u0e01\u0001\u0000\u0000\u0000"+
		"\u0e0a\u0e09\u0001\u0000\u0000\u0000\u0e0b\u02cb\u0001\u0000\u0000\u0000"+
		"\u0e0c\u0e11\u0003\u017e\u00bf\u0000\u0e0d\u0e0e\u0005\u00f1\u0000\u0000"+
		"\u0e0e\u0e10\u0003\u017e\u00bf\u0000\u0e0f\u0e0d\u0001\u0000\u0000\u0000"+
		"\u0e10\u0e13\u0001\u0000\u0000\u0000\u0e11\u0e0f\u0001\u0000\u0000\u0000"+
		"\u0e11\u0e12\u0001\u0000\u0000\u0000\u0e12\u02cd\u0001\u0000\u0000\u0000"+
		"\u0e13\u0e11\u0001\u0000\u0000\u0000\u0e14\u0e15\u00057\u0000\u0000\u0e15"+
		"\u0e16\u0005\u00f8\u0000\u0000\u0e16\u0e17\u0003\u02c4\u0162\u0000\u0e17"+
		"\u0e18\u0005\u00f9\u0000\u0000\u0e18\u02cf\u0001\u0000\u0000\u0000\u0e19"+
		"\u0e1b\u0003\u00fe\u007f\u0000\u0e1a\u0e19\u0001\u0000\u0000\u0000\u0e1b"+
		"\u0e1e\u0001\u0000\u0000\u0000\u0e1c\u0e1a\u0001\u0000\u0000\u0000\u0e1c"+
		"\u0e1d\u0001\u0000\u0000\u0000\u0e1d\u0e1f\u0001\u0000\u0000\u0000\u0e1e"+
		"\u0e1c\u0001\u0000\u0000\u0000\u0e1f\u0e20\u0005+\u0000\u0000\u0e20\u0e21"+
		"\u0005R\u0000\u0000\u0e21\u0e22\u0003\u02d2\u0169\u0000\u0e22\u02d1\u0001"+
		"\u0000\u0000\u0000\u0e23\u0e28\u0003\u02d4\u016a\u0000\u0e24\u0e25\u0005"+
		"\u00f1\u0000\u0000\u0e25\u0e27\u0003\u02d4\u016a\u0000\u0e26\u0e24\u0001"+
		"\u0000\u0000\u0000\u0e27\u0e2a\u0001\u0000\u0000\u0000\u0e28\u0e26\u0001"+
		"\u0000\u0000\u0000\u0e28\u0e29\u0001\u0000\u0000\u0000\u0e29\u02d3\u0001"+
		"\u0000\u0000\u0000\u0e2a\u0e28\u0001\u0000\u0000\u0000\u0e2b\u0e2d\u0003"+
		"\u01d8\u00ec\u0000\u0e2c\u0e2e\u0003\u02d6\u016b\u0000\u0e2d\u0e2c\u0001"+
		"\u0000\u0000\u0000\u0e2d\u0e2e\u0001\u0000\u0000\u0000\u0e2e\u0e30\u0001"+
		"\u0000\u0000\u0000\u0e2f\u0e31\u0003\u02da\u016d\u0000\u0e30\u0e2f\u0001"+
		"\u0000\u0000\u0000\u0e30\u0e31\u0001\u0000\u0000\u0000\u0e31\u02d5\u0001"+
		"\u0000\u0000\u0000\u0e32\u0e33\u0007\u001d\u0000\u0000\u0e33\u02d7\u0001"+
		"\u0000\u0000\u0000\u0e34\u0e35\u0005$\u0000\u0000\u0e35\u0e36\u0003\u0182"+
		"\u00c1\u0000\u0e36\u02d9\u0001\u0000\u0000\u0000\u0e37\u0e38\u0005\u0108"+
		"\u0000\u0000\u0e38\u0e3c\u0005s\u0000\u0000\u0e39\u0e3a\u0005\u0108\u0000"+
		"\u0000\u0e3a\u0e3c\u0005\u0083\u0000\u0000\u0e3b\u0e37\u0001\u0000\u0000"+
		"\u0000\u0e3b\u0e39\u0001\u0000\u0000\u0000\u0e3c\u02db\u0001\u0000\u0000"+
		"\u0000\u0e3d\u0e3e\u0005\u0133\u0000\u0000\u0e3e\u0e3f\u0005\u016d\u0000"+
		"\u0000\u0e3f\u0e42\u0001\u0000\u0000\u0000\u0e40\u0e41\u0005\u0134\u0000"+
		"\u0000\u0e41\u0e43\u0005\u016b\u0000\u0000\u0e42\u0e40\u0001\u0000\u0000"+
		"\u0000\u0e42\u0e43\u0001\u0000\u0000\u0000\u0e43\u0e49\u0001\u0000\u0000"+
		"\u0000\u0e44\u0e45\u0005\u0135\u0000\u0000\u0e45\u0e46\u0005$\u0000\u0000"+
		"\u0e46\u0e47\u0003\u0148\u00a4\u0000\u0e47\u0e48\u0007\u001e\u0000\u0000"+
		"\u0e48\u0e4a\u0001\u0000\u0000\u0000\u0e49\u0e44\u0001\u0000\u0000\u0000"+
		"\u0e49\u0e4a\u0001\u0000\u0000\u0000\u0e4a\u02dd\u0001\u0000\u0000\u0000"+
		"\u0e4b\u0e4d\u0003\u00fe\u007f\u0000\u0e4c\u0e4b\u0001\u0000\u0000\u0000"+
		"\u0e4d\u0e50\u0001\u0000\u0000\u0000\u0e4e\u0e4c\u0001\u0000\u0000\u0000"+
		"\u0e4e\u0e4f\u0001\u0000\u0000\u0000\u0e4f\u0e51\u0001\u0000\u0000\u0000"+
		"\u0e50\u0e4e\u0001\u0000\u0000\u0000\u0e51\u0e53\u0005~\u0000\u0000\u0e52"+
		"\u0e54\u0005\u0094\u0000\u0000\u0e53\u0e52\u0001\u0000\u0000\u0000\u0e53"+
		"\u0e54\u0001\u0000\u0000\u0000\u0e54\u0e55\u0001\u0000\u0000\u0000\u0e55"+
		"\u0e56\u0005\u001e\u0000\u0000\u0e56\u0e58\u0003\u0272\u0139\u0000\u0e57"+
		"\u0e59\u0003\u010e\u0087\u0000\u0e58\u0e57\u0001\u0000\u0000\u0000\u0e58"+
		"\u0e59\u0001\u0000\u0000\u0000\u0e59\u0e5e\u0001\u0000\u0000\u0000\u0e5a"+
		"\u0e5b\u0005\u00f8\u0000\u0000\u0e5b\u0e5c\u0003\u021e\u010f\u0000\u0e5c"+
		"\u0e5d\u0005\u00f9\u0000\u0000\u0e5d\u0e5f\u0001\u0000\u0000\u0000\u0e5e"+
		"\u0e5a\u0001\u0000\u0000\u0000\u0e5e\u0e5f\u0001\u0000\u0000\u0000\u0e5f"+
		"\u0e61\u0001\u0000\u0000\u0000\u0e60\u0e62\u0003\u02dc\u016e\u0000\u0e61"+
		"\u0e60\u0001\u0000\u0000\u0000\u0e61\u0e62\u0001\u0000\u0000\u0000\u0e62"+
		"\u0e63\u0001\u0000\u0000\u0000\u0e63\u0e64\u0003\u025e\u012f\u0000\u0e64"+
		"\u0e75\u0001\u0000\u0000\u0000\u0e65\u0e67\u0005~\u0000\u0000\u0e66\u0e68"+
		"\u0005\u0094\u0000\u0000\u0e67\u0e66\u0001\u0000\u0000\u0000\u0e67\u0e68"+
		"\u0001\u0000\u0000\u0000\u0e68\u0e69\u0001\u0000\u0000\u0000\u0e69\u0e6a"+
		"\u0005\u001e\u0000\u0000\u0e6a\u0e6b\u0005\u0088\u0000\u0000\u0e6b\u0e71"+
		"\u0005\u016d\u0000\u0000\u0e6c\u0e6d\u0005=\u0000\u0000\u0e6d\u0e6f\u0003"+
		"\u010e\u0087\u0000\u0e6e\u0e70\u0003\u0090H\u0000\u0e6f\u0e6e\u0001\u0000"+
		"\u0000\u0000\u0e6f\u0e70\u0001\u0000\u0000\u0000\u0e70\u0e72\u0001\u0000"+
		"\u0000\u0000\u0e71\u0e6c\u0001\u0000\u0000\u0000\u0e71\u0e72\u0001\u0000"+
		"\u0000\u0000\u0e72\u0e73\u0001\u0000\u0000\u0000\u0e73\u0e75\u0003\u025e"+
		"\u012f\u0000\u0e74\u0e4e\u0001\u0000\u0000\u0000\u0e74\u0e65\u0001\u0000"+
		"\u0000\u0000\u0e75\u02df\u0001\u0000\u0000\u0000\u0e76\u0e7b\u0003\u017e"+
		"\u00bf\u0000\u0e77\u0e78\u0005\u00f1\u0000\u0000\u0e78\u0e7a\u0003\u017e"+
		"\u00bf\u0000\u0e79\u0e77\u0001\u0000\u0000\u0000\u0e7a\u0e7d\u0001\u0000"+
		"\u0000\u0000\u0e7b\u0e79\u0001\u0000\u0000\u0000\u0e7b\u0e7c\u0001\u0000"+
		"\u0000\u0000\u0e7c\u02e1\u0001\u0000\u0000\u0000\u0e7d\u0e7b\u0001\u0000"+
		"\u0000\u0000\u0e7e\u0e80\u0003\u00fe\u007f\u0000\u0e7f\u0e7e\u0001\u0000"+
		"\u0000\u0000\u0e80\u0e83\u0001\u0000\u0000\u0000\u0e81\u0e7f\u0001\u0000"+
		"\u0000\u0000\u0e81\u0e82\u0001\u0000\u0000\u0000\u0e82\u0e88\u0001\u0000"+
		"\u0000\u0000\u0e83\u0e81\u0001\u0000\u0000\u0000\u0e84\u0e85\u0005>\u0000"+
		"\u0000\u0e85\u0e86\u0003\u0224\u0112\u0000\u0e86\u0e87\u00058\u0000\u0000"+
		"\u0e87\u0e89\u0001\u0000\u0000\u0000\u0e88\u0e84\u0001\u0000\u0000\u0000"+
		"\u0e88\u0e89\u0001\u0000\u0000\u0000\u0e89\u0e8a\u0001\u0000\u0000\u0000"+
		"\u0e8a\u0e8b\u0005\u001e\u0000\u0000\u0e8b\u0e8d\u0003\u0272\u0139\u0000"+
		"\u0e8c\u0e8e\u0003\u010e\u0087\u0000\u0e8d\u0e8c\u0001\u0000\u0000\u0000"+
		"\u0e8d\u0e8e\u0001\u0000\u0000\u0000\u0e8e\u0e93\u0001\u0000\u0000\u0000"+
		"\u0e8f\u0e90\u0005\u00f8\u0000\u0000\u0e90\u0e91\u0003\u021e\u010f\u0000"+
		"\u0e91\u0e92\u0005\u00f9\u0000\u0000\u0e92\u0e94\u0001\u0000\u0000\u0000"+
		"\u0e93\u0e8f\u0001\u0000\u0000\u0000\u0e93\u0e94\u0001\u0000\u0000\u0000"+
		"\u0e94\u0e95\u0001\u0000\u0000\u0000\u0e95\u0e96\u0005\u00ba\u0000\u0000"+
		"\u0e96\u0e97\u0005\u00f8\u0000\u0000\u0e97\u0e98\u0003\u02e0\u0170\u0000"+
		"\u0e98\u0e99\u0005\u00f9\u0000\u0000\u0e99\u0e9b\u0001\u0000\u0000\u0000"+
		"\u0e9a\u0e9c\u0003\u02dc\u016e\u0000\u0e9b\u0e9a\u0001\u0000\u0000\u0000"+
		"\u0e9b\u0e9c\u0001\u0000\u0000\u0000\u0e9c\u02e3\u0001\u0000\u0000\u0000"+
		"\u0e9d\u0e9e\u0005\u0013\u0000\u0000\u0e9e\u0e9f\u0005\u001e\u0000\u0000"+
		"\u0e9f\u0ea1\u0003\u0272\u0139\u0000\u0ea0\u0ea2\u0003\u010e\u0087\u0000"+
		"\u0ea1\u0ea0\u0001\u0000\u0000\u0000\u0ea1\u0ea2\u0001\u0000\u0000\u0000"+
		"\u0ea2\u0ea7\u0001\u0000\u0000\u0000\u0ea3\u0ea4\u0005\u00f8\u0000\u0000"+
		"\u0ea4\u0ea5\u0003\u021e\u010f\u0000\u0ea5\u0ea6\u0005\u00f9\u0000\u0000"+
		"\u0ea6\u0ea8\u0001\u0000\u0000\u0000\u0ea7\u0ea3\u0001\u0000\u0000\u0000"+
		"\u0ea7\u0ea8\u0001\u0000\u0000\u0000\u0ea8\u0ea9\u0001\u0000\u0000\u0000"+
		"\u0ea9\u0eaa\u0005\u00ba\u0000\u0000\u0eaa\u0eab\u0005\u00f8\u0000\u0000"+
		"\u0eab\u0eac\u0003\u02e0\u0170\u0000\u0eac\u0ead\u0005\u00f9\u0000\u0000"+
		"\u0ead\u0eaf\u0001\u0000\u0000\u0000\u0eae\u0eb0\u0003\u02dc\u016e\u0000"+
		"\u0eaf\u0eae\u0001\u0000\u0000\u0000\u0eaf\u0eb0\u0001\u0000\u0000\u0000"+
		"\u0eb0\u02e5\u0001\u0000\u0000\u0000\u0eb1\u0eb3\u0003\u00fe\u007f\u0000"+
		"\u0eb2\u0eb1\u0001\u0000\u0000\u0000\u0eb3\u0eb6\u0001\u0000\u0000\u0000"+
		"\u0eb4\u0eb2\u0001\u0000\u0000\u0000\u0eb4\u0eb5\u0001\u0000\u0000\u0000"+
		"\u0eb5\u0eb7\u0001\u0000\u0000\u0000\u0eb6\u0eb4\u0001\u0000\u0000\u0000"+
		"\u0eb7\u0eb8\u0005~\u0000\u0000\u0eb8\u0eba\u0005\u0002\u0000\u0000\u0eb9"+
		"\u0ebb\u0003\u02e2\u0171\u0000\u0eba\u0eb9\u0001\u0000\u0000\u0000\u0ebb"+
		"\u0ebc\u0001\u0000\u0000\u0000\u0ebc\u0eba\u0001\u0000\u0000\u0000\u0ebc"+
		"\u0ebd\u0001\u0000\u0000\u0000\u0ebd\u0ebf\u0001\u0000\u0000\u0000\u0ebe"+
		"\u0ec0\u0003\u02e4\u0172\u0000\u0ebf\u0ebe\u0001\u0000\u0000\u0000\u0ebf"+
		"\u0ec0\u0001\u0000\u0000\u0000\u0ec0\u0ec1\u0001\u0000\u0000\u0000\u0ec1"+
		"\u0ec2\u0003\u025e\u012f\u0000\u0ec2\u02e7\u0001\u0000\u0000\u0000\u0ec3"+
		"\u0ec4\u0005P\u0000\u0000\u0ec4\u0ec5\u0005\u00af\u0000\u0000\u0ec5\u0ec6"+
		"\u0003\u010e\u0087\u0000\u0ec6\u0ec7\u0005\u0088\u0000\u0000\u0ec7\u0ec8"+
		"\u0005\u016d\u0000\u0000\u0ec8\u02e9\u0001\u0000\u0000\u0000\u0ec9\u0eca"+
		"\u0005\u013a\u0000\u0000\u0eca\u0ed0\u0003\u010e\u0087\u0000\u0ecb\u0ed1"+
		"\u0005\u0137\u0000\u0000\u0ecc\u0ed1\u0005\u0138\u0000\u0000\u0ecd\u0ed1"+
		"\u0005}\u0000\u0000\u0ece\u0ecf\u0005<\u0000\u0000\u0ecf\u0ed1\u0005}"+
		"\u0000\u0000\u0ed0\u0ecb\u0001\u0000\u0000\u0000\u0ed0\u0ecc\u0001\u0000"+
		"\u0000\u0000\u0ed0\u0ecd\u0001\u0000\u0000\u0000\u0ed0\u0ece\u0001\u0000"+
		"\u0000\u0000\u0ed1\u0ed2\u0001\u0000\u0000\u0000\u0ed2\u0ed3\u0005\u00f8"+
		"\u0000\u0000\u0ed3\u0ed4\u0003\u021e\u010f\u0000\u0ed4\u0ed5\u0005\u00f9"+
		"\u0000\u0000\u0ed5\u02eb\u0001\u0000\u0000\u0000\u0ed6\u0ed7\u0005\u013a"+
		"\u0000\u0000\u0ed7\u0ed8\u0003\u010e\u0087\u0000\u0ed8\u0ed9\u0005\u015a"+
		"\u0000\u0000\u0ed9\u0eda\u0005\u00f8\u0000\u0000\u0eda\u0edb\u0003\u0224"+
		"\u0112\u0000\u0edb\u0edc\u0005\u00f9\u0000\u0000\u0edc\u02ed\u0001\u0000"+
		"\u0000\u0000\u0edd\u0ede\u0005\u015b\u0000\u0000\u0ede\u0ee8\u0005\u015c"+
		"\u0000\u0000\u0edf\u0ee0\u0005\u015b\u0000\u0000\u0ee0\u0ee8\u0005\u015d"+
		"\u0000\u0000\u0ee1\u0ee2\u0005\u015b\u0000\u0000\u0ee2\u0ee3\u0005\u015c"+
		"\u0000\u0000\u0ee3\u0ee8\u0005\u015d\u0000\u0000\u0ee4\u0ee5\u0005\u015b"+
		"\u0000\u0000\u0ee5\u0ee6\u0005\u015d\u0000\u0000\u0ee6\u0ee8\u0005\u015c"+
		"\u0000\u0000\u0ee7\u0edd\u0001\u0000\u0000\u0000\u0ee7\u0edf\u0001\u0000"+
		"\u0000\u0000\u0ee7\u0ee1\u0001\u0000\u0000\u0000\u0ee7\u0ee4\u0001\u0000"+
		"\u0000\u0000\u0ee8\u02ef\u0001\u0000\u0000\u0000\u0ee9\u0eea\u0005\u0125"+
		"\u0000\u0000\u0eea\u0eeb\u0005\u001b\u0000\u0000\u0eeb\u0eed\u0005d\u0000"+
		"\u0000\u0eec\u0eee\u0005\u015e\u0000\u0000\u0eed\u0eec\u0001\u0000\u0000"+
		"\u0000\u0eed\u0eee\u0001\u0000\u0000\u0000\u0eee\u02f1\u0001\u0000\u0000"+
		"\u0000\u0eef\u0ef0\u0005\u014f\u0000\u0000\u0ef0\u0ef4\u0005\u0152\u0000"+
		"\u0000\u0ef1\u0ef2\u0005\u014f\u0000\u0000\u0ef2\u0ef4\u0005d\u0000\u0000"+
		"\u0ef3\u0eef\u0001\u0000\u0000\u0000\u0ef3\u0ef1\u0001\u0000\u0000\u0000"+
		"\u0ef4\u02f3\u0001\u0000\u0000\u0000\u0ef5\u0ef6\u0005\u015f\u0000\u0000"+
		"\u0ef6\u0ef7\u0005\u016d\u0000\u0000\u0ef7\u02f5\u0001\u0000\u0000\u0000"+
		"\u0ef8\u0efa\u0003\u00fe\u007f\u0000\u0ef9\u0ef8\u0001\u0000\u0000\u0000"+
		"\u0efa\u0efd\u0001\u0000\u0000\u0000\u0efb\u0ef9\u0001\u0000\u0000\u0000"+
		"\u0efb\u0efc\u0001\u0000\u0000\u0000\u0efc\u0f00\u0001\u0000\u0000\u0000"+
		"\u0efd\u0efb\u0001\u0000\u0000\u0000\u0efe\u0f01\u0003\u02ea\u0175\u0000"+
		"\u0eff\u0f01\u0003\u02ec\u0176\u0000\u0f00\u0efe\u0001\u0000\u0000\u0000"+
		"\u0f00\u0eff\u0001\u0000\u0000\u0000\u0f01\u0f03\u0001\u0000\u0000\u0000"+
		"\u0f02\u0f04\u0003\u02f2\u0179\u0000\u0f03\u0f02\u0001\u0000\u0000\u0000"+
		"\u0f03\u0f04\u0001\u0000\u0000\u0000\u0f04\u0f06\u0001\u0000\u0000\u0000"+
		"\u0f05\u0f07\u0003\u02f0\u0178\u0000\u0f06\u0f05\u0001\u0000\u0000\u0000"+
		"\u0f06\u0f07\u0001\u0000\u0000\u0000\u0f07\u0f09\u0001\u0000\u0000\u0000"+
		"\u0f08\u0f0a\u0003\u02ee\u0177\u0000\u0f09\u0f08\u0001\u0000\u0000\u0000"+
		"\u0f09\u0f0a\u0001\u0000\u0000\u0000\u0f0a\u0f0c\u0001\u0000\u0000\u0000"+
		"\u0f0b\u0f0d\u0003\u02f4\u017a\u0000\u0f0c\u0f0b\u0001\u0000\u0000\u0000"+
		"\u0f0c\u0f0d\u0001\u0000\u0000\u0000\u0f0d\u02f7\u0001\u0000\u0000\u0000"+
		"\u0f0e\u0f0f\u0005P\u0000\u0000\u0f0f\u0f10\u0007\u0002\u0000\u0000\u0f10"+
		"\u0f11\u0003\u0272\u0139\u0000\u0f11\u0f12\u0005\u00a0\u0000\u0000\u0f12"+
		"\u0f13\u0005\u00b6\u0000\u0000\u0f13\u0f14\u0003\u0272\u0139\u0000\u0f14"+
		"\u0f39\u0001\u0000\u0000\u0000\u0f15\u0f16\u0005P\u0000\u0000\u0f16\u0f17"+
		"\u0007\u0002\u0000\u0000\u0f17\u0f18\u0003\u0272\u0139\u0000\u0f18\u0f19"+
		"\u0005\u00a0\u0000\u0000\u0f19\u0f1a\u0005Y\u0000\u0000\u0f1a\u0f1b\u0003"+
		"\u0274\u013a\u0000\u0f1b\u0f1c\u0005\u00b6\u0000\u0000\u0f1c\u0f1d\u0003"+
		"\u0274\u013a\u0000\u0f1d\u0f39\u0001\u0000\u0000\u0000\u0f1e\u0f1f\u0005"+
		"P\u0000\u0000\u0f1f\u0f20\u0007\u0002\u0000\u0000\u0f20\u0f21\u0003\u0272"+
		"\u0139\u0000\u0f21\u0f22\u0005\u011d\u0000\u0000\u0f22\u0f23\u0005Y\u0000"+
		"\u0000\u0f23\u0f24\u0003~?\u0000\u0f24\u0f39\u0001\u0000\u0000\u0000\u0f25"+
		"\u0f26\u0005P\u0000\u0000\u0f26\u0f27\u0007\u0002\u0000\u0000\u0f27\u0f28"+
		"\u0003\u0272\u0139\u0000\u0f28\u0f29\u0005O\u0000\u0000\u0f29\u0f2a\u0005"+
		"Y\u0000\u0000\u0f2a\u0f2b\u0003z=\u0000\u0f2b\u0f39\u0001\u0000\u0000"+
		"\u0000\u0f2c\u0f2d\u0005P\u0000\u0000\u0f2d\u0f2e\u0007\u0002\u0000\u0000"+
		"\u0f2e\u0f2f\u0003\u0272\u0139\u0000\u0f2f\u0f30\u0005O\u0000\u0000\u0f30"+
		"\u0f31\u0003\u02f6\u017b\u0000\u0f31\u0f39\u0001\u0000\u0000\u0000\u0f32"+
		"\u0f33\u0005P\u0000\u0000\u0f33\u0f34\u0007\u0002\u0000\u0000\u0f34\u0f35"+
		"\u0003\u0272\u0139\u0000\u0f35\u0f36\u0005\u0148\u0000\u0000\u0f36\u0f37"+
		"\u0005\u016d\u0000\u0000\u0f37\u0f39\u0001\u0000\u0000\u0000\u0f38\u0f0e"+
		"\u0001\u0000\u0000\u0000\u0f38\u0f15\u0001\u0000\u0000\u0000\u0f38\u0f1e"+
		"\u0001\u0000\u0000\u0000\u0f38\u0f25\u0001\u0000\u0000\u0000\u0f38\u0f2c"+
		"\u0001\u0000\u0000\u0000\u0f38\u0f32\u0001\u0000\u0000\u0000\u0f39\u02f9"+
		"\u0001\u0000\u0000\u0000\u0f3a\u0f3b\u0005P\u0000\u0000\u0f3b\u0f3d\u0005"+
		"%\u0000\u0000\u0f3c\u0f3e\u0003\u001a\r\u0000\u0f3d\u0f3c\u0001\u0000"+
		"\u0000\u0000\u0f3d\u0f3e\u0001\u0000\u0000\u0000\u0f3e\u0f3f\u0001\u0000"+
		"\u0000\u0000\u0f3f\u0f40\u0003\u0278\u013c\u0000\u0f40\u0f41\u0005\u011d"+
		"\u0000\u0000\u0f41\u0f42\u0003\u00be_\u0000\u0f42\u0f50\u0001\u0000\u0000"+
		"\u0000\u0f43\u0f45\u0005P\u0000\u0000\u0f44\u0f46\u00052\u0000\u0000\u0f45"+
		"\u0f44\u0001\u0000\u0000\u0000\u0f45\u0f46\u0001\u0000\u0000\u0000\u0f46"+
		"\u0f47\u0001\u0000\u0000\u0000\u0f47\u0f49\u0005%\u0000\u0000\u0f48\u0f4a"+
		"\u0003\u001a\r\u0000\u0f49\u0f48\u0001\u0000\u0000\u0000\u0f49\u0f4a\u0001"+
		"\u0000\u0000\u0000\u0f4a\u0f4b\u0001\u0000\u0000\u0000\u0f4b\u0f4c\u0003"+
		"\u0278\u013c\u0000\u0f4c\u0f4d\u0005\u0148\u0000\u0000\u0f4d\u0f4e\u0005"+
		"\u016d\u0000\u0000\u0f4e\u0f50\u0001\u0000\u0000\u0000\u0f4f\u0f3a\u0001"+
		"\u0000\u0000\u0000\u0f4f\u0f43\u0001\u0000\u0000\u0000\u0f50\u02fb\u0001"+
		"\u0000\u0000\u0000\u0f51\u0f52\u00050\u0000\u0000\u0f52\u0f53\u0003\u010e"+
		"\u0087\u0000\u0f53\u02fd\u0001\u0000\u0000\u0000\u0f54\u0f56\u0005\u0151"+
		"\u0000\u0000\u0f55\u0f57\u0005\u0152\u0000\u0000\u0f56\u0f55\u0001\u0000"+
		"\u0000\u0000\u0f56\u0f57\u0001\u0000\u0000\u0000\u0f57\u0f58\u0001\u0000"+
		"\u0000\u0000\u0f58\u0f59\u0003\u010e\u0087\u0000\u0f59\u02ff\u0001\u0000"+
		"\u0000\u0000\u01dd\u0304\u030a\u030e\u0313\u0317\u0322\u032b\u0330\u0334"+
		"\u0338\u033e\u0342\u0348\u0367\u036b\u0372\u0378\u037d\u0388\u0399\u039b"+
		"\u03a2\u03a4\u03b0\u03b8\u03d6\u03d9\u03dc\u03df\u03e2\u03e6\u03eb\u03f0"+
		"\u03f3\u03f6\u03fa\u03fe\u0401\u0404\u0407\u040c\u0410\u0414\u0418\u041d"+
		"\u0422\u0426\u042a\u042d\u0431\u0434\u0437\u043b\u0440\u0445\u0448\u044b"+
		"\u0453\u045c\u0462\u0467\u046c\u0471\u0475\u047a\u0481\u0485\u048a\u048f"+
		"\u0499\u049d\u04a2\u04a5\u04a9\u04ae\u04b2\u04b7\u04b9\u04bf\u04c2\u04c6"+
		"\u04ca\u04cd\u04d0\u04d5\u04d9\u04dd\u04e1\u04e4\u04e7\u04ee\u04f2\u04f6"+
		"\u04fe\u0502\u0515\u051e\u0527\u052e\u0533\u053a\u053d\u0541\u054a\u0552"+
		"\u055c\u0563\u056a\u056f\u057a\u057e\u0584\u058e\u0596\u059c\u059f\u05a2"+
		"\u05a5\u05a8\u05ab\u05ae\u05b1\u05b5\u05ba\u05bf\u05c8\u05cb\u05ce\u05d1"+
		"\u05d4\u05d7\u05da\u05dd\u05e0\u05e7\u0600\u0615\u061c\u0626\u0633\u063b"+
		"\u063e\u0644\u0647\u064d\u0650\u0655\u0658\u065e\u0660\u0671\u0675\u0683"+
		"\u0687\u068a\u068d\u0690\u0693\u0696\u0699\u069c\u06a3\u06b0\u06b9\u06c1"+
		"\u06ce\u06d4\u06dd\u06e4\u06ec\u06ee\u06f4\u06fa\u06fe\u0701\u0707\u070e"+
		"\u0710\u0720\u0731\u073e\u0742\u0744\u0751\u0758\u0770\u0777\u0786\u078d"+
		"\u0798\u07a2\u07a7\u07ac\u07b4\u07bb\u07bf\u07c4\u07c8\u07ce\u07d2\u07d7"+
		"\u07e0\u07e4\u07ea\u07f0\u0802\u080d\u0811\u0817\u081b\u0820\u0825\u0829"+
		"\u082e\u0833\u0837\u083c\u083e\u0847\u084c\u0850\u0856\u085c\u0861\u0865"+
		"\u0867\u086b\u086f\u0871\u0875\u0879\u087d\u0881\u0885\u0894\u0898\u08a0"+
		"\u08aa\u08b0\u08bc\u08c3\u08c7\u08cb\u08d0\u08d2\u08d6\u08db\u08df\u08e1"+
		"\u08e5\u08f7\u08fe\u090a\u090c\u0911\u0929\u0932\u0946\u094e\u0959\u095b"+
		"\u0966\u0968\u096c\u0972\u0984\u0988\u098c\u0993\u0996\u099e\u09a1\u09b4"+
		"\u09c8\u09cf\u09d9\u09e0\u09e8\u09ec\u09f6\u0a00\u0a04\u0a14\u0a21\u0a28"+
		"\u0a32\u0a35\u0a38\u0a3f\u0a4b\u0a50\u0a56\u0a5c\u0a67\u0a6d\u0a75\u0a7b"+
		"\u0a7f\u0a83\u0a8b\u0a8f\u0a9d\u0aa5\u0aa9\u0aad\u0ab0\u0ab3\u0ab6\u0ab9"+
		"\u0abc\u0abf\u0ac2\u0acc\u0ad0\u0ad7\u0adb\u0ade\u0ae5\u0ae9\u0aef\u0af7"+
		"\u0aff\u0b09\u0b0e\u0b15\u0b19\u0b1c\u0b23\u0b27\u0b2d\u0b35\u0b43\u0b49"+
		"\u0b4e\u0b54\u0b5a\u0b5e\u0b64\u0b6c\u0b75\u0b7c\u0b84\u0b8f\u0b93\u0ba7"+
		"\u0bab\u0bae\u0bba\u0bbd\u0bc3\u0bc7\u0bce\u0bd6\u0bda\u0bdd\u0be2\u0bea"+
		"\u0bf2\u0bfd\u0c09\u0c10\u0c17\u0c1e\u0c36\u0c41\u0c4f\u0c52\u0c55\u0c58"+
		"\u0c65\u0c6b\u0c74\u0c82\u0c8e\u0c9c\u0ca0\u0ca6\u0cac\u0cb0\u0cb5\u0cba"+
		"\u0cbf\u0cc4\u0ccb\u0cd0\u0cd4\u0cd8\u0cdd\u0ce2\u0ce9\u0ced\u0cf4\u0cfb"+
		"\u0cfd\u0d00\u0d09\u0d14\u0d1d\u0d24\u0d29\u0d2c\u0d30\u0d37\u0d3c\u0d41"+
		"\u0d46\u0d4b\u0d54\u0d59\u0d5e\u0d67\u0d7e\u0d83\u0d89\u0d99\u0d9d\u0da5"+
		"\u0dae\u0db3\u0dba\u0dc1\u0dc9\u0dcd\u0dd5\u0ddc\u0de1\u0deb\u0df4\u0dfc"+
		"\u0e01\u0e06\u0e0a\u0e11\u0e1c\u0e28\u0e2d\u0e30\u0e3b\u0e42\u0e49\u0e4e"+
		"\u0e53\u0e58\u0e5e\u0e61\u0e67\u0e6f\u0e71\u0e74\u0e7b\u0e81\u0e88\u0e8d"+
		"\u0e93\u0e9b\u0ea1\u0ea7\u0eaf\u0eb4\u0ebc\u0ebf\u0ed0\u0ee7\u0eed\u0ef3"+
		"\u0efb\u0f00\u0f03\u0f06\u0f09\u0f0c\u0f38\u0f3d\u0f45\u0f49\u0f4f\u0f56";
	public static final String _serializedATN = Utils.join(
		new String[] {
			_serializedATNSegment0,
			_serializedATNSegment1
		},
		""
	);
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}