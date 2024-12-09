/*
 Licensed to the Apache Software Foundation (ASF) under one
 or more contributor license agreements.  See the NOTICE file
 distributed with this work for additional information
 regarding copyright ownership.  The ASF licenses this file
 to you under the Apache License, Version 2.0 (the
 "License"); you may not use this file except in compliance
 with the License.  You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

lexer grammar SQLLexer;

@header {
}

@members {
}


/*
===============================================================================
  Tokens for Case Insensitive Keywords
===============================================================================
*/
fragment A
	:	'A' | 'a';

fragment B
	:	'B' | 'b';

fragment C
	:	'C' | 'c';

fragment D
	:	'D' | 'd';

fragment E
	:	'E' | 'e';

fragment F
	:	'F' | 'f';

fragment G
	:	'G' | 'g';

fragment H
	:	'H' | 'h';

fragment I
	:	'I' | 'i';

fragment J
	:	'J' | 'j';

fragment K
	:	'K' | 'k';

fragment L
	:	'L' | 'l';

fragment M
	:	'M' | 'm';

fragment N
	:	'N' | 'n';

fragment O
	:	'O' | 'o';

fragment P
	:	'P' | 'p';

fragment Q
	:	'Q' | 'q';

fragment R
	:	'R' | 'r';

fragment S
	:	'S' | 's';

fragment T
	:	'T' | 't';

fragment U
	:	'U' | 'u';

fragment V
	:	'V' | 'v';

fragment W
	:	'W' | 'w';

fragment X
	:	'X' | 'x';

fragment Y
	:	'Y' | 'y';

fragment Z
	:	'Z' | 'z';

/*
===============================================================================
  Reserved Keywords
===============================================================================
*/

AS : A S;
ALL : A L L;
AND : A N D;
ANY : A N Y;
ASYMMETRIC : A S Y M M E T R I C;
ASC : A S C;


BOTH : B O T H;

CASE : C A S E;
CAST : C A S T;
CREATE : C R E A T E;
CROSS : C R O S S;
CURRENT_DATE: C U R R E N T UNDERLINE D A T E;
CURRENT_TIME: C U R R E N T UNDERLINE T I M E;
CURRENT_TIMESTAMP: C U R R E N T UNDERLINE T I M E S T A M P;

DESC : D E S C;
DISTINCT : D I S T I N C T;
DATASET : D A T A S E T;

END : E N D;
ELSE : E L S E;
EXCEPT : E X C E P T;

FALSE : F A L S E;
FULL : F U L L;
FROM : F R O M;

GROUP : G R O U P;

HAVING : H A V I N G;

ILIKE : I L I K E;
IN : I N;
INNER : I N N E R;
INTERSECT : I N T E R S E C T;
INTO : I N T O;
IS : I S;

JOIN : J O I N;

LEADING : L E A D I N G;
LEFT : L E F T;
LIKE : L I K E;
LIMIT : L I M I T;

MAPPING : M A P P I N G;

NATURAL : N A T U R A L;
NOT : N O T;
NULL : N U L L;

ON : O N;
OR : O R;
ORDER : O R D E R;
OUTER : O U T E R;
OVER : O V E R;
PACKAGE : P A C K A G E;
PROCEDURE : P R O C E D U R E;
PROJECT : P R O J E C T;
RIGHT : R I G H T;
REUSABLE : R E U S A B L E;
SELECT : S E L E C T;
SOME : S O M E;
SYMMETRIC : S Y M M E T R I C;
SCENARIO : S C E N A R I O;

TABLE : T A B L E;
THEN : T H E N;
TRAILING : T R A I L I N G;
TRUE : T R U E;

UNION : U N I O N;
UNIQUE : U N I Q U E;
USING : U S I N G;

WHEN : W H E N;
WHERE : W H E R E;
WITH : W I T H;
WINDOW : W I N D O W;

VARIABLE : V A R I A B L E;

/* Extensions for defining file datastore */
POSITION : P O S I T I O N;
OFFSET: O F F S E T;

