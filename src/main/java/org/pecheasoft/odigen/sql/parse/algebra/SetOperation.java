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
public class SetOperation extends MultiaryOperator {
    
    public enum Type {
        UNION,
        EXCEPT,
        INTERSECT
    }

    private Type operationType;
    private Boolean[] distinctIndicators;
    private Type[] operationTypes;

    public SetOperation(Type operationType, Expr[] operands, Type[] operationTypes, Boolean[] distinctIndicators) {
        super(operands);
        this.operationType = operationType;
        this.distinctIndicators = distinctIndicators;
        this.operationTypes = operationTypes;
    }

    public Boolean[] getDistinctIndicators() {
        return distinctIndicators;
    }

    public void setDistinctIndicators(Boolean[] distinctIndicators) {
        this.distinctIndicators = distinctIndicators;
    }

    public Type[] getOperationTypes() {
        return operationTypes;
    }

    public Type getOperationType() {
        return operationType;
    }

    public void setOperationType(Type operationType) {
        this.operationType = operationType;
    }

    public void setOperationTypes(Type[] operationTypes) {
        this.operationTypes = operationTypes;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        SetOperation setOperation = (SetOperation) super.clone();
        setOperation.distinctIndicators = distinctIndicators.clone();
        setOperation.operationTypes = operationTypes.clone();
        return setOperation;
    }
}
