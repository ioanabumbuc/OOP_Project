package view;

import categories.*;
import question.Question;
import question.QuestionComp;
import question.QuestionsController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static question.QuestionModel.getCategories;
import static question.QuestionModel.getQuestions;

public class View extends JFrame {

    private final JButton ask = new JButton("Ask a question");
    private final JLabel welcomeMsg = new JLabel("Welcome to Q&A app!");


    private final QuestionsController questionsController;

    public View(List<Question> questionList, QuestionsController questionsController){
        this.questionsController = questionsController;
        setSize(1100,670);
        setLayout(null);
        setTitle("Questions");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createQuestionListView(questionList);
        addTopComponents();
        addCategoriesPanel();
    }
    private void createQuestionListView(List<Question> questionList){
        List<JPanel> questionPanelList = new ArrayList<>();
        questionList.forEach(question -> {
            QuestionComp questionComp = new QuestionComp(question);
            questionComp.addClickListener(new SeeQClickListener(question));
            questionPanelList.add(questionComp);
        });
        addQuestionList(questionPanelList);
    }
    private void addQuestionList(List<JPanel> panelList){
        JPanel questionPanel = new JPanel();
        questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.Y_AXIS));

        panelList.forEach(q -> {
            questionPanel.add(q);
            questionPanel.add(Box.createRigidArea(new Dimension(0,20)));
        });
        JScrollPane scrollPane = new JScrollPane(questionPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(30,150,800,470);
        add(scrollPane);
    }

    private void addTopComponents(){
        ask.setBounds(100,100,160,30);
        ask.setFont(new Font("Roboto", Font.BOLD, 16));
        ask.setBackground(Color.decode("#4390BC"));
        ask.setForeground(Color.white);
        ask.addActionListener(new AskListener());
        
        add(ask);

        welcomeMsg.setSize(300,50);
        welcomeMsg.setLocation(400,20);
        welcomeMsg.setFont(new Font("Roboto",Font.BOLD,25));
        add(welcomeMsg);
    }

    private void addCategoriesPanel(){
        List <String> categoryList = getCategories();
        List <JButton> buttonList = new ArrayList<>();
        for (String c: categoryList) {
            JButton button = new JButton(c);
            button.setSize(100,20);
            button.addActionListener(new categoryListener());
            button.setBackground(Color.decode("#D8E9F3"));
            button.setFont(new Font("Roboto", Font.BOLD,12));
            button.setPreferredSize(new Dimension(0,20));
            buttonList.add(button);
        }
        JPanel categoryPanel = new JPanel();
        categoryPanel.setLayout(new BoxLayout(categoryPanel, BoxLayout.Y_AXIS));
        JLabel cat = new JLabel("Categories");
        cat.setSize(200,30);
        cat.setFont(new Font("Roboto", Font.BOLD,16));
        //cat.setBackground(Color.decode("#D8E9F3"));
        categoryPanel.add(cat);
        categoryPanel.add(Box.createRigidArea(new Dimension(0,15)));

        for (JButton b: buttonList) {
            b.setSize(100,20);
            b.setPreferredSize(new Dimension(200,20));
            //b.setBackground(Color.decode("#D8E9F3"));
            categoryPanel.add(b);
            categoryPanel.add(Box.createRigidArea(new Dimension(0,10)));
        }
        categoryPanel.setBounds(840,150,200,470);
        add(categoryPanel);
    }

    private class SeeQClickListener implements ActionListener {

        private final Question qClicked;

        public SeeQClickListener(Question question) {
            qClicked = question;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            QuestionsController.onQClicked(qClicked);
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

    private class AskListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            AddQuestionView addQuestionView = new AddQuestionView();
            addQuestionView.setVisible(true);
        }
    }


}
