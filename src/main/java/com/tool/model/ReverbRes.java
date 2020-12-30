package com.tool.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties
public class ReverbRes {
    private List<Sentence> sentences;

    private List<Extraction> extractions;

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public List<Extraction> getExtractions() {
        return extractions;
    }

    public void setExtractions(List<Extraction> extractions) {
        this.extractions = extractions;
    }
}
