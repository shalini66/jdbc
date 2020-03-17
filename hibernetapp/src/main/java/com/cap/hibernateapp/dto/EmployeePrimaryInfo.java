package com.cap.hibernateapp.dto;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cap.hibernate.manytomany.ProjectInfo;
import com.cap.hibernateapp.onetomany.EmployeeAddressInfo;
import com.cap.hibernateapp.onetoone.EmployeeSecondaryInfo;

import lombok.Data;
@Data
@Entity
@Table(name="EmployeePrimaryInfo")
public class EmployeePrimaryInfo implements Serializable{
	@Id
	@Column
	private int id;
	@Column
	private String name;
	@Column(nullable = false)
	private String officialemail;
	@Column(nullable = false)
	private long mobile;
	@Column
	private double salary;
	@Column
	private int deptno;
	@Column
	private String bloodgroup;
	@Column
	private String designation;
	@Column
	private Date doj;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "primary")
	
	private EmployeeSecondaryInfo sInfo;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "primary")
	private List<EmployeeAddressInfo> address;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "primary")
	private List<ProjectInfo> project;
}
