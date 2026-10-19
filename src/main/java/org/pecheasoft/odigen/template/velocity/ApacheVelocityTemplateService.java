/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pecheasoft.odigen.template.velocity;

import java.io.StringWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.resource.loader.StringResourceLoader;
import org.apache.velocity.runtime.resource.util.StringResourceRepository;
import org.pecheasoft.odigen.project.ProjectObject;
import org.pecheasoft.odigen.template.TemplateEngineFacade;
import org.pecheasoft.odigen.template.TemplateParameter;

/**
 *
 * @author Adi Neagu
 */
public final class ApacheVelocityTemplateService implements TemplateEngineFacade {

    protected VelocityEngine engine;
    protected StringResourceRepository repo;

    private final Map<String, String> templateCache = new HashMap<>();

    public ApacheVelocityTemplateService() {
        initialize();
    }

    public void initialize() {
        initVelocityEngine();
    }

    @Override
    public void loadTemplates(Collection<ProjectObject> templates) {
        templateCache.keySet().forEach(repo::removeStringResource);
        templateCache.clear();
        templates.forEach(this::register);
    }

    private void register(ProjectObject template) {
        templateCache.put(template.id().qualifiedName(), template.content());
        repo.putStringResource(template.id().qualifiedName(), template.content());
    }

    @Override
    public String resolve(ProjectObject template, Collection<TemplateParameter> parameters) {
        VelocityContext context = new VelocityContext();
        parameters.forEach(p -> context.put(p.name(), p.value()));

        register(template);
        Template repoTemplate = engine.getTemplate(template.id().qualifiedName());

        StringWriter writer = new StringWriter();
        repoTemplate.merge(context, writer);

        return writer.toString();
    }

    private void initVelocityEngine() {
        engine = new VelocityEngine();
        engine.setProperty("resource.loaders", "string");
        engine.setProperty("resource.loader.string.class", StringResourceLoader.class.getName());
        engine.setProperty("resource.loader.string.repository.static", false);
        engine.setProperty("resource.loader.string.cache", false);
        engine.init();
        repo = getRepo(null, engine);
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
