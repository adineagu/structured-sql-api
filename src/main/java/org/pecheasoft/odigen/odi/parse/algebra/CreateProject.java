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
public class CreateProject extends OdiExpr {

    private final String projectCode;
    private final String projectName;
    private boolean ifNotExists = false;

    public CreateProject(final String projectCode, final String projectName) {
        this.projectCode = projectCode;
        this.projectName = projectName;
    }

    public CreateProject(final String projectCode) {
        this(projectCode, projectCode);
    }

    public String getProjectCode() {
        return projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public boolean isIfNotExists() {
        return ifNotExists;
    }

    public void setIfNotExists(boolean ifNotExists) {
        this.ifNotExists = ifNotExists;
    }

}
