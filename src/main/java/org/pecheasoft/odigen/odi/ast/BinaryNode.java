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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.Objects;

@JsonInclude(Include.NON_NULL)
public class BinaryNode extends LogicalNode {

    LogicalNode leftChild = null;
    LogicalNode rightChild = null;

    public BinaryNode(NodeType compType) {
        super(compType);
    }

    public BinaryNode(int pid, NodeType nodeType) {
        super(pid, nodeType);
    }

    @Override
    public int childNum() {
        return 2;
    }

    @Override
    public LogicalNode getChild(int idx) {
        switch (idx) {
            case 0 -> {
                return leftChild;
            }
            case 1 -> {
                return rightChild;
            }
            default -> throw new ArrayIndexOutOfBoundsException(idx);
        }
    }

    @Override
    public void setChild(int idx, LogicalNode node) {
        switch (idx) {
            case 0 -> leftChild = node;
            case 1 -> rightChild = node;
            default -> throw new ArrayIndexOutOfBoundsException(idx);
        }
    }
    
    @SuppressWarnings("unchecked")
    public <T extends LogicalNode> T getLeftChild() {
        return (T) this.leftChild;
    }

    public void setLeftChild(LogicalNode op) {
        this.leftChild = op;
    }

    @SuppressWarnings("unchecked")
    public <T extends LogicalNode> T getRightChild() {
        return (T) this.rightChild;
    }

    public void setRightChild(LogicalNode op) {
        this.rightChild = op;
    }

    @Override
    public void preOrder(LogicalNodeVisitor visitor) {
        visitor.visit(this);
        leftChild.preOrder(visitor);
        rightChild.preOrder(visitor);
    }

    @Override
    public void postOrder(LogicalNodeVisitor visitor) {
        leftChild.postOrder(visitor);
        rightChild.postOrder(visitor);
        visitor.visit(this);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.leftChild, this.rightChild);
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
        final BinaryNode other = (BinaryNode) obj;
        if (!java.util.Objects.equals(this.leftChild, other.leftChild)) {
            return false;
        }
        return true;
    }

}
