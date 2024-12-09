package org.pecheasoft.odigen.sql.api.ast.impl;

import java.util.Collection;

import org.pecheasoft.odigen.sql.api.ast.IDatastoreKey;
import org.pecheasoft.odigen.sql.parse.algebra.ITableConstraint;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 *
 * @author Adi Neagu
 */

@JsonInclude(Include.NON_NULL)
public class DatastoreKey extends DatastoreConstraint implements IDatastoreKey {
        
    private final Collection<String> keyColumns;
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
            key.getAnnotations()  
        );   

        this.primaryKey = key.isPrimaryKey();
        this.alternateKey = key.isAlternateKey();
        this.nonUniqueIndex = key.isNonUniqueIndex();
        this.keyColumns = key.getKeyColumns();
    }

    @Override
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
    
    @Override
    public Collection<String> getKeyColumns() {
        return keyColumns;
    }

    @Override
    public Boolean isPrimaryKey() {
        return primaryKey;
    }

    @Override
    public Boolean isAlternateKey() {
        return alternateKey;
    }

    @Override
    public boolean isNonUniqueIndex() {
        return nonUniqueIndex;
    }

}
