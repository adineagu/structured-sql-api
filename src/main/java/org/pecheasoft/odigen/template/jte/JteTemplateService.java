package org.pecheasoft.odigen.template.jte;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.pecheasoft.odigen.project.ProjectObject;
import org.pecheasoft.odigen.template.TemplateEngineFacade;
import org.pecheasoft.odigen.template.TemplateParameter;

import gg.jte.CodeResolver;
import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.output.StringOutput;

/**
 * JTE (Java Template Engine) implementation of the template service.
 * JTE is a modern, type-safe template engine with compiled templates for excellent performance.
 * 
 * @author Generated
 */
public class JteTemplateService implements TemplateEngineFacade {

    private TemplateEngine templateEngine;
    private Map<String, String> templateCache;

    public JteTemplateService() {
        this.templateCache = new HashMap<>();
        initialize();
    }

    public void initialize() {
        // Create a memory-based code resolver
        CodeResolver codeResolver = new CodeResolver() {
            @Override
            public String resolve(String name) {
                return templateCache.get(name);
            }

            @Override
            public long getLastModified(String name) {
                return 0;
            }
        };
        
        // Create template engine with plain text content type (for SQL generation)
        templateEngine = TemplateEngine.create(codeResolver, ContentType.Plain);
    }

    @Override
    public void loadTemplates(Collection<ProjectObject> templates) {
        for (ProjectObject template : templates) {
            templateCache.put(template.id().qualifiedName(), template.content());
        }
    }

    @Override
    public String resolve(ProjectObject template, Collection<TemplateParameter> parameters) {
        try {
            // Ensure template is loaded
            if (!templateCache.containsKey(template.id().qualifiedName())) {
                templateCache.put(template.id().qualifiedName(), template.content());
            }
            
            // Create parameter map
            Map<String, Object> params = new HashMap<>();
            parameters.forEach(p -> params.put(p.name(), p.value()));
            
            // Render template
            StringOutput output = new StringOutput();
            templateEngine.render(template.id().qualifiedName(), params, output);
            
            return output.toString();
            
        } catch (Exception e) {
            throw new RuntimeException("Error evaluating JTE template: " + template.id().qualifiedName(), e);
        }
    }

}
