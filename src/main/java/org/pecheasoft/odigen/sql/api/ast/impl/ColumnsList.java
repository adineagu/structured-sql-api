package org.pecheasoft.odigen.sql.api.ast.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.pecheasoft.odigen.sql.api.ast.SemanticModel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 *
 * @author Adi Neagu
 * @param <K>
 */

@JsonInclude(Include.NON_NULL)
public class ColumnsList<K extends SemanticModel> extends ArrayList<K> {

    private static final long serialVersionUID = -8964367556414533045L;

    public ColumnsList(List<? extends K> c) {
        super(c);
    }
    
    public List<K> annotatedWith(String tag) {
        List<K> cols = stream().filter(col -> col.annotations().has(tag)).collect(Collectors.toList());
        return new ColumnsList<>(cols);        
    }
    
    @Override
    public String toString() {
        return stream().map(K::toString).collect(Collectors.joining());
    }        
}
