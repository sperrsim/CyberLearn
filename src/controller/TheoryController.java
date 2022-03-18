package controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.Article;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class TheoryController {

    @FXML
    private ListView<Article> articleList;

    //Stage to give to other Controllers
    private static Stage stage;

    /**
     * Code to run when the Controller gets initialized
     **/
    public void initialize()
    {
        articleList.setItems(FXCollections.observableArrayList(TopicController.topic.getArticles()));
    }

    /**
     * Goes back in the Menu by one step
     **/
    public void back()
    {
        TopicController.show(TheoryController.stage, TopicController.topic);
    }

    /**
     * Opens the selected Article in a Webbrowser
     **/
    public void openLink()
    {
        //URl of the Website
        URL url;
        //If an article is selected
        if(articleList.getSelectionModel().getSelectedItem() != null)
        {
            if(Desktop.isDesktopSupported()){
                try {
                    url = articleList.getSelectionModel().getSelectedItem().getLink();
                    //Open the Link in a Browser
                    Desktop.getDesktop().browse(url.toURI());
                } catch (IOException | URISyntaxException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Internal Error");
                    alert.setContentText(String.format("An internal Error occurred. Please restart the program%nor contact the developer on GitHub%n%nError message: %s", e.getMessage()));
                    alert.showAndWait();
                    System.err.println(e.getMessage());
                    e.printStackTrace(System.err);
                }
            }
        } else
        {
            Alert info = new Alert(Alert.AlertType.INFORMATION, "Bitte wählen Sie zuerst ein Thema aus!");
            info.showAndWait();
        }
    }

    /**
     * Switches the FXML to theory.fxml
     * @param stage The Stage to display the FXML
     **/
    public static void show(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(TheoryController.class.getResource("/view/theory.fxml"));
            Parent root = fxmlLoader.load();

            TheoryController.stage = stage;
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
