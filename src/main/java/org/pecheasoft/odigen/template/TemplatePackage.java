package org.pecheasoft.odigen.template;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.*;
import java.util.*;
import java.util.regex.*;
import org.pecheasoft.odigen.project.*;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.constructor.SafeConstructor;

/** A logical template with declared artifacts and private engine resources. */
public final class TemplatePackage {
    public record Artifact(String template, String output) {}
    private final ProjectObject descriptor;
    private final List<Artifact> artifacts;
    private final Map<String, ProjectObject> resources;
    private final TemplateEngineType engine;

    public static boolean isPackage(ProjectObject object) {
        return object.id().filePath().getFileName().toString().equals("template.yml");
    }

    public TemplatePackage(ProjectObject descriptor) {
        this.descriptor = descriptor;
        if (!isPackage(descriptor)) throw new IllegalArgumentException("Not a package descriptor");
        var options = new LoaderOptions();
        options.setAllowDuplicateKeys(false);
        Object parsed = new Yaml(new SafeConstructor(options)).load(descriptor.content());
        if (!(parsed instanceof Map<?, ?> data) || !data.keySet().equals(Set.of("engine", "artifacts"))
                || !(data.get("artifacts") instanceof List<?> entries) || entries.isEmpty())
            throw new IllegalArgumentException("template.yml requires engine and a non-empty artifacts list, with no other fields");
        if (!(data.get("engine") instanceof String engineName) || engineName.isBlank())
            throw new IllegalArgumentException("template.yml requires an engine name");
        try { engine = TemplateEngineType.valueOf(engineName.trim().toUpperCase(Locale.ROOT)); }
        catch (IllegalArgumentException ex) { throw new IllegalArgumentException("Unsupported template package engine: " + engineName, ex); }
        var outputs = new ArrayList<Artifact>();
        for (Object entry : entries) {
            if (!(entry instanceof Map<?, ?> fields) || !fields.keySet().equals(Set.of("template", "output"))
                    || !(fields.get("template") instanceof String template) || template.isBlank()
                    || !(fields.get("output") instanceof String output) || output.isBlank())
                throw new IllegalArgumentException("Each artifact requires template and output strings");
            String remaining = output.replace("{name}", "");
            if (remaining.contains("{") || remaining.contains("}")) throw new IllegalArgumentException("Unknown artifact output placeholder: " + output);
            outputs.add(new Artifact(template, output));
        }
        artifacts = List.copyOf(outputs);
        resources = loadResources();
        for (Artifact artifact : artifacts) resource(artifact.template());
    }

    public List<Artifact> artifacts() { return artifacts; }
    public TemplateEngineType engine() { return engine; }
    public Collection<ProjectObject> resources() { return resources.values(); }
    public ProjectObject resource(String name) {
        ProjectObject result = resources.get(name);
        if (result == null) {
            var matches = resources.entrySet().stream().filter(e -> withoutExtension(e.getKey()).equals(name)).toList();
            if (matches.size() == 1) result = matches.get(0).getValue();
        }
        if (result == null) throw new IllegalArgumentException("Unknown local template in package " + descriptor.id().qualifiedName() + ": " + name);
        return result;
    }

    private Map<String, ProjectObject> loadResources() {
        Path root = descriptor.id().filePath().getParent();
        var names = new LinkedHashMap<String, String>();
        try (var paths = Files.walk(root)) {
            for (Path file : paths.filter(Files::isRegularFile).filter(p -> TemplateExtensions.detect(p.getFileName().toString()) == engine).sorted().toList()) {
                if (!file.toRealPath().startsWith(root.toRealPath())) throw new IllegalArgumentException("Package resource escapes folder: " + file);
                String local = root.relativize(file).toString().replace('\\', '/');
                names.put(local, descriptor.id().qualifiedName() + "/" + local);
            }
        } catch (IOException ex) { throw new UncheckedIOException(ex); }
        var result = new LinkedHashMap<String, ProjectObject>();
        Pattern include = Pattern.compile(switch (engine) {
            case VELOCITY -> "#(parse|include)\\(\\s*(['\"])([^'\"]+)\\2\\s*\\)";
            case FREEMARKER -> "<#(include|import)\\s+(['\"])([^'\"]+)\\2";
            case PEBBLE, JINJAVA -> "\\{%[-+]?\\s*(include|extends|import|from)\\s+(['\"])([^'\"]+)\\2";
        });
        for (var entry : names.entrySet()) {
            Path file = root.resolve(entry.getKey());
            try {
                String content = Files.readString(file);
                Matcher matcher = include.matcher(content);
                String rewritten = matcher.replaceAll(match -> {
                    String requested = match.group(3);
                    if (requested.startsWith("library.")) return Matcher.quoteReplacement(match.group());
                    String resolved = names.get(requested);
                    if (resolved == null) {
                        var matches = names.entrySet().stream().filter(e -> withoutExtension(e.getKey()).equals(requested)).toList();
                        if (matches.size() == 1) resolved = matches.get(0).getValue();
                    }
                    if (resolved == null) throw new IllegalArgumentException("Missing package-local include: " + requested + " in " + file);
                    if (engine == TemplateEngineType.FREEMARKER) resolved = "/" + resolved;
                    int start = match.start(3) - match.start();
                    int end = match.end(3) - match.start();
                    return Matcher.quoteReplacement(match.group().substring(0, start) + resolved + match.group().substring(end));
                });
                // Dynamic resource names cannot be given reliable package-local semantics.
                String dynamic = switch (engine) {
                    case VELOCITY -> "#(?:parse|include)\\((?>\\s*)(?!['\"])";
                    case FREEMARKER -> "<#(?:include|import)\\s+(?!['\"\\s])";
                    case PEBBLE, JINJAVA -> "\\{%[-+]?\\s*(?:include|extends|import|from)\\s+(?!['\"\\s])";
                };
                if (Pattern.compile(dynamic).matcher(content).find())
                    throw new IllegalArgumentException("Package includes must use literal local names: " + file);
                result.put(entry.getKey(), new ProjectObject(new ProjectObjectId(ObjectType.TEMPLATE, entry.getValue(), file), rewritten));
            } catch (IOException ex) { throw new UncheckedIOException(ex); }
        }
        return Collections.unmodifiableMap(result);
    }

    private static String withoutExtension(String name) {
        return name.substring(0, name.lastIndexOf('.'));
    }
}
