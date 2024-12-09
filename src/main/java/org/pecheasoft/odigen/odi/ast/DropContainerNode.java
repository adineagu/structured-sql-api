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
public class DropContainerNode extends LogicalNode {

    private final String qualifiedCode;
    private boolean ifExists;
    private boolean cascade;
    
    private DropContainerNode(NodeType compType, final String code, final boolean ifExists, final boolean cascade) {
        super(compType);
        this.qualifiedCode = code;
        this.ifExists = ifExists;
        this.cascade = cascade;        
    }

    public static DropContainerNode newDropProject(final String code, final boolean ifExists, final boolean cascade) {
        return new DropContainerNode(NodeType.DROP_PROJECT, code, ifExists, cascade);
    }

    public static DropContainerNode newDropFolder(final String code, final boolean ifExists, final boolean cascade) {
        return new DropContainerNode(NodeType.DROP_FOLDER, code, ifExists, cascade);
    }
    
    public static DropContainerNode newDropModel(final String code, final boolean ifExists, final boolean cascade) {
        return new DropContainerNode(NodeType.DROP_MODEL, code, ifExists, cascade);
    }

    public static DropContainerNode newDropSubmodel(final String code, final boolean ifExists, final boolean cascade) {
        return new DropContainerNode(NodeType.DROP_SUBMODEL, code, ifExists, cascade);
    }
    
    public boolean isIfExists() {
        return ifExists;
    }

    public void setIfExists(boolean ifExists) {
        this.ifExists = ifExists;
    }

    public boolean isCascade() {
        return cascade;
    }

    public void setCascade(boolean cascade) {
        this.cascade = cascade;
    }

    public String getQualifiedCode() {
        return qualifiedCode;
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
