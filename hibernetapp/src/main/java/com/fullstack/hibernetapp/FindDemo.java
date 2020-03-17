package com.fullstack.hibernetapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;

import com.cap.hibernateapp.dto.MovieInfo;

public class FindDemo {

	public static void main(String[] args) {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
	EntityManager manager = factory.createEntityManager();
	
	
	MovieInfo record =  manager.find(MovieInfo.class, 10);

	System.out.println("ID = "+record.getId());
	System.out.println("Name = "+record.getName());
	System.out.println("Rating = "+record.getRating());

	manager.close();
	factory.close();
	
	}

}
