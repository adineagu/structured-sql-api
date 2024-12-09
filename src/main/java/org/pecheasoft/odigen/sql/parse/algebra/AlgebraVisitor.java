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

import java.util.Stack;

public interface AlgebraVisitor<CONTEXT, RESULT> {
  // Relational Operators
  RESULT visitSetSession(CONTEXT ctx, Stack<Expr> stack, SetSession expr);

  // Relational Operators
  RESULT visitQuery(CONTEXT ctx, Stack<Expr> stack, Query expr);
  RESULT visitProjection(CONTEXT ctx, Stack<Expr> stack, Projection expr);
  RESULT visitLimit(CONTEXT ctx, Stack<Expr> stack, Limit expr);
  RESULT visitSort(CONTEXT ctx, Stack<Expr> stack, Sort expr);
  RESULT visitHaving(CONTEXT ctx, Stack<Expr> stack, Having expr);
  RESULT visitGroupBy(CONTEXT ctx, Stack<Expr> stack, Aggregation expr);
  RESULT visitUnpivot(CONTEXT ctx, Stack<Expr> stack, Unpivot expr);
  RESULT visitJoin(CONTEXT ctx, Stack<Expr> stack, Join expr);
  RESULT visitSelection(CONTEXT ctx, Stack<Expr> stack, Selection expr);
  RESULT visitFilter(CONTEXT ctx, Stack<Expr> stack, Selection expr);
  RESULT visitSetOperation(CONTEXT ctx, Stack<Expr> stack, SetOperation expr);
  RESULT visitUnion(CONTEXT ctx, Stack<Expr> stack, SetOperation expr);
  RESULT visitExcept(CONTEXT ctx, Stack<Expr> stack, SetOperation expr);
  RESULT visitIntersect(CONTEXT ctx, Stack<Expr> stack, SetOperation expr);
  RESULT visitTableFunction(CONTEXT ctx, Stack<Expr> stack, TableFunction expr);
  RESULT visitSimpleTableSubQuery(CONTEXT ctx, Stack<Expr> stack, SimpleTableSubQuery expr);
  RESULT visitTableSubQuery(CONTEXT ctx, Stack<Expr> stack, TablePrimarySubQuery expr);
  RESULT visitRelationList(CONTEXT ctx, Stack<Expr> stack, RelationList expr);
  RESULT visitRelation(CONTEXT ctx, Stack<Expr> stack, Relation expr);
  RESULT visitScalarSubQuery(CONTEXT ctx, Stack<Expr> stack, ScalarSubQuery expr);
  RESULT visitExplain(CONTEXT ctx, Stack<Expr> stack, Explain expr);
  RESULT visitRowPredicandList(CONTEXT ctx, Stack<Expr> stack, RowPredicandList expr);

  // Data definition language
  RESULT visitCreateDatabase(CONTEXT ctx, Stack<Expr> stack, CreateDatabase expr);
  RESULT visitDropDatabase(CONTEXT ctx, Stack<Expr> stack, DropDatabase expr);
  RESULT visitCreateTable(CONTEXT ctx, Stack<Expr> stack, CreateTable expr);
  RESULT visitDropTable(CONTEXT ctx, Stack<Expr> stack, DropTable expr);
  RESULT visitAlterTablespace(CONTEXT ctx, Stack<Expr> stack, AlterTablespace expr);
  RESULT visitAlterTable(CONTEXT ctx, Stack<Expr> stack, AlterTable expr);
  RESULT visitTruncateTable(CONTEXT ctx, Stack<Expr> stack, TruncateTable expr);

    // Insert or Update
  RESULT visitInsert(CONTEXT ctx, Stack<Expr> stack, Insert expr);
  RESULT visitMultiInsert(CONTEXT ctx, Stack<Expr> stack, MultiInsert expr);

  // Logical operators
  RESULT visitBinaryOperator(CONTEXT ctx, Stack<Expr> stack, BinaryOperator expr);
  RESULT visitAnd(CONTEXT ctx, Stack<Expr> stack, BinaryOperator expr);
  RESULT visitOr(CONTEXT ctx, Stack<Expr> stack, BinaryOperator expr);
  RESULT visitNot(CONTEXT ctx, Stack<Expr> stack, NotExpr expr);

  // comparison predicates
  RESULT visitEquals(CONTEXT ctx, Stack<Expr> stack, BinaryOperator expr);
  RESULT visitNotEquals(CONTEXT ctx, Stack<Expr> stack, BinaryOperator expr);
  RESULT visitLessThan(CONTEXT ctx, Stack<Expr> stack, BinaryOperator expr);
  RESULT visitLessThanOrEquals(CONTEXT ctx, Stack<Expr> stack, BinaryOperator expr);
  RESULT visitGreaterThan(CONTEXT ctx, Stack<Expr> stack, BinaryOperator expr);
  RESULT visitGreaterThanOrEquals(CONTEXT ctx, Stack<Expr> stack, BinaryOperator expr);

