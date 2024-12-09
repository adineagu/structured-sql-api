/*
 * Copyright 2018 DWH Tools.
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
import org.pecheasoft.odigen.sql.util.CatalogConstants;
import org.pecheasoft.odigen.sql.util.TUtil;
import org.pecheasoft.odigen.sql.util.annotation.impl.AnnotatedObject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 *
 * @author Adi Neagu
 */

@JsonPropertyOrder({
    "className",
    "name", 
    "dataType", 
    "length", 
    "position", 
    "precision", 
    "scale", 
    "isMandatory", 
    "format", 
    "scdBehavior",
    "description"
    }
)
@JsonInclude(Include.NON_NULL)
public class DatastoreAttribute extends AnnotatedObject implements IDatastoreAttribute {

    private String name;
    private String dataType;
    private Integer length;
    private Integer position;
    private Integer precision;
    private Integer scale;
    private boolean isMandatory;
    private boolean isPrimaryKey;
    private String format;
    private String scdBehavior;
    private String defaultValue;
    private String description;

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @Override
    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    @Override
    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public Integer getPrecision() {
        return precision;
    }

    public void setPrecision(Integer precision) {
        this.precision = precision;
    }

    @Override
    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    @Override
    public boolean getIsMandatory() {
        return isMandatory;
    }

    public void setIsMandatory(boolean isMandatory) {
        this.isMandatory = isMandatory;
    }

    @Override
    public boolean getIsPrimaryKey() {
        return isPrimaryKey;
    }

    public void setIsPrimaryKey(boolean isPrimaryKey) {
        this.isPrimaryKey = isPrimaryKey;
    }

    @Override
    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String getScdBehavior() {
        return scdBehavior;
    }

    public void setScdBehavior(String scdBehavior) {
        this.scdBehavior = scdBehavior;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        String vRet = (getPosition() == 1 ? " " : ",") + getName();
        vRet = vRet + "\t" + getDDLDataType();
        if (isMandatory) {
            vRet = vRet + "\t" + "NOT NULL";
        }
        if (!TUtil.isNullOrEmpty(getFormat())) {
            vRet = vRet + " FORMAT " + CatalogConstants.IDENTIFIER_SINGLEQUOTE_STRING + getFormat() + CatalogConstants.IDENTIFIER_SINGLEQUOTE_STRING;
        }

        if (!TUtil.isNullOrEmpty(getScdBehavior())) {
            vRet = vRet + "\t" + getScdBehavior();
        }

        return vRet;
    }

}
