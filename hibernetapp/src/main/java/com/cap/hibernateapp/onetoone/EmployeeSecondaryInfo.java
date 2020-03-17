package com.cap.hibernateapp.onetoone;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cap.hibernateapp.dto.EmployeePrimaryInfo;

import lombok.Data;
@Data
@Entity
@Table (name = "EmployeeSecondaryInfo")
public class EmployeeSecondaryInfo implements Serializable {
	@Id	
	private int id;
	@Column
	private int age;
	@Column
	private Date date;
	@Column
	private String gender;
	@Column
	private String personalemail;
	@Column
	private String fname;
	@Column
	private String mname;
	@Column
	private String maritalstatus;
	@Column
	private String nationality;
	@Column
	private String govtid;
	 
/*
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPersonalemail() {
		return personalemail;
	}
	public void setPersonalemail(String personalemail) {
		this.personalemail = personalemail;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMaritalstatus() {
		return maritalstatus;
	}
	public void setMaritalstatus(String maritalstatus) {
		this.maritalstatus = maritalstatus;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getGovtid() {
		return govtid;
	}
	public void setGovtid(String govtid) {
		this.govtid = govtid;
	}*/
	
	@MapsId
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private EmployeePrimaryInfo primary;
}
