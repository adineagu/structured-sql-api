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
package org.pecheasoft.odigen.sql.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.prefs.Preferences;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Sets;

/**
 * It provides miscellaneous and useful util methods.
 */
public class TUtil {

    /**
     * check two objects as equals. It will return true even if they are all
     * null.
     *
     * @param s1 the first object to be compared.
     * @param s2 the second object to be compared
     *
     * @return true if they are equal or all null
     */
    public static boolean checkEquals(Object s1, Object s2) {
        return Objects.equals(s1, s2);
    }

    /**
     * check two collections as equals. It also check the equivalence of null.
     * It will return true even if they are all null.
     *
     * @param s1 the first collection to be compared.
     * @param s2 the second collection to be compared
     * @return true if they are equal or all null
     */
    @SuppressWarnings("null")
    public static boolean checkEquals(Collection<?> s1, Collection<?> s2) {
        if (s1 == null ^ s2 == null) {
            return false;
       } else {
            if (s1.isEmpty() && s2.isEmpty()) {
                return true;
            } else if (s1.size() == s2.size()) {
                Iterator<?> it1 = s1.iterator();
                Iterator<?> it2 = s2.iterator();
                Object o1;
                Object o2;
                for (o1 = it1.next(), o2 = it2.next(); it1.hasNext() && it2.hasNext(); o1 = it1.next(), o2 = it2.next()) {
                    if (!o1.equals(o2)) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    /**
     * check two arrays as equals. It also check the equivalence of null. It
     * will return true even if they are all null.
     *
     * @param s1 the first array to be compared.
     * @param s2 the second array to be compared
     * @return true if they are equal or all null
     */
    public static boolean checkEquals(Object[] s1, Object[] s2) {
        if (s1 == null ^ s2 == null) {
            return false;
       } else {
            return Arrays.equals(s1, s2);
        }
    }

    public static boolean checkEquals(int[] s1, int[] s2) {
        if (s1 == null ^ s2 == null) {
            return false;
        } else {
            return Arrays.equals(s1, s2);
        }
    }

    public static <T> T[] concat(T[] first, T[] second) {
        T[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] concatAll(T[] first, T[]... rest) {
        int totalLength = first.length;
        for (T[] array : rest) {
            totalLength += array.length;
        }
        T[] result = Arrays.copyOf(first, totalLength);
        int offset = first.length;
        for (T[] array : rest) {
            System.arraycopy(array, 0, result, offset, array.length);
            offset += array.length;
        }
        return result;
    }

    public static <T> Set<T> newHashSet() {
        return new HashSet<>();
    }

    @SuppressWarnings("unchecked")
    public static <T> Set<T> newHashSet(T... items) {
        return new HashSet<>(Arrays.asList(items));
    }

    public static <K, V> Map<K, V> newHashMap() {
        return new HashMap<>();
    }

    public static <K, V> Map<K, V> newHashMap(Map<K, V> map) {
        return new HashMap<>(map);
    }

    public static <K, V> Map<K, V> newHashMap(K k, V v) {
        HashMap<K, V> newMap = new HashMap<>();
        newMap.put(k, v);
        return newMap;
    }

    public static <K, V> Map<K, V> newLinkedHashMap() {
        return new LinkedHashMap<>();
    }

    public static <K, V> Map<K, V> newLinkedHashMap(K k, V v) {
        HashMap<K, V> newMap = new LinkedHashMap<>();
        newMap.put(k, v);
        return newMap;
    }

    public static <K> Set<K> newLinkedHashSet() {
        return new LinkedHashSet<>();
    }

    public static <K, V> Map<K, V> newConcurrentHashMap() {
        return new ConcurrentHashMap<>();
    }

    public static <T> List<T> newList() {
        return new ArrayList<>();
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> newList(T... items) {
        List<T> list = new ArrayList<>();
        list.addAll(Arrays.asList(items));

        return list;
    }

    public static <T> List<T> newList(Collection<T> items) {
        List<T> list = new ArrayList<>();
        items.forEach((t) -> {
            list.add(t);
        });

        return list;
    }

    /**
     * It check if T is null or not.
     *
     * @param reference the object reference to be checked
     * @param <T> The object type
     * @return The reference
     */
    public static <T> T checkNotNull(T reference) {
        if (reference == null) {
            throw new NullPointerException();
        }
        return reference;
    }

    @SuppressWarnings("unchecked")
    public static <KEY1, VALUE> void putToNestedList(Map<KEY1, List<VALUE>> map, KEY1 k1, VALUE value) {
        if (map.containsKey(k1)) {
            map.get(k1).add(value);
        } else {
            map.put(k1, TUtil.newList(value));
        }
    }

    public static <KEY1, VALUE> void putCollectionToNestedList(Map<KEY1, List<VALUE>> map, KEY1 k1,
            Collection<VALUE> list) {
        if (map.containsKey(k1)) {
            map.get(k1).addAll(list);
        } else {
            map.put(k1, TUtil.newList(list));
        }
    }

    public static <KEY1, KEY2, VALUE> void putToNestedMap(Map<KEY1, Map<KEY2, VALUE>> map, KEY1 k1, KEY2 k2,
            VALUE value) {
        if (map.containsKey(k1)) {
            map.get(k1).put(k2, value);
        } else {
            map.put(k1, TUtil.newLinkedHashMap(k2, value));
        }
    }

    /**
     * It checks if an item is included in Map<KEY1, Map<KEY2, VALUE>>.
     *
     * @return True if the item is included in the nested map.
     */
    public static <KEY1, KEY2, VALUE> boolean containsInNestedMap(Map<KEY1, Map<KEY2, VALUE>> map, KEY1 k1, KEY2 k2) {
        return map.containsKey(k1) && map.get(k1).containsKey(k2);
    }

    /**
     * Get an item in Map<KEY1, Map<KEY2, VALUE>>.
     *
     * @return a VALUE
     */
    public static <KEY1, KEY2, VALUE> VALUE getFromNestedMap(Map<KEY1, Map<KEY2, VALUE>> map, KEY1 k1, KEY2 k2) {
        if (map.containsKey(k1)) {
            return map.get(k1).get(k2);
        } else {
            return null;
        }
    }

    @SuppressWarnings("rawtypes")
    public static String collectionToString(Collection objects, String delimiter) {
        boolean first = true;
        StringBuilder sb = new StringBuilder();
        for (Object object : objects) {
            if (first) {
                first = false;
            } else {
                sb.append(delimiter);
            }

            sb.append(object.toString());
        }

        return sb.toString();
    }

    public static String arrayToString(Object[] objects) {
        boolean first = true;
        StringBuilder sb = new StringBuilder();
        for (Object object : objects) {
            if (first) {
                first = false;
            } else {
                sb.append(", ");
            }

            sb.append(object.toString());
        }

        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] toArray(Collection<T> collection, Class<T> type) {
        T array = (T) Array.newInstance(type, collection.size());
        return collection.toArray((T[]) array);
    }

    public static int[] toArray(Collection<Integer> collection) {
        int[] array = new int[collection.size()];

        int index = 0;
        for (Integer eachInt : collection) {
            array[index++] = eachInt;
        }

        return array;
    }

    /**
     * It returns the exact code point at which this running thread is executed.
     *
     * @param depth in the call stack (0 means current method, 1 means call
     * method, ...)
     * @return A string including class name, method, and line.
     */
    public static String getCurrentCodePoint(final int depth) {
        final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        StackTraceElement element = ste[2 + depth];
        return element.getClassName() + ":" + element.getMethodName() + "(" + element.getLineNumber() + ")";
    }
        
    public static boolean isNotNullOrEmpty(String str) {
        return !(str == null || str.isEmpty());
    }
    
    public static boolean isNullOrEmpty(String str) {
        return (str == null || str.isEmpty());
    }

    @SuppressWarnings("rawtypes")
    public static boolean isNullOrEmpty(Collection coll) {
        return (coll == null || coll.isEmpty());
    }

    @SuppressWarnings("rawtypes")
    public static boolean isNullOrEmpty(Map map) {
        return (map == null || map.isEmpty());
    }
    
    public static boolean isNullOrEmpty(Object[] array) {
        return (array == null || array.length == 0);
    }

    public static String doubleQuote(String str) {
        return "\"" + str + "\"";
    }

    public static String unescapeJavaString(String st) {

        StringBuilder sb = new StringBuilder(st.length());

        for (int i = 0; i < st.length(); i++) {
            char ch = st.charAt(i);
            if (ch == '\\') {
                char nextChar = (i == st.length() - 1) ? '\\' : st
                        .charAt(i + 1);
                // Octal escape?
                if (nextChar >= '0' && nextChar <= '7') {
                    String code = "" + nextChar;
                    i++;
                    if ((i < st.length() - 1) && st.charAt(i + 1) >= '0'
                            && st.charAt(i + 1) <= '7') {
                        code += st.charAt(i + 1);
                        i++;
                        if ((i < st.length() - 1) && st.charAt(i + 1) >= '0'
                                && st.charAt(i + 1) <= '7') {
                            code += st.charAt(i + 1);
                            i++;
                        }
                    }
                    sb.append((char) Integer.parseInt(code, 8));
                    continue;
                }
                switch (nextChar) {
                    case '\\' -> ch = '\\';
                    case 'b' -> ch = '\b';
                    case 'f' -> ch = '\f';
                    case 'n' -> ch = '\n';
                    case 'r' -> ch = '\r';
                    case 't' -> ch = '\t';
                    case '\"' -> ch = '\"';
                    case '\'' -> ch = '\'';
                    case 'u' -> {
                        if (i >= st.length() - 5) {
                            ch = 'u';
                            break;
                        }
                        int code = Integer.parseInt(
                                "" + st.charAt(i + 2) + st.charAt(i + 3)
                                        + st.charAt(i + 4) + st.charAt(i + 5), 16);
                        sb.append(Character.toChars(code));
                        i += 5;
                        continue;
                    }
                }
                // Hex Unicode: u????
                i++;
            }
            sb.append(ch);
        }
        return sb.toString();
    }

    private static final Set<String> RESERVED_WORDS = Sets.newHashSet(
            "ADD",
            "ALIAS",
            "ALL",
            "ALTER",
            "AND",
            "ANY",
            "AS",
            "ASC",
            "ASSIGN",
            "ASYMMETRIC",
            "AT_SIGN",
            "AVRO",
            "BAD",
            "BETWEEN",
            "BIGINT",
            "BINARY",
            "BIT",
            "BLOB",
            "BOOL",
            "BOOLEAN",
            "BOTH",
            "BY",
            "BYTEA",
            "CASCADE",
            "CASE",
            "CAST",
            "CAST_EXPRESSION",
            "CATALOG",
            "CENTURY",
            "CHAR",
            "CHARACTER",
            "CKM",
            "CLOB",
            "COALESCE",
            "COLLECT",
            "COLON",
            "COLUMN",
            "CONTEXT",
            "COUNT",
            "CREATE",
            "CROSS",
            "CUBE",
            "CUME_DIST",
            "CURRENT",
            "CURRENT_DATE",
            "CURRENT_TIME",
            "CURRENT_TIMESTAMP",
            "DATABASE",
            "DATASET",
            "DATASTORE",
            "DATE",
            "DAY",
            "DEC",
            "DECADE",
            "DECIMAL",
            "DECIMAL_SEP",
            "DEFAULT",
            "DEFINED",
            "DELIMITED",
            "DENSE_RANK",
            "DESC",
            "DESCRIPTION",
            "DISTINCT",
            "DIVIDE",
            "DOT",
            "DOUBLE",
            "DOUBLE_QUOTE",
            "DOW",
            "DOY",
            "DROP",
            "EBCDIC_SIGNED_ZONED_DECIMAL",
            "ELSE",
            "END",
            "EPOCH",
            "EQUAL",
            "ESCAPED",
            "EVERY",
            "EXCEPT",
            "EXCLUDE",
            "EXISTS",
            "EXPLAIN",
            "EXTERNAL",
            "EXTRACT",
            "FALSE",
            "FEBCDIC",
            "FIELDS",
            "FIELD_SEP",
            "FILE",
            "FILTER",
            "FIRST",
            "FIRST_VALUE",
            "FIXED",
            "FLOAT",
            "FLOAT4",
            "FLOAT8",
            "FOLDER",
            "FOLLOWING",
            "FOR",
            "FORMAT",
            "FROM",
            "FULL",
            "FUSION",
            "GEQ",
            "GROUP",
            "GROUPING",
            "GTH",
            "HASH",
            "HASH_SIGN",
            "HAVING",
            "HEADING",
            "HOUR",
            "Hint_End",
            "Hint_Start",
            "IF",
            "IKM",
            "ILIKE",
            "IN",
            "INDEX",
            "INET4",
            "INNER",
            "INPUTFORMAT",
            "INSERT",
            "INT",
            "INT1",
            "INT2",
            "INT4",
            "INT8",
            "INTEGER",
            "INTERSECT",
            "INTERSECTION",
            "INTERVAL",
            "INTO",
            "IS",
            "ISODOW",
            "ISOYEAR",
            "JOIN",
            "LAG",
            "LAST",
            "LAST_VALUE",
            "LEAD",
            "LEADING",
            "LEFT",
            "LEFT_PAREN",
            "LEQ",
            "LESS",
            "LIKE",
            "LIMIT",
            "LIST",
            "LKM",
            "LOCATION",
            "LOGICAL_SCHEMA",
            "LTH",
            "LineComment",
            "MAPPING",
            "MAX",
            "MAXVALUE",
            "MICROSECONDS",
            "MILLENNIUM",
            "MILLISECONDS",
            "MIN",
            "MINUS",
            "MINUS_SET",
            "MINUTE",
            "MODEL",
            "MODIFY",
            "MODULAR",
            "MONTH",
            "MULTIPLY",
            "NAME",
            "NATIONAL",
            "NATURAL",
            "NCHAR",
            "NO",
            "NOT",
            "NOT_EQUAL",
            "NULL",
            "NULLIF",
            "NULLS",
            "NUMBER",
            "NUMERIC",
            "NVARCHAR",
            "ODIREF",
            "OFFSET",
            "ON",
            "OPTIMIZATION_CONTEXT",
            "OR",
            "ORANUMBER",
            "ORC",
            "ORDER",
            "OTHERS",
            "OUTER",
            "OUTPUTFORMAT",
            "OVER",
            "OVERWRITE",
            "PACKAGE",
            "PARQUET",
            "PARTITION",
            "PARTITIONS",
            "PERCENT_RANK",
            "PHYSICAL_DESIGN",
            "PHYS_LENGTH",
            "PLUS",
            "POSITION",
            "PRECEDING",
            "PRECISION",
            "PROCEDURE",
            "PROJECT",
            "PURGE",
            "QUARTER",
            "QUOTE",
            "RANGE",
            "RANK",
            "RCFILE",
            "REAL",
            "REAL_NUMBER",
            "RECORD_SEP",
            "REGEXP",
            "REMOVE_TEMPORARY_OBJECTS_ON_ERROR",
            "RENAME",
            "REPLACE",
            "RESET",
            "RESOURCE",
            "REUSABLE",
            "RIGHT",
            "RIGHT_PAREN",
            "RLIKE",
            "ROLLUP",
            "ROW",
            "ROWS",
            "ROW_FORMAT",
            "ROW_NUMBER",
            "SCD",
            "SCENARIO",
            "SECOND",
            "SELECT",
            "SEMI_COLON",
            "SEQUENCEFILE",
            "SERDE",
            "SERDEPROPERTIES",
            "SESSION",
            "SET",
            "SIGNED_PACKED_DECIMAL",
            "SIMILAR",
            "SMALLINT",
            "SOME",
            "STDDEV_POP",
            "STDDEV_SAMP",
            "STORED_AS",
            "STRING",
            "SUBMODEL",
            "SUBPARTITION",
            "SUM",
            "SYMMETRIC",
            "TABLE",
            "TABLESPACE",
            "TBLPROPERTIES",
            "TECHNOLOGY",
            "TEMPORARY",
            "TERMINATED",
            "TEXT",
            "TEXTFILE",
            "TEXT_DELIM",
            "THAN",
            "THEN",
            "TIES",
            "TIME",
            "TIMESTAMP",
            "TIMESTAMPTZ",
            "TIMETZ",
            "TIMEZONE",
            "TIMEZONE_HOUR",
            "TIMEZONE_MINUTE",
            "TINYINT",
            "TO",
            "TRAILING",
            "TRIM",
            "TRUE",
            "TRUNCATE",
            "UNBOUNDED",
            "UNION",
            "UNIQUE",
            "UNIQUE_TEMPORARY_OBJECT_NAMES",
            "USING",
            "VALUES",
            "VARBINARY",
            "VARBIT",
            "VARCHAR",
            "VARCHAR2",
            "VARIABLE",
            "WEEK",
            "WHEN",
            "WHERE",
            "WINDOW",
            "WITH",
            "XKM",
            "YEAR",
            "ZONE",
            "INTEGRATION",
            "TYPE",
            "UPDATE",
            "KEY",
            "REJECT",
            "PERCENT",
            "PRIMARY",
            "ALTERNATE",
            "OLAP",
            "CONSTRAINT",
            "CURSOR",
            "SUCCESS",
            "ERROR",
            "GOTO",
            "DECLARE",
            "REFRESH",
            "RETRY",
            "WAIT",
            "BEGIN",
            "EXIT"
    );

    private static String encloseWithinDoubleQuotes(String text) {
        return '"' + text + '"';
    }

    public static String encloseIfReservedWord(String in) {
        if (RESERVED_WORDS.contains(in.toUpperCase())) {
            return encloseWithinDoubleQuotes(in);
        } else {
            return in;
        }
    }

    public static String encloseIfRequired(String in) {
        if (isOdiSubstitutionCode(in)) {
            // do not enclose ODI code
            return in;
        }        
        if (RESERVED_WORDS.contains(in.toUpperCase())) {
            return encloseWithinDoubleQuotes(in);
        } else if (!in.equals(in.toUpperCase())) {
            return encloseWithinDoubleQuotes(in);
        } else if (in.contains(" ")) {
            return encloseWithinDoubleQuotes(in);
        } else {
            return in;
        }
    }
    
    public static String encloseNonReservedWordsIfRequired(String in) {
        if (isOdiSubstitutionCode(in)) {
            // do not enclose ODI code
            return in;
        }
        if (RESERVED_WORDS.contains(in.toUpperCase())) {
            return in;
        }
        
        if (!in.equals(in.toUpperCase())) {
            return encloseWithinDoubleQuotes(in);
        } else if (in.contains(" ")) {
            return encloseWithinDoubleQuotes(in);
        } else {
            return in;
        }
    }    

    public static String encloseEachToken(String str, String separator) {
        String vRet = "";
        int i = 0;

        if (separator != null && !str.contains(separator)) {
            return "\"" + str + "\"";
        }
        for (String line : StringUtils.split(str, separator)) {
            vRet = vRet.concat((i > 0) ? separator : "").concat("\"").concat(line).concat("\"");
            i = 1;
        }

        return vRet;
    }

    public static String encloseEachTokenIfRequired(String str, String separator) {
        String vRet = "";
        int i = 0;

        if (separator != null && !str.contains(separator)) {
            return encloseIfRequired(str);
        }
        for (String line : StringUtils.split(str, separator)) {
            vRet = vRet.concat((i > 0) ? separator : "").concat(encloseIfRequired(line));
            i = 1;
        }

        return vRet;
    }

    public static String formatQualifiedName(String str) {
        return encloseEachTokenIfRequired(str, CatalogConstants.IDENTIFIER_DELIMITER);
    }

    public static String longestCommonPrefix(String[] strings) {
        if (strings.length == 0) {
            return "";
        }

        for (int prefixLen = 0; prefixLen < strings[0].length(); prefixLen++) {
            char c = strings[0].charAt(prefixLen);
            for (int i = 1; i < strings.length; i++) {
                if (prefixLen >= strings[i].length() || strings[i].charAt(prefixLen) != c) {
                    // Mismatch found
                    return strings[i].substring(0, prefixLen);
                }
            }
        }
        return strings[0];
    }
    
    public static String getBasename(String name) {
        if (name.contains(CatalogConstants.IDENTIFIER_DELIMITER)) {
            return org.apache.commons.lang3.StringUtils.substringAfterLast(name, CatalogConstants.IDENTIFIER_DELIMITER);
        } else {
            return name;
        }
    }  
    
    public String toJson(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } catch (JsonProcessingException ex) {
            return "Error";
        }
    } 
    
    public static Map<String, Object> getCommonParameters() {
        int numberOfWorkers = Preferences.userRoot().node("OdiOptions").getInt("maxParallelThreadsCount", 1);
        Map<String, Object> parameters = TUtil.newHashMap();

        parameters.put("PARALLEL_WORKERS", numberOfWorkers);
        parameters.put("SERIAL_EXECUTION", false); 

        return parameters;        
    }
    
    public static boolean isOdiSubstitutionCode(String text) {
        boolean hasOdiStartTag = text.startsWith("<%")
                || text.startsWith("<?")
                || text.startsWith("<$")
                || text.startsWith("<@");
        
        boolean hasOdiEndTag = text.endsWith("%>")
                || text.endsWith("?>")
                || text.endsWith("$>")
                || text.endsWith("@>");
        
        return hasOdiStartTag && hasOdiEndTag;
        
    }

    public static String stripQuote(String str) {
        return str.substring(1, str.length() - 1);
    }

    public static boolean checkIfExist(Object obj) {
        return obj != null;
    }

    public static Map<String, String> escapeTableMeta(Map<String, String> map) {
        Map<String, String> params = new HashMap<>();
        map.forEach((key, value) -> {
            switch (key) {
                case CatalogConstants.CSVFILE_DELIMITER, CatalogConstants.TEXT_DELIMITER -> //backward compatibility
                    params.put(CatalogConstants.TEXT_DELIMITER, StringUtil.unicodeEscapedDelimiter(value));
                case CatalogConstants.CSVFILE_NULL, CatalogConstants.TEXT_NULL -> //backward compatibility
                    params.put(CatalogConstants.TEXT_NULL, value);
                default -> params.put(key, value);
            }
        });
        return params;
    }
}
