package question;

import view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static question.QuestionModel.getQuestions;


public class QuestionComp extends JPanel{
    private JLabel question;
    private JLabel user;
    private JLabel date;
    private JLabel nrAns;
    private JButton seeQ = new JButton("See Question...");

    public QuestionComp(Question q){
        setPreferredSize(new Dimension(0,180));
        setBorder(BorderFactory.createLineBorder(Color.black));
        setLayout(null);

        user = new JLabel("Posted by "+ q.getUser());
        user.setFont(new Font("Roboto", Font.ITALIC, 14));
        user.setForeground(Color.darkGray);
        user.setBounds(10,10,200,20);
        add(user);

        question = new JLabel(q.getQuestion());
        question.setFont(new Font("Roboto", Font.PLAIN, 20));
        question.setBounds(30,50,720,80);
        add(question);


        date = new JLabel("Posted on "+ String.valueOf(q.getPostDate()));
        date.setFont(new Font("Roboto", Font.ITALIC, 14));
        date.setForeground(Color.darkGray);
        date.setBounds(630,10,200,20);
        add(date);

        //seeQ.setBounds(180,150,160,20);
        seeQ.setSize(200,27);
        seeQ.setLocation(570,135);
        seeQ.setBackground(Color.decode("#B2D3E6"));
        seeQ.setFont(new Font("Roboto", Font.BOLD, 16));
        add(seeQ);

        nrAns = new JLabel(q.getNbAns()+" answers");
        nrAns.setFont(new Font("Roboto", Font.ITALIC, 14));
        nrAns.setBounds(50,140,100,30);
        add(nrAns);

    }

    public void addClickListener(ActionListener actionListener) {
        seeQ.addActionListener(actionListener);
    }

}
