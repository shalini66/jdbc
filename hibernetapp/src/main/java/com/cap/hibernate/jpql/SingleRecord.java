package com.cap.hibernate.jpql;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cap.hibernateapp.dto.MovieInfo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SingleRecord {
	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager = factory.createEntityManager();
		
		String jpql = "select m from MovieInfo m where id = 5";
		TypedQuery<MovieInfo> query = manager.createQuery(jpql, MovieInfo.class);
		MovieInfo movieInfo = query.getSingleResult();
		System.out.println("ID = "+movieInfo.getId());
		System.out.println("Name = "+movieInfo.getName());
		System.out.println("Rating = "+movieInfo.getRating());
	
		manager.close();
		factory.close();
		
	}
}
