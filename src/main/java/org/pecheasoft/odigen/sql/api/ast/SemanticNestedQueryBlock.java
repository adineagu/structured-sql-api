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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 *
 * @author Adi Neagu
 */

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({
    "className",
    "name",
    "query",
    "alias", 
    "selectList",
    "distinct", 
    "fromList", 
    "pivotText", 
    "whereExprList", 
    "groupByExprList", 
    "havingExprList", 
    "orderByExprList"
    }
)
public class SemanticNestedQueryBlock extends SemanticSimpleQueryBlock implements SemanticRelation {

    private final String alias;
    private final SemanticQueryBlock query;
    private SemanticAnnotationSet annotations;
    
    public SemanticNestedQueryBlock(SemanticQueryBlock query, String alias) {
        this.query = query;
        this.alias = alias;
    }
    
    public String getAlias() {
        return alias;
    }

    public SemanticQueryBlock getQuery() {
        return query;
    }

    @Override
    public String toString() {
        return "SubQuery{" + "alias=" + alias + ", query=" + query + '}';
    }

    @Override
    public String getName() {
        return getAlias();
    }

    @Override
    public SemanticAnnotationSet annotations() {
        return annotations;
    }

    public void setAnnotations(SemanticAnnotationSet annotations) {
        this.annotations = annotations;
    }

    @Override
    public SemanticNestedQueryBlock shallowCopy() {
        SemanticNestedQueryBlock copy = new SemanticNestedQueryBlock(this.query.shallowCopy(), this.alias);
        copy.setAnnotations(this.annotations);
        return copy;
    }
}

