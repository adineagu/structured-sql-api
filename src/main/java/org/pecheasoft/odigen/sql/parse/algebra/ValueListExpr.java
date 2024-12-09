/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
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
public class ValueListExpr extends Expr {

    private Expr[] values;

    public ValueListExpr(Expr[] values) {
        this.values = values;
    }

    public Expr[] getValues() {
        return values;
    }

    public void setValues(Expr[] values) {
        this.values = values;
    }

    public void setValue(int i, Expr expr) {
        this.values[i] = expr;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        ValueListExpr valueListExpr = (ValueListExpr) super.clone();
        valueListExpr.values = new Expr[values.length];
        for (int i = 0; i < values.length; i++) {
            valueListExpr.values[i] = (Expr) values[i].clone();
        }
        return valueListExpr;
    }
}
