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

/**
 * A class to represent the target table (the table on which data is inserted) specified in a <i>create mapping</i> input expression. An instance of this class is automatically 
 * created by ODI Generator tool as part of <b><i>insert</i></b> object.
 * 
 * <p>
 * In code templates you should use <b><i>$insert.Table</i></b> or <b><i>${insert.Table}</i></b> notation to access this object. 
 * </p><p>
 * Example: specifying the target table in an INSERT statement
 * </p>
 * <p><code>
 * INSERT INTO $insert.Table.QualifiedName (<br>
 * ...<br>
 * )<br>
 * </code></p>
 * 
 * @author Adi Neagu
 * @version 1.0.0,   9-Jan-2018
 */
public interface IDatastoreReference extends IRelation {   
    
    String getBasename();
    
    String getQualifier();

    /**
     * Returns the datastore which is referenced by a instance of this class.
     * @return 
     */
    IDatastore getDatastore();
    
    /**
     * Returns true is the datastore reference is used in INSERT clause
     * @return 
     */
    boolean isTarget();

    @Override
    default String getText() {
        return getQualifier() + "." + getBasename();
    }
}
