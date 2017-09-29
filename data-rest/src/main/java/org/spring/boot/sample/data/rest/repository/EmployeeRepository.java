package org.spring.boot.sample.data.rest.repository;

import java.util.UUID;

import org.spring.boot.sample.data.rest.domain.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = EmployeeResource.class)
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	@Query(value = "select e from Employee e where e.uuid =:uuid")
	public Employee findByUuid(@Param("uuid") UUID uuid);

}
