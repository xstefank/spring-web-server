package com.example.springwebserver.model;

public class Info {

    private String id;
    private String whereami;
    private String joke;

    public Info() {
    }

    public Info(String id, String whereami, String joke) {
        this.id = id;
        this.whereami = whereami;
        this.joke = joke;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWhereami() {
        return whereami;
    }

    public void setWhereami(String whereami) {
        this.whereami = whereami;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }
}
