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

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.pecheasoft.odigen.sql.api.ast.SemanticSimpleQueryBlock;
import org.pecheasoft.odigen.sql.api.ast.impl.SelectItem;
import org.pecheasoft.odigen.sql.util.TUtil;

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
    "distinct", 
    "fromList", 
    "pivotText", 
    "whereExprList", 
    "groupByExprList", 
    "havingExprList", 
    "orderByExprList"
}
)
public class SemanticSimpleQueryBlock implements SemanticQueryBlock {
    private String qryName;
    private Boolean isDistinct = false;
    private List<SemanticModel> withList;
    private String withText;
    private List<SelectItem> selectList;
    private List<SemanticModel> fromList;
    private String fromText;
    private String pivotText;
    private List<SemanticModel> whereExprList;
    private String whereText;
    private List<SemanticExpression> groupByExprList;
    private String groupByText;
    private List<SemanticExpression> havingExprList;
    private String havingText;
    private List<SemanticExpression> orderByExprList;
    private String orderByText;
    private SemanticExpression limit;
    private SemanticAnnotationSet annotations;
    
    public SemanticSimpleQueryBlock() {
    }    

    public SemanticSimpleQueryBlock(String qryName) {
        this.qryName = qryName;
    }

    public boolean getIsDistinct() {
        return isDistinct;
    }        

    public void setIsDistinct(Boolean isDistinct) {
        this.isDistinct = isDistinct;
    }        
    
    public List<SemanticModel> getFromList() {
        return fromList;
    }

    public void setFromList(List<SemanticModel> fromList) {
        this.fromList = fromList;
    }

    public String getFromText() {
        return fromText;
    }

    public void setFromText(String fromText) {
        this.fromText = fromText;
    }

    public List<SelectItem> getSelectList() {
        return selectList;
    }

    public void setSelectList(List<SelectItem> selectList) {
        this.selectList = selectList;
    }

    public String getSelectText() {
        return StringUtils.join(selectList, "\n\t,");
    }

    @JsonIgnore
    public List<SemanticModel> getWhereList() {
        return whereExprList;
    }

    public void setWhereList(List<SemanticModel> whereExprList) {
        this.whereExprList = whereExprList;
    }

    public String getWhereText() {
        return StringUtils.join(whereExprList, "\nAND\t");
    }

    public void setWhereText(String whereText) {
        this.whereText = whereText;
    }

    public List<SemanticExpression> getGroupByList() {
        return groupByExprList;
    }

    public void setGroupByList(List<SemanticExpression> groupByExprList) {
        this.groupByExprList = groupByExprList;
    }

    public String getGroupByText() {
        return groupByText;
    }

    public void setGroupByText(String groupByText) {
        this.groupByText = groupByText;
    }
    
    public List<SemanticExpression> getHavingList() {
        return havingExprList;
    }

    public void setHavingList(List<SemanticExpression> havingExprList) {
        this.havingExprList = havingExprList;
    }

    public String getHavingText() {
        return havingText;
    }

    public void setHavingText(String havingText) {
        this.havingText = havingText;
    }

    public List<SemanticExpression> getOrderByList() {
        return orderByExprList;
    }

    public void setOrderByList(List<SemanticExpression> orderByExprList) {
        this.orderByExprList = orderByExprList;
    }

    public String getOrderByText() {
        return orderByText;
    }
    
    public void setOrderByText(String orderByText) {
        this.orderByText = orderByText;
    }  

    public String getPivotText() {
        return pivotText;
    }

    /** Row-count expression from the specification; templates choose target syntax. */
    public SemanticExpression getLimit() {
        return limit;
    }

    public void setLimit(SemanticExpression limit) {
        this.limit = limit;
    }

    public void setPivotText(String pivotText) {
        this.pivotText = pivotText;
    }

    public String getName() {
        return qryName;
    }

    public void setName(String qryName) {
        this.qryName = qryName;
    }

    public List<SemanticModel> getWithList() {
        return withList;
    }

    public void setWithList(List<SemanticModel> withList) {
        this.withList = withList;
    }

    public String getWithText() {
        return withText;
    }

    public void setWithText(String withText) {
        this.withText = withText;
    }

    public SemanticAnnotationSet annotations() {
        return annotations;
    }

    public void setAnnotations(SemanticAnnotationSet annotations) {
        this.annotations = annotations;
    }

    public String toString() {
        
        String queryPattern = """
Query {
    qryName=%s,
    isDistinct=%s,
    selectList=[
        %s
    ],
    fromList=[%s],
    whereExprList=%s,
    groupByExprList=%s,
    havingExprList=%s,
    orderByExprList=%s
}""";

    return String.format (
            queryPattern, 
            qryName, 
            isDistinct, 
            (TUtil.isNullOrEmpty(selectList) ? "" : selectList.stream().map(anno -> anno.getClass().getName() + " {" + anno.toString() + "}").collect(Collectors.joining(",\n        "))),
            (TUtil.isNullOrEmpty(fromList) ? "" : fromList.stream().map(anno -> anno.toString()).collect(Collectors.joining(",\n        "))),
            whereExprList,
            groupByExprList,
            havingExprList,
            orderByExprList
        );
    }    

    @Override
    @SuppressWarnings("CloneDoesntCallSuperClone")
    public Object clone() throws CloneNotSupportedException {
        SemanticSimpleQueryBlock newQry = new SemanticSimpleQueryBlock(this.qryName);
        newQry.setAnnotations(this.annotations());
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
        newQry.setLimit(limit);
        newQry.setSelectList(selectList);
        newQry.setWhereList(whereExprList);

        return newQry;
    }

    /** Copies the query shell, sharing child lists and annotations with this query. */
    public SemanticSimpleQueryBlock shallowCopy() {
        SemanticSimpleQueryBlock newQry = new SemanticSimpleQueryBlock(this.qryName);

        newQry.setAnnotations(this.annotations());
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
        newQry.setLimit(limit);
        newQry.setSelectList(selectList);
        newQry.setWhereList(whereExprList);
  
        return newQry;
    }   

}
