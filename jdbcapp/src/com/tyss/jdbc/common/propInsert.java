package com.tyss.jdbc.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class propInsert {
	public static void main(String[] args) {
		//FileInputStream fin;
		
		Connection conn = null;
		Statement stmt = null;
		try {
		FileInputStream	fin = new FileInputStream("dburl.properties");
		Properties pro = new Properties();
		pro.load(fin);
		
		Class.forName(pro.getProperty("path")).newInstance();
		conn = DriverManager.getConnection(pro.getProperty("dburl"),pro);
		String query = "update employee set id = 19 where id=12";
		stmt = conn.createStatement();
		int count = stmt.executeUpdate(query);
		System.out.println("no of rows afftected---"+count);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}if(stmt != null) {
					stmt.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
