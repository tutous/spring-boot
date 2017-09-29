package org.spring.boot.sample.data.rest;

import java.util.UUID;

import javax.persistence.EntityManager;

import org.spring.boot.sample.data.rest.domain.Address;
import org.spring.boot.sample.data.rest.domain.Employee;
import org.spring.boot.sample.data.rest.domain.Manager;
import org.spring.boot.sample.data.rest.domain.Project;
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
			// address
			Address addressWob = new Address();
			addressWob.setCity("Wolfsburg");
			addressWob.setStreet("Street");
			addressWob.setStreetNumber("1");
			addressWob.setZip("12345");
			entityManager.persist(addressWob);
			// anton
			Employee anton = new Employee();
			anton.setFirstName("Anton");
			anton.setLastName("Sluga");
			anton.setUuid(UUID.randomUUID());
			anton.setAddress(addressWob);
			entityManager.persist(anton);
			// anni
			Employee anni = new Employee();
			anni.setFirstName("Anni");
			anni.setLastName("Sluga");
			anni.setUuid(UUID.randomUUID());
			anni.setAddress(addressWob);
			entityManager.persist(anni);
			// sabine
			Employee sabine = new Employee();
			sabine.setFirstName("Sabine");
			sabine.setLastName("Sluga");
			sabine.setUuid(UUID.randomUUID());
			sabine.setAddress(addressWob);
			entityManager.persist(sabine);
			// manager
			Manager uwe = new Manager();
			uwe.setFirstName("Uwe");
			uwe.setLastName("Sluga");
			uwe.setUuid(UUID.randomUUID());
			uwe.setAddress(addressWob);
			uwe.add(anton);
			uwe.add(anni);
			uwe.add(sabine);
			entityManager.persist(uwe);
			// family
			Project family = new Project();
			family.setName("family");
			family.setDescription("family sluga");
			family.setUuid(UUID.randomUUID());
			family.add(anton);
			family.add(anni);
			family.add(sabine);
			family.add(uwe);
			entityManager.persist(family);
			// school
			Project childs = new Project();
			childs.setName("childs");
			childs.setDescription("childs sluga");
			childs.setUuid(UUID.randomUUID());
			childs.add(anton);
			childs.add(anni);
			anni.add(childs);
			anni.add(family);
			anton.add(childs);
			anton.add(family);
			sabine.add(family);
			uwe.add(family);
			entityManager.persist(childs);
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
