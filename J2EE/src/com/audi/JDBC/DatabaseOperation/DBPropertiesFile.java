package com.audi.JDBC.DatabaseOperation;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;


public class DBPropertiesFile {

	
	public static void main(String[] args) throws SQLException, IOException {
		
		Connection con = null; 
	 PreparedStatement pstmt = null;
		
		String DB_URL = "jdbc:mysql://localhost:3306/try"; // try is database_name
		//String  USER = "root";
		//String  PASS = "root";
		  
		// read the file of properties 
				String path = "E:/j2ee/filecode/db.properties";
					FileReader fr = new FileReader(path);
				// properties class obj and pass the fr  using load method .
					
					Properties prop = new Properties();
					 prop.load(fr);
		try {
			// step 1 . load the driver 
			Class.forName("com.mysql.jdbc.Driver");
			
			// step 2 . connect via driver 	      
		//	  con  =  DriverManager.getConnection(DB_URL, USER, PASS);  method 1 
			

		
			con = DriverManager.getConnection(DB_URL, prop);
		// step 3. issue the sql query  via conn
			
			  String sql =  "update students_otherinfo" 
					        +"set password = ?" 
					        + " where regno = ?"
					        +" and password = ?"; 
			  System.out.println("Query : "+sql);
			   pstmt = con.prepareStatement(sql); 
			    
			   pstmt.setString(1, args[0]);
			    pstmt.setInt(2, Integer.parseInt(args[1]));
			    pstmt.setString(3, args[1]);
			    
			    int count = pstmt.executeUpdate();
		 // step 4 . process the result
			    System.out.println(count+" updated suss.. ");
			  
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
