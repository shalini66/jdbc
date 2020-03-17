package com.capgemeini.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemeini.springrest.beans.EmployeePrimaryInfo;
import com.capgemeini.springrest.beans.EmployeeResponse;
import com.capgemeini.springrest.service.EmployeeService;
//@Controller
@RestController
public class EmployeeRestController {
	@Autowired
	private EmployeeService service;

	@GetMapping(path = "/getEmployee", produces = MediaType.APPLICATION_JSON_VALUE)
	//@ResponseBody
	public EmployeeResponse getEmployee(int id) {
		EmployeePrimaryInfo info = service.getEmployeeInfo(id);
		EmployeeResponse response = new EmployeeResponse();
		if (info != null) {
			response.setPrimaryInfo(info);
		} else {
			response.setError(true);
			response.setMessage("Employee Id Not Found");
		}
		return response;
	}

	@PostMapping(path = "/addEmployee",
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public EmployeeResponse addEmployee(@RequestBody EmployeePrimaryInfo info) {
		boolean isAdded= service.createEmployeeInfo(info);
		EmployeeResponse response = new EmployeeResponse();
		if (isAdded) {
			response.setMessage("Record Inserted Successfully");
		} else {
			response.setError(true);
			response.setMessage("Unable to Insert record");
		}
		return response;
	}

	@GetMapping(path = "/getAllEmployees", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public EmployeeResponse getAllEmployees() {
		List<EmployeePrimaryInfo> list = service.getALLInfo();
		EmployeeResponse response = new EmployeeResponse();
		if (list != null && !list.isEmpty()) {
			response.setList(list);
		} else {
			response.setError(true);
			response.setMessage("No record Found");
		}
		return response;
	}

	@DeleteMapping(path = "/removeEmployee/{id}", 
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public EmployeeResponse removeEmployee(@PathVariable(name = "id") int id) {
		boolean isDeleted = service.deleteEmployeeInfo(id);
		EmployeeResponse response = new EmployeeResponse();
		if (isDeleted) {
			response.setMessage("record deleted");
		} else {
			response.setError(true);
			response.setMessage("record not deleted");
		}
		return response;
	}

	@PutMapping(path = "/updateEmployee",
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, 
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public EmployeeResponse updateEmployee(@RequestBody EmployeePrimaryInfo info) {
		boolean isUpdated = service.updateEmployeeInfo(info);
		EmployeeResponse response = new EmployeeResponse();
		if (isUpdated) {
			response.setMessage("record updated");
		} else {
			response.setError(true);
			response.setMessage("record not updated");
		}
		return response;
	}
}
