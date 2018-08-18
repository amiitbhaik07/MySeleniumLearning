package excelApachePOI;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelWrite {
	
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
				cell.setCellValue(i+","+j+","+ (i+j));
			}
		}
		
		FileOutputStream out = new FileOutputStream(new File("C:\\Users\\abhaik\\SeleniumWorks\\ExcelPractice\\createdExcel.xls"));
		workbook.write(out);		
		System.out.println("Success");
		
		
		
	}

}
