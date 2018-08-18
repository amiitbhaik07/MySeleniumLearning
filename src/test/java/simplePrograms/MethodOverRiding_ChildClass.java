package simplePrograms;

public class MethodOverRiding_ChildClass extends MethodOverRiding_SuperClass
{
	public void method()
	{
		System.out.println("This is Method1 in Child Class");
	}
	
	public static void main(String args[])
	{
		MethodOverRiding_ChildClass c = new MethodOverRiding_ChildClass();
		c.method1();
	}
}
