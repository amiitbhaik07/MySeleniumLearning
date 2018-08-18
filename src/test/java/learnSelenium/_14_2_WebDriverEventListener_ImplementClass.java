package learnSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class _14_2_WebDriverEventListener_ImplementClass 
{	
	static _14_1_WebDriverListener overrideClass = new _14_1_WebDriverListener();
	public static void main(String args[]) throws Exception
	{
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\BrowserDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		EventFiringWebDriver driverEvent = _14_2_WebDriverEventListener_ImplementClass.initiateWebDriverWithListener(driver);
		
		System.out.println("WebDriverEventListener implemented and EventFiringWebDriver doing its job :");
		driverEvent.get("https://www.google.co.in");
		driver.get("http://gmail.com");
		driverEvent.get("http://outlook.com");
		driverEvent.navigate().back();	
		
		System.out.println("Unregistering EventFiringWebDriver");
		driver = _14_2_WebDriverEventListener_ImplementClass.unregister(driverEvent);
		System.out.println("Unregistered... No logs will get displayed");
		driver.get("https://www.google.co.in");
		driver.get("http://gmail.com");
		driver.get("http://outlook.com");
		driver.navigate().back();
		System.out.println("Success");
	}
	
	public static EventFiringWebDriver initiateWebDriverWithListener(WebDriver driver)
	{
		EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
		_14_1_WebDriverListener overrideClass = new _14_1_WebDriverListener();
		eventFiringWebDriver.register(overrideClass);
		
		return eventFiringWebDriver;	
		
		//return new EventFiringWebDriver(driver).register(overrideClass);
	}
	
	public static WebDriver unregister(EventFiringWebDriver driver)
	{
		return driver.unregister(overrideClass);
	}
}
