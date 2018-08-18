package onlyPractice;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LearnDependentXPaths 
{
	public static void main(String argsp[]) throws Exception
	{
		System.out.println("Hello");
		System.setProperty("webdriver.firefox.marionette", "./geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://dipr-stage1.cloudapps.cisco.com/WWSF/dipr/Login.do");
		
		String dipr_username = "//*[@id='userInput']";
		String dipr_password="//*[@name='password']";
		String dipr_loginButton=	"//*[@id='login-button']";
		
		driver.findElement(By.xpath(dipr_username)).sendKeys("mnadaraj");
		driver.findElement(By.xpath(dipr_password)).sendKeys("$riR8ngac");
		driver.findElement(By.xpath(dipr_loginButton)).click();
		
		driver.switchTo().frame(driver.findElement(By.id("mainFrame")));
		
		
		WebElement table = driver.findElement(By.xpath("//div[@id='treeboxbox_tree']/descendant::tbody"));
		
		//WebElement table = driver.findElement(By.xpath("//div[@id='treeboxbox_tree']/descendant::tbody/tr[*]/descendant::td"));

		List<WebElement> allRows = table.findElements(By.xpath("./tr"));
		
		
		//driver.findElement(By.xpath("//div[@id='treeboxbox_tree']/descendant::tbody/tr[2]/descendant::img")).click();;
		
		
		
		System.out.println("Size is : "+allRows.size());
		
		
		int i=1;
		for(WebElement w :  allRows)
		{
			if(i==1){
				i++;
				continue;
			}
			System.out.println("Element " + w.toString());
			
			WebElement a = w.findElement(By.xpath("./descendant::img"));
			
			System.out.println("___________" + a.toString());
			
			a.click();
			Thread.sleep(1000);
		}
	}

}
