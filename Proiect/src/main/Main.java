package main;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import java.util.*;
import java.sql.*;



import answer.Answer;
import categories.Beauty;
import comPostgres.ConnPostgres;
import question.Question;
import question.QuestionsController;
import view.*;

import java.util.ArrayList;
import java.util.List;

import static question.QuestionModel.getQuestions;

public class Main {

    public static void main(String[] args) {

       Login login = new Login();
       login.setVisible(true);

       
       ConnPostgres cp = new ConnPostgres();
       //cp.getInfo();
       //cp.insertInfo("bogdan", "123");
       
       
       // Registration registration = new Registration();
       // registration.setVisible(true);

        //List<Question> questionList = getQuestions();
        //AnswerView answerView = new AnswerView(questionList.get(0));
       // answerView.setVisible(true);

       //QuestionsController questionsController = new QuestionsController(questionList);
        //Beauty beauty = new Beauty(questionList);
        //beauty.setVisible(true);

        //AddQuestionView addQuestionView = new AddQuestionView();
        //addQuestionView.setVisible(true);

        //System.out.println(questionList.get(0).getQuestion());
        //List<Answer> answerList = questionList.get(0).getAnsList();
        //System.out.println(answerList.size());

        //QuestionView questionView = new QuestionView(questionList.get(0));
        //questionView.setVisible(true);
    }
}