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
package org.pecheasoft.odigen.odi.parse.algebra;

import org.pecheasoft.odigen.sql.util.CatalogConstants;

/**
 *
 * @author Adi Neagu
 */
public class OdiSequence extends OdiExpr {

    private String projectName;
    private String name;
    private boolean global;
    private boolean nextVal;
    private boolean bindVariable;

    public OdiSequence(String projectName, String name) {
        this.global = Boolean.FALSE;

        this.name = name;

        if (projectName != null) {
            this.projectName = projectName;
            if ("GLOBAL".equalsIgnoreCase(projectName)) {
                global = Boolean.TRUE;
            }
        }
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGlobal() {
        return global;
    }

    public void setGlobal(boolean global) {
        this.global = global;
    }
    
    public String getQualifiedName() {
        return projectName + CatalogConstants.IDENTIFIER_DELIMITER + name;
    }

    public boolean isBindVariable() {
        return bindVariable;
    }

    public void setBindVariable(boolean valueType) {
        this.bindVariable = valueType;
    }

    public boolean isNextVal() {
        return nextVal;
    }

    public void setNextVal(boolean nextVal) {
        this.nextVal = nextVal;
    }

}