/* ODI extensions */

IKM : I K M;
LKM : L K M;
CKM : C K M;
TECHNOLOGY : T E C H N O L O G Y;

PHYSICAL_DESIGN : P H Y S I C A L Space D E S I G N;
DESCRIPTION : D E S C R I P T I O N;
OPTIMIZATION_CONTEXT : O P T I M I Z A T I O N Space C O N T E X T;
REMOVE_TEMPORARY_OBJECTS_ON_ERROR : R E M O V E Space T E M P O R A R Y Space O B J E C T S Space O N Space E R R O R;
UNIQUE_TEMPORARY_OBJECT_NAMES : U N I Q U E Space T E M P O R A R Y Space O B J E C T Space N A M E S;

/*
===============================================================================
  Non Reserved Keywords
===============================================================================
*/
AVG : A V G;
ADD: A D D;
ALTER : A L T E R;

BETWEEN : B E T W E E N;
BY : B Y;

CASCADE : C A S C A D E;
CATALOG : C A T A L O G;
CENTURY : C E N T U R Y;
CHARACTER : C H A R A C T E R;
COLLECT : C O L L E C T;
COALESCE : C O A L E S C E;
COLUMN : C O L U M N;
COUNT : C O U N T;
CUBE : C U B E;
CUME_DIST : C U M E UNDERLINE D I S T;
CURRENT : C U R R E N T;
STRING : S T R I N G;
FEBCDIC : F I X E D Space E B C D I C;
SIGNED_PACKED_DECIMAL : S I G N E D Space P A C K E D Space D E C I M A L;
EBCDIC_SIGNED_ZONED_DECIMAL : E B C D I C Space S I G N E D Space Z O N E D Space D E C I M A L;

DAY : D A Y;
DEFAULT : D E F A U L T;
DATABASE : D A T A B A S E;
DEC : D E C;
DECADE : D E C A D E;
DENSE_RANK : D E N S E UNDERLINE R A N K;
DOW : D O W;
DOY : D O Y;
DROP : D R O P;

EPOCH : E P O C H;
EVERY : E V E R Y;
EXCLUDE : E X C L U D E;
EXISTS : E X I S T S;
EXPLAIN : E X P L A I N;
EXTERNAL : E X T E R N A L;
EXTRACT : E X T R A C T;

FILTER : F I L T E R;
FIRST : F I R S T;
FIRST_VALUE : F I R S T UNDERLINE V A L U E;
FOLLOWING : F O L L O W I N G;
FOR : F O R;
FORMAT : F O R M A T;
FUSION : F U S I O N;

GROUPING : G R O U P I N G;

HASH : H A S H;
HOUR : H O U R;

IF : I F;
INDEX : I N D E X;
INSERT : I N S E R T;
INTERSECTION : I N T E R S E C T I O N;
ISODOW : I S O D O W;
ISOYEAR : I S O Y E A R;

LAG : L A G;
LAST : L A S T;
LAST_VALUE : L A S T UNDERLINE V A L U E;
LEAD : L E A D;
LESS : L E S S;
LIST : L I S T;
LOCATION : L O C A T I O N;

MAX : M A X;
MAXVALUE : M A X V A L U E;
MICROSECONDS : M I C R O S E C O N D S;
MILLENNIUM : M I L L E N N I U M;
MILLISECONDS : M I L L I S E C O N D S;
MIN : M I N;
MINUTE : M I N U T E;
MONTH : M O N T H;

NATIONAL : N A T I O N A L;
NULLIF : N U L L I F;
NO : N O;

OVERWRITE : O V E R W R I T E;
OTHERS: O T H E R S;

PARTITION : P A R T I T I O N;
PARTITIONS : P A R T I T I O N S;
PERCENT_RANK : P E R C E N T UNDERLINE R A N K;
PRECEDING : P R E C E D I N G;
PRECISION : P R E C I S I O N;
PURGE : P U R G E;

QUARTER : Q U A R T E R;

