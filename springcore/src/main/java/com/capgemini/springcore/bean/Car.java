package com.capgemini.springcore.bean;

public class Car {
	private int id;
	private String  name;

	public Car() {
		System.out.println("Default Constructor of Car ");
	}
	
	public Car(int id, String name) {
		
		this.id = id;
		this.name = name;
	}
	
	void display() {
		System.out.println("id---"+id+"name---"+name);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
