package com.jdbcapp.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.jdbcapp.dto.Student;

public class StudentDAOJDBCImplements implements studentDAO{

	@Override
	public List<Student> getALLInfo() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; 
		try {
			FileInputStream fin = new FileInputStream("dburl.properties");
			Properties pro = new Properties();
			pro.load(fin);

			List<Student> li = new ArrayList<Student>();

			String dburl="jdbc:mysql://localhost:3306/cgjan_db";
			conn=DriverManager.getConnection(dburl, pro);
			String query = "select * from student";
			stmt = conn.createStatement();

			rs = stmt.executeQuery(query);

			while(rs.next()) {
				Student emp= new Student();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));

				emp.setMobile(rs.getLong("mobile"));

				li.add(emp);
			}
			return li;

		} catch (Exception e) {

			e.printStackTrace();
			return null;
		} finally {

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
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Student getstudentInfo(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		try {
			FileInputStream fin = new FileInputStream("dburl.properties");
			Properties pro = new Properties();
			pro.load(fin);

			String dburl="jdbc:mysql://localhost:3306/cgjan_db";
			conn=DriverManager.getConnection(dburl, pro);
			String query = "select * from student where id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				Student st= new Student();
				st.setId(rs.getInt("id"));
				st.setName(rs.getString("name"));

				st.setMobile(rs.getLong("mobile"));

				return st;
			} else {
				System.out.println("No Record Found");
				return null;
			}
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		} finally {

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
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean updateStudentInfo(Student info) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs; 
		try {
			FileInputStream fin = new FileInputStream("dburl.properties");
			Properties pro = new Properties();
			pro.load(fin);

			String dburl="jdbc:mysql://localhost:3306/cgjan_db";
			conn=DriverManager.getConnection(dburl, pro);
			String query = "update student set name = 'aaaa' where id = ? ";
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, info.getId());


			rs = pstmt.executeUpdate();

			if(rs!=0) {
				return true;
			} else {
				return false;
			}


		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {
				if(conn != null) {
					conn.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}

			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean deleteStudentInfo(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs; 
		try {
			FileInputStream fin = new FileInputStream("dburl.properties");
			Properties pro = new Properties();
			pro.load(fin);

			String dburl="jdbc:mysql://localhost:3306/cgjan_db";
			conn=DriverManager.getConnection(dburl, pro);
			String query = "delete from employee where id=? ";
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, id);


			rs = pstmt.executeUpdate();

			if(rs!=0) {
				return true;
			} else {
				return false;
			}


		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {
				if(conn != null) {
					conn.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}

			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean createStudentInfo(Student info) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			FileInputStream	fin = new FileInputStream("dburl.properties");
			Properties pro = new Properties();
			pro.load(fin);

			Class.forName(pro.getProperty("path")).newInstance();
			conn = DriverManager.getConnection(pro.getProperty("dburl"),pro);
			String query = "insert into student values (?,?,?)";
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, info.getId());
			pstmt.setString(2, info.getName());
			pstmt.setLong(3, info.getMobile());


			int count = pstmt.executeUpdate();

			System.out.println("no of rows afftected---"+count);
			if(count!=0) {
				return true;
			} else {
				return false;
			}
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
		return false;
	}
}

