package simplePrograms;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class GetHostName {

	public static String getHostName(SessionId session) throws UnknownHostException
	{
		String hostDetail = null;
		String hostName ="localhost";
		int port = 4444;
		String errorMsg = "Failed to acquire remote webdriver node and port info. Root cause: ";

		try {
			HttpHost host = new HttpHost(hostName, port);
			DefaultHttpClient client = new DefaultHttpClient();
			URL sessionURL = new URL("http://" + hostName + ":" + port + "/grid/api/testsession?session=" + session);
			System.out.println("URL is : "+sessionURL);
			BasicHttpEntityEnclosingRequest r = new BasicHttpEntityEnclosingRequest("POST", sessionURL.toExternalForm());
			HttpResponse response = client.execute(host, r);
			//JSONObject object = extractObject(response);
			//URL myURL = new URL(object.getString("proxyId"));
			JsonObject myjsonobject =extractObject(response);
			JsonElement url = myjsonobject.get("proxyId");
			System.out.println("Url as a string : " + url.getAsString());
			URL myURL = new URL(url.getAsString());
			if ((myURL.getHost() != null) && (myURL.getPort() != -1)) {
				hostDetail = myURL.getHost();
			}

		} catch (Exception e) {
			//logger.log(Level.SEVERE, errorMsg, e);
			throw new RuntimeException(errorMsg, e);
		}
		return hostDetail;
	}

	private static JsonObject extractObject(HttpResponse resp) throws IOException {
		BufferedReader rd = new BufferedReader(new InputStreamReader(resp.getEntity().getContent()));
		StringBuffer s = new StringBuffer();
		String line;
		while ((line = rd.readLine()) != null) {
			s.append(line);
		}
		rd.close();
		JsonParser parser = new JsonParser();
		JsonObject objToReturn = (JsonObject)parser.parse(s.toString());
		System.out.println(objToReturn.toString());
		System.out.println("Proxy ID" + objToReturn.get("proxyId"));
		return objToReturn;
	}
	
	


	public static void main(String[] args) throws MalformedURLException, UnknownHostException, Exception {
	
		/*System.setProperty("webdriver.gecko.driver", "C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\Drivers\\geckodriver.exe");
		DesiredCapabilities dc = DesiredCapabilities.firefox();
		dc.setCapability("marionette", "false");
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://10.65.145.44:4444/wd/hub"),DesiredCapabilities.firefox());
		driver.get("http://www.google.com");
		System.out.println("Happy@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("Title : " + driver.getTitle());
		String hostname = getHostName(driver.getSessionId());
		System.out.println("hostname : " +hostname);
		System.out.println("Successsssssssssssssssss");
		driver.close();*/
		
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\abhaik\\SeleniumWorks\\Jars\\SeleniumUniversal\\Drivers\\chromedriver.exe");
		//DesiredCapabilities dc = DesiredCapabilities.chrome();
		//dc.setCapability("marionette", "false");
		Map<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", "\\\\10.65.145.45\\share");
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
		options.setExperimentalOption("prefs", chromePrefs);
		options.addArguments("--test-type");
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(ChromeOptions.CAPABILITY, options);	
		cap.setVersion("56");
		
		
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://10.65.145.45:4444/wd/hub"),DesiredCapabilities.phantomjs());
		driver.get("http://www.google.com");
		System.out.println("Happy@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("Title : " + driver.getTitle());
		String hostname = getHostName(driver.getSessionId());
		System.out.println("hostname : " +hostname);
		System.out.println("Successsssssssssssssssss");
		
		 InetAddress addr = InetAddress.getByName(hostname);
		 String host = addr.getHostName();
		 System.out.println("#################System Name : "+host);
		
		/*WebDriverWait wait = new WebDriverWait(driver,300);
		driver.get("http://www.seleniumhq.org/download/");		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='http://selenium-release.storage.googleapis.com/3.2/IEDriverServer_x64_3.2.0.zip']"))).click();		
		System.out.println("Downloading file");*/
		
		Thread.sleep(5000);
		
		driver.quit();
		
		
	}
}