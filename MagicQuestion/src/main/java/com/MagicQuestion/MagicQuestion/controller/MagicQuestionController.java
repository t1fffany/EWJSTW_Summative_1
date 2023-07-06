package com.MagicQuestion.MagicQuestion.controller;
import com.MagicQuestion.MagicQuestion.models.Answer;
import com.MagicQuestion.MagicQuestion.models.Definition;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
public class MagicQuestionController {


    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    public ResponseEntity<String> magic8BallAPI(@RequestParam String question) {
        Answer answer = new Answer(question);
        return new ResponseEntity<>(answer.toString(), HttpStatus.OK);
    }
}
