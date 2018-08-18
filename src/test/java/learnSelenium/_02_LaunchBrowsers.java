package learnSelenium;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class _02_LaunchBrowsers 
{	
	final String url = "http://10.65.145.133:4444/wd/hub";	
	public static void main(String args[]) throws Exception
	{	
		_02_LaunchBrowsers l = new _02_LaunchBrowsers();
		//Launch Browsers on Local Machine
		//WebDriver driver = l.launchBrowser("phantomjs");
		//WebDriver driver = l.launchBrowser("firefox");
		//WebDriver driver = l.launchBrowser("chrome");
		//WebDriver driver = l.launchBrowser("iexplore");
		WebDriver driver = l.launchBrowser("htmlunit");
		
		//Launch Browsers on Grid
		//WebDriver driver = l.launchBrowser("phantomjs","5",Platform.WINDOWS);
		//WebDriver driver = l.launchBrowser("firefox","37",Platform.WINDOWS);
		driver.get("https://www.google.co.in");
		
		/*driver.manage().window().maximize();		
		Thread.sleep(3000);
		String timeStamp = new SimpleDateFormat("dd_MMM_HH_mm_ss").format(new Date());
		FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File("C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\Screenshots\\"+timeStamp+".jpg"));
		System.out.println("Done");
		Thread.sleep(5000);
		driver.quit();
		System.out.println("Success");*/
		
		
		String pagetitle = driver.getTitle();
		System.out.println("Page title before search : "+pagetitle);
		WebElement Searchbox = driver.findElement(By.xpath("//input[@name='q']"));
		Searchbox.sendKeys("Hello World");
		Searchbox.submit();
		pagetitle = driver.getTitle();
		System.out.println("Page title after search : "+pagetitle);
		List<WebElement> allSearchResults=driver.findElements(By.cssSelector("ol li h3>a"));
		for(WebElement eachResult : allSearchResults)
		{
			  System.out.println("Title : "+eachResult.getText()+", Link : "+eachResult.getAttribute("href"));
		}
		
		
		
	}
	
	
	WebDriver launchBrowser(String browserName) throws Exception
	{
		if(browserName.trim().equalsIgnoreCase("phantomjs"))
		{
			System.setProperty("phantomjs.binary.path","C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\BrowserDrivers\\phantomjs.exe");
			System.out.println("Launching Phantomjs Local browser");
			return new PhantomJSDriver();
		}
		else if(browserName.trim().equalsIgnoreCase("htmlunit"))
		{
			//System.setProperty("webdriver.firefox.marionette","C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\BrowserDrivers\\geckodriver.exe");
			System.out.println("Launching HTML-Unit Local browser");
			return new HtmlUnitDriver();
		}
		else if(browserName.trim().equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.firefox.marionette","C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\BrowserDrivers\\geckodriver.exe");
			System.out.println("Launching Firefox Local browser");
			return new FirefoxDriver();
		}
		else if(browserName.trim().equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\BrowserDrivers\\chromedriver.exe");
			System.out.println("Launching Chrome Local browser");
			return new ChromeDriver();
		}
		else if(browserName.trim().equalsIgnoreCase("iexplore"))
		{
			System.setProperty("webdriver.ie.driver","C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\BrowserDrivers\\IEDriverServer.exe");
			System.out.println("Launching IE Local browser");
			return new InternetExplorerDriver();
		}
		else
		{
			throw new Exception("Browser Name '"+browserName.trim()+"' not defined in system");
		}
	}
	
	
	WebDriver launchBrowser(String browserName, String version, Platform platform) throws Exception 
	{	
		DesiredCapabilities cap;
		if(browserName.trim().equalsIgnoreCase("phantomjs"))
		{
			cap=DesiredCapabilities.phantomjs();
			//cap.setVersion(version);
			cap.setPlatform(platform);
			cap.setBrowserName(browserName.trim());
			cap.setCapability(CapabilityType.BROWSER_VERSION, version.trim());
			System.out.println("Launching Phantomjs Grid browser");
			return new RemoteWebDriver(new URL(url),cap);
		}
		else if(browserName.trim().equalsIgnoreCase("firefox"))
		{
			cap=DesiredCapabilities.firefox();
			//cap.setVersion(version);
			cap.setPlatform(platform);
			cap.setBrowserName(browserName.trim());
			cap.setCapability(CapabilityType.BROWSER_VERSION, version.trim());
			System.out.println("Launching Firefox Grid browser");
			return new RemoteWebDriver(new URL(url),cap);
		}
		else if(browserName.trim().equalsIgnoreCase("chrome"))
		{
			cap=DesiredCapabilities.chrome();
			//cap.setVersion(version);
			cap.setPlatform(platform);
			cap.setBrowserName(browserName.trim());
			cap.setCapability(CapabilityType.BROWSER_VERSION, version.trim());
			System.out.println("Launching Chrome Grid browser");
			return new RemoteWebDriver(new URL(url),cap);
		}
		else if(browserName.trim().equalsIgnoreCase("iexplore"))
		{
			cap=DesiredCapabilities.internetExplorer();
			//cap.setVersion(version);
			cap.setPlatform(platform);
			cap.setBrowserName(browserName.trim());
			cap.setCapability(CapabilityType.BROWSER_VERSION, version.trim());
			System.out.println("Launching IE Grid browser");
			return new RemoteWebDriver(new URL(url),cap);
		}
		else
		{
			throw new Exception("Browser Name '"+browserName+"' not defined in system");
		}
	}
	
	@Test
	public void phantomJs() throws Exception
	{
		//Download PhantomJS zip file from "http://phantomjs.org/download.html" and extract it in C:/Program Files/; and give that exe path below
		//System.setProperty("phantomjs.binary.path", "C:\\Program Files\\phantomjs\\bin\\phantomjs.exe");
		System.setProperty("phantomjs.binary.path", "C:\\Users\\abhaik\\SeleniumWorks1\\learnmaven3\\lib\\phantomjs.exe");
		//System.setProperty("phantomjs.binary.path", "${basedir}\\lib\\phantomjs.exe");
		System.out.println("Launching PhantomJS browser");
		WebDriver driver = new PhantomJSDriver();
		driver.manage().window().maximize();
		System.out.println("Launched PhantomJS browser");
		driver.get("https://www.google.co.in");
		Thread.sleep(20000);		
		driver.quit();
	}
	
	
	
	//@Test
	public void firefox() throws Exception
	//public static void main1(String args[])
	{
		//Download Mozilla Mozilla GeckoDriver from "http://www.seleniumhq.org/download/"
		//Older versions of Firefox = webdriver.firefox.marionette 
		//Newer Versions of Firefox = webdriver.gecko.driver
		//Always give the exe path in system.seProperty
		System.setProperty("webdriver.firefox.marionette", "${basedir}/lib/geckodriver.exe");
		//FirefoxProfile fp = new FirefoxProfile(new File("C:\\Users\\abhaik\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\cv1ng57o.default"));
		System.out.println("Launching Firefox browser");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		System.out.println("Launched Firefox browser");
		driver.get("https://www.naukri.com/");
		WebDriverWait wait = new WebDriverWait(driver,150);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_Layer"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("eLogin"))).sendKeys("amiitbhaik07@gmail.com");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("pLogin"))).sendKeys("Amiitonoma07");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='blueBtn']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'//my.naukri.com/Profile/edit?id=&altresid=')]"))).click();
		
	}
	
	
	//@Test
	public void chrome() throws Exception
	{
		//Download Google Chrome Driver from "http://www.seleniumhq.org/download/"
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\BrowserDrivers\\chromedriver.exe");
		System.out.println("Launching Chrome browser");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Launched Chrome browser");
		driver.get("https://www.google.co.in");
	}
	
	
	//@Test
	public void iexplore() throws Exception
	{
		System.out.println("Hello");
		System.setProperty("webdriver.ie.driver", "C:\\Users\\abhaik\\SeleniumWorks\\Jars\\Selenium Drivers\\iedriver\\IEDriverServer.exe");
		
		/*DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		cap.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);*/
		
		WebDriver driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.get("https://www.googe.co.in");
		Thread.sleep(10000);
		//driver.close();
	}
}
