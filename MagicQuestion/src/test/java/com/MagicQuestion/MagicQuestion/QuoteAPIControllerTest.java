package com.MagicQuestion.MagicQuestion;

import com.MagicQuestion.MagicQuestion.controller.QuoteAPIController;
import com.MagicQuestion.MagicQuestion.models.Answer;
//import com.MagicQuestion.MagicQuestion.models.Question;
//import com.MagicQuestion.MagicQuestion.models.Quote;
import com.MagicQuestion.MagicQuestion.models.Quote;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(QuoteAPIController.class)
public class QuoteAPIControllerTest {
    @Autowired
    private MockMvc mockMvc;
    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    // Testing GET /quote
    @Test
    public void shouldReturnQuote() throws Exception {
        // ARRANGE
        Quote inputQuote = new Quote();
        inputQuote.setId("1");
        inputQuote.setAuthor("Jonathan Van Ness (Queer Eye)");
        inputQuote.setQuote("You're strong, you're a Kelly Clarkson song, you got this.");

        // Convert Java object to JSON
        String inputJson = mapper.writeValueAsString(inputQuote);

        Quote outputQuote = new Quote();
        outputQuote.setId("1");
        outputQuote.setAuthor("Jonathan Van Ness (Queer Eye)");
        outputQuote.setQuote("You're strong, you're a Kelly Clarkson song, you got this.");

        String outputJson = mapper.writeValueAsString(outputQuote);

        // ACT
        mockMvc.perform(
                        get("/quote")   // Perform the POST request
                                .content(inputJson) // Set the request body
                                .contentType(MediaType.APPLICATION_JSON))   // Tell the server it's in JSON format
                .andDo(print()) // Print results to console
                .andExpect(status().isOk());
    }
}
