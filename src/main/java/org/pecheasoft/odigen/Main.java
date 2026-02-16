package org.pecheasoft.odigen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.logging.Logger;

import org.pecheasoft.odigen.sql.api.ast.IASTObject;
import org.pecheasoft.odigen.sql.api.transform.StructuredObjectBuilder;
import org.pecheasoft.odigen.sql.parse.SQLStatementParser;
import org.pecheasoft.odigen.sql.parse.algebra.Expr;
import org.pecheasoft.odigen.template.ITemplate;
import org.pecheasoft.odigen.template.ITemplateParameter;
import org.pecheasoft.odigen.template.velocity.ApacheVelocityTemplateService;
import org.pecheasoft.odigen.template.velocity.TemplateEngineParameter;

public class Main {

    private static final Logger logger = Logger.getLogger("Main");
    
    public static void main(String[] args) {
        Main main = new Main();

        // parse a SQL statement and write the structured AST to a file
        String stmt = main.readStream(main.getFileFromResourceAsStream("sql/01_simple_select.sql"));
        Expr expr = main.parse(stmt);
        main.writeToFile("target/01_simple_select_expr.json", expr.toJson());

        IASTObject struct = StructuredObjectBuilder.getStructuredObject(expr);
        main.writeToFile("target/01_simple_select_ast.json", struct.toJson());

        // parse a CREATE TABLE statement and write the structured AST to a file
        stmt = main.readStream(main.getFileFromResourceAsStream("sql/02_create_table.sql"));
        expr = main.parse(stmt);
        main.writeToFile("target/02_create_table_expr.json", expr.toJson());

        struct = StructuredObjectBuilder.getStructuredObject(expr);
        main.writeToFile("target/02_create_table_ast.json", struct.toJson());

        // apply a template to the structured AST and write the result to a file
        String templateBody = main.readStream(main.getFileFromResourceAsStream("template/create_datastore.vtl"));
        String evalResult = main.evaluateTemplate("create_datastore", templateBody, struct);
        main.writeToFile("target/02_create_datastore.sql", evalResult);

        // parse an ALTER TABLE statement and write the structured AST to a file
        stmt = main.readStream(main.getFileFromResourceAsStream("sql/03_alter_table.sql"));
        expr = main.parse(stmt);
        main.writeToFile("target/03_alter_table_expr.json", expr.toJson());
    }

    private Expr parse(String stmt) {
        SQLStatementParser parser = new SQLStatementParser();
        Expr expr = parser.parse(stmt);

        return expr;
    }

    private InputStream getFileFromResourceAsStream(String fileName) {

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }
    }

    private String readStream(InputStream inputStream) {
        String result = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result += '\n' + line;
            }
        } catch (IOException e) {
            logger.log(java.util.logging.Level.SEVERE, "Error reading stream", e);
            return null;
        }
        return result;
    }

    public boolean writeToFile(String path, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(content);
        } catch (IOException e) {
            logger.log(java.util.logging.Level.SEVERE, "Error writing to file", e);
            return false;
        }
        return true;
    }

    private String evaluateTemplate(String templateName, String templateBody, IASTObject datastore) {

        ApacheVelocityTemplateService engine = new ApacheVelocityTemplateService();
        engine.initialize();

        ITemplate template = new ITemplate() {
            @Override
            public String getName() {
                return templateName;
            }

            @Override
            public String getBody() {
                return templateBody;
            }
        };

        Collection<ITemplate> templates = Arrays.asList(template);
        engine.loadTemplates(templates);

        ITemplateParameter parameter = new TemplateEngineParameter("datastore", (Object) datastore);

        Collection<ITemplateParameter> parameters = Arrays.asList(parameter);

        String result = engine.evaluate(template, parameters);

        return result;
    }

}
