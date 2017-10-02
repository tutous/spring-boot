package org.spring.boot.sample.data.rest.repository;

import java.util.UUID;

import org.spring.boot.sample.data.rest.domain.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(excerptProjection = EmployeeResource.class)
public interface EmployeeRepository extends CrudRepository<Employee, Long>, PagingAndSortingRepository<Employee, Long> {

	@RestResource(path = "resource", rel = "resource")
	@Query(value = "select e from Employee e where e.uuid =:resourceId")
	public Employee findByResourceId(@Param("resourceId") UUID resourceId);

	@RestResource(path = "lastNameStartsWith", rel = "lastNameStartsWith")
	public Page<Employee> findByLastNameStartsWith(@Param("lastName") String name, Pageable p);

}
