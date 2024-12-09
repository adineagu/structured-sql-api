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
public enum NodeType {
    ROOT,
    DROP_DATASTORE,
    DROP_MAPPING,
    DROP_PACKAGE,
    DROP_PROJECT,
    DROP_FOLDER,
    DROP_MODEL,
    DROP_SUBMODEL, 
    SCENARIO_ACTION,
    ALTER_DATASTORE,
    ALTER_MAPPING,
    CREATE_MAPPING,
    CREATE_REUSABLE_MAPPING,
    CREATE_SCENARIO,
    CREATE_DATASTORE,
    CREATE_PROJECT,
    CREATE_FOLDER,
    CREATE_MODEL,
    CREATE_SUBMODEL,
    SINGLE_TARGET_TABLE,
    MULTI_TARGET_TABLE,
    COMPONENT,
    RELATION,
    PROJECTOR,
    UNION,
    TABLE_SUBQUERY,
    DATASET,
    DATASTORE,
    TABLE_FUNCTION,
    REUSABLE_MAPPING,
    OUTPUT_SIGNATURE,
    DISTINCT,
    GROUPBY,
    UNPIVOT,
    SORT,
    JOIN,
    LOOKUP,
    EXPRESSIONLIST,
    FILTER,
    IN_PREDICATE,
    ATTRIBUTE,
    PHYSICAL_DESIGN,
    CREATE_PACKAGE,
    TRUNCATE_MAPPING,  
    STATEMENT_BLOCK,
    ;

}
