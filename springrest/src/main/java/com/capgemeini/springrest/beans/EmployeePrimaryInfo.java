package com.capgemeini.springrest.beans;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;
@Data
@Entity
@Table(name="EmployeePrimaryInfo")
@JsonRootName("empInfo")
@JsonPropertyOrder({"employeeID","name","mobile"})
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class EmployeePrimaryInfo implements Serializable{
	@Id
	@Column
	@JsonProperty("employeeID")
	private int id;
	@Column
	@JsonProperty
	private String name;
	@Column
	private String email;
	@Column
	@JsonProperty("mobile")
	private long mobile;
	@Column
	private double salary;
	@Column
	private int deptno;
	@Column
	@JsonIgnore
	private String password;
	@Column
	private Date joiningDate;
	@Column
	private int managerId;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
}
