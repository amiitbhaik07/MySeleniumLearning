package javaSwing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Jsoncomparejar 
{
	static JLabel msgLabel = new JLabel("Please enter Formatted/Unformatted JSons below to compare : \n");
	static JTextArea json1 = new JTextArea("", 23,70);
	static JScrollPane jsonScroll1 = new JScrollPane(json1);
	static JTextArea json2 = new JTextArea("", 23,70);
	static JScrollPane jsonScroll2 = new JScrollPane(json2);
	static JTextArea jsonResult = new JTextArea("", 24,140);
	
	static int sizeOfJson1 = 0, sizeOfJson2 = 0;
	static String str1 = "", str2 = "";
	
	public static void main(String args[]) throws Exception
	{
		final JFrame f = new JFrame("JSon Compare ~ Amit_Bhaik");		
		JPanel p1 = new JPanel();	
		JButton compare = new JButton("Compare");
		compare.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				str1 = json1.getText();
				str2 = json2.getText();
				
				sizeOfJson1 = str1.split("\n").length;
				sizeOfJson2 = str2.split("\n").length;
			}
		});
		
		json1.addMouseListener(new MouseListener()
		{
			public void mouseEntered(MouseEvent e) 
			{
				jsonScroll2.getHorizontalScrollBar().setModel(jsonScroll1.getHorizontalScrollBar().getModel());
				jsonScroll2.getVerticalScrollBar().setModel(jsonScroll1.getVerticalScrollBar().getModel());	
			}
			
			public void mouseClicked(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		});
		
		json2.addMouseListener(new MouseListener()
		{
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				jsonScroll1.getHorizontalScrollBar().setModel(jsonScroll2.getHorizontalScrollBar().getModel());
				jsonScroll1.getVerticalScrollBar().setModel(jsonScroll2.getVerticalScrollBar().getModel());
				
			}
			
			public void mouseClicked(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		});
		
		JButton clear = new JButton("Clear");
		clear.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					json1.setText("");
					json2.setText("");
					jsonResult.setText("");	
					
					sizeOfJson1 = 0;
					sizeOfJson2 = 0;
				}
				catch(Exception e1){}
			}
		});
		
		JButton exit = new JButton("Exit");
		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					f.setVisible(false);
					f.dispose();
				}
				catch(Exception e1){}
			}
		});
		
		jsonResult.setEditable(false);
		JScrollPane jsonScrollResult = new JScrollPane(jsonResult);
		p1.add(jsonScroll1);
		p1.add(jsonScroll2);
		p1.add(compare);
		p1.add(clear);
		p1.add(exit);
		p1.add(jsonScrollResult);
		f.add(p1);		
		f.setVisible(true);
		f.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
