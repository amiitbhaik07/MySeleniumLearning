package learnSelenium;

import java.util.ArrayList;

public class _16_AutoboxingAndUnboxing
{
	public static void main(String args[])
	{
		
		Object a1 = 3;
		Object a2 = "Amit";
		Object a3 = new ArrayList();
		//Object a4 =
		
		System.out.println(a1);
		System.out.println(a2);
		a1 = "Bhaik";
		a2 = 4;
		System.out.println(a1);
		System.out.println(a2);
		
		
		Integer i = new Integer(5);
		//int j = i; //unboxing
		i = 7; //autoboxing
		
		System.out.println(i);
		
	}
}
