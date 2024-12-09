/* 
 * Copyright 2017 DWH Tools.
 *
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://odieasy.com/11-licenses/eula
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.pecheasoft.odigen.sql.parse.formatter;

import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.pecheasoft.odigen.sql.parse.algebra.Aggregation;
import org.pecheasoft.odigen.sql.parse.algebra.BaseAlgebraVisitor;
import org.pecheasoft.odigen.sql.parse.algebra.ColumnDefinition;
import org.pecheasoft.odigen.sql.parse.algebra.CreateTable;
import org.pecheasoft.odigen.sql.parse.algebra.DateLiteral;
import org.pecheasoft.odigen.sql.parse.algebra.DropTable;
import org.pecheasoft.odigen.sql.parse.algebra.Expr;
import org.pecheasoft.odigen.sql.parse.algebra.FunctionExpr;
import org.pecheasoft.odigen.sql.parse.algebra.Having;
import org.pecheasoft.odigen.sql.parse.algebra.ITableConstraint;
import org.pecheasoft.odigen.sql.parse.algebra.Insert;
import org.pecheasoft.odigen.sql.parse.algebra.Join;
import org.pecheasoft.odigen.sql.parse.algebra.MultiInsert;
import org.pecheasoft.odigen.sql.parse.algebra.MultiInsertTarget;
import org.pecheasoft.odigen.sql.parse.algebra.NamedExpr;
import org.pecheasoft.odigen.sql.parse.algebra.Projection;
import org.pecheasoft.odigen.sql.parse.algebra.Relation;
import org.pecheasoft.odigen.sql.parse.algebra.RelationList;
import org.pecheasoft.odigen.sql.parse.algebra.Selection;
import org.pecheasoft.odigen.sql.parse.algebra.SetOperation;
import org.pecheasoft.odigen.sql.parse.algebra.Sort;
import org.pecheasoft.odigen.sql.parse.algebra.TableFunction;
import org.pecheasoft.odigen.sql.parse.algebra.TablePrimarySubQuery;
import org.pecheasoft.odigen.sql.parse.algebra.TargetColumn;
import org.pecheasoft.odigen.sql.parse.algebra.Unpivot;
import org.pecheasoft.odigen.sql.util.CatalogConstants;
import org.pecheasoft.odigen.sql.util.TUtil;

import com.google.common.base.Strings;

/**
 *
 * @author Adi Neagu
 */
public final class SQLStatementFormatter extends BaseAlgebraVisitor<SQLStatementFormatter.Context, Expr> {

    private static final String INDENT = "    ";
    private static final Logger LOG = Logger.getLogger(SQLStatementFormatter.class.getName());

    public static class Context {

        private final StringBuilder builder;
        private Integer indent;

        public Context(StringBuilder builder) {
            this.builder = builder;
            this.indent = 0;
        }

        public Context(StringBuilder builder, Integer indent) {
            this.builder = builder;
            this.indent = indent;
        }
    }

    public static String format(Expr root) {
        StringBuilder builder = new StringBuilder();
        SQLStatementFormatter.Context ctx = new SQLStatementFormatter.Context(builder, 0);
        SQLStatementFormatter formatter = new SQLStatementFormatter();
        formatter.visit(ctx, new Stack<>(), root);
        
        return builder.toString();
    }

    public static String format(Expr root, Integer indentation) {
        StringBuilder builder = new StringBuilder();
        SQLStatementFormatter.Context ctx = new SQLStatementFormatter.Context(builder, indentation);
        SQLStatementFormatter formatter = new SQLStatementFormatter();
        formatter.visit(ctx, new Stack<>(), root);
        
        return builder.toString();
    }

