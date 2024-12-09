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

import java.util.List;
import org.pecheasoft.odigen.sql.util.TUtil;

/**
 *
 * @author Adi Neagu
 */
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)

public class MultiaryNode extends LogicalNode {

    private List<LogicalNode> children;
    
    public MultiaryNode(NodeType compType) {
        super(compType);
        this.children = TUtil.newList();
    }

    public List<LogicalNode> getChildren() {
        return children;
    }

    public void setChildren(List<LogicalNode> children) {
        this.children = children;
    }        
    
    @Override
    public int childNum() {
        return children.size();
    }

    @Override
    public LogicalNode getChild(int idx) {
        return children.get(idx);
    }

    @Override
    public void setChild(int idx, LogicalNode node) {
        children.set(idx, node);
    }
   
    @Override
    public void preOrder(LogicalNodeVisitor visitor) {
        visitor.visit(this);
        children.forEach((child) -> {
            child.preOrder(visitor);
        });        
    }

    @Override
    public void postOrder(LogicalNodeVisitor visitor) {
        children.forEach((child) -> {
            child.postOrder(visitor);
        });
        visitor.visit(this);
    }    
}
