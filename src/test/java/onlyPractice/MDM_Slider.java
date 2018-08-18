package onlyPractice;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MDM_Slider
{
	public static void main(String args[]) throws Exception
	{
		System.setProperty("webdriver.firefox.marionette", "C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\BrowserDrivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://mdmui-cstg.cloudapps.cisco.com/mdmui/rest/proxyHome");
		
		FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File("C:\\Users\\abhaik\\SeleniumWorks1\\LearnSelenium\\Screenshots\\sliderControls_1.jpg"));
		
		WebDriverWait wait = new WebDriverWait(driver,150);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='userInput']"))).sendKeys("meghgupt");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='passwordInput']"))).sendKeys("Prisha#2017");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='login-button']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='proxyId']"))).sendKeys("duabhish");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();
		System.out.println("1");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[starts-with(@kdfid,'icon-preview-') and @kdfapp='mdmUI' and @kdfpage='myDeals']"))).click();
		System.out.println("2");
		WebElement e1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'ps-active-y')]/div[@class='ps-scrollbar-y-rail'][2]/div")));
		System.out.println("3");
		Actions actions = new Actions(driver);
		actions.moveToElement(e1).clickAndHold().moveByOffset(0, 120).release().build().perform();
		System.out.println("4");
		
		
		
		
		FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File("C:\\Users\\abhaik\\SeleniumWorks1\\LearnSelenium\\Screenshots\\sliderControls_2.jpg"));
		
		
	}
}
