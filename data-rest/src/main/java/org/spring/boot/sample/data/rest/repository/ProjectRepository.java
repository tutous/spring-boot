package org.spring.boot.sample.data.rest.repository;

import org.spring.boot.sample.data.rest.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource()
public interface ProjectRepository extends CrudRepository<Project, Long> {

}
