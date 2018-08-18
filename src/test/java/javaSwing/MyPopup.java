package javaSwing;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyPopup 
{
	public static void main(String args[]) throws Exception
	{
		
		MyPopup my = new MyPopup();
		my.replaceXpathScreen();
		/*JFrame frame = new JFrame();
		frame.setLayout(new GridLayout(4,1));
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		
		JLabel label1 = new JLabel("What action do you wish to perform?");
		p1.add(label1);
		
		
		
		
		frame.add(p1);
		frame.add(p2);
		frame.add(p3);
		frame.add(p4);
		
		frame.setSize(450,450);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);*/
	}
	
	
	public void replaceXpathScreen() throws Exception
	{
		JFrame frame = new JFrame();
		frame.setLayout(new GridLayout(4,1));
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		
		JLabel label1 = new JLabel("XPath which is failing is : ");
		p1.add(label1);
		
		
		JTextArea oldXpath = new JTextArea("//*[@id='12345']");
		//JLabel label2 = new JLabel("//*[@id='12345']");
		p2.add(oldXpath);
		
		JLabel label2 = new JLabel("Please Enter a new XPath below : ");
		p3.add(label2);
		
		JTextField newXpath = new JTextField();
		newXpath.setBounds(0, 0, 300, 100);
		//JLabel label2 = new JLabel("//*[@id='12345']");
		p4.add(newXpath);
		
		
		
		frame.add(p1);
		frame.add(p2);
		frame.add(p3);
		frame.add(p4);
		
		frame.setSize(450,450);
		frame.setVisible(true);
	}
}
