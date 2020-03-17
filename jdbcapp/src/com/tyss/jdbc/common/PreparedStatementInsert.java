package com.tyss.jdbc.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Properties;

public class PreparedStatementInsert {
	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
		FileInputStream	fin = new FileInputStream("dburl.properties");
		Properties pro = new Properties();
		pro.load(fin);
		
		Class.forName(pro.getProperty("path")).newInstance();
		conn = DriverManager.getConnection(pro.getProperty("dburl"),pro);
		String query = "insert into employee values (?,?,?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(query);
		
		pstmt.setInt(1, Integer.parseInt(args[0]));
		pstmt.setString(2, args[1]);
		pstmt.setString(3, args[2]);
		pstmt.setLong(4, Long.parseLong(args[3]));
		pstmt.setDouble(5, Double.parseDouble(args[4]));
		pstmt.setInt(6, Integer.parseInt(args[5]));
		pstmt.setString(7, args[6]);
		pstmt.setInt(8, Integer.parseInt(args[7]));
		pstmt.setDate(9,Date.valueOf(args[8]));
		
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
