/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

parser grammar SQLParser;

options {
	language=Java;
	tokenVocab=SQLLexer;
}

@header {
}

@members {
}

/*
===============================================================================
  SQL statement (Start Symbol)
===============================================================================
*/
script
  : sql (sql)* EOF
  ;

singleSqlScript
  : (explain_clause)? statement (SEMI_COLON)? EOF
  ;

sql
  : (explain_clause)? statement (SEMI_COLON)?
  ;

explain_clause
  : EXPLAIN
  ;

statement
  : session_statement
  | data_statement
  | data_change_statement
  | schema_statement
  | index_statement
  | open_project_statement
  | connect_statement
  ;

session_statement
  : SET CATALOG dbname = identifier
  | SET TIME ZONE (TO | EQUAL)? (Character_String_Literal | signed_numerical_literal | DEFAULT)
  | SET (SESSION)? name=identifier (TO | EQUAL)?
    (Character_String_Literal | signed_numerical_literal | boolean_literal | DEFAULT)
  | RESET name=identifier
  ;

data_statement
  : query_specification
  ;

data_change_statement
  : insert_statement
  | multi_insert_statement
  ;

schema_statement
  : database_definition
  | drop_database_statement
  | create_table_statement
  | drop_table_statement
  | alter_tablespace_statement
  | alter_table_statement
  | truncate_table_statement
  | alter_mapping_statement
  | create_mapping_statement
  | create_package_statement
  | create_scenario_statement
  | regenerate_scenario_statement
  | drop_mapping_statement
  | truncate_mapping_statement
  | drop_reusable_mapping_statement
  | truncate_reusable_mapping_statement
  | drop_package_statement
  | create_model_statement
  | create_submodel_statement
  | create_project_statement
  | create_folder_statement
  | drop_project_statement
  | drop_model_statement
  | drop_folder_statement
  | drop_submodel_statement
  | drop_scenario_statement
  | export_scenario_statement
  | import_scenario_statement
  | export_mapping_statement
  ;

index_statement
  : CREATE (u=UNIQUE)? INDEX n=identifier ON t=table_name (m=method_specifier)?
    LEFT_PAREN s=sort_specifier_list RIGHT_PAREN p=param_clause?
  ;

database_definition
  : CREATE DATABASE (if_not_exists)? dbname = identifier
  ;

if_not_exists
  : IF NOT EXISTS
  ;

drop_database_statement
  : DROP DATABASE (if_exists)? dbname = identifier
  ;

if_exists
  : IF EXISTS
  ;

or_replace
  : OR_REPLACE
  ;

hive_row_format
    : DELIMITED (FIELDS TERMINATED BY Character_String_Literal (ESCAPED BY Character_String_Literal)?)?
    | SERDE Character_String_Literal (WITH SERDEPROPERTIES param_clause)?
    ;

hive_file_format
    : SEQUENCEFILE
    | TEXTFILE
    | RCFILE
    | ORC
    | PARQUET
    | AVRO
    | INPUTFORMAT input_format_classname=Character_String_Literal OUTPUTFORMAT output_format_classname=Character_String_Literal
    ;

file_alias : ALIAS Regular_Identifier;
file_resource_name : RESOURCE (Character_String_Literal | odi_variable_literal); 
file_description : DESCRIPTION Character_String_Literal;
file_format : FORMAT (FIXED|DELIMITED);
file_heading : HEADING NUMBER;
record_separator : RECORD_SEP Character_String_Literal;
field_separator : FIELD_SEP Character_String_Literal;
text_delimiter : TEXT_DELIM Character_String_Literal;
decimal_separator : DECIMAL_SEP Character_String_Literal;
olap_type : OLAP_TYPE otype=Character_String_Literal;

file_descriptor
    : FILE (LEFT_PAREN file_format file_heading? record_separator? field_separator? text_delimiter? decimal_separator? RIGHT_PAREN)?
    ;

    
create_table_statement
  : (annotation)* CREATE (or_replace)? (TEMPORARY)? (EXTERNAL)? (TABLE|DATASTORE) (if_not_exists)? table_name file_alias? file_resource_name? olap_type? file_description? table_elements 
      (ROW_FORMAT hive_row_format)? (STORED_AS hive_file_format)? 
      (LOCATION path=Character_String_Literal)? (TBLPROPERTIES params=param_clause)? 
  | (annotation)* CREATE (or_replace)? (TABLE|DATASTORE) (if_not_exists)? table_name file_alias? file_resource_name? table_elements file_descriptor?
    (param_clause)? (table_partitioning_clauses)? (AS query_expression)?
  | CREATE TABLE (if_not_exists)? table_name (USING storage_type=identifier)?
    (param_clause)? (table_partitioning_clauses)? AS query_expression
  | CREATE TABLE (if_not_exists)? table_name LIKE like_table_name=table_name
  | CREATE TABLE (if_not_exists)? table_name AS insert_statement
  ;

create_project_statement
  : CREATE PROJECT (if_not_exists)? code=Regular_Identifier (WITH_NAME name=Quoted_Identifier)?
  ;

drop_project_statement
  : DROP PROJECT (if_exists)? code=Regular_Identifier (CASCADE)?
  ;

create_folder_statement
  : CREATE FOLDER (if_not_exists)? folder_name
  ;

drop_folder_statement
  : DROP FOLDER (if_exists)? folder_name (CASCADE)?
 ;

create_model_statement
  : CREATE MODEL (if_not_exists)? code=Regular_Identifier (WITH_NAME name=Quoted_Identifier)? LOGICAL_SCHEMA schema=Quoted_Identifier CONTEXT context=identifier
  ;

drop_model_statement
  : DROP MODEL (if_exists)? code=Regular_Identifier (CASCADE)?
  ;

create_submodel_statement
  : CREATE SUBMODEL (if_not_exists)? folder_name? (WITH_NAME name=Quoted_Identifier)?
  ;

drop_submodel_statement
  : DROP SUBMODEL (if_exists)? folder_name (CASCADE)?
  ;

mapping_statements_block
  : BEGIN (insert_statement | multi_insert_statement)+ END
  ;

create_simple_mapping
  : CREATE (or_replace)? (REUSABLE)? MAPPING (if_not_exists)? mapping_name (param_clause)? staging_location? (phys_design_clause)? AS (insert_statement | multi_insert_statement)
  ;

create_complex_mapping
  : CREATE (or_replace)? MAPPING (if_not_exists)? mapping_name (param_clause)? staging_location? (phys_design_clause)? AS mapping_statements_block
  ;

create_mapping_statement
  : create_simple_mapping
  | create_complex_mapping
  ;

create_package_statement
  : CREATE (or_replace)? PACKAGE (if_not_exists)? mapping_name AS statement_block
  ;

  create_procedure_statement
  : CREATE (or_replace)? PROCEDURE (if_not_exists)? AS statement_block
  ; 

