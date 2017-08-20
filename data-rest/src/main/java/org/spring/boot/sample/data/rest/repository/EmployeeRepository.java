package org.spring.boot.sample.data.rest.repository;

import org.spring.boot.sample.data.rest.domain.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = EmployeeSimple.class)
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
