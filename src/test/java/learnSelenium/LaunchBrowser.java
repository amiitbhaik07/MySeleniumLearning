package learnSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class LaunchBrowser {
	@Test
	public void runBrowser() throws Exception
	{
		System.out.println("Running test runBrowser");
		System.setProperty("webdriver.firefox.marionette", "${basedir}\\lib\\geckodriver.exe");
		System.out.println("Set system property");
		WebDriver driver = new FirefoxDriver();
		System.out.println("Launched browser");
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in");
		System.out.println("Done");
		System.out.println("_____________________________________________________________________________________" + driver.getTitle());
	}

}