    @Override
    public Expr visitCreateTable(Context ctx, Stack<Expr> stack, CreateTable expr) {
                
        if (expr.isReplace()) {
            ctx.builder.append("CREATE OR REPLACE DATASTORE ");
        } else {
            ctx.builder.append("CREATE DATASTORE ");
        }
        
        if (expr.isIfNotExists()) {
            ctx.builder.append("IF NOT EXISTS ");
        }

        String name = TUtil.encloseEachToken(expr.getTableName(), CatalogConstants.IDENTIFIER_DELIMITER);
        
        ctx.builder.append(name).append("\n");

        if (!TUtil.isNullOrEmpty(expr.getAlias())) {
            ctx.builder.append("ALIAS ").append(expr.getAlias()).append('\n');
        }

        if (!TUtil.isNullOrEmpty(expr.getResourceName())) {
            ctx.builder.append("RESOURCE ").append(encloseWithinQuotes(expr.getResourceName())).append('\n');
        }

        if (!TUtil.isNullOrEmpty(expr.getOlapType())) {
            ctx.builder.append("OLAP TYPE ").append(encloseWithinQuotes(expr.getOlapType())).append('\n');
        }
        
         if (!TUtil.isNullOrEmpty(expr.getDescription())) {
            ctx.builder.append("DESCRIPTION ")
                    .append(encloseWithinQuotes(expr.getDescription().replaceAll("'", "\\\\'")))
                    .append('\n');
        }
         
        ctx.builder.append('(');

        ctx.indent++;

        boolean firstColumn = Boolean.TRUE;
        for (ColumnDefinition col : expr.getTableElements()) {
            ctx.builder.append(firstColumn ? "" : ",")
                    .append("\n")
                    .append(indentString(ctx.indent))
                    .append(TUtil.encloseIfRequired(col.getColumnName()))
                    .append("\t")
                    .append(TUtil.encloseNonReservedWordsIfRequired(col.getTypeName()));

            if (col.hasLengthOrPrecision()) {
                ctx.builder.append("(").append(col.getLengthOrPrecision());

                if (col.hasScale()) {
                    ctx.builder.append(",").append(col.getScale());
                }

                ctx.builder.append(")");
            }

            if (!col.isOptional()) {
                ctx.builder.append(" NOT NULL");
            }

            if (col.getOffset() != null) {
                ctx.builder.append("\tOFFSET ").append(col.getOffset());
            }

            if (col.getPhysLength() != null) {
                ctx.builder.append("\tPHYSICAL LENGTH ").append(col.getPhysLength());
            }

            if (col.getDecseparator() != null) {
                ctx.builder.append("\tDECIMAL SEPARATOR ").append(encloseWithinQuotes(col.getDecseparator()));
            }

            if (col.getFormat() != null) {
                ctx.builder.append("\tFORMAT ").append(encloseWithinQuotes(col.getFormat()));
            }

            if (col.getScdBehavior() != null) {
                ctx.builder.append("\t").append(col.getScdBehavior());
            }
            
            if (!TUtil.isNullOrEmpty(col.getDescription())) {
                ctx.builder.append("\t\t").append(String.format("COMMENT '%s'", col.getDescription().replaceAll("'", "\\\\'")));
            }

            firstColumn = Boolean.FALSE;
        }

        expr.getTableKeys().forEach(key -> {
            getTableConstraint(ctx, key);
        });

        ctx.builder.append("\n").append(")");
        ctx.indent--;

        if (expr.getFileDescriptor() != null) {
            CreateTable.FileDescriptor fd = expr.getFileDescriptor();
            ctx.builder.append("\n")
                    .append("FILE (\n")
                    .append(indentString(ctx.indent + 1))
                    .append("FORMAT ").append(fd.getFormat())
                    .append("\n")
                    .append(indentString(ctx.indent + 1))
                    .append("HEADING ").append(fd.getSkipHeadingLines());

            if (!TUtil.isNullOrEmpty(fd.getRecordSeparator())) {
                ctx.builder.append("\n")
                        .append(indentString(ctx.indent + 1))
                        .append("RECORD SEPARATOR ")
                        .append(encloseWithinQuotes(fd.getRecordSeparator()));
            }

            if (!TUtil.isNullOrEmpty(fd.getFieldSeparator())) {
                ctx.builder.append("\n")
                        .append(indentString(ctx.indent + 1))
                        .append("FIELD SEPARATOR ")
                        .append(encloseWithinQuotes(fd.getFieldSeparator()));
            }

            if (!TUtil.isNullOrEmpty(fd.getTextDelimiter())) {
                ctx.builder.append("\n")
                        .append(indentString(ctx.indent + 1))
                        .append("TEXT DELIMITER ")
                        .append(encloseWithinQuotes(fd.getTextDelimiter()));
            }

            if (!TUtil.isNullOrEmpty(fd.getDecimalDelimiter())) {
                ctx.builder.append("\n")
                        .append(indentString(ctx.indent + 1))
                        .append("DECIMAL SEPARATOR ")
                        .append(encloseWithinQuotes(fd.getDecimalDelimiter()));
            }

            ctx.builder.append("\n)");
        }

        ctx.builder.append("\n;\n\n");
        
        if (!TUtil.isNullOrEmpty(expr.getDescription())) {
            ctx.builder.append("ALTER DATASTORE ")
                    .append(name)
                    .append(" COMMENT '")
                    .append(expr.getDescription().replaceAll("'", "\\\\'"))
                    .append("';\n\n");
        }
        
        for (ColumnDefinition col : expr.getTableElements()) {
            if (!TUtil.isNullOrEmpty(col.getDescription())) {
                ctx.builder.append("ALTER DATASTORE ")
                        .append(name)
                        .append(" MODIFY COLUMN ")
                        .append(col.getColumnName())
                        .append(" COMMENT '")
                        .append(col.getDescription().replaceAll("'", "\\\\'"))
                        .append("';\n\n");
            }    
        }
        
        return null;
    }
    
