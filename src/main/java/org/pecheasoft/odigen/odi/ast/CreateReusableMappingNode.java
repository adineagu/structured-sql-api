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
import java.util.HashMap;

import org.pecheasoft.odigen.odi.util.MappingPropertyType;

/**
 *
 * @author Adi Neagu
 */
public class CreateReusableMappingNode extends UnaryNode {

    private String projectName;
    private String folderName;
    private String[] folders;
    private String mappingName;
    private String qualifiedName;
    private boolean ifNotExist;
    private boolean replace;
    private HashMap<MappingPropertyType, String> properties;
    private LogicalNode outputSignature;
    private ArrayList<PhysicalDesignNode> physicalDesigns;

    private CreateReusableMappingNode(int pid) {
        super(pid, NodeType.CREATE_REUSABLE_MAPPING);
    }

    private CreateReusableMappingNode(String projectName, String folderName, String mappingName) {
        super(0, NodeType.CREATE_REUSABLE_MAPPING);

        this.projectName = projectName;
        this.folderName = folderName;
        this.mappingName = mappingName;
    }

    private CreateReusableMappingNode(String projectName, String[] folders, String mappingName) {
        super(0, NodeType.CREATE_REUSABLE_MAPPING);

        this.projectName = projectName;
        this.folders = folders;
        this.mappingName = mappingName;
    }

    public static CreateReusableMappingNode builder() {
        return new CreateReusableMappingNode(0);
    }

    public static CreateReusableMappingNode builderWithoutSubfolders(String projectName, String folderName, String mappingName) {
        return new CreateReusableMappingNode(projectName, folderName, mappingName);
    }

    public static CreateReusableMappingNode builderWithSubfolders(String projectName, String[] folders, String mappingName) {
        return new CreateReusableMappingNode(projectName, folders, mappingName);
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public String getMappingName() {
        return mappingName;
    }

    public void setMappingName(String mappingName) {
        this.mappingName = mappingName;
    }

    public HashMap<MappingPropertyType, String> getProperties() {
        return properties;
    }

    public void setProperties(HashMap<MappingPropertyType, String> properties) {
        this.properties = properties;
    }

    public LogicalNode getOutputSignature() {
        return outputSignature;
    }

    public void setOutputSignature(LogicalNode outputSignature) {
        this.outputSignature = outputSignature;
    }

    /*
    public String toSQL() throws PlanExecutionException {
        LogicalPlan2SQL sql = new LogicalPlan2SQL();
        return sql.getSQL(this);
    }*/
    public ArrayList<PhysicalDesignNode> getPhysicalDesigns() {
        return physicalDesigns;
    }

    public void setPhysicalDesigns(ArrayList<PhysicalDesignNode> physicalDesigns) {
        this.physicalDesigns = physicalDesigns;
    }

    public String[] getFolders() {
        return folders;
    }

    public void setFolders(String[] folders) {
        this.folders = folders;
    }

    public String getQualifiedName() {
        return qualifiedName;
    }

    public void setQualifiedName(String qualifiedName) {
        this.qualifiedName = qualifiedName;
    }

    public boolean isReplace() {
        return replace;
    }

    public void setReplace(boolean replace) {
        this.replace = replace;
    }

    public boolean isIfNotExist() {
        return ifNotExist;
    }

    public void setIfNotExist(boolean ifNotExist) {
        this.ifNotExist = ifNotExist;
    }
}
