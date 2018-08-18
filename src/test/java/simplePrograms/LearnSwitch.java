package simplePrograms;

public class LearnSwitch {
	public static void main(String args[])
	{
		int num = 5;
		
		switch(num){
		case 1: 
		case 2:
		case 3:
		}
		
		
		label1:
		for(int i=0; i<=5; i++)
		{
			label2:
			for(int j=10; j<20; j++)
			{
				if(j==10)
				{
					System.out.println(i);
					continue label2;
				}
				else
				{
					System.out.println(j);
					break label1;
				}
			}
			
		}
	}

}
