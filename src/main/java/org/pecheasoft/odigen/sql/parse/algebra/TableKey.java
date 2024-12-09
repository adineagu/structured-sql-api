/*
 * Copyright 2018 Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.pecheasoft.odigen.sql.parse.algebra;

import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class TableKey extends Expr implements ITableConstraint {

    private final ITableConstraint constraint;
    private final List<String> keyColumns;
    private final boolean primaryKey;
    private final boolean alternateKey;
        
    public TableKey(ITableConstraint constraint, List<String> keyColumns, boolean primaryKey, boolean alternateKey) {
        this.constraint = constraint;
        this.keyColumns = keyColumns;
        this.primaryKey = primaryKey;
        this.alternateKey = alternateKey;
    }

    @Override
    public String getConstraintName() {
        return constraint.getConstraintName();
    }

    @Override
    public ConstraintType getConstraintType() {
        if (isPrimaryKey()) {
            return ConstraintType.PRIMARY_KEY;
        } else if (isAlternateKey()) {
            return ConstraintType.ALTERNATE_KEY;
        } else if (isUniqueIndex()) {
            return ConstraintType.UNIQUE_INDEX;
        } else {
            return ConstraintType.INDEX;
        }
    }

    @Override
    public Collection<String> getKeyColumns() {
        return keyColumns;
    }

    @Override
    public boolean isPrimaryKey() {
        return primaryKey;
    }
    
    @Override
    public boolean isAlternateKey() {
        return alternateKey;
    }

    @Override
    public boolean isNonUniqueIndex() {
        return !isPrimaryKey() && !isAlternateKey();
    }
    
    @Override
    public Boolean isControlFlowEnabled() {
        return constraint.isControlFlowEnabled();
    }

    @Override
    public Boolean isControlStaticEnabled() {
        return constraint.isControlStaticEnabled();
    }

    @Override
    public ConstraintScope getScope() {
        return constraint.getScope();
    }

    @Override
    public Boolean isDefinedInDatabase() {
        return constraint.isDefinedInDatabase();
    }

    @Override
    public Boolean isActive() {
        return constraint.isActive();
    }
    
    @Override
    public String getMessage() {
        return constraint.getMessage();
    }

    @Override
    public Expr getCondition() {
        return null;
    }
        
}
