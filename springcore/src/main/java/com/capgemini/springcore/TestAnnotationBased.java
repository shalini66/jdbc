package com.capgemini.springcore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capgemini.springcore.bean.Hello;
import com.capgemini.springcore.config.AppConfig;

public class TestAnnotationBased {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Hello h = context.getBean(Hello.class);
		h.print();
		Hello h2 = context.getBean(Hello.class);
		h2.print();
		System.out.println(h==h2);
		context.close();
	}
}

