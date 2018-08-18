package learnSelenium;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class _04_Screenshots
{
	public static void main(String args[]) throws Exception
	{
		String filePath = "C:\\Users\\abhaik\\SeleniumWorks1\\LearnSelenium\\Screenshots\\";
		System.setProperty("webdriver.firefox.marionette", "C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\BrowserDrivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		System.out.println("Browser Launched");
		WebDriverWait wait = new WebDriverWait(driver,150);
		driver.get("https://www.google.co.in");
		Thread.sleep(10000);
		FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File(filePath+"123.jpg"));
		Thread.sleep(15000);
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		/*System.setProperty("phantomjs.binary.path", "C:\\Program Files\\phantomjs\\bin\\phantomjs.exe");
		System.out.println("Launching PhantomJS browser");
		WebDriver driver = new PhantomJSDriver();
		driver.manage().window().maximize();
		System.out.println("Launched PhantomJS browser");
		driver.get("https://www.google.co.in");
		Thread.sleep(2000);		
		//driver.findElement(By.className("blueBtn")).click();		
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("dd_MMM_HH_mm_ss").format(new Date());
		FileUtils.copyFile(scr, new File(filePath + "phantomjs_" + timeStamp + ".jpg"));		
		WebDriverWait wait = new WebDriverWait(driver,300);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='blueBtn']"))).click();
		//One step to take and save screenshot:
		FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File("C:\\Users\\abhaik\\SeleniumWorks1\\learnmaven3\\Screenshots\\phantomjsScreenshot.jpg"));
		Thread.sleep(20000);		
		driver.quit();*/
	}
	
	
	@Test
	public void ss1() throws Exception
	{
		String filePath = "C:\\Users\\abhaik\\SeleniumWorks1\\learnmaven3\\Screenshots\\";		
		System.setProperty("phantomjs.binary.path","C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\BrowserDrivers\\phantomjs.exe");
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://10.65.145.34:4444/wd/hub"),DesiredCapabilities.phantomjs());
		System.out.println("Browser Launched");
		WebDriverWait wait = new WebDriverWait(driver,150);
		//driver.manage().window().maximize();
		driver.get("https://www.google.co.in");
		Thread.sleep(1000);
		FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File(filePath+"_ss1.jpg"));
		Thread.sleep(15000);
		driver.quit();
	}
	
	@Test
	public void ss2() throws Exception
	{
		String filePath = "C:\\Users\\abhaik\\SeleniumWorks1\\learnmaven3\\Screenshots\\";		
		System.setProperty("phantomjs.binary.path","C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\BrowserDrivers\\phantomjs.exe");
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://10.65.145.34:4444/wd/hub"),DesiredCapabilities.phantomjs());
		System.out.println("Browser Launched");
		WebDriverWait wait = new WebDriverWait(driver,150);
		//driver.manage().window().maximize();
		driver.get("https://www.google.co.in");
		Thread.sleep(1000);
		FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File(filePath+"_ss2.jpg"));
		Thread.sleep(10000);
		driver.quit();
	}
	
	@Test
	public void ss3() throws Exception
	{
		String filePath = "C:\\Users\\abhaik\\SeleniumWorks1\\learnmaven3\\Screenshots\\";		
		System.setProperty("phantomjs.binary.path","C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\BrowserDrivers\\phantomjs.exe");
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://10.65.145.34:4444/wd/hub"),DesiredCapabilities.phantomjs());
		System.out.println("Browser Launched");
		WebDriverWait wait = new WebDriverWait(driver,150);
		//driver.manage().window().maximize();
		driver.get("https://www.google.co.in");
		Thread.sleep(1000);
		FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File(filePath+"_ss3.jpg"));
		Thread.sleep(5000);
		driver.quit();
	}
	
	@Test
	public void ss4() throws Exception
	{
		String filePath = "C:\\Users\\abhaik\\SeleniumWorks1\\learnmaven3\\Screenshots\\";		
		System.setProperty("phantomjs.binary.path","C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\BrowserDrivers\\phantomjs.exe");
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://10.65.145.34:4444/wd/hub"),DesiredCapabilities.phantomjs());
		System.out.println("Browser Launched");
		WebDriverWait wait = new WebDriverWait(driver,150);
		//driver.manage().window().maximize();
		driver.get("https://www.google.co.in");
		Thread.sleep(1000);
		FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File(filePath+"_ss4.jpg"));
		Thread.sleep(20000);
		driver.quit();
	}
	
	@Test
	public void ss5() throws Exception
	{
		String filePath = "C:\\Users\\abhaik\\SeleniumWorks1\\learnmaven3\\Screenshots\\";		
		System.setProperty("phantomjs.binary.path","C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\BrowserDrivers\\phantomjs.exe");
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://10.65.145.34:4444/wd/hub"),DesiredCapabilities.phantomjs());
		System.out.println("Browser Launched");
		WebDriverWait wait = new WebDriverWait(driver,150);
		//driver.manage().window().maximize();
		driver.get("https://www.google.co.in");
		Thread.sleep(1000);
		FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File(filePath+"_ss5.jpg"));
		Thread.sleep(25000);
		driver.quit();
	}
	
	@Test
	public void ss6() throws Exception
	{
		String filePath = "C:\\Users\\abhaik\\SeleniumWorks1\\learnmaven3\\Screenshots\\";		
		System.setProperty("phantomjs.binary.path","C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\BrowserDrivers\\phantomjs.exe");
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://10.65.145.34:4444/wd/hub"),DesiredCapabilities.phantomjs());
		System.out.println("Browser Launched");
		WebDriverWait wait = new WebDriverWait(driver,150);
		//driver.manage().window().maximize();
		driver.get("https://www.google.co.in");
		Thread.sleep(1000);
		FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File(filePath+"_ss6.jpg"));
		Thread.sleep(30000);
		driver.quit();
	}

	@Test
	public void ss7() throws Exception
	{
		String filePath = "C:\\Users\\abhaik\\SeleniumWorks1\\learnmaven3\\Screenshots\\";		
		System.setProperty("phantomjs.binary.path","C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\BrowserDrivers\\phantomjs.exe");
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://10.65.145.34:4444/wd/hub"),DesiredCapabilities.phantomjs());
		System.out.println("Browser Launched");
		WebDriverWait wait = new WebDriverWait(driver,150);
		//driver.manage().window().maximize();
		driver.get("https://www.google.co.in");
		Thread.sleep(1000);
		FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File(filePath+"_ss7.jpg"));
		Thread.sleep(15000);
		driver.quit();
	}
	
	@Test
	public void ss8() throws Exception
	{
		String filePath = "C:\\Users\\abhaik\\SeleniumWorks1\\learnmaven3\\Screenshots\\";		
		System.setProperty("phantomjs.binary.path","C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\BrowserDrivers\\phantomjs.exe");
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://10.65.145.34:4444/wd/hub"),DesiredCapabilities.phantomjs());
		System.out.println("Browser Launched");
		WebDriverWait wait = new WebDriverWait(driver,150);
		//driver.manage().window().maximize();
		driver.get("https://www.google.co.in");
		Thread.sleep(1000);
		FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File(filePath+"_ss8.jpg"));
		Thread.sleep(35000);
		driver.quit();
	}
	
	@Test
	public void ss9() throws Exception
	{
		String filePath = "C:\\Users\\abhaik\\SeleniumWorks1\\learnmaven3\\Screenshots\\";		
		System.setProperty("phantomjs.binary.path","C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\BrowserDrivers\\phantomjs.exe");
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://10.65.145.34:4444/wd/hub"),DesiredCapabilities.phantomjs());
		System.out.println("Browser Launched");
		WebDriverWait wait = new WebDriverWait(driver,150);
		//driver.manage().window().maximize();
		driver.get("https://www.google.co.in");
		Thread.sleep(1000);
		FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File(filePath+"_ss9.jpg"));
		Thread.sleep(5000);
		driver.quit();
	}
	
	@Test
	public void ss10() throws Exception
	{
		String filePath = "C:\\Users\\abhaik\\SeleniumWorks1\\learnmaven3\\Screenshots\\";		
		System.setProperty("phantomjs.binary.path","C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\BrowserDrivers\\phantomjs.exe");
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://10.65.145.34:4444/wd/hub"),DesiredCapabilities.phantomjs());
		System.out.println("Browser Launched");
		WebDriverWait wait = new WebDriverWait(driver,150);
		//driver.manage().window().maximize();
		driver.get("https://www.google.co.in");
		Thread.sleep(1000);
		FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File(filePath+"_ss10.jpg"));
		Thread.sleep(1000);
		driver.quit();
	}
}
