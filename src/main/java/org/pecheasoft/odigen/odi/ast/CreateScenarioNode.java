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


import java.util.Collection;

import org.pecheasoft.odigen.odi.parse.algebra.OdiScenarioStartVariable;

/**
 *
 * @author Adi Neagu
 */
public class CreateScenarioNode extends LogicalNode { 

    private String scenarioName;
    private String version;
    private String sourceObjectType;
    private String sourceObjectCanonicalName;
    private String physDesignName;    
    private boolean regenerate;
    private boolean scenExists;
    Collection<OdiScenarioStartVariable> startVariables;
    
    public CreateScenarioNode() {
        super(NodeType.CREATE_SCENARIO);
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

    public String getScenarioName() {
        return scenarioName;
    }

    public void setScenarioName(String scenarioName) {
        this.scenarioName = scenarioName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSourceObjectType() {
        return sourceObjectType;
    }

    public void setSourceObjectType(String sourceObjectType) {
        this.sourceObjectType = sourceObjectType;
    }

    public String getSourceObjectCanonicalName() {
        return sourceObjectCanonicalName;
    }

    public void setSourceObjectCanonicalName(String sourceObjectCanonicalName) {
        this.sourceObjectCanonicalName = sourceObjectCanonicalName;
    }

    public String getPhysDesignName() {
        return physDesignName;
    }

    public void setPhysDesignName(String physDesignName) {
        this.physDesignName = physDesignName;
    }
    
    public boolean isRegenerate() {
        return regenerate;
    }

    public void setRegenerate(boolean regenerate) {
        this.regenerate = regenerate;
    }

    public boolean isScenExists() {
        return scenExists;
    }

    public void setScenExists(boolean scenExists) {
        this.scenExists = scenExists;
    }

    public Collection<OdiScenarioStartVariable> getStartVariables() {
        return startVariables;
    }

    public void setStartVariables(Collection<OdiScenarioStartVariable> startVariables) {
        this.startVariables = startVariables;
    }

}
