package org.pecheasoft.odigen.sql.api.ast.impl;

import java.util.Collection;
import java.util.List;

import org.pecheasoft.odigen.sql.api.ast.IASTObject;
import org.pecheasoft.odigen.sql.api.ast.IDatastoreReference;
import org.pecheasoft.odigen.sql.api.ast.ISelectItem;
import org.pecheasoft.odigen.sql.util.annotation.impl.AnnotatedObject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 *
 * @author Adi Neagu
 */

@JsonInclude(Include.NON_NULL)
public class MultiInsertTable extends AnnotatedObject implements IASTObject {
    private IDatastoreReference target;
    
    private String condition;    
    private Collection<ISelectItem> selectList;

    public IDatastoreReference getTarget() {
        return target;
    }

    public void setTarget(IDatastoreReference target) {
        this.target = target;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Collection<ISelectItem> getSelectList() {
        return selectList;
    }

    public void setSelectList(List<ISelectItem> selectList) {
        this.selectList = selectList;
    }

    @Override
    public String getName() {
        return null;
    }

}
