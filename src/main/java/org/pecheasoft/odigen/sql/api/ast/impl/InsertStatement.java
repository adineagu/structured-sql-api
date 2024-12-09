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

import java.util.Collection;
import java.util.List;

import org.pecheasoft.odigen.sql.api.ast.IDatastoreReference;
import org.pecheasoft.odigen.sql.api.ast.IInsertStatement;
import org.pecheasoft.odigen.sql.api.ast.IQuery;
import org.pecheasoft.odigen.sql.api.ast.ITargetAttribute;
import org.pecheasoft.odigen.sql.util.TUtil;
import org.pecheasoft.odigen.sql.util.annotation.impl.AnnotatedObject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Adi Neagu
 */

@JsonInclude(Include.NON_NULL)
public class InsertStatement extends AnnotatedObject implements IInsertStatement {
        
    private IDatastoreReference target;
    Collection<MultiInsertTable> multiInsertTargets;
    private IQuery query;
    private Collection<ITargetAttribute> columns;

    public InsertStatement() {
    }
    
    public InsertStatement(IDatastoreReference targetTable, List<ITargetAttribute> columns) {
        this.target = targetTable;
        this.columns = columns;
    }

    @JsonProperty("Table")
    @Override
    public IDatastoreReference getTarget() {
        return target;
    }

    @JsonProperty("ColumnList") 
    @Override
    public List<ITargetAttribute> getColumns() {
        if (!TUtil.isNullOrEmpty(columns)) {
            return new ColumnsList<>(columns);
        } else {
            return null;
        }
    }
    
    public void setTargetTable(DatastoreReference table) {
        target = table;
    }

    public void setColumns(List<ITargetAttribute> columns) {
        this.columns = columns;
    }

    @Override
    public IQuery getQuery() {
        return query;
    }

    public void setQuery(IQuery query) {
        this.query = query;
    }

    @Override
    public String getName() {
        return null;
    }

    public Collection<MultiInsertTable> getMultiInsertTargets() {
        return multiInsertTargets;
    }

    public void setMultiInsertTargets(Collection<MultiInsertTable> multiInsertTargets) {
        this.multiInsertTargets = multiInsertTargets;
    }      

}
