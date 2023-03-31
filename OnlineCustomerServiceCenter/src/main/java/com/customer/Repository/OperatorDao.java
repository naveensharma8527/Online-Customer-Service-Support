package com.customer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.Entity.Operator;

public interface OperatorDao  extends JpaRepository<Operator, Integer>{
	
}
