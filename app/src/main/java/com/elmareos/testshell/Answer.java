package com.elmareos.testshell;

import androidx.annotation.NonNull;

public class Answer {
    private String answerText;
    private boolean isCorrect;

    public Answer(String answer, boolean correct){
        this.answerText = answer;
        this.isCorrect = correct;
    }

    public String getAnswerText() {
        return answerText;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    @NonNull
    @Override
    public String toString() {
        return getAnswerText();
    }
}
