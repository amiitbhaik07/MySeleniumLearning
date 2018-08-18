package learnCoreJava;


interface I1
{
	void method1();
	void method2();
}

interface I2
{
	void method1();
	void method3();
}

class ImplementI1I2 implements I1, I2
{
	public void method3() {
		// TODO Auto-generated method stub
		System.out.println("Method 3");
	}

	public void method1() {
		// TODO Auto-generated method stub
		System.out.println("Method 1");
	}

	public void method2() {
		// TODO Auto-generated method stub
		System.out.println("Method 2");
	}
}

public class Interface1
{
	public static void main(String args[]) throws Exception
	{
		I1 i1 = new ImplementI1I2();
		i1.method1();
		i1.method2();
		
		I2 i2 = new ImplementI1I2();
		i2.method1();
		i2.method3();
	}
}
