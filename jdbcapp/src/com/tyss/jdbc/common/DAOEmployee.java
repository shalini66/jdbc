package com.tyss.jdbc.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DAOEmployee {
	public Employee getEmployee() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Employee emp= null;
	
		try {
			FileInputStream fin = new FileInputStream("dburl.properties");
			Properties pro = new Properties();
			pro.load(fin);

			
			String dburl="jdbc:mysql://localhost:3306/cgjan_db?autoReconnect=true&useSSL=false";
			conn=DriverManager.getConnection(dburl, pro);
			
			String query = "select * from employee ";
			stmt = conn.createStatement();
		
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				emp= new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setEmail(rs.getString("email"));
				emp.setMobile(rs.getLong("mobile"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setDeptno(rs.getInt("deptno"));
				emp.setBloodgroup(rs.getString("bloodgroup"));
				emp.setAge(rs.getInt("age"));
				emp.setDob(rs.getDate("dob"));
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
		return emp;
	}

}
