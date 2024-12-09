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

import org.pecheasoft.odigen.sql.util.TUtil;

/**
 *
 * @author Adi Neagu
 */
public class ReusableMappingNode extends LogicalNode implements RelationNode {

    private String qualifiedName;
    private String projectName;
    private String[] folders;
    private String alias;

    public ReusableMappingNode() {
        super(NodeType.REUSABLE_MAPPING);
    }

    @Override
    public boolean hasAlias() {
        return TUtil.isNullOrEmpty(alias);
    }

    @Override
    public String getAlias() {
        return alias;
    }

    @Override
    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Override
    public String getTableName() {
        return super.getName();
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setFolders(String[] folders) {
        this.folders = folders;
    }

    @Override
    public String getCanonicalName() {
        return qualifiedName;
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

    public String getProjectName() {
        return projectName;
    }

    public String[] getFolders() {
        return folders;
    }

    @Override
    public void setCanonicalName(String qualifiedName) {
        this.qualifiedName = qualifiedName;
    }

}
