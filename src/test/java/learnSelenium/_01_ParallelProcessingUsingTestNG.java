package learnSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _01_ParallelProcessingUsingTestNG {

	WebDriver driver;
	
	@BeforeClass
	public void abc()
	{
		System.setProperty("webdriver.firefox.marionette","C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\BrowserDrivers\\geckodriver.exe");
	}
	
	//WebDriver driver = new FirefoxDriver();
	@BeforeMethod
	public void asdfg()
	{
		try
		{
			driver = new FirefoxDriver();
			//WebElement w = driver.findElement(By.);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	@Test
	public void test1() throws Exception
	{
		
		try
		{
			Thread.sleep(4000);
			System.out.println("test1");
			driver.get("https://www.google.co.in");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void test2() throws Exception
	{
		
		try
		{
			Thread.sleep(4000);
			System.out.println("test2");
			driver.get("https://www.ultimatix.net");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void test3() throws Exception
	{
		
		try
		{
			Thread.sleep(4000);
			System.out.println("test3");
			driver.get("https://www.gmail.com");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void test4() throws Exception
	{
		
		try
		{
			Thread.sleep(4000);
			System.out.println("test4");
			driver.get("https://www.irctc.co.in");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

}
