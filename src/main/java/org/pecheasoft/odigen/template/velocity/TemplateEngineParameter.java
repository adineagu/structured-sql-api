/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pecheasoft.odigen.template.velocity;

import org.pecheasoft.odigen.template.ITemplateParameter;

/**
 *
 * @author Adi Neagu
 */
public class TemplateEngineParameter implements ITemplateParameter {
    private final String name;
    private final Object value;    
    
    public TemplateEngineParameter(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Object getValue() {
        return value;
    }
}
