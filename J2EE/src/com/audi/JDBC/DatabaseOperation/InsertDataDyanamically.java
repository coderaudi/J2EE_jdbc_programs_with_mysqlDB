package com.audi.JDBC.DatabaseOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class InsertDataDyanamically {

	public static void main(String[] args) throws SQLException {
	
		String DB_URL  = "jdbc:mysql://localhost:3306/try"; // try is database
		String USER = "root"; // username of database
		String PASS = "root"; // password of database
		
	  
		
		String sql = "insert into mydata values (? ,?, ?)" ;
		Connection con = null;
	
		PreparedStatement pstmt = null;
		
		try {
			//step 1 load the driver with Class.forName			
			Class.forName("com.mysql.jdbc.Driver");
			
			// step 2. connect to database 
		  con = DriverManager.getConnection(DB_URL, USER, PASS);
		 
		 // step 3 issue the sql queries  Dyanmic query 
		 // when the query has other than select and having the ? marks 
		 
		  		pstmt =	con.prepareStatement(sql);
		  // we all ready pass the query no we have to set the argument to the 
		  		// ??? mark position we receive it using the command line
		  		
		  		pstmt.setInt(1, Integer.parseInt(args[0]));
		  		pstmt.setInt(2, Integer.parseInt(args[1]));
		  		pstmt.setString(3, args[2]);
		 
		         int count =  pstmt.executeUpdate();
		         
		         // step 4 process the query output 
		         System.out.println(count+" Row are Updates ");
			
			
		} catch(Exception e) {
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
