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

import java.util.Map;

import org.pecheasoft.odigen.sql.util.TUtil;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.pecheasoft.odigen.odi.parse.algebra.PhysicalDesign;

/**
 *
 * @author Adi Neagu
 */
@JsonInclude(Include.NON_NULL)
public class PhysicalDesignNode extends LogicalNode {
    private String description;
    private String stagingLocation;
    private String optimContext;
    private boolean removeTempObj;
    private boolean useUniqueTempNames;
    private final Map<String, KnowledgeModuleNode> technologyXKMMap = TUtil.newHashMap();
    private final Map<String, KnowledgeModuleNode> sourceTableXKMMap = TUtil.newHashMap();    
    private final Map<String, KnowledgeModuleNode> technologyLKMMap = TUtil.newHashMap();
    private final Map<String, KnowledgeModuleNode> technologyIKMMap = TUtil.newHashMap();
    private final Map<String, KnowledgeModuleNode> targetTableIKMMap = TUtil.newHashMap();
    private final Map<String, KnowledgeModuleNode> technologyCKMMap = TUtil.newHashMap();
    private final Map<String, KnowledgeModuleNode> targetTableCKMMap = TUtil.newHashMap();
    private PhysicalDesign.MappingCommand beginMappingCommand;
    private PhysicalDesign.MappingCommand endMappingCommand;

    public PhysicalDesignNode() {
        super(NodeType.PHYSICAL_DESIGN);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOptimContext() {
        return optimContext;
    }

    public void setOptimContext(String optimContext) {
        this.optimContext = optimContext;
    }

    public String getStagingLocation() {
        return stagingLocation;
    }

    public void setStagingLocation(String stagingLocation) {
        this.stagingLocation = stagingLocation;
    }
    
    public boolean isRemoveTempObj() {
        return removeTempObj;
    }

    public void setRemoveTempObj(boolean removeTempObj) {
        this.removeTempObj = removeTempObj;
    }

    public boolean isUseUniqueTempNames() {
        return useUniqueTempNames;
    }

    public void setUseUniqueTempNames(boolean useUniqueTempNames) {
        this.useUniqueTempNames = useUniqueTempNames;
    }

    public Map<String, KnowledgeModuleNode> getTechnologyLKMMap() {
        return technologyLKMMap;
    }

    public Map<String, KnowledgeModuleNode> getTechnologyIKMMap() {
        return technologyIKMMap;
    }

    public Map<String, KnowledgeModuleNode> getTechnologyCKMMap() {
        return technologyCKMMap;
    }

    public Map<String, KnowledgeModuleNode> getTargetTableIKMMap() {
        return targetTableIKMMap;
    }

    public Map<String, KnowledgeModuleNode> getTargetTableCKMMap() {
        return targetTableCKMMap;
    }

    public Map<String, KnowledgeModuleNode> getTechnologyXKMMap() {
        return technologyXKMMap;
    }

    public Map<String, KnowledgeModuleNode> getSourceTableXKMMap() {
        return sourceTableXKMMap;
    }
    
    public KnowledgeModuleNode addTechnologyCKM(String k, KnowledgeModuleNode v) {
        return technologyCKMMap.put(k, v);
    }

    public KnowledgeModuleNode addTargetTableCKM(String k, KnowledgeModuleNode v) {
        return targetTableCKMMap.put(k, v);
    }
    
    public KnowledgeModuleNode addTechnologyIKM(String k, KnowledgeModuleNode v) {
        return technologyIKMMap.put(k, v);
    }
    
    public KnowledgeModuleNode addTargetTableIKM(String k, KnowledgeModuleNode v) {
        return targetTableIKMMap.put(k, v);
    }
    
    public KnowledgeModuleNode addTechnologyLKM(String k, KnowledgeModuleNode v) {
        return technologyLKMMap.put(k, v);
    }
    
    public KnowledgeModuleNode addTechnologyXKM(String k, KnowledgeModuleNode v) {
        return technologyXKMMap.put(k, v);
    }

    public KnowledgeModuleNode addSourceTableXKM(String k, KnowledgeModuleNode v) {
        return sourceTableXKMMap.put(k, v);
    }

    public PhysicalDesign.MappingCommand getBeginMappingCommand() {
        return beginMappingCommand;
    }

    public void setBeginMappingCommand(PhysicalDesign.MappingCommand beginMappingCommand) {
        this.beginMappingCommand = beginMappingCommand;
    }

    public PhysicalDesign.MappingCommand getEndMappingCommand() {
        return endMappingCommand;
    }

    public void setEndMappingCommand(PhysicalDesign.MappingCommand endMappingCommand) {
        this.endMappingCommand = endMappingCommand;
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
