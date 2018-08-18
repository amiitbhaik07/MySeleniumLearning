package learnSelenium;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class _17_ReporterForTestNG 
{
	//Open index.html in test-output folder
	
	@Test
	public void test1()
	{
		Reporter.log("Log Test1 1");
		Reporter.log("Log Test1 2");
		Reporter.log("Log Test1 3");
		Reporter.log("Log Test1 4");
		Reporter.log("Log Test1 5");
		Reporter.log("Log Test1 6");
		Reporter.log("Log Test1 7");
		Reporter.log("Log Test1 8");
	}
	
	@Test
	public void test2()
	{
		Reporter.log("Log Test2 1");
		Reporter.log("Log Test2 2");
		Reporter.log("Log Test2 3");
		Reporter.log("Log Test2 4");
		Reporter.log("Log Test2 5");
		Reporter.log("Log Test2 6");
		Reporter.log("Log Test2 7");
		Reporter.log("Log Test2 8");
	}
	
	public static void main(String args[])
	{
		Reporter.log("Log Test");
	}

}
