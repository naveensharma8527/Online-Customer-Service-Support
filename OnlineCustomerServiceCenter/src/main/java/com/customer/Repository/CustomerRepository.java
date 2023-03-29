package com.customer.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.customer.Entity.Customer;

public interface CustomerRepository  extends JpaRepository<Customer, Integer>{
	
	@Query("select c from Customer c where c.firstName = ?1")
	public List<Customer> findCustomerByFirstName(String name);
	
//	@Query("select c from Customer c where c.email = ?1")
	public Customer findCustomerByEmail(String email);
	
	public Customer findCustomerByMobile(String email);
}
