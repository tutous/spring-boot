package org.spring.boot.sample.data.rest.domain;

import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NaturalId;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.hateoas.Identifiable;
import org.springframework.util.ClassUtils;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Validated
@DynamicUpdate
@Table(name = "EMPLOYEE")
@JsonIgnoreProperties(value = { "new", "uuid", "id" })
public class Employee extends AbstractPersistable<Long> implements Identifiable<Long> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2667566374742132716L;

	@NotNull
	@Column(name = "FIRST_NAME")
	private String firstName;

	@NotNull
	@Column(name = "FAMILY_NAME")
	private String familyName;

	@NaturalId
	@Column(name = "UUID")
	private UUID uuid;

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

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		if (uuid == null) {
			return;
		}
		this.uuid = uuid;
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

		return null == this.getUuid() ? false : this.getUuid().equals(that.getUuid());
	}

	@Override
	public int hashCode() {

		int hashCode = 17;

		hashCode += null == getUuid() ? 0 : getUuid().hashCode() * 31;

		return hashCode;
	}

}
