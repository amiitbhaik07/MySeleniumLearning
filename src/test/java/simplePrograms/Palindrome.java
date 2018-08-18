package simplePrograms;

public class Palindrome
{
	public static void main(String[] args)
	{
		String a = "12345";		
		StringBuffer b = new StringBuffer();		
		for(int i=a.length(); i>0; i--)
			b.append(a.substring(i-1, i));		
		String c = b.toString();		
		if(a.equals(c))
			System.out.println("String '"+a+"' is a Palindrome");
		else
			System.out.println("String '"+a+"' is NOT a Palindrome");
		
		
		
	}
}
