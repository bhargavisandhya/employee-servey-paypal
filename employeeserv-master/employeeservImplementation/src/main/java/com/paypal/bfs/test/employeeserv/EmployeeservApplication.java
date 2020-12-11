package com.paypal.bfs.test.employeeserv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = { "com.paypal.bfs.test.employeeserv.repository"})
@ComponentScan(basePackages = { "com.paypal.bfs" })
public class EmployeeservApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmployeeservApplication.class, args);
    }
}