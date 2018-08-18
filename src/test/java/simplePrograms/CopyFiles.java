package simplePrograms;

import java.io.File;
import java.nio.file.Files;

public class CopyFiles {

	
	static String filePathSource = "C:\\BirthdayCollection\\BirthdayCollection.xlsx";
	static String dir = "C:\\BirthdayCollection\\Analysis\\";
	static String fileNameBefore = "AnalysisBefore.xlsx";
	static String fileNameAfter = "AnalysisAfter.xlsx";
	static String filePathAnalysisBefore = dir + fileNameBefore;
	static String filePathAnalysisAfter = dir + fileNameAfter;
	
	private static void copyFile(File dir, File source, File dest) throws Exception 
	{
	    try
	    {
	    	if(Files.isDirectory(dir.toPath()))
	    	{
	    		System.out.println("In correct directory");
	    	}
	    	else
	    	{
	    		System.err.println("No Directory");
	    		Files.createDirectory(dir.toPath());
	    	}
	    	
	    	if(! Files.exists(dest.toPath()))
	    	{
	    		Files.copy(source.toPath(), dest.toPath());
	    	}
	    	else
	    	{
	    		System.err.println("File already present");
		    	Files.delete(dest.toPath());
		    	System.out.println("File deleted");
		    	Files.copy(source.toPath(), dest.toPath());
	    	}
	    	
	    }
	    catch(Exception e){
	    }
	}
	
	
	public static void main(String args[]) throws Exception
	{
		copyFile(new File(dir), new File(filePathSource), new File(filePathAnalysisAfter));
		
		copyFile(new File(dir), new File(filePathSource), new File(filePathAnalysisBefore));		
	}



}