    private void getTableConstraint(Context ctx, ITableConstraint constraint) {
        String type;
        String scope;
        String control = "";
        String message = "";
        String database = "";
        
        if (constraint.isPrimaryKey()) {
            type = "PRIMARY KEY";
        } else if (constraint.isAlternateKey()) {
            type = "UNIQUE KEY";
        } else if (constraint.isCheckConstraint()) {
            type = "CHECK";
        } else {
            type = "INDEX";
        }
        
        if (constraint.getScope() == ITableConstraint.ConstraintScope.DATABASE) {
            scope = "DATABASE";
        } else {
            scope = "ODI";
        }
        
        String consContent;
        
        if (!constraint.isCheckConstraint()) {
            consContent = StringUtils.join(constraint.getKeyColumns(), ", ");
        } else {
            consContent = SQLExpressionFormatter.format(constraint.getCondition());
        }
        
        if (constraint.isControlFlowEnabled() || constraint.isControlStaticEnabled()) {
            control = " CONTROL".concat(constraint.isControlFlowEnabled() ? " FLOW" : "").concat(constraint.isControlStaticEnabled()? " STATIC" : "");
        }
        
        if (!StringUtils.isBlank(constraint.getMessage())) {
            message = constraint.getMessage();
        }
        
        if (constraint.isDefinedInDatabase()) {
            database = " DEFINED IN DATABASE";
            
            if (constraint.isActive()) {
                database = database.concat(" ACTIVE");
            }
        }
        
        ctx.builder.append(",\n")
                .append(indentString(ctx.indent))
                .append("CONSTRAINT ")
                .append(constraint.getConstraintName())
                .append(" " ).append(type)
                .append(" (")
                .append(consContent)
                .append(")")
                .append(" TYPE ").append(scope);
        
        if (!StringUtils.isBlank(database)) {
            ctx.builder.append(database);
        }
        
        ctx.builder.append(control);
        
        if (!StringUtils.isBlank(message)) {
            ctx.builder.append(" MESSAGE ").append("'").append(message).append("'");
        }
    }

    @Override
    public Expr visitDropTable(Context ctx, Stack<Expr> stack, DropTable expr) {
        ctx.builder.append("DROP DATASTORE ");

        if (expr.isIfExists()) {
            ctx.builder.append("IF EXISTS ");
        }

        String name = TUtil.encloseEachToken(expr.getTableName(), CatalogConstants.IDENTIFIER_DELIMITER);
        
        ctx.builder.append(name).append("\n;\n\n");

        return null;
    }

