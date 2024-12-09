/*
 * Copyright 2018 Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.pecheasoft.odigen.sql.parse.algebra;


/**
 *
 * @author Adi Neagu
 */

 import com.fasterxml.jackson.annotation.JsonInclude;
 import com.fasterxml.jackson.annotation.JsonInclude.Include;
 
 @JsonInclude(Include.NON_NULL)
 public class TableFunction extends Relation {

    private TargetColumn[] columns;
    private FunctionExpr function;

    public TableFunction(String relationName, FunctionExpr function, TargetColumn[] columns) {
        super(relationName);
        this.function = function;
        this.columns = columns;
    }

    public FunctionExpr getFunction() {
        return function;
    }

    public TargetColumn[] getColumns() {
        return columns;
    }

    public void setColumns(TargetColumn[] columns) {
        this.columns = columns;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        TableFunction tabfunc = (TableFunction) super.clone();
        tabfunc.function = (FunctionExpr) function.clone();
        return tabfunc;
    }
}
