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
public class Sort extends UnaryOperator {

    private SortSpec[] sortSpecs;

    public Sort(final SortSpec[] sortSpecs) {
        this.sortSpecs = sortSpecs;
    }

    public void setSortSpecs(SortSpec[] sortSpecs) {
        this.sortSpecs = sortSpecs;
    }

    public SortSpec[] getSortSpecs() {
        return this.sortSpecs;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Sort sort = (Sort) super.clone();
        sort.sortSpecs = new SortSpec[sortSpecs.length];
        for (int i = 0; i < sortSpecs.length; i++) {
            sort.sortSpecs[i] = (SortSpec) sortSpecs[i].clone();
        }

        return sort;
    }

    @JsonInclude(Include.NON_NULL)
    public static class SortSpec implements Cloneable {

        private Expr key;
        private boolean asc = true;
        private boolean nullFirst = false;

        public SortSpec(final Expr key) {
            this.key = key;
        }

        /**
         *
         * @param sortKey a column to sort
         * @param asc true if the sort order is ascending order
         * @param nullFirst Otherwise, it should be false.
         */
        public SortSpec(final ColumnReferenceExpr sortKey, final boolean asc,
                final boolean nullFirst) {
            this(sortKey);
            this.asc = asc;
            this.nullFirst = nullFirst;
        }

        public final boolean isAscending() {
            return this.asc;
        }

        public final void setDescending() {
            this.asc = false;
        }

        public final boolean isNullFirst() {
            return this.nullFirst;
        }

        public final void setNullFirst() {
            this.nullFirst = true;
        }

        public void setKey(Expr expr) {
            this.key = expr;
        }

        public final Expr getKey() {
            return this.key;
        }

        @Override
        public String toString() {
            return key + " " + (asc ? "asc" : "desc") + " " + (nullFirst ? "null first" : "");
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            SortSpec sortSpec = (SortSpec) super.clone();
            sortSpec.key = (Expr) key.clone();
            sortSpec.asc = asc;
            sortSpec.nullFirst = nullFirst;
            return sortSpec;
        }
    }
}
