package learnSelenium;


public class _08_TimeDifference 
{
	public static void main(String args[]) throws Exception
	{
		float diff = (float) 500;
		
		int mins=0, sec=0;
		mins = ((int)diff) / 60;
		sec = ((int)diff) % 60;
		
		System.out.println(mins);
		System.out.println(sec);
	}
}
