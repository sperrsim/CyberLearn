package model;

import java.util.ArrayList;

public class Topic {
    private String name;
    private ArrayList<Article> articles;
    private ArrayList<Question> questions;

    public Topic(String name, ArrayList<Article> articles, ArrayList<Question> questions)
    {
        this.name = name;
        this.articles = articles;
        this.questions = questions;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }


    public ArrayList<Question> getQuestions() {
        return questions;
    }
}
