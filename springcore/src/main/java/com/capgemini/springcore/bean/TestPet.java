package com.capgemini.springcore.bean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPet {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		
		Pet pet = context.getBean(Pet.class);
		pet.doSomething();
		context.close();
	}
}
