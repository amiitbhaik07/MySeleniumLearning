package learnSelenium;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class _13_AsciiCodes 
{
	public static void main(String args[]) throws Exception
	{
		//System.out.println((int)'A');
		
		//Ascii to Char :
		//char a = (char)65;
		//System.out.println(a);
		char a;
		
		XSSFWorkbook w = new XSSFWorkbook();
		XSSFSheet s = w.createSheet("ASCII Codes");
		
		for(int i=0; i<=255; i++)
		{
			XSSFRow row = s.createRow(i);
			System.out.print(i);
			row.createCell(0).setCellValue(i);
			System.out.print("\t");
			a = (char)i;
			
			System.out.print(a);
			row.createCell(2).setCellValue(""+\u0061);
			
			System.out.println();
		}
		
		FileOutputStream fout = new FileOutputStream(new File("C:\\AsciiCodes.xlsx"));
		w.write(fout);
		fout.close();
		System.out.println("success");
		
		
		
		System.exit(0);
		System.setProperty("webdriver.firefox.marionette", "C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\BrowserDrivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.co.in");
		WebDriverWait wait = new WebDriverWait(driver,150);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='lst-ib']"))).click();
		Thread.sleep(1000);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='lst-ib']"))).sendKeys("\u0061");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='lst-ib']"))).sendKeys("\u21EA");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='lst-ib']"))).sendKeys("a");
	}

}
