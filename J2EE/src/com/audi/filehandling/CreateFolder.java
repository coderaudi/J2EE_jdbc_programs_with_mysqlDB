package com.audi.filehandling;

import java.io.File;

public class CreateFolder {

	public static void main(String[] args) {
		
		String path = "E:/jfile/demofolder";
		
		File f = new File(path);
			
		 if (f.exists()) {
			 System.out.println("file already exist in directory ");
		 }
		 
		 boolean fc = f.mkdirs();  // mkdirs() used to create the folder
		 // mkdirs() not throws any exception 
		
		 if(fc == true ) {
			 System.out.println("new folder created ");
		 } else {
			 System.out.println("problem to create the folder");
		 }	

	}

}
