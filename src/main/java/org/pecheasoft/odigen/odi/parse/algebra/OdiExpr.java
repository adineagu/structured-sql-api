package org.pecheasoft.odigen.odi.parse.algebra;

import org.pecheasoft.odigen.sql.parse.algebra.Expr;
import org.pecheasoft.odigen.sql.parse.algebra.OpType;

public class OdiExpr extends Expr {

    public OdiExpr() {
        super(OpType.SQLEXT);
    }

    public OdiExpr(OpType opType) {
        super(opType);
    }

}
