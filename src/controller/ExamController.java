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
import model.Question;

import java.util.ArrayList;
import java.util.Collections;

public class ExamController {

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
    //Questions used in the Exam
    private ArrayList<Question> questions;
    //Answers to current question
    private ArrayList<Answer> currentAnswers;
    //Index of current question
    int currentQuestion;
    int points;

    public void checkAns1() {
        checkQuestion(currentAnswers.get(0).isRight());
    }

    public void checkAns2() {
        checkQuestion(currentAnswers.get(1).isRight());
    }

    public void checkAns3() {
        checkQuestion(currentAnswers.get(2).isRight());
    }

    public void checkAns4() {
        checkQuestion(currentAnswers.get(3).isRight());
    }

    /**
     * Code to run when the Controller gets initialized
     **/
    public void initialize()
    {
        //Shuffle the questions
        Collections.shuffle(TopicController.topic.getQuestions());

        //If less than 10 Questions use all
        if(TopicController.topic.getQuestions().size() < 10)
        {
            questions = TopicController.topic.getQuestions();
        } else
        {
            questions = new ArrayList<>();
            // if more than 10 questions use only 10
            for (int i = 0; i < 10; i++) {
                questions.add(TopicController.topic.getQuestions().get(i));
            }
        }
        //Reset the exam
        currentQuestion = 0;
        points = 0;
        //Display first question
        nextQuestion();
    }

    /**
     * Displays a question with its answers
     * @param question the question to display
     **/
    public void displayQuestion(Question question)
    {
        //Shuffle the answers
        Collections.shuffle(question.getAnswers());
        currentAnswers = question.getAnswers();
        questionTxt.setText(question.getQuestionText());
        answer1Btn.setText(currentAnswers.get(0).getAnswerText());
        answer2Btn.setText(currentAnswers.get(1).getAnswerText());
        answer3Btn.setText(currentAnswers.get(2).getAnswerText());
        answer4Btn.setText(currentAnswers.get(3).getAnswerText());
    }

    /**
     * Checks if there are more Questions left and displays the next Question or shows the results
     **/
    public void nextQuestion() {
        // check if Questions available
        if (currentQuestion < questions.size()) {
            displayQuestion(questions.get(currentQuestion));
        } else {
            //Show end result
            Alert finish = new Alert(Alert.AlertType.INFORMATION);
            double percent = (double) points / (double) questions.size();
            // check if exam was positive
            if (percent > 0.60) {
                finish.setTitle("Ergebnis");
                finish.setContentText("Du hast die Prüfung abgeschlossen!\nDu hast " + points + "/" + questions.size() + " Fragen richtig beantwortet und somit bestanden");
            } else {
                finish.setContentText("Du hast die Prüfung abgeschlossen!\nDu hast " + points + "/" + questions.size() + " Fragen richtig beantwortet und leider nicht bestanden");
            }
            finish.showAndWait();
            back();
        }
        currentQuestion++;
    }

    /**
     * handle if the given was answered correctly
     * @param correct boolean of the answer, true if right
     **/
    private void checkQuestion(boolean correct) {
        Alert result;
        // if is correct answer
        if (correct) {
            //Inform that answer was right
            result = new Alert(Alert.AlertType.INFORMATION);
            result.setTitle("Gratulation!");
            result.setContentText("Die Antwort war richtig!");
            points++;
        } else {
            //inform that answer is wrong
            result = new Alert(Alert.AlertType.WARNING);
            result.setTitle("Oh nein!");
            result.setContentText("Das war leider die falsche Antwort!");
        }
        result.showAndWait();
        nextQuestion();
    }

    /**
     * Goes back in the Menu by one step
     **/
    public void back() {
        PracticeController.show(ExamController.stage);
    }

    /**
     * Switches the FXML to exam.fxml
     * @param stage The Stage to display the FXML
     **/
    public static void show(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ExamController.class.getResource("/view/exam.fxml"));
            Parent root = fxmlLoader.load();

            ExamController.stage = stage;
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
