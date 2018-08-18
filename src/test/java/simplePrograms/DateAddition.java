package simplePrograms;

class Date
{
	int day;
	int month;
	int year;
	boolean isLeap=false;
	
	public Date(int day, int month, int year)
	{
		this.day=day;
		this.month=month;
		this.year=year;
		if(isLeap(year))
		{
			isLeap=true;
		}
	}
	
	public void nextYear()
	{
		year++;
		if(isLeap(year))
		{
			isLeap=true;
		}
	}
	
	public void nextMonth()
	{
		if(month<=11)
		{
			month++;
		}
		else
		{
			month=1;
			nextYear();
		}
	}
	
	public void nextDay()
	{
		if(day<=27)
		{
			day++;
		}
		else
		{
			if(day==28)
			{
				if(month==2)
				{
					if(isLeap)
					{
						day++;
					}
					else //Not Leap
					{
						day=1;
						nextMonth();
					}
				}
				else //month!=2
				{
					day++;
				}
			}
			else
			{
				if(day==29)
				{
					if(month==2)
					{
						day=1;
						nextMonth();
					}
					else
					{
						day++;
					}
				}
				else
				{
					//day==30,31
					if(day==30)
					{
						if(month==4 || month==6 || month==9 || month==11)
						{
							day=1;
							nextMonth();
						}
						else
						{
							day++;
						}
					}
					else
					{
						//day==31
						day=1;
						nextMonth();
					}
				}
			}
		}
	}
	
	public boolean isLeap(int year)
	{		
		if(year%4==0)
		{
			if(year%100==0)
			{
				if(year%400==0)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			else
			{
				return true;
			}
		}
		else
		{
			return false;
		}
	}
}

public class DateAddition {

	public static void main(String[] args) 
	{
		Date d =new Date(28,2,2020);
		int addDays = 1;
		
		for(int i=0; i<addDays; i++)
		{
			d.nextDay();
		}
		
		System.out.println(d.day + "-" + d.month + "-" + d.year);
		

	}
}
