package learnSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class _23_LearnSelectClass 
{
	public static void main(String args[])
	{
		WebDriver driver = new FirefoxDriver();
		Select select = new Select(driver.findElement(By.xpath("//select[bjdsafjds]")));
		List allOptions = select.getOptions();
	}

}
