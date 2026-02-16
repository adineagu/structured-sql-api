/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.pecheasoft.odigen.sql.parse.algebra;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.Preconditions;

@JsonInclude(Include.NON_NULL)
public class RelationList extends Expr {

    private Expr[] relations;

    public RelationList(Expr[] relations) {
        checkRelations(relations);
        this.relations = relations;
    }

    private void checkRelations(Expr[] relations) {
        for (Expr rel : relations) {
            Preconditions.checkArgument(
                    rel instanceof Relation
                    || rel instanceof Join
                    || rel instanceof Projection,
                    "Only Relation, Join, or TablePrimarySubQuery can be given to RelationList, but this expr "
                    + " is " + rel.getClass().getSimpleName());
        }
    }

    public Expr[] getRelations() {
        return this.relations;
    }

    public int size() {
        return this.relations.length;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        RelationList relationList = (RelationList) super.clone();
        relationList.relations = new Expr[relations.length];
        for (int i = 0; i < relations.length; i++) {
            relationList.relations[i] = (Expr) relations[i].clone();
        }
        return relationList;
    }
}
