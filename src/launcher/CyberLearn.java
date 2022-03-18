package launcher;

import controller.MenuController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Topic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class CyberLearn extends Application {
    public static ArrayList<Topic> topics = new ArrayList<>();

    @Override
    public void start(Stage stage) throws Exception {

        MenuController.show(stage);
    }

    @Override
    public void init() throws Exception {
        //Open topic directory
        File topicDir = new File("topic");
        File[] topics = topicDir.listFiles();
        //If Files in the directory
        if(topics != null)
        {
            //Load all Topics
for(int i = 0; i < topics.length; i ++)
            {
                try (
                        ObjectInputStream oos = new ObjectInputStream(new FileInputStream(topics[i]))) {
                    CyberLearn.topics.add((Topic)oos.readObject());
                } catch (
                        IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
