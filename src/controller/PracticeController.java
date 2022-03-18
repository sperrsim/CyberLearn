package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.stage.Stage;
import model.Topic;

public class PracticeController {

    private static Stage stage;

    public void questionCatalog()
    {
        QuestionCatalogController.show(PracticeController.stage);
    }

    public void exam()
    {
        ExamController.show(PracticeController.stage);
    }

    public void back()
    {
        TheoryController.show(PracticeController.stage);
    }

    public static void show(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(PracticeController.class.getResource("/view/practice.fxml"));
            Parent root = fxmlLoader.load();

            PracticeController.stage = stage;
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
