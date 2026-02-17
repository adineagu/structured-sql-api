package org.pecheasoft.odigen.template.jte;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;
import org.pecheasoft.odigen.template.ITemplate;
import org.pecheasoft.odigen.template.ITemplateParameter;
import org.pecheasoft.odigen.template.ITemplateService;

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
public class JteTemplateService implements ITemplateService {

    private TemplateEngine templateEngine;
    private Map<String, String> templateCache;

    public JteTemplateService() {
        this.templateCache = new HashMap<>();
        initialize();
    }

    @Override
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
            
            // Create parameter map
            Map<String, Object> params = new HashMap<>();
            parameters.forEach(p -> params.put(p.getName(), p.getValue()));
            
            // Render template
            StringOutput output = new StringOutput();
            templateEngine.render(template.getName(), params, output);
            
            return output.toString();
            
        } catch (Exception e) {
            throw new RuntimeException("Error evaluating JTE template: " + template.getName(), e);
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
