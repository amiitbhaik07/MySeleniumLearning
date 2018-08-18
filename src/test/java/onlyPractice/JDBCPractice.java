package onlyPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCPractice 
{
	public static void main(String args[]) throws Exception
	{
		System.out.println("Learn JDBC");
		Connection con = null;
		long start=0, end=0;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(LOAD_BALANCE=ON)(FAILOVER=ON)(ADDRESS=(PROTOCOL=TCP)(HOST=64.101.52.171)(PORT=1541))(ADDRESS=(PROTOCOL=TCP)(HOST=64.101.52.172)(PORT=1541)))(CONNECT_DATA=(SERVICE_NAME=TS1DMP.cisco.com)(SERVER=DEDICATED)))", "XXAPPSRO", "R3ad_0nly");
			Statement stmt = con.createStatement();
			
			String[] allDeals = new String[]{"1588647","1601165","1596161","2917237","3320143","1592188","3000453","1592193","3752371","2954966","2972133"};
			
			ResultSet rset = null;
			
			start=System.currentTimeMillis();
			for(String deal : allDeals)
			{
				rset = stmt.executeQuery("select am_email from cq_ccw_all_deal where opty_number = '"+deal+"'");
				while(rset.next())
				{
					System.out.println(rset.getString(1));
				}				
			}
			end = System.currentTimeMillis();
			
			System.out.println("____________________Seconds : " + (end-start)/(1000));
			
			PreparedStatement pstmt = con.prepareStatement("select am_email from cq_ccw_all_deal where opty_number = ?");
			
			start=System.currentTimeMillis();
			for(String deal : allDeals)
			{
				pstmt.setString(1, deal);
				rset = pstmt.executeQuery();
				
				while(rset.next())
				{
					System.out.println(rset.getString(1));
				}
			}
			end = System.currentTimeMillis();
			
			System.out.println("____________________Seconds : " + (end-start)/(1000));
			
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			con.close();
		}
		
		
		
		
	}
}
