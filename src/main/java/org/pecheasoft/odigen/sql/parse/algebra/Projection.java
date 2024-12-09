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
package org.pecheasoft.odigen.sql.parse.algebra;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Projection extends UnaryOperator {

    private boolean distinct = false;
    private NamedExpr[] targets;
    private DatasetHint datasetHint;

    public int size() {
        return targets.length;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct() {
        distinct = true;
    }

    public NamedExpr[] getNamedExprs() {
        return this.targets;
    }

    public void setNamedExprs(NamedExpr[] targets) {
        this.targets = targets;
    }

    public NamedExpr[] getTargets() {
        return targets;
    }

    public void setTargets(NamedExpr[] targets) {
        this.targets = targets;
    }

    public DatasetHint getDatasetHint() {
        return datasetHint;
    }

    public void setDatasetHint(DatasetHint datasetHint) {
        this.datasetHint = datasetHint;
    }

    @Override
    public Projection clone() throws CloneNotSupportedException {
        Projection projection = (Projection) super.clone();
        projection.distinct = distinct;
        if (targets != null) {
            projection.targets = new NamedExpr[targets.length];
            for (int i = 0; i < targets.length; i++) {
                projection.targets[i] = targets[i].clone();
            }
        }
    
        return projection;
    }

}
