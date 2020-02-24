package com.elmareos.testshell;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Question {
    private String quesionText;
    private ArrayList<Answer>answers;
    private String correctAnswer;

    public Question(String quesionText, ArrayList<Answer> answers, String correctAnswer){
        this.quesionText = quesionText;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    public void setQuesionText(String quesionText) {
        this.quesionText = quesionText;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getQuesionText() {
        return quesionText;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    @NonNull
    @Override
    public String toString() {
        return getQuesionText();
    }
}
