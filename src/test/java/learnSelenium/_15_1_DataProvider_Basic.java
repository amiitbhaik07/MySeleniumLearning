package learnSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _15_1_DataProvider_Basic
{
	//@BeforeMethod
	public void beforeMethod()
	{
		/*System.setProperty("webdriver.firefox.marionette","C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\BrowserDrivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in");*/
	}
	
	
	@DataProvider(name = "AuthenticationImp")
	public static Object[][] authentication() throws Exception
	{		
		System.out.println("Data provider run");
		return new Object[][] {{"user1","pwd1"},{"user2","pwd2"},{"user3","pwd3"}};
	}
	
	@Test(dataProvider="AuthenticationImp")
	public void test(String username, String pwd) throws Exception
	{
		System.out.println("____________________________________________________");
		System.out.println(username);
		System.out.println(pwd);
		Thread.sleep(1000);
	}
}
