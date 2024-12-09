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
import java.util.HashMap;

import org.pecheasoft.odigen.sql.util.TUtil;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class DatastoreNode extends LogicalNode implements RelationNode, MappingComponent {
    
    private String qualifiedName;
    private String alias;
    private String[] folders;
    private String schema;
    private Collection<Attribute> columns;
    private HashMap<String, String> properties;

    public DatastoreNode() {
        super(NodeType.DATASTORE);
    }
    
    public static DatastoreNode builder() {
        return new DatastoreNode();
    }
    
    public static DatastoreNode builderWithParams(String schemaName, String datastoreName) {
        DatastoreNode ds = new DatastoreNode();
        ds.setSchema(schemaName);
        ds.setName(datastoreName);
        
        return ds;
    }
    
    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }
 
    //@Override
    public Collection<Attribute> getAttributes() {
        return columns;
    }

    //@Override
    public void setAttributes(Collection<Attribute> columns) {
        this.columns = columns;
    }

    public HashMap<String, String> getProperties() {
        return properties;
    }

    public void setProperties(HashMap<String, String> properties) {
        this.properties = properties;
    }

    public String getPropertyValue(String propertyName) {
        String vRetValue = null;
        
        if (properties != null && properties.containsKey(propertyName)) {
            vRetValue = properties.get(propertyName);
        }
        
        return vRetValue;
    }

    @Override
    public boolean hasAlias() {
        return TUtil.isNullOrEmpty(alias);
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
        return super.getName();
    }

    @Override
    public String getCanonicalName() {
        return qualifiedName;
    }

    @Override
    public String getUniqueName() {
        return alias;
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

    public String[] getFolders() {
        return folders;
    }

    public void setFolders(String[] folders) {
        this.folders = folders;
    }

    @Override
    public void setCanonicalName(String qualifiedName) {
        this.qualifiedName = qualifiedName;
    }
}