    @Override
    public Expr visitInsert(Context ctx, Stack<Expr> stack, Insert expr) {
        if (expr.getAnnotations() != null && !expr.getAnnotations().isEmpty()) {
            ctx.builder.append(expr.getAnnotationsAsString()).append("\n").append(indentString(ctx.indent + 1)).append("\n");
        }
        ctx.builder
                .append("INSERT INTO ")
                .append(encloseNameTokens(expr.getTableName()))
                .append(expr.hasTableAlias() ? " " + TUtil.encloseIfReservedWord(expr.getTableAlias()) : "")
                .append(" (");

        for (int i = 0; i < expr.getTargetColumns().size(); i++) {
            TargetColumn tc = expr.getTargetColumns().get(i);
            ctx.builder.append("\n")
                    .append(indentString(ctx.indent + 1))
                    .append(i == 0 ? " " : ",");

            if (tc.getAnnotations() != null && !tc.getAnnotations().isEmpty()) {
                ctx.builder.append(tc.getAnnotationsAsString()).append("\n").append(indentString(ctx.indent + 1)).append(" ");
            }
            ctx.builder.append(SQLExpressionFormatter.encloseIfReservedWord(expr.getTargetColumns().get(i).getName()));
        }
        ctx.builder.append("\n)\n");

        if (expr.getSubQuery() != null) {
            super.visitInsert(ctx, stack, expr);
        }

        return null;
    }

    @Override
    public Expr visitMultiInsert(Context ctx, Stack<Expr> stack, MultiInsert expr) {

        ctx.builder.append("INSERT ALL");

        for (int i = 0; i < expr.getTargets().length; i++) {
            MultiInsertTarget target = expr.getTargets()[i];
            Expr cond = target.getCondition();

            ctx.builder.append("\n")
                    .append(indentString(ctx.indent + 1));

            if (!target.isDefaultcond()) {
                ctx.builder.append("WHEN (")
                        .append(SQLExpressionFormatter.format(cond, ctx.indent))
                        .append(") THEN ");
            } else {
                ctx.builder.append("ELSE ");
            }

            ctx.builder.append("INTO ")
                    .append(encloseNameTokens(target.getTableName()))
                    .append(target.hasTableAlias() ? " " + TUtil.encloseIfReservedWord(target.getTableAlias()) : "")
                    .append(" (");

            for (int j = 0; j < target.getTargetColumns().size(); j++) {
                TargetColumn tc = target.getTargetColumns().get(i);
                ctx.builder.append("\n")
                        .append(indentString(ctx.indent + 2))
                        .append(j == 0 ? " " : ",");

                if (tc.getAnnotations() != null && !tc.getAnnotations().isEmpty()) {
                    ctx.builder.append(tc.getAnnotationsAsString()).append(" ");
                }

                ctx.builder.append(SQLExpressionFormatter.encloseIfReservedWord(target.getTargetColumns().get(j).getName()));
            }

            ctx.builder.append("\n")
                    .append(indentString(ctx.indent + 1))
                    .append(") VALUES (");

            for (int j = 0; j < target.getExpressions().length; j++) {
                ctx.builder.append("\n")
                        .append(indentString(ctx.indent + 2))
                        .append(j == 0 ? " " : ",")
                        .append(SQLExpressionFormatter.format(target.getExpressions()[j], ctx.indent));
            }

            ctx.builder.append("\n")
                    .append(indentString(ctx.indent + 1))
                    .append(")");

            if (!TUtil.isNullOrEmpty(target.getIntegrationType())) {
                ctx.builder.append("\n")
                        .append(indentString(ctx.indent + 1))
                        .append("INTEGRATION TYPE ").append(encloseWithinQuotes(target.getIntegrationType()));
            }
            if (!TUtil.isNullOrEmpty(target.getUpdateKey())) {
                ctx.builder
                        .append("\n")
                        .append(indentString(ctx.indent + 1))
                        .append("UPDATE KEY ")
                        .append(target.getUpdateKey());
            }
            if (target.getRejectLimit() != null) {
                ctx.builder
                        .append("\n")
                        .append(indentString(ctx.indent + 1))
                        .append("REJECT LIMIT ").append(target.getRejectLimit()).append(" ").append(target.getRejectLimitUnit()).append("\n");
            }
        }

        if (expr.getSubQuery() != null) {
            super.visitMultiInsert(ctx, stack, expr);
        }

        return null;
    }

