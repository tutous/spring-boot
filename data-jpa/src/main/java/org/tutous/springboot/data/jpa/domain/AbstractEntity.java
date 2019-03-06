package org.tutous.springboot.data.jpa.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.springframework.data.domain.Persistable;
import org.springframework.data.util.ProxyUtils;

@MappedSuperclass
public abstract class AbstractEntity<PK extends Serializable> implements Persistable<PK> {

	@Transient
	public boolean isNew() {
		return Objects.isNull(getId());
	}

	@Override
	public boolean equals(Object obj) {

		if (null == obj) {
			return false;
		}

		if (this == obj) {
			return true;
		}

		if (!getClass().equals(ProxyUtils.getUserClass(obj))) {
			return false;
		}

		AbstractEntity<?> that = (AbstractEntity<?>) obj;

		return null == this.getId() ? false : this.getId().equals(that.getId());
	}

	@Override
	public int hashCode() {

		int hashCode = 17;

		hashCode += null == getId() ? 0 : getId().hashCode() * 31;

		return hashCode;
	}

}
