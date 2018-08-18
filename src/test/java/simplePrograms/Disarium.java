package simplePrograms;

public class Disarium
{


	public static void main(String[] args)
	{
		String num = "13579";
		int number = Integer.parseInt(num);
		int number1;
		
		int[] a = new int[num.length()];
		for(int i=0; i<num.length(); i++)
		{
			number1 = number%10;
			a[i] = number1;
			number = number/10;
		}
		
		
		
		int b[] = new int[num.length()];
		
		for(int i=0; i<num.length(); i++)
		{
			b[i] = a[num.length()-i-1];
		}
		
		System.out.println("Power : " + givePower(6,4));
		
		//System.out.println(giveSum(b));
		
		for(int i=0; i<b.length;i++)
		{
			System.out.println(i+1 + " : " + b[i]);
		}

	}
	
	public static int giveSum(int[] b)
	{
		int s=0;
		for(int i=0; i<b.length;i++)
		{
			s+=s;
		}
		return 0;
	}
	
	public static int giveMultiple(int num, int index)
	{
		
		return 0;
	}
	
	
	
	public static int givePower(int num, int index)
	{
		if(index==0)
		{
			return 1;
		}
		else if(index==1)
		{
			return num;
		}
		else
		{
			num = num*givePower(num,index-1);
			return num;
		}		
	}



	
}
