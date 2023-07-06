package com.MagicQuestion.MagicQuestion.models;

import java.util.ArrayList;
import java.util.List;

public class Definition {

    private int id;
    private String word;
    private String definition;


    public Definition() {}
    public Definition(String word, String definition, int id){
        this.id = id;
        this.word = word;
        this.definition = definition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        return getWord() + " "+ getDefinition();
    }
}