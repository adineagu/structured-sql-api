/*
 * Copyright 2016 Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.pecheasoft.odigen.sql.parse.algebra;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class MultiInsertTarget extends Expr implements Integrateable {

    private String tableName;
    private String tableAlias;
    private List<TargetColumn> targetColumns;
    private Expr[] expressions;
    private Expr condition;
    private boolean defaultcond;
    private String integrationType;
    private String updateKey;
    private Integer rejectLimit;
    private String rejectLimitUnit;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public boolean hasTableAlias() {
        return this.tableAlias != null;
    }

    public String getTableAlias() {
        return tableAlias;
    }

    public void setTableAlias(String tableAlias) {
        this.tableAlias = tableAlias;
    }

    public List<TargetColumn> getTargetColumns() {
        return targetColumns;
    }

    public void setTargetColumns(List<TargetColumn> targetColumns) {
        this.targetColumns = targetColumns;
    }

    public Expr[] getExpressions() {
        return expressions;
    }

    public void setExpressions(Expr[] expressions) {
        this.expressions = expressions;
    }

    public Expr getCondition() {
        return condition;
    }

    public void setCondition(Expr condition) {
        this.condition = condition;
    }

    public boolean isDefaultcond() {
        return defaultcond;
    }

    public void setDefaultcond(boolean defaultcond) {
        this.defaultcond = defaultcond;
    }

    public String getIntegrationType() {
        return integrationType;
    }

    @Override
    public void setIntegrationType(String integrationType) {
        this.integrationType = integrationType;
    }

    public String getUpdateKey() {
        return updateKey;
    }

    @Override
    public void setUpdateKey(String updateKey) {
        this.updateKey = updateKey;
    }

    public Integer getRejectLimit() {
        return rejectLimit;
    }

    @Override
    public void setRejectLimit(Integer rejectLimit) {
        this.rejectLimit = rejectLimit;
    }

    public String getRejectLimitUnit() {
        return rejectLimitUnit;
    }

    @Override
    public void setRejectLimitUnit(String rejectLimitUnit) {
        this.rejectLimitUnit = rejectLimitUnit;
    }

}
