/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. The ASF
 * licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.pecheasoft.odigen.sql.parse;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.pecheasoft.odigen.sql.parse.algebra.Aggregation;
import org.pecheasoft.odigen.sql.parse.algebra.Aggregation.GroupElement;
import org.pecheasoft.odigen.sql.parse.algebra.Aggregation.GroupType;
import org.pecheasoft.odigen.sql.parse.algebra.AlterTable;
import org.pecheasoft.odigen.sql.parse.algebra.AlterTable.AlterTableOpType;
import org.pecheasoft.odigen.sql.parse.algebra.AlterTablespace;
import org.pecheasoft.odigen.sql.parse.algebra.BetweenPredicate;
import org.pecheasoft.odigen.sql.parse.algebra.BinaryOperator;
import org.pecheasoft.odigen.sql.parse.algebra.BooleanLiteral;
import org.pecheasoft.odigen.sql.parse.algebra.CaseWhenPredicate;
import org.pecheasoft.odigen.sql.parse.algebra.CastExpr;
import org.pecheasoft.odigen.sql.parse.algebra.CoalesceExpr;
import org.pecheasoft.odigen.sql.parse.algebra.ColumnDefinition;
import org.pecheasoft.odigen.sql.parse.algebra.ColumnReferenceExpr;
import org.pecheasoft.odigen.sql.parse.algebra.CountRowsFunctionExpr;
import org.pecheasoft.odigen.sql.parse.algebra.CreateDatabase;
import org.pecheasoft.odigen.sql.parse.algebra.CreateTable;
import org.pecheasoft.odigen.sql.parse.algebra.CreateTable.FileDescriptor;
import org.pecheasoft.odigen.sql.parse.algebra.CreateTable.HashPartition;
import org.pecheasoft.odigen.sql.parse.algebra.CreateTable.ListPartition;
import org.pecheasoft.odigen.sql.parse.algebra.CreateTable.ListPartitionSpecifier;
import org.pecheasoft.odigen.sql.parse.algebra.CreateTable.PartitionMethodDescExpr;
import org.pecheasoft.odigen.sql.parse.algebra.CreateTable.PartitionSpecifier;
import org.pecheasoft.odigen.sql.parse.algebra.CreateTable.RangePartitionSpecifier;
import org.pecheasoft.odigen.sql.parse.algebra.DataTypeExpr;
import org.pecheasoft.odigen.sql.parse.algebra.DatasetHint;
import org.pecheasoft.odigen.sql.parse.algebra.DateLiteral;
import org.pecheasoft.odigen.sql.parse.algebra.DateValue;
import org.pecheasoft.odigen.sql.parse.algebra.DropDatabase;
import org.pecheasoft.odigen.sql.parse.algebra.DropTable;
import org.pecheasoft.odigen.sql.parse.algebra.ExistsPredicate;
import org.pecheasoft.odigen.sql.parse.algebra.Explain;
import org.pecheasoft.odigen.sql.parse.algebra.Expr;
import org.pecheasoft.odigen.sql.parse.algebra.FunctionExpr;
import org.pecheasoft.odigen.sql.parse.algebra.GeneralSetFunctionExpr;
import org.pecheasoft.odigen.sql.parse.algebra.Having;
import org.pecheasoft.odigen.sql.parse.algebra.ITableConstraint;
import org.pecheasoft.odigen.sql.parse.algebra.ITableConstraint.ConstraintScope;
import org.pecheasoft.odigen.sql.parse.algebra.InPredicate;
import org.pecheasoft.odigen.sql.parse.algebra.Insert;
import org.pecheasoft.odigen.sql.parse.algebra.IntervalLiteral;
import org.pecheasoft.odigen.sql.parse.algebra.IsNullPredicate;
import org.pecheasoft.odigen.sql.parse.algebra.Join;
import org.pecheasoft.odigen.sql.parse.algebra.Join.JoinType;
import org.pecheasoft.odigen.sql.parse.algebra.Limit;
import org.pecheasoft.odigen.sql.parse.algebra.LiteralValue;
import org.pecheasoft.odigen.sql.parse.algebra.LiteralValue.LiteralType;
import org.pecheasoft.odigen.sql.parse.algebra.MultiInsert;
import org.pecheasoft.odigen.sql.parse.algebra.MultiInsertTarget;
import org.pecheasoft.odigen.sql.parse.algebra.MultiaryOperator;
import org.pecheasoft.odigen.sql.parse.algebra.NamedExpr;
import org.pecheasoft.odigen.sql.parse.algebra.NamedQuery;
import org.pecheasoft.odigen.sql.parse.algebra.NotExpr;
import org.pecheasoft.odigen.sql.parse.algebra.NullLiteral;
import org.pecheasoft.odigen.sql.parse.algebra.NullifExpr;
import org.pecheasoft.odigen.sql.parse.algebra.OpType;
import org.pecheasoft.odigen.sql.parse.algebra.PatternMatchPredicate;
import org.pecheasoft.odigen.sql.parse.algebra.Projection;
import org.pecheasoft.odigen.sql.parse.algebra.QualifiedAsteriskExpr;
import org.pecheasoft.odigen.sql.parse.algebra.QuantifiedComparisonPredicate;
import org.pecheasoft.odigen.sql.parse.algebra.Query;
import org.pecheasoft.odigen.sql.parse.algebra.Relation;
import org.pecheasoft.odigen.sql.parse.algebra.RelationList;
import org.pecheasoft.odigen.sql.parse.algebra.RowPredicandList;
import org.pecheasoft.odigen.sql.parse.algebra.ScalarSubQuery;
import org.pecheasoft.odigen.sql.parse.algebra.Selection;
import org.pecheasoft.odigen.sql.parse.algebra.SetOperation;
import org.pecheasoft.odigen.sql.parse.algebra.SetSession;
import org.pecheasoft.odigen.sql.parse.algebra.SignedExpr;
import org.pecheasoft.odigen.sql.parse.algebra.SimpleTableSubQuery;
import org.pecheasoft.odigen.sql.parse.algebra.Sort;
import org.pecheasoft.odigen.sql.parse.algebra.TableCheckConstraint;
import org.pecheasoft.odigen.sql.parse.algebra.TableConstraint;
import org.pecheasoft.odigen.sql.parse.algebra.TableFunction;
import org.pecheasoft.odigen.sql.parse.algebra.TableKey;
import org.pecheasoft.odigen.sql.parse.algebra.TablePrimarySubQuery;
import org.pecheasoft.odigen.sql.parse.algebra.TargetColumn;
import org.pecheasoft.odigen.sql.parse.algebra.TimeLiteral;
import org.pecheasoft.odigen.sql.parse.algebra.TimeValue;
import org.pecheasoft.odigen.sql.parse.algebra.TimestampLiteral;
import org.pecheasoft.odigen.sql.parse.algebra.TruncateTable;
import org.pecheasoft.odigen.sql.parse.algebra.Unpivot;
import org.pecheasoft.odigen.sql.parse.algebra.ValueListExpr;
import org.pecheasoft.odigen.sql.parse.algebra.Window;
import org.pecheasoft.odigen.sql.parse.algebra.WindowFunctionExpr;
import org.pecheasoft.odigen.sql.parse.algebra.WindowSpec;
import org.pecheasoft.odigen.sql.parse.algebra.WindowSpec.WindowFrameEndBoundType;
import org.pecheasoft.odigen.sql.parse.algebra.WindowSpec.WindowFrameStartBoundType;
import org.pecheasoft.odigen.sql.parser.SQLParser;
import static org.pecheasoft.odigen.sql.parser.SQLParser.ADD;
import static org.pecheasoft.odigen.sql.parser.SQLParser.ALL;
import static org.pecheasoft.odigen.sql.parser.SQLParser.ALTERNATE_KEY;
import org.pecheasoft.odigen.sql.parser.SQLParser.Annotated_joined_table_primaryContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.AnnotationContext;
import static org.pecheasoft.odigen.sql.parser.SQLParser.COLUMN;
import org.pecheasoft.odigen.sql.parser.SQLParser.Case_abbreviationContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Character_factorContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Column_nameContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Column_reference_listContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Common_value_expressionContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Constraint_controlContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Convert_specificationContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Cursor_functionContext;
import static org.pecheasoft.odigen.sql.parser.SQLParser.DIVIDE;
import org.pecheasoft.odigen.sql.parser.SQLParser.Datastore_checkContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Datastore_constraintContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Datastore_keyContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Derived_columnContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Extract_expressionContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.FactorContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Field_elementContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.File_descriptorContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.File_resource_nameContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Hash_partitionsContext;
import static org.pecheasoft.odigen.sql.parser.SQLParser.INTERSECT;
import org.pecheasoft.odigen.sql.parser.SQLParser.IdentifierContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.In_databaseContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Index_inlineContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Integration_paramsContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Is_clauseContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.List_partitionsContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.List_value_partitionContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Listagg_functionContext;
import static org.pecheasoft.odigen.sql.parser.SQLParser.MODIFY;
import static org.pecheasoft.odigen.sql.parser.SQLParser.MULTIPLY;
import org.pecheasoft.odigen.sql.parser.SQLParser.Modify_field_elementContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Negativable_matcherContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Non_join_query_termContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Numeric_value_functionContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Ordinary_grouping_setContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Ordinary_grouping_set_listContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Outer_join_type_part2Context;
import static org.pecheasoft.odigen.sql.parser.SQLParser.PLUS;
import static org.pecheasoft.odigen.sql.parser.SQLParser.PRIMARY_KEY;
import org.pecheasoft.odigen.sql.parser.SQLParser.Qualified_asteriskContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Quantified_comparison_predicateContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Query_expressionContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Query_primaryContext;
import static org.pecheasoft.odigen.sql.parser.SQLParser.RENAME;
import org.pecheasoft.odigen.sql.parser.SQLParser.Range_partitionsContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Range_value_clauseContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Rank_function_typeContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Regex_matcherContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.ResultContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Row_value_predicand_listContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.ScriptContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Searched_when_clauseContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Simple_when_clauseContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.SingleSqlScriptContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Sort_specifier_listContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.SqlContext;
import static org.pecheasoft.odigen.sql.parser.SQLParser.TO;
import org.pecheasoft.odigen.sql.parser.SQLParser.Table_nameContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.TermContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Trim_specificationContext;
import static org.pecheasoft.odigen.sql.parser.SQLParser.UNION;
import org.pecheasoft.odigen.sql.parser.SQLParser.Unpivot_clauseContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Unpivot_ruleContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Unpivot_rulesContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Unpivot_source_fields_listContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Window_definitionContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Window_frame_betweenContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Window_frame_clauseContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Window_frame_end_boundContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Window_frame_start_boundContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Window_function_typeContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Window_name_or_specificationContext;
import org.pecheasoft.odigen.sql.parser.SQLParser.Window_specification_detailsContext;
import org.pecheasoft.odigen.sql.parser.SQLParserBaseVisitor;
import org.pecheasoft.odigen.sql.util.CatalogConstants;
import org.pecheasoft.odigen.sql.util.CatalogUtil;
import org.pecheasoft.odigen.sql.util.StringUtil;
import org.pecheasoft.odigen.sql.util.TUtil;
import org.pecheasoft.odigen.sql.util.annotation.Annotation;
import org.pecheasoft.odigen.sql.util.annotation.impl.DefaultAnnotation;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.pecheasoft.odigen.sql.parse.algebra.BinaryOperator.Operator;
import org.pecheasoft.odigen.sql.parse.algebra.PatternMatchPredicate.MatchType;

public class SQLAnalyzer extends SQLParserBaseVisitor<Expr> {

    public SQLAnalyzer() {
    }

    protected static boolean checkIfExist(Object obj) {
        return obj != null;
    }

    @Override
    public Expr visitScript(ScriptContext ctx) {        
        int statementsNr = ctx.sql().size();
        
        List<Expr> statements = ctx.sql().stream().map(this::visitSql).collect(Collectors.toList());
        Expr[] statementsArry = statements.toArray(new Expr[statementsNr]);
        
        return new MultiaryOperator(statementsArry);
    }

    @Override
    public Expr visitSingleSqlScript(SingleSqlScriptContext ctx) {
        // extract the text of the statements        
        int a = ctx.start.getStartIndex();
        int b = ctx.stop.getStopIndex();
        Interval interval = new Interval(a,b);
        String sqlText = ctx.start.getInputStream().getText(interval);

        Expr statement = visit(ctx.statement());
        statement.setText(sqlText);        
        
        if (checkIfExist(ctx.explain_clause())) {
            return new Explain(statement);
        } else {
            return statement;
        }        
    }
    
    @Override
    public Expr visitSql(SqlContext ctx) {
        // extract the text of the statements        
        int a = ctx.start.getStartIndex();
        int b = ctx.stop.getStopIndex();
        Interval interval = new Interval(a,b);
        String sqlText = ctx.start.getInputStream().getText(interval);

        Expr statement = visit(ctx.statement());
        statement.setText(sqlText);        
        
        if (checkIfExist(ctx.explain_clause())) {
            return new Explain(statement);
        } else {
            return statement;
        }
    }

    @Override
    public Expr visitSession_statement(SQLParser.Session_statementContext ctx) {

        if (checkIfExist(ctx.CATALOG())) {

            return new SetSession("CURRENT_DATABASE", ctx.dbname.getText());

        } else if (checkIfExist(ctx.name)) {
            String value;
            if (checkIfExist(ctx.boolean_literal())) {
                value = ctx.boolean_literal().getText();
            } else if (checkIfExist(ctx.Character_String_Literal())) {
                value = stripQuote(ctx.Character_String_Literal().getText());
            } else if (checkIfExist(ctx.signed_numerical_literal())) {
                value = ctx.signed_numerical_literal().getText();
            } else {
                value = null;
            }
            return new SetSession(ctx.name.getText(), value);

        } else if (checkIfExist(ctx.TIME()) && checkIfExist(ctx.ZONE())) {

            String value;
            if (checkIfExist(ctx.Character_String_Literal())) {
                value = stripQuote(ctx.Character_String_Literal().getText());
            } else if (checkIfExist(ctx.signed_numerical_literal())) {
                value = ctx.signed_numerical_literal().getText();
            } else {
                value = null;
            }
            return new SetSession("TIMEZONE", value);

        } else {
            throw new SQLSyntaxError("Unsupported session statement");
        }
    }

