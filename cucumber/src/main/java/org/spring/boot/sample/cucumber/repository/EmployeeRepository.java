package org.spring.boot.sample.cucumber.repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.spring.boot.sample.cucumber.domain.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeRepository {

	private static Set<Employee> employees = new HashSet<Employee>();
	static {
		employees.add(new Employee(1, "Uwe", "Sluga"));
		employees.add(new Employee(2, "Anni", "Sluga"));
		employees.add(new Employee(3, "Anton", "Sluga"));
		employees.add(new Employee(4, "Kill", "Bill"));
	}

	public Optional<Employee> findEmployeeById(Integer id) {
		return employees.stream().filter((e) -> e.getId().equals(id)).findFirst();
	}

}
