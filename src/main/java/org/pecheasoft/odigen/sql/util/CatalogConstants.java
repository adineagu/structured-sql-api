/*
 * Copyright 2017 DWH Tools.
 * SPDX-License-Identifier: GPL-3.0-only
 *
 * This file is part of SQLMorph.
 *
 * SQLMorph is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 3 of the License.
 *
 * SQLMorph is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with SQLMorph. If not, see <https://www.gnu.org/licenses/>.
 */
package org.pecheasoft.odigen.sql.util;

public class CatalogConstants {
  public final static String EMPTY_STRING = "";
  public final static String IDENTIFIER_DELIMITER_REGEXP = "\\.";
  public final static String IDENTIFIER_DELIMITER = ".";
  public final static String IDENTIFIER_QUOTE_STRING = "\"";
  public final static String IDENTIFIER_SINGLEQUOTE_STRING = "'";
  public final static String IDENTIFIER_ODIVAR_PREFIX = "#";
  public final static int MAX_IDENTIFIER_LENGTH = 128;
  public final static int MAX_USERNAME_LENGTH = 32;
  public final static int MAX_STATEMENT_LENGTH = 128 * 1024;
  public final static int MAX_CONNECTION_LENGTH = 10 * 1024;

  public static final String STORE_CLASS="tajo.catalog.store.class";

  public static final String CONNECTION_ID = "tajo.catalog.connection.id";
  public static final String CONNECTION_PASSWORD = "tajo.catalog.connection.password";
  public static final String CATALOG_URI="tajo.catalog.uri";

  public static final String DEPRECATED_CONNECTION_ID = "tajo.catalog.jdbc.connection.id";
  public static final String DEPRECATED_CONNECTION_PASSWORD = "tajo.catalog.jdbc.connection.password";
  public static final String DEPRECATED_CATALOG_URI="tajo.catalog.jdbc.uri";

  public static final String TB_META = "META";
  public static final String TB_SPACES = "TABLESPACES";
  public static final String TB_DATABASES = "DATABASES_";
  public static final String TB_TABLES = "TABLES";
  public static final String TB_COLUMNS = "COLUMNS";
  public static final String TB_OPTIONS = "OPTIONS";
  public static final String TB_INDEXES = "INDEXES";
  public static final String TB_STATISTICS = "STATS";
  public static final String TB_PARTITION_METHODS = "PARTITION_METHODS";
  public static final String TB_PARTTIONS = "PARTITIONS";

  public static final String COL_TABLESPACE_PK = "SPACE_ID";
  public static final String COL_DATABASES_PK = "DB_ID";
  public static final String COL_TABLES_PK = "TID";
  public static final String COL_TABLES_NAME = "TABLE_NAME";
  
  public static final String INFORMATION_SCHEMA_DB_NAME = "information_schema";
  
  public static final String DUAL_TABLE_NAME = "dual";
  
  public static final String CSVFILE_DELIMITER = "csvfile.delimiter";
  public static final String CSVFILE_NULL = "csvfile.null";
  public static final String CSVFILE_SERDE = "csvfile.serde";
  public static final String TEXT_DELIMITER = "text.delimiter";
  public static final String TEXT_NULL = "text.null";
}
