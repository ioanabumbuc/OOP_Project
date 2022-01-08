package view;

import question.Question;
import question.QuestionsController;

import javax.swing.*;

import comPostgres.ConnPostgres;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static question.QuestionModel.getQuestions;

public class Registration extends JFrame implements ActionListener {


    private static final JLabel title = new JLabel("Create new account");
    private static final JLabel username = new JLabel("Username: ");
    private static final JTextField userField = new JTextField();
    private static final JLabel password = new JLabel("Password: ");
    private static final JPasswordField passField = new JPasswordField();
    private static final JLabel gender = new JLabel("Gender:");
    private static final JRadioButton fem = new JRadioButton("Female");
    private static final JRadioButton male = new JRadioButton("Male");
    private static final JRadioButton notSay = new JRadioButton("Rather not say");
    private static final ButtonGroup btnGroup = new ButtonGroup();
    private static final JLabel dateOfBirth = new JLabel("Date Of Birth:");
    private static final JCheckBox term = new JCheckBox("Accept Terms And Conditions.");
    private static final JButton sub = new JButton("Submit");
    private static final JButton reset = new JButton("Reset");
    private static final JLabel userExists = new JLabel("Username already exists");
    private static final JLabel acceptTerms = new JLabel("You have to accept terms and conditions");
    private static final JLabel blankField = new JLabel("Field can't be blank");
    private static final JLabel haveAcc = new JLabel("Already have an account? Click here to Login");
    private static final JButton login = new JButton("Login");

    private final String[] dates
            = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    private final String[] months
            = {"Jan", "feb", "Mar", "Apr", "May", "Jun", "July", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private final String[] years
            = {"1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006",
            "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019"};

    private final JComboBox date = new JComboBox(dates);
    private final JComboBox month = new JComboBox(months);
    private final JComboBox year = new JComboBox(years);

    public Registration() {
        setTitle("Registration Form");
        setBounds(300, 90, 490, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        Container c = getContentPane();
        c.setLayout(null);

        title.setFont(new Font("Roboto", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(100, 30);
        c.add(title);

        username.setFont(new Font("Roboto", Font.PLAIN, 20));
        username.setSize(120, 20);
        username.setLocation(60, 100);
        c.add(username);

        userField.setFont(new Font("Roboto", Font.PLAIN, 15));
        userField.setSize(190, 20);
        userField.setLocation(200, 100);
        c.add(userField);

        userExists.setFont(new Font("Roboto", Font.PLAIN,11));
        userExists.setForeground(Color.RED);
        userExists.setSize(190, 10);
        userExists.setLocation(200, 85);
        userExists.setVisible(false);
        c.add(userExists);


        password.setFont(new Font("Roboto", Font.PLAIN, 20));
        password.setSize(100, 20);
        password.setLocation(60, 160);
        c.add(password);

        passField.setFont(new Font("Roboto", Font.PLAIN, 15));
        passField.setSize(190, 20);
        passField.setLocation(200, 160);
        c.add(passField);

        gender.setFont(new Font("Roboto", Font.PLAIN, 20));
        gender.setSize(100, 20);
        gender.setLocation(60, 220);
        c.add(gender);

        male.setFont(new Font("Roboto", Font.PLAIN, 15));
        male.setSelected(true);
        male.setSize(75, 20);
        male.setLocation(170, 220);
        c.add(male);

        fem.setFont(new Font("Roboto", Font.PLAIN, 15));
        fem.setSelected(false);
        fem.setSize(80, 20);
        fem.setLocation(245, 220);
        c.add(fem);

        notSay.setFont(new Font("Roboto", Font.PLAIN, 15));
        notSay.setSelected(false);
        notSay.setSize(150, 20);
        notSay.setLocation(330, 220);
        c.add(notSay);

        btnGroup.add(male);
        btnGroup.add(fem);
        btnGroup.add(notSay);

        dateOfBirth.setFont(new Font("Roboto", Font.PLAIN, 20));
        dateOfBirth.setSize(180, 20);
        dateOfBirth.setLocation(60, 280);
        c.add(dateOfBirth);

        date.setFont(new Font("Roboto", Font.PLAIN, 15));
        date.setSize(50, 20);
        date.setLocation(200, 280);
        c.add(date);

        month.setFont(new Font("Roboto", Font.PLAIN, 15));
        month.setSize(60, 20);
        month.setLocation(255, 280);
        c.add(month);

        year.setFont(new Font("Roboto", Font.PLAIN, 15));
        year.setSize(60, 20);
        year.setLocation(320, 280);
        c.add(year);

        term.setFont(new Font("Roboto", Font.PLAIN, 15));
        term.setSize(250, 20);
        term.setLocation(150, 330);
        c.add(term);

        acceptTerms.setFont(new Font("Roboto", Font.PLAIN, 15));
        acceptTerms.setSize(300,30);
        acceptTerms.setLocation(100,360);
        acceptTerms.setForeground(Color.RED);
        acceptTerms.setVisible(false);
        c.add(acceptTerms);

        blankField.setFont(new Font("Roboto", Font.PLAIN, 15));
        blankField.setSize(300,30);
        blankField.setForeground(Color.RED);
        blankField.setVisible(false);
        c.add(blankField);

        sub.setFont(new Font("Roboto", Font.BOLD, 15));
        sub.setSize(100, 30);
        sub.setBackground(Color.decode("#4390BC"));
        sub.setForeground(Color.white);
        sub.setLocation(120, 390);
        sub.addActionListener(this);
        c.add(sub);

        reset.setFont(new Font("Roboto", Font.BOLD, 15));
        reset.setSize(100, 30);
        reset.setBackground(Color.decode("#D8E9F3"));
        reset.setLocation(270, 390);
        reset.addActionListener(this);
        c.add(reset);

        haveAcc.setFont(new Font("Roboto",Font.PLAIN,15));
        haveAcc.setSize(400,20);
        haveAcc.setLocation(70,460);
        c.add(haveAcc);

        login.setFont(new Font("Roboto", Font.BOLD, 15));
        login.setSize(100, 30);
        login.setLocation(175, 490);
        login.setBackground(Color.decode("#D8E9F3"));
        login.addActionListener(this);
        c.add(login);


    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == sub) {
            if(userField.getText().equals("bogdan")){
                userExists.setVisible(true);
            }
            else if(userField.getText().isEmpty()){
                blankField.setLocation(200,77);
                blankField.setVisible(true);
            }
            else if(passField.getText().isEmpty()){
                blankField.setLocation(200,137);
                blankField.setVisible(true);
            }
            else if(!term.isSelected()){
                if(blankField.isVisible()){
                    blankField.setVisible(false);
                }
                acceptTerms.setVisible(true);
            }
            else{
            	ConnPostgres cp = new ConnPostgres();
            	cp.insertInfo(userField.getText(), passField.getText());
            	List<Question> questionList = getQuestions();
                QuestionsController questionsController = new QuestionsController(questionList);
                dispose();
            }
        }

        else if(e.getSource() == login){
            Login login = new Login();
            login.setVisible(true);
            dispose();
        }

        else if (e.getSource() == reset) {
            String def = "";
            userField.setText(def);
            passField.setText(def);
            btnGroup.clearSelection();
            term.setSelected(false);
            date.setSelectedIndex(0);
            month.setSelectedIndex(0);
            year.setSelectedIndex(0);
            acceptTerms.setVisible(false);
            blankField.setVisible(false);
        }
    }
}

