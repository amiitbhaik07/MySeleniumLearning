package simplePrograms;

public class OtherClass
{
	public static int[] a;	
	public static int[] b = new int[5];		
	public static int[] c = {1,2,3,4};
	
	
	
	public static void main(String args[])
	{
		//a = {1,2,3,4,5};
		
		b[0]=10;
		b[1]=20;
		b[2]=30;
		b[3]=40;
		b[4]=50;
		
		for(int abc : b)
		{
			System.out.println(abc);
		}
		
		
		System.out.println(b[1]);
		
		
		OtherClass o = new OtherClass();
		c[0] = 1;
		c[1] = 2;
		c[2] = 3;
		c[3] = 4;
		
		
		
		
		
		System.out.println(o.b[3]);
	}

}
