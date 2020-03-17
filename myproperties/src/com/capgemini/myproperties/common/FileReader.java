package com.capgemini.myproperties.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileReader {
	public static void main(String[] args) {
		try {
			FileInputStream fin =  new FileInputStream("db.properties");
			Properties pro =  new Properties();
			pro.load(fin);
			System.out.println("User--"+ pro.getProperty("user"));
			System.out.println("Password---"+ pro.getProperty("password"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
