package seleniumGrid;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.Augmenter;

public class HeadlessBrowsers {
	
	public static void main(String args[]) throws Exception
	{
		
		//HTML Unit Driver 
		
		/*
		WebDriver driver = new HtmlUnitDriver();        
	    //Navigate to Google		
		driver.get("http://www.google.com");					

		//Locate the searchbox using its name		
		WebElement element = driver.findElement(By.name("q"));	
   
		//Enter a search query		
		element.sendKeys("Guru99");
 
		//Submit the query. Webdriver searches for the form using the text input element automatically		
		//No need to locate/find the submit button		
		element.submit();			
  
		//This code will print the page title		
		System.out.println("Page title is: " + driver.getTitle());	
		driver.quit();	
		*/
		
		
		
		//Phantom JS
		File file = new File("C:\\Program Files\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");	
	    System.setProperty("phantomjs.binary.path", file.getAbsolutePath());		
	    WebDriver driver = new PhantomJSDriver();
	    driver.get("http://www.google.com");
	    WebElement element = driver.findElement(By.name("q"));	
	    element.sendKeys("Guru99");					
	    element.submit();         			
	    System.out.println("Page title is: " + driver.getTitle());	
	    
	    
	    
	    //Screenshot:
	   
       /* File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        System.out.println("File:" + srcFile);
        FileUtils.copyFile(srcFile, new File("C:\\PhantomJSScreenshots\\screenshot_2"+".png"));
        System.out.println("Done");*/
	    
	    
	    Thread.sleep(30000);
       
	    
	    
	    driver.quit();
	}

}
