package seleniumGridChallanges;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.omg.PortableInterceptor.SUCCESSFUL;

public class getHostNameFromIPAddress {
	public static void main(String args[]) throws Exception
	{
		//InetAddress addr = InetAddress.getByName("10.65.145.30");
		/*InetAddress addr = InetAddress.getByName("10.65.145.62");
		String host = addr.getHostName();
		System.out.println(host);*/
		
		//String host = "KOTHUMMA-AT02H";	
		//String host = "SUPANDYA-7RHHN";			
		String yourCommand = "net share share1=C:\\share1 /GRANT:Everyone,FULL";
		Process p = Runtime.getRuntime().exec(yourCommand );		
		System.out.println("Success");
		
	}

}
