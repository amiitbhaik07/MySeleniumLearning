package seleniumGrid;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;

public class RemoteFileSelection {
	
	public static void main(String args[])
	{
		WebDriver driver = new FirefoxDriver();
		WebElement El = driver.findElement(By.id("'fileUploadField'"));
		((RemoteWebElement) El ).setFileDetector(new LocalFileDetector()); 
		El.sendKeys("c:\\temp\\test.txt");
		
		RemoteWebElement r = (RemoteWebElement) driver.findElement(By.id(""));
		
	}

}
