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

import java.util.Collection;

import org.pecheasoft.odigen.sql.api.ast.IASTObject;
import org.pecheasoft.odigen.sql.api.ast.IExpression;
import org.pecheasoft.odigen.sql.api.ast.IQuery;
import org.pecheasoft.odigen.sql.api.ast.ISelectItem;
import org.pecheasoft.odigen.sql.api.ast.ISubQuery;
import org.pecheasoft.odigen.sql.util.annotation.impl.AnnotatedObject;

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
    "alias", 
    "selectList", 
    "selectText", 
    "distinct", 
    "fromList", 
    "fromText", 
    "pivotText", 
    "whereExprList", 
    "whereText", 
    "groupByExprList", 
    "groupByText", 
    "havingExprList", 
    "havingText", 
    "orderByExprList", 
    "orderByText"}
)
public class SubQuery extends AnnotatedObject implements ISubQuery {

    private final String alias;
    private final IQuery query;

    public SubQuery(IQuery query, String alias) {
        this.query = query;
        this.alias = alias;
    }
    
    @Override
    public String getAlias() {
        return alias;
    }

    @Override
    @JsonIgnore
    public IQuery getQuery() {
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
    public boolean getIsDistinct() {
        return query.getIsDistinct();
    }

    @Override
    public Collection<ISelectItem> getSelectList() {
        return query.getSelectList();
    }

    @Override
    public String getSelectText() {
        return query.getSelectText();
    }

    @Override
    public Collection<IASTObject> getFromList() {
        return query.getFromList();
    }

    @Override
    public String getFromText() {
        return query.getFromText();
    }

    @Override
    public Collection<IASTObject> getWhereList() {
        return query.getWhereList();
    }

    @Override
    public String getWhereText() {
        return query.getWhereText();
    }

    @Override
    public Collection<IExpression> getGroupByList() {
        return query.getGroupByList();
    }

    @Override
    public String getGroupByText() {
        return query.getGroupByText();
    }

    @Override
    public Collection<IExpression> getOrderByList() {
        return query.getOrderByList();
    }

    @Override
    public String getOrderByText() {
        return query.getOrderByText();
    }

    @Override
    public Collection<IExpression> getHavingList() {
        return query.getHavingList();
    }

    @Override
    public String getHavingText() {
        return query.getHavingText();
    }

    @Override
    public String getSetOperator() {
        return query.getSetOperator();
    }

    @Override
    public void setSetOperator(String setOperator) {
        this.query.setSetOperator(setOperator);
    }
    
    @Override
    public Collection<IQuery> getDatasetList() {
        return query.getDatasetList();
    }

    @Override
    public void setDatasetList(Collection<IQuery> datasetList) {
        query.setDatasetList(datasetList);
    }

    @Override
    public String getPivotText() {
        return query.getPivotText();
    }

    @Override
    public Collection<IASTObject> getWithList() {
        return query.getWithList();
    }

    @Override
    public String getWithText() {
        return query.getWithText();
    }

    @Override
    public String getText() {
        return getAlias();
    }
               
}
