package com.capgemini.springmvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import com.capgemini.springmvc.dto.EmployeePrimaryInfo;
import com.capgemini.springmvc.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}
	@GetMapping("/add")
	public String getForm() {
		return "addEmployee";
	}
	@PostMapping("/added")
	public String submitForm(EmployeePrimaryInfo info, ModelMap map) {
		boolean added = service.createEmployeeInfo(info);
		if(added) {
			return "hello";
		} else {
			return "addEmployee";
		}	
	}

	@GetMapping("/search")

	public String getSearchForm() {
		return "searchEmp";
	}

	@GetMapping("/searchEmployee")
	public String getDetails(int id, ModelMap map) {
		EmployeePrimaryInfo info = service.getEmployeeInfo(id);
		if(info!=null) {
			map.addAttribute("info", info);
			return "searched";
		} else {
			return "searchEmp";
		}
	}

	@GetMapping("/delete")
	public String getDeleteForm() {
		return "deleteEmp";
	}

	@GetMapping("/deleteEmployee")
	public String deleteEmployee(int id, ModelMap map) {
		boolean deleted= service.deleteEmployeeInfo(id);
		if(deleted) {
			map.addAttribute("hello","Record Deleted");
			return "hello";
		} else {
			return "deleteEmp";
		}
	}

	@GetMapping("/getAll")
	public String getAll() {
		return "allDetailOfEmployee";
	}

	@GetMapping("/getAllEmployee")
	public String getAllEmployee( ModelMap map) {
		List<EmployeePrimaryInfo> allRecord = service.getALLInfo();
		map.addAttribute("list", allRecord);
		return "getEmployeeALL";
	}
	@GetMapping("/update")
	public String getUpdate() {
		return "updateEmp";
	}
	@GetMapping("/updateEmp")
	public String submitUpdated(EmployeePrimaryInfo info, ModelMap map) {
		boolean updated =	service.updateEmployeeInfo(info);

		if(updated) {
			map.addAttribute("hello", "record updated");
			return "hello";
		}else {
			return "updateEmp";
		}
	}
	
	@GetMapping("/login")
	public String getLogin() {
		return "";
	}
}
