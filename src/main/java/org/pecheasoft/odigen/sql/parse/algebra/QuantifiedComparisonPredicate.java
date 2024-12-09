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
public class QuantifiedComparisonPredicate extends BinaryOperator {

    private String sqlOperator;
    private String quantifier;
    
    public QuantifiedComparisonPredicate(Expr predicand, Expr subquery, String sqlOperator, String quantifier) {
        super(Operator.QuantifiedComparisonPredicate, predicand, subquery);
        this.sqlOperator = sqlOperator;
        this.quantifier = quantifier;
    }

    public Expr getPredicand() {
        return left;
    }

    public Expr getSubquery() {
        return right;
    }

    public String getSqlOperator() {
        return sqlOperator;
    }

    public void setSqlOperator(String sqlOperator) {
        this.sqlOperator = sqlOperator;
    }

    public String getQuantifier() {
        return quantifier;
    }

    public void setQuantifier(String quantifier) {
        this.quantifier = quantifier;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        QuantifiedComparisonPredicate qntfCompPredicate = (QuantifiedComparisonPredicate) super.clone();
        qntfCompPredicate.sqlOperator = sqlOperator;
        qntfCompPredicate.quantifier = quantifier;
        return qntfCompPredicate;
    }
}
