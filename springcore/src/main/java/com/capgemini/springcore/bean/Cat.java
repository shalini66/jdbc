package com.capgemini.springcore.bean;

public class Cat implements Animal{

	@Override
	public void sound() {
		System.out.println("Cat Sound Meow Meow");
	}

}
