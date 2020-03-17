package com.tyss.jdbc.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class PreparedStatementDelete {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
		FileInputStream	fin = new FileInputStream("dburl.properties");
		Properties pro = new Properties();
		pro.load(fin);
		
		Class.forName(pro.getProperty("path")).newInstance();
		conn = DriverManager.getConnection(pro.getProperty("dburl"),pro);
		String query = " delete from employee where name=?";
		pstmt = conn.prepareStatement(query);
		
		
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
