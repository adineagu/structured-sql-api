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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Adi Neagu
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
 
@JsonInclude(Include.NON_NULL)

public class TableSubQueryNode extends ProjectorNode implements RelationNode {

    private LogicalNode subQuery;

    public TableSubQueryNode() {
        super(NodeType.TABLE_SUBQUERY);
    }

    public LogicalNode getSubQuery() {
        return subQuery;
    }

    public void setSubQuery(LogicalNode subQuery) {
        this.subQuery = subQuery;
    }

    @Override
    public String getTableName() {
        return super.getName();
    }

    @Override
    public String getCanonicalName() {
        return super.getName();
    }

    @Override
    public void setCanonicalName(String name) {
        super.setName(name);
    }

}
