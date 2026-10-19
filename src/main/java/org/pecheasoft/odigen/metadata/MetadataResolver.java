package org.pecheasoft.odigen.metadata;

import java.util.HashMap;
import java.util.Map;
import java.util.Locale;
import java.util.Optional;
import java.util.Stack;

import org.pecheasoft.odigen.project.ProjectObject;
import org.pecheasoft.odigen.sql.api.ast.SemanticAssignment;
import org.pecheasoft.odigen.sql.api.ast.SemanticModel;
import org.pecheasoft.odigen.sql.api.ast.impl.Datastore;
import org.pecheasoft.odigen.sql.api.ast.impl.DatastoreReferenceNode;
import org.pecheasoft.odigen.sql.api.ast.impl.InsertNode;
import org.pecheasoft.odigen.sql.api.ast.impl.MultiInsertTableNode;
import org.pecheasoft.odigen.sql.api.ast.impl.SelectItem;
import org.pecheasoft.odigen.sql.api.transform.BaseSemanticModelVisitor;
import org.pecheasoft.odigen.sql.api.transform.SemanticModelBuilder;
import org.pecheasoft.odigen.sql.parse.SQLStatementParser;

/** Injects structured file metadata into existing AST references, without interpreting strategy annotations. */
public final class MetadataResolver {
    public enum Mode { STRICT, ALLOW_UNRESOLVED }

    private final MetadataManager metadata;

    public MetadataResolver(MetadataManager metadata) {
        this.metadata = java.util.Objects.requireNonNull(metadata);
    }

    public SemanticModel parse(ProjectObject source, Mode mode) {
        return parse(source.content(), source.id().qualifiedName(), mode);
    }

    public SemanticModel parse(String sql, String sourceName, Mode mode) {
        SemanticModel model = SemanticModelBuilder.getStructuredObject(
                new SQLStatementParser().parseSingleStatementScript(sql));
        return resolve(model, sourceName, mode);
    }

    /** Mutates references in the supplied AST; explicitly attached definitions are retained. */
    public SemanticModel resolve(SemanticModel model, String sourceName, Mode mode) {
        java.util.Objects.requireNonNull(mode);
        if (!(model instanceof Datastore)) {
            new Resolution(sourceName, mode).visit(null, new Stack<>(), model);
        }
        return model;
    }

    private final class Resolution extends BaseSemanticModelVisitor<Void, Void> {
        private final String sourceName;
        private final Mode mode;
        // One cache per operation, so later generations see definition-file edits.
        private final Map<String, Optional<Datastore>> definitions = new HashMap<>();

        Resolution(String sourceName, Mode mode) {
            this.sourceName = sourceName;
            this.mode = mode;
        }

        private IllegalArgumentException error(String detail) {
            return new IllegalArgumentException("Metadata resolution for '" + sourceName + "': " + detail);
        }

        @Override
        public Void visitDatastoreReference(Void ctx, Stack<SemanticModel> stack, DatastoreReferenceNode node) {
            if (node.getDatastore() != null) return null;
            String name = node.getName();
            String key = name.toUpperCase(Locale.ROOT);
            Optional<Datastore> definition = definitions.computeIfAbsent(key, ignored -> load(name));
            if (definition.isEmpty() && mode == Mode.STRICT) {
                throw error("No definition for reference '" + name + "'; expected project datastore ID '"
                        + name + "' (for example datastores/" + name.replace('.', '/') + ".sql).");
            }
            definition.ifPresent(node::setMetadata);
            return null;
        }

        private Optional<Datastore> load(String name) {
            ProjectObject file;
            try {
                Optional<ProjectObject> found = metadata.findDatastoreReference(name);
                if (found.isEmpty()) return Optional.empty();
                file = found.get();
            } catch (RuntimeException ex) {
                throw error(ex.getMessage());
            }
            SemanticModel parsed;
            try {
                parsed = SemanticModelBuilder.getStructuredObject(
                        new SQLStatementParser().parseSingleStatementScript(file.content()));
            } catch (RuntimeException ex) {
                throw new IllegalArgumentException("Invalid datastore definition '" + file.id().filePath()
                        + "' for reference '" + name + "' in '" + sourceName + "'", ex);
            }
            if (!(parsed instanceof Datastore datastore)) {
                throw error("Definition '" + file.id().filePath() + "' for '" + name
                        + "' must declare a TABLE or DATASTORE.");
            }
            return Optional.of(datastore);
        }

        @Override
        public Void visitTargetAttribute(Void ctx, Stack<SemanticModel> stack, SemanticAssignment assignment) {
            if (mode == Mode.STRICT && assignment.getMetadata() == null) {
                String target = stack.stream().filter(InsertNode.class::isInstance).map(InsertNode.class::cast)
                        .map(InsertNode::getTarget).filter(java.util.Objects::nonNull)
                        .map(DatastoreReferenceNode::getName).findFirst().orElse("<unknown>");
                throw error("Target column '" + assignment.getName() + "' is absent from definition '" + target + "'.");
            }
            return null;
        }

        @Override
        public Void visitMultiInsertTarget(Void ctx, Stack<SemanticModel> stack, MultiInsertTableNode node) {
            if (node.getTarget() != null) node.getTarget().setIsTarget(true);
            super.visitMultiInsertTarget(ctx, stack, node);
            if (node.getSelectList() != null && node.getTarget() != null) {
                int position = 0;
                for (SelectItem item : node.getSelectList()) {
                    SemanticAssignment assignment = item.getTargetColumn();
                    if (assignment == null) {
                        assignment = new SemanticAssignment(item.getAlias(), position, null, node.getTarget());
                        assignment.setExpression(item);
                        item.setTargetColumn(assignment);
                    }
                    position++;
                    if (mode == Mode.STRICT && assignment.getMetadata() == null) {
                        throw error("Target column '" + item.getAlias() + "' is absent from definition '"
                                + node.getTarget().getName() + "'.");
                    }
                }
            }
            return null;
        }
    }
}
