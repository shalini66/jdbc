package com.capgemini.springcore.bean;

public class EmployeePrimaryInfo {
	private int id;
	private String name;
	private EmployeeAddressInfo address;
	
	public EmployeePrimaryInfo() {
		System.out.println("Default");
	}
	
	public EmployeePrimaryInfo(int id, String name, EmployeeAddressInfo address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	public void print() {
		System.out.println("id---"+id+"name---"+name);
	}
	public EmployeeAddressInfo getAddress() {
		return address;
	}
	public void setAddress(EmployeeAddressInfo address) {
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
