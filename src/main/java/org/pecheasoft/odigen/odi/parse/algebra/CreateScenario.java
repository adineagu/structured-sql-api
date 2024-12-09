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

import java.util.Collection;


/**
 *
 * @author Adi Neagu
 */
public class CreateScenario extends OdiExpr {

    public enum SourceObjectType {
        MAPPING, PACKAGE, PROCEDURE, VARIABLE
    }

    private String name;
    private String version;
    private boolean regenerate;
    private String srcObjType;
    private String srcObjectName;
    private String physDesignName;
    private boolean alreadyExists = Boolean.FALSE;
    private String promptType;
    Collection<OdiScenarioStartVariable> startVariables;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public boolean isRegenerate() {
        return regenerate;
    }

    public void setRegenerate(boolean regenerate) {
        this.regenerate = regenerate;
    }

    public String getSrcObjType() {
        return srcObjType;
    }

    public void setSrcObjType(String srcObjType) {
        this.srcObjType = srcObjType;
    }

    public String getSrcObjectName() {
        return srcObjectName;
    }

    public void setSrcObjectName(String srcObjectName) {
        this.srcObjectName = srcObjectName;
    }

    public boolean isAlreadyExists() {
        return alreadyExists;
    }

    public void setAlreadyExists(boolean alreadyExists) {
        this.alreadyExists = alreadyExists;
    }

    public String getPhysDesignName() {
        return physDesignName;
    }

    public void setPhysDesignName(String physDesignName) {
        this.physDesignName = physDesignName;
    }

    public String getPromptType() {
        return promptType;
    }

    public void setPromptType(String promptType) {
        this.promptType = promptType;
    }

    public Collection<OdiScenarioStartVariable> getStartVariables() {
        return startVariables;
    }

    public void setStartVariables(Collection<OdiScenarioStartVariable> startVariables) {
        this.startVariables = startVariables;
    }

}
