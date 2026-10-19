package org.pecheasoft.odigen.metadata;

import org.pecheasoft.odigen.project.ObjectType;
import org.pecheasoft.odigen.project.Project;
import org.pecheasoft.odigen.project.ProjectObject;
import org.pecheasoft.odigen.project.ProjectObjectId;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;

public final class MetadataManager {

    private final Project project;

    public MetadataManager(Project project) {
        this.project = project;
    }

    public Project project() { return project; }

    // ------------------------------------------------------------
    // Generic API
    // ------------------------------------------------------------

    public Optional<ProjectObject> find(ObjectType type, String qualifiedName) {
        return project.getObjects().stream()
            .filter(o -> o.type() == type && o.qualifiedName().equals(qualifiedName))
            .findFirst()
            .map(this::load);
    }

    public List<ProjectObject> findAll(ObjectType type, String qualifiedNamePrefix) {
        return project.getObjects().stream()
            .filter(o -> o.type() == type && o.qualifiedName().startsWith(qualifiedNamePrefix))
            .map(this::load)
            .toList();
    }

    private ProjectObject load(ProjectObjectId id) {
        try {
            String content = Files.readString(id.filePath());
            return new ProjectObject(id, content);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    // ------------------------------------------------------------
    // Typed API (thin wrappers)
    // ------------------------------------------------------------

    public Optional<ProjectObject> findDatastore(String qualifiedName) {
        return find(ObjectType.DATASTORE, qualifiedName);
    }

    /** Resolve a SQL reference by its full project path, independent of lexer casing. */
    public Optional<ProjectObject> findDatastoreReference(String qualifiedName) {
        List<ProjectObjectId> matches = project.getObjects().stream()
                .filter(o -> o.type() == ObjectType.DATASTORE
                        && o.qualifiedName().equalsIgnoreCase(qualifiedName))
                .toList();
        if (matches.size() > 1) {
            throw new IllegalArgumentException("Ambiguous datastore reference '" + qualifiedName
                    + "': " + matches.stream().map(o -> o.filePath().toString()).toList());
        }
        return matches.stream().findFirst().map(this::load);
    }

    public List<ProjectObject> findAllDatastores(String prefix) {
        return findAll(ObjectType.DATASTORE, prefix);
    }

    public Optional<ProjectObject> findMapping(String qualifiedName) {
        return find(ObjectType.MAPPING, qualifiedName);
    }

    public List<ProjectObject> findAllMappings(String prefix) {
        return findAll(ObjectType.MAPPING, prefix);
    }

    public Optional<ProjectObject> findTemplate(String qualifiedName) {
        return find(ObjectType.TEMPLATE, qualifiedName);
    }

    /** Explicit access to private package resources, not included in template listings. */
    public Optional<ProjectObject> findTemplateResource(String id) {
        for (ProjectObject object : findAllTemplates("")) {
            String prefix = object.id().qualifiedName() + "/";
            if (org.pecheasoft.odigen.template.TemplatePackage.isPackage(object) && id.startsWith(prefix)) {
                var pkg = new org.pecheasoft.odigen.template.TemplatePackage(object);
                return Optional.of(pkg.resource(id.substring(prefix.length())));
            }
        }
        return Optional.empty();
    }

    public List<ProjectObject> findAllTemplates(String prefix) {
        return findAll(ObjectType.TEMPLATE, prefix);
    }
}
