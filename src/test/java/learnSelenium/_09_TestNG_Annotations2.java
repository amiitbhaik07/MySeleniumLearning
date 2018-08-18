package learnSelenium;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class _09_TestNG_Annotations2
{	
	@BeforeTest
	public void beforeTest() throws Exception
	{
		System.out.println("Before Test");
	}
	
	@BeforeMethod
	public void beforeMethod() throws Exception
	{
		System.out.println("Before Method");
		Thread.sleep(2000);
	}
	
	@Test
	public void test1() throws Exception
	{
		System.out.println("Test1");
		Thread.sleep(5000);
		abc();		
	}
	
	public void abc() throws Exception
	{
		throw new Exception("Failed Failed Failed");
	}
	
	@Test
	public void test2() throws Exception
	{
		System.out.println("Test2");
		Thread.sleep(5000);
		abc();
	}
	
	@Test
	public void test3() throws Exception
	{
		System.out.println("Test3");
		Thread.sleep(5000);
		abc();
	}
	
	@AfterMethod
	public void afterMethod() throws Exception
	{
		System.out.println("After Method");
		Thread.sleep(2000);
	}
	
	@AfterTest
	public void afterTest() throws Exception
	{
		System.out.println("After Test");
	}
}
