package com.MagicQuestion.MagicQuestion.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.MagicQuestion.MagicQuestion.models.Definition;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@RestController
public class WordController {

    private List<Definition> definitionList;
    private Random rand = new Random();

    private static int idCounter = 1;

    public WordController() {
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

    }
    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Definition wordOfTheDay() {
        Definition dailyDefinition = null;
        if (definitionList != null && !definitionList.isEmpty()) {
            dailyDefinition = definitionList.get(rand.nextInt(definitionList.size()));
        }
        return dailyDefinition;
    }
}