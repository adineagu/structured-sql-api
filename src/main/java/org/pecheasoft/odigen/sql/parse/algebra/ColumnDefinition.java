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


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ColumnDefinition extends Expr {

    private final String columnName;
    private boolean optional;
    private Integer position;
    private Integer physLength;
    private Integer offset;
    private String format;
    private String decseparator;
    private String scdBehavior;
    private String description;
    private DataTypeExpr dataType;
    
    public ColumnDefinition(String columnName) {
        this.columnName = columnName;
    }

    public ColumnDefinition(String columnName, String dataTypeName) {
        this.dataType = new DataTypeExpr(dataTypeName);
        this.columnName = columnName;
    }

    public ColumnDefinition(String columnName, DataTypeExpr dataType) {
        this.dataType = dataType;
        this.columnName = columnName;
    }

    public String getColumnName() {
        return this.columnName;
    }
    
    public boolean isOptional() {
        return optional;
    }

    public void setOptional(boolean optional) {
        this.optional = optional;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getPhysLength() {
        return physLength;
    }

    public void setPhysLength(Integer physLength) {
        this.physLength = physLength;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getDecseparator() {
        return decseparator;
    }

    public void setDecseparator(String decseparator) {
        this.decseparator = decseparator;
    }

    public String getScdBehavior() {
        return scdBehavior;
    }

    public void setScdBehavior(String scdBehavior) {
        this.scdBehavior = scdBehavior;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DataTypeExpr getDataType() {
        return dataType;
    }

    public void setDataType(DataTypeExpr dataType) {
        this.dataType = dataType;
    }

    public boolean hasLengthOrPrecision() {
        return dataType.hasLengthOrPrecision();
    }
    
    public Integer getLengthOrPrecision() {
        return dataType.getLengthOrPrecision();
    }

    public void setLengthOrPrecision(Integer lengthOrPrecision) {
        dataType.setLengthOrPrecision(lengthOrPrecision);
    }

    public boolean hasScale() {
        return dataType.hasScale();
    }

    public Integer getScale() {
        return dataType.getScale();
    }

    public void setScale(Integer scale) {
        dataType.setScale(scale);
    }

    public String getTypeName() {
        return dataType.typeName;
    }

}
