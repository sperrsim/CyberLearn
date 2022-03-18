package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;

import javafx.stage.Stage;
import launcher.CyberLearn;
import model.Topic;

import java.util.Collections;

public class MenuController {
    @FXML
    private ListView<Topic> topicList;

    private static Stage stage;

    public void initialize()
    {
        topicList.setItems(FXCollections.observableArrayList(CyberLearn.topics));
    }

    public void selectTopic()
    {
        if(topicList.getSelectionModel().getSelectedItem() != null)
        {
            TopicController.show(MenuController.stage, topicList.getSelectionModel().getSelectedItem());
        } else
        {
            Alert info = new Alert(Alert.AlertType.INFORMATION, "Bitte wählen Sie zuerst ein Thema aus!");
            info.showAndWait();
        }
    }

    public static void show(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MenuController.class.getResource("/view/menu.fxml"));
            Parent root = fxmlLoader.load();

            stage.setTitle("CyberLearn");
            MenuController.stage = stage;
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception exception) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Internal Error");
            alert.setContentText(String.format("An internal Error occurred. Please restart the program%nor contact the developer on GitHub%n%nError message: %s", exception.getMessage()));
            alert.showAndWait();
            System.err.println(exception.getMessage());
            exception.printStackTrace(System.err);
        }
    }
}
