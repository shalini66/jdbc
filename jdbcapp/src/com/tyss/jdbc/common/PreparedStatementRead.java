/*
 * Run as Config
 * main class
 * arguments
 * enter data
 */

package com.tyss.jdbc.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class PreparedStatementRead {
	public static void main(String[] args) {

		Connection conn= null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;

		try {
			FileInputStream fin = new FileInputStream("dburl.properties");
			Properties pro = new Properties();
			pro.load(fin);

			//InputStreamReader ir = new InputStreamReader(System.in);

			Class.forName(pro.getProperty("path"));

			conn= DriverManager.getConnection(pro.getProperty("dburl"), pro);

			String query = "Select * from employee where id = ? and name = ?";
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, Integer.parseInt(args[0]));
			pstmt.setString(2, args[1]);

			rs= pstmt.executeQuery();

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

			};

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//5.Close all JDBC Object
			try {
				if(conn != null) {
					conn.close();
				}
				if(pstmt != null) {
					pstmt.close();
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
