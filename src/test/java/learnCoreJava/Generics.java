package learnCoreJava;

import java.util.ArrayList;

public class Generics
{
	public static void main(String args[])
	{
		//Printing an int
		Generics.print(5);
		
		//Printing a string
		Generics.print("Five");
		
		//Printing an arraylist
		ArrayList<String> a = new ArrayList<String>();
		a.add("One AL");
		a.add("Two AL");
		Generics.print(a);		
		
	}
	
	public static <F> void print(F t)
	{
		System.out.println(t.getClass().getName());
		System.out.println(t);
		
	}
	
}
