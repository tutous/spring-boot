package org.spring.boot.sample.domain;

import javax.validation.constraints.NotNull;

import org.springframework.util.ClassUtils;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {

	@NotNull
	@JsonProperty(value = "id")
	private Integer id = null;

	@NotNull
	@JsonProperty(value = "firstName")
	private String firstName = null;

	@NotNull
	@JsonProperty(value = "familyName")
	private String familyName = null;

	public Employee(Integer id, String firstName, String familyName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.familyName = familyName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	@Override
	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}

		if (this == obj) {
			return true;
		}

		if (!getClass().equals(ClassUtils.getUserClass(obj))) {
			return false;
		}

		Employee that = (Employee) obj;

		return null == this.getId() ? false : this.getId().equals(that.getId());
	}

	@Override
	public int hashCode() {

		int hashCode = 17;

		hashCode += null == getId() ? 0 : getId().hashCode() * 31;

		return hashCode;
	}

	@Override
	public String toString() {
		return new StringBuilder(Employee.class.getSimpleName()).append('{')//
				.append("id=").append(id)//
				.append(",firstName=").append(firstName)//
				.append(",familyName").append(familyName)//
				.append('}').toString();
	}
}
