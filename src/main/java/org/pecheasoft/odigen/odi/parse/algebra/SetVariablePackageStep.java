/*
 * Copyright 2018 Apache Software Foundation.
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
public class SetVariablePackageStep extends AbstractPackageStep {

    public enum Type {
        SET, INCREMENT
    }

    private final OdiVariable odiVariable;
    private final String value;
    private final Type setType;

    public SetVariablePackageStep(OdiVariable odiVariable, String value, Type setType) {
        this.odiVariable = odiVariable;
        this.value = value;
        this.setType = setType;
    }

    public OdiVariable getOdiVariable() {
        return odiVariable;
    }

    public String getValue() {
        return value;
    }

    public Type getSetType() {
        return setType;
    }

}
