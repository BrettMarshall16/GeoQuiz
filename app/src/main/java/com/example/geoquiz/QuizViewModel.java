package com.example.geoquiz;

import android.util.Log;

import androidx.lifecycle.ViewModel;

public class QuizViewModel extends ViewModel {
    private static String TAG = "QuizViewModel";
    public QuizViewModel() {
        Log.d(TAG, "ViewModel instance created");
    }
    @Override
    public void onCleared() {
        super.onCleared();
        Log.d(TAG, "ViewModel instance about to be destroyed");
    }

}