RANGE : R A N G E;
RANK : R A N K;
REGEXP : R E G E X P;
RENAME : R E N A M E;
RESET : R E S E T;
RLIKE : R L I K E;
ROLLUP : R O L L U P;
ROW : R O W;
ROWS : R O W S;
ROW_NUMBER :  R O W UNDERLINE N U M B E R;

SECOND : S E C O N D;
SESSION : S E S S I O N;
SET : S E T;
SIMILAR : S I M I L A R;
STDDEV_POP : S T D D E V UNDERLINE P O P;
STDDEV_SAMP : S T D D E V UNDERLINE S A M P;
SUBPARTITION : S U B P A R T I T I O N;
SUM : S U M;

TABLESPACE : T A B L E S P A C E;
THAN : T H A N;
TIES : T I E S;
TIMEZONE: T I M E Z O N E;
TIMEZONE_HOUR: T I M E Z O N E UNDERLINE H O U R;
TIMEZONE_MINUTE: T I M E Z O N E UNDERLINE M I N U T E;
TRIM : T R I M;
TO : T O;
TRUNCATE : T R U N C A T E;

UNBOUNDED : U N B O U N D E D;
UNKNOWN : U N K N O W N;

VALUES : V A L U E S;
VAR_SAMP : V A R UNDERLINE S A M P;
VAR_POP : V A R UNDERLINE P O P;
VARYING : V A R Y I N G;

WEEK : W E E K;

YEAR : Y E A R;

ZONE : Z O N E;


/*
===============================================================================
  Data Type Tokens
===============================================================================
*/
BOOLEAN : B O O L E A N;
BOOL : B O O L;
BIT : B I T;
VARBIT : V A R B I T;

INT1 : I N T '1';
INT2 : I N T '2';
INT4 : I N T '4';
INT8 : I N T '8';

TINYINT : T I N Y I N T; // alias for INT1
SMALLINT : S M A L L I N T; // alias for INT2
INT : I N T; // alias for INT4
INTEGER : I N T E G E R; // alias - INT4
BIGINT : B I G I N T; // alias for INT8

FLOAT4 : F L O A T '4';
FLOAT8 : F L O A T '8';

REAL : R E A L; // alias for FLOAT4
FLOAT : F L O A T; // alias for FLOAT8
DOUBLE : D O U B L E; // alias for FLOAT8

NUMERIC : N U M E R I C;
ORANUMBER : N U M B E R;
DECIMAL : D E C I M A L; // alias for number

CHAR : C H A R;
VARCHAR2 : V A R C H A R '2';
VARCHAR : V A R C H A R;
NCHAR : N C H A R;
NVARCHAR : N V A R C H A R;
CLOB : C L O B;

DATE : D A T E;
INTERVAL: I N T E R V A L;
TIME : T I M E;
TIMETZ : T I M E T Z;
TIMESTAMP : T I M E S T A M P;
TIMESTAMPTZ : T I M E S T A M P T Z;

TEXT : T E X T;

BINARY : B I N A R Y;
VARBINARY : V A R B I N A R Y;
BLOB : B L O B;
BYTEA : B Y T E A; // alias for BLOB

INET4 : I N E T '4';

// Operators
Similar_To : '~';
Not_Similar_To : '!~';
Similar_To_Case_Insensitive : '~*';
Not_Similar_To_Case_Insensitive : '!~*';

// Cast Operator
CAST_EXPRESSION
  : COLON COLON
  ;

ASSIGN  : ':=';
EQUAL  : '=';
COLON :  ':';
SEMI_COLON :  ';';
COMMA : ',';
CONCATENATION_OPERATOR : VERTICAL_BAR VERTICAL_BAR;
NOT_EQUAL  : '<>' | '!=' | '~='| '^=' ;
LTH : '<' ;
LEQ : '<=';
GTH   : '>';
GEQ   : '>=';
LEFT_PAREN :  '(';
RIGHT_PAREN : ')';
PLUS  : '+';
MINUS : '-';
MULTIPLY: '*';
DIVIDE  : '/';
MODULAR : '%';
DOT : '.';
UNDERLINE : '_';
VERTICAL_BAR : '|';
QUOTE : '\'';
DOUBLE_QUOTE : '"';
HASH_SIGN : '#';
AT_SIGN : '@';

