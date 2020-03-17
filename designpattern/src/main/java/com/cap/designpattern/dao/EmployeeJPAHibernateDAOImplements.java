package com.cap.designpattern.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cap.designpattern.dto.Employee;

public class EmployeeJPAHibernateDAOImplements implements EmployeeDAO {

	/*public List<Employee> getALLInfo() {
		/*EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager = factory.createEntityManager();
		Employee emp1 = manager.find(Employee.class, 1);
		
		List<Employee> list = manager.persist(emp1);
		Iterator<Employee> itr = list.iterator();
		while (itr.hasNext()) {
			Employee emp = itr.next();
			System.out.println("ID = " + emp.getId());
			System.out.println("Name = " + emp.getName());
			System.out.println("Email = " + emp.getEmail());
			System.out.println("Mobile = " + emp.getMobile());
			System.out.println("Salary = " + emp.getSalary());
			System.out.println("Deptno = " + emp.getDeptno());
			System.out.println("BloodGroup = " + emp.getBloodgroup());
			System.out.println("Age = " + emp.getAge());
			System.out.println("DOB = " + emp.getDob());
			System.out.println("-------------------");
			list.add(emp);
		}
		return null;
		manager.close();
		factory.close();
		*/


	@Override
	public Employee getEmployeeInfo(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager = factory.createEntityManager();
		Employee emp = manager.find(Employee.class, 1);
		emp.setId(1);

		System.out.println("ID = " + emp.getId());
		System.out.println("Name = " + emp.getName());
		System.out.println("Email = " + emp.getEmail());
		System.out.println("Mobile = " + emp.getMobile());
		System.out.println("Salary = " + emp.getSalary());
		System.out.println("Deptno = " + emp.getDeptno());
		System.out.println("BloodGroup = " + emp.getBloodgroup());
		System.out.println("Age = " + emp.getAge());
		System.out.println("DOB = " + emp.getDob());
		System.out.println("-------------------");
		
		manager.close();
		factory.close();
		return emp;

	}

	@Override
	public boolean updateEmployeeInfo(Employee info) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			Employee record = manager.find(Employee.class, 1);
			record.setName("sanjana");
			System.out.println("updated");
			transaction.commit();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
		}
		return false;

	}

	@Override
	public boolean deleteEmployeeInfo(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		
		System.out.println("record deleted");
		
		transaction.commit();
		Employee record = manager.find(Employee.class, 22);
		manager.remove(record);
		manager.close();
		factory.close();
		return false;
	}

	@Override
	public boolean createEmployeeInfo(Employee info) {
		
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			System.out.println("Record Saved");
			transaction.commit();
		} catch (Exception e) {

			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();
		return false;
	}

	@Override
	public List<Employee> getALLInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
