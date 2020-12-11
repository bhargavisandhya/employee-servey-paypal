package com.paypal.bfs.test.employeeserv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paypal.bfs.test.employeeserv.api.Entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {

}
