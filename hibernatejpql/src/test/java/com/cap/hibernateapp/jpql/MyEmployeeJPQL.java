package com.cap.hibernateapp.jpql;

import com.cap.hibernate.dao.EmployeeDAO;
import com.cap.hibernate.dao.EmployeeDAOJPQLImplement;
import com.cap.hibernatejpql.dto.Employee;


public class MyEmployeeJPQL {
	public static void main(String[] args) {
		System.out.println("Main Started");

		/*Retriving 1 record
		 * 
		 * EmployeeDAO dao  = new EmployeeDAOJPQLImplement();
		 * Employee ep = dao.getEmployeeInfo(8);
		 */


		EmployeeDAO dao  = new EmployeeDAOJPQLImplement();
		Employee ep =  new Employee();

		/*
		 * ep.setId(22);
		 * boolean result = dao.updateEmployeeInfo(ep);
		 * System.out.println("no of rows affected"+result);	
		 */

		/*boolean result = dao.deleteEmployeeInfo(22);
		System.out.println("no of rows affected "+result);
		 */
	}
}
