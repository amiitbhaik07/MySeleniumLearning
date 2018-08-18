package learnSelenium;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class _12_2_Automate_SliderControls
{
	public static void main(String args[]) throws Exception
	{
		System.setProperty("webdriver.firefox.marionette", "C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\BrowserDrivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://jqueryui.com/slider/");
		
		FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File("C:\\Users\\abhaik\\SeleniumWorks1\\LearnSelenium\\Screenshots\\sliderControls_1.jpg"));
		
		WebDriverWait wait = new WebDriverWait(driver,150);
		driver.switchTo().frame(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='demo-frame']"))));
		
		WebElement slider = driver.findElement(By.xpath("//div[@id='slider']"));
		WebElement sliderBox = driver.findElement(By.xpath("//div[@id='slider']/span"));
		int width = slider.getSize().width;
		
		Actions actions = new Actions(driver);
		actions.clickAndHold(sliderBox).moveByOffset(120, 0).release().build().perform();
		Thread.sleep(5000);
		
		FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File("C:\\Users\\abhaik\\SeleniumWorks1\\LearnSelenium\\Screenshots\\sliderControls_2.jpg"));
		
		
	}
}
