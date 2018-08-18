package javaSwing;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GridbagLayoutExample
{
	public static void main(String args[]) throws Exception
	{
		JFrame frame = new JFrame("Java Swing Example");
		frame.setSize(400, 400);
		frame.setLocation(500, 250);
		
		
		JPanel panel = new JPanel();
		//panel.setBackground(Color.GRAY);
		
		GridBagLayout layout = new GridBagLayout();
		panel.setLayout(layout);

		GridBagConstraints gbc = new GridBagConstraints();
		
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 30;
		panel.add(new JButton("Button 1"), gbc);
		
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		panel.add(new JTextField("Text field"), gbc);
		
		frame.add(panel);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}


}
