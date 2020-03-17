package com.fullstack.hibernetapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cap.hibernateapp.dto.EmployeePrimaryInfo;
import com.cap.hibernateapp.onetoone.EmployeeSecondaryInfo;

public class TestOneToOne {
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
		primary.setDoj(java.sql.Date.valueOf("1939-9-3"));
		//primary.setSInfo();
		
		EmployeeSecondaryInfo secondary = new EmployeeSecondaryInfo();
		secondary.setGender("Female");
		secondary.setAge(22);
		secondary.setFname("venky");
		secondary.setMname("kavitha");
		secondary.setMaritalstatus("single");
		secondary.setGovtid("apa0740");
		secondary.setDate(java.sql.Date.valueOf("1990-2-09"));
		secondary.setPersonalemail("eyleh@hfl.com");
		secondary.setPrimary(primary);
		//secondary.set
		
		//secondary.setDate(java.sql.Date.valueOf("2003-09-8"));
		
		try{
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			EmployeePrimaryInfo list = manager.find(EmployeePrimaryInfo.class, 16);
			System.out.println(list.getSInfo().getFname());
			manager.persist(secondary);
			
			transaction.commit();

		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
			factory.close();
		}
		
	}
}
