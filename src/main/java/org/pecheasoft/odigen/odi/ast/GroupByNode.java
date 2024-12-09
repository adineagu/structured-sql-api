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

/**
 *
 * @author Adi Neagu
 */
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)

public class GroupByNode extends ProjectorNode implements MappingComponent {
    
    private List<Attribute> groupAttributes;
    private String havingExpression;
    
    public GroupByNode() {
        super(NodeType.GROUPBY);
    }  

    public List<Attribute> getGroupAttributes() {
        return groupAttributes;
    }

    public void setGroupAttributes(List<Attribute> groupAttributes) {
        this.groupAttributes = groupAttributes;
    }

    public String getHavingExpression() {
        return havingExpression;
    }

    public void setHavingExpression(String havingExpression) {
        this.havingExpression = havingExpression;
    }
        
}
