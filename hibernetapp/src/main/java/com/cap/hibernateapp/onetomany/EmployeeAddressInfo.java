package com.cap.hibernateapp.onetomany;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.cap.hibernateapp.dto.EmployeePrimaryInfo;

import lombok.Data;
import lombok.ToString.Exclude;

@Data
@Entity
@Table (name = "EmployeeAddressInfo")

public class EmployeeAddressInfo implements Serializable{
	@EmbeddedId
	private EmployeeAddressPK pk;
	
	@Column
	private int hno;
	@Column
	private String address1;
	@Column
	private String address2;
	@Column
	private String landmark;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private int pincode;
	
	@Exclude
	@MapsId("empid")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="empid")
	
	private EmployeePrimaryInfo primary;	
	
}
