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
import java.util.Map;

import org.pecheasoft.odigen.sql.parse.algebra.CreateTable.FileDescriptor;
import org.pecheasoft.odigen.sql.parse.algebra.ITableConstraint;
import org.pecheasoft.odigen.sql.util.CatalogConstants;
import org.pecheasoft.odigen.sql.util.CatalogUtil;

/**
 *
 * @author Adi Neagu
 */
public class CreateDatastoreNode extends LogicalNode {

    private boolean replace;
    private String modelCode;
    private String[] submoldes;
    private String tableName;
    private String alias;
    private String resourceName;    
    private String olapType;    
    private String qualifiedName;
    private String schema;
    private FileDescriptor fileDescriptor;
    private List<Attribute> columns;
    private Collection<ITableConstraint> keys;    
    private Map<String, String> properties;
    private boolean ifNotExists;

    private CreateDatastoreNode() {
        super(NodeType.CREATE_DATASTORE);
    }

    private CreateDatastoreNode(String modelCode, String tableName) {
        this();
        this.modelCode = modelCode;
        this.tableName = tableName;
    }

    private CreateDatastoreNode(String modelCode, String[] submodels, String tableName) {
        this();
        this.modelCode = modelCode;
        this.submoldes = submodels;
        this.tableName = tableName;
    }
    
    public static CreateDatastoreNode newDatastoreWithQualifiedName(String qualifiedName) {
        CreateDatastoreNode createDatastoreNode = new CreateDatastoreNode();
        createDatastoreNode.setQualifiedName(qualifiedName);
        
        String[] tokens = qualifiedName.split(CatalogConstants.IDENTIFIER_DELIMITER_REGEXP);

        String modelCode;
        String tableName;
        String[] submodels;

        if (tokens.length < 2) {
            throw new RuntimeException("Incomplete table name: " + qualifiedName);
        } else if (tokens.length == 2) {
            modelCode = CatalogUtil.extractQualifier(qualifiedName);
            tableName = CatalogUtil.extractSimpleName(qualifiedName);
            createDatastoreNode.setModelCode(modelCode);
            createDatastoreNode.setTableName(tableName);
            createDatastoreNode.setName(tableName);
            createDatastoreNode.setSchema(modelCode);            
        } else {
            modelCode = CatalogUtil.extractQualifier(qualifiedName);
            tableName = CatalogUtil.extractSimpleName(qualifiedName);
            submodels = CatalogUtil.extractMidQualifier(qualifiedName);
            createDatastoreNode.setModelCode(modelCode);
            createDatastoreNode.setSubmoldes(submodels);
            createDatastoreNode.setTableName(tableName);
            createDatastoreNode.setName(tableName);
            createDatastoreNode.setSchema(modelCode);
        } 
        createDatastoreNode.setQualifiedName(qualifiedName);
        return createDatastoreNode;
    }    

    public static CreateDatastoreNode newDatastoreWithModelAndCode(String modelCode, String tableName) {
        return new CreateDatastoreNode(modelCode, tableName);
    }

    public static CreateDatastoreNode newDatastoreWithModelSubmoldesAndCode(String modelCode, String[] submodels, String tableName) {
        return new CreateDatastoreNode(modelCode, submodels, tableName);
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

    public boolean isReplace() {
        return replace;
    }

    public void setReplace(boolean replace) {
        this.replace = replace;
    }
    
    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public String[] getSubmoldes() {
        return submoldes;
    }

    public void setSubmoldes(String[] submoldes) {
        this.submoldes = submoldes;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getQualifiedName() {
        return qualifiedName;
    }

    public void setQualifiedName(String qualifiedName) {
        this.qualifiedName = qualifiedName;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public List<Attribute> getColumns() {
        return columns;
    }

    public void setColumns(List<Attribute> columns) {
        this.columns = columns;
    }

    public Collection<ITableConstraint> getKeys() {
        return keys;
    }

    public void setKeys(Collection<ITableConstraint> keys) {
        this.keys = keys;
    }
        
    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    public boolean isIfNotExists() {
        return ifNotExists;
    }

    public void setIfNotExists(boolean ifNotExists) {
        this.ifNotExists = ifNotExists;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getOlapType() {
        return olapType;
    }

    public void setOlapType(String olapType) {
        this.olapType = olapType;
    }
    
    public FileDescriptor getFileDescriptor() {
        return fileDescriptor;
    }

    public void setFileDescriptor(FileDescriptor fileDescriptor) {
        this.fileDescriptor = fileDescriptor;
    }

    public String getPropertyValue(String propertyName) {
        if (properties != null && properties.containsKey(propertyName)) {
            return properties.get(propertyName);
        } else {
            return null;
        }
    }

}
