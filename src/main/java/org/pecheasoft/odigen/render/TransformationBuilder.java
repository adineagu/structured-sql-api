package org.pecheasoft.odigen.render;

import java.util.Optional;

import org.pecheasoft.odigen.metadata.MetadataManager;
import org.pecheasoft.odigen.project.ProjectObject;
import org.pecheasoft.odigen.template.TemplateEngineFacade;

public class TransformationBuilder {
    private final ProjectObject source;
    private TransformationContext context;
    private final TemplateEngineFacade templateEngine;
    private final MetadataManager metadata;

    public TransformationBuilder(ProjectObject source, TransformationContext context, TemplateEngineFacade templateEngine, MetadataManager metadata) {
        this.source = source;
        this.context = context;
        this.templateEngine = templateEngine;
        this.metadata = metadata;
    }

    public TemplateBuilder using(String templateId) {
        Optional<ProjectObject> template = this.metadata.findTemplate(templateId);
        if (template.isEmpty()) {
            throw new IllegalArgumentException("Template not found: " + templateId);
        }

        return new TemplateBuilder(template.get(), source, context, templateEngine);
    }

}