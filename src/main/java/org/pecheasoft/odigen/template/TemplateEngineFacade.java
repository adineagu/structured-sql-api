package org.pecheasoft.odigen.template;

import org.pecheasoft.odigen.project.ProjectObject;
import java.util.Collection;

public interface TemplateEngineFacade {
    void loadTemplates(Collection<ProjectObject> templates);
    String resolve(ProjectObject template, Collection<TemplateParameter> parameters);
}
