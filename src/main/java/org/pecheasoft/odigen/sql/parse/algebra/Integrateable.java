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
 * 
 * A class to represent an entity which can be integrated 
 * For example a target entity like MultiIntertTarget or Insert
 */
public interface Integrateable {
    void setIntegrationType(String integrationType);
    void setUpdateKey(String updateKey);
    void setRejectLimit(Integer rejectLimit);
    void setRejectLimitUnit(String rejectLimitUnit);
}
