package excelApachePOI;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite_XSSF {
	
	public static void main(String args[]) throws Exception
	{
		
		FileInputStream fis = new FileInputStream("C:\\Users\\abhaik\\SeleniumWorks\\ExcelPractice\\createdExcel_XSSF.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		fis.close();
		XSSFSheet sheet = workbook.getSheet("New Created");
		
		for(int i=0; i<10; i++)
		{
			XSSFRow row = sheet.getRow(i);
			for(int j=0; j<10; j++)
			{
				XSSFCell cell = row.getCell(j);
				cell.setCellValue(i+","+j+","+ (i+j)+ ",1234");
			}
		}
		
		//FileUtils.copyFile(,  new File(""));
		
		
		
		FileOutputStream out = new FileOutputStream(new File("C:\\Users\\abhaik\\SeleniumWorks\\ExcelPractice\\createdExcel_XSSF.xlsx"));
		workbook.write(out);		
		out.close();
		System.out.println("Success");
		
		
		
	}

}
