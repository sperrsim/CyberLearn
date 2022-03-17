package model;

import java.net.URL;

public class Article {
    private String name;
    private String link;

    public Article(String name, String link)
    {
        this.name = name;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public String getLink() {
        return link;
    }
}
