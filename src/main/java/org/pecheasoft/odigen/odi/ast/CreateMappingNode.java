package org.pecheasoft.odigen.odi.ast;

import java.util.HashMap;
import java.util.List;

import org.pecheasoft.odigen.odi.util.MappingPropertyType;

/**
 *
 * @author Adi Neagu
 */
public class CreateMappingNode extends UnaryNode {

    private String projectName;
    private String folderName;
    private String mappingName;
    private String qualifiedName;
    private boolean ifNotExist;        
    private boolean replace;
    private HashMap<MappingPropertyType, String> properties;
    private LogicalNode targetTable;
    private String stagingLocation;    
    private List<PhysicalDesignNode> physicalDesigns;

    private CreateMappingNode(int pid) {
        super(pid, NodeType.CREATE_MAPPING);
    }

    private CreateMappingNode(String projectName, String mappingName) {
        super(0, NodeType.CREATE_MAPPING);

        this.projectName = projectName;
        this.mappingName = mappingName;
    }

    public static CreateMappingNode builder() {
        return new CreateMappingNode(0);
    }

    public static CreateMappingNode builderWithSubfolders(String projectName, String mappingName) {
        return new CreateMappingNode(projectName, mappingName);
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

    public LogicalNode getTargetTable() {
        return targetTable;
    }

    public void setTargetTable(LogicalNode targetTable) {
        this.targetTable = targetTable;
    }

    public List<PhysicalDesignNode> getPhysicalDesigns() {
        return physicalDesigns;
    }

    public void setPhysicalDesigns(List<PhysicalDesignNode> physicalDesigns) {
        this.physicalDesigns = physicalDesigns;
    }

    public String getStagingLocation() {
        return stagingLocation;
    }

    public void setStagingLocation(String stagingLocation) {
        this.stagingLocation = stagingLocation;
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
