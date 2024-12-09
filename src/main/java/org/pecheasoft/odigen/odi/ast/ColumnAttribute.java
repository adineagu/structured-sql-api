/* 
 * Copyright 2017 DWH Tools.
 *
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://odieasy.com/11-licenses/eula
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.pecheasoft.odigen.odi.ast;

/**
 *
 * @author Adi Neagu
 */
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ColumnAttribute extends Attribute {

    private String qualifier;
    private Integer precisionOrLength;
    private Integer scale;
    private String dataType;
    private boolean mandatory;
    private Integer offset;
    private Integer physLength;
    private String format;
    private String decseparator;
    private String scdBehavior;
    private String description;

    public ColumnAttribute() {
        setAttrType(AttributeType.ColumnAttribute);
    }

    public String getQualifier() {
        return qualifier;
    }

    public void setQualifier(String qualifier) {
        this.qualifier = qualifier;
    }

    public String getQualifiedName() {
        if (qualifier != null && !qualifier.isEmpty()) {
            return qualifier + "." + getName();
        } else {
            return getName();
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((qualifier == null) ? 0 : qualifier.hashCode());
        result = prime * result + ((precisionOrLength == null) ? 0 : precisionOrLength.hashCode());
        result = prime * result + ((scale == null) ? 0 : scale.hashCode());
        result = prime * result + ((dataType == null) ? 0 : dataType.hashCode());
        result = prime * result + (mandatory ? 1231 : 1237);
        result = prime * result + ((offset == null) ? 0 : offset.hashCode());
        result = prime * result + ((physLength == null) ? 0 : physLength.hashCode());
        result = prime * result + ((format == null) ? 0 : format.hashCode());
        result = prime * result + ((decseparator == null) ? 0 : decseparator.hashCode());
        result = prime * result + ((scdBehavior == null) ? 0 : scdBehavior.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        ColumnAttribute other = (ColumnAttribute) obj;
        if (qualifier == null) {
            if (other.qualifier != null) {
                return false;
            }
        } else if (!qualifier.equals(other.qualifier)) {
            return false;
        }

        if (precisionOrLength == null) {
            if (other.precisionOrLength != null) {
                return false;
            }
        } else if (!precisionOrLength.equals(other.precisionOrLength)) {
            return false;
        }

        if (scale == null) {
            if (other.scale != null) {
                return false;
            }
        } else if (!scale.equals(other.scale)) {
            return false;
        }

        if (dataType == null) {
            if (other.dataType != null) {
                return false;
            }
        } else if (!dataType.equals(other.dataType)) {
            return false;
        }

        if (mandatory != other.mandatory) {
            return false;
        }

        if (offset == null) {
            if (other.offset != null) {
                return false;
            }
        } else if (!offset.equals(other.offset)) {
            return false;
        }

        if (physLength == null) {
            if (other.physLength != null) {
                return false;
            }
        } else if (!physLength.equals(other.physLength)) {
            return false;
        }

        if (format == null) {
            if (other.format != null) {
                return false;
            }
        } else if (!format.equals(other.format)) {
            return false;
        }

        if (decseparator == null) {
            if (other.decseparator != null) {
                return false;
            }
        } else if (!decseparator.equals(other.decseparator)) {
            return false;
        }

        if (scdBehavior == null) {
            if (other.scdBehavior != null) {
                return false;
            }
        } else if (!scdBehavior.equals(other.scdBehavior)) {
            return false;
        }

        if (description == null) {
            if (other.description != null) {
                return false;
            }
        } else if (!description.equals(other.description)) {
            return false;
        }

        return true;
    }

    public Integer getPrecisionOrLength() {
        return precisionOrLength;
    }

    public void setPrecisionOrLength(Integer precisionOrLength) {
        this.precisionOrLength = precisionOrLength;
    }

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }

    public Integer isOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getPhysLength() {
        return physLength;
    }

    public void setPhysLength(Integer physLength) {
        this.physLength = physLength;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getDecseparator() {
        return decseparator;
    }

    public void setDecseparator(String decseparator) {
        this.decseparator = decseparator;
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

}
