package org.spring.boot.sample.cucumber.controller;

import java.util.Optional;

import org.spring.boot.sample.cucumber.domain.Employee;
import org.spring.boot.sample.cucumber.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	private EmployeeRepository employeeRepository;

	public EmployeeController(@Autowired EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@RequestMapping(method = { RequestMethod.GET }, value = { "/version" })
	public String getVersion() {
		return "1.0";
	}

	@ResponseBody()
	@RequestMapping(method = { RequestMethod.GET }, 
	        value = { "/employee/{id}" }, //
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmployee(@PathVariable Integer id) {
		Optional<Employee> optional = employeeRepository.findEmployeeById(id);
		if (optional.isPresent()) {
			return new ResponseEntity<Employee>(optional.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}

}
