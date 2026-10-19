package org.pecheasoft.odigen.render;

import java.util.Optional;

import org.pecheasoft.odigen.metadata.MetadataManager;
import org.pecheasoft.odigen.metadata.MetadataResolver;
import org.pecheasoft.odigen.project.ProjectObject;
import org.pecheasoft.odigen.template.TemplateEngineFacade;

public class TransformationBuilder {
    private final ProjectObject source;
    private TransformationContext context;
    private final TemplateEngineFacade templateEngine;
    private final MetadataManager metadata;
    private final MetadataResolver.Mode metadataResolution;

    public TransformationBuilder(ProjectObject source, TransformationContext context, TemplateEngineFacade templateEngine, MetadataManager metadata) {
        this(source, context, templateEngine, metadata, MetadataResolver.Mode.STRICT);
    }

    public TransformationBuilder(ProjectObject source, TransformationContext context, TemplateEngineFacade templateEngine,
            MetadataManager metadata, MetadataResolver.Mode metadataResolution) {
        this.source = source;
        this.context = context;
        this.templateEngine = templateEngine;
        this.metadata = metadata;
        this.metadataResolution = metadataResolution;
    }

    public TemplateBuilder using(String templateId) {
        Optional<ProjectObject> template = this.metadata.findTemplate(templateId);
        if (template.isEmpty()) template = metadata.findTemplateResource(templateId);
        if (template.isEmpty()) {
            throw new IllegalArgumentException("Template not found: " + templateId);
        }

        if (org.pecheasoft.odigen.template.TemplatePackage.isPackage(template.get()))
            throw new IllegalArgumentException("Use codegen.renderPackage() or generatePackage() for a multi-artifact template package: " + templateId);

        return new TemplateBuilder(template.get(), source, context, templateEngine, metadata, metadataResolution);
    }

}
