package com.customer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.Entity.Operator;

@Repository
public interface OperatorDao  extends JpaRepository<Operator, Integer>{
	
}
