package com.audi.JDBC.DatabaseOperation;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class UpdataData {

	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
		try {
			// step1 load the driver 
			Class.forName("com.mysql.jdbc.Driver");
			
			// database credentials
			String DB_URL = "jdbc:mysql://localhost:3306/try";
			//String USER = "root";
			//String PASS = "root";
			String path = "E:/filecode/j2ee/db.properties";
			FileReader fr = new FileReader(path);
			
			Properties p = new Properties();
						p.load(fr);
			// step 2 get the connection  via driverManger.get
			
				//con = DriverManager.getConnection(DB_URL, USER, PASS);
						con = DriverManager.getConnection(DB_URL, p);
			// step 3 issue the query via con 
				
//				String sql = "update mydata set name = ? "
//						+ "where id = ? and name = ?" ;
//				
						
				String sql = "update mydata set name = ? where id = ?";
				 pstmt = con.prepareStatement(sql);
				 
				 pstmt.setString(1, args[0]);
				 pstmt.setInt(2 , Integer.parseInt(args[1]));
		
				 
				 // exeupdate query 
				 int count = pstmt.executeUpdate();
				 
				 // step4 process the result 
				 
				 System.out.println(count+ " row data updated ");
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			
			// step 5  
			if(con != null ) {
				try {
					con.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
			if(pstmt != null)	{
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			}
		}
		
	}
}
