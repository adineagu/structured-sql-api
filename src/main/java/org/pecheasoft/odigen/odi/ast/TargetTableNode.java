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

public class TargetTableNode extends UnaryNode implements MappingComponent {

    private DatastoreNode datastore;    
    private String integrationType;
    private String updateKey;
    private Integer rejectLimit;    
    private String rejectLimitUnit;        
    
    public TargetTableNode() {
        super(NodeType.SINGLE_TARGET_TABLE);
    }

    public DatastoreNode getDatastore() {
        return datastore;
    }

    public void setDatastore(DatastoreNode datastore) {
        this.datastore = datastore;
    }

    public String getIntegrationType() {
        return integrationType;
    }

    public void setIntegrationType(String integrationType) {
        this.integrationType = integrationType;
    }

    public String getUpdateKey() {
        return updateKey;
    }

    public void setUpdateKey(String updateKey) {
        this.updateKey = updateKey;
    }

    public Integer getRejectLimit() {
        return rejectLimit;
    }

    public void setRejectLimit(Integer rejectLimit) {
        this.rejectLimit = rejectLimit;
    }

    public String getRejectLimitUnit() {
        return rejectLimitUnit;
    }

    public void setRejectLimitUnit(String rejectLimitUnit) {
        this.rejectLimitUnit = rejectLimitUnit;
    }
            
}
