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

import org.pecheasoft.odigen.sql.api.ast.IDatastoreAttribute;
import org.pecheasoft.odigen.sql.api.ast.IDatastoreReference;
import org.pecheasoft.odigen.sql.api.ast.ISelectItem;
import org.pecheasoft.odigen.sql.api.ast.ITargetAttribute;
import org.pecheasoft.odigen.sql.util.annotation.impl.AnnotatedObject;

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
public class TargetColumn extends AnnotatedObject implements ITargetAttribute {

    private final String name;
    private final Integer position;
    private ISelectItem expression;
    
    @JsonProperty("Metadata")
    private final IDatastoreAttribute metadata;

    public TargetColumn(String name, Integer position, IDatastoreAttribute columnMetadata, IDatastoreReference table) {
        this.name = name;
        this.position = position;
        this.metadata = columnMetadata;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getPosition() {
        return position;
    }

    @Override
    public ISelectItem getExpression() {
        return expression;
    }

    public void setExpression(ISelectItem expression) {
        this.expression = expression;
    }       

    @JsonIgnore
    @Override
    public String getDataType() {        
        return metadata.getDataType();
    }

    @JsonIgnore
    @Override
    public Integer getLength() {
        return metadata.getLength();
    }

    @JsonIgnore
    @Override
    public Integer getPrecision() {
        return metadata.getPrecision();
    }

    @JsonIgnore
    @Override
    public Integer getScale() {
        return metadata.getScale();
    }

    @JsonIgnore
    @Override
    public boolean getIsMandatory() {
        return metadata.getIsMandatory();
    }

    @JsonIgnore
    @Override
    public boolean getIsPrimaryKey() {
        return metadata.getIsPrimaryKey();
    }

    @JsonIgnore
    @Override
    public String getDDLDataType() {
        return metadata.getDDLDataType();
    }

    @JsonIgnore
    @Override
    public String getFormat() {
        return metadata.getFormat();
    }

    @JsonIgnore
    @Override
    public String getScdBehavior() {
        return metadata.getScdBehavior();
    }

    @JsonIgnore
    @Override
    public String getDescription() {
        return metadata.getDescription();
    }

    @Override
    public String getDefaultValue() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
