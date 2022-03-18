package model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Answer implements Externalizable {
    //Text of the Answer
    private String answerText;
    //Boolean if right Answer to question
    private boolean right;

    public Answer(){}

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

    /**
     * Writes the Object into a Serial File
     * @param out OutputObject
     * @throws IOException
     **/
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(answerText);
        out.writeObject(right);
    }

    /**
     * Reads the Object from a Serial File
     * @param in Input Object
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        answerText = (String)in.readObject();
        right = (boolean)in.readObject();
    }
}
