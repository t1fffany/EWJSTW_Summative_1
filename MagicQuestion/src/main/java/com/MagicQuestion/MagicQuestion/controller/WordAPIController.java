package com.MagicQuestion.MagicQuestion.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.MagicQuestion.MagicQuestion.models.Word;
import org.springframework.web.bind.annotation.*;


@RestController
public class WordAPIController {

    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Word wordOfTheDay() {
        Word dailyDefinition = new Word();
        return dailyDefinition;
    }
}