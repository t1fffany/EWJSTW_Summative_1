package com.MagicQuestion.MagicQuestion.controller;

import com.MagicQuestion.MagicQuestion.models.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.web.bind.annotation.*;


@RestController
public class QuoteAPIController {

    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Quote quoteOfTheDay() {
        return new Quote();
    }
}