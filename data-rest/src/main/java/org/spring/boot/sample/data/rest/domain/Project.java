package org.spring.boot.sample.data.rest.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Validated
@DynamicUpdate
@Table(name = "PROJECT")
@JsonIgnoreProperties(value = { "uuid", "new", "id", "handler", "hibernateLazyInitializer" })
public class Project extends Resource {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1391488418146787022L;

	@NotNull
	@Column(name = "NAME")
	private String name;

	@NotNull
	@Column(name = "DESCRIPTION")
	private String description;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "projects")
	private List<Employee> employees;

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void add(Employee employee) {
		if (Objects.isNull(employees)) {
			employees = new ArrayList<>();
		}
		employees.add(employee);
	}

}
