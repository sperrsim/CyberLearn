package model;

import java.util.ArrayList;

public class Question {
    private String questionText;
    private ArrayList<Answer> answers;

    public Question(String questionText, ArrayList<Answer> answers)
    {
        this.questionText = questionText;
        this.answers = answers;
    }

    public String getQuestionText() {
        return questionText;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }
}
