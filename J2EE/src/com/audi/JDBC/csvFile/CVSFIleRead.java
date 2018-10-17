package com.audi.JDBC.csvFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CVSFIleRead {

	public static void main(String[] args) throws IOException {
		// read the csv file 
		
		String path = "E:/jfiles/data.txt";
		
		FileReader fr = new FileReader(path);
		
		BufferedReader br = new BufferedReader(fr);
			
			while(br.ready()) {
				String str = br.readLine();
				System.out.println(str);
			}
	}

}
