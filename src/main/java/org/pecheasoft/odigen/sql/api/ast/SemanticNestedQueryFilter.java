package org.pecheasoft.odigen.sql.api.ast;

import org.pecheasoft.odigen.sql.api.ast.impl.Expression;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 *
 * @author Adi Neagu
 */

@JsonInclude(Include.NON_NULL)
public class SemanticNestedQueryFilter implements SemanticModel {
    private String queryRole;
    private String groupComparisonKeyword;
    private Expression expression;
    private SemanticSimpleQueryBlock query;
    private SemanticAnnotationSet annotations;

    public SemanticExpression getComparedExpression() {
        return expression;
    }

    public String getQueryRole() {
        return queryRole;
    }

    public String getGroupComparisonKeyword() {
        return groupComparisonKeyword;
    }

    public SemanticSimpleQueryBlock getSubQuery() {
        return query;
    }

    public String getName() {
        throw new UnsupportedOperationException("Unimplemented method 'getName'");
    }

    @Override
    public SemanticAnnotationSet annotations() {
        return annotations;
    }

    public void setAnnotations(SemanticAnnotationSet annotations) {
        this.annotations = annotations;
    }

}
