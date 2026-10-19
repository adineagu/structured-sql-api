package org.pecheasoft.odigen.sql.parse;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.pecheasoft.odigen.sql.api.ast.impl.DatastoreReferenceNode;
import org.pecheasoft.odigen.sql.parser.SQLLexer;
import org.pecheasoft.odigen.sql.parser.SQLParser;

/** Captures replacement spans in the exact expression text, never in another formatted copy. */
public final class EmbeddedTableReferences {
    public record Reference(int start, int end, DatastoreReferenceNode table, boolean needsAlias) {}

    private EmbeddedTableReferences() {}

    public static List<Reference> capture(String text, Set<String> enclosingCtes) {
        if (!text.toUpperCase(java.util.Locale.ROOT).contains("SELECT")) return List.of();
        SQLLexer lexer = new SQLLexer(CharStreams.fromString(text));
        lexer.removeErrorListeners();
        lexer.addErrorListener(new SQLErrorListener());
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        tokens.fill();
        if (tokens.getTokens().stream().noneMatch(t -> t.getType() == SQLLexer.SELECT)) return List.of();
        SQLParser parser = new SQLParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new SQLErrorListener());
        parser.setErrorHandler(new SQLErrorStrategy());
        ParseTree tree = parser.value_expression();
        if (tokens.LA(1) == SQLLexer.ASC || tokens.LA(1) == SQLLexer.DESC || tokens.LA(1) == SQLLexer.NULLS) {
            parser.reset();
            tree = parser.sort_specifier();
        }
        if (tokens.LA(1) != Token.EOF) {
            throw new IllegalArgumentException("Cannot capture embedded table references in incomplete expression: " + text);
        }
        Set<String> qualifiers = new HashSet<>();
        collectQualifiers(tree, qualifiers);
        List<Reference> references = new ArrayList<>();
        collect(tree, text, enclosingCtes, qualifiers, references);
        return List.copyOf(references);
    }

    private static void collectQualifiers(ParseTree tree, Set<String> qualifiers) {
        if (tree instanceof SQLParser.Column_referenceContext column && column.tb_name != null) {
            qualifiers.add(column.tb_name.getText());
        }
        for (int i = 0; i < tree.getChildCount(); i++) collectQualifiers(tree.getChild(i), qualifiers);
    }

    private static void collect(ParseTree tree, String text, Set<String> scope,
            Set<String> qualifiers, List<Reference> references) {
        if (tree instanceof SQLParser.Query_expressionContext query && query.with_clause() != null) {
            scope = new HashSet<>(scope);
            for (var definition : query.with_clause().named_query()) scope.add(definition.name.getText());
        }
        if (tree instanceof SQLParser.Table_or_query_nameContext name && !scope.contains(name.getText())) {
            String alias = tree.getParent() instanceof SQLParser.Table_primaryContext primary && primary.alias != null
                    ? primary.alias.getText() : null;
            DatastoreReferenceNode table = new DatastoreReferenceNode(name.getText(), alias);
            // ANTLR indexes Unicode code points; String.substring indexes UTF-16 units.
            int start = text.offsetByCodePoints(0, name.getStart().getStartIndex());
            int end = text.offsetByCodePoints(0, name.getStop().getStopIndex() + 1);
            references.add(new Reference(start, end, table, alias == null && qualifiers.contains(table.getBasename())));
        }
        for (int i = 0; i < tree.getChildCount(); i++) collect(tree.getChild(i), text, scope, qualifiers, references);
    }
}
