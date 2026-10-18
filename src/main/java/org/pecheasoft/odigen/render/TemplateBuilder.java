package org.pecheasoft.odigen.render;

import java.util.List;
import java.util.Optional;

import org.pecheasoft.odigen.metadata.MetadataManager;
import org.pecheasoft.odigen.project.ProjectObject;
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

    public TemplateBuilder(ProjectObject template, ProjectObject source, TransformationContext context, TemplateEngineFacade templateEngine) {
        this.template = template;
        this.source = source;
        this.context = context;
        this.templateEngine = templateEngine;
    }

    public String render() {
        String sourceObjectType = switch (source.id().type()) {
            case DATASTORE -> "datastore";
            case MAPPING -> "mapping";
            default -> "unknown";
        };

        SemanticModel sourceSemanticModel = parse(source.content());

        return templateEngine.resolve(template, List.of(new TemplateParameter(sourceObjectType, sourceSemanticModel)));
    }
    
    private SemanticModel parse(String stmt) {
        SQLStatementParser parser = new SQLStatementParser();
        Expr expr = parser.parse(stmt);
        SemanticModel struct = SemanticModelBuilder.getStructuredObject(expr);

        return struct;
    }    
}
