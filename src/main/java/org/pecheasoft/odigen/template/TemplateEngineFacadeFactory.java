package org.pecheasoft.odigen.template;

import org.pecheasoft.odigen.project.Project;
import org.pecheasoft.odigen.metadata.MetadataManager;
import org.pecheasoft.odigen.project.*;
import java.util.ArrayList;
import java.util.List;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.io.IOException;
import java.io.UncheckedIOException;
import org.pecheasoft.odigen.template.freemarker.FreeMarkerTemplateService;
import org.pecheasoft.odigen.template.jinjava.JinjavaTemplateService;
import org.pecheasoft.odigen.template.pebble.PebbleTemplateService;
import org.pecheasoft.odigen.template.velocity.ApacheVelocityTemplateService;

public final class TemplateEngineFacadeFactory {

    private TemplateEngineFacadeFactory() {
        // utility class
    }

    public static TemplateEngineFacade create(Project project) {
        return new ProjectTemplateService(project);
    }

    public static TemplateEngineFacade createPackage(TemplatePackage pkg) {
        TemplateEngineFacade engine = create(pkg.engine());
        List<ProjectObject> templates = new ArrayList<>(libraries(pkg.engine()));
        templates.addAll(pkg.resources());
        engine.loadTemplates(templates);
        return engine;
    }

    /** Lazily initializes independent engine instances for packages and legacy templates. */
    private static final class ProjectTemplateService implements TemplateEngineFacade {
        private final Project project;
        private List<ProjectObject> templates;
        private TemplateEngineFacade legacy;
        private final java.util.Map<String, TemplateEngineFacade> packages = new java.util.HashMap<>();

        ProjectTemplateService(Project project) {
            this.project = project;
            this.templates = new MetadataManager(project).findAllTemplates("");
        }

        @Override public void loadTemplates(java.util.Collection<ProjectObject> templates) {
            this.templates = List.copyOf(templates);
            legacy = null;
            packages.clear();
        }

        @Override public String resolve(ProjectObject template, java.util.Collection<TemplateParameter> parameters) {
            if (TemplatePackage.isPackage(template))
                throw new IllegalArgumentException("Use renderPackage() for a template package");
            for (ProjectObject descriptor : templates) {
                if (TemplatePackage.isPackage(descriptor) && template.id().qualifiedName().startsWith(descriptor.id().qualifiedName() + "/")) {
                    TemplateEngineFacade engine = packages.computeIfAbsent(descriptor.id().qualifiedName(),
                            ignored -> createPackage(new TemplatePackage(descriptor)));
                    return engine.resolve(template, parameters);
                }
            }
            if (legacy == null) {
                legacy = create(project.config().templateEngine());
                var resources = new java.util.LinkedHashMap<String, ProjectObject>();
                libraries(project.config().templateEngine()).forEach(t -> resources.put(t.id().qualifiedName(), t));
                templates.stream().filter(t -> !TemplatePackage.isPackage(t)).forEach(t -> resources.put(t.id().qualifiedName(), t));
                legacy.loadTemplates(resources.values());
            }
            return legacy.resolve(template, parameters);
        }
    }
    public static TemplateEngineFacade create(TemplateEngineType type) {
        TemplateEngineFacade engine = switch (type) {
            case PEBBLE -> new PebbleTemplateService();
            case VELOCITY -> new ApacheVelocityTemplateService();
            case FREEMARKER -> new FreeMarkerTemplateService();
            case JINJAVA -> new JinjavaTemplateService();
        };
        engine.loadTemplates(libraries(type));
        return engine;
    }

    private static List<ProjectObject> libraries(TemplateEngineType type) {
        if (type != TemplateEngineType.VELOCITY) return List.of();
        try (var stream = TemplateEngineFacadeFactory.class.getResourceAsStream("/template/Query.vtl")) {
            if (stream == null) throw new IllegalStateException("Missing bundled Query.vtl");
            return List.of(new ProjectObject(new ProjectObjectId(ObjectType.TEMPLATE, "library.Query", Path.of("Query.vtl")),
                    new String(stream.readAllBytes(), StandardCharsets.UTF_8)));
        } catch (IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }
}
