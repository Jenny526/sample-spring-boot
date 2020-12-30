package com.tool.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.collect.ImmutableList;
import edu.washington.cs.knowitall.commonlib.Range;
import edu.washington.cs.knowitall.nlp.ChunkedSentence;

@JsonIgnoreProperties
public class ChunkedExtraction {
    private Range range;
    private ChunkedSentence sent;
    private String tokensAsString;
    private ImmutableList<Range> offsets;

    public ChunkedExtraction(Range range, ChunkedSentence sent, String tokensAsString, ImmutableList<Range> offsets) {
        this.range = range;
        this.sent = sent;
        this.tokensAsString = tokensAsString;
        this.offsets = offsets;
    }

    public ChunkedExtraction() {

    }

    public Range getRange() {
        return range;
    }

    public ChunkedSentence getSent() {
        return sent;
    }

    public void setRange(Range range) {
        this.range = range;
    }

    public void setSent(ChunkedSentence sent) {
        this.sent = sent;
    }

    public String getTokensAsString() {
        return tokensAsString;
    }

    public void setTokensAsString(String tokensAsString) {
        this.tokensAsString = tokensAsString;
    }

    public ImmutableList<Range> getOffsets() {
        return offsets;
    }

    public void setOffsets(ImmutableList<Range> offsets) {
        this.offsets = offsets;
    }
}
