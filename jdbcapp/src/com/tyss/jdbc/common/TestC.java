
package com.tyss.jdbc.common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class TestC {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement stmt = null;
		BufferedReader br;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dburl="jdbc:mysql://localhost:3306/cgjan_db?user=root&password=root";
			conn= DriverManager.getConnection(dburl);
			String query = "insert into movie values(?,?,?)";
			stmt=conn.prepareStatement(query);
			br= new BufferedReader(new InputStreamReader(System.in));
			
			do {
				System.out.println("enter id");
				int id = Integer.parseInt(br.readLine());
				System.out.println("name");
				String name = br.readLine();
				System.out.println("rating");
				String rate = br.readLine();
				stmt.setInt(1, id);

				stmt.setString(2, name);
				stmt.setString(3, rate);
				int count=stmt.executeUpdate();
				System.out.println("no rows effected"+count);
				
			}while(false);
			
			/*
			 * stmt.setInt(1, 6);
			 * stmt.setString(2, "kgf");
			 * stmt.setString(3, "good");
			 * int count=stmt.executeUpdate();
			 * System.out.println("no rows effected"+count);
			 */
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			//5.Close all JDBC Object
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
