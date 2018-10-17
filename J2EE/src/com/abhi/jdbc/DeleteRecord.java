package com.abhi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;


public class DeleteRecord { 
	
	public static void main(String[] args) throws SQLException {
		
		Connection con = null; 
	 PreparedStatement pstmt = null;
		
		String DB_URL = "jdbc:mysql://localhost:3306/try"; // try is database_name
		String  USER = "root";
		String  PASS = "root";
		try {
			// step 1 . load the driver 
			
			java.sql.Driver d = new Driver();
			
			// step 2 . connect via driver 	      
			  con  =  DriverManager.getConnection(DB_URL, USER, PASS);
		// step 3. issue the sql query  via conn
			  String sql =  "delete from mydata where id = ?"; 
			   pstmt = con.prepareStatement(sql); 
			    pstmt.setInt(1, Integer.parseInt(args[0]));
			    
			    int count = pstmt.executeUpdate();
		 // step 4 . process the result
			    System.out.println(count+" row is deleted ");
			  
		} catch (Exception e ) {
			e.printStackTrace();
		}
		
		finally {
			if(con != null) {
				con.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
		}
	}

}
