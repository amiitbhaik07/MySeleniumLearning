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


public class _12_1_Javascript
{
	public static void main(String args[]) throws InterruptedException
	{
		System.setProperty("webdriver.firefox.marionette", "C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\BrowserDrivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.javatpoint.com/java-tutorial");
		WebDriverWait wait = new WebDriverWait(driver, 150);
		WebElement e = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//a[text()='What is the difference between JRE and JVM ?']"))));
		
		WebElement e1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//h4[text()='4) Mobile Application']"))));
		WebElement e2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//h4[text()='1) Standalone Application']"))));
		WebElement e3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//h2[text()='Java Example']"))));
		e3.click();
		
		
		//Type text using javascript executor :
		
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		 jse.executeScript("document.getElementById('arguments[0]').value = 'Ripon Al Wasim';", driver.findElement(By.xpath(""))); 

		
		
		//1) By Actions Class
		/*new Actions(driver).moveToElement(e).build().perform();
		Thread.sleep(2000);
		new Actions(driver).moveToElement(e1).build().perform();
		Thread.sleep(2000);
		new Actions(driver).moveToElement(e2).build().perform();
		Thread.sleep(2000);
		new Actions(driver).moveToElement(e3).build().perform();
		Thread.sleep(2000);
		System.out.println("Done");*/
		
		
		//new Actions(driver).moveToElement(e3).clickAndHold().moveToElement(e).release().build().perform();
		
		//new Actions(driver).sendKeys(Keys.chord(Keys.CONTROL,"a")).sendKeys(Keys.chord(Keys.CONTROL,"c")).build().perform();
		new Actions(driver).sendKeys(Keys.chord(Keys.BACK_SPACE, "d")).build().perform();
		Thread.sleep(1000);
		new Actions(driver).sendKeys(Keys.SPACE).build().perform();
		Thread.sleep(1000);		
		new Actions(driver).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(1000);
		new Actions(driver).sendKeys(Keys.ARROW_RIGHT).build().perform();
		Thread.sleep(1000);
		new Actions(driver).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(1000);
		new Actions(driver).sendKeys("MaintenanceAutomation").sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(1000);
	
		

		
		
		//2) By JavaScript Executor
		//JavascriptExecutor javascript = (JavascriptExecutor)driver;
		
		//By Using WebElements
		/*
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", e,e1,e2,e3);
		Thread.sleep(2000);
		((JavascriptExecutor)driver).executeScript("arguments[1].scrollIntoView(true)", e,e1,e2,e3);
		Thread.sleep(2000);
		((JavascriptExecutor)driver).executeScript("arguments[2].scrollIntoView(true)", e,e1,e2,e3);
		Thread.sleep(2000);
		((JavascriptExecutor)driver).executeScript("arguments[3].scrollIntoView(true)", e,e1,e2,e3);
		Thread.sleep(2000);
		*/
		
		
		
		
		
		//By using No. of Pixels : Y=horizontal, X=Vertical
		/*javascript.executeScript("window.scrollBy(0,1400)", "");
		Thread.sleep(2000);
		javascript.executeScript("window.scrollBy(0,-500)", "");
		Thread.sleep(2000);
		javascript.executeScript("window.scrollBy(0,1000)", "");
		Thread.sleep(2000);
		javascript.executeScript("window.scrollBy(0,-500)", "");
		Thread.sleep(2000);
		javascript.executeScript("window.scrollBy(0,1000)", "");
		Thread.sleep(2000);
		javascript.executeScript("window.scrollBy(0,10400)", "");
		Thread.sleep(2000);*/
		
		
		
		//Scroll down to bottom of the page.  
		//javascript.executeScript("window.scrollTo(0, document.body.scrollHeight)", "");  
	     
		
		System.out.println("Done");
	}
}
