package org.pecheasoft.odigen.project;

import org.pecheasoft.odigen.template.TemplateEngineType;

public record ProjectConfig(TemplateEngineType templateEngine) {
    public static ProjectConfig defaultConfig() {
        return new ProjectConfig(TemplateEngineType.PEBBLE);
    }
}
