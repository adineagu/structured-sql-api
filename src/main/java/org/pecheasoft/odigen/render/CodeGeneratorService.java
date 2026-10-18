package org.pecheasoft.odigen.render;

import java.util.Optional;

import org.pecheasoft.odigen.metadata.MetadataManager;
import org.pecheasoft.odigen.project.Project;
import org.pecheasoft.odigen.project.ProjectObject;
import org.pecheasoft.odigen.sql.api.ast.SemanticModel;
import org.pecheasoft.odigen.sql.api.transform.SemanticModelBuilder;
import org.pecheasoft.odigen.sql.parse.SQLStatementParser;
import org.pecheasoft.odigen.sql.parse.algebra.Expr;
import org.pecheasoft.odigen.template.TemplateEngineFacade;
import org.pecheasoft.odigen.template.TemplateEngineFacadeFactory;

public class CodeGeneratorService {
    public final Project project;
    private final TemplateEngineFacade templateEngine;
    private TransformationContext transformationContext;
    private final MetadataManager metadata;

    public CodeGeneratorService(Project project, MetadataManager metadata) {
        this.project = project;
        this.transformationContext = new TransformationContext();
        this.metadata = metadata;
        this.templateEngine = TemplateEngineFacadeFactory.create(project);
    }

    public CodeGeneratorService withContext(TransformationContext context) {
        this.transformationContext = context;
        return this;
    }

    public SemanticModel parse(String statement) {
        SQLStatementParser parser = new SQLStatementParser();
        Expr expr = parser.parse(statement);
        SemanticModel struct = SemanticModelBuilder.getStructuredObject(expr);

        return struct;
    }

    public SemanticModel parse(ProjectObject object) {        
        SQLStatementParser parser = new SQLStatementParser();
        Expr expr = parser.parse(object.content());
        SemanticModel struct = SemanticModelBuilder.getStructuredObject(expr);

        return struct;
    }    
    
    public TransformationBuilder transform(String source) {
        ProjectObject obj = getProjectObject(source);
        if (obj == null) {
            throw new IllegalArgumentException("No datastore or mapping found with id: " + source);
        }

        return new TransformationBuilder(obj, transformationContext, templateEngine, metadata);
    }

    private ProjectObject getProjectObject(String id) {
        Optional<ProjectObject> obj = metadata.findDatastore(id);
        
        if (obj.isPresent()) {
            return obj.get();
        } else {
            obj = metadata.findMapping(id);
            if (obj.isPresent()) {
                return obj.get();
            }
        }
        return null;
    }

}
