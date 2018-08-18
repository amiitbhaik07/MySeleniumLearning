package learnCoreJava;

//Cannot instantiate an abstract class
abstract class AbstractClass	//If any one of the methods in a class is abstract, that class must be declared abstract
{
	abstract void run(); 	//Abstract methods will not have method body
	abstract void stop();
	abstract void slow();
	void show1(){}; 		//Abstract class can contain non-abstract methods
}


//Abstract class needs to be extended to implement the methods
//If method body is not to be implemented, make the class and the methods abstract
abstract class ChildClass0 extends AbstractClass
{
	//abstract void run();	//Didn't want to implement this method, so made it abstract
	abstract void stop();
	void slow(){}			//Implemented this method by giving body	
}

abstract class AbstractClassWithNoAbstractMethod	//If there are no abstract methods, still that class can be declared abstract
{
	void run(){}; 			//Abstract methods will not have method body
	void stop(){};
	void slow(){};
	void show1(){}; 		//Abstract class can contain non-abstract methods
}

class ChildClass1 extends AbstractClass 
{
	//Need to implement ALL the methods in AbstractClass
	@Override
	void run() 
	{
		System.out.println("ChildClass1 Running");		
	}

	@Override
	void stop() 
	{
		System.out.println("ChildClass1 Stopping");		
	}

	@Override
	void slow() 
	{
		System.out.println("ChildClass1 Slowing down");		
	}
	
	//void show1(){};
}

class ChildClass2 extends AbstractClass 
{
	//Need to implement ALL the methods in AbstractClass
	@Override
	void run() 
	{
		System.out.println("ChildClass2 Running");		
	}

	@Override
	void stop() 
	{
		System.out.println("ChildClass2 Stopping");		
	}

	@Override
	void slow() 
	{
		System.out.println("ChildClass2 Slowing down");		
	}
}


class ChildClass3 extends ChildClass2 
{
	//Need to implement ALL the methods in AbstractClass
	@Override
	void stop() 
	{
		System.out.println("ChildClass3 Stopping");		
	}

	@Override
	void slow() 
	{
		System.out.println("ChildClass3 Slowing down");		
	}
}



public class Abstraction
{
	public static void main(String args[])
	{
		//Cannot Instantiate Abstract Class if this current class is NOT abstract
		//AbstractClass aa = new AbstractClass();
		
		AbstractClass a1 = new ChildClass1();		
		a1.run();
		a1.slow();
		a1.stop();
		
		AbstractClass a = new ChildClass2();		
		a.run();
		a.slow();
		a.stop();
	}
}

