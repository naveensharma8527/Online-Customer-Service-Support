package com.customer.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.customer.DTO.OperatorDTO;
import com.customer.Entity.Department;
import com.customer.Entity.Operator;
import com.customer.Exception.DepartmentException;
import com.customer.Exception.LoginException;
import com.customer.Exception.OperatorException;
import com.customer.Repository.AdminRepository;
import com.customer.Repository.DepartmentDao;

public class AdminServiceImp implements AdminService{
	
	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired
	private DepartmentDao deptDao;
	
	

	@Override
	public Department addDepartment(Department d, String key) throws LoginException {
		// TODO Auto-generated method stub
		
		// verify login with given key 
		if(true) {
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
				if(true) {
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
		if(true) {
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
		return null;
	}

	@Override
	public Operator addOperator(Operator o, String key) throws LoginException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OperatorDTO assignDeptToOperator(Integer oid, Integer did, String key)
			throws DepartmentException, OperatorException, LoginException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Operator updateOperator(Operator o, String key) throws OperatorException, LoginException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Operator deleteOperator(Integer id, String key) throws OperatorException, LoginException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Operator> getAllOperators(String key) throws LoginException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Operator getOperatorById(Integer id, String key) throws OperatorException, LoginException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Operator> getAllOperatorWithDeptId(Integer id, String key) throws DepartmentException, LoginException {
		// TODO Auto-generated method stub
		return null;
	}
       
	
}
