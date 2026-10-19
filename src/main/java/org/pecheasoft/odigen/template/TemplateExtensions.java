package org.pecheasoft.odigen.template;

import java.util.Map;

public final class TemplateExtensions {

    public static final Map<String, TemplateEngineType> EXT_TO_ENGINE = Map.of(
        "peb", TemplateEngineType.PEBBLE,
        "pebble", TemplateEngineType.PEBBLE,
        "ftl", TemplateEngineType.FREEMARKER,
        "vm", TemplateEngineType.VELOCITY,
        "vtl", TemplateEngineType.VELOCITY,
        "j2", TemplateEngineType.JINJAVA,
        "jinja", TemplateEngineType.JINJAVA
    );

    public static TemplateEngineType detect(String filename) {
        int idx = filename.lastIndexOf('.');
        if (idx < 0) return null;
        String ext = filename.substring(idx + 1).toLowerCase();
        return EXT_TO_ENGINE.get(ext);
    }
}
