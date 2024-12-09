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
import org.pecheasoft.odigen.sql.parse.algebra.Expr;

/**
 *
 * @author Adi Neagu
 */
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
 
@JsonInclude(Include.NON_NULL)

public class UnpivotNode extends ProjectorNode implements MappingComponent {
    
    private List<Attribute> unpivotAttributes;
    
    Expr unpivotExpression;

    public UnpivotNode() {
        super(NodeType.UNPIVOT);
    }  

    public List<Attribute> getUnpivotAttributes() {
        return unpivotAttributes;
    }

    public void setUnpivotAttributes(List<Attribute> unpivotAttributes) {
        this.unpivotAttributes = unpivotAttributes;
    }

    public Expr getUnpivotExpression() {
        return unpivotExpression;
    }

    public void setUnpivotExpression(Expr unpivotExpression) {
        this.unpivotExpression = unpivotExpression;
    }
        
}
