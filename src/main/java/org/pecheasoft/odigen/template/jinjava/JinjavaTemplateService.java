package org.pecheasoft.odigen.template.jinjava;

import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;
import org.pecheasoft.odigen.template.ITemplate;
import org.pecheasoft.odigen.template.ITemplateParameter;
import org.pecheasoft.odigen.template.ITemplateService;

import com.hubspot.jinjava.Jinjava;
import com.hubspot.jinjava.JinjavaConfig;
import com.hubspot.jinjava.interpret.JinjavaInterpreter;
import com.hubspot.jinjava.loader.ResourceLocator;

/**
 * Jinjava implementation of the template service.
 * Jinjava is a Java implementation of the Jinja2 template engine (Python).
 * Brings Jinja's elegant syntax to Java applications.
 * 
 * @author Generated
 */
public class JinjavaTemplateService implements ITemplateService {

    private Jinjava jinjava;
    private Map<String, String> templateCache;

    public JinjavaTemplateService() {
        this.templateCache = new HashMap<>();
        initialize();
    }

    @Override
    public void initialize() {
        // Create Jinjava configuration
        JinjavaConfig config = JinjavaConfig.newBuilder()
            .withFailOnUnknownTokens(false)
            .build();
        
        // Initialize Jinjava with custom resource locator for in-memory templates
        jinjava = new Jinjava(config);
        
        // Register a custom resource locator that reads from our template cache
        jinjava.setResourceLocator(new ResourceLocator() {
            @Override
            public String getString(String fullName, Charset encoding, JinjavaInterpreter interpreter) {
                return templateCache.getOrDefault(fullName, "");
            }
        });
    }

    @Override
    public void loadTemplates(Collection<ITemplate> templates) {
        // Clear and reload template cache
        templateCache.clear();
        templates.forEach(t -> templateCache.put(t.getName(), t.getBody()));
    }

    @Override
    public String evaluate(ITemplate template, Collection<ITemplateParameter> parameters) {
        try {
            // Ensure template is loaded
            if (!templateCache.containsKey(template.getName())) {
                templateCache.put(template.getName(), template.getBody());
            }
            
            // Convert parameters to a context map
            Map<String, Object> context = parameters.stream()
                .collect(Collectors.toMap(
                    ITemplateParameter::getName,
                    ITemplateParameter::getValue
                ));
            
            // Render the template
            return jinjava.render(template.getBody(), context);
            
        } catch (Exception e) {
            throw new RuntimeException("Error evaluating Jinjava template: " + template.getName(), e);
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
