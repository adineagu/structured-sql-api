package org.pecheasoft.odigen.template.pebble;

import io.pebbletemplates.pebble.PebbleEngine;
import io.pebbletemplates.pebble.template.PebbleTemplate;
import org.pecheasoft.odigen.project.ProjectObject;
import org.pecheasoft.odigen.template.TemplateEngineFacade;
import org.pecheasoft.odigen.template.TemplateParameter;

import java.io.StringWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public final class PebbleTemplateService implements TemplateEngineFacade {

    private PebbleEngine engine;
    private final Map<String, String> templateCache = new HashMap<>();

    public PebbleTemplateService() {
        initialize();
    }

    private void initialize() {
        this.engine = new PebbleEngine.Builder()
            .loader(new MapLoader(templateCache))
            .cacheActive(false)
            .autoEscaping(false)
            .build();
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
        try {
            templateCache.put(template.id().qualifiedName(), template.content());

            Map<String, Object> context = parameters.stream()
                .collect(Collectors.toMap(
                    TemplateParameter::name,
                    TemplateParameter::value
                ));

            PebbleTemplate t = engine.getTemplate(template.id().qualifiedName());
            StringWriter writer = new StringWriter();
            t.evaluate(writer, context);

            return writer.toString();

        } catch (Exception e) {
            throw new RuntimeException(
                "Error resolving Pebble template: " + template.id().qualifiedName(), e
            );
        }
    }
}
