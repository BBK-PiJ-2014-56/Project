package jimjohn_thornton.project.quiz;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

/**
 * Created by jimjohn_thornton on 24/07/2015.
 */
public class answerTest {

    answerImpl answerTest;

    @Before
    public void setUp() throws Exception {
        answerTest = new answerImpl("Answer1", "Answer2", "Answer3", "Answer4", 4);
    }

    @Test
    public void testCheckAnswer() throws Exception {
        assertEquals(true, answerTest.checkAnswer(4));
        assertEquals(false, answerTest.checkAnswer(1));
        assertEquals(false, answerTest.checkAnswer(2));
        assertEquals(false, answerTest.checkAnswer(3));
        assertEquals(false, answerTest.checkAnswer(5));
    }

    @Test
    public void testGetAllAnswers() throws Exception {
        ArrayList<String> answers = new ArrayList<>();
        answers.add("Answer1");
        answers.add("Answer2");
        answers.add("Answer3");
        answers.add("Answer4");
        assertEquals(answers, answerTest.getAllAnswers());
    }

    @Test
    public void testGetCorrectAnswer() throws Exception {
        assertEquals(4,answerTest.getCorrectAnswer());
    }
}