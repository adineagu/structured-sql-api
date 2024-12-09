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

import org.pecheasoft.odigen.sql.api.ast.IExpression;
import org.pecheasoft.odigen.sql.util.annotation.impl.AnnotatedObject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 *
 * @author Adi Neagu
 */
@JsonPropertyOrder({"className", "text"})
@JsonInclude(Include.NON_NULL)
public class Expression extends AnnotatedObject implements IExpression {

    private final String text; 

    public Expression(String text) {
        this.text = text;
    }
    
    @Override
    public String getText() {
        return text;
    }
        
    @Override
    public String toString() {
        return text;
    }

    @Override
    public String getName() {
        return null;
    }

}