scenario_name
  : identifier
  ;

scenario_version 
  : identifier
  ;

odi_object_type
  : PROJECT
  | FOLDER
  | MAPPING
  | REUSABLE MAPPING  
  | PROCEDURE
  | VARIABLE
  | SCENARIO
  | MODEL
  | DATASTORE
  ;

odi_parent_object_type
  : PROJECT
  | FOLDER
  | MODEL
  ;

scenario_source_type
  : MAPPING 
  | PACKAGE
  | PROCEDURE
  | VARIABLE
  ;

scenario_variable
  : Odi_Variable (DEFAULT value=Character_String_Literal)?
  ;

scenario_variables
  : WITH LEFT_PAREN scenario_variable (COMMA scenario_variable)* RIGHT_PAREN
  ;

create_scenario_statement
  : CREATE (or_replace)? SCENARIO scenario_name (scenario_version)? FOR scenario_source_type mapping_name (PHYSICAL_DESIGN phys_design_name)? scenario_variables?
  ;

regenerate_scenario_statement
  : REGENERATE (if_exists)? SCENARIO scenario_name scenario_version
  ;

drop_scenario_statement
  : DROP SCENARIO (if_exists)? scenario_name scenario_version
  ;

export_scenario_statement
  : EXPORT SCENARIO (if_exists)? scenario_name scenario_version TO path=Quoted_Identifier
  ;

export_mapping_statement
  : EXPORT MAPPING (if_exists)? mapping_name TO path=Quoted_Identifier (AS TEXT)?
  ;

odi_object_name
  : identifier (DOT identifier)*
  ;

import_object
  : odi_object_name scenario_version?
  ;

import_parent_object
  : odi_parent_object_type odi_object_name
  ;

import_mode
  : TYPE Quoted_Identifier
  ;

import_scenario_statement
  : IMPORT (odi_object_type if_not_exists? import_object)? FROM path=Quoted_Identifier (INTO import_parent_object)? import_mode
  ;

table_elements
  : LEFT_PAREN field_element (COMMA field_element)* RIGHT_PAREN
  ;

field_element
  : (annotation)* name=identifier field_type null_constraint? position? offset? field_phys_length? decimal_separator? field_format? field_scd_behavior? field_comment?
  | datastore_constraint
  | index_inline
  ;

index_inline
  : (annotation)* INDEX (index_type=UNIQUE)? name=identifier LEFT_PAREN column_name_list RIGHT_PAREN
  ;

modify_field_element
  : name=identifier field_type? null_constraint? position? offset? field_phys_length? decimal_separator? field_format? field_scd_behavior? field_comment?
  ;

field_type
  : data_type
  ;

null_constraint
  : NULL | NOT NULL
  ;

position
  : POSITION NUMBER
  ;

offset
  : OFFSET NUMBER
  ;

field_phys_length
  : PHYS_LENGTH NUMBER
  ;

field_format
  : FORMAT Character_String_Literal
  ;

field_scd_behavior
  : SCD_BEHAVIOR
  ;

field_comment
  : CMNT comm=Character_String_Literal
  ;

param_clause
  : LEFT_PAREN param (COMMA param)* RIGHT_PAREN
  ;

param
  : key=Character_String_Literal EQUAL value=numeric_value_expression
  ;

km_param
  : key=Character_String_Literal EQUAL value=general_literal
  ;

km_name
  : Quoted_Identifier
  ;

km_technology
  : FOR TECHNOLOGY Quoted_Identifier
  ;

km_target_item
  : table_name
  | Regular_Identifier
  ;

km_target_list
  : km_target_item (COMMA km_target_item)*
  ;

ikm_target
  : FOR TABLE table_name (COMMA table_name)*
  ;

km_target
  : FOR TABLE km_target_list
  ;

km_params
  : LEFT_PAREN km_param (COMMA km_param)* RIGHT_PAREN
  ;

lkm_clause
  : LKM km_name km_technology? km_params?
  ;

xkm_clause 
  : XKM km_name (km_technology | km_target) km_params?
  ;

ikm_clause
  : IKM km_name (km_technology | km_target)? km_params?
  ;

ckm_clause
  : CKM km_name km_technology? km_params?
  ;

km_list
  : (lkm_clause | ikm_clause | ckm_clause | xkm_clause)+
  ;

phys_design_name
   : Quoted_Identifier
   ;

phys_design_desc
   : DESCRIPTION Quoted_Identifier
   ;

optimization_context
   : OPTIMIZATION_CONTEXT identifier
   ;

staging_location
   : STAGING LOCATION name=identifier   
   ;

mapping_command
    : command=FreeCode (TECHNOLOGY technology=Quoted_Identifier)? (LOCATION location=Quoted_Identifier)?
    ;

on_begin_mapping_cmd
    : ON BEGIN MAPPING mapping_command
    ;

on_end_mapping_cmd
    : ON END MAPPING mapping_command
    ;

phys_design
   : PHYSICAL_DESIGN (phys_design_name)? LEFT_PAREN phys_design_desc? staging_location? optimization_context? on_begin_mapping_cmd? on_end_mapping_cmd? REMOVE_TEMPORARY_OBJECTS_ON_ERROR? UNIQUE_TEMPORARY_OBJECT_NAMES? (km_list)? RIGHT_PAREN
   ;

phys_design_clause
   : (phys_design)+
   ;

declare_odivar_statement
   : DECLARE odi_variable
   ;

refresh_odivar_statement
   : REFRESH odi_variable
   ;

set_odivar_statement
   : SET odi_variable EQUAL (Character_String_Literal | signed_numerical_literal)
   ;

procedure_options
   : WITH LEFT_PAREN km_param (COMMA km_param)* RIGHT_PAREN
   ;

procedure_statement
   : PROCEDURE mapping_name (procedure_options)? 
   ;

increment_odivar_statement
   : odi_variable EQUAL (PLUS | MINUS) signed_numerical_literal
   | odi_variable EQUAL odi_variable (PLUS | MINUS) signed_numerical_literal
   ;

mapping_statement
   : MAPPING mapping_name (PHYSICAL_DESIGN phys_design_name)?
   ;

package_statement
   : declare_odivar_statement
   | refresh_odivar_statement
   | set_odivar_statement
   | increment_odivar_statement
   | mapping_statement
   | procedure_statement
   | statement_block
   ;
    
success_clause
   : ON SUCCESS (GOTO label | EXIT)
   ;

error_clause
   : ON ERROR (RETRY times=NUMBER (WAIT wait_time=NUMBER)?)? (GOTO label | CONTINUE | EXIT)?
   ;

label
  : identifier COLON
  ;

generic_package_statement
   : (label)? package_statement (success_clause)? (error_clause)?
   ;

