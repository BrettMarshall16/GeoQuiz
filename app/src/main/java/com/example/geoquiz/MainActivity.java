package com.example.geoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mQuestionTextView;

    private Question[] mQuestionBank = {
            new Question(R.string.question_australia, true),
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_americas, true),
            new Question(R.string.question_asia, true)
    };
    private int mCurrentIndex = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton = (Button)findViewById(R.id.trueButton);
        mFalseButton = (Button)findViewById(R.id.falseButton);
        mNextButton = (Button)findViewById(R.id.next);
        mQuestionTextView = findViewById(R.id.question_text_view);

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
               updateQuestion();
            }
        });
    }
    private void updateQuestion(){
        int questionTextResId = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(questionTextResId);
    }
    private void checkAnswer(boolean answer) {
        boolean correctAnswer = mQuestionBank[mCurrentIndex].isAnswer();
        if (answer == correctAnswer) {
            Toast.makeText(this, R.string.toastTrue, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, R.string.toastFalse, Toast.LENGTH_SHORT).show();
        }
    }
}
