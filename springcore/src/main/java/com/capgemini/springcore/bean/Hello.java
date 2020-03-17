package com.capgemini.springcore.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class Hello /* implements InitializingBean, DisposableBean */ {
	private int id;
	private List<String> name;
	@Autowired
	private Car car;
	
	public Hello() {
		System.out.println("Default Constructor of Hello");
	}
	
	public Hello(int id) {
		this.id = id;
	}

public Hello(List<String> name) {
	this.name= name;
}

	public Hello(int id, List<String> name, Car car) {
		this.id = id;
		this.name = name;
		this.car = car;
	}

	public void print() {
		car.display();
		System.out.println("Welcome to Spring Core"+"id---"+id+"name--"+name);
		for(String string : name) {
			System.out.println(string);
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<String> getName() {
		return name;
	}

	public void setName(List<String> name) {
		this.name = name;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	/*
	 * public void afterPropertiesSet() throws Exception {
	 * System.out.println("afterPropertiesSet");
	 * 
	 * }
	 */
	
	@PostConstruct
	public void init() throws Exception{
		System.out.println("init method");
	}
	@PreDestroy
	public void destroy() throws Exception {
		System.out.println("destroy");
		
	}
	
	
}
