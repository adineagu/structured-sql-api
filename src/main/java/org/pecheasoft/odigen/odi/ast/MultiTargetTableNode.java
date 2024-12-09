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

import java.util.ArrayList;
import java.util.List;
import org.pecheasoft.odigen.sql.util.TUtil;

/**
 *
 * @author Adi Neagu
 * 
 * A complex component which models the multi table insert
 * 
 */
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)

public class MultiTargetTableNode extends UnaryNode implements MappingComponent {

    private List<TargetTableNode> targetTables = TUtil.newList();
    private List<SelectorNode> conditions = TUtil.newList();
    
    public MultiTargetTableNode() {
        super(NodeType.MULTI_TARGET_TABLE);
    }
    
    public MultiTargetTableNode(int pid) {
        super(pid, NodeType.MULTI_TARGET_TABLE);
        this.targetTables = new ArrayList<>();
        this.conditions = new ArrayList<>();
    }

    public List<TargetTableNode> getTargetTables() {
        return targetTables;
    }

    public void setDatastores(ArrayList<TargetTableNode> datastores) {
        this.targetTables = datastores;
    }

    public List<SelectorNode> getConditions() {
        return conditions;
    }

    public void setConditions(ArrayList<SelectorNode> conditions) {
        this.conditions = conditions;
    }

    public boolean addDatasore(TargetTableNode e) {
        return targetTables.add(e);
    }

    public boolean addCondition(SelectorNode e) {
        return conditions.add(e);
    }
}
