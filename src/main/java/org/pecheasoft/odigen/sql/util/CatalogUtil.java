/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. The ASF
 * licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.pecheasoft.odigen.sql.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;


public class CatalogUtil {

    public static final String TEXTFILE_NAME = "TEXT";

    /**
     * Normalize an identifier. Normalization means a translation from a
     * identifier to be a refined identifier name.
     *
     * Identifier can be composed of multiple parts as follows:
     * <pre>
     *   database_name.table_name.column_name
     * </pre>
     *
     * Each regular identifier part can be composed alphabet ([a-z][A-Z]),
     * number([0-9]), and underscore([_]). Also, the first letter must be an
     * alphabet character.
     *
     * <code>normalizeIdentifier</code> normalizes each part of an identifier.
     *
     * In detail, for each part, it performs as follows:
     * <ul>
     * <li>changing a part without double quotation to be lower case
     * letters</li>
     * <li>eliminating double quotation marks from identifier</li>
     * </ul>
     *
     * @param identifier The identifier to be normalized
     * @return The normalized identifier
     */
    public static String normalizeIdentifier(String identifier) {
        if (identifier == null || identifier.equals("")) {
            return identifier;
        }
        String[] splitted = identifier.split(CatalogConstants.IDENTIFIER_DELIMITER_REGEXP);

        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (String part : splitted) {
            if (first) {
                first = false;
            } else {
                sb.append(CatalogConstants.IDENTIFIER_DELIMITER);
            }
            sb.append(normalizeIdentifierPart(part));
        }
        return sb.toString();
    }

    public static String normalizeIdentifierPart(String part) {
        return isDelimited(part) ? stripQuote(part) : part.toLowerCase();
    }

    /**
     * Denormalize an identifier. Denormalize means a translation from a stored
     * identifier to be a printable identifier name.
     *
     * In detail, for each part, it performs as follows:
     * <ul>
     * <li>changing a part including upper case character or non-ascii character
     * to be lower case letters</li>
     * <li>eliminating double quotation marks from identifier</li>
     * </ul>
     *
     * @param identifier The identifier to be normalized
     * @return The denormalized identifier
     */
    public static String denormalizeIdentifier(String identifier) {
        String[] splitted = identifier.split(CatalogConstants.IDENTIFIER_DELIMITER_REGEXP);

        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (String part : splitted) {
            if (first) {
                first = false;
            } else {
                sb.append(CatalogConstants.IDENTIFIER_DELIMITER);
            }
            sb.append(denormalizePart(part));
        }
        return sb.toString();
    }

    public static String denormalizePart(String identifier) {
        if (isShouldBeQuoted(identifier)) {
            return StringUtil.doubleQuote(identifier);
        } else {
            return identifier;
        }
    }

    public static boolean isShouldBeQuoted(String columnName) {
        for (char character : columnName.toCharArray()) {
            if (Character.isUpperCase(character)) {
                return true;
            }

            if (!StringUtil.isPartOfAnsiSQLIdentifier(character)) {
                return true;
            }

            if (RESERVED_KEYWORDS_SET.contains(columnName.toUpperCase())) {
                return true;
            }
        }

        return false;
    }

    public static String stripQuote(String str) {
        return str.substring(1, str.length() - 1);
    }

    public static boolean isDelimited(String identifier) {
        boolean openQuote = identifier.charAt(0) == '"';
        boolean closeQuote = identifier.charAt(identifier.length() - 1) == '"';

        // if at least one quote mark exists, the identifier must be grater than equal to 2 characters,
        if (openQuote ^ closeQuote && identifier.length() < 2) {
            throw new IllegalArgumentException("Invalid Identifier: " + identifier);
        }

        // does not allow the empty identifier (''),
        if (openQuote && closeQuote && identifier.length() == 2) {
            throw new IllegalArgumentException("zero-length delimited identifier: " + identifier);
        }

        // Ensure the quote open and close
        return openQuote && closeQuote;
    }

    public static boolean isFQColumnName(String tableName) {
        return tableName.split(CatalogConstants.IDENTIFIER_DELIMITER_REGEXP).length == 3;
    }

    public static boolean isFQRelationName(String relationName) {
        /*
        check if relationName can be the FQ name of a datastore or a reusable mapping
        */        
        return isFQTableName(relationName) || isFQReusableMappingName(relationName) || relationName.toUpperCase().equals(CatalogConstants.DUAL_TABLE_NAME);
    }
    
    public static boolean isFQTableName(String tableName) {
        /*
         tableName can be fully qualified datastore name only if contains at least one occurences of DOT character
         */
        int lastDelimiterIdx = tableName.lastIndexOf(CatalogConstants.IDENTIFIER_DELIMITER);
        return lastDelimiterIdx > -1;
    }

