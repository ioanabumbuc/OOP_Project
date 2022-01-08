package question;
import answer.Answer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Question {
    String question;
    String user;
    LocalDate postDate;
    int nbAns;
    List<Answer> answerList = new ArrayList<>();

    public Question(String question, String user, LocalDate postDate, int nbAns) {
        this.question = question;
        this.user = user;
        this.postDate = postDate;
        this.nbAns = nbAns;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public int getNbAns() {
        return nbAns;
    }

    public void setNbAns(int nbAns) {
        this.nbAns = nbAns;
    }

    public List<Answer> getAnsList(){
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

}
