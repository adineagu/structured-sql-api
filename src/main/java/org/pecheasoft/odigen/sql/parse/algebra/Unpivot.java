/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pecheasoft.odigen.sql.parse.algebra;

import java.util.Collection;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Unpivot extends Relation {

    private Collection<NamedExpr> targets;
    private final Collection<String> sourceAttributeNames;
    private final String locatorAttributeName;
    private final Map<String, Collection<String>> pivotMap;
    private Expr child;

    public Unpivot(String relName, Collection<String> sourceAttributeNames, String locatorAttributeName, Map<String, Collection<String>> pivotMap) {
        super(relName);
        this.sourceAttributeNames = sourceAttributeNames;
        this.locatorAttributeName = locatorAttributeName;
        this.pivotMap = pivotMap;
    }

    public Collection<NamedExpr> getTargets() {
        return targets;
    }

    public void setTargets(Collection<NamedExpr> targets) {
        this.targets = targets;
    }

    public Collection<String> getSourceAttributeNames() {
        return sourceAttributeNames;
    }

    public String getLocatorAttributeName() {
        return locatorAttributeName;
    }

    public Map<String, Collection<String>> getPivotMap() {
        return pivotMap;
    }

    public Expr getChild() {
        return child;
    }

    public void setChild(Expr child) {
        this.child = child;
    }

}
