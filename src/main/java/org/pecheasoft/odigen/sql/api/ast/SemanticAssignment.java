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

    public SemanticAssignment(String name, Integer position, DatastoreAttribute columnMetadata, DatastoreReferenceNode table) {
        this.name = name;
        this.position = position;
        this.metadata = columnMetadata;
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

    public DatastoreAttribute getMetadata() {
        return metadata;
    }

    @JsonIgnore
    public String getDataType() {        
        return metadata.getDataType();
    }

    @JsonIgnore
    public Integer getLength() {
        return metadata.getLength();
    }

    @JsonIgnore
    public Integer getPrecision() {
        return metadata.getPrecision();
    }

    @JsonIgnore
    public Integer getScale() {
        return metadata.getScale();
    }

    @JsonIgnore
    public boolean getIsMandatory() {
        return metadata.getIsMandatory();
    }

    @JsonIgnore
    public boolean getIsPrimaryKey() {
        return metadata.getIsPrimaryKey();
    }

    @JsonIgnore
    public String getDDLDataType() {
        return metadata.getDDLDataType();
    }

    @JsonIgnore
    public String getFormat() {
        return metadata.getFormat();
    }

    @JsonIgnore
    public String getScdBehavior() {
        return metadata.getScdBehavior();
    }

    @JsonIgnore
    public String getDescription() {
        return metadata.getDescription();
    }

    public String getDefaultValue() {
        return metadata != null ? metadata.getDefaultValue().toString() : null;
    }

}
