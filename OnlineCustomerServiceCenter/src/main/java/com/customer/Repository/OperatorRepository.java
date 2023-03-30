package com.customer.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.Entity.Operator;

public interface OperatorRepository  extends JpaRepository<Operator, Integer>{
	
	
	
}