NUMBER : Digit+;

fragment
Digit : '0'..'9';

REAL_NUMBER
    :   ('0'..'9')+ '.' ('0'..'9')* EXPONENT?
    |   ('0'..'9')+ EXPONENT
    ;

NULLS : N U L L S;

MINUS_SET : M I N U S;

DATASTORE : D A T A S T O R E;
ALIAS : A L I A S;
RESOURCE : R E S O U R C E;
FILE : F I L E;
HEADING : H E A D I N G;
RECORD_SEP : R E C O R D Space S E P A R A T O R;
FIELD_SEP : F I E L D Space S E P A R A T O R;
TEXT_DELIM : TEXT Space D E L I M I T E R;
DECIMAL_SEP : DECIMAL Space S E P A R A T O R; 
FIXED : F I X E D;
DELIMITED : D E L I M I T E D;
PHYS_LENGTH : P H Y S I C A L Space L E N G T H;
SCD : S C D;

fragment
ADD_ROW_ON_CHANGE : A D D UNDERLINE R O W UNDERLINE O N UNDERLINE C H A N G E;

fragment
CURRENT_RECORD_FLAG : C U R R E N T UNDERLINE R E C O R D UNDERLINE F L A G;

fragment
START_TIMESTAMP : S T A R T UNDERLINE T I M E S T A M P;

fragment
END_TIMESTAMP : E N D UNDERLINE T I M E S T A M P;

fragment
NATURAL_KEY : N A T U R A L UNDERLINE K E Y;

fragment
OVERWRITE_ON_CHANGE : O V E R W R I T E UNDERLINE O N UNDERLINE C H A N G E;

fragment
SURROGATE_KEY : S U R R O G A T E UNDERLINE K E Y;

SCD_BEHAVIOR
    : ADD_ROW_ON_CHANGE | CURRENT_RECORD_FLAG | START_TIMESTAMP | END_TIMESTAMP | NATURAL_KEY | OVERWRITE_ON_CHANGE | SURROGATE_KEY
    ;

MODEL : M O D E L;
WITH_NAME : W I T H Space N A M E;
LOGICAL_SCHEMA : L O G I C A L Space S C H E M A;
FOLDER : F O L D E R;
SUBMODEL : S U B M O D E L;
MODIFY : M O D I F Y;
REPLACE : R E P L A C E;
CONTEXT : C O N T E X T;
XKM : X K M;
SEQUENCEFILE : S E Q U E N C E F I L E;
FIELDS : F I E L D S;
TERMINATED : T E R M I N A T E D;
ESCAPED : E S C A P E D;
DEFINED : D E F I N E D;
SERDE : S E R D E;
SERDEPROPERTIES : S E R D E P R O P E R T I E S;
TEXTFILE : T E X T F I L E;
RCFILE : R C F I L E;
ORC : O R C;
PARQUET: P A R Q U E T;
AVRO : A V R O;
INPUTFORMAT : I N P U T F O R M A T;
OUTPUTFORMAT : O U T P U T F O R M A T;
TEMPORARY : T E M P O R A R Y;
STORED_AS : S T O R E D Space A S;
TBLPROPERTIES : T B L P R O P E R T I E S;
ROW_FORMAT : R O W Space F O R M A T;
INTEGRATION_TYPE: I N T E G R A T I O N Space T Y P E;
UPDATE_KEY: U P D A T E Space K E Y;
REJECT: R E J E C T;
PERCENT: P E R C E N T;
PRIMARY_KEY: P R I M A R Y Space K E Y;
ALTERNATE_KEY: U N I Q U E Space K E Y;
OLAP_TYPE: O L A P Space T Y P E;
CONSTRAINT: C O N S T R A I N T;

ODI_Tag_Start : '<%' | '<?' | '<$' | '<@';
ODI_Tag_End : '%>' | '?>' | '$>' | '@>';
ODIREF : ODI_Tag_Start .*? ODI_Tag_End;

