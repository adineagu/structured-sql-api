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
import java.util.List;
import java.util.Map;

import org.pecheasoft.odigen.sql.parse.algebra.Expr;
import org.pecheasoft.odigen.sql.util.TUtil;
import org.pecheasoft.odigen.sql.util.graph.SimpleDirectedGraph;

public class CreatePackage extends OdiExpr {

    private String packageName;
    private Map<String, String> params;
    private boolean isReplace;
    private boolean ifNotExists;
    private final List<Expr> stepsList = TUtil.newList();
    private final SimpleDirectedGraph<AbstractPackageStep, PackageStepLink> stepsGraph = new SimpleDirectedGraph<>();

    public CreatePackage(final String packageName, boolean isReplace, boolean ifNotExists) {
        this.packageName = packageName;
        this.isReplace = isReplace;
        this.ifNotExists = ifNotExists;
    }

    public String getPackageName() {
        return this.packageName;
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

    public boolean isIfNotExists() {
        return ifNotExists;
    }

    public boolean isReplace() {
        return isReplace;
    }

    public void setReplace(boolean isReplace) {
        this.isReplace = isReplace;
    }

    public List<Expr> getStepsList() {
        return stepsList;
    }    

    public SimpleDirectedGraph<AbstractPackageStep, PackageStepLink> getStepsGraph() {
        return stepsGraph;
    }
        

    @Override
    public Object clone() throws CloneNotSupportedException {
        CreatePackage createTable = (CreatePackage) super.clone();
        createTable.packageName = packageName;
        createTable.params = new HashMap<>(params);
        createTable.ifNotExists = ifNotExists;
        return createTable;
    }

}
