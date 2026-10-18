package org.pecheasoft.odigen.sql.api.ast.impl;

import java.util.List;

import org.pecheasoft.odigen.sql.api.ast.SemanticAnnotationSet;
import org.pecheasoft.odigen.sql.parse.algebra.ITableConstraint;
import org.pecheasoft.odigen.sql.util.annotation.AnnotationTransformer;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 *
 * @author Adi Neagu
 */

@JsonInclude(Include.NON_NULL)
public class DatastoreKey extends DatastoreConstraint {
        
    private final List<String> keyColumns;
    private final boolean primaryKey;
    private final boolean alternateKey;
    private final boolean nonUniqueIndex;
    
    public DatastoreKey(ITableConstraint key) {
        super(
            key.getConstraintName(),
            ConstraintType.KEY,
            key.isDefinedInDatabase() ? ConstraintScope.DATABASE : ConstraintScope.ODI,
            key.isControlFlowEnabled(), 
            key.isControlStaticEnabled(), 
            key.isDefinedInDatabase(), 
            key.isActive(),
            key.getMessage(),
            new SemanticAnnotationSet(
                AnnotationTransformer.toSemanticList(List.copyOf(key.getAnnotations()))
            )
        );   

        this.primaryKey = key.isPrimaryKey();
        this.alternateKey = key.isAlternateKey();
        this.nonUniqueIndex = key.isNonUniqueIndex();
        this.keyColumns = List.copyOf(key.getKeyColumns());
    }

    public String getKeyType() {
        if (isPrimaryKey()) {
            return "PRIMARY KEY";
        } else if (isAlternateKey()) {
            return "UNIQUE KEY";
        } else if (!nonUniqueIndex) {
            return "UNIQUE INDEX";
        } else {
            return "INDEX";
        }
    }
    
    public List<String> getKeyColumns() {
        return keyColumns;
    }

    public Boolean isPrimaryKey() {
        return primaryKey;
    }

    public Boolean isAlternateKey() {
        return alternateKey;
    }

    public boolean isNonUniqueIndex() {
        return nonUniqueIndex;
    }

}
