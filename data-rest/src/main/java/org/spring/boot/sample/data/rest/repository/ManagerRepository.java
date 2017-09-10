package org.spring.boot.sample.data.rest.repository;

import org.spring.boot.sample.data.rest.domain.Manager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource()
public interface ManagerRepository extends CrudRepository<Manager, Long> {

}
