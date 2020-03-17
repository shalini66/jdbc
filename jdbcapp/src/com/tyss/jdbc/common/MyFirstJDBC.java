package com.tyss.jdbc.common;


import com.tyss.jdbc.dao.EmployeeDAO;
import com.tyss.jdbc.dao.EmployeeDAOJDBCImplement;

import com.tyss.jdbc.dto.Employee; 

public class MyFirstJDBC {
	public static void main(String[] args) {
		
		System.out.println("Main Started");
		//EmployeeDAOJDBCImplement dao =  new EmployeeDAOJDBCImplement();
		
		Employee ep =  new Employee();
		EmployeeDAO dao  = new EmployeeDAOJDBCImplement();
		//Employee ep = dao.getEmployeeInfo(1);
		
		//update
		/*Employee ep =  new Employee();
		ep.setId(3);
		boolean ins = dao.updateEmployeeInfo(ep);
		System.out.println("no of rows affected"+ins);	
		*/
		
		
		/*List<Employee > l =dao.getALLInfo();
		Iterator<Employee > itr = l.iterator();
		System.out.println("Again on MyFirstJDBC");

		while(itr.hasNext()) {
		Employee ep = itr.next();
		System.out.println("Id---"+ep.getId());
		System.out.println("Name---"+ep.getName());
		System.out.println("Email---"+ep.getEmail());
		System.out.println("Mobile---"+ep.getMobile());
		System.out.println("Salry---"+ep.getSalary());
		System.out.println("Deptno---"+ep.getDeptno());
		System.out.println("BloodGroup"+ep.getBloodgroup());
		System.out.println("Age---"+ep.getAge());
		System.out.println("DOB---"+ep.getDob());
		System.out.println("-----------------------------------");
		*/
		
		//delete
		/*boolean ins = dao.deleteEmployeeInfo(7);
		System.out.println("no of rows affected"+ins);
	}
}*/
		
		//create
		ep.setId(29);
		ep.setName("sony");
		ep.setEmail("sony@gmail.com");
		ep.setMobile(998800766);
		ep.setSalary(8645.37);
		ep.setDeptno(50);
		ep.setBloodgroup("B-");
		ep.setAge(19);
		ep.setDob(java.sql.Date.valueOf("2001-09-08"));
		
		boolean rs = dao.createEmployeeInfo(ep);
		System.out.println("no of rows affected "+rs);
	}	
	}