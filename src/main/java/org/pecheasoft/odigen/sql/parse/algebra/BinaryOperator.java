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
public class BinaryOperator extends Expr {

    public enum Operator {
        And,
        Or,
        Equals,
        NotEquals,
        LessThan,
        LessThanOrEquals,
        GreaterThan,
        GreaterThanOrEquals,
        Concatenate,
        Plus,
        Minus,
        Multiply,
        Divide,
        Modular,
        InPredicate,
        Join,
        PatternMatchPredicate,
        QuantifiedComparisonPredicate
    }
    
    private Operator operator;
    protected Expr left;
    protected Expr right;

    BinaryOperator() {
        super();
    }

    public BinaryOperator(Operator operator, Expr left, Expr right) {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    public BinaryOperator(OpType opType) {
        super(opType);
    }

    @SuppressWarnings("unchecked")
    public <T extends Expr> T getLeft() {
        return (T) this.left;
    }

    public void setLeft(Expr left) {
        this.left = left;
    }

    @SuppressWarnings("unchecked")
    public <T extends Expr> T getRight() {
        return (T) this.right;
    }

    public void setRight(Expr right) {
        this.right = right;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return left.toString() + " " + opType.toString() + " " + right.toString();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        BinaryOperator binaryOperator = (BinaryOperator) super.clone();
        binaryOperator.left = (Expr) left.clone();
        binaryOperator.right = (Expr) right.clone();
        return binaryOperator;
    }
}
