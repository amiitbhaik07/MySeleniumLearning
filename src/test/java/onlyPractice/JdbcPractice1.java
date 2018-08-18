package onlyPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class JdbcPractice1 
{
	public static void main(String args[]) throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(LOAD_BALANCE=ON)(FAILOVER=ON)(ADDRESS=(PROTOCOL=TCP)(HOST=dbc-pts-vm-3009-vip.cisco.com)(PORT=1531))(ADDRESS=(PROTOCOL=TCP)(HOST=dbc-pts-vm-3010-vip.cisco.com)(PORT=1531))(ADDRESS=(PROTOCOL=TCP)(HOST=dbc-pts-vm-3011-vip.cisco.com)(PORT=1531))(ADDRESS=(PROTOCOL=TCP)(HOST=dbc-pts-vm-3012-vip.cisco.com)(PORT=1531)))(CONNECT_DATA=(SERVICE_NAME=TS3DMP.cisco.com)(SERVER=DEDICATED)))", "XXAPPSRO", "R3ad_0nly");
		
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
		//Statement
		
		try
		{
					
			ResultSet rset = stmt.executeQuery("select OPTY_ID, SHARE_NODE_ID, deal_type, CREATED_BY,THEATER,AREA,REGION, LEVEL1_NODE,LEVEL2_NODE,LEVEL3_NODE,LEVEL4_NODE,LEVEL5_NODE , a.* from cq_deal_master a where opty_id in ('61001493','61000249', '61000146')");
			ResultSetMetaData rsmd;
			
			while(rset.next())
			{
				rsmd = rset.getMetaData();
				for(int i=1; i<=rsmd.getColumnCount(); i++)
				{
					System.out.print(rset.getString(i) + "\t");
				}
				System.out.println();
			}
			
			
			//Prepared Statement
			
			
			PreparedStatement pstmt = con.prepareStatement("select OPTY_ID, SHARE_NODE_ID, deal_type, CREATED_BY,THEATER,AREA,REGION, LEVEL1_NODE,LEVEL2_NODE,LEVEL3_NODE,LEVEL4_NODE,LEVEL5_NODE , a.* from cq_deal_master a where opty_id = ?");
			
			
			String[] dealIds = new String[]{"61001493","61000249", "61000146"};
			
			
			for(String deal : dealIds)
			{
				pstmt.setString(1, deal);
				rset = pstmt.executeQuery();
				while(rset.next())
				{
					rsmd = rset.getMetaData();
					for(int i=1; i<=rsmd.getColumnCount(); i++)
					{
						
						System.out.print(rset.getString(i) + "\t");
					}
					System.out.println();
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally 
		{
			stmt.close();		
			con.close();
		}
		
	}

}
