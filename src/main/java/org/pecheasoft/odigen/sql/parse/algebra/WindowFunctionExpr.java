/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class WindowFunctionExpr extends GeneralSetFunctionExpr {

    private String windowName;
    private String nullsInclusionOption;
    private WindowSpec windowSpec;

    public WindowFunctionExpr(GeneralSetFunctionExpr function) {
        super(OpType.WindowFunction, function.getSignature(), function.isDistinct(), function.getParams());
    }

    public boolean hasWindowName() {
        return windowName != null;
    }

    public void setWindowName(String windowName) {
        this.windowName = windowName;
    }

    public String getWindowName() {
        return this.windowName;
    }

    public boolean hasWidowSpec() {
        return windowSpec != null;
    }

    public void setWindowSpec(WindowSpec windowSpec) {
        this.windowSpec = windowSpec;
    }

    public WindowSpec getWindowSpec() {
        return this.windowSpec;
    }

    public String getNullOption() {
        return nullsInclusionOption;
    }

    public void setNullOption(String nullOption) {
        this.nullsInclusionOption = nullOption;
    }

}
