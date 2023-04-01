package com.customer.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.Entity.CurrentUserSession;
import com.customer.Entity.Customer;
import com.customer.Entity.Issue;
import com.customer.Entity.Login;
import com.customer.Entity.Status;
import com.customer.Exception.CustomerException;
import com.customer.Repository.CurrentUserSessionRepository;
import com.customer.Repository.CustomerRepository;
import com.customer.Repository.IssueRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository cr;
	
	@Autowired
	private CurrentUserSessionRepository currentsession;
	
	@Autowired
	private IssueRepository issueRepo;

	@Override
	public Customer registerCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		List<Issue> issue = customer.getIssue();
		
		for(Issue i:issue) {
			i.setCustomer(customer);
		}
		return cr.save(customer);
	}

	@Override
	public String changePassword(Login login) throws CustomerException {
		// TODO Auto-generated method stub
		
		Customer c = cr.findByEmail(login.getEmail());
		
		if(c==null) {
			throw new CustomerException("Invalid Credentials");
		}
		
		c.setPassword(login.getPassword());
		cr.save(c);
		return "Password Changed";
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
	public Customer emailPassword(Integer id) throws CustomerException {
		// TODO Auto-generated method stub
		
		Customer c = cr.findById(id).get();
		
		if(c==null) {
			throw new CustomerException("Invalid Customer Id");
		}
		else {
			return c;
		}
	}

	@Override
	public Issue viewissue(Integer id, String key) throws CustomerException {
		// TODO Auto-generated method stub
		
		CurrentUserSession session = currentsession.findByUuid(key);
		
		if(session==null) {
			throw new CustomerException("Please Login to continue");
		}
		else {
			Issue i = issueRepo.findById(id).get();
			
			if(i==null) {
				throw new CustomerException("No Issue find with Id: "+id);
			}
			else {
				return i;
			}
		}
		
	}

	@Override
	public List<Issue> getAllIssue(String key) throws CustomerException {
		// TODO Auto-generated method stub
		
		CurrentUserSession session = currentsession.findByUuid(key);
		
		if(session==null) {
			throw new CustomerException("Please Login to continue");
		}
		else {
			List<Issue> i = cr.findById(session.getId()).get().getIssue();
			
			if(i==null) {
				throw new CustomerException("No Issue found");
			}
			else {
				return i;
			}
		}
		
	}

	@Override
	public String reopenIssue(Integer id,String key) throws CustomerException {
		// TODO Auto-generated method stub
		CurrentUserSession session = currentsession.findByUuid(key);
		if(session==null) {
			throw new CustomerException("Please Login to continue");
		}
		else {
			Customer c = cr.findById(session.getId()).get();
			
			List<Issue> listIssue = c.getIssue();
			
			Issue issue = null;
			
			for(Issue I: listIssue) {
				if(I.getIssueId()==id) {
					issue = I;
				}
			}
			
			if(issue==null) {
				throw new CustomerException("Invalid Issue Id");
			}
			else {
				issue.setStatus(Status.Open);
				cr.save(c);
				return "Issue Opened Succesfully";
			}
		}
	}
}
