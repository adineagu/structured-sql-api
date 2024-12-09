package org.pecheasoft.odigen.sql.api.ast.impl;

import org.pecheasoft.odigen.sql.api.ast.IExpression;
import org.pecheasoft.odigen.sql.api.ast.IFilterSubQuery;
import org.pecheasoft.odigen.sql.api.ast.IQuery;
import org.pecheasoft.odigen.sql.util.annotation.impl.AnnotatedObject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 *
 * @author Adi Neagu
 */

@JsonInclude(Include.NON_NULL)
public class FilterSubQuery extends AnnotatedObject implements IFilterSubQuery {
    private String queryRole;
    private String groupComparisonKeyword;
    private Expression expression;
    private Query query;

    @Override
    public IExpression getComparedExpression() {
        return expression;
    }

    @Override
    public String getQueryRole() {
        return queryRole;
    }

    @Override
    public String getGroupComparisonKeyword() {
        return groupComparisonKeyword;
    }

    @Override
    public IQuery getSubQuery() {
        return query;
    }
    
    @Override
    public String getName() {
        return null;
    }

}
