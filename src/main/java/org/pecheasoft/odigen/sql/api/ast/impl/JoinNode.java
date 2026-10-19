/*
 * Copyright 2017 DWH Tools.
 *
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.odieasy.com/11-licenses/eula
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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