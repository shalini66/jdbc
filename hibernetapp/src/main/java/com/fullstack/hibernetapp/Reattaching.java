package com.fullstack.hibernetapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cap.hibernateapp.dto.MovieInfo;

public class Reattaching {
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
			
			MovieInfo record = manager.find(MovieInfo.class, 2);
			System.out.println(manager.contains(record));
			manager.detach(record);
			MovieInfo reattach = manager.merge(record);
			 
			System.out.println(manager.contains(record));
			reattach.setRating("good");
			System.out.println("Record Updates");
			transaction.commit();
		} catch (Exception e) {

			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();
	}
}
