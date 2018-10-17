package com.audi.JDBC.DatabaseOperation;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class ReadDataFromTable {

	public static void main(String[] args) throws SQLException {
	
		String DB_URL  = "jdbc:mysql://localhost:3306/try"; // try is database
		String USER = "root"; // username of database
		String PASS = "root"; // password of database
		Connection con = null; 
		Statement stmt = null;
		ResultSet  rs = null; 
		
		try {
			// step 1 load the driver at runtime using class for name method 
			
		//	Class.forName("com.mysql.jdbc.Driver");
			
			Driver d = new com.mysql.jdbc.Driver();
			 DriverManager.registerDriver(d);
			 
			
			// step 2 get the connection to database 
				
			 con = DriverManager.getConnection(DB_URL, USER, PASS);
			 
			// step 3 issue using the sql query  create the statement using connection obj
			 
			 String sql = "select * from mydata ";
			    	stmt = con.createStatement();
			  // execute the query with stmt obj and store it into the result set
			   rs = stmt.executeQuery(sql);
			  
			 // step 4 process the result to display the data 
			  
			  while (rs.next()) {
				  int id = rs.getInt("id");
				  int age = rs.getInt("age");
				  String name = rs.getString("name");
				  
				  System.out.println(id+" "+ age +" "+name);
			  }
			 		
			 
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		finally {
			if(con!=null) {
				con.close();
			}
			if(stmt!= null) {
				stmt.close();
			}
			if(rs!= null) {
				rs.close();
			}
		}
		

	}

}
