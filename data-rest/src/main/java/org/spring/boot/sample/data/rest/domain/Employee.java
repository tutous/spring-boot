package org.spring.boot.sample.data.rest.domain;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.validation.annotation.Validated;

@Entity
@Validated
@DynamicUpdate
@Table(name = "EMPLOYEE")
@DiscriminatorValue("empl")
public class Employee extends Person {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2667566374742132716L;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(//
			name = "EMP_PROJ", //
			joinColumns = @JoinColumn(name = "EMPLOYEE_ID"), //
			inverseJoinColumns = @JoinColumn(name = "PROJECT_ID"))
	private List<Project> projects;

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
}
