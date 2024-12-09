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
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.pecheasoft.odigen.sql.api.ast.IASTObject;
import org.pecheasoft.odigen.sql.api.ast.IExpression;
import org.pecheasoft.odigen.sql.api.ast.IQuery;
import org.pecheasoft.odigen.sql.api.ast.ISelectItem;
import org.pecheasoft.odigen.sql.util.TUtil;
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
public class Query extends AnnotatedObject implements IQuery {
    
    private String qryName;
    private String setOperator;
    private Boolean isDistinct = false;
    @JsonIgnore
    private Collection<IQuery> datasetList;
    private Collection<IASTObject> withList;
    private String withText;
    private Collection<ISelectItem> selectList;
    private Collection<IASTObject> fromList;
    private String fromText;
    private String pivotText;
    private Collection<IASTObject> whereExprList;
    private String whereText;
    private Collection<IExpression> groupByExprList;
    private String groupByText;
    private Collection<IExpression> havingExprList;
    private String havingText;
    private Collection<IExpression> orderByExprList;
    private String orderByText;    
    
    public Query() {
    }    

    public Query(String qryName) {
        this.qryName = qryName;
    }

    public Query(String qryName, String setOperator) {
        this.setOperator = setOperator;
        this.qryName = qryName;
    }

    @Override
    public boolean getIsDistinct() {
        return isDistinct;
    }        

    public void setIsDistinct(Boolean isDistinct) {
        this.isDistinct = isDistinct;
    }        
    
    @Override
    public Collection<IASTObject> getFromList() {
        return fromList;
    }

    public void setFromList(Collection<IASTObject> fromList) {
        this.fromList = fromList;
    }

    @Override
    public String getFromText() {
        return fromText;
    }

    public void setFromText(String fromText) {
        this.fromText = fromText;
    }

    @Override
    public Collection<ISelectItem> getSelectList() {
        return selectList;
    }

    public void setSelectList(Collection<ISelectItem> selectList) {
        this.selectList = selectList;
    }

    @Override
    public String getSelectText() {
        return StringUtils.join(selectList, "\n\t,");
    }

    @Override
    @JsonIgnore
    public Collection<IASTObject> getWhereList() {
        return whereExprList;
    }

    public void setWhereList(Collection<IASTObject> whereExprList) {
        this.whereExprList = whereExprList;
    }

    @Override
    public String getWhereText() {
        return StringUtils.join(whereExprList, "\nAND\t");
    }

    public void setWhereText(String whereText) {
        this.whereText = whereText;
    }

    @Override
    public Collection<IExpression> getGroupByList() {
        return groupByExprList;
    }

    public void setGroupByList(Collection<IExpression> groupByExprList) {
        this.groupByExprList = groupByExprList;
    }

    @Override
    public String getGroupByText() {
        return groupByText;
    }

    public void setGroupByText(String groupByText) {
        this.groupByText = groupByText;
    }
    
    @Override
    public Collection<IExpression> getHavingList() {
        return havingExprList;
    }

    public void setHavingList(Collection<IExpression> havingExprList) {
        this.havingExprList = havingExprList;
    }

    @Override
    public String getHavingText() {
        return havingText;
    }

    public void setHavingText(String havingText) {
        this.havingText = havingText;
    }

    @Override
    public Collection<IExpression> getOrderByList() {
        return orderByExprList;
    }

    public void setOrderByList(Collection<IExpression> orderByExprList) {
        this.orderByExprList = orderByExprList;
    }

    @Override
    public String getOrderByText() {
        return orderByText;
    }
    
    public void setOrderByText(String orderByText) {
        this.orderByText = orderByText;
    }  

    @Override
    public String getPivotText() {
        return pivotText;
    }

    public void setPivotText(String pivotText) {
        this.pivotText = pivotText;
    }

    @Override
    public Collection<IQuery> getDatasetList() {
        return datasetList;
    }

    @Override
    public void setDatasetList(Collection<IQuery> datasetList) {
        this.datasetList = datasetList;
    }

    @Override
    public String getSetOperator() {
        return setOperator;
    }

    @Override
    public void setSetOperator(String setOperator) {
        this.setOperator = setOperator;
    }

    @Override
    public String getName() {
        return qryName;
    }

    public void setName(String qryName) {
        this.qryName = qryName;
    }

    @Override
    public Collection<IASTObject> getWithList() {
        return withList;
    }

    public void setWithList(Collection<IASTObject> withList) {
        this.withList = withList;
    }

    @Override
    public String getWithText() {
        return withText;
    }

    public void setWithText(String withText) {
        this.withText = withText;
    }

    @Override
    public String toString() {
        
        String queryPattern = """
Query {
    qryName=%s,
    setOperator=%s,
    isDistinct=%s,
    selectList=[
        %s
    ],
    fromList=[%s],
    fromText=%s,
    whereExprList=%s,
    whereText=%s,
    groupByExprList=%s,
    groupByText=%s,
    havingExprList=%s,
    havingText=%s,
    orderByExprList=%s,
    orderByText=%s
}""";

    return String.format (
            queryPattern, 
            qryName, setOperator, isDistinct, 
            (TUtil.isNullOrEmpty(selectList) ? "" : selectList.stream().map(anno -> anno.getClass().getName() + " {" + anno.toString() + "}").collect(Collectors.joining(",\n        "))),
            (TUtil.isNullOrEmpty(fromList) ? "" : fromList.stream().map(anno -> anno.toString()).collect(Collectors.joining(",\n        "))),
            fromText,
            whereExprList,
            whereText,
            groupByExprList,
            groupByText,
            havingExprList,
            havingText,
            orderByExprList,
            orderByText
        );
    }    

    @Override
    @SuppressWarnings("CloneDoesntCallSuperClone")
    public Object clone() throws CloneNotSupportedException {
        Query newQry = new Query(this.qryName, this.setOperator);
        
        newQry.setAnnotations(this.getAnnotations());
        newQry.setDatasetList(this.datasetList);
        newQry.setFromList(this.fromList);
        newQry.setFromText(this.fromText);
        newQry.setGroupByList(groupByExprList);
        newQry.setGroupByText(groupByText);
        newQry.setHavingList(havingExprList);
        newQry.setHavingText(havingText);
        newQry.setIsDistinct(isDistinct);
        newQry.setOrderByList(orderByExprList);
        newQry.setOrderByText(orderByText);
        newQry.setPivotText(pivotText);
        newQry.setSelectList(selectList);
        newQry.setWhereList(whereExprList);

        return newQry;
    }
    
    public Query shallowCopy() {
        Query newQry = new Query(this.qryName, this.setOperator);
        
        newQry.setAnnotations(this.getAnnotations());
        newQry.setDatasetList(this.datasetList);
        newQry.setFromList(this.fromList);
        newQry.setFromText(this.fromText);
        newQry.setGroupByList(groupByExprList);
        newQry.setGroupByText(groupByText);
        newQry.setHavingList(havingExprList);
        newQry.setHavingText(havingText);
        newQry.setIsDistinct(isDistinct);
        newQry.setOrderByList(orderByExprList);
        newQry.setOrderByText(orderByText);
        newQry.setPivotText(pivotText);
        newQry.setSelectList(selectList);
        newQry.setWhereList(whereExprList);
        
        return newQry;
    }   

}
