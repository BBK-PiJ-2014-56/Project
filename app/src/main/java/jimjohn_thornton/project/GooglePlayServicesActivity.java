package jimjohn_thornton.project;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.Games;
import com.google.android.gms.plus.Plus;

import java.util.List;
import java.util.Random;

import jimjohn_thornton.project.quiz.question;
import jimjohn_thornton.project.quiz.questionChooser;

public class GooglePlayServicesActivity extends Activity implements
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {

    private static final String TAG = "GooglePlayServicesActivity";

    private static final String KEY_IN_RESOLUTION = "is_in_resolution";

    /**
     * Request code for auto Google Play Services error resolution.
     */
    protected static final int REQUEST_CODE_RESOLUTION = 1;

    /**
     * Google API client.
     */
    private GoogleApiClient mGoogleApiClient;

    /**
     * Determines if the client is in a resolution state, and
     * waiting for resolution intent to return.
     */
    private boolean mIsInResolution;

    question currentQ;
    TextView txtQuestion, txtScore;
    Button button1, button2, button3, button4, D1, D2, D3, D4, D5, D6, D7, D8, D9, backToDiffChooseFromScore;
    int coin = 0;
    int difficulty;

    /**
     * Called when the activity is starting. Restores the activity state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            mIsInResolution = savedInstanceState.getBoolean(KEY_IN_RESOLUTION, false);
        }
        setContentView(R.layout.difficulty_chooser);
        difficultyChooser();
    }

    protected void difficultyChooser() {
        D1 = (Button) findViewById(R.id.buttD1);
        D2 = (Button) findViewById(R.id.buttD2);
        D3 = (Button) findViewById(R.id.buttD3);
        D4 = (Button) findViewById(R.id.buttD4);
        D5 = (Button) findViewById(R.id.buttD5);
        D6 = (Button) findViewById(R.id.buttD6);
        D7 = (Button) findViewById(R.id.buttD7);

        D1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                difficulty = 0;
                quizLayout();
            }
        });
        D2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                difficulty = 1;
                quizLayout();
            }
        });
        D3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                difficulty = 2;
                quizLayout();
            }
        });
        D4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                difficulty = 3;
                quizLayout();
            }
        });
        D5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                difficulty = 4;
                quizLayout();
            }
        });
        D6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                difficulty = 5;
                quizLayout();
            }
        });
        D7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                difficulty = 6;
                quizLayout();
            }
        });

    }
    public void onClick1(View v) {
        if(currentQ.getAnswer(pos1+1)==true) {
            coin = coin + difficulty + 1;
            setQuestionView();
        } else {
            score();
        }
    }
    public void onClick2(View v) {
        if(currentQ.getAnswer(pos2+1)==true) {
            coin = coin + difficulty + 1;
            setQuestionView();
        } else {
            score();
        }
    }
    public void onClick3(View v) {
        if(currentQ.getAnswer(pos3+1)==true) {
            coin = coin + difficulty + 1;
            setQuestionView();
        } else {
            score();
        }
    }
    public void onClick4(View v) {
        if(currentQ.getAnswer(pos4+1)==true) {
            coin = coin + difficulty + 1;
            setQuestionView();
        } else {
            score();
        }
    }

    public void diffChoose (View v) {
        setContentView(R.layout.difficulty_chooser);
        difficultyChooser();
    }

    public void score() {
        setContentView(R.layout.results);
        txtScore = (TextView) findViewById(R.id.txtScore);
        txtScore.setText(Integer.toString(coin));
        coin = 0;
    }

    public void quizLayout () {

        setContentView(R.layout.activity_quiz);

        txtQuestion = (TextView) findViewById(R.id.questionText);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        setQuestionView();
    }
    /*
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentQ.getAnswer(pos2+1)==true) {
                    coin = coin + difficulty + 1;
                    setQuestionView();
                } else {
                    setContentView(R.layout.difficulty_chooser);
                    difficultyChooser();
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentQ.getAnswer(pos3+1)==true) {
                    coin = coin + difficulty + 1;
                    setQuestionView();
                } else {
                    setContentView(R.layout.difficulty_chooser);
                    difficultyChooser();
                }
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentQ.getAnswer(pos4+1)==true) {
                    coin = coin + difficulty + 1;
                    setQuestionView();
                } else {
                    setContentView(R.layout.difficulty_chooser);
                    difficultyChooser();
                }
            }
        });
    }
    */


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

    /**
     * Called when the Activity is made visible.
     * A connection to Play Services need to be initiated as
     * soon as the activity is visible. Registers {@code ConnectionCallbacks}
     * and {@code OnConnectionFailedListener} on the
     * activities itself.
     */
    @Override
    protected void onStart() {
        super.onStart();
        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addApi(Games.API)
                    .addApi(Plus.API)
                    .addScope(Games.SCOPE_GAMES)
                    .addScope(Plus.SCOPE_PLUS_LOGIN)
                            // Optionally, add additional APIs and scopes if required.
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .build();
        }
        mGoogleApiClient.connect();
    }

    /**
     * Called when activity gets invisible. Connection to Play Services needs to
     * be disconnected as soon as an activity is invisible.
     */
    @Override
    protected void onStop() {
        if (mGoogleApiClient != null) {
            mGoogleApiClient.disconnect();
        }
        super.onStop();
    }

    /**
     * Saves the resolution state.
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(KEY_IN_RESOLUTION, mIsInResolution);
    }

    /**
     * Handles Google Play Services resolution callbacks.
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_CODE_RESOLUTION:
                retryConnecting();
                break;
        }
    }

    private void retryConnecting() {
        mIsInResolution = false;
        if (!mGoogleApiClient.isConnecting()) {
            mGoogleApiClient.connect();
        }
    }

    /**
     * Called when {@code mGoogleApiClient} is connected.
     */
    @Override
    public void onConnected(Bundle connectionHint) {
        Log.i(TAG, "GoogleApiClient connected");
        // TODO: Start making API requests.
    }

    /**
     * Called when {@code mGoogleApiClient} connection is suspended.
     */
    @Override
    public void onConnectionSuspended(int cause) {
        Log.i(TAG, "GoogleApiClient connection suspended");
        retryConnecting();
    }

    /**
     * Called when {@code mGoogleApiClient} is trying to connect but failed.
     * Handle {@code result.getResolution()} if there is a resolution
     * available.
     */
    @Override
    public void onConnectionFailed(ConnectionResult result) {
        Log.i(TAG, "GoogleApiClient connection failed: " + result.toString());
        if (!result.hasResolution()) {
            // Show a localized error dialog.
            GooglePlayServicesUtil.getErrorDialog(
                    result.getErrorCode(), this, 0, new OnCancelListener() {
                        @Override
                        public void onCancel(DialogInterface dialog) {
                            retryConnecting();
                        }
                    }).show();
            return;
        }
        // If there is an existing resolution error being displayed or a resolution
        // activity has started before, do nothing and wait for resolution
        // progress to be completed.
        if (mIsInResolution) {
            return;
        }
        mIsInResolution = true;
        try {
            result.startResolutionForResult(this, REQUEST_CODE_RESOLUTION);
        } catch (SendIntentException e) {
            Log.e(TAG, "Exception while starting resolution activity", e);
            retryConnecting();
        }
    }
}
