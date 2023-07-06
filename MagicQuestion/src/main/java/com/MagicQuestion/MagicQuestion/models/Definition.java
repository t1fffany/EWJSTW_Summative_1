package com.MagicQuestion.MagicQuestion.models;

<<<<<<< HEAD
=======
import java.util.ArrayList;
import java.util.List;

>>>>>>> 4fc53e550e63e0937dddeb71aaaf648983ffba7b
public class Definition {

    private int id;
    private String word;
    private String definition;

<<<<<<< HEAD
=======

>>>>>>> 4fc53e550e63e0937dddeb71aaaf648983ffba7b
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
<<<<<<< HEAD
}
=======
}
>>>>>>> 4fc53e550e63e0937dddeb71aaaf648983ffba7b
