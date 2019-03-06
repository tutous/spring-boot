package org.tutous.springboot.data.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.tutous.springboot.data.jpa.domain.Employee;
import org.tutous.springboot.data.jpa.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public Iterable<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

}
