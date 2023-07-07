package com.MagicQuestion.MagicQuestion.models;


public class Definition {

    private String id;
    private String word;
    private String definition;

    public Definition() {
    }

    public Definition(String word, String definition, String id) {
        this.id = id;
        this.word = word;
        this.definition = definition;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    @Override
    public String toString() {
        return getWord() + " " + getDefinition();
    }
}
