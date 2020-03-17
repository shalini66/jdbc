package com.tyss.jdbc.common;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class InsertDemo {
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dburl="jdbc:mysql://localhost:3306/cgjan_db?user=root&password=root";
			conn= DriverManager.getConnection(dburl);
			String query = "insert into employee values(22,'kalpana','kalpu@gmail.com',778855643,54638.00,30,'O+',22,'1998-07-11')";
			stmt=conn.createStatement();
			int count=stmt.executeUpdate(query);
			System.out.println("no rows effected"+count);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//5.Close all JDBC Object
			try {
				if(conn != null) {
					conn.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
