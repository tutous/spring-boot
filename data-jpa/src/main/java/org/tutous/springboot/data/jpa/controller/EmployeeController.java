package org.tutous.springboot.data.jpa.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tutous.springboot.data.jpa.domain.Employee;
import org.tutous.springboot.data.jpa.service.EmployeeService;

@RestController
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping(path = "/employees", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Iterable<Employee>> getEmployees() {
		return ResponseEntity.ok(employeeService.getEmployees());
	}

}
