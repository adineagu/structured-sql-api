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
package org.pecheasoft.odigen.sql.api.ast;

import org.apache.commons.lang.StringUtils;
import org.pecheasoft.odigen.sql.util.TUtil;

/**
 *
 * @author Adi Neagu
 */
public interface IDatastoreAttribute extends IASTObject {

    
    /**
     * Return the position of the attribute.
     * @return 
     */       
    Integer getPosition();
    
    /**
     * Return the data type of the attribute.
     * @return 
     */        
    String getDataType();           // i.e. NUMBER, DATE, VARCHAR2
    
    /**
     * Return the length of the attribute.
     * @return 
     */            
    Integer getLength();
    
    /**
     * Return the precision of the attribute. 
     * @return 
     */              
    Integer getPrecision();
    
    /**
     * Return the scale of the attribute. 
     * @return 
     */         
    Integer getScale();    
    
    /**
     * Indicate whether this attribute is mandatory.
     * 
     * @return true is the attribute is mandatory, false otherwise
     */    
    boolean getIsMandatory();
        
    /**
     * Indicate whether this attribute is part of the primary key.
     * 
     * @return true is the attribute is part of the primary key, false otherwise
     */       
    boolean getIsPrimaryKey();

    /**
     * Get the default value of the attribute.
     * @return 
     */        
    String getDefaultValue();

    /**
     * Get a data type expression which can be used in a DDL command. For example NUMBER(5,2), DATE, VARCHAR2(20).
     * @return 
     */        
    default String getDDLDataType() {
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
        
    /**
     * Get the format specified in the input expression for this attribute.
     * @return 
     */       
    String getFormat();
    
    /**
     * Get the SCD behavior specified in the input expression for this attribute.
     * @return 
     */           
    String getScdBehavior();
    
    String getDescription();
    
    default String toSql() {
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
    
}
