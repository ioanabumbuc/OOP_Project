package question;

import view.QuestionView;
import view.View;

import java.util.List;

public class QuestionsController {

    private final View view;

    private final List<Question> questionList;

    public QuestionsController(List<Question> questionList) {
        this.view = new View(questionList,this);
        this.questionList = questionList;
        view.setVisible(true);
    }

    public static void onQClicked(Question question) {
        QuestionView questionView = new QuestionView(question);
        questionView.setVisible(true);
    }

}
