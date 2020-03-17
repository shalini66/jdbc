package com.cap.designpattern;

import com.cap.designpattern.dao.EmployeeDAO;
import com.cap.designpattern.dao.EmployeeDAOFactory;

public class FactoryMain {
	public static void main(String[] args) {
		EmployeeDAO dao = EmployeeDAOFactory.getInstance();
		System.out.println(dao);
		
	}
}
