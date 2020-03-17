package com.cap.designpattern;

import java.util.List;

import com.cap.designpattern.dao.EmployeeDAO;
import com.cap.designpattern.dao.EmployeeJPAHibernateDAOImplements;
import com.cap.designpattern.dto.Employee;

public class EmployeeJPAHibernateMain {
	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeJPAHibernateDAOImplements();

		/*
		 * retriving 1 record
		 * 
		 * Employee ep = dao.getEmployeeInfo(1);
		 */

		/*
		 * update
		 * 
		 * boolean res = dao.updateEmployeeInfo(ep); System.out.println("res "+res);
		 */
		// List<Employee> list = dao.getALLInfo();
		// System.out.println(list);

		/*
		 * delete
		 * 
		 * boolean ep = dao.deleteEmployeeInfo(22); System.out.println("result "+ep);
		 */
		
		Employee ep = new Employee();
		ep.setAge(23);
		ep.setBloodgroup("B+");
		ep.setDeptno(40);
		ep.setDob(java.sql.Date.valueOf("2001-09-06"));
		ep.setEmail("sha@gmail.com");
		ep.setId(43);
		ep.setName("swetha");
		ep.setSalary(30000.00);

		boolean res = dao.createEmployeeInfo(ep);
		System.out.println("result "+res);
	}
}
