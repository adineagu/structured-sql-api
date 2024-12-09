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

import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.pecheasoft.odigen.sql.util.TUtil;

/**
 *
 * @author oracle
 */
public class KnowledgeModule extends OdiExpr {

    public enum KmType {
        XKM, LKM, IKM, CKM
    }

    private String name;
    private boolean global;
    private KmType kmType;
    private Map<String, String> options;
    private String technology;
    private List<String> targetTableQualifiedNames = TUtil.newList();

    public KnowledgeModule(String name, KnowledgeModule.KmType kmType) {

        this.name = name;
        this.kmType = kmType;
        this.global = Boolean.FALSE;

        if (name.toUpperCase().endsWith(".GLOBAL")) {
            this.global = Boolean.TRUE;
            this.name = StringUtils.removeEnd(name, ".GLOBAL");
        }
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

    public KmType getKmType() {
        return kmType;
    }

    public void setKmType(KmType kmType) {
        this.kmType = kmType;
    }

    public Map<String, String> getOptions() {
        return options;
    }

    public void setOptions(Map<String, String> options) {
        this.options = options;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public List<String> getTargetTableQualifiedNames() {
        return targetTableQualifiedNames;
    }

    public void setTargetTableQualifiedNames(List<String> targetTableQualifiedNames) {
        this.targetTableQualifiedNames = targetTableQualifiedNames;
    }

}
