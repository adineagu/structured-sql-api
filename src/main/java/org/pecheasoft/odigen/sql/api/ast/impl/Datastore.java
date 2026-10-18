/*
 * Copyright 2018 DWH Tools.
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

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.pecheasoft.odigen.sql.api.ast.SemanticAnnotationSet;
import org.pecheasoft.odigen.sql.api.ast.SemanticModel;
import org.pecheasoft.odigen.sql.util.CatalogConstants;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 *
 * @author Adi Neagu
 */

@JsonInclude(Include.NON_NULL)
public class Datastore implements SemanticModel {

    private String name;
    private String description;
    private List<DatastoreAttribute> attributes;
    private List<DatastoreKey> keys;
    private List<DatastoreCondition> conditions;
    private SemanticAnnotationSet annotations;
    
    public Datastore() {
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
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getQualifier() {
        if (name.contains(CatalogConstants.IDENTIFIER_DELIMITER)) {
            return StringUtils.substringBeforeLast(name, CatalogConstants.IDENTIFIER_DELIMITER);
        } else {
            return "";
        }
    }   

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public List<DatastoreAttribute> getAttributes() {
        List<DatastoreAttribute> attrs = attributes
                .stream()
                .sorted(Comparator.comparing(DatastoreAttribute::getPosition))
                .collect(Collectors.toList());
        return new ColumnsList<>(attrs);
    }
    
    public void setAttributes(List<DatastoreAttribute> attributes) {
        this.attributes = new ColumnsList<>(attributes);
    }
    
    public DatastoreAttribute getAttribute(String attributeName) {
        return attributes.stream().filter(attr -> attr.getName().equalsIgnoreCase(attributeName)).findFirst().orElse(null);
    }
    
    public List<DatastoreAttribute> getAttributes(String condition) {
        return null;
    }

    public List<DatastoreKey> getKeys() {
        return this.keys;
    }

    public void setKeys(List<DatastoreKey> keys) {
        this.keys = keys;
    }       

    public List<DatastoreCondition> getConditions() {
        return conditions;
    }

    public void setConditions(List<DatastoreCondition> conditions) {
        this.conditions = conditions;
    }

    @Override
    public SemanticAnnotationSet annotations() {
        return annotations;
    }

    public void setAnnotations(SemanticAnnotationSet annotations) {
        this.annotations = annotations;
    }
}
