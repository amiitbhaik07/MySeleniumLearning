package excelApachePOI;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead_XSSF {
	
	public static void main(String args[]) throws Exception
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\abhaik\\SeleniumWorks\\ExcelPractice\\createdExcel_XSSF.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		fis.close();
		
		XSSFSheet sheet = workbook.getSheet("New Created");
		String dummy=""; int abc=0;
		for(int i=0; i<10; i++)
		{
			XSSFRow row = sheet.getRow(i);
			for(int j=0; j<10; j++)
			{
				XSSFCell cell = row.getCell(j);
				try
				{
					
					dummy = cell.getStringCellValue().toString();
				}
				catch(Exception e)
				{
					System.err.println("In catch");
					dummy = cell.getRawValue().toString();
				}
				System.out.print(dummy);
				System.out.print(" | ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		System.out.println("Success");
		
	}

}
