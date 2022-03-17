package model;

public class Answer {
    private String answerText;
    private boolean right;

    public Answer(String answerText, boolean right)
    {
        this.answerText = answerText;
        this.right = right;
    }

    public String getAnswerText() {
        return answerText;
    }

    public boolean isRight() {
        return right;
    }
}
