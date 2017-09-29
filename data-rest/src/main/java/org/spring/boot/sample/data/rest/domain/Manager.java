package org.spring.boot.sample.data.rest.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Validated
@DynamicUpdate
@Table(name = "EMPLOYEE")
@DiscriminatorValue("mng")
public class Manager extends Employee {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8524122526868836523L;

	@JsonProperty(value="employees")
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ref")
	private List<Employee> employees;

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public void add(Employee employee) {
		if (Objects.isNull(employees)) {
			employees = new ArrayList<>();
		}
		employees.add(employee);
	}

}