    @Override
    public Expr visitProjection(Context ctx, Stack<Expr> stack, Projection expr) {
        if (Objects.isNull(expr)) {
            LOG.severe("Projection object cannot be null");
            throw new RuntimeException("Projection object cannot be null");
        }

        if (expr.getAnnotations() != null && !expr.getAnnotations().isEmpty()) {
            ctx.builder.append("\n")
                    .append(indentString(ctx.indent))
                    .append(expr.getAnnotationsAsString());
                    
        }
        ctx.builder.append("\n")
                .append(indentString(ctx.indent))
                .append("SELECT");


        if (expr.isDistinct()) {
            ctx.builder.append(" DISTINCT");
        }

        boolean first = true;
        
        if (Objects.isNull(expr.getNamedExprs())) {
            LOG.severe("Projection does not have any projected attributes!");
            throw new RuntimeException("Projection does not have any projected attributes: " + expr);
        }        
        
        for (NamedExpr target : expr.getNamedExprs()) {            
            ctx.builder.append("\n")
                    .append(indentString(ctx.indent + 1))
                    .append(first ? " " : ",");
                
            if (target.getAnnotations() != null && !target.getAnnotations().isEmpty()) {
                ctx.builder.append(target.getAnnotationsAsString())
                        .append("\n")
                        .append(indentString(ctx.indent + 1))
                        .append(" ");
            }
            
            ctx.builder.append(SQLExpressionFormatter.format(target, ctx.indent));

            if (target.hasAlias()) {
                ctx.builder.append(" as ").append(SQLExpressionFormatter.encloseIfReservedWord(target.getAlias()));
            }

            first = false;
        }

        if (expr.hasChild()) {
            visit(ctx, stack, expr.getChild());
        }

        return null;
    }

    @Override
    public Expr visitTargetExpr(Context ctx, Stack<Expr> stack, NamedExpr expr) {
        ctx.builder.append("\n")
                .append(indentString(ctx.indent + 1))
                .append(SQLExpressionFormatter.format(expr, ctx.indent));

        if (expr.hasAlias()) {
            ctx.builder.append(" as ").append(SQLExpressionFormatter.encloseIfReservedWord(expr.getAlias()));
        }

        return null;
    }

    @Override
    public Expr visitRelationList(Context ctx, Stack<Expr> stack, RelationList expr) {
        ctx.builder.append("\n")
                .append(indentString(ctx.indent))
                .append("FROM");

        super.visitRelationList(ctx, stack, expr);
        return null;
    }

    @Override
    public Expr visitRelation(Context ctx, Stack<Expr> stack, Relation expr) {
        ctx.builder.append("\n")
                .append(indentString(ctx.indent + 1))
                .append(encloseNameTokens(expr.getName()));

        if (expr.hasAlias()) {
            ctx.builder.append(" ")
                    .append(SQLExpressionFormatter.encloseIfReservedWord(expr.getAlias()));
        }

        super.visitRelation(ctx, stack, expr);

        return null;
    }

    @Override
    public Expr visitTableSubQuery(Context ctx, Stack<Expr> stack, TablePrimarySubQuery expr) {
        ctx.indent++;

        ctx.builder.append("\n")
                .append(indentString(ctx.indent))
                .append("(");

        super.visitTableSubQuery(ctx, stack, expr);

        ctx.builder.append("\n")
                .append(indentString(ctx.indent))
                .append(")");

        if (!TUtil.isNullOrEmpty(expr.getName())) {
            ctx.builder.append(" ").append(expr.getName());
        }

        ctx.indent--;

        return null;
    }

