package com.customer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.customer.Entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("from Customer c where c.email=?1")
	public Customer findByEmail(String email);
}
