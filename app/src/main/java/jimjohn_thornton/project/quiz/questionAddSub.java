package jimjohn_thornton.project.quiz;

import java.util.Random;

/**
 * Created by jimjohn_thornton on 06/08/2015.
 */
public class questionAddSub {
    Random generator = new Random();
    private int coeff1 = generator.nextInt(10) + 1;
    private int coeff2 = generator.nextInt(10) + 1;
    private int ran1 = generator.nextInt(10) - 4;
    private int ran2 = generator.nextInt(10) - 4;
    private int a1 = coeff1 + coeff2;
    private int a2 = coeff1 - coeff2;
    private int a3 = coeff1 + coeff2 + ran1;
    private int a4 = coeff1 - coeff2 + ran2;


    public question getQuestion() {
        int qType = generator.nextInt(2)+1;
        if (qType==1) return question1();
        else return question2();
    }

    public question question1() {
        if (a2==a1) {
            a2++;
        }
        while (a3==a1||a3==a2) {
            a3++;
        }
        while (a4==a1||a4==a2||a4==a3) {
            a4++;
        }
        String qString = "simplify by gathering all like terms \n" + coeff1 + "x + " + coeff2 + "x = ?";
        answerImpl ans = new answerImpl(a1+"x", a2+"x", a3+"x", a4+"x", 1);
        question q = new question(qString, ans);
        return q;
    }
    public question question2() {
        if (a2==a1) {
            a1++;
        }
        while (a3==a1||a3==a2) {
            a3++;
        }
        while (a4==a1||a4==a2||a4==a3) {
            a4++;
        }
        String qString = "simplify by gathering all like terms \n" + coeff1 + "x - " + coeff2 + "x = ?";
        answerImpl ans = new answerImpl(a1+"x", a2+"x", a3+"x", a4+"x", 2);
        question q = new question(qString, ans);
        return q;
    }
}