statement_block
   : BEGIN (generic_package_statement)+ (ON ERROR (generic_package_statement)+)? END
   ;

method_specifier
  : USING m=identifier
  ;

table_space_specifier
  : TABLESPACE table_space_name
  ;

table_space_name
  : identifier
  ;

table_partitioning_clauses
  : range_partitions
  | hash_partitions
  | list_partitions
  | column_partitions
  ;

range_partitions
  : PARTITION BY RANGE LEFT_PAREN column_reference_list RIGHT_PAREN
    LEFT_PAREN range_value_clause_list RIGHT_PAREN
  ;

range_value_clause_list
  : range_value_clause (COMMA range_value_clause)*
  ;

range_value_clause
  : PARTITION partition_name VALUES LESS THAN (LEFT_PAREN value_expression RIGHT_PAREN | LEFT_PAREN? MAXVALUE RIGHT_PAREN?)
  ;

hash_partitions
  : PARTITION BY HASH LEFT_PAREN column_reference_list RIGHT_PAREN
    (LEFT_PAREN individual_hash_partitions RIGHT_PAREN | hash_partitions_by_quantity)
  ;

individual_hash_partitions
  : individual_hash_partition (COMMA individual_hash_partition)*
  ;

individual_hash_partition
  : PARTITION partition_name
  ;

hash_partitions_by_quantity
  : PARTITIONS quantity = numeric_value_expression
  ;

list_partitions
  : PARTITION BY LIST LEFT_PAREN column_reference_list RIGHT_PAREN LEFT_PAREN  list_value_clause_list RIGHT_PAREN
  ;

list_value_clause_list
  : list_value_partition (COMMA list_value_partition)*
  ;

list_value_partition
  : PARTITION partition_name VALUES (IN)? LEFT_PAREN in_value_list RIGHT_PAREN
  ;

column_partitions
  : PARTITION BY COLUMN table_elements
  ;

partition_name
  : identifier
  ;

truncate_table_statement
  : TRUNCATE (TABLE)? table_name (COMMA table_name)*
  ;

annotation_element
  : identifier EQUAL Quoted_Identifier
  | identifier EQUAL Character_String_Literal
  ;

annotation
  : AT_SIGN identifier (LEFT_PAREN annotation_element (COMMA annotation_element)* RIGHT_PAREN)? 
  ;

/*
===============================================================================
  11.21 <data types>
===============================================================================
*/

truncate_mapping_statement
  : TRUNCATE MAPPING (if_exists)? mapping_name
  ;

truncate_reusable_mapping_statement
  : TRUNCATE REUSABLE MAPPING (if_exists)? mapping_name
  ;

drop_table_statement
  : DROP (TABLE|DATASTORE) (if_exists)? table_name (PURGE)?
  ;

drop_mapping_statement
  : DROP MAPPING (if_exists)? mapping_name (CASCADE)?
  ;

drop_reusable_mapping_statement
  : DROP REUSABLE MAPPING (if_exists)? mapping_name (CASCADE)?
  ;

drop_package_statement
  : DROP PACKAGE (if_exists)? mapping_name
  ;

/*
===============================================================================
  5.2 <token and separator>

  Specifying lexical units (tokens and separators) that participate in SQL language
===============================================================================
*/

nonreserved_keywords
  : ADD
  | ACTIVE
  | ALIAS
  | ALTER
  | ASYMMETRIC
  | AVG
  | AVRO
  | BETWEEN
  | BIGINT
  | BINARY
  | BIT
  | BLOB
  | BOOL
  | BOOLEAN
  | BOTH
  | BY
  | BYTEA
  | CATALOG
  | CENTURY
  | CHAR
  | CHARACTER
  | CHARACTER
  | CKM
  | COALESCE
  | COLLECT
  | COLUMN
  | CONTEXT
  | CONTROL
  | COUNT
  | CROSS
  | CUBE
  | CUME_DIST
  | CURRENT
  | CURRENT_DATE
  | CURRENT_TIME
  | CURRENT_TIMESTAMP
  | DATABASE
  | DATASET
  | DATASTORE
  | DATE
  | DAY
  | DEC
  | DECADE
  | DECIMAL
  | DEFAULT
  | DENSE_RANK
  | DESCRIPTION
  | DOUBLE
  | DOW
  | DOY
  | DROP
  | EPOCH
  | EPOCH
  | EVERY
  | EXCLUDE
  | EXISTS
  | EXPLAIN
  | EXTERNAL
  | EXTRACT
  | FIELDS
  | FILE
  | FILTER
  | FIRST
  | FIRST_VALUE
  | FIXED
  | FLOAT
  | FLOAT4
  | FLOAT8
  | FLOW
  | FOLDER
  | FOLLOWING
  | FORMAT
  | FULL
  | FUSION
  | GROUP
  | GROUPING
  | HASH
  | HEADING
  | IKM
  | INDEX
  | INET4
  | INPUTFORMAT
  | INSERT
  | INT
  | INT1
  | INT2
  | INT4
  | INT8
  | INTEGER
  | INTERSECTION
  | INTERVAL
  | ISODOW
  | ISOYEAR
  | KEEP
  | LAG
  | LAST
  | LAST_VALUE
  | LESS
  | LIMIT
  | LIST
  | LKM
  | LOCATION
  | MAPPING
  | MAX
  | MAXVALUE
  | MESSAGE
  | MICROSECONDS
  | MILLENNIUM
  | MILLISECONDS
  | MIN
  | MINUTE
  | MODEL
  | MONTH
  | NATIONAL
  | NATURAL
  | NCHAR
  | NO
  | NULLIF
  | NUMERIC
  | NVARCHAR
  | ODI
  | OFFSET
  | ORANUMBER
  | ORC
  | ORDER
  | OTHERS
  | OUTPUTFORMAT
  | OVERWRITE
  | PACKAGE
  | PARQUET
  | PARTITION
  | PARTITIONS
  | PERCENT
  | PERCENT_RANK
  | PIVOT
  | POSITION
  | PRECEDING
  | PRECISION
  | PROCEDURE
  | PROJECT
  | PURGE
  | QUARTER
  | RANGE
  | RANK
  | RCFILE
  | REAL
  | REAL_NUMBER
  | REGEXP
  | REJECT
  | RENAME
  | REPLACE
  | RESET
  | RESOURCE
  | REUSABLE
  | RLIKE
  | ROLLUP
  | ROW
  | ROWS
  | ROW_NUMBER
  | SCD
  | SCENARIO
  | SECOND
  | SEQUENCEFILE
  | SERDE
  | SERDEPROPERTIES
  | SESSION
  | SET
  | SIMILAR
  | SMALLINT
  | STATIC
  | STDDEV_POP
  | STDDEV_SAMP
  | STRING
  | SUBMODEL
  | SUBPARTITION
  | SUCCESS
  | SUM
  | SYMMETRIC
  | TABLESPACE
  | TBLPROPERTIES
  | TECHNOLOGY
  | TEMPORARY
  | TERMINATED
  | TEXT
  | TEXTFILE
  | THAN
  | TIES
  | TIME
  | TIMESTAMP
  | TIMESTAMPTZ
  | TIMETZ
  | TIMEZONE
  | TIMEZONE_HOUR
  | TIMEZONE_MINUTE
  | TINYINT
  | TO
  | TRAILING 
  | TRIM
  | TYPE
  | UNBOUNDED
  | UNKNOWN
  | UNPIVOT
  | VALUES
  | VARBINARY
  | VARBIT
  | VARCHAR
  | VARCHAR2
  | VARIABLE
  | VARYING
  | VAR_POP
  | VAR_SAMP
  | WEEK
  | WINDOW
  | XKM
  | YEAR
  | ZONE
  ;

