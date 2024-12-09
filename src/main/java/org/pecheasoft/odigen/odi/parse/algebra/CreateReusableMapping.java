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
package org.pecheasoft.odigen.odi.parse.algebra;

import java.util.HashMap;
import java.util.Map;

import org.pecheasoft.odigen.sql.parse.algebra.Expr;

public class CreateReusableMapping extends OdiExpr {

    private String mappingName;
    private Expr subquery;
    private Map<String, String> params;
    private boolean ifNotExists;    
    private boolean isReplace;
    PhysicalDesignList physicalDesignList;
    String description;    
    

    public CreateReusableMapping(final String mappingName, boolean isReplace, boolean ifNotExists) {
        this.mappingName = mappingName;
        this.isReplace = isReplace;
        this.ifNotExists = ifNotExists;
    }

    public CreateReusableMapping(final String mappingName, final Expr subQuery, boolean isReplace, boolean ifNotExists) {
        this(mappingName, isReplace, ifNotExists);
        this.subquery = subQuery;
    }

    public String getMappingName() {
        return this.mappingName;
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

    public boolean hasSubQuery() {
        return subquery != null;
    }

    public void setSubQuery(Expr subquery) {
        this.subquery = subquery;
    }

    public Expr getSubQuery() {
        return subquery;
    }

    public boolean isIfNotExists() {
        return ifNotExists;
    }

    public boolean isIsReplace() {
        return isReplace;
    }       

    public boolean hasPhysicalDesigns() {
        return physicalDesignList != null;
    }
    
    public PhysicalDesignList getPhysicalDesignList() {
        return physicalDesignList;
    }

    public void setPhysicalDesignList(PhysicalDesignList physicalDesignList) {
        this.physicalDesignList = physicalDesignList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        CreateReusableMapping createTable = (CreateReusableMapping) super.clone();
        createTable.mappingName = mappingName;
        createTable.subquery = subquery;
        createTable.params = new HashMap<>(params);
        createTable.isReplace = isReplace;
        createTable.ifNotExists = ifNotExists;
        return createTable;
    }

}
