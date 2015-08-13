package jimjohn_thornton.project.quiz;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

/**
 * Created by jimjohn_thornton on 24/07/2015.
 */
public class questionTest {

    answerImpl answerTest;
    question q1;
    @Before
    public void setUp() throws Exception {
        answerTest = new answerImpl("Answer1", "Answer2", "Answer3", "Answer4", 4);
        q1 = new question("Whats the answer?", answerTest);
    }

    @Test
    public void testGetAnswer() throws Exception {
        assertEquals(false, q1.getAnswer(1));
        assertEquals(false, q1.getAnswer(2));
        assertEquals(false, q1.getAnswer(3));
        assertEquals(true, q1.getAnswer(4));
        assertEquals(false, q1.getAnswer(5));
    }

    @Test
    public void testGetQuestion() throws Exception {
        assertEquals("Whats the answer?", q1.getQuestion());
    }

    @Test
    public void testGetAllAnswers() throws Exception {
        ArrayList<String> answers = new ArrayList<>();
        answers.add("Answer1");
        answers.add("Answer2");
        answers.add("Answer3");
        answers.add("Answer4");
        assertEquals(answers, q1.getAllAnswers());
    }

    @Test
    public void testGetCorrectAnswer() throws Exception {
        assertEquals(4, q1.getCorrectAnswer());
    }
}