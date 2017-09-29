package org.spring.boot.sample.data.rest.repository;

import java.util.List;
import java.util.UUID;

import org.spring.boot.sample.data.rest.domain.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Projection(types = { Employee.class })
@JsonPropertyOrder(value = { "uuid", "firstName", "lastName", "address" })
public interface EmployeeResource {

	@JsonProperty("uuid")
	public UUID getUuid();

	@JsonProperty("firstName")
	public String getFirstName();

	@JsonProperty("lastName")
	public String getLastName();

	@Value("#{target.address.zip} #{target.address.city}, #{target.address.street} #{target.address.streetNumber}")
	@JsonProperty("address")
	public String getAddress();

}
