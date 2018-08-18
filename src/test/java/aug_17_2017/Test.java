package aug_17_2017;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test 
{
	public static void main(String args[]) throws Exception
	{	
		
		
		
		
		
		
		
		
		//Prepared Statement Example
		/*Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracledb", "sys as sysdba", "amiitonoma07");
		PreparedStatement pstmt = con.prepareStatement("insert into test1 values (?,?,?,?,?,?)", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		FileInputStream fis = new FileInputStream("C:\\Users\\abhaik\\SeleniumWorks1\\LearnSeleniumJenkins\\src\\test\\java\\aug_17_2017\\testExcel.xlsx");
		XSSFWorkbook w = new XSSFWorkbook(fis);
		fis.close();
		XSSFSheet s = w.getSheetAt(0);
		for(int i=0; i<s.getPhysicalNumberOfRows(); i++)
		{
			pstmt.setString(1, s.getRow(i).getCell(0).getStringCellValue());
			pstmt.setString(2, s.getRow(i).getCell(1).getStringCellValue());
			pstmt.setString(3, s.getRow(i).getCell(2).getStringCellValue());
			pstmt.setString(4, s.getRow(i).getCell(3).getStringCellValue());
			pstmt.setString(5, s.getRow(i).getCell(4).getStringCellValue());
			pstmt.setString(6, s.getRow(i).getCell(5).getStringCellValue());
			int a = pstmt.executeUpdate();
			System.out.println("Records updated : " + a);
		}
		con.close();*/
		
		
		
		
		//Fetch data from database using JDBC
		/*Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracledb", "sys as sysdba", "amiitonoma07");
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);		
		String query = "select * from test1";		
		ResultSet rset = stmt.executeQuery(query);
		ResultSetMetaData rsmd = rset.getMetaData();		
		while(rset.next())
		{
			for(int i=0; i<rsmd.getColumnCount(); i++)
			{
				System.out.println(rset.getString(i+1));
			}
		}		
		con.close();*/
		
		
		
		//Create Excel Workbook
		/*XSSFWorkbook w = new XSSFWorkbook();
		XSSFSheet s = w.createSheet("testSheet");
		XSSFRow r;
		XSSFCell c;		
		for(int i=0; i<15; i++)
		{
			r = s.createRow(i);
			for(int j=0; j<15; j++)
			{
				c = r.createCell(j);
				c.setCellValue(i+","+j);
			}
		}		
		FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\abhaik\\SeleniumWorks1\\LearnSeleniumJenkins\\src\\test\\java\\aug_17_2017\\testExcel.xlsx"));
		w.write(fos);
		fos.close();*/
		
		
		//Read Excel Workbook
		/*FileInputStream fis = new FileInputStream("C:\\Users\\abhaik\\SeleniumWorks1\\LearnSeleniumJenkins\\src\\test\\java\\aug_17_2017\\testExcel.xlsx");
		XSSFWorkbook w = new XSSFWorkbook(fis);
		fis.close();
		
		XSSFSheet s = w.getSheetAt(0);
		
		for(int i=0; i<s.getPhysicalNumberOfRows(); i++)
		{
			for(int j=0; j<s.getRow(i).getPhysicalNumberOfCells(); j++)
			{
				System.out.print("\t"+s.getRow(i).getCell(j).getStringCellValue());
			}
			System.out.println();
		}*/
		
		
		
		//Update Excel Workbook
		/*FileInputStream fis = new FileInputStream("C:\\Users\\abhaik\\SeleniumWorks1\\LearnSeleniumJenkins\\src\\test\\java\\aug_17_2017\\testExcel.xlsx");
		XSSFWorkbook w = new XSSFWorkbook(fis);
		fis.close();		
		XSSFSheet s = w.getSheetAt(0);		
		for(int i=0; i<s.getPhysicalNumberOfRows(); i++)
		{
			for(int j=0; j<s.getRow(i).getPhysicalNumberOfCells(); j++)
			{
				if(s.getRow(i).getCell(j).getStringCellValue().contains("7"))
				{
					s.getRow(i).getCell(j).setCellValue("newValue_"+i+"_"+j);
				}
			}
		}
		FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\abhaik\\SeleniumWorks1\\LearnSeleniumJenkins\\src\\test\\java\\aug_17_2017\\testExcel.xlsx"));
		w.write(fos);
		fos.close();*/
		
	}

}
