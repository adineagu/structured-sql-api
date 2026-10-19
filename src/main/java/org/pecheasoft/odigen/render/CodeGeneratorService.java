package org.pecheasoft.odigen.render;

import java.util.Optional;

import org.pecheasoft.odigen.metadata.MetadataManager;
import org.pecheasoft.odigen.metadata.MetadataResolver;
import org.pecheasoft.odigen.project.Project;
import org.pecheasoft.odigen.project.ProjectObject;
import org.pecheasoft.odigen.sql.api.ast.SemanticModel;
import org.pecheasoft.odigen.template.TemplateEngineFacade;
import org.pecheasoft.odigen.template.TemplateEngineFacadeFactory;

public class CodeGeneratorService {
    public final Project project;
    private final TemplateEngineFacade templateEngine;
    private TransformationContext transformationContext;
    private final MetadataManager metadata;
    private MetadataResolver.Mode metadataResolution = MetadataResolver.Mode.STRICT;

    public CodeGeneratorService(Project project, MetadataManager metadata) {
        this.project = project;
        this.transformationContext = new TransformationContext();
        this.metadata = metadata;
        this.templateEngine = TemplateEngineFacadeFactory.create(project);
    }

    public CodeGeneratorService withContext(TransformationContext context) {
        this.transformationContext = java.util.Objects.requireNonNull(context);
        return this;
    }

    public SemanticModel parse(String statement) {
        return new MetadataResolver(metadata).parse(statement, "<inline specification>", metadataResolution);
    }

    public SemanticModel parse(ProjectObject object) {        
        return new MetadataResolver(metadata).parse(object, metadataResolution);
    }    

    /** Strict by default; opt out only for strategies that accept incomplete definitions. */
    public CodeGeneratorService withMetadataResolution(MetadataResolver.Mode mode) {
        this.metadataResolution = java.util.Objects.requireNonNull(mode);
        return this;
    }
    
    public TransformationBuilder transform(String source) {
        ProjectObject obj = getProjectObject(source);
        if (obj == null) {
            throw new IllegalArgumentException("No datastore or mapping found with id: " + source);
        }

        return new TransformationBuilder(obj, transformationContext, templateEngine, metadata, metadataResolution);
    }

    /** Render all artifacts before writing any. Keys are relative output paths, values template IDs. */
    public void generate(String source, java.util.Map<String, String> artifacts, java.nio.file.Path directory)
            throws java.io.IOException {
        var root = directory.toAbsolutePath().normalize();
        var rendered = new java.util.LinkedHashMap<java.nio.file.Path, String>();
        for (var entry : artifacts.entrySet()) {
            var relative = java.nio.file.Path.of(entry.getKey());
            var destination = root.resolve(relative).normalize();
            if (relative.isAbsolute() || !destination.startsWith(root) || destination.equals(root)) {
                throw new IllegalArgumentException("Artifact path must be relative and inside output directory: " + entry.getKey());
            }
            if (rendered.containsKey(destination)) throw new IllegalArgumentException("Duplicate artifact path: " + entry.getKey());
            rendered.put(destination, transform(source).using(entry.getValue()).render());
        }
        writeArtifacts(rendered);
    }

    private void writeArtifacts(java.util.Map<java.nio.file.Path, String> rendered) throws java.io.IOException {
        for (var entry : rendered.entrySet()) {
            java.nio.file.Files.createDirectories(entry.getKey().getParent());
            java.nio.file.Files.writeString(entry.getKey(), entry.getValue());
        }
    }

    /** Return package artifacts without writing. {name} is the source object's project basename. */
    public java.util.Map<String, String> renderPackage(String source, String packageId) {
        var descriptor = metadata.findTemplate(packageId).orElseThrow(() -> new IllegalArgumentException("Template package not found: " + packageId));
        var pkg = new org.pecheasoft.odigen.template.TemplatePackage(descriptor);
        var object = getProjectObject(source);
        if (object == null) throw new IllegalArgumentException("Source not found: " + source);
        String name = object.id().qualifiedName().substring(object.id().qualifiedName().lastIndexOf('.') + 1);
        if (!name.matches("[A-Za-z0-9_-]+")) throw new IllegalArgumentException("Unsafe artifact basename: " + name);
        var result = new java.util.LinkedHashMap<String, String>();
        var paths = new java.util.HashSet<java.nio.file.Path>();
        for (var artifact : pkg.artifacts()) {
            String output = artifact.output().replace("{name}", name);
            var path = java.nio.file.Path.of(output).normalize();
            if (path.isAbsolute() || path.getRoot() != null || output.contains(":") || output.startsWith("\\")
                    || path.startsWith("..") || path.toString().isBlank() || path.toString().equals("."))
                throw new IllegalArgumentException("Invalid artifact output path: " + output);
            if (!paths.add(path)) throw new IllegalArgumentException("Duplicate artifact output: " + output);
            var builder = new TemplateBuilder(pkg.resource(artifact.template()), object, transformationContext, templateEngine, metadata, metadataResolution);
            result.put(path.toString().replace('\\', '/'), builder.withParameter("artifactName", name).render());
        }
        return java.util.Collections.unmodifiableMap(result);
    }

    public void generatePackage(String source, String packageId, java.nio.file.Path directory) throws java.io.IOException {
        var artifacts = renderPackage(source, packageId);
        var root = directory.toAbsolutePath().normalize();
        var output = new java.util.LinkedHashMap<java.nio.file.Path, String>();
        artifacts.forEach((path, content) -> {
            var destination = root.resolve(path).normalize();
            if (!destination.startsWith(root)) throw new IllegalArgumentException("Artifact escapes output directory: " + path);
            output.put(destination, content);
        });
        writeArtifacts(output);
    }

    private ProjectObject getProjectObject(String id) {
        Optional<ProjectObject> obj = metadata.findDatastore(id);
        
        if (obj.isPresent()) {
            return obj.get();
        } else {
            obj = metadata.findMapping(id);
            if (obj.isPresent()) {
                return obj.get();
            }
        }
        return null;
    }

}
