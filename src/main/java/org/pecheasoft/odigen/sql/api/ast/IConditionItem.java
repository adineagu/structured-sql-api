/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pecheasoft.odigen.sql.api.ast;

/**
 *
 * @author Adi Neagu
 */
public interface IConditionItem extends IExpression {
    boolean isFilterSubquery();
    IFilterSubQuery getFilterSubQuery();
    IExpression getExpression();
}
