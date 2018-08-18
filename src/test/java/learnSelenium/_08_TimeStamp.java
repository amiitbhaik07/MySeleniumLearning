package learnSelenium;

import java.text.SimpleDateFormat;
import java.util.Date;

public class _08_TimeStamp 
{
	public static void main(String args[])
	{
		String timeStamp = new SimpleDateFormat("dd_MMM_HH_mm_ss").format(new Date());
		
		
		String timeStamp1 = new SimpleDateFormat("dd_MMM---hh_mm_ss_a").format(new Date());
		
		
		String timeStamp2 = new SimpleDateFormat("dd-MMM-YYYY hh:mm:ss a").format(new Date());
		
		
		
		System.out.println(timeStamp);
		System.out.println(timeStamp1);
		System.out.println(timeStamp2);
	}
}
