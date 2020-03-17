package com.cap.hibernate.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
//import javax.transaction.Transaction;

//import com.cap.hibernateapp.dto.MovieInfo;

public class DynamicUpdateRecord {
	public static void main(String[] args) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try{
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			String jpql = "update MovieInfo m set m.name=:mn where m.id =:mid";
			//TypedQuery<MovieInfo> query = manager.createQuery(jpql, MovieInfo.class);

			Query query = manager.createQuery(jpql);

			query.setParameter("mn", "hulk");
			query.setParameter("mid", 10);

			int result = query.executeUpdate();
			System.out.println("no of count "+result);
			transaction.commit();

		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
		}

	}
}
