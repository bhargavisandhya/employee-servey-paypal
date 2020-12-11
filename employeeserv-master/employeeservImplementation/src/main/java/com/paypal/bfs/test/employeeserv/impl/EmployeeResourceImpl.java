package com.paypal.bfs.test.employeeserv.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.Entity.Address;
import com.paypal.bfs.test.employeeserv.api.Entity.Employee;
import com.paypal.bfs.test.employeeserv.exception.NoDataFoundException;
import com.paypal.bfs.test.employeeserv.repository.EmployeeRepository;

/**
 * Implementation class for employee resource.
 */
@RestController
public class EmployeeResourceImpl implements EmployeeResource {

	private static Integer count=1;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public ResponseEntity<Employee> employeeGetById(@PathVariable("id") String id) {
		Optional<Employee> employee = employeeRepository.findById(Integer.valueOf(id));
		if (employee.isPresent()) {
			return new ResponseEntity<>(employee.get(), HttpStatus.OK);
		} else {
			throw new NoDataFoundException("No Task Found for task Id : ");
		}
	}

	@Override
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
		Integer employeeId = count++;
		if(employee.getAddresses()!=null) {
			for (Address address : employee.getAddresses()) {
				address.setId(UUID.randomUUID().toString());
				address.setEmployeeId(employeeId);
			}
		}
		employee.setId(employeeId);
		Employee dbemployee = employeeRepository.save(employee);
		return new ResponseEntity<>(dbemployee, HttpStatus.CREATED);
	}

}
