package org.pecheasoft.odigen.sql.api.ast.impl;

import java.util.List;

import org.pecheasoft.odigen.sql.api.ast.SemanticAnnotationSet;
import org.pecheasoft.odigen.sql.api.ast.SemanticModel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 *
 * @author Adi Neagu
 */

@JsonInclude(Include.NON_NULL)
public class MultiInsertTableNode implements SemanticModel {
    private DatastoreReferenceNode target;
    private SemanticAnnotationSet annotations;
    private String condition;    
    private List<SelectItem> selectList;

    public DatastoreReferenceNode getTarget() {
        return target;
    }

    public void setTarget(DatastoreReferenceNode target) {
        this.target = target;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public List<SelectItem> getSelectList() {
        return selectList;
    }

    public void setSelectList(List<SelectItem> selectList) {
        this.selectList = selectList;
    }

    @Override
    public SemanticAnnotationSet annotations() {
        return annotations;
    }

    public void setAnnotations(SemanticAnnotationSet annotations) {
        this.annotations = annotations;
    }

}
