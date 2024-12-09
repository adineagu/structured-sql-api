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

import java.util.Collection;

/**
* A class to represent the table and the columns on which data is inserted. A instance of this class is created automatically by the ODI Generator tool on behalf of <i>create mapping</i> input expressions 
* and contains the information necessary for generating <i>INSERT INTO</i> section of a CREATE MAPPING command.
* <p>
* In code templates you should use <b><i>$insert</i></b> or <b><i>${insert}</i></b> notation to access this object. 
* </p>
* <p>
* Typically a INSERT INTO snippet will be generated using the following template code:
* </p>
* 
* <code>
* INSERT INTO $insert.Table.QualifiedName ( <br>
* #foreach($column in $insert.ColumnList) <br>  
* &nbsp;&nbsp;&nbsp; #if ( $foreach.count != 1 ),#end $column.Annotation $column.Name <br>
* #end <br>
* ) <br>
* </code>
* 
* @author Adi Neagu
* @version 1.0.0,   9-Jan-2018
*/
public interface IInsertStatement extends IASTObject {
    /**
     * Get the object representing the table on which the insert is performed.
     * 
     * @return 
     */    
    IDatastoreReference getTarget();
    
    /**
     * Get the list of objects representing the columns on which data is inserted.
     * 
     * @return 
     */        
    Collection<ITargetAttribute> getColumns();
    
    /**
     * Get the query subordinated query
     * @return 
     */
    IQuery getQuery();

}
