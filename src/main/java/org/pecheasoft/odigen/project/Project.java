package org.pecheasoft.odigen.project;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import org.pecheasoft.odigen.template.TemplateEngineType;

public final class Project {

    private final Path root;
    private final ProjectConfig config;
    private final List<ProjectObjectId> objects;

    public Project(Path root) {
        this.root = root;
        this.config = new ProjectConfigLoader().load(this.root);

        ProjectScanner scanner = new ProjectScanner();

        TemplateEngineType engine = config.templateEngine();

        var datastores = scanner.scan(root.resolve("datastores"), ObjectType.DATASTORE);
        var mappings   = scanner.scan(root.resolve("mappings"),   ObjectType.MAPPING);
        var templates  = scanner.scanTemplates(root.resolve("templates"), engine);

        this.objects = Stream.of(datastores, mappings, templates)
                             .flatMap(List::stream)
                             .toList();
    }

    public Path root() {
        return root;
    }

    public ProjectConfig config() {
        return config;
    }

    public List<ProjectObjectId> getObjects() {
        return objects;
    }

    public Path resolve(ProjectObjectId id) {
        return root.resolve(switch (id.type()) {
            case DATASTORE -> "datastores";
            case MAPPING -> "mappings";
            case TEMPLATE -> "templates";
        }).resolve(id.qualifiedName());
    }
}
