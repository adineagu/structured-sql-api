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
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
 
@JsonInclude(Include.NON_NULL)

public class UnionNode extends MultiaryNode implements Projectable, MappingComponent {

    private SetOperatorType operatorType;
    private boolean isDistinct;
    private Map<Integer, List<Attribute>> attributes = new HashMap<>();
    private Map<Integer, SetOperatorType> operators = new HashMap<>();
    
    public UnionNode() {
        super(NodeType.UNION);
        this.isDistinct = false;
    }

    public SetOperatorType getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(SetOperatorType operatorType) {
        this.operatorType = operatorType;
    }

    public boolean isIsDistinct() {
        return isDistinct;
    }

    public void setIsDistinct(boolean isDistinct) {
        this.isDistinct = isDistinct;
    }

    @Override
    public List<Attribute> getAttributes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAttributes(Collection<Attribute> attributes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Map<Integer, SetOperatorType> getOperators() {
        return operators;
    }

    public void setOperators(Map<Integer, SetOperatorType> operators) {
        this.operators = operators;
    }
        
    public static enum SetOperatorType {
        EXCEPT, EXCEPT_ALL, INTERSECT, INTERSECT_ALL, UNION, UNION_ALL, MINUS, MINUS_ALL
    }

    public static UnionNode build(String operationType) {
        UnionNode set = new UnionNode();
        SetOperatorType type = null;

        switch (operationType) {
            case "EXCEPT" -> type = SetOperatorType.EXCEPT;
            case "EXCEPT ALL" -> type = SetOperatorType.EXCEPT_ALL;
            case "INTERSECT" -> type = SetOperatorType.INTERSECT;
            case "INTERSECT_ALL" -> type = SetOperatorType.INTERSECT_ALL;
            case "INTERSECT DISTINCT" -> {
                type = SetOperatorType.INTERSECT;
                set.setIsDistinct(true);
            }
            case "UNION" -> type = SetOperatorType.UNION;
            case "UNION_ALL" -> type = SetOperatorType.UNION_ALL;
            case "UNION DISTINCT" -> {
                type = SetOperatorType.UNION;
                set.setIsDistinct(true);
            }
            case "MINUS" -> type = SetOperatorType.MINUS;
            case "MINUS_ALL" -> type = SetOperatorType.MINUS_ALL;
            case "MINUS DISTINCT" -> {
                type = SetOperatorType.MINUS;
                set.setIsDistinct(true);
            }
        }

        set.setOperatorType(type);

        return set;
    }

    public List<Attribute> getAttributes(Integer i) {
        return attributes.get(i);
    }

    public Map<Integer, List<Attribute>> getSetAttributes() {
        return attributes;
    }

    public void setAttributes(Map<Integer, List<Attribute>> attributes) {
        this.attributes = attributes;
    }

    public void setAttributes(Integer i, List<Attribute> attr) {
        this.attributes.put(i, attr);
    }

    public Map<String, List<String>> getAttributesExpressionsMap() {
        Map<String, List<String>> map = new LinkedHashMap<>();

        attributes.keySet().forEach((i) -> {
            attributes.get(i).forEach((attr) -> {
                String expression;
                String name;
                switch (attr) {
                    case ColumnAttribute columnAttribute -> {
                        name = columnAttribute.getName();
                        expression = columnAttribute.getQualifier() + "." + columnAttribute.getName();
                    }
                    case ExpressionAttribute expressionAttribute -> {
                        name = expressionAttribute.getName();
                        expression = expressionAttribute.getExpression();
                    }
                    default -> throw new RuntimeException("Unhandled attribute type " + attr.getAttrType());
                }

                if (!map.containsKey(name)) {
                    map.put(name, new ArrayList<>());
                }

                map.get(name).add(expression);
            });
        });

        return map;
    }
}
