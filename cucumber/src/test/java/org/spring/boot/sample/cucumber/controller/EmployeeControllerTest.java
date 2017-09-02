package org.spring.boot.sample.cucumber.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.spring.boot.sample.cucumber.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@CucumberIntegrationConf
public class EmployeeControllerTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private TestRestTemplate restTemplate;

	private ResultActions response;
	private Integer givenMajor, givenMinor, givenEmployeeId;

	/**
	 * Scenario: get version
	 */

	@Given("^valid version (\\d+)\\.(\\d+)$")
	public void valid_version(Integer major, Integer minor) throws Throwable {
		this.givenMajor = major;
		this.givenMinor = minor;
	}

	@When("^get version$")
	public void get_version() throws Throwable {
		response = mvc.perform(get("http://localhost:8080/version"));
	}

	@Then("^version response status code is (\\d+)$")
	public void version_request_status_code_is(int status) throws Throwable {
		response.andExpect(status().is(status));
	}

	@Then("^receives version (\\d+)\\.(\\d+)$")
	public void receives_version(Integer major, Integer minor) throws Throwable {
		response.andExpect(content().string(major + "." + minor));
		Assert.assertThat(this.givenMajor, Matchers.equalTo(major));
		Assert.assertThat(this.givenMinor, Matchers.equalTo(minor));
	}

	/**
	 * Scenario: get employee by id
	 */

	@When("^get employee (\\d+)$")
	public void get_employee(int employeeId) throws Throwable {
		this.givenEmployeeId = employeeId;
		response = mvc.perform(get("http://localhost:8080/employee/" + employeeId));
	}

	@Then("^the employee response status code is (\\d+)$")
	public void the_employee_response_status_code_is(int status) throws Throwable {
		response.andExpect(status().is(status));
	}

	@Then("^the employee value contains \"([^\"]*)\", \"([^\"]*)\"$")
	public void the_employee_value_should_contain(String firstName, String familyName) throws Throwable {
		ObjectMapper om = new ObjectMapper();
		String jsonContent = om.writeValueAsString(new Employee(givenEmployeeId, firstName, familyName));
		response.andExpect(content().json(jsonContent));
	}

	@Then("^the employee value contains , $")
	public void the_employee_value_contains() throws Throwable {
		// is called by status code 404
	}

}
