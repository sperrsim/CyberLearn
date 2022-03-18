package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Answer;

import java.util.ArrayList;

public class QuestionController {
    @FXML
    private Label questionTxt;

    @FXML
    private Button answer1Btn;

    @FXML
    private Button answer2Btn;

    @FXML
    private Button answer3Btn;

    @FXML
    private Button answer4Btn;

    //Stage to give to other Controllers
    private static Stage stage;
    //Answers of the Question
    private ArrayList<Answer> answers;

    /**
     * Code to run when the Controller gets initialized
     **/
    public void initialize()
    {
        questionTxt.setText(QuestionCatalogController.selectedQuestion.getQuestionText());
        answers = QuestionCatalogController.selectedQuestion.getAnswers();
        answer1Btn.setText(answers.get(0).getAnswerText());
        answer2Btn.setText(answers.get(1).getAnswerText());
        answer3Btn.setText(answers.get(2).getAnswerText());
        answer4Btn.setText(answers.get(3).getAnswerText());
    }

    public void checkAns1() {
        result(answers.get(0).isRight());
        back();
    }

    public void checkAns2() {
        result(answers.get(1).isRight());
        back();
    }

    public void checkAns3() {
        result(answers.get(2).isRight());
        back();
    }

    public void checkAns4() {
        result(answers.get(3).isRight());
        back();
    }

    /**
     * display the result of the chosen answer
     * @param correct
     **/
    private void result(boolean correct)
    {
        Alert result;
        //if answer correct
        if(correct)
        {
            result = new Alert(Alert.AlertType.INFORMATION);
            result.setTitle("Gratulation!");
            result.setContentText("Die Antwort war richtig!");
        } else
        {
            result = new Alert(Alert.AlertType.WARNING);
            result.setTitle("Oh nein!");
            result.setContentText("Das war leider die falsche Antwort!");
        }
        result.showAndWait();
    }

    /**
     * Goes back in the Menu by one step
     **/
    public void back()
    {
        QuestionCatalogController.show(QuestionController.stage);
    }

    /**
     * Switches the FXML to question.fxml
     * @param stage The Stage to display the FXML
     **/
    public static void show(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(QuestionController.class.getResource("/view/question.fxml"));
            Parent root = fxmlLoader.load();

            QuestionController.stage = stage;
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