    public static boolean isFQMappingName(String mappingName) {
        /*
         mappingName can be fully qualified mapping name only if contains at least two occurences of DOT character
         */
        int delimiterCnt = mappingName.split(CatalogConstants.IDENTIFIER_DELIMITER_REGEXP, -1).length - 1;
        return delimiterCnt > 1;
    }

    public static boolean isFQReusableMappingName(String mappingName) {
        /*
         mappingName can be fully qualified reusable mapping name only if contains at least two occurences of DOT character
         */
        int delimiterCnt = mappingName.split(CatalogConstants.IDENTIFIER_DELIMITER_REGEXP, -1).length - 1;
        return delimiterCnt > 1;
    }

    public static boolean isNonFQRelationName(String relationName) {
        return CatalogConstants.EMPTY_STRING.equals(CatalogUtil.extractQualifier(relationName));
    }
    
    public static String[] splitFQTableName(String qualifiedName) {
        String[] splitted = CatalogUtil.splitTableName(qualifiedName);
        if (splitted.length == 1) {
            throw new IllegalArgumentException("createTable() requires a qualified table name, but it is \""
                    + qualifiedName + "\".");
        }
        return splitted;
    }

    public static String[] splitFQMappingName(String qualifiedName) {
        String[] splitted = CatalogUtil.splitMappingName(qualifiedName);
        if (splitted.length < 3) {
            throw new IllegalArgumentException("createMapping() requires a qualified mapping name, but it is \""
                    + qualifiedName + "\".");
        }
        return splitted;
    }

    public static String[] splitTableName(String tableName) {
        int lastDelimiterIdx = tableName.lastIndexOf(CatalogConstants.IDENTIFIER_DELIMITER);
        if (lastDelimiterIdx > -1) {
            return new String[]{
                tableName.substring(0, lastDelimiterIdx),
                tableName.substring(lastDelimiterIdx + 1, tableName.length())
            };
        } else {
            return new String[]{tableName};
        }
    }

    public static String[] splitMappingName(String mappingName) {
        int lastDelimiterIdx = mappingName.lastIndexOf(CatalogConstants.IDENTIFIER_DELIMITER);
        if (lastDelimiterIdx > -1) {
            String project = null;
            String folder = null;
            String mapping;

            String projectAndFolder = mappingName.substring(0, lastDelimiterIdx);
            mapping = mappingName.substring(lastDelimiterIdx + 1, mappingName.length());

            lastDelimiterIdx = projectAndFolder.lastIndexOf(CatalogConstants.IDENTIFIER_DELIMITER);
            if (lastDelimiterIdx > -1) {
                project = projectAndFolder.substring(0, lastDelimiterIdx);
                folder = projectAndFolder.substring(lastDelimiterIdx + 1, projectAndFolder.length());
            }
            return new String[]{project, folder, mapping};
        } else {
            return new String[]{mappingName};
        }
    }

    public static String buildFQName(String... identifiers) {
        boolean first = true;
        StringBuilder sb = new StringBuilder();
        for (String id : identifiers) {
            if (first) {
                first = false;
            } else {
                sb.append(CatalogConstants.IDENTIFIER_DELIMITER);
            }

            sb.append(id);
        }

        return sb.toString();
    }

    /**
     * Extract a qualification name from an identifier.
     *
     * For example, consider a table identifier like 'database1.table1'. In this
     * case, this method extracts 'database1'.
     *
     * @param name The identifier to be extracted
     * @return The extracted qualifier
     */
    public static String extractQualifier(String name) {
        int lastDelimiterIdx = name.lastIndexOf(CatalogConstants.IDENTIFIER_DELIMITER);
        if (lastDelimiterIdx > -1) {
            return name.substring(0, lastDelimiterIdx);
        } else {
            return CatalogConstants.EMPTY_STRING;
        }
    }

    public static String getBasename(String name) {
        if (name.contains(CatalogConstants.IDENTIFIER_DELIMITER)) {
            return StringUtils.substringAfterLast(name, CatalogConstants.IDENTIFIER_DELIMITER);
        } else {
            return name;
        }
    }
    /**
     * Extract a simple name from an identifier.
     *
     * For example, consider a table identifier like 'database1.table1'. In this
     * case, this method extracts 'table1'.
     *
     * @param name The identifier to be extracted
     * @return The extracted simple name
     */
    public static String extractSimpleName(String name) {
        int lastDelimiterIdx = name.lastIndexOf(CatalogConstants.IDENTIFIER_DELIMITER);
        if (lastDelimiterIdx > -1) {
            // plus one means skipping a delimiter.
            return name.substring(lastDelimiterIdx + 1, name.length());
        } else {
            return name;
        }
    }
    
