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

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Adi Neagu
 */
public interface IDatastore extends IASTObject {
    
    /**
     * Get the non-qualified name of the datastore. For example, for <b>HR.EMPLOYEES</b> datastore, this method will return <b>EMPLOYEES</b> string value.
     * 
     * @return String
     */  
    @JsonIgnore
    String getBasename();

    /**
     * Get the qualifier of the datastore. For example for <b>HR.EMPLOYEES</b> datastore, this method will return <b>HR</b> string value.
     * @return String
     */ 
    @JsonIgnore    
    String getQualifier();
    
    @JsonIgnore    
    String getDescription();  
        
    /**
     * Get a list containing all datastore attributes.
     * 
     * @return 
     */
    @JsonProperty    
    Collection<IDatastoreAttribute> getAttributes();
    
    /**
     * Return information for the attribute indicated by method's parameter.
     * 
     * @param attributeName
     * @return IDatastoreAttribute
     */
    @JsonIgnore
    IDatastoreAttribute getAttribute(String attributeName);
    
    /**
     * Get a list containing all datastore attributes according to a given condition .
     * 
     * @param condition
     * @return 
     */ 
    @JsonIgnore
    Collection<IDatastoreAttribute> getAttributes(String condition);    
    
    @JsonProperty
    Collection<IDatastoreKey> getKeys();

    @JsonProperty
    Collection<IDatastoreCondition> getConditions();
    
    void copyProperties(IDatastore source);

}
