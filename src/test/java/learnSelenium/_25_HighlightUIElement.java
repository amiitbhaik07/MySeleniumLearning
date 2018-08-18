package learnSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class _25_HighlightUIElement 
{
	public static void main(String args[]) throws Exception
	{
		System.setProperty("webdriver.firefox.marionette", "C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\BrowserDrivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.google.co.in");
		WebDriverWait wait = new WebDriverWait(driver,300);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		jse.executeScript("alert('hello world');");
		
		
		
		System.exit(0);
		
		
		
		
		
		
		
		//jse.executeScript("arguments[0].style.border='3px solid red'", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='btnK']"))));
		
		//jse.executeScript("arguments[0].setAttribute('style', 'color: red');", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='btnK']"))));
		
		//jse.executeScript("arguments[0].setAttribute('style', 'color: red'); arguments[0].style.border='3px solid red';", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='btnK']"))));
		
		highlightElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='btnK']"))));		
		Thread.sleep(5000);
		highlightElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='btnI']"))));
		//jse.executeScript("arguments[0].setAttribute('style', 'color: red'); arguments[0].style.border='3px solid red';", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='btnI']"))));
		Thread.sleep(5000);
		highlightElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='lst-ib']"))));
		//jse.executeScript("arguments[0].setAttribute('style', 'color: red'); arguments[0].style.border='3px solid red';", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='lst-ib']"))));
		Thread.sleep(5000);
		highlightElement(driver, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='hplogo']/div"))));
		//jse.executeScript("arguments[0].setAttribute('style', 'color: red'); arguments[0].style.border='3px solid red';", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='hplogo']/div"))));
		Thread.sleep(10000);
		
		
		
	}
	
	public static void highlightElement(WebDriver driver, WebElement element) throws Exception
	{
	    for (int i = 0; i < 2; i++) 
	    {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
	                element, "color: yellow; border: 2px solid red;");
	        Thread.sleep(200);
	        js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
	                element, "");
	    }
	}

}