    @Override
    public Expr visitNon_join_query_expression(SQLParser.Non_join_query_expressionContext ctx) {

        Expr current = visitNon_join_query_term(ctx.non_join_query_term());
        if (ctx.getChildCount() == 1) {
            return current;
        }

        SetOperation.Type operatorType;

        if (ctx.getChildCount() > 1) {
            List<Expr> operands = TUtil.newList();
            List<Boolean> distInds = TUtil.newList();
            List<SetOperation.Type> opTypes = TUtil.newList();

            operands.add(current);
            distInds.add(null);
            opTypes.add(null);

            for (int i = 1; i < ctx.getChildCount(); i++) {
                int idx = i;
                boolean distinct = true;

                if (ctx.getChild(idx) instanceof TerminalNode terminalNode) {
                    if (terminalNode.getSymbol().getType() == UNION) {
                        operatorType = SetOperation.Type.UNION;
                    } else {
                        operatorType = SetOperation.Type.EXCEPT;
                    }

                    idx++;

                    if (ctx.getChild(idx) instanceof TerminalNode) {
                        if (terminalNode.getSymbol().getType() == ALL) {
                            distinct = false;
                        }

                        idx++;
                    }

                    SQLParser.Query_termContext queryTermContext
                            = (SQLParser.Query_termContext) ctx.getChild(idx);
                    Expr right = visitQuery_term(queryTermContext);

                    operands.add(right);
                    distInds.add(distinct);
                    opTypes.add(operatorType);

                    i = idx;
                }
            }
            

            SetOperation setOp = new SetOperation(SetOperation.Type.UNION, operands.toArray(Expr[]::new), opTypes.toArray(SetOperation.Type[]::new),
                    distInds.toArray(Boolean[]::new));
            
            if (checkIfExist(ctx.annotation())) {
                Collection<Annotation> annotations = getAnnotations(ctx.annotation());
                setOp.setAnnotations(annotations);            
            }  
            
            return setOp;
        }

        return current;

    }

    @Override
    public Expr visitNon_join_query_term(Non_join_query_termContext ctx) {

        Expr current = visitNon_join_query_primary(ctx.non_join_query_primary());

        if (ctx.getChildCount() > 1) {
            List<Expr> operands = TUtil.newList();
            List<Boolean> distInds = TUtil.newList();
            List<SetOperation.Type> opTypes = TUtil.newList();

            operands.add(current);
            distInds.add(null);
            opTypes.add(null);

            for (int i = 1; i < ctx.getChildCount();) {
                int idx = i;
                boolean distinct = true;

                if (ctx.getChild(idx) instanceof TerminalNode terminalNode) {
                    if (terminalNode.getSymbol().getType() == INTERSECT) {
                        idx++;
                    }

                    if (ctx.getChild(idx) instanceof TerminalNode) {
                        if (terminalNode.getSymbol().getType() == ALL) {
                            distinct = false;
                            idx++;
                        }
                    }

                    Query_primaryContext queryPrimaryContext = (Query_primaryContext) ctx.getChild(idx);
                    Expr right = visitQuery_primary(queryPrimaryContext);

                    operands.add(right);
                    distInds.add(distinct);
                    opTypes.add(SetOperation.Type.INTERSECT);

                    i += idx;
                }
            }
            return new SetOperation(SetOperation.Type.INTERSECT, operands.toArray(Expr[]::new), opTypes.toArray(SetOperation.Type[]::new),
                    distInds.toArray(Boolean[]::new));
        }
        return current;
    }

    @Override
    public Expr visitQuery_specification(SQLParser.Query_specificationContext ctx) {
        Expr current = null;
        if (ctx.table_expression() != null) {
            current = visitFrom_clause(ctx.table_expression().from_clause());
            
            if (ctx.table_expression().where_clause() != null) {
                Selection selection = visitWhere_clause(ctx.table_expression().where_clause());
                selection.setChild(current);
                current = selection;
            }

            if (ctx.table_expression().groupby_clause() != null) {
                Aggregation aggregation = visitGroupby_clause(ctx.table_expression().groupby_clause());
                aggregation.setChild(current);
                current = aggregation;

                if (ctx.table_expression().having_clause() != null) {
                    Expr havingCondition = visitBoolean_value_expression(
                            ctx.table_expression().having_clause().boolean_value_expression());
                    Having having = new Having(havingCondition);
                    having.setText(ctx.table_expression().having_clause().getText());
                    having.setChild(current);
                    current = having;
                }
            }
            
            if (ctx.table_expression().unpivot_clause()!= null) {
                Unpivot unpivot = visitUnpivot_clause(ctx.table_expression().unpivot_clause());
                unpivot.setChild(current);
                current = unpivot;
            }

            if (ctx.table_expression().orderby_clause() != null) {
                Sort sort = visitOrderby_clause(ctx.table_expression().orderby_clause());
                sort.setChild(current);
                current = sort;
            }

            if (checkIfExist(ctx.table_expression().window_clause())) {
                Window window = visitWindow_clause(ctx.table_expression().window_clause());
                window.setChild(current);
                current = window;
            }

            if (ctx.table_expression().limit_clause() != null) {
                Limit limit = visitLimit_clause(ctx.table_expression().limit_clause());
                limit.setChild(current);
                current = limit;
            }
            
        }

        Projection projection = visitSelect_list(ctx.select_list());

        if (ctx.set_qualifier() != null && ctx.set_qualifier().DISTINCT() != null) {
            projection.setDistinct();
        }

        if (ctx.dataset_hint() != null) {
            DatasetHint hint = new DatasetHint();

            if (ctx.dataset_hint().identifier() != null) {
                hint.setDatasetName(ctx.dataset_hint().identifier().toString());
            }

            projection.setDatasetHint(hint);
        }
        
        if (checkIfExist(ctx.annotation())) {
            Collection<Annotation> annotations = getAnnotations(ctx.annotation());
            projection.setAnnotations(annotations);            
        }        

        if (current != null) {
            projection.setChild(current);
        }

        current = projection;

        return current;
    }

    /**
     * <pre>
     *   select_list
     *   : select_sublist (COMMA select_sublist)*
     *   ;
     * </pre>
     *
     * @param ctx
     * @return
     */
    @Override
    public Projection visitSelect_list(SQLParser.Select_listContext ctx) {
        Projection projection = new Projection();
        NamedExpr[] targets = new NamedExpr[ctx.select_sublist().size()];
        for (int i = 0; i < targets.length; i++) {
            targets[i] = visitSelect_sublist(ctx.select_sublist(i));
        }
        projection.setNamedExprs(targets);

        return projection;
    }

    /**
     * <pre>
     *   select_sublist
     *   : derived_column
     *   | asterisked_qualifier
     *   ;
     * </pre>
     *
     * @param ctx
     * @return
     */
    @Override
    public NamedExpr visitSelect_sublist(SQLParser.Select_sublistContext ctx) {
        if (ctx.qualified_asterisk() != null) {
            return visitQualified_asterisk(ctx.qualified_asterisk());
        } else {
            return visitDerived_column(ctx.derived_column());
        }
    }

    @Override
    public RelationList visitFrom_clause(SQLParser.From_clauseContext ctx) {
        Expr[] relations = new Expr[ctx.table_reference_list().table_reference().size()];
        for (int i = 0; i < relations.length; i++) {
            relations[i] = visitTable_reference(ctx.table_reference_list().table_reference(i));
        }
        return new RelationList(relations);
    }

    @Override
    public Unpivot visitUnpivot_clause(Unpivot_clauseContext ctx) {
        
        String locatorFieldName = null;
        Map<String, Collection<String>> pivotMap = TUtil.newHashMap();
        
        if (checkIfExist(ctx.locator.Regular_Identifier())) {
            locatorFieldName = ctx.locator.Regular_Identifier().getText(); 
        }
        
        Unpivot_rulesContext rulesCtx = ctx.unpivot_rules();
        
        Collection<String> pivotSourceFieldsList = ctx.unpivot_fields_list().identifier()
                .stream()
                .map(IdentifierContext::Regular_Identifier)
                .map(TerminalNode::getText)
                .collect(Collectors.toList());   
                
        for (Unpivot_ruleContext ruleCtx : rulesCtx.unpivot_rule()) {
            Unpivot_source_fields_listContext ruleFieldsListCtx = ruleCtx.unpivot_source_fields_list();
            
            List<String> ruleFieldList = ruleFieldsListCtx.common_value_expression()
                    .stream()
                    .map(Common_value_expressionContext::getText)
                    //.map(TerminalNode::getText)
                    .collect(Collectors.toList());
            
            String locatorValue = null;
            
            if (checkIfExist(ruleCtx.Character_String_Literal())) {
                locatorValue = ruleCtx.Character_String_Literal().getText();
            } else if (checkIfExist(ruleCtx.signed_numerical_literal())) {
                locatorValue = ruleCtx.signed_numerical_literal().getText();
            }
            
            pivotMap.put(locatorValue, ruleFieldList);
            
        }
        
        return new Unpivot(ctx.alias.getText(), pivotSourceFieldsList, locatorFieldName, pivotMap);
    }
    
    @Override
    public Selection visitWhere_clause(SQLParser.Where_clauseContext ctx) {
        Selection selection = new Selection(visitSearch_condition(ctx.search_condition()));
        selection.setText(getRuleText(ctx));
        
        return selection;
    }

    @Override
    public Aggregation visitGroupby_clause(SQLParser.Groupby_clauseContext ctx) {
        Aggregation clause = new Aggregation();

        // If grouping group is not empty
        if (ctx.grouping_element_list().grouping_element().get(0).empty_grouping_set() == null) {
            int elementSize = ctx.grouping_element_list().grouping_element().size();
            ArrayList<GroupElement> groups = new ArrayList<>(elementSize + 1);
            ArrayList<Expr> ordinaryExprs = null;
            int groupSize = 1;
            groups.add(null);

            for (int i = 0; i < elementSize; i++) {
                SQLParser.Grouping_elementContext element
                        = ctx.grouping_element_list().grouping_element().get(i);
                if (element.ordinary_grouping_set() != null) {
                    if (ordinaryExprs == null) {
                        ordinaryExprs = new ArrayList<>();
                    }
                    Collections.addAll(ordinaryExprs, getRowValuePredicandsFromOrdinaryGroupingSet(element.ordinary_grouping_set()));
                } else if (element.rollup_list() != null) {
                    groupSize++;
                    groups.add(new GroupElement(GroupType.Rollup,
                            getRowValuePredicandsFromOrdinaryGroupingSetList(element.rollup_list().c)));
                } else if (element.cube_list() != null) {
                    groupSize++;
                    groups.add(new GroupElement(GroupType.Cube,
                            getRowValuePredicandsFromOrdinaryGroupingSetList(element.cube_list().c)));
                }
            }

            if (ordinaryExprs != null) {
                groups.set(0, new GroupElement(GroupType.OrdinaryGroup, ordinaryExprs.toArray(Expr[]::new)));
                clause.setGroups(groups.subList(0, groupSize).toArray(new GroupElement[groupSize]));
            } else if (groupSize > 1) {
                clause.setGroups(groups.subList(1, groupSize).toArray(new GroupElement[groupSize - 1]));
            }
            
            if (checkIfExist(ctx.annotation())) {
                Collection<Annotation> annotations = getAnnotations(ctx.annotation());
                clause.setAnnotations(annotations);            
            }              
        }

        return clause;
    }

    @Override
    public Expr visitListagg_function(Listagg_functionContext ctx) {
        GeneralSetFunctionExpr functionBody;

        Expr[] operands = new Expr[ctx.value_expression().size()];
        
        for (int i = 0; i < ctx.value_expression().size(); i++) {
            Expr operand = visitValue_expression(ctx.value_expression(i));
            operands[i] = operand;
        }
                
        functionBody = new GeneralSetFunctionExpr("listagg", false, operands);
        
        WindowFunctionExpr windowFunction = new WindowFunctionExpr(functionBody);
        
        WindowSpec windowSpec = null;
        
        if (checkIfExist(ctx.window_name_or_specification())) {
            Window_name_or_specificationContext windowNameOrSpec = ctx.window_name_or_specification();
            if (checkIfExist(windowNameOrSpec.window_name())) {
                windowFunction.setWindowName(windowNameOrSpec.window_name().getText());
            } else {
                windowSpec = buildWindowSpec(windowNameOrSpec.window_specification());                
            }            
        }  
        
        if (checkIfExist(ctx.orderby_clause())) {
            if (windowSpec == null) {
                windowSpec = new WindowSpec();
            }
            windowSpec.setSortSpecs(buildSortSpecs(ctx.orderby_clause().sort_specifier_list()));
        }
        
        windowFunction.setWindowSpec(windowSpec);
                                      
        return windowFunction;
    }
        
    @Override
    public WindowFunctionExpr visitWindow_function(SQLParser.Window_functionContext context) {
        WindowFunctionExpr windowFunction;

        Window_function_typeContext functionType = context.window_function_type();
        GeneralSetFunctionExpr functionBody;
        if (checkIfExist(functionType.rank_function_type())) {
            Rank_function_typeContext rankFunction = functionType.rank_function_type();
            if (checkIfExist(rankFunction.RANK())) {
                functionBody = new GeneralSetFunctionExpr("rank", false, new Expr[]{});
            } else if (checkIfExist(rankFunction.DENSE_RANK())) {
                functionBody = new GeneralSetFunctionExpr("dense_rank", false, new Expr[]{});
            } else if (checkIfExist(rankFunction.PERCENT_RANK())) {
                functionBody = new GeneralSetFunctionExpr("percent_rank", false, new Expr[]{});
            } else {
                functionBody = new GeneralSetFunctionExpr("cume_dist", false, new Expr[]{});
            }
        } else if (checkIfExist(functionType.ROW_NUMBER())) {
            functionBody = new GeneralSetFunctionExpr("row_number", false, new Expr[]{});
        } else if (checkIfExist(functionType.FIRST_VALUE())) {
            functionBody = new GeneralSetFunctionExpr("first_value", false, new Expr[]{visitValue_expression(functionType.value_expression())});
        } else if (checkIfExist(functionType.LAST_VALUE())) {
            functionBody = new GeneralSetFunctionExpr("last_value", false, new Expr[]{visitValue_expression(functionType.value_expression())});
        } else if (checkIfExist(functionType.LAG())) {
            if (checkIfExist(functionType.numeric_value_expression())) {
                if (checkIfExist(functionType.common_value_expression())) {
                    functionBody = new GeneralSetFunctionExpr("lag", false, new Expr[]{
                        visitValue_expression(functionType.value_expression()),
                        visitNumeric_value_expression(functionType.numeric_value_expression()),
                        visitCommon_value_expression(functionType.common_value_expression())});
                } else {
                    functionBody = new GeneralSetFunctionExpr("lag", false, new Expr[]{
                        visitValue_expression(functionType.value_expression()),
                        visitNumeric_value_expression(functionType.numeric_value_expression())});
                }
            } else {
                functionBody = new GeneralSetFunctionExpr("lag", false, new Expr[]{visitValue_expression(functionType.value_expression())});
            }
        } else if (checkIfExist(functionType.LEAD())) {
            if (checkIfExist(functionType.numeric_value_expression())) {
                if (checkIfExist(functionType.common_value_expression())) {
                    functionBody = new GeneralSetFunctionExpr("lead", false, new Expr[]{visitValue_expression(functionType.value_expression()),
                        visitNumeric_value_expression(functionType.numeric_value_expression()),
                        visitCommon_value_expression(functionType.common_value_expression())});
                } else {
                    functionBody = new GeneralSetFunctionExpr("lead", false, new Expr[]{visitValue_expression(functionType.value_expression()),
                        visitNumeric_value_expression(functionType.numeric_value_expression())});
                }
            } else {
                functionBody = new GeneralSetFunctionExpr("lead", false, new Expr[]{visitValue_expression(functionType.value_expression())});
            }
        } else {
            functionBody = visitAggregate_function(functionType.aggregate_function());
        }
        windowFunction = new WindowFunctionExpr(functionBody);

        Window_name_or_specificationContext windowNameOrSpec = context.window_name_or_specification();
        if (checkIfExist(windowNameOrSpec.window_name())) {
            windowFunction.setWindowName(windowNameOrSpec.window_name().getText());
        } else {
            windowFunction.setWindowSpec(buildWindowSpec(windowNameOrSpec.window_specification()));
        }
        
        if (checkIfExist(functionType.window_function_nulls_clause())) {
            String whatToDoWithNulls = functionType.window_function_nulls_clause().getText();
            windowFunction.setNullOption(whatToDoWithNulls);
        }        

        return windowFunction;
    }

