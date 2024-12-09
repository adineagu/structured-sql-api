/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.pecheasoft.odigen.odi.parse.algebra;

public class DropSubModel extends OdiExpr {

    private String qualifiedCode;
    private boolean ifExists;
    private boolean cascade;

    public DropSubModel(String qualifiedName, boolean ifExists, boolean cascade) {
        this.qualifiedCode = qualifiedName;
        this.ifExists = ifExists;
        this.cascade = cascade;
    }

    public String getQualifiedCode() {
        return qualifiedCode;
    }

    public boolean isIfExists() {
        return ifExists;
    }

    public boolean isCascade() {
        return cascade;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        DropSubModel drop = (DropSubModel) super.clone();
        drop.qualifiedCode = qualifiedCode;
        drop.ifExists = ifExists;
        drop.cascade = cascade;
        return drop;
    }
}
