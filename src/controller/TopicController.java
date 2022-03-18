package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.stage.Stage;
import model.Topic;

public class TopicController {

    //Stage to give to other Controllers
    private static Stage stage;
    //Topic that was chosen in Menu
    public static Topic topic;

    /**
     * Open PracticeController
     **/
    public void practice()
    {
        PracticeController.show(TopicController.stage);
    }

    /**
     * Open TheoryController
     **/
    public void theory(){
        TheoryController.show(TopicController.stage);
    }

    /**
     * Goes back in the Menu by one step
     **/
    public void back()
    {
        MenuController.show(TopicController.stage);
    }

    /**
     * Switches the FXML to topic.fxml
     * @param stage The Stage to display the FXML
     * @param topic The Topic to use
     **/
    public static void show(Stage stage, Topic topic) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(TopicController.class.getResource("/view/topic.fxml"));
            Parent root = fxmlLoader.load();

            TopicController.topic = topic;
            TopicController.stage = stage;
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
