package com.capgemini.springcore.bean;

public class EmployeeAddressInfo {
	private int aid;
	private String city;
	private String addressType;
	
	public EmployeeAddressInfo() {
		System.out.println("Default");
	}
	public EmployeeAddressInfo(int aid, String city, String addressType) {
		super();
		this.aid = aid;
		this.city = city;
		this.addressType = addressType;
	}
	public void address() {
		System.out.println("id---"+aid+"addressType---"+addressType+"city---"+city);
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddressType() {
		return addressType;
	}
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	
	
}
