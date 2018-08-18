package learnCoreJava;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

public class TestAssert
{
	public static void main(String args[]) throws Exception
	{
		try
		{
			//Assert.assertEquals(true, false);
			//throw new Exception("EEE");
			
			long a1 = 12345678;
			long a2 = 12345678;
			
			System.out.println("1");
			assertEquals(a1, a2);
			System.out.println("2");
			assertNotEquals(a1, a2);
			System.out.println("3");
			
			throw new AssertionError();
		}		
		catch(AssertionError e1){
			System.err.println("AssertionError");
			e1.printStackTrace();
		}
		catch(Error e1){
			System.err.println("Error");
			e1.printStackTrace();
		}
		catch(NoSuchElementException e){
			e.printStackTrace();
		}
		catch(Exception e){
			System.err.println("Exception");
			e.printStackTrace();
		}
		Thread.sleep(1000);
		System.out.println("After assert command");
	}
}
