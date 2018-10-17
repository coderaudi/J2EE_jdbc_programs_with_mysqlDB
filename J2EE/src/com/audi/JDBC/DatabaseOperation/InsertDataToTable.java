package com.audi.JDBC.DatabaseOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDataToTable {

	public static void main(String[] args) throws SQLException {
				 
		Connection con = null;
		Statement stmt = null;
		
		
		try {
			
			// step 1 load the driver using ClassFor method 
			
			Class.forName("com.mysql.jdbc.Driver");
			
			// step 2 connect to database 
			
			String DB_URL  = "jdbc:mysql://localhost:3306/try"; // try is database
			String USER = "root"; // username of database
			String PASS = "root"; // password of database
			
		  con = DriverManager.getConnection(DB_URL, USER, PASS);
			
			// step 3  issue the sql query 
		  String sql = "insert into mydata values ( 6, 14 , 'wakawaka' )" ;
		  		stmt = con.createStatement();
		  		int count  = stmt.executeUpdate(sql);
		  		
		  		if(count == 1) {
		  			System.out.println("record is stored successfully ");
		  		}
			   
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
		}
		finally {
			 if( con != null ) {
				 con.close();
			 }
			 if(stmt != null ) {
				 stmt.close();
			 }
		}
		
	}

}
