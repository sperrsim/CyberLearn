package model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;

public class Question implements Externalizable {
    //Text of the Question
    private String questionText;
    //Answers to the Question
    private ArrayList<Answer> answers;

    public Question(){}

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

    @Override
    public String toString() {
        return questionText;
    }

    /**
     * Writes the Object into a Serial File
     * @param out OutputObject
     * @throws IOException
     **/
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(questionText);
        out.writeObject(answers);
    }

    /**
     * Reads the Object from a Serial File
     * @param in Input Object
     * @throws IOException
     * @throws ClassNotFoundException
     **/
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        questionText = (String)in.readObject();
        answers = (ArrayList<Answer>) in.readObject();
    }
}
