package learnSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.FindsByClassName;
import org.openqa.selenium.internal.FindsByXPath;

public class _24_CreateOwnLocatingMechanism_implementation {
	
	public static void main(String args[]) throws Exception
	{
		_02_LaunchBrowsers b = new _02_LaunchBrowsers();
		WebDriver driver = b.launchBrowser("firefox");
		driver.get("https://www.google.co.in");
		//driver.findElement(_24_CreateOwnLocatingMechanism);
		//((FindsByClassName) context).findElementByClassName("");
		
		
	}
	
	
}