    public static String extractTopQualifier(String name) {
        int delimiterCount = StringUtils.countMatches(name, CatalogConstants.IDENTIFIER_DELIMITER);
        if (delimiterCount == 0)  {
            return null;
        }
        else {
            return StringUtils.substringBefore(name, CatalogConstants.IDENTIFIER_DELIMITER);
        }
    }
    
    public static String[] extractMidQualifier(String name) {
        int delimiterCount = StringUtils.countMatches(name, CatalogConstants.IDENTIFIER_DELIMITER);
        if (delimiterCount < 2)  {
            return null;
        }
        else {
            String projectCode = StringUtils.substringBefore(name, CatalogConstants.IDENTIFIER_DELIMITER);
            String mappingName = StringUtils.substringAfterLast(name, CatalogConstants.IDENTIFIER_DELIMITER);
            
            String prefix = projectCode + CatalogConstants.IDENTIFIER_DELIMITER;
            String suffix = CatalogConstants.IDENTIFIER_DELIMITER + mappingName;
            String temp = name.startsWith(prefix) ? name.substring(prefix.length()) : name;
            String result = temp.endsWith(suffix) ? temp.substring(0, temp.length() - suffix.length()) : temp;
            return result.split(CatalogConstants.IDENTIFIER_DELIMITER_REGEXP);
        }
    }

    public static String getCanonicalTableName(String databaseName, String tableName) {
        StringBuilder sb = new StringBuilder(databaseName);
        sb.append(CatalogConstants.IDENTIFIER_DELIMITER);
        sb.append(tableName);
        return sb.toString();
    }
    
    public static Triple<String, String, String> getQualifiedNameTokens(String qualifiedName) {
        String leftToken = "";
        String middleToken = "";
        String rightToken = "";
        
        String[] tokens = org.apache.commons.lang3.StringUtils.split(qualifiedName, CatalogConstants.IDENTIFIER_DELIMITER, 3);
        
        if (tokens == null) {
            return new Triple<>(leftToken, middleToken, rightToken);
        }
        
        if (tokens.length == 3) {
            rightToken = tokens[2];            
        }
        if (tokens.length >= 2) {
            middleToken = tokens[1];
        }
        if (tokens.length >= 1) {
            leftToken = tokens[0];
        }        
        return new Triple<>(leftToken, middleToken, rightToken);
    }

    public static void closeQuietly(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException se) {
        }
    }

    public static void closeQuietly(Statement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException se) {
        }
    }

    public static void closeQuietly(ResultSet res) {
        try {
            if (res != null) {
                res.close();
            }
        } catch (SQLException se) {
        }
    }

    public static void closeQuietly(Statement stmt, ResultSet res) {
        try {
            closeQuietly(res);
        } finally {
            closeQuietly(stmt);
        }
    }
    

    public static final Set<String> RESERVED_KEYWORDS_SET = new HashSet<String>();

    static final String[] RESERVED_KEYWORDS = {
        "AS", "ALL", "AND", "ANY", "ASYMMETRIC", "ASC",
        "BOTH",
        "CASE", "CAST", "CREATE", "CROSS", "CURRENT_DATE", "CURRENT_TIME", "CURRENT_TIMESTAMP",
        "DESC", "DISTINCT",
        "END", "ELSE", "EXCEPT",
        "FALSE", "FULL", "FROM",
        "GROUP",
        "HAVING",
        "ILIKE", "IN", "INNER", "INTERSECT", "INTO", "IS",
        "JOIN",
        "LEADING", "LEFT", "LIKE", "LIMIT",
        "NATURAL", "NOT", "NULL",
        "ON", "OUTER", "OR", "ORDER",
        "RIGHT",
        "SELECT", "SOME", "SYMMETRIC",
        "TABLE", "THEN", "TRAILING", "TRUE",
        "OVER",
        "UNION", "UNIQUE", "USING",
        "WHEN", "WHERE", "WINDOW", "WITH"
    };

    static {
        RESERVED_KEYWORDS_SET.addAll(Arrays.asList(RESERVED_KEYWORDS));
    }

    // table default properties
    public static final String BLOCK_SIZE = "parquet.block.size";
    public static final String PAGE_SIZE = "parquet.page.size";
    public static final String COMPRESSION = "parquet.compression";
    public static final String ENABLE_DICTIONARY = "parquet.enable.dictionary";
    public static final String VALIDATION = "parquet.validation";

}
