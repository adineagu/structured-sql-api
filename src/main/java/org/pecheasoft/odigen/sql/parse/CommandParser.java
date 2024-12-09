/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pecheasoft.odigen.sql.parse;

import java.util.List;
import org.pecheasoft.odigen.sql.parse.algebra.Expr;

/**
 *
 * @author Adi Neagu
 */
public interface CommandParser {
    Expr parseScript(String sql);
    Expr parseSingleStatementScript(String sql);
    Expr parse(String sql);
    Expr parseExpression(String sql);
    Expr parseSortClause(String sql);
    List<String> splitScript(String scriptText);
}
