package onlyPractice;

abstract class Abstract1
{
	abstract void run();
	abstract void slow();
	abstract void stop();
	
	void reverse()
	{
		System.out.println("Going reverse in abstract class");
	}
}


class ImplementClass extends Abstract1
{
	@Override
	void run() {
		// TODO Auto-generated method stub
		System.out.println("Running");
	}

	@Override
	void slow() {
		// TODO Auto-generated method stub
		System.out.println("Slowing");
	}

	@Override
	void stop() {
		// TODO Auto-generated method stub
		System.out.println("Stopping");
	}
	
	@Override
	void reverse()
	{
		System.out.println("Going reverse in child class");
	}
}



public class LearnAbstraction 
{
	public static void main(String args[])
	{
		Abstract1 a = new ImplementClass();
		ImplementClass b = new ImplementClass();
		
		System.out.println("This is : Abstract1 a = new ImplementClass();");
		a.run();
		a.slow();
		a.stop();
		a.reverse();
		
		System.out.println("This is : ImplementClass b = new ImplementClass();");
		b.run();
		b.slow();
		b.stop();
		b.reverse();
	}

}
