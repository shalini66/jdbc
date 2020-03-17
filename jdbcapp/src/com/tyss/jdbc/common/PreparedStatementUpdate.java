package com.tyss.jdbc.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class PreparedStatementUpdate {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
		FileInputStream	fin = new FileInputStream("dburl.properties");
		Properties pro = new Properties();
		pro.load(fin);
		
		Class.forName(pro.getProperty("path")).newInstance();
		conn = DriverManager.getConnection(pro.getProperty("dburl"),pro);
		String query = "update employee set id = 234 where name = ? ";
		pstmt = conn.prepareStatement(query);
		
		//pstmt.setInt(1, Integer.parseInt(args[0]));
		pstmt.setString(1, args[0]);
		
		int count = pstmt.executeUpdate();
		System.out.println("no of rows afftected---"+count);
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}if(pstmt != null) {
					pstmt.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
