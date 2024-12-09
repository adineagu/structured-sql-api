/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pecheasoft.odigen.template;

import java.util.Collection;

import org.apache.commons.lang3.tuple.Pair;

/**
 *
 * @author Adi Neagu
 */
public interface ITemplateService {
    void initialize();

    void loadTemplates(Collection<ITemplate> templates);

    // execute a template with a set of parameters
    String evaluate(ITemplate template, Collection<ITemplateParameter> parameters);

    // execute a set of templates each with its set of parameters
    String evaluate(Collection<Pair<ITemplate, Collection<ITemplateParameter>>> parameters);
}
