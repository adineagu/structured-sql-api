package org.pecheasoft.odigen;

import java.nio.file.Path;

import org.pecheasoft.odigen.metadata.MetadataManager;
import org.pecheasoft.odigen.project.Project;
import org.pecheasoft.odigen.render.CodeGeneratorService;

public class PythonBridge {

        private final Project project;
        private final MetadataManager metadata;
        private final CodeGeneratorService codegen;

        public PythonBridge(String projectRoot) {
                this.project = new Project(Path.of(projectRoot));
                this.metadata = new MetadataManager(project);
                this.codegen = new CodeGeneratorService(project, metadata);
        }

        public Project getProject() {
                return project;
        }

        public MetadataManager getMetadata() {
                return metadata;
        }

        public CodeGeneratorService getCodegen() {
                return codegen;
        }

        public Project project() {
                return project;
        }

        public MetadataManager metadata() {
                return metadata;
        }

        public CodeGeneratorService codegen() {
                return codegen;
        }
}
