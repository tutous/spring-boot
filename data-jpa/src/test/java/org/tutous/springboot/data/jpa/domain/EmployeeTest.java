package org.tutous.springboot.data.jpa.domain;

import static org.assertj.core.api.Assertions.assertThat;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import org.tutous.springboot.data.jpa.Application;
import org.tutous.springboot.data.jpa.repository.EmployeeRepository;

@Transactional
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
public class EmployeeTest {

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private EmployeeRepository employeeRepository;

	@BeforeEach
	public void setUp() {
		Address addressWob = new Address();
		addressWob.setCity("Wolfsburg");
		addressWob.setStreet("Street");
		addressWob.setStreetNumber("1");
		addressWob.setZip("12345");
		persistAndFlush(addressWob);
		Employee uwe = new Employee();
		uwe.setFirstName("Uwe");
		uwe.setLastName("Sluga");
		uwe.setAddress(addressWob);
		persistAndFlush(uwe);
	}

	@Test
	@Rollback
	public void testFinder() {
		assertThat(employeeRepository.findById(new Long(1)).get().getId()).isEqualTo(1);
	}

	public <T extends AbstractEntity<Long>> void persistAndFlush(T entity) {
		entityManager.persist(entity);
		entityManager.flush();
	}

}
