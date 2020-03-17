package com.cap.hibernate.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DeleteRecord {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		String jpql = "delete from MovieInfo m where m.id = 55";
		//TypedQuery<MovieInfo> query = manager.createQuery(jpql, MovieInfo.class);
		
		Query query = manager.createQuery(jpql);
		int stmt = query.executeUpdate();
		
		System.out.println("record deleted");
		
		transaction.commit();
		manager.close();
		factory.close();

	}
}
