package org.pecheasoft.odigen.template.freemarker;

import java.io.StringWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.pecheasoft.odigen.project.ProjectObject;
import org.pecheasoft.odigen.template.TemplateEngineFacade;
import org.pecheasoft.odigen.template.TemplateParameter;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;
import freemarker.cache.StringTemplateLoader;

/**
 * FreeMarker implementation of the template service.
 * FreeMarker is a powerful and feature-rich template engine with excellent documentation.
 * 
 * @author Generated
 */
public class FreeMarkerTemplateService implements TemplateEngineFacade {

    private Configuration cfg;
    private StringTemplateLoader loader = new StringTemplateLoader();

    public FreeMarkerTemplateService() {
        initialize();
    }

    private void initialize() {
        // Configure FreeMarker
        cfg = new Configuration(new Version("2.3.33"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateLoader(loader);
        cfg.setTemplateExceptionHandler(freemarker.template.TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        cfg.setFallbackOnNullLoopVariable(false);
    }

    @Override
    public void loadTemplates(Collection<ProjectObject> templates) {
        // Clear existing templates
        loader = new StringTemplateLoader();
        cfg.setTemplateLoader(loader);
        
        // Store template definitions
        for (ProjectObject template : templates) {
            loader.putTemplate(template.id().qualifiedName(), template.content());
        }
        cfg.clearTemplateCache();
    }

    @Override
    public String resolve(ProjectObject template, Collection<TemplateParameter> parameters) {
        try {
            // Create data model
            Map<String, Object> dataModel = new HashMap<>();
            parameters.forEach(p -> dataModel.put(p.name(), p.value()));
            
            // Get or create template
            loader.putTemplate(template.id().qualifiedName(), template.content());
            cfg.clearTemplateCache();
            Template fmTemplate = cfg.getTemplate(template.id().qualifiedName());
            
            // Process template
            StringWriter writer = new StringWriter();
            fmTemplate.process(dataModel, writer);
            
            return writer.toString();
            
        } catch (Exception e) {
            throw new RuntimeException("Error evaluating FreeMarker template: " + template.id().qualifiedName(), e);
        }
    }

}
