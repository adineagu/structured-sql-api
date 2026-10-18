package org.pecheasoft.odigen.repl;

import org.pecheasoft.odigen.metadata.MetadataManager;
import org.pecheasoft.odigen.project.ProjectObject;
import org.pecheasoft.odigen.sql.api.ast.SemanticModel;
import org.pecheasoft.odigen.sql.api.transform.SemanticModelBuilder;
import org.pecheasoft.odigen.sql.parse.SQLStatementParser;
import org.pecheasoft.odigen.sql.parse.algebra.Expr;
import org.pecheasoft.odigen.template.TemplateEngineFacade;
import org.pecheasoft.odigen.template.TemplateParameter;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public final class CommandExecutor {

    private final Supplier<MetadataManager> metadata;
    private final TemplateEngineFacade templateEngine;

    public CommandExecutor(Supplier<MetadataManager> metadata,
                           TemplateEngineFacade templateEngine) {
        this.metadata = metadata;
        this.templateEngine = templateEngine;
    }

    public String execute(Command cmd) {
        return switch (cmd.name()) {
            case "help" -> handleHelp();
            case "list" -> handleList(cmd.args());
            case "show" -> handleShow(cmd.args());
            case "apply" -> handleApply(cmd.args());
            case "clear" -> { handleClear(); yield ""; }
            case "exit", "quit" -> "exit";
            default -> "Unknown command: " + cmd.name();
        };
    }

    // Please change the implementation to return String instead of printing directly to the console. This will allow us to capture the output and write it to a file if needed.

    private String handleHelp() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("Available commands:\n");
        sb.append("\n");
        sb.append("  help\n");
        sb.append("      Show this help message.\n");
        sb.append("\n");
        sb.append("  list <datastores|mappings|templates>\n");
        sb.append("      List all objects of the given type.\n");
        sb.append("\n");
        sb.append("  show <datastore|mapping|template> <id>\n");
        sb.append("      Show the content of the specified object.\n");
        sb.append("\n");
        sb.append("  apply <template_id> to <datastore|mapping> <id>\n");
        sb.append("      Resolve a template using the AST of the target object.\n");
        sb.append("\n");
        sb.append("  clear\n");
        sb.append("      Clear the console.\n");
        sb.append("\n");
        sb.append("  exit\n");
        sb.append("      Exit the REPL.\n");
        sb.append("\n");
        sb.append("  quit\n");
        sb.append("      Exit the REPL.\n");
        sb.append("\n");
        return sb.toString();
    }
    
    // -------------------------
    // CLEAR
    // -------------------------
    private void handleClear() {
        System.out.println("\033[H\033[2J");
    }

    // -------------------------
    // LIST
    // -------------------------
    private String handleList(List<String> args) {
        if (args.isEmpty()) return "Usage: list <datastores|mappings|templates>";

        return switch (args.get(0)) {
            case "datastores" -> metadata.get().findAllDatastores("")
                .stream().map(o -> o.id().qualifiedName())
                .collect(Collectors.joining("\n"));

            case "mappings" -> metadata.get().findAllMappings("")
                .stream().map(o -> o.id().qualifiedName())
                .collect(Collectors.joining("\n"));

            case "templates" -> metadata.get().findAllTemplates("")
                .stream().map(o -> o.id().qualifiedName())
                .collect(Collectors.joining("\n"));

            default -> "Unknown list target: " + args.get(0);
        };
    }

    // -------------------------
    // SHOW
    // -------------------------
    private String handleShow(List<String> args) {
        if (args.size() != 2) {
            return "Usage: show <datastore|mapping|template> <id>";
        }

        String type = args.get(0);
        String id = args.get(1);

        MetadataManager m = metadata.get();

        return switch (type) {
            case "datastore" -> metadata.get().findDatastore(id)
                .map(ProjectObject::content)
                .orElse("Datastore not found: " + id);

            case "mapping" -> metadata.get().findMapping(id)
                .map(ProjectObject::content)
                .orElse("Mapping not found: " + id);

            case "template" -> metadata.get().findTemplate(id)
                .map(ProjectObject::content)
                .orElse("Template not found: " + id);

            default -> "Unknown type: " + type;
        };
    }

    // -------------------------
    // APPLY
    // -------------------------
    private String handleApply(List<String> args) {
        // apply <template_id> to <object_type> <object_id>
        if (args.size() != 4 || !args.get(1).equals("to")) {
            return "Usage: apply <template_id> to <datastore|mapping> <id>";
        }

        String templateId = args.get(0);
        String objectType = args.get(2);
        String objectId = args.get(3);

        MetadataManager m = metadata.get();

        Optional<ProjectObject> template = m.findTemplate(templateId);
        if (template.isEmpty()) {
            return "Template not found: " + templateId;
        }

        Optional<ProjectObject> target = switch (objectType) {
            case "datastore" -> m.findDatastore(objectId);
            case "mapping" -> m.findMapping(objectId);
            default -> Optional.empty();
        };

        if (target.isEmpty()) {
            return "Object not found: " + objectId;
        }

        SemanticModel struct = parse(target.get().content());

        String parameterName = switch (objectType) {
            case "datastore" -> "datastore";
            case "mapping" -> "mapping";
            default -> "unknown";
        };

        String output = templateEngine.resolve(template.get(), List.of(TemplateParameter.of(parameterName, struct)));
        return output;
    }

    private SemanticModel parse(String stmt) {
        SQLStatementParser parser = new SQLStatementParser();
        Expr expr = parser.parse(stmt);
        SemanticModel struct = SemanticModelBuilder.getStructuredObject(expr);

        return struct;
    }

}
