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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.pecheasoft.odigen.sql.parse.algebra.Expr;
import org.pecheasoft.odigen.sql.parse.algebra.MultiaryOperator;
import org.pecheasoft.odigen.sql.parser.SQLLexer;
import org.pecheasoft.odigen.sql.parser.SQLParser;
import org.pecheasoft.odigen.sql.util.TUtil;

/**
 *
 * @author Adi Neagu
 */
public class SQLStatementParser implements CommandParser {

    private SQLParser parser;
    private final SQLAnalyzer analyzer = new SQLAnalyzer();
    private static final Logger LOG = Logger.getLogger(SQLStatementParser.class.getName());
    

    @Override
    public Expr parseScript(String sql) {
        
        try {
            CharStream input = CharStreams.fromStream(new ByteArrayInputStream(sql.getBytes(StandardCharsets.UTF_8)));
            
            SQLLexer lexer = new SQLLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            this.parser = new SQLParser(tokens);
            parser.setBuildParseTree(true);
            parser.removeErrorListeners();
            
            parser.setErrorHandler(new SQLErrorStrategy());
            parser.addErrorListener(new SQLErrorListener());
            
            SQLParser.ScriptContext context = parser.script();
                    
            return analyzer.visitScript(context);
        } catch (IOException ex) {
            LOG.log(Level.WARNING, "Error parsing script: {0}", ex.getMessage());
            return null;
        }
    }

    @Override
    public Expr parseSingleStatementScript(String sql) {
        try {
            CharStream input = CharStreams.fromStream(new ByteArrayInputStream(sql.getBytes(StandardCharsets.UTF_8)));
            SQLLexer lexer = new SQLLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            this.parser = new SQLParser(tokens);
            parser.setBuildParseTree(true);
            parser.removeErrorListeners();

            parser.setErrorHandler(new SQLErrorStrategy());
            parser.addErrorListener(new SQLErrorListener());

            SQLParser.SingleSqlScriptContext context = parser.singleSqlScript();

            return analyzer.visitSingleSqlScript(context);
        } catch (IOException ex) {
            LOG.log(Level.WARNING, "Error parsing script: {0}", ex.getMessage());
            return null;
        }
    }
        
    @Override
    public Expr parse(String sql) {
        try {
            CharStream input = CharStreams.fromStream(new ByteArrayInputStream(sql.getBytes(StandardCharsets.UTF_8)));
            SQLLexer lexer = new SQLLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            this.parser = new SQLParser(tokens);
            parser.setBuildParseTree(true);
            parser.removeErrorListeners();

            parser.setErrorHandler(new SQLErrorStrategy());
            parser.addErrorListener(new SQLErrorListener());

            SQLParser.SqlContext context = parser.sql();

            return analyzer.visitSql(context);
        } catch (IOException ex) {
            LOG.log(Level.WARNING, "Error parsing script: {0}", ex.getMessage());
            return null;
        }
    }

    @Override
    public Expr parseExpression(String sql) {
        try {
            CharStream input = CharStreams.fromStream(new ByteArrayInputStream(sql.getBytes(StandardCharsets.UTF_8)));
            SQLLexer lexer = new SQLLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            this.parser = new SQLParser(tokens);
            parser.setBuildParseTree(true);
            parser.removeErrorListeners();

            parser.setErrorHandler(new SQLErrorStrategy());
            parser.addErrorListener(new SQLErrorListener());

            SQLParser.Value_expressionContext context = parser.value_expression();

            return analyzer.visitValue_expression(context);
        } catch (IOException ex) {
            LOG.log(Level.WARNING, "Error parsing script: {0}", ex.getMessage());
            return null;
        }
    }

    @Override
    public Expr parseSortClause(String sql) {
        try {
            CharStream input = CharStreams.fromStream(new ByteArrayInputStream(sql.getBytes(StandardCharsets.UTF_8)));
            SQLLexer lexer = new SQLLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            this.parser = new SQLParser(tokens);
            parser.setBuildParseTree(true);
            parser.removeErrorListeners();

            parser.setErrorHandler(new SQLErrorStrategy());
            parser.addErrorListener(new SQLErrorListener());

            SQLParser.Orderby_clauseContext context = parser.orderby_clause();

            return analyzer.visitOrderby_clause(context);
        } catch (IOException ex) {
            LOG.log(Level.WARNING, "Error parsing script: {0}", ex.getMessage());
            return null;
        }
    }
    
    @Override
    public List<String> splitScript(String scriptText) {
        
        final Collection<Expr> statementsExpr = TUtil.newList();   
                
        Expr scriptExpr = parseScript(scriptText);
        
        if (scriptExpr instanceof MultiaryOperator multiaryOperator) {
            for (Expr stmtExpr : multiaryOperator.getOperands()) {
                stmtExpr.getText();
                statementsExpr.add(stmtExpr);
            }
        } else {
            statementsExpr.add(scriptExpr);
        }        
        
        return statementsExpr.stream().map(Expr::getText).collect(Collectors.toList());
    }
    
}
