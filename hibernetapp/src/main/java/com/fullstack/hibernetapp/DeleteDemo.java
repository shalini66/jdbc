package com.fullstack.hibernetapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cap.hibernateapp.dto.MovieInfo;

public class DeleteDemo {
	public static void main(String[] args) {
		MovieInfo info = new MovieInfo();
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			MovieInfo record = manager.find(MovieInfo.class, 99);
			 
			System.out.println("Record Removed");
			transaction.commit();
		} catch (Exception e) {

			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();

	}
}
