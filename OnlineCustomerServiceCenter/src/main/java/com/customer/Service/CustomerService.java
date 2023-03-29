package com.customer.Service;

import java.util.List;

import com.customer.Entity.Customer;
import com.customer.Entity.Issue;
import com.customer.Entity.Login;
import com.customer.Exception.CustomerException;

public interface CustomerService {
	
	public Customer registerCustomer(Customer customer);
	
	public String changePassword(Login login) throws CustomerException;
	public String forgetPassword(Integer id) throws CustomerException;
	public Customer emailPassword(Integer id,String key) throws CustomerException;
	public Issue viewissue(Integer id, String key) throws CustomerException;
	public List<Issue> getAllIssue(Integer id,String key) throws CustomerException;
	public String reopenIssue(Integer id, Integer cid, String key) throws CustomerException;
}
