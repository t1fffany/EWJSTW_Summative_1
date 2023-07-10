package com.MagicQuestion.MagicQuestion.models;

import java.util.*;


public class Quote {
    private static HashMap<String, String> quotes = new HashMap<String, String>() {{
        put("Frank Underwood (House of Cards)", "There are two kinds of pain. The sort of pain that makes you strong, or useless pain. The sort of pain that's only suffering. I have no patience for useless things.");
        put("Eleven (Stranger Things)", "Friends don't lie.");
        put("Princess Margaret (The Crown)", "I know who I am: a woman for the modern age. Free to live, to love, and free to break away.");
        put("Jonathan Van Ness (Queer Eye)", "You're strong, you're a Kelly Clarkson song, you got this.");
        put("The Professor (Money Heist)", "In the end, love is a good reason for everything to fall apart.");
        put("Bojack Horseman (Bojack Horseman)", "You know, sometimes I think I was born with a leak, and any goodness I started with just slowly spilled out of me and now it's all gone.");
        put("Suzanne 'Crazy Eyes' Warren (Orange Is The New Black)", "I am not crazy, I am unique.");
        put("Tommy Shelby (Peaky Blinders)", "I don't pay for suits. My suits are on the house or the house burns down.");
        put("Joe Goldberg (You)", "Love has taken me to some pretty dark places but Los Angeles has got to be as dark as it gets.");
        put("Maeve Wiley (Sex Education)", "I'm a big fan of ignoring a problem until eventually it just goes away.");
        put("Anne Lister (Gentleman Jack)", "I was born like this, why should I compromise myself?");
        put("Reginald Hargreeves (The Umbrella Academy)", "You are as elusive as the melody of a one-handed clapping man.");
        put("Hilda (Hilda)", "I'm not lost, I'm exploring.");
        put("Tokyo (Money Heist)", "After all, what's more human than the fight for survival?");
    }};
    private static int idCounter = 1;

    private String id;
    private String author;
    private String quote;


    public Quote(){
        this.id = Integer.toString(idCounter++);
        Random random = new Random();
        // map quotes hashmap to arrayList
        List<Map.Entry<String, String>> quotesEntries = new ArrayList<>(quotes.entrySet());
        // get random entry from quotes
        Map.Entry<String, String> randomQuote = quotesEntries.get(random.nextInt(quotesEntries.size()));
        this.author = randomQuote.getKey();
        this.quote = randomQuote.getValue();
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getAuthor() {
        return this.author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getQuote() {
        return this.quote;
    }
    public void setQuote(String quote) {
        this.quote = quote;
    }
    @Override
    public String toString() {
        return String.format("{id: %s, author: %s, quote: %s}", this.id, this.author, this.quote);
    }
}