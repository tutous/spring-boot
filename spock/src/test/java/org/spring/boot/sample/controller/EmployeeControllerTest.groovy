package org.spring.boot.sample.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.web.servlet.MockMvc

import spock.lang.Specification

@SpringBootIntegrationTest
class EmployeeControllerTest extends Specification {


	@Autowired
	private MockMvc mvc;

	@Autowired
	private TestRestTemplate restTemplate;

	def "testGetVersion"(){

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
}
