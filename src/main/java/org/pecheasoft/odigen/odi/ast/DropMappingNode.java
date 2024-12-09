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
public class DropMappingNode extends LogicalNode {

    private String projectName;
    private String[] folders;
    private String mappingName;
    private String qualifiedName;
    private boolean reusable;
    private boolean dropIfExists;
    private boolean cascade;

    public DropMappingNode() {
        super(NodeType.DROP_MAPPING);
    }

    public static DropMappingNode builderWithSubfolders(String projectName, String[] folders, String mappingName) {
        return new DropMappingNode(projectName, folders, mappingName);
    }

    private DropMappingNode(String projectName, String[] folders, String mappingName) {
        super(NodeType.DROP_MAPPING);
        this.projectName = projectName;
        this.folders = folders;
        this.mappingName = mappingName;
    }

    public boolean isDropIfExists() {
        return dropIfExists;
    }

    public void setDropIfExists(boolean dropIfExists) {
        this.dropIfExists = dropIfExists;
    }

    public boolean isCascade() {
        return cascade;
    }

    public void setCascade(boolean cascade) {
        this.cascade = cascade;
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

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String[] getFolders() {
        return folders;
    }

    public void setFolders(String[] folders) {
        this.folders = folders;
    }

    public String getMappingName() {
        return mappingName;
    }

    public void setMappingName(String mappingName) {
        this.mappingName = mappingName;
    }

    public String getQualifiedName() {
        return qualifiedName;
    }

    public void setQualifiedName(String qualifiedName) {
        this.qualifiedName = qualifiedName;
    }

    public boolean isReusable() {
        return reusable;
    }

    public void setReusable(boolean reusable) {
        this.reusable = reusable;
    }

}
