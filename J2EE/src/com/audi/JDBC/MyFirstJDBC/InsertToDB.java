package com.audi.JDBC.MyFirstJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class InsertToDB {
		
	@SuppressWarnings("null")
	public static void main(String[] args) throws SQLException {
		
		String DBURL = "jdbc:mysql://localhost/student_info";
		String USER = "root";
		String PASS = "root";
		Connection conn = null; 
		ResultSet rs = null;
		//Statement stmt = null; 
		 PreparedStatement pstmt = null;
		// step 1 
		
		try {
			// step 1  load the driver 
		 Class.forName("com.mysql.cj.jdbc.Driver");
		
		 // step 2  get the connection to db
		 
		 conn = DriverManager.getConnection(DBURL,USER,PASS);
		
		 //  step 3 issue the sql queries 
		 
	
		  String sql = "insert into student_data values (?,? )";
		  
		  		pstmt  = conn.prepareStatement(sql);
		 				pstmt.setInt(1, Integer.parseInt(args[0]) );
		 				pstmt.setString(2, args[1]);
		 				
		 		int res = pstmt.executeUpdate();
		 		System.out.println(res+ " row inserted to database ");
		 // process the 
		 
		   while(rs.next()) {
			  int roll = rs.getInt("roll");
			  System.out.println(roll);
		   }
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			conn.close();
			pstmt.close();
			rs.close();
			
		}

	}

}
