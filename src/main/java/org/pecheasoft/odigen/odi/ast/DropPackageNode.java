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
public class DropPackageNode extends LogicalNode {

    private final String qualifiedName;
    private final boolean dropIfExists;

    public DropPackageNode(String qualifiedName, boolean dropIfExists) {
        super(NodeType.DROP_PACKAGE);
        this.qualifiedName = qualifiedName;
        this.dropIfExists = dropIfExists;
    }

    public boolean isDropIfExists() {
        return dropIfExists;
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

    public String getQualifiedName() {
        return qualifiedName;
    }

}
