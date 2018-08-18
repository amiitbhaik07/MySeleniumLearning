package simplePrograms;

public class StudyFloat {
	public static void main(String args[]) throws Exception
	{
		long start = System.currentTimeMillis();
		Thread.sleep(1576);
		long end = System.currentTimeMillis();
		float f = (float) ((end-start)/1000.0);
		System.out.println(f);
	}

}
