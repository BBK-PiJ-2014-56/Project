package jimjohn_thornton.project.quiz;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by jimjohn_thornton on 25/07/2015.
 */
public class questionChooserTest {
    question termQuestion;
    questionChooser q;
    @Before
    public void setUp() throws Exception {
        q = new questionChooser();
    }

    @Test
    public void testGetQuestion() throws Exception {
        termQuestion = q.getQuestion(0);
        //assertEquals(q.);
    }
}