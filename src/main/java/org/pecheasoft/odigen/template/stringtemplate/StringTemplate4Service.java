package org.pecheasoft.odigen.template.stringtemplate;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.pecheasoft.odigen.project.ProjectObject;
import org.pecheasoft.odigen.template.TemplateEngineFacade;
import org.pecheasoft.odigen.template.TemplateParameter;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

/**
 * StringTemplate 4 (ST4) implementation of the template service.
 * ST4 is designed specifically for code generation and enforces separation of logic and presentation.
 * 
 * @author Generated
 */
public class StringTemplate4Service implements TemplateEngineFacade {

    private STGroup group;
    private Map<String, String> templateBodies;

    public StringTemplate4Service() {
        this.templateBodies = new HashMap<>();
        initialize();
    }

    public void initialize() {
        // Initialize with an empty group. Templates will be added via loadTemplates()
        this.group = new STGroupString("");
    }

    @Override
    public void loadTemplates(Collection<ProjectObject> templates) {
        // Clear existing templates
        templateBodies.clear();
        
        // Store template bodies
        templates.forEach(t -> templateBodies.put(t.id().qualifiedName(), t.content()));
        
        // Build group with all templates
        StringBuilder groupDef = new StringBuilder();
        templates.forEach(t -> {
            // ST4 template definition format: templateName(params) ::= <<template body>>
            groupDef.append(t.id().qualifiedName()).append("(");
            groupDef.append(") ::= <<\n");
            groupDef.append(t.content());
            groupDef.append("\n>>\n\n");
        });
        
        // Create new group with all templates
        if (groupDef.length() > 0) {
            this.group = new STGroupString(groupDef.toString());
            this.group.setListener(new org.stringtemplate.v4.STErrorListener() {
                @Override
                public void compileTimeError(org.stringtemplate.v4.misc.STMessage msg) {
                    System.err.println("ST4 Compile Error: " + msg);
                }

                @Override
                public void runTimeError(org.stringtemplate.v4.misc.STMessage msg) {
                    System.err.println("ST4 Runtime Error: " + msg);
                }

                @Override
                public void IOError(org.stringtemplate.v4.misc.STMessage msg) {
                    System.err.println("ST4 IO Error: " + msg);
                }

                @Override
                public void internalError(org.stringtemplate.v4.misc.STMessage msg) {
                    System.err.println("ST4 Internal Error: " + msg);
                }
            });
        }
    }

    @Override
    public String resolve(ProjectObject template, Collection<TemplateParameter> parameters) {
        ST st;
        
        // Check if template is in the group
        if (group.isDefined(template.id().qualifiedName())) {
            st = group.getInstanceOf(template.id().qualifiedName());
        } else {
            // Create a standalone template if not in group
            st = new ST(group, template.content());
        }
        
        if (st == null) {
            throw new RuntimeException("Template not found: " + template.id().qualifiedName());
        }
        
        // Add all parameters to the template
        Map<String, Object> context = parameters.stream()
            .collect(Collectors.toMap(
                TemplateParameter::name,
                TemplateParameter::value
            ));
        
        context.forEach(st::add);

        return st.render();
    }

}
