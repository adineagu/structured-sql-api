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

/**
 *
 * @author Adi Neagu
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class TableCheckConstraint extends Expr implements ITableConstraint {
    
    private final ITableConstraint constraint;
    private final Expr qual;
    private String qualText;

    public TableCheckConstraint(ITableConstraint constraint, Expr qual) {
        this.constraint = constraint;
        this.qual = qual;
    }

    @Override
    public String getConstraintName() {
        return constraint.getConstraintName();
    }

    @Override
    public ConstraintType getConstraintType() {
        return ConstraintType.CHECK_CONSTRAINT;
    }
    
    public OpType getType() {
        return OpType.TableCheckConstraint;
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
    public Expr getCondition() {
        return qual;
    }

    @Override
    public boolean isCheckConstraint() {
        return true;
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
    
    public String getQualText() {
        return qualText;
    }        

    public void setQualText(String qualText) {
        this.qualText = qualText;
    }

    @Override
    public String getConditionText() {
        return qualText;
    }
        
}
