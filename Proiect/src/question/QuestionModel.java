package question;

import answer.Answer;
import comPostgres.ConnPostgres;
import view.Login;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionModel {


    private static List<Question> questionList = new ArrayList<>();
    private static List<Question> addedQuestions = new ArrayList<>();

    public static void addToQuestionList(String question) {
        Question q = new Question(question,"bogdan",LocalDate.now(),0);
        questionList.add(q);
        addedQuestions.add(q);
    }

    public static java.util.List<Question> getQuestions(){

        questionList.clear();
        List<Answer> ans = new ArrayList<>();

        ConnPostgres cp = new ConnPostgres();
        String[] arr = new String[100];
        
        //question 1
        /* Question q1 = new Question("\n Salutare! Am un inel care este cam mare și aș vrea sa iau\n piatra de la el și să o pun la un inel pe comandă. Știți unde\n as putea să personalizez un inel în acest mod? ",
                "ioio", LocalDate.of(2021,12,27),1);
        Answer a11 = new Answer("Rasp1","edi",LocalDate.of(2021,12,8));
        ans.add(a11);
        q1.setAnswerList(ans);
        questionList.add(q1);

        //question 2
        ans.clear();
        Question q2 = new Question("\n\n Pot infia ca barbat necasatorit in Romania? ",
                "bogdan", LocalDate.of(2021,8,27),3);
        Answer a21 = new Answer("Rasp2","maricica",LocalDate.of(2021,12,10));
        ans.add(a21);
        Answer a22 = new Answer("Raspunsss", "andrei",LocalDate.of(2021,12,12));
        ans.add(a22);
        Answer a23 = new Answer("adjakls","akdsj",LocalDate.of(2011,3,4));
        ans.add(a23);
        q2.setAnswerList(ans);
        questionList.add(q2);

        //question 3
        //ans.clear();
        Question q3 = new Question("\n Știe cineva când se mai fac înscrieri la pompieri/jandarmi? Se poate intra cu profesionala? In Dâmbovița ",
                "alex",LocalDate.of(2020,12,27),0);
        questionList.add(q3);

        //question 4

        Question q4 = new Question("O lista cu filme/seriale care merita vazute. Nu conteaza categoria. ",
                "alex",LocalDate.of(2020,12,27),8);
        questionList.add(q4);

        for ( Question q: addedQuestions) {
            questionList.add(q);
        }*/

        
        arr = cp.getAllQuestions();
        for(int i = 0; i < arr.length - 1; i++) {
        	if(arr[i] != null){
        	
        	Question qx = new Question(arr[i], Login.getUser(), LocalDate.of(2020,12,27), 3);
        	ans.clear();
        	Answer qx1 = new Answer("I don't know.","maricica",LocalDate.of(2021,12,10));
            ans.add(qx1);
            Answer qx2 = new Answer("No.", "andrei",LocalDate.of(2021,12,12));
            ans.add(qx2);
            Answer qx3 = new Answer("Vreau funda","akdsj",LocalDate.of(2011,3,4));
            ans.add(qx3);
            qx.setAnswerList(ans);
        	
        	questionList.add(qx);
        	}
        }
        
        return questionList;

    }

    public static void addAnswer(Question q, String s){

        List<Answer> answerList = q.getAnsList();
        Answer answer = new Answer(s,"bogdan",LocalDate.now());
        answerList.add(answer);

    }

    public static List<String> getCategories(){
        List<String> categoryList = new ArrayList<>();
        categoryList.add("Cars");
        categoryList.add("Beauty & Fashion");
        categoryList.add("Love, Family, Relationships");
        categoryList.add("Music");
        categoryList.add("Sport");
        categoryList.add("Science & Technology");
        Collections.sort(categoryList);

        return categoryList;
    }
}
