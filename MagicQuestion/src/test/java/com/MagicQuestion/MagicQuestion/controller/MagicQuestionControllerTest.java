package com.MagicQuestion.MagicQuestion.controller;

import com.MagicQuestion.MagicQuestion.models.Answer;
import com.MagicQuestion.MagicQuestion.models.Definition;
import com.MagicQuestion.MagicQuestion.models.Question;
import com.MagicQuestion.MagicQuestion.models.Quote;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MagicQuestionController.class)
public class MagicQuestionControllerTest {

    // Wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    MagicQuestionController magicQuestionController;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    // A list of records for testing purposes
    private String wordDef;
    private String quote;

    Definition defTest = new Definition("abscond", "to secretly leave a place and go into hiding", 1);

    Quote quoteTest = new Quote("Maya Angelou", "If you don't like something, change it. If you can't change it, change your attitude.", 2);

    // Testing GET /word
    @Test
    public void shouldReturnWord() throws Exception {

        // ARRANGE
        // Convert Java object to JSON
        String outputJson = mapper.writeValueAsString(defTest);

        when(magicQuestionController.wordOfTheDay()).thenReturn(defTest);

        // ACT
        mockMvc.perform(get("/word"))                // Perform the GET request
                .andDo(print())                          // Print results to console
                .andExpect(status().isOk());             // ASSERT (status code is 200)
               // .andExpect(content().json(outputJson));

    }


    // Testing GET /quote
    @Test
    public void shouldReturnQuote() throws Exception {

        // ARRANGE
        // Convert Java object to JSON
        String outputJson = mapper.writeValueAsString(quoteTest);

        when(magicQuestionController.quoteOfTheDay()).thenReturn(quoteTest);

        // ACT
        mockMvc.perform(get("/quote"))                // Perform the GET request
                .andDo(print())                          // Print results to console
                .andExpect(status().isOk());            // ASSERT (status code is 200)
                //.andExpect(content().json(outputJson));
    }


    // Testing POST /magic
    @Test
    public void shouldCreateNewPost() throws Exception {

        // ARRANGE
        Question question = new Question("Am I hot?");
        Answer inputQuestion = new Answer();

        // Convert Java Object to JSON
        String inputJson = mapper.writeValueAsString(question);

        Answer outputQuestion = new Answer();
        outputQuestion.setQuestion(question);
        outputQuestion.setAnswer("Yes.");
        outputQuestion.setId(3);

        String outputJson = mapper.writeValueAsString(outputQuestion);

        // ACT
        mockMvc.perform(
                        post("/magic")                            // Perform the POST request
                                .content(inputJson)                       // Set the request body
                                .contentType(MediaType.APPLICATION_JSON)  // Tell the server it's in JSON format
                )
                .andDo(print())                                // Print results to console
                .andExpect(status().isCreated());              // ASSERT (status code is 201)
    }
}
