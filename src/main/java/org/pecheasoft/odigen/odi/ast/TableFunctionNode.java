/*
 * Copyright 2018 DWH Tools.
 *
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.odieasy.com/11-licenses/eula
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.pecheasoft.odigen.odi.ast;

import java.util.List;
import org.pecheasoft.odigen.sql.util.TUtil;

/**
 *
 * @author Adi Neagu
 */

 import com.fasterxml.jackson.annotation.JsonInclude;
 import com.fasterxml.jackson.annotation.JsonInclude.Include;
 
 @JsonInclude(Include.NON_NULL)

public class TableFunctionNode extends MultiaryNode implements RelationNode, MappingComponent {

    public enum InputGroupType {
        SCALAR, REF_CURSOR
    }

    private String alias;
    List<InputAttributeGroup> inputAttributeGroups = TUtil.newList();
    List<Attribute> outAttributes;

    public TableFunctionNode(String alias) {
        super(NodeType.TABLE_FUNCTION);
        this.alias = alias;
    }

    @Override
    public boolean hasAlias() {
        return !TUtil.isNullOrEmpty(alias);
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
        return alias;
    }

    @Override
    public String getCanonicalName() {
        return alias;
    }

    @Override
    public void setCanonicalName(String name) {
        setAlias(name);
    }

    public List<InputAttributeGroup> getInputAttributeGroups() {
        return inputAttributeGroups;
    }

    public void setInputAttributeGroups(List<InputAttributeGroup> inputAttributeGroups) {
        this.inputAttributeGroups = inputAttributeGroups;
    }

    public List<Attribute> getOutAttributes() {
        return outAttributes;
    }

    public void setOutAttributes(List<Attribute> outAttributes) {
        this.outAttributes = outAttributes;
    }
    
    public void addAttributeGroup(InputAttributeGroup grp) {
        inputAttributeGroups.add(grp);
    }
    
    public void addInputAttribute(InputAttributeGroup grp, Attribute attr) {
        grp.addAttribute(attr);
    }
    

    @JsonInclude(Include.NON_NULL)
    public static class InputAttributeGroup {

        private final String name;
        private final InputGroupType parameterType;
        List<Attribute> attributes;

        public InputAttributeGroup(String name, InputGroupType parameterType) {
            this.name = name;
            this.parameterType = parameterType;
        }

        public String getName() {
            return name;
        }

        public InputGroupType getParameterType() {
            return parameterType;
        }

        public List<Attribute> getAttributes() {
            return attributes;
        }

        public void setAttributes(List<Attribute> attributes) {
            this.attributes = attributes;
        }
        
        public void addAttribute(Attribute attr) {
            this.attributes.add(attr);
        }
                
    }

}
