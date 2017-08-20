package org.spring.boot.sample.data.rest.repository;

import org.spring.boot.sample.data.rest.domain.Employee;
import org.springframework.data.rest.core.config.Projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Projection(name = "simple", types = { Employee.class })
public interface EmployeeSimple {

	@JsonProperty("firstName")
	public String getFirstName();

	@JsonProperty("familyName")
	public String getFamilyName();

}
