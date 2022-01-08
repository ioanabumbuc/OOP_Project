package view;

import question.Question;
import question.QuestionsController;
import view.AddQuestionView;
import view.View;
import view.Login;
//import View.ProgressBar;


import javax.swing.*;
import javax.swing.border.Border;

import comPostgres.ConnPostgres;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.time.LocalDate;
import java.util.List;

import static question.QuestionModel.*;

public class AddQuestionView extends JFrame implements ActionListener {

	
	
	private static final JButton button = new JButton("Submit Question");
	private static final JTextArea textField = new JTextArea();
	private static final JLabel label1 = new JLabel("Ask a question");
	//private static final JLabel label2 = new JLabel("Va rugam sa folositi un limbaj elegant\n si sa evitati prescurtarile (cf, ms, npc)!");

	List<String> categoryList = getCategories();
	private JComboBox comboBox;
	private String[] categories = new String[categoryList.size()];

	public AddQuestionView() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		setSize(600, 600);
		setLocationRelativeTo(null);

		JPanel addQuestPanel = new JPanel();
		addQuestPanel.setLayout(new BoxLayout(addQuestPanel, BoxLayout.Y_AXIS));

		label1.setLocation(100,40);
		label1.setSize(500,40);
		label1.setFont(new Font("Roboto", Font.PLAIN, 40));

		button.addActionListener(this);
		button.setBounds(220, 500, 170, 30);
		button.setBackground(Color.decode("#4390BC"));
		button.setForeground(Color.white);


		for (int i = 0; i < categories.length; i++) {
			categories[i] = categoryList.get(i);
		}
		comboBox = new JComboBox(categories);
		comboBox.setFont(new Font("", Font.PLAIN, 15));
		comboBox.setBounds(407, 200, 120, 34);

		textField.setBounds(5, 84, 50, 50);
		textField.setFont(new Font("Roboto", Font.PLAIN, 20));

		addQuestPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		addQuestPanel.add(textField);

		addQuestPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		addQuestPanel.add(comboBox);
		addQuestPanel.add(Box.createRigidArea(new Dimension(0, 10)));

		addQuestPanel.add(Box.createRigidArea(new Dimension(0, 10)));

		add(label1);
		addQuestPanel.setBounds(100, 100, 400, 400);
		add(addQuestPanel);

		add(button);
		setVisible(true);
	}

	
	
	public void actionPerformed(ActionEvent e) {

		
		if (e.getSource() == button) {
			//if(comboBox.getSelectedIndex() == 0 ) {
				
				ConnPostgres cp1 = new ConnPostgres();
				
				addToQuestionList(textField.getText());
				
				cp1.insertQuestion(textField.getText(), comboBox.getSelectedItem().toString());
				
				
				//List<Question> questionList = getQuestions();
				Question q = new Question(textField.getText(), Login.getUser(), LocalDate.of(2021,12,27),2);
				
				
				dispose();
			//}
			//else{
			//	dispose();
			//}
			//List<Question> questionList = getQuestions();
			//questionList.add(q);
			//QuestionsController questionsController = new QuestionsController(questionList);	
		}
	}


}

