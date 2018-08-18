package learnSelenium;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Junk {
	
	public static void main(String args[])
	{
		FirefoxProfile profile = new FirefoxProfile();
		DesiredCapabilities browser =new DesiredCapabilities();
		browser = DesiredCapabilities.firefox() ;
		profile.setPreference("browser.download.folderList", 2);
	profile.setPreference("browser.download.manager.showWhenStarting", false);	
	profile.setPreference("browser.download.dir", "");
	profile.setPreference("browser.helperApps.neverAsk.openFile",
		"application/csv, text/csv, text/plain,application/octet-stream doc xls pdf txt");
	profile.setPreference("browser.helperApps.neverAsk.openFile",
			"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
	
	
	//profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
	profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/csv, text/csv, text/plain,application/octet-stream doc xls xlsx pdf txt");
	profile.setPreference("browser.helperApps.alwaysAsk.force", false);
	profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
	profile.setPreference("browser.download.manager.focusWhenStarting", false);
	profile.setPreference("browser.download.manager.useWindow", false);
	profile.setPreference("browser.download.manager.showAlertOnComplete", false);
	profile.setPreference("browser.download.manager.closeWhenDone", false);
	browser.setCapability(FirefoxDriver.PROFILE, profile);
		
		
		
	}

}
