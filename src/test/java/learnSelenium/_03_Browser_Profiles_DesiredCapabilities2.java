package learnSelenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.FileDetector;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class _03_Browser_Profiles_DesiredCapabilities2
{
	public static void main(String[] args) throws Exception 
	{
		
		System.out.println(System.getProperty("java.io.tmpdir") );
			
		//System.setProperty("webdriver.firefox.marionette", "C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\BrowserDrivers\\geckodriver.exe");
		
		
		
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.manager.showWhenStarting", false); 
		//profile.setPreference("browser.download.dir", "C:\\testDownload\\");
		profile.setPreference("browser.download.dir", "\\\\10.65.193.16\\share1");
		//profile.setPreference("browser.download.dir", System.getProperty("java.io.tmpdir"));
		profile.setPreference("browser.helperApps.neverAsk.openFile", "application/csv, text/csv, text/plain,application/octet-stream doc xls pdf txt");
		profile.setPreference("browser.helperApps.neverAsk.openFile", "text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
		//profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/csv, text/csv, text/plain,application/octet-stream doc xls xlsx pdf txt");
		profile.setPreference("browser.helperApps.alwaysAsk.force", false);
		profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
		profile.setPreference("browser.download.manager.focusWhenStarting", false);
		profile.setPreference("browser.download.manager.useWindow", false);
		profile.setPreference("browser.download.manager.showAlertOnComplete", false);
		profile.setPreference("browser.download.manager.closeWhenDone", false);
		
		DesiredCapabilities cap = DesiredCapabilities.firefox();
		//cap.setCapability("", "");
		//cap.setCapability(CapabilityType.BROWSER_VERSION, 37);
		cap.setCapability(FirefoxDriver.PROFILE, profile);
		
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://10.65.193.16:4444/wd/hub"), cap);
				
		driver.setFileDetector(new LocalFileDetector());
		
		//driver.setFileDetector(new LocalFileDetector());
		//WebElement El = driver.findElement(By.id("'fileUploadField'"));
		//((RemoteWebElement) El ).setFileDetector(new LocalFileDetector()); 
		//El.sendKeys("c:\\temp\\test.txt");
		
		//WebDriver driver = new FirefoxDriver(profile);
		WebDriverWait wait = new WebDriverWait(driver,150);		
		
		driver.get("https://pep-stage.cloudapps.cisco.com/pep/login");
		System.out.println("Executing...");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userInput"))).sendKeys("mnadaraj");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwordInput"))).sendKeys("$riR8ngab");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button"))).click();
		new Actions(driver).moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a/span")))).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span/a/span"))).click();
		
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='text-center']/button"))).click();
		Thread.sleep(5000);
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//img[@alt='loading GIF']")));
		System.out.println("Checking");
		
		WebElement w = driver.findElement(By.xpath("//div[@class='text-center']/button"));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='text-center']/button"))).click();
		System.out.println("Downloaded successfully");
		Thread.sleep(8000);
		
		//String nodeName = "";
		
		FileInputStream fis = new FileInputStream(new File("C:\\share1\\DeniedPartnerList.xlsx"));
		
		
		XSSFWorkbook wbk = new XSSFWorkbook();
		fis.close();
		
		XSSFSheet s = wbk.getSheet("DeniedPartnerList");
		
		System.out.println(s.getRow(0).getCell(0).getStringCellValue());
		
		System.out.println("Success");
		Thread.sleep(60000);
		driver.quit();
		
	}


}
