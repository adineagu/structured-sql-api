import java.nio.file.Files;
import java.nio.file.Path;
import org.pecheasoft.odigen.project.Project;
import org.pecheasoft.odigen.metadata.MetadataManager;
import org.pecheasoft.odigen.render.CodeGeneratorService;
import org.pecheasoft.odigen.sql.api.ast.impl.Datastore;

/** Public API checks for the documented SQL-first application fixture and API gaps. */
public class VerifyOracle {
    private static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }

    private static void rejects(Runnable action, String fragment) {
        try {
            action.run();
        } catch (RuntimeException error) {
            for (Throwable cause = error; cause != null; cause = cause.getCause()) {
                if (String.valueOf(cause.getMessage()).contains(fragment)) return;
            }
            throw new AssertionError("Unexpected rejection", error);
        }
        throw new AssertionError("Expected rejection: " + fragment);
    }

    private static void verifyChecks(CodeGeneratorService codegen, String sql) {
        var annotated = (Datastore) codegen.parse(sql);
        var rule = annotated.getConditions().get(0);
        check(rule.getName().equals("SALARY_NONNEGATIVE"), "CHECK name");
        check(rule.getCondition().replaceAll("\\s+", "").equals("SALARY>=0"), "CHECK expression");
        check(rule.annotations().get("VALIDATION").attribute("SEVERITY").equals("ERROR"), "CHECK policy retention");
        var plain = (Datastore) codegen.parse(sql.replace("@VALIDATION(SEVERITY=\"ERROR\")", ""));
        check(plain.getConditions().get(0).annotations().isEmpty(), "Unannotated CHECK");
    }

    public static void main(String[] args) throws Exception {
        Path root = Path.of(args.length == 0 ? "docs/agents/oracle-project" : args[0]);
        Files.createDirectories(root.resolve("mappings"));
        var project = new Project(root);
        var metadata = new MetadataManager(project);
        var codegen = new CodeGeneratorService(project, metadata);
        String sql = Files.readString(root.resolve("datastores/source/employees.sql"));
        var datastore = (Datastore) codegen.parse(metadata.findDatastore("source.employees").orElseThrow());
        check(datastore.getName().equals("DEMO.EMPLOYEES_RAW"), "Physical name");
        check(datastore.getAttributes().size() == 4, "Column count");
        for (int i = 0; i < 4; i++) check(datastore.getAttributes().get(i).getPosition() == i + 1, "Column order");
        check(datastore.getAttribute("EMPLOYEE_ID").getIsMandatory(), "NOT NULL metadata");
        check(!datastore.getAttribute("EMAIL").getIsMandatory(), "Nullable metadata");
        check(datastore.getAttribute("EMAIL").getLength() == 120, "VARCHAR size");
        check(datastore.getAttribute("SALARY").getPrecision() == 12
                && datastore.getAttribute("SALARY").getScale() == 2, "Decimal size");
        check(datastore.getAttribute("EMPLOYEE_NAME").getDescription().equals("Employee display name"), "COMMENT retention");
        check(datastore.getAttribute("EMAIL").annotations().get("CLEANSE").attribute("OP").equals("TRIM"), "Column policy");
        check(datastore.getKeys().size() == 2 && datastore.getKeys().get(0).isPrimaryKey()
                && datastore.getKeys().get(1).isAlternateKey(), "SQL key kinds");
        check(datastore.getKeys().get(1).getKeyColumns().equals(java.util.List.of("EMAIL")), "SQL key members");
        check(datastore.getKeys().get(1).annotations().get("VALIDATION").attribute("SEVERITY").equals("WARN"), "Key policy retention");
        check(datastore.getConditions().size() == 1, "SQL CHECK count");
        check(datastore.getConditions().get(0).annotations().get("VALIDATION").attribute("SEVERITY").equals("ERROR"), "CHECK policy");
        check(!datastore.getAttribute("EMPLOYEE_ID").getIsPrimaryKey(), "Documented column PK-flag limitation changed");
        var withoutNotNull = (Datastore) codegen.parse(sql.replace("DECIMAL(10,0) NOT NULL", "DECIMAL(10,0)"));
        check(!withoutNotNull.getAttribute("EMPLOYEE_ID").getIsMandatory(), "Unexpected PK-to-mandatory inference");

        var extended = (Datastore) codegen.parse(sql.replace("PRIMARY KEY (EMPLOYEE_ID)",
                "PRIMARY KEY (EMPLOYEE_ID) TYPE DATABASE DEFINED IN DATABASE ACTIVE CONTROL STATIC MESSAGE 'key issue'"));
        var extendedKey = extended.getKeys().get(0);
        check(extendedKey.isDefinedInDatabase() && extendedKey.isActive()
                && extendedKey.isStaticControlEnabled() && !extendedKey.isFlowControlEnabled()
                && extendedKey.getMessage().equals("key issue"), "Constraint SQL extension fields");

        var preview = codegen.renderPackage("source.employees", "oracle_validate");
        check(preview.size() == 2 && preview.equals(codegen.renderPackage("source.employees", "oracle_validate")), "Repeatable package");
        for (var entry : preview.entrySet()) {
            String expected = Files.readString(root.resolve("expected").resolve(entry.getKey()));
            check(expected.replaceAll("\\s+", "").equals(entry.getValue().replaceAll("\\s+", "")), "Fixture " + entry.getKey());
            check(!entry.getValue().contains("$") && !entry.getValue().contains("@"), "Leaked template or annotation syntax");
        }
        String prepared = codegen.transform("source.employees").using("oracle_validate/clean.vtl").withModel(datastore).render();
        check(prepared.equals(codegen.transform("source.employees").using("oracle_validate/clean.vtl").withModel(datastore).render()), "Prepared model mutation");
        rejects(() -> codegen.transform("source.employees").using("oracle_validate/clean.vtl")
                .withModel(withoutNotNull).render(), "explicitly declare NOT NULL");
        rejects(() -> codegen.transform("source.employees").using("oracle_validate/clean.vtl")
                .withModel(codegen.parse(sql.replace("OP=\"TRIM\"", "OP=\"UNKNOWN\""))).render(), "OP=TRIM on VARCHAR");
        rejects(() -> codegen.transform("source.employees").using("oracle_validate/validate.vtl")
                .withModel(codegen.parse(sql.replace("SEVERITY=\"WARN\"", "SEVERITY=\"UNKNOWN\""))).render(), "SEVERITY=ERROR or WARN");
        rejects(() -> codegen.transform("source.employees").using("oracle_validate/validate.vtl")
                .withModel(codegen.parse(sql.replace("UNIQUE KEY (EMAIL)", "UNIQUE KEY (EMAIL, EMPLOYEE_NAME)"))).render(), "Composite unique keys");
        verifyChecks(codegen, Files.readString(root.resolve("fixtures/with-check.sql")));
        rejects(() -> codegen.parse("CREATE TABLE T (ID DECIMAL(10,0) DEFAULT 0)"), "syntax error");
        System.out.println("Oracle fixture verified: SQL metadata, annotation scopes, policy rejections, repeatability, annotated/unannotated CHECK generation.");
    }
}
