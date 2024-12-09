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


import java.util.Map;

/**
 *
 * @author Adi Neagu
 */
public class ProcedurePackageStep extends AbstractPackageStep {

    private final String procedureName;
    private final Map<String, String> options;

    public ProcedurePackageStep(String procedureName, Map<String, String> options) {
        this.procedureName = procedureName;
        this.options = options;
    } 

    public String getProcedureName() {
        return procedureName;
    }

    public Map<String, String> getOptions() {
        return options;
    }
            
}
