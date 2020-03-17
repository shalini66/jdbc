package com.capgemini.myproperties.common;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class FileWriter {
	public static void main(String[] args) {
		try {
			FileOutputStream out=  new FileOutputStream("first.propertiies");
			Properties pro =  new Properties();
			pro.setProperty("name", "shalini");
			pro.setProperty("email", "shalini@gmail.com");
			pro.store(out, "this is my program");
			System.out.println("Properties File Created");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
