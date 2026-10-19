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
package org.pecheasoft.odigen.sql.api.ast;

import org.pecheasoft.odigen.sql.api.ast.impl.DatastoreAttribute;
import org.pecheasoft.odigen.sql.api.ast.impl.DatastoreReferenceNode;
import org.pecheasoft.odigen.sql.api.ast.impl.SelectItem;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 *
 * @author Adi Neagu
 */

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"className", "Name", "Position", "AnnotationsList", "Metadata"})
public class SemanticAssignment implements SemanticModel {

    private final String name;
    private final Integer position;
    private SelectItem expression;
    private SemanticAnnotationSet annotations;
    
    @JsonProperty("Metadata")
    private final DatastoreAttribute metadata;
    @JsonIgnore
    private final DatastoreReferenceNode table;

    public SemanticAssignment(String name, Integer position, DatastoreAttribute columnMetadata, DatastoreReferenceNode table) {
        this.name = name;
        this.position = position;
        this.metadata = columnMetadata;
        this.table = table;
    }
    
    public String getName() {
        return name;
    }

    public SemanticAnnotationSet annotations() {
        return annotations;
    }

    public void setAnnotations(SemanticAnnotationSet annotations) {
        this.annotations = annotations;
    }

    public Integer getPosition() {
        return position;
    }

    public SelectItem getExpression() {
        return expression;
    }

    public void setExpression(SelectItem expression) {
        this.expression = expression;
    }       

    @JsonProperty("Metadata")
    public DatastoreAttribute getMetadata() {
        if (metadata != null) return metadata;
        return table != null && table.getDatastore() != null
                ? table.getDatastore().getAttribute(name) : null;
    }

    private DatastoreAttribute requireMetadata() {
        DatastoreAttribute resolved = getMetadata();
        if (resolved == null) {
            throw new IllegalStateException("Column metadata is unresolved for assignment '" + name
                    + "'. Supply datastore metadata before using metadata-dependent properties.");
        }
        return resolved;
    }

    @JsonIgnore
    public String getDataType() {        
        return requireMetadata().getDataType();
    }

    @JsonIgnore
    public Integer getLength() {
        return requireMetadata().getLength();
    }

    @JsonIgnore
    public Integer getPrecision() {
        return requireMetadata().getPrecision();
    }

    @JsonIgnore
    public Integer getScale() {
        return requireMetadata().getScale();
    }

    @JsonIgnore
    public boolean getIsMandatory() {
        return requireMetadata().getIsMandatory();
    }

    @JsonIgnore
    public boolean getIsPrimaryKey() {
        return requireMetadata().getIsPrimaryKey();
    }

    @JsonIgnore
    public String getDDLDataType() {
        return requireMetadata().getDDLDataType();
    }

    @JsonIgnore
    public String getFormat() {
        return requireMetadata().getFormat();
    }

    @JsonIgnore
    public String getScdBehavior() {
        return requireMetadata().getScdBehavior();
    }

    @JsonIgnore
    public String getDescription() {
        return requireMetadata().getDescription();
    }

    public String getDefaultValue() {
        DatastoreAttribute resolved = getMetadata();
        return resolved != null ? resolved.getDefaultValue() : null;
    }

}
