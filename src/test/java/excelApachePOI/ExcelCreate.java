package excelApachePOI;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelCreate {
	
	public static void main(String args[]) throws Exception
	{
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("New Created");
		
		
		
		for(int i=0; i<10; i++)
		{
			HSSFRow row = sheet.createRow(i);
			for(int j=0; j<10; j++)
			{
				HSSFCell cell = row.createCell(j);
				cell.setCellValue(i+","+j);
			}
		}
		
		
		
		FileOutputStream out = new FileOutputStream(new File("createdExcel.xls"));
		workbook.write(out);
		out.close();
		System.out.println("Success");
	}

}
