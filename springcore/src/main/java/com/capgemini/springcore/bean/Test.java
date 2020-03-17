package com.capgemini.springcore.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		/*
		 * Hello hello = new Hello(); hello.print();
		 */
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Hello info = context.getBean(Hello.class);
		info.print();
		Hello info2 = context.getBean(Hello.class);
		info2.print();
		System.out.println(info==info2);
		context.close();
	}
}
