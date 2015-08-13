package jimjohn_thornton.project.quiz;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by jimjohn_thornton on 25/07/2015.
 */
public class questionTermGathererTest {
    questionTermGatherer q;
    @Before
    public void setUp() throws Exception {
        q = new questionTermGatherer();
    }

    @Test
    public void testGetCoeff1() throws Exception {
        System.out.println(q.getCoeff1());
    }

    @Test
    public void testGetCoeff2() throws Exception {
        System.out.println(q.getCoeff2());
    }

    @Test
    public void testGetCoeff3() throws Exception {

    }

    @Test
    public void testGetCoeff4() throws Exception {

    }

    @Test
    public void testQuestion1() throws Exception {
        System.out.println(q.question1().getQuestion());
        System.out.println(q.question1().getAnswer(1));
        System.out.println(q.question1().getCorrectAnswer());
        System.out.println(q.question1().getAllAnswers());
    }

    @Test
    public void testQuestion2() throws Exception {
        System.out.println(q.question2().getQuestion());
        System.out.println(q.question2().getAnswer(2));
        System.out.println(q.question2().getCorrectAnswer());
        System.out.println(q.question2().getAllAnswers());
    }

    @Test
    public void testQuestion3() throws Exception {
        System.out.println(q.question3().getQuestion());
        System.out.println(q.question3().getAnswer(3));
        System.out.println(q.question3().getCorrectAnswer());
        System.out.println(q.question3().getAllAnswers());
    }

    @Test
    public void testQuestion4() throws Exception {

    }
}