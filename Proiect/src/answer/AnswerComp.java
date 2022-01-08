package answer;

import answer.Answer;

import javax.swing.*;
import java.awt.*;

public class AnswerComp extends JPanel {
    private JLabel answer;
    private JLabel user;
    private JLabel date;

    public AnswerComp(Answer a){
        setPreferredSize(new Dimension(0,130));
        setBorder(BorderFactory.createLineBorder(Color.black));
        setLayout(null);
        setBackground(Color.white);

        user = new JLabel("Posted by "+ a.getUser());
        user.setFont(new Font("Arial", Font.ITALIC, 14));
        user.setForeground(Color.darkGray);
        user.setBounds(10,10,200,20);
        add(user);

        answer = new JLabel(a.getAnswer());
        answer.setFont(new Font("Arial", Font.PLAIN, 20));
        answer.setBounds(30,30,650,80);
        add(answer);


        date = new JLabel("Posted on "+ String.valueOf(a.getPostDate()));
        date.setFont(new Font("Arial", Font.ITALIC, 14));
        date.setForeground(Color.darkGray);
        date.setBounds(570,10,200,20);
        add(date);
    }
}
