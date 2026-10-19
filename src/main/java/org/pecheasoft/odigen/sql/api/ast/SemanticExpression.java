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
