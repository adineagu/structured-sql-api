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
import org.pecheasoft.odigen.template.ITemplateService;
import org.pecheasoft.odigen.template.TemplateEngineType;
import org.pecheasoft.odigen.template.TemplateServiceFactory;
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

        // Apply a Velocity template to the structured AST and write the result to a file
        logger.info("Evaluating template using Apache Velocity...");
        String templateBody = main.readStream(main.getFileFromResourceAsStream("template/create_datastore.vtl"));
        String evalResult = main.evaluateTemplate("create_datastore", templateBody, struct, TemplateEngineType.VELOCITY);
        main.writeToFile("target/02_create_datastore_velocity.sql", evalResult);

        // Apply a StringTemplate 4 template to the structured AST and write the result to a file
        logger.info("Evaluating template using StringTemplate 4...");
        String st4TemplateBody = main.readStream(main.getFileFromResourceAsStream("template/create_datastore.st"));
        String st4EvalResult = main.evaluateTemplate("create_datastore", st4TemplateBody, struct, TemplateEngineType.STRING_TEMPLATE_4);
        main.writeToFile("target/02_create_datastore_st4.sql", st4EvalResult);

        // Apply a FreeMarker template to the structured AST and write the result to a file
        logger.info("Evaluating template using FreeMarker...");
        String fmTemplateBody = main.readStream(main.getFileFromResourceAsStream("template/create_datastore.ftl"));
        String fmEvalResult = main.evaluateTemplate("create_datastore", fmTemplateBody, struct, TemplateEngineType.FREEMARKER);
        main.writeToFile("target/02_create_datastore_freemarker.sql", fmEvalResult);

        // Apply a JTE template to the structured AST and write the result to a file
        logger.info("Evaluating template using JTE...");
        String jteTemplateBody = main.readStream(main.getFileFromResourceAsStream("template/create_datastore.jte"));
        String jteEvalResult = main.evaluateTemplate("create_datastore", jteTemplateBody, struct, TemplateEngineType.JTE);
        main.writeToFile("target/02_create_datastore_jte.sql", jteEvalResult);

        // Apply a Jinjava template to the structured AST and write the result to a file
        logger.info("Evaluating template using Jinjava...");
        String jinjaTemplateBody = main.readStream(main.getFileFromResourceAsStream("template/create_datastore.jinja"));
        String jinjaEvalResult = main.evaluateTemplate("create_datastore", jinjaTemplateBody, struct, TemplateEngineType.JINJAVA);
        main.writeToFile("target/02_create_datastore_jinjava.sql", jinjaEvalResult);

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

    private String evaluateTemplate(String templateName, String templateBody, IASTObject datastore, TemplateEngineType engineType) {

        // Create the appropriate template service using the factory
        ITemplateService engine = TemplateServiceFactory.createTemplateService(engineType);
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
    
    /**
     * Helper method for backwards compatibility - uses Velocity by default
     */
    private String evaluateTemplate(String templateName, String templateBody, IASTObject datastore) {
        return evaluateTemplate(templateName, templateBody, datastore, TemplateEngineType.VELOCITY);
    }

}
