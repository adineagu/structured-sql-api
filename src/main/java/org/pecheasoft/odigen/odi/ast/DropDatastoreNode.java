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

/**
 *
 * @author Adi Neagu
 */
public class DropDatastoreNode extends UnaryNode {

    private String modelCode;
    private String[] submodels;
    private String tableName;
    private String qualifiedName;
    private boolean dropIfExists;

    private DropDatastoreNode() {
        super(NodeType.DROP_DATASTORE);
    }

    private DropDatastoreNode(String modelCode, String tableName) {
        this();
        this.modelCode = modelCode;
        this.tableName = tableName;
    }

    private DropDatastoreNode(String modelCode, String[] submodels, String tableName) {
        this(modelCode, tableName);
        this.submodels = submodels;
    }

    public static DropDatastoreNode newDropDatastoreNode(String modelCode, String tableName) {
        return new DropDatastoreNode(modelCode, tableName);
    }

    public static DropDatastoreNode newDropDatastoreNodeWithSubmodels(String modelCode, String[] submodels, String tableName) {
        return new DropDatastoreNode(modelCode, submodels, tableName);
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public String[] getSubmodels() {
        return submodels;
    }

    public void setSubmodels(String[] submodels) {
        this.submodels = submodels;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public boolean isDropIfExists() {
        return dropIfExists;
    }

    public void setDropIfExists(boolean dropIfExists) {
        this.dropIfExists = dropIfExists;
    }

    public String getQualifiedName() {
        return qualifiedName;
    }

    public void setQualifiedName(String qualifiedName) {
        this.qualifiedName = qualifiedName;
    }

}
