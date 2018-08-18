package excelApachePOI;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelCreate_XSSF {
	
	public static void main(String args[]) throws Exception
	{
		/*XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("New Created");
		
		for(int i=0; i<10; i++)
		{
			XSSFRow row = sheet.createRow(i);
			for(int j=0; j<10; j++)
			{
				XSSFCell cell = row.createCell(j);
				cell.setCellValue(i+","+j);
			}
		}
		
		FileOutputStream out = new FileOutputStream(new File("createdExcel_XSSF.xlsx"));
		workbook.write(out);
		out.close();
		System.out.println("Success");*/
		
		
		XSSFWorkbook w = new XSSFWorkbook();
		XSSFSheet sheet = w.createSheet("wrsdfds");
		XSSFRow row = sheet.createRow(0);
		XSSFCell cell = row.createCell(0);
		cell.setCellValue("sdaferg");
		cell = row.createCell(1);
		cell.setCellValue("WON dsgfrew");
		cell = row.createCell(2);
		cell.setCellValue("wefdgvdg");
		cell = row.createCell(3);
		cell.setCellValue("gregg");
		cell = row.createCell(4);
		cell.setCellValue("rgbard");
		cell = row.createCell(5);
		cell.setCellValue("bgvfb");
		cell = row.createCell(6);
		cell.setCellValue("babt");
		
		System.out.println("Success");
		
		try
		{
			FileOutputStream out = new FileOutputStream(new File("C:\\TimeSheetAutomation\\TimesheetDefaulters\\TimeSheetDefaulters123132.xlsx"));
			w.write(out);
			out.close();
			System.out.println("Success");	
		}
		catch(Exception e)
		{
			System.err.println("File already present");
			BufferedWriter out = new BufferedWriter(new FileWriter("filename"));
			out.write("aString1\n");
			out.close();
			boolean success = (new File("filename")).delete();
			if (success) {
				System.out.println("The file has been successfully deleted"); 
			}
		}
		
		
		
		
		
		
		
		
	}

}
