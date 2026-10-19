package org.pecheasoft.odigen.render;

import java.util.List;
import java.util.ArrayList;

import org.pecheasoft.odigen.project.ProjectObject;
import org.pecheasoft.odigen.metadata.MetadataManager;
import org.pecheasoft.odigen.metadata.MetadataResolver;
import org.pecheasoft.odigen.sql.api.ast.SemanticModel;
import org.pecheasoft.odigen.sql.api.transform.SemanticModelBuilder;
import org.pecheasoft.odigen.sql.parse.SQLStatementParser;
import org.pecheasoft.odigen.sql.parse.algebra.Expr;
import org.pecheasoft.odigen.template.TemplateEngineFacade;
import org.pecheasoft.odigen.template.TemplateParameter;

public class TemplateBuilder {
    private final ProjectObject source;
    private final TransformationContext context;
    private final TemplateEngineFacade templateEngine;
    private final ProjectObject template;
    private final MetadataResolver metadataResolver;
    private final MetadataResolver.Mode metadataResolution;
    private SemanticModel model;
    private final List<TemplateParameter> parameters = new ArrayList<>();

    public TemplateBuilder(ProjectObject template, ProjectObject source, TransformationContext context, TemplateEngineFacade templateEngine) {
        this(template, source, context, templateEngine, null, MetadataResolver.Mode.STRICT);
    }

    public TemplateBuilder(ProjectObject template, ProjectObject source, TransformationContext context,
            TemplateEngineFacade templateEngine, MetadataManager metadata, MetadataResolver.Mode metadataResolution) {
        this.template = template;
        this.source = source;
        this.context = context;
        this.templateEngine = templateEngine;
        this.metadataResolver = metadata == null ? null : new MetadataResolver(metadata);
        this.metadataResolution = metadataResolution;
    }

    /** Use a prepared AST, including any strategy-specific manipulations. */
    public TemplateBuilder withModel(SemanticModel model) {
        this.model = java.util.Objects.requireNonNull(model);
        return this;
    }

    /** Supply explicit strategy dependencies such as metadata or helper objects. */
    public TemplateBuilder withParameter(String name, Object value) {
        parameters.add(TemplateParameter.of(name, value));
        return this;
    }

    public String render() {
        String sourceObjectType = switch (source.id().type()) {
            case DATASTORE -> "datastore";
            case MAPPING -> "mapping";
            default -> "unknown";
        };

        SemanticModel sourceSemanticModel = model != null ? model : parse(source.content());
        if (metadataResolver != null) {
            metadataResolver.resolve(sourceSemanticModel, source.id().qualifiedName(), metadataResolution);
        }

        List<TemplateParameter> arguments = new ArrayList<>(parameters);
        if (arguments.stream().anyMatch(p -> p.name().equals(sourceObjectType) || p.name().equals("ctx"))) {
            throw new IllegalArgumentException("Reserved template parameters: " + sourceObjectType + " and ctx. Use withModel() or withContext().");
        }
        arguments.add(TemplateParameter.of(sourceObjectType, sourceSemanticModel));
        arguments.add(TemplateParameter.of("ctx", context.copy()));
        return templateEngine.resolve(template, arguments);
    }
    
    private SemanticModel parse(String stmt) {
        SQLStatementParser parser = new SQLStatementParser();
        Expr expr = parser.parseSingleStatementScript(stmt);
        SemanticModel struct = SemanticModelBuilder.getStructuredObject(expr);

        return struct;
    }    
}
