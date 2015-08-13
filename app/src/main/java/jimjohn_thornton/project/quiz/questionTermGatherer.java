package jimjohn_thornton.project.quiz;

import java.util.Random;

/**
 * Created by jimjohn_thornton on 22/06/15.
 */
public class questionTermGatherer {
    Random generator = new Random();
    private int coeff1 = generator.nextInt(10) + 1;
    private int coeff2 = generator.nextInt(10) + 1;
    private int coeff3 = generator.nextInt(10) + 1;
    private int coeff4 = generator.nextInt(10) + 1;
    private int a1 = coeff1 + coeff2;// + coeff3 + coeff4;
    private int a2 = coeff1 - coeff2;// - coeff3 - coeff4;
    private int a3 = coeff1 * coeff2;// * coeff3 * coeff4;
    private int a4 = coeff1 / coeff2;// - coeff3 + coeff4;
    private question returnquestion;

    public question getQuestion() {
        int qType = generator.nextInt(3)+1;
        if (qType==1) return question1();
        else if (qType==2) return question2();
        else return question3();
        //else question4();
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
    public question question3() {
        if (a2==a3) {
            a2++;
        }
        while (a1==a2||a1==a3) {
            a1++;
        }
        while (a4==a1||a4==a2||a4==a3) {
            a4++;
        }
        String qString = "simplify by gathering all like terms \n" + coeff1 + "x * " + coeff2 + "x = ?";
        answerImpl ans = new answerImpl(a1+"x", a2+"x", a3+"x", a4+"x", 3);
        question q = new question(qString, ans);
        return q;
    }
    public void question4() {
        //to go at the top of the page
        //System.out.println("simplify by gathering all like terms");
        // jimjohn_thornton.project.quiz.question to be answered
        //System.out.println(coeff1 + "x + " + coeff2 + "x + " + coeff3 + "x + " + coeff4 + " = ?");
    }
}