identifier
  : Regular_Identifier
  | Quoted_Identifier
  | nonreserved_keywords
  ;

/*
===============================================================================
  5.3 <literal>
===============================================================================
*/

unsigned_literal
  : unsigned_numeric_literal
  | general_literal
  ;

general_literal
  : Character_String_Literal
  | datetime_literal
  | boolean_literal
  | odi_variable_literal
  ;

datetime_literal
  : timestamp_literal
  | time_literal
  | date_literal
  | interval_literal
  ;

time_literal
  : TIME time_string=Character_String_Literal
  ;

timestamp_literal
  : TIMESTAMP timestamp_string=Character_String_Literal
  ;

date_literal
  : DATE date_string=Character_String_Literal
  ;

interval_literal
  : INTERVAL interval_string=Character_String_Literal
  ;

boolean_literal
  : TRUE | FALSE | UNKNOWN
  ;

/*
===============================================================================
  6.1 <data types>
===============================================================================
*/

data_type
  : predefined_type
  | generic_type
  ;

predefined_type
  : character_string_type
  | national_character_string_type
  | binary_large_object_string_type
  | numeric_type
  | boolean_type
  | datetime_type
  | bit_type
  | binary_type
  | network_type
  ;

generic_type
  : (Regular_Identifier | Quoted_Identifier) (precision_param)?
  ;

network_type
  : INET4
  ;

character_string_type
  : CHARACTER type_length?
  | CHAR type_length?
  | CHARACTER VARYING type_length?
  | CHAR VARYING type_length?
  | VARCHAR type_length?
  | VARCHAR_MAX
  | VARCHAR2 type_length?
  | VARCHAR2_MAX
  | FEBCDIC type_length?
  | STRING type_length?
  | TEXT
  | CLOB type_length?
  ;

type_length
  : LEFT_PAREN NUMBER RIGHT_PAREN
  ;

national_character_string_type
  : NATIONAL CHARACTER type_length?
  | NATIONAL CHAR type_length?
  | NCHAR type_length?
  | NATIONAL CHARACTER VARYING type_length?
  | NATIONAL CHAR VARYING type_length?
  | NCHAR VARYING type_length?
  | NVARCHAR type_length?
  ;

binary_large_object_string_type
  : BLOB type_length?
  | BYTEA type_length?
  ;

numeric_type
  : exact_numeric_type | approximate_numeric_type
  ;

exact_numeric_type
  : NUMERIC (precision_param)?
  | ORANUMBER (precision_param)?
  | DECIMAL (precision_param)?
  | DEC (precision_param)?
  | INT1
  | TINYINT
  | INT2
  | SMALLINT
  | INT4
  | INT
  | INTEGER
  | INT8
  | BIGINT
  | SIGNED_PACKED_DECIMAL (precision_param)
  | EBCDIC_SIGNED_ZONED_DECIMAL (precision_param)
  ;

approximate_numeric_type
  : FLOAT (precision_param)?
  | FLOAT4
  | REAL
  | FLOAT8
  | DOUBLE
  | DOUBLE PRECISION
  ;

precision_param
  : LEFT_PAREN precision=NUMBER RIGHT_PAREN
  | LEFT_PAREN precision=NUMBER COMMA scale=NUMBER RIGHT_PAREN
  ;

boolean_type
  : BOOLEAN
  | BOOL
  ;

datetime_type
  : DATE (type_length)?
  | DATETIME
  | INTERVAL
  | TIME
  | TIME WITH TIME ZONE
  | TIMETZ
  | TIMESTAMP (type_length)?
  | TIMESTAMP WITH TIME ZONE
  | TIMESTAMPTZ
  ;

bit_type
  : BIT type_length?
  | VARBIT type_length?
  | BIT VARYING type_length?
  ;

binary_type
  : BINARY type_length?
  | BINARY VARYING type_length?
  | VARBINARY type_length?
  ;

/*
===============================================================================
  6.3 <value_expression_primary>
===============================================================================
*/
value_expression_primary
  : parenthesized_value_expression
  | nonparenthesized_value_expression_primary
  ;

parenthesized_value_expression
  : LEFT_PAREN value_expression RIGHT_PAREN
  ;

nonparenthesized_value_expression_primary
  : unsigned_value_specification
  | column_reference
  | set_function_specification
  | window_function
  | listagg_function
  | case_expression
  | case_abbreviation
  | cast_specification
  | convert_specification
  | routine_invocation
  | scalar_subquery
  | cursor_function
  ;

/*
===============================================================================
  6.4 <unsigned value specification>
===============================================================================
*/

unsigned_value_specification
  : unsigned_literal
  ;

unsigned_numeric_literal
  : NUMBER
  | REAL_NUMBER
  ;

signed_numerical_literal
  : sign? unsigned_numeric_literal
  ;

/*
===============================================================================
  6.9 <set function specification>

  Invoke an SQL-invoked routine.
===============================================================================
*/
set_function_specification
  : aggregate_function
  ;

aggregate_function
  : COUNT LEFT_PAREN MULTIPLY RIGHT_PAREN
  | general_set_function filter_clause?
  ;

general_set_function
  : set_function_type LEFT_PAREN set_qualifier? value_expression RIGHT_PAREN
  ;

set_function_type
  : AVG
  | MAX
  | MIN
  | SUM
  | EVERY
  | ANY
  | SOME
  | COUNT
  | STDDEV_POP
  | STDDEV_SAMP
  | VAR_SAMP
  | VAR_POP
  | COLLECT
  | FUSION
  | INTERSECTION
  ;

/*
filter_clause
  : FILTER LEFT_PAREN WHERE search_condition RIGHT_PAREN
  ;
*/

filter_clause
  : KEEP LEFT_PAREN DENSE_RANK (FIRST | LAST) orderby_clause RIGHT_PAREN
  ;

