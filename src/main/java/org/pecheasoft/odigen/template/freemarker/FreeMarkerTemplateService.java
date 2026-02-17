package org.pecheasoft.odigen.template.freemarker;

import java.io.StringWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;
import org.pecheasoft.odigen.template.ITemplate;
import org.pecheasoft.odigen.template.ITemplateParameter;
import org.pecheasoft.odigen.template.ITemplateService;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;

/**
 * FreeMarker implementation of the template service.
 * FreeMarker is a powerful and feature-rich template engine with excellent documentation.
 * 
 * @author Generated
 */
public class FreeMarkerTemplateService implements ITemplateService {

    private Configuration cfg;
    private Map<String, String> templateCache;

    public FreeMarkerTemplateService() {
        this.templateCache = new HashMap<>();
        initialize();
    }

    @Override
    public void initialize() {
        // Configure FreeMarker
        cfg = new Configuration(new Version("2.3.33"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(freemarker.template.TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        cfg.setFallbackOnNullLoopVariable(false);
    }

    @Override
    public void loadTemplates(Collection<ITemplate> templates) {
        // Clear existing templates
        templateCache.clear();
        
        // Store template definitions
        templates.forEach(t -> templateCache.put(t.getName(), t.getBody()));
    }

    @Override
    public String evaluate(ITemplate template, Collection<ITemplateParameter> parameters) {
        try {
            // Create data model
            Map<String, Object> dataModel = new HashMap<>();
            parameters.forEach(p -> dataModel.put(p.getName(), p.getValue()));
            
            // Get or create template
            String templateBody = templateCache.getOrDefault(template.getName(), template.getBody());
            Template fmTemplate = new Template(
                template.getName(), 
                templateBody, 
                cfg
            );
            
            // Process template
            StringWriter writer = new StringWriter();
            fmTemplate.process(dataModel, writer);
            
            return writer.toString();
            
        } catch (Exception e) {
            throw new RuntimeException("Error evaluating FreeMarker template: " + template.getName(), e);
        }
    }

    @Override
    public String evaluate(Collection<Pair<ITemplate, Collection<ITemplateParameter>>> templatesCollection) {
        return templatesCollection
            .stream()
            .map(p -> evaluate(p.getLeft(), p.getRight()))
            .collect(Collectors.joining("\n"));
    }
}
