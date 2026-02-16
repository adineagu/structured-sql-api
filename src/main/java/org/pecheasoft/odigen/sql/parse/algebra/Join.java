/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. The ASF
 * licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.pecheasoft.odigen.sql.parse.algebra;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Join extends BinaryOperator {

    public enum JoinType {
        CROSS,
        INNER,
        LEFT_OUTER,
        RIGHT_OUTER,
        FULL_OUTER,
        UNION,
        LEFT_ANTI,
        RIGHT_ANTI,
        LEFT_SEMI,
        RIGHT_SEMI
    }

    private JoinType joinType;
    private Expr joinQual;
    private ColumnReferenceExpr[] joinColumns;
    private boolean natural = false;
    private boolean implementAsLookup;
    private LookupJoin lookup;

    public Join(JoinType joinType) {
        this.joinType = joinType;
    }

    public JoinType getJoinType() {
        return this.joinType;
    }

    public boolean hasQual() {
        return this.joinQual != null;
    }

    public Expr getQual() {
        return this.joinQual;
    }

    public void setQual(Expr expr) {
        this.joinQual = expr;
    }

    public boolean hasJoinColumns() {
        return joinColumns != null;
    }

    public ColumnReferenceExpr[] getJoinColumns() {
        return joinColumns;
    }

    public void setJoinColumns(ColumnReferenceExpr[] columns) {
        joinColumns = columns;
    }

    public void setNatural() {
        natural = true;
    }

    public boolean isNatural() {
        return natural;
    }

    public String getJoinTypeAsSQL() {
        String vRet = null;

        switch (joinType) {
            case CROSS ->
                vRet = "CROSS JOIN";
            case INNER ->
                vRet = "INNER JOIN";
            case FULL_OUTER ->
                vRet = "FULL OUTER JOIN";
            case LEFT_OUTER ->
                vRet = "LEFT JOIN";
            case RIGHT_OUTER ->
                vRet = "RIGHT JOIN";
            case LEFT_ANTI -> {
            }
            case LEFT_SEMI -> {
            }
            case RIGHT_ANTI -> {
            }
            case RIGHT_SEMI -> {
            }
            case UNION -> {
            }
            default -> {
            }
        }

        return vRet;
    }

    public boolean isImplementAsLookup() {
        return implementAsLookup;
    }

    public void setImplementAsLookup(boolean implementAsLookup) {
        this.implementAsLookup = implementAsLookup;
    }

    public LookupJoin getLookup() {
        return lookup;
    }

    public void setLookup(LookupJoin lookup) {
        this.lookup = lookup;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Join join = (Join) super.clone();
        join.joinType = joinType;
        join.joinQual = (Expr) joinQual.clone();
        if (joinColumns != null) {
            join.joinColumns = new ColumnReferenceExpr[joinColumns.length];
            for (ColumnReferenceExpr colume : joinColumns) {
                join.joinColumns = (ColumnReferenceExpr[]) colume.clone();
            }
        }
        join.natural = natural;

        return join;
    }

    public static class LookupJoin extends Expr {

        public enum LookupMatchRowRule {FIRST_ROW, LAST_ROW, ALL_ROWS};
        
        private LookupMatchRowRule matchRowRule;
        private Sort sortExpr;
    
        public LookupMatchRowRule getMatchRowRule() {
            return matchRowRule;
        }
    
        public void setMatchRowRule(LookupMatchRowRule matchRowRule) {
            this.matchRowRule = matchRowRule;
        }
    
        public Sort getSortExpr() {
            return sortExpr;
        }
    
        public void setSortExpr(Sort sortExpr) {
            this.sortExpr = sortExpr;
        }
        
    }    
}
