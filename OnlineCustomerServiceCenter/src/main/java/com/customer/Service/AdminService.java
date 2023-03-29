package com.customer.Service;

import java.util.List;

import com.customer.DTO.OperatorDTO;
import com.customer.Entity.Department;
import com.customer.Entity.Issue;
import com.customer.Entity.Operator;
import com.customer.Exception.DepartmentException;
import com.customer.Exception.LoginException;
import com.customer.Exception.OperatorException;

public interface AdminService {
	public Department addDepartment(Department d,String key) throws LoginException;
	public Department updateDepartment(Department d,String key) throws DepartmentException,LoginException;
	public Department removeDepartment(Integer id,String key) throws DepartmentException,LoginException;
	public Department getDepartmentById(Integer id,String key) throws DepartmentException,LoginException;
	public Operator addOperator(Operator o,String key)throws LoginException;
	public OperatorDTO assignDeptToOperator(Integer oid,Integer did,String key) throws DepartmentException, OperatorException,LoginException;
	public Operator updateOperator(Operator o,String key) throws OperatorException,LoginException;
	public Operator deleteOperator(Integer id,String key)throws OperatorException,LoginException;
	public List<Operator> getAllOperators(String key)throws LoginException;
	public Operator getOperatorById(Integer id,String key) throws OperatorException,LoginException;
	public List<Operator> getAllOperatorWithDeptId(Integer id,String key) throws DepartmentException,LoginException;
}
