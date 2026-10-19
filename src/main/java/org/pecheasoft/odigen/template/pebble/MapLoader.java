package org.pecheasoft.odigen.template.pebble;

import java.io.Reader;
import java.io.StringReader;
import java.util.Map;

import io.pebbletemplates.pebble.loader.Loader;

public class MapLoader implements Loader<String> {

    private final Map<String, String> templates;

    public MapLoader(Map<String, String> templates) {
        this.templates = templates;
    }

    @Override
    public Reader getReader(String templateName) {
        String template = templates.get(templateName);
        if (template == null) {
            throw new RuntimeException("Template not found: " + templateName);
        }
        return new StringReader(template);
    }

    @Override
    public void setCharset(String charset) {
        // not needed
    }

    @Override
    public void setPrefix(String prefix) {
        // not needed
    }

    @Override
    public void setSuffix(String suffix) {
        // not needed
    }

    @Override
    public String resolveRelativePath(String relativePath, String anchorPath) {
        // not needed
        return relativePath;
    }

    @Override
    public String createCacheKey(String templateName) {
        // not needed
        return templateName;
    }

    @Override
    public boolean resourceExists(String templateName) {
        // not needed
        return templates.containsKey(templateName);
    }
}
