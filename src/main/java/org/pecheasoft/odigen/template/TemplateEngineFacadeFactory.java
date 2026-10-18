package org.pecheasoft.odigen.template;

import org.pecheasoft.odigen.project.Project;
import org.pecheasoft.odigen.template.freemarker.FreeMarkerTemplateService;
import org.pecheasoft.odigen.template.jinjava.JinjavaTemplateService;
import org.pecheasoft.odigen.template.pebble.PebbleTemplateService;
import org.pecheasoft.odigen.template.velocity.ApacheVelocityTemplateService;

public final class TemplateEngineFacadeFactory {

    private TemplateEngineFacadeFactory() {
        // utility class
    }

    public static TemplateEngineFacade create(Project project) {
        return switch (project.config().templateEngine()) {
            case PEBBLE -> new PebbleTemplateService();
            case VELOCITY -> new ApacheVelocityTemplateService();
            case FREEMARKER -> new FreeMarkerTemplateService();
            case JINJAVA -> new JinjavaTemplateService();
        };
    }
}
