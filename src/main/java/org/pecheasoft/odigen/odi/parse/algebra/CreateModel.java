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
public class CreateModel extends OdiExpr {

    private final String modelCode;
    private final String modelName;
    private final String logicalSchemaName;
    private final String reverseContext;    
    private boolean ifNotExists = false;
    
    public CreateModel(final String modelCode, final String modelName, final String logicalSchemaName, final String reverseContext) {
        this.modelCode = modelCode;
        this.modelName = modelName;
        this.logicalSchemaName = logicalSchemaName;
        this.reverseContext = reverseContext;
    }

    public CreateModel(final String modelCode, final String logicalSchemaName, final String reverseContext) {
        this(modelCode, modelCode, logicalSchemaName, reverseContext);
    }
    
    public String getModelCode() {
        return modelCode;
    }

    public String getModelName() {
        return modelName;
    }

    public String getLogicalSchemaName() {
        return logicalSchemaName;
    }

    public boolean isIfNotExists() {
        return ifNotExists;
    }

    public void setIfNotExists(boolean ifNotExists) {
        this.ifNotExists = ifNotExists;
    }

    public String getReverseContext() {
        return reverseContext;
    }

}
