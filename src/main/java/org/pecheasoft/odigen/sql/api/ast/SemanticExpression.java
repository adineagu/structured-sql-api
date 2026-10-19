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

import java.util.List;
import java.util.function.Function;
import org.pecheasoft.odigen.sql.api.ast.impl.DatastoreReferenceNode;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * A class to represent a SQL expression.
 * 
 * @author Adi Neagu
 * @version 1.0.0,   9-Jan-2018
 */
@JsonInclude(Include.NON_NULL)
public interface SemanticExpression extends SemanticModel {
    String getText();

    default List<DatastoreReferenceNode> getTableReferences() {
        return List.of();
    }

    /** Render only table names using a strategy-supplied function; getText remains unchanged. */
    default String render(Function<DatastoreReferenceNode, String> names) {
        return getText();
    }
}
