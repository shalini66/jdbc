package com.fullstack.hibernetapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cap.hibernateapp.dto.MovieInfo;

public class InsertDemo {

	public static void main(String[] args) {

		MovieInfo info = new MovieInfo();
		info.setId(10);
		info.setName("Dr Strange");
		info.setRating("average");
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(info);
			System.out.println("Record Saved");
			transaction.commit();
		} catch (Exception e) {

			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();

	}

}
