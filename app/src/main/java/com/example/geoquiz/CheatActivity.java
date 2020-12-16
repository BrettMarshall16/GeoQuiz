package com.example.geoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {
    private static final String EXTRA_ANSWER_IS_TRUE = "com.example.android.geoquiz.answer_is_true";
    public static final String EXTRA_ANSWER_SHOWN = "com.example.android.geoquiz.answer_shown";
    private boolean mAnswerIsTrue;
    private Button mShowAnswerButton;
    private TextView mAnswerTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAnswerTextView = findViewById(R.id.textView2);
        mShowAnswerButton = findViewById(R.id.button);
        mShowAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAnswerIsTrue) {
                    mAnswerTextView.setText(R.string.toastTrue);
                } else {
                    mAnswerTextView.setText(R.string.toastFalse);
                }
                setAnswerShownResult(true);
            }
        });

    }

    public static Intent newIntent(Context packageContext, boolean questionAnswer) {
        Intent intent = new Intent(packageContext, CheatActivity.class);
        intent.putExtra(EXTRA_ANSWER_IS_TRUE, questionAnswer);
        return intent;
    }

    private void setAnswerShownResult(boolean isAnswerShown) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(Activity.RESULT_OK, data);
    }


}