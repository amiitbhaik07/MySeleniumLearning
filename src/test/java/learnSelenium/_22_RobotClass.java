package learnSelenium;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;

public class _22_RobotClass 
{
	public static void main(String args[]) throws Exception
	{
		Robot robot = new Robot();
		/*for(int i=0; i<10; i++)
		{
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(500);
		}*/
		
		for(int i=0; i<900; i++)
		{
			robot.mouseMove(i, i);
			Thread.sleep(50);
		}
		
		
		
		
		
	}

}
