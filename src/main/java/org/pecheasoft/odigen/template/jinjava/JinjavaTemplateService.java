package org.pecheasoft.odigen.template.jinjava;

import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.pecheasoft.odigen.project.ProjectObject;
import org.pecheasoft.odigen.template.TemplateEngineFacade;
import org.pecheasoft.odigen.template.TemplateParameter;

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
public class JinjavaTemplateService implements TemplateEngineFacade {

    private Jinjava jinjava;
    private Map<String, String> templateCache;

    public JinjavaTemplateService() {
        this.templateCache = new HashMap<>();
        initialize();
    }

    private void initialize() {
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
    public String resolve(ProjectObject template, Collection<TemplateParameter> parameters) {
        try {
            // Ensure template is loaded
            templateCache.put(template.id().qualifiedName(), template.content());
            
            // Convert parameters to a context map
            Map<String, Object> context = parameters.stream()
                .collect(Collectors.toMap(
                    TemplateParameter::name,
                    TemplateParameter::value
                ));
            
            // Render the template
            return jinjava.render(template.content(), context);
            
        } catch (Exception e) {
            throw new RuntimeException("Error evaluating Jinjava template: " + template.id().qualifiedName(), e);
        }
    }

    @Override
    public void loadTemplates(Collection<ProjectObject> templates) {
        for (ProjectObject template : templates) {
            templateCache.put(template.id().qualifiedName(), template.content());
        }
    }

}