    @Override
    public Window visitWindow_clause(SQLParser.Window_clauseContext ctx) {
        Window.WindowDefinition[] definitions
                = new Window.WindowDefinition[ctx.window_definition_list().window_definition().size()];
        for (int i = 0; i < definitions.length; i++) {
            Window_definitionContext windowDefinitionContext = ctx.window_definition_list().window_definition(i);
            String windowName = windowDefinitionContext.window_name().identifier().getText();
            WindowSpec windowSpec = buildWindowSpec(windowDefinitionContext.window_specification());
            definitions[i] = new Window.WindowDefinition(windowName, windowSpec);
        }
        return new Window(definitions);
    }

    public WindowSpec buildWindowSpec(SQLParser.Window_specificationContext ctx) {
        WindowSpec windowSpec = new WindowSpec();
        if (checkIfExist(ctx.window_specification_details())) {
            Window_specification_detailsContext windowSpecDetail = ctx.window_specification_details();

            if (checkIfExist(windowSpecDetail.existing_window_name())) {
                windowSpec.setWindowName(windowSpecDetail.existing_window_name().getText());
            }

            if (checkIfExist(windowSpecDetail.window_partition_clause())) {
                windowSpec.setPartitionKeys(
                        buildRowValuePredicands(windowSpecDetail.window_partition_clause().row_value_predicand_list()));
            }

            if (checkIfExist(windowSpecDetail.window_order_clause())) {
                windowSpec.setSortSpecs(
                        buildSortSpecs(windowSpecDetail.window_order_clause().orderby_clause().sort_specifier_list()));
            }

            if (checkIfExist(windowSpecDetail.window_frame_clause())) {
                Window_frame_clauseContext frameContext = windowSpecDetail.window_frame_clause();

                WindowSpec.WindowFrameUnit unit;
                // frame unit - there are only two cases: RANGE and ROW
                if (checkIfExist(frameContext.window_frame_units().RANGE())) {
                    unit = WindowSpec.WindowFrameUnit.RANGE;
                } else {
                    unit = WindowSpec.WindowFrameUnit.ROW;
                }

                WindowSpec.WindowFrame windowFrame;

                if (checkIfExist(frameContext.window_frame_extent().window_frame_between())) { // when 'between' is given
                    Window_frame_betweenContext between = frameContext.window_frame_extent().window_frame_between();
                    WindowSpec.WindowStartBound startBound = buildWindowStartBound(between.window_frame_start_bound());
                    WindowSpec.WindowEndBound endBound = buildWindowEndBound(between.window_frame_end_bound());

                    windowFrame = new WindowSpec.WindowFrame(unit, startBound, endBound);
                } else { // if there is only start bound
                    WindowSpec.WindowStartBound startBound
                            = buildWindowStartBound(frameContext.window_frame_extent().window_frame_start_bound());
                    windowFrame = new WindowSpec.WindowFrame(unit, startBound);
                }

                windowSpec.setWindowFrame(windowFrame);
            }
        }
        return windowSpec;
    }

    public WindowSpec.WindowStartBound buildWindowStartBound(Window_frame_start_boundContext context) {
        WindowFrameStartBoundType boundType;
        if (checkIfExist(context.UNBOUNDED())) {
            boundType = WindowFrameStartBoundType.UNBOUNDED_PRECEDING;
        } else if (checkIfExist(context.unsigned_value_specification())) {
            boundType = WindowFrameStartBoundType.PRECEDING;
        } else {
            boundType = WindowFrameStartBoundType.CURRENT_ROW;
        }

        WindowSpec.WindowStartBound bound = new WindowSpec.WindowStartBound(boundType);
        if (boundType == WindowFrameStartBoundType.PRECEDING) {
            bound.setNumber(visitUnsigned_value_specification(context.unsigned_value_specification()));
        }

        return bound;
    }

    public WindowSpec.WindowEndBound buildWindowEndBound(Window_frame_end_boundContext context) {
        WindowFrameEndBoundType boundType;
        if (checkIfExist(context.UNBOUNDED())) {
            boundType = WindowFrameEndBoundType.UNBOUNDED_FOLLOWING;
        } else if (checkIfExist(context.unsigned_value_specification())) {
            boundType = WindowFrameEndBoundType.FOLLOWING;
        } else {
            boundType = WindowFrameEndBoundType.CURRENT_ROW;
        }

        WindowSpec.WindowEndBound endBound = new WindowSpec.WindowEndBound(boundType);
        if (boundType == WindowFrameEndBoundType.FOLLOWING) {
            endBound.setNumber(visitUnsigned_value_specification(context.unsigned_value_specification()));
        }

        return endBound;
    }

    public Sort.SortSpec[] buildSortSpecs(Sort_specifier_listContext context) {
        int size = context.sort_specifier().size();

        Sort.SortSpec specs[] = new Sort.SortSpec[size];
        for (int i = 0; i < size; i++) {
            SQLParser.Sort_specifierContext specContext = context.sort_specifier(i);
            Expr sortKeyExpr = visitRow_value_predicand(specContext.key);
            specs[i] = new Sort.SortSpec(sortKeyExpr);
            if (specContext.order_specification() != null) {
                if (specContext.order.DESC() != null) {
                    specs[i].setDescending();
                }
            }

            if (specContext.null_ordering() != null) {
                if (specContext.null_ordering().FIRST() != null) {
                    specs[i].setNullFirst();
                }
            }
        }

        return specs;
    }

    @Override
    public Sort visitOrderby_clause(SQLParser.Orderby_clauseContext ctx) {
        Sort orderBy = new Sort(buildSortSpecs(ctx.sort_specifier_list()));
        
        if (checkIfExist(ctx.annotation())) {
            Collection<Annotation> annotations = getAnnotations(ctx.annotation());
            orderBy.setAnnotations(annotations);            
        }
        
        return orderBy;
    }

    @Override
    public Limit visitLimit_clause(SQLParser.Limit_clauseContext ctx) {
        return new Limit(visitNumeric_value_expression(ctx.numeric_value_expression()));
    }

    @Override
    public Expr visitJoined_table(SQLParser.Joined_tableContext ctx) {
        Expr top = visitTable_primary(ctx.table_primary());        
        
        // The following loop builds a left deep join tree.
        Join join;
        for (int i = 0; i < ctx.annotated_joined_table_primary().size(); i++) {
            join = visitAnnotated_joined_table_primary(ctx.annotated_joined_table_primary(i));
            join.setLeft(top);

            top = join;            
        }

        return top;
    }

    @Override
    public Join visitAnnotated_joined_table_primary(Annotated_joined_table_primaryContext ctx) {
        Join join = visitJoined_table_primary(ctx.joined_table_primary());
        if (checkIfExist(ctx.annotation())) {
            Collection<Annotation> annotations = getAnnotations(ctx.annotation());
            join.setAnnotations(annotations);            
        }
        
        return join;
    }
    
    
    
    @Override
    public Join visitJoined_table_primary(SQLParser.Joined_table_primaryContext ctx) {
        Join join;
        if (ctx.CROSS() != null) {
            join = new Join(JoinType.CROSS);
        } else if (ctx.UNION() != null) {
            join = new Join(JoinType.UNION);
        } else { // qualified join or natural
            if (ctx.join_type() != null && ctx.join_type().outer_join_type() != null) {
                Outer_join_type_part2Context outer_join_typeContext = ctx.join_type().outer_join_type()
                        .outer_join_type_part2();
                if (outer_join_typeContext.FULL() != null) {
                    join = new Join(JoinType.FULL_OUTER);
                } else if (outer_join_typeContext.LEFT() != null) {
                    join = new Join(JoinType.LEFT_OUTER);
                } else {
                    join = new Join(JoinType.RIGHT_OUTER);
                }
            } else {
                join = new Join(JoinType.INNER);
            }

            if (ctx.NATURAL() != null) {
                join.setNatural();
            }

            if (ctx.join_specification() != null) { // only for qualified join
                if (ctx.join_specification().join_condition() != null) {
                    Expr searchCondition = visitSearch_condition(ctx.join_specification().
                            join_condition().search_condition());
                    join.setQual(searchCondition);
                    join.setText(getRuleText(ctx.join_specification().join_condition().search_condition()));
                } else if (ctx.join_specification().named_columns_join() != null) {
                    ColumnReferenceExpr[] columns = buildColumnReferenceList(ctx.join_specification().
                            named_columns_join().column_reference_list());
                    join.setJoinColumns(columns);
                    join.setText(getRuleText(ctx.join_specification().
                            named_columns_join().column_reference_list()));
                }
                
            }                        

        }

        //join.setRight(visitTable_primary(ctx.right));
        join.setRight(visitJoined_table(ctx.right));
        return join;
    }

    protected Expr[] getRowValuePredicandsFromOrdinaryGroupingSetList(Ordinary_grouping_set_listContext ctx) {
        ArrayList<Expr> rowValuePredicands = new ArrayList<>();
        for (int i = 0; i < ctx.ordinary_grouping_set().size(); i++) {
            Collections.addAll(rowValuePredicands, getRowValuePredicandsFromOrdinaryGroupingSet(ctx.ordinary_grouping_set(i)));
        }
        return rowValuePredicands.toArray(Expr[]::new);
    }

    protected Expr[] getRowValuePredicandsFromOrdinaryGroupingSet(Ordinary_grouping_setContext ctx) {
        ArrayList<Expr> rowValuePredicands = new ArrayList<>();
        if (ctx.row_value_predicand() != null) {
            Expr rowValPredicand = visitRow_value_predicand(ctx.row_value_predicand());
            rowValPredicand.setText(getRuleText(ctx.row_value_predicand()));
            rowValuePredicands.add(rowValPredicand);
            //rowValuePredicands.add(visitRow_value_predicand(ctx.row_value_predicand()));
        }
        if (ctx.row_value_predicand_list() != null) {
            Collections.addAll(rowValuePredicands, buildRowValuePredicands(ctx.row_value_predicand_list()));
        }
        return rowValuePredicands.toArray(Expr[]::new);
    }

    protected Expr[] buildRowValuePredicands(Row_value_predicand_listContext ctx) {
        Expr[] rowValuePredicands = new Expr[ctx.row_value_predicand().size()];
        for (int i = 0; i < rowValuePredicands.length; i++) {
            rowValuePredicands[i] = visitRow_value_predicand(ctx.row_value_predicand(i));
        }
        return rowValuePredicands;
    }

    protected ColumnReferenceExpr[] buildColumnReferenceList(Column_reference_listContext ctx) {
        ColumnReferenceExpr[] columnRefs = new ColumnReferenceExpr[ctx.column_reference().size()];
        for (int i = 0; i < columnRefs.length; i++) {
            columnRefs[i] = visitColumn_reference(ctx.column_reference(i));
        }
        return columnRefs;
    }

    @Override
    public Expr visitTable_primary(SQLParser.Table_primaryContext ctx) {
        if (ctx.table_or_query_name() != null) {
            Relation relation = new Relation(ctx.table_or_query_name().getText());
            if (ctx.alias != null) {
                relation.setAlias(ctx.alias.getText());
            }
            return relation;
        } else if (ctx.derived_table() != null) {
            return new TablePrimarySubQuery(ctx.name.getText(), visit(ctx.derived_table().table_subquery()));
        } else if (ctx.table_function() != null) {
            TargetColumn[] cols = null;
            if (ctx.column_name_list() != null) {
                int nrOfCols = ctx.column_name_list().target_column().size();
                cols = new TargetColumn[nrOfCols];
                
                for (int i = 0; i < nrOfCols; i++) {
                    cols[i] = new TargetColumn(ctx.column_name_list().target_column(i).identifier().getText());
                }
            }
            FunctionExpr funcExpr = visitRoutine_invocation(ctx.table_function().routine_invocation());
            
            return new TableFunction(ctx.alias.getText(), funcExpr, cols);
        } else {
            return null;
        }
    }

    @Override
    public Expr visitCursor_function(Cursor_functionContext ctx) {
        ctx.table_subquery();
        //return new TablePrimarySubQuery(RandomStringUtils.random(8, true, false), visit(ctx.table_subquery()));
        return new TablePrimarySubQuery("", visit(ctx.table_subquery()));
    }

    
    @Override
    public Expr visitSubquery(SQLParser.SubqueryContext ctx) {
        return visitQuery_expression(ctx.query_expression());
    }
    
    @Override
    public Expr visitQuery_expression(Query_expressionContext ctx) {
        Query query = new Query();
        
        if (checkIfExist(ctx.with_clause())) {
            List<Expr> namedQueries = TUtil.newList();
            ctx.with_clause().named_query().stream().map((named_query_ctx) -> {
                NamedQuery namedQry = new NamedQuery(named_query_ctx.name.getText());
                namedQry.setChild(visitQuery_expression_body(named_query_ctx.query_expression_body()));
                return namedQry;
            }).forEachOrdered(namedQueries::add);
            query.setWithQueries(namedQueries);
        }
        query.setChild(super.visitQuery_expression(ctx));
        return query;
    }

    @Override
    public BetweenPredicate visitBetween_predicate(SQLParser.Between_predicateContext ctx) {
        Expr predicand = visitRow_value_predicand(ctx.predicand);
        Expr begin = visitRow_value_predicand(ctx.between_predicate_part_2().begin);
        Expr end = visitRow_value_predicand(ctx.between_predicate_part_2().end);
        return new BetweenPredicate(checkIfExist(ctx.between_predicate_part_2().NOT()),
                checkIfExist(ctx.between_predicate_part_2().SYMMETRIC()), predicand, begin, end);
    }

