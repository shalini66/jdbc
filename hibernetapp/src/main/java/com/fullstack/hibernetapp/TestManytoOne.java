package com.fullstack.hibernetapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cap.hibernateapp.dto.EmployeePrimaryInfo;
import com.cap.hibernateapp.onetomany.EmployeeAddressInfo;
import com.cap.hibernateapp.onetomany.EmployeeAddressPK;

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
		primary.setDesignation("Tester");
		primary.setDoj(java.sql.Date.valueOf("2009-12-2"));
	
		
		//giving composite key
		
		EmployeeAddressPK pkinfo = new EmployeeAddressPK();
		pkinfo.setEmpid(16);
		pkinfo.setAddresstype("current");
		
		
		EmployeeAddressInfo ainfo = new EmployeeAddressInfo();
		ainfo.setPk(pkinfo);
		ainfo.setAddress1("Adarsha Colony");
		ainfo.setAddress2("HNK");
		ainfo.setCity("Warangal");
		ainfo.setHno(2-1-574);
		ainfo.setLandmark("KU cross");
		ainfo.setPincode(506001); 
		ainfo.setState("Telangana");
		
		ainfo.setPrimary(primary);
		
		try{
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			EmployeePrimaryInfo record= manager.find(EmployeePrimaryInfo.class, 16);
			/*ainfo.setPrimary(record);// for different address type
			
			manager.persist(ainfo);
			*/
			System.out.println(record.getAddress().get(0).getPrimary().getId());
			System.out.println(record.getAddress().get(0).getPrimary().getName());
			System.out.println("Record Saved");
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
