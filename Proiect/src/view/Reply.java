package view;

import view.AddQuestionView;
//import view.HelloView;
//import view.Login;
//import view.ProgressBar;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;


public class Reply extends JFrame implements ActionListener {

	private static final JLabel label1 = new JLabel("Pot sa-mi pun flashscore pe ceas?");
	private static final JLabel label2 = new JLabel();
	private static final Border border = BorderFactory.createLineBorder(Color.orange, 1);
	
	private static final JTextArea textField = new JTextArea();
	private static final JButton button = new JButton("Raspunde");
	
	//private static final BufferedImage myPicture = ImageIO.read(new File("profile_oerfect.png"));
	//private static final JLabel picLabel = new JLabel(new ImageIcon(myPicture));
	
	public Reply() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setSize(600, 600);
		
		label1.setBounds(5, 5, 400, 50);
		label1.setFont(new Font("Serif", Font.PLAIN, 28));
		
    	label2.setForeground(new Color(255, 140, 160)); //font color
		label2.setFont(new Font("MV Boli", Font.PLAIN, 20)); //set font
    	label2.setBounds(5, 100, 550, 230);
    	label2.setBorder(border);
		label2.setVerticalAlignment(JLabel.CENTER); //vertical position of label
		label2.setHorizontalAlignment(JLabel.CENTER); //horizontal position of label
		label2.setBackground(new Color(255, 165, 0));
		label2.setOpaque(true);
		//label2.setIcon(image);
		
		textField.setText("Raspunsul tau aici ...");
		textField.setBounds(90, 115, 450, 132);
		textField.setFont(new Font("Serif", Font.PLAIN, 20));
		
		button.setBounds(434, 272, 100, 30);
			
		add(label1);
		add(label2);
		add(textField);
		add(button);
		//add(image);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		
	}
}
