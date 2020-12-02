package com.example.geoquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    private final String KEY_INDEX = "index";
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mQuestionTextView;
    private QuizViewModel mQuizViewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle) called");
        setContentView(R.layout.activity_main);

        ViewModelProvider provider = ViewModelProviders.of(this);
        mQuizViewModel = provider.get(QuizViewModel.class);
        Log.d(TAG, "Got a QuizViewModel: $quizViewModel");

        if (savedInstanceState != null) {
            mQuizViewModel.mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
        } else {
            mQuizViewModel.mCurrentIndex = 0;
        }

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
                checkAnswer(false);
            }
        });

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mQuizViewModel.moveToNext();
               updateQuestion();
            }
        });
        updateQuestion();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putInt(KEY_INDEX, mQuizViewModel.mCurrentIndex);
    }


    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG, "onStart called.");
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called.");
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called.");
    }
    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called.");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called.");
    }

    private void updateQuestion(){
        int questionTextResId = mQuizViewModel.currentQuestionText();
        mQuestionTextView.setText(questionTextResId);
    }
    private void checkAnswer(boolean answer) {
        boolean correctAnswer = mQuizViewModel.currentQuestionAnswer();
        if (answer == correctAnswer) {
            Toast.makeText(this, R.string.toastTrue, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, R.string.toastFalse, Toast.LENGTH_SHORT).show();
        }
    }
}
