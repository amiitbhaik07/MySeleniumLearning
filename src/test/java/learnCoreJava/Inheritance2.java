package learnCoreJava;

import org.testng.Reporter;

/*
 
Parent
|
|----Child

 */

public class Inheritance2 
{
	public static void main(String args[])
	{
		Parent p = new Parent();
		System.out.println("+++++++++++++++++++++++++++++++++++++++Parent p = new Parent();");
		System.out.println(p.a);
		p.parentMethod();
		p.overriddenMethod();		
		System.out.println("__________________________");
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++Child c = new Child();");
		Child c = new Child();
		System.out.println(c.a);
		c.parentMethod();
		c.childMethod();	
		c.overriddenMethod();
		System.out.println("__________________________");
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++Parent p1 = new Child();");
		Parent p1 = new Child();
		System.out.println(p1.a);
		p1.parentMethod();
		p1.overriddenMethod();
		System.out.println("__________________________");	
	}
}

class Parent
{
	String a = "Parent a";
	
	public void parentMethod()
	{
		System.out.println("Parent method");
	}
	
	public void overriddenMethod()
	{
		System.out.println("Parent class Overridden method called");
	}
}

class Child extends Parent
{
	String a = "Child a";
	
	public void childMethod()
	{
		System.out.println("Child method");
	}
	
	public void overriddenMethod()
	{
		System.out.println("Childt class overriden method called");
	}
}



