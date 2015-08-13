package jimjohn_thornton.project.quiz;

import java.util.Random;

/**
 * Created by jimjohn_thornton on 09/08/2015.
 */
public class questionOneStepLinear {

    Random generator = new Random();
    private int coeff1 = generator.nextInt(10) + 1;
    private int ran1 = generator.nextInt(10) - 4;
    private int ran2 = generator.nextInt(10) - 4;
    private int ran3 = generator.nextInt(10) - 4;
    private int ran4 = generator.nextInt(10) + 1;

    private int a1 = ran1;
    private int a2 = ran2;
    private int a3 = ran3;
    private int a4 = ran4;

    public question getQuestion() {
        if (a2==a1) {
            a2++;
        }
        while (a3==a1||a3==a2) {
            a3++;
        }
        while (a4==a1||a4==a2||a4==a3) {
            a4++;
        }
        String qString = "Solve for x \n" + coeff1 + "x = " + a1*coeff1;
        answerImpl ans = new answerImpl("x = " + a1, "x = " + a2, "x = " + a3, "x = " + a4, 1);
        question q = new question(qString, ans);
        return q;
    }
}
