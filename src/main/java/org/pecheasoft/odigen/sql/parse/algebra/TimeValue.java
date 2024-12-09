/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
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

import org.apache.commons.lang.StringUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class TimeValue implements Cloneable {

    private String hours;
    private String minutes;
    private String seconds;
    private String secondsFraction; // optional

    public TimeValue(String hours, String minutes, String seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public String getHours() {
        return hours;
    }

    public String getMinutes() {
        return minutes;
    }

    public String getSeconds() {
        return seconds;
    }

    public boolean hasSecondsFraction() {
        return secondsFraction != null;
    }

    public void setSecondsFraction(String secondsFraction) {
        this.secondsFraction = StringUtils.rightPad(secondsFraction, 3, '0');
    }

    public String getSecondsFraction() {
        return secondsFraction;
    }

    @Override
    public String toString() {
        if (hasSecondsFraction()) {
            return String.format("%s:%s:%s.%s", hours, minutes, seconds, secondsFraction);
        } else {
            return String.format("%s:%s:%s", hours, minutes, seconds);
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        TimeValue timeValue = (TimeValue) super.clone();
        timeValue.hours = hours;
        timeValue.minutes = minutes;
        timeValue.seconds = seconds;
        timeValue.secondsFraction = secondsFraction;
        return timeValue;
    }
}
