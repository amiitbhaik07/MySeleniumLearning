package excelApachePOI;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelRead {
	
	public static void main(String args[]) throws Exception
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\abhaik\\SeleniumWorks\\ExcelPractice\\createdExcel.xls");
		HSSFWorkbook workbook = new HSSFWorkbook(fis);
		fis.close();
		
		HSSFSheet sheet = workbook.getSheet("New Created");
		
		for(int i=0; i<10; i++)
		{
			HSSFRow row = sheet.getRow(i);
			for(int j=0; j<10; j++)
			{
				HSSFCell cell = row.getCell(j);
				System.out.print(cell.getStringCellValue());
				System.out.print(" | ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		for(int i=0; i<10; i++)
		{
			for(int j=0; j<10; j++)
			{
				System.out.print(sheet.getRow(j).getCell(i).getStringCellValue() + " | ");
			}
			System.out.println();
		}
		
		
		System.out.println("Success");
		
	}

}