grouping_operation
  : GROUPING LEFT_PAREN column_reference_list RIGHT_PAREN
  ;

/*
===============================================================================
   listagg function
===============================================================================
*/

listagg_function
  : LISTAGG LEFT_PAREN value_expression (COMMA value_expression)? RIGHT_PAREN WITHIN_GROUP LEFT_PAREN orderby_clause RIGHT_PAREN (OVER window_name_or_specification)?
  ;

/*
===============================================================================
  6.10 window function
===============================================================================
*/

window_function
  : window_function_type OVER window_name_or_specification
  ;


window_function_nulls_clause
  : IGNORE_NULLS | RESPECT_NULLS
  ;


window_function_type
  : rank_function_type LEFT_PAREN RIGHT_PAREN
  | ROW_NUMBER LEFT_PAREN RIGHT_PAREN
  | aggregate_function
  | FIRST_VALUE LEFT_PAREN value_expression (window_function_nulls_clause)? RIGHT_PAREN
  | LAST_VALUE LEFT_PAREN value_expression (window_function_nulls_clause)? RIGHT_PAREN
  | LAG LEFT_PAREN value_expression ( COMMA numeric_value_expression ( COMMA common_value_expression )? )? RIGHT_PAREN
  | LEAD LEFT_PAREN value_expression ( COMMA numeric_value_expression ( COMMA common_value_expression )? )? RIGHT_PAREN
  ;

rank_function_type
  : RANK | DENSE_RANK | PERCENT_RANK | CUME_DIST
  ;


window_name_or_specification
  : window_name
  | window_specification
  ;

/*
===============================================================================
  6.11 <case expression>
===============================================================================
*/

case_expression
  : case_specification
  ;

/*
case_abbreviation
  : NULLIF LEFT_PAREN numeric_value_expression COMMA boolean_value_expression  RIGHT_PAREN
  | COALESCE LEFT_PAREN numeric_value_expression ( COMMA boolean_value_expression  )+ RIGHT_PAREN
  ;
*/

case_abbreviation
  : NULLIF LEFT_PAREN value_expression COMMA value_expression  RIGHT_PAREN
  | COALESCE LEFT_PAREN value_expression ( COMMA value_expression  )+ RIGHT_PAREN
  ;

case_specification
  : simple_case
  | searched_case
  ;

simple_case
  : CASE boolean_value_expression ( simple_when_clause )+ ( else_clause  )? END
  ;

searched_case
  : CASE (searched_when_clause)+ (else_clause)? END
  ;

simple_when_clause : WHEN search_condition THEN result ;

searched_when_clause
  : WHEN c=search_condition THEN r=result
  ;

else_clause
  : ELSE r=result
  ;

result
  : value_expression | NULL
  ;

/*
===============================================================================
  6.12 <cast specification>
===============================================================================
*/

cast_specification
  : CAST LEFT_PAREN cast_operand AS cast_target RIGHT_PAREN
  ;

cast_operand
  : value_expression
  ;

cast_target
  : data_type
  ;

/*
===============================================================================
  6.13 <convert specification>
===============================================================================
*/

convert_specification
  : CONVERT LEFT_PAREN cast_target COMMA cast_operand (COMMA style=NUMBER)? RIGHT_PAREN
  ;

/*
===============================================================================
  6.25 <value expression>
===============================================================================
*/
value_expression
  : common_value_expression
  | row_value_expression
  | boolean_value_expression
  ;

common_value_expression
  : numeric_value_expression
  | odi_variable
  | odi_variable_literal
  | odi_sequence
  | string_value_expression
  | datetime_value_expression
  | ODIREF
  | NULL
  ;

/*
===============================================================================
  6.26 <numeric value expression>

  Specify a comparison of two row values.
===============================================================================
*/

numeric_value_expression
  : left=term ((PLUS|MINUS) right=term)*
  ;

term
  : left=factor ((MULTIPLY|DIVIDE|MODULAR) right=factor)*
  ;

factor
  : (sign)? numeric_primary
  ;

array
  : LEFT_PAREN numeric_value_expression (COMMA numeric_value_expression )* RIGHT_PAREN
  ;

numeric_primary
  : value_expression_primary (CAST_EXPRESSION cast_target)*
  | numeric_value_function
  ;

sign
  : PLUS | MINUS
  ;

/*
===============================================================================
  6.27 <numeric value function>
===============================================================================
*/

numeric_value_function
  : extract_expression
  ;

extract_expression
  : EXTRACT LEFT_PAREN extract_field_string=extract_field FROM extract_source RIGHT_PAREN
  ;

extract_field
  : primary_datetime_field
  | time_zone_field
  | extended_datetime_field
  ;

time_zone_field
  : TIMEZONE | TIMEZONE_HOUR | TIMEZONE_MINUTE
  ;

extract_source
  : datetime_value_expression
  ;

/*
===============================================================================
  6.28 <string value expression>
===============================================================================
*/

string_value_expression
  : character_value_expression
  ;

character_value_expression
  : character_factor (CONCATENATION_OPERATOR character_factor)*
  ;

character_factor
  : character_primary
  ;

character_primary
  : value_expression_primary
  | string_value_function
  ;

/*
===============================================================================
  6.29 <string value function>
===============================================================================
*/

string_value_function
  : trim_function
  ;

trim_function
  : TRIM LEFT_PAREN trim_operands RIGHT_PAREN
  ;

trim_operands
  : ((trim_specification)? (trim_character=character_value_expression)? FROM)? trim_source=character_value_expression
  | trim_source=character_value_expression COMMA trim_character=character_value_expression
  ;

trim_specification
  : LEADING | TRAILING | BOTH
  ;

/*
===============================================================================
  6.30 <datetime_value_expression>
===============================================================================
*/
datetime_value_expression
  : datetime_term
  ;
datetime_term
  : datetime_factor
  ;

datetime_factor
  : datetime_primary
  ;

datetime_primary
  : value_expression_primary
  | datetime_value_function
  ;

/*
===============================================================================
  6.31 <datetime_value_function>
===============================================================================
*/

datetime_value_function
  : current_date_value_function
  | current_time_value_function
  | current_timestamp_value_function
  ;

current_date_value_function
  : CURRENT_DATE
  | CURRENT_DATE LEFT_PAREN RIGHT_PAREN
  ;

current_time_value_function
  : CURRENT_TIME
  | CURRENT_TIME LEFT_PAREN RIGHT_PAREN
  ;

current_timestamp_value_function
  : CURRENT_TIMESTAMP
  ;

/*
===============================================================================
  6.34 <boolean value expression>
===============================================================================
*/

boolean_value_expression
  : or_predicate
  ;

or_predicate
  : and_predicate (OR or_predicate)*
  ;

