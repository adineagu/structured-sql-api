/*
 * Copyright 2017 DWH Tools.
 * SPDX-License-Identifier: GPL-3.0-only
 *
 * This file is part of SQLMorph.
 *
 * SQLMorph is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 3 of the License.
 *
 * SQLMorph is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with SQLMorph. If not, see <https://www.gnu.org/licenses/>.
 */
package org.pecheasoft.odigen.sql.api.ast;

import org.pecheasoft.odigen.sql.api.ast.impl.DatastoreAttribute;
import org.pecheasoft.odigen.sql.api.ast.impl.DatastoreReferenceNode;
import org.pecheasoft.odigen.sql.api.ast.impl.SelectItem;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 *
 * @author Adi Neagu
 */

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"className", "Name", "Position", "AnnotationsList", "Metadata"})
public class SemanticAssignment implements SemanticModel {

    private final String name;
    private final Integer position;
    private SelectItem expression;
    private SemanticAnnotationSet annotations;
    
    @JsonProperty("Metadata")
    private final DatastoreAttribute metadata;
    @JsonIgnore
    private final DatastoreReferenceNode table;

    public SemanticAssignment(String name, Integer position, DatastoreAttribute columnMetadata, DatastoreReferenceNode table) {
        this.name = name;
        this.position = position;
        this.metadata = columnMetadata;
        this.table = table;
    }
    
    public String getName() {
        return name;
    }

    public SemanticAnnotationSet annotations() {
        return annotations;
    }

    public void setAnnotations(SemanticAnnotationSet annotations) {
        this.annotations = annotations;
    }

    public Integer getPosition() {
        return position;
    }

    public SelectItem getExpression() {
        return expression;
    }

    public void setExpression(SelectItem expression) {
        this.expression = expression;
    }       

    @JsonProperty("Metadata")
    public DatastoreAttribute getMetadata() {
        if (metadata != null) return metadata;
        return table != null && table.getDatastore() != null
                ? table.getDatastore().getAttribute(name) : null;
    }

    private DatastoreAttribute requireMetadata() {
        DatastoreAttribute resolved = getMetadata();
        if (resolved == null) {
            throw new IllegalStateException("Column metadata is unresolved for assignment '" + name
                    + "'. Supply datastore metadata before using metadata-dependent properties.");
        }
        return resolved;
    }

    @JsonIgnore
    public String getDataType() {        
        return requireMetadata().getDataType();
    }

    @JsonIgnore
    public Integer getLength() {
        return requireMetadata().getLength();
    }

    @JsonIgnore
    public Integer getPrecision() {
        return requireMetadata().getPrecision();
    }

    @JsonIgnore
    public Integer getScale() {
        return requireMetadata().getScale();
    }

    @JsonIgnore
    public boolean getIsMandatory() {
        return requireMetadata().getIsMandatory();
    }

    @JsonIgnore
    public boolean getIsPrimaryKey() {
        return requireMetadata().getIsPrimaryKey();
    }

    @JsonIgnore
    public String getDDLDataType() {
        return requireMetadata().getDDLDataType();
    }

    @JsonIgnore
    public String getFormat() {
        return requireMetadata().getFormat();
    }

    @JsonIgnore
    public String getScdBehavior() {
        return requireMetadata().getScdBehavior();
    }

    @JsonIgnore
    public String getDescription() {
        return requireMetadata().getDescription();
    }

    public String getDefaultValue() {
        DatastoreAttribute resolved = getMetadata();
        return resolved != null ? resolved.getDefaultValue() : null;
    }

}
