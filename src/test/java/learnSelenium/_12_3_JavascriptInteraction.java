package learnSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class _12_3_JavascriptInteraction
{
	public static void main(String args[]) throws InterruptedException
	{
		System.setProperty("webdriver.firefox.marionette", "C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\BrowserDrivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.javatpoint.com/java-tutorial");
		WebDriverWait wait = new WebDriverWait(driver, 150);
		WebElement element = driver.findElement(By.id("abcd"));		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		
		
		
		//Alert
		js.executeScript("alert('hello world');");		
		
		//Click 
		js.executeScript("arguments[0].click();", element);
		
		//Refresh Browser
		js.executeScript("history.go(0)");
		
		//Get InnerText of a Webpage
		String sText =  js.executeScript("return document.documentElement.innerText;").toString();
		
		//Type text
		js.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", element, "innerHTML", "test");
		
		//Get Title of a WebPage
		String sTitle =  js.executeScript("return document.title;").toString();
		
		//Scroll Page
		js.executeScript("window.scrollBy(0,150)");
		
		
		
		
		
		//Fetch AngularJS text from UI
		
		WebElement w = null;
		try
		{
			w = driver.findElement(By.cssSelector("input[ng-model='nonXaasSimulationDetails.originalListPriceWithCurrenyCode']"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			w = driver.findElement(By.xpath("//input[@ng-model='nonXaasSimulationDetails.originalListPriceWithCurrenyCode']"));
		}
		
		try
		{
			System.out.println("1 Text is :");
			JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
	        System.out.println(javascriptExecutor.executeScript("return angular.element(arguments[0]).scope().nonXaasSimulationDetails.originalListPriceWithCurrenyCode;", w));
	        System.out.println("End text 1");
		}
		catch(Exception e){
			e.printStackTrace();
		}
				
		
		
		System.out.println("Done");
	}
}