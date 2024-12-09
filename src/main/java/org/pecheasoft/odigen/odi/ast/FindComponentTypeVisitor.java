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

import org.pecheasoft.odigen.sql.parse.algebra.BinaryOperator;
import org.pecheasoft.odigen.sql.parse.algebra.Expr;
import org.pecheasoft.odigen.sql.parse.algebra.ExprVisitor;
import org.pecheasoft.odigen.sql.parse.algebra.OpType;
import org.pecheasoft.odigen.sql.parse.algebra.UnaryOperator;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class FindComponentTypeVisitor implements ExprVisitor {

    private final OpType opType;
    private boolean compFound = false;
    
    public FindComponentTypeVisitor(OpType opType) {
        this.opType = opType;
    }
            
    @Override
    public void visit(Expr expr) {       
        compFound = visitExpr(expr);
    }
    
    private boolean visitExpr(Expr expr) {
        if (expr.getType() == this.opType) {
            return true;
        }
        else {
            if (expr instanceof UnaryOperator unop) {
                return visitExpr(unop.getChild());
            }
            else {
                BinaryOperator binop = (BinaryOperator) expr;
                return visitExpr(binop.getLeft()) || visitExpr(binop.getRight());
            }
        }
    }

    public boolean isCompFound() {
        return compFound;
    }
    
}
