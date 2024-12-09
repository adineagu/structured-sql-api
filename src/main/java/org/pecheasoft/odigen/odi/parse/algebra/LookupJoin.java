/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pecheasoft.odigen.odi.parse.algebra;

import org.pecheasoft.odigen.sql.parse.algebra.Sort;

/**
 *
 * @author Adi Neagu
 */
public class LookupJoin extends OdiExpr {

    public enum LookupMatchRowRule {FIRST_ROW, LAST_ROW, ALL_ROWS};
    
    private LookupMatchRowRule matchRowRule;
    private Sort sortExpr;

    public LookupMatchRowRule getMatchRowRule() {
        return matchRowRule;
    }

    public void setMatchRowRule(LookupMatchRowRule matchRowRule) {
        this.matchRowRule = matchRowRule;
    }

    public Sort getSortExpr() {
        return sortExpr;
    }

    public void setSortExpr(Sort sortExpr) {
        this.sortExpr = sortExpr;
    }
    
}
