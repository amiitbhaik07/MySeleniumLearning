package learnSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class _11_DragAndDrop
{
	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.firefox.marionette","C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\BrowserDrivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://demos.telerik.com/kendo-ui/dragdrop/index");
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver,90);
		
		WebElement e1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='draggable']")));
		WebElement e2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='droptarget']")));
		
		System.out.println("Got elements");
		Thread.sleep(5000);
		//Somehow this did not work:
		//new Actions(driver).dragAndDrop(e1, e2);
		
		//But this worked
		new Actions(driver).moveToElement(e1).clickAndHold().moveToElement(e2).release().build().perform();
		
		System.out.println("Done");
		
	}

}
