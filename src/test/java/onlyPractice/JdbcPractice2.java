package onlyPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class JdbcPractice2 
{
	public static void main(String args[]) throws Exception
	{
		
		
		//Establish connection
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//URL : jdbc:oracle:thin:@
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(LOAD_BALANCE=ON)(FAILOVER=ON)(ADDRESS=(PROTOCOL=TCP)(HOST=dbc-pts-vm-3009-vip.cisco.com)(PORT=1531))(ADDRESS=(PROTOCOL=TCP)(HOST=dbc-pts-vm-3010-vip.cisco.com)(PORT=1531))(ADDRESS=(PROTOCOL=TCP)(HOST=dbc-pts-vm-3011-vip.cisco.com)(PORT=1531))(ADDRESS=(PROTOCOL=TCP)(HOST=dbc-pts-vm-3012-vip.cisco.com)(PORT=1531)))(CONNECT_DATA=(SERVICE_NAME=TS3DMP.cisco.com)(SERVER=DEDICATED)))","XXAPPSRO","R3ad_0nly");
		
		
		
		
		//Statement
		
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
		
		try
		{
			ResultSet rset = stmt.executeQuery("select OPTY_ID, SHARE_NODE_ID, deal_type, CREATED_BY,THEATER,AREA,REGION, LEVEL1_NODE,LEVEL2_NODE,LEVEL3_NODE,LEVEL4_NODE,LEVEL5_NODE , a.* from cq_deal_master a where opty_id in ( '61000146', '61000221', '61000200')");
			ResultSetMetaData rsmd = rset.getMetaData();
			int colCount = rsmd.getColumnCount();
			
			while(rset.next())
			{			
				for(int i=1; i<=colCount; i++)
				{
					System.out.print(rset.getString(i) + "\t");
				}
				System.out.println();
			}			
			
			
			
			PreparedStatement pstmt = con.prepareStatement("select OPTY_ID, SHARE_NODE_ID, deal_type, CREATED_BY,THEATER,AREA,REGION, LEVEL1_NODE,LEVEL2_NODE,LEVEL3_NODE,LEVEL4_NODE,LEVEL5_NODE , a.* from cq_deal_master a where opty_id in (?)");
			
			String[] arr = new String[]{"61000146", "61000200", "61000221"};
			
			
			for(String a : arr)
			{
				pstmt.setString(1, a);
				rset = pstmt.executeQuery();
				rsmd = rset.getMetaData();
				while(rset.next())
				{
					for(int i=1; i<=rsmd.getColumnCount(); i++)
					{
						System.out.print( rset.getString(i) + "\t");
					}
				}
				System.out.println();
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println("Connection closed");
			stmt.close();
			con.close();
		}
		
		
		
		
		
		
		
		
		//PreparedStatement
		
		
		
		
		
		
		
		
		
	}
}