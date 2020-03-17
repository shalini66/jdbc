package com.capgemini.springcore.bean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnimal {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		/*
		 * Animal l = context.getBean(Lion.class); l.sound(); Animal c =
		 * context.getBean(Cat.class); c.sound();
		 */
		Animal a = context.getBean(Animal.class);
		a.sound();
		context.close();
	}
}