    @Override
    public CaseWhenPredicate visitSimple_case(SQLParser.Simple_caseContext ctx) {
        Expr leftTerm = visitBoolean_value_expression(ctx.boolean_value_expression());
        CaseWhenPredicate caseWhen = new CaseWhenPredicate();

        for (int i = 0; i < ctx.simple_when_clause().size(); i++) {
            Simple_when_clauseContext simpleWhenCtx = ctx.simple_when_clause(i);
            BinaryOperator bin = new BinaryOperator(Operator.Equals, leftTerm,
                    visitValue_expression(simpleWhenCtx.search_condition().value_expression()));
            caseWhen.addWhen(bin, buildCaseResult(simpleWhenCtx.result()));
        }
        if (ctx.else_clause() != null) {
            caseWhen.setElseResult(buildCaseResult(ctx.else_clause().result()));
        }
        return caseWhen;
    }

    @Override
    public Expr visitCase_abbreviation(Case_abbreviationContext ctx) {
        List<Expr> operands = TUtil.newList();
        Expr expr = null;

        for (int i = 0; i < ctx.value_expression().size(); i++) {
            Expr operand = visitValue_expression(ctx.value_expression(i));
            operands.add(operand);
        }

        if (ctx.COALESCE() != null) {
            expr = new CoalesceExpr(operands);
        } else if (ctx.NULLIF() != null) {
            expr = new NullifExpr(operands);
        }

        return expr;
    }

    protected Expr buildCaseResult(ResultContext result) {
        if (result.NULL() != null) {
            return new NullLiteral();
        } else {
            return visitValue_expression(result.value_expression());
        }
    }

    @Override
    public CaseWhenPredicate visitSearched_case(SQLParser.Searched_caseContext ctx) {
        CaseWhenPredicate caseWhen = new CaseWhenPredicate();

        for (int i = 0; i < ctx.searched_when_clause().size(); i++) {
            Searched_when_clauseContext searchedWhenCtx = ctx.searched_when_clause(i);
            caseWhen.addWhen(
                    visitSearch_condition(searchedWhenCtx.search_condition()),
                    buildCaseResult(searchedWhenCtx.result()));
        }
        if (ctx.else_clause() != null) {
            caseWhen.setElseResult(buildCaseResult(ctx.else_clause().result()));
        }
        return caseWhen;
    }

    @Override
    public Expr visitCommon_value_expression(SQLParser.Common_value_expressionContext ctx) {
        if (checkIfExist(ctx.NULL())) {
            return new NullLiteral();
        } else if (checkIfExist(ctx.ODIREF())) {
            return new LiteralValue(ctx.ODIREF().getText(), LiteralType.Unsigned_Integer);
        } else {
            return visitChildren(ctx);
        }
    }

    @Override
    public Expr visitParenthesized_value_expression(SQLParser.Parenthesized_value_expressionContext ctx) {
        return visitValue_expression(ctx.value_expression());
    }

    @Override
    public Expr visitBoolean_value_expression(SQLParser.Boolean_value_expressionContext ctx) {
        Expr current = visitOr_predicate(ctx.or_predicate());
        return current;
    }

    @Override
    public Expr visitOr_predicate(SQLParser.Or_predicateContext ctx) {
        Expr current = visitAnd_predicate(ctx.and_predicate());

        Expr left;
        Expr right;
        for (int i = 0; i < ctx.or_predicate().size(); i++) {
            left = current;
            right = visitOr_predicate(ctx.or_predicate(i));
            current = new BinaryOperator(Operator.Or, left, right);
        }

        return current;
    }

    @Override
    public Expr visitAnd_predicate(SQLParser.And_predicateContext ctx) {
        Expr current = visitBoolean_factor(ctx.boolean_factor());

        Expr left;
        Expr right;
        for (int i = 0; i < ctx.and_predicate().size(); i++) {
            left = current;
            right = visitAnd_predicate(ctx.and_predicate(i));
            current = new BinaryOperator(Operator.And, left, right);
        }
        
        Collection<Annotation> annotations = null;
        
        if (checkIfExist(ctx.annotation())) {
            annotations = getAnnotations(ctx.annotation());
            current.setAnnotations(annotations);
        }
        
        if (current instanceof BinaryOperator && ((BinaryOperator) current).getType().equals(OpType.And)) {
            BinaryOperator cbo = (BinaryOperator) current;
            
            if (cbo.getLeft() instanceof InPredicate || cbo.getLeft() instanceof QuantifiedComparisonPredicate || cbo.getLeft() instanceof ExistsPredicate) {
                if (cbo.getLeft().getAnnotations() == null || cbo.getLeft().getAnnotations().isEmpty()) {
                    cbo.getLeft().setAnnotations(annotations);
                }
            }
            
            if (cbo.getRight()instanceof InPredicate || cbo.getRight() instanceof QuantifiedComparisonPredicate || cbo.getRight() instanceof ExistsPredicate) {
                if (cbo.getRight().getAnnotations() == null || cbo.getRight().getAnnotations().isEmpty()) {
                    cbo.getRight().setAnnotations(annotations);
                }
            }
            
            if (annotations != null && !annotations.isEmpty()) {
                cbo.getLeft().setAnnotations(annotations);
            }
        }  
        return current;
    }

    @Override
    public Expr visitBoolean_factor(SQLParser.Boolean_factorContext ctx) {
        if (ctx.NOT() != null) {
            return new NotExpr(visitBoolean_test(ctx.boolean_test()));
        } else {
            return visitBoolean_test(ctx.boolean_test());
        }
    }

    @Override
    public Expr visitBoolean_test(SQLParser.Boolean_testContext ctx) {
        if (checkIfExist(ctx.is_clause())) {
            Is_clauseContext isClauseContext = ctx.is_clause();
            if (checkIfExist(isClauseContext.NOT())) {
                if (checkIfExist(ctx.is_clause().truth_value().TRUE())) {
                    return new NotExpr(visitBoolean_primary(ctx.boolean_primary()));
                } else {
                    return visitBoolean_primary(ctx.boolean_primary());
                }
            } else {
                if (checkIfExist(ctx.is_clause().truth_value().TRUE())) {
                    return visitBoolean_primary(ctx.boolean_primary());
                } else {
                    return new NotExpr(visitBoolean_primary(ctx.boolean_primary()));
                }
            }
        } else {
            return visitBoolean_primary(ctx.boolean_primary());
        }
    }

    @Override
    public Expr visitBoolean_primary(SQLParser.Boolean_primaryContext ctx) {
        if (ctx.predicate() != null) {
            return visitPredicate(ctx.predicate());
        } else {
            return visitBoolean_predicand(ctx.boolean_predicand());
        }
    }

    @Override
    public Expr visitBoolean_predicand(SQLParser.Boolean_predicandContext ctx) {
        if (checkIfExist(ctx.nonparenthesized_value_expression_primary())) {
            return visitNonparenthesized_value_expression_primary(ctx.nonparenthesized_value_expression_primary());
        } else {
            return visitBoolean_value_expression(ctx.parenthesized_boolean_value_expression().boolean_value_expression());
        }
    }
    
    @Override
    public Expr visitScalar_subquery(SQLParser.Scalar_subqueryContext ctx) {
        return new ScalarSubQuery(visitChildren(ctx));
    }

    @Override
    public Expr visitRow_value_predicand(SQLParser.Row_value_predicandContext ctx) {
        if (checkIfExist(ctx.row_value_special_case())) {
            return visitRow_value_special_case(ctx.row_value_special_case());
        } else {
            return visitRow_value_constructor_predicand(ctx.row_value_constructor_predicand());
        }
    }

    @Override
    public Expr visitRow_value_constructor_predicand(SQLParser.Row_value_constructor_predicandContext ctx) {
        if (checkIfExist(ctx.boolean_predicand())) {
            return visitBoolean_predicand(ctx.boolean_predicand());
        } else {
            return visitCommon_value_expression(ctx.common_value_expression());
        }
    }

    @Override
    public BinaryOperator visitComparison_predicate(SQLParser.Comparison_predicateContext ctx) {
        TerminalNode operator = (TerminalNode) ctx.comp_op().getChild(0);
        return new BinaryOperator(tokenToOperatorType(operator.getSymbol().getType()),
                visitRow_value_predicand(ctx.left),
                visitRow_value_predicand(ctx.right));
    }

    @Override
    public Expr visitNumeric_value_expression(SQLParser.Numeric_value_expressionContext ctx) {
        Expr current = visitTerm(ctx.term(0));

        Expr left;
        Expr right;
        for (int i = 1; i < ctx.getChildCount(); i++) {
            left = current;
            TerminalNode operator = (TerminalNode) ctx.getChild(i++);
            right = visitTerm((TermContext) ctx.getChild(i));

            if (operator.getSymbol().getType() == PLUS) {
                current = new BinaryOperator(Operator.Plus, left, right);
            } else {
                current = new BinaryOperator(Operator.Minus, left, right);
            }
        }

        return current;
    }

    @Override
    public Expr visitTerm(SQLParser.TermContext ctx) {
        Expr current = visitFactor(ctx.factor(0));

        Expr left;
        Expr right;
        for (int i = 1; i < ctx.getChildCount(); i++) {
            left = current;
            TerminalNode operator = (TerminalNode) ctx.getChild(i++);
            right = visitFactor((FactorContext) ctx.getChild(i));

            current = switch (operator.getSymbol().getType()) {
                case MULTIPLY -> new BinaryOperator(Operator.Multiply, left, right);
                case DIVIDE -> new BinaryOperator(Operator.Divide, left, right);
                default -> new BinaryOperator(Operator.Modular, left, right);
            };
        }

        return current;
    }

    @Override
    public Expr visitFactor(SQLParser.FactorContext ctx) {
        Expr current = visitNumeric_primary(ctx.numeric_primary());
        if (checkIfExist(ctx.sign()) && checkIfExist(ctx.sign().MINUS())) {
            current = new SignedExpr(true, current);
        }
        return current;
    }

    @Override
    public Expr visitNumeric_primary(SQLParser.Numeric_primaryContext ctx) {
        Expr current = null;
        if (checkIfExist(ctx.value_expression_primary())) {
            current = visitValue_expression_primary(ctx.value_expression_primary());
            for (int i = 0; i < ctx.CAST_EXPRESSION().size(); i++) {
                current = new CastExpr(current, visitData_type(ctx.cast_target(i).data_type()));
            }
        } else if (checkIfExist(ctx.numeric_value_function())) {
            current = visitNumeric_value_function(ctx.numeric_value_function());
        }

        return current;
    }

    public static Operator tokenToOperatorType(int tokenId) {
        return switch (tokenId) {
            case SQLParser.AND -> Operator.And;
            case SQLParser.OR -> Operator.Or;
            case SQLParser.EQUAL -> Operator.Equals;
            case SQLParser.NOT_EQUAL -> Operator.NotEquals;
            case SQLParser.LTH -> Operator.LessThan;
            case SQLParser.LEQ -> Operator.LessThanOrEquals;
            case SQLParser.GTH -> Operator.GreaterThan;
            case SQLParser.GEQ -> Operator.GreaterThanOrEquals;
            case SQLParser.MULTIPLY -> Operator.Multiply;
            case SQLParser.DIVIDE -> Operator.Divide;
            case SQLParser.MODULAR -> Operator.Modular;
            case SQLParser.PLUS -> Operator.Plus;
            case SQLParser.MINUS -> Operator.Minus;
            default -> throw new RuntimeException("Unknown Token Id: " + tokenId);
        };
    }
    
    public static SetOperation.Type tokenToSetOpetationType(int tokenId) {
        return switch (tokenId) {
            case SQLParser.UNION -> SetOperation.Type.UNION;
            case SQLParser.EXCEPT -> SetOperation.Type.EXCEPT;
            case SQLParser.INTERSECT -> SetOperation.Type.INTERSECT;
            default -> throw new RuntimeException("Unknown Token Id: " + tokenId);
        };
    }

    @Override
    public InPredicate visitIn_predicate(SQLParser.In_predicateContext ctx) {
        
        InPredicate predicate;
        
        if (checkIfExist(ctx.row_value_predicand_list())) {
            RowPredicandList predicandsList = new RowPredicandList();
            predicandsList.setPredicands(buildRowValuePredicands(ctx.row_value_predicand_list()));
            predicate = new InPredicate(predicandsList,
                    visitIn_predicate_value(ctx.in_predicate_value()), ctx.NOT() != null);
        } else {
            predicate = new InPredicate(visitChildren(ctx.common_value_expression()),
                    visitIn_predicate_value(ctx.in_predicate_value()), ctx.NOT() != null);
        }
                
        return predicate;
    }
    
    @Override
    public Expr visitIn_predicate_value(SQLParser.In_predicate_valueContext ctx) {
        if (checkIfExist(ctx.in_value_list())) {
            int size = ctx.in_value_list().row_value_predicand().size();
            Expr[] exprs = new Expr[size];
            for (int i = 0; i < size; i++) {
                exprs[i] = visitRow_value_predicand(ctx.in_value_list().row_value_predicand(i));
            }
            return new ValueListExpr(exprs);
        } else {
            return new SimpleTableSubQuery(visitChildren(ctx.table_subquery()));
        }
    }

    @Override
    public Expr visitQuantified_comparison_predicate(Quantified_comparison_predicateContext ctx) {
        QuantifiedComparisonPredicate predicate;
        
        if (checkIfExist(ctx.quantifier())) {
            predicate = new QuantifiedComparisonPredicate(visitCommon_value_expression(ctx.common_value_expression()),
                    visitTable_subquery(ctx.table_subquery()), ctx.comp_op().getText(), ctx.quantifier().getText());
        } else {
            predicate = new QuantifiedComparisonPredicate(visitCommon_value_expression(ctx.common_value_expression()),
                    visitTable_subquery(ctx.table_subquery()), ctx.comp_op().getText(), null);
        }
        
        return predicate;
    }
    
    @Override
    public Expr visitArray(SQLParser.ArrayContext ctx) {
        int size = ctx.numeric_value_expression().size();
        Expr[] exprs = new Expr[size];
        for (int i = 0; i < size; i++) {
            exprs[i] = visit(ctx.numeric_value_expression(i));
        }
        return new ValueListExpr(exprs);
    }

