package com.tool.model;

public class Sentence {
    private String token;

    private String pos;

    private String chunk;

    public Sentence(String token, String pos, String chunk) {
        this.token = token;
        this.pos = pos;
        this.chunk = chunk;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getChunk() {
        return chunk;
    }

    public void setChunk(String chunk) {
        this.chunk = chunk;
    }
}
