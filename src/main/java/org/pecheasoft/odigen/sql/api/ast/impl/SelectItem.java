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
import org.pecheasoft.odigen.sql.api.ast.ISelectItem;
import org.pecheasoft.odigen.sql.api.ast.ITargetAttribute;
import org.pecheasoft.odigen.sql.util.annotation.impl.AnnotatedObject;

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
public class SelectItem extends AnnotatedObject implements ISelectItem {
    private final Expression expression;
    private final String alias;
    
    @JsonIgnore
    private ITargetAttribute targetColumn;

    public SelectItem(Expression expression, String alias) {
        this.expression = expression;
        this.alias = alias;
    }

    @Override
    public IExpression getExpression() {
        return expression;
    }

    @Override
    public String getAlias() {
        return alias;
    }
    
    @JsonIgnore
    @Override
    public ITargetAttribute getTargetColumn() {
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

    public void setTargetColumn(ITargetAttribute targetColumn) {
        this.targetColumn = targetColumn;
    }            

    @Override
    public String getName() {
        return getAlias();
    }

}