    @Override
    public Expr visitJoin(Context ctx, Stack<Expr> stack, Join expr) {

        visit(ctx, stack, expr.getLeft());

        ctx.builder.append("\n")
                .append(indentString(ctx.indent + 1))
                .append(expr.getAnnotationsAsString())             
                .append("\n")
                .append(indentString(ctx.indent + 1))
                .append(expr.getJoinTypeAsSQL())
                .append(" ");

        ctx.indent++;
        
        if (expr.getRight() != null) {
            visit(ctx, stack, expr.getRight());
        }

        ctx.builder.append(" ON ")
                .append(SQLExpressionFormatter.format(expr.getQual(), ctx.indent));
        
        ctx.indent--;
        return null;
    }

    @Override
    public Expr visitFilter(Context ctx, Stack<Expr> stack, Selection expr) {
        if (expr.getChild() != null) {
            visit(ctx, stack, expr.getChild());
        }

        ctx.builder.append("\n")
                .append(indentString(ctx.indent))
                .append("WHERE")
                .append("\n")
                .append(indentString(ctx.indent + 1))
                .append(SQLExpressionFormatter.format(expr.getQual(), ctx.indent));

        return null;
    }

    @Override
    public Expr visitGroupBy(Context ctx, Stack<Expr> stack, Aggregation expr) {
        if (expr.getChild() != null) {
            visit(ctx, stack, expr.getChild());
        }
        
        for (org.pecheasoft.odigen.sql.parse.algebra.Aggregation.GroupElement groupElement : expr.getGroupSet()) {
            int i = 0;
            for (Expr groupingSet : groupElement.getGroupingSets()) {
                if (i==0) {
                    if (expr.getAnnotations() != null && !expr.getAnnotations().isEmpty()) {
                        ctx.builder.append("\n")
                                .append(indentString(ctx.indent))
                                .append(expr.getAnnotationsAsString());                    
                    }

                    ctx.builder.append("\n")
                            .append(indentString(ctx.indent))
                            .append("GROUP BY");                    
                }
                
                ctx.builder.append("\n")
                        .append(indentString(ctx.indent + 1))
                        .append(i++ == 0 ? " " : ",")
                        .append(SQLExpressionFormatter.format(groupingSet, ctx.indent));
            }
        }        
                
        return null;
    }

    @Override
    public Expr visitUnpivot(Context ctx, Stack<Expr> stack, Unpivot expr) {
        if (expr.getChild() != null) {
            visit(ctx, stack, expr.getChild());
        }
        
        String sourceAttributesNames = expr.getSourceAttributeNames()
                .stream()
                .collect(Collectors.joining(", ", "(", ")"));
        
        String mapExtressions = expr.getPivotMap().entrySet()
                .stream()
                .map(a -> String.format("(%s) AS %s", a.getValue().stream().collect(Collectors.joining(", ")), a.getKey()))
                .collect(Collectors.joining(",\n" + indentString(ctx.indent+3), "IN (\n" + indentString(ctx.indent+3), ")\n"));
                
        
        ctx.builder.append("\n")
                .append(indentString(ctx.indent+1))
                .append("UNPIVOT INCLUDE NULLS (")
                .append("\n")
                .append(indentString(ctx.indent+2))
                .append(sourceAttributesNames)
                .append("\n")
                .append(indentString(ctx.indent+2))
                .append("FOR ")
                .append(expr.getLocatorAttributeName())
                .append("\n")
                .append(indentString(ctx.indent+2))
                .append(mapExtressions)
                .append(indentString(ctx.indent+1))
                .append(") ")
                .append(String.format(" %s", expr.getAlias()))
                ;
                    
        return null;
    }
    
    

    @Override
    public Expr visitHaving(Context ctx, Stack<Expr> stack, Having expr) {
        if (expr.getChild() != null) {
            visit(ctx, stack, expr.getChild());
        }

        ctx.builder.append("\n")
                .append(indentString(ctx.indent))
                .append("HAVING")
                .append("\n")
                .append(indentString(ctx.indent + 1))
                .append(SQLExpressionFormatter.format(expr.getQual(), ctx.indent));

        return null;

    }

