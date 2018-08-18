package javaSwing;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ScreenshotBuilderUI 
{
	public static void main(String args[]) throws Exception
	{		
		ScreenshotBuilderUI my = new ScreenshotBuilderUI();
		my.inputScreen();
	}
	
	
	public void inputScreen() throws Exception
	{
		final JFrame frame = new JFrame();
		frame.setLayout(new GridLayout(5,1));
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();		
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		
		JLabel label1 = new JLabel("Please enter a User Story, CEC ID and Password to proceed :");
		p1.add(label1);		
		
		JLabel l1 = new JLabel("User Story : ");
		final JTextField inputUserStory = new JTextField(20);
		p2.add(l1);
		p2.add(inputUserStory);
		
		JLabel l2 = new JLabel("CEC ID : ");
		final JTextField cecId = new JTextField(20);
		p3.add(l2);
		p3.add(cecId);
		
		JLabel l3 = new JLabel("Password : ");
		final JPasswordField password = new JPasswordField(20);
		p4.add(l3);
		p4.add(password);
		
		JButton buttonOk = new JButton("Ok");
		buttonOk.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
			   System.out.println("OK Pressed");
			   String userStoryValue = inputUserStory.getText();
			   String cecIdValue = cecId.getText();
			   String passwordValue = password.getText();			   
			   frame.setVisible(false);
			  } 
			} );
		
		JButton buttonCancel = new JButton("Cancel");
		buttonCancel.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
			   System.out.println("Cancel Pressed");
			   frame.setVisible(false);
			   System.exit(0);
			  }
			} );
		
		p5.add(buttonOk);
		p5.add(buttonCancel);
		
		frame.add(p1);
		frame.add(p2);		
		frame.add(p3);
		frame.add(p4);
		frame.add(p5);
		
		//frame.setSize(300,300);
		frame.setBounds(600,300,500,300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}


}
