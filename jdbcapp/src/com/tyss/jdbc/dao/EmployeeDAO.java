package com.tyss.jdbc.dao;

import java.util.List;

import com.tyss.jdbc.dto.Employee;

public interface EmployeeDAO {
	
	List<Employee> getALLInfo();
	Employee getEmployeeInfo(int id);
	boolean updateEmployeeInfo(Employee info);
	boolean deleteEmployeeInfo(int id);
	boolean createEmployeeInfo(Employee info);
}
