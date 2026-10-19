package org.pecheasoft.odigen.sql.api.ast;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/*
Represents a basic query which can be a single SELECT..FROM... or multiple 
SELECT...FROM... combined using SET operators
*/

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({
    "className",
    "name",
    "datasets"
}
)

public class SemanticSetQueryBlock implements SemanticQueryBlock {

    private final List<Dataset> datasets;
    private SemanticAnnotationSet annotations;

    public SemanticSetQueryBlock() {
        this.datasets = new ArrayList<>();
    }

    public SemanticSetQueryBlock(List<Dataset> datasets) {
        this.datasets = datasets;
    }

    public List<Dataset> getDatasets() {
        return datasets;
    }

    public List<Dataset> datasets() {
        return datasets;
    }

    public void addDataset(Dataset dataset) {
        datasets.add(dataset);
    }

    @Override
    public SemanticAnnotationSet annotations() {
        return annotations;
    }

    public void setAnnotations(SemanticAnnotationSet annotations) {
        this.annotations = annotations;
    }

    @JsonInclude(Include.NON_NULL)
    @JsonPropertyOrder({
        "setOperator",
        "dataset"
    })
    public static class Dataset {
        private final SemanticQueryBlock dataset;
        private final String setOperator;

        public Dataset(SemanticQueryBlock dataset, String setOperator) {
            this.dataset = dataset;
            this.setOperator = setOperator;
        }

        public SemanticQueryBlock getDataset() {
            return dataset;
        }

        public String getSetOperator() {
            return setOperator;
        }

        // implement shallow copy for Dataset
        public Dataset shallowCopy() {
            return new Dataset(this.dataset.shallowCopy(), this.setOperator);
        }
    }

    @Override
    public SemanticSetQueryBlock shallowCopy() {
        SemanticSetQueryBlock newBlock = new SemanticSetQueryBlock();
        newBlock.setAnnotations(this.annotations());
        for (Dataset dataset : this.datasets) {
            newBlock.addDataset(dataset.shallowCopy());
        }
        return newBlock;
    }

}