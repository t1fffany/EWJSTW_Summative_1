package com.MagicQuestion.MagicQuestion.models;

import java.util.*;


public class Word {
    private static HashMap<String, String> definitions = new HashMap<String, String>() {{
        put("abscond", "to secretly leave a place and go into hiding");
        put("girandole", "an ornamental branched candlestick");
        put("embezzle", "to steal money you have been trusted with");
        put("prowess", "great ability or skill");
        put("whimsical", "unusual in a playful or amusing way");
        put("abate", "to become less intense or widespread");
        put("cogent", "clear, logical, and convincing");
        put("ephemeral", "lasting for a very short time");
        put("gregarious", "fond of company; sociable");
        put("lament", "to express sorrow or grief");
    }};
    private static int idCounter = 1;

    private int id;
    private String word;
    private String definition;

    public Word(){
        id = idCounter++;
        Random random = new Random();
        // map definitions hashmap to arrayList
        List<Map.Entry<String, String>> definitionsEntries = new ArrayList<>(definitions.entrySet());
        // get random entry from definitions
        Map.Entry<String, String> randomDefinition = definitionsEntries.get(random.nextInt(definitionsEntries.size()));
        this.word = randomDefinition.getKey();
        this.definition = randomDefinition.getValue();
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