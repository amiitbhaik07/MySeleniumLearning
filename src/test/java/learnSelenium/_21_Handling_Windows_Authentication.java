package learnSelenium;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class _21_Handling_Windows_Authentication 
{
	public static void main(String args[]) throws Exception
	{
		System.setProperty("webdriver.firefox.marionette","C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\BrowserDrivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();		
		
		
		//Selenium 
		/*driver.get("http://www.engprod-charter.net");
		WebDriverWait wait = new WebDriverWait(driver,60);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.authenticateUsing(new UserAndPassword("user","password"));*/
		
		
		//driver.navigate().to("http://user:pass@www.engprod-charter.net");
		
		
		driver.get("chrome://restclient/content/restclient.html");
		
		
		
		
		
		
	}
}
