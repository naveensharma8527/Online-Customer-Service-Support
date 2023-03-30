package com.customer.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.customer.Entity.Customer;	

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("from Customer c where c.email=?1")
	public Customer findByEmail(String email);
  
	@Query("select c from Customer c where c.firstName = ?1")
	public List<Customer> findCustomerByFirstName(String name);
	
	public Customer findCustomerByMobile(String mobileNo);
}
