package com.fullstack.hibernetapp;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cap.hibernate.manytomany.ProjectInfo;
import com.cap.hibernateapp.dto.EmployeePrimaryInfo;
import com.cap.hibernateapp.onetoone.EmployeeSecondaryInfo;

public class TestManyToMany {
	public static void main(String[] args) {
		EntityManagerFactory factory = null;
		EntityManager manager= null;
		EntityTransaction transaction = null;

		/*EmployeePrimaryInfo primary = new EmployeePrimaryInfo();
		primary.setId(8);
		primary.setName("hari");
		primary.setOfficialemail("hari@gmail.com");
		primary.setMobile(985698002);
		primary.setDeptno(60);
		primary.setSalary(82354.00);
		primary.setBloodgroup("B+");
		primary.setDoj(java.sql.Date.valueOf("1939-9-3"));
		 */

		ProjectInfo pinfo =  new ProjectInfo();
		pinfo.setPid(18);
		pinfo.setPname("E-Commerce");
		pinfo.setStartdate(java.sql.Date.valueOf("2020-01-20"));
		pinfo.setEnddate(java.sql.Date.valueOf("2020-04-17"));
		pinfo.setTechnology("java");

		ProjectInfo pinfo1 =  new ProjectInfo();
		pinfo1.setPid(17);
		pinfo1.setPname("E-Commerce");
		pinfo1.setStartdate(java.sql.Date.valueOf("2020-01-20"));
		pinfo1.setEnddate(java.sql.Date.valueOf("2020-04-17"));
		pinfo1.setTechnology("java");

		EmployeePrimaryInfo primary1 = new EmployeePrimaryInfo();
		primary1.setId(19);
		primary1.setName("ram");
		primary1.setOfficialemail("ram@gmail.com");
		primary1.setMobile(900900902);
		primary1.setDeptno(40);
		primary1.setSalary(546000.00);
		primary1.setBloodgroup("O+");
		primary1.setDesignation("Marketing");
		primary1.setDoj(java.sql.Date.valueOf("1987-4-27"));
	


		ArrayList<ProjectInfo> list = new ArrayList<ProjectInfo>();

		list.add(pinfo);
		list.add(pinfo1);


		try{
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(list);
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
