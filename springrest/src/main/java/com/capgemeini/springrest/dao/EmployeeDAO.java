package com.capgemeini.springrest.dao;

import java.util.List;

import com.capgemeini.springrest.beans.EmployeePrimaryInfo;

public interface EmployeeDAO {
	EmployeePrimaryInfo auth(int id , String password);
	List<EmployeePrimaryInfo> getALLInfo();
	EmployeePrimaryInfo getEmployeeInfo(int id);
	boolean updateEmployeeInfo(EmployeePrimaryInfo info);
	boolean deleteEmployeeInfo(int id);
	boolean createEmployeeInfo(EmployeePrimaryInfo info);
}
