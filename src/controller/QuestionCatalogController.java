package controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.Question;

public class QuestionCatalogController {

    @FXML
    private ListView<Question> questionList;

    //Question last selected to give to other Controllers
    public static Question selectedQuestion;
    //Stage to give to other Controllers
    private static Stage stage;

    /**
     * Code to run when the Controller gets initialized
     **/
    public void initialize()
    {
        questionList.setItems(FXCollections.observableArrayList(TopicController.topic.getQuestions()));
    }

    /**
     * Show the selected Question in QuestionController
     **/
    public void openQuestion()
    {
        QuestionCatalogController.selectedQuestion = questionList.getSelectionModel().getSelectedItem();
        QuestionController.show(QuestionCatalogController.stage);
    }

    /**
     * Goes back in the Menu by one step
     **/
    public void back()
    {
        PracticeController.show(QuestionCatalogController.stage);
    }

    /**
     * Switches the FXML to questionCatalog.fxml
     * @param stage The Stage to display the FXML
     **/
    public static void show(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(QuestionCatalogController.class.getResource("/view/questionCatalog.fxml"));
            Parent root = fxmlLoader.load();

            QuestionCatalogController.stage = stage;
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
