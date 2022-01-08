package view;

import answer.Answer;
import answer.AnswerComp;
import categories.*;
import question.Question;
import question.QuestionsController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static question.QuestionModel.getCategories;
import static question.QuestionModel.getQuestions;

public class QuestionView extends JFrame{

    private final JButton back = new JButton("Q&A");
    private final JButton answer = new JButton("Answer");


    public QuestionView(Question q) {

        setSize(1100,670);
        setLayout(null);
        setTitle("Questions");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setBackground(Color.lightGray);

        addQuestion(q);
        addCategoriesPanel();
        addAnswers(q);

    }

    private void addQuestion(Question q){

        back.setBounds(30,30,100,50);
        back.setFont(new Font("Roboto", Font.PLAIN, 20));
        back.setBackground(Color.decode("#D8E9F3"));
        back.addActionListener(new HomeClickListener());
        add(back);

        JLabel user = new JLabel(q.getUser() + " asked on " + q.getPostDate());
        user.setFont(new Font("Roboto", Font.ITALIC, 16));
        user.setForeground(Color.darkGray);
        user.setBounds(30,90,300,20);
        add(user);

        JTextArea question = new JTextArea(q.getQuestion());
        question.setBounds(70,120,740,170);
        question.setFont(new Font("Roboto", Font.PLAIN, 25));
        question.setLineWrap(true);
        question.setEditable(false);
        add(question);

        answer.setBounds(100,300,120,30);
        answer.setBackground(Color.decode("#4390BC"));
        answer.setForeground(Color.white);
        answer.setOpaque(true);
        answer.setVisible(true);
        answer.addActionListener(new answerListener(q));
        add(answer);

    }

    private void addCategoriesPanel(){
        java.util.List<String> categoryList = getCategories();
        List<JButton> buttonList = new ArrayList<>();
        for (String c: categoryList) {
            JButton button = new JButton(c);
            button.setPreferredSize(new Dimension(200,20));

            buttonList.add(button);
        }
        JPanel categoryPanel = new JPanel();
        categoryPanel.setLayout(new BoxLayout(categoryPanel, BoxLayout.Y_AXIS));
        JLabel cat = new JLabel("Categories");
        cat.setSize(200,30);
        cat.setFont(new Font("Roboto", Font.BOLD,16));
        categoryPanel.add(cat);
        categoryPanel.add(Box.createRigidArea(new Dimension(0,15)));

        for (JButton b: buttonList) {
            b.setBackground(Color.decode("#D8E9F3") );
            b.setFont(new Font("Roboto",Font.BOLD,16));
            b.addActionListener(new categoryListener());
            categoryPanel.add(b);
            categoryPanel.add(Box.createRigidArea(new Dimension(0,10)));
        }
        categoryPanel.setBounds(840,120,200,470);
        add(categoryPanel);
    }

    void addAnswers(Question q){
        List<JPanel> answerPanelList = new ArrayList<>();
        List<Answer> answerList = q.getAnsList();
        System.out.println("a");
        for ( Answer answer: answerList) {
            AnswerComp answerComp = new AnswerComp(answer);
            System.out.println(answer.getAnswer());
            answerPanelList.add(answerComp);
        }

        JPanel answerPanel = new JPanel();
        answerPanel.setLayout(new BoxLayout(answerPanel, BoxLayout.Y_AXIS));
        for(JPanel answer: answerPanelList){
            answerPanel.add(answer);
            answerPanel.add(Box.createRigidArea(new Dimension(0,20)));
        }

        JScrollPane scrollPane = new JScrollPane(answerPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(70,350,740,230);
        add(scrollPane);
    }

    private class HomeClickListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            List<Question> questionList = getQuestions();
            QuestionsController questionsController = new QuestionsController(questionList);
            dispose();
        }
    }

    private class categoryListener implements ActionListener{

        List <String> categoryList = getCategories();

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            if(button.getText().equals(categoryList.get(0))){
                Beauty beauty = new Beauty(getQuestions());
                beauty.setVisible(true);
                dispose();
            } else if(button.getText().equals(categoryList.get(1))){
                Cars cars = new Cars(getQuestions());
                cars.setVisible(true);
                dispose();
            } else if(button.getText().equals(categoryList.get(2))){
                Love love = new Love(getQuestions());
                love.setVisible(true);
                dispose();
            } else if(button.getText().equals(categoryList.get(3))){
                Music music = new Music(getQuestions());
                music.setVisible(true);
                dispose();
            } else if(button.getText().equals(categoryList.get(4))){
                Science science = new Science(getQuestions());
                science.setVisible(true);
                dispose();
            }
            else{
                Sport sport = new Sport(getQuestions());
                sport.setVisible(true);
                dispose();
            }

        }
    }

    private class answerListener implements ActionListener{

        private final Question q;

        public answerListener(Question question){
            q = question;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            AnswerView answerView = new AnswerView(q);
            answerView.setVisible(true);
        }
    }
}
