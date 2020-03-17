package com.cap.hibernate.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;
//import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cap.hibernateapp.dto.MovieInfo;

public class DynamicJPQL {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager = factory.createEntityManager();
		
		String jpql = "select m from MovieInfo m where m.id =:mid";
		TypedQuery<MovieInfo> query = manager.createQuery(jpql, MovieInfo.class);
		
		//Query query = manager.createQuery(jpql);

		query.setParameter("mid", 10);
		
		MovieInfo movieInfo = query.getSingleResult();
		System.out.println("ID = "+movieInfo.getId());
		System.out.println("Name = "+movieInfo.getName());
		System.out.println("Rating = "+movieInfo.getRating());
		System.out.println("-------------------");
	

	}
}
