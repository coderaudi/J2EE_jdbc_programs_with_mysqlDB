package com.audi.JDBC.MyFirstJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDB {
		
	public static void main(String[] args) throws SQLException {
		
		String DBURL = "jdbc:mysql://localhost/student_info";
		String USER = "root";
		String PASS = "root";
		Connection conn = null; 
		ResultSet rs = null;
		Statement stmt = null; 
		// step 1 
		
		try {
			// step 1  load the driver 
		 Class.forName("com.mysql.jdbc.Driver");
		
		 // step 2  get the connection to db
		 
		 conn = DriverManager.getConnection(DBURL,USER,PASS);
		
		 //  step 3 issue the sql queries 
		 
		 stmt = conn.createStatement();
		 
		 rs = stmt.executeQuery("select * from student_data");
		 // process the rs 
		 
		   while(rs.next()) {
			  int roll = rs.getInt("roll");
			  System.out.println(roll);
		   }
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			conn.close();
			stmt.close();
			rs.close();
			
		}

	}

}
