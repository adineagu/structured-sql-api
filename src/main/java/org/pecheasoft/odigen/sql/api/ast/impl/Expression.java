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
package org.pecheasoft.odigen.sql.api.ast.impl;

import java.util.List;
import java.util.Set;
import java.util.Objects;
import java.util.function.Function;
import org.pecheasoft.odigen.sql.parse.EmbeddedTableReferences;

import org.pecheasoft.odigen.sql.api.ast.SemanticAnnotationSet;
import org.pecheasoft.odigen.sql.api.ast.SemanticExpression;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 *
 * @author Adi Neagu
 */
@JsonPropertyOrder({"className", "text"})
@JsonInclude(Include.NON_NULL)
public class Expression implements SemanticExpression {

    private final String text;
    private final List<EmbeddedTableReferences.Reference> references;
    private final List<String> enclosingCteReferences;
    SemanticAnnotationSet annotations;

    public Expression(String text) {
        this(text, Set.of());
    }

    public Expression(String text, Set<String> enclosingCtes) {
        this.text = text;
        this.references = text == null ? List.of() : EmbeddedTableReferences.capture(text, enclosingCtes);
        this.enclosingCteReferences = text == null || enclosingCtes.isEmpty() ? List.of()
                : EmbeddedTableReferences.capture(text, Set.of()).stream().map(r -> r.table().getName())
                    .filter(enclosingCtes::contains).distinct().toList();
    }

    /** Dependencies on enclosing WITH definitions that a standalone expression cannot emit. */
    public List<String> getEnclosingCteReferences() { return enclosingCteReferences; }

    @Override
    public List<DatastoreReferenceNode> getTableReferences() {
        return references.stream().map(EmbeddedTableReferences.Reference::table).toList();
    }

    @Override
    public String render(Function<DatastoreReferenceNode, String> names) {
        Objects.requireNonNull(names);
        StringBuilder result = new StringBuilder();
        int cursor = 0;
        for (var reference : references) {
            String replacement = Objects.requireNonNull(names.apply(reference.table()), "Target table name");
            if (replacement.isBlank()) throw new IllegalArgumentException("Target table name must not be blank");
            if (reference.needsAlias() && !replacement.equals(text.substring(reference.start(), reference.end()))) {
                throw new IllegalArgumentException("Add an explicit alias for embedded table '"
                        + reference.table().getName() + "' before renaming it: qualified column references must remain valid.");
            }
            result.append(text, cursor, reference.start()).append(replacement);
            cursor = reference.end();
        }
        return result.append(text, cursor, text.length()).toString();
    }
    
    @Override
    public String getText() {
        return text;
    }
        
    @Override
    public String toString() {
        return text;
    }

    @Override
    public SemanticAnnotationSet annotations() {
        return annotations;
    }

    public void setAnnotations(SemanticAnnotationSet annotations) {
        this.annotations = annotations;
    }

}
