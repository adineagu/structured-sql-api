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
package org.pecheasoft.odigen.sql.api.ast.impl;


import org.pecheasoft.odigen.sql.api.ast.SemanticExpression;
import org.pecheasoft.odigen.sql.api.ast.SemanticAnnotationSet;
import org.pecheasoft.odigen.sql.api.ast.SemanticAssignment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 *
 * @author Adi Neagu
 */
@JsonPropertyOrder({"className", "name", "alias", "expression"})
@JsonInclude(Include.NON_NULL)
public class SelectItem implements SemanticExpression {
    private final Expression expression;
    private final String alias;
    private SemanticAnnotationSet annotations;
    
    @JsonIgnore
    private SemanticAssignment targetColumn;

    public SelectItem(Expression expression, String alias) {
        this.expression = expression;
        this.alias = alias;
    }

    public SemanticExpression getExpression() {
        return expression;
    }

    @Override
    public java.util.List<DatastoreReferenceNode> getTableReferences() {
        return expression.getTableReferences();
    }

    @Override
    public String render(java.util.function.Function<DatastoreReferenceNode, String> names) {
        return expression.render(names) + " as " + alias;
    }

    public String getAlias() {
        return alias;
    }
    
    @JsonIgnore
    public SemanticAssignment getTargetColumn() {
        return targetColumn;
    }

    @Override
    public String toString() {
        return getText();
    }

    @Override
    public String getText() {
        return String.format("%s as %s", expression.getText(), this.alias);
    }

    public void setTargetColumn(SemanticAssignment targetColumn) {
        this.targetColumn = targetColumn;
    }

    @Override
    public SemanticAnnotationSet annotations() {
        return annotations;
    }

    public void setAnnotations(SemanticAnnotationSet annotations) {
        this.annotations = annotations;
    }

}
