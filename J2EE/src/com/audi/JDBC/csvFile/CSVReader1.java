package com.audi.JDBC.csvFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class CSVReader1 {

	public static void main(String[] args) throws SQLException, IOException {
		
		String sql1 = "insert into students_info values ( ?,?,?,?)";
		String sql2 = "insert into guardian_info values ( ?,?,?,?)";
		String sql3 = "insert into students_ohter_info values ( ?,?,?)";
		
		FileReader fileReader = null ;
		BufferedReader bufferedReader = null;
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		
		try {
			// 1. load the drivers 
				java.sql.Driver d = new Driver();
			  DriverManager.registerDriver(d);
			  
			// 2. 
				String DBURL = "jdbc:mysql://localhost:3306/student";
				String USER = "root";
				String PASS = "root";
				
				 con = DriverManager.getConnection(DBURL,USER,PASS);
			  
			String path = "E:\\j2eeCSV\\student.csv";
			fileReader = new FileReader(path);
			bufferedReader = new BufferedReader(fileReader);
			
			while ( bufferedReader.ready()) {
				String str = bufferedReader.readLine();
				String[] arr = str.split(",");
				int regno= Integer.parseInt(arr[0]);
				String fname = arr[1];
				String mname = arr[2];
				String lname = arr[3];
				String gfname = arr[4];
				String gmname = arr[5];
				String glname = arr[6];
				String isadmin = arr[7];
				String password = arr[8];
				
				pstmt1.setInt(1, regno);
				pstmt1.setString(2, fname);
				pstmt1.setString(3, mname);
				pstmt1.setString(4, lname);
				
				pstmt1.addBatch();
				
				pstmt2.setInt(1, regno);
				pstmt2.setString(2, gfname);
				pstmt2.setString(3, gmname);
				pstmt2.setString(4, glname);
				
				pstmt2.addBatch();
				
				pstmt3.setInt(1, regno);
				pstmt3.setString(2, isadmin);
				pstmt3.setString(3, password);
			
				pstmt3.addBatch();	
				
			}
			
			int[]  count1 = pstmt1.executeBatch();
			int[]  count2 = pstmt2.executeBatch();
			int[]  count3 = pstmt3.executeBatch();
			
			int sum1 =0;
			int sum2 =0;
			int sum3 =0;
			
			for(int i: count1) {
				sum1 = sum1+i ;
			}

			for(int i: count2) {
				sum2= sum2+i ;
			}

			for(int i: count3) {
				sum3 = sum3+i ;
			}
			System.out.println(sum1+" Rows inserted ");
			System.out.println(sum2+" Rows inserted ");
			System.out.println(sum3+" Rows inserted ");
			
			
		} catch( Exception e) {
			e.printStackTrace();
		}
		finally {
			if(con!=null) {
				con.close();
			}
			if(pstmt1!=null) {
				pstmt1.close();
			}
			if(pstmt2!=null) {
				pstmt2.close();
			}
			if(pstmt3!=null) {
				pstmt3.close();
			}
			
			if(bufferedReader !=null) {
				bufferedReader.close();
			}
		}

	}

}
