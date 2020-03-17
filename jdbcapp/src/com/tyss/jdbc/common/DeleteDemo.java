package com.tyss.jdbc.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.Driver;

public class DeleteDemo {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dburl = "jdbc:mysql://localhost:3306/cgjan_db";
			conn= DriverManager.getConnection(dburl,"root","root");
			String query= "delete from employee where id = 19";
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(query);
			System.out.println("no of rows affected   "+result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(stmt != null) {
					stmt.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
