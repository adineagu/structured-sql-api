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
public class CreateContainerNode extends LogicalNode {

    private String qualifiedCode;
    private String componentName;
    private String logicalSchema;
    private String reverseContextCode;
    private boolean ifNotExists;

    private CreateContainerNode(NodeType compType) {
        super(compType);
    }

    public static CreateContainerNode newProjectWithCode(final String code) {
        CreateContainerNode project = new CreateContainerNode(NodeType.CREATE_PROJECT);
        project.setQualifiedCode(code);
        return project;
    }

    public static CreateContainerNode newProjectWithCodeAndName(final String code, final String name) {
        CreateContainerNode project = newProjectWithCode(code);
        project.setComponentName(name);
        return project;
    }

    public static CreateContainerNode newFolderWithName(final String name) {
        CreateContainerNode folder = new CreateContainerNode(NodeType.CREATE_FOLDER);
        folder.setComponentName(name);
        return folder;
    }

    public static CreateContainerNode newModelWithCode(final String code, final String logicalSchema, final String reverseContextCode) {
        CreateContainerNode model = new CreateContainerNode(NodeType.CREATE_MODEL);
        model.setQualifiedCode(code);
        model.setLogicalSchema(logicalSchema);
        model.setReverseContextCode(reverseContextCode);
        return model;
    }

    public static CreateContainerNode newModelWithCodeAndName(final String code, final String name, final String logicalSchema, final String reverseContextCode) {
        CreateContainerNode model = newModelWithCode(code, logicalSchema, reverseContextCode);
        model.setComponentName(name);
        return model;
    }

    public static CreateContainerNode newSubmodelWithCode(final String code) {
        CreateContainerNode model = new CreateContainerNode(NodeType.CREATE_SUBMODEL);
        model.setQualifiedCode(code);
        return model;
    }

    public static CreateContainerNode newSubmodelWithCodeAndName(final String code, final String name) {
        CreateContainerNode model = newSubmodelWithCode(code);
        model.setComponentName(name);
        return model;
    }

    public boolean isIfNotExists() {
        return ifNotExists;
    }

    public void setIfNotExists(boolean ifNotExists) {
        this.ifNotExists = ifNotExists;
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

    public String getQualifiedCode() {
        return qualifiedCode;
    }

    public void setQualifiedCode(String qualifiedCode) {
        this.qualifiedCode = qualifiedCode;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String qualifiedName) {
        this.componentName = qualifiedName;
    }

    public String getLogicalSchema() {
        return logicalSchema;
    }

    public void setLogicalSchema(String logicalSchema) {
        this.logicalSchema = logicalSchema;
    }

    public String getReverseContextCode() {
        return reverseContextCode;
    }

    public void setReverseContextCode(String reverseContextCode) {
        this.reverseContextCode = reverseContextCode;
    }

}
