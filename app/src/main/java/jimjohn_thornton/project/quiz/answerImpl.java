package jimjohn_thornton.project.quiz;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jimjohn_thornton on 21/04/15.
 */
public class answerImpl implements answer {

    private List<String> answers = new ArrayList<String>();
    private int correctAnswer;
    private int choices = 0;

    public answerImpl(String a1, String a2, String a3, String a4, int x) {
        this.answers.add(a1);
        this.answers.add(a2);
        this.answers.add(a3);
        this.answers.add(a4);
        this.correctAnswer = x;
    }

    @Override
    public boolean checkAnswer(int x) {
        if (correctAnswer == x)
            return true;
        if (x < 1 || x > 4) {
            System.out.println("try again");
            return false;
        }
        else return false;
    }

    @Override
    public List<String> getAllAnswers() {
        return answers;
    }

    @Override
    public int getCorrectAnswer() {
        return correctAnswer;
    }
}