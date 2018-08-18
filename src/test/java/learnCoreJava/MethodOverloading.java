package learnCoreJava;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

public class MethodOverloading 
{
	public static void main(String args)
	{
		 int a=1;
		 
		 long q1 = 321321321;
		 long q2 = 321321321;
		 

		 Long q3 = new Long(321321321);
		 Long q4 = new Long(321321321);
		 q3.compareTo(q4);
		 
		 
		 
		 assertEquals(q1, q2);
		 
		 ArrayList<Integer> a1 = new ArrayList<Integer>();
		 a1.add(new Integer(2));
		 a1.add(3);
		 
		 Object a3 = new Integer(6);
		 
		 int a4 = (Integer)a3;
		 
		 if(a3 instanceof Object)
		 {
			 
		 }
		 
	}
	
	
	//We cannot overload by changing the return type
	/*String method(int a)
	{
		return null;
	}
	
	int method(int a)
	{
		return null;
	}*/
	
	
	
	Integer method(int a, String b)
	{
		return null;
	}
	
	int method(String b, int a)
	{
		return 0;
	}
	
	

}
