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
public interface RelationNode  {

    public abstract boolean hasAlias();

    public abstract String getAlias();
    
    public abstract void setAlias(String alias);

    public abstract String getTableName();

    public abstract String getCanonicalName();
    
    public abstract void setCanonicalName(String name);

}
