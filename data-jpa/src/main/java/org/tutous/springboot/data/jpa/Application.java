package org.tutous.springboot.data.jpa;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.transaction.annotation.Transactional;
import org.tutous.springboot.data.jpa.domain.Address;
import org.tutous.springboot.data.jpa.domain.Employee;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableSpringDataWebSupport
@SpringBootApplication
public class Application implements CommandLineRunner {

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
	public void run(String... args) throws Exception {
		
	}

//	@Autowired
//	private EntityManager entityManager;
//
//	@Override
//	@Transactional
//	public void run(String... args) throws Exception {
//		// if (initTestData(args)) {
//		// address
//		Address addressWob = new Address();
//		addressWob.setCity("Wolfsburg");
//		addressWob.setStreet("Street");
//		addressWob.setStreetNumber("1");
//		addressWob.setZip("12345");
//		entityManager.persist(addressWob);
//		// anton
//		Employee anton = new Employee();
//		anton.setFirstName("Anton");
//		anton.setLastName("Sluga");
//		anton.setAddress(addressWob);
//		entityManager.persist(anton);
//		// anni
//		Employee anni = new Employee();
//		anni.setFirstName("Anni");
//		anni.setLastName("Sluga");
//		anni.setAddress(addressWob);
//		entityManager.persist(anni);
//		// sabine
//		Employee sabine = new Employee();
//		sabine.setFirstName("Sabine");
//		sabine.setLastName("Sluga");
//		sabine.setAddress(addressWob);
//		entityManager.persist(sabine);
//		// Uwe
//		Employee uwe = new Employee();
//		uwe.setFirstName("Uwe");
//		uwe.setLastName("Sluga");
//		uwe.setAddress(addressWob);
//		entityManager.persist(uwe);
//		// }
//
//	}
//
//	private boolean initTestData(String[] args) {
//		for (String arg : args) {
//			if ("init.test.data=true".equals(arg)) {
//				return true;
//			}
//		}
//		return false;
//	}

}