    @Override
    public Expr visitPattern_matching_predicate(SQLParser.Pattern_matching_predicateContext ctx) {
        /*
        Expr predicand = visitChildren(ctx.row_value_predicand());
        Expr pattern = new LiteralValue(stripQuote(ctx.Character_String_Literal().getText()),
                LiteralType.String);
        */
        Expr predicand = visitChildren(ctx.f);
        Expr pattern = visitChildren(ctx.s);

        if (checkIfExist(ctx.pattern_matcher().negativable_matcher())) {
            boolean not = ctx.pattern_matcher().NOT() != null;
            Negativable_matcherContext matcher = ctx.pattern_matcher().negativable_matcher();
            if (checkIfExist(matcher.LIKE())) {
                return new PatternMatchPredicate(MatchType.LikePredicate, not, predicand, pattern);
            } else if (checkIfExist(matcher.ILIKE())) {
                return new PatternMatchPredicate(MatchType.LikePredicate, not, predicand, pattern, true);
            } else if (checkIfExist(matcher.SIMILAR())) {
                return new PatternMatchPredicate(MatchType.SimilarToPredicate, not, predicand, pattern);
            } else if (checkIfExist(matcher.REGEXP()) || checkIfExist(matcher.RLIKE())) {
                return new PatternMatchPredicate(MatchType.Regexp, not, predicand, pattern);
            } else {
                throw new SQLSyntaxError("Unsupported predicate: " + matcher.getText());
            }
        } else if (checkIfExist(ctx.pattern_matcher().regex_matcher())) {
            Regex_matcherContext matcher = ctx.pattern_matcher().regex_matcher();
            if (checkIfExist(matcher.Similar_To())) {
                return new PatternMatchPredicate(MatchType.Regexp, false, predicand, pattern, false);
            } else if (checkIfExist(matcher.Not_Similar_To())) {
                return new PatternMatchPredicate(MatchType.Regexp, true, predicand, pattern, false);
            } else if (checkIfExist(matcher.Similar_To_Case_Insensitive())) {
                return new PatternMatchPredicate(MatchType.Regexp, false, predicand, pattern, true);
            } else if (checkIfExist(matcher.Not_Similar_To_Case_Insensitive())) {
                return new PatternMatchPredicate(MatchType.Regexp, true, predicand, pattern, true);
            } else {
                throw new SQLSyntaxError("Unsupported predicate: " + matcher.getText());
            }
        } else {
            throw new SQLSyntaxError("Unsupported predicate: " + ctx.pattern_matcher().getText());
        }
    }

    @Override
    public IsNullPredicate visitNull_predicate(SQLParser.Null_predicateContext ctx) {
        Expr predicand = visitRow_value_predicand(ctx.row_value_predicand());
        return new IsNullPredicate(ctx.NOT() != null, predicand);
    }

    @Override
    public ExistsPredicate visitExists_predicate(SQLParser.Exists_predicateContext ctx) {
        ExistsPredicate predicate;
        predicate = new ExistsPredicate(new SimpleTableSubQuery(visitTable_subquery(ctx.table_subquery())), ctx.NOT() != null);

        return predicate;
        
    }

    @Override
    public ColumnReferenceExpr visitColumn_reference(SQLParser.Column_referenceContext ctx) {
        ColumnReferenceExpr column = new ColumnReferenceExpr(ctx.name.getText());
        if (checkIfExist(ctx.db_name)) {
            column.setQualifier(CatalogUtil.buildFQName(ctx.db_name.getText(), ctx.tb_name.getText()));
        } else if (ctx.tb_name != null) {
            column.setQualifier(ctx.tb_name.getText());
        }

        return column;
    }

    @Override
    public LiteralValue visitUnsigned_numeric_literal(SQLParser.Unsigned_numeric_literalContext ctx) {
        if (ctx.NUMBER() != null) {
            long lValue = Long.parseLong(ctx.getText());
            if (lValue >= Integer.MIN_VALUE && lValue <= Integer.MAX_VALUE) {
                return new LiteralValue(ctx.getText(), LiteralType.Unsigned_Integer);
            } else {
                return new LiteralValue(ctx.getText(), LiteralType.Unsigned_Large_Integer);
            }
        } else {
            return new LiteralValue(ctx.getText(), LiteralType.Unsigned_Float);
        }
    }

    @Override
    public GeneralSetFunctionExpr visitAggregate_function(SQLParser.Aggregate_functionContext ctx) {
        if (ctx.COUNT() != null && ctx.MULTIPLY() != null) {            
            return new CountRowsFunctionExpr();
        } else {
            return visitGeneral_set_function(ctx.general_set_function());
        }
    }

    @Override
    public GeneralSetFunctionExpr visitGeneral_set_function(SQLParser.General_set_functionContext ctx) {
        String signature = ctx.set_function_type().getText();
        boolean distinct = checkIfExist(ctx.set_qualifier()) && checkIfExist(ctx.set_qualifier().DISTINCT());
        Expr param = visitValue_expression(ctx.value_expression());

        return new GeneralSetFunctionExpr(signature, distinct, new Expr[]{param});
    }

    @Override
    public FunctionExpr visitRoutine_invocation(SQLParser.Routine_invocationContext ctx) {
        String signature;
        signature = ctx.function_name().getText();

        FunctionExpr function = new FunctionExpr(signature);
        if (ctx.sql_argument_list() != null) {
            int numArgs = ctx.sql_argument_list().value_expression().size();
            Expr[] argument_list = new Expr[numArgs];
            for (int i = 0; i < numArgs; i++) {
                argument_list[i] = visitValue_expression(ctx.sql_argument_list().
                        value_expression().get(i));
            }

            function.setParams(argument_list);
        }
        return function;
    }

    @Override
    public NamedExpr visitDerived_column(Derived_columnContext ctx) {
        NamedExpr target = new NamedExpr(visitValue_expression(ctx.value_expression()));
        target.setText(getRuleText(ctx.value_expression()));
        if (ctx.as_clause() != null) {
            target.setAlias(ctx.as_clause().identifier().getText());
        } else if (target.getChild() != null && target.getChild() instanceof ColumnReferenceExpr) {
            target.setAlias(((ColumnReferenceExpr) target.getChild()).getName());      
        }
 
        if (checkIfExist(ctx.annotation())) {
            Collection<Annotation> annotations = getAnnotations(ctx.annotation());
            target.setAnnotations(annotations);            
        }   
        
        return target;
    }

    @Override
    public NamedExpr visitQualified_asterisk(Qualified_asteriskContext ctx) {
        QualifiedAsteriskExpr target = new QualifiedAsteriskExpr();
        if (ctx.tb_name != null) {
            target.setQualifier(ctx.tb_name.getText());
        }

        return new NamedExpr(target);
    }

    @Override
    public Expr visitCharacter_string_type(SQLParser.Character_string_typeContext ctx) {
        return new LiteralValue(stripQuote(ctx.getText()), LiteralType.String);
    }

    @Override
    public Expr visitCharacter_value_expression(SQLParser.Character_value_expressionContext ctx) {
        Expr current = visitCharacter_factor(ctx.character_factor(0));

        Expr left;
        Expr right;
        for (int i = 1; i < ctx.getChildCount(); i++) {
            left = current;
            i++; // skip '||' operator
            right = visitCharacter_factor((Character_factorContext) ctx.getChild(i));

            if (left.getType() == OpType.Literal && right.getType() == OpType.Literal) {
                current = new LiteralValue(((LiteralValue) left).getValue() + ((LiteralValue) right).getValue(),
                        LiteralType.String);
            } else {
                current = new BinaryOperator(Operator.Concatenate, left, right);
            }
        }

        return current;
    }

    @Override
    public Expr visitNumeric_value_function(Numeric_value_functionContext ctx) {
        if (checkIfExist(ctx.extract_expression())) {
            return visitExtract_expression(ctx.extract_expression());
        }

        return null;
    }

    @Override
    public Expr visitExtract_expression(Extract_expressionContext ctx) {
        Expr extractTarget = new LiteralValue(ctx.extract_field_string.getText(), LiteralType.String);
        Expr extractSource = visitDatetime_value_expression(ctx.extract_source().datetime_value_expression());
//    if (checkIfExist(ctx.extract_source().column_reference())) {
//      extractSource = visitColumn_reference(ctx.extract_source().column_reference());
//    } else if (checkIfExist(ctx.extract_source().datetime_literal())) {
//      extractSource = visitDatetime_literal(ctx.extract_source().datetime_literal());
//    } else {
//      return null;
//    }

        String functionName = "date_part";
        Expr[] params = new Expr[]{extractTarget, extractSource};

        return new FunctionExpr(functionName, params);
    }

    @Override
    public Expr visitTrim_function(SQLParser.Trim_functionContext ctx) {
        Expr trimSource = visitChildren(ctx.trim_operands().trim_source);
        String functionName = "trim";
        if (checkIfExist(ctx.trim_operands().FROM())) {
            if (checkIfExist(ctx.trim_operands().trim_specification())) {
                Trim_specificationContext specification = ctx.trim_operands().trim_specification();
                if (checkIfExist(specification.LEADING())) {
                    functionName = "ltrim";
                } else if (checkIfExist(specification.TRAILING())) {
                    functionName = "rtrim";
                } else {
                    functionName = "trim";
                }
            }
        }

        Expr trimCharacters = null;
        if (checkIfExist(ctx.trim_operands().trim_character)) {
            trimCharacters = visitCharacter_value_expression(ctx.trim_operands().trim_character);
        }

        Expr[] params;
        if (trimCharacters != null) {
            params = new Expr[]{trimSource, trimCharacters};
        } else {
            params = new Expr[]{trimSource};
        }

        return new FunctionExpr(functionName, params);
    }

    @Override
    public Expr visitDatabase_definition(SQLParser.Database_definitionContext ctx) {
        return new CreateDatabase(ctx.identifier().getText(), null, checkIfExist(ctx.if_not_exists()));
    }

    @Override
    public Expr visitDrop_database_statement(SQLParser.Drop_database_statementContext ctx) {
        return new DropDatabase(ctx.identifier().getText(), checkIfExist(ctx.if_exists()));
    }
        
    @Override
    public Expr visitCreate_table_statement(SQLParser.Create_table_statementContext ctx) {
        
        String tableName = ctx.table_name(0).getText();
        CreateTable createTable = new CreateTable(tableName, checkIfExist(ctx.if_not_exists()));
        
        createTable.setReplace(checkIfExist(ctx.or_replace()));
        
        if (checkIfExist(ctx.LIKE())) {
            createTable.setLikeParentTable(ctx.like_table_name.getText());
            return createTable;
        }

        if (checkIfExist(ctx.file_alias())) {
            createTable.setAlias(ctx.file_alias().Regular_Identifier().getText());
        }
        
        if (checkIfExist(ctx.annotation())) {
            Collection<Annotation> annotations = getAnnotations(ctx.annotation());
            createTable.setAnnotations(annotations);            
        }          

        if (checkIfExist(ctx.file_resource_name())) {
            File_resource_nameContext fileResCtx = ctx.file_resource_name();
            if (checkIfExist(fileResCtx.Character_String_Literal())) {
                createTable.setResourceName(stripQuote(ctx.file_resource_name().Character_String_Literal().getText()));
            } else if (checkIfExist(fileResCtx.odi_variable_literal())) {
                createTable.setResourceName(stripQuote(fileResCtx.odi_variable_literal().getText()));
            }
        }
        
        if (checkIfExist(ctx.file_description())) {
            createTable.setDescription(stripQuote(ctx.file_description().Character_String_Literal().getText()));
        }
        
        if (checkIfExist(ctx.olap_type())) {
            createTable.setOlapType(stripQuote(ctx.olap_type().otype.getText()));
        }

        if (checkIfExist(ctx.file_descriptor())) {
            File_descriptorContext fileCtx = ctx.file_descriptor();
            CreateTable.FileDescriptor fDesc = new FileDescriptor();

            if (checkIfExist(fileCtx.file_format())) {
                if (checkIfExist(fileCtx.file_format().DELIMITED())) {
                    fDesc.setFormat(FileDescriptor.FileFormat.DELIMITED);
                } else if (checkIfExist(fileCtx.file_format().FIXED())) {
                    fDesc.setFormat(FileDescriptor.FileFormat.FIXED);
                }
            }

            if (checkIfExist(fileCtx.file_heading())) {
                fDesc.setSkipHeadingLines(Integer.valueOf(fileCtx.file_heading().NUMBER().getText()));
            }

            if (checkIfExist(fileCtx.record_separator())) {
                fDesc.setRecordSeparator(stripQuote(fileCtx.record_separator().Character_String_Literal().getText()));
            }

            if (checkIfExist(fileCtx.field_separator())) {
                fDesc.setFieldSeparator(stripQuote(fileCtx.field_separator().Character_String_Literal().getText()));
            }

            if (checkIfExist(fileCtx.text_delimiter())) {
                String textDelim = stripQuote(fileCtx.text_delimiter().Character_String_Literal().getText());
                if (textDelim.contains("\\u")) {                    
                    try {
                        String replaced = org.apache.commons.lang.StringUtils.replace(textDelim, "\\u00", "");
                        byte[] bytes = Hex.decodeHex(replaced.toCharArray());
                        textDelim = new String(bytes, "UTF-8");
                    } catch (DecoderException | UnsupportedEncodingException ex) {
                        throw new SQLSyntaxError(String.format("Invalif text delimiter: %s", textDelim));
                    }
                }                    
                fDesc.setTextDelimiter(textDelim);
            }

            if (checkIfExist(fileCtx.decimal_separator())) {
                fDesc.setDecimalDelimiter(stripQuote(fileCtx.decimal_separator().Character_String_Literal().getText()));
            }

            createTable.setFileDescriptor(fDesc);
        }

        if (checkIfExist(ctx.table_elements())) {
            ColumnDefinition[] elements = getDefinitions(ctx.table_elements());
            Collection<ITableConstraint> keys = getTableKeys(ctx.table_elements());
            Collection<TableKey> indexes = getTableIndexes(ctx.table_elements());
            createTable.setTableElements(elements);
            
            Collection<ITableConstraint> allCons = TUtil.newList();
            allCons.addAll(keys);
            allCons.addAll(indexes);
            createTable.setTableKeys(allCons);
        }

        if (checkIfExist(ctx.USING())) {
            String fileType = ctx.storage_type.getText();
            createTable.setStorageType(fileType);
        }

        if (checkIfExist(ctx.query_expression())) {
            Expr subquery = visitQuery_expression(ctx.query_expression());
            createTable.setSubQuery(subquery);
        }

        if (checkIfExist(ctx.insert_statement())) {
            Expr insert = this.visitInsert_statement(ctx.insert_statement());
            createTable.setSubQuery(insert);
        }

        if (checkIfExist(ctx.param_clause())) {
            Map<String, String> params = escapeTableMeta(getParams(ctx.param_clause()));
            createTable.setParams(params);
        }

        if (checkIfExist(ctx.table_partitioning_clauses())) {
            PartitionMethodDescExpr partitionMethodDesc
                    = parseTablePartitioningClause(ctx.table_partitioning_clauses());
            createTable.setPartitionMethod(partitionMethodDesc);
        }
        return createTable;
    }
    
    @Override
    public Expr visitCreate_mapping_statement(SQLParser.Create_mapping_statementContext ctx) {

        if (checkIfExist(ctx.create_simple_mapping())) {
            return visitCreate_simple_mapping(ctx.create_simple_mapping());
        } else if (checkIfExist(ctx.create_complex_mapping())) {
            return visitCreate_complex_mapping(ctx.create_complex_mapping());
        } else {
            return null;
        }
    }

    @Override
    public Expr visitTruncate_table_statement(SQLParser.Truncate_table_statementContext ctx) {
        List<Table_nameContext> tableNameContexts = ctx.table_name();
        List<String> tableNames = new ArrayList<>();

        tableNameContexts.forEach((eachTableNameContext) -> tableNames.add(eachTableNameContext.getChild(0).getText()));

        return new TruncateTable(tableNames);
    }

