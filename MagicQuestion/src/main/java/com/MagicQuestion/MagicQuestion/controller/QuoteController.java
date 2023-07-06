//package com.MagicQuestion.MagicQuestion.controller;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class QuoteController {
//    private final QuoteService quoteService;
//
//    public QuoteController(QuoteService quoteService) {
//        this.quoteService = quoteService;
//    }
//
//    @GetMapping("/quote")
//    public Quote getRandomQuote() {
//        // Get a random quote using the quoteService
//        return quoteService.getRandomQuote();
//    }
//}