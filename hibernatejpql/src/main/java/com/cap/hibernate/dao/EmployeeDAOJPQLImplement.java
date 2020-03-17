package com.cap.hibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cap.hibernatejpql.dto.Employee;

public class EmployeeDAOJPQLImplement implements EmployeeDAO {

	public List<Employee> getALLInfo() {
		return null;
	}

	//Retriving 1 record
	public Employee getEmployeeInfo(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager = factory.createEntityManager();

		String jpql = "select m from Employee m where m.id =:mid";
		TypedQuery<Employee> query = manager.createQuery(jpql, Employee.class);

		//Query query = manager.createQuery(jpql);

		query.setParameter("mid", id);

		Employee emp = query.getSingleResult();
		System.out.println("ID = "+emp.getId());
		System.out.println("Name = "+emp.getName());
		System.out.println("Email = "+emp.getEmail());
		System.out.println("Mobile = "+emp.getMobile());
		System.out.println("Salary = "+emp.getSalary());
		System.out.println("Deptno = "+emp.getDeptno());
		System.out.println("BloodGroup = "+emp.getBloodgroup());
		System.out.println("Age = "+emp.getAge());
		System.out.println("DOB = "+emp.getDob());
		System.out.println("-------------------");

		return emp;
	}

	//Updating the record

	public boolean updateEmployeeInfo(Employee info) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try{
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			String jpql = "update Employee m set m.name=:mn where m.id =:mid";
			//TypedQuery<MovieInfo> query = manager.createQuery(jpql, MovieInfo.class);

			Query query = manager.createNativeQuery(jpql);

			//query.setParameter("sanjana", info.getId());

			query.setParameter("sanjana", info.getName());
			query.setParameter("mid", info.getId());

			int result = query.executeUpdate();
			System.out.println("no of count "+result);
			transaction.commit();

		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
		}
		return false;
	}
	

	public boolean deleteEmployeeInfo(int id) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try{
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			String jpql = "delete from EmployeeInfo m where m.id =:id";
			//TypedQuery<MovieInfo> query = manager.createQuery(jpql, MovieInfo.class);

			Query query = manager.createQuery(jpql);

			query.setParameter("id", id);

			int result = query.executeUpdate();
			System.out.println("no of count "+result);
			transaction.commit();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
		}
		return false;
	}

	public boolean createEmployeeInfo(Employee info) {
		// TODO Auto-generated method stub
		return false;
	}

}
