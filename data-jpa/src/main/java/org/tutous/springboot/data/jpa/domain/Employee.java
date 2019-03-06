package org.tutous.springboot.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.lang.Nullable;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Validated
@DynamicUpdate
@Table(name = "EMPLOYEE")
@DiscriminatorValue("empl")
public class Employee extends AbstractEntity<Long> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2667566374742132716L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee-generator")
	@SequenceGenerator(name = "employee-generator", sequenceName = "employee_sequence", allocationSize = 1)
	@Nullable
	private Long id;

	@NotNull
	@Column(name = "FIRST_NAME")
	private String firstName;

	@NotNull
	@Column(name = "LAST_NAME")
	private String lastName;

	@NotNull
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	@JsonProperty(value = "address")
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
