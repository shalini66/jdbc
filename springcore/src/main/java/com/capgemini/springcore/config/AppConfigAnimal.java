package com.capgemini.springcore.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.capgemini.springcore.bean.Cat;
import com.capgemini.springcore.bean.Lion;
import com.capgemini.springcore.bean.Pet;

public class AppConfigAnimal {
	@Bean
	@Primary
	public Lion getLion() {
		Lion lion = new Lion();
		return lion;
	}
	@Bean
	public Cat getCat() {
		Cat cat = new Cat();
		return cat;
	}
	@Bean
	public Pet getPet() {
		Pet pet = new Pet();
		pet.setName("snoopy");
		return pet;	
	}
}
