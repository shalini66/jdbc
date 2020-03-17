package com.capgemini.springcore.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.capgemini.springcore.bean.Car;
import com.capgemini.springcore.bean.Hello;
@Configuration
public class AppConfig {
	@Bean
	public Car getCar() {
		Car car = new Car();
		car.setId(001);
		car.setName("Audi");
		return car;
		
	}
	@Bean
	@Scope("prototype")
	public Hello getHello() {
		Hello hello= new Hello();
		hello.setId(11);
		ArrayList<String> al = new ArrayList<String>();
		al.add("ravi");
		al.add("soumya");
		al.add("supriya");
		al.add("shanmuk");
		hello.setName(al);
		return hello;
		
	}
	

}
