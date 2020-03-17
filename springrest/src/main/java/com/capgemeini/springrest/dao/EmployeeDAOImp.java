package com.capgemeini.springrest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemeini.springrest.beans.EmployeePrimaryInfo;
import com.capgemeini.springrest.exception.EmployeeException;
@Repository
public class EmployeeDAOImp implements EmployeeDAO{
	@PersistenceUnit
	private EntityManagerFactory factory;
	@Override
	public EmployeePrimaryInfo auth(int id, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<EmployeePrimaryInfo> getALLInfo() {
		EntityManager manager = factory.createEntityManager();
		String jpql = "select e from EmployeePrimaryInfo e";
		Query query = manager.createQuery(jpql);
		List<EmployeePrimaryInfo> li = query.getResultList();
		manager.close();
		return li;
	}

	@Override
	public EmployeePrimaryInfo getEmployeeInfo(int id) {
		EntityManager manager = factory.createEntityManager();
		EmployeePrimaryInfo primaryInfo = manager.find(EmployeePrimaryInfo.class, id);
		manager.close();
		return primaryInfo;
	}

	@Override
	public boolean updateEmployeeInfo(EmployeePrimaryInfo info) {

		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction =manager.getTransaction();
		EmployeePrimaryInfo primary = manager.find(EmployeePrimaryInfo.class, info.getId());
		boolean isUpdated = false;
		if(primary != null){
			transaction.begin();
			primary.setName(info.getName());
			transaction.commit();
			isUpdated = true;
			System.out.println("Updated");
			transaction.commit();
		}
			manager.close();
		return isUpdated;
	}

	@Override
	public boolean deleteEmployeeInfo(int id) {
		boolean isDeleted = false;
		EntityManager manager = factory.createEntityManager();
		EmployeePrimaryInfo primaryInfo = manager.find(EmployeePrimaryInfo.class, id);
		if(primaryInfo !=null) {
			EntityTransaction transaction =manager.getTransaction();
			transaction.begin();
			manager.remove(primaryInfo);
			transaction.commit();
			isDeleted = true;
		}
		manager.close();
		return isDeleted;
	}

	@Override
	public boolean createEmployeeInfo(EmployeePrimaryInfo info) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		boolean isAdded = false;
		try {
			transaction.begin();
			manager.persist(info);
			transaction.commit();
			isAdded = true;
			System.out.println("Added");
		} catch (Exception e) {
			e.printStackTrace();
			throw new EmployeeException("Employee Id already Exist");
			
		} finally {
			manager.close();
		}
		return isAdded;
	}

}
