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

import org.apache.commons.lang3.StringUtils;
import org.pecheasoft.odigen.sql.api.ast.SemanticAnnotationSet;
import org.pecheasoft.odigen.sql.api.ast.SemanticModel;
import org.pecheasoft.odigen.sql.api.ast.SemanticRelation;
import org.pecheasoft.odigen.sql.util.CatalogConstants;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 *
 * @author Adi Neagu
 */
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"className", "name", "alias", "qualifier", "basename", "attributes", "datastore"})
public class DatastoreReferenceNode implements SemanticRelation {

    private final String name;
    private String alias;
    private Datastore datastore;
    boolean isTarget;
    private SemanticAnnotationSet annotations;

    public DatastoreReferenceNode(String name) {
        this.name = name;
    }

    public DatastoreReferenceNode(String name, String alias) {
        this.name = name;
        this.alias = alias;
    }

    public Datastore getDatastore() {
        return datastore;
    }

    public String getBasename() {
        String dsName = getName();

        if (dsName.contains(CatalogConstants.IDENTIFIER_DELIMITER)) {
            return StringUtils.substringAfterLast(name, CatalogConstants.IDENTIFIER_DELIMITER);
        } else {
            return dsName;
        }
    }

    public String getName() {
        return name;
    }

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

    public void setMetadata(Datastore metadata) {
        this.datastore = metadata;
    }

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

    @Override
    public SemanticAnnotationSet annotations() {
        return annotations;
    }

    public void setAnnotations(SemanticAnnotationSet annotations) {
        this.annotations = annotations;
    }

}
