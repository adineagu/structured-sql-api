/*
 * Copyright 2017 DWH Tools.
 *
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.odieasy.com/11-licenses/eula
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.pecheasoft.odigen.sql.api.ast.impl;

import org.apache.commons.lang.StringUtils;
import org.pecheasoft.odigen.sql.api.ast.IDatastore;
import org.pecheasoft.odigen.sql.api.ast.IDatastoreReference;
import org.pecheasoft.odigen.sql.util.CatalogConstants;
import org.pecheasoft.odigen.sql.util.annotation.impl.AnnotatedObject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 *
 * @author Adi Neagu
 */
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"className", "name", "alias", "qualifier", "basename", "attributes", "datastore"})
public class DatastoreReference extends AnnotatedObject implements IDatastoreReference {

    private final String name;
    private String alias;
    private IDatastore datastore;
    boolean isTarget;

    public DatastoreReference(String name) {
        this.name = name;
    }

    public DatastoreReference(String name, String alias) {
        this.name = name;
        this.alias = alias;
    }

    @Override
    public IDatastore getDatastore() {
        return datastore;
    }

    @Override
    public String getBasename() {
        String dsName = getName();

        if (dsName.contains(CatalogConstants.IDENTIFIER_DELIMITER)) {
            return StringUtils.substringAfterLast(name, CatalogConstants.IDENTIFIER_DELIMITER);
        } else {
            return dsName;
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getQualifier() {
        if (name.contains(CatalogConstants.IDENTIFIER_DELIMITER)) {
            return StringUtils.substringBeforeLast(name, CatalogConstants.IDENTIFIER_DELIMITER);
        } else {
            return "";
        }
    }

    @Override
    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setMetadata(IDatastore metadata) {
        this.datastore = metadata;
    }

    @Override
    public boolean isTarget() {
        return isTarget;
    }

    public void setIsTarget(boolean isTarget) {
        this.isTarget = isTarget;
    }

    @Override
    public String toString() {
        return "DatastoreReference{" + "name=" + name + ", alias=" + alias + ", datastore=" + datastore + ", isTarget=" + isTarget + '}';
    }

}
