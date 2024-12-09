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

import org.pecheasoft.odigen.sql.api.ast.IExpression;
import org.pecheasoft.odigen.sql.api.ast.IJoin;
import org.pecheasoft.odigen.sql.api.ast.IJoinComponent;
import org.pecheasoft.odigen.sql.api.ast.IQuery;
import org.pecheasoft.odigen.sql.api.ast.IRelation;
import org.pecheasoft.odigen.sql.util.TUtil;
import org.pecheasoft.odigen.sql.util.annotation.impl.AnnotatedObject;

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
public class Join extends AnnotatedObject implements IJoin {
    
    private final IJoinComponent leftRelation;
    private final IJoinComponent rightRelation;
    private final String joinType;
    private final IExpression joinExpression;
    private final String joinName;

    public Join(String joinName, IJoinComponent leftRelation, IJoinComponent rightRelation, String joinType, IExpression joinExpression) {
        this.joinName = joinName;
        this.leftRelation = leftRelation;
        this.rightRelation = rightRelation;
        this.joinType = joinType;
        this.joinExpression = joinExpression;
    }

    public Join(IJoinComponent leftRelation, IJoinComponent rightRelation, String joinType, IExpression joinExpression) {
        this.joinName = "";
        this.leftRelation = leftRelation;
        this.rightRelation = rightRelation;
        this.joinType = joinType;
        this.joinExpression = joinExpression;
    }

    @Override
    public IRelation getLeftTable() {
        return leftRelation instanceof IRelation && !(leftRelation instanceof IQuery) ? (IRelation) leftRelation : null;
    }

    @Override
    public IRelation getRightTable() {
        return rightRelation instanceof IRelation && !(rightRelation instanceof IQuery)? (IRelation) rightRelation : null;
    }

    @Override
    public IQuery getLeftQuery() {
        return leftRelation instanceof IQuery ? (IQuery) leftRelation : null;
    }

    @Override
    public IQuery getRightQuery() {
        return rightRelation instanceof IQuery ? (IQuery) rightRelation : null;
    }        
    
    @Override
    public IJoin getLeftJoin() {
        return leftRelation instanceof IJoin ? (IJoin) leftRelation : null;
    }

    @Override
    public IJoin getRightJoin() {
        return rightRelation instanceof IJoin ? (IJoin) rightRelation : null;
    }
    
    @Override
    public String getJoinType() {
        return joinType;
    }

    @Override
    public IExpression getJoinExpression() {
        return joinExpression;
    }

    @Override
    public String getName() {
        return joinName;
    }
    
    @Override
    public String getText() {
        StringBuilder vBuilder = new StringBuilder(leftRelation.getText());
        
        if (!TUtil.isNullOrEmpty(joinType)) {
            vBuilder.append(joinType);

            if (rightRelation != null) {
                vBuilder.append(" ").append(rightRelation.getText());
            } else {
                vBuilder.append("<NUL>");
            }
            
            if (joinExpression != null) {
                vBuilder.append(" ON ").append(joinExpression.getText());
            }
        }
        
        return vBuilder.toString();
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

}
