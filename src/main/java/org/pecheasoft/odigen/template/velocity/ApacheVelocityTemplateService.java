/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pecheasoft.odigen.template.velocity;

import java.io.StringWriter;
import java.util.Collection;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.resource.loader.StringResourceLoader;
import org.apache.velocity.runtime.resource.util.StringResourceRepository;
import org.pecheasoft.odigen.template.ITemplate;
import org.pecheasoft.odigen.template.ITemplateParameter;
import org.pecheasoft.odigen.template.ITemplateService;

/**
 *
 * @author Adi Neagu
 */
public final class ApacheVelocityTemplateService implements ITemplateService {

    protected VelocityEngine engine;
    protected StringResourceRepository repo;

    public ApacheVelocityTemplateService() {
        initialize();
    }

    @Override
    public void initialize() {
        initVelocityEngine();
    }

    @Override
    public void loadTemplates(Collection<ITemplate> templates) {
        templates.stream().forEach (
            t -> {if (repo.getStringResource(t.getName()) != null) repo.removeStringResource(t.getName());}
        );

        templates.stream().forEach (t -> repo.putStringResource(t.getName(), t.getBody(), "UTF-8"));
    }

    @Override
    public String evaluate(ITemplate template, Collection<ITemplateParameter> parameters) {
        VelocityContext context = new VelocityContext();
        parameters.forEach(p -> context.put(p.getName(), p.getValue()));

        Template repoTemplate = Velocity.getTemplate(template.getName());

        StringWriter writer = new StringWriter();
        repoTemplate.merge(context, writer);

        return writer.toString();
    }

    @Override
    public String evaluate(Collection<Pair<ITemplate, Collection<ITemplateParameter>>> templatesCollection) {
        return templatesCollection
            .stream()
            .map(p -> evaluate(p.getLeft(), p.getRight()))
            .collect(Collectors.joining("\n"));
    }

    private void initVelocityEngine() {
        Velocity.reset();
        Velocity.setProperty(Velocity.RESOURCE_LOADERS, "string");
        Velocity.addProperty("string.resource.loader.class", StringResourceLoader.class.getName());
        Velocity.addProperty("string.resource.loader.modificationCheckInterval", "1");
        Velocity.addProperty("velocimacro.max_depth", -1);
        Velocity.init();

        repo = getRepo(null, null);
    }

    private StringResourceRepository getRepo(String name, VelocityEngine engine) {
        if (engine == null) {
            if (name == null) {
                return StringResourceLoader.getRepository();
            } else {
                return StringResourceLoader.getRepository(name);
            }
        } else {
            if (name == null) {
                return (StringResourceRepository) engine.getApplicationAttribute(StringResourceLoader.REPOSITORY_NAME_DEFAULT);
            } else {
                return (StringResourceRepository) engine.getApplicationAttribute(name);
            }
        }
    }

}
