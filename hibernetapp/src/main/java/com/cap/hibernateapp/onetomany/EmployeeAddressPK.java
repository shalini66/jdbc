package com.cap.hibernateapp.onetomany;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable

public class EmployeeAddressPK implements Serializable {
	private int empid;
	private String addresstype;
}
