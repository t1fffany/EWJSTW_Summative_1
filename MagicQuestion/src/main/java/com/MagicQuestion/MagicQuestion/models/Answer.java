package com.MagicQuestion.MagicQuestion.models;

import java.util.List;
import java.util.Random;

public class Answer {
    private static int idCounter = 0;
    private static List<String> responses = List.of(
            "As likely as a new season premiere.",
            "Outcome looks promising, like a top-rated series.",
            "As doubtful as a cancelled series returning.",
            "Highly probable, like binge-watching on a weekend.",
            "Reply unclear, try another episode.",
            "Prospects as good as a hit Netflix Original.",
            "As unpredictable as a season finale.",
            "Chance of success similar to a breakout new show.",
            "As unlikely as running out of shows to watch on Netflix.",
            "It's settled, like your 'Continue Watching' list."
    );
    private String id;
    private String question;
    private String answer;

    public Answer(String question) {
        this.id = Integer.toString(idCounter++);
        this.question = question;
        Random rand = new Random();
        this.answer = responses.get(rand.nextInt(responses.size()));
    }

    public String getAnswer() {
        return answer;
    }

    public static List<String> getResponses() {
        return responses;
    }

    @Override
    public String toString() {
        return String.format("{id: %s, question: %s, answer: %s}", id, question, answer);
    }


}