    protected Collection<ITableConstraint> getTableKeys(SQLParser.Table_elementsContext ctx) {
        return ctx.field_element().stream().filter(e -> checkIfExist(e.datastore_constraint()))
                .map(e -> getDatastoreConstraint(e.datastore_constraint())).collect(Collectors.toList());
    }
    
    protected Collection<TableKey> getTableIndexes(SQLParser.Table_elementsContext ctx) {
        return ctx.field_element().stream().filter(e -> checkIfExist(e.index_inline()))
                .map(e -> getInlineIndex(e.index_inline())).collect(Collectors.toList());        
    }
    
    protected ColumnDefinition[] getDefinitions(SQLParser.Table_elementsContext ctx) {
        
        List<ColumnDefinition> colList = ctx.field_element().stream().filter(e -> (!checkIfExist(e.datastore_constraint()) && !checkIfExist(e.index_inline())))
                .map(this::getDatastoreColumndefinition).collect(Collectors.toList());
        
        return colList.toArray(ColumnDefinition[]::new);
        
    }

    protected ColumnDefinition getDatastoreColumndefinition(Field_elementContext field_ctx) {
        String name = field_ctx.name.getText();
        DataTypeExpr typeDef = visitData_type(field_ctx.field_type().data_type());
        ColumnDefinition col = new ColumnDefinition(name, typeDef);

        if (field_ctx.null_constraint() != null) {
            if (field_ctx.null_constraint().NOT() != null) {
                col.setOptional(false);
            } else {
                col.setOptional(true);
            }
        } else {
            col.setOptional(true);
        }

        if (field_ctx.offset() != null) {
            col.setOffset(Integer.valueOf(field_ctx.offset().NUMBER().getText()));
        }

        if (field_ctx.decimal_separator() != null) {
            col.setDecseparator(stripQuote(field_ctx.decimal_separator().Character_String_Literal().getText()));
        }

        if (field_ctx.field_format() != null) {
            col.setFormat(stripQuote(field_ctx.field_format().Character_String_Literal().getText()));
        }

        if (field_ctx.field_scd_behavior() != null) {
            col.setScdBehavior(field_ctx.field_scd_behavior().SCD_BEHAVIOR().getText());
        }

        if (field_ctx.field_phys_length() != null) {
            col.setPhysLength(Integer.valueOf(field_ctx.field_phys_length().NUMBER().getText()));
        }
        
        if (checkIfExist(field_ctx.annotation())) {
            Collection<Annotation> annotations = getAnnotations(field_ctx.annotation());
            col.setAnnotations(annotations);            
        }   
        
        if (checkIfExist(field_ctx.field_comment())) {
            col.setDescription(stripQuote(field_ctx.field_comment().comm.getText())); 
        }
        return col;
    }    
    
    protected ColumnDefinition getAddColumnDefinition(SQLParser.Field_elementContext ctx) {
        Field_elementContext field_ctx = ctx;
        String name = field_ctx.name.getText();
                                                   
        DataTypeExpr typeDef = visitData_type(field_ctx.field_type().data_type());  
        ColumnDefinition col = new ColumnDefinition(name, typeDef);

        if (field_ctx.null_constraint() != null) {
           if (field_ctx.null_constraint().NOT() != null) {
              col.setOptional(false);
           } else {
              col.setOptional(true);
           }
        } else {
           col.setOptional(true);
        }

        if (field_ctx.offset() != null) {
           col.setOffset(Integer.valueOf(field_ctx.offset().NUMBER().getText()));
        }

        if (field_ctx.decimal_separator() != null) {
           col.setDecseparator(stripQuote(field_ctx.decimal_separator().Character_String_Literal().getText()));
        }

        if (field_ctx.field_format() != null) {
           col.setFormat(stripQuote(field_ctx.field_format().Character_String_Literal().getText()));
        }

        if (field_ctx.field_scd_behavior() != null) {
           col.setScdBehavior(field_ctx.field_scd_behavior().SCD_BEHAVIOR().getText());
        }

        if (field_ctx.field_phys_length() != null) {
           col.setPhysLength(Integer.valueOf(field_ctx.field_phys_length().NUMBER().getText()));
        }
        
        if (checkIfExist(field_ctx.field_comment())) {
            col.setDescription(stripQuote(field_ctx.field_comment().comm.getText())); 
        }

        return col;
    }   
    
    protected ColumnDefinition getModifyColumnDefinition(SQLParser.Modify_field_elementContext ctx) {
        Modify_field_elementContext field_ctx = ctx;
        String name = field_ctx.name.getText();
                                   
        ColumnDefinition col;
        
        if (field_ctx.field_type() == null || field_ctx.field_type().data_type() == null) {
            col = new ColumnDefinition(name);
        } else {
            DataTypeExpr typeDef = visitData_type(field_ctx.field_type().data_type());  
            col = new ColumnDefinition(name, typeDef);
        }

        if (field_ctx.null_constraint() != null) {
           if (field_ctx.null_constraint().NOT() != null) {
              col.setOptional(false);
           } else {
              col.setOptional(true);
           }
        } else {
           col.setOptional(true);
        }

        if (field_ctx.offset() != null) {
           col.setOffset(Integer.valueOf(field_ctx.offset().NUMBER().getText()));
        }

        if (field_ctx.decimal_separator() != null) {
           col.setDecseparator(stripQuote(field_ctx.decimal_separator().Character_String_Literal().getText()));
        }

        if (field_ctx.field_format() != null) {
           col.setFormat(stripQuote(field_ctx.field_format().Character_String_Literal().getText()));
        }

        if (field_ctx.field_scd_behavior() != null) {
           col.setScdBehavior(field_ctx.field_scd_behavior().SCD_BEHAVIOR().getText());
        }

        if (field_ctx.field_phys_length() != null) {
           col.setPhysLength(Integer.valueOf(field_ctx.field_phys_length().NUMBER().getText()));
        }
        
        if (checkIfExist(field_ctx.field_comment())) {
            col.setDescription(stripQuote(field_ctx.field_comment().comm.getText())); 
        } 

        return col;
    }    

    public PartitionMethodDescExpr parseTablePartitioningClause(SQLParser.Table_partitioning_clausesContext ctx) {

        if (checkIfExist(ctx.range_partitions())) { // For Range Partition
            Range_partitionsContext rangePartitionsContext = ctx.range_partitions();
            List<Range_value_clauseContext> rangeValueClause = rangePartitionsContext.
                    range_value_clause_list().range_value_clause();

            List<RangePartitionSpecifier> specifiers = Lists.newArrayList();

            rangeValueClause.forEach((rangeValue) -> {
                if (checkIfExist(rangeValue.MAXVALUE())) { // LESS THAN (MAXVALUE)
                    specifiers.add(new RangePartitionSpecifier(rangeValue.partition_name().getText()));
                } else { // LESS THAN (expr)
                    specifiers.add(new RangePartitionSpecifier(rangeValue.partition_name().getText(),
                            visitValue_expression(rangeValue.value_expression())));
                }
            });
            return new CreateTable.RangePartition(buildColumnReferenceList(ctx.range_partitions().column_reference_list()),
                    specifiers);

        } else if (checkIfExist(ctx.hash_partitions())) { // For Hash Partition
            Hash_partitionsContext hashPartitions = ctx.hash_partitions();

            if (checkIfExist(hashPartitions.hash_partitions_by_quantity())) { // PARTITIONS (num)
                return new HashPartition(buildColumnReferenceList(hashPartitions.column_reference_list()),
                        visitNumeric_value_expression(hashPartitions.hash_partitions_by_quantity().quantity));

            } else { // ( PARTITION part_name , ...)
                List<CreateTable.PartitionSpecifier> specifiers = Lists.newArrayList();
                hashPartitions.individual_hash_partitions().individual_hash_partition().forEach((partition) -> specifiers.add(new PartitionSpecifier(partition.partition_name().getText())));
                return new HashPartition(buildColumnReferenceList(hashPartitions.column_reference_list()), specifiers);
            }

        } else if (checkIfExist(ctx.list_partitions())) { // For List Partition
            List_partitionsContext listPartitions = ctx.list_partitions();
            List<List_value_partitionContext> partitions = listPartitions.list_value_clause_list().list_value_partition();
            List<ListPartitionSpecifier> specifiers = Lists.newArrayList();

            partitions.forEach((listValuePartition) -> {
                int size = listValuePartition.in_value_list().row_value_predicand().size();
                Expr[] exprs = new Expr[size];
                for (int i = 0; i < size; i++) {
                    exprs[i] = visitRow_value_predicand(listValuePartition.in_value_list().row_value_predicand(i));
                }
                specifiers.add(new ListPartitionSpecifier(listValuePartition.partition_name().getText(),
                        new ValueListExpr(exprs)));
            });
            return new ListPartition(buildColumnReferenceList(ctx.list_partitions().column_reference_list()), specifiers);

        } else if (checkIfExist(ctx.column_partitions())) { // For Column Partition (Hive Style)
            return new CreateTable.ColumnPartition(getDefinitions(ctx.column_partitions().table_elements()));
        } else {
            throw new SQLSyntaxError("Invalid Partition Type: " + ctx.toStringTree());
        }
        
    }

    @SuppressWarnings("null")
    @Override
    public DataTypeExpr visitData_type(SQLParser.Data_typeContext ctx) {
        DataTypeExpr typeDefinition = null;

        if (checkIfExist(ctx.generic_type())) {
            SQLParser.Generic_typeContext generic_type = ctx.generic_type();
            String dataType;
            
            if (checkIfExist(generic_type.Regular_Identifier())) {
                dataType = generic_type.Regular_Identifier().getText();
            } else {
                dataType = generic_type.Quoted_Identifier().getText();
            }
            typeDefinition = new DataTypeExpr(dataType);

            if (checkIfExist(generic_type.precision_param())) {
                SQLParser.Precision_paramContext precision_ctx = generic_type.precision_param();
                if (precision_ctx.precision != null) {
                    String precisionOrLength = generic_type.precision_param().precision.getText();
                    typeDefinition.setLengthOrPrecision(Integer.parseInt(precisionOrLength));
                }
                if (precision_ctx.scale != null) {
                    String scale = generic_type.precision_param().scale.getText();
                    typeDefinition.setScale(Integer.parseInt(scale));
                }
            }

            return typeDefinition;
        }

        SQLParser.Predefined_typeContext predefined_type = ctx.predefined_type();

        if (predefined_type.character_string_type() != null) {
            SQLParser.Character_string_typeContext character_string_type
                    = predefined_type.character_string_type();

            if ((character_string_type.CHARACTER() != null || character_string_type.CHAR() != null)
                    && character_string_type.VARYING() == null) {
                typeDefinition = new DataTypeExpr("CHAR");
                if (character_string_type.type_length() != null) {
                    typeDefinition.setLengthOrPrecision(
                            Integer.parseInt(character_string_type.type_length().NUMBER().getText()));
                }
            } else if (character_string_type.VARCHAR() != null
                    || character_string_type.VARYING() != null) {
                typeDefinition = new DataTypeExpr("VARCHAR");
                if (character_string_type.type_length() != null) {
                    typeDefinition.setLengthOrPrecision(
                            Integer.parseInt(character_string_type.type_length().NUMBER().getText()));
                }
            } else if (character_string_type.VARCHAR2() != null) {
                typeDefinition = new DataTypeExpr("VARCHAR2");
                if (character_string_type.type_length() != null) {
                    typeDefinition.setLengthOrPrecision(
                            Integer.parseInt(character_string_type.type_length().NUMBER().getText()));
                }
            } else if (character_string_type.FEBCDIC() != null) {
                typeDefinition = new DataTypeExpr("FEBCDIC");
                if (character_string_type.type_length() != null) {
                    typeDefinition.setLengthOrPrecision(
                            Integer.parseInt(character_string_type.type_length().NUMBER().getText()));
                }
            } else if (character_string_type.STRING() != null) {
                typeDefinition = new DataTypeExpr("STRING");
                if (character_string_type.type_length() != null) {
                    typeDefinition.setLengthOrPrecision(
                            Integer.parseInt(character_string_type.type_length().NUMBER().getText()));
                }
            } else if (character_string_type.CLOB() != null) {
                typeDefinition = new DataTypeExpr("CLOB");
                if (character_string_type.type_length() != null) {
                    typeDefinition.setLengthOrPrecision(
                            Integer.parseInt(character_string_type.type_length().NUMBER().getText()));
                }                
            } else if (character_string_type.TEXT() != null) {
                typeDefinition = new DataTypeExpr("TEXT");
            } else if (character_string_type.VARCHAR_MAX()!= null) {
                typeDefinition = new DataTypeExpr("VARCHAR(MAX)");
            } else if (character_string_type.VARCHAR2_MAX()!= null) {
                typeDefinition = new DataTypeExpr("VARCHAR2(MAX)");
            }

        } else if (predefined_type.national_character_string_type() != null) {
            SQLParser.National_character_string_typeContext nchar_type
                    = predefined_type.national_character_string_type();
            if ((nchar_type.CHAR() != null || nchar_type.CHARACTER() != null || nchar_type.NCHAR() != null) && nchar_type.VARYING() == null) {
                typeDefinition = new DataTypeExpr("NCHAR");
                if (nchar_type.type_length() != null) {
                    typeDefinition.setLengthOrPrecision(Integer.parseInt(nchar_type.type_length().NUMBER().getText()));
                }
            } else if (nchar_type.NVARCHAR() != null || nchar_type.VARYING() != null) {
                typeDefinition = new DataTypeExpr("NVARCHAR");
                if (nchar_type.type_length() != null) {
                    typeDefinition.setLengthOrPrecision(Integer.parseInt(nchar_type.type_length().NUMBER().getText()));
                }
            }

        } else if (predefined_type.binary_large_object_string_type() != null) {
            SQLParser.Binary_large_object_string_typeContext blob_type
                    = predefined_type.binary_large_object_string_type();
            typeDefinition = new DataTypeExpr("BLOB");
            if (blob_type.type_length() != null) {
                typeDefinition.setLengthOrPrecision(
                        Integer.parseInt(blob_type.type_length().NUMBER().getText()));
            }
        } else if (predefined_type.numeric_type() != null) {
            // exact number
            if (predefined_type.numeric_type().exact_numeric_type() != null) {
                SQLParser.Exact_numeric_typeContext exactType
                        = predefined_type.numeric_type().exact_numeric_type();
                if (exactType.TINYINT() != null || exactType.INT1() != null) {
                    typeDefinition = new DataTypeExpr("TINYINT");
                } else if (exactType.INT2() != null || exactType.SMALLINT() != null) {
                    typeDefinition = new DataTypeExpr("SMALLINT");
                } else if (exactType.INT4() != null || exactType.INTEGER() != null
                        || exactType.INT() != null) {
                    typeDefinition = new DataTypeExpr("INTEGER");
                } else if (exactType.INT8() != null || exactType.BIGINT() != null) {
                    typeDefinition = new DataTypeExpr("BIGINT");
                } else if (exactType.NUMERIC() != null) {
                    typeDefinition = new DataTypeExpr("NUMERIC");
                } else if (exactType.DECIMAL() != null || exactType.DEC() != null) {
                    //typeDefinition = new DataTypeExpr("NUMERIC");
                    typeDefinition = new DataTypeExpr("DECIMAL");
                } else if (exactType.ORANUMBER() != null) {
                    typeDefinition = new DataTypeExpr("NUMBER");
                } else if (exactType.EBCDIC_SIGNED_ZONED_DECIMAL() != null) {
                    typeDefinition = new DataTypeExpr("EBCDIC_SIGNED_ZONED_DECIMAL");
                    if (exactType.precision_param() != null) {
                        typeDefinition.setLengthOrPrecision(Integer.parseInt(exactType.precision_param().precision.getText()));
                        if (exactType.precision_param().scale != null) {
                            typeDefinition.setScale(Integer.parseInt(exactType.precision_param().scale.getText()));
                        }
                    }
                } else if (exactType.SIGNED_PACKED_DECIMAL() != null) {
                    typeDefinition = new DataTypeExpr("SIGNED_PACKED_DECIMAL");
                    if (exactType.precision_param() != null) {
                        typeDefinition.setLengthOrPrecision(Integer.parseInt(exactType.precision_param().precision.getText()));
                        if (exactType.precision_param().scale != null) {
                            typeDefinition.setScale(Integer.parseInt(exactType.precision_param().scale.getText()));
                        }
                    }
                }

                assert typeDefinition != null;

                if (typeDefinition.getTypeName().equals("NUMERIC") || typeDefinition.getTypeName().equals("NUMBER")
                    || typeDefinition.getTypeName().equals("DECIMAL")) {
                    if (exactType.precision_param() != null) {
                        if (exactType.precision_param().scale != null) {
                            typeDefinition.setScale(
                                    Integer.parseInt(exactType.precision_param().scale.getText()));
                        }
                        typeDefinition.setLengthOrPrecision(
                                Integer.parseInt(exactType.precision_param().precision.getText()));
                    }
                }
            } else { // approximate number
                SQLParser.Approximate_numeric_typeContext approximateType
                        = predefined_type.numeric_type().approximate_numeric_type();
                if (approximateType.FLOAT() != null || approximateType.FLOAT4() != null
                        || approximateType.REAL() != null) {
                    typeDefinition = new DataTypeExpr("REAL");
                } else if (approximateType.FLOAT8() != null || approximateType.DOUBLE() != null) {
                    typeDefinition = new DataTypeExpr("DOUBLE");
                }
            }
        } else if (predefined_type.boolean_type() != null) {
            typeDefinition = new DataTypeExpr("BOOLEAN");
        } else if (predefined_type.datetime_type() != null) {
            SQLParser.Datetime_typeContext dateTimeType = predefined_type.datetime_type();
            if (dateTimeType.DATE() != null) {
                typeDefinition = new DataTypeExpr("DATE");
            } else if (dateTimeType.DATETIME() != null) {
                typeDefinition = new DataTypeExpr("DATETIME");
            } else if (dateTimeType.TIME(0) != null && dateTimeType.ZONE() == null) {
                typeDefinition = new DataTypeExpr("TIME");
            } else if ((dateTimeType.TIME(0) != null && dateTimeType.ZONE() != null)
                    || dateTimeType.TIMETZ() != null) {
                typeDefinition = new DataTypeExpr("TIMEZ");
            } else if (dateTimeType.TIMESTAMP() != null && dateTimeType.ZONE() == null) {
                typeDefinition = new DataTypeExpr("TIMESTAMP");
            } else if ((dateTimeType.TIMESTAMP() != null && dateTimeType.ZONE() != null)
                    || dateTimeType.TIMESTAMPTZ() != null) {
                typeDefinition = new DataTypeExpr("TIMESTAMPZ");
            }

            assert typeDefinition != null;
            if (dateTimeType.type_length() != null && dateTimeType.type_length().NUMBER() != null) {
                typeDefinition.setLengthOrPrecision(Integer.parseInt(dateTimeType.type_length().NUMBER().getText()));
            }

        } else if (predefined_type.bit_type() != null) {
            SQLParser.Bit_typeContext bitType = predefined_type.bit_type();
            if (bitType.VARBIT() != null || bitType.VARYING() != null) {
                typeDefinition = new DataTypeExpr("VARBIT");
            } else {
                typeDefinition = new DataTypeExpr("BIT");
            }
            if (bitType.type_length() != null) {
                typeDefinition.setLengthOrPrecision(
                        Integer.parseInt(bitType.type_length().NUMBER().getText()));
            }
        } else if (predefined_type.binary_type() != null) {
            SQLParser.Binary_typeContext binaryType = predefined_type.binary_type();
            if (binaryType.VARBINARY() != null || binaryType.VARYING() != null) {
                typeDefinition = new DataTypeExpr("VARBINARY");
            } else {
                typeDefinition = new DataTypeExpr("BINARY");
            }

            if (binaryType.type_length() != null) {
                typeDefinition.setLengthOrPrecision(
                        Integer.parseInt(binaryType.type_length().NUMBER().getText()));
            }
        } else if (predefined_type.network_type() != null) {
            typeDefinition = new DataTypeExpr("INET4");
        }

        return typeDefinition;
    }

