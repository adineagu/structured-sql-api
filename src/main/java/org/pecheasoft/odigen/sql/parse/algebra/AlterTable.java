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
    };

    public record Model(String tableName, String newTableName, String columnName, String newColumnName, 
        ColumnDefinition addNewColumn, ITableConstraint tableKey, String comment, AlterTableOpType alterTableOpType) {
    }

    private final Model model;

    public AlterTable(final Model model) {
        this.model = model;
    };

    public Model getModel() {
        return model;
    }
    
}
