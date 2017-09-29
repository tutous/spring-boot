package org.spring.boot.sample.controller

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

import org.spring.boot.sample.domain.Employee
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.web.servlet.MockMvc

import com.fasterxml.jackson.databind.ObjectMapper

import spock.lang.Specification

@SpringBootIntegrationTest
class EmployeeControllerTest extends Specification {


	@Autowired
	private MockMvc mvc;

	@Autowired
	private TestRestTemplate restTemplate;

	def "test get version"(){

		setup:
		def url ="http://localhost:8080/version"

		when:
		def response = mvc.perform(get(url));

		then:
		response != null

		expect:
		response.andExpect(status().is(httpStatus)).andExpect(content().string(controllerVersion))

		where:
		httpStatus = 200
		controllerVersion = "1.0"
	}

	def "test get employee by id"(){

		given: "get emplyee by givenId"
		def response = mvc.perform(get("http://localhost:8080/employee/" + givenId));

		expect:
		if(!expectedError) {
			def om = new ObjectMapper();
			def emplyee = new Employee(givenId, expectedFirstName, expectedFamilyName)
			def jsonContent = om.writeValueAsString(emplyee);
			response.andExpect(content().json(jsonContent)).andExpect(status().is(expectedStatus))
		}
		else {
			response.andExpect(status().is(expectedStatus));
		}

		where:
		givenId || expectedFirstName || expectedFamilyName || expectedStatus || expectedError
		1       || "Uwe"             || "Sluga"            || 200            || false
		2       || "Anni"            || "Sluga"            || 200            || false
		3       || "Anton"           || "Sluga"            || 200            || false
		5       || null              || null               || 404            || true
	}
}
