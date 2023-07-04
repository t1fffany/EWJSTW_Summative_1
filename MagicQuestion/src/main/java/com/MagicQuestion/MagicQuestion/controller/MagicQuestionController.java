package com.MagicQuestion.MagicQuestion.controller;
import com.MagicQuestion.MagicQuestion.models.Answer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
public class MagicQuestionController {

    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    public ResponseEntity<String> magic8BallAPI(@RequestParam String question) {
        System.out.println("API");
        Answer answer = new Answer(question);
        return new ResponseEntity<>(answer.toString(), HttpStatus.OK);
    }
}
