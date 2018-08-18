package learnCoreJava;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class LearnJOptionPane 
{
	public static void main(String args[]) throws Exception
	{
		
		//JOptionPane.showOptionDialog(parentComponent, message, title, optionType, messageType, icon, options, initialValue)
		
		// Creating the main window of our application
		final JFrame frame = new JFrame();
		frame.setLayout(new GridLayout(3, 2));

		// Release the window and quit the application when it has been closed
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//Create a button and set its action
		final JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		}
		);

		// Creating a button and setting its action
		final JButton clickMeButton = new JButton("Click Me!");
		clickMeButton.addActionListener(new ActionListener() {

		    public void actionPerformed(ActionEvent e) {
		        // Ask for the user name and say hello
		        String name = JOptionPane.showInputDialog("What is your name?");
		        JOptionPane.showMessageDialog(frame, "Hello " + name + '!');
		    }
		});

		// Add the button to the window and resize it to fit the button
		frame.getContentPane().add(cancelButton);
		frame.getContentPane().add(clickMeButton);
		
		frame.pack();

		// Displaying the window
		frame.setVisible(true);
		
		
		
		
		
		/*JTextArea textArea = new JTextArea();
        textArea.setEditable(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.requestFocus();
        textArea.requestFocusInWindow();
        scrollPane.setPreferredSize(new Dimension(800, 600));
        JOptionPane.showMessageDialog((ControlWindow) App.controller.control, scrollPane, "Paste Info", JOptionPane.PLAIN_MESSAGE);
        //JOptionPane;
        String info = textArea.getText();*/
	}

}
