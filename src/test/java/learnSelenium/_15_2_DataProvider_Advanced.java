package learnSelenium;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _15_2_DataProvider_Advanced
{
	@DataProvider(name = "AuthenticationImp")
	public static Object[][] authentication() throws Exception
	{
		return ExcelUtils.getTableArray("C:\\Users\\abhaik\\SeleniumWorks1\\learnmaven3\\TestData.xlsx", "Sheet1");
	}
	
	@DataProvider(name = "AuthenticationImp1")
	public static Object[][] authentication1() throws Exception
	{
		return ExcelUtils.getTableArray("C:\\Users\\abhaik\\SeleniumWorks1\\learnmaven3\\TestData.xlsx", "Sheet1");
	}
	
	@Test(dataProvider="AuthenticationImp")
	public void test(String testName, String username, String pwd) throws Exception
	{
		System.out.println("____________________________________________________");
		System.out.println(testName);
		System.out.println(username);
		System.out.println(pwd);
		Thread.sleep(5000);
	}
}


class ExcelUtils
{
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static XSSFRow row;
	
	public static Object[][] getTableArray(String filePath, String sheetName) throws Exception
	{
		String[][] tabArray = null;
		FileInputStream fis = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(fis);
		fis.close();
		sheet = workbook.getSheet(sheetName);
		
		tabArray = new String[sheet.getPhysicalNumberOfRows()][sheet.getRow(0).getPhysicalNumberOfCells()];
		String val1="",val2="";
		for(int i=0; i<sheet.getPhysicalNumberOfRows(); i++)
		{
			for(int j=0; j<sheet.getRow(i).getPhysicalNumberOfCells(); j++)
			{
				try
				{
					val1=sheet.getRow(i).getCell(j).getStringCellValue();
					tabArray[i][j] = val1;
				}
				catch(Exception e)
				{
					val2=sheet.getRow(i).getCell(j).getRawValue();
					tabArray[i][j] = val2;
				}
			}
		}		
		return tabArray;
	}
}