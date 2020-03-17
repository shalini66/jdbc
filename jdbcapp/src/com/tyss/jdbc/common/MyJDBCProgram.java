package com.tyss.jdbc.common;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class MyJDBCProgram {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			
			//1. Load the Driver
			
			//First approach
			/*
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			*/
			
			//Second approach
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			//2.Get the "DB Connection" via "Driver"
			String dburl="jdbc:mysql://localhost:3306/cgjan_db?user=root&password=root";
			conn=DriverManager.getConnection(dburl);
			//3.Issue the SQL Query via connection
			String query = "select * from employee ";
			stmt = conn.createStatement();
			//4.Process the Results "returned by SQL Queries"
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				long mobile = rs.getLong("mobile");
				double salary = rs.getDouble("salary");
				int deptno = rs.getInt("deptno");
				String bloodgroup = rs.getString("bloodgroup");
				int age = rs.getInt("age");
				Date dob = rs.getDate("dob");
				
				System.out.println("---------Employee Details---------");
				System.out.println("EmployeeId---"+id);
				System.out.println("Name is---"+name);
				System.out.println("Email is---"+email);
				System.out.println("MobileNo is---"+mobile);
				System.out.println("Salary is---"+salary);
				System.out.println("DeptNo---"+deptno);
				System.out.println("BloodGroup---"+bloodgroup);
				System.out.println("Age is---"+age);
				System.out.println("DOB--"+dob);
				System.out.println("----------------------------------");
			
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
				if(rs != null) {
					rs.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
