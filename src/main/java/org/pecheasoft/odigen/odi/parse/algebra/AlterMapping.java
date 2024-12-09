/*
 * Copyright 2017 Apache Software Foundation.
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

/**
 *
 * @author Adi Neagu
 */
public class AlterMapping extends OdiExpr {

    private String mappingName;
    private boolean ifExists;
    PhysicalDesignList physicalDesignList;
    String comment;
    Boolean reusable;

    public AlterMapping(String mappingName, boolean ifExists) {
        this.mappingName = mappingName;
        this.ifExists = ifExists;
    }

    public String getMappingName() {
        return mappingName;
    }

    public void setMappingName(String mappingName) {
        this.mappingName = mappingName;
    }

    public boolean isIfExists() {
        return ifExists;
    }

    public void setIfExists(boolean ifExists) {
        this.ifExists = ifExists;
    }

    public PhysicalDesignList getPhysicalDesignList() {
        return physicalDesignList;
    }

    public void setPhysicalDesignList(PhysicalDesignList physicalDesignList) {
        this.physicalDesignList = physicalDesignList;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean isReusable() {
        return reusable;
    }

    public void setReusable(Boolean reusable) {
        this.reusable = reusable;
    }

}
