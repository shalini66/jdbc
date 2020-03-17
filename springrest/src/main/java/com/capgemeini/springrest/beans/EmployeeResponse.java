package com.capgemeini.springrest.beans;

import java.util.List;

import lombok.Data;

@Data
public class EmployeeResponse {
	private boolean error;
	private String message;
	
	private EmployeePrimaryInfo primaryInfo;
	private  List<EmployeePrimaryInfo> list;
	
}
