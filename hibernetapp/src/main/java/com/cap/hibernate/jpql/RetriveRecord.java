package com.cap.hibernate.jpql;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cap.hibernateapp.dto.MovieInfo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RetriveRecord {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager = factory.createEntityManager();
		
		String jpql = "select m from MovieInfo m";
		//Query query = manager.createQuery(jpql);
		TypedQuery<MovieInfo> query = manager.createQuery(jpql, MovieInfo.class);
		List<MovieInfo> recordList = query.getResultList();
		for(MovieInfo movieInfo : recordList) {
			System.out.println("ID = "+movieInfo.getId());
			System.out.println("Name = "+movieInfo.getName());
			System.out.println("Rating = "+movieInfo.getRating());
			System.out.println("-------------------");
		}
	
		manager.close();
		factory.close();
	}
}
