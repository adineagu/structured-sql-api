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

/**
 * The type of the operation.
 */
public enum OpType {
    RelationList,
    Relation,
    TableCheckConstraint,
    And,
    Or,
    Not,
    Plus,
    Multiply,
    Divide,
    Modular,
    Column,
    Target,
    Function,
    WindowFunction,
    CountRowsFunction,
    GeneralSetFunction,
    Literal,
    NullLiteral,
    TimeLiteral,
    DateLiteral,
    TimestampLiteral,
    IntervalLiteral,
    UnparseableString,
    Script,
    ODI,
    SQL,
    SQLEXT;

    /**
     * Check if it is one of the logical types.
     *
     * @param type The type to be checked
     * @return True if it is one of the logical types. Otherwise, it returns
     * False.
     */
    public static boolean isLogicalType(OpType type) {
        return type == Not || type == And || type == Or;
    }


    /**
     * Check if it is one of the literal types.
     *
     * @param type The type to be checked
     * @return True if it is one of the literal types. Otherwise, it returns
     * False.
     */
    public static boolean isLiteralType(OpType type) {
        return type == Literal
                || type == NullLiteral
                || type == TimeLiteral
                || type == DateLiteral
                || type == TimestampLiteral;
    }

    /**
     * Check if it is one of function types.
     *
     * @param type The type to be checked
     * @return True if it is aggregation function type. Otherwise, it returns
     * False.
     */
    public static boolean isFunction(OpType type) {
        return type == Function || isAggregationFunction(type) || isWindowFunction(type);
    }

    /**
     * Check if it is an aggregation function type.
     *
     * @param type The type to be checked
     * @return True if it is aggregation function type. Otherwise, it returns
     * False.
     */
    public static boolean isAggregationFunction(OpType type) {
        return type == GeneralSetFunction || type == CountRowsFunction;
    }

    /**
     * Check if it is an window function type.
     *
     * @param type The type to be checked
     * @return True if it is window function type. Otherwise, it returns False.
     */
    public static boolean isWindowFunction(OpType type) {
        return type == WindowFunction;
    }

}
