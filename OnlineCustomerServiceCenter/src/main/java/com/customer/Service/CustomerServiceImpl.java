package com.customer.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.Entity.Customer;
import com.customer.Entity.Issue;
import com.customer.Entity.Login;
import com.customer.Exception.CustomerException;
import com.customer.Repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository cr;

	@Override
	public Customer registerCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return cr.save(customer);
	}

	@Override
	public String changePassword(Login login) throws CustomerException {
		// TODO Auto-generated method stub
		
		Customer c = cr.findByEmail(login.getEmail());
		
		if(c==null) {
			throw new CustomerException("Invalid Credentials");
		}
		
		c.setPassword("123456789");
		cr.save(c);
		return "Your Temporary Password is '123456789'";
	}

	@Override
	public String forgetPassword(Integer id) throws CustomerException {
		// TODO Auto-generated method stub
		
		Customer c = cr.findById(id).get();
		
		if(c==null) {
			throw new CustomerException("Invalid Customer id");
		}
		c.setPassword("123456789");
		cr.save(c);
		return "Your Temporary Password is '123456789'";
	}

	@Override
	public Customer emailPassword(Integer id, String key) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Issue viewissue(Integer id, String key) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Issue> getAllIssue(Integer id, String key) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String reopenIssue(Integer id, Integer cid, String key) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

}
