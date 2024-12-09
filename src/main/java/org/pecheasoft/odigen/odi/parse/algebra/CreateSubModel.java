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

import org.apache.commons.lang.StringUtils;

/**
 *
 * @author Adi Neagu
 */
public class CreateSubModel extends OdiExpr {

    private final String qualifiedCode;
    private final String submodelName;
    private boolean ifNotExists = false;
    
    public CreateSubModel(final String qualifiedName, final String modelName) {
        this.qualifiedCode = qualifiedName;
        this.submodelName = modelName;
    }

    public CreateSubModel(final String qualifiedName) {
        this.qualifiedCode = qualifiedName;
        this.submodelName = StringUtils.substringAfterLast(qualifiedName, ".");
    }
    
    public String getQualifiedCode() {
        return qualifiedCode;
    }

    public String getSubmodelName() {
        return submodelName;
    }
    
    public boolean isIfNotExists() {
        return ifNotExists;
    }

    public void setIfNotExists(boolean ifNotExists) {
        this.ifNotExists = ifNotExists;
    }

}
