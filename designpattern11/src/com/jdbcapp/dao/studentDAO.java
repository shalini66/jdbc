package com.jdbcapp.dao;

import java.util.List;

import com.jdbcapp.dto.Student;
public interface studentDAO {
	
	List<Student> getALLInfo();
	Student getstudentInfo(int id);
	boolean updateStudentInfo(Student info);
	boolean deleteStudentInfo(int id);
	boolean createStudentInfo(Student info);
}
