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
public class MultiaryOperator extends Expr {

    protected Expr[] operands; 

    public MultiaryOperator(Expr[] operands) {
        super();
        this.operands = operands;
    }

    @SuppressWarnings("unchecked")
    public <T extends Expr> T[] getOperands() {
        return (T[]) this.operands;
    }

    public void setOperands(Expr[] operands) {
        this.operands = operands;
    }
    
    public void setOperand(int i, Expr expr) {
        operands[i] = expr;
    }

    @Override
    public String toString() {
        StringBuilder bld = new StringBuilder();
        for (Expr operand : operands) {
            bld.append(" ").append(operand.toString());
        }
        return bld.toString();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        MultiaryOperator multiaryOperator = (MultiaryOperator) super.clone();
        multiaryOperator.operands = new Expr[operands.length];
        for (int i = 0; i < multiaryOperator.getOperands().length; i++) {
            multiaryOperator.operands[i] = (Expr) operands[i].clone();
        }
        return multiaryOperator;
    }
}
