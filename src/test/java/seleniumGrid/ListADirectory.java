package seleniumGrid;

import java.io.File;
import java.io.FileFilter;

public class ListADirectory 
{
	
	public static void main(String args[])
	{
		System.out.println(System.getProperty("user.dir"));;
	}
		   /*public static void main(String[] args) {
		      File dir = new File("\\");
		      File[] files = dir.listFiles();
		      FileFilter fileFilter = new FileFilter() {
		         public boolean accept(File file) {
		            return file.isDirectory();
		         }
		      };
		      files = dir.listFiles(fileFilter);
		      System.out.println(files.length);
		      
		      if (files.length == 0) {
		         System.out.println("Either dir does not exist or is not a directory");
		      } else {
		         for (int i = 0; i< files.length; i++) {
		            File filename = files[i];
		            System.out.println(filename.toString());
		         }
		      }
		   }*/
}