CURSOR : C U R S O R;

SUCCESS: S U C C E S S;
ERROR: E R R O R;
GOTO: G O T O;
DECLARE: D E C L A R E;
REFRESH: R E F R E S H;
RETRY: R E T R Y;
WAIT: W A I T;
BEGIN: B E G I N;
EXIT: E X I T;
CMNT: C O M M E N T;
LISTAGG: L I S T A G G;
WITHIN_GROUP: W I T H I N Space G R O U P;
EXPORT: E X P O R T;
IMPORT: I M P O R T;
REGENERATE: R E G E N E R A T E;
OR_REPLACE: O R Space R E P L A C E;
TYPE: T Y P E;
STAGING: S T A G I N G;
CONNECT: C O N N E C T;
ODI: O D I;
IGNORE_NULLS: I G N O R E Space N U L L S;
RESPECT_NULLS: R E S P E C T Space N U L L S;
CONVERT: C O N V E R T;
DATETIME: D A T E T I M E;
VARCHAR_MAX: VARCHAR LEFT_PAREN MAX RIGHT_PAREN;
VARCHAR2_MAX: VARCHAR2 LEFT_PAREN MAX RIGHT_PAREN;
CONTINUE: C O N T I N U E;
CHECK: C H E C K;
CONTROL: C O N T R O L;
FLOW: F L O W;
STATIC: S T A T I C;
ACTIVE: A C T I V E;
MESSAGE: M E S S A G E;
KEEP: K E E P;
PIVOT: P I V O T;
UNPIVOT: U N P I V O T;
INCLUDE: I N C L U D E;

Odi_Sequence  : (HASH_SIGN | COLON) Regular_Identifier '.' Regular_Identifier UNDERLINE (N E X T V A L | C U R R V A L); /*{ setText(getText().substring(0, getText().length()-8)); } ;*/
Odi_Variable : HASH_SIGN Regular_Identifier '.' Regular_Identifier;
Odi_Variable_Literal : QUOTE Odi_Variable QUOTE;

Hint_Start
    : '/*+' 
    ;

Hint_End
    : '*/' 
    ;

BlockComment
    :   '/*' ~[+]*? '*/' -> skip
    ;

LineComment
    :   '--' ~[+\r\n]* -> skip
    ;

/*
===============================================================================
 Identifiers
===============================================================================
*/
Regular_Identifier
  : ('a'..'z'|'A'..'Z'|Digit|'_') ('a'..'z'|'A'..'Z'|Digit|'_')* { setText(getText().toUpperCase()); }
  ;

Quoted_Identifier
  : DOUBLE_QUOTE ( ESC_SEQ | ~('\\'|'"') )* DOUBLE_QUOTE { setText(getText().substring(1, getText().length()-1).replaceAll("\\\\\"", "\"")); }
  ;

/*
===============================================================================
 Literal
===============================================================================
*/

// Some Unicode Character Ranges
fragment
Control_Characters                  :   '\u0001' .. '\u001F';
fragment
Extended_Control_Characters         :   '\u0080' .. '\u009F';

Character_String_Literal
  : QUOTE ( (QUOTE QUOTE) | ESC_SEQ | ~('\'') )* QUOTE { setText(getText().replaceAll("\\\\\'", "'")); }
  ;

fragment
EXPONENT : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;

fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
ESC_SEQ
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')
    |   UNICODE_ESC
    |   OCTAL_ESC
    ;

fragment
OCTAL_ESC
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UNICODE_ESC
    :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;

FreeCode
   : 'q' QUOTE '[' ~[+]*? ']' QUOTE { setText(getText().substring(3).substring(0, getText().substring(3).length()-2)); }
   ;

/*
===============================================================================
 Whitespace Tokens
===============================================================================
*/

Space
  : ' ' -> skip
  ;

White_Space
  :	( Control_Characters  | Extended_Control_Characters )+ -> skip
  ;

BAD
  : . -> skip
  ;
