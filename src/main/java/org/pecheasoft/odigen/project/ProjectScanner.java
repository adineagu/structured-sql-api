package org.pecheasoft.odigen.project;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.pecheasoft.odigen.template.TemplateEngineType;
import org.pecheasoft.odigen.template.TemplateExtensions;

public final class ProjectScanner {

    public List<ProjectObjectId> scan(Path root, ObjectType type) {
        try (Stream<Path> stream = Files.walk(root)) {
            return stream
                .filter(Files::isRegularFile)
                .map(path -> toId(root, path, type))
                .toList();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private ProjectObjectId toId(Path root, Path file, ObjectType type) {
        Path rel = root.relativize(file); // e.g. source/kdb/kunde.sql

        // Drop the first folder (e.g. "source")
        //Path withoutFirst = rel.subpath(1, rel.getNameCount());

        // Remove extension
        String filename = rel.toString();
        int dot = filename.lastIndexOf('.');
        if (dot != -1) {
            filename = filename.substring(0, dot);
        }

        // Convert / to .
        String qualifiedName = filename.replace(File.separatorChar, '.');

        return new ProjectObjectId(type, qualifiedName, file);
    }

    public List<ProjectObjectId> scanTemplates(Path root, TemplateEngineType engine) {
        List<ProjectObjectId> result = new ArrayList<>();

        try (var stream = Files.walk(root)) {
            stream.filter(Files::isRegularFile).forEach(path -> {
                String filename = path.getFileName().toString();

                TemplateEngineType detected = TemplateExtensions.detect(filename);

                if (detected != null && detected == engine) {
                    String qname = toQualifiedName(root, path);
                    result.add(new ProjectObjectId(ObjectType.TEMPLATE, qname, path));
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    private String toQualifiedName(Path root, Path file) {
        String filename = root.relativize(file).toString();

        int dot = filename.lastIndexOf('.');
        if (dot != -1) {
            filename = filename.substring(0, dot);
        }
        return filename.replace(File.separatorChar, '.');
    }

}

