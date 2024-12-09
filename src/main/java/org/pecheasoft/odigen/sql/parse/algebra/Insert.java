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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Insert extends Expr implements Integrateable {

    private boolean overwrite = false;
    private String tableName;
    private String tableAlias;  
    private List<TargetColumn> targetColumns;
    private String storageType;
    private String location;
    private Expr subquery;
    private Map<String, String> params;
    private String integrationType;
    private String updateKey;
    private Integer rejectLimit;  
    private String rejectLimitUnit;
    private boolean reusableMappingSignature;

    public void setOverwrite() {
        overwrite = true;
    }

    public boolean isOverwrite() {
        return overwrite;
    }

    public boolean hasTableName() {
        return this.tableName != null;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return this.tableName;
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
        
    public boolean hasTargetColumns() {
        return targetColumns != null;
    }

    public List<TargetColumn> getTargetColumns() {
        return targetColumns;
    }

    public void setTargetColumns(List<TargetColumn> targets) {
        this.targetColumns = targets;
    }

    public boolean hasLocation() {
        return location != null;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean hasStorageType() {
        return storageType != null;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    public String getStorageType() {
        return storageType;
    }

    public boolean hasParams() {
        return params != null;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public void setSubQuery(Expr subquery) {
        this.subquery = subquery;
    }

    public Expr getSubQuery() {
        return subquery;
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

    public boolean isReusableMappingSignature() {
        return reusableMappingSignature;
    }

    public void setReusableMappingSignature(boolean reusableMappingSignature) {
        this.reusableMappingSignature = reusableMappingSignature;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object clone() throws CloneNotSupportedException {
        Insert insert = (Insert) super.clone();
        insert.overwrite = overwrite;
        insert.tableName = tableName;
        insert.targetColumns = (List<TargetColumn>) (targetColumns != null ? ((ArrayList<TargetColumn>)targetColumns).clone() : null);
        insert.storageType = storageType;
        insert.location = location;
        insert.subquery = (Expr) subquery.clone();
        if (params != null) {
            insert.params = new HashMap<>(params);
        }
        insert.integrationType = integrationType;
        insert.updateKey = updateKey;
        insert.rejectLimit = rejectLimit;
        insert.rejectLimitUnit = rejectLimitUnit;
        
        return insert;
    }
    
}
