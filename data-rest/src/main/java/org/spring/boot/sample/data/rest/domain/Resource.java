package org.spring.boot.sample.data.rest.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.NaturalId;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.hateoas.Identifiable;
import org.springframework.util.ClassUtils;

@MappedSuperclass
public class Resource extends AbstractPersistable<Long> implements Identifiable<Long> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6486643787050552905L;

	@NaturalId
	@Column(name = "UUID")
	private UUID uuid;

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
