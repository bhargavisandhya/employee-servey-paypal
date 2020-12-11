package com.paypal.bfs.test.employeeserv.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.paypal.bfs.test.employeeserv.api.Entity.Employee;

/**
 * Interface for employee resource operations.
 */
public interface EmployeeResource {

    /**
     * Retrieves the {@link EmployeeResource} resource by id.
     *
     * @param id employee id.
     * @return {@link EmployeeResource} resource.
     */
    @GetMapping("/v1/bfs/employees/{id}")
    ResponseEntity<Employee> employeeGetById(@PathVariable("id") String id);


    @PostMapping("/v1/bfs/employees")
    ResponseEntity<Employee> createEmployee(final @RequestBody Employee employee);
   
}
