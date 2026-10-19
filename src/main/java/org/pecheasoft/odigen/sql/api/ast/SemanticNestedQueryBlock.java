/*
 * Copyright 2017 DWH Tools.
 * SPDX-License-Identifier: GPL-3.0-only
 *
 * This file is part of SQLMorph.
 *
 * SQLMorph is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 3 of the License.
 *
 * SQLMorph is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with SQLMorph. If not, see <https://www.gnu.org/licenses/>.
 */
package org.pecheasoft.odigen.sql.api.ast;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 *
 * @author Adi Neagu
 */

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({
    "className",
    "name",
    "query",
    "alias", 
    "selectList",
    "distinct", 
    "fromList", 
    "pivotText", 
    "whereExprList", 
    "groupByExprList", 
    "havingExprList", 
    "orderByExprList"
    }
)
public class SemanticNestedQueryBlock extends SemanticSimpleQueryBlock implements SemanticRelation {

    private final String alias;
    private final SemanticQueryBlock query;
    private SemanticAnnotationSet annotations;
    
    public SemanticNestedQueryBlock(SemanticQueryBlock query, String alias) {
        this.query = query;
        this.alias = alias;
    }
    
    public String getAlias() {
        return alias;
    }

    public SemanticQueryBlock getQuery() {
        return query;
    }

    @Override
    public String toString() {
        return "SubQuery{" + "alias=" + alias + ", query=" + query + '}';
    }

    @Override
    public String getName() {
        return getAlias();
    }

    @Override
    public SemanticAnnotationSet annotations() {
        return annotations;
    }

    public void setAnnotations(SemanticAnnotationSet annotations) {
        this.annotations = annotations;
    }

    @Override
    public SemanticNestedQueryBlock shallowCopy() {
        SemanticNestedQueryBlock copy = new SemanticNestedQueryBlock(this.query.shallowCopy(), this.alias);
        copy.setAnnotations(this.annotations);
        return copy;
    }
}