    @Override
    public Expr visitSort(Context ctx, Stack<Expr> stack, Sort expr) {
        if (expr.getChild() != null) {
            visit(ctx, stack, expr.getChild());
        }

        ctx.builder.append("\n")
                .append(indentString(ctx.indent))
                .append("ORDER BY");

        int i = 0;
        for (Sort.SortSpec sortSpec : expr.getSortSpecs()) {
            ctx.builder.append("\n")
                    .append(indentString(ctx.indent + 1))
                    .append(i++ == 0 ? " " : ",")
                    .append(SQLExpressionFormatter.format(sortSpec.getKey(), ctx.indent))
                    .append(sortSpec.isAscending() ? " ASC" : " DESC")
                    .append(sortSpec.isNullFirst() ? " NULLS FIRST" : " NULLS LAST");

        }
        return null;
    }

    @Override
    public Expr visitIntersect(Context ctx, Stack<Expr> stack, SetOperation expr) {
        return visitUnion(ctx, stack, expr);
    }

    @Override
    public Expr visitExcept(Context ctx, Stack<Expr> stack, SetOperation expr) {
        return visitUnion(ctx, stack, expr);
    }

    @Override
    public Expr visitUnion(Context ctx, Stack<Expr> stack, SetOperation expr) {
        int childCount = expr.getOperands().length;

        for (int i = 0; i < childCount; i++) {
            if (expr.getOperationTypes()[i] != null) {
                ctx.builder.append("\n")
                        .append(indentString(ctx.indent))
                        .append(expr.getOperationTypes()[i].toString().toUpperCase());
            }

            if (expr.getDistinctIndicators()[i] != null && !expr.getDistinctIndicators()[i]) {
                ctx.builder.append(" ALL");
            }

            visit(ctx, stack, expr.getOperands()[i]);
        }
        return null;
    }

    @Override
    public Expr visitTableFunction(Context ctx, Stack<Expr> stack, TableFunction expr) {
        ctx.builder.append("\n")
                .append(indentString(ctx.indent + 1))
                .append("TABLE(");
        
        visit(ctx, stack, expr.getFunction());
        
        ctx.builder.append(") ")                
                .append(" (")
                .append(Arrays.asList(expr.getColumns()).stream().map(TargetColumn::getName).collect(Collectors.joining(", ")))
                .append(") AS ")
                .append(expr.getName())
                .append("\n")
                ;
        return null;
    }

    @Override
    public Expr visitFunction(Context ctx, Stack<Expr> stack, FunctionExpr expr) {
        ctx.builder.append(expr.getSignature()).append("(");
        boolean isFirstParam = true;
        if (expr.getParams() != null) {
            for (int i = 0; i < expr.getParams().length; i++) {
                if (!isFirstParam) {
                    ctx.builder.append(",");
                }
                isFirstParam = false;
                Expr param = (expr.getParams())[i];
                if (param instanceof TablePrimarySubQuery) {
                    ctx.builder.append("CURSOR");
                    visit(ctx, stack, param);
                }
                else {
                    visit(ctx, stack, param);
                    ctx.builder.append(SQLExpressionFormatter.format(param));
                }
            }
        } 
        ctx.builder.append(")");
        return null;
    }   

    
    @Override
    public Expr visitDateLiteral(Context ctx, Stack<Expr> stack, DateLiteral expr) {
        ctx.builder.append("DATE'").append(expr.getText()).append("'");
        return null;
    }        
   
    private static String indentString(int indent) {
        return Strings.repeat(INDENT, indent);
    }

    private String encloseWithinQuotes(String text) {
        return "'" + text.replaceAll("'", "\\'") + "'";
    }

    private String encloseNameTokens(final String name) {
        String[] tokens = StringUtils.split(name, CatalogConstants.IDENTIFIER_DELIMITER);

        for (int i = 0; i < tokens.length; i++) {
            tokens[i] = SQLExpressionFormatter.encloseIfReservedWord(tokens[i]);
        }

        return StringUtils.join(tokens, CatalogConstants.IDENTIFIER_DELIMITER);
    }

}
