package learnSelenium;

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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class _03_Browser_Profiles_DesiredCapabilities
{
	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.firefox.marionette", "C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\BrowserDrivers\\geckodriver.exe");
		FirefoxProfile profile = new FirefoxProfile();
		profile.setAcceptUntrustedCertificates(true);
		profile.setPreference("browser.startup.homepage", "https://www.google.co.in");
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.dir", "C:\\testDownload\\");
		profile.setPreference("pdfjs.disabled", true); //disable the built-in PDF viewer
		profile.setPreference("browser.helperApps.alwaysAsk.force", false);
		profile.setPreference("browser.download.manager.showWhenStarting",false);
		profile.setPreference("plugin.disable_full_page_plugin_for_types", "application/pdf");
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
		WebDriver driver = new FirefoxDriver(profile);
		WebDriverWait wait = new WebDriverWait(driver,150);		
		/*driver.get("https://www.mozilla.org/en-US/foundation/documents");
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("IRS Form 872-C"))).click();*/
		
		//https://static.mozilla.com/foundation/documents/mf-ca-ct-registration-exhibit-c.pdf
		
		try
		{
			//URL url = new URL("https://static.mozilla.com/foundation/documents/mf-ca-ct-registration-exhibit-c.pdf");
			//http://opendatakit.org/wp-content/uploads/static/sample.xls
			//Scanner s = new Scanner(url.openStream());
			
			URL url = new URL("http://opendatakit.org/wp-content/uploads/static/sample.xls");
			InputStream fis = url.openStream();
			HSSFWorkbook w = new HSSFWorkbook(fis);
			fis.close();
			
			HSSFSheet sheet = w.getSheet("survey");
			
			System.out.println("Success................" + sheet.getRow(0).getCell(0).getStringCellValue());
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}


}
