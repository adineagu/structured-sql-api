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
package org.pecheasoft.odigen.sql.parse.algebra;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class AlterTable extends Expr {

    public enum AlterTableOpType {
        RENAME_TABLE, RENAME_COLUMN, ADD_COLUMN, MODIFY_COLUMN, ADD_PRIMARY_KEY, ADD_ALTERNATE_KEY, ADD_INDEX, COMMENT
    }

    private String tableName;
    private String newTableName;
    private String columnName;
    private String newColumnName;
    private ColumnDefinition addNewColumn;
    private ITableConstraint tableKey;
    private String comment;
    private AlterTableOpType alterTableOpType;

    public AlterTable(final String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getNewTableName() {
        return newTableName;
    }

    public void setNewTableName(String newTableName) {
        this.newTableName = newTableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getNewColumnName() {
        return newColumnName;
    }

    public void setNewColumnName(String newColumnName) {
        this.newColumnName = newColumnName;
    }

    public ColumnDefinition getAddNewColumn() {
        return addNewColumn;
    }

    public void setAddNewColumn(ColumnDefinition addNewColumn) {
        this.addNewColumn = addNewColumn;
    }

    public AlterTableOpType getAlterTableOpType() {
        return alterTableOpType;
    }

    public void setAlterTableOpType(AlterTableOpType alterTableOpType) {
        this.alterTableOpType = alterTableOpType;
    }

    public ITableConstraint getTableKey() {
        return tableKey;
    }

    public void setTableKey(ITableConstraint tableKey) {
        this.tableKey = tableKey;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        AlterTable alter = (AlterTable) super.clone();
        alter.tableName = tableName;
        alter.newTableName = newTableName;
        alter.columnName = columnName;
        alter.newColumnName = newColumnName;
        alter.addNewColumn = (ColumnDefinition) addNewColumn.clone();
        alter.alterTableOpType = alterTableOpType;
        return alter;
    }
}
