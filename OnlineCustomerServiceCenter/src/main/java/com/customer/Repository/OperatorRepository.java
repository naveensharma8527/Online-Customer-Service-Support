package com.customer.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.customer.Entity.Customer;
import com.customer.Entity.Operator;

public interface OperatorRepository  extends JpaRepository<Operator, Integer>{
	
	
	
}
