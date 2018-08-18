package onlyPractice;

public class PrimeNumber 
{
	public static void main(String args[]) throws Exception
	{
		
		
		//Logic to check if its prime or not
		for(int i=0; i<1000; i++)
		{
			isPrime(i);
		}
		
			
	}
	
	public static boolean isPrime(int num)
	{
		int count=2;
		boolean prime=true;
		if(num < 0)
		{
			System.out.println("Please enter a positive number");
		}
		
		if(num==0)
		{
			System.out.println("Number '"+num+"' is Not Prime");
			return false;
		}
		
		if(num==1 || num==2)
		{
			System.out.println("Number '"+num+"' is Prime");
			return true;
		}
		
		if(num >= 3)
		{
			while(count!=num)
			{
				if(num%count==0)
				{
					prime=false;
					break;
				}
				count++;
			}
		}
		
		if(prime)
		{
			System.out.println("Number '"+num+"' is a Prime Number");
			return true;
		}
		else
		{
			//System.out.println("Number '"+num+"' is NOT a Prime Number");
			return false;
		}
	}

}
