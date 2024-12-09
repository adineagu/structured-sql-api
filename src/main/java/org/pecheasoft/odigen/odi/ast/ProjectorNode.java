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

import org.pecheasoft.odigen.sql.util.TUtil;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)

public abstract class ProjectorNode extends UnaryNode implements Projectable {
    
    private Collection<Attribute> attributes;
    private String alias;
    private boolean dataset;

    public ProjectorNode(NodeType nodeType) {
        super(nodeType);
    }
    
    public ProjectorNode(int nodeId, NodeType nodeType) {
        super(nodeId, nodeType);
    }

    @Override
    public Collection<Attribute> getAttributes() {
        return attributes;
    }

    @Override
    public void setAttributes(Collection<Attribute> attributes) {
        this.attributes = attributes;
    }

    public boolean isDataset() {
        return dataset;
    }

    public void setDataset(boolean dataset) {
        this.dataset = dataset;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
    
    public boolean hasAlias() {
        return TUtil.isNullOrEmpty(alias);
    }
    
}
