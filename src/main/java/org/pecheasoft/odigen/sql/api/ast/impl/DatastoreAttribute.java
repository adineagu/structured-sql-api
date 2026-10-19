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

import org.pecheasoft.odigen.sql.api.ast.SemanticAnnotationSet;
import org.pecheasoft.odigen.sql.api.ast.SemanticModel;
import org.pecheasoft.odigen.sql.util.CatalogConstants;
import org.pecheasoft.odigen.sql.util.TUtil;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.commons.lang3.StringUtils;


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
public class DatastoreAttribute implements SemanticModel {

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
    private SemanticAnnotationSet annotations;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getPrecision() {
        return precision;
    }

    public void setPrecision(Integer precision) {
        this.precision = precision;
    }

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    public boolean getIsMandatory() {
        return isMandatory;
    }

    public void setIsMandatory(boolean isMandatory) {
        this.isMandatory = isMandatory;
    }

    public boolean getIsPrimaryKey() {
        return isPrimaryKey;
    }

    public void setIsPrimaryKey(boolean isPrimaryKey) {
        this.isPrimaryKey = isPrimaryKey;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getScdBehavior() {
        return scdBehavior;
    }

    public void setScdBehavior(String scdBehavior) {
        this.scdBehavior = scdBehavior;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

    public String getDDLDataType() {
        String vRet;

        String dataType = TUtil.encloseNonReservedWordsIfRequired(getDataType().trim());
        
        if (getPrecision() != null && !getPrecision().equals(0)) {
            vRet = dataType.concat("(").concat(getPrecision().toString());
            if (getScale() != null && !getScale().equals(0)) {
                vRet = vRet.concat(",").concat(getScale().toString());
            }
            vRet = vRet.concat(")");
        } else if (getLength() != null && !getLength().equals(0)) {
            vRet = dataType.concat("(").concat(getLength().toString()).concat(")");
        } else {
            vRet = dataType;
        }

        return vRet;
    }

    public String toSql() {
        String vRet = getName();
        vRet = vRet + " " + getDDLDataType();
        if (getIsMandatory()) {
            vRet = vRet + " " + "NOT NULL";
        }
        if (StringUtils.isNotEmpty(getFormat())) {
            vRet = vRet + " FORMAT " + "'" + getFormat() + "'";
        }

        if (StringUtils.isNotEmpty(getScdBehavior())) {
            vRet = vRet + " " + getScdBehavior();
        }

        return vRet;
    }

    @Override
    public SemanticAnnotationSet annotations() {
        return annotations;
    }

    public void setAnnotations(SemanticAnnotationSet annotations) {
        this.annotations = annotations;
    }   

}
