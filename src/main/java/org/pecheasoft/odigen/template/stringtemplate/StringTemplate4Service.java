package org.pecheasoft.odigen.template.stringtemplate;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;
import org.pecheasoft.odigen.template.ITemplate;
import org.pecheasoft.odigen.template.ITemplateParameter;
import org.pecheasoft.odigen.template.ITemplateService;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

/**
 * StringTemplate 4 (ST4) implementation of the template service.
 * ST4 is designed specifically for code generation and enforces separation of logic and presentation.
 * 
 * @author Generated
 */
public class StringTemplate4Service implements ITemplateService {

    private STGroup group;
    private Map<String, String> templateBodies;

    public StringTemplate4Service() {
        this.templateBodies = new HashMap<>();
        initialize();
    }

    @Override
    public void initialize() {
        // Initialize with an empty group. Templates will be added via loadTemplates()
        this.group = new STGroupString("");
    }

    @Override
    public void loadTemplates(Collection<ITemplate> templates) {
        // Clear existing templates
        templateBodies.clear();
        
        // Store template bodies
        templates.forEach(t -> templateBodies.put(t.getName(), t.getBody()));
        
        // Build group with all templates
        StringBuilder groupDef = new StringBuilder();
        templates.forEach(t -> {
            // ST4 template definition format: templateName(params) ::= <<template body>>
            groupDef.append(t.getName()).append("(");
            groupDef.append(") ::= <<\n");
            groupDef.append(t.getBody());
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
    public String evaluate(ITemplate template, Collection<ITemplateParameter> parameters) {
        ST st;
        
        // Check if template is in the group
        if (group.isDefined(template.getName())) {
            st = group.getInstanceOf(template.getName());
        } else {
            // Create a standalone template if not in group
            st = new ST(group, template.getBody());
        }
        
        if (st == null) {
            throw new RuntimeException("Template not found: " + template.getName());
        }
        
        // Add all parameters to the template
        parameters.forEach(p -> st.add(p.getName(), p.getValue()));
        
        return st.render();
    }

    @Override
    public String evaluate(Collection<Pair<ITemplate, Collection<ITemplateParameter>>> templatesCollection) {
        return templatesCollection
            .stream()
            .map(p -> evaluate(p.getLeft(), p.getRight()))
            .collect(Collectors.joining("\n"));
    }
}
