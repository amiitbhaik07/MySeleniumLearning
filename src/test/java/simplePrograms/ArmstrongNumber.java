package simplePrograms;

public class ArmstrongNumber
{
	public static void main(String args[])
	{
		/*String n ="37123242";
		int original = Integer.parseInt(n);
		int[] single = new int[n.length()];
		int soc=0;
		
		for(int i=0; i<n.length(); i++)
		{
			single[i] = Integer.parseInt(n.substring(i, i+1));
		}
		
		for(int i=0; i<single.length; i++)
		{
			soc+= single[i] * single[i] * single[i];
		}
		
		if(soc == original)
		{
			System.out.println("Successsssssss !!! '"+n+"' is Armstrong");
		}
		else
		{
			System.out.println("Fail !!! '"+n+"' is NOT Armstrong");
		}*/
		
		
		for(int abc=1; abc<1000000; abc++)
		{
			String n = abc+"";
			int original = abc;
			int[] single = new int[n.length()];
			int soc=0;
			
			for(int i=0; i<n.length(); i++)
			{
				single[i] = Integer.parseInt(n.substring(i, i+1));
			}
			for(int i=0; i<single.length; i++)
			{
				soc+= single[i] * single[i] * single[i];
			}
			
			if(soc == original)
			{
				System.out.println(n);
			}			
		}
		
		
	}
}
