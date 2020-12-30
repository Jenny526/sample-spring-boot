package com.tool.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Extraction {
    private ChunkedArgumentExtraction arg1;

    private ChunkedExtraction rel;

    private ChunkedArgumentExtraction arg2;

    private double conf;

    public Extraction(ChunkedArgumentExtraction arg1, ChunkedArgumentExtraction arg2, ChunkedExtraction rel, double conf) {
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.rel = rel;
        this.conf = conf;
    }

    public Extraction() {

    }

    public ChunkedArgumentExtraction getArg1() {
        return arg1;
    }

    public void setArg1(ChunkedArgumentExtraction arg1) {
        this.arg1 = arg1;
    }

    public ChunkedExtraction getRel() {
        return rel;
    }

    public void setRel(ChunkedExtraction rel) {
        this.rel = rel;
    }

    public ChunkedArgumentExtraction getArg2() {
        return arg2;
    }

    public void setArg2(ChunkedArgumentExtraction arg2) {
        this.arg2 = arg2;
    }

    public double getConf() {
        return conf;
    }

    public void setConf(double conf) {
        this.conf = conf;
    }
}
