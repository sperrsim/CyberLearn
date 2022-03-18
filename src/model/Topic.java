package model;

import java.io.*;
import java.util.ArrayList;

public class Topic implements Externalizable {
    //Name of the Topic
    private String name;
    //Articles to the Topic
    private ArrayList<Article> articles;
    //Question to the Topic
    private ArrayList<Question> questions;

    public Topic(){}

    public Topic(String name, ArrayList<Article> articles, ArrayList<Question> questions)
    {
        this.name = name;
        this.articles = articles;
        this.questions = questions;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }


    public ArrayList<Question> getQuestions() {
        return questions;
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * Writes the Object into a Serial File
     * @param out OutputObject
     * @throws IOException
     **/
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeObject(articles);
        out.writeObject(questions);
    }

    /**
     * Reads the Object from a Serial File
     * @param in Input Object
     * @throws IOException
     * @throws ClassNotFoundException
     **/
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = (String)in.readObject();
        this.articles = (ArrayList<Article>) in.readObject();
        this.questions = (ArrayList<Question>) in.readObject();
    }
}
