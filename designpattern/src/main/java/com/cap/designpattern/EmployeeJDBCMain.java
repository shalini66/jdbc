package com.cap.designpattern;

import com.cap.designpattern.dto.Employee;
import com.cap.designpattern.dao.EmployeeDAOJDBCImplement;

import java.util.List;

import com.cap.designpattern.dao.EmployeeDAO;

public class EmployeeJDBCMain {
	public static void main(String[] args) {
		
		System.out.println("Main Started");
		// EmployeeDAOJDBCImplement dao = new EmployeeDAOJDBCImplement();

		EmployeeDAO dao = new EmployeeDAOJDBCImplement();
		//Employee ep = new Employee();
		// Employee ep = dao.getEmployeeInfo(1);

		// update

		/*
		 * ep.setId(1); boolean ins = dao.updateEmployeeInfo(ep);
		 * System.out.println("no of rows affected" + ins);
		 */
		List<Employee> list = dao.getALLInfo();
		  for(Employee ep: list) {
		 
			/*
			 * System.out.println("Id---"+ep.getId());
			 * System.out.println("Name---"+ep.getName());
			 * System.out.println("Email---"+ep.getEmail());
			 * System.out.println("Mobile---"+ep.getMobile());
			 * System.out.println("Salry---"+ep.getSalary());
			 * System.out.println("Deptno---"+ep.getDeptno());
			 * System.out.println("BloodGroup"+ep.getBloodgroup());
			 * System.out.println("Age---"+ep.getAge());
			 * System.out.println("DOB---"+ep.getDob());
			 */
			  System.out.println(ep.getId());
		 System.out.println("-----------------------------------");
		 
		 }
	}

		// delete

		/*
		 * boolean ins = dao.deleteEmployeeInfo(22);
		 * System.out.println("no of rows affected"+ins);
		 */

		// create
		/*
		 * ep.setId(99); ep.setName("sony"); ep.setEmail("sony@gmail.com");
		 * ep.setMobile(998800766); ep.setSalary(8645.37); ep.setDeptno(50);
		 * ep.setBloodgroup("B-"); ep.setAge(19);
		 */
		// ep.setDob(java.sql.Date.valueOf("2001-2-09"));
		/*
		 * boolean rs = dao.createEmployeeInfo(ep);
		 * System.out.println("no of rows affected " + rs);
		 */
	}
