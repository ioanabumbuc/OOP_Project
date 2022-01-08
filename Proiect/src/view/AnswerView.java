package view;

import question.Question;
import question.QuestionModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnswerView extends JFrame {
    private static final JLabel answer = new JLabel("Answer the question!");
    private static final JTextField yourAnswer = new JTextField();
    private static final JButton submit = new JButton("Submit answer");

    public AnswerView(Question q){
        setTitle("Add an answer");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(830,200);
        setLocationRelativeTo(null);
        setLayout(null);
        addComponents(q);
    }


    private void addComponents(Question question){
        answer.setLocation(100,17);
        answer.setSize(500,40);
        answer.setFont(new Font("Roboto",Font.BOLD,24));
        add(answer);

        yourAnswer.setBounds(60,80,550,30);
        yourAnswer.setFont(new Font("Roboto",Font.ITALIC, 16));
        add(yourAnswer);

        submit.setBounds(650,80,140,30);
        submit.addActionListener(new SubmitListener(question));
        submit.setFont(new Font("Roboto",Font.BOLD,14));
        submit.setBackground(Color.decode("#4390BC"));
        submit.setForeground(Color.white);
        add(submit);
    }

    private class SubmitListener implements ActionListener {

        private final Question qSelected;

        public SubmitListener(Question question) {
            qSelected = question;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            QuestionModel.addAnswer(qSelected, answer.getText());
            dispose();
        }
    }
}


