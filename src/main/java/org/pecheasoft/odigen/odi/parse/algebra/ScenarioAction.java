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

import org.pecheasoft.odigen.odi.parse.OdiConstants;
import org.pecheasoft.odigen.odi.parse.OdiConstants.OdiObjectType;
import org.pecheasoft.odigen.odi.parse.OdiConstants.ScenarioActionType;

/**
 *
 * @author Adi Neagu
 *
 * Generic class for actions on a scenario: DROP, EXPORT, IMPORT, REGENERATE
 */
public class ScenarioAction extends OdiExpr {

    public enum SourceObjectType {
        MAPPING, PACKAGE, PROCEDURE, VARIABLE
    }

    private String name;
    private String version;
    private boolean ifExists = Boolean.FALSE;
    private boolean ifNotExists = Boolean.FALSE;
    private ScenarioActionType actionType;
    private OdiObjectType importObjectType;
    private OdiObjectType parentObjectType;
    private String parentObjectName;
    private OdiConstants.ImportType importType;
    private String xmlFileName;

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

    public void setImportType(OdiConstants.ImportType importType) {
        this.importType = importType;
    }

    public boolean isIfExists() {
        return ifExists;
    }

    public void setIfExists(boolean ifExists) {
        this.ifExists = ifExists;
    }

    public boolean isIfNotExists() {
        return ifNotExists;
    }

    public void setIfNotExists(boolean ifNotExists) {
        this.ifNotExists = ifNotExists;
    }

    public OdiConstants.ScenarioActionType getActionType() {
        return actionType;
    }

    public void setActionType(OdiConstants.ScenarioActionType actionType) {
        this.actionType = actionType;
    }

    public OdiObjectType getImportObjectType() {
        return importObjectType;
    }

    public void setImportObjectType(OdiObjectType importObjectType) {
        this.importObjectType = importObjectType;
    }

    public OdiConstants.ImportType getImportType() {
        return importType;
    }

    public String getXmlFileName() {
        return xmlFileName;
    }

    public void setXmlFileName(String xmlFileName) {
        this.xmlFileName = xmlFileName;
    }

    public OdiObjectType getParentObjectType() {
        return parentObjectType;
    }

    public void setParentObjectType(OdiObjectType parentObjectType) {
        this.parentObjectType = parentObjectType;
    }

    public String getParentObjectName() {
        return parentObjectName;
    }

    public void setParentObjectName(String parentObjectName) {
        this.parentObjectName = parentObjectName;
    }

}
