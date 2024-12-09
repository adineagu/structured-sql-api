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
package org.pecheasoft.odigen.sql.util.annotation.impl;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.pecheasoft.odigen.sql.util.annotation.Annotation;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * @author Adi Neagu
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DefaultAnnotation implements Annotation {
       
    private final String name;     
    private final Map<String, String> parameters;
    
    public DefaultAnnotation(String name, Map<String, String> parameters) {
        this.name = name;
        this.parameters = parameters;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Map<String, String> getParameters() {
        return parameters;
    }

    @Override
    public String toString() {
        String vRet = "@" + name;
        if (parameters != null && !parameters.isEmpty()) {            
            Set<Map.Entry<String, String>> entries = parameters.entrySet();
            vRet += entries.stream()
                    .map(e -> e.getKey() + "=\"" + e.getValue() + "\"")
                    .collect(Collectors.joining(", ", "(", ")"));
        }
        return vRet;
    }
}
