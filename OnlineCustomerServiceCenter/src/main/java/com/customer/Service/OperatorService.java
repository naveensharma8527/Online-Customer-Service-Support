package com.customer.Service;

import java.util.List;

import com.customer.Entity.Customer;
import com.customer.Entity.Issue;
import com.customer.Entity.Status;
import com.customer.Exception.CustomerException;
import com.customer.Exception.IssueException;

public interface OperatorService {
	
	public String AddCustomerIssue(Issue issue) throws IssueException;
	
	public String UpdateIssue(Issue issue) throws IssueException;
	
	public String closeCustomerIssue(Integer IssueId, Status status) throws IssueException;
	
	public List<Customer> findAllCustomer() throws CustomerException;
	
	public Customer findByCustomerId(Integer cusId) throws CustomerException;
	
	public List<Customer> findCustomerByFirstName(String name) throws CustomerException;
	
	public Customer findCustomerByEmail(String email) throws CustomerException;
	
	public Customer findCustomerByMobile(String mobile) throws CustomerException;


	
	
	

}
