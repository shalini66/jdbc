package com.capgemini.springcore.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCar {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("car.xml");
		Car c = context.getBean(Car.class);
		c.display();

	}
}
