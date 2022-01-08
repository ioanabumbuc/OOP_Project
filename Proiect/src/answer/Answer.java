package answer;

import java.time.LocalDate;

public class Answer {

    String answer;
    String user;
    LocalDate postDate;

    public Answer(String answer, String user, LocalDate postDate) {
        this.answer = answer;
        this.user = user;
        this.postDate = postDate;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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
}


