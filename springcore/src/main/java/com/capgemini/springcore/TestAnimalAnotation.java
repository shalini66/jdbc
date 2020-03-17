package com.capgemini.springcore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capgemini.springcore.bean.Pet;
import com.capgemini.springcore.config.AppConfigAnimal;

public class TestAnimalAnotation {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfigAnimal.class);
		Pet pet = context.getBean(Pet.class);
		pet.doSomething();
		context.close();

	}
}
