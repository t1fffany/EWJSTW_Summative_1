package com.MagicQuestion.MagicQuestion;

//import com.MagicQuestion.MagicQuestion.models.Question;
//import com.MagicQuestion.MagicQuestion.models.Quote;

import com.MagicQuestion.MagicQuestion.controller.WordAPIController;
import com.MagicQuestion.MagicQuestion.models.Definition;
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

@WebMvcTest(WordAPIController.class)
public class WordAPIControllerTest {
    @Autowired
    private MockMvc mockMvc;
    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    // Testing POST /magic
    @Test
    public void shouldReturnWordOfTheDay() throws Exception {
        // ARRANGE
        Definition inputWord = new Definition();
        inputWord.setWord("abscond");
        inputWord.setDefinition("to secretly leave a place and go into hiding");

        // Convert Java Object to JSON
        String inputJson = mapper.writeValueAsString(inputWord);

        Definition outputWord = new Definition();
        outputWord.setWord("abscond");
        outputWord.setDefinition("to secretly leave a place and go into hiding");

        String outputJson = mapper.writeValueAsString(outputWord);

        // ACT
        mockMvc.perform(
                        get("/word")                            // Perform the POST request
                                .content(inputJson)                       // Set the request body
                                .contentType(MediaType.APPLICATION_JSON)  // Tell the server it's in JSON format
                )
                .andDo(print())                                // Print results to console
                .andExpect(status().isOk());    // ASSERT (status code is 200)
    }
}
