/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pecheasoft.odigen.odi.parse.algebra;

/**
 *
 * @author Adi Neagu
 */
public class OdiScenarioStartVariable {

    private final OdiVariable odiVariable;
    private final String defaultValue;
    private final String persistence;

    public OdiScenarioStartVariable(OdiVariable odiVariable, String defaultValue, String persistence) {
        this.odiVariable = odiVariable;
        this.defaultValue = defaultValue;
        this.persistence = persistence;
    }

    public OdiVariable getOdiVariable() {
        return odiVariable;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public String getPersistence() {
        return persistence;
    }

}
