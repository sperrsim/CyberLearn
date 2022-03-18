package data;

import model.Answer;
import model.Article;
import model.Question;
import model.Topic;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class TopicFileMaker {
    public static void main(String[] args) {
        ArrayList<Question> questions = new ArrayList<>();
        ArrayList<Answer> answers1 = new ArrayList<>();
        answers1.add(new Answer("malicious Software", true));
        answers1.add(new Answer("mafunctioning Software", false));
        answers1.add(new Answer("male Software", false));
        answers1.add(new Answer("massive Software", false));
        questions.add(new Question("Was bedeutet Malware?", answers1));
        ArrayList<Answer> answers2 = new ArrayList<>();
        answers2.add(new Answer("Trojaner", false));
        answers2.add(new Answer("Phishing", false));
        answers2.add(new Answer("Spyware", false));
        answers2.add(new Answer("Bothub", true));
        questions.add(new Question("Welche Art von Malware gibt es nicht?", answers2));
        ArrayList<Answer> answers3 = new ArrayList<>();
        answers3.add(new Answer("Eine Art von Social Engineering, bei welcher Angreifer versuchen durch betrügerische Anfragen (z.B.: E-Mails) das Opfer zur Herausgabe vertraulicher Daten zu bringen.", true));
        answers3.add(new Answer("Ein Hobby für welches eine Angel gebraucht wird.", false));
        answers3.add(new Answer("Ein Programm, welches Daten fischt.", false));
        answers3.add(new Answer("Eine falsche Website, die versucht den User zu täuschen und an sein Daten zu kommen.", false));
        questions.add(new Question("Was ist Phishing?", answers3));
        ArrayList<Answer> answers4 = new ArrayList<>();
        answers4.add(new Answer("DDoS-Attacken", false));
        answers4.add(new Answer("um Lösegeld zu Erpressen", true));
        answers4.add(new Answer("Krypto-Mining", false));
        answers4.add(new Answer("um Spam zu senden", false));
        questions.add(new Question("Wofür werden Botnets nicht verwendet?", answers4));
        ArrayList<Article> articles = new ArrayList<>();

        try {
            articles.add(new Article("Was ist Malware?", new URL("https://www.redhat.com/de/topics/security/what-is-malware#:~:text=Zur%20Malware%2C%20kurz%20f%C3%BCr%20%E2%80%9Emalicious,mit%20denen%20infizierte%20Ger%C3%A4te%20kommunizieren")));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Topic topic = new Topic("Malware", articles,  questions);
        try (
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("malware.topic"))) {
            oos.writeObject(topic);
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }

}
