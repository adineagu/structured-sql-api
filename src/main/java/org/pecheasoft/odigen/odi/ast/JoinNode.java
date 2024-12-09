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

/**
 *
 * @author Adi Neagu
 */
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)

public class JoinNode extends BinaryNode implements MappingComponent {
    
    private String expression;
    private String joinType;
    private boolean natural;
    private String sourceOrderText;
    private Map<Integer, String> joinCondRelations;
    
    public JoinNode() {
        super(NodeType.JOIN);
    }  
    
    public JoinNode(NodeType nodeType) {
        super(nodeType);
    }            

    public String getJoinType() {
        return joinType;
    }

    public void setJoinType(String joinType) {
        this.joinType = joinType;
    }    

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public boolean isNatural() {
        return natural;
    }

    public void setNatural(boolean natural) {
        this.natural = natural;
    }

    public String getSourceOrderText() {
        return sourceOrderText;
    }

    public void setSourceOrderText(String sourceOrderText) {
        this.sourceOrderText = sourceOrderText;
    }

    public Map<Integer, String> getJoinCondRelations() {
        return joinCondRelations;
    }

    public void setJoinCondRelations(Map<Integer, String> joinCondRelations) {
        this.joinCondRelations = joinCondRelations;
    }

    @Override
    public void setName(String name) {
        super.setName(name); 
    }

}
