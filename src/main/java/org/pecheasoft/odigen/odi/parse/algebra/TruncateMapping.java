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

public class TruncateMapping extends OdiExpr {

    private String mappingName;
    private boolean ifExists;
    private boolean reusable;

    public TruncateMapping(String mappingName, boolean ifExists) {
        this.mappingName = mappingName;
        this.ifExists = ifExists;
    }

    public TruncateMapping(String mappingName, boolean ifExists, boolean reusable) {
        this(mappingName, ifExists);
        this.reusable = reusable;
    }

    public String getMappingName() {
        return mappingName;
    }

    public boolean isIfExists() {
        return ifExists;
    }

    public boolean isReusable() {
        return reusable;
    }

    public void setReusable(boolean reusable) {
        this.reusable = reusable;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        TruncateMapping drop = (TruncateMapping) super.clone();
        drop.mappingName = mappingName;
        drop.ifExists = ifExists;
        return drop;
    }
}
