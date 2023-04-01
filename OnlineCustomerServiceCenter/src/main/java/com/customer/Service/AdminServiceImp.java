package com.customer.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.DTO.OperatorDTO;
import com.customer.Entity.CurrentUserSession;
import com.customer.Entity.Department;
import com.customer.Entity.Operator;
import com.customer.Exception.DepartmentException;
import com.customer.Exception.LoginException;
import com.customer.Exception.OperatorException;
import com.customer.Repository.AdminRepository;
import com.customer.Repository.CurrentUserSessionRepository;
import com.customer.Repository.DepartmentDao;
import com.customer.Repository.OperatorDao;


@Service
public class AdminServiceImp implements AdminService{
	
	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired
	private DepartmentDao deptDao;
	
	
	@Autowired
	private OperatorDao optDao;
	
	@Autowired
	private CurrentUserSessionRepository cDao;
	
	

	@Override
	public Department addDepartment(Department d, String key) throws LoginException {
		// TODO Auto-generated method stub
		
		// verify login with given key 
		CurrentUserSession cs =   cDao.findByUuid(key);
		if(cs != null && cs.getUser_Type().equalsIgnoreCase("Admin")) {
			Department d1 = deptDao.save(d);
			
			return d1;
		}else {
			 throw new LoginException("You are not authorized to add department");
		}
		
		
	}

	@Override
	public Department updateDepartment(Department d, String key) throws DepartmentException, LoginException {
		// TODO Auto-generated method stub
		         
		            
		           
		       // verify login with given key 
		CurrentUserSession cs =   cDao.findByUuid(key);
		if(cs != null && cs.getUser_Type().equalsIgnoreCase("Admin")) {
					Department d1 = deptDao.findById(d.getDeptId()).orElseThrow(() -> new DepartmentException("There is not deparmtent with id "+d.getDeptId()));
					  d1.setDeptName(d.getDeptName());
					  d1.getOperators().addAll(d.getOperators());
					return deptDao.save(d1);
				}else {
					 throw new LoginException("You are not authorized to update department");
				}
	}

	@Override
	public Department removeDepartment(Integer id, String key) throws DepartmentException, LoginException {
		// TODO Auto-generated method stub
		   // verify login with given key 
		CurrentUserSession cs =   cDao.findByUuid(key);
		if(cs != null && cs.getUser_Type().equalsIgnoreCase("Admin")) {
			Department d1 = deptDao.findById(id).orElseThrow(() -> new DepartmentException("There is not deparmtent with id "+id));
			 
			 deptDao.delete(d1);
			 return d1;
		}else {
			 throw new LoginException("You are not authorized to update department");
		}
	}

	@Override
	public Department getDepartmentById(Integer id, String key) throws DepartmentException, LoginException {
		// TODO Auto-generated method stub
		   // verify login with given key 
		CurrentUserSession cs =   cDao.findByUuid(key);
		if(cs != null && cs.getUser_Type().equalsIgnoreCase("Admin")) {
				Department d1 = deptDao.findById(id).orElseThrow(() -> new DepartmentException("There is not deparmtent with id "+id));
				 
				 return d1;
			}else {
				 throw new LoginException("You are not authorized to Admin to get department");
			}
	}

	@Override
	public Operator addOperator(Operator o, String key) throws LoginException {
		// TODO Auto-generated method stub
		   // verify login with given key 
		CurrentUserSession cs =   cDao.findByUuid(key);
		if(cs != null && cs.getUser_Type().equalsIgnoreCase("Admin")) {
						  return optDao.save(o);
						 
						 
					}else {
						 throw new LoginException("You are not authorized as Admin so you cannot add a operator");
					}
	}

	@Override
	public OperatorDTO assignDeptToOperator(Integer oid, Integer did, String key)
			throws DepartmentException, OperatorException, LoginException {
		// TODO Auto-generated method stub
		CurrentUserSession cs =   cDao.findByUuid(key);
		if(cs != null && cs.getUser_Type().equalsIgnoreCase("Admin")) {
		
			//find the department 
		      Department dept =	    deptDao.findById(did).orElseThrow(() -> new DepartmentException("There is no department with this id "+did));
			Operator  opt =		 optDao.findById(oid).orElseThrow(() -> new OperatorException("There is no operator with this  id "+oid));
						  
			      opt.setDepartment(dept);
			      dept.getOperators().add(opt);
			      
			      deptDao.save(dept);
			      optDao.save(opt);
			      
			      return new OperatorDTO(opt.getOperatorId(), dept.getDeptId());
					}else {
						 throw new LoginException("You are not authorized as Admin so you cannot add a operator");
					}
	}

