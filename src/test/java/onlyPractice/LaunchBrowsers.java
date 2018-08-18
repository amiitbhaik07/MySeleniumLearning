package onlyPractice;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LaunchBrowsers 
{
	final String url = "http://10.65.145.133:4444/wd/hub";
	
	public static void main(String args[]) throws Exception
	{	
		LaunchBrowsers l = new LaunchBrowsers();
		//Launch Browsers on Local Machine
		//WebDriver driver = l.launchBrowser("phantomjs");
		//WebDriver driver = l.launchBrowser("firefox");
		//WebDriver driver = l.launchBrowser("chrome");
		//WebDriver driver = l.launchBrowser("iexplore");
		//WebDriver driver = l.launchBrowser("htmlunit");
		
		//Launch Browsers on Grid
		WebDriver driver = l.launchBrowser("phantomjs","5",Platform.WINDOWS);
		//WebDriver driver = l.launchBrowser("firefox","37",Platform.WINDOWS);
		//WebDriver driver = l.launchBrowser("chrome","57",Platform.WINDOWS);
		//WebDriver driver = l.launchBrowser("iexplore","9",Platform.WINDOWS);
		
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in");
		Thread.sleep(3000);
		String timeStamp = new SimpleDateFormat("dd_MMM_HH_mm_ss").format(new Date());
		FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File("C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\Screenshots\\"+timeStamp+".jpg"));
		System.out.println("Done");
		Thread.sleep(5000);
		driver.quit();
		System.out.println("Success");
	}
	
	
	WebDriver launchBrowser(String browserName) throws Exception
	{
		if(browserName.trim().equalsIgnoreCase("phantomjs"))
		{
			System.setProperty("phantomjs.binary.path","C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\BrowserDrivers\\phantomjs.exe");
			System.out.println("Launching Phantomjs Local browser");
			return new PhantomJSDriver();
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
		else if(browserName.trim().equalsIgnoreCase("htmlunit"))
		{
			//System.setProperty("webdriver.ie.driver","C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\BrowserDrivers\\IEDriverServer.exe");
			System.out.println("Launching HtmlUnit Local browser");
			return new HtmlUnitDriver();
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
	
	
	
	

}
