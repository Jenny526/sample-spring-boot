package com.tool.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class ChunkedArgumentExtraction {
    private ChunkedExtraction relation;
    private double confidence = 0.5D;

    public ChunkedArgumentExtraction(ChunkedExtraction relation, double confidence) {
        this.relation = relation;
        this.confidence = confidence;
    }

    public ChunkedArgumentExtraction() {

    }

    public ChunkedExtraction getRelation() {
        return relation;
    }

    public void setRelation(ChunkedExtraction relation) {
        this.relation = relation;
    }

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }
}