	@Override
	public Operator updateOperator(Operator o, String key) throws OperatorException, LoginException {
		// TODO Auto-generated method stub
		 // verify login with given key 
		CurrentUserSession cs =   cDao.findByUuid(key);
		if(cs != null && cs.getUser_Type().equalsIgnoreCase("Admin")) {
			  Operator opt =      optDao.findById(o.getOperatorId()).orElseThrow(() -> new OperatorException("There is no operator associated with thid operatorId "+o.getOperatorId()));
			 
			  // update the operator --
			  
			  
			  // update the first name 
			  if(o.getFirstName() != null) {
				   opt.setFirstName(o.getFirstName());
			  }
			  
			  //update the last name 
			  if(o.getLastName() != null) {
				   opt.setLastName(o.getLastName());
			  }
			  
			  // update department
			  if(o.getDepartment() != null) {
				   opt.setDepartment(o.getDepartment());
			  }
			  
			  
			  // update city 
			  if(o.getCity() != null) {
				   opt.setCity(o.getCity());
			  }
			  
			  // update email
			  if(o.getEmail() != null) {
				   opt.setEmail(o.getEmail());
			  }
			  
			  // update the password 
			  if(o.getPassword() != null) {
				    opt.setPassword(o.getPassword());
			  }
			  
			  //update the call list 
			  if(!o.getCall().isEmpty()) {
				     opt.getCall().clear();
				     opt.getCall().addAll(o.getCall());
			  }
			  
			  
			  
			         return  optDao.save(opt);
			 
		}else {
			 throw new LoginException("You are not authorized as Admin so you cannot update a operator");
		}
	}

	@Override
	public Operator deleteOperator(Integer id, String key) throws OperatorException, LoginException {
		// TODO Auto-generated method stub
		
		 // verify login with given key 
		CurrentUserSession cs =   cDao.findByUuid(key);
		if(cs != null && cs.getUser_Type().equalsIgnoreCase("Admin")) {
			Operator opt =     optDao.findById(id).orElseThrow(() -> new OperatorException("There is no operator with this id "+ id));
			 
			
		    	optDao.delete(opt);
		    	
		    	return opt;
			 
		}else {
			 throw new LoginException("You are not authorized as Admin so you cannot delete a operator");
		}
		
	}

	@Override
	public List<Operator> getAllOperators(String key) throws LoginException {
		// TODO Auto-generated method stub
		
		
		 // verify login with given key 
		CurrentUserSession cs =   cDao.findByUuid(key);
		if(cs != null && cs.getUser_Type().equalsIgnoreCase("Admin")) {
			  
		   return	optDao.findAll();
			 
			 
		}else 
			 throw new LoginException("You are not authorized as Admin");
	}

	@Override
	public Operator getOperatorById(Integer id, String key) throws OperatorException, LoginException {
		// TODO Auto-generated method stub
		 // verify login with given key 
		CurrentUserSession cs =   cDao.findByUuid(key);
		if(cs != null && cs.getUser_Type().equalsIgnoreCase("Admin")) {
			  
		  return optDao.findById(id).orElseThrow(() -> new OperatorException("There is no operator with this id "+ id));
			 
			 
		}else {
			 throw new LoginException("You are not authorized as Admin");
		}
		
	}

	@Override
	public List<Operator> getAllOperatorWithDeptId(Integer id, String key) throws DepartmentException, LoginException {
		// TODO Auto-generated method stub
		 // verify login with given key 
		CurrentUserSession cs =   cDao.findByUuid(key);
		if(cs != null && cs.getUser_Type().equalsIgnoreCase("Admin")) {
			
		   Department dept =	  deptDao.findById(id).orElseThrow(() -> new DepartmentException("There is no department with this id "+ id));
			 
		   
		   return dept.getOperators();
			 
		}else {
			 throw new LoginException("You are not authorized as Admin so you cannot add a operator");
		}
	}
       
	
}
