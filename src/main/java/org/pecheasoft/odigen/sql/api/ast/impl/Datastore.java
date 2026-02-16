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

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.pecheasoft.odigen.sql.api.ast.IDatastore;
import org.pecheasoft.odigen.sql.api.ast.IDatastoreAttribute;
import org.pecheasoft.odigen.sql.api.ast.IDatastoreCondition;
import org.pecheasoft.odigen.sql.api.ast.IDatastoreKey;
import org.pecheasoft.odigen.sql.util.CatalogConstants;
import org.pecheasoft.odigen.sql.util.annotation.impl.AnnotatedObject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 *
 * @author Adi Neagu
 */

@JsonInclude(Include.NON_NULL)
public class Datastore extends AnnotatedObject implements IDatastore {

    private String name;
    private String description;
    private Collection<IDatastoreAttribute> attributes;
    private IDatastore metadata;
    private Collection<IDatastoreKey> keys;
    private Collection<IDatastoreCondition> conditions;
    
    public Datastore() {
    }
    
    public Datastore(String name) {
        this.name = name;
    }
    
    public Datastore(IDatastore metadata) {
        this.metadata = metadata;
        this.attributes = new ColumnsList<>(metadata.getAttributes());
        this.name = metadata.getName();
        setAnnotations(metadata.getAnnotations());
        this.keys = metadata.getKeys();
        this.conditions = metadata.getConditions();
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
    
    public void setName(String name) {
        this.name = name;
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
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public Collection<IDatastoreAttribute> getAttributes() {
        List<IDatastoreAttribute> attrs = attributes
                .stream()
                .sorted(Comparator.comparing(IDatastoreAttribute::getPosition))
                .collect(Collectors.toList());
        return new ColumnsList<>(attrs);
        
    }
    
    public void setAttributes(List<IDatastoreAttribute> attributes) {
        this.attributes = new ColumnsList<>(attributes);
    }
    
    @Override
    public IDatastoreAttribute getAttribute(String attributeName) {
        return attributes.stream().filter(attr -> attr.getName().equalsIgnoreCase(attributeName)).findFirst().orElse(null);
    }
    
    @Override
    public Collection<IDatastoreAttribute> getAttributes(String condition) {
        return null;
    }
    
    @Override
    public void copyProperties(IDatastore source) {
        if (source == null) {
            throw new IllegalArgumentException("source cannot be null");
        }
        
        if (source == this) {
            return;
        }
        
        metadata.copyProperties(source);
    }
    
    @Override
    public Collection<IDatastoreKey> getKeys() {
        return this.keys;
    }

    public void setKeys(Collection<IDatastoreKey> keys) {
        this.keys = keys;
    }       

    @Override
    public Collection<IDatastoreCondition> getConditions() {
        return conditions;
    }

    public void setConditions(Collection<IDatastoreCondition> conditions) {
        this.conditions = conditions;
    }    

    @Override
    public String toJson() {
        return IDatastore.super.toJson();
    }

}
