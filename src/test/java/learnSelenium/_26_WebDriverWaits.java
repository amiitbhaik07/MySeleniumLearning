package learnSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class _26_WebDriverWaits 
{
	public static void main(String args[]) throws Exception
	{
		WebDriver driver = new FirefoxDriver();
		
		
		//Implicitly Wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		//Fluent Wait
		Wait wait = new FluentWait(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		Wait wait2 = new FluentWait(driver)
								.withTimeout(30, TimeUnit.SECONDS)
								.pollingEvery(5, TimeUnit.SECONDS)
								.ignoring(NoSuchElementException.class);
		
		
		//Explicit Wait
		WebDriverWait wait1 = new WebDriverWait(driver,150);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
		
	}

}
