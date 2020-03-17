package com.cap.hibernate.jpql;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cap.hibernateapp.dto.MovieInfo;

public class UpdateRecord {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		String jpql = "update MovieInfo m set m.id = 55 where m.id = 5";
		//TypedQuery<MovieInfo> query = manager.createQuery(jpql, MovieInfo.class);
		
		Query query = manager.createQuery(jpql);
		int stmt = query.executeUpdate();
		
		System.out.println("record updated");
		
		transaction.commit();
		manager.close();
		factory.close();
	
	}
}
