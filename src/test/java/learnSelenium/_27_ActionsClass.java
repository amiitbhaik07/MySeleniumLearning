package learnSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class _27_ActionsClass 
{
	public static void main(String args[]) throws Exception
	{
		WebDriver driver = new FirefoxDriver();
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath(""))).build().perform();
		
		
		
		
		Select select = new Select(driver.findElement(By.xpath("")));
		select.selectByVisibleText("");
	}

}