and_predicate
  : (annotation)* boolean_factor (AND and_predicate)*
  ;

boolean_factor
  : boolean_test
  | NOT boolean_test
  ;

boolean_test
  : boolean_primary is_clause?
  ;

is_clause
  : IS NOT? t=truth_value
  ;

truth_value
  : TRUE | FALSE | UNKNOWN
  ;

boolean_primary
  : predicate
  | boolean_predicand
  ;

boolean_predicand
  : parenthesized_boolean_value_expression
  | nonparenthesized_value_expression_primary
  ;

parenthesized_boolean_value_expression
  : LEFT_PAREN boolean_value_expression RIGHT_PAREN
  ;

/*
===============================================================================
  6.35 ODI variables
===============================================================================
*/

odi_variable
  : Odi_Variable
  ;

odi_variable_literal
  : Odi_Variable_Literal
  ;

odi_sequence
  : Odi_Sequence
  ;

/*
===============================================================================
  7.2 <row value expression>
===============================================================================
*/
row_value_expression
  : row_value_special_case
  | explicit_row_value_constructor
  ;

row_value_special_case
  : nonparenthesized_value_expression_primary
  ;

explicit_row_value_constructor
  : NULL
  ;

row_value_predicand
  : row_value_special_case
  | row_value_constructor_predicand
  ;

row_value_constructor_predicand
  : common_value_expression
  | boolean_predicand
//  | 

  ;

/*
===============================================================================
  7.4 <table expression>
===============================================================================
*/

table_expression
  : from_clause
    pivot_clause?
    where_clause?
    unpivot_clause?
    groupby_clause?
    having_clause?
    orderby_clause?
    window_clause?
    limit_clause?
  ;

/*
===============================================================================
  7.5 <from clause>
===============================================================================
*/

from_clause
  : FROM table_reference_list
  ;

table_reference_list
  :table_reference (COMMA table_reference)*
  ;

/*
===============================================================================
    <unpivot clause>
===============================================================================
*/

unpivot_fields_list
  : LEFT_PAREN? identifier (COMMA identifier)* RIGHT_PAREN?
  ;

unpivot_source_fields_list
  : LEFT_PAREN? common_value_expression (COMMA common_value_expression)* RIGHT_PAREN?
  ;

unpivot_rule
  : unpivot_source_fields_list AS (Character_String_Literal | signed_numerical_literal)
  ;

unpivot_rules
  : LEFT_PAREN unpivot_rule (COMMA unpivot_rule)* RIGHT_PAREN
  ;

unpivot_clause
  : UNPIVOT (INCLUDE NULLS)? LEFT_PAREN unpivot_fields_list FOR locator=identifier IN unpivot_rules RIGHT_PAREN (AS)? alias=identifier
  ;

/*
===============================================================================
    <unpivot clause>
===============================================================================
*/

pivot_fields_list
  : LEFT_PAREN? identifier (COMMA identifier)* RIGHT_PAREN?
  ;

pivot_source_fields_list
  : LEFT_PAREN? common_value_expression (COMMA common_value_expression)* RIGHT_PAREN?
  ;

pivot_rule
  : unpivot_source_fields_list AS (Character_String_Literal | signed_numerical_literal)
  ;

pivot_rules
  : LEFT_PAREN unpivot_rule (COMMA unpivot_rule)* RIGHT_PAREN
  ;

pivot_clause
  : PIVOT LEFT_PAREN pivot_fields_list FOR locator=identifier IN unpivot_rules RIGHT_PAREN (AS)? alias=identifier
  ;

/*
===============================================================================
  7.6 <table reference>
===============================================================================
*/

table_reference
  : joined_table
  | table_primary
  ;

/*
===============================================================================
  7.7 <joined table>
===============================================================================
*/

annotated_joined_table_primary
  : (annotation)* joined_table_primary
  ;

joined_table
  : LEFT_PAREN? table_primary annotated_joined_table_primary* RIGHT_PAREN?
  ;

joined_table_primary
  : CROSS JOIN right=joined_table
  | (t=join_type)? JOIN right=joined_table s=join_specification
  | NATURAL (t=join_type)? JOIN right=joined_table s=join_specification
  | UNION JOIN right=joined_table
  ;

cross_join
  : CROSS JOIN r=table_reference
  ;

qualified_join
  : (t=join_type)? JOIN r=table_primary s=join_specification
  ;

natural_join
  : NATURAL (t=join_type)? JOIN r=table_primary
  ;

union_join
  : UNION JOIN r=table_primary
  ;

join_type
  : INNER
  | t=outer_join_type
  ;

outer_join_type
  : outer_join_type_part2 OUTER?
  ;

outer_join_type_part2
  : LEFT
  | RIGHT
  | FULL
  ;

first_row : FIRST ROW;

last_row : LAST ROW;

all_rows : ALL ROWS; 

lookup_specification
  : first_row orderby_clause
  | last_row orderby_clause
  | all_rows
  ;

join_specification
  : (join_condition | named_columns_join) lookup_specification?
  ;

join_condition
  : ON search_condition
  ;

named_columns_join
  : USING LEFT_PAREN f=column_reference_list RIGHT_PAREN
  ;

table_primary
  : table_or_query_name ((AS)? alias=identifier)? (LEFT_PAREN column_name_list RIGHT_PAREN)?
  | derived_table (AS)? name=identifier (LEFT_PAREN column_name_list RIGHT_PAREN)?
  | table_function (LEFT_PAREN column_name_list RIGHT_PAREN) (AS)? alias=identifier
  ;

target_column
  : COMMA? (annotation)* identifier
  ;

column_name_list
  :  (target_column)*
  ;

derived_table
  : table_subquery
  ;

/*
===============================================================================
  7.8 <where clause>
===============================================================================
*/
where_clause
  : (annotation)* WHERE search_condition
  ;

search_condition
  : value_expression // instead of boolean_value_expression, we use value_expression for more flexibility.
  ;

/*
===============================================================================
  7.9 <group by clause>
===============================================================================
*/
groupby_clause
  : (annotation)* GROUP BY g=grouping_element_list
  ;

grouping_element_list
  : grouping_element (COMMA grouping_element)*
  ;

grouping_element
  : rollup_list
  | cube_list
  | empty_grouping_set
  | ordinary_grouping_set
  ;

ordinary_grouping_set
  : row_value_predicand
  | LEFT_PAREN row_value_predicand_list RIGHT_PAREN
  ;

ordinary_grouping_set_list
  : ordinary_grouping_set (COMMA ordinary_grouping_set)*
  ;

rollup_list
  : ROLLUP LEFT_PAREN c=ordinary_grouping_set_list RIGHT_PAREN
  ;

cube_list
  : CUBE LEFT_PAREN c=ordinary_grouping_set_list RIGHT_PAREN
  ;

