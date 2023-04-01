package com.customer.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.Entity.Operator;

@Repository
public interface OperatorRepository  extends JpaRepository<Operator, Integer>{
	
	public Operator findByEmail(String email);
	
}
