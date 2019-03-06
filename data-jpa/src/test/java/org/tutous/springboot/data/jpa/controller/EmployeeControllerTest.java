package org.tutous.springboot.data.jpa.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.tutous.springboot.data.jpa.domain.Address;
import org.tutous.springboot.data.jpa.domain.Employee;
import org.tutous.springboot.data.jpa.repository.EmployeeRepository;
import org.tutous.springboot.data.jpa.service.EmployeeService;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
//@AutoConfigureMockMvc()
public class EmployeeControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private EmployeeService mockEmployeeService;

	private List<Employee> employees;

	@Before
	public void setUp() {
		employees = new ArrayList<>();
		Address addressWob = new Address();
		addressWob.setCity("Wolfsburg");
		addressWob.setStreet("Street");
		addressWob.setStreetNumber("1");
		addressWob.setZip("12345");
		Employee uwe = new Employee();
		uwe.setId(new Long(1));
		uwe.setFirstName("Uwe");
		uwe.setLastName("Sluga");
		uwe.setAddress(addressWob);
		employees.add(uwe);
	}

	@Test
	public void testGetEmployeesOk() throws Exception {
		given(mockEmployeeService.getEmployees()).willReturn(employees);

		mvc.perform(get("/employees") //
				.accept(MediaType.APPLICATION_JSON_UTF8)) //
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].id").value("1"));

	}
}
