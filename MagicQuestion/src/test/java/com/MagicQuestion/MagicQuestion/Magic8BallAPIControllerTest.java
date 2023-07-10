package com.MagicQuestion.MagicQuestion;

import com.MagicQuestion.MagicQuestion.controller.Magic8BallAPIController;
import com.MagicQuestion.MagicQuestion.controller.WordAPIController;
//import com.MagicQuestion.MagicQuestion.models.Question;
//import com.MagicQuestion.MagicQuestion.models.Quote;
import com.MagicQuestion.MagicQuestion.models.Answer;
import com.MagicQuestion.MagicQuestion.models.Quote;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(Magic8BallAPIController.class)
public class Magic8BallAPIControllerTest {

    // Wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    // Testing GET /word
    @Test
    public void shouldReturnAnswerOfTheDayIfQuestionNotEmpty() throws Exception {
        // ARRANGE
        Answer inputAnswer = new Answer("Will it rain today?");
        inputAnswer.setId("1");
        inputAnswer.setAnswer("As likely as a new season premiere.");

        // Convert Java object to JSON
        String inputJson = mapper.writeValueAsString(inputAnswer);

        // ARRANGE
        Answer outputAnswer = new Answer("Will it rain today?");
        outputAnswer.setId("1");
        outputAnswer.setAnswer("As likely as a new season premiere.");

        String outputJson = mapper.writeValueAsString(outputAnswer);

        // ACT
        mockMvc.perform(
                post("/magic")               // Perform the GET request
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())                          // Print results to console
                .andExpect(status().isOk());             // ASSERT (status code is 200)

    }

    @Test
    public void shouldReturnAnswerOfTheDayIfQuestionIsEmpty() throws Exception {
        // ARRANGE
        Answer inputAnswer = new Answer("");
        inputAnswer.setId("1");
        inputAnswer.setAnswer("As likely as a new season premiere.");

        // Convert Java object to JSON
        String inputJson = mapper.writeValueAsString(inputAnswer);

        // ARRANGE
        Answer outputAnswer = new Answer("");
        outputAnswer.setId("1");
        outputAnswer.setAnswer("As likely as a new season premiere.");

        String outputJson = mapper.writeValueAsString(outputAnswer);

        // ACT
        mockMvc.perform(
                        post("/magic")               // Perform the GET request
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())                          // Print results to console
                .andExpect(status().isOk());             // ASSERT (status code is 200)

    }

}