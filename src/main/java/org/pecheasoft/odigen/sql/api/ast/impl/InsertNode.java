/*
 * Copyright 2017 DWH Tools.
 *
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.odieasy.com/11-licenses/eula
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
