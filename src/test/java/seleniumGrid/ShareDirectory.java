package seleniumGrid;

import java.io.File;

public class ShareDirectory 
{
	public static void main(String args[]) throws Exception
	{
		/*new File("C:\\ShareFolderCode\\createdByJava").mkdir();
		Thread.sleep(2000);
		System.out.println("Done");*/
		
		//net share sharefolder=<drivepath> /GRANT:<username>,Full /GRANT:<username>,Full;
				
		//String yourCommand = "net share sharefolder=C:\\ShareFolderCode\\createdByJava /GRANT:supandya,FULL";
		
		String yourCommand = "net share share=\\users\\temp /GRANT:Everyone,FULL";
		Process p = Runtime.getRuntime().exec(yourCommand);		
		System.out.println("Success");
	}
}
