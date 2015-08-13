package jimjohn_thornton.project.quiz;

import java.util.List;

/**
 * @author James Thornton on 19/04/15.
 */
public interface answer {

    /**
     * Checks to see if jimjohn_thornton.project.quiz.answer is correct
     * @param x jimjohn_thornton.project.quiz.answer to be checked
     * @return true or false depending on whether the player gets the jimjohn_thornton.project.quiz.answer correct
     */
    boolean checkAnswer(int x);

    /**
     * Gets available answers
     * @return returns a list of the possible jimjohn_thornton.project.quiz.answer choices
     */
    List<String> getAllAnswers();

    /**
     * tells you which jimjohn_thornton.project.quiz.answer is the correct one
     * @return returns an int for the correct jimjohn_thornton.project.quiz.answer
     */
    int getCorrectAnswer();
}