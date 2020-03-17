package com.cap.hibernateapp.onetomany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cap.hibernateapp.dto.EmployeePrimaryInfo;
import com.cap.hibernateapp.onetoone.EmployeeSecondaryInfo;

public class TestManytoOne {
	public static void main(String[] args) {
		EntityManagerFactory factory = null;
		EntityManager manager= null;
		EntityTransaction transaction = null;
		
		EmployeePrimaryInfo primary = new EmployeePrimaryInfo();
		primary.setId(16);
		primary.setName("harika");
		primary.setOfficialemail("harika@gmail.com");
		primary.setMobile(985698362);
		primary.setDeptno(50);
		primary.setSalary(82354.00);
		primary.setBloodgroup("B+");
		//primary.setDoj();
		
		EmployeeSecondaryInfo secondary = new EmployeeSecondaryInfo();
		secondary.setGender("Female");
		secondary.setAge(22);
		secondary.setFname("venky");
		secondary.setMname("kavitha");
		secondary.setMaritalstatus("single");
		secondary.setGovtid("apa0740");
		//secondary.
		
		//secondary.setDate(java.sql.Date.valueOf("2003-09-8"));
		
		try{
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(secondary);
			
			transaction.commit();

		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
		}
		
	}
	}