    @Override
    public Expr visitInsert_statement(SQLParser.Insert_statementContext ctx) {
        Insert insertExpr = new Insert();

        if (ctx.OVERWRITE() != null) {
            insertExpr.setOverwrite();
        }

        if (ctx.table_name() != null) {
            insertExpr.setTableName(ctx.table_name().getText());

            if (ctx.column_name_list() != null) {
                List<TargetColumn> targetColumns = TUtil.newList();
                ctx.column_name_list().target_column().stream().map((targColCtx) -> {
                    TargetColumn targCol = new TargetColumn(targColCtx.identifier().getText());
                    if (checkIfExist(targColCtx.annotation())) {
                        Collection<Annotation> annotations = getAnnotations(targColCtx.annotation());                        
                        targCol.setAnnotations(annotations);
                    }
                    return targCol;                                        
                }).forEachOrdered(targetColumns::add);

                insertExpr.setTargetColumns(targetColumns);
            }
        }
        
        if (checkIfExist(ctx.alias)) {
            insertExpr.setTableAlias(ctx.alias.getText());            
        }

        if (ctx.LOCATION() != null) {
            insertExpr.setLocation(stripQuote(ctx.path.getText()));

            if (ctx.USING() != null) {
                insertExpr.setStorageType(ctx.storage_type.getText());

                if (ctx.param_clause() != null) {
                    insertExpr.setParams(escapeTableMeta(getParams(ctx.param_clause())));
                }
            }
        }
        
        if (checkIfExist(ctx.integration_params())) {
            Integration_paramsContext intctx = ctx.integration_params();
            if (checkIfExist(intctx.INTEGRATION_TYPE())) {
                 insertExpr.setIntegrationType(stripQuote(intctx.integration_type.getText()));
            }
            if(checkIfExist(intctx.UPDATE_KEY())) {
                insertExpr.setUpdateKey(intctx.key.getText().toUpperCase());
            }                        
            if (checkIfExist(intctx.REJECT())) {
                insertExpr.setRejectLimit(Integer.valueOf(intctx.max_rejected.getText()));
                insertExpr.setRejectLimitUnit(intctx.rejected_unit.getText().toUpperCase());
            }            
        }
        
        if (checkIfExist(ctx.annotation())) {
            Collection<Annotation> annotations = getAnnotations(ctx.annotation());
            insertExpr.setAnnotations(annotations);            
        }
                
        insertExpr.setSubQuery(visitQuery_expression(ctx.query_expression()));

        Preconditions.checkState(insertExpr.hasTableName() || insertExpr.hasLocation(),
                "Either a table name or a location should be given.");
        Preconditions.checkState(insertExpr.hasTableName() ^ insertExpr.hasLocation(),
                "A table name and a location cannot coexist.");
        return insertExpr;
    }

    @Override
    public MultiInsert visitMulti_insert_statement(SQLParser.Multi_insert_statementContext ctx) {
        MultiInsert insert = new MultiInsert();
        int targetsSize = 0;

        if (checkIfExist(ctx.multi_insert_target())) {
            targetsSize = ctx.multi_insert_target().size();
        }
        if (checkIfExist(ctx.multi_insert_def_target())) {
            targetsSize++;
        }

        if (targetsSize > 0) {
            MultiInsertTarget[] targets = new MultiInsertTarget[targetsSize];

            if (checkIfExist(ctx.multi_insert_target())) {
                for (int i = 0; i < ctx.multi_insert_target().size(); i++) {
                    targets[i] = visitMulti_insert_target(ctx.multi_insert_target(i));
                }
            }

            if (checkIfExist(ctx.multi_insert_def_target())) {
                targets[targetsSize - 1] = visitMulti_insert_def_target(ctx.multi_insert_def_target());
            }

            insert.setTargets(targets);
        }

        insert.setSubQuery(visitQuery_expression(ctx.query_expression()));

        if (checkIfExist(ctx.annotation())) {
            Collection<Annotation> annotations = getAnnotations(ctx.annotation());
            insert.setAnnotations(annotations);            
        }
        
        return insert;

    }

    @Override
    public Expr visitDrop_table_statement(SQLParser.Drop_table_statementContext ctx) {
        return new DropTable(ctx.table_name().getText(), checkIfExist(ctx.if_exists()), checkIfExist(ctx.PURGE()));
    }

    
    protected Map<String, String> getParams(SQLParser.Param_clauseContext ctx) {
        Map<String, String> params = new HashMap<>();
        for (int i = 0; i < ctx.param().size(); i++) {
            params.put(stripQuote(ctx.param(i).key.getText()), stripQuote(ctx.param(i).value.getText()));
        }

        return params;
    }

    public Map<String, String> escapeTableMeta(Map<String, String> map) {
        Map<String, String> params = new HashMap<>();
        map.forEach((key, value) -> {
            switch (key) {
                case CatalogConstants.CSVFILE_DELIMITER, CatalogConstants.TEXT_DELIMITER -> //backward compatibility
                    params.put(CatalogConstants.TEXT_DELIMITER, StringUtil.unicodeEscapedDelimiter(value));
                case CatalogConstants.CSVFILE_NULL, CatalogConstants.TEXT_NULL -> //backward compatibility
                    params.put(CatalogConstants.TEXT_NULL, value);
                default -> params.put(key, value);
            }
        });
        return params;
    }

    protected static String stripQuote(String str) {
        return str.substring(1, str.length() - 1);
    }

    @Override
    public Expr visitCast_specification(SQLParser.Cast_specificationContext ctx) {
        Expr operand = visitChildren(ctx.cast_operand());
        DataTypeExpr castTarget = visitData_type(ctx.cast_target().data_type());
        return new CastExpr(operand, castTarget);
    }

    @Override
    public Expr visitConvert_specification(Convert_specificationContext ctx) {
        String signature;
        signature = ctx.CONVERT().getText();
        
        FunctionExpr function = new FunctionExpr(signature);
        
        List<Expr> argsList = TUtil.newList();
        
        argsList.add(visitCast_target(ctx.cast_target()));
        argsList.add(visitCast_operand(ctx.cast_operand()));
        
        if (checkIfExist(ctx.NUMBER())) {
            argsList.add(new LiteralValue(ctx.NUMBER().getText(), LiteralType.Unsigned_Integer));
        }
                
        function.setParams(argsList.toArray(Expr[]::new));
        
        return function;
    }        

