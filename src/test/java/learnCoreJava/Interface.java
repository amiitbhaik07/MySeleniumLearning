package learnCoreJava;

interface Drawable
{
	void draw();
	void common();
}

interface Sketchable
{
	void sketch();
	void common();
}

class Rectangle implements Drawable
{
	public void draw() 
	{
		System.out.println("Drawing Rectangle");		
	}
	public void draw1()
	{
		System.out.println("Drawing Rectangle1");		
	}
	public void common()
	{
		System.out.println("Drawing Common Rectangle");		
	}
}


class Circle implements Drawable
{
	public void draw()
	{
		System.out.println("Drawing circle");
	}
	public void draw1() 
	{
		System.out.println("Drawing Rectangle1");		
	}
	public void common()
	{
		System.out.println("Drawing Common Circle");		
	}
}


//Multiple inheritance in Java is supported only through interface
class multipleInheritance implements Drawable,Sketchable
{
	public void sketch() 
	{
		System.out.println("Sketching...");
	}

	public void draw()
	{
		System.out.println("Drawing...");
	}	
	public void draw1() 
	{
		System.out.println("Drawing Rectangle1");		
	}
	public void common()
	{
		System.out.println("Drawing Common multipleInheritance");		
	}
}

public class Interface 
{
	public static void main(String args[])
	{
		Drawable rect = new Rectangle();
		Drawable cir = new Circle();
		
		rect.draw();
		cir.draw();
		
		multipleInheritance multi = new multipleInheritance();
		multi.sketch();
		multi.draw();
		
		
		Drawable s = new Rectangle();
		s.common();
	}
}

