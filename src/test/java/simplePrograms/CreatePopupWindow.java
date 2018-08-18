package simplePrograms;

import javax.swing.JOptionPane;

public class CreatePopupWindow 
{
	public void createPopup() throws Exception
	{
		JOptionPane.showConfirmDialog(null, "Processing");
		Thread.sleep(3000);
		JOptionPane.showMessageDialog(null, "Hello Pop-up" , "InfoBox: " + "Well Done", JOptionPane.INFORMATION_MESSAGE);
	}

}
