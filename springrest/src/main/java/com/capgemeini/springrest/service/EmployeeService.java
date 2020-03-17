package com.capgemeini.springrest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemeini.springrest.beans.EmployeePrimaryInfo;
@Service
public interface EmployeeService {
	EmployeePrimaryInfo auth(int empId , String password);
	List<EmployeePrimaryInfo> getALLInfo();
	EmployeePrimaryInfo getEmployeeInfo(int id);
	boolean updateEmployeeInfo(EmployeePrimaryInfo info);
	boolean deleteEmployeeInfo(int id);
	boolean createEmployeeInfo(EmployeePrimaryInfo info);
}
