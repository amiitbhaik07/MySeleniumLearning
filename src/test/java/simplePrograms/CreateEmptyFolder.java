package simplePrograms;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class CreateEmptyFolder
{
	public static void main(String args[]) throws Exception
	{
		/*new File("C:\\ShareFolderCode\\createdByJava").mkdir();
		Thread.sleep(2000);
		System.out.println("Done");*/
		
		//net share sharefolder=<drivepath> /GRANT:<username>,Full /GRANT:<username>,Full;
				
		//String yourCommand = "net share sharefolder=C:\ShareFolderCode\createdByJava /GRANT:supandya,FULL";
				
		String getUname = "wmic.exe /node:10.65.145.44 ComputerSystem Get UserName";
		Process p = Runtime.getRuntime().exec(getUname);
		BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
		BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
		
		System.out.println(stdInput.readLine());
		System.out.println(stdInput.readLine());
		System.out.println(stdInput.readLine());
		System.out.println(stdInput.readLine());
		
		
		System.out.println("Done");

	}

}
