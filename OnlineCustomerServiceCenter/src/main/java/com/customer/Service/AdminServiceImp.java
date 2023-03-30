package com.customer.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.DTO.OperatorDTO;
import com.customer.Entity.Department;
import com.customer.Entity.Operator;
import com.customer.Exception.DepartmentException;
import com.customer.Exception.LoginException;
import com.customer.Exception.OperatorException;
import com.customer.Repository.AdminRepository;


@Service
public class AdminServiceImp implements AdminService {
	
	   @Autowired
	   public AdminRepository adminRepository;
	   

	@Override
	public Department addDepartment(Department d, String key) throws LoginException {
		// TODO Auto-generated method stub
		  
		return null;
	}

	@Override
	public Department updateDepartment(Department d, String key) throws DepartmentException, LoginException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department removeDepartment(Integer id, String key) throws DepartmentException, LoginException {
		// TODO Auto-generated method stub
		return null;
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
