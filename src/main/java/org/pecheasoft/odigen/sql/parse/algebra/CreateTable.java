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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.pecheasoft.odigen.sql.util.TUtil;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CreateTable extends Expr {

    private boolean isReplace;
    private boolean external = false;
    private String tableName;
    private String alias;
    private String resourceName;
    private String olapType;
    FileDescriptor fileDescriptor;
    private ColumnDefinition[] tableElements;
    private Collection<ITableConstraint> tableKeys;
    private String storageType;
    private String location;
    private Expr subquery;
    private Map<String, String> params;
    private PartitionMethodDescExpr partition;
    private boolean ifNotExists;
    private String likeParentTable;
    private String description;
    
    public CreateTable(final String tableName, boolean ifNotExists) {
        this.tableName = tableName;
        this.ifNotExists = ifNotExists;
    }

    public CreateTable(final String tableName, final Expr subQuery, boolean ifNotExists) {
        this(tableName, ifNotExists);
        this.subquery = subQuery;
    }

    public boolean isReplace() {
        return isReplace;
    }

    public void setReplace(boolean isReplace) {
        this.isReplace = isReplace;
    }
    
    public void setExternal() {
        external = true;
    }

    public boolean isExternal() {
        return external;
    }

    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public boolean hasLocation() {
        return location != null;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean hasTableElements() {
        return !TUtil.isNullOrEmpty(tableElements);
    }

    public ColumnDefinition[] getTableElements() {
        return tableElements;
    }

    public void setTableElements(ColumnDefinition[] tableElements) {
        this.tableElements = tableElements;
    }

    public boolean hasTableKeys() {
        return !TUtil.isNullOrEmpty(tableKeys);
    }
    
    public Collection<ITableConstraint> getTableKeys() {
        return tableKeys;
    }

    public void setTableKeys(Collection<ITableConstraint> tableKeys) {
        this.tableKeys = tableKeys;
    }    

    public String getOlapType() {
        return olapType;
    }

    public void setOlapType(String olapType) {
        this.olapType = olapType;
    }
    
    public boolean hasFileDescriptor() {
        return this.fileDescriptor != null;
    }
    
    public FileDescriptor getFileDescriptor() {
        return this.fileDescriptor;
    }

    public void setFileDescriptor(FileDescriptor fileDescriptor) {
        this.fileDescriptor = fileDescriptor;
    }
    
    public boolean hasStorageType() {
        return storageType != null;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    public String getStorageType() {
        return storageType;
    }

    public boolean hasParams() {
        return params != null;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public boolean hasPartition() {
        return partition != null;
    }

    public void setPartitionMethod(PartitionMethodDescExpr partition) {
        this.partition = partition;
    }

    @SuppressWarnings("unchecked")
    public <T extends PartitionMethodDescExpr> T getPartitionMethod() {
        return (T) this.partition;
    }

    public boolean hasSubQuery() {
        return subquery != null;
    }

    public void setSubQuery(Expr subquery) {
        this.subquery = subquery;
    }

    public Expr getSubQuery() {
        return subquery;
    }

    public boolean isIfNotExists() {
        return ifNotExists;
    }

    public void setLikeParentTable(String parentTable) {
        this.likeParentTable = parentTable;
    }

    public String getLikeParentTableName() {
        return likeParentTable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        CreateTable createTable = (CreateTable) super.clone();
        createTable.isReplace = isReplace;
        createTable.external = external;
        createTable.tableName = tableName;
        if (tableElements != null) {
            createTable.tableElements = new ColumnDefinition[tableElements.length];
            for (int i = 0; i < tableElements.length; i++) {
                createTable.tableElements[i] = (ColumnDefinition) tableElements[i].clone();
            }
        }
        createTable.storageType = storageType;
        createTable.location = location;
        createTable.subquery = subquery;
        if (params != null) {
            createTable.params = new HashMap<>(params);
        }
        if (partition != null) {
            createTable.partition = (PartitionMethodDescExpr) partition.clone();
        }
        createTable.ifNotExists = ifNotExists;
        return createTable;
    }

    public static enum PartitionType {
        RANGE,
        HASH,
        LIST,
        COLUMN
    }

    public static abstract class PartitionMethodDescExpr implements Cloneable {
        PartitionType type;

        public PartitionMethodDescExpr(PartitionType type) {
            this.type = type;
        }

        public PartitionType getPartitionType() {
            return type;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            PartitionMethodDescExpr partition = (PartitionMethodDescExpr) super.clone();
            partition.type = type;
            return partition;
        }

    }

    public static class RangePartition extends PartitionMethodDescExpr {

        ColumnReferenceExpr[] columns;
        List<RangePartitionSpecifier> specifiers;

        public RangePartition(ColumnReferenceExpr[] columns, List<RangePartitionSpecifier> specifiers) {
            super(PartitionType.RANGE);
            this.columns = columns;
            this.specifiers = specifiers;
        }

        public ColumnReferenceExpr[] getColumns() {
            return columns;
        }

        public List<RangePartitionSpecifier> getSpecifiers() {
            return specifiers;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            RangePartition range = (RangePartition) super.clone();
            range.columns = new ColumnReferenceExpr[columns.length];
            for (int i = 0; i < columns.length; i++) {
                range.columns[i] = (ColumnReferenceExpr) columns[i].clone();
            }
            if (range.specifiers != null) {
                range.specifiers = new ArrayList<>();
                for (int i = 0; i < specifiers.size(); i++) {
                    range.specifiers.add(specifiers.get(i));
                }
            }
            return range;
        }
    }

    public static class HashPartition extends PartitionMethodDescExpr {

        ColumnReferenceExpr[] columns;
        Expr quantity;
        List<PartitionSpecifier> specifiers;

        public HashPartition(ColumnReferenceExpr[] columns, Expr quantity) {
            super(PartitionType.HASH);
            this.columns = columns;
            this.quantity = quantity;
        }

        public HashPartition(ColumnReferenceExpr[] columns, List<PartitionSpecifier> specifier) {
            super(PartitionType.HASH);
            this.columns = columns;
            this.specifiers = specifier;
        }

        public ColumnReferenceExpr[] getColumns() {
            return columns;
        }

        public boolean hasQuantifier() {
            return quantity != null;
        }

        public Expr getQuantifier() {
            return quantity;
        }

        public boolean hasSpecifiers() {
            return specifiers != null;
        }

        public List<PartitionSpecifier> getSpecifiers() {
            return specifiers;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            HashPartition hash = (HashPartition) super.clone();
            hash.columns = new ColumnReferenceExpr[columns.length];
            for (int i = 0; i < columns.length; i++) {
                hash.columns[i] = (ColumnReferenceExpr) columns[i].clone();
            }
            hash.quantity = quantity;
            if (specifiers != null) {
                hash.specifiers = new ArrayList<>();
                for (PartitionSpecifier specifier : specifiers) {
                    hash.specifiers.add(specifier);
                }
            }
            return hash;
        }
    }

    public static class ListPartition extends PartitionMethodDescExpr {

        ColumnReferenceExpr[] columns;
        List<ListPartitionSpecifier> specifiers;

        public ListPartition(ColumnReferenceExpr[] columns, List<ListPartitionSpecifier> specifers) {
            super(PartitionType.LIST);
            this.columns = columns;
            this.specifiers = specifers;
        }

        public ColumnReferenceExpr[] getColumns() {
            return columns;
        }

        public List<ListPartitionSpecifier> getSpecifiers() {
            return specifiers;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            ListPartition listPartition = (ListPartition) super.clone();
            listPartition.columns = new ColumnReferenceExpr[columns.length];
            for (int i = 0; i < columns.length; i++) {
                listPartition.columns[i] = (ColumnReferenceExpr) columns[i].clone();
            }
            if (specifiers != null) {
                listPartition.specifiers = new ArrayList<>();
                for (ListPartitionSpecifier specifier : specifiers) {
                    listPartition.specifiers.add(specifier);
                }
            }
            return listPartition;
        }
    }

    public static class ColumnPartition extends PartitionMethodDescExpr {

        private ColumnDefinition[] columns;

        public ColumnPartition(ColumnDefinition[] columns) {
            super(PartitionType.COLUMN);
            this.columns = columns;
        }

        public ColumnDefinition[] getColumns() {
            return columns;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            ColumnPartition columnPartition = (ColumnPartition) super.clone();
            columnPartition.columns = new ColumnDefinition[columns.length];
            for (int i = 0; i < columns.length; i++) {
                columnPartition.columns[i] = (ColumnDefinition) columns[i].clone();
            }
            return columnPartition;
        }
    }

    public static class RangePartitionSpecifier extends PartitionSpecifier {
        Expr end;
        boolean maxValue;

        public RangePartitionSpecifier(String name, Expr end) {
            super(name);
            this.end = end;
        }

        public RangePartitionSpecifier(String name) {
            super(name);
            maxValue = true;
        }

        public Expr getEnd() {
            return end;
        }

        public boolean isEndMaxValue() {
            return this.maxValue;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            RangePartitionSpecifier specifier = (RangePartitionSpecifier) super.clone();
            specifier.end = (Expr) end.clone();
            specifier.maxValue = maxValue;
            return specifier;
        }
    }

    public static class ListPartitionSpecifier extends PartitionSpecifier {

        ValueListExpr valueList;

        public ListPartitionSpecifier(String name, ValueListExpr valueList) {
            super(name);
            this.valueList = valueList;
        }

        public ValueListExpr getValueList() {
            return valueList;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            ListPartitionSpecifier specifier = (ListPartitionSpecifier) super.clone();
            specifier.valueList = (ValueListExpr) valueList.clone();
            return specifier;
        }
    }

    public static class PartitionSpecifier implements Cloneable {

        private String name;

        public PartitionSpecifier(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            PartitionSpecifier specifier = (PartitionSpecifier) super.clone();
            specifier.name = name;
            return specifier;
        }
    }

    public static class FileDescriptor {

        public enum FileFormat {
            FIXED, DELIMITED
        }

        private FileFormat format;
        private Integer skipHeadingLines;
        private String recordSeparator;
        private String fieldSeparator;
        private String textDelimiter;
        private String decimalDelimiter;

        public FileFormat getFormat() {
            return format;
        }

        public void setFormat(FileFormat format) {
            this.format = format;
        }

        public Integer getSkipHeadingLines() {
            return skipHeadingLines;
        }

        public void setSkipHeadingLines(Integer headingLines) {
            this.skipHeadingLines = headingLines;
        }

        public String getRecordSeparator() {
            return recordSeparator;
        }

        public void setRecordSeparator(String recordSeparator) {
            this.recordSeparator = recordSeparator;
        }

        public String getFieldSeparator() {
            return fieldSeparator;
        }

        public void setFieldSeparator(String fieldSeparator) {
            this.fieldSeparator = fieldSeparator;
        }

        public String getTextDelimiter() {
            return textDelimiter;
        }

        public void setTextDelimiter(String textDelimiter) {
            this.textDelimiter = textDelimiter;
        }

        public String getDecimalDelimiter() {
            return decimalDelimiter;
        }

        public void setDecimalDelimiter(String decimalDelimiter) {
            this.decimalDelimiter = decimalDelimiter;
        }

    }
    
    public static class HiveProperties {
        public enum ROW_FORMAT {DELIMITED, SERDE}
        public enum STORAGE_FORMAT {JSON, INPUTFORMAT, PARQUET, TEXTFILE, ORC, AVRO, RCFILE}
    }

}
