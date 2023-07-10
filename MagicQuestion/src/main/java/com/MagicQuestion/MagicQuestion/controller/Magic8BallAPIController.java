package com.MagicQuestion.MagicQuestion.controller;
import com.MagicQuestion.MagicQuestion.models.Answer;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

@RestController
public class Magic8BallAPIController {


    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public Answer magic8BallAPI(@RequestBody String question) {
        Answer answer = new Answer(question);
        return answer;
    }
}
