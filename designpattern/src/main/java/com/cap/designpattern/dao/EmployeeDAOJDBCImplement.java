
package com.cap.designpattern.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.cap.designpattern.dto.Employee;

public class EmployeeDAOJDBCImplement implements EmployeeDAO {

	@Override
	public List<Employee> getALLInfo() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try (FileInputStream fin = new FileInputStream("dburl.properties")) {

			Properties pro = new Properties();
			pro.load(fin);

			List<Employee> li = new ArrayList<Employee>();

			String dburl = "jdbc:mysql://localhost:3306/cgjan_db";
			conn = DriverManager.getConnection(dburl, pro);
			String query = "select * from employee";
			stmt = conn.createStatement();

			rs = stmt.executeQuery(query);

			while (rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setEmail(rs.getString("email"));
				emp.setMobile(rs.getLong("mobile"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setDeptno(rs.getInt("deptno"));
				emp.setBloodgroup(rs.getString("bloodgroup"));
				emp.setAge(rs.getInt("age"));
				emp.setDob(rs.getDate("dob"));
				li.add(emp);
			}
			return li;

		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Employee getEmployeeInfo(int id) {
		ResultSet rs = null;
		try (FileInputStream fin = new FileInputStream("dburl.properties")) {
			// FileInputStream fin = new FileInputStream("dburl.properties");
			Properties pro = new Properties();
			pro.load(fin);

			String dburl = "jdbc:mysql://localhost:3306/cgjan_db";
			try (Connection conn = DriverManager.getConnection(dburl, pro)) {
				String query = "select * from employee where id = ?";

				try (PreparedStatement pstmt = conn.prepareStatement(query)) {

					pstmt.setInt(1, id);
					rs = pstmt.executeQuery();

					if (rs.next()) {
						Employee emp = new Employee();
						emp.setId(rs.getInt("id"));
						emp.setName(rs.getString("name"));
						emp.setEmail(rs.getString("email"));
						emp.setMobile(rs.getLong("mobile"));
						emp.setSalary(rs.getDouble("salary"));
						emp.setDeptno(rs.getInt("deptno"));
						emp.setBloodgroup(rs.getString("bloodgroup"));
						emp.setAge(rs.getInt("age"));
						emp.setDob(rs.getDate("dob"));
						return emp;
					} else {
						System.out.println("No Record Found");
						return null;
					}
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean updateEmployeeInfo(Employee info) {
		int rs;
		try (FileInputStream fin = new FileInputStream("dburl.properties")) {

			Properties pro = new Properties();
			pro.load(fin);

			String dburl = "jdbc:mysql://localhost:3306/cgjan_db";
			try (Connection conn = DriverManager.getConnection(dburl, pro)) {
				String query = "update employee set name = 'aaaa' where id = ? ";
				try (PreparedStatement pstmt = conn.prepareStatement(query)) {

					pstmt.setInt(1, info.getId());

					rs = pstmt.executeUpdate();

					if (rs != 0) {
						return true;
					} else {
						return false;
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean deleteEmployeeInfo(int id) {
		int rs;
		try (FileInputStream fin = new FileInputStream("dburl.properties")) {

			Properties pro = new Properties();
			pro.load(fin);

			String dburl = "jdbc:mysql://localhost:3306/cgjan_db";

			try (Connection conn = DriverManager.getConnection(dburl, pro)) {

				String query = "delete from employee where id=? ";

				try (PreparedStatement pstmt = conn.prepareStatement(query)) {
					pstmt.setInt(1, id);

					rs = pstmt.executeUpdate();

					if (rs != 0) {
						return true;
					} else {
						return false;
					}

				}
			}
		} catch (Exception e) {

			e.printStackTrace();

		}
		return false;
	}

	@Override
	public boolean createEmployeeInfo(Employee info) {
		try (FileInputStream fin = new FileInputStream("dburl.properties")) {

			Properties pro = new Properties();
			pro.load(fin);

			Class.forName(pro.getProperty("path")).newInstance();
			try (Connection conn = DriverManager.getConnection(pro.getProperty("dburl"), pro)) {
				String query = "insert into employee values (?,?,?,?,?,?,?,?,'2009-09-07')";

				try (PreparedStatement pstmt = conn.prepareStatement(query)) {
					pstmt.setInt(1, info.getId());
					pstmt.setString(2, info.getName());
					pstmt.setString(3, info.getEmail());
					pstmt.setLong(4, info.getMobile());
					pstmt.setDouble(5, info.getSalary());
					pstmt.setInt(6, info.getDeptno());
					pstmt.setString(7, info.getBloodgroup());
					pstmt.setInt(8, info.getAge());
					//pstmt.setDate(9, java.sql.Date.valueOf("2001-09-07"));

					int count = pstmt.executeUpdate();

					System.out.println("no of rows afftected---" + count);
					if (count != 0) {
						return true;
					} else {
						return false;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
