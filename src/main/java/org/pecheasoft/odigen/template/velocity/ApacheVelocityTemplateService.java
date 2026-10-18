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
import org.apache.velocity.app.Velocity;
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
        templateCache.clear();
        templates.forEach(t ->
            templateCache.put(t.id().qualifiedName(), t.content())
        );
    }

    @Override
    public String resolve(ProjectObject template, Collection<TemplateParameter> parameters) {
        VelocityContext context = new VelocityContext();
        parameters.forEach(p -> context.put(p.name(), p.value()));

        Template repoTemplate = Velocity.getTemplate(template.id().qualifiedName());

        StringWriter writer = new StringWriter();
        repoTemplate.merge(context, writer);

        return writer.toString();
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