empty_grouping_set
  : LEFT_PAREN RIGHT_PAREN
  ;

having_clause
  : HAVING boolean_value_expression
  ;

row_value_predicand_list
  : row_value_predicand (COMMA row_value_predicand)*
  ;


 /*
 ===============================================================================
   7.11 <window clause> (p331)
 ===============================================================================
 */

window_clause
  : WINDOW window_definition_list;

window_definition_list
  : window_definition (COMMA window_definition)*
  ;

window_definition
  : window_name AS window_specification
  ;

window_name
  : identifier
  ;

window_specification
  : LEFT_PAREN window_specification_details RIGHT_PAREN
  ;

window_specification_details
  : (existing_window_name)? (window_partition_clause)? (window_order_clause)? (window_frame_clause)?
  ;

existing_window_name
  : window_name
  ;

window_partition_clause
  : PARTITION BY row_value_predicand_list
  ;

window_order_clause
  : orderby_clause
  ;

window_frame_clause
  : window_frame_units window_frame_extent (window_frame_exclusion)?
  ;

window_frame_units
  : ROWS | RANGE
  ;

window_frame_extent
  : window_frame_start_bound
  | window_frame_between
  ;

window_frame_start_bound
  : UNBOUNDED PRECEDING
  | unsigned_value_specification PRECEDING // window_frame_preceding
  | CURRENT ROW
  ;

window_frame_between
  : BETWEEN bound1=window_frame_start_bound AND bound2=window_frame_end_bound
  ;

window_frame_end_bound
  : UNBOUNDED FOLLOWING
  | unsigned_value_specification FOLLOWING // window_frame_following FOLLOWING
  | CURRENT ROW
  ;

window_frame_exclusion
  : EXCLUDE CURRENT ROW
  | EXCLUDE GROUP
  | EXCLUDE TIES
  | EXCLUDE NO OTHERS
  ;

/*
===============================================================================
  7.13 <query expression>
===============================================================================
*/

/*
named_query
  : name=Regular_Identifier AS LEFT_PAREN query_specification RIGHT_PAREN
  ;
*/

named_query
  : name=Regular_Identifier AS LEFT_PAREN query_expression_body RIGHT_PAREN
  ;


with_clause
  : WITH named_query (COMMA named_query)*
  ;

query_expression
  : with_clause? query_expression_body
  ;

query_expression_body
  : non_join_query_expression
  | joined_table
  ;

non_join_query_expression
  : (non_join_query_term
  | joined_table (UNION | EXCEPT | MINUS_SET) (ALL|DISTINCT)? query_term)
    ( (annotation)* (UNION | EXCEPT | MINUS_SET) (ALL|DISTINCT)? query_term)*
  ;

query_term
  : non_join_query_term
  | joined_table
  ;

non_join_query_term
  : ( non_join_query_primary
  | joined_table (annotation)* INTERSECT (ALL|DISTINCT)? query_primary)
    (INTERSECT (ALL|DISTINCT)? query_primary)*
  ;

query_primary
  : non_join_query_primary
  | joined_table
  ;

non_join_query_primary
  : simple_table
  | LEFT_PAREN non_join_query_expression RIGHT_PAREN
  ;

simple_table
  : query_specification
  | explicit_table
  ;

explicit_table
  : TABLE table_or_query_name
  ;

table_or_query_name
  : table_name
  | identifier
  ;

table_name
  : identifier (DOT identifier ( DOT identifier)? )?
  | mapping_name
  ;

column_name
  : identifier
  ;

folder_name
  : identifier (DOT identifier)+
  ;

mapping_name
  : identifier DOT identifier DOT identifier (DOT identifier)*
  ;

dataset_hint : Hint_Start identifier (LEFT_PAREN identifier RIGHT_PAREN)? Hint_End;

query_specification
  : (annotation)* SELECT dataset_hint? set_qualifier? select_list table_expression?
  ;

select_list
  : select_sublist (COMMA select_sublist)*
  ;

select_sublist
  : derived_column
  | qualified_asterisk
  ;

derived_column
  : (annotation)* value_expression as_clause?
  ;

qualified_asterisk
  : (tb_name=identifier DOT)? MULTIPLY
  ;

set_qualifier
  : DISTINCT
  | ALL
  ;

column_reference
  : ((db_name = identifier DOT)? (tb_name=identifier DOT))? name=identifier
  ;

as_clause
  : (AS)? identifier
  ;

column_reference_list
  : column_reference (COMMA column_reference)*
  ;

/*
==============================================================================================
  7.15 <subquery>

  Specify a scalar value, a row, or a table derived from a query_expression .
==============================================================================================
*/

cursor_function
  : CURSOR table_subquery
  ;

scalar_subquery
  :  subquery
  ;

row_subquery
  :  subquery
  ;

table_subquery
  : subquery
  ;

subquery
  :  LEFT_PAREN query_expression RIGHT_PAREN
  ;

/*
===============================================================================
  8.1 <predicate>
===============================================================================
*/

predicate
  : quantified_comparison_predicate
  | comparison_predicate
  | between_predicate
  | in_predicate
  | pattern_matching_predicate // like predicate and other similar predicates
  | null_predicate
  | exists_predicate
  ;

/*
==============================================================================================
  8.8 <quantified comparison predicate>

  Specify a quantified comparison.
==============================================================================================
*/

quantified_comparison_predicate
  : l=common_value_expression c=comp_op (q=quantifier)? s=table_subquery
  ;

quantifier : all  | some ;

all : ALL;

some : SOME | ANY;

/*
===============================================================================
  8.2 <comparison predicate>

  Specify a comparison of two row values.
===============================================================================
*/
comparison_predicate
  : left=row_value_predicand c=comp_op right=row_value_predicand
  ;

comp_op
  : EQUAL
  | NOT_EQUAL
  | LTH
  | LEQ
  | GTH
  | GEQ
  ;

/*
===============================================================================
  8.3 <between predicate>
===============================================================================
*/

between_predicate
  : predicand=row_value_predicand between_predicate_part_2
  ;

between_predicate_part_2
  : (NOT)? BETWEEN (ASYMMETRIC | SYMMETRIC)? begin=row_value_predicand AND end=row_value_predicand
  ;


/*
===============================================================================
  8.4 <in predicate>
===============================================================================
*/

in_predicate
  : common_value_expression NOT? IN in_predicate_value
  | LEFT_PAREN row_value_predicand_list RIGHT_PAREN  NOT? IN in_predicate_value
  ;

in_predicate_value
  : table_subquery
  | LEFT_PAREN in_value_list RIGHT_PAREN
  ;

in_value_list
  : row_value_predicand  ( COMMA row_value_predicand )*
  ;

/*
===============================================================================
  8.5, 8.6 <pattern matching predicate>

  Specify a pattern-matching comparison.
===============================================================================
*/

