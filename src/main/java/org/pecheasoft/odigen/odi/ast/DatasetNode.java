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

 import com.fasterxml.jackson.annotation.JsonInclude;
 import com.fasterxml.jackson.annotation.JsonInclude.Include;
 
 @JsonInclude(Include.NON_NULL)
 
 public class DatasetNode extends LogicalNode implements MappingComponent {
    
    List<LogicalNode> datastores = new ArrayList<>();
    List<LogicalNode> reusablemaps = new ArrayList<>();
    List<LogicalNode> joins = new ArrayList<>();            
    List<LogicalNode> filters = new ArrayList<>();            
    
    public DatasetNode() {
        super(NodeType.DATASET);
    }
    
    public static DatasetNode build() {
        return new DatasetNode();
    }
    
    public boolean addDatastore(LogicalNode e) {
        return datastores.add(e);
    }

    public boolean addJoin(LogicalNode e) {
        return joins.add(e);
    }

    public boolean addFilter(LogicalNode e) {
        return filters.add(e);
    }

    public boolean addReusableMap(LogicalNode e) {
        return reusablemaps.add(e);
    }

    public List<LogicalNode> getDatastores() {
        return datastores;
    }

    public List<LogicalNode> getReusablemaps() {
        return reusablemaps;
    }

    public List<LogicalNode> getJoins() {
        return joins;
    }

    public List<LogicalNode> getFilters() {
        return filters;
    }

    @Override
    public int childNum() {
        return 0;
    }

    @Override
    public LogicalNode getChild(int idx) {
        return null;
    }

    @Override
    public void preOrder(LogicalNodeVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void postOrder(LogicalNodeVisitor visitor) {
        visitor.visit(this);
    }
}
