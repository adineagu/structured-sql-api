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

import org.pecheasoft.odigen.sql.api.ast.SemanticAnnotationSet;
import org.pecheasoft.odigen.sql.api.ast.SemanticExpression;
import org.pecheasoft.odigen.sql.api.ast.SemanticJoinSource;
import org.pecheasoft.odigen.sql.api.ast.SemanticSimpleQueryBlock;
import org.pecheasoft.odigen.sql.api.ast.SemanticRelation;

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
    "leftTable",
    "leftQuery",
    "leftJoin",
    "rightTable",
    "rightQuery",
    "rightJoin",
    "joinType",
    "joinExpression"
})
public class JoinNode implements SemanticJoinSource {
    
    private final SemanticJoinSource leftRelation;
    private final SemanticJoinSource rightRelation;
    private final String joinType;
    private final SemanticExpression joinExpression;
    private SemanticAnnotationSet annotations;
    private final String joinName;

    public JoinNode(String joinName, SemanticJoinSource leftRelation, SemanticJoinSource rightRelation, String joinType, SemanticExpression joinExpression) {
        this.joinName = joinName;
        this.leftRelation = leftRelation;
        this.rightRelation = rightRelation;
        this.joinType = joinType;
        this.joinExpression = joinExpression;
    }

    public JoinNode(SemanticJoinSource leftRelation, SemanticJoinSource rightRelation, String joinType, SemanticExpression joinExpression) {
        this.joinName = "";
        this.leftRelation = leftRelation;
        this.rightRelation = rightRelation;
        this.joinType = joinType;
        this.joinExpression = joinExpression;
    }

    public SemanticRelation getLeftTable() {
        return leftRelation instanceof SemanticRelation && !(leftRelation instanceof SemanticSimpleQueryBlock) ? (SemanticRelation) leftRelation : null;
    }

    public SemanticRelation getRightTable() {
        return rightRelation instanceof SemanticRelation && !(rightRelation instanceof SemanticSimpleQueryBlock)? (SemanticRelation) rightRelation : null;
    }

    public SemanticSimpleQueryBlock getLeftQuery() {
        return leftRelation instanceof SemanticSimpleQueryBlock ? (SemanticSimpleQueryBlock) leftRelation : null;
    }

    public SemanticSimpleQueryBlock getRightQuery() {
        return rightRelation instanceof SemanticSimpleQueryBlock ? (SemanticSimpleQueryBlock) rightRelation : null;
    }        
    
    public JoinNode getLeftJoin() {
        return leftRelation instanceof JoinNode ? (JoinNode) leftRelation : null;
    }

    public JoinNode getRightJoin() {
        return rightRelation instanceof JoinNode ? (JoinNode) rightRelation : null;
    }
    
    public String getJoinType() {
        return joinType;
    }

    public SemanticExpression getJoinExpression() {
        return joinExpression;
    }

    public String getName() {
        return joinName;
    }

    @Override
    public String toString() {
        String pattern = """

        JoinTable %s = {
            leftRelation %s = {%s},
            rightRelation %s = {%s},
            joinType = "%s",
            joinExpression %s = {%s}
        }
        """
        ;

        return String.format(
            pattern, 
            this.getClass().getName(),
            leftRelation.getClass().getName(),
            leftRelation,
            rightRelation == null ? "" : rightRelation.getClass().getName(),
            rightRelation,
            joinType,
            joinExpression == null ? "" : joinExpression.getClass().getName(),
            joinExpression
        );

    }

    @Override
    public SemanticAnnotationSet annotations() {
        return annotations;
    }

    public void setAnnotations(SemanticAnnotationSet annotations) {
        this.annotations = annotations;
    }

}