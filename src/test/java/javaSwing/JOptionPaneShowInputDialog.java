package javaSwing;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JOptionPaneShowInputDialog 
{
	JFrame f;  
	String name;
	JOptionPaneShowInputDialog()
	{  
	    f=new JFrame();   
	    name =JOptionPane.showInputDialog(f,"Enter Name");      
	}  
	
	public static void main(String[] args) {  
	    new JOptionPaneShowInputDialog();
	} 

}
