package org.pecheasoft.odigen.template;

import org.pecheasoft.odigen.template.freemarker.FreeMarkerTemplateService;
import org.pecheasoft.odigen.template.jinjava.JinjavaTemplateService;
import org.pecheasoft.odigen.template.jte.JteTemplateService;
import org.pecheasoft.odigen.template.stringtemplate.StringTemplate4Service;
import org.pecheasoft.odigen.template.velocity.ApacheVelocityTemplateService;

/**
 * Factory for creating template service instances based on the desired engine type.
 * 
 * @author Generated
 */
public class TemplateServiceFactory {
    
    /**
     * Creates and returns a template service implementation based on the specified engine type.
     * 
     * @param engineType The type of template engine to create
     * @return An initialized ITemplateService instance
     * @throws IllegalArgumentException if the engine type is null or not supported
     */
    public static ITemplateService createTemplateService(TemplateEngineType engineType) {
        if (engineType == null) {
            throw new IllegalArgumentException("Template engine type cannot be null");
        }
        
        return switch (engineType) {
            case VELOCITY -> new ApacheVelocityTemplateService();
            case STRING_TEMPLATE_4 -> new StringTemplate4Service();
            case FREEMARKER -> new FreeMarkerTemplateService();
            case JTE -> new JteTemplateService();
            case JINJAVA -> new JinjavaTemplateService();
        };
    }
    
    /**
     * Creates a template service using the default engine (Velocity for backwards compatibility).
     * 
     * @return An initialized ITemplateService instance using Apache Velocity
     */
    public static ITemplateService createDefaultTemplateService() {
        return createTemplateService(TemplateEngineType.VELOCITY);
    }
}
