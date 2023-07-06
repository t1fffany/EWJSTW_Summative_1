package com.MagicQuestion.MagicQuestion.controller;

import com.MagicQuestion.MagicQuestion.models.Answer;
import com.MagicQuestion.MagicQuestion.models.Definition;
import com.MagicQuestion.MagicQuestion.models.Question;
import com.MagicQuestion.MagicQuestion.models.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@RestController
public class MagicQuestionController {

    private List<Definition> definitionList;
    private List<Quote> quoteList;
    private List<Answer> answerList;
    private List<String> responses;

    private Random rand = new Random();

    private static int idCounter = 1;

    public MagicQuestionController() {
        definitionList = new ArrayList<>();
        definitionList.add(new Definition("abscond", "to secretly leave a place and go into hiding", idCounter++));
        definitionList.add(new Definition("girandole", "an ornamental branched candlestick", idCounter++));
        definitionList.add(new Definition("embezzle", "to steal money you have been trusted with", idCounter++));
        definitionList.add(new Definition("prowess", "great ability or skill", idCounter++));
        definitionList.add(new Definition("whimsical", "unusual in a playful or amusing way", idCounter++));
        definitionList.add(new Definition("abate", "to become less intense or widespread", idCounter++));
        definitionList.add(new Definition("cogent", "clear, logical, and convincing", idCounter++));
        definitionList.add(new Definition("ephemeral", "lasting for a very short time", idCounter++));
        definitionList.add(new Definition("gregarious", "fond of company; sociable", idCounter++));
        definitionList.add(new Definition("lament", "to express sorrow or grief", idCounter++));

        quoteList = new ArrayList<>();
        quoteList.add(new Quote("Nelson Mandela", "I never lose. I either win or learn.", idCounter++));
        quoteList.add(new Quote("Dr. Martin Luther King, Jr.", "Darkness cannot drive out darkness, only light can do that. Hate cannot drive out hate, only love can do that.", idCounter++));
        quoteList.add(new Quote("Dr. Mae Jemison", "Never be limited by other people's limited imaginations.", idCounter++));
        quoteList.add(new Quote("Albert Einstein", "Imagination is more important than knowledge.", idCounter++));
        quoteList.add(new Quote("Steve Jobs", "Stay hungry, stay foolish.", idCounter++));
        quoteList.add(new Quote("Oprah Winfrey", "The biggest adventure you can take is to live the life of your dreams.", idCounter++));
        quoteList.add(new Quote("Helen Keller", "The only thing worse than being blind is having sight but no vision.", idCounter++));
        quoteList.add(new Quote("Malala Yousafzai", "We realize the importance of our voices only when we are silenced.", idCounter++));
        quoteList.add(new Quote("Walt Disney", "All our dreams can come true if we have the courage to pursue them.", idCounter++));
        quoteList.add(new Quote("Eleanor Roosevelt", "No one can make you feel inferior without your consent.", idCounter++));
        quoteList.add(new Quote("Mahatma Gandhi", "Be the change that you wish to see in the world.", idCounter++));
        quoteList.add(new Quote("Rosa Parks", "I would like to be known as a person who is concerned about freedom and equality and justice and prosperity for all people.", idCounter++));
        quoteList.add(new Quote("Mother Teresa", "If you can't feed a hundred people, then just feed one.", idCounter++));
        quoteList.add(new Quote("Maya Angelou", "If you don't like something, change it. If you can't change it, change your attitude.", idCounter++));
        quoteList.add(new Quote("Jesse Jackson", "If you fall behind, run faster. Never give up, never surrender and rise up against all odds.", idCounter++));

        answerList = new ArrayList<>();

        responses = new ArrayList<>();
        responses.add("It is certain.");
        responses.add("Better not to tell you now.");
        responses.add("Outlook not so good.");
        responses.add("Concentrate and ask again.");
        responses.add("Yes.");
        responses.add("My reply is no.");

    }
    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Definition wordOfTheDay() {
        Definition dailyDefinition = null;
        if (definitionList != null && !quoteList.isEmpty()) {
            dailyDefinition = definitionList.get(rand.nextInt(definitionList.size()));
        }
        return dailyDefinition;
    }

    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Quote quoteOfTheDay() {
        Quote dailyQuote = null;
        if (quoteList != null && !quoteList.isEmpty()) {
            dailyQuote = quoteList.get(rand.nextInt(quoteList.size()));
        }
        return dailyQuote;
    }

    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Answer createAnswer(@RequestBody String question) {
        Answer answer = new Answer();
        answer.setId(idCounter++);
        answer.setQuestion(question);

        if (responses != null && !responses.isEmpty()) {
            answer.setAnswer(responses.get(rand.nextInt(responses.size())));
        } else {
            answer.setAnswer("No.");
        }
        answerList.add(answer);

        return answer;
    }
}
