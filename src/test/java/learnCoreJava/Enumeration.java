package learnCoreJava;

public class Enumeration 
{
	enum Days{sun,mon,tue,wed,thu,fri,sat};	
	public static void main(String args[])
	{			
		
		
		Days d = Days.tue;
		System.out.println(d.name());
		d= Days.mon;
		System.out.println(d.name());
		
		System.out.println("Printing all enum values");
		for(Days d1 : Days.values())
		{
			System.out.println(d1.name());
		}		
	}
}
