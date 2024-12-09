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
public class FunctionExpr extends Expr {

    private String signature;
    private Expr[] params;

    public FunctionExpr(String signature) {
        this(OpType.Function, signature);
    }

    public FunctionExpr(String signature, Expr[] params) {
        this(OpType.Function, signature);
        setParams(params);
    }

    protected FunctionExpr(OpType type, String signature) {
        super(type);
        if (type != OpType.Function && type != OpType.CountRowsFunction) {
            throw new IllegalArgumentException("FunctionExpr cannot accept " + type + "type");
        }
        this.signature = signature;
    }

    protected FunctionExpr(OpType type, String signature, Expr[] params) {
        super(type);
        if (!OpType.isFunction(type)) {
            throw new IllegalArgumentException("FunctionExpr cannot accept " + type + "type");
        }
        this.signature = signature;
        setParams(params);
    }

    public String getSignature() {
        return this.signature;
    }

    public boolean hasParams() {
        return params != null;
    }

    public Expr[] getParams() {
        return params;
    }

    public final void setParams(Expr[] params) {
        this.params = params;
    }

    public void setParam(int i, Expr param) {
        this.params[i] = param;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        FunctionExpr func = (FunctionExpr) super.clone();
        func.signature = signature;
        if (params != null) {
            func.params = new Expr[params.length];
            for (int i = 0; i < params.length; i++) {
                func.params[i] = (Expr) params[i].clone();
            }
        }
        return func;
    }
}
