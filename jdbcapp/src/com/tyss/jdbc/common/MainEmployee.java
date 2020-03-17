package com.tyss.jdbc.common;

public class MainEmployee {
	public static void main(String[] args) {
		Employee ep = new Employee();
		DAOEmployee e = new DAOEmployee();
		e.getEmployee();
		
		System.out.println(e.getEmployee().getId());
		System.out.println(e.getEmployee().getName());
		System.out.println(e.getEmployee().getEmail());
		System.out.println(e.getEmployee().getMobile());
		System.out.println(e.getEmployee().getAge());
		System.out.println(e.getEmployee().getBloodgroup());
		System.out.println(e.getEmployee().getDeptno());
		System.out.println(e.getEmployee().getSalary());
		System.out.println(e.getEmployee().getDob());
	}
}
