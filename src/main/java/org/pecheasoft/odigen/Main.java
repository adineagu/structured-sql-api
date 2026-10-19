package org.pecheasoft.odigen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Logger;

import org.pecheasoft.odigen.sql.api.ast.SemanticModel;
import org.pecheasoft.odigen.sql.api.transform.SemanticModelBuilder;
import org.pecheasoft.odigen.sql.parse.SQLStatementParser;
import org.pecheasoft.odigen.sql.parse.algebra.Expr;
import org.pecheasoft.odigen.template.TemplateEngineType;

public class Main {

    private static final Logger logger = Logger.getLogger("Main");
    public static void main(String[] args) {
        Main main = new Main();

        // parse a SQL statement and write the structured AST to a file
        String stmt = main.readStream(main.getFileFromResourceAsStream("sql/01_simple_select.sql"));
        Expr expr = main.parse(stmt);
        main.writeToFile("target/01_simple_select_expr.json", expr.toJson());

        SemanticModel struct = SemanticModelBuilder.getStructuredObject(expr);
        main.writeToFile("target/01_simple_select_ast.json", struct.toJson());

        // parse a CREATE TABLE statement and write the structured AST to a file
        stmt = main.readStream(main.getFileFromResourceAsStream("sql/02_create_table.sql"));
        expr = main.parse(stmt);
        main.writeToFile("target/02_create_table_expr.json", expr.toJson());

        struct = SemanticModelBuilder.getStructuredObject(expr);
        main.writeToFile("target/02_create_table_ast.json", struct.toJson());

        // Apply a Velocity template to the structured AST and write the result to a file
        logger.info("Evaluating template using Apache Velocity...");
        String templateBody = main.readStream(main.getFileFromResourceAsStream("template/create_datastore.vtl"));
        String evalResult = main.evaluateTemplate("create_datastore", templateBody, struct, TemplateEngineType.VELOCITY);
        main.writeToFile("target/02_create_datastore_velocity.sql", evalResult);

        // Apply a FreeMarker template to the structured AST and write the result to a file
        logger.info("Evaluating template using FreeMarker...");
        String fmTemplateBody = main.readStream(main.getFileFromResourceAsStream("template/create_datastore.ftl"));
        String fmEvalResult = main.evaluateTemplate("create_datastore", fmTemplateBody, struct, TemplateEngineType.FREEMARKER);
        main.writeToFile("target/02_create_datastore_freemarker.sql", fmEvalResult);

        // Apply a Jinjava template to the structured AST and write the result to a file
        logger.info("Evaluating template using Jinjava...");
        String jinjaTemplateBody = main.readStream(main.getFileFromResourceAsStream("template/create_datastore.jinja"));
        String jinjaEvalResult = main.evaluateTemplate("create_datastore", jinjaTemplateBody, struct, TemplateEngineType.JINJAVA);
        main.writeToFile("target/02_create_datastore_jinjava.sql", jinjaEvalResult);

        // Apply a Pebble template to the structured AST and write the result to a file
        logger.info("Evaluating template using Pebble...");
        String pebbleTemplateBody = main.readStream(main.getFileFromResourceAsStream("template/create_datastore.peb"));
        String pebbleEvalResult = main.evaluateTemplate("create_datastore", pebbleTemplateBody, struct, TemplateEngineType.PEBBLE);
        main.writeToFile("target/02_create_datastore_pebble.sql", pebbleEvalResult);

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

    private String evaluateTemplate(String templateName, String templateBody, SemanticModel datastore, TemplateEngineType engineType) {
        var template = new org.pecheasoft.odigen.project.ProjectObject(
                new org.pecheasoft.odigen.project.ProjectObjectId(
                        org.pecheasoft.odigen.project.ObjectType.TEMPLATE, templateName, java.nio.file.Path.of(templateName)),
                templateBody);
        return org.pecheasoft.odigen.template.TemplateEngineFacadeFactory.create(engineType)
                .resolve(template, java.util.List.of(org.pecheasoft.odigen.template.TemplateParameter.of("datastore", datastore)));
    }
    

}
