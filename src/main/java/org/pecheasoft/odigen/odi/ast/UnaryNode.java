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

public class UnaryNode extends LogicalNode {

    LogicalNode child;

    public UnaryNode(NodeType compType) {
        super(compType);
    }

    public UnaryNode(int nodeId, NodeType compType) {
        super(nodeId, compType);
    }
    
    @Override
    public int childNum() {
        return 1;
    }

    public void setChild(LogicalNode subNode) {
        this.child = subNode;
    }

    @SuppressWarnings("unchecked")
    public <T extends LogicalNode> T getChild() {
        return (T) this.child;
    }

    @Override
    public LogicalNode getChild(int idx) {
        if (idx == 0) {
            return child;
        } else {
            throw new ArrayIndexOutOfBoundsException(idx);
        }
    }

    @Override
    public void setChild(int idx, LogicalNode node) {
        if (idx == 0) {
            child = node;
        } else {
            throw new ArrayIndexOutOfBoundsException(idx);
        }
    }
    
    @Override
    public void preOrder(LogicalNodeVisitor visitor) {
        visitor.visit(this);
        child.preOrder(visitor);
    }

    @Override
    public void postOrder(LogicalNodeVisitor visitor) {
        child.postOrder(visitor);
        visitor.visit(this);
    }

}
