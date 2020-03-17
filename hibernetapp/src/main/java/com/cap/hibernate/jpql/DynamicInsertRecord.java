package com.cap.hibernate.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cap.hibernateapp.dto.MovieInfo;

public class DynamicInsertRecord {
	public static void main(String[] args) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try{
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			String jpql = "insert into MovieInfo values(m.id=:mid, m.name=:mn, m.rating=:mrate)";
			//TypedQuery<MovieInfo> query = manager.createQuery(jpql, MovieInfo.class);

			Query query = manager.createNativeQuery(jpql);
			
			MovieInfo M = (MovieInfo) query.getSingleResult();
			//query.setParameter("mn", "hulk");
			query.setParameter("mid", "" );
			query.setParameter("mn", "hulk");
			query.setParameter("mrating", "super");
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
