package view;

import question.Question;
import question.QuestionsController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import comPostgres.ConnPostgres;

import java.awt.*;
import java.util.List;

import static question.QuestionModel.getQuestions;

public class Login extends JFrame {


    private class LoginClickListener implements ActionListener{

    	ConnPostgres cp = new ConnPostgres();
    	@Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == button) {
               
            	//user.getText().equals("bogdan") && parola.getText().equals("123")
            	
            	if (cp.checkForPassword(user.getText(), parola.getText())) {
                    List<Question> questionList = getQuestions();
                    QuestionsController questionsController = new QuestionsController(questionList);
                    dispose();
                } else {
                    addError();
                }
            }
            else if (e.getSource() == register){
                Registration registration = new Registration();
                registration.setVisible(true);
                dispose();
            }
        }
    }



    private static final JLabel helloMsg = new JLabel("Login to Q&A App");
    private static final JTextField user = new JTextField();
    private static final JPasswordField parola = new JPasswordField();
    private static final JLabel userMsg = new JLabel("Username:");
    private static final JLabel passMsg = new JLabel("Password");
    private static final JButton button = new JButton("Login");
    private static final JLabel error = new JLabel("Incorrect");
    private static final JLabel noAcc = new JLabel("Don't have an account? Create one now!");
    private static final JButton register = new JButton("Register");

    public Login() {
        setTitle("Login");
        setSize(380, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addInput();
        button.addActionListener(new LoginClickListener());
        register.addActionListener(new LoginClickListener());
    }

    private void addError() {
        //remove(helloMsg);
        helloMsg.setVisible(false);
        error.setBounds(110, 40, 300, 40);
        error.setFont(new Font("Roboto", Font.BOLD, 27));
        add(error);
    }

    private void addInput(){

        helloMsg.setBounds(65,40,300,50);
        helloMsg.setFont(new Font("Roboto", Font.BOLD, 27));
        add(helloMsg);

        userMsg.setBounds(80, 100, 300, 20);
        userMsg.setFont(new Font("Roboto",Font.PLAIN,13));
        user.setBounds(80, 130, 200, 25);
        add(userMsg);
        add(user);

        passMsg.setBounds(80, 160, 300, 20);
        passMsg.setFont(new Font("Roboto",Font.PLAIN,13));
        parola.setBounds(80, 190, 200, 25);
        add(passMsg);
        add(parola);

        button.setBounds(130, 230, 100, 30);
        button.setBackground(Color.decode("#4390BC"));
        button.setFont(new Font("Roboto",Font.BOLD,13));
        button.setForeground(Color.WHITE);
        add(button);

        noAcc.setBounds(65,280,300,30);
        noAcc.setFont(new Font("Roboto",Font.BOLD,13));
        add(noAcc);

        register.setBounds(130,310,100,30);
        register.setFont(new Font("Roboto",Font.BOLD,13));
        register.setBackground(Color.decode("#D8E9F3"));
        add(register);

    }
    
    public static String getUser(){
    	return user.getText();
    }
}