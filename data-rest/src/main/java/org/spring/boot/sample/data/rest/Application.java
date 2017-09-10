package org.spring.boot.sample.data.rest;

import java.util.UUID;

import javax.persistence.EntityManager;

import org.spring.boot.sample.data.rest.domain.Address;
import org.spring.boot.sample.data.rest.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.transaction.annotation.Transactional;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableSpringDataWebSupport
@Import({ SpringDataRestConfiguration.class })
@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private EntityManager entityManager;
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)//
				.select().apis(RequestHandlerSelectors.any())//
				.paths(PathSelectors.any()).build();
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		if (initTestData(args)) {
			Employee empl1 = new Employee();
			empl1.setFirstName("Uwe");
			empl1.setLastName("Sluga");
			empl1.setUuid(UUID.randomUUID());
			Address address1 = new Address();
			address1.setCity("Wolfsburg");
			address1.setStreet("Street");
			address1.setStreetNumber("1");
			address1.setZip("12345");
			empl1.setAddress(address1);
			entityManager.persist(address1);
			entityManager.persist(empl1);
		}

	}

	private boolean initTestData(String[] args) {
		for (String arg : args) {
			if ("init.test.data=true".equals(arg)) {
				return true;
			}
		}
		return false;
	}

}
