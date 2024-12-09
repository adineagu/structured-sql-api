/*
 * Copyright 2017 Apache Software Foundation.
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


import java.util.Map;

import org.pecheasoft.odigen.sql.util.TUtil;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class GenericAction<K, V> extends Expr {

    public enum GenericActionType {
        OPEN_PROJECT, CONNECT, CONNECT_ODI
    }

    private final GenericActionType actionType;
    private final Map<K, V> parametersMap = TUtil.newHashMap();

    public GenericAction(GenericActionType actionType) {
        this.actionType = actionType;
    }

    public GenericActionType getActionType() {
        return actionType;
    }

    public Map<K, V> getParametersMap() {
        return parametersMap;
    }

}
