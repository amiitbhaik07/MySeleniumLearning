package learnCoreJava;

public class SwitchStatement 
{
	public static void main(String args[]) throws Exception
	{
		//func1();
		
		func(1);
		func(2);
		func(3);
		func(4);
		func(5);
		func(6);
	}
	
	
	public static void func1() throws Exception
	{
		throw new Exception("Element is not cickable at point ");
	}
	
	public static void func(int a)
	{
		switch(a)
		{
		case 1:
			System.out.println(a);		
		case 4:
			System.out.println(a);
		case 5:			
			System.out.println(a);
		case 2:
			System.out.println(a);
		case 3:
			System.out.println(a);
		case 6:
			System.out.println(a);
		default:
			System.out.println(a);
		}
	}

}
