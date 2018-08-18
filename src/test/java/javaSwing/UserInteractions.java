package javaSwing;

import java.awt.FlowLayout;
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


public class UserInteractions 
{
	public static void main(String args[]) throws Exception
	{		
		UserInteractions my = new UserInteractions();
		my.inputScreen();
	}
	
	
	public void inputScreen() throws Exception
	{
		final JFrame frame = new JFrame("Screenshots Builder (abhaik)");
		frame.setLayout(new GridLayout(8,1));
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();		
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		JPanel p6 = new JPanel();
		JPanel p7 = new JPanel();
		JPanel p8 = new JPanel();		
		
		JLabel l1 = new JLabel("Please enter a Test Case Name (Optional) and Press OK : ");
		final JTextField testName = new JTextField(40);
		p2.add(l1);
		p2.add(testName);
		
		JButton buttonOk = new JButton("Ok");
		buttonOk.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e) { 
			   System.out.println("OK Pressed");
			   String testCaseName = testName.getText();
			   frame.setVisible(false);
			  } 
			} );
		
		JButton buttonCancel = new JButton("Exit");
		buttonCancel.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
			   System.out.println("Exit Pressed");
			   frame.setVisible(false);
			   System.exit(0);
			  }
			} );
		
		p4.add(buttonOk);
		p4.add(buttonCancel);
		
		
		JLabel info = new JLabel("F9 = Add Screenshot  ;  F8 = Completed");
		p6.add(info);
		
		frame.add(p1);
		frame.add(p2);		
		frame.add(p3);
		frame.add(p4);
		frame.add(p5);
		frame.add(p6);
		frame.add(p7);
		
		//frame.setSize(300,300);
		frame.setBounds(600,200,550,400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}


}
