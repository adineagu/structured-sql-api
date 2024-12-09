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
public class Aggregation extends UnaryOperator {

    private NamedExpr[] namedExprs;
    private GroupElement[] groups;

    public NamedExpr[] getTargets() {
        return this.namedExprs;
    }

    public void setTargets(NamedExpr[] namedExprs) {
        this.namedExprs = namedExprs;
    }

    public void setGroups(GroupElement[] groups) {
        this.groups = groups;
    }

    public boolean isEmptyGrouping() {
        return groups == null || groups.length == 0;
    }

    public GroupElement[] getGroupSet() {
        return groups;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Aggregation aggregation = (Aggregation) super.clone();

        if (namedExprs != null) {
            aggregation.namedExprs = new NamedExpr[namedExprs.length];
            for (int i = 0; i < namedExprs.length; i++) {
                aggregation.namedExprs[i] = (NamedExpr) namedExprs[i].clone();
            }
        }

        aggregation.groups = new GroupElement[groups.length];
        for (int i = 0; i < groups.length; i++) {
            aggregation.groups[i] = (GroupElement) groups[i].clone();
        }
        
        return aggregation;
    }

    public static class GroupElement implements Cloneable {

        private GroupType group_type;
        private Expr[] grouping_sets;

        public GroupElement(GroupType groupType, Expr[] grouping_sets) {
            this.group_type = groupType;
            this.grouping_sets = grouping_sets;
        }

        public GroupType getType() {
            return this.group_type;
        }

        public Expr[] getGroupingSets() {
            return this.grouping_sets;
        }

        public void setGroupingSets(Expr[] grouping_sets) {
            this.grouping_sets = grouping_sets;
        }

        public void setGroupSetTarget(int i, Expr expr) {
            grouping_sets[i] = expr;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            GroupElement element = (GroupElement) super.clone();
            element.group_type = group_type;
            if (element.grouping_sets != null) {
                element.grouping_sets = new Expr[grouping_sets.length];
                for (int i = 0; i < grouping_sets.length; i++) {
                    element.grouping_sets[i] = (Expr) grouping_sets[i].clone();
                }
            }
            return element;
        }
    }

    public static enum GroupType {
        OrdinaryGroup(""),
        Cube("Cube"),
        Rollup("Rollup"),
        EmptySet("()");

        String displayName;

        GroupType(String displayName) {
            this.displayName = displayName;
        }

        @Override
        public String toString() {
            return displayName;
        }
    }

}
