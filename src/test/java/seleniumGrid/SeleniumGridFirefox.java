package seleniumGrid;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumGridFirefox
{
	public static void main(String[] args) throws Exception
	{
		
		/*
		DesiredCapabilities capFirefox = null;		
		capFirefox = DesiredCapabilities.firefox();
		capFirefox.setBrowserName("firefox");
		//capFirefox.setVersion("37");
		capFirefox.setPlatform(Platform.WINDOWS);
		
		DesiredCapabilities capChrome = null;
		capChrome=DesiredCapabilities.chrome();
		capChrome.setBrowserName("chrome");
		capChrome.setVersion("56");
		capChrome.setPlatform(Platform.WINDOWS);
		
		DesiredCapabilities capIE = null;
		capIE=DesiredCapabilities.internetExplorer();
		capIE.setBrowserName("iexplorer");
		capIE.setVersion("11");
		capIE.setPlatform(Platform.WINDOWS);*/
		
		/*File file = new File("C:\\Program Files\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");	
	    System.setProperty("phantomjs.binary.path", file.getAbsolutePath());	
	    WebDriver driver = new PhantomJSDriver();
	    driver.get("http://www.google.com");
	    WebElement element = driver.findElement(By.name("q"));	
	    element.sendKeys("Guru99");					
	    element.submit();         			
	    System.out.println("Page title is: " + driver.getTitle());	*/	
		
		
		DesiredCapabilities cap = DesiredCapabilities.phantomjs();
		cap.setBrowserName("phantomjs");
		cap.setVersion("2");
		cap.setPlatform(Platform.WINDOWS);
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://10.65.145.45:4444/wd/hub"), cap);
		
		
		
		driver.get("http://www.google.com");
	    WebElement element = driver.findElement(By.name("q"));	
	    element.sendKeys("Guru99");					
	    element.submit();         			
	    System.out.println("Page title is: " + driver.getTitle());	    
	    FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File("C:\\PhantomJSScreenshots\\screenshot_1.jpg"));
		System.out.println("Success");		
		Thread.sleep(30000);
		
		
		driver.quit();
		
		
		
		
		/*
		//RemoteWebDriver chrome = new RemoteWebDriver(new URL("http://10.65.145.35:4444/wd/hub"), capChrome);
		
		//RemoteWebDriver firefox = new RemoteWebDriver(new URL("http://10.65.145.35:4444/wd/hub"), capFirefox);
		//firefox.get("https://www.google.co.in");
		
		RemoteWebDriver ie = new RemoteWebDriver(new URL("http://10.65.145.35:4444/wd/hub"),capIE);
		
		Thread.sleep(10000);
		
		ie.quit();
		
		*/

	}
}

