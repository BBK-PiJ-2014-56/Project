package jimjohn_thornton.project.quiz;

import java.util.List;

/**
 * Created by jimjohn_thornton on 10/07/15.
 */
public class question {

    private static final long serialVersionUID = 3135L;

    private List<String> allAnswers;
    private answerImpl answers;
    private int questionNumber = 0;
    private String question;

    /**
     * sets up questions and answers for the quiz
     * @param question the jimjohn_thornton.project.quiz.question
     * @param answers the answers
     */
    public question (String question, answerImpl answers) {
        this.question = question;
        this.answers = answers;
        this.questionNumber = questionNumber++;
        //maybe change this to an jimjohn_thornton.project.quiz.answer object...?
        //this.jimjohn_thornton.project.quiz.answer = jimjohn_thornton.project.quiz.answer;
    }

    /**
     * checks if the jimjohn_thornton.project.quiz.answer is correct
     * @param x the jimjohn_thornton.project.quiz.answer
     * @return true or false fi they got it right
     */
    public boolean getAnswer(int x){
        return answers.checkAnswer(x);
    }

    /**
     * gets the jimjohn_thornton.project.quiz.question
     * @return the jimjohn_thornton.project.quiz.question
     */
    public String getQuestion(){
        return question;
    }

    /**
     * gets all the answers
     * @return a list of all the possible answers
     */
    public List<String> getAllAnswers() {
        allAnswers = answers.getAllAnswers();
        return allAnswers;
    }

    /**
     * gets the correct jimjohn_thornton.project.quiz.answer
     * @return the position of the correct jimjohn_thornton.project.quiz.answer
     */
    public int getCorrectAnswer(){
        return answers.getCorrectAnswer();
    }
}
