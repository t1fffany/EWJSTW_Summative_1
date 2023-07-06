package com.MagicQuestion.MagicQuestion;

import com.MagicQuestion.MagicQuestion.models.Answer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MagicQuestionApplicationTests {

	Answer answer;
	@BeforeEach
	public void setUp() {
		answer = new Answer("test question");
	}
	@Test
	void magic8BallAPI_isValidAnswer() {
		assertTrue(answer.getResponses().contains(answer.getAnswer()));
	}

	// TODO: confirm if we need a Question model
	// TODO: test if request is 200
	// TODO: clarify rubric

}
