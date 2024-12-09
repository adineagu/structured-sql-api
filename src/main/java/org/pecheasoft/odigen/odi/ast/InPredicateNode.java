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
import java.util.List;

import org.pecheasoft.odigen.sql.util.TUtil;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)

public class InPredicateNode extends BinaryNode implements Projectable, MappingComponent {
    
    public enum Role {
        EXISTS,
        NOT_EXISTS,
        EQUAL,
        UNEQUAL,
        XOR,
        IN,
        NOT_IN,
        XOR_BEFORE_EQUAL,
        LESS_OR_GREATER,
        GREATER,
        LESS,
        EQUAL_OR_GREATER,
        EQUAL_OR_LESS
    }

    private boolean not;
    private Role role;
    private String operator;
    private String quantifier;
    private Collection<Attribute> attributes;
    private Collection<Attribute> drivingAttributes = TUtil.newList();
    private Collection<Attribute> filterAttributes = TUtil.newList();
    private String subQryFilterCondition;

    public InPredicateNode() {
        super(NodeType.IN_PREDICATE);
    }

    public InPredicateNode(NodeType nodeType) {
        super(nodeType);
    }
    
    @Override
    public Collection<Attribute> getAttributes() {
        return attributes;
    }

    @Override
    public void setAttributes(Collection<Attribute> attributes) {
        this.attributes = attributes;
    }

    public Collection<Attribute> getDrivingAttributes() {
        return drivingAttributes;
    }

    public void setDrivingAttributes(List<Attribute> drivingAttributes) {
        this.drivingAttributes = drivingAttributes;
    }

    public Collection<Attribute> getFilterAttributes() {
        return filterAttributes;
    }

    public void setFilterAttributes(List<Attribute> filterAttributes) {
        this.filterAttributes = filterAttributes;
    }

    public boolean isNot() {
        return not;
    }

    public void setNot(boolean not) {
        this.not = not;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator.toUpperCase();
    }

    public String getQuantifier() {
        return quantifier;
    }

    public void setQuantifier(String quantifier) {
        this.quantifier = quantifier.toUpperCase();
    }

    
    public String getSubQryFilterCondition() {
        return subQryFilterCondition;
    }

    public void setSubQryFilterCondition(String subQryFilterCondition) {
        this.subQryFilterCondition = subQryFilterCondition;
    }

}
