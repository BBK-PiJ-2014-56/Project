package jimjohn_thornton.project;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

import jimjohn_thornton.project.quiz.question;
import jimjohn_thornton.project.quiz.questionChooser;

/**
 * Created by jimjohn_thornton on 30/07/2015.
 */
public class quizView {

    question currentQ;
    TextView txtQuestion;
    Button button1, button2, button3, button4, D1, D2, D3, D4, D5, D6, D7, D8, D9;
    int coin = 0;
    int difficulty = 0;

    public void setQuizView() {

//        setContentView(R.layout.activity_quiz);
//
//        txtQuestion = (TextView) findViewById(R.id.questionText);
//        button1 = (Button) findViewById(R.id.button1);
//        button2 = (Button) findViewById(R.id.button2);
//        button3 = (Button) findViewById(R.id.button3);
//        button4 = (Button) findViewById(R.id.button4);
        setQuestionView();

        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (currentQ.getAnswer(pos1 + 1) == true) {
                    coin = coin + difficulty + 1;
                    setQuestionView();
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQ.getAnswer(pos2 + 1) == true) {
                    coin = coin + difficulty + 1;
                    setQuestionView();
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQ.getAnswer(pos3 + 1) == true) {
                    coin = coin + difficulty + 1;
                    setQuestionView();
                }
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQ.getAnswer(pos4 + 1) == true) {
                    coin = coin + difficulty + 1;
                    setQuestionView();
                }
            }
        });

    }
    /**
     * Randomly sets up the 4 answer squares
     */
    Random generator = new Random();
    questionChooser QC = new questionChooser();
    int pos1;
    int pos2;
    int pos3;
    int pos4;
    private void setQuestionView() {
        //currentQ = new questionTermGatherer().getQuestion();

        currentQ = QC.getQuestion(difficulty);
        txtQuestion.setText(currentQ.getQuestion());
        List answers;
        answers = currentQ.getAllAnswers();
        pos1 = generator.nextInt(4);
        pos2 = generator.nextInt(4);
        while (pos1==pos2) {
            pos2 = generator.nextInt(4);
        }
        pos3 = generator.nextInt(4);
        while (pos1==pos3 || pos2 == pos3) {
            pos3 = generator.nextInt(4);
        }
        pos4 = generator.nextInt(4);
        while (pos1==pos4 || pos2 == pos4 || pos3 == pos4) {
            pos4 = generator.nextInt(4);
        }
        System.out.println(""+pos1+pos2+pos3+pos4);
        button1.setText(answers.get(pos1).toString());
        button2.setText(answers.get(pos2).toString());
        button3.setText(answers.get(pos3).toString());
        button4.setText(answers.get(pos4).toString());
    }


}
