package com.jdbcapp.controller;

//import java.util.Iterator;
//import java.util.List;
//
import com.jdbcapp.dao.studentDAO;

import com.jdbcapp.dao.StudentDAOJDBCImplements;

import com.jdbcapp.dto.Student;

public class StudentMain {
	public static void main(String[] args) {
		System.out.println("Main Started");
		//EmployeeDAOJDBCImplement dao =  new EmployeeDAOJDBCImplement();

		//Student ep =  new Student();
		StudentDAOJDBCImplements dao  = new StudentDAOJDBCImplements();
		Student s = new  Student();
		/*Student ep = dao.getstudentInfo(6);
		System.out.println("Id---"+ep.getId());
		System.out.println("Name---"+ep.getName());

		System.out.println("Mobile---"+ep.getMobile());

		System.out.println("-----------------------------------");
		
*/
		//update
		/*Student ep =  new Student();
		ep.setId(20);
		boolean ins = dao.updateStudentInfo(ep);
		System.out.println("no of rows affected"+ins);	
		 */


		/*
		List<Student > l =dao.getALLInfo();
		Iterator<Student > itr = l.iterator();
		System.out.println("Again on MyFirstJDBC");

		while(itr.hasNext()) {
			//Student ep = itr.next();
			System.out.println("Id---"+ep.getId());
			System.out.println("Name---"+ep.getName());

			System.out.println("Mobile---"+ep.getMobile());

			System.out.println("-----------------------------------");
		}
*/
		//delete
		boolean rs = dao.deleteStudentInfo(20);
		System.out.println("no of rows affected "+rs);
		 

		//create
		/*ep.setId(10);
		ep.setName("shanmuk");

		ep.setMobile(998877665);

		boolean rs = dao.createStudentInfo(ep);
		System.out.println("no of rows affected "+rs);
		 */

	}
}