    @Override
    public Expr visitUnsigned_value_specification(SQLParser.Unsigned_value_specificationContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Expr visitUnsigned_literal(SQLParser.Unsigned_literalContext ctx) {
        if (checkIfExist(ctx.unsigned_numeric_literal())) {
            return visitUnsigned_numeric_literal(ctx.unsigned_numeric_literal());
        } else {
            return visitGeneral_literal(ctx.general_literal());
        }
    }

    @Override
    public Expr visitGeneral_literal(SQLParser.General_literalContext ctx) {
        if (checkIfExist(ctx.Character_String_Literal())) {
            return new LiteralValue(stripQuote(ctx.Character_String_Literal().getText()), LiteralType.String);
        } else if (checkIfExist(ctx.datetime_literal())) {
            return visitDatetime_literal(ctx.datetime_literal());
        } else if (checkIfExist(ctx.boolean_literal())) {
            return new BooleanLiteral(checkIfExist(ctx.boolean_literal().TRUE()));
        } else if (checkIfExist(ctx.odi_variable_literal())) {
            return visitOdi_variable_literal(ctx.odi_variable_literal());
        } else {
            return null;
        }
    }

    @Override
    public Expr visitDatetime_literal(SQLParser.Datetime_literalContext ctx) {
        if (checkIfExist(ctx.time_literal())) {
            return visitTime_literal(ctx.time_literal());
        } else if (checkIfExist(ctx.date_literal())) {
            return visitDate_literal(ctx.date_literal());
        } else if (checkIfExist(ctx.interval_literal())) {
            return visitInterval_literal(ctx.interval_literal());
        } else {
            return visitTimestamp_literal(ctx.timestamp_literal());
        }
    }

    @Override
    public Expr visitTime_literal(SQLParser.Time_literalContext ctx) {
        String timePart = stripQuote(ctx.time_string.getText());
        return new TimeLiteral(parseTime(timePart));
    }

    @Override
    public Expr visitDate_literal(SQLParser.Date_literalContext ctx) {
        String datePart = stripQuote(ctx.date_string.getText());
        return new DateLiteral(parseDate(datePart));
    }

    @Override
    public Expr visitTimestamp_literal(SQLParser.Timestamp_literalContext ctx) {
        String timestampStr = stripQuote(ctx.timestamp_string.getText());
        String[] parts = timestampStr.split(" ");
        String datePart = parts[0];
        String timePart = parts[1];
        return new TimestampLiteral(parseDate(datePart), parseTime(timePart));
    }

    @Override
    public Expr visitInterval_literal(SQLParser.Interval_literalContext ctx) {
        String intervalStr = stripQuote(ctx.interval_string.getText());
        return new IntervalLiteral(intervalStr);
    }

    @Override
    public Expr visitDatetime_value_expression(SQLParser.Datetime_value_expressionContext ctx) {
        return visitDatetime_term(ctx.datetime_term());
    }

    @Override
    public Expr visitDatetime_term(SQLParser.Datetime_termContext ctx) {
        return visitDatetime_factor(ctx.datetime_factor());
    }

    @Override
    public Expr visitDatetime_factor(SQLParser.Datetime_factorContext ctx) {
        return visitDatetime_primary(ctx.datetime_primary());
    }

    @Override
    public Expr visitDatetime_primary(SQLParser.Datetime_primaryContext ctx) {
        if (checkIfExist(ctx.value_expression_primary())) {
            return visitValue_expression_primary(ctx.value_expression_primary());
        } else {
            return visitDatetime_value_function(ctx.datetime_value_function());
        }
    }

    @Override
    public Expr visitDatetime_value_function(SQLParser.Datetime_value_functionContext ctx) {
        if (checkIfExist(ctx.current_date_value_function())) {
            return visitCurrent_date_value_function(ctx.current_date_value_function());
        } else if (checkIfExist(ctx.current_time_value_function())) {
            return visitCurrent_time_value_function(ctx.current_time_value_function());
        } else {
            return visitCurrent_timestamp_value_function(ctx.current_timestamp_value_function());
        }
    }

    @Override
    public Expr visitCurrent_date_value_function(SQLParser.Current_date_value_functionContext ctx) {
        String functionName = "current_date";
        Expr[] params = new Expr[]{};
        return new FunctionExpr(functionName, params);
    }

    @Override
    public Expr visitCurrent_time_value_function(SQLParser.Current_time_value_functionContext ctx) {
        String functionName = "current_time";
        Expr[] params = new Expr[]{};
        return new FunctionExpr(functionName, params);
    }

    @Override
    public Expr visitCurrent_timestamp_value_function(SQLParser.Current_timestamp_value_functionContext ctx) {
        String functionName = "now";
        Expr[] params = new Expr[]{};
        return new FunctionExpr(functionName, params);
    }

    protected DateValue parseDate(String datePart) {
        // e.g., 1980-04-01
        String[] parts = datePart.split("-");
        return new DateValue(parts[0], parts[1], parts[2]);
    }

    protected TimeValue parseTime(String timePart) {
        // e.g., 12:01:50.399
        String[] parts = timePart.split(":");

        TimeValue time;
        boolean hasFractionOfSeconds = (parts.length > 2 && parts[2].indexOf('.') > 0);
        if (hasFractionOfSeconds) {
            String[] secondsParts = parts[2].split("\\.");
            time = new TimeValue(parts[0], parts[1], secondsParts[0]);
            if (secondsParts.length == 2) {
                time.setSecondsFraction(secondsParts[1]);
            }
        } else {
            time = new TimeValue(parts[0],
                    (parts.length > 1 ? parts[1] : "0"),
                    (parts.length > 2 ? parts[2] : "0"));
        }
        return time;
    }

    @Override
    public Expr visitAlter_tablespace_statement(SQLParser.Alter_tablespace_statementContext ctx) {
        AlterTablespace alter = new AlterTablespace(ctx.space_name.getText());
        alter.setLocation(stripQuote(ctx.uri.getText()));
        return alter;
    }

    @Override
    public Expr visitAlter_table_statement(SQLParser.Alter_table_statementContext ctx) {

        final List<Table_nameContext> tables = ctx.table_name();

        final AlterTable alterTable = new AlterTable(tables.get(0).getText());
        
        if (tables.size() == 2) {
            alterTable.setNewTableName(tables.get(1).getText());
        }

        if (checkIfExist(ctx.column_name()) && ctx.column_name().size() == 2) {
            final List<Column_nameContext> columns = ctx.column_name();
            alterTable.setColumnName(columns.get(0).getText());
            alterTable.setNewColumnName(columns.get(1).getText());
        }
        
        Modify_field_elementContext mod_field_elementContext = ctx.modify_field_element();
        if (checkIfExist(mod_field_elementContext)) {            
            final ColumnDefinition columnDefinition = getModifyColumnDefinition(mod_field_elementContext);
            alterTable.setAddNewColumn(columnDefinition);
        }
        
        Field_elementContext add_field_elementContext = ctx.field_element();
        if (checkIfExist(add_field_elementContext)) {            
            final ColumnDefinition columnDefinition = getAddColumnDefinition(add_field_elementContext);
            alterTable.setAddNewColumn(columnDefinition);
        }
        
        if (checkIfExist(ctx.datastore_constraint())) {             
            ITableConstraint key = getDatastoreConstraint(ctx.datastore_constraint());
            alterTable.setTableKey(key);
        }
                
        alterTable.setAlterTableOpType(determineAlterTableType(ctx));
        
        if (checkIfExist(ctx.comm)) {
            alterTable.setComment(stripQuote(ctx.comm.getText()));
            alterTable.setAlterTableOpType(AlterTableOpType.COMMENT);
        }        

        return alterTable;
    }
    
    protected ITableConstraint getDatastoreConstraint(Datastore_constraintContext ctx) {
        List<String> keyColumnNames;
        boolean controlFlow = true;
        boolean controlStatic = true;
        boolean inDatabase = false;
        boolean active = false;
        ConstraintScope scope = ConstraintScope.ODI;
        String description = null;
        
        if (Objects.nonNull(ctx.constraint_control())) {
            Constraint_controlContext ctrlCtx = ctx.constraint_control();
            controlFlow = Objects.nonNull(ctrlCtx.FLOW());
            controlStatic = Objects.nonNull(ctrlCtx.STATIC());            
        }
        
        if (Objects.nonNull(ctx.constraint_type())) {
            if (Objects.nonNull(ctx.constraint_type().DATABASE())) {
                scope = ConstraintScope.DATABASE;                
            }
            if (Objects.nonNull(ctx.constraint_type().ODI())) {
                scope = ConstraintScope.ODI;
            }
        }
        
        if (Objects.nonNull(ctx.in_database())) {
            In_databaseContext inDbCtx = ctx.in_database();
            inDatabase = true;

            if (Objects.nonNull(inDbCtx.ACTIVE())) {
                active = true;
            }
        }
        
        if (Objects.nonNull(ctx.datastore_condition_message())) {
            description = stripQuote(ctx.datastore_condition_message().comm.getText());
        }   
        
        if (Objects.nonNull(ctx.datastore_key())) {
            Datastore_keyContext keyCtx = ctx.datastore_key();
            String keyName = keyCtx.key_name.getText();
            TableConstraint constraint = new TableConstraint(keyName, scope, controlFlow, controlStatic, inDatabase, active, description);
            keyColumnNames = keyCtx.column_name_list().target_column().stream().map(c -> c.identifier().getText()).collect(Collectors.toList());
            TableKey key = new TableKey(constraint, keyColumnNames, checkIfExist(keyCtx.PRIMARY_KEY()), checkIfExist(keyCtx.ALTERNATE_KEY()) && checkIfExist(keyCtx.UNIQUE()));
            
            if (checkIfExist(ctx.annotation())) {
                Collection<Annotation> annotations = getAnnotations(ctx.annotation());
                key.setAnnotations(annotations);
            }
            
            return key;
        } else if (Objects.nonNull(ctx.datastore_check())) {
            Datastore_checkContext checkCtx = ctx.datastore_check();
            String keyName = checkCtx.key_name.getText();
            TableConstraint constraint = new TableConstraint(keyName, scope, controlFlow, controlStatic, inDatabase, active, description);
            Expr condition = visitSearch_condition(checkCtx.search_condition());
            TableCheckConstraint checkConstraint = new TableCheckConstraint(constraint, condition);
            checkConstraint.setQualText(getRuleText(ctx.datastore_check().search_condition()));
            
            return checkConstraint;
        } else {
            throw new RuntimeException("Invalid constraint specification");
        }
    }

    protected TableKey getInlineIndex(Index_inlineContext ctx) {
        List<String> keyColumnNames;
        keyColumnNames = ctx.column_name_list().target_column().stream().map(c -> c.identifier().getText()).collect(Collectors.toList());
        
        TableConstraint constraint = new TableConstraint(ctx.name.getText(), ConstraintScope.DATABASE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, null);
        TableKey key = new TableKey(constraint, keyColumnNames, Boolean.FALSE, Objects.nonNull(ctx.UNIQUE()));
        if (checkIfExist(ctx.annotation())) {
            Collection<Annotation> annotations = getAnnotations(ctx.annotation());
            key.setAnnotations(annotations);
        }
        return key;
    }
    
    protected AlterTableOpType determineAlterTableType(SQLParser.Alter_table_statementContext ctx) {

        final int RENAME_MASK = 00000001;
        final int COLUMN_MASK = 00000010;
        final int TO_MASK = 00000100;
        final int ADD_MASK = 00001000;
        final int MODIFY_MASK = 00010000;
        final int PRIMARY_KEY_MASK = 00100000;
        final int ALTERNATE_KEY_MASK = 01000000;

        int val = 00000000;

        for (int idx = 1; idx < ctx.getChildCount(); idx++) {
            if (ctx.getChild(idx) instanceof TerminalNode terminalNode) {
                if (terminalNode.getSymbol().getType() == MODIFY) {
                    val = val | MODIFY_MASK;
                }                
                if (terminalNode.getSymbol().getType() == RENAME) {
                    val = val | RENAME_MASK;
                }
                if (terminalNode.getSymbol().getType() == COLUMN) {
                    val = val | COLUMN_MASK;
                }
                if (terminalNode.getSymbol().getType() == TO) {
                    val = val | TO_MASK;
                }
                if (terminalNode.getSymbol().getType() == ADD) {
                    val = val | ADD_MASK;
                }
                if (terminalNode.getSymbol().getType() == PRIMARY_KEY) {
                    val = val | PRIMARY_KEY_MASK;
                }    
                if (terminalNode.getSymbol().getType() == ALTERNATE_KEY) {
                    val = val | ALTERNATE_KEY_MASK;
                }                   
            }
        }
        return evaluateAlterTableOperationTye(val);
    }

    protected AlterTableOpType evaluateAlterTableOperationTye(final int value) {
        return switch (value) {
            case 65 -> AlterTableOpType.RENAME_TABLE;
            case 73 -> AlterTableOpType.RENAME_COLUMN;
            case 520 -> AlterTableOpType.ADD_COLUMN;
            case 4104 -> AlterTableOpType.MODIFY_COLUMN;
            case 33280 -> AlterTableOpType.ADD_PRIMARY_KEY;
            case 262656 -> AlterTableOpType.ADD_ALTERNATE_KEY;
            default -> null;
        };
    }

    protected String getRuleText(ParserRuleContext ctx) {
        int a = ctx.start.getStartIndex();
        int b = ctx.stop.getStopIndex();
        Interval i = new Interval(a, b);
        return ctx.start.getInputStream().getText(i);
    }

    @Override
    public MultiInsertTarget visitMulti_insert_target(SQLParser.Multi_insert_targetContext ctx) {
        MultiInsertTarget target = new MultiInsertTarget();
        target.setDefaultcond(Boolean.FALSE);

        if (checkIfExist(ctx.table_name())) {
            target.setTableName(ctx.table_name().getText());
        }

        if (checkIfExist(ctx.alias)) {
            target.setTableAlias(ctx.alias.getText());            
        }
        
        if (checkIfExist(ctx.column_name_list())) {
            List<TargetColumn> targetColumns = TUtil.newList();
            ctx.column_name_list().target_column().stream().map((targColCtx) -> {
                TargetColumn targCol = new TargetColumn(targColCtx.identifier().getText());
                if (checkIfExist(targColCtx.annotation())) {
                    Collection<Annotation> annotations = getAnnotations(targColCtx.annotation());
                    targCol.setAnnotations(annotations);
                }
                return targCol;
            }).forEachOrdered(targetColumns::add);
            target.setTargetColumns(targetColumns);

        }

        if (checkIfExist(ctx.multi_insert_select_list())) {
            NamedExpr[] expressions = new NamedExpr[ctx.multi_insert_select_list().value_expression().size()];
            for (int i = 0; i < ctx.multi_insert_select_list().value_expression().size(); i++) {
                expressions[i] = new NamedExpr(visitValue_expression(ctx.multi_insert_select_list().value_expression().get(i)));
                expressions[i].setText(getRuleText(ctx.multi_insert_select_list().value_expression().get(i)));
            }
            target.setExpressions(expressions);
        }

        if (checkIfExist(ctx.search_condition())) {
            Selection selection = new Selection(visitSearch_condition(ctx.search_condition()));
            selection.setText(getRuleText(ctx.search_condition()));

            target.setCondition(selection);
        }
        
        if (checkIfExist(ctx.integration_params())) {
            Integration_paramsContext intctx = ctx.integration_params();
            if (checkIfExist(intctx.INTEGRATION_TYPE())) {
                 target.setIntegrationType(intctx.integration_type.getText());
            }
            if(checkIfExist(intctx.UPDATE_KEY())) {
                target.setUpdateKey(intctx.key.getText().toUpperCase());
            }                        
            if (checkIfExist(intctx.REJECT())) {
                target.setRejectLimit(Integer.valueOf(intctx.max_rejected.getText()));
                target.setRejectLimitUnit(intctx.rejected_unit.getText().toUpperCase());
            }            
        }
        
        if (checkIfExist(ctx.annotation())) {
            Collection<Annotation> annotations = getAnnotations(ctx.annotation());
            target.setAnnotations(annotations);            
        }

        return target;
    }

    @Override
    public MultiInsertTarget visitMulti_insert_def_target(SQLParser.Multi_insert_def_targetContext ctx) {
        MultiInsertTarget target = new MultiInsertTarget();
        target.setDefaultcond(Boolean.TRUE);

        if (checkIfExist(ctx.table_name())) {
            target.setTableName(ctx.table_name().getText());
        }

        if (checkIfExist(ctx.column_name_list())) {
            List<TargetColumn> targetColumns = TUtil.newList();
            ctx.column_name_list().target_column().stream().map((targColCtx) -> {
                TargetColumn targCol = new TargetColumn(targColCtx.identifier().getText());
                if (checkIfExist(targColCtx.annotation())) {
                    Collection<Annotation> annotations = getAnnotations(targColCtx.annotation());
                    targCol.setAnnotations(annotations);
                }
                return targCol;
            }).forEachOrdered(targetColumns::add);
            target.setTargetColumns(targetColumns);

        }

        if (checkIfExist(ctx.multi_insert_select_list())) {
            NamedExpr[] expressions = new NamedExpr[ctx.multi_insert_select_list().value_expression().size()];
            for (int i = 0; i < ctx.multi_insert_select_list().value_expression().size(); i++) {
                expressions[i] = new NamedExpr(visitValue_expression(ctx.multi_insert_select_list().value_expression().get(i)));
                expressions[i].setText(getRuleText(ctx.multi_insert_select_list().value_expression().get(i)));
            }
            target.setExpressions(expressions);
        }

        return target;
    }
    
    protected Collection<Annotation> getAnnotations(List<AnnotationContext> annotationsCtx) {
        Collection<Annotation> annotations = TUtil.newList();
                        
        annotationsCtx.stream().map((ctx) -> {
            Map<String, String> parameters = TUtil.newHashMap();
            ctx.annotation_element().forEach((SQLParser.Annotation_elementContext annoElmnt) -> 
                    parameters.put(
                            annoElmnt.identifier().getText().toUpperCase(), 
                            (checkIfExist(annoElmnt.Quoted_Identifier())) ? annoElmnt.Quoted_Identifier().getText() : CatalogUtil.stripQuote(annoElmnt.Character_String_Literal().getText())
                    )
            );
            Annotation anno = new DefaultAnnotation(ctx.identifier().getText(), parameters);
            return anno;
        }).forEachOrdered(annotations::add);
        
        return annotations;      
    }

}
