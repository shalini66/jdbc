package com.capgemini.springcore.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEmp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		EmployeePrimaryInfo info = context.getBean(EmployeePrimaryInfo.class);
		
		info.print();
		info.getAddress().address();
	}
}
