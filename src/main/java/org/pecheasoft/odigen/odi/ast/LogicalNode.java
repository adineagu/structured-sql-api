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

import org.pecheasoft.odigen.sql.parse.algebra.Expr;
import org.pecheasoft.odigen.sql.util.annotation.Annotated;
import org.pecheasoft.odigen.sql.util.annotation.Annotation;
import org.pecheasoft.odigen.sql.util.annotation.impl.AnnotatedObject;

/**
 *
 * @author Adi Neagu
 */
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonInclude(Include.NON_NULL)

public abstract class LogicalNode implements Annotated {

    private int nodeId;
    private NodeType type;
    private String name;
    private NodeType compType;    
    private Expr expr;
    private Annotated annotated = new AnnotatedObject();

    protected LogicalNode(NodeType compType) {
        this.nodeId = 0;
        this.compType = compType;
        this.type = compType;
    }
    
    protected LogicalNode(int nodeId, NodeType compType) {
        this.nodeId = nodeId;
        this.compType = compType;
        this.type = compType;
    }

    public int getPID() {
        return nodeId;
    }

    public void setPID(int pid) {
        this.nodeId = pid;
    }

    public NodeType getType() {
        return this.type;
    }

    public void setType(NodeType type) {
        this.type = type;
    }

    public abstract int childNum();

    public abstract LogicalNode getChild(int idx);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getUniqueName() {
        return name;
    }

    public NodeType getComponentType() {
        return compType;
    }

    public NodeType getCompType() {
        return compType;
    }

    public void setCompType(NodeType compType) {
        this.compType = compType;
    }

    public Expr getExpr() {
        return expr;
    }

    public void setExpr(Expr expr) {
        this.expr = expr;
    }
    
    public void setChild(int i, LogicalNode node) {
    };

    @Override
    public Collection<Annotation> getAnnotations() {
        return this.annotated.getAnnotations();
    }

    @Override
    public void setAnnotations(Collection<Annotation> annotations) {
        this.annotated.setAnnotations(annotations);
    }

    @Override
    public String toString() {
        return toJson();
    }
        
    public String toJson() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        LogicalNode newNode = (LogicalNode) super.clone();
        newNode.nodeId = nodeId;
        newNode.type = type;
        newNode.compType = compType;
        newNode.name = name;
        newNode.expr = expr;
        newNode.annotated = (Annotated) annotated.clone();
        return newNode;
    }
    
    public abstract void preOrder(LogicalNodeVisitor visitor);

    public abstract void postOrder(LogicalNodeVisitor visitor);

}
