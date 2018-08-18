package learnCoreJava;

import org.testng.Reporter;

/*
 
C1
|
|----C2
|	  |----C3
|	  |----C4
|
|----C5

 */

public class Inheritance 
{
	public static void main(String args[])
	{
		//We can make instances of all the classes
		C1 c1_1 = new C1();
		C2 c2_1 = new C2();
		C3 c3_1 = new C3();
		C4 c4_1 = new C4();
		C5 c5_1 = new C5();
		
		System.out.println("C1 c1_1 = new C1();");
		c1_1.run();
		c1_1.stop();
		c1_1.slow();
		
		System.out.println("C2 c2_1 = new C2();");
		c2_1.run();
		c2_1.stop();
		c2_1.slow();
		c2_1.methodc2();
		
		System.out.println("C3 c3_1 = new C3();");
		c3_1.run();
		c3_1.stop();
		c3_1.slow();
		c3_1.methodc2(); //methodc2 got inherited from Class C2
		c3_1.methodc3();
		
		Reporter.log("");
		
		System.out.println("C4 c4_1 = new C4();");
		c4_1.run();
		c4_1.stop();
		c4_1.slow();
		c4_1.methodc2();
		c4_1.methodc4();
		
		
		
		//We cannot convert a parent class to child class
		//C2 c2_2 = new C1();
		
		//But we can convert a child class to parent class
		C1 c2_2 = new C2();
		C1 c3_2 = new C3();
		C1 c4_2 = new C4();
		C1 c5_2 = new C5();

	}
}




class C1
{
	void run(){
		System.out.println("Running in Class C1");
	}
	void stop()
	{
		System.out.println("Stopping in Class C1");
	}
	void slow()
	{
		System.out.println("Slowing in Class C1");
	}
}

class C2 extends C1
{
	void run(){
		System.out.println("Running in Class C2");
	}
	void stop()
	{
		System.out.println("Stopping in Class C2");
	}
	void slow()
	{
		System.out.println("Slowing in Class C2");
	}
	void methodc2()
	{
		System.out.println("methodc2 in C2");
	}
}

class C3 extends C2
{
	void run(){
		System.out.println("Running in Class C3");
	}
	void stop()
	{
		System.out.println("Stopping in Class C3");
	}
	void slow()
	{
		System.out.println("Slowing in Class C3");
	}
	void methodc3()
	{
		System.out.println("methodc3 in C3");
	}
}

class C4 extends C2
{
	void run(){
		System.out.println("Running in Class C4");
	}
	void stop()
	{
		System.out.println("Stopping in Class C4");
	}
	void slow()
	{
		System.out.println("Slowing in Class C4");
	}
	void methodc4()
	{
		System.out.println("methodc4 in C4");
	}
}

class C5 extends C1
{
	void slow()
	{
		System.out.println("Slowing in Class C5");
	}
	void methodc5()
	{
		System.out.println("methodc5 in C5");
	}
}



