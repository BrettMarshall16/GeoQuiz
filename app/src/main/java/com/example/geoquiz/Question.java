package com.example.geoquiz;

public class Question {
    int textResId;
    boolean answer;
    Question(int textResId, boolean answer){
        this.textResId = textResId;
        this.answer = answer;
    }

    public int getTextResId() {
        return textResId;
    }

    public void setTextResId(int textResId) {
        this.textResId = textResId;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
