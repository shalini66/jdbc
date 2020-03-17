package com.capgemini.springcore.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Pet {
	private String name;
	@Autowired
	@Qualifier("getLion")
	private Animal animal;
	
	public Pet() {
		System.out.println("Default Constructor of Pet");
	}
	
	public Pet(String name, Animal animal) {
		this.name = name;
		this.animal = animal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	public void doSomething() {
		System.out.println("Name of Animal---"+name);
		animal.sound();
	}
	
}
