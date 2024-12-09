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


import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 *
 * @author Adi Neagu
 */
@JsonInclude(Include.NON_NULL)
public class AlterMappingNode extends LogicalNode {

    private String qualifiedName;
    private boolean ifExist;        
    private List<PhysicalDesignNode> physicalDesigns;
    private String comment;    
    Boolean reusable;
    
    public AlterMappingNode() {
        super(NodeType.ALTER_MAPPING);
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

    public void setQualifiedName(String qualifiedName) {
        this.qualifiedName = qualifiedName;
    }

    public boolean isIfExist() {
        return ifExist;
    }

    public void setIfExist(boolean ifExist) {
        this.ifExist = ifExist;
    }

    public List<PhysicalDesignNode> getPhysicalDesigns() {
        return physicalDesigns;
    }

    public void setPhysicalDesigns(List<PhysicalDesignNode> physicalDesigns) {
        this.physicalDesigns = physicalDesigns;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean isReusable() {
        return reusable;
    }

    public void setReusable(Boolean reusable) {
        this.reusable = reusable;
    }
    
}
