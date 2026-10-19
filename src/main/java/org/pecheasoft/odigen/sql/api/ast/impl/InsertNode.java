/*
 * Copyright 2017 DWH Tools.
 * SPDX-License-Identifier: GPL-3.0-only
 *
 * This file is part of SQLMorph.
 *
 * SQLMorph is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 3 of the License.
 *
 * SQLMorph is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with SQLMorph. If not, see <https://www.gnu.org/licenses/>.
 */
package org.pecheasoft.odigen.sql.api.ast.impl;

import java.util.List;

import org.pecheasoft.odigen.sql.api.ast.SemanticSetQueryBlock;
import org.pecheasoft.odigen.sql.api.ast.SemanticAnnotationSet;
import org.pecheasoft.odigen.sql.api.ast.SemanticAssignment;
import org.pecheasoft.odigen.sql.api.ast.SemanticModel;
import org.pecheasoft.odigen.sql.api.ast.SemanticQueryBlock;
import org.pecheasoft.odigen.sql.util.TUtil;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Adi Neagu
 */

@JsonInclude(Include.NON_NULL)
public class InsertNode implements SemanticModel {
        
    private DatastoreReferenceNode target;
    List<MultiInsertTableNode> multiInsertTargets;
    private SemanticQueryBlock query;
    private List<SemanticAssignment> columns;
    private SemanticAnnotationSet annotations;
    private String integrationType;
    private String updateKey;
    private Integer rejectLimit;
    private String rejectLimitUnit;

    public String getIntegrationType() { return integrationType; }
    public void setIntegrationType(String value) { integrationType = value; }
    public String getUpdateKey() { return updateKey; }
    public void setUpdateKey(String value) { updateKey = value; }
    public Integer getRejectLimit() { return rejectLimit; }
    public void setRejectLimit(Integer value) { rejectLimit = value; }
    public String getRejectLimitUnit() { return rejectLimitUnit; }
    public void setRejectLimitUnit(String value) { rejectLimitUnit = value; }

    public InsertNode() {
    }
    
    public InsertNode(DatastoreReferenceNode targetTable, List<SemanticAssignment> columns) {
        this.target = targetTable;
        this.columns = columns;
    }

    @JsonProperty("Table")
    public DatastoreReferenceNode getTarget() {
        return target;
    }

    /** Returns a collection copy with shared assignments, or null when there are no columns. */
    @JsonProperty("ColumnList")
    public List<SemanticAssignment> getColumns() {

        if (!TUtil.isNullOrEmpty(columns)) {
            return new ColumnsList<>(columns);
        } else {
            return null;
        }
    }
    
    public void setTargetTable(DatastoreReferenceNode table) {
        target = table;
    }

    public void setColumns(List<SemanticAssignment> columns) {
        this.columns = columns;
    }

    public SemanticQueryBlock getQuery() {
        return query;
    }

    public void setQuery(SemanticQueryBlock query) {
        this.query = query;
    }

    public String getName() {
        return null;
    }

    public List<MultiInsertTableNode> getMultiInsertTargets() {
        return multiInsertTargets;
    }

    public void setMultiInsertTargets(List<MultiInsertTableNode> multiInsertTargets) {
        this.multiInsertTargets = multiInsertTargets;
    }
    
    @Override
    public SemanticAnnotationSet annotations() {
        return annotations;
    }

    public void setAnnotations(SemanticAnnotationSet annotations) {
        this.annotations = annotations;
    }

}
