package jimjohn_thornton.project.quiz;

/**
 * Created by jimjohn_thornton on 22/06/15.
 */
public class questionChooser {
    private question q;
    public question getQuestion(int difficulty) {
        if (difficulty == 0) {
            return q = new questionAdd().getQuestion();
        } else if (difficulty == 1) {
            return q = new questionAddSub().getQuestion();
        } else if (difficulty == 2) {
            return q = new questionTermGatherer().getQuestion();
        } else if (difficulty == 3) {
            return q = new questionOneStepLinear().getQuestion();
        } else if (difficulty == 4) {
            return q = new questionTwoStepLinear().getQuestion();
        } else if (difficulty == 5) {
            return q = new questionUnknownOnBothSides().getQuestion();
        } else if (difficulty == 6) {
            return q = new questionLinearWithOneBracket().getQuestion();
        } else if (difficulty == 7) {
            return q = new questionLinearWithTwoBrackets().getQuestion();
        } else return q;
    }
}
