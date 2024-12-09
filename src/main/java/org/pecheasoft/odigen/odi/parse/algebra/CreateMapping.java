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

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.pecheasoft.odigen.sql.parse.algebra.Expr;
import org.pecheasoft.odigen.sql.util.TUtil;

public class CreateMapping extends OdiExpr {

    private String mappingName;
    private List<Expr> statements = TUtil.newList();
    private Map<String, String> params;
    private boolean isReplace;
    private boolean ifNotExists;
    private boolean isReusable;
    private String stagingLocation;    
    PhysicalDesignList physicalDesignList;
    String description;    

    public CreateMapping(final String mappingName, boolean isReplace, boolean ifNotExists) {
        this.mappingName = mappingName;
        this.isReplace = isReplace;
        this.ifNotExists = ifNotExists;
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

    public boolean hasStatements() {
        return !statements.isEmpty();
    }

    public void setStatements(List<Expr> statements) {
        this.statements = statements;
    }

    public List<Expr>  getStatements() {
        return statements;
    }

    public void addStatement(Expr statement) {
        statements.add(statement);
    }

    public boolean isIfNotExists() {
        return ifNotExists;
    }

    public boolean isReplace() {
        return isReplace;
    }

    public void setReplace(boolean isReplace) {
        this.isReplace = isReplace;
    }
    
    /**
     * @return the isReusable
     */
    public boolean isReusable() {
        return isReusable;
    }

    /**
     * @param isReusable the isReusable to set
     */
    public void setReusable(boolean isReusable) {
        this.isReusable = isReusable;
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

    public String getStagingLocation() {
        return stagingLocation;
    }

    public void setStagingLocation(String stagingLocation) {
        this.stagingLocation = stagingLocation;
    }        

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }        


    @Override
    public Object clone() throws CloneNotSupportedException {
        CreateMapping createTable = (CreateMapping) super.clone();
        createTable.mappingName = mappingName;
        List<Expr> statementsCopy = TUtil.newList();
        Collections.copy(statementsCopy, statements);
        createTable.statements = statementsCopy;
        createTable.params = new HashMap<>(params);
        createTable.ifNotExists = ifNotExists;
        return createTable;
    }

}
