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
 *
 * @author Adi Neagu
 */
public interface IQuery extends IASTObject {

    boolean getIsDistinct();

    Collection<ISelectItem> getSelectList();

    String getSelectText();

    Collection<IASTObject> getWithList();

    String getWithText();

    Collection<IASTObject> getFromList();

    String getFromText();

    Collection<IASTObject> getWhereList();

    String getWhereText();

    Collection<IExpression> getGroupByList();

    String getGroupByText();

    Collection<IExpression> getOrderByList();

    String getOrderByText();

    Collection<IExpression> getHavingList();

    String getHavingText();

    String getPivotText();

    String getSetOperator();

    void setSetOperator(String setOperator);

    Collection<IQuery> getDatasetList();

    void setDatasetList(Collection<IQuery> datasetList);

}
