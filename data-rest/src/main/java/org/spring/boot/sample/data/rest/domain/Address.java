package org.spring.boot.sample.data.rest.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Validated
@DynamicUpdate
@Table(name = "ADDRESS")
@JsonIgnoreProperties(value = { "new", "id" })
public class Address extends AbstractPersistable<Long> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -298502234984848767L;

	@NotNull
	@Column(name = "CITY")
	@JsonProperty(value="city")
	private String city;

	@NotNull
	@Column(name = "STREET")
	@JsonProperty(value="street")
	private String street;

	@NotNull
	@Column(name = "STREET_NUMBER")
	@JsonProperty(value="streetNumber")
	private String streetNumber;
	
	@NotNull
	@Column(name = "ZIP")
	@JsonProperty(value="zip")
	private String zip;
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

}