  // Other Predicates
  RESULT visitBetween(CONTEXT ctx, Stack<Expr> stack, BetweenPredicate expr);
  RESULT visitCaseWhen(CONTEXT ctx, Stack<Expr> stack, CaseWhenPredicate expr);
  RESULT visitCoalesce(CONTEXT ctx, Stack<Expr> stack, CoalesceExpr expr);
  RESULT visitNullif(CONTEXT ctx, Stack<Expr> stack, NullifExpr expr);
  RESULT visitIsNullPredicate(CONTEXT ctx, Stack<Expr> stack, IsNullPredicate expr);
  RESULT visitInPredicate(CONTEXT ctx, Stack<Expr> stack, InPredicate expr);
  RESULT visitValueListExpr(CONTEXT ctx, Stack<Expr> stack, ValueListExpr expr);
  RESULT visitExistsPredicate(CONTEXT ctx, Stack<Expr> stack, ExistsPredicate expr);
  RESULT visitQuantifiedComparisonPredicate(CONTEXT ctx, Stack<Expr> stack, QuantifiedComparisonPredicate expr);  

  // String Operator or Pattern Matching Predicates
  RESULT visitPatternMatchPredicate(CONTEXT ctx, Stack<Expr> stack, PatternMatchPredicate expr);
  RESULT visitLikePredicate(CONTEXT ctx, Stack<Expr> stack, PatternMatchPredicate expr);
  RESULT visitSimilarToPredicate(CONTEXT ctx, Stack<Expr> stack, PatternMatchPredicate expr);
  RESULT visitRegexpPredicate(CONTEXT ctx, Stack<Expr> stack, PatternMatchPredicate expr);
  RESULT visitConcatenate(CONTEXT ctx, Stack<Expr> stack, BinaryOperator expr);

  // arithmetic operators
  RESULT visitPlus(CONTEXT ctx, Stack<Expr> stack, BinaryOperator expr);
  RESULT visitMinus(CONTEXT ctx, Stack<Expr> stack, BinaryOperator expr);
  RESULT visitMultiply(CONTEXT ctx, Stack<Expr> stack, BinaryOperator expr);
  RESULT visitDivide(CONTEXT ctx, Stack<Expr> stack, BinaryOperator expr);
  RESULT visitModular(CONTEXT ctx, Stack<Expr> stack, BinaryOperator expr);

  // other expressions
  RESULT visitSign(CONTEXT ctx, Stack<Expr> stack, SignedExpr expr);
  RESULT visitColumnReference(CONTEXT ctx, Stack<Expr> stack, ColumnReferenceExpr expr);
  RESULT visitTargetExpr(CONTEXT ctx, Stack<Expr> stack, NamedExpr expr);
  RESULT visitQualifiedAsterisk(CONTEXT ctx, Stack<Expr> stack, QualifiedAsteriskExpr expr);

  // functions
  RESULT visitFunction(CONTEXT ctx, Stack<Expr> stack, FunctionExpr expr);
  RESULT visitGeneralSetFunction(CONTEXT ctx, Stack<Expr> stack, GeneralSetFunctionExpr expr);
  RESULT visitCountRowsFunction(CONTEXT ctx, Stack<Expr> stack, CountRowsFunctionExpr expr);
  RESULT visitWindowFunction(CONTEXT ctx, Stack<Expr> stack, WindowFunctionExpr expr);

  // Literal
  RESULT visitCastExpr(CONTEXT ctx, Stack<Expr> stack, CastExpr expr);
  RESULT visitDataType(CONTEXT ctx, Stack<Expr> stack, DataTypeExpr expr);
  RESULT visitLiteral(CONTEXT ctx, Stack<Expr> stack, LiteralValue expr);
  RESULT visitNullLiteral(CONTEXT ctx, Stack<Expr> stack, NullLiteral expr);
  RESULT visitTimestampLiteral(CONTEXT ctx, Stack<Expr> stack, TimestampLiteral expr);
  RESULT visitIntervalLiteral(CONTEXT ctx, Stack<Expr> stack, IntervalLiteral expr);
  RESULT visitTimeLiteral(CONTEXT ctx, Stack<Expr> stack, TimeLiteral expr);
  RESULT visitDateLiteral(CONTEXT ctx, Stack<Expr> stack, DateLiteral expr);
  RESULT visitUnparseableString(CONTEXT ctx, Stack<Expr> stack, UnparseableString expr);
 
}
