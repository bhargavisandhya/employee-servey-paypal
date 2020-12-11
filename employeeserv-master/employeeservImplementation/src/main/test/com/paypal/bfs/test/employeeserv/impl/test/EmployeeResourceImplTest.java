package com.paypal.bfs.test.employeeserv.impl.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paypal.bfs.test.employeeserv.api.Entity.Address;
import com.paypal.bfs.test.employeeserv.api.Entity.Employee;
import com.paypal.bfs.test.employeeserv.impl.EmployeeResourceImpl;
import com.paypal.bfs.test.employeeserv.repository.EmployeeRepository;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeResourceImplTest {

	private MockMvc mockMvc;

	@InjectMocks
	EmployeeResourceImpl employeeResourceImpl;

	@Mock
	EmployeeRepository employeeRepository;

	private Employee employee;

	private ObjectMapper mapper = new ObjectMapper();

	@Before
	public void setUp() throws Exception {
		employee = new Employee();
		employee.setFirstName("Bhavya");
		employee.setLastName("Singh");
		List<Address> addresses=new ArrayList();
		Address address=new Address("test", "test", "test", "test", "test", "test");
		addresses.add(address);
		employee.setAddresses(addresses);
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(employeeResourceImpl)
				.setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver()).build();
	}

	@Test
	public void testEmployeeGetById() throws Exception {
		Mockito.when(employeeRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(employee));
		this.mockMvc.perform(get("/v1/bfs/employees/{id}", 1).accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
	}

	@Test
	public void testCreateEmployee() throws Exception {
		Mockito.when(employeeRepository.save(Mockito.any())).thenReturn(employee);

		String postModel = mapper.writeValueAsString(employee);
		this.mockMvc.perform(post("/v1/bfs/employees").contentType(MediaType.APPLICATION_JSON).content(postModel))
				.andExpect(status().isCreated());
	}
}
