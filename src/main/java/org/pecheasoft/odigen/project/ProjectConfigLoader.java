package org.pecheasoft.odigen.project;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;

import org.pecheasoft.odigen.template.TemplateEngineType;

public final class ProjectConfigLoader {

    private static final String CONFIG_FILE = "config.yml";

    public ProjectConfig load(Path projectRoot) {
        Path cfg = projectRoot.resolve(CONFIG_FILE);
        if (!Files.exists(cfg)) {
            return ProjectConfig.defaultConfig();
        }

        try {
            String content = Files.readString(cfg);
            String engineName = parseTemplateEngine(content);
            TemplateEngineType type = TemplateEngineType.valueOf(engineName.toUpperCase(Locale.ROOT));
            return new ProjectConfig(type);
        } catch (Exception e) {
            // fallback to default if config is broken
            return ProjectConfig.defaultConfig();
        }
    }

    private String parseTemplateEngine(String content) {
        // extremely minimal: look for line starting with "templateEngine:"
        return content.lines()
            .map(String::trim)
            .filter(l -> l.startsWith("templateEngine:"))
            .map(l -> l.substring("templateEngine:".length()).trim())
            .findFirst()
            .orElse("pebble");
    }
}
