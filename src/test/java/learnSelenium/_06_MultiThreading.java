package learnSelenium;

public class _06_MultiThreading
{

	static String screenshotPath = System.getProperty("user.dir")+"\\src\\test\\reports"; 
	
	public static void main(String args[]) throws Exception
	{		
		Thread t1 = new Thread(new evenPrint());	
		t1.start();
		
		System.out.println("Started thread 1");
		
		for(int i=1000; i<5000; i+=10)
		{
			System.out.println("Main thread running ________________________" + i);
			Thread.sleep(2000);
		}
	}
}



class evenPrint implements Runnable
{
	public void run()
	{
		for(int i=0; i<50; i+=2)
		{
			System.out.println("****"+i);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
}



class oddPrint implements Runnable
{
	public void run()
	{
		for(int i=1; i<1000; i+=2)
		{
			System.err.println("@@@@@@@@@@"+i);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
}
