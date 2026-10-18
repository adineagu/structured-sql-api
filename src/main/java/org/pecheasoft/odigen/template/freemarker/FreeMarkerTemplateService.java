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

/**
 * FreeMarker implementation of the template service.
 * FreeMarker is a powerful and feature-rich template engine with excellent documentation.
 * 
 * @author Generated
 */
public class FreeMarkerTemplateService implements TemplateEngineFacade {

    private Configuration cfg;
    private Map<String, String> templateCache;

    public FreeMarkerTemplateService() {
        this.templateCache = new HashMap<>();
        initialize();
    }

    private void initialize() {
        // Configure FreeMarker
        cfg = new Configuration(new Version("2.3.33"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(freemarker.template.TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        cfg.setFallbackOnNullLoopVariable(false);
    }

    @Override
    public void loadTemplates(Collection<ProjectObject> templates) {
        // Clear existing templates
        templateCache.clear();
        
        // Store template definitions
        templates.forEach(t -> templateCache.put(t.id().qualifiedName(), t.content()));
    }

    @Override
    public String resolve(ProjectObject template, Collection<TemplateParameter> parameters) {
        try {
            // Create data model
            Map<String, Object> dataModel = new HashMap<>();
            parameters.forEach(p -> dataModel.put(p.name(), p.value()));
            
            // Get or create template
            String templateBody = templateCache.getOrDefault(template.id().qualifiedName(), template.content());
            Template fmTemplate = new Template(
                template.id().qualifiedName(), 
                templateBody, 
                cfg
            );
            
            // Process template
            StringWriter writer = new StringWriter();
            fmTemplate.process(dataModel, writer);
            
            return writer.toString();
            
        } catch (Exception e) {
            throw new RuntimeException("Error evaluating FreeMarker template: " + template.id().qualifiedName(), e);
        }
    }

}
