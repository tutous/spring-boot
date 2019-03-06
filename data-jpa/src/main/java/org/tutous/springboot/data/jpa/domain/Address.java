package org.tutous.springboot.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.lang.Nullable;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Validated
@DynamicUpdate
@Table(name = "ADDRESS")
@JsonIgnoreProperties(value = { "new", "id", "handler", "hibernateLazyInitializer" })
public class Address extends AbstractEntity<Long> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -298502234984848767L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address-generator")
	@SequenceGenerator(name = "address-generator", sequenceName = "address_sequence", allocationSize = 1)
	@Nullable
	private Long id;

	@NotNull
	@Column(name = "CITY")
	@JsonProperty(value = "city")
	private String city;

	@NotNull
	@Column(name = "STREET")
	@JsonProperty(value = "street")
	private String street;

	@NotNull
	@Column(name = "STREET_NUMBER")
	@JsonProperty(value = "streetNumber")
	private String streetNumber;

	@NotNull
	@Column(name = "ZIP")
	@JsonProperty(value = "zip")
	private String zip;

	@Override
	public Long getId() {
		return id;
	}

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
