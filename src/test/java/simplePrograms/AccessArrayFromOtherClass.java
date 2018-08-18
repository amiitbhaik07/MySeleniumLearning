package simplePrograms;

public class AccessArrayFromOtherClass 
{
	public static void main(String args[])
	{
		OtherClass o = new OtherClass();
		o.a = new int[4];
		
		//System.out.println(o.a[0]);
	}

}
