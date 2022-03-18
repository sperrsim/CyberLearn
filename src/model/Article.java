package model;

import java.io.*;
import java.net.URL;

public class Article implements Externalizable {
    //Name of the Article
    private String name;
    //URL to the Article Website
    private URL link;

    public Article(){}

    public Article(String name, URL link)
    {
        this.name = name;
        this.link = link;
    }

    public URL getLink() {
        return link;
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
        out.writeObject(link);
    }

    /**
     * Reads the Object from a Serial File
     * @param in Input Object
     * @throws IOException
     * @throws ClassNotFoundException
     **/
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String)in.readObject();
        link = (URL)in.readObject();
    }
}
