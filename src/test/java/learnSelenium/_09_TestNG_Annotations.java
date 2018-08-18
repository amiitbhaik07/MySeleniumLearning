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

public class _09_TestNG_Annotations
{
	@BeforeSuite
	public void beforeSuite() throws Exception
	{
		System.out.println("Before Suite");
	}
	
	@BeforeClass
	public void beforeClass() throws Exception
	{
		System.out.println("Before Class");
	}
	
	@BeforeTest
	public void beforeTest() throws Exception
	{
		System.out.println("Before Test");
	}
	
	@BeforeMethod
	public void beforeMethod() throws Exception
	{
		System.out.println("Before Method");
	}
	
	@Test(priority=1, groups = { "group1" })
	public void test1() throws Exception
	{
		System.out.println("Test1");
	}
	
	@Test(priority=1, groups = {"group2"})
	public void test2() throws Exception
	{
		System.out.println("Test2");
	}
	
	@Test(priority=1, groups = {"group1"})
	public void test3() throws Exception
	{
		System.out.println("Test3");
	}
	
	@Test(priority=1, groups = {"group2"})
	public void test4() throws Exception
	{
		System.out.println("Test4");
	}
	
	@Test(priority=1, groups = {"group3"})
	public void test5() throws Exception
	{
		System.out.println("Test5");
	}
	
	@Test(priority=1, groups = {"group1","group2"})
	public void test6() throws Exception
	{
		System.out.println("Test6");
	}
	
	@Test(priority=1, groups = {"group3","group2"})
	public void test7() throws Exception
	{
		System.out.println("Test7");
	}
	
	@Test(priority=1, groups = {"group1","group3"})
	public void test8() throws Exception
	{
		System.out.println("Test8");
	}
	
	@Test(priority=1, groups = {"group3"})
	public void test9() throws Exception
	{
		System.out.println("Test9");
	}
	
	@Test(priority=1, groups = {"group3"})
	public void test10() throws Exception
	{
		System.out.println("Test10");
	}
	
	@AfterMethod
	public void afterMethod() throws Exception
	{
		System.out.println("After Method");
	}
	
	@AfterTest
	public void afterTest() throws Exception
	{
		System.out.println("After Test");
	}
	
	@AfterClass
	public void afterClass() throws Exception
	{
		System.out.println("After Class");
	}
	
	@AfterSuite
	public void afterSuite() throws Exception
	{
		System.out.println("After Suite");
	}
	

}
