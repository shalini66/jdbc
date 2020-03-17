package com.cap.hibernate.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cap.hibernateapp.dto.MovieInfo;

public class InsertRecord {
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
			String jpql = "insert into MovieInfo (id,name,rating) values(:id, :name, :rating)";
			//TypedQuery<MovieInfo> query = manager.createQuery(jpql, MovieInfo.class);
			
			Query query = manager.createNativeQuery(jpql);
			query.setParameter("id",15);
			query.setParameter("name","pk");
			query.setParameter("rating","good");
			manager.persist(info);
			System.out.println("Record Saved");
			int rs = query.executeUpdate();
			
			if (rs == 0) {
				System.out.println("result "+rs);
			} else {
			System.out.println(" no result "+rs);
			}
			transaction.commit();
		} catch (Exception e) {

			e.printStackTrace();
			transaction.rollback();
		}
		//manager.close();
		//factory.close();

	}
}