/*
pattern_matching_predicate
  : f=row_value_predicand pattern_matcher s=Character_String_Literal
  ;
*/
pattern_matching_predicate
  : f=row_value_predicand pattern_matcher s=row_value_predicand
  ;

pattern_matcher
  : NOT? negativable_matcher
  | regex_matcher
  ;

negativable_matcher
  : LIKE
  | ILIKE
  | SIMILAR TO
  | REGEXP
  | RLIKE
  ;

regex_matcher
  : Similar_To
  | Not_Similar_To
  | Similar_To_Case_Insensitive
  | Not_Similar_To_Case_Insensitive
  ;

/*
===============================================================================
  8.7 <null predicate>

  Specify a test for a null value.
===============================================================================
*/

null_predicate
  : predicand=row_value_predicand IS (n=NOT)? NULL
  ;


/*
==============================================================================================
  8.9 <exists predicate>

  Specify a test for a non_empty set.
==============================================================================================
*/

exists_predicate
  : NOT? EXISTS s=table_subquery
  ;


/*
==============================================================================================
  8.10 <unique predicate>

  Specify a test for the absence of duplicate rows
==============================================================================================
*/

unique_predicate
  : UNIQUE s=table_subquery
  ;

/*
===============================================================================
  10.1 <interval qualifier>

  Specify the precision of an interval data type.
===============================================================================
*/

primary_datetime_field
	:	non_second_primary_datetime_field
	|	SECOND
	;

non_second_primary_datetime_field
  : YEAR | MONTH | DAY | HOUR | MINUTE
  ;

extended_datetime_field
  : CENTURY | DECADE | DOW | DOY | EPOCH | ISODOW | ISOYEAR | MICROSECONDS | MILLENNIUM | MILLISECONDS | QUARTER | WEEK
  ;

/*
===============================================================================
  10.4 <routine invocation>

  Invoke an SQL-invoked routine.
===============================================================================
*/

routine_invocation
  : function_name LEFT_PAREN sql_argument_list? RIGHT_PAREN
  ;

function_names_for_reserved_words
  : LEFT
  | RIGHT
  | REPLACE
  ;

schema_name
  : identifier 
  | ODIREF
  ;

function_name
  : (schema_name DOT)? (package_name=identifier DOT)? name=identifier  
  | function_names_for_reserved_words
  ;

sql_argument_list
  : value_expression (COMMA value_expression)*
  ;

/*
===============================================================================
  14.1 <declare cursor>
===============================================================================
*/

table_function
  : TABLE LEFT_PAREN routine_invocation RIGHT_PAREN
  ;

orderby_clause
  : (annotation)* ORDER BY sort_specifier_list
  ;

sort_specifier_list
  : sort_specifier (COMMA sort_specifier)*
  ;

sort_specifier
  : key=row_value_predicand order=order_specification? null_order=null_ordering?
  ;

order_specification
  : ASC
  | DESC
  ;

limit_clause
  : LIMIT e=numeric_value_expression
  ;

null_ordering
  : NULLS FIRST
  | NULLS LAST
  ;

/*
===============================================================================
  14.8 <insert statement>
===============================================================================
*/

integration_params
   : (INTEGRATION_TYPE integration_type=Character_String_Literal) (UPDATE_KEY key=Regular_Identifier)? (REJECT LIMIT max_rejected=unsigned_numeric_literal rejected_unit=(ROWS|PERCENT))?
   ;

insert_statement
  : (annotation)* INSERT (OVERWRITE)? INTO table_name (alias=identifier)? (LEFT_PAREN column_name_list RIGHT_PAREN)? integration_params? query_expression
  | INSERT (OVERWRITE)? INTO LOCATION path=Character_String_Literal (USING storage_type=identifier (param_clause)?)? query_expression
  ;

/*
===============================================================================
  14.8 <muti table insert statement>
===============================================================================
*/

multi_insert_select_list
  : value_expression (COMMA value_expression)*
  ;
multi_insert_target
  : (annotation)* (WHEN search_condition THEN)? INTO table_name (alias=identifier)? (LEFT_PAREN column_name_list RIGHT_PAREN)? VALUES (LEFT_PAREN multi_insert_select_list RIGHT_PAREN) integration_params?
  ;

multi_insert_def_target
  : ELSE INTO table_name (alias=identifier)? (LEFT_PAREN column_name_list RIGHT_PAREN)? VALUES (LEFT_PAREN multi_insert_select_list RIGHT_PAREN) integration_params?
  ;

multi_insert_statement
  : (annotation)* INSERT ALL (multi_insert_target)+ (multi_insert_def_target)? query_expression
  ;
/*
===============================================================================
  <alter table>
===============================================================================
*/

alter_tablespace_statement
  : ALTER TABLESPACE space_name=identifier LOCATION uri=Character_String_Literal
  ;

datastore_key
  : key_type=CONSTRAINT key_name=identifier (PRIMARY_KEY | ALTERNATE_KEY | INDEX | UNIQUE INDEX) LEFT_PAREN column_name_list RIGHT_PAREN
  ;

datastore_check
  : key_type=CONSTRAINT key_name=identifier CHECK LEFT_PAREN search_condition RIGHT_PAREN
  ;

constraint_control
  : CONTROL FLOW
  | CONTROL STATIC
  | CONTROL FLOW STATIC
  | CONTROL STATIC FLOW
  ;

in_database
  : DEFINED IN DATABASE (ACTIVE)?
  ;

constraint_type
  : TYPE ODI
  | TYPE DATABASE
  ;

datastore_condition_message
  : MESSAGE comm=Character_String_Literal
  ;

datastore_constraint
  : (annotation)* (datastore_key | datastore_check) constraint_type? in_database? constraint_control? datastore_condition_message?
  ;

alter_table_statement
  : ALTER (TABLE|DATASTORE) table_name RENAME TO table_name
  | ALTER (TABLE|DATASTORE) table_name RENAME COLUMN column_name TO column_name
  | ALTER (TABLE|DATASTORE) table_name MODIFY COLUMN modify_field_element
  | ALTER (TABLE|DATASTORE) table_name ADD COLUMN field_element
  | ALTER (TABLE|DATASTORE) table_name ADD datastore_constraint
  | ALTER (TABLE|DATASTORE) table_name CMNT comm=Character_String_Literal
  ;

alter_mapping_statement
  : ALTER MAPPING (if_exists)? mapping_name MODIFY phys_design_clause
  | ALTER REUSABLE? MAPPING (if_exists)? mapping_name CMNT comm=Character_String_Literal
  ;

/*
  Project operations
 */
 open_project_statement
    : PROJECT path=identifier
    ;

connect_statement
    : CONNECT (ODI)? name=identifier
    ;