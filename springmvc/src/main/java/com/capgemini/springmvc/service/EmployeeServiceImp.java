package com.capgemini.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.springmvc.dao.EmployeeDAO;
import com.capgemini.springmvc.dto.EmployeePrimaryInfo;

@Service
public class EmployeeServiceImp implements EmployeeService {
	@Autowired
	private EmployeeDAO dao;

	@Override
	public EmployeePrimaryInfo auth(int empId, String password) {
		
		return dao.auth(empId, password);
	}

	@Override
	public List<EmployeePrimaryInfo> getALLInfo() {
		
		return dao.getALLInfo();
	}

	@Override
	public EmployeePrimaryInfo getEmployeeInfo(int id) {
		return dao.getEmployeeInfo(id);
	}

	@Override
	public boolean updateEmployeeInfo(EmployeePrimaryInfo info) {
		
		return dao.updateEmployeeInfo(info);
	}

	@Override
	public boolean deleteEmployeeInfo(int id) {
		// TODO Auto-generated method stub
		return dao.deleteEmployeeInfo(id);
	}

	@Override
	public boolean createEmployeeInfo(EmployeePrimaryInfo info) {
		return dao.createEmployeeInfo(info);
	}

}
