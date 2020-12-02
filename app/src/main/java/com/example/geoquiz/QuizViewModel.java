package com.example.geoquiz;

import android.util.Log;

import androidx.lifecycle.ViewModel;

public class QuizViewModel extends ViewModel {
    private static String TAG = "QuizViewModel";
    private Question[] mQuestionBank = {
            new Question(R.string.question_australia, true),
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_americas, true),
            new Question(R.string.question_asia, true)
    };
    int mCurrentIndex = 0;

    public boolean currentQuestionAnswer() {
        return mQuestionBank[mCurrentIndex].answer;
    }
    public int currentQuestionText() {
        return mQuestionBank[mCurrentIndex].textResId;
    }
    public void moveToNext() {
        mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
    }
}
