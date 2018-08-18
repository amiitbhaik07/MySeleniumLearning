package learnSelenium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class _05_JDBC_Examples
{
	public static void main(String[] args) throws Exception
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
		
		
		
		
		
		
		
		
		
		
		
		/*Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracledb", "sys as sysdba", "amiitonoma07");
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		*/
		
		
		
		
		
		
		System.out.println("Hello");
		String tableName = "testdb";
		String colNames = "";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracledb", "sys as sysdba", "amiitonoma07");
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);		
		
		
		
		//insert data in table
		/*for(int i=0; i<15; i++)
		{
			System.out.println(stmt.executeUpdate("insert into testdb (col1, col2, col3, col4, col5, col6, col7, col8) values ("+i+","+i+","+i+","+i+","+i+","+i+","+i+","+i+")"));
		}*/
		
		
		
		//Get column Names
		ResultSet rset1 = stmt.executeQuery("select column_name from all_tab_columns where table_name = upper('"+tableName+"')");
		while(rset1.next())
		{
			colNames+=rset1.getString(1);
			if(!rset1.isLast())
			{
				colNames+=",";
			}
		}
		
		rset1.updateString(0, "");
		System.out.println(colNames);
		
		
		
		//Total Row count and Column count
		String query = "select "+colNames+" from " + tableName;
		ResultSet rset = stmt.executeQuery(query);
	
		ResultSetMetaData rsmd = rset.getMetaData();		
		System.out.println("Total col count : " + rsmd.getColumnCount());
		rset.last();
		System.out.println("Total row count : " + rset.getRow());
		
		
		
		//Print Column Names
		for(int i=1; i<=rsmd.getColumnCount(); i++)
		{
			System.out.print(rsmd.getColumnLabel(i) + "\t");
		}
		System.out.println();
		
		
		
		//Update resultset and database
		/*rset.beforeFirst();
		while(rset.next())
		{
			for(int i=1; i<=rsmd.getColumnCount(); i++)
			{
				if(rset.getString(rsmd.getColumnLabel(i)).equalsIgnoreCase("22"))
				{
					if(rset.getConcurrency() == ResultSet.CONCUR_UPDATABLE)
					{
						System.out.println("Resultset is Updatable");
					}
					else
					{
						System.err.println("Resultset is not updatable");
					}
					
					rset.updateString(rsmd.getColumnLabel(i), "2");
					
				}
				System.out.print(rset.getString(rsmd.getColumnLabel(i)) + "\t");
				rset.updateRow();
			}
			System.out.println();
		}
		System.out.println();*/
		
		
		
		
		//Insert new row in resultset
		rset.moveToInsertRow();
		for(int i=1; i<=rsmd.getColumnCount(); i++)
		{
			rset.updateString(i, "inserted");
		}
		rset.insertRow();
		
		
		
		
		System.out.println("success");
		con.close();

	}



}
